/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources$Theme
 *  android.os.Build$VERSION
 */
package androidx.core.content.res;

import android.content.res.Resources;
import android.os.Build;
import androidx.core.content.res.ResourcesCompat$ThemeCompat$ImplApi23;
import androidx.core.content.res.ResourcesCompat$ThemeCompat$ImplApi29;

public final class ResourcesCompat$ThemeCompat {
    private ResourcesCompat$ThemeCompat() {
    }

    public static void rebase(Resources.Theme theme) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11) {
            ResourcesCompat$ThemeCompat$ImplApi29.rebase(theme);
        } else {
            n11 = 23;
            if (n10 >= n11) {
                ResourcesCompat$ThemeCompat$ImplApi23.rebase(theme);
            }
        }
    }
}

