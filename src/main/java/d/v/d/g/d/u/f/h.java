/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
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
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.os.Handler;
import android.view.Surface;
import d.v.d.g.d.n;
import d.v.d.g.d.u.d;
import d.v.d.g.d.u.f.b;
import d.v.d.g.d.u.f.g;
import d.v.d.h.f;
import d.v.d.i.a.a;
import d.v.d.i.c.c;
import d.v.d.i.f.i;
import d.v.d.i.f.u;
import java.lang.constant.Constable;

public class h
implements g {
    private static final int d = 0;
    private static final int e = 1;
    private static final int f = 2;
    private static final int g = 3;
    private static final int h = 4;
    private int a = 0;
    private final d b;
    private final Runnable c;

    public h(d d10) {
        b b10 = new b(this);
        this.c = b10;
        this.b = d10;
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
        this.s();
        object = this.b.a0();
        int n12 = 2;
        Object object3 = n12;
        ((d.v.d.i.e.g)object).r((Integer)object3);
        try {
            Object object4;
            boolean bl2;
            object = this.b;
            object = ((n)object).l(n12);
            object3 = CaptureRequest.CONTROL_CAPTURE_INTENT;
            Integer n13 = n12;
            object.set((CaptureRequest.Key)object3, (Object)n13);
            object3 = this.b;
            object3 = ((d)object3).b0();
            object.addTarget((Surface)object3);
            this.u((CaptureRequest.Builder)object);
            object3 = this.b;
            object3 = ((n)object3).u();
            boolean bl3 = ((i)object3).q();
            int n14 = 1;
            if (bl3 || (bl3 = ((i)object3).r())) {
                n13 = CaptureRequest.CONTROL_MODE;
                Integer n15 = n14;
                object.set((CaptureRequest.Key)n13, (Object)n15);
                n13 = CaptureRequest.FLASH_MODE;
                n15 = n12;
                object.set((CaptureRequest.Key)n13, (Object)n15);
            }
            if (bl2 = ((i)object3).o()) {
                object3 = CaptureRequest.CONTROL_AE_MODE;
                n13 = n14;
                object.set((CaptureRequest.Key)object3, (Object)n13);
                object3 = CaptureRequest.FLASH_MODE;
                object4 = n12;
                object.set((CaptureRequest.Key)object3, object4);
            }
            object4 = CaptureRequest.JPEG_ORIENTATION;
            object3 = this.b;
            int n16 = ((d)object3).c0();
            object3 = n16;
            object.set((CaptureRequest.Key)object4, object3);
            object4 = CaptureRequest.JPEG_QUALITY;
            byte by2 = 90;
            object3 = by2;
            object.set((CaptureRequest.Key)object4, object3);
            object4 = "capture Still Picture done";
            d.v.d.h.f.a((String)object4);
            object4 = this.b;
            ((n)object4).T();
            n12 = 0;
            object4 = null;
            this.o((CaptureRequest.Builder)object, null, null);
            this.t();
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
            object5 = this.b.a0();
            object2 = n10;
            ((d.v.d.i.e.g)object5).r((Integer)object2);
        }
    }

    private boolean f() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("checkStatus getDeviceStatus=");
        a a10 = this.b.p();
        ((StringBuilder)object).append(a10);
        ((StringBuilder)object).append("getPreviewStatus=");
        a10 = this.b.y();
        ((StringBuilder)object).append(a10);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.b.p();
        boolean bl2 = ((c)object).r();
        boolean bl3 = true;
        if (!bl2) {
            d.v.d.h.f.a("current is not session succeed ,return");
            return bl3;
        }
        object = this.b.y();
        bl2 = ((u)object).o();
        if (!bl2) {
            d.v.d.h.f.a("current is not preview ing ,return");
            return bl3;
        }
        return false;
    }

    private /* synthetic */ void j() {
        d.v.d.h.f.a("time out capture picture");
        this.a();
    }

    private void l() {
        int n10 = this.a;
        int n11 = 3;
        if (n10 == n11) {
            d.v.d.h.f.a("current is wait ae lock , return");
            return;
        }
        this.a = n11;
        CaptureRequest.Builder builder = this.g();
        CaptureRequest.Key key = CaptureRequest.CONTROL_AE_LOCK;
        Boolean bl2 = Boolean.TRUE;
        builder.set(key, (Object)bl2);
        key = this.h();
        bl2 = this.i();
        this.p(builder, (CameraCaptureSession.CaptureCallback)key, (Handler)bl2);
    }

    private void m() {
        CharSequence charSequence = new StringBuilder();
        String string2 = "lock focus mPhotoState=";
        charSequence.append(string2);
        int n10 = this.a;
        charSequence.append(n10);
        charSequence = charSequence.toString();
        d.v.d.h.f.a((String)charSequence);
        int n11 = this.a;
        n10 = 1;
        Integer n12 = n10;
        if (n11 == n10) {
            d.v.d.h.f.a("current is wait af lock , return");
            return;
        }
        this.a = n10;
        this.r();
        charSequence = this.g();
        string2 = CaptureRequest.CONTROL_AF_MODE;
        charSequence.set((CaptureRequest.Key)string2, n12);
        string2 = CaptureRequest.CONTROL_AF_TRIGGER;
        Integer n13 = 0;
        charSequence.set((CaptureRequest.Key)string2, n13);
        string2 = this.h();
        n13 = this.i();
        this.p((CaptureRequest.Builder)charSequence, (CameraCaptureSession.CaptureCallback)string2, (Handler)n13);
        string2 = CaptureRequest.CONTROL_AF_TRIGGER;
        charSequence.set((CaptureRequest.Key)string2, n12);
        string2 = this.h();
        n12 = this.i();
        this.o((CaptureRequest.Builder)charSequence, (CameraCaptureSession.CaptureCallback)string2, (Handler)n12);
    }

    private void n() {
        Object object = this.g();
        Object object2 = CaptureRequest.CONTROL_AE_MODE;
        object2 = (Integer)object.get((CaptureRequest.Key)object2);
        Object object3 = CaptureRequest.FLASH_MODE;
        object3 = (Integer)object.get((CaptureRequest.Key)object3);
        int n10 = (Integer)object2;
        int n11 = 2;
        int n12 = 1;
        if (n10 == n12 && (n10 = ((Integer)object3).intValue()) == n11) {
            object = "flash is ready open";
            d.v.d.h.f.a((String)object);
        } else {
            d.v.d.h.f.a("open flash");
            object2 = CaptureRequest.CONTROL_AE_MODE;
            object3 = n12;
            object.set((CaptureRequest.Key)object2, object3);
            object2 = CaptureRequest.FLASH_MODE;
            object3 = n11;
            object.set((CaptureRequest.Key)object2, object3);
            object2 = this.h();
            object3 = this.i();
            this.p((CaptureRequest.Builder)object, (CameraCaptureSession.CaptureCallback)object2, (Handler)object3);
        }
    }

    private void o(CaptureRequest.Builder builder, CameraCaptureSession.CaptureCallback captureCallback, Handler handler) {
        u u10 = this.b.y();
        boolean bl2 = u10.o();
        if (!bl2) {
            d.v.d.h.f.a("set Repeating failed,current is not preview ing");
            return;
        }
        this.b.O(builder, captureCallback, handler);
    }

    private void p(CaptureRequest.Builder builder, CameraCaptureSession.CaptureCallback captureCallback, Handler handler) {
        u u10 = this.b.y();
        boolean bl2 = u10.o();
        if (!bl2) {
            d.v.d.h.f.a("set Repeating failed,current is not preview ing");
            return;
        }
        this.b.P(builder, captureCallback, handler);
    }

    private void q() {
        int n10;
        int n11;
        Object object;
        CharSequence charSequence;
        block15: {
            block14: {
                charSequence = new StringBuilder();
                object = "start trigger ae mPhotoState=";
                charSequence.append((String)object);
                n11 = this.a;
                charSequence.append(n11);
                charSequence = charSequence.toString();
                d.v.d.h.f.a((String)charSequence);
                n10 = this.f();
                if (n10 == 0) break block14;
                return;
            }
            n10 = this.a;
            n11 = 2;
            if (n10 != n11) break block15;
            charSequence = "current is wait ae lock , return";
            d.v.d.h.f.a((String)charSequence);
            return;
        }
        this.a = n11;
        this.r();
        charSequence = this.g();
        object = CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER;
        int n12 = 1;
        Object object2 = n12;
        charSequence.set((CaptureRequest.Key)object, object2);
        object = this.h();
        object2 = this.i();
        try {
            this.o((CaptureRequest.Builder)charSequence, (CameraCaptureSession.CaptureCallback)object, (Handler)object2);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            object = new StringBuilder();
            object2 = "look focus failed =";
            ((StringBuilder)object).append((String)object2);
            Object object3 = exception.toString();
            ((StringBuilder)object).append((String)object3);
            d.v.d.h.f.a(((StringBuilder)object).toString());
            n10 = 0;
            this.a = 0;
            object3 = this.b.a0();
            n11 = 4;
            object = n11;
            ((d.v.d.i.e.g)object3).r((Integer)object);
        }
    }

    private void r() {
        d.v.d.h.f.a("start TimeOut");
        Handler handler = this.b.o();
        Runnable runnable = this.c;
        handler.removeCallbacks(runnable);
        handler = this.b.o();
        runnable = this.c;
        handler.postDelayed(runnable, 2200L);
    }

    private void s() {
        d.v.d.h.f.a("stop TimeOut");
        Handler handler = this.b.o();
        Runnable runnable = this.c;
        handler.removeCallbacks(runnable);
    }

    private void u(CaptureRequest.Builder builder) {
        if (builder == null) {
            return;
        }
        CaptureRequest.Key key = CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION;
        Object object = this.b.q().get();
        builder.set(key, object);
        this.b.R(builder);
        key = this.b.a;
        object = CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE;
        key = (Rect)key.get((CameraCharacteristics.Key)object);
        float f10 = ((Float)this.b.D().get()).floatValue();
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
        String string2 = "takePhoto SamSung mPhotoState=";
        ((StringBuilder)object).append(string2);
        int n10 = this.a;
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        d.v.d.h.f.a((String)object);
        int n11 = this.a;
        if (n11 != 0) {
            return;
        }
        object = this.b.u();
        n10 = (int)(((i)object).r() ? 1 : 0);
        if (n10 == 0 && (n11 = (int)(((i)object).p() ? 1 : 0)) == 0) {
            this.q();
            return;
        }
        this.a();
    }

    /*
     * Enabled aggressive block sorting
     */
    public void c(CaptureResult object) {
        int n10;
        Object object2 = CaptureResult.CONTROL_AF_STATE;
        object2 = (Integer)object.get((CaptureResult.Key)object2);
        Object object3 = CaptureResult.CONTROL_AE_STATE;
        object = (Integer)object.get((CaptureResult.Key)object3);
        int n11 = this.a;
        String string2 = " afState=";
        if (n11 == 0) {
            object3 = new StringBuilder();
            String string3 = "STATE_PREVIEW, aeState===";
            ((StringBuilder)object3).append(string3);
            ((StringBuilder)object3).append(object);
            ((StringBuilder)object3).append(string2);
            ((StringBuilder)object3).append(object2);
            object = ((StringBuilder)object3).toString();
            d.v.d.h.f.a((String)object);
            return;
        }
        int n12 = 1;
        int n13 = 4;
        if (n11 != n12) {
            n12 = 2;
            if (n11 != n12) {
                n12 = 3;
                if (n11 != n12) {
                    if (n11 != n13) {
                        return;
                    }
                    object3 = new StringBuilder();
                    String string4 = "STATE_WAITING_TAKE ,aeState===";
                    ((StringBuilder)object3).append(string4);
                    ((StringBuilder)object3).append(object);
                    ((StringBuilder)object3).append(string2);
                    ((StringBuilder)object3).append(object2);
                    object = ((StringBuilder)object3).toString();
                    d.v.d.h.f.a((String)object);
                    return;
                }
                object3 = new StringBuilder();
                String string5 = "STATE_WAITING_LOCK_AE_DONE, aeState===";
                ((StringBuilder)object3).append(string5);
                ((StringBuilder)object3).append(object);
                ((StringBuilder)object3).append(string2);
                ((StringBuilder)object3).append(object2);
                object2 = ((StringBuilder)object3).toString();
                d.v.d.h.f.a((String)object2);
                if (object == null) {
                    this.a();
                    return;
                }
                int n14 = (Integer)object;
                if (n12 != n14) return;
                this.m();
                return;
            }
            object3 = new StringBuilder();
            String string6 = "STATE_WAITING_LOCK_AE, aeState===";
            ((StringBuilder)object3).append(string6);
            ((StringBuilder)object3).append(object);
            ((StringBuilder)object3).append(string2);
            ((StringBuilder)object3).append(object2);
            object2 = ((StringBuilder)object3).toString();
            d.v.d.h.f.a((String)object2);
            if (object == null) {
                this.a();
                return;
            }
            ((Integer)object).intValue();
            int n15 = (Integer)object;
            if (n12 != n15) return;
            this.l();
            return;
        }
        object3 = new StringBuilder();
        String string7 = "STATE_WAITING_LOCK_AF, aeState===";
        ((StringBuilder)object3).append(string7);
        ((StringBuilder)object3).append(object);
        ((StringBuilder)object3).append(string2);
        ((StringBuilder)object3).append(object2);
        object = ((StringBuilder)object3).toString();
        d.v.d.h.f.a((String)object);
        if (object2 != null && (n10 = ((Integer)object2).intValue()) != 0) {
            n10 = (Integer)object2;
            if (n13 != n10) {
                n10 = 5;
                int n16 = (Integer)object2;
                if (n10 != n16) return;
            }
            this.a();
            return;
        }
        this.a();
    }

    public void d() {
    }

    public void e() {
    }

    public CaptureRequest.Builder g() {
        return this.b.r();
    }

    public int getAfState() {
        return 0;
    }

    public CameraCaptureSession.CaptureCallback h() {
        return this.b.s();
    }

    public Handler i() {
        return this.b.o();
    }

    public /* synthetic */ void k() {
        this.j();
    }

    public void t() {
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
        object = this.b.a0();
        n10 = 3;
        object2 = n10;
        ((d.v.d.i.e.g)object).r((Integer)object2);
        object = this.b;
        object2 = ((n)object).c;
        if (object2 != null && (object = ((n)object).d) != null) {
            n11 = 0;
            this.a = 0;
            object2 = this.g();
            Object object3 = CaptureRequest.CONTROL_AF_TRIGGER;
            int n12 = 2;
            Constable constable = n12;
            object2.set(object3, (Object)constable);
            object3 = this.h();
            constable = this.i();
            this.o((CaptureRequest.Builder)object2, (CameraCaptureSession.CaptureCallback)object3, (Handler)constable);
            object3 = CaptureRequest.CONTROL_AE_LOCK;
            constable = Boolean.FALSE;
            object2.set(object3, (Object)constable);
            object3 = CaptureRequest.CONTROL_AF_TRIGGER;
            constable = 0;
            object2.set(object3, (Object)constable);
            object3 = CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER;
            object = 0;
            object2.set(object3, object);
            object = CaptureRequest.CONTROL_AF_MODE;
            int n13 = 4;
            object3 = n13;
            object2.set((CaptureRequest.Key)object, object3);
            object = this.h();
            object3 = this.i();
            this.p((CaptureRequest.Builder)object2, (CameraCaptureSession.CaptureCallback)object, (Handler)object3);
        }
    }
}

