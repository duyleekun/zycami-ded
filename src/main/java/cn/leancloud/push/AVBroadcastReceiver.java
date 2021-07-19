/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 */
package cn.leancloud.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cn.leancloud.AVLogger;
import cn.leancloud.push.PushService;
import cn.leancloud.utils.LogUtil;

public class AVBroadcastReceiver
extends BroadcastReceiver {
    private static final AVLogger LOGGER = LogUtil.getLogger(AVBroadcastReceiver.class);

    public void onReceive(Context context, Intent object) {
        Object object2 = PushService.class;
        object = new Intent(context, (Class)object2);
        try {
            context.startService((Intent)object);
        }
        catch (Exception exception) {
            object = LOGGER;
            object2 = new StringBuilder();
            String string2 = "failed to start PushService. cause: ";
            ((StringBuilder)object2).append(string2);
            String string3 = exception.getMessage();
            ((StringBuilder)object2).append(string3);
            string3 = ((StringBuilder)object2).toString();
            ((AVLogger)object).e(string3);
        }
    }
}

