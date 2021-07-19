/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import m.a.a;

public final class DBMigrationsTemplate$2
extends Migration {
    public DBMigrationsTemplate$2(int n10, int n11) {
        super(n10, n11);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Object[] objectArray = new Object[]{};
        a.i("MIGRATION_2_3, \u6570\u636e\u5e93", objectArray);
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `template_recording` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `temp_id` INTEGER NOT NULL, `name` TEXT, `title` TEXT, `attach_time` INTEGER NOT NULL, `start_time` INTEGER NOT NULL, `end_time` INTEGER NOT NULL, `timebase` INTEGER NOT NULL, `volume` REAL NOT NULL, `mute` INTEGER NOT NULL, `local_source` INTEGER NOT NULL, `customer_uuid` TEXT, FOREIGN KEY(`temp_id`) REFERENCES `TemplateData`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_TemplateRecording_temp_id` ON `template_recording` (`temp_id`)");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateGlobal ADD COLUMN `voice_enable` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateVideo ADD COLUMN `voice_enable` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateVideo ADD COLUMN `customer_uuid` TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateSticker ADD COLUMN `customer_uuid` TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateMusic ADD COLUMN `customer_uuid` TEXT");
        supportSQLiteDatabase.execSQL("DROP TABLE filter_data");
        supportSQLiteDatabase.execSQL("alter table caption_style_data add column `licenseName` TEXT");
        supportSQLiteDatabase.execSQL("alter table caption_style_data add column `licensePath` TEXT");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `filter_data` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `res_id` INTEGER NOT NULL, `label` TEXT, `label_tw` TEXT, `label_en` TEXT, `sort` INTEGER NOT NULL,  `main_sort` INTEGER NOT NULL, `type_id` INTEGER NOT NULL, `size` INTEGER NOT NULL, `path` TEXT, `thumb` TEXT, `hash` TEXT)");
        supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_FilterData_type_id` ON `filter_data` (`type_id`)");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `sticker_type` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `res_id` INTEGER NOT NULL, `label` TEXT,`label_tw` TEXT,`label_en` TEXT,`sort` INTEGER NOT NULL)");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `sticker_data` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `res_id` INTEGER NOT NULL, `label` TEXT,`label_tw` TEXT,`label_en` TEXT,`sort` INTEGER NOT NULL,`type_id` INTEGER NOT NULL,`size` INTEGER NOT NULL,`name` TEXT,`scale` REAL NOT NULL,`thumb` TEXT,`little_thumb` TEXT,`path` TEXT,`hash` TEXT)");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `sticker_file` (`hash` TEXT NOT NULL, `name` TEXT, `category` TEXT, `mime` TEXT, `size` INTEGER NOT NULL, `url` TEXT, `path` TEXT, `download_timestamp` INTEGER NOT NULL, `ext_lic_url` TEXT, `ext_lic_name` TEXT, `ext_lic_path` TEXT, PRIMARY KEY(`hash`))");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `transition_data` (`size` INTEGER NOT NULL, `path` TEXT, `hash` TEXT, `thumb` TEXT, `littleThumb` TEXT, `transitionType` 'INTEGER' NOT NULL, `licenseName` TEXT, `licensePath` TEXT, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `res_id` INTEGER NOT NULL, `label` TEXT, `label_tw` TEXT, `label_en` TEXT, `sort` INTEGER NOT NULL)");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `transition_file` (`hash` TEXT NOT NULL, `name` TEXT, `category` TEXT, `mime` TEXT, `size` INTEGER NOT NULL, `url` TEXT, `path` TEXT, `download_timestamp` INTEGER NOT NULL, `ext_lic_url` TEXT, `ext_lic_name` TEXT, `ext_lic_path` TEXT, PRIMARY KEY(`hash`))");
    }
}

