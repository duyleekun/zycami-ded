/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.Camera$Size
 *  android.util.Size
 */
package d.v.d.g.c.x;

import android.hardware.Camera;
import android.util.Size;
import d.v.d.g.c.s;
import d.v.d.g.c.x.a;
import d.v.d.g.c.x.b;
import d.v.d.g.c.x.c;
import d.v.d.g.c.x.d;
import d.v.d.g.c.x.e;
import d.v.d.g.c.x.f;
import d.v.d.i.a.c$a;
import d.v.d.i.f.t;
import d.v.d.i.f.w;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class g
extends s {
    private final c$a q;

    public g(d.v.d.e object, f f10) {
        super((d.v.d.e)object, f10);
        this.q = object = d.v.d.g.c.x.d.a;
        this.C0(true);
    }

    public static /* synthetic */ void P0(Integer n10, int n11) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("photo control change integer=");
        stringBuilder.append(n10);
        d.v.d.h.f.a(stringBuilder.toString());
    }

    public static /* synthetic */ void Q0(List list, Camera.Size size) {
        int n10 = size.width;
        int n11 = size.height;
        Size size2 = new Size(n10, n11);
        list.add(size2);
    }

    public static /* synthetic */ int R0(Size size, Size size2) {
        int n10 = size2.getWidth();
        int n11 = size2.getHeight();
        n10 *= n11;
        n11 = size.getWidth();
        int n12 = size.getHeight();
        return n10 - (n11 *= n12);
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

    private void U0(boolean bl2) {
        d.v.d.i.e.a a10 = this.L0();
        c$a c$a = this.q;
        this.c(bl2, a10, c$a);
    }

    private void V0() {
        String string2;
        int n10;
        d.v.d.h.f.a("reset support preview and photo size---");
        Object object = new ArrayList();
        Object object2 = this.c.getSupportedPictureSizes();
        Object object3 = new b((List)object);
        object2.forEach(object3);
        object2 = d.v.d.g.c.x.a.a;
        object.sort(object2);
        this.N0().u((List)object);
        object2 = (Size)this.N0().get();
        object3 = new StringBuilder();
        String string3 = "select PhotoSize=";
        ((StringBuilder)object3).append(string3);
        ((StringBuilder)object3).append(object2);
        object3 = ((StringBuilder)object3).toString();
        d.v.d.h.f.a((String)object3);
        int n11 = object.contains(object2);
        if (n11 != 0) {
            object = this.N0();
            ((d.v.d.i.a.a)object).d();
        } else {
            object2 = this.N0();
            n10 = 0;
            object3 = null;
            object = (Size)object.get(0);
            ((d.v.d.i.e.f)object2).s((Size)object);
        }
        object = new ArrayList();
        object2 = this.c.getSupportedPreviewSizes();
        object3 = new c((List)object);
        object2.forEach(object3);
        object2 = e.a;
        object.sort(object2);
        object2 = this.A();
        object3 = (Size)this.E().get();
        ((t)object2).x((List)object, (Size)object3);
        object2 = (Size)this.A().get();
        object3 = new StringBuilder();
        string3 = "current select previewSize=";
        ((StringBuilder)object3).append(string3);
        ((StringBuilder)object3).append(object2);
        d.v.d.h.f.a(((StringBuilder)object3).toString());
        object3 = (Size)this.N0().get();
        int n12 = object3.getWidth();
        double d10 = n12;
        double d11 = 1.0;
        d10 *= d11;
        double d12 = object3.getHeight();
        d10 /= d12;
        object3 = this.E();
        n10 = ((w)object3).n();
        boolean bl2 = object.contains(object2);
        if (!bl2) {
            object2 = this.A();
            object = this.I0((List)object, d10, n10);
            ((t)object2).v((Size)object);
            return;
        }
        String string4 = ".0000";
        DecimalFormat decimalFormat = new DecimalFormat(string4);
        int n13 = object2.getWidth();
        double d13 = (double)n13 * d11;
        n11 = object2.getHeight();
        d11 = n11;
        boolean bl3 = ((String)(object2 = decimalFormat.format(d13 /= d11))).equals(string2 = "1.3333");
        if (!bl3 && (n11 = (int)(((String)object2).equals(string2 = "1.7778") ? 1 : 0)) == 0) {
            object2 = this.A();
            object = this.I0((List)object, d10, n10);
            ((t)object2).v((Size)object);
        } else {
            object = this.A();
            ((d.v.d.i.a.a)object).d();
        }
    }

    public void C0(boolean bl2) {
        this.U0(bl2);
    }

    public void D0() {
        this.V0();
    }

    public d.v.d.i.e.a L0() {
        return this.a.j0();
    }

    public d.v.d.i.e.b M0() {
        return this.a.k0();
    }

    public d.v.d.i.e.f N0() {
        return this.a.m0();
    }

    public d.v.d.i.e.g O0() {
        return this.a.n0();
    }

    public void w0() {
        d.v.d.h.f.a("release Source");
    }
}

