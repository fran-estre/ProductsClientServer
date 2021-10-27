package com.company.Server;

import com.company.Shared.Commands.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.*;

public class Communication {
    private final DatagramSocket datagramSocket;

    public Communication(Integer port) throws SocketException {
        datagramSocket = new DatagramSocket(port);
    }

    public void listen() {
        try {
            System.out.println("Server working at " + InetAddress.getLocalHost());
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.out.println("There was an exception while getting local host address. " + e.getMessage());
        }

        ProcessHandler processHandler = new ProcessHandler();
        while (!ServerApp.getExit()) {
            byte[] buffer = new byte[PartsGenerator.PACKAGESIZE + PartsGenerator.HEADER];
            DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
            try {
                datagramSocket.receive(datagramPacket);
                SizeMessage sizeMessage = (SizeMessage) Serialization.deserialize(datagramPacket.getData());
                System.out.println("the message was received");
                System.out.println("the size message is: " + sizeMessage.Size);
                if (sizeMessage.Size <= 0) continue;

                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                int repetition = PartsGenerator.getPartsNumber(sizeMessage.Size);
                for (int i = 0; i < repetition; i++) {
                    datagramSocket.receive(datagramPacket);
                    int partSize = PartsGenerator.PACKAGESIZE * (i + 1) < sizeMessage.Size ? PartsGenerator.PACKAGESIZE : sizeMessage.Size - PartsGenerator.PACKAGESIZE * i;
                    bos.write(datagramPacket.getData(), 0, partSize);
                }
                buffer = bos.toByteArray();

                Command command = (Command) Serialization.deserialize(buffer);
                String response = processHandler.processCommand(command);
                AnswerToClient(datagramPacket.getAddress(), datagramPacket.getPort(), response);
                System.out.println("the message was sent");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("There was an exception while receiving the datagramPacket " + e.getMessage());
                datagramSocket.close();
            }
        }
    }

    private void AnswerToClient(InetAddress clientAddress, int clientPort, String response) throws IOException {
        DataBox dataBox = new DataBox();
        dataBox.setResponse(response);
        byte[] responseBytes = Serialization.serialize(dataBox);
        if (responseBytes == null) {
            throw new InternalError("Size array is 0");
        }

        int repetition = PartsGenerator.getPartsNumber(responseBytes.length);
        SizeMessage sizeMessage = new SizeMessage();
        sizeMessage.Size = responseBytes.length;
        byte[] sizeBytes = Serialization.serialize(sizeMessage);
        if (sizeBytes == null) {
            throw new InternalError("Size array is 0");
        }

        DatagramPacket sizePacket = new DatagramPacket(sizeBytes, sizeBytes.length, clientAddress, clientPort);
        this.datagramSocket.send(sizePacket);

        int offset = 0;
        for (int i = 0; i < repetition; i++) {
            int partSize = PartsGenerator.PACKAGESIZE * (i + 1) < responseBytes.length ? PartsGenerator.PACKAGESIZE : responseBytes.length - PartsGenerator.PACKAGESIZE * i;
            byte[] part = new byte[partSize];
            System.arraycopy(responseBytes, offset, part, 0, partSize);
            offset = offset + PartsGenerator.PACKAGESIZE;
            DatagramPacket responsePacket = new DatagramPacket(part, part.length, clientAddress, clientPort);
            this.datagramSocket.send(responsePacket);
        }
    }
}