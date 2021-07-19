/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.SurfaceTexture
 *  android.util.Size
 */
package d.v.d.g.g.p;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.Size;
import d.v.d.g.g.m;
import d.v.d.g.g.p.a;
import d.v.d.g.g.p.b;
import d.v.d.g.g.p.c;
import d.v.d.g.g.p.d;
import d.v.d.g.g.p.e$a;
import d.v.d.i.a.c$a;
import d.v.d.i.e.f;
import d.v.d.i.e.g;
import d.v.d.i.f.t;
import java.util.List;

public class e
extends m {
    public final d r;
    private final c$a s;
    private final c$a t;

    public e(d d10, d.v.d.e object, Context context) {
        super(d10, (d.v.d.e)object, context);
        this.s = object = d.v.d.g.g.p.c.a;
        this.t = object = new e$a(this);
        this.r = d10;
        this.p0(true);
    }

    public static /* synthetic */ void H0(Size size, int n10) {
    }

    public static /* synthetic */ int I0(Size size, Size size2) {
        int n10 = size2.getWidth();
        int n11 = size2.getHeight();
        n10 *= n11;
        n11 = size.getWidth();
        int n12 = size.getHeight();
        return n10 - (n11 *= n12);
    }

    public static /* synthetic */ int J0(Size size, Size size2) {
        int n10 = size2.getWidth();
        int n11 = size2.getHeight();
        n10 *= n11;
        n11 = size.getWidth();
        int n12 = size.getHeight();
        return n10 - (n11 *= n12);
    }

    private void K0(boolean bl2) {
        d.v.d.i.e.a a10 = this.C0();
        c$a c$a = this.t;
        this.b(bl2, a10, c$a);
    }

    private void L0(boolean bl2) {
        f f10 = this.F0();
        c$a c$a = this.s;
        this.b(bl2, f10, c$a);
    }

    private void M0() {
        List list = this.c.getSupportedCaptureSizes(256);
        Object object = d.v.d.g.g.p.a.a;
        list.sort(object);
        this.F0().u(list);
        object = this.F0();
        list = (Size)list.get(0);
        ((f)object).s((Size)list);
        list = this.c.getSupportedPreviewSizes(SurfaceTexture.class);
        object = d.v.d.g.g.p.b.a;
        list.sort(object);
        object = this.w();
        Size size = (Size)this.z().get();
        ((t)object).x(list, size);
        object = this.w();
        size = (Size)this.F0().get();
        list = this.u0(list, size);
        ((t)object).v((Size)list);
    }

    public d.v.d.i.e.a C0() {
        return this.a.j0();
    }

    public d.v.d.i.e.b D0() {
        return this.a.k0();
    }

    public d.v.d.i.e.c E0() {
        return this.a.l0();
    }

    public f F0() {
        return this.a.m0();
    }

    public g G0() {
        return this.a.n0();
    }

    public void k0() {
    }

    public void p0(boolean bl2) {
        this.K0(bl2);
        this.L0(bl2);
    }

    public void q0() {
        this.M0();
    }
}

