/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0.me;

import e.a.k0;
import e.a.m0;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public final class d$b
implements m0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ byte[] b;
    public final /* synthetic */ int c;

    public d$b(String string2, byte[] byArray, int n10) {
        this.a = string2;
        this.b = byArray;
        this.c = n10;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     */
    public void subscribe(k0 k02) {
        void var1_4;
        Object object;
        block24: {
            block26: {
                DatagramSocket datagramSocket;
                block22: {
                    block25: {
                        block23: {
                            boolean bl2 = false;
                            object = null;
                            datagramSocket = new DatagramSocket();
                            object = this.a;
                            object = InetAddress.getByName((String)object);
                            byte[] byArray = this.b;
                            int n10 = byArray.length;
                            int n11 = this.c;
                            DatagramPacket datagramPacket = new DatagramPacket(byArray, n10, (InetAddress)object, n11);
                            datagramSocket.send(datagramPacket);
                            bl2 = k02.isDisposed();
                            if (bl2) break block22;
                            object = this.b;
                            try {
                                k02.onSuccess(object);
                                break block22;
                            }
                            catch (IOException iOException) {
                                break block23;
                            }
                            catch (Throwable throwable) {
                                break block24;
                            }
                            catch (IOException iOException) {
                                datagramSocket = null;
                                object = iOException;
                            }
                        }
                        boolean bl3 = k02.isDisposed();
                        if (bl3) break block25;
                        try {
                            k02.onError((Throwable)object);
                        }
                        catch (Throwable throwable) {
                            object = datagramSocket;
                        }
                    }
                    if (datagramSocket == null) break block26;
                }
                datagramSocket.close();
            }
            return;
        }
        if (object != null) {
            ((DatagramSocket)object).close();
        }
        throw var1_4;
    }
}

