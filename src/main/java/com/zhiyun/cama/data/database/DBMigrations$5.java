/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final class DBMigrations$5
extends Migration {
    public DBMigrations$5(int n10, int n11) {
        super(n10, n11);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Feedback` (`errcode` INTEGER NOT NULL, `errmsg` TEXT, `id` INTEGER NOT NULL, `userId` INTEGER NOT NULL, `name` TEXT, `contact` TEXT, `title` TEXT, `content` TEXT, `type` TEXT, `platform` TEXT, `mobileModel` TEXT, `mobileOSVersion` TEXT, `appVersion` TEXT, `deviceModel` TEXT, `images` TEXT, `user_lang` TEXT, `firmwareVersion` TEXT, `frequency` INTEGER NOT NULL, `advice_target` TEXT, `dealStatus` INTEGER NOT NULL, `createAt` TEXT, `closedAt` TEXT, `canActive` INTEGER NOT NULL, PRIMARY KEY(`id`))");
    }
}

