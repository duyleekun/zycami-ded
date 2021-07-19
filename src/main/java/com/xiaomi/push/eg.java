/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ed;
import com.xiaomi.push.ho;
import com.xiaomi.push.i;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class eg
extends ed {
    public eg(Context context, int n10) {
        super(context, n10);
    }

    public int a() {
        return 23;
    }

    public ho a() {
        return ho.w;
    }

    public String a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ram:");
        String string2 = i.b();
        stringBuilder.append(string2);
        string2 = ",";
        stringBuilder.append(string2);
        stringBuilder.append("rom:");
        String string3 = i.c();
        stringBuilder.append(string3);
        stringBuilder.append("|");
        stringBuilder.append("ramOriginal:");
        string3 = i.d();
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        stringBuilder.append("romOriginal:");
        string2 = i.e();
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

