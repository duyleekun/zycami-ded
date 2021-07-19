/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.p;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class q
implements Runnable {
    public final /* synthetic */ p a;
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public q(p p10, String string2, String string3, String string4) {
        this.a = p10;
        this.a = string2;
        this.b = string3;
        this.c = string4;
    }

    public void run() {
        Context context = p.a(this.a);
        String string2 = this.a;
        context = context.getSharedPreferences(string2, 4).edit();
        string2 = this.b;
        String string3 = this.c;
        context.putString(string2, string3);
        context.commit();
    }
}

