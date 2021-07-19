/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final class DBMigrations$6
extends Migration {
    public DBMigrations$6(int n10, int n11) {
        super(n10, n11);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("ALTER TABLE PublishWorks ADD COLUMN shareToKwai INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE PublishWorks ADD COLUMN kwaiToken TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE PublishWorks ADD COLUMN coverObjectKey TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE PublishWorks ADD COLUMN fileObjectKey TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE MessageSystem ADD COLUMN userId INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE MessageSystem ADD COLUMN avatar TEXT");
    }
}

