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

public class ImageCapturePixelHDRPlusQuirk
implements Quirk {
    private static boolean isPixel2() {
        String string2 = "Google";
        String string3 = Build.MANUFACTURER;
        boolean bl2 = string2.equals(string3);
        if (bl2 && (bl2 = (string2 = "Pixel 2").equals(string3 = Build.MODEL))) {
            bl2 = true;
        } else {
            bl2 = false;
            string3 = null;
        }
        return bl2;
    }

    private static boolean isPixel3() {
        String string2 = "Google";
        String string3 = Build.MANUFACTURER;
        boolean bl2 = string2.equals(string3);
        if (bl2 && (bl2 = (string2 = "Pixel 3").equals(string3 = Build.MODEL))) {
            bl2 = true;
        } else {
            bl2 = false;
            string3 = null;
        }
        return bl2;
    }

    public static boolean load() {
        boolean bl2;
        boolean bl3 = ImageCapturePixelHDRPlusQuirk.isPixel2();
        bl3 = (bl3 || (bl3 = ImageCapturePixelHDRPlusQuirk.isPixel3())) && (bl3 = Build.VERSION.SDK_INT) >= (bl2 = 26 != 0);
        return bl3;
    }
}

