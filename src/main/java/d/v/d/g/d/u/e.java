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
package d.v.d.g.d.u;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.ImageReader;
import android.util.Size;
import android.view.Surface;
import d.v.d.g.d.o;
import d.v.d.g.d.u.b;
import d.v.d.g.d.u.c;
import d.v.d.g.d.u.d;
import d.v.d.g.d.u.e$a;
import d.v.d.g.d.u.e$b;
import d.v.d.h.f;
import d.v.d.i.a.c$a;
import d.v.d.i.e.a;
import d.v.d.i.e.g;
import d.v.d.i.f.l;
import d.v.d.i.f.t;
import java.util.Arrays;
import java.util.List;

public class e
extends o {
    private final d s;
    private ImageReader t;
    private final c$a u;
    private final c$a v;

    public e(d d10, d.v.d.e object) {
        super((d.v.d.e)object, d10);
        this.u = object = new e$a(this);
        this.v = object = new e$b(this);
        this.s = d10;
        this.F0(true);
    }

    public static /* synthetic */ d V0(e e10) {
        return e10.s;
    }

    public static /* synthetic */ ImageReader W0(e e10) {
        return e10.t;
    }

    public static /* synthetic */ ImageReader X0(e e10, ImageReader imageReader) {
        e10.t = imageReader;
        return imageReader;
    }

    public static /* synthetic */ void Y0(e e10) {
        e10.g();
    }

    public static /* synthetic */ void Z0(e e10) {
        e10.o0();
    }

    public static /* synthetic */ boolean a1(e e10) {
        return e10.l1();
    }

    public static /* synthetic */ int g1(Size size, Size size2) {
        int n10 = size2.getWidth();
        int n11 = size2.getHeight();
        n10 *= n11;
        n11 = size.getWidth();
        int n12 = size.getHeight();
        return n10 - (n11 *= n12);
    }

    public static /* synthetic */ int h1(Size size, Size size2) {
        int n10 = size2.getWidth();
        int n11 = size2.getHeight();
        n10 *= n11;
        n11 = size.getWidth();
        int n12 = size.getHeight();
        return n10 - (n11 *= n12);
    }

    private void i1(boolean bl2) {
        a a10 = this.b1();
        c$a c$a = this.u;
        this.b(bl2, a10, c$a);
    }

    private void j1(boolean bl2) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("add photo size listener add=");
        ((StringBuilder)object).append(bl2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.d1();
        c$a c$a = this.v;
        this.b(bl2, (d.v.d.i.a.a)object, c$a);
    }

    private void k1() {
        Object object = this.c;
        Object object2 = CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP;
        if ((object = (StreamConfigurationMap)object.get((CameraCharacteristics.Key)object2)) == null) {
            d.v.d.h.f.a("no support size find");
            return;
        }
        d.v.d.h.f.a("reset support preview and photo size");
        int n10 = 256;
        object2 = Arrays.asList(object.getOutputSizes(n10));
        Object object3 = d.v.d.g.d.u.b.a;
        object2.sort(object3);
        this.d1().u((List)object2);
        object3 = (Size)this.d1().get();
        CharSequence charSequence = new StringBuilder();
        Object object4 = "select PhotoSize=";
        charSequence.append((String)object4);
        charSequence.append(object3);
        charSequence = charSequence.toString();
        d.v.d.h.f.a((String)charSequence);
        boolean bl2 = object2.contains(object3);
        if (bl2) {
            object2 = this.d1();
            ((d.v.d.i.a.a)object2).d();
        } else {
            object3 = this.d1();
            charSequence = null;
            object2 = (Size)object2.get(0);
            ((d.v.d.i.e.f)object3).s((Size)object2);
        }
        object = Arrays.asList(object.getOutputSizes(SurfaceTexture.class));
        object2 = d.v.d.g.d.u.c.a;
        object.sort(object2);
        object2 = this.H();
        object3 = (Size)this.K().get();
        ((t)object2).x((List)object, (Size)object3);
        object2 = (Size)this.d1().get();
        double d10 = (double)object2.getWidth() * 1.0;
        double d11 = object2.getHeight();
        n10 = this.K().n();
        object4 = this.H();
        object = this.L0((List)object, d10 /= d11, n10);
        ((t)object4).v((Size)object);
    }

    private boolean l1() {
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
        this.j1(bl2);
        this.i1(bl2);
    }

    public void G0() {
        this.k1();
    }

    public a b1() {
        return this.a.j0();
    }

    public d.v.d.i.e.b c1() {
        return this.a.k0();
    }

    public d.v.d.i.e.f d1() {
        return this.a.m0();
    }

    public g e1() {
        return this.a.n0();
    }

    public Surface f1() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("get Photo surface mPhotoImageReader=");
        int n10 = this.t.getWidth();
        stringBuilder.append(n10);
        stringBuilder.append("X");
        n10 = this.t.getHeight();
        stringBuilder.append(n10);
        d.v.d.h.f.a(stringBuilder.toString());
        return this.t.getSurface();
    }

    public void z0() {
        d.v.d.h.f.a("release Source");
    }
}

