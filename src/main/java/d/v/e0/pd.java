/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.RxBleConnection$RxBleConnectionState;
import com.polidea.rxandroidble2.RxBleConnection$d;
import d.k.a.a;
import d.n.a.j0;
import d.v.e0.o;
import d.v.e0.p;
import d.v.e0.pd$a;
import d.v.e0.pd$b;
import d.v.e0.q;
import d.v.e0.r;
import d.v.e0.s;
import d.v.e0.t;
import d.v.e0.u;
import d.v.e0.v;
import d.v.e0.w;
import e.a.c1.b;
import e.a.e0;
import e.a.f0;
import e.a.h0;
import e.a.o0;
import e.a.v0.c;
import e.a.z;
import io.reactivex.subjects.PublishSubject;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class pd {
    private j0 a;
    private int b;
    private PublishSubject c;
    private z d;
    private volatile byte[] e;

    public pd(j0 object) {
        PublishSubject publishSubject;
        this.c = publishSubject = PublishSubject.n8();
        this.a = object;
        this.d = object = this.A();
    }

    private z A() {
        z z10 = this.a.a(false);
        Object object = this.c;
        z10 = z10.n6((e0)object);
        object = d.k.a.a.f();
        return z10.z0((f0)object);
    }

    public static /* synthetic */ byte[] a(pd pd2, byte[] byArray) {
        pd2.e = byArray;
        return byArray;
    }

    public static /* synthetic */ j0 b(pd pd2) {
        return pd2.a;
    }

    public static /* synthetic */ z c(pd pd2) {
        return pd2.d;
    }

    private z d(RxBleConnection rxBleConnection, UUID uUID, byte[] byArray) {
        return rxBleConnection.r().f(byArray).b(uUID).build();
    }

    private z e(UUID object, byte[] object2, RxBleConnection rxBleConnection, z z10) {
        object = rxBleConnection.r().f((byte[])object2).b((UUID)object);
        object2 = new pd$a;
        object2(this, z10);
        object = object.c((RxBleConnection$d)object2).build();
        object2 = new q;
        object2(this);
        return ((z)object).H3((e.a.v0.o)object2);
    }

    private /* synthetic */ byte[] l(byte[] byArray) {
        return this.e;
    }

    public static /* synthetic */ e0 n(UUID uUID, RxBleConnection rxBleConnection) {
        return rxBleConnection.f(uUID);
    }

    public static /* synthetic */ e0 o(z z10) {
        return z10;
    }

    public static /* synthetic */ o0 p(UUID uUID, RxBleConnection rxBleConnection) {
        return rxBleConnection.s(uUID);
    }

    public static /* synthetic */ e0 q(UUID uUID, RxBleConnection rxBleConnection) {
        return rxBleConnection.f(uUID);
    }

    private /* synthetic */ z r(UUID uUID, byte[] byArray, RxBleConnection rxBleConnection, z z10) {
        return this.e(uUID, byArray, rxBleConnection, z10);
    }

    public static /* synthetic */ e0 t(z z10) {
        return z10;
    }

    public static /* synthetic */ o0 u(int n10, RxBleConnection rxBleConnection) {
        return rxBleConnection.j(n10);
    }

    private /* synthetic */ e0 v(UUID uUID, byte[] byArray, RxBleConnection rxBleConnection) {
        return this.d(rxBleConnection, uUID, byArray);
    }

    public z B(UUID uUID) {
        z z10 = this.d;
        v v10 = new v(uUID);
        return z10.K2(v10);
    }

    public z C(UUID object, UUID object2, byte[] byArray) {
        z z10 = this.d;
        Object object3 = TimeUnit.MILLISECONDS;
        z10 = z10.E1(50, (TimeUnit)((Object)object3));
        object3 = e.a.c1.b.g();
        z10 = z10.L5((h0)object3);
        object3 = new u((UUID)object2);
        object2 = new r(this, (UUID)object, byArray);
        object = z10.v2((e.a.v0.o)object3, (c)object2, 1);
        object2 = o.a;
        return ((z)object).s2((e.a.v0.o)object2).b6(1L);
    }

    public z D(int n10) {
        z z10 = this.d;
        p p10 = new p(n10);
        return z10.K2(p10);
    }

    public void E(int n10) {
        this.b = n10;
    }

    public z F(UUID uUID, byte[] byArray) {
        z z10 = this.d;
        t t10 = new t(this, uUID, byArray);
        return z10.T0(t10);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl2 = object instanceof pd;
        if (!bl2) {
            return false;
        }
        object = (pd)object;
        j0 j02 = this.a;
        object = ((pd)object).a;
        return j02.equals(object);
    }

    public void f() {
        PublishSubject publishSubject = this.c;
        Boolean bl2 = Boolean.TRUE;
        publishSubject.onNext(bl2);
    }

    public RxBleConnection$RxBleConnectionState g() {
        return this.a.d();
    }

    public String h() {
        return this.a.e();
    }

    public String i() {
        return this.a.getName();
    }

    public int j() {
        return this.b;
    }

    public boolean k() {
        boolean bl2;
        RxBleConnection$RxBleConnectionState rxBleConnection$RxBleConnectionState;
        RxBleConnection$RxBleConnectionState rxBleConnection$RxBleConnectionState2 = this.g();
        if (rxBleConnection$RxBleConnectionState2 == (rxBleConnection$RxBleConnectionState = RxBleConnection$RxBleConnectionState.CONNECTED)) {
            bl2 = true;
        } else {
            bl2 = false;
            rxBleConnection$RxBleConnectionState2 = null;
        }
        return bl2;
    }

    public /* synthetic */ byte[] m(byte[] byArray) {
        return this.l(byArray);
    }

    public /* synthetic */ z s(UUID uUID, byte[] byArray, RxBleConnection rxBleConnection, z z10) {
        return this.r(uUID, byArray, rxBleConnection, z10);
    }

    public /* synthetic */ e0 w(UUID uUID, byte[] byArray, RxBleConnection rxBleConnection) {
        return this.v(uUID, byArray, rxBleConnection);
    }

    public z x() {
        z z10 = this.a.f();
        RxBleConnection$RxBleConnectionState rxBleConnection$RxBleConnectionState = this.g();
        return z10.I5((Object)rxBleConnection$RxBleConnectionState);
    }

    public z y(UUID object) {
        Object object2 = this.d;
        s s10 = new s((UUID)object);
        object = ((z)object2).T0(s10);
        object2 = w.a;
        return ((z)object).T0((e.a.v0.o)object2);
    }

    public z z(int n10) {
        pd$b pd$b = new pd$b(this, n10);
        return z.D1(pd$b);
    }
}

