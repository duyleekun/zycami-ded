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
import androidx.camera.camera2.internal.compat.quirk.PreviewPixelHDRnetQuirk;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SessionConfig$Builder;

public class PreviewPixelHDRnet {
    private PreviewPixelHDRnet() {
    }

    public static void setHDRnet(SessionConfig$Builder sessionConfig$Builder) {
        Object object = (PreviewPixelHDRnetQuirk)DeviceQuirks.get(PreviewPixelHDRnetQuirk.class);
        if (object == null) {
            return;
        }
        object = new Camera2ImplConfig$Builder();
        CaptureRequest.Key key = CaptureRequest.TONEMAP_MODE;
        Integer n10 = 2;
        ((Camera2ImplConfig$Builder)object).setCaptureRequestOption(key, n10);
        object = ((Camera2ImplConfig$Builder)object).build();
        sessionConfig$Builder.addImplementationOptions((Config)object);
    }
}

