/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.f.b;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final class a$c
extends Migration {
    public a$c(int n10, int n11) {
        super(n10, n11);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `PrimeInfo` (`errcode` INTEGER NOT NULL DEFAULT 0, `errmsg` TEXT, `id` INTEGER NOT NULL DEFAULT 0, `userId` INTEGER PRIMARY KEY NOT NULL, `deviceId` INTEGER NOT NULL DEFAULT 0, `periodTime` INTEGER NOT NULL DEFAULT 0, `activeTime` TEXT, `startTime` TEXT, `endTime` TEXT, `hasRenew` INTEGER NOT NULL DEFAULT 0, `status` INTEGER NOT NULL DEFAULT 0, `isShowDialog` INTEGER NOT NULL DEFAULT 0)");
        supportSQLiteDatabase.execSQL("ALTER TABLE UserInfo ADD COLUMN prime INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE UserInfo ADD COLUMN primeId INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `CEUpLoadCloudLogInfo` (`startedAt` TEXT, `version` TEXT, `longitude` TEXT, `latitude` TEXT, `url` TEXT PRIMARY KEY NOT NULL, `status` INTEGER NOT NULL DEFAULT 0, `duration` INTEGER NOT NULL DEFAULT 0, `operation` INTEGER NOT NULL DEFAULT 0) ");
        supportSQLiteDatabase.execSQL("ALTER TABLE firmware_info ADD COLUMN `ota_update` INTEGER NOT NULL DEFAULT 1 ");
    }
}

