/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.f.b;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import m.a.a;

public final class a$i
extends Migration {
    public a$i(int n10, int n11) {
        super(n10, n11);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Object[] objectArray = new Object[]{};
        a.i("MIGRATION_8_9, \u6570\u636e\u5e93", objectArray);
        supportSQLiteDatabase.execSQL("ALTER TABLE activation_data ADD COLUMN isVisitor INTEGER NOT NULL DEFAULT 0");
    }
}

