/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.f.b;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import m.a.a;

public final class a$g
extends Migration {
    public a$g(int n10, int n11) {
        super(n10, n11);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Object[] objectArray = new Object[]{};
        a.i("MIGRATION_6_7, \u6570\u636e\u5e93", objectArray);
        supportSQLiteDatabase.execSQL("ALTER TABLE PublishWorks ADD COLUMN shareToKwai INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE PublishWorks ADD COLUMN kwaiToken TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE PublishWorks ADD COLUMN coverObjectKey TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE PublishWorks ADD COLUMN fileObjectKey TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE MessageSystem ADD COLUMN userId INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE MessageSystem ADD COLUMN avatar TEXT");
    }
}

