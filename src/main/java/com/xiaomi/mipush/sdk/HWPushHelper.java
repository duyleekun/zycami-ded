/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.text.TextUtils
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import com.xiaomi.mipush.sdk.ag;
import com.xiaomi.mipush.sdk.av;
import com.xiaomi.mipush.sdk.d;
import com.xiaomi.mipush.sdk.e;
import com.xiaomi.mipush.sdk.h;
import org.json.JSONArray;
import org.json.JSONObject;

public class HWPushHelper {
    private static boolean a = false;

    public static void convertMessage(Intent intent) {
        h.a(intent);
    }

    public static boolean hasNetwork(Context context) {
        return h.a(context);
    }

    public static boolean isHmsTokenSynced(Context object) {
        boolean bl2;
        String string2 = h.a(d.a);
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (bl3) {
            return false;
        }
        string2 = h.a((Context)object, string2);
        object = ag.a((Context)object);
        av av2 = av.c;
        object = ((ag)object).a(av2);
        boolean bl4 = TextUtils.isEmpty((CharSequence)string2);
        return !bl4 && !(bl4 = TextUtils.isEmpty((CharSequence)object)) && (bl2 = (string2 = "synced").equals(object));
    }

    public static boolean isUserOpenHmsPush(Context context) {
        return MiPushClient.getOpenHmsPush(context);
    }

    public static boolean needConnect() {
        return a;
    }

    public static void notifyHmsNotificationMessageClicked(Context context, String object) {
        Object object2;
        Object object3;
        boolean bl2;
        Object object4;
        block11: {
            object4 = "pushMsg";
            bl2 = TextUtils.isEmpty((CharSequence)object);
            object3 = "";
            if (!bl2) {
                int n10;
                try {
                    object2 = new JSONArray((String)object);
                    n10 = object2.length();
                    if (n10 <= 0) break block11;
                    n10 = 0;
                    object = null;
                }
                catch (Exception exception) {
                    object = exception.toString();
                    b.d((String)object);
                }
                while (true) {
                    block12: {
                        int n11 = object2.length();
                        if (n10 >= n11) break block11;
                        JSONObject jSONObject = object2.getJSONObject(n10);
                        boolean bl3 = jSONObject.has((String)object4);
                        if (!bl3) break block12;
                        object3 = object = jSONObject.getString((String)object4);
                    }
                    ++n10;
                }
            }
        }
        if ((object = h.a(context)) != null) {
            object4 = h.a((String)object3);
            object2 = ((MiPushMessage)object4).getExtra();
            bl2 = object2.containsKey(object3 = "notify_effect");
            if (bl2) {
                return;
            }
            ((PushMessageReceiver)((Object)object)).onNotificationMessageClicked(context, (MiPushMessage)object4);
        }
    }

    public static void notifyHmsPassThoughMessageArrived(Context context, String object) {
        Object object2;
        Object object3;
        block7: {
            object3 = "content";
            object2 = "";
            boolean bl2 = TextUtils.isEmpty((CharSequence)object);
            if (bl2) break block7;
            JSONObject jSONObject = new JSONObject((String)object);
            boolean bl3 = jSONObject.has((String)object3);
            if (!bl3) break block7;
            try {
                object2 = object = jSONObject.getString((String)object3);
            }
            catch (Exception exception) {
                object = exception.toString();
                b.d((String)object);
            }
        }
        if ((object = h.a(context)) != null) {
            object3 = h.a((String)object2);
            ((PushMessageReceiver)((Object)object)).onReceivePassThroughMessage(context, (MiPushMessage)object3);
        }
    }

    public static void registerHuaWeiAssemblePush(Context object) {
        object = e.a((Context)object);
        d d10 = d.a;
        if ((object = ((e)object).a(d10)) != null) {
            object.register();
        }
    }

    public static void reportError(String string2, int n10) {
        h.a(string2, n10);
    }

    public static void setConnectTime(Context context) {
        Class<HWPushHelper> clazz = HWPushHelper.class;
        synchronized (clazz) {
            String string2 = "mipush_extra";
            context = context.getSharedPreferences(string2, 0);
            context = context.edit();
            string2 = "last_connect_time";
            long l10 = System.currentTimeMillis();
            context = context.putLong(string2, l10);
            context.commit();
            return;
        }
    }

    public static void setGetTokenTime(Context context) {
        Class<HWPushHelper> clazz = HWPushHelper.class;
        synchronized (clazz) {
            String string2 = "mipush_extra";
            context = context.getSharedPreferences(string2, 0);
            context = context.edit();
            string2 = "last_get_token_time";
            long l10 = System.currentTimeMillis();
            context = context.putLong(string2, l10);
            context.commit();
            return;
        }
    }

    public static void setNeedConnect(boolean bl2) {
        a = bl2;
    }

    public static boolean shouldGetToken(Context context) {
        Class<HWPushHelper> clazz = HWPushHelper.class;
        synchronized (clazz) {
            boolean bl2;
            block6: {
                String string2 = "mipush_extra";
                bl2 = false;
                context = context.getSharedPreferences(string2, 0);
                long l10 = System.currentTimeMillis();
                string2 = "last_get_token_time";
                long l11 = -1;
                l11 = context.getLong(string2, l11);
                l10 -= l11;
                l10 = Math.abs(l10);
                l11 = 172800000L;
                long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                if (l12 <= 0) break block6;
                bl2 = true;
            }
            return bl2;
        }
    }

    public static boolean shouldTryConnect(Context context) {
        Class<HWPushHelper> clazz = HWPushHelper.class;
        synchronized (clazz) {
            boolean bl2;
            block6: {
                String string2 = "mipush_extra";
                bl2 = false;
                context = context.getSharedPreferences(string2, 0);
                long l10 = System.currentTimeMillis();
                string2 = "last_connect_time";
                long l11 = -1;
                l11 = context.getLong(string2, l11);
                l10 -= l11;
                l10 = Math.abs(l10);
                l11 = 5000L;
                long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                if (l12 <= 0) break block6;
                bl2 = true;
            }
            return bl2;
        }
    }

    public static void uploadToken(Context context, String string2) {
        d d10 = d.a;
        h.a(context, d10, string2);
    }
}

