/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.net;

import androidx.core.net.DatagramSocketWrapper$DatagramSocketImplWrapper;
import java.io.FileDescriptor;
import java.net.DatagramSocket;
import java.net.Socket;

public class DatagramSocketWrapper
extends Socket {
    public DatagramSocketWrapper(DatagramSocket datagramSocket, FileDescriptor fileDescriptor) {
        DatagramSocketWrapper$DatagramSocketImplWrapper datagramSocketWrapper$DatagramSocketImplWrapper = new DatagramSocketWrapper$DatagramSocketImplWrapper(datagramSocket, fileDescriptor);
        super(datagramSocketWrapper$DatagramSocketImplWrapper);
    }
}

