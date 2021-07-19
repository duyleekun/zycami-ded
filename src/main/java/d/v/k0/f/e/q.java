/*
 * Decompiled with CFR 0.151.
 */
package d.v.k0.f.e;

import d.v.k0.f.e.a;
import d.v.k0.f.e.b;
import d.v.k0.f.e.c;
import d.v.k0.f.e.d;
import d.v.k0.f.e.e;
import d.v.k0.f.e.f;
import d.v.k0.f.e.p;
import d.v.k0.f.e.r;
import e.a.h0;
import e.a.v0.g;
import e.a.z;
import java.io.Closeable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

public class q
extends p {
    private final e.a.s0.a f;
    private r g;
    private boolean h;
    private byte[] i;
    private DatagramPacket j;
    private DatagramSocket k;

    public q() {
        e.a.s0.a a10;
        this.f = a10 = new e.a.s0.a();
        this.h = true;
    }

    private /* synthetic */ void j(Long object) {
        Object object2;
        boolean bl2 = this.h;
        if (!bl2) {
            bl2 = false;
            object = null;
            object2 = this.d;
            try {
                object = d.v.k0.g.d.e((String)object2);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                m.a.a.y(illegalArgumentException);
            }
            if (object != null) {
                this.j.setAddress((InetAddress)object);
                object = this.j;
                object2 = this.i;
                ((DatagramPacket)object).setData((byte[])object2);
            }
        }
        object = this.k;
        object2 = this.j;
        this.b((DatagramSocket)object, (DatagramPacket)object2);
        object = this.g;
        if (object != null) {
            object.d();
        }
    }

    private /* synthetic */ void l(e.a.s0.b object) {
        object = this.g;
        if (object != null) {
            object.onStart();
        }
    }

    private /* synthetic */ void n() {
        DatagramSocket datagramSocket = this.k;
        this.a(datagramSocket);
    }

    public static /* synthetic */ void p(Long l10) {
    }

    private /* synthetic */ void q(Throwable throwable) {
        r r10 = this.g;
        d.v.k0.g.d.h("\u5e7f\u64ad\u5f02\u5e38", throwable, 102, r10);
    }

    private /* synthetic */ void s() {
        r r10 = this.g;
        if (r10 != null) {
            r10.a();
        }
    }

    public void h() {
        this.f.e();
    }

    public String i() {
        return this.d;
    }

    public boolean isClosed() {
        boolean bl2;
        DatagramSocket datagramSocket = this.k;
        if (datagramSocket != null && !(bl2 = datagramSocket.isClosed())) {
            bl2 = false;
            datagramSocket = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public /* synthetic */ void k(Long l10) {
        this.j(l10);
    }

    public /* synthetic */ void m(e.a.s0.b b10) {
        this.l(b10);
    }

    public /* synthetic */ void o() {
        this.n();
    }

    public /* synthetic */ void r(Throwable throwable) {
        this.q(throwable);
    }

    public /* synthetic */ void t() {
        this.s();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void u(byte[] object) {
        Object object2;
        Object object3;
        Object object4;
        int n10;
        if (object == null) {
            return;
        }
        this.i = (byte[])object;
        try {
            n10 = this.h;
            if (n10 != 0) {
                object4 = this.d;
                object4 = d.v.k0.g.d.f((String)object4);
                this.k = object3 = d.v.k0.g.d.d();
            } else {
                object4 = this.d;
                object4 = d.v.k0.g.d.e((String)object4);
                this.k = object3 = d.v.k0.g.d.b();
            }
            Object object5 = object4;
            int n11 = ((Object)object).length;
            int n12 = this.b;
            object2 = object4;
            this.j = object4 = new DatagramPacket((byte[])object, 0, n11, (InetAddress)object5, n12);
        }
        catch (Exception exception) {
            n10 = 101;
            object3 = this.g;
            object2 = "\u5e7f\u64ad\u521b\u5efa\u5931\u8d25";
            d.v.k0.g.d.h((String)object2, exception, n10, (d.v.k0.e.a)object3);
            object = this.k;
            this.a((Closeable)object);
        }
        int n13 = this.isClosed();
        if (n13 != 0) {
            return;
        }
        n13 = 1000;
        n10 = this.c;
        n10 = n10 <= 0 ? -1 >>> 1 : (n10 /= n13);
        this.g();
        long l10 = n13;
        object = TimeUnit.MILLISECONDS;
        object = z.n3(l10, (TimeUnit)((Object)object));
        long l11 = n10;
        object = ((z)object).b6(l11);
        object4 = new a(this);
        object = ((z)object).f2((g)object4);
        object4 = new f(this);
        object = ((z)object).g2((g)object4);
        object4 = e.a.c1.b.d();
        object = ((z)object).L5((h0)object4);
        object4 = new c(this);
        object = ((z)object).X1((e.a.v0.a)object4);
        object4 = d.v.k0.f.e.b.a;
        object3 = new d(this);
        object2 = new e(this);
        object = ((z)object).f((g)object4, (g)object3, (e.a.v0.a)object2);
        this.f.b((e.a.s0.b)object);
    }

    public void v(byte[] byArray) {
        if (byArray == null) {
            return;
        }
        this.i = byArray;
    }

    public void w(r r10) {
        this.g = r10;
    }

    public void x(boolean bl2) {
        this.h = bl2;
    }
}

