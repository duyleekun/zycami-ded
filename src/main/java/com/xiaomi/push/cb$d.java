/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.sqlite.SQLiteDatabase
 */
package com.xiaomi.push;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.xiaomi.push.cb$a;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class cb$d
extends cb$a {
    private String a;
    public String[] a;

    public cb$d(String string2, String string3, String[] stringArray) {
        super(string2);
        this.a = string3;
        this.a = stringArray;
    }

    public void a(Context object, SQLiteDatabase sQLiteDatabase) {
        object = this.b;
        String string2 = this.a;
        String[] stringArray = this.a;
        sQLiteDatabase.delete((String)object, string2, stringArray);
    }
}

