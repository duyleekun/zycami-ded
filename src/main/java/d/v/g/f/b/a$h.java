/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.f.b;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import m.a.a;

public final class a$h
extends Migration {
    public a$h(int n10, int n11) {
        super(n10, n11);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Object[] objectArray = new Object[]{};
        a.i("MIGRATION_7_8, \u6570\u636e\u5e93", objectArray);
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `regional_restrictions_info` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `deviceName` TEXT, `deviceSn` TEXT, `isRestrictions` INTEGER NOT NULL)");
        supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_regional_restrictions_info_deviceSn` ON `regional_restrictions_info` (`deviceSn`)");
    }
}

