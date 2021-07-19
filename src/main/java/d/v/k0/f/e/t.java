/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.wifi.WifiManager
 *  android.net.wifi.WifiManager$MulticastLock
 */
package d.v.k0.f.e;

import android.content.Context;
import android.net.wifi.WifiManager;
import d.v.k0.f.e.h;
import d.v.k0.f.e.i;
import d.v.k0.f.e.j;
import d.v.k0.f.e.k;
import d.v.k0.f.e.l;
import d.v.k0.f.e.p;
import d.v.k0.f.e.s;
import d.v.k0.f.e.t$a;
import d.v.k0.f.e.u;
import d.v.k0.f.e.u$b;
import d.v.k0.g.d;
import e.a.b0;
import e.a.c0;
import e.a.c1.b;
import e.a.e0;
import e.a.g0;
import e.a.h0;
import e.a.v0.a;
import e.a.v0.c;
import e.a.z;
import java.io.Closeable;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class t
extends p {
    private final int f;
    private final e.a.s0.a g;
    private final u h;
    private s i;
    private boolean j;
    private boolean k;
    private final WifiManager l;

    public t(Context context) {
        boolean bl2;
        this.f = 200;
        Object object = new e.a.s0.a();
        this.g = object;
        this.h = object = new u();
        this.j = bl2 = true;
        this.k = bl2;
        context = (WifiManager)context.getApplicationContext().getSystemService("wifi");
        this.l = context;
    }

    public static /* synthetic */ e.a.s0.a i(t t10) {
        return t10.g;
    }

    public static /* synthetic */ s j(t t10) {
        return t10.i;
    }

    public static /* synthetic */ u k(t t10) {
        return t10.h;
    }

    private void l(AtomicReference object, AtomicReference serializable) {
        Object object2 = ((AtomicReference)object).get();
        if (object2 != null) {
            object2 = (Closeable)((AtomicReference)object).get();
            this.a((Closeable)object2);
            boolean bl2 = this.j;
            if (bl2 && (object2 = serializable.get()) != null && !(bl2 = ((DatagramSocket)(object2 = (DatagramSocket)((AtomicReference)object).get())).isClosed())) {
                object = ((AtomicReference)object).get();
                object = (MulticastSocket)object;
                serializable = serializable.get();
                serializable = (InetAddress)serializable;
                try {
                    ((MulticastSocket)object).leaveGroup((InetAddress)serializable);
                }
                catch (IOException iOException) {
                    m.a.a.f(iOException);
                }
            }
        }
        this.h.o();
    }

    private /* synthetic */ void m(AtomicReference atomicReference, AtomicReference atomicReference2) {
        this.l(atomicReference, atomicReference2);
    }

    public static /* synthetic */ void o(b0 b02, String string2, d.v.k0.f.d.a a10) {
        boolean bl2 = b02.isDisposed();
        if (!bl2) {
            b02.onNext(a10);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ void p(AtomicReference object, AtomicReference object2, AtomicReference atomicReference, b0 b02) {
        try {
            int n10;
            Object object3 = this.h;
            Object object4 = new l(b02);
            ((u)object3).m((u$b)object4);
            this.g();
            boolean bl2 = this.j;
            if (bl2) {
                object3 = this.l;
                object4 = "scan_mutilcast";
                object3 = object3.createMulticastLock((String)object4);
                ((AtomicReference)object).set(object3);
                object = ((AtomicReference)object).get();
                object = (WifiManager.MulticastLock)object;
                object.acquire();
                object = this.d;
                object = d.v.k0.g.d.f((String)object);
                ((AtomicReference)object2).set(object);
                int n11 = this.b;
                object = d.v.k0.g.d.c(n11, (InetAddress)object);
                atomicReference.set(object);
            } else {
                n10 = this.b;
                object = d.v.k0.g.d.a(n10);
                atomicReference.set(object);
            }
            n10 = 1;
            this.k = n10;
            n10 = 1024;
            object2 = new byte[n10];
            object3 = new DatagramPacket((byte[])object2, n10);
            while (true) {
                if ((n10 = (int)(b02.isDisposed() ? 1 : 0)) != 0) {
                    b02.onComplete();
                    return;
                }
                object = atomicReference.get();
                object = (DatagramSocket)object;
                ((DatagramSocket)object).receive((DatagramPacket)object3);
                object = atomicReference.get();
                object = (DatagramSocket)object;
                n10 = (int)(((DatagramSocket)object).isClosed() ? 1 : 0);
                this.k = n10;
                object = ((DatagramPacket)object3).getAddress();
                object4 = ((InetAddress)object).getHostAddress();
                Object object5 = this.h;
                int n12 = ((u)object5).b((String)object4);
                if (n12 != 0) {
                    object = this.h;
                    ((u)object).p((String)object4);
                    continue;
                }
                n12 = ((DatagramPacket)object3).getOffset();
                int n13 = ((DatagramPacket)object3).getLength() + n12;
                object5 = Arrays.copyOfRange((byte[])object2, n12, n13);
                u u10 = this.h;
                object = ((InetAddress)object).getHostName();
                object = u10.k((byte[])object5, (String)object4, (String)object);
                b02.onNext(object);
            }
        }
        catch (Exception exception) {
            boolean bl3 = b02.isDisposed();
            if (bl3) return;
            bl3 = this.c();
            if (bl3) {
                b02.onComplete();
                return;
            }
            b02.onError(exception);
        }
    }

    public static /* synthetic */ d.v.k0.f.d.a r(Long l10, d.v.k0.f.d.a a10) {
        return a10;
    }

    private /* synthetic */ void s(AtomicReference object, AtomicReference atomicReference, AtomicReference atomicReference2) {
        boolean bl2;
        this.l((AtomicReference)object, atomicReference);
        atomicReference = ((AtomicReference)object).get();
        if (atomicReference != null && !(bl2 = ((DatagramSocket)(object = (DatagramSocket)((AtomicReference)object).get())).isClosed())) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        this.k = bl2;
        object = atomicReference2.get();
        if (object != null) {
            object = (WifiManager.MulticastLock)atomicReference2.get();
            object.release();
        }
        if ((object = this.i) != null) {
            object.c();
        }
    }

    public void f(int n10) {
        if (n10 == 0) {
            this.c = 0;
            return;
        }
        int n11 = 200;
        if (n10 == n11) {
            this.c = 1;
            return;
        }
        this.c = n10 -= n11;
    }

    public void h() {
        Object[] objectArray = new Object[]{};
        m.a.a.i("stop-------", objectArray);
        this.g.e();
    }

    public boolean isClosed() {
        e.a.s0.a a10;
        boolean bl2 = this.k;
        if (!bl2 && !(bl2 = (a10 = this.g).isDisposed())) {
            bl2 = false;
            a10 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public /* synthetic */ void n(AtomicReference atomicReference, AtomicReference atomicReference2) {
        this.m(atomicReference, atomicReference2);
    }

    public /* synthetic */ void q(AtomicReference atomicReference, AtomicReference atomicReference2, AtomicReference atomicReference3, b0 b02) {
        this.p(atomicReference, atomicReference2, atomicReference3, b02);
    }

    public /* synthetic */ void t(AtomicReference atomicReference, AtomicReference atomicReference2, AtomicReference atomicReference3) {
        this.s(atomicReference, atomicReference2, atomicReference3);
    }

    public void u() {
        Object object;
        Object object2;
        Object object3;
        this.h.a();
        Object object4 = new AtomicReference();
        Object object5 = new AtomicReference();
        AtomicReference atomicReference = new AtomicReference();
        int n10 = this.c;
        if (n10 != 0) {
            long l10 = 10;
            object3 = TimeUnit.MILLISECONDS;
            object2 = z.n3(l10, object3);
            int n11 = (this.c + 200) / 10;
            long l11 = n11;
            object2 = ((z)object2).b6(l11);
            object = new h(this, (AtomicReference)object4, atomicReference);
            object2 = ((z)object2).Y1((a)object);
        } else {
            n10 = 0;
            object2 = null;
        }
        object = new i(this, (AtomicReference)object5, atomicReference, (AtomicReference)object4);
        object = z.y1((c0)object);
        if (object2 != null) {
            object3 = d.v.k0.f.e.j.a;
            object = z.W7((e0)object2, (e0)object, (c)object3);
        }
        object2 = new k(this, (AtomicReference)object4, atomicReference, (AtomicReference)object5);
        object4 = ((z)object).X1((a)object2);
        object5 = e.a.c1.b.d();
        object4 = ((z)object4).L5((h0)object5);
        object5 = new t$a(this);
        ((z)object4).subscribe((g0)object5);
    }

    public void v(s s10) {
        this.i = s10;
    }

    public void w(boolean bl2) {
        this.j = bl2;
    }
}

