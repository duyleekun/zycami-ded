/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.Camera$Size
 *  android.util.Size
 *  android.view.Surface
 */
package d.v.d.g.c.a0;

import android.hardware.Camera;
import android.util.Size;
import android.view.Surface;
import d.v.d.g.b;
import d.v.d.g.c.a0.a;
import d.v.d.g.c.a0.c;
import d.v.d.g.c.a0.d;
import d.v.d.g.c.a0.e;
import d.v.d.g.c.a0.f;
import d.v.d.g.c.a0.g;
import d.v.d.g.c.a0.h;
import d.v.d.g.c.a0.i$a;
import d.v.d.g.c.r;
import d.v.d.g.c.s;
import d.v.d.i.a.c$a;
import d.v.d.i.f.t;
import d.v.d.i.f.u;
import d.v.d.i.g.j;
import d.v.d.i.g.k;
import d.v.d.i.g.k$a;
import d.v.d.i.g.l;
import d.v.d.i.g.m;
import d.v.d.i.g.n;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class i
extends s {
    private static final int t = 200;
    private d.v.d.g.f.d q;
    private final c$a r;
    private final c$a s;

    public i(h object, d.v.d.e e10) {
        super(e10, (r)object);
        this.r = object = new c(this);
        this.s = object = new e(this);
        this.C0(true);
    }

    private b V0(k$a object) {
        int n10;
        b b10;
        Object object2;
        Size size = ((k$a)object).a;
        Object object3 = object2 = this.T0().get();
        object3 = (Surface)object2;
        int n11 = this.n();
        int n12 = ((k$a)object).c();
        double d10 = (Double)this.M0().get();
        object2 = this.L0();
        object = ((k$a)object).a;
        int n13 = (Integer)this.w().get();
        n13 = ((d.v.d.i.g.d)object2).n((Size)object, n13);
        boolean bl2 = (Boolean)this.P0().get();
        String string2 = this.Q0().o();
        int n14 = this.O0().n();
        object2 = b10;
        b10 = new b(size, (Surface)object3, n11, n12, d10, n13, bl2, string2, n14);
        b10.j = n10 = ((Integer)this.w().get()).intValue();
        object = new i$a(this);
        b10.i = object;
        return b10;
    }

    public static /* synthetic */ void W0(i i10) {
        i10.j1();
    }

    private /* synthetic */ void X0(k$a object, int n10) {
        Comparable<StringBuilder> comparable = new StringBuilder();
        String string2 = "record size notify fpsSize=";
        comparable.append(string2);
        object = ((k$a)object).toString();
        comparable.append((String)object);
        comparable.append("\uff0cisPreviewIng=");
        boolean bl2 = this.B().o();
        comparable.append(bl2);
        d.v.d.h.f.a(comparable.toString());
        object = this.B();
        bl2 = ((u)object).o();
        if (bl2) {
            this.f();
            this.l0();
            object = this.K();
            n10 = 4;
            comparable = n10;
            ((d.v.d.i.b.e)object).n((Integer)comparable);
        }
    }

    private /* synthetic */ void Z0(Integer n10, int n11) {
        Object object = new StringBuilder();
        String string2 = "record control change integer=";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        d.v.d.h.f.a((String)object);
        int n12 = n10;
        if (n12 != 0) {
            n11 = 1;
            if (n12 != n11) {
                n11 = 2;
                if (n12 == n11) {
                    this.f1();
                }
            } else {
                n10 = this.o();
                object = new a(this);
                n10.post((Runnable)object);
            }
        } else {
            n10 = this.o();
            object = new g(this);
            n10.post((Runnable)object);
        }
    }

    public static /* synthetic */ void b1(List list, Camera.Size size) {
        int n10 = size.width;
        int n11 = size.height;
        Size size2 = new Size(n10, n11);
        list.add(size2);
    }

    public static /* synthetic */ void c1(List list, Camera.Size size) {
        int n10 = size.width;
        int n11 = size.height;
        Size size2 = new Size(n10, n11);
        list.add(size2);
    }

    public static /* synthetic */ int d1(Size size, Size size2) {
        int n10 = size2.getWidth();
        int n11 = size2.getHeight();
        n10 *= n11;
        n11 = size.getWidth();
        int n12 = size.getHeight();
        return n10 - (n11 *= n12);
    }

    private void g1(boolean bl2) {
        d.v.d.i.g.f f10 = this.N0();
        c$a c$a = this.s;
        this.c(bl2, f10, c$a);
    }

    private void h1(boolean bl2) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("add photo size listener add=");
        ((StringBuilder)object).append(bl2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.R0();
        c$a c$a = this.r;
        this.c(bl2, (d.v.d.i.a.a)object, c$a);
    }

    private void i1() {
        d.v.d.h.f.a("reset support preview and  record size");
        Size size = new ArrayList();
        Object object = this.c.getSupportedPreviewSizes();
        Consumer consumer = new d.v.d.g.c.a0.b((List)size);
        object.forEach(consumer);
        object = (Integer)this.v().f();
        int n10 = (Integer)object;
        int n11 = 60;
        if (n10 < n11) {
            n11 = 30;
        }
        object = this.R0();
        int n12 = (Integer)this.w().get();
        ((k)object).B((List)size, n11, n12);
        size = new ArrayList();
        object = this.c.getSupportedPreviewSizes();
        consumer = new f((List)size);
        object.forEach(consumer);
        object = d.v.d.g.c.a0.d.a;
        size.sort(object);
        object = this.A();
        consumer = (Size)this.E().get();
        ((t)object).x((List)size, (Size)consumer);
        object = ((k$a)this.R0().get()).a;
        double d10 = (double)object.getWidth() * 1.0;
        double d11 = object.getHeight();
        n10 = object.getHeight();
        t t10 = this.A();
        size = this.I0((List)size, d10 /= d11, n10);
        t10.v(size);
    }

    private void j1() {
        long l10;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("start record getPreviewStatus=");
        Object object2 = this.B();
        ((StringBuilder)object).append(object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.S0();
        Object object3 = ((l)object).o();
        if (object3 == 0) {
            d.v.d.h.f.a("current is not prepared start,return");
            return;
        }
        long l11 = d.v.d.i.g.c.p();
        long l12 = l11 - (l10 = 200L);
        object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object3 >= 0 && (object3 = (Object)((u)(object = this.B())).o()) != 0) {
            object = this.q;
            if (object == null) {
                d.v.d.h.f.a("current is mMediaRecorderZy==null,return");
                return;
            }
            d.v.d.h.f.a("start record");
            object = this.S0();
            object2 = 2;
            ((l)object).s((Integer)object2);
            this.q.B();
            return;
        }
        d.v.d.h.f.a("current is not enough arm ,return");
    }

    private void k1() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("stop Record getRecordStatus=");
        Object object2 = this.S0();
        ((StringBuilder)object).append(object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.q;
        if (object == null) {
            d.v.d.h.f.a("current is mMediaRecorderZy=null,return");
            return;
        }
        object = this.S0();
        boolean bl2 = ((l)object).p();
        if (!bl2) {
            d.v.d.h.f.a("current is not prepare stop ,return");
            return;
        }
        d.v.d.h.f.a("stop record");
        this.q.C();
        this.q = null;
        object = this.S0();
        object2 = 5;
        ((l)object).s((Integer)object2);
    }

    public void C0(boolean bl2) {
        this.g1(bl2);
        this.h1(bl2);
    }

    public void D0() {
        this.i1();
    }

    public d.v.d.i.g.d L0() {
        return this.a.M0();
    }

    public d.v.d.i.g.e M0() {
        return this.a.N0();
    }

    public d.v.d.i.g.f N0() {
        return this.a.O0();
    }

    public d.v.d.i.g.g O0() {
        return this.a.P0();
    }

    public d.v.d.i.g.h P0() {
        return this.a.Q0();
    }

    public j Q0() {
        return this.a.R0();
    }

    public k R0() {
        return this.a.S0();
    }

    public l S0() {
        return this.a.T0();
    }

    public m T0() {
        return this.a.U0();
    }

    public n U0() {
        return this.a.V0();
    }

    public /* synthetic */ void Y0(k$a k$a, int n10) {
        this.X0(k$a, n10);
    }

    public /* synthetic */ void a1(Integer n10, int n11) {
        this.Z0(n10, n11);
    }

    public void e1() {
        boolean bl2;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("prepare Record getRecordStatus=");
        Object object2 = this.S0();
        ((StringBuilder)object).append(object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.S0();
        boolean n10 = ((l)object).o();
        if (!n10 && !(bl2 = ((l)(object = this.S0())).q())) {
            this.T0().set(null);
            this.q = object = new d.v.d.g.f.d();
            ((d.v.d.g.f.d)object).l(false);
            object = (k$a)this.R0().get();
            object = this.V0((k$a)object);
            object2 = this.q;
            float f10 = (float)((b)object).e;
            ((d.v.d.g.f.d)object2).v(f10);
            object2 = this.q;
            int n11 = ((b)object).c;
            ((d.v.d.g.f.d)object2).w(n11);
            object2 = this.q;
            String string2 = ((b)object).h;
            ((d.v.d.g.f.d)object2).x(string2);
            object2 = this.q;
            n11 = ((b)object).d;
            ((d.v.d.g.f.d)object2).z(n11);
            object2 = this.q;
            n11 = ((b)object).a.getWidth();
            int n12 = ((b)object).a.getHeight();
            ((d.v.d.g.f.d)object2).A(n11, n12);
            object2 = this.q;
            int n13 = ((b)object).f;
            ((d.v.d.g.f.d)object2).y(n13);
            this.q.o();
            object = this.T0();
            object2 = this.q.n();
            ((d.v.d.i.a.a)object).set(object2);
            object = this.S0();
            object2 = 1;
            ((l)object).s((Integer)object2);
            return;
        }
        d.v.d.h.f.a("current is prepare start or start, return");
    }

    public void f1() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("prepare stop getRecordStatus=");
        Object object2 = this.S0();
        ((StringBuilder)object).append(object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.S0();
        boolean bl2 = ((l)object).q();
        if (!bl2) {
            d.v.d.h.f.a("current is not start,return");
            return;
        }
        object = this.S0();
        object2 = 4;
        ((l)object).s((Integer)object2);
        this.k1();
    }

    public void w0() {
    }
}

