/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.hardware.camera2.CameraAccessException
 *  android.hardware.camera2.CameraCharacteristics
 *  android.hardware.camera2.CameraCharacteristics$Key
 *  android.hardware.camera2.CameraManager
 *  android.hardware.camera2.CaptureRequest
 *  android.hardware.camera2.CaptureRequest$Builder
 *  android.hardware.camera2.CaptureRequest$Key
 *  android.hardware.camera2.CaptureResult
 *  android.os.Build
 *  android.os.Handler
 *  android.os.Looper
 *  android.view.Surface
 */
package d.v.d.g.d.u;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import d.v.d.g.d.n;
import d.v.d.g.d.o;
import d.v.d.g.d.u.d$a;
import d.v.d.g.d.u.e;
import d.v.d.g.d.u.f.f;
import d.v.d.g.d.u.f.g;
import d.v.d.i.a.a;
import java.util.Arrays;
import java.util.List;

public class d
extends n {
    private static final String q = "Xiaomi";
    private static final String r = "HUAWEI";
    private static final String s = "samsung";
    private g l;
    public e m;
    private final Handler n;
    private CaptureRequest.Builder o;
    private final Runnable p;

    public d(Context object, d.v.d.e e10) {
        d$a d$a = new d$a(this);
        this.p = d$a;
        d.v.d.h.f.a("init camera2photo  start");
        object = (CameraManager)object.getSystemService("camera");
        this.b = object;
        super(this, e10);
        this.m = object;
        this.I((o)object);
        this.d0();
        super("Camera2Photo_burst");
        object.start();
        object = object.getLooper();
        super((Looper)object);
        this.n = e10;
    }

    public static /* synthetic */ CaptureRequest.Builder V(d d10) {
        return d10.o;
    }

    public static /* synthetic */ Runnable W(d d10) {
        return d10.p;
    }

    public static /* synthetic */ Handler X(d d10) {
        return d10.n;
    }

    private void Y() {
        Handler handler = this.n;
        Runnable runnable = this.p;
        handler.removeCallbacks(runnable);
    }

    private void Z() {
        int n10;
        Object object;
        block43: {
            object = "capture  Picture start";
            d.v.d.h.f.a((String)object);
            n10 = this.i();
            if (n10 == 0) break block43;
            return;
        }
        object = this.c;
        int n11 = 2;
        object = object.createCaptureRequest(n11);
        this.o = object;
        Object object2 = CaptureRequest.CONTROL_CAPTURE_INTENT;
        Object object3 = n11;
        object.set((CaptureRequest.Key)object2, object3);
        object = this.o;
        object2 = this.b0();
        object.addTarget((Surface)object2);
        object = this.o;
        object2 = this.z();
        object.addTarget((Surface)object2);
        object = this.o;
        object2 = CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION;
        object3 = this.q();
        object3 = ((a)object3).get();
        object.set((CaptureRequest.Key)object2, object3);
        object = this.o;
        this.R((CaptureRequest.Builder)object);
        object = this.a;
        object2 = CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE;
        object = object.get((CameraCharacteristics.Key)object2);
        object = (Rect)object;
        object2 = this.D();
        object2 = ((a)object2).get();
        object2 = (Float)object2;
        float f10 = ((Float)object2).floatValue();
        int n12 = object.width();
        n12 /= n11;
        int n13 = object.height();
        n13 /= n11;
        n11 = object.width();
        double d10 = n11;
        double d11 = 2.0;
        double d12 = (double)f10 * d11;
        int n14 = (int)(d10 /= d12);
        double d13 = (double)object.height() / d12;
        n10 = (int)d13;
        n11 = n12 - n14;
        n12 += n14;
        byte by2 = n13 - n10;
        n13 += n10;
        object = this.o;
        CaptureRequest.Key key = CaptureRequest.SCALER_CROP_REGION;
        Rect rect = new Rect(n11, (int)by2, n12, n13);
        object.set(key, (Object)rect);
        object = this.o;
        Object object4 = CaptureRequest.JPEG_ORIENTATION;
        by2 = this.c0();
        object2 = (int)by2;
        object.set(object4, object2);
        object = this.o;
        object4 = CaptureRequest.JPEG_QUALITY;
        by2 = 90;
        f10 = 1.26E-43f;
        object2 = by2;
        object.set(object4, object2);
        object = this.n;
        object4 = this.p;
        try {
            object.post((Runnable)object4);
        }
        catch (CameraAccessException cameraAccessException) {
            cameraAccessException.printStackTrace();
        }
    }

    private void d0() {
        Object object = Build.MANUFACTURER;
        String string2 = Build.MODEL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("init take photo manufacturer=");
        stringBuilder.append((String)object);
        String string3 = ",model=";
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        d.v.d.h.f.a(stringBuilder.toString());
        string2 = r;
        boolean bl2 = string2.equalsIgnoreCase((String)object);
        if (bl2) {
            this.l = object = new f(this);
            return;
        }
        string2 = s;
        boolean bl3 = string2.equalsIgnoreCase((String)object);
        if (bl3) {
            this.l = object = new f(this);
            return;
        }
        this.l = object = new f(this);
    }

    public List A() {
        Surface surface = this.m.J();
        Surface[] surfaceArray = new Surface[]{surface, surface = this.m.j()};
        return Arrays.asList(surfaceArray);
    }

    public List F() {
        Surface surface = this.m.J();
        Surface[] surfaceArray = new Surface[]{surface, surface = this.m.j(), surface = this.m.f1()};
        return Arrays.asList(surfaceArray);
    }

    public int G() {
        return 1;
    }

    public d.v.d.i.e.g a0() {
        return this.m.e1();
    }

    public Surface b0() {
        return this.m.f1();
    }

    public int c0() {
        return this.m.r();
    }

    public void e0() {
        d.v.d.h.f.a("take Burst end ");
        this.Y();
    }

    public void f0() {
        d.v.d.h.f.a("take Burst Start ");
        this.Z();
    }

    public void g0() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("take photo getPhotoStatus=");
        Object object2 = this.a0().get();
        ((StringBuilder)object).append(object2);
        object = ((StringBuilder)object).toString();
        d.v.d.h.f.a((String)object);
        boolean bl2 = this.i();
        if (bl2) {
            return;
        }
        object = this.a0();
        bl2 = ((d.v.d.i.e.g)object).o();
        if (bl2) {
            d.v.d.h.f.a("current is photo start or prepare ,return");
            return;
        }
        object = this.a0();
        object2 = 1;
        ((d.v.d.i.e.g)object).r((Integer)object2);
        this.l.b();
    }

    public void h(CaptureResult captureResult, CaptureRequest captureRequest) {
        this.l.c(captureResult);
    }

    public void h0(CaptureRequest.Builder builder) {
        e e10 = this.m;
        int n10 = (Integer)this.u().get();
        e10.R0(builder, n10);
    }
}

