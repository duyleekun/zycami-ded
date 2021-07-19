/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.net;

import java.io.FileDescriptor;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketImpl;

public class DatagramSocketWrapper$DatagramSocketImplWrapper
extends SocketImpl {
    public DatagramSocketWrapper$DatagramSocketImplWrapper(DatagramSocket datagramSocket, FileDescriptor fileDescriptor) {
        int n10;
        this.localport = n10 = datagramSocket.getLocalPort();
        this.fd = fileDescriptor;
    }

    public void accept(SocketImpl object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public int available() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public void bind(InetAddress serializable, int n10) {
        serializable = new UnsupportedOperationException();
        throw serializable;
    }

    public void close() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public void connect(String object, int n10) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public void connect(InetAddress serializable, int n10) {
        serializable = new UnsupportedOperationException();
        throw serializable;
    }

    public void connect(SocketAddress serializable, int n10) {
        serializable = new UnsupportedOperationException();
        throw serializable;
    }

    public void create(boolean bl2) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public InputStream getInputStream() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public Object getOption(int n10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public OutputStream getOutputStream() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public void listen(int n10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public void sendUrgentData(int n10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public void setOption(int n10, Object object) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}

