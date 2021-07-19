/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.hardware.camera2.CameraCharacteristics
 *  android.hardware.camera2.CameraCharacteristics$Key
 *  android.hardware.camera2.params.StreamConfigurationMap
 *  android.media.ImageReader
 *  android.util.Size
 *  android.view.Surface
 */
package d.v.d.g.d.t;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.ImageReader;
import android.util.Size;
import android.view.Surface;
import d.v.d.g.d.o;
import d.v.d.g.d.t.b;
import d.v.d.g.d.t.c;
import d.v.d.g.d.t.d;
import d.v.d.g.d.t.e;
import d.v.d.g.d.t.f$a;
import d.v.d.i.a.c$a;
import d.v.d.i.e.a;
import d.v.d.i.e.g;
import d.v.d.i.f.l;
import d.v.d.i.f.t;
import d.v.d.i.f.w;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class f
extends o {
    private ImageReader s;
    private final e t;
    private final c$a u;
    private final c$a v;

    public f(d.v.d.e object, e e10) {
        super((d.v.d.e)object, e10);
        this.u = object = d.v.d.g.d.t.b.a;
        this.v = object = new f$a(this);
        this.t = e10;
        this.F0(true);
    }

    public static /* synthetic */ ImageReader V0(f f10) {
        return f10.s;
    }

    public static /* synthetic */ ImageReader W0(f f10, ImageReader imageReader) {
        f10.s = imageReader;
        return imageReader;
    }

    public static /* synthetic */ boolean X0(f f10) {
        return f10.j1();
    }

    public static /* synthetic */ void d1(Integer n10, int n11) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("photo control change integer=");
        stringBuilder.append(n10);
        d.v.d.h.f.a(stringBuilder.toString());
    }

    public static /* synthetic */ int e1(Size size, Size size2) {
        int n10 = size2.getWidth();
        int n11 = size2.getHeight();
        n10 *= n11;
        n11 = size.getWidth();
        int n12 = size.getHeight();
        return n10 - (n11 *= n12);
    }

    public static /* synthetic */ int f1(Size size, Size size2) {
        int n10 = size2.getWidth();
        int n11 = size2.getHeight();
        n10 *= n11;
        n11 = size.getWidth();
        int n12 = size.getHeight();
        return n10 - (n11 *= n12);
    }

    private void g1(boolean bl2) {
        a a10 = this.Y0();
        c$a c$a = this.u;
        this.b(bl2, a10, c$a);
    }

    private void h1(boolean bl2) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("add photo size listener add=");
        ((StringBuilder)object).append(bl2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.a1();
        c$a c$a = this.v;
        this.b(bl2, (d.v.d.i.a.a)object, c$a);
    }

    private void i1() {
        String string2;
        int n10;
        Object object = this.c;
        Object object2 = CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP;
        if ((object = (StreamConfigurationMap)object.get((CameraCharacteristics.Key)object2)) == null) {
            d.v.d.h.f.a("no support size find");
            return;
        }
        d.v.d.h.f.a("reset support preview and photo size---");
        int n11 = 256;
        object2 = Arrays.asList(object.getOutputSizes(n11));
        Object object3 = d.v.d.g.d.t.d.a;
        object2.sort(object3);
        this.a1().u((List)object2);
        object3 = (Size)this.a1().get();
        CharSequence charSequence = new StringBuilder();
        String string3 = "select PhotoSize=";
        charSequence.append(string3);
        charSequence.append(object3);
        charSequence = charSequence.toString();
        d.v.d.h.f.a((String)charSequence);
        int n12 = object2.contains(object3);
        if (n12 != 0) {
            object2 = this.a1();
            ((d.v.d.i.a.a)object2).d();
        } else {
            object3 = this.a1();
            n10 = 0;
            charSequence = null;
            object2 = (Size)object2.get(0);
            ((d.v.d.i.e.f)object3).s((Size)object2);
        }
        object = Arrays.asList(object.getOutputSizes(SurfaceTexture.class));
        object2 = d.v.d.g.d.t.c.a;
        object.sort(object2);
        object2 = this.H();
        object3 = (Size)this.K().get();
        ((t)object2).x((List)object, (Size)object3);
        object2 = (Size)this.H().get();
        object3 = new StringBuilder();
        charSequence = "current select previewSize=";
        ((StringBuilder)object3).append((String)charSequence);
        ((StringBuilder)object3).append(object2);
        d.v.d.h.f.a(((StringBuilder)object3).toString());
        object3 = (Size)this.a1().get();
        n10 = object3.getWidth();
        double d10 = n10;
        double d11 = 1.0;
        d10 *= d11;
        double d12 = object3.getHeight();
        d10 /= d12;
        object3 = this.K();
        n12 = ((w)object3).n();
        boolean bl2 = object.contains(object2);
        if (!bl2) {
            object2 = this.H();
            object = this.L0((List)object, d10, n12);
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
            object2 = this.H();
            object = this.L0((List)object, d10, n12);
            ((t)object2).v((Size)object);
        } else {
            object = this.H();
            ((d.v.d.i.a.a)object).d();
        }
    }

    private boolean j1() {
        d.v.d.i.a.a a10 = this.a.l0();
        boolean bl2 = ((d.v.d.i.e.c)a10).n();
        if (bl2 && (bl2 = ((l)(a10 = this.a.w0())).s())) {
            bl2 = true;
        } else {
            bl2 = false;
            a10 = null;
        }
        return bl2;
    }

    public void F0(boolean bl2) {
        this.h1(bl2);
        this.g1(bl2);
    }

    public void G0() {
        this.i1();
    }

    public a Y0() {
        return this.a.j0();
    }

    public d.v.d.i.e.b Z0() {
        return this.a.k0();
    }

    public d.v.d.i.e.f a1() {
        return this.a.m0();
    }

    public g b1() {
        return this.a.n0();
    }

    public Surface c1() {
        return this.s.getSurface();
    }

    public void z0() {
        d.v.d.h.f.a("release Source");
    }
}

