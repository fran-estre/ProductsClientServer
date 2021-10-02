package com.company.Client;

import com.company.Shared.Commands.PartsGenerator;
import com.company.Shared.Commands.Serialization;
import com.company.Shared.Commands.SizeMessage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

public class Communication {
    private final Integer port;
    private final DatagramSocket datagramSocket;
    private final InetAddress serverAddress;

    public Communication(String serverAddress, Integer port) throws UnknownHostException, SocketException {
        this.port = port;
        datagramSocket = new DatagramSocket(this.port);
        this.serverAddress = InetAddress.getByName(serverAddress);
    }

    public boolean send(byte[] command) throws IOException {
        if (!sendPackageSize(command)) return false;

        ArrayList<byte[]> parts = PartsGenerator.breakData(command);
        for (byte[] part : parts) {
            DatagramPacket datagramPacket = new DatagramPacket(part, part.length, serverAddress, port);
            this.datagramSocket.send(datagramPacket);
        }
        return true;
    }

    public byte[] receive(StringBuilder errors) {
        byte[] buffer = new byte[PartsGenerator.HEADER + PartsGenerator.PACKAGESIZE];
        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
        try {
            datagramSocket.receive(datagramPacket);
            SizeMessage sizeMessage = (SizeMessage) Serialization.deserialize(datagramPacket.getData());
            if (sizeMessage.Size <= 0) {
                errors.append("Size message 0");
                return null;
            }

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int partsNumber = PartsGenerator.getPartsNumber(sizeMessage.Size);
            for (int i = 0; i < partsNumber; i++) {
                datagramSocket.receive(datagramPacket);
                int partSize = PartsGenerator.getPartSize(sizeMessage, i);
                bos.write(datagramPacket.getData(), 0, partSize);
            }
            return bos.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
            errors.append("An exception occurred");
            return null;
        }
    }


    private boolean sendPackageSize(byte[] command) throws IOException {
        SizeMessage sizeMessage = new SizeMessage();
        sizeMessage.Size = command.length;
        byte[] sizeBytes = Serialization.serialize(sizeMessage);
        if (sizeBytes == null) return false;

        DatagramPacket sizePacket = new DatagramPacket(sizeBytes, sizeBytes.length, serverAddress, port);
        this.datagramSocket.send(sizePacket);
        return true;
    }
}
