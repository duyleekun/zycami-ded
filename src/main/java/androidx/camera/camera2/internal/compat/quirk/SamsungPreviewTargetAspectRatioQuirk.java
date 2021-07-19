/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build
 */
package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.PreviewConfig;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.List;

public class SamsungPreviewTargetAspectRatioQuirk
implements Quirk {
    private static final List DEVICE_MODELS = Arrays.asList("SM-J710MN", "SM-T580");

    public static boolean load() {
        String string2 = "SAMSUNG";
        Object object = Build.BRAND.toUpperCase();
        boolean bl2 = string2.equals(object);
        if (bl2 && (bl2 = (object = DEVICE_MODELS).contains(string2 = Build.MODEL.toUpperCase()))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean require16_9(Config config) {
        return config instanceof PreviewConfig;
    }
}

