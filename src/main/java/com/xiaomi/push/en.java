/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.em;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class en
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Context a;
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    public en(Context context, String string2, int n10, String string3) {
        this.a = context;
        this.a = string2;
        this.a = n10;
        this.b = string3;
    }

    public void run() {
        Context context = this.a;
        String string2 = this.a;
        int n10 = this.a;
        String string3 = this.b;
        em.b(context, string2, n10, string3);
    }
}

