/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import m.a.a;

public final class DBMigrationsComm$4
extends Migration {
    public DBMigrationsComm$4(int n10, int n11) {
        super(n10, n11);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Object[] objectArray = new Object[]{};
        a.i("MIGRATION_4_5, \u6570\u636e\u5e93", objectArray);
        supportSQLiteDatabase.execSQL("DROP TABLE TemplateData");
        supportSQLiteDatabase.execSQL("DROP TABLE Template");
        supportSQLiteDatabase.execSQL("DROP TABLE draft");
        supportSQLiteDatabase.execSQL("DROP TABLE withdraw");
        supportSQLiteDatabase.execSQL("DROP TABLE TemplateGlobal");
        supportSQLiteDatabase.execSQL("DROP TABLE TemplateSticker");
        supportSQLiteDatabase.execSQL("DROP TABLE TemplateVideo");
        supportSQLiteDatabase.execSQL("DROP TABLE SortResult");
        supportSQLiteDatabase.execSQL("DROP TABLE FileData");
        supportSQLiteDatabase.execSQL("DROP TABLE TemplateFileRelation");
        supportSQLiteDatabase.execSQL("DROP TABLE TemplateMusic");
        supportSQLiteDatabase.execSQL("DROP TABLE script_track");
        supportSQLiteDatabase.execSQL("DROP TABLE script_track_point");
        supportSQLiteDatabase.execSQL("DROP TABLE TemplateType");
        supportSQLiteDatabase.execSQL("DROP TABLE script");
        supportSQLiteDatabase.execSQL("DROP TABLE template_recording");
    }
}

