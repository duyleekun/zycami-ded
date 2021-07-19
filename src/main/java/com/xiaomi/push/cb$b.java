/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 */
package com.xiaomi.push;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.xiaomi.push.cb$a;
import java.util.ArrayList;
import java.util.List;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class cb$b
extends cb$a {
    private int a;
    private String a;
    private List a;
    private String[] a;
    private List b;
    private String c;
    private String d;
    private String e;

    public cb$b(String arrayList, List list, String string2, String[] stringArray, String string3, String string4, String string5, int n10) {
        super((String)((Object)arrayList));
        this.b = arrayList = new ArrayList();
        this.a = list;
        this.a = string2;
        this.a = stringArray;
        this.c = string3;
        this.d = string4;
        this.e = string5;
        this.a = n10;
    }

    public SQLiteDatabase a() {
        return ((cb$a)this).a.getReadableDatabase();
    }

    public abstract Object a(Context var1, Cursor var2);

    public void a(Context context, SQLiteDatabase object) {
        String[] stringArray;
        int n10;
        this.b.clear();
        Object object2 = this.a;
        Object object3 = null;
        if (object2 != null && (n10 = object2.size()) > 0) {
            n10 = this.a.size();
            object2 = new String[n10];
            List list = this.a;
            list.toArray((T[])object2);
            stringArray = object2;
        } else {
            stringArray = null;
        }
        n10 = this.a;
        if (n10 > 0) {
            object3 = String.valueOf(n10);
        }
        String string2 = ((cb$a)this).b;
        String string3 = this.a;
        String[] stringArray2 = this.a;
        String string4 = this.c;
        String string5 = this.d;
        String string6 = this.e;
        object = object.query(string2, stringArray, string3, stringArray2, string4, string5, string6, (String)object3);
        if (object != null && (n10 = (int)(object.moveToFirst() ? 1 : 0)) != 0) {
            do {
                if ((object2 = this.a(context, (Cursor)object)) == null) continue;
                object3 = this.b;
                object3.add(object2);
            } while ((n10 = (int)(object.moveToNext() ? 1 : 0)) != 0);
            object.close();
        }
        object = this.b;
        this.a(context, (List)object);
    }

    public abstract void a(Context var1, List var2);
}

