/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 */
package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.push.ed;
import com.xiaomi.push.ho;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class eh
extends ed {
    private SharedPreferences a;

    public eh(Context context, int n10) {
        super(context, n10);
        context = context.getSharedPreferences("mipush_extra", 0);
        this.a = context;
    }

    public int a() {
        return 9;
    }

    public ho a() {
        return ho.i;
    }

    public String a() {
        return null;
    }
}

