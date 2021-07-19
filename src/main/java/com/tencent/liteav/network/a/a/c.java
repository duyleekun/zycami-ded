/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.network.a.a;

import com.tencent.liteav.network.a.a;
import com.tencent.liteav.network.a.a.b;
import com.tencent.liteav.network.a.d;
import com.tencent.liteav.network.a.e;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

public final class c
implements com.tencent.liteav.network.a.c {
    private static final Random b;
    public final InetAddress a;
    private final int c;

    static {
        Random random;
        b = random = new Random();
    }

    public c(InetAddress inetAddress) {
        this(inetAddress, 10);
    }

    public c(InetAddress inetAddress, int n10) {
        this.a = inetAddress;
        this.c = n10;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private byte[] a(byte[] object) {
        void var1_4;
        Object object2;
        block6: {
            int n13;
            DatagramSocket datagramSocket;
            int n10 = 0;
            object2 = null;
            try {
                datagramSocket = new DatagramSocket();
            }
            catch (Throwable throwable) {
                // empty catch block
                break block6;
            }
            try {
                int n11 = ((Object)object).length;
                InetAddress inetAddress = this.a;
                int n12 = 53;
                object2 = new DatagramPacket((byte[])object, n11, inetAddress, n12);
                n13 = this.c * 1000;
            }
            catch (Throwable throwable) {
                object2 = datagramSocket;
                break block6;
            }
            {
                datagramSocket.setSoTimeout(n13);
                datagramSocket.send((DatagramPacket)object2);
                n10 = 1500;
                byte[] byArray = new byte[n10];
                object = new DatagramPacket(byArray, n10);
                datagramSocket.receive((DatagramPacket)object);
                object = object.getData();
                datagramSocket.close();
                return object;
            }
        }
        if (object2 != null) {
            ((DatagramSocket)object2).close();
        }
        throw var1_4;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public e[] a(com.tencent.liteav.network.a.b object, d object2) {
        int n10;
        object2 = b;
        synchronized (object2) {
            n10 = ((Random)object2).nextInt() & 0xFF;
        }
        object2 = com.tencent.liteav.network.a.a.b.a(((com.tencent.liteav.network.a.b)object).a, n10);
        object2 = this.a((byte[])object2);
        if (object2 != null) {
            object = ((com.tencent.liteav.network.a.b)object).a;
            return com.tencent.liteav.network.a.a.b.a((byte[])object2, n10, (String)object);
        }
        object = ((com.tencent.liteav.network.a.b)object).a;
        object2 = new a((String)object, "cant get answer");
        throw object2;
    }
}

