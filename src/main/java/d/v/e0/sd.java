/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.polidea.rxandroidble2.RxBleConnection$RxBleConnectionState;
import com.zhiyun.stabilizer.Stabilizer;
import d.v.e0.a0;
import d.v.e0.b0;
import d.v.e0.c0;
import d.v.e0.d0;
import d.v.e0.d1;
import d.v.e0.e0;
import d.v.e0.f0;
import d.v.e0.g0;
import d.v.e0.id;
import d.v.e0.oe.q;
import d.v.e0.sd$a;
import d.v.e0.x;
import d.v.e0.y;
import d.v.e0.z;
import e.a.c1.b;
import e.a.h0;
import e.a.v0.a;
import e.a.v0.g;
import e.a.v0.o;
import io.reactivex.subjects.PublishSubject;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public abstract class sd {
    private final Stabilizer a;
    private final e.a.s0.a b;
    private PublishSubject c;

    public sd(Stabilizer object) {
        Objects.requireNonNull(object);
        this.a = object;
        this.b = object = new e.a.s0.a();
        this.c = object = PublishSubject.n8();
    }

    private void a() {
        Object object = TimeUnit.MILLISECONDS;
        Object object2 = e.a.c1.b.g();
        object = e.a.z.P6(2000L, (TimeUnit)((Object)object), (h0)object2);
        object2 = new c0(this);
        object = ((e.a.z)object).s2((o)object2);
        object2 = new x(this);
        object = ((e.a.z)object).f2((g)object2);
        object2 = e.a.q0.c.a.c();
        object = ((e.a.z)object).i4((h0)object2);
        object2 = new a0(this);
        d1 d12 = new d1(this);
        object = ((e.a.z)object).c((g)object2, d12);
        this.b.b((e.a.s0.b)object);
    }

    private e.a.z b() {
        e.a.z z10 = this.a.d1();
        o o10 = new z(this);
        z10 = z10.s2(o10);
        o10 = d0.a;
        return z10.s2(o10);
    }

    public static /* synthetic */ void c(sd sd2, boolean bl2) {
        sd2.z(bl2);
    }

    public static /* synthetic */ void d(sd sd2, RxBleConnection$RxBleConnectionState rxBleConnection$RxBleConnectionState) {
        sd2.w(rxBleConnection$RxBleConnectionState);
    }

    private /* synthetic */ e.a.e0 e(Long l10) {
        return this.b();
    }

    private /* synthetic */ void g(Boolean bl2) {
        this.s();
    }

    private /* synthetic */ e.a.e0 i(Float f10) {
        return this.a.o0();
    }

    public static /* synthetic */ e.a.e0 k(Boolean bl2) {
        Boolean bl3 = Boolean.TRUE;
        boolean bl4 = bl2;
        if (bl4) {
            return e.a.z.t3(bl3);
        }
        return e.a.z.t3(bl3);
    }

    private /* synthetic */ void l(RxBleConnection$RxBleConnectionState rxBleConnection$RxBleConnectionState) {
        int[] nArray = sd$a.a;
        int n10 = rxBleConnection$RxBleConnectionState.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            n11 = 2;
            if (n10 == n11) {
                this.u();
            }
        } else {
            this.a();
        }
    }

    public static /* synthetic */ void n(String string2) {
    }

    public static /* synthetic */ void o(Throwable throwable) {
    }

    public static /* synthetic */ void p(sd sd2, String string2) {
        sd2.v(string2);
    }

    private void q() {
        Object object = this.a.a.f();
        Object object2 = e.a.q0.c.a.c();
        object = ((e.a.z)object).i4((h0)object2);
        object2 = new id(this);
        object = ((e.a.z)object).Z1((a)object2);
        object2 = new y(this);
        d1 d12 = new d1(this);
        object = ((e.a.z)object).c((g)object2, d12);
        this.b.b((e.a.s0.b)object);
    }

    private void r() {
        Object object = this.c;
        Object object2 = e.a.q0.c.a.c();
        object = ((e.a.z)object).i4((h0)object2);
        object2 = new b0(this);
        d1 d12 = new d1(this);
        object = ((e.a.z)object).c((g)object2, d12);
        this.b.b((e.a.s0.b)object);
    }

    private void v(String object) {
        object = this.a.M2();
        String string2 = this.a.F2();
        float f10 = this.a.s2();
        String string3 = this.a.H2().name();
        String string4 = this.a.G2();
        Locale locale = Locale.getDefault();
        Object[] objectArray = new Object[]{object, string2, object = Float.valueOf(f10), string3, string4};
        q.f(String.format(locale, "\u5df2\u8fde\u63a5\u5230 %s, MAC=%s, \u56fa\u4ef6\u7248\u672c=%.02f, \u578b\u53f7=%s, \u751f\u4ea7\u5e8f\u5217\u53f7=%s", objectArray));
    }

    private void w(RxBleConnection$RxBleConnectionState rxBleConnection$RxBleConnectionState) {
        Object object = RxBleConnection$RxBleConnectionState.DISCONNECTED;
        if (rxBleConnection$RxBleConnectionState == object) {
            this.y();
            this.u();
        } else {
            object = this.c;
            ((PublishSubject)object).onNext((Object)rxBleConnection$RxBleConnectionState);
        }
    }

    private void z(boolean bl2) {
        Object object = this.a.M();
        g g10 = new f0(this);
        object = ((e.a.z)object).f2(g10);
        g10 = e0.a;
        g0 g02 = g0.a;
        object = ((e.a.z)object).c(g10, g02);
        this.b.b((e.a.s0.b)object);
    }

    public /* synthetic */ e.a.e0 f(Long l10) {
        return this.e(l10);
    }

    public /* synthetic */ void h(Boolean bl2) {
        this.g(bl2);
    }

    public /* synthetic */ e.a.e0 j(Float f10) {
        return this.i(f10);
    }

    public /* synthetic */ void m(RxBleConnection$RxBleConnectionState rxBleConnection$RxBleConnectionState) {
        this.l(rxBleConnection$RxBleConnectionState);
    }

    public abstract void s();

    public abstract void t(Throwable var1);

    public abstract void u();

    public void x() {
        this.y();
        this.q();
        this.r();
    }

    public void y() {
        e.a.s0.a a10 = this.b;
        try {
            a10.e();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

