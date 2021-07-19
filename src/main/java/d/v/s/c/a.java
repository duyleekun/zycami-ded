/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Environment
 */
package d.v.s.c;

import android.os.Build;
import android.os.Environment;

public final class a {
    private a() {
    }

    public static boolean a() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        n10 = n10 >= n11 && (n10 = (int)(Environment.isExternalStorageLegacy() ? 1 : 0)) == 0 ? 1 : 0;
        return n10 != 0;
    }
}

