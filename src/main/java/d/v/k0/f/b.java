/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.k0.f;

import android.text.TextUtils;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketAddress;

public class b {
    private int a;
    private boolean b;
    private int c;
    private int d;
    private int e;
    private String f;
    private boolean g;

    public b() {
        int n10;
        this.a = n10 = -1;
        this.c = n10;
        this.d = n10;
        this.e = n10;
    }

    private void e(DatagramSocket datagramSocket) {
        int n10 = this.a;
        int n11 = -1;
        if (n10 != n11) {
            datagramSocket.setSoTimeout(n10);
        }
        if ((n10 = this.d) != n11) {
            datagramSocket.setSendBufferSize(n10);
        }
        if ((n10 = this.c) != n11) {
            datagramSocket.setReceiveBufferSize(n10);
        }
        n10 = (int)(this.b ? 1 : 0);
        n11 = 1;
        if (n10) {
            datagramSocket.setBroadcast(n11 != 0);
        }
        if (n10 = this.g) {
            datagramSocket.setReuseAddress(n11 != 0);
        }
    }

    public DatagramSocket a() {
        DatagramSocket datagramSocket = new DatagramSocket(null);
        this.e(datagramSocket);
        Object object = this.f;
        int n10 = TextUtils.isEmpty((CharSequence)object);
        int n11 = -1;
        if (n10 == 0 && (n10 = this.e) != n11) {
            InetAddress inetAddress = InetAddress.getByName(this.f);
            int n12 = this.e;
            object = new InetSocketAddress(inetAddress, n12);
            datagramSocket.bind((SocketAddress)object);
        } else {
            object = this.f;
            n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
            if (n10 != 0 && (n10 = this.e) != n11) {
                n11 = this.e;
                object = new InetSocketAddress(n11);
                datagramSocket.bind((SocketAddress)object);
            } else {
                n11 = 0;
                Object var5_6 = null;
                object = new InetSocketAddress(0);
                datagramSocket.bind((SocketAddress)object);
            }
        }
        return datagramSocket;
    }

    public MulticastSocket b() {
        MulticastSocket multicastSocket;
        int n10 = this.e;
        int n11 = -1;
        if (n10 != n11) {
            n11 = this.e;
            multicastSocket = new MulticastSocket(n11);
        } else {
            multicastSocket = new MulticastSocket();
        }
        this.e(multicastSocket);
        return multicastSocket;
    }

    public b c(String string2) {
        this.f = string2;
        return this;
    }

    public b d(boolean bl2) {
        this.b = bl2;
        return this;
    }

    public b f(int n10) {
        this.e = n10;
        return this;
    }

    public b g(int n10) {
        if (n10 > 0) {
            this.c = n10;
        }
        return this;
    }

    public b h(boolean bl2) {
        this.g = bl2;
        return this;
    }

    public b i(int n10) {
        if (n10 > 0) {
            this.d = n10;
        }
        return this;
    }

    public b j(int n10) {
        this.a = n10;
        return this;
    }
}

