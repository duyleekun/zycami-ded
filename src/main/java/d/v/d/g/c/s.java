/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Point
 *  android.graphics.Rect
 *  android.hardware.Camera
 *  android.hardware.Camera$Area
 *  android.hardware.Camera$AutoFocusCallback
 *  android.hardware.Camera$CameraInfo
 *  android.hardware.Camera$Parameters
 *  android.os.Handler
 *  android.util.Range
 *  android.util.Size
 *  android.view.Surface
 */
package d.v.d.g.c;

import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.collection.SparseArrayCompat;
import d.v.d.g.c.a;
import d.v.d.g.c.e;
import d.v.d.g.c.i;
import d.v.d.g.c.j;
import d.v.d.g.c.l;
import d.v.d.g.c.n;
import d.v.d.g.c.q;
import d.v.d.g.c.r;
import d.v.d.h.f;
import d.v.d.i.a.c$a;
import d.v.d.i.b.b;
import d.v.d.i.b.d;
import d.v.d.i.d.c;
import d.v.d.i.f.a0;
import d.v.d.i.f.g;
import d.v.d.i.f.h;
import d.v.d.i.f.k;
import d.v.d.i.f.o;
import d.v.d.i.f.t;
import d.v.d.i.f.u;
import d.v.d.i.f.v;
import d.v.d.i.f.w;
import d.v.d.i.f.y;
import d.v.d.i.f.z;
import java.util.ArrayList;
import java.util.List;

public abstract class s {
    public static final SparseArrayCompat p;
    public final d.v.d.e a;
    public r b;
    public Camera.Parameters c;
    public List d;
    private final c$a e;
    private int f;
    private final c$a g;
    private final c$a h;
    private final c$a i;
    private int j;
    private final c$a k;
    private final c$a l;
    private final c$a m;
    private final c$a n;
    private final c$a o;

    static {
        SparseArrayCompat sparseArrayCompat;
        p = sparseArrayCompat = new SparseArrayCompat();
        sparseArrayCompat.put(0, "off");
        sparseArrayCompat.put(1, "on");
        sparseArrayCompat.put(3, "torch");
        sparseArrayCompat.put(2, "auto");
    }

    public s(d.v.d.e e10, r r10) {
        c$a c$a = new n(this);
        this.e = c$a;
        super(this);
        this.g = c$a;
        super(this);
        this.h = c$a;
        super(this);
        this.i = c$a;
        super(this);
        this.k = c$a;
        super(this);
        this.l = c$a;
        super(this);
        this.m = c$a;
        super(this);
        this.n = c$a;
        super(this);
        this.o = c$a;
        this.a = e10;
        this.b = r10;
        this.N();
        this.E0(true);
    }

    private void A0() {
        List list = this.c.getSupportedFocusModes();
        ArrayList<Object> arrayList = d.v.d.g.c.l.a;
        list.forEach(arrayList);
        arrayList = new ArrayList<Object>();
        Object object = "continuous-picture";
        int n10 = list.contains(object);
        boolean bl2 = true;
        if (n10 != 0) {
            object = (int)(bl2 ? 1 : 0);
            arrayList.add(object);
        }
        if ((n10 = list.contains(object = "auto")) != 0) {
            object = 2;
            arrayList.add(object);
            object = 3;
            arrayList.add(object);
            object = 4;
            arrayList.add(object);
            object = 5;
            arrayList.add(object);
            n10 = 6;
            object = n10;
            arrayList.add(object);
        }
        object = this.u();
        if (list == null) {
            bl2 = false;
        }
        ((d.v.d.i.a.a)object).l(bl2);
        this.u().p(arrayList);
    }

