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
import java.util.ArrayList;
import java.util.Iterator;

public class cb$c
extends cb$a {
    private ArrayList a;

    public cb$c(String arrayList, ArrayList arrayList2) {
        super((String)((Object)arrayList));
        this.a = arrayList = new ArrayList();
        arrayList.addAll(arrayList2);
    }

    public final void a(Context context) {
        boolean bl2;
        super.a(context);
        Iterator iterator2 = this.a.iterator();
        while (bl2 = iterator2.hasNext()) {
            cb$a cb$a = (cb$a)iterator2.next();
            if (cb$a == null) continue;
            cb$a.a(context);
        }
    }

    public void a(Context context, SQLiteDatabase sQLiteDatabase) {
        boolean bl2;
        Iterator iterator2 = this.a.iterator();
        while (bl2 = iterator2.hasNext()) {
            cb$a cb$a = (cb$a)iterator2.next();
            if (cb$a == null) continue;
            cb$a.a(context, sQLiteDatabase);
        }
    }
}

