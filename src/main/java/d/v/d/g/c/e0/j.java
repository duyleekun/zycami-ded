/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.Camera$Size
 *  android.os.Handler
 *  android.os.SystemClock
 *  android.util.Size
 *  android.view.Surface
 */
package d.v.d.g.c.e0;

import android.hardware.Camera;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Size;
import android.view.Surface;
import d.v.d.g.c.e0.a;
import d.v.d.g.c.e0.b;
import d.v.d.g.c.e0.c;
import d.v.d.g.c.e0.d;
import d.v.d.g.c.e0.e;
import d.v.d.g.c.e0.f;
import d.v.d.g.c.e0.g;
import d.v.d.g.c.e0.h;
import d.v.d.g.c.e0.i;
import d.v.d.g.c.e0.j$a;
import d.v.d.g.c.r;
import d.v.d.g.c.s;
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
    private final d.v.d.g.h.a q;
    private final c$a r;
    private final c$a s;
    private final Runnable t;

    public j(i object, d.v.d.e e10) {
        super(e10, (r)object);
        this.r = object = new f(this);
        this.s = object = new c(this);
        this.t = object = new g(this);
        this.q = object = new d.v.d.g.h.a();
        this.C0(true);
    }

    private int L0() {
        d.v.d.g.h.a a10;
        double d10 = 20.0;
        try {
            a10 = this.q;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getCurrentDecibel failed e=");
            String string2 = exception.toString();
            stringBuilder.append(string2);
            d.v.d.h.f.a(stringBuilder.toString());
            return 0;
        }
        a10 = a10.b();
        int n10 = a10.getMaxAmplitude();
        float f10 = n10;
        float f11 = 0.1f;
        double d11 = f10 /= f11;
        return (int)(Math.log10(d11) * d10);
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

    private d.v.d.g.b X0(k$a object) {
        int n10;
        d.v.d.g.b b10;
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
        b10 = new d.v.d.g.b(size, (Surface)object3, n11, n12, d10, n13, bl2, string2, n14);
        b10.j = n10 = ((Integer)this.w().get()).intValue();
        object = new j$a(this);
        b10.i = object;
        return b10;
    }

    public static /* synthetic */ void Y0(j j10) {
        j10.n1();
    }

    private /* synthetic */ void Z0(k$a object, int n10) {
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
            object = this.K();
            n10 = 4;
            comparable = n10;
            ((d.v.d.i.b.e)object).n((Integer)comparable);
            this.b.a();
            object = this.b;
            ((r)object).c();
        }
    }

    private /* synthetic */ void b1(Integer n10, int n11) {
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
                    this.j1();
                }
            } else {
                n10 = this.o();
                object = new d(this);
                n10.post((Runnable)object);
            }
        } else {
            n10 = this.o();
            object = new h(this);
            n10.post((Runnable)object);
        }
    }

    private /* synthetic */ void d1() {
        n n10 = this.V0();
        Integer n11 = this.L0();
        n10.n(n11);
        this.o1();
    }

    public static /* synthetic */ void f1(List list, Camera.Size size) {
        int n10 = size.width;
        int n11 = size.height;
        Size size2 = new Size(n10, n11);
        list.add(size2);
    }

    public static /* synthetic */ void g1(List list, Camera.Size size) {
        int n10 = size.width;
        int n11 = size.height;
        Size size2 = new Size(n10, n11);
        list.add(size2);
    }

    public static /* synthetic */ int h1(Size size, Size size2) {
        int n10 = size2.getWidth();
        int n11 = size2.getHeight();
        n10 *= n11;
        n11 = size.getWidth();
        int n12 = size.getHeight();
        return n10 - (n11 *= n12);
    }

    private void k1(boolean bl2) {
        d.v.d.i.g.f f10 = this.O0();
        c$a c$a = this.s;
        this.c(bl2, f10, c$a);
    }

    private void l1(boolean bl2) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("add record size listener add=");
        ((StringBuilder)object).append(bl2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.S0();
        c$a c$a = this.r;
        this.c(bl2, (d.v.d.i.a.a)object, c$a);
    }

    private void m1() {
        d.v.d.h.f.a("reset support preview and  record size");
        Size size = new ArrayList();
        Object object = this.c.getSupportedPreviewSizes();
        Consumer consumer = new e((List)size);
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
        consumer = new a((List)size);
        object.forEach(consumer);
        object = d.v.d.g.c.e0.b.a;
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

    private void n1() {
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
            object = this.T0();
            object2 = 2;
            ((d.v.d.i.g.l)object).s((Integer)object2);
            SystemClock.sleep((long)50);
            this.q.g();
            this.o1();
            return;
        }
        d.v.d.h.f.a("current is not enough arm ,return");
    }

    private void o1() {
        Handler handler = this.o();
        Runnable runnable = this.t;
        handler.postDelayed(runnable, 1000L);
    }

    private void p1() {
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
        this.q.h();
        this.q1();
        object = this.T0();
        object2 = 5;
        ((d.v.d.i.g.l)object).s((Integer)object2);
    }

    private void q1() {
        Handler handler = this.o();
        Runnable runnable = this.t;
        handler.removeCallbacks(runnable);
    }

    public void C0(boolean bl2) {
        this.k1(bl2);
        this.l1(bl2);
    }

    public void D0() {
        this.m1();
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

    public /* synthetic */ void a1(k$a k$a, int n10) {
        this.Z0(k$a, n10);
    }

    public /* synthetic */ void c1(Integer n10, int n11) {
        this.b1(n10, n11);
    }

    public /* synthetic */ void e1() {
        this.d1();
    }

    public void i1() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("prepare Record getRecordStatus=");
        Object object2 = this.T0();
        ((StringBuilder)object).append(object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.T0();
        boolean bl2 = ((d.v.d.i.g.l)object).o();
        if (!bl2 && !(bl2 = ((d.v.d.i.g.l)(object = this.T0())).q())) {
            object = (k$a)this.S0().get();
            object2 = this.N0();
            double d10 = ((k$a)object).c();
            double d11 = 1.0;
            Double d12 = d10 *= d11;
            ((d.v.d.i.g.e)object2).n(d12);
            object2 = this.U0();
            d12 = null;
            ((d.v.d.i.a.a)object2).set(null);
            object2 = this.q;
            object = this.X0((k$a)object);
            bl2 = ((d.v.d.g.h.a)object2).d((d.v.d.g.b)object);
            if (bl2) {
                object = this.U0();
                object2 = this.q.c();
                ((d.v.d.i.a.a)object).set(object2);
                object = this.T0();
                int n10 = 1;
                object2 = n10;
                ((d.v.d.i.g.l)object).s((Integer)object2);
            } else {
                object = this.T0();
                int n11 = 6;
                object2 = n11;
                ((d.v.d.i.g.l)object).s((Integer)object2);
            }
            return;
        }
        d.v.d.h.f.a("current is prepare start or start, return");
    }

    public void j1() {
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
        this.p1();
    }

    public void w0() {
        d.v.d.h.f.a("release Source");
    }
}

