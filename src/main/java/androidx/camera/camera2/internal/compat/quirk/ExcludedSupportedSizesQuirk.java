/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.util.Size
 */
package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import android.util.Size;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Quirk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExcludedSupportedSizesQuirk
implements Quirk {
    private static final String TAG = "ExcludedSupportedSizesQuirk";

    private List getOnePlus6ExcludedSizes(String string2, int n10) {
        ArrayList<String> arrayList = new ArrayList<String>();
        String string3 = "0";
        int n11 = string2.equals(string3);
        if (n11 != 0 && n10 == (n11 = 256)) {
            string2 = new Size(4160, 3120);
            arrayList.add(string2);
            n10 = 4000;
            int n12 = 3000;
            string2 = new Size(n10, n12);
            arrayList.add(string2);
        }
        return arrayList;
    }

    private List getOnePlus6TExcludedSizes(String string2, int n10) {
        ArrayList<String> arrayList = new ArrayList<String>();
        String string3 = "0";
        int n11 = string2.equals(string3);
        if (n11 != 0 && n10 == (n11 = 256)) {
            string2 = new Size(4160, 3120);
            arrayList.add(string2);
            n10 = 4000;
            int n12 = 3000;
            string2 = new Size(n10, n12);
            arrayList.add(string2);
        }
        return arrayList;
    }

    private static boolean isOnePlus6() {
        String string2 = "OnePlus";
        String string3 = Build.BRAND;
        boolean bl2 = string2.equalsIgnoreCase(string3);
        if (bl2 && (bl2 = (string2 = "OnePlus6").equalsIgnoreCase(string3 = Build.DEVICE))) {
            bl2 = true;
        } else {
            bl2 = false;
            string3 = null;
        }
        return bl2;
    }

    private static boolean isOnePlus6T() {
        String string2 = "OnePlus";
        String string3 = Build.BRAND;
        boolean bl2 = string2.equalsIgnoreCase(string3);
        if (bl2 && (bl2 = (string2 = "OnePlus6T").equalsIgnoreCase(string3 = Build.DEVICE))) {
            bl2 = true;
        } else {
            bl2 = false;
            string3 = null;
        }
        return bl2;
    }

    public static boolean load() {
        boolean bl2 = ExcludedSupportedSizesQuirk.isOnePlus6();
        bl2 = bl2 || (bl2 = ExcludedSupportedSizesQuirk.isOnePlus6T());
        return bl2;
    }

    public List getExcludedSizes(String string2, int n10) {
        boolean bl2 = ExcludedSupportedSizesQuirk.isOnePlus6();
        if (bl2) {
            return this.getOnePlus6ExcludedSizes(string2, n10);
        }
        bl2 = ExcludedSupportedSizesQuirk.isOnePlus6T();
        if (bl2) {
            return this.getOnePlus6TExcludedSizes(string2, n10);
        }
        Logger.w(TAG, "Cannot retrieve list of supported sizes to exclude on this device.");
        return Collections.emptyList();
    }
}

