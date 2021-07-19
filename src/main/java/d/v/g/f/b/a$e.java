/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.f.b;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import m.a.a;

public final class a$e
extends Migration {
    public a$e(int n10, int n11) {
        super(n10, n11);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Object[] objectArray = new Object[]{};
        a.i("MIGRATION_4_5, \u6570\u636e\u5e93", objectArray);
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `activation_data` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userId` INTEGER NOT NULL, `account` TEXT, `serialNum` TEXT, `deviceModel` INTEGER NOT NULL, `deviceName` TEXT, `appVersion` TEXT, `longitude` TEXT, `latitude` TEXT, `activeCode` TEXT, `activeAt` TEXT, `activeStatus` TEXT, `ex` TEXT)");
    }
}

