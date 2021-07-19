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
import d.v.d.g.d.u.f.c;
import d.v.d.g.d.u.f.g;
import d.v.d.h.f;
import d.v.d.i.a.a;
import d.v.d.i.f.u;

public class i
implements g {
    private static final int g = 0;
    private static final int h = 1;
    private static final int i = 2;
    private static final int j = 3;
    private static final int k = 4;
    private int a = 0;
    private int b;
    private int c;
    private final d d;
    private boolean e;
    private final Runnable f;

    public i(d d10) {
        int n10;
        this.b = n10 = -1;
        this.c = n10;
        this.e = true;
        c c10 = new c(this);
        this.f = c10;
        this.d = d10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a() {
        Object object = new StringBuilder();
        Object object2 = "capture Still Picture mPhotoState=";
        ((StringBuilder)object).append((String)object2);
        int n10 = this.a;
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        d.v.d.h.f.a((String)object);
        int n11 = this.f();
        if (n11 != 0) {
            return;
        }
        n11 = this.a;
        n10 = 4;
        if (n11 == n10) {
            d.v.d.h.f.a("current is STATE_WAITING_TAKE, return");
            return;
        }
        this.a = n10;
        this.n();
        object = this.d.a0();
        int n12 = 2;
        Object object3 = n12;
        ((d.v.d.i.e.g)object).r((Integer)object3);
        try {
            Object object4;
            boolean bl2;
            boolean bl3;
            object = this.d;
            object = ((n)object).l(n12);
            object3 = CaptureRequest.CONTROL_CAPTURE_INTENT;
            Integer n13 = n12;
            object.set((CaptureRequest.Key)object3, (Object)n13);
            object3 = this.d;
            object3 = ((d)object3).b0();
            object.addTarget((Surface)object3);
            this.p((CaptureRequest.Builder)object);
            object3 = this.d;
            object3 = ((n)object3).u();
            boolean bl4 = ((d.v.d.i.f.i)object3).q();
            int n14 = 1;
            if (bl4 || (bl4 = ((d.v.d.i.f.i)object3).r())) {
                n13 = CaptureRequest.CONTROL_AE_MODE;
                Integer n15 = n14;
                object.set((CaptureRequest.Key)n13, (Object)n15);
                n13 = CaptureRequest.FLASH_MODE;
                n15 = n12;
                object.set((CaptureRequest.Key)n13, (Object)n15);
            }
            if ((bl3 = ((d.v.d.i.f.i)object3).o()) && !(bl2 = this.e)) {
                object3 = CaptureRequest.CONTROL_AE_MODE;
                n13 = n14;
                object.set((CaptureRequest.Key)object3, (Object)n13);
                object3 = CaptureRequest.FLASH_MODE;
                object4 = n12;
                object.set((CaptureRequest.Key)object3, object4);
            }
            object4 = CaptureRequest.JPEG_ORIENTATION;
            object3 = this.d;
            int n16 = ((d)object3).c0();
            object3 = n16;
            object.set((CaptureRequest.Key)object4, object3);
            object4 = CaptureRequest.JPEG_QUALITY;
            byte by2 = 90;
            object3 = by2;
            object.set((CaptureRequest.Key)object4, object3);
            object4 = "capture Still Picture done";
            d.v.d.h.f.a((String)object4);
            object4 = this.d;
            ((n)object4).T();
            object4 = this.d;
            boolean bl5 = false;
            object3 = null;
            ((n)object4).O((CaptureRequest.Builder)object, null, null);
            this.o();
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            StringBuilder stringBuilder = new StringBuilder();
            object3 = "capture still photo failed =";
            stringBuilder.append((String)object3);
            Object object5 = exception.toString();
            stringBuilder.append((String)object5);
            d.v.d.h.f.a(stringBuilder.toString());
            n11 = 0;
            this.a = 0;
            object5 = this.d.a0();
            object2 = n10;
            ((d.v.d.i.e.g)object5).r((Integer)object2);
        }
    }

    private boolean f() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("checkStatus getDeviceStatus=");
        a a10 = this.d.p();
        ((StringBuilder)object).append(a10);
        ((StringBuilder)object).append("getPreviewStatus=");
        a10 = this.d.y();
        ((StringBuilder)object).append(a10);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.d.p();
        boolean bl2 = ((d.v.d.i.c.c)object).r();
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

    private /* synthetic */ void g() {
        d.v.d.h.f.a("time out capture picture");
        this.a();
    }

    private void i() {
        Object object = new StringBuilder();
        String string2 = "lock ae mPhotoState=";
        ((StringBuilder)object).append(string2);
        int n10 = this.a;
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        d.v.d.h.f.a((String)object);
        int n11 = this.f();
        if (n11 != 0) {
            return;
        }
        n11 = this.a;
        n10 = 3;
        if (n11 == n10) {
            d.v.d.h.f.a("current is STATE_WAITING_PREPARE");
            return;
        }
        this.a = n10;
        object = this.d.r();
        string2 = CaptureRequest.CONTROL_AE_LOCK;
        Boolean bl2 = Boolean.TRUE;
        object.set((CaptureRequest.Key)string2, (Object)bl2);
        object = this.d;
        string2 = ((n)object).r();
        bl2 = this.d.s();
        Handler handler = this.d.o();
        ((n)object).P((CaptureRequest.Builder)string2, (CameraCaptureSession.CaptureCallback)bl2, handler);
    }

    private void j() {
        int n10;
        int n11;
        Object object;
        Object object2;
        block22: {
            block21: {
                object2 = new StringBuilder();
                object = "lock focus mPhotoState=";
                ((StringBuilder)object2).append((String)object);
                n11 = this.a;
                ((StringBuilder)object2).append(n11);
                object2 = ((StringBuilder)object2).toString();
                d.v.d.h.f.a((String)object2);
                n10 = this.f();
                if (n10 == 0) break block21;
                return;
            }
            n10 = this.a;
            n11 = 1;
            if (n10 != n11) break block22;
            object2 = "current is wait af lock , return";
            d.v.d.h.f.a((String)object2);
            return;
        }
        this.a = n11;
        this.m();
        object2 = this.d;
        object2 = ((n)object2).c;
        object2 = object2.createCaptureRequest(n11);
        Object object3 = this.d;
        object3 = ((n)object3).z();
        object2.addTarget((Surface)object3);
        this.p((CaptureRequest.Builder)object2);
        object3 = this.d;
        ((d)object3).h0((CaptureRequest.Builder)object2);
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

    private void k() {
        CharSequence charSequence = new StringBuilder();
        Object object = "openFlash mNeedOpenFlash=";
        charSequence.append((String)object);
        boolean bl2 = this.e;
        charSequence.append(bl2);
        charSequence = charSequence.toString();
        d.v.d.h.f.a((String)charSequence);
        boolean bl3 = this.e;
        if (!bl3) {
            return;
        }
        this.e = false;
        charSequence = this.d.r();
        object = CaptureRequest.CONTROL_AE_MODE;
        Integer n10 = 1;
        charSequence.set((CaptureRequest.Key)object, n10);
        object = CaptureRequest.FLASH_MODE;
        n10 = 2;
        charSequence.set((CaptureRequest.Key)object, n10);
        object = this.d;
        n10 = ((n)object).s();
        Handler handler = this.d.o();
        ((n)object).P((CaptureRequest.Builder)charSequence, (CameraCaptureSession.CaptureCallback)n10, handler);
    }

    private void l() {
        int n10;
        int n11;
        Object object;
        Object object2;
        block21: {
            block20: {
                object2 = new StringBuilder();
                object = "start trigger ae mPhotoState=";
                ((StringBuilder)object2).append((String)object);
                n11 = this.a;
                ((StringBuilder)object2).append(n11);
                object2 = ((StringBuilder)object2).toString();
                d.v.d.h.f.a((String)object2);
                n10 = this.f();
                if (n10 == 0) break block20;
                return;
            }
            n10 = this.a;
            n11 = 2;
            if (n10 != n11) break block21;
            object2 = "current is wait ae lock , return";
            d.v.d.h.f.a((String)object2);
            return;
        }
        this.a = n11;
        this.m();
        object2 = this.d;
        n11 = 1;
        object2 = ((n)object2).l(n11);
        Object object3 = this.d;
        object3 = ((n)object3).z();
        object2.addTarget((Surface)object3);
        this.p((CaptureRequest.Builder)object2);
        object3 = CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER;
        object = n11;
        object2.set((CaptureRequest.Key)object3, object);
        object = this.d;
        object3 = ((n)object).s();
        d d10 = this.d;
        d10 = d10.o();
        try {
            ((n)object).O((CaptureRequest.Builder)object2, (CameraCaptureSession.CaptureCallback)object3, (Handler)d10);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            object = new StringBuilder();
            object3 = "look focus failed =";
            ((StringBuilder)object).append((String)object3);
            Object object4 = exception.toString();
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
        d.v.d.h.f.a("start TimeOut");
        Handler handler = this.d.o();
        Runnable runnable = this.f;
        handler.removeCallbacks(runnable);
        handler = this.d.o();
        runnable = this.f;
        handler.postDelayed(runnable, 2200L);
    }

    private void n() {
        d.v.d.h.f.a("stop TimeOut");
        Handler handler = this.d.o();
        Runnable runnable = this.f;
        handler.removeCallbacks(runnable);
    }

    private void p(CaptureRequest.Builder builder) {
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
        n10 = (int)(((d.v.d.i.f.i)object).r() ? 1 : 0);
        if (n10 == 0 && (n11 = (int)(((d.v.d.i.f.i)object).p() ? 1 : 0)) == 0) {
            this.l();
            return;
        }
        this.a();
    }

    public void c(CaptureResult object) {
        block20: {
            block19: {
                int n10;
                int n11;
                String string2;
                int n12;
                Object object2;
                Object object3;
                block18: {
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
                    string2 = " afState=";
                    if (n14 == n13) break block18;
                    n13 = 2;
                    if (n14 != n13) {
                        n13 = 3;
                        if (n14 != n13) {
                            if (n14 == n12) {
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
                            String string4 = "STATE_WAITING_PREPARE ae State===";
                            ((StringBuilder)object2).append(string4);
                            ((StringBuilder)object2).append(object);
                            ((StringBuilder)object2).append(string2);
                            ((StringBuilder)object2).append(object3);
                            object3 = ((StringBuilder)object2).toString();
                            d.v.d.h.f.a((String)object3);
                            if (object == null) {
                                this.a();
                                return;
                            }
                            int n15 = (Integer)object;
                            if (n15 == n13) {
                                this.j();
                            }
                        }
                    } else {
                        object2 = new StringBuilder();
                        String string5 = "STATE_WAITING_LOCK_AE ae State===";
                        ((StringBuilder)object2).append(string5);
                        ((StringBuilder)object2).append(object);
                        ((StringBuilder)object2).append(string2);
                        ((StringBuilder)object2).append(object3);
                        object3 = ((StringBuilder)object2).toString();
                        d.v.d.h.f.a((String)object3);
                        if (object == null) {
                            this.a();
                            return;
                        }
                        int n16 = (Integer)object;
                        if (n16 == n12) {
                            object = this.d.u();
                            boolean bl2 = ((d.v.d.i.f.i)object).o();
                            if (bl2 || (bl2 = ((d.v.d.i.f.i)(object = this.d.u())).q())) {
                                this.k();
                            }
                            return;
                        }
                        int n17 = (Integer)object;
                        if (n17 == n13) {
                            this.i();
                        }
                    }
                    break block19;
                }
                object2 = new StringBuilder();
                String string6 = "STATE_WAITING_LOCK_AF ae State===";
                ((StringBuilder)object2).append(string6);
                ((StringBuilder)object2).append(object);
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append(object3);
                object = ((StringBuilder)object2).toString();
                d.v.d.h.f.a((String)object);
                if (object3 == null || (n11 = ((Integer)object3).intValue()) == 0) break block20;
                n11 = (Integer)object3;
                if (n12 == n11 || (n11 = 5) == (n10 = ((Integer)object3).intValue())) {
                    this.a();
                }
            }
            return;
        }
        this.a();
    }

    public void d() {
    }

    public void e() {
    }

    public int getAfState() {
        return this.c;
    }

    public /* synthetic */ void h() {
        this.g();
    }

    public void o() {
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
            return;
        }
        n11 = (int)(this.f() ? 1 : 0);
        if (n11 != 0) {
            return;
        }
        d.v.d.h.f.a("un lock focus ae and af");
        object = this.d.a0();
        n10 = 3;
        object2 = n10;
        ((d.v.d.i.e.g)object).r((Integer)object2);
        object = this.d;
        object2 = ((n)object).c;
        if (object2 != null && (object2 = ((n)object).d) != null) {
            object2 = null;
            this.a = 0;
            n10 = 1;
            this.e = n10;
            object = ((n)object).r();
            Object object3 = CaptureRequest.CONTROL_AF_MODE;
            int n12 = 4;
            Object object4 = n12;
            object.set(object3, object4);
            object = this.d.r();
            object3 = CaptureRequest.CONTROL_AE_LOCK;
            object4 = Boolean.FALSE;
            object.set(object3, object4);
            object = this.d;
            object3 = ((n)object).r();
            ((d)object).h0((CaptureRequest.Builder)object3);
            object = this.d;
            object3 = ((n)object).r();
            object4 = this.d.s();
            Handler handler = this.d.o();
            ((n)object).P((CaptureRequest.Builder)object3, (CameraCaptureSession.CaptureCallback)object4, handler);
            object = this.d;
            object = ((n)object).l(n10);
            object2 = this.d;
            object2 = ((n)object2).z();
            object.addTarget((Surface)object2);
            object2 = CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER;
            int n13 = 2;
            object4 = n13;
            object.set((CaptureRequest.Key)object2, object4);
            object2 = CaptureRequest.CONTROL_AF_TRIGGER;
            object3 = n13;
            object.set((CaptureRequest.Key)object2, object3);
            this.p((CaptureRequest.Builder)object);
            object2 = this.d;
            object3 = ((n)object2).s();
            object4 = this.d;
            object4 = ((n)object4).o();
            try {
                ((n)object2).O((CaptureRequest.Builder)object, (CameraCaptureSession.CaptureCallback)object3, (Handler)object4);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}

