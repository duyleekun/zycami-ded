/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.content.Context
 */
package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import com.xiaomi.push.bp;
import com.xiaomi.push.cb$e;
import com.xiaomi.push.hq;
import com.xiaomi.push.iw;
import com.xiaomi.push.ix;

public class by
extends cb$e {
    private String a = "MessageInsertJob";

    public by(String string2, ContentValues contentValues, String string3) {
        super(string2, contentValues);
        this.a = string3;
    }

    public static by a(Context object, String string2, hq object2) {
        int n10;
        byte[] byArray = iw.a((ix)object2);
        if (byArray != null && (n10 = byArray.length) > 0) {
            ContentValues contentValues = new ContentValues();
            Integer n11 = 0;
            contentValues.put("status", n11);
            contentValues.put("messageId", "");
            object2 = ((hq)object2).d();
            contentValues.put("messageItemId", (String)object2);
            contentValues.put("messageItem", byArray);
            object2 = bp.a(object).b();
            contentValues.put("appId", (String)object2);
            object = bp.a(object).a();
            contentValues.put("packageName", (String)object);
            object = System.currentTimeMillis();
            contentValues.put("createTimeStamp", (Long)object);
            object = 0;
            contentValues.put("uploadTimestamp", (Integer)object);
            object = new by(string2, contentValues, "a job build to insert message to db");
            return object;
        }
        return null;
    }
}

