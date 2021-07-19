/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.SurfaceTexture
 *  android.util.Size
 */
package d.v.d.g.g.q;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.Size;
import d.v.d.e;
import d.v.d.g.g.m;
import d.v.d.g.g.q.a;
import d.v.d.g.g.q.b;
import d.v.d.g.g.q.c;
import d.v.d.g.g.q.d$a;
import d.v.d.h.f;
import d.v.d.i.a.c$a;
import d.v.d.i.e.g;
import d.v.d.i.e.h;
import d.v.d.i.f.t;
import java.util.List;

public class d
extends m {
    private final c r;
    private final c$a s;

    public d(c c10, e object, Context context) {
        super(c10, (e)object, context);
        this.s = object = new d$a(this);
        this.r = c10;
        this.p0(true);
    }

    public static /* synthetic */ c C0(d d10) {
        return d10.r;
    }

    public static /* synthetic */ int J0(Size size, Size size2) {
        int n10 = size2.getWidth();
        int n11 = size2.getHeight();
        n10 *= n11;
        n11 = size.getWidth();
        int n12 = size.getHeight();
        return n10 - (n11 *= n12);
    }

    public static /* synthetic */ int K0(Size size, Size size2) {
        int n10 = size2.getWidth();
        int n11 = size2.getHeight();
        n10 *= n11;
        n11 = size.getWidth();
        int n12 = size.getHeight();
        return n10 - (n11 *= n12);
    }

    private void L0(boolean bl2) {
        d.v.d.i.e.a a10 = this.D0();
        c$a c$a = this.s;
        this.b(bl2, a10, c$a);
    }

    private void M0() {
        f.a("reset support preview and  photo size");
        List list = this.c.getSupportedCaptureSizes(256);
        Object object = d.v.d.g.g.q.b.a;
        list.sort(object);
        this.G0().u(list);
        object = this.G0();
        list = (Size)list.get(0);
        ((d.v.d.i.e.f)object).s((Size)list);
        list = this.c.getSupportedPreviewSizes(SurfaceTexture.class);
        object = d.v.d.g.g.q.a.a;
        list.sort(object);
        object = this.w();
        Size size = (Size)this.z().get();
        ((t)object).x(list, size);
        object = this.w();
        size = (Size)this.G0().get();
        list = this.u0(list, size);
        ((t)object).v((Size)list);
    }

    public d.v.d.i.e.a D0() {
        return this.a.j0();
    }

    public d.v.d.i.e.b E0() {
        return this.a.k0();
    }

    public d.v.d.i.e.c F0() {
        return this.a.l0();
    }

    public d.v.d.i.e.f G0() {
        return this.a.m0();
    }

    public g H0() {
        return this.a.n0();
    }

    public h I0() {
        return this.a.o0();
    }

    public void k0() {
    }

    public void p0(boolean bl2) {
        this.L0(bl2);
    }

    public void q0() {
        this.M0();
    }
}

