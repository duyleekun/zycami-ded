/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.IntentFilter
 */
package com.xiaomi.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ds;
import com.xiaomi.push.dw;
import com.xiaomi.push.dx;
import com.xiaomi.push.mpcd.receivers.BroadcastActionsReceiver;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class dr {
    private static IntentFilter a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        intentFilter.addAction("android.intent.action.PACKAGE_DATA_CLEARED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addAction("android.intent.action.PACKAGE_RESTARTED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        return intentFilter;
    }

    private static dw a() {
        ds ds2 = new ds();
        return ds2;
    }

    public static void a(Context context) {
        Object object = dx.a(context);
        object.a();
        dw dw2 = dr.a();
        object = new BroadcastActionsReceiver(dw2);
        dw2 = dr.a();
        try {
            context.registerReceiver((BroadcastReceiver)object, (IntentFilter)dw2);
        }
        catch (Throwable throwable) {
            b.a(throwable);
        }
    }
}

