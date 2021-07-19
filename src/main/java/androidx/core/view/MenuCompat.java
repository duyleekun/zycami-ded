/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.Menu
 *  android.view.MenuItem
 */
package androidx.core.view;

import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import androidx.core.internal.view.SupportMenu;

public final class MenuCompat {
    private MenuCompat() {
    }

    public static void setGroupDividerEnabled(Menu menu2, boolean bl2) {
        int n10 = menu2 instanceof SupportMenu;
        if (n10 != 0) {
            menu2 = (SupportMenu)menu2;
            menu2.setGroupDividerEnabled(bl2);
        } else {
            n10 = Build.VERSION.SDK_INT;
            int n11 = 28;
            if (n10 >= n11) {
                menu2.setGroupDividerEnabled(bl2);
            }
        }
    }

    public static void setShowAsAction(MenuItem menuItem, int n10) {
        menuItem.setShowAsAction(n10);
    }
}

