/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 */
package com.mob.tools.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.NtFetcher;

public class NtFetcher$2
extends BroadcastReceiver {
    public final /* synthetic */ NtFetcher this$0;

    public NtFetcher$2(NtFetcher ntFetcher) {
        this.this$0 = ntFetcher;
    }

    public void onReceive(Context object, Intent object2) {
        block5: {
            object = object2.getAction();
            object2 = "android.net.conn.CONNECTIVITY_CHANGE";
            boolean bl2 = ((String)object).equalsIgnoreCase((String)object2);
            if (!bl2) break block5;
            object = this.this$0;
            try {
                NtFetcher.access$000((NtFetcher)object);
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                ((NLog)object2).d(throwable);
            }
        }
    }
}

