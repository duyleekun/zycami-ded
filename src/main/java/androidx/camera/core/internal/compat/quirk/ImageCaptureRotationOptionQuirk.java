/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build
 */
package androidx.camera.core.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.Quirk;

public final class ImageCaptureRotationOptionQuirk
implements Quirk {
    private static boolean isHonor9X() {
        String string2 = "HONOR";
        String string3 = Build.BRAND;
        boolean bl2 = string2.equalsIgnoreCase(string3);
        if (bl2 && (bl2 = (string2 = "STK-LX1").equalsIgnoreCase(string3 = Build.MODEL))) {
            bl2 = true;
        } else {
            bl2 = false;
            string3 = null;
        }
        return bl2;
    }

    private static boolean isHuaweiMate20Lite() {
        String string2 = "HUAWEI";
        String string3 = Build.BRAND;
        boolean bl2 = string2.equalsIgnoreCase(string3);
        if (bl2 && (bl2 = (string2 = "SNE-LX1").equalsIgnoreCase(string3 = Build.MODEL))) {
            bl2 = true;
        } else {
            bl2 = false;
            string3 = null;
        }
        return bl2;
    }

    public static boolean load() {
        boolean bl2 = ImageCaptureRotationOptionQuirk.isHuaweiMate20Lite();
        bl2 = bl2 || (bl2 = ImageCaptureRotationOptionQuirk.isHonor9X());
        return bl2;
    }

    public boolean isSupported(Config$Option config$Option) {
        boolean bl2;
        Config$Option config$Option2 = CaptureConfig.OPTION_ROTATION;
        if (config$Option != config$Option2) {
            bl2 = true;
        } else {
            bl2 = false;
            config$Option = null;
        }
        return bl2;
    }
}

