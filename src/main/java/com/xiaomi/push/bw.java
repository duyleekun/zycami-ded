/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.Cursor
 */
package com.xiaomi.push;

import android.content.Context;
import android.database.Cursor;
import com.xiaomi.push.cb$b;
import java.util.ArrayList;
import java.util.List;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class bw
extends cb$b {
    private long a;
    private String a = 0L;

    public bw(String string2, List list, String string3, String[] stringArray, String string4, String string5, String string6, int n10, String string7) {
        super(string2, list, string3, stringArray, string4, string5, string6, n10);
        this.a = string7;
    }

    public static bw a(String string2) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("count(*)");
        bw bw2 = new bw(string2, arrayList, null, null, null, null, null, 0, "job to get count of all message");
        return bw2;
    }

    public Long a(Context context, Cursor cursor) {
        return cursor.getLong(0);
    }

    public Object a() {
        return this.a;
    }

    public void a(Context object, List list) {
        int n10;
        if (object != null && list != null && (n10 = list.size()) > 0) {
            long l10;
            n10 = 0;
            object = (Long)list.get(0);
            this.a = l10 = ((Long)object).longValue();
        }
    }
}

