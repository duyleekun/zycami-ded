/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.KeyguardManager
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 */
package com.xiaomi.push;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.xiaomi.channel.commonutils.logger.b;

public class ah {
    public static boolean a(Context object) {
        String string2 = "keyguard";
        try {
            object = object.getSystemService(string2);
        }
        catch (Exception exception) {
            b.a(exception);
            return false;
        }
        object = (KeyguardManager)object;
        return object.inKeyguardRestrictedInputMode();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean b(Context context) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        int n10 = 0;
        Intent intent = null;
        try {
            intent = context.registerReceiver(null, intentFilter);
        }
        catch (Exception exception) {}
        boolean bl2 = false;
        context = null;
        if (intent == null) {
            return false;
        }
        String string2 = "status";
        int n11 = intent.getIntExtra(string2, -1);
        if (n11 == (n10 = 2)) return true;
        n10 = 5;
        if (n11 != n10) return bl2;
        return true;
    }
}

