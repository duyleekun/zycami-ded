/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import m.a.a;

public final class DBMigrations$10
extends Migration {
    public DBMigrations$10(int n10, int n11) {
        super(n10, n11);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Object[] objectArray = new Object[]{};
        a.b("-----MIGRATION_10_11", objectArray);
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `MessageViolation` (`id` INTEGER NOT NULL, `verb` TEXT, `refId` INTEGER NOT NULL, `refType` TEXT, `content` TEXT, `createAt` TEXT, `isRead` INTEGER NOT NULL, `build_time` TEXT, `degree` TEXT, `refuse_reason` TEXT, `appeal_id` TEXT, `appeal_status` TEXT, `has_punish` TEXT, `classify` TEXT, `punish` TEXT, `forever` TEXT, `punish_endtime` TEXT, `circle_name` TEXT, `source` TEXT, `source_id` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        supportSQLiteDatabase.execSQL("ALTER TABLE MessageUnReadCount ADD COLUMN punished INTEGER NOT NULL default 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE Works ADD COLUMN approval_id INTEGER");
        supportSQLiteDatabase.execSQL("ALTER TABLE Works ADD COLUMN approval_degree TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE Works ADD COLUMN approval_createAt TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE Works ADD COLUMN approval_refuse_reason TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE Works ADD COLUMN approval_classify TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE Works ADD COLUMN approval_circle_name TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE Works ADD COLUMN approval_modify TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE Works ADD COLUMN approval_comment TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE Works ADD COLUMN appeal_id INTEGER");
        supportSQLiteDatabase.execSQL("ALTER TABLE Works ADD COLUMN appeal_approval_id TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE Works ADD COLUMN appeal_appeal_reason TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE Works ADD COLUMN appeal_punish_id TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE Works ADD COLUMN appeal_classify INTEGER");
        supportSQLiteDatabase.execSQL("ALTER TABLE Works ADD COLUMN appeal_status INTEGER");
        supportSQLiteDatabase.execSQL("ALTER TABLE Works ADD COLUMN appeal_sourceUrls TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE Works ADD COLUMN appeal_createAt TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE Works ADD COLUMN appeal_refuse_reason TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE Works ADD COLUMN appeal_comment TEXT");
    }
}

