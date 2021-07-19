/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 */
package d.v.e0.ne;

import android.util.Pair;
import com.zhiyun.protocol.core.entities.ErrorStatus;
import com.zhiyun.protocol.message.bl.ccs.CCSParams;
import com.zhiyun.protocol.message.usb.command.Flag;
import d.v.e0.me.d;
import d.v.e0.ne.d0;
import d.v.e0.ne.e0;
import d.v.e0.ne.f0;
import d.v.e0.ne.g0;
import d.v.e0.ne.h0;
import d.v.e0.ne.n0;
import d.v.e0.ne.n0$a;
import d.v.e0.ne.p0$a;
import d.v.e0.ne.p0$b;
import d.v.e0.oe.q;
import d.v.y.c.a0;
import d.v.y.c.a1;
import d.v.y.c.b0;
import d.v.y.c.b1;
import d.v.y.c.m;
import d.v.y.c.p;
import d.v.y.c.r0;
import d.v.y.c.s1.l.c;
import d.v.y.c.v;
import d.v.y.c.v0;
import d.v.y.c.w0;
import d.v.y.c.x0;
import d.v.y.c.y0;
import d.v.y.c.z;
import e.a.i0;
import e.a.s0.b;
import e.a.v0.g;
import e.a.v0.r;
import io.reactivex.subjects.PublishSubject;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class p0
implements n0 {
    private static final String g = "WiFi ";
    private static final p0 h;
    private PublishSubject a;
    private b b;
    private b c;
    private n0$a d;
    private volatile boolean e;
    private d.v.e0.oe.p f;

    static {
        p0 p02;
        h = p02 = new p0();
    }

    public p0() {
        Object object = PublishSubject.n8();
        this.a = object;
        this.e = true;
        this.f = object = new d.v.e0.oe.p();
    }

    public static /* synthetic */ void e(p0 p02, r0 r02, p0$b p0$b) {
        p02.p(r02, p0$b);
    }

    private void f(byte[] object) {
        int n10 = this.h((byte[])object);
        Object object2 = new StringBuilder();
        String string2 = "WiFi Recv: ";
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(n10);
        object2 = ((StringBuilder)object2).toString();
        q.g((String)object2, object);
        if (n10 > 0) {
            object2 = this.f;
            Object object3 = (Pair)((d.v.e0.oe.p)object2).i(n10);
            if (object3 != null) {
                ((r0)object3.first).clear();
                object2 = (r0)object3.first;
                boolean bl2 = object2.parseFrom((byte[])object);
                if (bl2) {
                    object = (r0)object3.first;
                    object3 = (p0$b)object3.second;
                    object3.a((r0)object);
                } else {
                    q.b("\u89e3\u6790\u9519\u8bef\u6570\u636e", object);
                    object = (p0$b)object3.second;
                    object2 = "Data error";
                    object3 = new IllegalArgumentException((String)object2);
                    object.onFailed((Throwable)object3);
                }
            }
        } else if (n10 == 0) {
            Object object4 = new x0();
            object2 = new v0();
            ((x0)object4).s((p)object2);
            boolean bl3 = ((a1)object4).parseFrom((byte[])object);
            if (bl3) {
                object = (v0)((x0)object4).r();
                object4 = this.d;
                if (object4 != null) {
                    object = object.n();
                    object4.a0((c)object);
                }
                return;
            }
            object4 = new x0();
            object2 = new m();
            ((x0)object4).s((p)object2);
            bl3 = ((a1)object4).parseFrom((byte[])object);
            if (bl3) {
                object = (m)((x0)object4).r();
                object4 = this.d;
                if (object4 != null) {
                    bl3 = object.p();
                    int n11 = object.n();
                    object = object.o();
                    object4.S0(bl3, n11, (ErrorStatus)object);
                }
                return;
            }
            object4 = new x0();
            object2 = new b0();
            ((x0)object4).s((p)object2);
            bl3 = ((a1)object4).parseFrom((byte[])object);
            if (bl3) {
                object = (b0)((x0)object4).r();
                object4 = this.d;
                if (object4 != null) {
                    object = object.n();
                    object4.u0((CCSParams)object);
                }
                return;
            }
            object4 = new x0();
            object2 = new d.v.y.c.d0();
            ((x0)object4).s((p)object2);
            bl3 = ((a1)object4).parseFrom((byte[])object);
            if (bl3) {
                object = (d.v.y.c.d0)((x0)object4).r();
                object4 = this.d;
                if (object4 != null) {
                    object = object.n();
                    object4.r1((CCSParams)object);
                }
                return;
            }
            object4 = new x0();
            object2 = new a0();
            ((x0)object4).s((p)object2);
            bl3 = ((a1)object4).parseFrom((byte[])object);
            if (bl3) {
                object = (a0)((x0)object4).r();
                object4 = this.d;
                if (object4 != null) {
                    object = object.n();
                    object4.f((CCSParams)object);
                }
                return;
            }
            object4 = new x0();
            object2 = new z();
            ((x0)object4).s((p)object2);
            bl3 = ((a1)object4).parseFrom((byte[])object);
            if (bl3) {
                object = (z)((x0)object4).r();
                object4 = this.d;
                if (object4 != null) {
                    object = object.o();
                    object4.A((w0)object);
                }
                return;
            }
            object4 = new x0();
            object2 = new v();
            ((x0)object4).s((p)object2);
            bl3 = ((a1)object4).parseFrom((byte[])object);
            if (bl3) {
                object4 = (v)((x0)object4).r();
                object2 = this.d;
                if (object2 != null) {
                    object = ((v)object4).n();
                    this.d.A0((d.v.y.c.s1.n.d)object);
                    return;
                }
            }
            if (bl3 = ((a1)(object4 = new y0())).parseFrom((byte[])object)) {
                object = ((y0)object4).r();
                if (object == (object4 = Flag.REPULL)) {
                    object = this.d;
                    object.y0();
                }
                return;
            }
            object4 = this.a;
            ((PublishSubject)object4).onNext(object);
        }
    }

    public static p0 g() {
        return h;
    }

    private int h(byte[] byArray) {
        boolean bl2;
        b1 b12 = new b1();
        int n10 = b12.parseFrom(byArray);
        if (n10 != 0 && (bl2 = b12.r())) {
            b1 b13 = new b1();
            int n11 = b12.n();
            b13.q(n11);
            n11 = 0;
            this.p(b13, null);
        }
        n10 = n10 != 0 ? -1 : b12.n();
        return n10;
    }

    private void i(Throwable throwable) {
        q.k("WiFi  Notification", throwable);
    }

    public static /* synthetic */ void j(p0 p02, byte[] byArray) {
        p02.f(byArray);
    }

    private /* synthetic */ boolean k(byte[] byArray) {
        return this.e;
    }

    public static /* synthetic */ void m(p0 p02, Throwable throwable) {
        p02.i(throwable);
    }

    public static /* synthetic */ void n(byte[] byArray) {
    }

    public static /* synthetic */ void o(p0$b p0$b, Throwable throwable) {
        if (p0$b != null) {
            p0$b.onFailed(throwable);
        }
    }

    private void p(r0 object, p0$b p0$b) {
        Object object2;
        Object object3 = object;
        object3 = (a1)object;
        int n10 = ((a1)object3).n();
        if (p0$b != null) {
            object2 = this.f;
            Pair pair = Pair.create((Object)object, (Object)p0$b);
            ((d.v.e0.oe.p)object2).h(n10, pair);
        }
        object = object.a();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("WiFi Send: ");
        ((StringBuilder)object2).append(n10);
        q.g(((StringBuilder)object2).toString(), (byte[])object);
        object = d.v.e0.me.d.b((byte[])object, "192.168.2.1", 8888);
        object3 = f0.a;
        object2 = new h0(p0$b);
        ((i0)object).c((g)object3, (g)object2);
    }

    public void a(boolean bl2) {
        this.e = bl2;
    }

    public e.a.z b(UUID uUID) {
        return this.a;
    }

    public e.a.z c(r0 object, long l10, boolean bl2, String string2) {
        if (bl2) {
            p0$a p0$a = new p0$a(this, (r0)object);
            object = e.a.z.y1(p0$a);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            return ((e.a.z)object).E6(1000L, timeUnit).U4(3);
        }
        this.p((r0)object, null);
        return e.a.z.t3(object);
    }

    public void connect() {
        Object object = this.b;
        if (object == null) {
            int n10 = 18888;
            object = d.v.e0.me.d.a(n10);
            Object object2 = new d0(this);
            object = ((e.a.z)object).o2((r)object2);
            object2 = new e0(this);
            g0 g02 = new g0(this);
            this.b = object = ((e.a.z)object).c((g)object2, g02);
        }
    }

    public void d(n0$a n0$a) {
        this.d = n0$a;
    }

    public void disconnect() {
        b b10 = this.c;
        if (b10 != null) {
            b10.dispose();
            this.c = null;
        }
        if ((b10 = this.b) != null) {
            b10.dispose();
            this.b = null;
        }
    }

    public /* synthetic */ boolean l(byte[] byArray) {
        return this.k(byArray);
    }
}

