/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.cama.data.database;

import android.database.Cursor;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import d.v.a.c;
import d.v.a.f.c.b;

public final class DBMigrations$12
extends Migration {
    public DBMigrations$12(int n10, int n11) {
        super(n10, n11);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        int n10 = b.N().O();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("SELECT * FROM UserInfo WHERE id = ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        charSequence = supportSQLiteDatabase.query((String)charSequence);
        c.a(n10, (Cursor)charSequence);
        supportSQLiteDatabase.execSQL("DROP TABLE UserInfo");
    }
}

