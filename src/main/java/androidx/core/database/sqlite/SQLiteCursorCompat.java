/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteCursor
 *  android.os.Build$VERSION
 */
package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteCursor;
import android.os.Build;

public final class SQLiteCursorCompat {
    private SQLiteCursorCompat() {
    }

    public static void setFillWindowForwardOnly(SQLiteCursor sQLiteCursor, boolean bl2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            sQLiteCursor.setFillWindowForwardOnly(bl2);
        }
    }
}

