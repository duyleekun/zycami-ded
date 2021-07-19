/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.hardware.camera2.CameraCharacteristics
 *  android.hardware.camera2.CameraDevice$StateCallback
 *  android.hardware.camera2.CameraManager
 *  android.hardware.camera2.CameraManager$AvailabilityCallback
 *  android.os.Build$VERSION
 *  android.os.Handler
 */
package androidx.camera.camera2.internal.compat;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Handler;
import androidx.camera.camera2.internal.compat.CameraManagerCompatApi28Impl;
import androidx.camera.camera2.internal.compat.CameraManagerCompatApi29Impl;
import androidx.camera.camera2.internal.compat.CameraManagerCompatBaseImpl;
import java.util.concurrent.Executor;

public interface CameraManagerCompat$CameraManagerCompatImpl {
    public static CameraManagerCompat$CameraManagerCompatImpl from(Context context, Handler object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11) {
            object = new CameraManagerCompatApi29Impl(context);
            return object;
        }
        n11 = 28;
        if (n10 >= n11) {
            return CameraManagerCompatApi28Impl.create(context);
        }
        return CameraManagerCompatBaseImpl.create(context, object);
    }

    public CameraCharacteristics getCameraCharacteristics(String var1);

    public String[] getCameraIdList();

    public CameraManager getCameraManager();

    public void openCamera(String var1, Executor var2, CameraDevice.StateCallback var3);

    public void registerAvailabilityCallback(Executor var1, CameraManager.AvailabilityCallback var2);

    public void unregisterAvailabilityCallback(CameraManager.AvailabilityCallback var1);
}

