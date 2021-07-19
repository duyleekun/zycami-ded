/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import m.a.a;

public final class DBMigrationsTemplate$5
extends Migration {
    public DBMigrationsTemplate$5(int n10, int n11) {
        super(n10, n11);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Object[] objectArray = new Object[]{};
        a.i("MIGRATION_5_6, \u6570\u636e\u5e93", objectArray);
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `script_new` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `script_id` INTEGER NOT NULL DEFAULT 0,`reference_id` INTEGER NOT NULL DEFAULT 0, FOREIGN KEY (script_id) REFERENCES TemplateData (id) ON DELETE CASCADE ON UPDATE CASCADE)");
        supportSQLiteDatabase.execSQL("CREATE INDEX index_script_new_script_id ON script_new (script_id)");
        supportSQLiteDatabase.execSQL("INSERT INTO script_new (reference_id, script_id) SELECT id,script_id FROM script");
        supportSQLiteDatabase.execSQL("DROP TABLE script");
        supportSQLiteDatabase.execSQL("ALTER TABLE script_new RENAME TO script");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Template_new` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `temp_id` INTEGER NOT NULL DEFAULT 0,`type_id` INTEGER NOT NULL DEFAULT 0,`reference_id` INTEGER NOT NULL DEFAULT 0, FOREIGN KEY (temp_id) REFERENCES TemplateData (id) ON DELETE CASCADE ON UPDATE CASCADE, FOREIGN KEY (type_id) REFERENCES TemplateType (id) ON DELETE CASCADE ON UPDATE CASCADE)");
        supportSQLiteDatabase.execSQL("CREATE INDEX index_Template_new_temp_id ON Template_new (temp_id)");
        supportSQLiteDatabase.execSQL("CREATE INDEX index_Template_new_type_id ON Template_new (type_id)");
        supportSQLiteDatabase.execSQL("INSERT INTO Template_new (reference_id,temp_id,type_id) SELECT id,temp_id,type_id FROM Template");
        supportSQLiteDatabase.execSQL("DROP TABLE Template");
        supportSQLiteDatabase.execSQL("ALTER TABLE Template_new RENAME TO Template");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateData ADD COLUMN `script_ext_status` INTEGER");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateData ADD COLUMN `script_ext_protocol` INTEGER");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateData ADD COLUMN `script_ext_version` INTEGER");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateData ADD COLUMN `is_prime_usable` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("CREATE TABLE `script_track_point_new2` (`id` INTEGER PRIMARY KEY NOT NULL,`track_point_id` INTEGER NOT NULL DEFAULT 0, `type` TEXT,`duration` INTEGER NOT NULL DEFAULT 0,`yaw` REAL,`pitch` REAL,`roll` REAL,`orientation` TEXT,`func` TEXT,`zoom_start` REAL,`zoom_end` REAL,`zoom_type` TEXT,`focus_start` REAL,`focus_end` REAL,`focus_type` TEXT, FOREIGN KEY (track_point_id) REFERENCES script_track (id) ON DELETE CASCADE ON UPDATE CASCADE)");
        supportSQLiteDatabase.execSQL("CREATE INDEX index_script_track_point_new2_track_point_id ON script_track_point_new2 (track_point_id)");
        supportSQLiteDatabase.execSQL("INSERT INTO script_track_point_new2 (id,track_point_id,type,duration,yaw,pitch,roll,zoom_start,zoom_end,zoom_type,focus_start,focus_end,focus_type) SELECT id,track_point_id,type,duration,yaw,pitch,roll,zoom_start,zoom_end,zoom_type,focus_start,focus_end,focus_type FROM script_track_point");
        supportSQLiteDatabase.execSQL("DROP TABLE script_track_point");
        supportSQLiteDatabase.execSQL("ALTER TABLE script_track_point_new2 RENAME TO script_track_point");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `script_track_new` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `script_track_id` INTEGER NOT NULL, `track_id` INTEGER NOT NULL DEFAULT 0, `duration_type` TEXT, FOREIGN KEY (script_track_id) REFERENCES TemplateData (id) ON DELETE CASCADE ON UPDATE CASCADE)");
        supportSQLiteDatabase.execSQL("CREATE INDEX index_script_track_new_script_track_id ON script_track_new (script_track_id)");
        supportSQLiteDatabase.execSQL("INSERT INTO script_track_new (id,script_track_id,duration_type) SELECT id,track_id,duration_type FROM script_track");
        supportSQLiteDatabase.execSQL("DROP TABLE script_track");
        supportSQLiteDatabase.execSQL("ALTER TABLE script_track_new RENAME TO script_track");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `script_metadata` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `track_metadata_id` INTEGER NOT NULL DEFAULT 0, `product` TEXT, `name` TEXT, `version` INTEGER NOT NULL DEFAULT 0, FOREIGN KEY (track_metadata_id) REFERENCES script_track (id) ON DELETE CASCADE ON UPDATE CASCADE)");
        supportSQLiteDatabase.execSQL("CREATE INDEX index_script_metadata_track_metadata_id ON script_metadata (track_metadata_id)");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateData ADD COLUMN `template_proto_type` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateGlobal ADD COLUMN `temp_display_type` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateGlobal ADD COLUMN `roi_enable` INTEGER");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateGlobal ADD COLUMN `roi_start_center` TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateGlobal ADD COLUMN `roi_start_width` REAL");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateGlobal ADD COLUMN `roi_start_height` REAL");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateGlobal ADD COLUMN `roi_end_center` TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateGlobal ADD COLUMN `roi_end_width` REAL");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateGlobal ADD COLUMN `roi_end_height` REAL");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateGlobal ADD COLUMN `roi_duration` INTEGER");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateVideo ADD COLUMN `rate_type` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateVideo ADD COLUMN `bezier_rate` TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateVideo ADD COLUMN `roi_enable` INTEGER");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateVideo ADD COLUMN `roi_start_center` TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateVideo ADD COLUMN `roi_start_width` REAL");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateVideo ADD COLUMN `roi_start_height` REAL");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateVideo ADD COLUMN `roi_end_center` TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateVideo ADD COLUMN `roi_end_width` REAL");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateVideo ADD COLUMN `roi_end_height` REAL");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateVideo ADD COLUMN `roi_duration` INTEGER");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateVideo ADD COLUMN `rotate_frame_center` TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateVideo ADD COLUMN `rotate_frame_scale` TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateVideo ADD COLUMN `rotate_frame_rotate` INTEGER");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateVideo ADD COLUMN `is_local_source` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateVideo ADD COLUMN `is_reverse` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateVideo ADD COLUMN `reverse_path` TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateMusic ADD COLUMN `fade_in_start_time` INTEGER");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateMusic ADD COLUMN `fade_in_end_time` INTEGER");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateMusic ADD COLUMN `fade_in_start_volume` REAL");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateMusic ADD COLUMN `fade_in_end_volume` REAL");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateMusic ADD COLUMN `fade_out_start_time` INTEGER");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateMusic ADD COLUMN `fade_out_end_time` INTEGER");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateMusic ADD COLUMN `fade_out_start_volume` REAL");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateMusic ADD COLUMN `fade_out_end_volume` REAL");
        supportSQLiteDatabase.execSQL("ALTER TABLE template_recording ADD COLUMN `fade_in_start_time` INTEGER");
        supportSQLiteDatabase.execSQL("ALTER TABLE template_recording ADD COLUMN `fade_in_end_time` INTEGER");
        supportSQLiteDatabase.execSQL("ALTER TABLE template_recording ADD COLUMN `fade_in_start_volume` REAL");
        supportSQLiteDatabase.execSQL("ALTER TABLE template_recording ADD COLUMN `fade_in_end_volume` REAL");
        supportSQLiteDatabase.execSQL("ALTER TABLE template_recording ADD COLUMN `fade_out_start_time` INTEGER");
        supportSQLiteDatabase.execSQL("ALTER TABLE template_recording ADD COLUMN `fade_out_end_time` INTEGER");
        supportSQLiteDatabase.execSQL("ALTER TABLE template_recording ADD COLUMN `fade_out_start_volume` REAL");
        supportSQLiteDatabase.execSQL("ALTER TABLE template_recording ADD COLUMN `fade_out_end_volume` REAL");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateType ADD COLUMN `template_proto_type` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("UPDATE TemplateData SET template_use_type = 2 WHERE id IN (SELECT back_id FROM withdraw)");
        supportSQLiteDatabase.execSQL("UPDATE TemplateData SET template_use_type = 3 WHERE id IN (SELECT draft_id FROM draft)");
        supportSQLiteDatabase.execSQL("ALTER TABLE TemplateData ADD COLUMN `first_loaded` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("DROP TABLE TemplateFileRelation");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `TemplateFileRelation` (`temp_id` INTEGER NOT NULL, `file_hash` TEXT NOT NULL,PRIMARY KEY(temp_id, file_hash), FOREIGN KEY (temp_id) REFERENCES TemplateData (id) ON DELETE CASCADE ON UPDATE CASCADE, FOREIGN KEY (file_hash) REFERENCES FileData (hash) ON DELETE CASCADE ON UPDATE CASCADE)");
        supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS index_TemplateFileRelation_temp_id ON TemplateFileRelation (temp_id)");
        supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS index_TemplateFileRelation_file_hash ON TemplateFileRelation (file_hash)");
        supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS index_TemplateFileRelation_temp_id_file_hash ON TemplateFileRelation (temp_id, file_hash)");
        supportSQLiteDatabase.execSQL("INSERT INTO TemplateFileRelation (temp_id,file_hash) SELECT TemplateData.id, FileData.hash FROM TemplateData, FileData WHERE TemplateData.temp_type == 0");
    }
}

