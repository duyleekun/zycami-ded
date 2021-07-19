/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 */
package com.huawei.hms.support.api.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.android.HwBuildEx$VERSION;
import com.huawei.hms.push.i;
import com.huawei.hms.push.t;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;

public class PushMsgReceiver
extends BroadcastReceiver {
    public static void a(Context context, Intent intent) {
        CharSequence charSequence = "selfshow_info";
        boolean bl2 = intent.hasExtra((String)charSequence);
        if (bl2) {
            bl2 = t.a(context);
            if (!bl2) {
                charSequence = new StringBuilder();
                String string2 = context.getPackageName();
                ((StringBuilder)charSequence).append(string2);
                ((StringBuilder)charSequence).append(" disable display notification.");
                charSequence = ((StringBuilder)charSequence).toString();
                string2 = "PushMsgReceiver";
                HMSLog.i(string2, (String)charSequence);
            }
            i.a(context, intent);
        }
    }

    public void onReceive(Context object, Intent object2) {
        if (object2 != null && object != null) {
            int n10;
            int n11;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("push receive broadcast message, Intent:");
            String string2 = object2.getAction();
            charSequence.append(string2);
            charSequence.append(" pkgName:");
            string2 = object.getPackageName();
            charSequence.append(string2);
            charSequence = charSequence.toString();
            string2 = "PushMsgReceiver";
            HMSLog.i(string2, (String)charSequence);
            charSequence = "TestIntent";
            try {
                object2.getStringExtra((String)charSequence);
            }
            catch (Exception exception) {
                object = "intent has some error";
                HMSLog.e(string2, (String)object);
            }
            charSequence = object2.getAction();
            Object object3 = ResourceLoaderUtil.getmContext();
            if (object3 == null) {
                object3 = object.getApplicationContext();
                ResourceLoaderUtil.setmContext((Context)object3);
            }
            if ((n11 = ((String)(object3 = "com.huawei.intent.action.PUSH_DELAY_NOTIFY")).equals(charSequence)) == 0 && ((n10 = ((String)(object3 = "com.huawei.intent.action.PUSH")).equals(charSequence)) == 0 || (n10 = HwBuildEx$VERSION.EMUI_SDK_INT) >= (n11 = 10))) {
                object = new StringBuilder();
                ((StringBuilder)object).append("message can't be recognised:");
                n10 = 0;
                charSequence = null;
                object2 = object2.toUri(0);
                ((StringBuilder)object).append((String)object2);
                object = ((StringBuilder)object).toString();
                HMSLog.i(string2, (String)object);
            } else {
                PushMsgReceiver.a((Context)object, object2);
            }
            return;
        }
    }
}

