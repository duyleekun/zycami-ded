/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraAccessException
 *  android.hardware.camera2.CameraCaptureSession
 *  android.hardware.camera2.CameraCaptureSession$StateCallback
 *  android.hardware.camera2.CaptureRequest
 *  android.hardware.camera2.CaptureRequest$Key
 *  android.os.Handler
 *  android.util.Log
 */
package i.f.b;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.util.Log;
import i.f.b.c;

public class c$b
extends CameraCaptureSession.StateCallback {
    public final /* synthetic */ c a;

    public c$b(c c10) {
        this.a = c10;
    }

    public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        Log.e((String)"Camera2Renderer", (String)"createCameraPreviewSession failed");
        c.x(this.a).release();
    }

    public void onConfigured(CameraCaptureSession object) {
        String string2 = "Camera2Renderer";
        c c10 = this.a;
        c.A(c10, object);
        object = this.a;
        object = c.B((c)object);
        c10 = CaptureRequest.CONTROL_AF_MODE;
        int n10 = 4;
        Integer n11 = n10;
        object.set((CaptureRequest.Key)c10, (Object)n11);
        object = this.a;
        object = c.B((c)object);
        c10 = CaptureRequest.CONTROL_AE_MODE;
        n10 = 2;
        n11 = n10;
        object.set((CaptureRequest.Key)c10, (Object)n11);
        object = this.a;
        object = c.z((c)object);
        c10 = this.a;
        c10 = c.B(c10);
        c10 = c10.build();
        n10 = 0;
        n11 = null;
        c c11 = this.a;
        c11 = c.C(c11);
        object.setRepeatingRequest((CaptureRequest)c10, null, (Handler)c11);
        object = "CameraPreviewSession has been started";
        try {
            Log.i((String)string2, (String)object);
        }
        catch (CameraAccessException cameraAccessException) {
            object = "createCaptureSession failed";
            Log.e((String)string2, (String)object);
        }
        c.x(this.a).release();
    }
}

