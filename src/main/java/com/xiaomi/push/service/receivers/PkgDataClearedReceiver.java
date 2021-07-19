/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.text.TextUtils
 */
package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ax;
import com.xiaomi.push.service.bb;

public class PkgDataClearedReceiver
extends BroadcastReceiver {
    public void onReceive(Context object, Intent object2) {
        String string2;
        Object object3;
        boolean bl2;
        if (object2 != null && (bl2 = ((String)(object3 = "android.intent.action.PACKAGE_DATA_CLEARED")).equals(string2 = object2.getAction())) && (string2 = object2.getData()) != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object2 = object2.getData().getEncodedSchemeSpecificPart())))) {
            object3 = XMPushService.class;
            string2 = new Intent((Context)object, (Class)object3);
            object3 = ax.b;
            string2.setAction((String)object3);
            object3 = "data_cleared_pkg_name";
            string2.putExtra((String)object3, (String)object2);
            object = bb.a((Context)object);
            try {
                ((bb)object).a((Intent)string2);
            }
            catch (Exception exception) {
                object2 = new StringBuilder();
                string2 = "data cleared broadcast error: ";
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append(exception);
                String string3 = ((StringBuilder)object2).toString();
                b.d(string3);
            }
        }
    }
}

