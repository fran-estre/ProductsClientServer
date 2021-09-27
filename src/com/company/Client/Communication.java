package com.company.Client;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Communication {
    private final Integer port;
    private final DatagramSocket datagramSocket;
    private final InetAddress serverAddress;
    public Communication(String serverAddress, Integer port) throws UnknownHostException, SocketException {
        this.port = port;
        datagramSocket = new DatagramSocket(this.port);
        this.serverAddress = InetAddress.getByName(serverAddress);
    }
}
