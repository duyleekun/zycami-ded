/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.hardware.camera2.CameraCaptureSession$CaptureCallback
 *  android.hardware.camera2.CameraCharacteristics
 *  android.hardware.camera2.CameraCharacteristics$Key
 *  android.hardware.camera2.CaptureRequest
 *  android.hardware.camera2.CaptureRequest$Builder
 *  android.hardware.camera2.CaptureRequest$Key
 *  android.hardware.camera2.params.StreamConfigurationMap
 *  android.media.ImageReader
 *  android.os.Build
 *  android.os.Handler
 *  android.util.Range
 *  android.util.Size
 *  android.view.Surface
 */
package d.v.d.g.d.v;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import d.v.d.g.d.o;
import d.v.d.g.d.v.b;
import d.v.d.g.d.v.c;
import d.v.d.g.d.v.d;
import d.v.d.g.d.v.e;
import d.v.d.g.d.v.f;
import d.v.d.g.d.v.g;
import d.v.d.g.d.v.h;
import d.v.d.g.d.v.i$a;
import d.v.d.g.d.v.i$b;
import d.v.d.i.a.c$a;
import d.v.d.i.e.a;
import d.v.d.i.f.l;
import d.v.d.i.f.m;
import d.v.d.i.f.r;
import d.v.d.i.f.t;
import d.v.d.i.f.x;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class i
extends o {
    private ImageReader s;
    private final h t;
    private final c$a u;
    private final c$a v;
    private final c$a w;
    private final c$a x;
    private final c$a y;
    private final c$a z;

    public i(d.v.d.e object, h h10) {
        super((d.v.d.e)object, h10);
        this.u = object = new i$a(this);
        this.v = object = new g(this);
        this.w = object = new d(this);
        this.x = object = new b(this);
        this.y = object = new f(this);
        this.z = object = new i$b(this);
        this.t = h10;
        this.F0(true);
    }

    private void A1() {
        Object object = this.c;
        Object object2 = CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP;
        if ((object = (StreamConfigurationMap)object.get((CameraCharacteristics.Key)object2)) == null) {
            d.v.d.h.f.a("no support size find");
            return;
        }
        d.v.d.h.f.a("reset support preview and photo size");
        int n10 = 256;
        object2 = Arrays.asList(object.getOutputSizes(n10));
        Object object3 = d.v.d.g.d.v.c.a;
        object2.sort(object3);
        this.f1().u((List)object2);
        object3 = this.f1().get();
        if (object3 == null) {
            object3 = this.f1();
            object2 = (Size)object2.get(0);
            ((d.v.d.i.e.f)object3).s((Size)object2);
        } else {
            object2 = this.f1();
            ((d.v.d.i.a.a)object2).d();
        }
        object = Arrays.asList(object.getOutputSizes(SurfaceTexture.class));
        object2 = e.a;
        object.sort(object2);
        object2 = this.H();
        object3 = (Size)this.K().get();
        ((t)object2).x((List)object, (Size)object3);
        object2 = (Size)this.f1().get();
        double d10 = (double)object2.getWidth() * 1.0;
        double d11 = object2.getHeight();
        n10 = this.K().n();
        t t10 = this.H();
        object = this.L0((List)object, d10 /= d11, n10);
        t10.v((Size)object);
    }

    private void B1() {
        Object object = this.c;
        Object object2 = CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES;
        object = (int[])object.get(object2);
        object2 = null;
        if (object == null) {
            d.v.d.h.f.a("wb is not support");
            this.l1().l(false);
            return;
        }
        Object object3 = this.l1();
        Object object4 = true;
        ((d.v.d.i.a.a)object3).l((boolean)object4);
        int n10 = ((CameraCharacteristics)object).length;
        for (int i10 = 0; i10 < n10; ++i10) {
            object4 = object[i10];
            if (object4 || !(object4 = this.c1())) continue;
            object = this.l1();
            i10 = 1000;
            object2 = i10;
            n10 = 15000;
            object3 = n10;
            ((d.v.d.i.a.a)object).c(object2, object3);
            break;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("reset wb=");
        object2 = this.l1().toString();
        ((StringBuilder)object).append((String)object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
    }

    private boolean C1() {
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

    private int D1() {
        Integer n10 = (Integer)this.E().get();
        int n11 = n10;
        int n12 = 270;
        int n13 = 180;
        int n14 = 90;
        if (n11 != 0) {
            if (n11 != n14) {
                if (n11 != n13) {
                    n12 = 0;
                }
            } else {
                n12 = n13;
            }
        } else {
            n12 = n14;
        }
        return n12;
    }

    public static /* synthetic */ h V0(i i10) {
        return i10.t;
    }

    public static /* synthetic */ void W0(i i10) {
        i10.g();
    }

    public static /* synthetic */ void X0(i i10) {
        i10.o0();
    }

    public static /* synthetic */ ImageReader Y0(i i10) {
        return i10.s;
    }

    public static /* synthetic */ ImageReader Z0(i i10, ImageReader imageReader) {
        i10.s = imageReader;
        return imageReader;
    }

    public static /* synthetic */ boolean a1(i i10) {
        return i10.C1();
    }

    private /* synthetic */ void b0(Integer n10, int n11) {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "preview iso change integer=";
        stringBuilder.append(string2);
        stringBuilder.append(n10);
        d.v.d.h.f.a(stringBuilder.toString());
        stringBuilder = this.u();
        if (stringBuilder == null) {
            return;
        }
        string2 = CaptureRequest.CONTROL_AE_MODE;
        Integer n12 = 0;
        stringBuilder.set((CaptureRequest.Key)string2, n12);
        string2 = CaptureRequest.SENSOR_SENSITIVITY;
        stringBuilder.set((CaptureRequest.Key)string2, n10);
        n10 = this.v();
        string2 = this.B();
        this.O0((CaptureRequest.Builder)stringBuilder, (CameraCaptureSession.CaptureCallback)n10, (Handler)string2);
    }

    public static /* synthetic */ int b1(i i10) {
        return i10.D1();
    }

    private boolean c1() {
        String string2 = Build.MODEL;
        Locale locale = Locale.US;
        return string2.toLowerCase(locale).contains("nexus 6") ^ true;
    }

    private /* synthetic */ void m1(Float f10, int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "preview af change aFloat=";
        stringBuilder.append(string2);
        stringBuilder.append(f10);
        d.v.d.h.f.a(stringBuilder.toString());
        stringBuilder = this.u();
        if (stringBuilder == null) {
            return;
        }
        string2 = CaptureRequest.CONTROL_AF_MODE;
        Integer n11 = 0;
        stringBuilder.set((CaptureRequest.Key)string2, n11);
        string2 = CaptureRequest.LENS_FOCUS_DISTANCE;
        stringBuilder.set((CaptureRequest.Key)string2, f10);
        f10 = this.v();
        string2 = this.B();
        this.O0((CaptureRequest.Builder)stringBuilder, (CameraCaptureSession.CaptureCallback)f10, (Handler)string2);
    }

    private /* synthetic */ void p1(Long l10, int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "preview sec change aLong=";
        stringBuilder.append(string2);
        stringBuilder.append(l10);
        d.v.d.h.f.a(stringBuilder.toString());
        stringBuilder = this.u();
        if (stringBuilder == null) {
            return;
        }
        string2 = CaptureRequest.CONTROL_AE_MODE;
        Integer n11 = 0;
        stringBuilder.set((CaptureRequest.Key)string2, n11);
        string2 = CaptureRequest.SENSOR_EXPOSURE_TIME;
        stringBuilder.set((CaptureRequest.Key)string2, l10);
        l10 = this.v();
        string2 = this.B();
        this.O0((CaptureRequest.Builder)stringBuilder, (CameraCaptureSession.CaptureCallback)l10, (Handler)string2);
    }

    private /* synthetic */ void r1(Integer n10, int n11) {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "preview wb change integer=";
        stringBuilder.append(string2);
        stringBuilder.append(n10);
        d.v.d.h.f.a(stringBuilder.toString());
        stringBuilder = this.u();
        if (stringBuilder == null) {
            return;
        }
        n10 = d.v.d.h.e.c(n10);
        string2 = CaptureRequest.CONTROL_AWB_MODE;
        Integer n12 = 0;
        stringBuilder.set((CaptureRequest.Key)string2, n12);
        string2 = CaptureRequest.COLOR_CORRECTION_MODE;
        Integer n13 = 0;
        stringBuilder.set((CaptureRequest.Key)string2, n13);
        string2 = CaptureRequest.COLOR_CORRECTION_GAINS;
        stringBuilder.set((CaptureRequest.Key)string2, n10);
        n10 = this.v();
        string2 = this.B();
        this.O0((CaptureRequest.Builder)stringBuilder, (CameraCaptureSession.CaptureCallback)n10, (Handler)string2);
    }

    public static /* synthetic */ int t1(Size size, Size size2) {
        int n10 = size2.getWidth();
        int n11 = size2.getHeight();
        n10 *= n11;
        n11 = size.getWidth();
        int n12 = size.getHeight();
        return n10 - (n11 *= n12);
    }

    public static /* synthetic */ int u1(Size size, Size size2) {
        int n10 = size2.getWidth();
        int n11 = size2.getHeight();
        n10 *= n11;
        n11 = size.getWidth();
        int n12 = size.getHeight();
        return n10 - (n11 *= n12);
    }

    private void v1(boolean bl2) {
        d.v.d.i.a.a a10 = this.d1();
        c$a c$a = this.u;
        this.b(bl2, a10, c$a);
        a10 = this.i1();
        c$a = this.v;
        this.b(bl2, a10, c$a);
        a10 = this.j1();
        c$a = this.w;
        this.b(bl2, a10, c$a);
        a10 = this.k1();
        c$a = this.x;
        this.b(bl2, a10, c$a);
        a10 = this.l1();
        c$a = this.y;
        this.b(bl2, a10, c$a);
    }

    private void w1(boolean bl2) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("add photo size listener add=");
        ((StringBuilder)object).append(bl2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.f1();
        c$a c$a = this.z;
        this.b(bl2, (d.v.d.i.a.a)object, c$a);
    }

    private void x1() {
        Object object = this.c;
        Object object2 = CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE;
        if ((object = (Float)object.get((CameraCharacteristics.Key)object2)) == null) {
            object = this.i1();
            object2 = null;
            ((d.v.d.i.a.a)object).l(false);
        } else {
            this.i1().l(true);
            object2 = this.i1();
            Float f10 = Float.valueOf(0.0f);
            ((d.v.d.i.a.a)object2).c(f10, object);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("reset af=");
        object2 = this.i1().toString();
        ((StringBuilder)object).append((String)object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
    }

    private void y1() {
        Object object = this.c;
        Object object2 = CameraCharacteristics.SENSOR_INFO_SENSITIVITY_RANGE;
        if ((object = (Range)object.get((CameraCharacteristics.Key)object2)) == null) {
            object = this.j1();
            object2 = null;
            ((d.v.d.i.a.a)object).l(false);
        } else {
            object2 = this.j1();
            boolean bl2 = true;
            ((d.v.d.i.a.a)object2).l(bl2);
            object2 = this.j1();
            Comparable comparable = object.getLower();
            object = object.getUpper();
            ((d.v.d.i.a.a)object2).c(comparable, object);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("reset iso=");
        object2 = this.j1().toString();
        ((StringBuilder)object).append((String)object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
    }

    private void z1() {
        Object object = this.c;
        Object object2 = CameraCharacteristics.SENSOR_INFO_EXPOSURE_TIME_RANGE;
        if ((object = (Range)object.get((CameraCharacteristics.Key)object2)) == null) {
            object = this.k1();
            object2 = null;
            ((d.v.d.i.a.a)object).l(false);
        } else {
            object2 = this.k1();
            boolean bl2 = true;
            ((d.v.d.i.a.a)object2).l(bl2);
            object2 = this.k1();
            Comparable comparable = object.getLower();
            object = object.getUpper();
            ((d.v.d.i.a.a)object2).c(comparable, object);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("reset sec=");
        object2 = this.k1().toString();
        ((StringBuilder)object).append((String)object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
    }

    public void F0(boolean bl2) {
        this.w1(bl2);
        this.v1(bl2);
    }

    public void G0() {
        this.x1();
        this.y1();
        this.z1();
        this.B1();
        this.A1();
    }

    public a d1() {
        return this.a.j0();
    }

    public d.v.d.i.e.b e1() {
        return this.a.k0();
    }

    public d.v.d.i.e.f f1() {
        return this.a.m0();
    }

    public d.v.d.i.e.g g1() {
        return this.a.n0();
    }

    public Surface h1() {
        ImageReader imageReader = this.s;
        if (imageReader == null) {
            return null;
        }
        return imageReader.getSurface();
    }

    public d.v.d.i.f.f i1() {
        return this.a.q0();
    }

    public m j1() {
        return this.a.x0();
    }

    public r k1() {
        return this.a.B0();
    }

    public x l1() {
        return this.a.H0();
    }

    public /* synthetic */ void n1(Float f10, int n10) {
        this.m1(f10, n10);
    }

    public /* synthetic */ void o1(Integer n10, int n11) {
        this.b0(n10, n11);
    }

    public /* synthetic */ void q1(Long l10, int n10) {
        this.p1(l10, n10);
    }

    public /* synthetic */ void s1(Integer n10, int n11) {
        this.r1(n10, n11);
    }

    public void z0() {
        d.v.d.h.f.a("release source");
    }
}

