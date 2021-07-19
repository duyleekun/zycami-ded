/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build
 */
package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

public class CrashWhenTakingPhotoWithAutoFlashAEModeQuirk
implements Quirk {
    public static boolean load() {
        String string2 = "SAMSUNG";
        String string3 = Build.MANUFACTURER.toUpperCase();
        boolean bl2 = string2.equals(string3);
        if (bl2 && (bl2 = (string3 = Build.MODEL.toUpperCase()).startsWith(string2 = "SM-A300"))) {
            bl2 = true;
        } else {
            bl2 = false;
            string3 = null;
        }
        return bl2;
    }
}

