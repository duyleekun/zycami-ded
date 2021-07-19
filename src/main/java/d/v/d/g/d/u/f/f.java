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
import d.v.d.g.d.u.f.a;
import d.v.d.g.d.u.f.f$a;
import d.v.d.g.d.u.f.g;
import d.v.d.i.c.c;
import d.v.d.i.f.i;
import d.v.d.i.f.u;

public class f
implements g {
    private static final int g = 0;
    private static final int h = 1;
    private static final int i = 2;
    private static final int j = 3;
    private static final int k = 5;
    private int a = 0;
    private int b;
    private int c;
    private final d d;
    private final Runnable e;
    private final Runnable f;

    public f(d d10) {
        int n10;
        this.b = n10 = -1;
        this.c = n10;
        Runnable runnable = new a(this);
        this.e = runnable;
        super(this);
        this.f = runnable;
        this.d = d10;
    }

    public static /* synthetic */ d a(f f10) {
        return f10.d;
    }

    public static /* synthetic */ int f(f f10, int n10) {
        f10.a = n10;
        return n10;
    }

    public static /* synthetic */ void g(f f10, CaptureRequest.Builder builder) {
        f10.q(builder);
    }

    private void h() {
        int n10;
        int n11;
        Object object;
        Object object2;
        int n12;
        block39: {
            block38: {
                n12 = 4;
                object2 = new StringBuilder();
                object = "capture Still Picture mPhotoState=";
                ((StringBuilder)object2).append((String)object);
                n11 = this.a;
                ((StringBuilder)object2).append(n11);
                object2 = ((StringBuilder)object2).toString();
                d.v.d.h.f.a((String)object2);
                n10 = this.i();
                if (n10 == 0) break block38;
                return;
            }
            n10 = this.a;
            n11 = 5;
            if (n10 != n11) break block39;
            object2 = "current is STATE_WAITING_TAKE, return";
            d.v.d.h.f.a((String)object2);
            return;
        }
        this.a = n11;
        this.o();
        object2 = this.d;
        object2 = ((n)object2).c;
        n11 = 2;
        object2 = object2.createCaptureRequest(n11);
        Object object3 = CaptureRequest.CONTROL_AF_MODE;
        Object object4 = n12;
        object2.set(object3, object4);
        object3 = this.d;
        object3 = object3.b0();
        object2.addTarget((Surface)object3);
        object3 = this.d;
        object3 = object3.z();
        object2.addTarget((Surface)object3);
        this.q((CaptureRequest.Builder)object2);
        object3 = this.d;
        object3.h0((CaptureRequest.Builder)object2);
        object3 = CaptureRequest.JPEG_ORIENTATION;
        object4 = this.d;
        int by2 = ((d)object4).c0();
        object4 = by2;
        object2.set(object3, object4);
        object3 = CaptureRequest.JPEG_QUALITY;
        byte by3 = 90;
        object4 = by3;
        object2.set(object3, object4);
        object3 = "capture Still Picture done";
        d.v.d.h.f.a((String)object3);
        object3 = this.d;
        object3 = object3.a0();
        object = n11;
        object3.r((Integer)object);
        object = this.d;
        object = ((n)object).d;
        object.stopRepeating();
        object = this.d;
        object = ((n)object).d;
        object2 = object2.build();
        object3 = new f$a(this);
        object4 = this.d;
        object4 = ((n)object4).o();
        try {
            object.capture((CaptureRequest)object2, (CameraCaptureSession.CaptureCallback)object3, (Handler)object4);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            n10 = 0;
            this.a = 0;
            object2 = this.d.a0();
            Integer n13 = n12;
            ((d.v.d.i.e.g)object2).r(n13);
        }
    }

    private boolean i() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("checkStatus getDeviceStatus=");
        d.v.d.i.a.a a10 = this.d.p();
        ((StringBuilder)object).append(a10);
        ((StringBuilder)object).append("getPreviewStatus=");
        a10 = this.d.y();
        ((StringBuilder)object).append(a10);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.d.p();
        boolean bl2 = ((c)object).r();
        boolean bl3 = true;
        if (!bl2) {
            d.v.d.h.f.a("current is not session succeed ,return");
            return bl3;
        }
        object = this.d.y();
        bl2 = ((u)object).o();
        if (!bl2) {
            d.v.d.h.f.a("current is not preview ing ,return");
            return bl3;
        }
        return false;
    }

    private /* synthetic */ void j() {
        d.v.d.h.f.a("time out capture picture");
        this.h();
    }

    private void l() {
        int n10;
        int n11;
        Object object;
        Object object2;
        block21: {
            block20: {
                object2 = new StringBuilder();
                object = "lock focus mPhotoState=";
                ((StringBuilder)object2).append((String)object);
                n11 = this.a;
                ((StringBuilder)object2).append(n11);
                object2 = ((StringBuilder)object2).toString();
                d.v.d.h.f.a((String)object2);
                n10 = this.i();
                if (n10 == 0) break block20;
                return;
            }
            n10 = this.a;
            n11 = 1;
            if (n10 != n11) break block21;
            object2 = "current is wait af lock , return";
            d.v.d.h.f.a((String)object2);
            return;
        }
        this.a = n11;
        this.n();
        object2 = this.d;
        object2 = ((n)object2).c;
        object2 = object2.createCaptureRequest(n11);
        Object object3 = this.d;
        object3 = ((n)object3).z();
        object2.addTarget((Surface)object3);
        this.q((CaptureRequest.Builder)object2);
        object3 = CaptureRequest.CONTROL_AF_TRIGGER;
        object = n11;
        object2.set((CaptureRequest.Key)object3, object);
        object = this.d;
        object = ((n)object).d;
        object2 = object2.build();
        object3 = this.d;
        object3 = ((n)object3).s();
        d d10 = this.d;
        d10 = d10.o();
        try {
            object.capture((CaptureRequest)object2, (CameraCaptureSession.CaptureCallback)object3, (Handler)d10);
        }
        catch (CameraAccessException cameraAccessException) {
            cameraAccessException.printStackTrace();
            object = new StringBuilder();
            object3 = "look focus failed =";
            ((StringBuilder)object).append((String)object3);
            Object object4 = cameraAccessException.toString();
            ((StringBuilder)object).append((String)object4);
            d.v.d.h.f.a(((StringBuilder)object).toString());
            n10 = 0;
            this.a = 0;
            object4 = this.d.a0();
            n11 = 4;
            object = n11;
            ((d.v.d.i.e.g)object4).r((Integer)object);
        }
    }

    private void m() {
        int n10;
        int n11;
        Object object;
        Object object2;
        block26: {
            block25: {
                object2 = new StringBuilder();
                object = "start trigger ae mPhotoState=";
                ((StringBuilder)object2).append((String)object);
                n11 = this.a;
                ((StringBuilder)object2).append(n11);
                object2 = ((StringBuilder)object2).toString();
                d.v.d.h.f.a((String)object2);
                n10 = this.i();
                if (n10 == 0) break block25;
                return;
            }
            n10 = this.a;
            n11 = 2;
            if (n10 != n11) break block26;
            object2 = "current is wait ae lock , return";
            d.v.d.h.f.a((String)object2);
            return;
        }
        this.a = n11;
        this.n();
        object2 = this.d;
        object2 = ((n)object2).c;
        n11 = 1;
        object2 = object2.createCaptureRequest(n11);
        Object object3 = this.d;
        object3 = ((n)object3).z();
        object2.addTarget((Surface)object3);
        object3 = this.d;
        ((d)object3).h0((CaptureRequest.Builder)object2);
        this.q((CaptureRequest.Builder)object2);
        object3 = CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER;
        object = n11;
        object2.set((CaptureRequest.Key)object3, object);
        object = this.d;
        object = ((n)object).d;
        object2 = object2.build();
        object3 = this.d;
        object3 = ((n)object3).s();
        d d10 = this.d;
        d10 = d10.o();
        try {
            object.capture((CaptureRequest)object2, (CameraCaptureSession.CaptureCallback)object3, (Handler)d10);
        }
        catch (CameraAccessException cameraAccessException) {
            cameraAccessException.printStackTrace();
            object = new StringBuilder();
            object3 = "look focus failed =";
            ((StringBuilder)object).append((String)object3);
            Object object4 = cameraAccessException.toString();
            ((StringBuilder)object).append((String)object4);
            d.v.d.h.f.a(((StringBuilder)object).toString());
            n10 = 0;
            this.a = 0;
            object4 = this.d.a0();
            n11 = 4;
            object = n11;
            ((d.v.d.i.e.g)object4).r((Integer)object);
        }
    }

    private void n() {
        d.v.d.h.f.a("start TimeOut");
        Handler handler = this.d.o();
        Runnable runnable = this.e;
        handler.removeCallbacks(runnable);
        handler = this.d.o();
        runnable = this.e;
        handler.postDelayed(runnable, 2000L);
    }

    private void o() {
        d.v.d.h.f.a("stop TimeOut");
        Handler handler = this.d.o();
        Runnable runnable = this.e;
        handler.removeCallbacks(runnable);
    }

    private void q(CaptureRequest.Builder builder) {
        if (builder == null) {
            return;
        }
        CaptureRequest.Key key = CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION;
        Object object = this.d.q().get();
        builder.set(key, object);
        this.d.R(builder);
        key = this.d.a;
        object = CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE;
        key = (Rect)key.get((CameraCharacteristics.Key)object);
        float f10 = ((Float)this.d.D().get()).floatValue();
        int n10 = key.width() / 2;
        int n11 = key.height() / 2;
        double d10 = key.width();
        double d11 = (double)f10 * 2.0;
        int n12 = (int)(d10 / d11);
        int n13 = (int)((double)key.height() / d11);
        int n14 = n10 - n12;
        n10 += n12;
        n12 = n11 - n13;
        key = CaptureRequest.SCALER_CROP_REGION;
        Rect rect = new Rect(n14, n12, n10, n11 += n13);
        builder.set(key, (Object)rect);
    }

    public void b() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("takePhoto Universal mLastAfState=");
        int n10 = this.c;
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(",mLastAeState=");
        n10 = this.b;
        ((StringBuilder)object).append(n10);
        String string2 = ",mPhotoState=";
        ((StringBuilder)object).append(string2);
        n10 = this.a;
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        d.v.d.h.f.a((String)object);
        int n11 = this.a;
        if (n11 != 0) {
            return;
        }
        object = this.d.u();
        n10 = (int)(((i)object).r() ? 1 : 0);
        if (n10 == 0 && (n11 = (int)(((i)object).p() ? 1 : 0)) == 0) {
            this.m();
            return;
        }
        this.h();
    }

    public void c(CaptureResult object) {
        block19: {
            block18: {
                int n10;
                String string2;
                int n11;
                int n12;
                Object object2;
                Object object3;
                block17: {
                    int n13;
                    int n14;
                    object3 = CaptureResult.CONTROL_AF_STATE;
                    if ((object3 = (Integer)object.get((CaptureResult.Key)object3)) != null && (n14 = this.c) != (n13 = ((Integer)object3).intValue())) {
                        this.c = n14 = ((Integer)object3).intValue();
                    }
                    if ((object = (Integer)object.get((CaptureResult.Key)(object2 = CaptureResult.CONTROL_AE_STATE))) != null && (n14 = this.b) != (n13 = ((Integer)object).intValue())) {
                        this.b = n14 = ((Integer)object).intValue();
                    }
                    n14 = this.a;
                    n13 = 1;
                    n12 = 4;
                    n11 = 5;
                    string2 = " afState=";
                    if (n14 == n13) break block17;
                    n13 = 3;
                    int n15 = 2;
                    if (n14 != n15) {
                        if (n14 != n13) {
                            if (n14 == n11) {
                                object2 = new StringBuilder();
                                String string3 = "STATE_WAITING_TAKE ae State===";
                                ((StringBuilder)object2).append(string3);
                                ((StringBuilder)object2).append(object);
                                ((StringBuilder)object2).append(string2);
                                ((StringBuilder)object2).append(object3);
                                object = ((StringBuilder)object2).toString();
                                d.v.d.h.f.a((String)object);
                            }
                        } else {
                            object2 = new StringBuilder();
                            String string4 = "STATE_WAITING_LOCK_AE_DONE ae State===";
                            ((StringBuilder)object2).append(string4);
                            ((StringBuilder)object2).append(object);
                            ((StringBuilder)object2).append(string2);
                            ((StringBuilder)object2).append(object3);
                            object3 = ((StringBuilder)object2).toString();
                            d.v.d.h.f.a((String)object3);
                            if (object == null) {
                                this.h();
                                return;
                            }
                            int n16 = (Integer)object;
                            if (n16 == n15) {
                                this.h();
                                return;
                            }
                            int n17 = (Integer)object;
                            if (n17 == n12) {
                                this.h();
                                return;
                            }
                        }
                    } else {
                        int n18;
                        object2 = new StringBuilder();
                        String string5 = "STATE_WAITING_LOCK_AE_START ae State===";
                        ((StringBuilder)object2).append(string5);
                        ((StringBuilder)object2).append(object);
                        ((StringBuilder)object2).append(string2);
                        ((StringBuilder)object2).append(object3);
                        object3 = ((StringBuilder)object2).toString();
                        d.v.d.h.f.a((String)object3);
                        if (object == null) {
                            this.h();
                            return;
                        }
                        int n19 = (Integer)object;
                        if (n11 == n19 || n15 == (n18 = ((Integer)object).intValue())) {
                            this.a = n13;
                            return;
                        }
                    }
                    break block18;
                }
                object2 = new StringBuilder();
                String string6 = "STATE_WAITING_LOCK_AF ae State===";
                ((StringBuilder)object2).append(string6);
                ((StringBuilder)object2).append(object);
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append(object3);
                object = ((StringBuilder)object2).toString();
                d.v.d.h.f.a((String)object);
                if (object3 == null || (n10 = ((Integer)object3).intValue()) == 0) break block19;
                n10 = (Integer)object3;
                if (n12 == n10 || n11 == (n10 = ((Integer)object3).intValue())) {
                    this.h();
                }
            }
            return;
        }
        this.h();
    }

    public void d() {
    }

    public void e() {
    }

    public int getAfState() {
        return this.c;
    }

    public /* synthetic */ void k() {
        this.j();
    }

    public void p() {
        Object object = new StringBuilder();
        Object object2 = "unlockFocusAe mPhotoState=";
        ((StringBuilder)object).append((String)object2);
        int n10 = this.a;
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        d.v.d.h.f.a((String)object);
        int n11 = this.a;
        if (n11 == 0) {
            d.v.d.h.f.a("current is STATE_PREVIEW,return");
            object = this.d.a0();
            object2 = 3;
            ((d.v.d.i.e.g)object).r((Integer)object2);
            return;
        }
        n11 = (int)(this.i() ? 1 : 0);
        if (n11 != 0) {
            object = this.d.a0();
            object2 = 4;
            ((d.v.d.i.e.g)object).r((Integer)object2);
            this.a = 0;
            return;
        }
        object = this.d.o();
        object2 = this.f;
        object.postDelayed((Runnable)object2, (long)20);
    }
}

