/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 */
package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.List;

public class Nexus4AndroidLTargetAspectRatioQuirk
implements Quirk {
    private static final List DEVICE_MODELS = Arrays.asList("NEXUS 4");

    public static boolean load() {
        int n10;
        String string2 = "GOOGLE";
        Object object = Build.BRAND.toUpperCase();
        int n11 = string2.equals(object);
        if (n11 != 0 && (n11 = Build.VERSION.SDK_INT) < (n10 = 23) && (n11 = (int)((object = DEVICE_MODELS).contains(string2 = Build.MODEL.toUpperCase()) ? 1 : 0)) != 0) {
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

