/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push.service.receivers;

import android.content.Context;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class a
implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ NetworkStatusReceiver a;

    public a(NetworkStatusReceiver networkStatusReceiver, Context context) {
        this.a = networkStatusReceiver;
        this.a = context;
    }

    public void run() {
        NetworkStatusReceiver networkStatusReceiver = this.a;
        Context context = this.a;
        NetworkStatusReceiver.a(networkStatusReceiver, context);
    }
}

