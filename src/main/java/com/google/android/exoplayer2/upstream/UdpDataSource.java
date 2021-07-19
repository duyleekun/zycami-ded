/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.BaseDataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.UdpDataSource$UdpDataSourceException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketAddress;
import java.net.SocketException;

public final class UdpDataSource
extends BaseDataSource {
    public static final int DEFAULT_MAX_PACKET_SIZE = 2000;
    public static final int DEFAULT_SOCKET_TIMEOUT_MILLIS = 8000;
    public static final int UDP_PORT_UNSET = 255;
    private InetAddress address;
    private MulticastSocket multicastSocket;
    private boolean opened;
    private final DatagramPacket packet;
    private final byte[] packetBuffer;
    private int packetRemaining;
    private DatagramSocket socket;
    private InetSocketAddress socketAddress;
    private final int socketTimeoutMillis;
    private Uri uri;

    public UdpDataSource() {
        this(2000);
    }

    public UdpDataSource(int n10) {
        this(n10, 8000);
    }

    public UdpDataSource(int n10, int n11) {
        super(true);
        DatagramPacket datagramPacket;
        this.socketTimeoutMillis = n11;
        byte[] byArray = new byte[n10];
        this.packetBuffer = byArray;
        this.packet = datagramPacket = new DatagramPacket(byArray, 0, n10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void close() {
        this.uri = null;
        DatagramSocket datagramSocket = this.multicastSocket;
        if (datagramSocket != null) {
            try {
                InetAddress inetAddress = this.address;
                ((MulticastSocket)datagramSocket).leaveGroup(inetAddress);
            }
            catch (IOException iOException) {}
            this.multicastSocket = null;
        }
        if ((datagramSocket = this.socket) != null) {
            datagramSocket.close();
            this.socket = null;
        }
        this.address = null;
        this.socketAddress = null;
        this.packetRemaining = 0;
        boolean bl2 = this.opened;
        if (bl2) {
            this.opened = false;
            this.transferEnded();
        }
    }

    public int getLocalPort() {
        DatagramSocket datagramSocket = this.socket;
        if (datagramSocket == null) {
            return -1;
        }
        return datagramSocket.getLocalPort();
    }

    public Uri getUri() {
        return this.uri;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public long open(DataSpec dataSpec) {
        Object object = dataSpec.uri;
        this.uri = object;
        object = object.getHost();
        Object object2 = this.uri;
        int n10 = object2.getPort();
        this.transferInitializing(dataSpec);
        try {
            object = InetAddress.getByName((String)object);
            InetAddress inetAddress = this.address = object;
            object = new InetSocketAddress(inetAddress, n10);
            this.socketAddress = object;
            object = this.address;
            boolean bl2 = ((InetAddress)object).isMulticastAddress();
            if (bl2) {
                object2 = this.socketAddress;
                this.multicastSocket = object = new MulticastSocket((SocketAddress)object2);
                object2 = this.address;
                ((MulticastSocket)object).joinGroup((InetAddress)object2);
                this.socket = object = this.multicastSocket;
            } else {
                object2 = this.socketAddress;
                this.socket = object = new DatagramSocket((SocketAddress)object2);
            }
        }
        catch (IOException iOException) {
            object = new UdpDataSource$UdpDataSourceException(iOException);
            throw object;
        }
        try {
            object = this.socket;
            n10 = this.socketTimeoutMillis;
            ((DatagramSocket)object).setSoTimeout(n10);
            this.opened = true;
            this.transferStarted(dataSpec);
            return -1;
        }
        catch (SocketException socketException) {
            object = new UdpDataSource$UdpDataSourceException(socketException);
            throw object;
        }
    }

    public int read(byte[] byArray, int n10, int n11) {
        int n12;
        if (n11 == 0) {
            return 0;
        }
        int n13 = this.packetRemaining;
        if (n13 == 0) {
            Object object;
            try {
                object = this.socket;
            }
            catch (IOException iOException) {
                UdpDataSource$UdpDataSourceException udpDataSource$UdpDataSourceException = new UdpDataSource$UdpDataSourceException(iOException);
                throw udpDataSource$UdpDataSourceException;
            }
            DatagramPacket datagramPacket = this.packet;
            ((DatagramSocket)object).receive(datagramPacket);
            object = this.packet;
            this.packetRemaining = n13 = ((DatagramPacket)object).getLength();
            this.bytesTransferred(n13);
        }
        n13 = this.packet.getLength();
        int n14 = this.packetRemaining;
        n11 = Math.min(n14, n11);
        System.arraycopy(this.packetBuffer, n13 -= n14, byArray, n10, n11);
        this.packetRemaining = n12 = this.packetRemaining - n11;
        return n11;
    }
}

