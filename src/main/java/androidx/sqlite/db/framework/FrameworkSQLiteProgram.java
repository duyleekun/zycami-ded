/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteProgram
 */
package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.db.SupportSQLiteProgram;

public class FrameworkSQLiteProgram
implements SupportSQLiteProgram {
    private final SQLiteProgram mDelegate;

    public FrameworkSQLiteProgram(SQLiteProgram sQLiteProgram) {
        this.mDelegate = sQLiteProgram;
    }

    public void bindBlob(int n10, byte[] byArray) {
        this.mDelegate.bindBlob(n10, byArray);
    }

    public void bindDouble(int n10, double d10) {
        this.mDelegate.bindDouble(n10, d10);
    }

    public void bindLong(int n10, long l10) {
        this.mDelegate.bindLong(n10, l10);
    }

    public void bindNull(int n10) {
        this.mDelegate.bindNull(n10);
    }

    public void bindString(int n10, String string2) {
        this.mDelegate.bindString(n10, string2);
    }

    public void clearBindings() {
        this.mDelegate.clearBindings();
    }

    public void close() {
        this.mDelegate.close();
    }
}

