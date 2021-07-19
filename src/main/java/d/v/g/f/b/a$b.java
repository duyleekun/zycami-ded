/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.f.b;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final class a$b
extends Migration {
    public a$b(int n10, int n11) {
        super(n10, n11);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `AppDeviceInfo` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userid` TEXT,  `phoneid` TEXT, `model` TEXT, `deviceid` TEXT, `bts` TEXT, `ets` TEXT, `longitude` TEXT, `latitude` TEXT,`serial_num` TEXT)");
    }
}

