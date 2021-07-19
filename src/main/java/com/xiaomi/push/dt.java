/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 */
package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import com.xiaomi.push.ds;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class dt
implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ Intent a;
    public final /* synthetic */ ds a;

    public dt(ds ds2, Context context, Intent intent) {
        this.a = ds2;
        this.a = context;
        this.a = intent;
    }

    public void run() {
        ds ds2 = this.a;
        Context context = this.a;
        Intent intent = this.a;
        ds.a(ds2, context, intent);
    }
}

