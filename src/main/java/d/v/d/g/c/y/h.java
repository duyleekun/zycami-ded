/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.Camera$Size
 *  android.util.Size
 */
package d.v.d.g.c.y;

import android.hardware.Camera;
import android.util.Size;
import d.v.d.g.c.s;
import d.v.d.g.c.y.b;
import d.v.d.g.c.y.c;
import d.v.d.g.c.y.d;
import d.v.d.g.c.y.e;
import d.v.d.g.c.y.f;
import d.v.d.g.c.y.g;
import d.v.d.g.c.y.h$a;
import d.v.d.i.a.c$a;
import d.v.d.i.e.a;
import d.v.d.i.f.t;
import d.v.d.i.f.u;
import java.util.ArrayList;
import java.util.List;

public class h
extends s {
    private final g q;
    private final c$a r;
    private final c$a s;

    public h(g g10, d.v.d.e object) {
        super((d.v.d.e)object, g10);
        this.r = object = new h$a(this);
        this.s = object = new f(this);
        this.q = g10;
        this.C0(true);
    }

    public static /* synthetic */ g L0(h h10) {
        return h10.q;
    }

    private /* synthetic */ void Q0(Size object, int n10) {
        object = this.B();
        boolean bl2 = ((u)object).o();
        if (bl2) {
            this.f();
            this.l0();
            object = this.K();
            n10 = 4;
            Integer n11 = n10;
            ((d.v.d.i.b.e)object).n(n11);
        }
    }

    public static /* synthetic */ void S0(List list, Camera.Size size) {
        int n10 = size.width;
        int n11 = size.height;
        Size size2 = new Size(n10, n11);
        list.add(size2);
    }

    public static /* synthetic */ int T0(Size size, Size size2) {
        int n10 = size2.getWidth();
        int n11 = size2.getHeight();
        n10 *= n11;
        n11 = size.getWidth();
        int n12 = size.getHeight();
        return n10 - (n11 *= n12);
    }

    public static /* synthetic */ void U0(List list, Camera.Size size) {
        int n10 = size.width;
        int n11 = size.height;
        Size size2 = new Size(n10, n11);
        list.add(size2);
    }

    public static /* synthetic */ int V0(Size size, Size size2) {
        int n10 = size2.getWidth();
        int n11 = size2.getHeight();
        n10 *= n11;
        n11 = size.getWidth();
        int n12 = size.getHeight();
        return n10 - (n11 *= n12);
    }

    private void W0(boolean bl2) {
        a a10 = this.M0();
        c$a c$a = this.r;
        this.c(bl2, a10, c$a);
    }

    private void X0(boolean bl2) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("add photo size listener add=");
        ((StringBuilder)object).append(bl2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.O0();
        c$a c$a = this.s;
        this.c(bl2, (d.v.d.i.a.a)object, c$a);
    }

    private void Y0() {
        d.v.d.h.f.a("reset support preview and photo size");
        Size size = new ArrayList();
        Object object = this.c.getSupportedPictureSizes();
        Object object2 = new d((List)size);
        object.forEach(object2);
        object = d.v.d.g.c.y.c.a;
        size.sort(object);
        this.O0().u((List)size);
        object = (Size)this.O0().get();
        object2 = new StringBuilder();
        String string2 = "select PhotoSize=";
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(object);
        object2 = ((StringBuilder)object2).toString();
        d.v.d.h.f.a((String)object2);
        int n10 = size.contains(object);
        if (n10 != 0) {
            size = this.O0();
            size.d();
        } else {
            object = this.O0();
            object2 = null;
            size = (Size)size.get(0);
            ((d.v.d.i.e.f)object).s(size);
        }
        size = new ArrayList();
        object = this.c.getSupportedPreviewSizes();
        object2 = new b((List)size);
        object.forEach(object2);
        object = e.a;
        size.sort(object);
        object = this.A();
        object2 = (Size)this.E().get();
        ((t)object).x((List)size, (Size)object2);
        object = (Size)this.O0().get();
        double d10 = (double)object.getWidth() * 1.0;
        double d11 = object.getHeight();
        n10 = this.E().n();
        t t10 = this.A();
        size = this.I0((List)size, d10 /= d11, n10);
        t10.v(size);
    }

    public void C0(boolean bl2) {
        this.X0(bl2);
        this.W0(bl2);
    }

    public void D0() {
        this.Y0();
    }

    public a M0() {
        return this.a.j0();
    }

    public d.v.d.i.e.b N0() {
        return this.a.k0();
    }

    public d.v.d.i.e.f O0() {
        return this.a.m0();
    }

    public d.v.d.i.e.g P0() {
        return this.a.n0();
    }

    public /* synthetic */ void R0(Size size, int n10) {
        this.Q0(size, n10);
    }

    public void w0() {
        d.v.d.h.f.a("release Source");
    }
}

