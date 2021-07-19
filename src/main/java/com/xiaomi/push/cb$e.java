/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.content.Context
 *  android.database.sqlite.SQLiteDatabase
 */
package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.xiaomi.push.cb$a;

public class cb$e
extends cb$a {
    private ContentValues a;

    public cb$e(String string2, ContentValues contentValues) {
        super(string2);
        this.a = contentValues;
    }

    public void a(Context object, SQLiteDatabase sQLiteDatabase) {
        object = this.b;
        ContentValues contentValues = this.a;
        sQLiteDatabase.insert((String)object, null, contentValues);
    }
}

