/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final class DBMigrations$4
extends Migration {
    public DBMigrations$4(int n10, int n11) {
        super(n10, n11);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `activation_data` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userId` INTEGER NOT NULL, `account` TEXT, `serialNum` TEXT, `deviceModel` INTEGER NOT NULL, `deviceName` TEXT, `appVersion` TEXT, `longitude` TEXT, `latitude` TEXT, `activeCode` TEXT, `activeAt` TEXT, `activeStatus` TEXT, `ex` TEXT)");
    }
}

