/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.Camera$Size
 *  android.os.SystemClock
 *  android.util.Size
 *  android.view.Surface
 */
package d.v.d.g.c.w;

import android.hardware.Camera;
import android.os.SystemClock;
import android.util.Size;
import android.view.Surface;
import d.v.d.e;
import d.v.d.g.b;
import d.v.d.g.c.r;
import d.v.d.g.c.s;
import d.v.d.g.c.w.c;
import d.v.d.g.c.w.d;
import d.v.d.g.c.w.f;
import d.v.d.g.c.w.g;
import d.v.d.g.c.w.h;
import d.v.d.g.c.w.i;
import d.v.d.g.c.w.j$a;
import d.v.d.g.c.w.j$b;
import d.v.d.i.a.a;
import d.v.d.i.a.c$a;
import d.v.d.i.f.l;
import d.v.d.i.f.t;
import d.v.d.i.f.u;
import d.v.d.i.g.k;
import d.v.d.i.g.k$a;
import d.v.d.i.g.m;
import d.v.d.i.g.n;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class j
extends s {
    private static final int u = 200;
    private d.v.d.g.f.d q;
    private final c$a r;
    private final c$a s;
    private final c$a t;

    public j(i object, e e10) {
        super(e10, (r)object);
        this.r = object = new f(this);
        this.s = object = new d(this);
        this.t = object = new j$b(this);
        this.C0(true);
    }

    public static /* synthetic */ d.v.d.g.f.d L0(j j10) {
        return j10.q;
    }

    private int W0() {
        int n10 = this.n();
        l l10 = this.w();
        boolean bl2 = l10.s();
        if (bl2) {
            n10 = (360 - n10) % 360;
        }
        return n10;
    }

    private b X0(k$a object) {
        int n10;
        b b10;
        Object object2;
        Size size = ((k$a)object).a;
        Object object3 = object2 = this.U0().get();
        object3 = (Surface)object2;
        int n11 = this.W0();
        int n12 = ((k$a)object).c();
        double d10 = (Double)this.N0().get();
        object2 = this.M0();
        object = ((k$a)object).a;
        int n13 = (Integer)this.w().get();
        n13 = ((d.v.d.i.g.d)object2).n((Size)object, n13);
        boolean bl2 = (Boolean)this.Q0().get();
        String string2 = this.R0().o();
        int n14 = this.P0().n();
        object2 = b10;
        b10 = new b(size, (Surface)object3, n11, n12, d10, n13, bl2, string2, n14);
        b10.j = n10 = ((Integer)this.w().get()).intValue();
        object = new j$a(this);
        b10.i = object;
        return b10;
    }

    private /* synthetic */ void Y0(k$a object, int n10) {
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
            this.l0();
            this.f();
            object = this.K();
            n10 = 4;
            comparable = n10;
            ((d.v.d.i.b.e)object).n((Integer)comparable);
        }
    }

    private /* synthetic */ void a1(Integer n10, int n11) {
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
                    this.h1();
                }
            } else {
                n10 = this.o();
                object = new g(this);
                n10.post((Runnable)object);
            }
        } else {
            n10 = this.o();
            object = new h(this);
            n10.post((Runnable)object);
        }
    }

    public static /* synthetic */ void c1(List list, Camera.Size size) {
        int n10 = size.width;
        int n11 = size.height;
        Size size2 = new Size(n10, n11);
        list.add(size2);
    }

    public static /* synthetic */ void d1(List list, Camera.Size size) {
        int n10 = size.width;
        int n11 = size.height;
        Size size2 = new Size(n10, n11);
        list.add(size2);
    }

    public static /* synthetic */ int e1(Size size, Size size2) {
        int n10 = size2.getWidth();
        int n11 = size2.getHeight();
        n10 *= n11;
        n11 = size.getWidth();
        int n12 = size.getHeight();
        return n10 - (n11 *= n12);
    }

    public static /* synthetic */ void f1(j j10) {
        j10.l1();
    }

    private void i1(boolean bl2) {
        d.v.d.i.g.f f10 = this.O0();
        c$a c$a = this.s;
        this.c(bl2, f10, c$a);
    }

    private void j1(boolean bl2) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("add record size listener add=");
        ((StringBuilder)object).append(bl2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.S0();
        c$a c$a = this.r;
        this.c(bl2, (a)object, c$a);
    }

    private void k1() {
        d.v.d.h.f.a("reset support preview and  record size");
        Size size = new ArrayList();
        Object object = this.c.getSupportedPreviewSizes();
        Consumer consumer = new d.v.d.g.c.w.e((List)size);
        object.forEach(consumer);
        object = (Integer)this.v().f();
        int n10 = (Integer)object;
        int n11 = 60;
        if (n10 < n11) {
            n11 = 30;
        }
        object = this.S0();
        int n12 = (Integer)this.w().get();
        ((k)object).B((List)size, n11, n12);
        size = new ArrayList();
        object = this.c.getSupportedPreviewSizes();
        consumer = new d.v.d.g.c.w.b((List)size);
        object.forEach(consumer);
        object = d.v.d.g.c.w.c.a;
        size.sort(object);
        object = this.A();
        consumer = (Size)this.E().get();
        ((t)object).x((List)size, (Size)consumer);
        object = ((k$a)this.S0().get()).a;
        double d10 = (double)object.getWidth() * 1.0;
        double d11 = object.getHeight();
        n10 = object.getHeight();
        t t10 = this.A();
        size = this.I0((List)size, d10 /= d11, n10);
        t10.v(size);
    }

    private void l1() {
        long l10;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("start record getPreviewStatus=");
        Object object2 = this.B();
        ((StringBuilder)object).append(object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.T0();
        Object object3 = ((d.v.d.i.g.l)object).o();
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
            this.T0().l(false);
            object = this.T0();
            object2 = 2;
            ((d.v.d.i.g.l)object).s((Integer)object2);
            this.q.B();
            object = this.m();
            object2 = this.t;
            ((a)object).g((c$a)object2);
            return;
        }
        d.v.d.h.f.a("current is not enough arm ,return");
    }

    private void m1() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("stop Record getRecordStatus=");
        Object object2 = this.T0();
        ((StringBuilder)object).append(object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.q;
        if (object == null) {
            d.v.d.h.f.a("current is mMediaRecorderZy=null,return");
            return;
        }
        object = this.T0();
        boolean bl2 = ((d.v.d.i.g.l)object).p();
        if (!bl2) {
            d.v.d.h.f.a("current is not prepare stop ,return");
            return;
        }
        d.v.d.h.f.a("stop record");
        this.q.C();
        this.q = null;
        object = this.T0();
        object2 = 5;
        ((d.v.d.i.g.l)object).s((Integer)object2);
        this.T0().l(true);
        object = this.m();
        object2 = this.t;
        ((a)object).a((c$a)object2);
    }

    private void n1(d.v.d.i.d.c c10) {
        d.v.d.h.f.a("wait pcm data");
        Object object = c10.get();
        if (object == null) {
            object = "sleep";
            d.v.d.h.f.a((String)object);
            long l10 = 500L;
            SystemClock.sleep((long)l10);
            this.n1(c10);
        }
    }

    public void C0(boolean bl2) {
        this.i1(bl2);
        this.j1(bl2);
    }

    public void D0() {
        this.k1();
    }

    public d.v.d.i.g.d M0() {
        return this.a.M0();
    }

    public d.v.d.i.g.e N0() {
        return this.a.N0();
    }

    public d.v.d.i.g.f O0() {
        return this.a.O0();
    }

    public d.v.d.i.g.g P0() {
        return this.a.P0();
    }

    public d.v.d.i.g.h Q0() {
        return this.a.Q0();
    }

    public d.v.d.i.g.j R0() {
        return this.a.R0();
    }

    public k S0() {
        return this.a.S0();
    }

    public d.v.d.i.g.l T0() {
        return this.a.T0();
    }

    public m U0() {
        return this.a.U0();
    }

    public n V0() {
        return this.a.V0();
    }

    public /* synthetic */ void Z0(k$a k$a, int n10) {
        this.Y0(k$a, n10);
    }

    public /* synthetic */ void b1(Integer n10, int n11) {
        this.a1(n10, n11);
    }

    public void g1() {
        boolean bl2;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("prepare Record getRecordStatus=");
        Object object2 = this.T0();
        ((StringBuilder)object).append(object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.B();
        boolean n10 = ((u)object).o();
        if (!n10) {
            d.v.d.h.f.a("current is not preview ing ,return");
            return;
        }
        object = this.T0();
        boolean bl3 = ((d.v.d.i.g.l)object).o();
        if (!bl3 && !(bl2 = ((d.v.d.i.g.l)(object = this.T0())).q())) {
            this.U0().set(null);
            this.q = object = new d.v.d.g.f.d();
            object = this.m();
            this.n1((d.v.d.i.d.c)object);
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("ready audio data=");
            String string2 = ((d.v.d.i.d.c)object).toString();
            ((StringBuilder)object2).append(string2);
            d.v.d.h.f.a(((StringBuilder)object2).toString());
            object2 = this.q;
            int n11 = ((d.v.d.i.d.c)object).p();
            ((d.v.d.g.f.d)object2).s(n11);
            object2 = this.q;
            n11 = ((d.v.d.i.d.c)object).o();
            ((d.v.d.g.f.d)object2).t(n11);
            object2 = this.q;
            int n12 = ((d.v.d.i.d.c)object).q();
            ((d.v.d.g.f.d)object2).u(n12);
            object = this.q;
            int n13 = ((byte[])this.m().get()).length;
            ((d.v.d.g.f.d)object).r(n13);
            object = (k$a)this.S0().get();
            object2 = this.N0();
            object = (double)((k$a)object).c() * 1.0;
            ((d.v.d.i.g.e)object2).n((Double)object);
            object = (k$a)this.S0().get();
            object = this.X0((k$a)object);
            object2 = this.q;
            float f10 = (float)((b)object).e;
            ((d.v.d.g.f.d)object2).v(f10);
            object2 = this.q;
            n11 = ((b)object).c;
            ((d.v.d.g.f.d)object2).w(n11);
            object2 = this.q;
            string2 = ((b)object).h;
            ((d.v.d.g.f.d)object2).x(string2);
            object2 = this.q;
            n11 = ((b)object).d;
            ((d.v.d.g.f.d)object2).z(n11);
            object2 = this.q;
            n11 = ((b)object).a.getWidth();
            int n14 = ((b)object).a.getHeight();
            ((d.v.d.g.f.d)object2).A(n11, n14);
            object2 = this.q;
            int n15 = ((b)object).f;
            ((d.v.d.g.f.d)object2).y(n15);
            this.q.o();
            object = this.U0();
            object2 = this.q.n();
            ((a)object).set(object2);
            object = this.T0();
            object2 = 1;
            ((d.v.d.i.g.l)object).s((Integer)object2);
            return;
        }
        d.v.d.h.f.a("current is prepare start or start, return");
    }

    public void h1() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("prepare stop getRecordStatus=");
        Object object2 = this.T0();
        ((StringBuilder)object).append(object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.T0();
        boolean bl2 = ((d.v.d.i.g.l)object).q();
        if (!bl2) {
            d.v.d.h.f.a("current is not start,return");
            return;
        }
        object = this.T0();
        object2 = 4;
        ((d.v.d.i.g.l)object).s((Integer)object2);
        this.m1();
    }

    public void w0() {
        d.v.d.h.f.a("release Source");
    }
}

