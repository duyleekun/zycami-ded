/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.k0.f.c;

import android.text.TextUtils;
import com.zhiyun.zysocket.udp.interactive.UdpInteractiveException;
import d.v.k0.f.a;
import d.v.k0.f.b;
import d.v.k0.f.c.c;
import d.v.k0.f.c.e;
import e.a.b0;
import e.a.c0;
import e.a.h0;
import e.a.z;
import java.io.Closeable;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class h
extends a {
    private final Map b;
    private e c;

    public h() {
        HashMap hashMap;
        this.b = hashMap = new HashMap();
    }

    private void d() {
        e e10 = this.c;
        if (e10 != null) {
            e10.clear();
        }
        this.b.clear();
    }

    private InetAddress e(d.v.k0.f.d.a object) {
        synchronized (this) {
            Object object2;
            block9: {
                object2 = ((d.v.k0.f.d.a)object).d();
                boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
                if (!bl2) break block9;
                return null;
            }
            object2 = this.b;
            object = ((d.v.k0.f.d.a)object).d();
            object = object2.get(object);
            object = (InetAddress)object;
            return object;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void f(AtomicReference atomicReference, int n10, int n11, boolean bl2, b0 b02) {
        void var0_5;
        d.v.k0.f.d.a a10 = new d.v.k0.f.d.a();
        try {
            Object object = new b();
            object = ((b)object).f(n10);
            Object object2 = ((b)object).g(n11);
            boolean bl3 = true;
            object2 = ((b)object2).h(bl3);
            object2 = ((b)object2).a();
            atomicReference.set(object2);
            n11 = 0x100000;
            object = new byte[n11];
            DatagramPacket datagramPacket = new DatagramPacket((byte[])object, n11);
            while ((n11 = (int)(b02.isDisposed() ? 1 : 0)) == 0) {
                object2 = atomicReference.get();
                object2 = (DatagramSocket)object2;
                ((DatagramSocket)object2).receive(datagramPacket);
                if (bl2) {
                    object2 = datagramPacket.getAddress();
                    Object object3 = ((InetAddress)object2).getHostAddress();
                    object2 = ((InetAddress)object2).getHostName();
                    object3 = a10.h((String)object3);
                    object3 = ((d.v.k0.f.d.a)object3).j(n10);
                    ((d.v.k0.f.d.a)object3).i((String)object2);
                }
                n11 = datagramPacket.getOffset();
                int n12 = datagramPacket.getLength() + n11;
                object2 = Arrays.copyOfRange((byte[])object, n11, n12);
                object2 = a10.g((byte[])object2);
                ((d.v.k0.f.d.a)object2).j(n10);
                b02.onNext(a10);
            }
            return;
        }
        catch (Exception exception) {
            n10 = (int)(b02.isDisposed() ? 1 : 0);
            if (n10 != 0) return;
            n11 = 402;
            UdpInteractiveException udpInteractiveException = new UdpInteractiveException(exception, a10, n11);
            b02.onError(udpInteractiveException);
            return;
        }
        catch (IOException iOException) {
            n10 = (int)(b02.isDisposed() ? 1 : 0);
            if (n10 != 0) return;
            n11 = 400;
            UdpInteractiveException udpInteractiveException = new UdpInteractiveException(iOException, a10, n11);
            b02.onError(udpInteractiveException);
            return;
        }
        catch (UnknownHostException unknownHostException) {
        }
        catch (SocketException socketException) {
            // empty catch block
        }
        n10 = (int)(b02.isDisposed() ? 1 : 0);
        if (n10 != 0) return;
        n11 = 401;
        UdpInteractiveException udpInteractiveException = new UdpInteractiveException((Throwable)var0_5, a10, n11);
        b02.onError(udpInteractiveException);
    }

    private /* synthetic */ void g(AtomicReference object) {
        object = (Closeable)((AtomicReference)object).get();
        this.a((Closeable)object);
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ void i(b0 b02) {
        void var1_4;
        Object object;
        block21: {
            object = null;
            Object object2 = new b();
            object2 = ((b)object2).a();
            Object var4_7 = null;
            try {
                block17: {
                    block20: {
                        block19: {
                            block18: {
                                try {
                                    int n10;
                                    Object object3 = new byte[]{};
                                    DatagramPacket datagramPacket = new DatagramPacket((byte[])object3, 0);
                                    while ((n10 = b02.isDisposed()) == 0) {
                                        Object object4;
                                        int n11;
                                        object3 = this.c;
                                        object = object3.a();
                                        if (object == null || (object3 = (Object)((d.v.k0.f.d.a)object).c()) == null || (n10 = ((d.v.k0.f.d.a)object).f()) <= (n11 = -1) || (n10 = ((byte[])(object3 = ((d.v.k0.f.d.a)object).c())).length) <= 0 || (object4 = this.e((d.v.k0.f.d.a)object)) == null) continue;
                                        datagramPacket.setAddress((InetAddress)object4);
                                        object4 = ((d.v.k0.f.d.a)object).c();
                                        datagramPacket.setData((byte[])object4, 0, n10);
                                        n10 = ((d.v.k0.f.d.a)object).f();
                                        datagramPacket.setPort(n10);
                                        this.b((DatagramSocket)object2, datagramPacket);
                                        b02.onNext(object);
                                    }
                                    b02.onComplete();
                                    break block17;
                                }
                                catch (Exception exception) {
                                    break block18;
                                }
                                catch (IOException iOException) {
                                    break block19;
                                }
                                catch (UnknownHostException unknownHostException) {
                                    break block20;
                                }
                                catch (SocketException socketException) {
                                    break block20;
                                }
                                catch (Throwable throwable) {
                                    break block21;
                                }
                                catch (Exception exception) {
                                    object2 = null;
                                }
                            }
                            boolean bl2 = b02.isDisposed();
                            if (!bl2) {
                                void var4_13;
                                int n12 = 402;
                                UdpInteractiveException udpInteractiveException = new UdpInteractiveException((Throwable)var4_13, (d.v.k0.f.d.a)object, n12);
                                b02.onError(udpInteractiveException);
                            }
                            break block17;
                            catch (IOException iOException) {
                                object2 = null;
                            }
                        }
                        boolean bl3 = b02.isDisposed();
                        if (!bl3) {
                            void var4_15;
                            int n13 = 300;
                            UdpInteractiveException udpInteractiveException = new UdpInteractiveException((Throwable)var4_15, (d.v.k0.f.d.a)object, n13);
                            b02.onError(udpInteractiveException);
                        }
                        break block17;
                        catch (UnknownHostException unknownHostException) {
                        }
                        catch (SocketException socketException) {
                            // empty catch block
                        }
                        object2 = null;
                    }
                    boolean bl4 = b02.isDisposed();
                    if (!bl4) {
                        void var4_18;
                        int n14 = 301;
                        UdpInteractiveException udpInteractiveException = new UdpInteractiveException((Throwable)var4_18, (d.v.k0.f.d.a)object, n14);
                        b02.onError(udpInteractiveException);
                    }
                }
                this.a((Closeable)object2);
                this.d();
                return;
            }
            catch (Throwable throwable) {
                object = object2;
            }
        }
        this.a((Closeable)object);
        this.d();
        throw var1_4;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void c(String string2) {
        synchronized (this) {
            Object object;
            block11: {
                boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
                if (!bl2) break block11;
                return;
            }
            try {
                Map map = this.b;
                object = InetAddress.getByName(string2);
                map.putIfAbsent(string2, object);
                return;
            }
            catch (UnknownHostException unknownHostException) {
                object = "\u5730\u5740\u89e3\u6790\u5931\u8d25\uff0c\u65e0\u6cd5\u6dfb\u52a0\u5230\u5730\u5740\u5217\u8868-----ip:%s";
                int n10 = 1;
                Object[] objectArray = new Object[n10];
                objectArray[0] = string2;
                m.a.a.k(unknownHostException, (String)object, objectArray);
                return;
            }
            finally {
            }
        }
    }

    public /* synthetic */ void h(AtomicReference atomicReference) {
        this.g(atomicReference);
    }

    public boolean isClosed() {
        return false;
    }

    public /* synthetic */ void j(b0 b02) {
        this.i(b02);
    }

    public z k(int n10, int n11, boolean bl2) {
        AtomicReference atomicReference = new AtomicReference();
        d.v.k0.f.c.a a10 = new d.v.k0.f.c.a(atomicReference, n10, n11, bl2);
        z z10 = z.y1(a10);
        Object object = new d.v.k0.f.c.b(this, atomicReference);
        z10 = z10.X1((e.a.v0.a)object);
        object = e.a.c1.b.d();
        return z10.L5((h0)object);
    }

    public z l() {
        Object object = new c(this);
        object = z.y1((c0)object);
        h0 h02 = e.a.c1.b.d();
        return ((z)object).L5(h02);
    }

    public void m(String string2) {
        synchronized (this) {
            block5: {
                boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
                if (!bl2) break block5;
                return;
            }
            Map map = this.b;
            map.remove(string2);
            return;
        }
    }

    public void n(d.v.k0.f.d.a a10) {
        e e10 = this.c;
        if (e10 == null) {
            return;
        }
        e10.c(a10);
    }

    public void o(List list) {
        e e10 = this.c;
        if (e10 == null) {
            return;
        }
        e10.b(list);
    }

    public void p(e e10) {
        this.c = e10;
    }
}

