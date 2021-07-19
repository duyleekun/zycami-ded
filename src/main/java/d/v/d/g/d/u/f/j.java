/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.hardware.camera2.CameraAccessException
 *  android.hardware.camera2.CameraCaptureSession$CaptureCallback
 *  android.hardware.camera2.CameraCharacteristics
 *  android.hardware.camera2.CameraCharacteristics$Key
 *  android.hardware.camera2.CaptureRequest
 *  android.hardware.camera2.CaptureRequest$Builder
 *  android.hardware.camera2.CaptureRequest$Key
 *  android.hardware.camera2.CaptureResult
 *  android.hardware.camera2.CaptureResult$Key
 *  android.os.Handler
 *  android.view.Surface
 */
package d.v.d.g.d.u.f;

import android.graphics.Rect;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.os.Handler;
import android.view.Surface;
import d.v.d.g.d.n;
import d.v.d.g.d.u.d;
import d.v.d.g.d.u.f.e;
import d.v.d.g.d.u.f.g;
import d.v.d.h.f;
import d.v.d.i.f.i;

public class j
implements g {
    public static final int f = 1100;
    private int a;
    private int b;
    private final d c;
    private int d;
    private boolean e;

    public j(d d10) {
        int n10;
        this.a = n10 = -1;
        this.b = n10;
        this.d = 1500;
        this.e = false;
        this.c = d10;
    }

    private void a() {
        Object object;
        block29: {
            object = "capture Still Picture";
            d.v.d.h.f.a((String)object);
            object = this.c;
            boolean bl2 = ((n)object).i();
            if (!bl2) break block29;
            return;
        }
        object = this.c;
        object = ((n)object).c;
        int n10 = 2;
        object = object.createCaptureRequest(n10);
        Object object2 = CaptureRequest.CONTROL_CAPTURE_INTENT;
        Object object3 = n10;
        object.set((CaptureRequest.Key)object2, object3);
        object2 = this.c;
        object2 = ((d)object2).b0();
        object.addTarget((Surface)object2);
        object2 = this.c;
        object2 = ((n)object2).z();
        object.addTarget((Surface)object2);
        this.i((CaptureRequest.Builder)object);
        object2 = CaptureRequest.JPEG_ORIENTATION;
        object3 = this.c;
        int by2 = ((d)object3).c0();
        object3 = by2;
        object.set((CaptureRequest.Key)object2, object3);
        object2 = CaptureRequest.JPEG_QUALITY;
        byte by3 = 90;
        object3 = by3;
        object.set((CaptureRequest.Key)object2, object3);
        object2 = "capture Still Picture done";
        d.v.d.h.f.a((String)object2);
        object2 = this.c;
        object2 = ((d)object2).a0();
        Object object4 = n10;
        ((d.v.d.i.e.g)object2).r((Integer)object4);
        object4 = this.c;
        object2 = null;
        ((n)object4).O((CaptureRequest.Builder)object, null, null);
        object = this.c;
        object = ((n)object).o();
        object4 = new e(this);
        long l10 = 500L;
        try {
            object.postDelayed((Runnable)object4, l10);
        }
        catch (CameraAccessException cameraAccessException) {
            cameraAccessException.printStackTrace();
            object = this.c.a0();
            n10 = 4;
            object4 = n10;
            ((d.v.d.i.e.g)object).r((Integer)object4);
        }
    }

    private void f() {
        Object object = this.c.a0();
        int n10 = 3;
        Integer n11 = n10;
        ((d.v.d.i.e.g)object).r(n11);
        d.v.d.h.f.a("close Flash");
        object = this.c.u();
        boolean bl2 = ((i)object).r();
        if (!bl2) {
            object = this.c.r();
            n11 = CaptureRequest.CONTROL_AE_MODE;
            Integer n12 = 1;
            object.set((CaptureRequest.Key)n11, (Object)n12);
            n11 = CaptureRequest.FLASH_MODE;
            n12 = 0;
            object.set((CaptureRequest.Key)n11, (Object)n12);
            object = this.c;
            n11 = ((n)object).r();
            n12 = this.c.s();
            Handler handler = this.c.o();
            ((n)object).P((CaptureRequest.Builder)n11, (CameraCaptureSession.CaptureCallback)n12, handler);
        }
    }

    public static /* synthetic */ void g(j j10) {
        j10.a();
    }

    public static /* synthetic */ void h(j j10) {
        j10.f();
    }

    private void i(CaptureRequest.Builder builder) {
        Object object;
        float f10;
        int n10;
        if (builder == null) {
            return;
        }
        CharSequence charSequence = new StringBuilder();
        String string2 = "updateParameter mNeedFlash=";
        charSequence.append(string2);
        int n11 = this.e;
        charSequence.append(n11 != 0);
        charSequence = charSequence.toString();
        d.v.d.h.f.a((String)charSequence);
        int n12 = this.e;
        n11 = 2;
        if (n12 != 0) {
            charSequence = CaptureRequest.CONTROL_AE_MODE;
            n10 = 1;
            f10 = Float.MIN_VALUE;
            object = n10;
            builder.set((CaptureRequest.Key)charSequence, object);
            charSequence = CaptureRequest.FLASH_MODE;
            object = n11;
            builder.set((CaptureRequest.Key)charSequence, object);
        }
        charSequence = CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION;
        object = this.c.q().get();
        builder.set((CaptureRequest.Key)charSequence, object);
        this.c.R(builder);
        charSequence = this.c.a;
        object = CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE;
        charSequence = (Rect)charSequence.get((CameraCharacteristics.Key)object);
        f10 = ((Float)this.c.D().get()).floatValue();
        int n13 = charSequence.width() / n11;
        int n14 = charSequence.height() / n11;
        double d10 = charSequence.width();
        double d11 = (double)f10 * 2.0;
        int n15 = (int)(d10 / d11);
        n12 = (int)((double)charSequence.height() / d11);
        n11 = n13 - n15;
        n10 = n14 - n12;
        charSequence = CaptureRequest.SCALER_CROP_REGION;
        Rect rect = new Rect(n11, n10, n13 += n15, n14 += n12);
        builder.set((CaptureRequest.Key)charSequence, (Object)rect);
    }

    public void b() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("takePhoto mLastAfState=");
        int n10 = this.b;
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(",mLastAeState=");
        n10 = this.a;
        ((StringBuilder)object).append(n10);
        Object object2 = ",mPhotoState=\uff0cmCurrentIso=";
        ((StringBuilder)object).append((String)object2);
        n10 = this.d;
        ((StringBuilder)object).append(n10);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        boolean n11 = false;
        this.e = false;
        object = this.c.u();
        n10 = (int)(((i)object).r() ? 1 : 0);
        if (n10 == 0 && (n10 = (int)(((i)object).p() ? 1 : 0)) == 0) {
            int n12;
            boolean bl2 = ((i)object).o();
            if (bl2 && (n12 = this.d) < (n10 = 1100)) {
                this.a();
                return;
            }
            object = this.c.r();
            object2 = CaptureRequest.CONTROL_AE_MODE;
            int n13 = 1;
            Integer n14 = n13;
            object.set((CaptureRequest.Key)object2, (Object)n14);
            object = this.c.r();
            object2 = CaptureRequest.FLASH_MODE;
            n14 = 2;
            object.set((CaptureRequest.Key)object2, (Object)n14);
            object = this.c;
            object2 = ((n)object).r();
            n14 = this.c.s();
            Handler handler = this.c.o();
            ((n)object).P((CaptureRequest.Builder)object2, (CameraCaptureSession.CaptureCallback)n14, handler);
            this.e = n13;
            object = this.c.o();
            object2 = new d.v.d.g.d.u.f.d(this);
            object.postDelayed((Runnable)object2, 1500L);
            return;
        }
        this.a();
    }

    public void c(CaptureResult object) {
        int n10;
        int n11;
        int n12;
        Object object2 = CaptureResult.CONTROL_AF_STATE;
        if ((object2 = (Integer)object.get((CaptureResult.Key)object2)) != null && (n12 = this.b) != (n11 = ((Integer)object2).intValue())) {
            this.b = n10 = ((Integer)object2).intValue();
        }
        object2 = CaptureResult.CONTROL_AE_STATE;
        if ((object2 = (Integer)object.get((CaptureResult.Key)object2)) != null && (n12 = this.a) != (n11 = ((Integer)object2).intValue())) {
            this.a = n10 = ((Integer)object2).intValue();
        }
        object2 = CaptureResult.SENSOR_SENSITIVITY;
        object = (Integer)object.get((CaptureResult.Key)object2);
        object2 = new StringBuilder();
        String string2 = "processPhoto iso=";
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(object);
        object2 = ((StringBuilder)object2).toString();
        d.v.d.h.f.a((String)object2);
        if (object != null) {
            int n13;
            this.d = n13 = ((Integer)object).intValue();
        }
    }

    public void d() {
    }

    public void e() {
    }

    public int getAfState() {
        return this.b;
    }
}

