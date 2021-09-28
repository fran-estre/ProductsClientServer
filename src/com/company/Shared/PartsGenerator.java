package com.company.Shared;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.DatagramPacket;
import java.util.ArrayList;

public class PartsGenerator {
    public static final int PACKAGESIZE = 512;
    public static final int HEADER = 128;

    public static int getPartSize(SizeMessage sizeMessage, int i) {
        return PartsGenerator.PACKAGESIZE * (i + 1) < sizeMessage.Size ? PartsGenerator.PACKAGESIZE : sizeMessage.Size - PartsGenerator.PACKAGESIZE * i;
    }

    public static int getPartsNumber(int size) {
        int residue = size % PACKAGESIZE;
        int division = (size - residue) / PACKAGESIZE;

        return residue == 0 ? division : division + 1;
    }

    public static ArrayList<byte[]> breakData(byte[] data) {
        int partsNumber = getPartsNumber(data.length);
        ArrayList<byte[]> parts = new ArrayList<>();
        int offset = 0;
        for (int i = 0; i < partsNumber; i++) {
            int partSize = PACKAGESIZE * (i + 1) < data.length ? PACKAGESIZE : data.length - PACKAGESIZE * i;
            byte[] currentPart = new byte[partSize];
            System.arraycopy(data, offset, currentPart, 0, partSize);
            offset = offset + PACKAGESIZE;
            parts.add(currentPart);
        }
        return parts;
    }


    public static byte[] joinData(ArrayList<byte[]> parts) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        for (byte[] part : parts)
            bos.write(part);
        return bos.toByteArray();
    }

}
