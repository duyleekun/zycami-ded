/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils;

import androidx.camera.core.Logger;
import java.lang.constant.Constable;

public final class CameraOrientationUtil {
    private static final String TAG = "CameraOrientationUtil";

    private CameraOrientationUtil() {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int degreesToSurfaceRotation(int n10) {
        if (n10 == 0) return 0;
        int n11 = 90;
        if (n10 == n11) return 1;
        n11 = 180;
        if (n10 == n11) return 2;
        n11 = 270;
        if (n10 == n11) {
            return 3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid sensor rotation: ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public static int getRelativeImageRotation(int n10, int n11, boolean bl2) {
        int n12 = bl2 ? (n11 - n10 + 360) % 360 : (n11 + n10) % 360;
        String string2 = TAG;
        int n13 = Logger.isDebugEnabled(string2);
        if (n13 != 0) {
            Object object;
            n13 = 4;
            Object[] objectArray = new Object[n13];
            objectArray[0] = object = Integer.valueOf(n10);
            Constable constable = n11;
            objectArray[1] = constable;
            constable = Boolean.valueOf(bl2);
            objectArray[2] = constable;
            n10 = 3;
            constable = n12;
            objectArray[n10] = constable;
            object = String.format("getRelativeImageRotation: destRotationDegrees=%s, sourceRotationDegrees=%s, isOppositeFacing=%s, result=%s", objectArray);
            Logger.d(string2, (String)object);
        }
        return n12;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int surfaceRotationToDegrees(int n10) {
        if (n10 == 0) return 0;
        int n11 = 1;
        if (n10 == n11) return 90;
        n11 = 2;
        if (n10 == n11) return 180;
        n11 = 3;
        if (n10 == n11) {
            return 270;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported surface rotation: ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }
}

