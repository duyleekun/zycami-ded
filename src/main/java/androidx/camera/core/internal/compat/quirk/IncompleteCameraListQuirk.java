/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build
 */
package androidx.camera.core.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class IncompleteCameraListQuirk
implements Quirk {
    private static final List KNOWN_AFFECTED_DEVICES;

    static {
        ArrayList<String> arrayList;
        List<String> list = Arrays.asList("a5y17lte", "tb-8704x", "a7y17lte", "on7xelte", "heroqltevzw", "1816", "1814", "1815", "santoni", "htc_oclul", "asus_z01h_1", "vox_alpha_plus", "a5y17ltecan", "x304l", "hero2qltevzw", "a5y17lteskt", "1801", "a5y17lteskt", "1801", "a5y17ltelgt", "herolte", "htc_hiau_ml_tuhl", "a6plte", "hwtrt-q", "co2_sprout", "h3223", "davinci", "vince", "armor_x5", "a2corelte", "j6lte");
        KNOWN_AFFECTED_DEVICES = arrayList = new ArrayList<String>(list);
    }

    public static boolean load() {
        List list = KNOWN_AFFECTED_DEVICES;
        String string2 = Build.DEVICE;
        Locale locale = Locale.getDefault();
        string2 = string2.toLowerCase(locale);
        return list.contains(string2);
    }
}

