/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 */
package androidx.camera.core.impl;

import android.content.Context;
import android.os.Build;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraRepository;
import androidx.camera.core.impl.CameraValidator$CameraIdListIncorrectException;
import java.util.LinkedHashSet;

public final class CameraValidator {
    private static final String TAG = "CameraValidator";

    private CameraValidator() {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void validateCameras(Context object, CameraRepository object2) {
        Object object3;
        block9: {
            object = object.getPackageManager();
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("Verifying camera lens facing on ");
            String string2 = Build.DEVICE;
            ((StringBuilder)object3).append(string2);
            object3 = ((StringBuilder)object3).toString();
            string2 = TAG;
            Logger.d(string2, (String)object3);
            object3 = "android.hardware.camera";
            try {
                boolean bl2 = object.hasSystemFeature((String)object3);
                if (!bl2) break block9;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("Camera LensFacing verification failed, existing cameras: ");
                object2 = ((CameraRepository)object2).getCameras();
                ((StringBuilder)object3).append(object2);
                object2 = ((StringBuilder)object3).toString();
                Logger.e(string2, (String)object2);
                object2 = new CameraValidator$CameraIdListIncorrectException("Expected camera missing from device.", illegalArgumentException);
                throw object2;
            }
            object3 = CameraSelector.DEFAULT_BACK_CAMERA;
            LinkedHashSet linkedHashSet = ((CameraRepository)object2).getCameras();
            ((CameraSelector)object3).select(linkedHashSet);
        }
        object3 = "android.hardware.camera.front";
        boolean bl3 = object.hasSystemFeature((String)object3);
        if (!bl3) return;
        object = CameraSelector.DEFAULT_FRONT_CAMERA;
        object3 = ((CameraRepository)object2).getCameras();
        ((CameraSelector)object).select((LinkedHashSet)object3);
    }
}

