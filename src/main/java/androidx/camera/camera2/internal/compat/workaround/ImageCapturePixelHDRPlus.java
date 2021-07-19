/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CaptureRequest
 *  android.hardware.camera2.CaptureRequest$Key
 */
package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.impl.Camera2ImplConfig$Builder;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ImageCapturePixelHDRPlusQuirk;

public class ImageCapturePixelHDRPlus {
    public void toggleHDRPlus(int n10, Camera2ImplConfig$Builder camera2ImplConfig$Builder) {
        Object object = (ImageCapturePixelHDRPlusQuirk)DeviceQuirks.get(ImageCapturePixelHDRPlusQuirk.class);
        if (object == null) {
            return;
        }
        if (n10 != 0) {
            int n11 = 1;
            if (n10 == n11) {
                CaptureRequest.Key key = CaptureRequest.CONTROL_ENABLE_ZSL;
                object = Boolean.FALSE;
                camera2ImplConfig$Builder.setCaptureRequestOption(key, object);
            }
        } else {
            CaptureRequest.Key key = CaptureRequest.CONTROL_ENABLE_ZSL;
            object = Boolean.TRUE;
            camera2ImplConfig$Builder.setCaptureRequestOption(key, object);
        }
    }
}

