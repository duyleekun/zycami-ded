/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.text.TextUtils
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import com.xiaomi.mipush.sdk.d;
import com.xiaomi.mipush.sdk.h;
import java.util.Map;

public class FCMPushHelper {
    public static void clearToken(Context context) {
        d d10 = d.b;
        h.a(context, d10);
    }

    public static void convertMessage(Intent intent) {
        h.a(intent);
    }

    public static boolean isFCMSwitchOpen(Context context) {
        boolean bl2;
        d d10 = d.b;
        boolean bl3 = h.a(context, d10);
        if (bl3 && (bl2 = MiPushClient.getOpenFCMPush(context))) {
            bl2 = true;
        } else {
            bl2 = false;
            context = null;
        }
        return bl2;
    }

    public static void notifyFCMNotificationCome(Context context, Map object) {
        Object object2 = "pushMsg";
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = (String)object.get(object2)));
        if (!bl2 && (object2 = h.a(context)) != null) {
            object = h.a((String)object);
            ((PushMessageReceiver)((Object)object2)).onNotificationMessageArrived(context, (MiPushMessage)object);
        }
    }

    public static void notifyFCMPassThoughMessageCome(Context context, Map object) {
        Object object2 = "pushMsg";
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = (String)object.get(object2)));
        if (!bl2 && (object2 = h.a(context)) != null) {
            object = h.a((String)object);
            ((PushMessageReceiver)((Object)object2)).onReceivePassThroughMessage(context, (MiPushMessage)object);
        }
    }

    public static void reportFCMMessageDelete() {
        MiTinyDataClient.upload(h.b(d.b), "fcm", 1L, "some fcm messages was deleted ");
    }

    public static void uploadToken(Context context, String string2) {
        d d10 = d.b;
        h.a(context, d10, string2);
    }
}

