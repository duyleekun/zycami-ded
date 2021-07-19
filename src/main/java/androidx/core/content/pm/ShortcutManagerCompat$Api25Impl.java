/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.pm.ShortcutInfo
 */
package androidx.core.content.pm;

import android.content.pm.ShortcutInfo;
import java.util.List;

public class ShortcutManagerCompat$Api25Impl {
    private ShortcutManagerCompat$Api25Impl() {
    }

    public static String getShortcutInfoWithLowestRank(List object) {
        boolean bl2;
        object = object.iterator();
        int n10 = -1;
        int n11 = 0;
        String string2 = null;
        while (bl2 = object.hasNext()) {
            ShortcutInfo shortcutInfo = (ShortcutInfo)object.next();
            int n12 = shortcutInfo.getRank();
            if (n12 <= n10) continue;
            String string3 = shortcutInfo.getId();
            n11 = shortcutInfo.getRank();
            string2 = string3;
            n10 = n11;
        }
        return string2;
    }
}

