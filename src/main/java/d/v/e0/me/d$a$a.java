/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0.me;

import d.v.e0.me.d$a;
import e.a.b0;
import e.a.c0;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class d$a$a
implements c0 {
    public final /* synthetic */ d$a a;

    public d$a$a(d$a d$a) {
        this.a = d$a;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void subscribe(b0 b02) {
        void var1_4;
        Object object;
        block14: {
            int n10 = 0;
            object = null;
            Object object2 = this.a;
            int n11 = ((d$a)object2).a;
            DatagramSocket datagramSocket = new DatagramSocket(n11);
            n10 = 512;
            try {
                block15: {
                    block12: {
                        block13: {
                            try {
                                object2 = new byte[n10];
                                DatagramPacket datagramPacket = new DatagramPacket((byte[])object2, n10);
                                while ((n10 = (int)(b02.isDisposed() ? 1 : 0)) == 0) {
                                    datagramSocket.receive(datagramPacket);
                                    n10 = datagramPacket.getOffset();
                                    int n12 = datagramPacket.getLength() + n10;
                                    object = Arrays.copyOfRange((byte[])object2, n10, n12);
                                    b02.onNext(object);
                                }
                                break block12;
                            }
                            catch (IOException iOException) {
                                break block13;
                            }
                            catch (Throwable throwable) {
                                break block14;
                            }
                            catch (IOException iOException) {
                                datagramSocket = null;
                                object = iOException;
                            }
                        }
                        b02.onError((Throwable)object);
                        if (datagramSocket == null) break block15;
                    }
                    datagramSocket.close();
                }
                return;
            }
            catch (Throwable throwable) {
                object = datagramSocket;
            }
        }
        if (object != null) {
            ((DatagramSocket)object).close();
        }
        throw var1_4;
    }
}

