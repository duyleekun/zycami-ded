/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 */
package d.v.h0;

import android.view.Surface;
import com.zhiyun.vtpusher.VtDataType;
import com.zhiyun.vtpusher.VtEncoderType;
import d.v.h0.c;
import d.v.h0.d;
import d.v.h0.g;
import d.v.h0.i$a;
import d.v.h0.i$b;
import d.v.h0.i$c;
import d.v.h0.i$d;
import d.v.h0.j;
import d.v.h0.k.e;
import d.v.h0.k.f;
import d.v.h0.l.a;
import d.v.k0.f.c.h;
import d.v.y.c.z0;
import e.a.e0;
import e.a.g0;
import e.a.v0.o;
import e.a.z;
import java.util.List;
import java.util.stream.Collectors;

public class i {
    private f a;
    private h b;
    private d.v.k0.f.d.a c;
    private g d;
    private final e.a.s0.a e;
    private z0 f;
    private int g;
    private int h;
    private final e i;

    public i() {
        Object object = new e.a.s0.a();
        this.e = object;
        this.i = object = new i$a(this);
    }

    public static /* synthetic */ void a(i i10, byte[] byArray) {
        i10.t(byArray);
    }

    public static /* synthetic */ g b(i i10) {
        return i10.d;
    }

    public static /* synthetic */ e.a.s0.a c(i i10) {
        return i10.e;
    }

    private boolean d() {
        Object[] objectArray = this.a;
        if (objectArray == null) {
            objectArray = new Object[]{};
            m.a.a.i("prepare first------", objectArray);
            return true;
        }
        return false;
    }

    public static i f() {
        return i$d.a();
    }

    private /* synthetic */ void g() {
        Object object = this.f;
        if (object != null) {
            ((d.v.y.c.a)object).clear();
        }
        if ((object = this.c) != null) {
            ((d.v.k0.f.d.a)object).a();
        }
        this.g = 0;
        this.h = 0;
    }

    public static /* synthetic */ e0 i(z0 z02, d.v.k0.f.d.a object) {
        z02.clear();
        object = ((d.v.k0.f.d.a)object).c();
        boolean bl2 = z02.parseFrom((byte[])object);
        if (bl2) {
            return z.t3(z02);
        }
        return z.l2();
    }

    private /* synthetic */ d.v.k0.f.d.a j(int n10, byte[] byArray) {
        z0 z02 = this.f;
        int n11 = this.h;
        z02.B(n11);
        z02 = this.f;
        n11 = this.g;
        z02.F(n11);
        this.f.D(n10);
        this.f.z(byArray);
        this.g = n10 = this.g + 1;
        d.v.k0.f.d.a a10 = this.c.b();
        byArray = this.f.a();
        return a10.g(byArray);
    }

    private void o(j object) {
        Object object2 = new f();
        this.a = object2;
        Enum enum_ = ((j)object).i();
        ((f)object2).j((VtDataType)enum_);
        object2 = this.a;
        enum_ = ((j)object).j();
        ((f)object2).d((VtEncoderType)enum_);
        object2 = this.a;
        int n10 = ((j)object).h();
        int n11 = ((j)object).g();
        ((f)object2).h(n10, n11);
        object2 = this.a;
        n10 = ((j)object).f();
        ((f)object2).g(n10);
        object2 = this.a;
        int n12 = ((j)object).e();
        ((f)object2).k(n12);
        object = this.a;
        object2 = this.i;
        ((f)object).b((e)object2);
        this.a.f();
    }

    private void p(j object) {
        Object object2 = new z0();
        this.f = object2;
        ((z0)object2).G(true);
        this.g = 0;
        this.h = 0;
        this.c = object2 = new d.v.k0.f.d.a();
        String string2 = ((j)object).c();
        object2 = ((d.v.k0.f.d.a)object2).h(string2);
        int n10 = ((j)object).d();
        ((d.v.k0.f.d.a)object2).j(n10);
        this.b = object2 = new h();
        object = ((j)object).c();
        ((h)object2).c((String)object);
        object = this.b;
        object2 = new a();
        ((h)object).p((d.v.k0.f.c.e)object2);
        object = this.b.l();
        object2 = new d(this);
        object = ((z)object).X1((e.a.v0.a)object2);
        object2 = new i$b(this);
        ((z)object).subscribe((g0)object2);
    }

    private void q(j object) {
        Object object2 = this.b;
        if (object2 == null) {
            return;
        }
        object2 = new z0();
        Object object3 = this.b;
        int n10 = ((j)object).b();
        object = ((h)object3).k(n10, 524288, false);
        object3 = new c((z0)object2);
        object = ((z)object).s2((o)object3);
        object2 = new i$c(this);
        ((z)object).subscribe((g0)object2);
    }

    private void t(byte[] object) {
        Object object2 = this.b;
        if (object2 != null && (object2 = this.c) != null) {
            int n10;
            int n11 = 1453;
            int n12 = d.v.k0.g.c.a((byte[])object, n11);
            object = d.v.k0.g.c.b((byte[])object, n11).stream();
            object2 = new d.v.h0.e(this, n12);
            object = object.map(object2);
            object2 = Collectors.toList();
            object = object.collect(object2);
            object2 = this.b;
            ((h)object2).o((List)object);
            object = null;
            this.g = 0;
            this.h = n10 = this.h + 1;
        }
    }

    public Surface e() {
        Surface surface;
        boolean bl2 = this.d();
        if (bl2) {
            bl2 = false;
            surface = null;
        } else {
            surface = this.a.a();
        }
        return surface;
    }

    public /* synthetic */ void h() {
        this.g();
    }

    public /* synthetic */ d.v.k0.f.d.a k(int n10, byte[] byArray) {
        return this.j(n10, byArray);
    }

    public void l(byte[] byArray) {
        boolean bl2 = this.d();
        if (bl2) {
            return;
        }
        this.a.c(byArray);
    }

    public void m() {
        boolean bl2 = this.d();
        if (bl2) {
            return;
        }
        this.a.pause();
    }

    public void n(j j10) {
        this.o(j10);
        this.p(j10);
    }

    public void r() {
        this.w();
        boolean bl2 = this.d();
        if (!bl2) {
            f f10 = this.a;
            f10.release();
            this.a = null;
        }
        this.d = null;
    }

    public void s() {
        boolean bl2 = this.d();
        if (bl2) {
            return;
        }
        this.a.i();
    }

    public void u(g g10) {
        this.d = g10;
    }

    public void v() {
        boolean bl2 = this.d();
        if (bl2) {
            return;
        }
        this.a.start();
    }

    public void w() {
        boolean bl2 = this.d();
        if (!bl2) {
            f f10 = this.a;
            f10.stop();
        }
        this.e.e();
    }
}

