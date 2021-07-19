/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzkm;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

public final class zzkl
extends SSLSocket {
    private final SSLSocket zza;

    public zzkl(zzkm zzkm2, SSLSocket sSLSocket) {
        this.zza = sSLSocket;
    }

    public final void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.zza.addHandshakeCompletedListener(handshakeCompletedListener);
    }

    public final void bind(SocketAddress socketAddress) {
        this.zza.bind(socketAddress);
    }

    public final void close() {
        synchronized (this) {
            SSLSocket sSLSocket = this.zza;
            sSLSocket.close();
            return;
        }
    }

    public final void connect(SocketAddress socketAddress) {
        this.zza.connect(socketAddress);
    }

    public final void connect(SocketAddress socketAddress, int n10) {
        this.zza.connect(socketAddress, n10);
    }

    public final boolean equals(Object object) {
        return this.zza.equals(object);
    }

    public final SocketChannel getChannel() {
        return this.zza.getChannel();
    }

    public final boolean getEnableSessionCreation() {
        return this.zza.getEnableSessionCreation();
    }

    public final String[] getEnabledCipherSuites() {
        return this.zza.getEnabledCipherSuites();
    }

    public final String[] getEnabledProtocols() {
        return this.zza.getEnabledProtocols();
    }

    public final InetAddress getInetAddress() {
        return this.zza.getInetAddress();
    }

    public final InputStream getInputStream() {
        return this.zza.getInputStream();
    }

    public final boolean getKeepAlive() {
        return this.zza.getKeepAlive();
    }

    public final InetAddress getLocalAddress() {
        return this.zza.getLocalAddress();
    }

    public final int getLocalPort() {
        return this.zza.getLocalPort();
    }

    public final SocketAddress getLocalSocketAddress() {
        return this.zza.getLocalSocketAddress();
    }

    public final boolean getNeedClientAuth() {
        return this.zza.getNeedClientAuth();
    }

    public final boolean getOOBInline() {
        return this.zza.getOOBInline();
    }

    public final OutputStream getOutputStream() {
        return this.zza.getOutputStream();
    }

    public final int getPort() {
        return this.zza.getPort();
    }

    public final int getReceiveBufferSize() {
        synchronized (this) {
            SSLSocket sSLSocket = this.zza;
            int n10 = sSLSocket.getReceiveBufferSize();
            return n10;
        }
    }

    public final SocketAddress getRemoteSocketAddress() {
        return this.zza.getRemoteSocketAddress();
    }

    public final boolean getReuseAddress() {
        return this.zza.getReuseAddress();
    }

    public final int getSendBufferSize() {
        synchronized (this) {
            SSLSocket sSLSocket = this.zza;
            int n10 = sSLSocket.getSendBufferSize();
            return n10;
        }
    }

    public final SSLSession getSession() {
        return this.zza.getSession();
    }

    public final int getSoLinger() {
        return this.zza.getSoLinger();
    }

    public final int getSoTimeout() {
        synchronized (this) {
            SSLSocket sSLSocket = this.zza;
            int n10 = sSLSocket.getSoTimeout();
            return n10;
        }
    }

    public final String[] getSupportedCipherSuites() {
        return this.zza.getSupportedCipherSuites();
    }

    public final String[] getSupportedProtocols() {
        return this.zza.getSupportedProtocols();
    }

    public final boolean getTcpNoDelay() {
        return this.zza.getTcpNoDelay();
    }

    public final int getTrafficClass() {
        return this.zza.getTrafficClass();
    }

    public final boolean getUseClientMode() {
        return this.zza.getUseClientMode();
    }

    public final boolean getWantClientAuth() {
        return this.zza.getWantClientAuth();
    }

    public final boolean isBound() {
        return this.zza.isBound();
    }

    public final boolean isClosed() {
        return this.zza.isClosed();
    }

    public final boolean isConnected() {
        return this.zza.isConnected();
    }

    public final boolean isInputShutdown() {
        return this.zza.isInputShutdown();
    }

    public final boolean isOutputShutdown() {
        return this.zza.isOutputShutdown();
    }

    public final void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.zza.removeHandshakeCompletedListener(handshakeCompletedListener);
    }

    public final void sendUrgentData(int n10) {
        this.zza.sendUrgentData(n10);
    }

    public final void setEnableSessionCreation(boolean bl2) {
        this.zza.setEnableSessionCreation(bl2);
    }

    public final void setEnabledCipherSuites(String[] stringArray) {
        this.zza.setEnabledCipherSuites(stringArray);
    }

    public final void setEnabledProtocols(String[] object) {
        String string2;
        Object object2;
        int n10;
        if (object != null && (n10 = (object2 = Arrays.asList(object)).contains(string2 = "SSLv3")) != 0) {
            int n11;
            object2 = Arrays.asList(this.zza.getEnabledProtocols());
            object = new ArrayList(object2);
            n10 = object.size();
            if (n10 > (n11 = 1)) {
                object.remove(string2);
            }
            n10 = object.size();
            object2 = new String[n10];
            object = object.toArray((T[])object2);
        }
        this.zza.setEnabledProtocols((String[])object);
    }

    public final void setKeepAlive(boolean bl2) {
        this.zza.setKeepAlive(bl2);
    }

    public final void setNeedClientAuth(boolean bl2) {
        this.zza.setNeedClientAuth(bl2);
    }

    public final void setOOBInline(boolean bl2) {
        this.zza.setOOBInline(bl2);
    }

    public final void setPerformancePreferences(int n10, int n11, int n12) {
        this.zza.setPerformancePreferences(n10, n11, n12);
    }

    public final void setReceiveBufferSize(int n10) {
        synchronized (this) {
            SSLSocket sSLSocket = this.zza;
            sSLSocket.setReceiveBufferSize(n10);
            return;
        }
    }

    public final void setReuseAddress(boolean bl2) {
        this.zza.setReuseAddress(bl2);
    }

    public final void setSendBufferSize(int n10) {
        synchronized (this) {
            SSLSocket sSLSocket = this.zza;
            sSLSocket.setSendBufferSize(n10);
            return;
        }
    }

    public final void setSoLinger(boolean bl2, int n10) {
        this.zza.setSoLinger(bl2, n10);
    }

    public final void setSoTimeout(int n10) {
        synchronized (this) {
            SSLSocket sSLSocket = this.zza;
            sSLSocket.setSoTimeout(n10);
            return;
        }
    }

    public final void setTcpNoDelay(boolean bl2) {
        this.zza.setTcpNoDelay(bl2);
    }

    public final void setTrafficClass(int n10) {
        this.zza.setTrafficClass(n10);
    }

    public final void setUseClientMode(boolean bl2) {
        this.zza.setUseClientMode(bl2);
    }

    public final void setWantClientAuth(boolean bl2) {
        this.zza.setWantClientAuth(bl2);
    }

    public final void shutdownInput() {
        this.zza.shutdownInput();
    }

    public final void shutdownOutput() {
        this.zza.shutdownOutput();
    }

    public final void startHandshake() {
        this.zza.startHandshake();
    }

    public final String toString() {
        return this.zza.toString();
    }
}

