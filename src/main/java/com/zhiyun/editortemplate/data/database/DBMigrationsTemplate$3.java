/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import m.a.a;

public final class DBMigrationsTemplate$3
extends Migration {
    public DBMigrationsTemplate$3(int n10, int n11) {
        super(n10, n11);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Object[] objectArray = new Object[]{};
        a.i("MIGRATION_3_4, \u6570\u636e\u5e93", objectArray);
        supportSQLiteDatabase.execSQL("CREATE TABLE `script_track_point_new` (`id` INTEGER PRIMARY KEY NOT NULL,`track_point_id` INTEGER NOT NULL DEFAULT 0, `type` TEXT,`duration` INTEGER NOT NULL DEFAULT 0,`yaw` REAL NOT NULL DEFAULT 0,`pitch` REAL NOT NULL DEFAULT 0,`roll` REAL NOT NULL DEFAULT 0,`zoom_start` REAL,`zoom_end` REAL,`zoom_type` TEXT,`focus_start` REAL,`focus_end` REAL,`focus_type` TEXT, FOREIGN KEY (track_point_id) REFERENCES script_track (id) ON DELETE CASCADE ON UPDATE CASCADE)");
        supportSQLiteDatabase.execSQL("CREATE INDEX index_script_track_point_new_track_point_id ON script_track_point_new (track_point_id)");
        supportSQLiteDatabase.execSQL("INSERT INTO script_track_point_new (id,track_point_id,type,duration,yaw,pitch,roll) SELECT id,track_point_id,type,duration,yaw,pitch,roll FROM script_track_point");
        supportSQLiteDatabase.execSQL("DROP TABLE script_track_point");
        supportSQLiteDatabase.execSQL("ALTER TABLE script_track_point_new RENAME TO script_track_point");
    }
}

