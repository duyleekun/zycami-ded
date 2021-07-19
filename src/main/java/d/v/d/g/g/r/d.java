/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.SurfaceTexture
 *  android.util.Size
 */
package d.v.d.g.g.r;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.Size;
import d.v.d.e;
import d.v.d.g.g.m;
import d.v.d.g.g.r.a;
import d.v.d.g.g.r.b;
import d.v.d.g.g.r.c;
import d.v.d.g.g.r.d$a;
import d.v.d.h.f;
import d.v.d.i.a.c$a;
import d.v.d.i.e.g;
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
        d.v.d.i.e.a a10 = this.D0();
        c$a c$a = this.s;
        this.b(bl2, a10, c$a);
    }

    private void L0() {
        f.a("reset support preview and  photo size");
        Object object = this.c.getSupportedCaptureSizes(256);
        Object object2 = d.v.d.g.g.r.b.a;
        object.sort(object2);
        this.G0().u((List)object);
        object2 = (Size)this.G0().get();
        CharSequence charSequence = new StringBuilder();
        String string2 = "select PhotoSize=";
        charSequence.append(string2);
        charSequence.append(object2);
        charSequence = charSequence.toString();
        f.a((String)charSequence);
        boolean bl2 = object.contains(object2);
        if (bl2) {
            object = this.G0();
            ((d.v.d.i.a.a)object).d();
        } else {
            object2 = this.G0();
            charSequence = null;
            object = (Size)object.get(0);
            ((d.v.d.i.e.f)object2).s((Size)object);
        }
        object = this.c.getSupportedPreviewSizes(SurfaceTexture.class);
        object2 = d.v.d.g.g.r.a.a;
        object.sort(object2);
        object2 = this.w();
        charSequence = (Size)this.z().get();
        ((t)object2).x((List)object, (Size)charSequence);
        object2 = this.w();
        charSequence = (Size)this.G0().get();
        object = this.u0((List)object, (Size)charSequence);
        ((t)object2).v((Size)object);
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

    public void k0() {
    }

    public void p0(boolean bl2) {
        this.K0(bl2);
    }

    public void q0() {
        this.L0();
    }
}

