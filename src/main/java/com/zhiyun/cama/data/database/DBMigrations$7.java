/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final class DBMigrations$7
extends Migration {
    public DBMigrations$7(int n10, int n11) {
        super(n10, n11);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `regional_restrictions_info` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `deviceName` TEXT, `deviceSn` TEXT, `isRestrictions` INTEGER NOT NULL)");
        supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_regional_restrictions_info_deviceSn` ON `regional_restrictions_info` (`deviceSn`)");
    }
}

