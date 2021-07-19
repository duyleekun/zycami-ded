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
import com.xiaomi.mipush.sdk.PushMessageHandler;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class am
implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ Intent a;

    public am(Context context, Intent intent) {
        this.a = context;
        this.a = intent;
    }

    public void run() {
        Context context = this.a;
        Intent intent = this.a;
        PushMessageHandler.b(context, intent);
    }
}

