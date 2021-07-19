/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 */
package com.xiaomi.mipush.sdk;

import android.content.Intent;
import com.xiaomi.mipush.sdk.PushMessageReceiver;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class MessageHandleService$a {
    private Intent a;
    private PushMessageReceiver a;

    public MessageHandleService$a(Intent intent, PushMessageReceiver pushMessageReceiver) {
        this.a = pushMessageReceiver;
        this.a = intent;
    }

    public Intent a() {
        return this.a;
    }

    public PushMessageReceiver a() {
        return this.a;
    }
}

