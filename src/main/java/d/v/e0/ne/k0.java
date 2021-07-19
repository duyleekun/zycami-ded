/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.e0.ne;

import android.content.Context;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.exceptions.BleGattException;
import com.zhiyun.protocol.constants.Model;
import com.zhiyun.protocol.core.entities.ErrorStatus;
import com.zhiyun.protocol.core.entities.Functions;
import com.zhiyun.protocol.message.bl.ccs.CCSParams;
import d.v.e0.ne.a;
import d.v.e0.ne.a0;
import d.v.e0.ne.b;
import d.v.e0.ne.b0;
import d.v.e0.ne.c;
import d.v.e0.ne.c0;
import d.v.e0.ne.d;
import d.v.e0.ne.e;
import d.v.e0.ne.f;
import d.v.e0.ne.g;
import d.v.e0.ne.h;
import d.v.e0.ne.i;
import d.v.e0.ne.i0;
import d.v.e0.ne.j;
import d.v.e0.ne.j0;
import d.v.e0.ne.k;
import d.v.e0.ne.k0$a;
import d.v.e0.ne.k0$b;
import d.v.e0.ne.l;
import d.v.e0.ne.l0;
import d.v.e0.ne.m;
import d.v.e0.ne.m0;
import d.v.e0.ne.n;
import d.v.e0.ne.n0;
import d.v.e0.ne.n0$a;
import d.v.e0.ne.o;
import d.v.e0.ne.o0;
import d.v.e0.ne.p;
import d.v.e0.ne.q;
import d.v.e0.ne.q0;
import d.v.e0.ne.r;
import d.v.e0.ne.s;
import d.v.e0.ne.t;
import d.v.e0.ne.u;
import d.v.e0.ne.v;
import d.v.e0.ne.w;
import d.v.e0.ne.x;
import d.v.e0.ne.y;
import d.v.e0.ne.z;
import d.v.y.c.d0;
import d.v.y.c.k1;
import d.v.y.c.o1;
import d.v.y.c.r0;
import d.v.y.c.v0;
import d.v.y.c.w0;
import e.a.e0;
import e.a.f0;
import io.reactivex.subjects.PublishSubject;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class k0
implements n0 {
    private static final String o = "BLE ";
    private final PublishSubject a;
    private final PublishSubject b;
    private final PublishSubject c;
    private final PublishSubject d;
    private final d.v.y.a.b e;
    private final e.a.z f;
    private final m0 g;
    private e.a.s0.b h;
    private e.a.s0.b i;
    private n0$a j;
    private int k;
    private volatile boolean l;
    private volatile boolean m;
    private volatile boolean n;

    public k0(Context object, d.n.a.j0 j02, Model model) {
        Object object2 = PublishSubject.n8();
        this.a = object2;
        object2 = PublishSubject.n8();
        this.b = object2;
        object2 = PublishSubject.n8();
        this.c = object2;
        object2 = PublishSubject.n8();
        this.d = object2;
        this.g = object2 = new m0();
        this.k = 23;
        object2 = null;
        this.l = false;
        this.m = false;
        this.n = true;
        Objects.requireNonNull(j02);
        Objects.requireNonNull(model);
        boolean bl2 = model.isBl();
        object2 = bl2 ? new d.v.y.a.a() : new d.v.y.a.d();
        this.e = object2;
        c c10 = new c(this);
        ((d.v.y.a.b)object2).f(c10);
        object = this.c0((Context)object, j02, model);
        this.f = object;
    }

    public static /* synthetic */ RxBleConnection A(RxBleConnection rxBleConnection, Boolean bl2) {
        return rxBleConnection;
    }

    private /* synthetic */ e0 B(UUID uUID, RxBleConnection rxBleConnection) {
        return this.j0(rxBleConnection, uUID);
    }

    private /* synthetic */ boolean D(byte[] byArray) {
        return this.n;
    }

    public static /* synthetic */ void F(byte[] byArray) {
        d.v.e0.oe.q.g("BLE Recv:", byArray);
    }

    private /* synthetic */ e0 G(RxBleConnection rxBleConnection, q0 q02) {
        return this.f0(rxBleConnection, q02);
    }

    private /* synthetic */ e0 I(r0 r02, String string2, long l10) {
        return this.l0(r02, string2, l10);
    }

    public static /* synthetic */ byte[] K(byte[] byArray, byte[] byArray2) {
        return byArray;
    }

    public static /* synthetic */ e0 L(q0 object, Throwable throwable) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(o);
        object = ((q0)object).a();
        stringBuilder.append((String)object);
        d.v.e0.oe.q.k(stringBuilder.toString(), throwable);
        return e.a.z.l2();
    }

    public static /* synthetic */ q0 M(q0 q02, byte[] byArray) {
        q02.g(byArray);
        return q02;
    }

    private /* synthetic */ void N(Integer n10) {
        int n11;
        this.k = n11 = n10.intValue();
    }

    public static /* synthetic */ RxBleConnection P(RxBleConnection rxBleConnection, Integer n10) {
        return rxBleConnection;
    }

    public static /* synthetic */ e.a.o0 Q(RxBleConnection rxBleConnection, Throwable throwable) {
        return e.a.i0.x0(rxBleConnection.a());
    }

    public static /* synthetic */ e0 R(e.a.z z10) {
        return z10;
    }

    public static /* synthetic */ e0 S(byte[] byArray, RxBleConnection object) {
        object = object.r();
        UUID uUID = l0.e;
        return object.b(uUID).f(byArray).build();
    }

    public static /* synthetic */ void T(byte[] byArray) {
    }

    public static /* synthetic */ boolean U(int n10, q0 q02) {
        int n11 = q02.e();
        n10 = n10 == n11 ? 1 : 0;
        return n10 != 0;
    }

    private /* synthetic */ r0 V(r0 r02, q0 object) {
        object = ((q0)object).b();
        return this.a0((byte[])object, r02);
    }

    public static /* synthetic */ e0 X(k0 k02, RxBleConnection rxBleConnection) {
        return k02.e0(rxBleConnection);
    }

    public static /* synthetic */ void Y(k0 k02, Throwable throwable) {
        k02.n(throwable);
    }

    private Boolean Z(Model object) {
        int n10;
        int[] nArray = k0$b.a;
        int n11 = object.ordinal();
        int n12 = nArray[n11];
        if (n12 != (n11 = 1) && n12 != (n10 = 2)) {
            object = object.getFunctions();
            int n13 = ((Functions)object).bleHid;
            if (n13 != n11) {
                n11 = 0;
            }
            return n11 != 0;
        }
        return Boolean.FALSE;
    }

    private r0 a0(byte[] byArray, r0 r02) {
        r02.clear();
        r02.parseFrom(byArray);
        return r02;
    }

    private e.a.z c0(Context object, d.n.a.j0 object2, Model model) {
        object = object2.a(false);
        object2 = this.d;
        object = ((e.a.z)object).n6((e0)object2);
        object2 = d.k.a.a.f();
        return ((e.a.z)object).z0((f0)object2);
    }

    private e.a.z d0(r0 r02, String string2, long l10) {
        a a10 = new a(this, r02, string2, l10);
        return e.a.z.D1(a10);
    }

    public static /* synthetic */ boolean e(k0 k02, boolean bl2) {
        k02.l = bl2;
        return bl2;
    }

    private e0 e0(RxBleConnection rxBleConnection) {
        PublishSubject publishSubject = this.b;
        t t10 = new t(this, rxBleConnection);
        return publishSubject.t2(t10, 1);
    }

    public static /* synthetic */ boolean f(k0 k02) {
        return k02.m;
    }

    private e0 f0(RxBleConnection object, q0 object2) {
        d.v.e0.oe.q.f(((q0)object2).a());
        Object object3 = this.a.b6(1L);
        Object object4 = ((q0)object2).b();
        object = this.k((RxBleConnection)object, (byte[])object4);
        object4 = v.a;
        object = e.a.z.W7((e0)object3, (e0)object, (e.a.v0.c)object4);
        long l10 = ((q0)object2).d();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        object = ((e.a.z)object).E6(l10, timeUnit);
        object3 = new q((q0)object2);
        object = ((e.a.z)object).n4((e.a.v0.o)object3);
        object3 = new e((q0)object2);
        object = ((e.a.z)object).H3((e.a.v0.o)object3);
        object2 = this.c;
        object2.getClass();
        object3 = new b0((PublishSubject)object2);
        object = ((e.a.z)object).f2((e.a.v0.g)object3);
        object2 = c0.a;
        return ((e.a.z)object).H3((e.a.v0.o)object2);
    }

    public static /* synthetic */ m0 g(k0 k02) {
        return k02.g;
    }

    private e.a.o0 g0(RxBleConnection rxBleConnection) {
        e.a.i0 i02 = rxBleConnection.j(517);
        Object object = new k(rxBleConnection);
        i02 = i02.Q0((e.a.v0.o)object);
        object = new i(this);
        i02 = i02.b0((e.a.v0.g)object);
        object = new x(rxBleConnection);
        return i02.z0((e.a.v0.o)object);
    }

    public static /* synthetic */ int h(k0 k02) {
        return k02.k;
    }

    private e.a.z h0(r0 r02) {
        byte[] byArray = r02.a();
        this.b0(byArray);
        return e.a.z.t3(r02);
    }

    public static /* synthetic */ void i(k0 k02, byte[] byArray) {
        k02.k0(byArray);
    }

    private void i0() {
        k0$a k0$a = new k0$a(this);
        k0$a.start();
    }

    private e.a.a j(Context context, d.n.a.j0 j02, boolean bl2) {
        if (!bl2) {
            return e.a.a.y();
        }
        return d.v.e0.je.e.a(context, j02).k3();
    }

    private e0 j0(RxBleConnection object, UUID object2) {
        object = object.f((UUID)object2);
        object2 = d.v.e0.ne.m.a;
        return ((e.a.z)object).s2((e.a.v0.o)object2);
    }

    private e.a.z k(RxBleConnection object, byte[] byArray) {
        d.v.e0.oe.q.g("BLE Send:", byArray);
        object = object.r();
        UUID uUID = l0.e;
        return object.b(uUID).f(byArray).build();
    }

    private void k0(byte[] object) {
        d.v.e0.oe.q.g("BLE Send sync:", (byte[])object);
        Object object2 = this.f;
        Object object3 = new d((byte[])object);
        object = ((e.a.z)object2).s2((e.a.v0.o)object3);
        object2 = w.a;
        object3 = i0.a;
        ((e.a.z)object).c((e.a.v0.g)object2, (e.a.v0.g)object3);
    }

    private void l(byte[] object) {
        int n10;
        d.v.e0.oe.q.g("BLE Recv:", (byte[])object);
        Object object2 = new v0();
        boolean n102 = ((d.v.y.c.a)object2).parseFrom((byte[])object);
        if (n102) {
            object = this.j;
            if (object != null) {
                object2 = ((v0)object2).n();
                object.a0((d.v.y.c.s1.l.c)object2);
            }
            return;
        }
        object2 = new d.v.y.c.m();
        boolean bl2 = ((d.v.y.c.a)object2).parseFrom((byte[])object);
        if (bl2) {
            object = this.j;
            if (object != null) {
                boolean bl3 = ((d.v.y.c.m)object2).p();
                int n11 = ((d.v.y.c.m)object2).n();
                object2 = ((d.v.y.c.m)object2).o();
                object.S0(bl3, n11, (ErrorStatus)object2);
            }
            return;
        }
        object2 = new d.v.y.c.b0();
        boolean bl4 = ((d.v.y.c.a)object2).parseFrom((byte[])object);
        if (bl4) {
            object = this.j;
            if (object != null) {
                object2 = ((d.v.y.c.b0)object2).n();
                object.u0((CCSParams)object2);
            }
            return;
        }
        Object object3 = new d0();
        boolean bl5 = ((d.v.y.c.a)object3).parseFrom((byte[])object);
        if (bl5) {
            object = this.j;
            if (object != null) {
                object2 = ((d.v.y.c.b0)object2).n();
                object.r1((CCSParams)object2);
            }
            return;
        }
        object3 = new d.v.y.c.a0();
        boolean bl6 = ((d.v.y.c.a)object3).parseFrom((byte[])object);
        if (bl6) {
            object = this.j;
            if (object != null) {
                object2 = ((d.v.y.c.b0)object2).n();
                object.f((CCSParams)object2);
            }
            return;
        }
        object2 = new d.v.y.c.z();
        boolean bl7 = ((d.v.y.c.a)object2).parseFrom((byte[])object);
        if (bl7) {
            object = this.j;
            if (object != null) {
                object2 = ((d.v.y.c.z)object2).o();
                object.A((w0)object2);
            }
            return;
        }
        object2 = new o1();
        boolean bl8 = ((k1)object2).parseFrom((byte[])object);
        if (bl8) {
            object = this.j;
            if (object != null) {
                int n12 = ((o1)object2).n();
                int n13 = ((o1)object2).o();
                object3 = this.j;
                object3.a1(n12, n13);
            }
            return;
        }
        object2 = new d.v.y.c.v();
        boolean bl9 = ((d.v.y.c.a)object2).parseFrom((byte[])object);
        if (bl9 && (object3 = this.j) != null && (n10 = ((d.v.y.c.v)object2).o()) <= 0) {
            object = ((d.v.y.c.v)object2).n();
            this.j.A0((d.v.y.c.s1.n.d)object);
            return;
        }
        this.a.onNext(object);
    }

    private e0 l0(r0 r02, String object, long l10) {
        int n10 = o0.a();
        PublishSubject publishSubject = this.b;
        q0 q02 = new q0(r02, (String)object, l10, n10);
        publishSubject.onNext(q02);
        object = this.c;
        Object object2 = new b(n10);
        object = ((e.a.z)object).o2((e.a.v0.r)object2).b6(1L);
        object2 = new h(this, r02);
        return ((e.a.z)object).H3((e.a.v0.o)object2);
    }

    private void m(Throwable throwable) {
        d.v.e0.oe.q.k("BLE Notification", throwable);
    }

    private void n(Throwable throwable) {
        d.v.e0.oe.q.k("BLE Request", throwable);
    }

    private boolean o(Throwable throwable) {
        int n10;
        int n11 = throwable instanceof BleGattException;
        boolean bl2 = false;
        if (n11 != 0 && ((n10 = ((BleGattException)(throwable = (BleGattException)throwable)).getStatus()) == (n11 = 4) || n10 == (n11 = 6))) {
            bl2 = true;
        }
        return bl2;
    }

    public static /* synthetic */ void p(k0 k02, byte[] byArray) {
        k02.l(byArray);
    }

    public static /* synthetic */ void q(k0 k02, Throwable throwable) {
        k02.m(throwable);
    }

    public static /* synthetic */ e.a.o0 r(k0 k02, RxBleConnection rxBleConnection) {
        return k02.g0(rxBleConnection);
    }

    public static /* synthetic */ e0 s(RxBleConnection rxBleConnection) {
        Object object = new d.v.e0.me.c();
        object = rxBleConnection.A((d.n.a.i0)object);
        Object object2 = Boolean.FALSE;
        object = ((e.a.z)object).p4(object2);
        object2 = new o(rxBleConnection);
        return ((e.a.z)object).H3((e.a.v0.o)object2);
    }

    private /* synthetic */ void t(RxBleConnection rxBleConnection) {
        this.m = false;
    }

    private /* synthetic */ e0 v(RxBleConnection rxBleConnection) {
        UUID uUID = l0.d;
        return this.j0(rxBleConnection, uUID);
    }

    private /* synthetic */ boolean x(byte[] byArray) {
        return this.n;
    }

    public static /* synthetic */ void z(byte[] byArray) {
    }

    public /* synthetic */ e0 C(UUID uUID, RxBleConnection rxBleConnection) {
        return this.B(uUID, rxBleConnection);
    }

    public /* synthetic */ boolean E(byte[] byArray) {
        return this.D(byArray);
    }

    public /* synthetic */ e0 H(RxBleConnection rxBleConnection, q0 q02) {
        return this.G(rxBleConnection, q02);
    }

    public /* synthetic */ e0 J(r0 r02, String string2, long l10) {
        return this.I(r02, string2, l10);
    }

    public /* synthetic */ void O(Integer n10) {
        this.N(n10);
    }

    public /* synthetic */ r0 W(r0 r02, q0 q02) {
        return this.V(r02, q02);
    }

    public void a(boolean bl2) {
        this.n = bl2;
    }

    public e.a.z b(UUID object) {
        Object object2 = this.f;
        u u10 = new u(this, (UUID)object);
        object = ((e.a.z)object2).s2(u10);
        object2 = new p(this);
        object = ((e.a.z)object).o2((e.a.v0.r)object2);
        object2 = s.a;
        return ((e.a.z)object).f2((e.a.v0.g)object2);
    }

    public void b0(byte[] byArray) {
        m0 m02 = this.g;
        m02.c(byArray);
        boolean bl2 = this.l;
        if (!bl2) {
            this.i0();
        }
    }

    public e.a.z c(r0 object, long l10, boolean bl2, String string2) {
        if (bl2) {
            object = this.d0((r0)object, string2, l10);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            return ((e.a.z)object).E6(l10, timeUnit);
        }
        object = this.h0((r0)object);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return ((e.a.z)object).E6(l10, timeUnit);
    }

    public void connect() {
        Object object = this.f;
        Object object2 = new l(this);
        object = ((e.a.z)object).K2((e.a.v0.o)object2);
        object2 = d.v.e0.ne.j.a;
        object = ((e.a.z)object).s2((e.a.v0.o)object2);
        object2 = new a0(this);
        object = ((e.a.z)object).f2((e.a.v0.g)object2);
        object2 = new g(this);
        object = ((e.a.z)object).s2((e.a.v0.o)object2);
        object2 = new r(this);
        object = ((e.a.z)object).o2((e.a.v0.r)object2);
        object2 = this.e;
        object2.getClass();
        e.a.v0.g g10 = new j0((d.v.y.a.b)object2);
        object2 = new f(this);
        this.h = object = ((e.a.z)object).c(g10, (e.a.v0.g)object2);
        object = this.f;
        object2 = new y(this);
        object = ((e.a.z)object).t2((e.a.v0.o)object2, 1);
        object2 = d.v.e0.ne.n.a;
        g10 = new z(this);
        this.i = object = ((e.a.z)object).c((e.a.v0.g)object2, g10);
    }

    public void d(n0$a n0$a) {
        this.j = n0$a;
    }

    public void disconnect() {
        Object object = this.i;
        Boolean bl2 = null;
        if (object != null) {
            object.dispose();
            this.i = null;
        }
        if ((object = this.h) != null) {
            object.dispose();
            this.h = null;
        }
        this.m = true;
        object = this.d;
        bl2 = Boolean.FALSE;
        ((PublishSubject)object).onNext(bl2);
    }

    public /* synthetic */ void u(RxBleConnection rxBleConnection) {
        this.t(rxBleConnection);
    }

    public /* synthetic */ e0 w(RxBleConnection rxBleConnection) {
        return this.v(rxBleConnection);
    }

    public /* synthetic */ boolean y(byte[] byArray) {
        return this.x(byArray);
    }
}

