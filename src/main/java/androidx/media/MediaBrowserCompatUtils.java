/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.media;

import android.os.Bundle;

public class MediaBrowserCompatUtils {
    private MediaBrowserCompatUtils() {
    }

    public static boolean areSameOptions(Bundle bundle, Bundle bundle2) {
        int n10;
        int n11;
        int n12;
        boolean bl2 = true;
        if (bundle == bundle2) {
            return bl2;
        }
        String string2 = "android.media.browse.extra.PAGE_SIZE";
        String string3 = "android.media.browse.extra.PAGE";
        int n13 = -1;
        if (bundle == null) {
            int n14 = bundle2.getInt(string3, n13);
            if (n14 != n13 || (n14 = bundle2.getInt(string2, n13)) != n13) {
                bl2 = false;
            }
            return bl2;
        }
        if (bundle2 == null) {
            int n15;
            int n16 = bundle.getInt(string3, n13);
            if (n16 != n13 || (n15 = bundle.getInt(string2, n13)) != n13) {
                bl2 = false;
            }
            return bl2;
        }
        int n17 = bundle.getInt(string3, n13);
        if (n17 != (n12 = bundle2.getInt(string3, n13)) || (n11 = bundle.getInt(string2, n13)) != (n10 = bundle2.getInt(string2, n13))) {
            bl2 = false;
        }
        return bl2;
    }

    public static boolean hasDuplicatedItems(Bundle bundle, Bundle bundle2) {
        String string2 = "android.media.browse.extra.PAGE";
        int n10 = -1;
        int n11 = bundle == null ? n10 : bundle.getInt(string2, n10);
        int n12 = bundle2 == null ? n10 : bundle2.getInt(string2, n10);
        String string3 = "android.media.browse.extra.PAGE_SIZE";
        int n13 = bundle == null ? n10 : bundle.getInt(string3, n10);
        int n14 = bundle2 == null ? n10 : bundle2.getInt(string3, n10);
        int n15 = -1 >>> 1;
        int n16 = 1;
        if (n11 != n10 && n13 != n10) {
            n11 *= n13;
            n13 = n13 + n11 - n16;
        } else {
            n13 = n15;
            n11 = 0;
        }
        if (n12 != n10 && n14 != n10) {
            n12 *= n14;
            n15 = (n14 += n12) + -1;
        } else {
            n12 = 0;
            string2 = null;
        }
        if (n13 < n12 || n15 < n11) {
            n16 = 0;
        }
        return n16 != 0;
    }
}

