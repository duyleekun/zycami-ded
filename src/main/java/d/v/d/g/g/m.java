/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Point
 *  android.graphics.Rect
 *  android.hardware.camera2.CameraCharacteristics
 *  android.hardware.camera2.CameraCharacteristics$Key
 *  android.hardware.camera2.CaptureRequest$Key
 *  android.media.ImageReader
 *  android.media.ImageReader$OnImageAvailableListener
 *  android.os.Handler
 *  android.util.Size
 *  android.util.SparseIntArray
 *  android.view.Surface
 */
package d.v.d.g.g;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.media.ImageReader;
import android.os.Handler;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.Surface;
import com.huawei.camera.camerakit.CameraInfo;
import com.huawei.camera.camerakit.CameraKit;
import com.huawei.camera.camerakit.Mode;
import com.huawei.camera.camerakit.ModeCharacteristics;
import com.huawei.camera.camerakit.ModeConfig$Builder;
import com.huawei.camera.camerakit.RequestKey;
import d.v.d.g.g.a;
import d.v.d.g.g.b;
import d.v.d.g.g.c;
import d.v.d.g.g.d;
import d.v.d.g.g.e;
import d.v.d.g.g.f;
import d.v.d.g.g.g;
import d.v.d.g.g.h;
import d.v.d.g.g.i;
import d.v.d.g.g.j;
import d.v.d.g.g.k;
import d.v.d.g.g.l;
import d.v.d.i.a.c$a;
import d.v.d.i.f.a0;
import d.v.d.i.f.n;
import d.v.d.i.f.o;
import d.v.d.i.f.q;
import d.v.d.i.f.t;
import d.v.d.i.f.u;
import d.v.d.i.f.w;
import d.v.d.i.f.y;
import d.v.d.i.f.z;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class m {
    public static final int q = 500;
    public final d.v.d.e a;
    public final l b;
    public ModeCharacteristics c;
    public ImageReader d;
    public SparseIntArray e;
    private final c$a f;
    private final c$a g;
    private final ImageReader.OnImageAvailableListener h;
    private final c$a i;
    private final c$a j;
    private final c$a k;
    private final c$a l;
    private final c$a m;
    private final c$a n;
    private boolean o;
    public final c$a p;

    public m(l l10, d.v.d.e e10, Context context) {
        Object object = new f(this);
        this.f = object;
        super(this);
        this.g = object;
        object = new g(this);
        this.h = object;
        this.i = object = new b(this);
        this.j = object = new e(this);
        this.k = object = new h(this);
        this.l = object = new d(this);
        this.m = object = new c(this);
        this.n = object = new i(this);
        this.p = object = new a(this);
        this.b = l10;
        this.a = e10;
        this.G(context);
        this.F();
        this.r0(true);
    }

    private void B0() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("update Wt=,getPreviewStatus=");
        u u10 = this.x();
        ((StringBuilder)object).append(u10);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.b.a;
        if (object == null) {
            d.v.d.h.f.a("current is mMode==null, return");
            return;
        }
        object = this.x();
        boolean bl2 = ((u)object).o();
        if (!bl2) {
            d.v.d.h.f.a("current is not preview ing, return");
            return;
        }
        object = this.b.a;
        float f10 = ((Float)this.B().get()).floatValue();
        ((Mode)object).setZoom(f10);
    }

    private void F() {
        SparseIntArray sparseIntArray;
        this.e = sparseIntArray = new SparseIntArray(4);
        int n10 = 2;
        sparseIntArray.append(0, n10);
        sparseIntArray = this.e;
        int n11 = 1;
        sparseIntArray.append(n11, 0);
        this.e.append(n10, n11);
        sparseIntArray = this.e;
        int n12 = 3;
        sparseIntArray.append(n12, n12);
    }

    private void G(Context object) {
        object = CameraKit.getInstance(object.getApplicationContext());
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ArrayList<Object> arrayList2 = new ArrayList<Object>();
        for (String string2 : ((CameraKit)object).getCameraIdList()) {
            CameraInfo cameraInfo = ((CameraKit)object).getCameraInfo(string2);
            int n10 = cameraInfo.getFacingType();
            Object object2 = new StringBuilder();
            ((StringBuilder)object2).append("camera id  =");
            ((StringBuilder)object2).append(string2);
            String string3 = ",face=";
            ((StringBuilder)object2).append(string3);
            ((StringBuilder)object2).append(n10);
            object2 = ((StringBuilder)object2).toString();
            d.v.d.h.f.a((String)object2);
            int n11 = 1;
            if (n10 == n11) {
                object2 = Integer.valueOf(string2);
                arrayList2.add(object2);
            }
            if (n10 != 0) continue;
            Integer n12 = Integer.valueOf(string2);
            arrayList.add(n12);
        }
        this.s().A(arrayList, arrayList2);
    }

    private /* synthetic */ void H(Integer object, int n10) {
        Comparable<StringBuilder> comparable = new StringBuilder();
        comparable.append("id change id=");
        comparable.append(object);
        d.v.d.h.f.a(comparable.toString());
        this.c();
        this.Z();
        object = this.E();
        comparable = 3;
        ((d.v.d.i.b.e)object).n((Integer)comparable);
    }

    private /* synthetic */ void J(ImageReader imageReader) {
        d.v.d.i.a.a a10 = this.x();
        boolean bl2 = ((u)a10).o();
        if (bl2) {
            a10 = this.o();
            ((d.v.d.i.f.g)a10).n(imageReader);
        }
    }

    private /* synthetic */ void L(Point point, int n10) {
        n10 = point.x;
        int n11 = point.y;
        this.d(n10, n11);
    }

    private /* synthetic */ void N(Integer n10, int n11) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("focus observer change value=");
        ((StringBuilder)object).append(n10);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.n();
        int n12 = n10;
        this.z0((ModeConfig$Builder)object, n12);
    }

    private /* synthetic */ void P(Float f10, int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("wt notify wtValue=");
        stringBuilder.append(f10);
        d.v.d.h.f.a(stringBuilder.toString());
        this.B0();
    }

    private /* synthetic */ void R(Integer n10, int n11) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ae notify aeValue=");
        stringBuilder.append(n10);
        d.v.d.h.f.a(stringBuilder.toString());
        this.w0();
    }

    private /* synthetic */ void T(Integer n10, int n11) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("wb type observer value=");
        stringBuilder.append(n10);
        d.v.d.h.f.a(stringBuilder.toString());
        this.A0();
    }

    private /* synthetic */ void V(List list, int n10) {
        boolean bl2 = this.p().j();
        this.x0(bl2);
    }

    private /* synthetic */ void X(Integer n10, int n11) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("flash observer value=");
        stringBuilder.append(n10);
        d.v.d.h.f.a(stringBuilder.toString());
        this.y0();
    }

    public static /* synthetic */ ImageReader.OnImageAvailableListener a(m m10) {
        return m10.h;
    }

    private void a0(boolean bl2) {
        d.v.d.i.f.e e10 = this.m();
        c$a c$a = this.l;
        this.b(bl2, e10, c$a);
    }

    private void b0(boolean bl2) {
        d.v.d.i.f.h h10 = this.p();
        c$a c$a = this.n;
        this.b(bl2, h10, c$a);
    }

    private void d(int n10, int n11) {
        w w10 = this.z();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("focus region x=");
        charSequence.append(n10);
        charSequence.append(",y=");
        charSequence.append(n11);
        charSequence.append(",getPreviewStatus=");
        u u10 = this.x();
        charSequence.append(u10);
        charSequence = charSequence.toString();
        d.v.d.h.f.a((String)charSequence);
        float f10 = n10;
        float f11 = w10.o();
        float f12 = 2000.0f;
        f11 = f12 / f11;
        f10 *= f11;
        f11 = 1000.0f;
        n10 = (int)(f10 -= f11);
        float f13 = n11;
        float f14 = w10.n();
        f13 = f13 * (f12 /= f14) - f11;
        n11 = (int)f13;
        int n12 = n10 + -500;
        int n13 = -1000;
        f11 = 0.0f / 0.0f;
        n12 = Math.max(n12, n13);
        n10 += 500;
        int n14 = 1000;
        f12 = 1.401E-42f;
        n10 = Math.min(n10, n14);
        int n15 = n11 + -500;
        n13 = Math.max(n15, n13);
        n11 = Math.min(n11 + 500, n14);
        u10 = new Rect(n12, n13, n10, n11);
        Object object = this.b.a;
        if (object == null) {
            d.v.d.h.f.a("current is mMode==null, return");
            return;
        }
        object = this.x();
        n10 = (int)(((u)object).o() ? 1 : 0);
        if (n10 == 0) {
            d.v.d.h.f.a("current is not preview ing, return");
            return;
        }
        this.b.a.setFocus(2, (Rect)u10);
    }

    private void d0(boolean bl2) {
        d.v.d.i.f.j j10 = this.r();
        c$a c$a = this.j;
        this.b(bl2, j10, c$a);
    }

    private void e0(boolean bl2) {
        d.v.d.i.f.l l10 = this.s();
        c$a c$a = this.f;
        this.b(bl2, l10, c$a);
    }

    private void f0(boolean bl2) {
        q q10 = this.v();
        c$a c$a = this.i;
        this.b(bl2, q10, c$a);
    }

    private Size g(double d10, List object) {
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "getClosestSize targetRatio=";
        stringBuilder.append(string2);
        stringBuilder.append(d10);
        d.v.d.h.f.a(stringBuilder.toString());
        object = object.iterator();
        stringBuilder = null;
        double d11 = Double.MAX_VALUE;
        while (bl2 = object.hasNext()) {
            double d12;
            Size size = (Size)object.next();
            int n10 = size.getWidth();
            double d13 = n10;
            double d14 = size.getHeight();
            double d15 = (d14 = Math.abs(d13 = d13 / d14 - d10)) - d11;
            Object object2 = d15 == 0.0 ? 0 : (d15 < 0.0 ? -1 : 1);
            if (object2 >= 0) continue;
            d11 = d12 = Math.abs(d13);
            stringBuilder = size;
        }
        return stringBuilder;
    }

    private void g0(boolean bl2) {
        t t10 = this.w();
        c$a c$a = this.g;
        this.b(bl2, t10, c$a);
    }

    private void h0(boolean bl2) {
        y y10 = this.A();
        c$a c$a = this.m;
        this.b(bl2, y10, c$a);
    }

    private void i0(boolean bl2) {
        z z10 = this.B();
        c$a c$a = this.k;
        this.b(bl2, z10, c$a);
    }

    private void l0() {
        Object object = this.c;
        Object object2 = RequestKey.HW_EXPOSURE_COMPENSATION_VALUE;
        object = ((ModeCharacteristics)object).getParameterRange((CaptureRequest.Key)object2);
        int n10 = object.size();
        int n11 = 0;
        Integer n12 = null;
        if (n10 == 0) {
            object = this.m();
            ((d.v.d.i.a.a)object).l(false);
        } else {
            Collections.sort(object);
            object2 = this.m();
            int n13 = 1;
            ((d.v.d.i.a.a)object2).l(n13 != 0);
            object2 = this.m();
            n11 = ((Float)object.get(0)).intValue();
            n12 = n11;
            int n14 = object.size() - n13;
            int n15 = ((Float)object.get(n14)).intValue();
            object = n15;
            ((d.v.d.i.a.a)object2).c(n12, object);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("reset ae=");
        object2 = this.m().toString();
        ((StringBuilder)object).append((String)object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
    }

    private void m0() {
        Object object = this.c;
        Object object2 = CameraCharacteristics.SENSOR_ORIENTATION;
        int n10 = (Integer)((ModeCharacteristics)object).get((CameraCharacteristics.Key)object2);
        object2 = this.h();
        object = n10;
        ((d.v.d.i.c.a)object2).n((Integer)object);
        object = new StringBuilder();
        ((StringBuilder)object).append("reset device orientation =");
        object2 = this.h().toString();
        ((StringBuilder)object).append((String)object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
    }

    private ModeConfig$Builder n() {
        return this.b.d;
    }

    private void n0() {
        Object object = this.c.getSupportedFlashMode();
        int n10 = ((int[])object).length;
        if (n10 == 0) {
            this.q().l(false);
            return;
        }
        this.q().l(true);
        Object object2 = new ArrayList();
        for (int n11 : object) {
            SparseIntArray sparseIntArray = this.e;
            n11 = sparseIntArray.get(n11);
            Integer n12 = n11;
            object2.add(n12);
        }
        this.q().t((List)object2);
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("reset flash:");
        object2 = this.q().toString();
        ((StringBuilder)object).append((String)object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
    }

    private void o0() {
        Object object;
        int n10;
        int n11;
        Object object2 = this.c.getSupportedAutoFocus();
        int n12 = ((int[])object2).length;
        boolean n13 = false;
        Integer n14 = null;
        for (n11 = 0; n11 < n12; ++n11) {
            n10 = object2[n11];
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "reset auto focus ";
            stringBuilder.append(string2);
            stringBuilder.append(n10);
            String string3 = stringBuilder.toString();
            d.v.d.h.f.a(string3);
        }
        if (object2 == null) {
            object2 = this.r();
            ((d.v.d.i.a.a)object2).l(false);
        } else {
            object = this.r();
            n11 = 1;
            ((d.v.d.i.a.a)object).l(n11 != 0);
            object = this.r();
            Object object3 = object2[0];
            n14 = (int)object3;
            n10 = ((Object)object2).length - n11;
            Object object4 = object2[n10];
            object2 = (int)object4;
            ((d.v.d.i.a.a)object).c(n14, object2);
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("reset auto focus:");
        object = this.r().toString();
        ((StringBuilder)object2).append((String)object);
        d.v.d.h.f.a(((StringBuilder)object2).toString());
    }

    private void s0() {
        Serializable serializable = new ArrayList();
        Object object = this.c.getSupportedColorMode();
        d.v.d.i.a.a a10 = this.A();
        int n10 = ((int[])object).length;
        int n11 = 1;
        n10 = n10 > 0 ? n11 : 0;
        a10.l(n10 != 0);
        for (int n12 : object) {
            Integer n13;
            if (n12 != 0) {
                int n14 = 2;
                if (n12 != n11) {
                    if (n12 != n14) continue;
                    n13 = n11;
                    serializable.add(n13);
                    continue;
                }
                n13 = n14;
                serializable.add(n13);
                continue;
            }
            n13 = 0;
            serializable.add(n13);
        }
        object = this.A();
        a10 = this.s();
        ((y)object).r((List)((Object)serializable), (d.v.d.i.f.l)a10);
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append("reset wb type:");
        object = this.A().toString();
        ((StringBuilder)serializable).append((String)object);
        d.v.d.h.f.a(((StringBuilder)serializable).toString());
    }

    private void t0() {
        Object object = this.c.getSupportedZoom();
        Object object2 = 0.0f;
        Object object3 = null;
        if (object == null) {
            this.B().l(false);
            object = this.C();
            ((d.v.d.i.a.a)object).l(false);
        } else {
            d.v.d.i.a.a a10 = this.B();
            int n10 = 1;
            a10.l(n10 != 0);
            a10 = this.B();
            Object object4 = object[0];
            Float f10 = Float.valueOf((float)object4);
            int n11 = ((Object)object).length - n10;
            Object object5 = object[n11];
            Float f11 = Float.valueOf((float)object5);
            float f12 = 1.0f;
            ((z)a10).z(f10, f11, f12);
            a10 = this.C();
            object2 = object[0];
            object3 = Float.valueOf(object2);
            int n12 = ((Object)object).length - n10;
            Object object6 = object[n12];
            object = Float.valueOf((float)object6);
            ((a0)a10).x((Float)object3, (Float)object);
            object = this.C();
            ((d.v.d.i.a.a)object).l(n10 != 0);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("reset wt:");
        object3 = this.B().toString();
        ((StringBuilder)object).append((String)object3);
        d.v.d.h.f.a(((StringBuilder)object).toString());
    }

    private void w0() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("update ae=,getPreviewStatus=");
        u u10 = this.x();
        ((StringBuilder)object).append(u10);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.b.a;
        if (object == null) {
            d.v.d.h.f.a("current is mMode==null, return");
            return;
        }
        object = this.x();
        boolean bl2 = ((u)object).o();
        if (!bl2) {
            d.v.d.h.f.a("current is not preview ing, return");
            return;
        }
        object = this.b.a;
        u10 = RequestKey.HW_EXPOSURE_COMPENSATION_VALUE;
        Float f10 = Float.valueOf((float)((Integer)this.m().get()).intValue() * 1.0f);
        ((Mode)object).setParameter((CaptureRequest.Key)u10, f10);
    }

    private void x0(boolean bl2) {
        boolean bl3 = this.o;
        if (bl3 == bl2) {
            return;
        }
        Object object = this.b.a;
        if (object == null) {
            d.v.d.h.f.a("current is mMode==null, return");
            return;
        }
        object = this.x();
        bl3 = ((u)object).o();
        if (!bl3) {
            d.v.d.h.f.a("current is not preview ing, return");
            return;
        }
        this.o = bl2;
        this.b.a.setFaceDetection(1, bl2);
    }

    private void z0(ModeConfig$Builder object, int n10) {
        block1: {
            block5: {
                int n11;
                block2: {
                    block3: {
                        block4: {
                            if (object == null || (object = this.b.a) == null) break block1;
                            object = this.x();
                            boolean n112 = ((u)object).o();
                            if (!n112) {
                                d.v.d.h.f.a("current is not preview ing, return");
                                return;
                            }
                            n11 = 1;
                            if (n10 == n11) break block2;
                            int n12 = 2;
                            if (n10 == n12) break block3;
                            n12 = 5;
                            if (n10 == n12) break block4;
                            n12 = 6;
                            if (n10 == n12) break block2;
                            break block5;
                        }
                        object = this.b.a;
                        n10 = 3;
                        ((Mode)object).setFocus(n10, null);
                        break block5;
                    }
                    object = this.b.a;
                    n10 = 0;
                    Object mode = null;
                    ((Mode)object).setFocus(0, null);
                    break block5;
                }
                Mode mode = this.b.a;
                mode.setFocus(n11, null);
            }
            return;
        }
        d.v.d.h.f.a("current is build=null or mMode=null ,return");
    }

    public y A() {
        return this.a.I0();
    }

    public void A0() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("update wb type=,getPreviewStatus=");
        u u10 = this.x();
        ((StringBuilder)object).append(u10);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.b.a;
        if (object == null) {
            d.v.d.h.f.a("current is mMode==null, return");
            return;
        }
        object = this.x();
        boolean bl2 = ((u)object).o();
        if (!bl2) {
            d.v.d.h.f.a("current is not preview ing, return");
            return;
        }
        object = this.b.a;
        int n10 = (Integer)this.A().get() + -1;
        ((Mode)object).setColorMode(n10);
    }

    public z B() {
        return this.a.J0();
    }

    public a0 C() {
        return this.a.K0();
    }

    public d.v.d.i.b.d D() {
        return this.a.Y0();
    }

    public d.v.d.i.b.e E() {
        return this.a.Z0();
    }

    public /* synthetic */ void I(Integer n10, int n11) {
        this.H(n10, n11);
    }

    public /* synthetic */ void K(ImageReader imageReader) {
        this.J(imageReader);
    }

    public /* synthetic */ void M(Point point, int n10) {
        this.L(point, n10);
    }

    public /* synthetic */ void O(Integer n10, int n11) {
        this.N(n10, n11);
    }

    public /* synthetic */ void Q(Float f10, int n10) {
        this.P(f10, n10);
    }

    public /* synthetic */ void S(Integer n10, int n11) {
        this.R(n10, n11);
    }

    public /* synthetic */ void U(Integer n10, int n11) {
        this.T(n10, n11);
    }

    public /* synthetic */ void W(List list, int n10) {
        this.V(list, n10);
    }

    public /* synthetic */ void Y(Integer n10, int n11) {
        this.X(n10, n11);
    }

    public void Z() {
        Handler handler = this.l();
        l l10 = this.b;
        l10.getClass();
        j j10 = new j(l10);
        handler.post((Runnable)j10);
    }

    public void b(boolean bl2, d.v.d.i.a.a a10, c$a c$a) {
        if (bl2) {
            a10.g(c$a);
        } else {
            a10.a(c$a);
        }
    }

    public void c() {
        Handler handler = this.l();
        l l10 = this.b;
        l10.getClass();
        k k10 = new k(l10);
        handler.post((Runnable)k10);
    }

    public void c0(boolean bl2) {
        d.v.d.i.f.i i10 = this.q();
        c$a c$a = this.p;
        this.b(bl2, i10, c$a);
    }

    public Surface e() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("get analysis mAnalysisImageReader=");
        ImageReader imageReader = this.d;
        stringBuilder.append(imageReader);
        d.v.d.h.f.a(stringBuilder.toString());
        stringBuilder = this.d;
        if (stringBuilder == null) {
            return null;
        }
        return stringBuilder.getSurface();
    }

    public Handler f() {
        return this.a.d0();
    }

    public d.v.d.i.c.a h() {
        return this.a.e0();
    }

    public d.v.d.i.c.c i() {
        return this.a.f0();
    }

    public d.v.d.i.d.c j() {
        return this.a.g0();
    }

    public void j0() {
        d.v.d.h.f.a("release--source");
        this.r0(false);
        this.p0(false);
        this.k0();
    }

    public int k() {
        Integer n10 = (Integer)this.h().get();
        int n11 = n10;
        Comparable<Integer> comparable = (Integer)this.u().get();
        int n12 = (Integer)comparable;
        d.v.d.i.f.l l10 = this.s();
        int n13 = l10.s();
        n13 = n13 != 0 ? -1 : 1;
        n11 = (n11 + (n12 *= n13) + 360) % 360;
        comparable = new Comparable<Integer>();
        ((StringBuilder)comparable).append("get orientation final =");
        ((StringBuilder)comparable).append(n11);
        d.v.d.h.f.a(((StringBuilder)comparable).toString());
        return n11;
    }

    public abstract void k0();

    public Handler l() {
        return this.a.i0();
    }

    public d.v.d.i.f.e m() {
        return this.a.p0();
    }

    public d.v.d.i.f.g o() {
        return this.a.r0();
    }

    public d.v.d.i.f.h p() {
        return this.a.s0();
    }

    public abstract void p0(boolean var1);

    public d.v.d.i.f.i q() {
        return this.a.t0();
    }

    public abstract void q0();

    public d.v.d.i.f.j r() {
        return this.a.u0();
    }

    public void r0(boolean bl2) {
        this.a0(bl2);
        this.e0(bl2);
        this.i0(bl2);
        this.g0(bl2);
        this.f0(bl2);
        this.b0(bl2);
        this.c0(bl2);
        this.d0(bl2);
        this.h0(bl2);
    }

    public d.v.d.i.f.l s() {
        return this.a.w0();
    }

    public n t() {
        return this.a.y0();
    }

    public o u() {
        return this.a.z0();
    }

    public Size u0(List object, Size size) {
        boolean bl2;
        int n10 = size.getWidth();
        double d10 = (double)n10 * 1.0;
        int n11 = size.getHeight();
        double d11 = n11;
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("select optimal preview size targetRatio =");
        ((StringBuilder)object2).append(d10 /= d11);
        d.v.d.h.f.a(((StringBuilder)object2).toString());
        object2 = object.iterator();
        int n12 = 0;
        Size size2 = null;
        double d12 = Double.MAX_VALUE;
        while (bl2 = object2.hasNext()) {
            int n13;
            Size size3 = (Size)object2.next();
            double d13 = size3.getWidth();
            int n14 = size3.getHeight();
            double d14 = n14;
            double d15 = (d13 = Math.abs(d13 / d14 - d10)) - (d14 = 0.05);
            Object object3 = d15 == 0.0 ? 0 : (d15 > 0.0 ? 1 : -1);
            if (object3 > 0 || (object3 = (Object)size3.getHeight()) < (n13 = size.getHeight())) continue;
            object3 = size3.getHeight();
            n13 = size.getHeight();
            d13 = object3 - n13;
            double d16 = d13 - d12;
            if ((object3 = d16 == 0.0 ? 0 : (d16 < 0.0 ? -1 : 1)) >= 0) continue;
            n12 = size3.getHeight();
            int n15 = size.getHeight();
            n12 = Math.abs(n12 - n15);
            double d17 = n12;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("supported optimalSize=");
            charSequence.append(size3);
            String string2 = ", minDiff=";
            charSequence.append(string2);
            charSequence.append(d17);
            charSequence = charSequence.toString();
            d.v.d.h.f.a((String)charSequence);
            d12 = d17;
            size2 = size3;
        }
        if (size2 == null) {
            size2 = this.g(d10, (List)object);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(" calculationSize final preview size: ");
        ((StringBuilder)object).append(size2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        return size2;
    }

    public q v() {
        return this.a.A0();
    }

    public void v0(ModeCharacteristics modeCharacteristics) {
        this.c = modeCharacteristics;
        this.l0();
        this.t0();
        this.n0();
        this.o0();
        this.s0();
        this.m0();
        this.q0();
    }

    public t w() {
        return this.a.D0();
    }

    public u x() {
        return this.a.E0();
    }

    public Surface y() {
        d.v.d.h.f.a("get preview surface");
        return this.t().p();
    }

    public void y0() {
        d.v.d.h.f.a("update flash mode ");
        Object object = this.b.a;
        if (object == null) {
            d.v.d.h.f.a("current is mMode==null, return");
            return;
        }
        object = this.x();
        boolean bl2 = ((u)object).o();
        if (!bl2) {
            d.v.d.h.f.a("current is not preview ing, return");
            return;
        }
        object = this.b.a;
        SparseIntArray sparseIntArray = this.e;
        int n10 = (Integer)this.q().get();
        int n11 = sparseIntArray.indexOfValue(n10);
        ((Mode)object).setFlashMode(n11);
    }

    public w z() {
        return this.a.G0();
    }
}