    private void B0() {
        Object object;
        Object object2 = this.c.getSupportedPreviewFpsRange();
        if (object2 == null) {
            object2 = this.v();
            boolean bl2 = false;
            object = null;
            ((d.v.d.i.a.a)object2).l(false);
        } else {
            object = this.v();
            int n10 = 1;
            ((d.v.d.i.a.a)object).l(n10 != 0);
            int n11 = object2.size() - n10;
            object2 = (int[])object2.get(n11);
            object = this.v();
            Integer n12 = n10;
            reference var6_7 = object2[n10] / 1000;
            object2 = (int)var6_7;
            ((d.v.d.i.a.a)object).c(n12, object2);
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("reset preview fps=");
        object = this.v().toString();
        ((StringBuilder)object2).append((String)object);
        d.v.d.h.f.a(((StringBuilder)object2).toString());
    }

    private void E0(boolean bl2) {
        this.m0(bl2);
        this.u0(bl2);
        this.o0(bl2);
        this.s0(bl2);
        this.p0(bl2);
        this.q0(bl2);
        this.t0(bl2);
        this.r0(bl2);
        this.n0(bl2);
    }

    private void F0() {
        Handler handler = this.o();
        j j10 = new j(this);
        handler.postDelayed((Runnable)j10, 2000L);
    }

    private void G0() {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Object object = this.c.getSupportedWhiteBalance();
        d.v.d.i.f.l l10 = null;
        if (object == null) {
            object = this.F();
            ((d.v.d.i.a.a)object).l(false);
        } else {
            int n10;
            Object object2 = this.F();
            boolean bl2 = true;
            ((d.v.d.i.a.a)object2).l(bl2);
            for (int i10 = 0; i10 <= (n10 = 4); ++i10) {
                object2 = this.L(i10);
                n10 = (int)(object.contains(object2) ? 1 : 0);
                if (n10 == 0) continue;
                object2 = i10;
                arrayList.add(object2);
            }
        }
        object = this.F();
        l10 = this.w();
        ((y)object).r(arrayList, l10);
        object = new StringBuilder();
        ((StringBuilder)object).append("reset wb type");
        int n11 = arrayList.size();
        ((StringBuilder)object).append(n11);
        d.v.d.h.f.a(((StringBuilder)object).toString());
    }

    private void H0() {
        int n10 = this.c.getMaxZoom();
        Object object = this.c.getZoomRatios();
        this.d = object;
        Integer n11 = (Integer)object.get(n10);
        n10 = n11;
        float f10 = n10;
        float f11 = 1.0f;
        Float f12 = Float.valueOf(f11);
        f10 = f10 * f11 / 100.0f;
        float f13 = 10.0f;
        float f14 = (f10 = Math.min(f10, f13)) - f11;
        Object object2 = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
        if (object2 > 0) {
            Object object3 = this.G();
            boolean bl2 = true;
            ((d.v.d.i.a.a)object3).l(bl2);
            object3 = this.G();
            Float f15 = Float.valueOf(f10);
            ((z)object3).z(f12, f15, f11);
            this.H().l(bl2);
            object = this.H();
            object3 = Float.valueOf(f10);
            ((a0)object).x(f12, (Float)object3);
        } else {
            object = this.G();
            f12 = null;
            ((d.v.d.i.a.a)object).l(false);
            object = this.H();
            ((d.v.d.i.a.a)object).l(false);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("reset wt maxValue=");
        ((StringBuilder)object).append(f10);
        d.v.d.h.f.a(((StringBuilder)object).toString());
    }

    private int I(float f10) {
        Camera.Parameters parameters = this.c;
        int n10 = parameters.getMaxZoom();
        float f11 = 100.0f * f10;
        int n11 = (int)f11;
        float f12 = 1.0f;
        float f13 = f10 == f12 ? 0 : (f10 < f12 ? -1 : 1);
        int n12 = 0;
        if (f13 <= 0) {
            return 0;
        }
        Number number = (Float)this.G().f();
        f12 = ((Float)number).floatValue();
        float f14 = f10 - f12;
        Object object = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
        if (object >= 0) {
            return n10;
        }
        f10 = 0.0f;
        for (object = (Object)false; object <= n10; ++object) {
            number = (Integer)this.d.get((int)object);
            f13 = ((Integer)number).intValue();
            if (f13 < n11) continue;
            n12 = (int)object;
            break;
        }
        return n12;
    }

    private void N() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int n10 = Camera.getNumberOfCameras();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        ArrayList<Object> arrayList2 = new ArrayList<Object>();
        for (int i10 = 0; i10 < n10; ++i10) {
            Camera.getCameraInfo((int)i10, (Camera.CameraInfo)cameraInfo);
            Object object = new StringBuilder();
            ((StringBuilder)object).append("camera id =");
            ((StringBuilder)object).append(i10);
            String string2 = ",face=";
            ((StringBuilder)object).append(string2);
            int n11 = cameraInfo.facing;
            ((StringBuilder)object).append(n11);
            object = ((StringBuilder)object).toString();
            d.v.d.h.f.a((String)object);
            int n12 = cameraInfo.facing;
            if (n12 == 0) {
                object = i10;
                arrayList2.add(object);
            }
            if ((n12 = cameraInfo.facing) != (n11 = 1)) continue;
            object = i10;
            arrayList.add(object);
        }
        this.w().A(arrayList, arrayList2);
    }

    private /* synthetic */ void O(boolean bl2, Camera camera) {
        this.F0();
    }

    private /* synthetic */ void Q(boolean bl2, Camera camera) {
        this.F0();
    }

    private /* synthetic */ void S(Integer object, int n10) {
        Comparable<StringBuilder> comparable = new StringBuilder();
        comparable.append("id change id=");
        comparable.append(object);
        d.v.d.h.f.a(comparable.toString());
        this.f();
        this.l0();
        object = this.K();
        comparable = 3;
        ((d.v.d.i.b.e)object).n((Integer)comparable);
    }

    private /* synthetic */ void U(Point point, int n10) {
        float f10 = point.x;
        float f11 = point.y;
        this.g(f10, f11);
    }

    private /* synthetic */ void W(Integer object, int n10) {
        Object object2 = new StringBuilder();
        Object object3 = "flash observer value=";
        ((StringBuilder)object2).append((String)object3);
        ((StringBuilder)object2).append(object);
        d.v.d.h.f.a(((StringBuilder)object2).toString());
        object2 = this.c;
        if (object2 != null && (n10 = (int)(((u)(object2 = this.B())).o() ? 1 : 0)) != 0) {
            this.c.setFlashMode("off");
            this.K0();
            object2 = this.c;
            object3 = p;
            int n11 = (Integer)object;
            object = (String)((SparseArrayCompat)object3).get(n11);
            object2.setFlashMode((String)object);
            this.K0();
        }
    }

    private /* synthetic */ void Y(Integer n10, int n11) {
        Object object = new StringBuilder();
        String string2 = "focus observer value=";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(n10);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.c;
        if (object != null && (n11 = (int)(((u)(object = this.B())).o() ? 1 : 0)) != 0) {
            int n12 = n10;
            object = "auto";
            string2 = "continuous-picture";
            switch (n12) {
                default: {
                    break;
                }
                case 4: 
                case 6: {
                    n10 = this.c;
                    n11 = 0;
                    object = null;
                    n10.setAutoExposureLock(false);
                    n10 = this.c;
                    n10.setFocusMode(string2);
                    this.K0();
                    break;
                }
                case 3: 
                case 5: {
                    n10 = this.c;
                    boolean bl2 = true;
                    n10.setAutoExposureLock(bl2);
                    n10 = this.c;
                    n10.setFocusMode((String)object);
                    this.K0();
                    break;
                }
                case 2: {
                    n10 = this.c;
                    n10.setFocusMode((String)object);
                    this.K0();
                    break;
                }
                case 1: {
                    n10 = this.c;
                    n10.setFocusMode(string2);
                    this.K0();
                }
            }
        }
    }

    public static /* synthetic */ int a(s s10) {
        return s10.f;
    }

    private /* synthetic */ void a0(List object, int n10) {
        int n11 = this.j;
        if (n11 == n10) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("preview face change status=");
        ((StringBuilder)object).append(n10);
        Object object2 = ",isOpenFace=";
        ((StringBuilder)object).append((String)object2);
        int bl2 = this.j;
        ((StringBuilder)object).append(bl2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.B();
        n11 = (int)(((u)object).o() ? 1 : 0);
        if (n11 != 0) {
            object = this.b;
            object2 = this.r();
            boolean bl3 = ((d.v.d.i.a.a)object2).j();
            ((r)object).f(bl3);
            this.j = n10;
        }
    }

    public static /* synthetic */ int b(s s10, int n10) {
        s10.f = n10;
        return n10;
    }

    private /* synthetic */ void c0(Float f10, int n10) {
        Object object = new StringBuilder();
        String string2 = "wt notify Photo wtValue=";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(f10);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.w();
        n10 = (int)(((d.v.d.i.f.l)object).s() ? 1 : 0);
        if (n10 != 0) {
            d.v.d.h.f.a("current is front,return");
            return;
        }
        object = this.c;
        if (object != null && (n10 = (int)(((u)(object = this.B())).o() ? 1 : 0)) != 0) {
            object = this.c;
            float f11 = f10.floatValue();
            int n11 = this.I(f11);
            object.setZoom(n11);
            this.K0();
        }
    }

    private int d(float f10, int n10, int n11) {
        int n12;
        float f11 = n10;
        f10 = f10 / f11 * 2000.0f;
        f11 = 1000.0f;
        int n13 = (int)(f10 -= f11);
        n10 = Math.abs(n13) + n11;
        if (n10 > (n12 = 1000)) {
            if (n13 > 0) {
                return n12 - n11;
            }
            return n11 + -1000;
        }
        return n13;
    }

    private Rect e(float f10, float f11) {
        int n10 = this.E().o();
        int n11 = 250;
        int n12 = this.d(f10, n10, n11);
        n10 = this.E().n();
        int n13 = this.d(f11, n10, n11);
        int n14 = n12 + -250;
        int n15 = n13 + -250;
        Rect rect = new Rect(n14, n15, n12 += n11, n13 += n11);
        return rect;
    }

    private /* synthetic */ void e0(Integer n10, int n11) {
        Object object = new StringBuilder();
        String string2 = "ae notify aeValue=";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(n10);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.c;
        if (object != null && (n11 = (int)(((u)(object = this.B())).o() ? 1 : 0)) != 0) {
            object = this.c;
            int n12 = n10;
            object.setExposureCompensation(n12);
            this.K0();
        }
    }

    private /* synthetic */ void g0(Integer object, int n10) {
        Object object2 = new StringBuilder();
        String string2 = "wb type observer value=";
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(object);
        d.v.d.h.f.a(((StringBuilder)object2).toString());
        object2 = this.c;
        if (object2 != null && (n10 = (int)(((u)(object2 = this.B())).o() ? 1 : 0)) != 0) {
            object2 = this.c;
            int n11 = (Integer)object;
            object = this.L(n11);
            object2.setWhiteBalance((String)object);
            this.K0();
        }
    }

    public static /* synthetic */ void i0(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("reset focus s=");
        stringBuilder.append(string2);
        d.v.d.h.f.a(stringBuilder.toString());
    }

    private Size j(double d10, List object) {
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

    private /* synthetic */ void j0() {
        boolean bl2;
        Object object = this.b.b;
        if (object != null && (object = this.c) != null && (bl2 = ((u)(object = this.B())).o())) {
            this.b.b.cancelAutoFocus();
            object = this.c;
            if (object == null) {
                return;
            }
            String string2 = "continuous-picture";
            Object object2 = object.getFlashMode();
            boolean bl3 = string2.equals(object2);
            if (bl3) {
                return;
            }
            object2 = object.getSupportedFocusModes();
            bl3 = object2.contains(string2);
            if (bl3) {
                object.setFocusMode(string2);
                bl3 = false;
                object2 = null;
                object.setFocusAreas(null);
                object.setMeteringAreas(null);
                this.K0();
            }
        }
    }

    private void m0(boolean bl2) {
        d.v.d.i.f.e e10 = this.p();
        c$a c$a = this.m;
        this.c(bl2, e10, c$a);
    }

    private void n0(boolean bl2) {
        g g10 = this.q();
        c$a c$a = this.g;
        this.c(bl2, g10, c$a);
    }

    private void o0(boolean bl2) {
        h h10 = this.r();
        c$a c$a = this.k;
        this.c(bl2, h10, c$a);
    }

    private void p0(boolean bl2) {
        d.v.d.i.f.i i10 = this.t();
        c$a c$a = this.o;
        this.c(bl2, i10, c$a);
    }

    private void q0(boolean bl2) {
        d.v.d.i.f.j j10 = this.u();
        c$a c$a = this.i;
        this.c(bl2, j10, c$a);
    }

    private void r0(boolean bl2) {
        boolean bl3 = this.M();
        if (bl3) {
            d.v.d.i.f.l l10 = this.w();
            c$a c$a = this.e;
            this.c(bl2, l10, c$a);
        }
    }

    private void s0(boolean bl2) {
        d.v.d.i.f.q q10 = this.z();
        c$a c$a = this.h;
        this.c(bl2, q10, c$a);
    }

    private void t0(boolean bl2) {
        y y10 = this.F();
        c$a c$a = this.n;
        this.c(bl2, y10, c$a);
    }

    private void u0(boolean bl2) {
        z z10 = this.G();
        c$a c$a = this.l;
        this.c(bl2, z10, c$a);
    }

    private void x0() {
        Object object = this.c.getMinExposureCompensation();
        Comparable<Integer> comparable = this.c.getMaxExposureCompensation();
        Object object2 = new Range((Comparable)object, (Comparable)comparable);
        this.p().l(true);
        object = this.p();
        comparable = object2.getLower();
        object2 = object2.getUpper();
        ((d.v.d.i.a.a)object).c(comparable, object2);
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("reset ae=");
        object = this.p().toString();
        ((StringBuilder)object2).append((String)object);
        d.v.d.h.f.a(((StringBuilder)object2).toString());
    }

    private void y0(Camera.CameraInfo object) {
        int n10 = ((Camera.CameraInfo)object).orientation;
        Object object2 = this.k();
        object = n10;
        ((d.v.d.i.c.a)object2).n((Integer)object);
        object = new StringBuilder();
        ((StringBuilder)object).append("reset device orientation =");
        object2 = this.k().toString();
        ((StringBuilder)object).append((String)object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
    }

    private void z0() {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Object object = this.c.getSupportedFlashModes();
        Integer n10 = 0;
        if (object == null) {
            arrayList.add(n10);
        } else {
            int n11;
            block12: for (int i10 = 0; i10 < (n11 = object.size()); ++i10) {
                Object object2 = (String)object.get(i10);
                ((String)object2).hashCode();
                int n12 = -1;
                int n13 = ((String)object2).hashCode();
                int n14 = 3;
                int n15 = 2;
                int n16 = 1;
                switch (n13) {
                    default: {
                        break;
                    }
                    case 110547964: {
                        String string2 = "torch";
                        n11 = (int)(((String)object2).equals(string2) ? 1 : 0);
                        if (n11 == 0) break;
                        n12 = n14;
                        break;
                    }
                    case 3005871: {
                        String string2 = "auto";
                        n11 = (int)(((String)object2).equals(string2) ? 1 : 0);
                        if (n11 == 0) break;
                        n12 = n15;
                        break;
                    }
                    case 109935: {
                        String string2 = "off";
                        n11 = (int)(((String)object2).equals(string2) ? 1 : 0);
                        if (n11 == 0) break;
                        n12 = n16;
                        break;
                    }
                    case 3551: {
                        String string2 = "on";
                        n11 = (int)(((String)object2).equals(string2) ? 1 : 0);
                        if (n11 == 0) break;
                        n12 = 0;
                    }
                }
                switch (n12) {
                    default: {
                        continue block12;
                    }
                    case 3: {
                        object2 = n14;
                        arrayList.add(object2);
                        continue block12;
                    }
                    case 2: {
                        object2 = n15;
                        arrayList.add(object2);
                        continue block12;
                    }
                    case 1: {
                        arrayList.add(n10);
                        continue block12;
                    }
                    case 0: {
                        object2 = n16;
                        arrayList.add(object2);
                    }
                }
            }
        }
        this.t().t(arrayList);
        object = new StringBuilder();
        ((StringBuilder)object).append("reset flash=");
        int n17 = arrayList.size();
        ((StringBuilder)object).append(n17);
        d.v.d.h.f.a(((StringBuilder)object).toString());
    }

    public t A() {
        return this.a.D0();
    }

    public u B() {
        return this.a.E0();
    }

    public Surface C() {
        d.v.d.h.f.a("get preview surface");
        return this.x().p();
    }

    public abstract void C0(boolean var1);

    public v D() {
        return this.a.F0();
    }

    public abstract void D0();

    public w E() {
        return this.a.G0();
    }

    public y F() {
        return this.a.I0();
    }

    public z G() {
        return this.a.J0();
    }

    public a0 H() {
        return this.a.K0();
    }

    public Size I0(List object, double d10, int n10) {
        boolean bl2;
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("select optimal preview size targetRatio =");
        ((StringBuilder)object2).append(d10);
        ((StringBuilder)object2).append(",targetHeight=");
        ((StringBuilder)object2).append(n10);
        d.v.d.h.f.a(((StringBuilder)object2).toString());
        object2 = object.iterator();
        int n11 = 0;
        Size size = null;
        double d11 = Double.MAX_VALUE;
        while (bl2 = object2.hasNext()) {
            double d12;
            Size size2 = (Size)object2.next();
            double d13 = size2.getWidth();
            int n12 = size2.getHeight();
            double d14 = n12;
            double d15 = (d13 = Math.abs(d13 / d14 - d10)) - (d14 = 0.05);
            Object object3 = d15 == 0.0 ? 0 : (d15 > 0.0 ? 1 : -1);
            if (object3 > 0 || (object3 = (d12 = (d13 = (double)Math.abs(size2.getHeight() - n10)) - d11) == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1)) >= 0) continue;
            n11 = Math.abs(size2.getHeight() - n10);
            double d16 = n11;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("supported optimalSize=");
            charSequence.append(size2);
            String string2 = ", minDiff=";
            charSequence.append(string2);
            charSequence.append(d16);
            charSequence = charSequence.toString();
            d.v.d.h.f.a((String)charSequence);
            d11 = d16;
            size = size2;
        }
        if (size == null) {
            size = this.j(d10, (List)object);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(" calculationSize final preview size: ");
        ((StringBuilder)object).append(size);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        return size;
    }

    public d J() {
        return this.a.Y0();
    }

    public void J0(Camera.Parameters parameters, Camera.CameraInfo cameraInfo) {
        this.c = parameters;
        this.x0();
        this.B0();
        this.H0();
        this.A0();
        this.G0();
        this.z0();
        this.y0(cameraInfo);
        this.D0();
    }

    public d.v.d.i.b.e K() {
        return this.a.Z0();
    }

    public void K0() {
        this.b.K();
    }

    public String L(int n10) {
        switch (n10) {
            default: {
                return "auto";
            }
            case 6: {
                return "shade";
            }
            case 5: {
                return "twilight";
            }
            case 4: {
                return "fluorescent";
            }
            case 3: {
                return "incandescent";
            }
            case 2: {
                return "cloudy-daylight";
            }
            case 1: 
        }
        return "daylight";
    }

    public boolean M() {
        return true;
    }

    public /* synthetic */ void P(boolean bl2, Camera camera) {
        this.O(bl2, camera);
    }

    public /* synthetic */ void R(boolean bl2, Camera camera) {
        this.Q(bl2, camera);
    }

    public /* synthetic */ void T(Integer n10, int n11) {
        this.S(n10, n11);
    }

    public /* synthetic */ void V(Point point, int n10) {
        this.U(point, n10);
    }

    public /* synthetic */ void X(Integer n10, int n11) {
        this.W(n10, n11);
    }

    public /* synthetic */ void Z(Integer n10, int n11) {
        this.Y(n10, n11);
    }

    public /* synthetic */ void b0(List list, int n10) {
        this.a0(list, n10);
    }

    public void c(boolean bl2, d.v.d.i.a.a a10, c$a c$a) {
        if (bl2) {
            a10.g(c$a);
        } else {
            a10.a(c$a);
        }
    }

    public /* synthetic */ void d0(Float f10, int n10) {
        this.c0(f10, n10);
    }

    public void f() {
        d.v.d.h.f.a("closeDevice start");
        Handler handler = this.h();
        r r10 = this.b;
        r10.getClass();
        q q10 = new q(r10);
        handler.post((Runnable)q10);
    }

    public /* synthetic */ void f0(Integer n10, int n11) {
        this.e0(n10, n11);
    }

    public void g(float f10, float f11) {
        boolean bl2;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("focus region x=");
        ((StringBuilder)object).append(f10);
        String string2 = ",y=";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(f11);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.c;
        if (object != null && (bl2 = ((u)(object = this.B())).o())) {
            object = this.c.getFocusMode();
            Object object2 = this.e(f10, f11);
            Object object3 = new ArrayList();
            int n10 = 500;
            string2 = new Camera.Area((Rect)object2, n10);
            object3.add(string2);
            object2 = this.c;
            int n11 = object2.getMaxNumFocusAreas();
            string2 = "auto";
            if (n11 != 0 && object != null && ((n11 = (int)(((String)object).equals(string2) ? 1 : 0)) != 0 || (n11 = (int)(((String)object).equals(object2 = "macro") ? 1 : 0)) != 0 || (n11 = (int)(((String)object).equals(object2 = "continuous-picture") ? 1 : 0)) != 0 || (n11 = (int)(((String)object).equals(object2 = "continuous-video") ? 1 : 0)) != 0)) {
                this.c.setFocusMode(string2);
                this.c.setFocusAreas(object3);
                object2 = this.c;
                n11 = object2.getMaxNumMeteringAreas();
                if (n11 > 0) {
                    object2 = this.c;
                    object2.setMeteringAreas(object3);
                }
                if ((n11 = (int)((object2 = this.c.getSupportedFocusModes()).contains(string2) ? 1 : 0)) == 0) {
                    return;
                }
                this.K0();
                object2 = this.b.b;
                object3 = new e(this);
                object2.autoFocus((Camera.AutoFocusCallback)object3);
            } else {
                object2 = this.c;
                n11 = object2.getMaxNumMeteringAreas();
                if (n11 > 0) {
                    object2 = this.c.getSupportedFocusModes();
                    n11 = (int)(object2.contains(string2) ? 1 : 0);
                    if (n11 == 0) {
                        return;
                    }
                    this.c.setFocusMode(string2);
                    this.c.setFocusAreas(object3);
                    this.c.setMeteringAreas(object3);
                    this.K0();
                    object2 = this.b.b;
                    object3 = new i(this);
                    object2.autoFocus((Camera.AutoFocusCallback)object3);
                } else {
                    object2 = this.b.b;
                    f11 = 0.0f;
                    object3 = null;
                    object2.autoFocus(null);
                }
            }
        }
    }

    public Handler h() {
        return this.a.d0();
    }

    public /* synthetic */ void h0(Integer n10, int n11) {
        this.g0(n10, n11);
    }

    public b i() {
        return this.a.X0();
    }

    public d.v.d.i.c.a k() {
        return this.a.e0();
    }

    public /* synthetic */ void k0() {
        this.j0();
    }

    public d.v.d.i.c.c l() {
        return this.a.f0();
    }

    public void l0() {
        d.v.d.h.f.a("openDevice start");
        Handler handler = this.h();
        r r10 = this.b;
        r10.getClass();
        a a10 = new a(r10);
        handler.post((Runnable)a10);
    }

    public c m() {
        return this.a.g0();
    }

    public int n() {
        Integer n10 = (Integer)this.k().get();
        int n11 = n10;
        Comparable<Integer> comparable = (Integer)this.y().get();
        int n12 = (Integer)comparable;
        d.v.d.i.f.l l10 = this.w();
        int n13 = l10.s();
        n13 = n13 != 0 ? -1 : 1;
        n11 = (n11 + (n12 *= n13) + 360) % 360;
        comparable = new Comparable<Integer>();
        ((StringBuilder)comparable).append("get orientation final =");
        ((StringBuilder)comparable).append(n11);
        d.v.d.h.f.a(((StringBuilder)comparable).toString());
        return n11;
    }

    public Handler o() {
        return this.a.i0();
    }

    public d.v.d.i.f.e p() {
        return this.a.p0();
    }

    public g q() {
        return this.a.r0();
    }

    public h r() {
        return this.a.s0();
    }

    public d.v.d.i.f.s s() {
        return this.a.C0();
    }

    public d.v.d.i.f.i t() {
        return this.a.t0();
    }

    public d.v.d.i.f.j u() {
        return this.a.u0();
    }

    public k v() {
        return this.a.v0();
    }

    public void v0() {
        d.v.d.h.f.a("release--source");
        this.E0(false);
        this.C0(false);
        this.w0();
    }

    public d.v.d.i.f.l w() {
        return this.a.w0();
    }

    public abstract void w0();

    public d.v.d.i.f.n x() {
        return this.a.y0();
    }

    public o y() {
        return this.a.z0();
    }

    public d.v.d.i.f.q z() {
        return this.a.A0();
    }
}

