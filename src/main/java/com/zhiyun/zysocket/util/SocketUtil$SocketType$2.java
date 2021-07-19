/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.zysocket.util;

import com.zhiyun.zysocket.util.SocketUtil$SocketType;
import java.net.DatagramSocket;
import java.net.InetAddress;

public final class SocketUtil$SocketType$2
extends SocketUtil$SocketType {
    public boolean isPortAvailable(int n10, String object) {
        if (object == null) {
            object = "localhost";
            object = InetAddress.getByName((String)object);
        } else {
            object = InetAddress.getByName((String)object);
        }
        try {
            DatagramSocket datagramSocket = new DatagramSocket(n10, (InetAddress)object);
            datagramSocket.close();
            return true;
        }
        catch (Exception exception) {
            return false;
        }
    }
}

