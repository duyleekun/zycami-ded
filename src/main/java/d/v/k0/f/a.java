/*
 * Decompiled with CFR 0.151.
 */
package d.v.k0.f;

import java.io.Closeable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public abstract class a
implements d.v.k0.d.a {
    private final Object a;

    public a() {
        Object object;
        this.a = object = new Object();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(Closeable closeable) {
        if (closeable == null) return;
        Object object = this.a;
        synchronized (object) {
            Throwable throwable2;
            block5: {
                try {
                    try {
                        closeable.close();
                    }
                    catch (Exception exception) {
                        m.a.a.f(exception);
                    }
                }
                catch (Throwable throwable2) {
                    break block5;
                }
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean b(DatagramSocket datagramSocket, DatagramPacket datagramPacket) {
        if (datagramSocket == null) return false;
        if (datagramPacket == null) {
            return false;
        }
        Object object = this.a;
        synchronized (object) {
            boolean bl2 = datagramSocket.isClosed();
            if (bl2) return false;
            datagramSocket.send(datagramPacket);
            return true;
        }
    }
}

