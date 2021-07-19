/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Point
 *  android.graphics.Rect
 *  android.hardware.camera2.CameraCaptureSession$CaptureCallback
 *  android.hardware.camera2.CameraCharacteristics
 *  android.hardware.camera2.CameraCharacteristics$Key
 *  android.hardware.camera2.CameraManager
 *  android.hardware.camera2.CaptureRequest
 *  android.hardware.camera2.CaptureRequest$Builder
 *  android.hardware.camera2.CaptureRequest$Key
 *  android.hardware.camera2.params.MeteringRectangle
 *  android.hardware.camera2.params.StreamConfigurationMap
 *  android.media.ImageReader
 *  android.media.ImageReader$OnImageAvailableListener
 *  android.os.Handler
 *  android.os.SystemClock
 *  android.util.Range
 *  android.util.Size
 *  android.util.SizeF
 *  android.util.SparseIntArray
 *  android.view.Surface
 */
package d.v.d.g.d;

import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.ImageReader;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Range;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseIntArray;
import android.view.Surface;
import d.v.d.e;
import d.v.d.g.d.l;
import d.v.d.g.d.m;
import d.v.d.g.d.n;
import d.v.d.h.f;
import d.v.d.i.a.c$a;
import d.v.d.i.b.b;
import d.v.d.i.b.d;
import d.v.d.i.c.a;
import d.v.d.i.d.c;
import d.v.d.i.f.a0;
import d.v.d.i.f.g;
import d.v.d.i.f.h;
import d.v.d.i.f.i;
import d.v.d.i.f.j;
import d.v.d.i.f.k;
import d.v.d.i.f.q;
import d.v.d.i.f.s;
import d.v.d.i.f.t;
import d.v.d.i.f.u;
import d.v.d.i.f.w;
import d.v.d.i.f.y;
import d.v.d.i.f.z;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class o {
    public static final int r = 1000;
    public final e a;
    public n b;
    public CameraCharacteristics c;
    public ImageReader d;
    private boolean e = false;
    public SparseIntArray f;
    private final c$a g;
    private final c$a h;
    private final ImageReader.OnImageAvailableListener i;
    private final c$a j;
    private final Runnable k;
    private final c$a l;
    private final c$a m;
    private final c$a n;
    private final c$a o;
    private final c$a p;
    private final c$a q;

    public o(e e10, n n10) {
        Object object;
        this.f = object = new SparseIntArray(7);
        super(this);
        this.g = object;
        super(this);
        this.h = object;
        super(this);
        this.i = object;
        super(this);
        this.j = object;
        super(this);
        this.k = object;
        super(this);
        this.l = object;
        super(this);
        this.m = object;
        super(this);
        this.n = object;
        super(this);
        this.o = object;
        super(this);
        this.p = object;
        super(this);
        this.q = object;
        this.a = e10;
        this.b = n10;
        this.T();
        this.U();
        this.H0(true);
    }

    private void A0() {
        Object object = this.c;
        Object object2 = CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE;
        if ((object = (Range)object.get((CameraCharacteristics.Key)object2)) == null) {
            object = this.t();
            object2 = null;
            ((d.v.d.i.a.a)object).l(false);
        } else {
            object2 = this.t();
            boolean bl2 = true;
            ((d.v.d.i.a.a)object2).l(bl2);
            object2 = this.t();
            Comparable comparable = object.getLower();
            object = object.getUpper();
            ((d.v.d.i.a.a)object2).c(comparable, object);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("reset ae=");
        object2 = this.t().toString();
        ((StringBuilder)object).append((String)object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
    }

    private void B0() {
        Object object = this.c;
        Object object2 = CameraCharacteristics.SENSOR_ORIENTATION;
        int n10 = (Integer)object.get((CameraCharacteristics.Key)object2);
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("reset device orientation =");
        ((StringBuilder)object2).append(n10);
        d.v.d.h.f.a(((StringBuilder)object2).toString());
        object2 = this.n();
        object = n10;
        ((a)object2).n((Integer)object);
    }

    private void C0() {
        Object object = this.c;
        Object object2 = CameraCharacteristics.FLASH_INFO_AVAILABLE;
        object = (Boolean)object.get((CameraCharacteristics.Key)object2);
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("reset flash support=");
        ((StringBuilder)object2).append(object);
        d.v.d.h.f.a(((StringBuilder)object2).toString());
        object2 = new ArrayList();
        Integer n10 = 0;
        object2.add(n10);
        boolean n11 = (Boolean)object;
        if (n11) {
            object = 1;
            object2.add(object);
            object = 2;
            object2.add(object);
            int n12 = 3;
            object = n12;
            object2.add(object);
        }
        this.y().t((List)object2);
        object = new StringBuilder();
        ((StringBuilder)object).append("reset flash=");
        int n13 = object2.size();
        ((StringBuilder)object).append(n13);
        d.v.d.h.f.a(((StringBuilder)object).toString());
    }

    private void D0() {
        Object object = this.c;
        Object object2 = CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES;
        object = (int[])object.get((CameraCharacteristics.Key)object2);
        object2 = new StringBuilder();
        String string2 = "reset focus modes=";
        ((StringBuilder)object2).append(string2);
        boolean bl2 = ((CameraCharacteristics)object).length;
        ((StringBuilder)object2).append((int)(bl2 ? 1 : 0));
        d.v.d.h.f.a(((StringBuilder)object2).toString());
        object2 = new ArrayList();
        bl2 = true;
        Object object3 = (int)(bl2 ? 1 : 0);
        object2.add(object3);
        object3 = 2;
        object2.add(object3);
        object3 = 3;
        object2.add(object3);
        object3 = 4;
        object2.add(object3);
        object3 = 5;
        object2.add(object3);
        int n10 = 6;
        object3 = n10;
        object2.add(object3);
        object3 = this.z();
        if (object == null) {
            bl2 = false;
            string2 = null;
        }
        ((d.v.d.i.a.a)object3).l(bl2);
        this.z().p((List)object2);
    }

    private void E0() {
        Object object = this.c;
        Object object2 = CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES;
        if ((object = (Range[])object.get((CameraCharacteristics.Key)object2)) == null) {
            object = this.A();
            boolean bl2 = false;
            object2 = null;
            ((d.v.d.i.a.a)object).l(false);
        } else {
            this.A().o((Range[])object);
            object2 = this.A();
            int n10 = 1;
            ((d.v.d.i.a.a)object2).l(n10 != 0);
            int n11 = ((Object)object).length - n10;
            object = object[n11];
            object2 = this.A();
            Integer n12 = n10;
            object = object.getUpper();
            ((d.v.d.i.a.a)object2).c(n12, object);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("reset preview fps=");
        object2 = this.A().toString();
        ((StringBuilder)object).append((String)object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
    }

    private void H0(boolean bl2) {
        this.p0(bl2);
        this.x0(bl2);
        this.q0(bl2);
        this.v0(bl2);
        this.u0(bl2);
        this.r0(bl2);
        this.s0(bl2);
        this.w0(bl2);
        this.t0(bl2);
    }

    /*
     * WARNING - void declaration
     */
    private void I0() {
        void var4_7;
        Object object;
        Serializable serializable = new ArrayList();
        Object object2 = this.c;
        Object object3 = CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES;
        object2 = (int[])object2.get((CameraCharacteristics.Key)object3);
        object3 = this.L();
        int n10 = ((CameraCharacteristics)object2).length;
        int n11 = 0;
        if (n10 > 0) {
            boolean bl2 = true;
        } else {
            boolean bl3 = false;
            object = null;
        }
        ((d.v.d.i.a.a)object3).l((boolean)var4_7);
        int n12 = ((CameraCharacteristics)object2).length;
        while (n11 < n12) {
            Object object4 = object2[n11];
            SparseIntArray sparseIntArray = this.f;
            int n13 = sparseIntArray.indexOfValue((int)object4);
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "resetWbType value=";
            stringBuilder.append(string2);
            stringBuilder.append((int)object4);
            stringBuilder.append(",index=");
            stringBuilder.append(n13);
            object = stringBuilder.toString();
            d.v.d.h.f.a((String)object);
            object4 = -1;
            if (n13 != object4) {
                object4 = this.f.keyAt(n13);
                object = (int)object4;
                serializable.add(object);
            }
            ++n11;
        }
        Collections.sort(serializable);
        object2 = this.L();
        object3 = this.C();
        ((y)object2).r((List)((Object)serializable), (d.v.d.i.f.l)object3);
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append("reset wb type=");
        object2 = this.L().get();
        ((StringBuilder)serializable).append(object2);
        d.v.d.h.f.a(((StringBuilder)serializable).toString());
    }

    private void J0() {
        Object object = this.c;
        Object object2 = CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM;
        object = (Float)object.get((CameraCharacteristics.Key)object2);
        float f10 = ((Float)object).floatValue();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("reset wt maxWt=");
        ((StringBuilder)object2).append(f10);
        object2 = ((StringBuilder)object2).toString();
        d.v.d.h.f.a((String)object2);
        f10 = Math.min(f10, 10.0f);
        float f11 = 1.0f;
        Float f12 = Float.valueOf(f11);
        float f13 = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
        if (f13 > 0) {
            d.v.d.i.a.a a10 = this.N();
            boolean bl2 = true;
            a10.l(bl2);
            a10 = this.N();
            Float f14 = Float.valueOf(f10);
            ((a0)a10).x(f12, f14);
            this.M().l(bl2);
            a10 = this.M();
            object = Float.valueOf(f10);
            ((z)a10).z(f12, (Float)object, f11);
        } else {
            object = this.M();
            f11 = 0.0f;
            object2 = null;
            ((d.v.d.i.a.a)object).l(false);
            object = this.N();
            ((d.v.d.i.a.a)object).l(false);
        }
    }

    private void K0() {
        d.v.d.h.f.a("resumeAuto start");
        Handler handler = this.s();
        Runnable runnable = this.k;
        handler.removeCallbacks(runnable);
        handler = this.s();
        runnable = this.k;
        handler.postDelayed(runnable, 2000L);
    }

    private void N0(CaptureRequest.Builder builder, CameraCaptureSession.CaptureCallback captureCallback, Handler handler) {
        u u10 = this.I();
        boolean bl2 = u10.o();
        if (!bl2) {
            d.v.d.h.f.a("set Repeating failed,current is not preview ing");
            return;
        }
        this.b.O(builder, captureCallback, handler);
    }

    private void P0(CaptureRequest.Builder builder, int n10) {
        if (builder == null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("update ae ,current ae=");
        stringBuilder.append(n10);
        d.v.d.h.f.a(stringBuilder.toString());
        stringBuilder = CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION;
        Integer n11 = n10;
        builder.set((CaptureRequest.Key)stringBuilder, (Object)n11);
    }

    private void Q0(boolean bl2) {
        boolean bl3 = this.e;
        if (bl3 == bl2) {
            return;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("updateFaceDetect open=");
        charSequence.append(bl2);
        Object object = ",mLastTrigger=";
        charSequence.append((String)object);
        boolean bl4 = this.e;
        charSequence.append(bl4);
        charSequence = charSequence.toString();
        d.v.d.h.f.a((String)charSequence);
        this.e = bl2;
        CaptureRequest.Builder builder = this.u();
        if (builder == null) {
            return;
        }
        charSequence = CaptureRequest.STATISTICS_FACE_DETECT_MODE;
        object = this.p();
        builder.set((CaptureRequest.Key)charSequence, object);
        charSequence = this.v();
        object = this.B();
        this.O0(builder, (CameraCaptureSession.CaptureCallback)charSequence, (Handler)object);
    }

    private void S0(CaptureRequest.Builder builder, int n10) {
        if (builder == null) {
            return;
        }
        Object object = new StringBuilder();
        String string2 = "update focus value=";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        d.v.d.h.f.a((String)object);
        int n11 = 1;
        switch (n10) {
            default: {
                break;
            }
            case 6: {
                this.K0();
                break;
            }
            case 5: {
                CaptureRequest.Key key = CaptureRequest.CONTROL_AF_TRIGGER;
                object = n11;
                builder.set(key, object);
                key = this.v();
                object = this.B();
                this.O0(builder, (CameraCaptureSession.CaptureCallback)key, (Handler)object);
                break;
            }
            case 4: {
                CaptureRequest.Key key = CaptureRequest.CONTROL_AE_LOCK;
                object = Boolean.FALSE;
                builder.set(key, object);
                key = this.v();
                object = this.B();
                this.O0(builder, (CameraCaptureSession.CaptureCallback)key, (Handler)object);
                break;
            }
            case 3: {
                CaptureRequest.Key key = CaptureRequest.CONTROL_AE_LOCK;
                object = Boolean.TRUE;
                builder.set(key, object);
                key = this.v();
                object = this.B();
                this.O0(builder, (CameraCaptureSession.CaptureCallback)key, (Handler)object);
                break;
            }
            case 2: {
                CaptureRequest.Key key = CaptureRequest.CONTROL_AF_MODE;
                object = n11;
                builder.set(key, object);
                key = this.v();
                object = this.B();
                this.O0(builder, (CameraCaptureSession.CaptureCallback)key, (Handler)object);
                break;
            }
            case 1: {
                this.h();
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void T() {
        try {
            Object object = this.b;
            object = ((n)object).b;
            object = object.getCameraIdList();
            ArrayList<Object> arrayList = new ArrayList<Object>();
            ArrayList arrayList2 = new ArrayList();
            int n10 = ((String[])object).length;
            int n11 = 0;
            while (true) {
                int n12;
                if (n11 >= n10) {
                    object = this.C();
                    ((d.v.d.i.f.l)object).A(arrayList, arrayList2);
                    return;
                }
                Object object2 = object[n11];
                n n13 = this.b;
                n13 = n13.b;
                n13 = n13.getCameraCharacteristics((String)object2);
                Object object3 = CameraCharacteristics.LENS_FACING;
                object3 = n13.get((CameraCharacteristics.Key)object3);
                object3 = (Integer)object3;
                StringBuilder stringBuilder = new StringBuilder();
                String string2 = "camera id  =";
                stringBuilder.append(string2);
                stringBuilder.append((String)object2);
                string2 = ",face=";
                stringBuilder.append(string2);
                stringBuilder.append(object3);
                String string3 = stringBuilder.toString();
                d.v.d.h.f.a(string3);
                int n14 = (Integer)object3;
                int n15 = 1;
                if (n14 == n15) {
                    this.c((CameraCharacteristics)n13, (String)object2, arrayList2);
                }
                if ((n12 = ((Integer)object3).intValue()) == 0) {
                    object2 = Integer.valueOf((String)object2);
                    arrayList.add(object2);
                }
                ++n11;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            String string4 = "init id failed";
            d.v.d.h.f.a(string4);
        }
    }

    private void U() {
        SparseIntArray sparseIntArray = this.f;
        int n10 = 1;
        sparseIntArray.append(0, n10);
        this.f.append(n10, 5);
        sparseIntArray = this.f;
        int n11 = 2;
        sparseIntArray.append(n11, 6);
        sparseIntArray = this.f;
        n10 = 3;
        sparseIntArray.append(n10, n11);
        this.f.append(4, n10);
    }

    private /* synthetic */ void V(Integer object, int n10) {
        Comparable<StringBuilder> comparable = new StringBuilder();
        comparable.append("id change id=");
        comparable.append(object);
        d.v.d.h.f.a(comparable.toString());
        this.g();
        this.o0();
        object = this.R();
        comparable = 3;
        ((d.v.d.i.b.e)object).n((Integer)comparable);
    }

    private /* synthetic */ void X(ImageReader imageReader) {
        this.w().n(imageReader);
    }

    private /* synthetic */ void Z(Point point, int n10) {
        float f10 = point.x;
        float f11 = point.y;
        this.i(f10, f11);
    }

    public static /* synthetic */ ImageReader.OnImageAvailableListener a(o o10) {
        return o10.i;
    }

    private /* synthetic */ void b0(Integer n10, int n11) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("focus observer value=");
        stringBuilder.append(n10);
        d.v.d.h.f.a(stringBuilder.toString());
        stringBuilder = this.u();
        int n12 = n10;
        this.S0((CaptureRequest.Builder)stringBuilder, n12);
    }

    private void c(CameraCharacteristics object, String string2, List list) {
        CameraManager cameraManager = "0";
        int n10 = string2.equalsIgnoreCase((String)cameraManager);
        if (n10 != 0) {
            object = Integer.valueOf(string2);
            list.add(object);
            return;
        }
        cameraManager = CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP;
        if ((cameraManager = (StreamConfigurationMap)object.get((CameraCharacteristics.Key)cameraManager)) == null) {
            d.v.d.h.f.a("streamConfigurationMap==null invalid id,return");
            return;
        }
        int n11 = 256;
        if ((cameraManager = cameraManager.getOutputSizes(n11)) == null) {
            d.v.d.h.f.a("getOutputSizes==null invalid id,return");
            return;
        }
        n10 = list.size();
        if (n10 < (n11 = 2)) {
            object = Integer.valueOf(string2);
            list.add(object);
            return;
        }
        float f10 = this.d((CameraCharacteristics)object);
        cameraManager = this.b.b;
        n11 = 1;
        String string3 = String.valueOf(list.get(n11));
        float f11 = this.d((CameraCharacteristics)(cameraManager = cameraManager.getCameraCharacteristics(string3)));
        float f12 = f10 - f11;
        Object object2 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object2 > 0) {
            object = Integer.valueOf(string2);
            list.add(n11, object);
            return;
        }
        object = Integer.valueOf(string2);
        list.add(object);
    }

    private float d(CameraCharacteristics object) {
        CameraCharacteristics.Key key = CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE;
        key = (SizeF)object.get(key);
        CameraCharacteristics.Key key2 = CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS;
        object = (float[])object.get(key2);
        int n10 = ((CameraCharacteristics)object).length + -1;
        Object object2 = object[n10];
        float f10 = key.getWidth();
        double d10 = Math.atan(f10 / (object2 *= 2.0f));
        double d11 = 2.0;
        f10 = (float)(d10 * d11);
        object2 = Math.atan(key.getHeight() / object2) * d11;
        return f10 * object2;
    }

    private /* synthetic */ void d0(List list, int n10) {
        boolean bl2 = this.x().j();
        this.Q0(bl2);
    }

    private boolean e(float f10) {
        d.v.d.i.a.a a10 = this.I();
        boolean bl2 = ((u)a10).o();
        if (bl2 && !(bl2 = ((d.v.d.i.g.l)(a10 = this.O())).q()) && !(bl2 = ((d.v.d.i.f.l)(a10 = this.C())).s())) {
            a10 = this.C();
            s s10 = this.G();
            float f11 = 1.0f;
            float f12 = f10 == f11 ? 0 : (f10 < f11 ? -1 : 1);
            boolean bl3 = true;
            if (f12 < 0 && (f12 = (float)((d.v.d.i.f.l)a10).t()) != false) {
                s10.p();
                ((d.v.d.i.f.l)a10).B();
                return bl3;
            }
            Object object = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
            if (object >= 0 && (object = (Object)((d.v.d.i.f.l)a10).v()) != false) {
                s10.p();
                ((d.v.d.i.f.l)a10).z();
                return bl3;
            }
        }
        return false;
    }

    private int f(int n10, int n11) {
        if (n10 > n11) {
            return n11;
        }
        return Math.max(n10, 0);
    }

    private /* synthetic */ void f0(Float f10, int n10) {
        Object object = new StringBuilder();
        String string2 = "wt notify wtValue=";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(f10);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.C();
        n10 = (int)(((d.v.d.i.f.l)object).s() ? 1 : 0);
        if (n10 != 0) {
            d.v.d.h.f.a("current is front,return");
            return;
        }
        object = this.I();
        n10 = (int)(((u)object).o() ? 1 : 0);
        if (n10 == 0) {
            d.v.d.h.f.a("current is not preview ing");
            return;
        }
        float f11 = f10.floatValue();
        n10 = (int)(this.e(f11) ? 1 : 0);
        if (n10 != 0) {
            return;
        }
        object = this.u();
        if (object == null) {
            return;
        }
        float f12 = f10.floatValue();
        this.U0((CaptureRequest.Builder)object, f12);
        f10 = this.v();
        string2 = this.B();
        this.O0((CaptureRequest.Builder)object, (CameraCaptureSession.CaptureCallback)f10, (Handler)string2);
    }

    private void h() {
        d.v.d.h.f.a("do auto mode");
        CaptureRequest.Builder builder = this.u();
        if (builder == null) {
            return;
        }
        CaptureRequest.Key key = CaptureRequest.CONTROL_AF_TRIGGER;
        Integer n10 = 2;
        builder.set(key, (Object)n10);
        key = this.v();
        n10 = this.B();
        this.N0(builder, (CameraCaptureSession.CaptureCallback)key, (Handler)n10);
        key = CaptureRequest.CONTROL_AF_MODE;
        n10 = 4;
        builder.set(key, (Object)n10);
        key = this.v();
        n10 = this.B();
        this.O0(builder, (CameraCaptureSession.CaptureCallback)key, (Handler)n10);
    }

    private /* synthetic */ void h0(Integer n10, int n11) {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "ae notify aeValue=";
        stringBuilder.append(string2);
        stringBuilder.append(n10);
        d.v.d.h.f.a(stringBuilder.toString());
        stringBuilder = this.u();
        if (stringBuilder == null) {
            return;
        }
        int n12 = n10;
        this.P0((CaptureRequest.Builder)stringBuilder, n12);
        n10 = this.v();
        string2 = this.B();
        this.O0((CaptureRequest.Builder)stringBuilder, (CameraCaptureSession.CaptureCallback)n10, (Handler)string2);
    }

    private /* synthetic */ void j0(Integer n10, int n11) {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "wb type observer integer=";
        stringBuilder.append(string2);
        stringBuilder.append(n10);
        d.v.d.h.f.a(stringBuilder.toString());
        stringBuilder = this.u();
        if (stringBuilder == null) {
            return;
        }
        string2 = this.f;
        int n12 = n10;
        n12 = string2.get(n12);
        this.T0((CaptureRequest.Builder)stringBuilder, n12);
        n10 = this.v();
        string2 = this.B();
        this.O0((CaptureRequest.Builder)stringBuilder, (CameraCaptureSession.CaptureCallback)n10, (Handler)string2);
    }

    private Rect l(float f10, float f11) {
        CameraCharacteristics cameraCharacteristics = this.c;
        CameraCharacteristics.Key key = CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE;
        cameraCharacteristics = (Rect)cameraCharacteristics.get(key);
        int n10 = cameraCharacteristics.right;
        int n11 = cameraCharacteristics.bottom;
        int n12 = this.K().o();
        int n13 = this.K().n();
        int n14 = (int)f10;
        int n15 = (int)f11;
        n14 = (n14 * n10 + -1000) / n12;
        n15 = (n15 * n11 + -1000) / n13;
        n14 = this.f(n14, n10);
        n15 = this.f(n15, n11);
        n10 = n14 + 1000;
        n12 = n15 + 1000;
        cameraCharacteristics = new Rect(n14, n15, n10, n12);
        return cameraCharacteristics;
    }

    private /* synthetic */ void l0(Integer n10, int n11) {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "flash observer value=";
        stringBuilder.append(string2);
        stringBuilder.append(n10);
        d.v.d.h.f.a(stringBuilder.toString());
        n10 = this.u();
        if (n10 == null) {
            return;
        }
        this.R0((CaptureRequest.Builder)n10, 0);
        stringBuilder = this.v();
        string2 = this.B();
        this.O0((CaptureRequest.Builder)n10, (CameraCaptureSession.CaptureCallback)stringBuilder, (Handler)string2);
        SystemClock.sleep((long)100);
        n11 = (Integer)this.y().get();
        this.R0((CaptureRequest.Builder)n10, n11);
        stringBuilder = this.v();
        string2 = this.B();
        this.O0((CaptureRequest.Builder)n10, (CameraCaptureSession.CaptureCallback)stringBuilder, (Handler)string2);
    }

    private Size m(double d10, List object) {
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

    public static /* synthetic */ void n0(o o10) {
        o10.h();
    }

    private void p0(boolean bl2) {
        d.v.d.i.f.e e10 = this.t();
        c$a c$a = this.o;
        this.b(bl2, e10, c$a);
    }

    private void q0(boolean bl2) {
        h h10 = this.x();
        c$a c$a = this.m;
        this.b(bl2, h10, c$a);
    }

    private void r0(boolean bl2) {
        i i10 = this.y();
        c$a c$a = this.q;
        this.b(bl2, i10, c$a);
    }

    private void s0(boolean bl2) {
        j j10 = this.z();
        c$a c$a = this.l;
        this.b(bl2, j10, c$a);
    }

    private void t0(boolean bl2) {
        boolean bl3 = this.S();
        if (bl3) {
            d.v.d.i.f.l l10 = this.C();
            c$a c$a = this.g;
            this.b(bl2, l10, c$a);
        }
    }

    private void u0(boolean bl2) {
        q q10 = this.F();
        c$a c$a = this.j;
        this.b(bl2, q10, c$a);
    }

    private void v0(boolean bl2) {
        t t10 = this.H();
        c$a c$a = this.h;
        this.b(bl2, t10, c$a);
    }

    private void w0(boolean bl2) {
        y y10 = this.L();
        c$a c$a = this.p;
        this.b(bl2, y10, c$a);
    }

    private void x0(boolean bl2) {
        z z10 = this.M();
        c$a c$a = this.n;
        this.b(bl2, z10, c$a);
    }

    public k A() {
        return this.a.v0();
    }

    public Handler B() {
        return this.b.o();
    }

    public d.v.d.i.f.l C() {
        return this.a.w0();
    }

    public d.v.d.i.f.n D() {
        return this.a.y0();
    }

    public d.v.d.i.f.o E() {
        return this.a.z0();
    }

    public q F() {
        return this.a.A0();
    }

    public abstract void F0(boolean var1);

    public s G() {
        return this.a.C0();
    }

    public abstract void G0();

    public t H() {
        return this.a.D0();
    }

    public u I() {
        return this.a.E0();
    }

    public Surface J() {
        d.v.d.h.f.a("get preview surface");
        return this.D().p();
    }

    public w K() {
        return this.a.G0();
    }

    public y L() {
        return this.a.I0();
    }

    public Size L0(List object, double d10, int n10) {
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
            size = this.m(d10, (List)object);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(" calculationSize final preview size: ");
        ((StringBuilder)object).append(size);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        return size;
    }

    public z M() {
        return this.a.J0();
    }

    public void M0(CameraCharacteristics cameraCharacteristics) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setCameraCharacteristics characteristics=");
        stringBuilder.append(cameraCharacteristics);
        d.v.d.h.f.a(stringBuilder.toString());
        this.c = cameraCharacteristics;
        this.A0();
        this.E0();
        this.J0();
        this.D0();
        this.I0();
        this.C0();
        this.B0();
        this.G0();
    }

    public a0 N() {
        return this.a.K0();
    }

    public d.v.d.i.g.l O() {
        return this.a.T0();
    }

    public void O0(CaptureRequest.Builder builder, CameraCaptureSession.CaptureCallback captureCallback, Handler handler) {
        u u10 = this.I();
        boolean bl2 = u10.o();
        if (!bl2) {
            d.v.d.h.f.a("set Repeating failed,current is not preview ing");
            return;
        }
        this.b.P(builder, captureCallback, handler);
    }

    public b P() {
        return this.a.X0();
    }

    public d Q() {
        return this.a.Y0();
    }

    public d.v.d.i.b.e R() {
        return this.a.Z0();
    }

    public void R0(CaptureRequest.Builder builder, int n10) {
        Object object = new StringBuilder();
        Object object2 = "update flash flash=";
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        d.v.d.h.f.a((String)object);
        if (builder == null) {
            return;
        }
        object = null;
        int n11 = 1;
        if (n10 != 0) {
            int n12 = 3;
            if (n10 != n11) {
                int n13 = 2;
                if (n10 != n13) {
                    if (n10 == n12) {
                        CaptureRequest.Key key = CaptureRequest.CONTROL_AE_MODE;
                        object = n11;
                        builder.set(key, object);
                        key = CaptureRequest.FLASH_MODE;
                        object = n13;
                        builder.set(key, object);
                    }
                } else {
                    CaptureRequest.Key key = CaptureRequest.CONTROL_AE_MODE;
                    object2 = n13;
                    builder.set(key, object2);
                    key = CaptureRequest.FLASH_MODE;
                    object = 0;
                    builder.set(key, object);
                }
            } else {
                CaptureRequest.Key key = CaptureRequest.CONTROL_AE_MODE;
                object2 = n12;
                builder.set(key, object2);
                key = CaptureRequest.FLASH_MODE;
                object = 0;
                builder.set(key, object);
            }
        } else {
            CaptureRequest.Key key = CaptureRequest.CONTROL_AE_MODE;
            object2 = n11;
            builder.set(key, object2);
            key = CaptureRequest.FLASH_MODE;
            object = 0;
            builder.set(key, object);
        }
    }

    public boolean S() {
        return true;
    }

    public void T0(CaptureRequest.Builder builder, int n10) {
        if (builder == null) {
            return;
        }
        CaptureRequest.Key key = CaptureRequest.CONTROL_AWB_MODE;
        Integer n11 = n10;
        builder.set(key, (Object)n11);
    }

    public void U0(CaptureRequest.Builder builder, float f10) {
        CharSequence charSequence = new StringBuilder();
        String string2 = "update wt ,current wt=";
        charSequence.append(string2);
        charSequence.append(f10);
        charSequence = charSequence.toString();
        d.v.d.h.f.a((String)charSequence);
        if (builder != null && (charSequence = this.c) != null) {
            int n10;
            float f11 = 1.0f;
            float f12 = f10 - f11;
            Object object = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
            if (object < 0) {
                object = 1092616192;
                f11 = 10.0f;
                f10 *= f11;
                n10 = 0x40A00000;
                float f13 = 5.0f;
                f10 = (f10 + f13) / f11;
            }
            string2 = CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE;
            charSequence = (Rect)charSequence.get((CameraCharacteristics.Key)string2);
            object = charSequence.width() / 2;
            n10 = charSequence.height() / 2;
            double d10 = charSequence.width();
            double d11 = 2.0;
            double d12 = (double)f10 * d11;
            int n11 = (int)(d10 / d12);
            d10 = (double)charSequence.height() / d12;
            int n12 = (int)d10;
            float f14 = object - n11;
            object += n11;
            n11 = n10 - n12;
            charSequence = CaptureRequest.SCALER_CROP_REGION;
            Rect rect = new Rect((int)f14, n11, (int)object, n10 += n12);
            builder.set((CaptureRequest.Key)charSequence, (Object)rect);
        }
    }

    public /* synthetic */ void W(Integer n10, int n11) {
        this.V(n10, n11);
    }

    public /* synthetic */ void Y(ImageReader imageReader) {
        this.X(imageReader);
    }

    public /* synthetic */ void a0(Point point, int n10) {
        this.Z(point, n10);
    }

    public void b(boolean bl2, d.v.d.i.a.a a10, c$a c$a) {
        if (bl2) {
            a10.g(c$a);
        } else {
            a10.a(c$a);
        }
    }

    public /* synthetic */ void c0(Integer n10, int n11) {
        this.b0(n10, n11);
    }

    public /* synthetic */ void e0(List list, int n10) {
        this.d0(list, n10);
    }

    public void g() {
        d.v.d.h.f.a("closeDevice start");
        Handler handler = this.s();
        n n10 = this.b;
        n10.getClass();
        m m10 = new m(n10);
        handler.post((Runnable)m10);
    }

    public /* synthetic */ void g0(Float f10, int n10) {
        this.f0(f10, n10);
    }

    public void i(float f10, float f11) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("focus region x=");
        stringBuilder.append(f10);
        String string2 = ",y=";
        stringBuilder.append(string2);
        stringBuilder.append(f11);
        d.v.d.h.f.a(stringBuilder.toString());
        stringBuilder = this.c;
        if (stringBuilder == null) {
            d.v.d.h.f.a("current is mCameraCharacteristics ==null");
            return;
        }
        stringBuilder = this.u();
        if (stringBuilder == null) {
            return;
        }
        Object object = this.l(f10, f11);
        string2 = new MeteringRectangle(object, 1000);
        int n10 = 1;
        CameraCaptureSession.CaptureCallback captureCallback = new MeteringRectangle[n10];
        captureCallback[0] = string2;
        string2 = CaptureRequest.CONTROL_AF_TRIGGER;
        Integer n11 = 0;
        stringBuilder.set((CaptureRequest.Key)string2, n11);
        string2 = CaptureRequest.CONTROL_AF_MODE;
        n11 = n10;
        stringBuilder.set((CaptureRequest.Key)string2, n11);
        string2 = CaptureRequest.CONTROL_AF_REGIONS;
        stringBuilder.set((CaptureRequest.Key)string2, captureCallback);
        string2 = CaptureRequest.CONTROL_AE_REGIONS;
        stringBuilder.set((CaptureRequest.Key)string2, captureCallback);
        captureCallback = this.v();
        string2 = this.B();
        this.O0((CaptureRequest.Builder)stringBuilder, captureCallback, (Handler)string2);
        captureCallback = CaptureRequest.CONTROL_AF_TRIGGER;
        object = n10;
        stringBuilder.set((CaptureRequest.Key)captureCallback, object);
        object = this.v();
        captureCallback = this.B();
        this.N0((CaptureRequest.Builder)stringBuilder, (CameraCaptureSession.CaptureCallback)object, (Handler)captureCallback);
        this.K0();
    }

    public /* synthetic */ void i0(Integer n10, int n11) {
        this.h0(n10, n11);
    }

    public Surface j() {
        d.v.d.h.f.a("get analysis surface");
        ImageReader imageReader = this.d;
        if (imageReader == null) {
            return null;
        }
        return imageReader.getSurface();
    }

    public Handler k() {
        return this.a.d0();
    }

    public /* synthetic */ void k0(Integer n10, int n11) {
        this.j0(n10, n11);
    }

    public /* synthetic */ void m0(Integer n10, int n11) {
        this.l0(n10, n11);
    }

    public a n() {
        return this.a.e0();
    }

    public d.v.d.i.c.c o() {
        return this.a.f0();
    }

    public void o0() {
        d.v.d.h.f.a("openDevice start");
        Handler handler = this.s();
        n n10 = this.b;
        n10.getClass();
        l l10 = new l(n10);
        handler.post((Runnable)l10);
    }

    public int p() {
        int n10;
        int n11;
        Object object;
        block4: {
            object = this.c;
            n11 = 0;
            if (object == null) {
                return 0;
            }
            CameraCharacteristics.Key key = CameraCharacteristics.STATISTICS_INFO_AVAILABLE_FACE_DETECT_MODES;
            object = (int[])object.get(key);
            int n12 = ((CameraCharacteristics)object).length;
            int n13 = 0;
            while (true) {
                n10 = 2;
                if (n13 >= n12) break;
                CameraCharacteristics cameraCharacteristics = object[n13];
                if (cameraCharacteristics != n10) {
                    ++n13;
                    continue;
                }
                break block4;
                break;
            }
            n10 = 1;
        }
        object = this.x();
        boolean bl2 = ((d.v.d.i.a.a)object).j();
        if (bl2) {
            n11 = n10;
        }
        return n11;
    }

    public c q() {
        return this.a.g0();
    }

    public int r() {
        Integer n10 = (Integer)this.n().get();
        int n11 = n10;
        Comparable<Integer> comparable = (Integer)this.E().get();
        int n12 = (Integer)comparable;
        d.v.d.i.f.l l10 = this.C();
        int n13 = l10.s();
        n13 = n13 != 0 ? -1 : 1;
        n11 = (n11 + (n12 *= n13) + 360) % 360;
        comparable = new Comparable<Integer>();
        ((StringBuilder)comparable).append("get orientation final =");
        ((StringBuilder)comparable).append(n11);
        d.v.d.h.f.a(((StringBuilder)comparable).toString());
        return n11;
    }

    public Handler s() {
        return this.a.i0();
    }

    public d.v.d.i.f.e t() {
        return this.a.p0();
    }

    public CaptureRequest.Builder u() {
        return this.b.r();
    }

    public CameraCaptureSession.CaptureCallback v() {
        return this.b.s();
    }

    public g w() {
        return this.a.r0();
    }

    public h x() {
        return this.a.s0();
    }

    public i y() {
        return this.a.t0();
    }

    public void y0() {
        d.v.d.h.f.a("release--source");
        Handler handler = this.s();
        Runnable runnable = this.k;
        handler.removeCallbacks(runnable);
        this.e = false;
        this.H0(false);
        this.F0(false);
        this.z0();
    }

    public j z() {
        return this.a.u0();
    }

    public abstract void z0();
}

