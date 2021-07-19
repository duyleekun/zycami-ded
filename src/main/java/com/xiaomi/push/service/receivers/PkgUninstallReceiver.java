/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 */
package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ax;
import com.xiaomi.push.service.bb;

public class PkgUninstallReceiver
extends BroadcastReceiver {
    public void onReceive(Context object, Intent object2) {
        String string2;
        Object object3;
        boolean bl2;
        if (object2 != null && (bl2 = ((String)(object3 = "android.intent.action.PACKAGE_REMOVED")).equals(string2 = object2.getAction()))) {
            string2 = object2.getExtras();
            object3 = "android.intent.extra.REPLACING";
            bl2 = string2.getBoolean((String)object3);
            if ((object2 = object2.getData()) != null && !bl2) {
                object3 = XMPushService.class;
                string2 = new Intent((Context)object, (Class)object3);
                object3 = ax.a;
                string2.setAction((String)object3);
                object3 = "uninstall_pkg_name";
                object2 = object2.getEncodedSchemeSpecificPart();
                string2.putExtra((String)object3, (String)object2);
                object = bb.a((Context)object);
                try {
                    ((bb)object).a((Intent)string2);
                }
                catch (Exception exception) {
                    b.a(exception);
                }
            }
        }
    }
}

