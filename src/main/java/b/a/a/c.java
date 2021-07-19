/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package b.a.a;

import android.content.Context;
import androidx.camera.camera2.internal.Camera2CameraFactory;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.CameraFactory$Provider;
import androidx.camera.core.impl.CameraThreadConfig;

public final class c
implements CameraFactory$Provider {
    public static final /* synthetic */ c a;

    static {
        c c10;
        a = c10 = new c();
    }

    public final CameraFactory newInstance(Context context, CameraThreadConfig cameraThreadConfig, CameraSelector cameraSelector) {
        Camera2CameraFactory camera2CameraFactory = new Camera2CameraFactory(context, cameraThreadConfig, cameraSelector);
        return camera2CameraFactory;
    }
}

