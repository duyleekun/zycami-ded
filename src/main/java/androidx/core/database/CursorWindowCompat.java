/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.CursorWindow
 *  android.os.Build$VERSION
 */
package androidx.core.database;

import android.database.CursorWindow;
import android.os.Build;

public final class CursorWindowCompat {
    private CursorWindowCompat() {
    }

    public static CursorWindow create(String string2, long l10) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            CursorWindow cursorWindow = new CursorWindow(string2, l10);
            return cursorWindow;
        }
        int n12 = 15;
        if (n10 >= n12) {
            CursorWindow cursorWindow = new CursorWindow(string2);
            return cursorWindow;
        }
        string2 = new CursorWindow(false);
        return string2;
    }
}

