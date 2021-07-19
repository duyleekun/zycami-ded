/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build
 */
package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class PreviewPixelHDRnetQuirk
implements Quirk {
    private static final List SUPPORTED_DEVICES;

    static {
        ArrayList<String> arrayList;
        List<String> list = Arrays.asList("sunfish", "bramble", "redfin");
        SUPPORTED_DEVICES = arrayList = new ArrayList<String>(list);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean load() {
        String string2 = "Google";
        Object object = Build.MANUFACTURER;
        boolean bl2 = string2.equals(object);
        if (!bl2) return false;
        object = SUPPORTED_DEVICES;
        string2 = Build.DEVICE;
        Locale locale = Locale.getDefault();
        bl2 = object.contains(string2 = string2.toLowerCase(locale));
        if (!bl2) return false;
        return true;
    }
}

