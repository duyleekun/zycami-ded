/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import m.a.a;

public final class DBMigrationsTemplate$1
extends Migration {
    public DBMigrationsTemplate$1(int n10, int n11) {
        super(n10, n11);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Object[] objectArray = new Object[]{};
        a.i("MIGRATION_1_2, \u6570\u636e\u5e93", objectArray);
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `script` (`id` INTEGER PRIMARY KEY NOT NULL,`script_id` INTEGER NOT NULL DEFAULT 0, FOREIGN KEY (script_id) REFERENCES TemplateData (id) ON DELETE CASCADE ON UPDATE CASCADE)");
        supportSQLiteDatabase.execSQL("CREATE INDEX index_script_script_id ON script (script_id)");
    }
}

