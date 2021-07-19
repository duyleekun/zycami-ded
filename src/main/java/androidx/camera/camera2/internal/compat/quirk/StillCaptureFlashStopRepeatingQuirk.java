/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build
 */
package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import java.util.Locale;

public class StillCaptureFlashStopRepeatingQuirk
implements Quirk {
    public static boolean load() {
        String string2 = Build.MANUFACTURER;
        String string3 = "SAMSUNG";
        Object object = Locale.US;
        boolean bl2 = string3.equals(string2 = string2.toUpperCase((Locale)object));
        if (bl2 && (bl2 = (string2 = Build.MODEL.toUpperCase((Locale)object)).startsWith((String)(object = "SM-A716")))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }
}

