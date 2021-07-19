/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import m.a.a;

public final class DBMigrationsTemplate$4
extends Migration {
    public DBMigrationsTemplate$4(int n10, int n11) {
        super(n10, n11);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Object[] objectArray = new Object[]{};
        a.i("MIGRATION_4_5, \u6570\u636e\u5e93", objectArray);
        supportSQLiteDatabase.execSQL("DROP TABLE music_info_data");
        supportSQLiteDatabase.execSQL("DROP TABLE filter_data");
        supportSQLiteDatabase.execSQL("DROP TABLE filter_type");
        supportSQLiteDatabase.execSQL("DROP TABLE filter_file");
        supportSQLiteDatabase.execSQL("DROP TABLE album_data");
        supportSQLiteDatabase.execSQL("DROP TABLE music_data");
        supportSQLiteDatabase.execSQL("DROP TABLE music_file");
        supportSQLiteDatabase.execSQL("DROP TABLE font_data");
        supportSQLiteDatabase.execSQL("DROP TABLE font_file");
        supportSQLiteDatabase.execSQL("DROP TABLE caption_style_data");
        supportSQLiteDatabase.execSQL("DROP TABLE caption_style_file");
        supportSQLiteDatabase.execSQL("DROP TABLE sticker_type");
        supportSQLiteDatabase.execSQL("DROP TABLE sticker_data");
        supportSQLiteDatabase.execSQL("DROP TABLE sticker_file");
        supportSQLiteDatabase.execSQL("DROP TABLE transition_data");
        supportSQLiteDatabase.execSQL("DROP TABLE transition_file");
    }
}

