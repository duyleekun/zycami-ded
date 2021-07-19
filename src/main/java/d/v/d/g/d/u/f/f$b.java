/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession$CaptureCallback
 *  android.hardware.camera2.CaptureRequest
 *  android.hardware.camera2.CaptureRequest$Builder
 *  android.hardware.camera2.CaptureRequest$Key
 *  android.os.Handler
 *  android.view.Surface
 */
package d.v.d.g.d.u.f;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.view.Surface;
import d.v.d.g.d.n;
import d.v.d.g.d.u.d;
import d.v.d.g.d.u.f.f;
import d.v.d.i.e.g;

public class f$b
implements Runnable {
    public final /* synthetic */ f a;

    public f$b(f f10) {
        this.a = f10;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void run() {
        int n10 = 4;
        g g10 = null;
        Object object = "un lock focus ae and af";
        d.v.d.h.f.a((String)object);
        object = this.a;
        object = f.a((f)object);
        object = ((d)object).a0();
        int n11 = 3;
        Object object2 = n11;
        ((g)object).r((Integer)object2);
        object = this.a;
        object = f.a((f)object);
        object = ((n)object).c;
        if (object == null) return;
        object = this.a;
        object = f.a((f)object);
        object = ((n)object).d;
        if (object == null) return;
        object = this.a;
        f.f((f)object, 0);
        object = this.a;
        object = f.a((f)object);
        object = ((n)object).r();
        object2 = CaptureRequest.CONTROL_AF_MODE;
        Object object3 = n10;
        object.set((CaptureRequest.Key)object2, object3);
        object = this.a;
        object = f.a((f)object);
        object2 = this.a;
        object2 = f.a((f)object2);
        object2 = ((n)object2).r();
        object3 = this.a;
        object3 = f.a((f)object3);
        object3 = ((n)object3).s();
        Object object4 = this.a;
        object4 = f.a((f)object4);
        object4 = ((n)object4).o();
        ((n)object).P((CaptureRequest.Builder)object2, (CameraCaptureSession.CaptureCallback)object3, (Handler)object4);
        object = this.a;
        object = f.a((f)object);
        object = ((n)object).c;
        n11 = 1;
        object = object.createCaptureRequest(n11);
        object2 = this.a;
        object2 = f.a((f)object2);
        object2 = ((n)object2).z();
        object.addTarget((Surface)object2);
        object2 = this.a;
        object2 = f.a((f)object2);
        ((d)object2).h0((CaptureRequest.Builder)object);
        object2 = this.a;
        f.g((f)object2, (CaptureRequest.Builder)object);
        object2 = CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER;
        int n12 = 2;
        object4 = n12;
        object.set((CaptureRequest.Key)object2, object4);
        object2 = CaptureRequest.CONTROL_AF_TRIGGER;
        object3 = n12;
        object.set((CaptureRequest.Key)object2, object3);
        object2 = this.a;
        object2 = f.a((f)object2);
        object2 = ((n)object2).d;
        object = object.build();
        object3 = this.a;
        object3 = f.a((f)object3);
        object3 = ((n)object3).s();
        object4 = this.a;
        object4 = f.a((f)object4);
        object4 = ((n)object4).o();
        try {
            object2.capture((CaptureRequest)object, (CameraCaptureSession.CaptureCallback)object3, (Handler)object4);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            object = this.a;
            f.f((f)object, 0);
            g10 = f.a(this.a).a0();
            Integer n13 = n10;
            g10.r(n13);
        }
    }
}

