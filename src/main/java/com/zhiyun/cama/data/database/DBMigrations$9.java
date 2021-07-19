/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import m.a.a;

public final class DBMigrations$9
extends Migration {
    public DBMigrations$9(int n10, int n11) {
        super(n10, n11);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Object[] objectArray = new Object[]{};
        a.b("-----MIGRATION_9_10", objectArray);
        supportSQLiteDatabase.execSQL("ALTER TABLE PrimeInfo ADD COLUMN getWay INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE PrimeInfo ADD COLUMN overdueTime INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE PrimeInfo ADD COLUMN inactive INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE PrimeInfo ADD COLUMN createAt TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE PrimeInfo ADD COLUMN updateAt TEXT");
        supportSQLiteDatabase.execSQL("DROP TABLE activation_data");
        supportSQLiteDatabase.execSQL("DROP TABLE device_info");
        supportSQLiteDatabase.execSQL("DROP TABLE AppDeviceInfo");
        supportSQLiteDatabase.execSQL("DROP TABLE firmware_info");
        supportSQLiteDatabase.execSQL("DROP TABLE regional_restrictions_info");
    }
}

