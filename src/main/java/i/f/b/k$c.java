/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession
 *  android.hardware.camera2.CameraCaptureSession$StateCallback
 *  android.hardware.camera2.CaptureRequest
 *  android.hardware.camera2.CaptureRequest$Key
 *  android.os.Handler
 *  android.util.Log
 */
package i.f.b;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.util.Log;
import i.f.b.k;

public class k$c
extends CameraCaptureSession.StateCallback {
    public final /* synthetic */ k a;

    public k$c(k k10) {
        this.a = k10;
    }

    public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        Log.e((String)"JavaCamera2View", (String)"createCameraPreviewSession failed");
    }

    public void onConfigured(CameraCaptureSession object) {
        String string2 = "JavaCamera2View";
        Log.i((String)string2, (String)"createCaptureSession::onConfigured");
        Object object2 = k.t(this.a);
        if (object2 == null) {
            return;
        }
        object2 = this.a;
        k.y((k)((Object)object2), object);
        object = this.a;
        object = k.z((k)((Object)object));
        object2 = CaptureRequest.CONTROL_AF_MODE;
        int n10 = 4;
        Integer n11 = n10;
        object.set((CaptureRequest.Key)object2, (Object)n11);
        object = this.a;
        object = k.z((k)((Object)object));
        object2 = CaptureRequest.CONTROL_AE_MODE;
        n10 = 2;
        n11 = n10;
        object.set((CaptureRequest.Key)object2, (Object)n11);
        object = this.a;
        object = k.x((k)((Object)object));
        object2 = this.a;
        object2 = k.z((k)((Object)object2));
        object2 = object2.build();
        n10 = 0;
        n11 = null;
        k k10 = this.a;
        k10 = k.A(k10);
        object.setRepeatingRequest((CaptureRequest)object2, null, (Handler)k10);
        object = "CameraPreviewSession has been started";
        try {
            Log.i((String)string2, (String)object);
        }
        catch (Exception exception) {
            object2 = "createCaptureSession failed";
            Log.e((String)string2, (String)object2, (Throwable)exception);
        }
    }
}

