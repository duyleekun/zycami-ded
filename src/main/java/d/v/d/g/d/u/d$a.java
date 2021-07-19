/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraAccessException
 *  android.hardware.camera2.CaptureRequest
 */
package d.v.d.g.d.u;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CaptureRequest;
import d.v.d.g.d.u.d;

public class d$a
implements Runnable {
    public final /* synthetic */ d a;

    public d$a(d d10) {
        this.a = d10;
    }

    public void run() {
        d d10 = this.a;
        Object object = d10.d;
        d10 = d.V(d10);
        d10 = d10.build();
        object.capture((CaptureRequest)d10, null, null);
        d10 = this.a;
        d10 = d.X(d10);
        object = this.a;
        object = d.W((d)object);
        long l10 = 330L;
        try {
            d10.postDelayed((Runnable)object, l10);
        }
        catch (CameraAccessException cameraAccessException) {
            cameraAccessException.printStackTrace();
        }
    }
}

