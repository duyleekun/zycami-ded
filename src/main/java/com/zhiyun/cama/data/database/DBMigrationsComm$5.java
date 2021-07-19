/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final class DBMigrationsComm$5
extends Migration {
    public DBMigrationsComm$5(int n10, int n11) {
        super(n10, n11);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `music_beat_data` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `music_path` TEXT , `beat_map` TEXT)");
        supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_music_beat_data_music_path` ON `music_beat_data` (`music_path`)");
        supportSQLiteDatabase.execSQL("ALTER TABLE caption_style_data ADD COLUMN `requiredPrime` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE filter_data ADD COLUMN `requiredPrime` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE font_data ADD COLUMN `requiredPrime` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE music_data ADD COLUMN `requiredPrime` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE sticker_data ADD COLUMN `requiredPrime` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE transition_data ADD COLUMN `requiredPrime` INTEGER NOT NULL DEFAULT 0");
    }
}

