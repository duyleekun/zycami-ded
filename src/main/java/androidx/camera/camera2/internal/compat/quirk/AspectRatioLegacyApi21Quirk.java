/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCharacteristics
 *  android.hardware.camera2.CameraCharacteristics$Key
 *  android.os.Build$VERSION
 */
package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.impl.Quirk;

public class AspectRatioLegacyApi21Quirk
implements Quirk {
    public static boolean load(CameraCharacteristicsCompat object) {
        int n10;
        int n11;
        CameraCharacteristics.Key key = CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL;
        if ((object = (Integer)((CameraCharacteristicsCompat)object).get(key)) != null && (n11 = ((Integer)object).intValue()) == (n10 = 2) && (n11 = Build.VERSION.SDK_INT) == (n10 = 21)) {
            n11 = 1;
        } else {
            n11 = 0;
            object = null;
        }
        return n11 != 0;
    }

    public int getCorrectedAspectRatio() {
        return 2;
    }
}

