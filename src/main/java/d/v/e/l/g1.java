/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.PowerManager
 */
package d.v.e.l;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.PowerManager;

public class g1 {
    public static void a(Context context) {
        CharSequence charSequence;
        PowerManager powerManager = (PowerManager)context.getSystemService("power");
        boolean bl2 = powerManager.isIgnoringBatteryOptimizations((String)(charSequence = context.getPackageName()));
        if (!bl2) {
            powerManager = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("package:");
            String string2 = context.getPackageName();
            ((StringBuilder)charSequence).append(string2);
            charSequence = Uri.parse((String)((StringBuilder)charSequence).toString());
            powerManager.setData((Uri)charSequence);
            context.startActivity((Intent)powerManager);
        }
    }
}

