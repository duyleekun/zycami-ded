/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package androidx.camera.camera2;

import android.content.Context;
import androidx.camera.camera2.internal.Camera2DeviceSurfaceManager;
import androidx.camera.camera2.internal.Camera2UseCaseConfigFactory;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.CameraXConfig$Builder;
import androidx.camera.core.InitializationException;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.UseCaseConfigFactory;
import b.a.a.a;
import b.a.a.b;
import b.a.a.c;
import java.util.Set;

public final class Camera2Config {
    private Camera2Config() {
    }

    public static /* synthetic */ CameraDeviceSurfaceManager a(Context context, Object object, Set set) {
        try {
            Camera2DeviceSurfaceManager camera2DeviceSurfaceManager = new Camera2DeviceSurfaceManager(context, object, set);
            return camera2DeviceSurfaceManager;
        }
        catch (CameraUnavailableException cameraUnavailableException) {
            object = new InitializationException(cameraUnavailableException);
            throw object;
        }
    }

    public static /* synthetic */ UseCaseConfigFactory b(Context context) {
        Camera2UseCaseConfigFactory camera2UseCaseConfigFactory = new Camera2UseCaseConfigFactory(context);
        return camera2UseCaseConfigFactory;
    }

    public static CameraXConfig defaultConfig() {
        c c10 = c.a;
        b b10 = b.a;
        a a10 = a.a;
        CameraXConfig$Builder cameraXConfig$Builder = new CameraXConfig$Builder();
        return cameraXConfig$Builder.setCameraFactoryProvider(c10).setDeviceSurfaceManagerProvider(b10).setUseCaseConfigFactoryProvider(a10).build();
    }
}

