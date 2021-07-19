/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push;

import android.content.Context;
import java.util.List;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class dc {
    private int a;

    public dc(int n10) {
        this.a = n10;
    }

    public int a() {
        return this.a;
    }

    public abstract String a(Context var1, String var2, List var3);

    public boolean a(Context context, String string2, List list) {
        return true;
    }
}

