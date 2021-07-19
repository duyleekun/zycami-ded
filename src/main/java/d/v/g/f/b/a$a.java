/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.f.b;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final class a$a
extends Migration {
    public a$a(int n10, int n11) {
        super(n10, n11);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("ALTER TABLE firmware_info ADD COLUMN has_popup INTEGER NOT NULL DEFAULT 1");
    }
}

