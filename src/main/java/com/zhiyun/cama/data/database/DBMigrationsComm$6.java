/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final class DBMigrationsComm$6
extends Migration {
    public DBMigrationsComm$6(int n10, int n11) {
        super(n10, n11);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("ALTER TABLE filter_data ADD COLUMN `licensePath` TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE filter_data ADD COLUMN `licenseName` TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE sticker_data ADD COLUMN `licensePath` TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE sticker_data ADD COLUMN `licenseName` TEXT");
    }
}

