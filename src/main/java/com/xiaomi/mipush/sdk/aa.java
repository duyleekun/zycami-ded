/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import com.xiaomi.channel.commonutils.logger.b;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class aa
implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ Intent a;

    public aa(Context context, Intent intent) {
        this.a = context;
        this.a = intent;
    }

    public void run() {
        Object object = this.a;
        Intent intent = this.a;
        try {
            object.startService(intent);
        }
        catch (Exception exception) {
            object = exception.getMessage();
            b.a((String)object);
        }
    }
}

