/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 */
package androidx.camera.core.internal.utils;

import android.util.Size;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.ImageOutputConfig$Builder;
import androidx.camera.core.impl.UseCaseConfig$Builder;
import androidx.camera.core.impl.utils.CameraOrientationUtil;

public final class UseCaseConfigUtil {
    private UseCaseConfigUtil() {
    }

    public static void updateTargetRotationAndRelatedConfigs(UseCaseConfig$Builder object, int n10) {
        int n11;
        ImageOutputConfig imageOutputConfig = (ImageOutputConfig)((Object)object.getUseCaseConfig());
        int n12 = imageOutputConfig.getTargetRotation(n11 = -1);
        if (n12 == n11 || n12 != n10) {
            Object object2 = object;
            object2 = (ImageOutputConfig$Builder)object;
            object2.setTargetRotation(n10);
        }
        if (n12 != n11 && n10 != n11 && n12 != n10) {
            n11 = CameraOrientationUtil.surfaceRotationToDegrees(n12);
            if ((n10 = Math.abs(CameraOrientationUtil.surfaceRotationToDegrees(n10) - n11) % 180) == (n11 = 90)) {
                n10 = 0;
                Size size = imageOutputConfig.getTargetResolution(null);
                if (size != null) {
                    object = (ImageOutputConfig$Builder)object;
                    n11 = size.getHeight();
                    n10 = size.getWidth();
                    imageOutputConfig = new Size(n11, n10);
                    object.setTargetResolution((Size)imageOutputConfig);
                }
            }
        }
    }
}

