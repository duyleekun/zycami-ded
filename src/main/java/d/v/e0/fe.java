/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Point
 *  android.graphics.PointF
 */
package d.v.e0;

import android.graphics.Point;
import android.graphics.PointF;
import androidx.core.math.MathUtils;
import com.zhiyun.protocol.constants.WorkingMode;
import com.zhiyun.stabilizer.Stabilizer;
import com.zhiyun.stabilizer.exception.StabilizerDisconnectionException;
import d.v.e0.ae;
import d.v.e0.b1;
import d.v.e0.cb;
import d.v.e0.ce;
import d.v.e0.db;
import d.v.e0.eb;
import d.v.e0.ec;
import d.v.e0.fb;
import d.v.e0.fe$a;
import d.v.e0.fe$b;
import d.v.e0.gb;
import d.v.e0.hb;
import d.v.e0.i0;
import d.v.e0.ib;
import d.v.e0.j0;
import d.v.e0.jb;
import d.v.e0.kb;
import d.v.e0.lb;
import d.v.e0.mb;
import d.v.e0.n0;
import d.v.e0.nb;
import d.v.e0.nd;
import d.v.e0.ob;
import d.v.e0.pb;
import d.v.e0.qb;
import d.v.e0.rb;
import d.v.e0.sb;
import d.v.e0.tb;
import d.v.e0.ub;
import d.v.e0.vb;
import d.v.e0.vc;
import e.a.a;
import e.a.d;
import e.a.e0;
import e.a.g;
import e.a.s0.b;
import e.a.v0.o;
import e.a.v0.r;
import e.a.z;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class fe {
    private final e.a.s0.a a;
    private WorkingMode b;
    private float c;

    public fe() {
        e.a.s0.a a10;
        this.a = a10 = new e.a.s0.a();
    }

    public static /* synthetic */ void B() {
    }

    private void C() {
        a a10 = this.D();
        Object object = this.b();
        a10 = a10.n((g)object);
        object = new fe$a(this);
        a10.f((d)object);
    }

    private a D() {
        Object object;
        Object object2 = this.b;
        if (object2 != null && object2 != (object = WorkingMode.L)) {
            object = this.c();
            db db2 = new db((WorkingMode)((Object)object2));
            object2 = ((e.a.i0)object).k0(db2).k3();
        } else {
            object2 = e.a.a.y();
        }
        return object2;
    }

    private PointF E(ae ae2, PointF pointF) {
        boolean bl2;
        boolean bl3 = ae2.d();
        float f10 = -1.0f;
        if (bl3) {
            float f11;
            pointF.x = f11 = pointF.x * f10;
        }
        if (bl2 = ae2.f()) {
            float f12;
            pointF.y = f12 = pointF.y * f10;
        }
        return pointF;
    }

    private a F(float f10) {
        e.a.i0 i02 = this.c();
        ub ub2 = new ub(this, f10);
        return i02.i0(ub2);
    }

    private void G(Point point) {
        int n10 = point.x;
        int n11 = point.y;
        ce.E0().U5(n11, 2048, n10, null);
    }

    private a H(Point point) {
        e.a.i0 i02 = this.c();
        eb eb2 = new eb(point);
        return i02.k0(eb2).k3();
    }

    private a I(float f10, Point object) {
        a a10 = this.F(f10);
        object = this.H((Point)object);
        a10 = a10.n((g)object);
        object = pb.a;
        return a10.w0((o)object);
    }

    private a J(WorkingMode workingMode) {
        e.a.i0 i02 = this.c();
        tb tb2 = new tb(workingMode);
        return i02.i0(tb2);
    }

    private a L() {
        Object object = this.c();
        Object object2 = b1.a;
        object = ((e.a.i0)object).k0((o)object2);
        object2 = new ob(this);
        object = ((z)object).f2((e.a.v0.g)object2);
        object2 = nb.a;
        object = ((z)object).o2((r)object2);
        object2 = new ib(this);
        return ((z)object).E2((o)object2);
    }

    private b N(fe$b fe$b) {
        Object object = new ae();
        Object object2 = ce.E0().X0();
        Object object3 = ec.a;
        object2 = ((e.a.i0)object2).k0((o)object3);
        object3 = new i0((ae)object);
        object2 = ((z)object2).f2((e.a.v0.g)object3).k3();
        object3 = this.L();
        object2 = ((a)object2).n((g)object3);
        object3 = this.a();
        object2 = ((a)object2).n((g)object3).Z0();
        object3 = hb.a;
        object2 = ((z)object2).H3((o)object3);
        object3 = new sb(this);
        object2 = ((z)object2).s2((o)object3);
        object3 = new jb(fe$b);
        object2 = ((z)object2).H3((o)object3);
        object3 = new kb(this, (ae)object);
        object = ((z)object2).H3((o)object3);
        object2 = gb.a;
        object = ((z)object).H3((o)object2);
        object2 = new cb(this);
        object = ((z)object).X1((e.a.v0.a)object2);
        object2 = new lb(this);
        fe$b.getClass();
        object3 = new n0(fe$b);
        return ((z)object).c((e.a.v0.g)object2, (e.a.v0.g)object3);
    }

    private b O(fe$b fe$b) {
        Object object = this.d(50);
        Object object2 = new vb(fe$b);
        object = ((z)object).H3((o)object2);
        object2 = mb.a;
        object = ((z)object).H3((o)object2);
        object2 = new rb(this, fe$b);
        object = ((z)object).E2((o)object2);
        object2 = fb.a;
        fe$b.getClass();
        n0 n02 = new n0(fe$b);
        return ((a)object).h((e.a.v0.a)object2, n02);
    }

    private a a() {
        e.a.i0 i02 = this.c();
        vc vc2 = vc.a;
        return i02.i0(vc2);
    }

    private a b() {
        e.a.i0 i02 = this.c();
        j0 j02 = j0.a;
        return i02.i0(j02);
    }

    private e.a.i0 c() {
        return ce.E0().X0();
    }

    private z d(long l10) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        z z10 = z.n3(l10, timeUnit);
        qb qb2 = qb.a;
        return z10.s2(qb2);
    }

    public static /* synthetic */ void e(fe fe2) {
        fe2.C();
    }

    public static /* synthetic */ a f(fe fe2, WorkingMode workingMode) {
        return fe2.J(workingMode);
    }

    public static /* synthetic */ void g(fe fe2, Point point) {
        fe2.G(point);
    }

    public static /* synthetic */ e0 h(Long object) {
        boolean bl2 = ce.A1();
        if (bl2) {
            object = z.t3(Boolean.TRUE);
        } else {
            object = new StabilizerDisconnectionException();
            object = z.m2((Throwable)object);
        }
        return object;
    }

    public static /* synthetic */ z i(fe fe2, long l10) {
        return fe2.d(l10);
    }

    public static /* synthetic */ e0 j(WorkingMode workingMode, Stabilizer stabilizer) {
        return stabilizer.j0(workingMode);
    }

    private /* synthetic */ g k(float f10, Stabilizer stabilizer) {
        float f11 = this.c;
        float f12 = f11 - f10;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            this.c = f10;
            return stabilizer.g7(f10).z0(2);
        }
        return nd.a;
    }

    public static /* synthetic */ e0 m(Point point, Stabilizer stabilizer) {
        int n10 = point.x;
        int n11 = point.y;
        return stabilizer.B7(n10, n11);
    }

    public static /* synthetic */ g n(Throwable object) {
        boolean bl2 = object instanceof TimeoutException;
        object = bl2 ? e.a.a.y() : e.a.a.V((Throwable)object);
        return object;
    }

    public static /* synthetic */ g o(WorkingMode workingMode, Stabilizer stabilizer) {
        return stabilizer.j0(workingMode).k3();
    }

    public static /* synthetic */ boolean p(WorkingMode workingMode) {
        boolean bl2;
        WorkingMode workingMode2 = WorkingMode.L;
        if (workingMode != workingMode2) {
            bl2 = true;
        } else {
            bl2 = false;
            workingMode = null;
        }
        return bl2;
    }

    private /* synthetic */ void q(WorkingMode workingMode) {
        this.b = workingMode;
    }

    public static /* synthetic */ Integer s(Object object) {
        return 150;
    }

    public static /* synthetic */ PointF t(fe$b fe$b, Boolean bl2) {
        return fe$b.a();
    }

    private /* synthetic */ PointF u(ae ae2, PointF pointF) {
        return this.E(ae2, pointF);
    }

    public static /* synthetic */ Point w(PointF pointF) {
        int n10;
        int n11;
        float f10 = pointF.x;
        float f11 = 2048.0f;
        pointF.x = f10 = f10 * f11 + f11;
        pointF.y = f10 = pointF.y * f11 + f11;
        Point point = new Point();
        point.x = n11 = Math.round(pointF.x);
        point.y = n10 = Math.round(pointF.y);
        return point;
    }

    public static /* synthetic */ PointF x(fe$b fe$b, Boolean bl2) {
        return fe$b.a();
    }

    public static /* synthetic */ Point y(PointF pointF) {
        int n10;
        int n11;
        float f10 = pointF.x;
        float f11 = -1.0f;
        float f12 = 1.0f;
        pointF.x = f10 = MathUtils.clamp(f10, f11, f12);
        pointF.y = f10 = MathUtils.clamp(pointF.y, f11, f12);
        Point point = new Point();
        f11 = pointF.x + f12;
        float f13 = 500.0f;
        point.x = n11 = Math.round(f11 * f13);
        point.y = n10 = Math.round((pointF.y + f12) * f13);
        return point;
    }

    private /* synthetic */ g z(fe$b fe$b, Point point) {
        float f10 = fe$b.b();
        return this.I(f10, point);
    }

    public /* synthetic */ g A(fe$b fe$b, Point point) {
        return this.z(fe$b, point);
    }

    public void K() {
        this.a.e();
    }

    public void M(fe$b object) {
        Objects.requireNonNull(object, "callback is null");
        Stabilizer stabilizer = ce.E0().a1();
        int n10 = stabilizer.Z2();
        if (n10 != 0) {
            n10 = 1;
        } else {
            n10 = 0;
            stabilizer = null;
        }
        object = n10 != 0 ? this.O((fe$b)object) : this.N((fe$b)object);
        this.a.b((b)object);
    }

    public /* synthetic */ g l(float f10, Stabilizer stabilizer) {
        return this.k(f10, stabilizer);
    }

    public /* synthetic */ void r(WorkingMode workingMode) {
        this.q(workingMode);
    }

    public /* synthetic */ PointF v(ae ae2, PointF pointF) {
        return this.u(ae2, pointF);
    }
}

