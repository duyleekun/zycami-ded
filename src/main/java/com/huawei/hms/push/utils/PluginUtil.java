/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.text.TextUtils
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.huawei.hms.push.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.push.e;
import com.huawei.hms.push.h;
import com.huawei.hms.push.i;
import com.huawei.hms.push.t;
import com.huawei.hms.push.w;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.nio.charset.Charset;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class PluginUtil {
    public static String a(String string2) {
        JSONObject jSONObject;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return null;
        }
        try {
            jSONObject = new JSONObject();
        }
        catch (JSONException jSONException) {
            HMSLog.e("PluginUtil", "rebuild message failed");
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        String string3 = "data";
        jSONObject.put(string3, (Object)string2);
        string2 = "msgContent";
        jSONObject2.put(string2, (Object)jSONObject);
        return jSONObject2.toString();
    }

    public static void a(Context context, String string2) {
        e.a(context, string2, null, "102");
    }

    public static void a(Context context, String string2, String object, String object2) {
        String string3 = "PluginUtil";
        Object object3 = "onNotification";
        HMSLog.i(string3, (String)object3);
        boolean bl2 = t.a(context);
        if (!bl2) {
            object = new StringBuilder();
            object2 = context.getPackageName();
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(" disable display notification.");
            object = ((StringBuilder)object).toString();
            HMSLog.i(string3, (String)object);
            e.a(context, string2, null, "103");
            return;
        }
        string2 = new Intent();
        string2.setAction("com.huawei.push.msg.NOTIFY_MSG");
        object3 = w.a;
        object2 = ((String)object2).getBytes((Charset)object3);
        string2.putExtra("selfshow_info", (byte[])object2);
        object = ((String)object).getBytes((Charset)object3);
        string2.putExtra("selfshow_token", (byte[])object);
        object = context.getPackageName();
        string2.setPackage((String)object);
        i.a(context, (Intent)string2);
        HMSLog.i(string3, "invokeSelfShow done");
    }

    public static boolean a(Context context) {
        int n10;
        Iterator iterator2 = ((ActivityManager)context.getSystemService("activity")).getRunningAppProcesses().iterator();
        int n11 = 1;
        block0: while (true) {
            int n12;
            n10 = n11;
            while ((n12 = iterator2.hasNext()) != 0) {
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)iterator2.next();
                String string2 = runningAppProcessInfo.processName;
                String string3 = context.getPackageName();
                boolean bl2 = string2.equals(string3);
                if (!bl2) continue;
                n10 = runningAppProcessInfo.importance;
                n12 = 100;
                if (n10 != n12 && n10 != (n12 = 200)) continue block0;
                n10 = 0;
            }
            break;
        }
        return n10 != 0;
    }

    public static boolean a(Context object, String[] object2) {
        boolean bl2 = true;
        String string2 = object2[bl2];
        boolean bl3 = TextUtils.equals((CharSequence)string2, (CharSequence)"0");
        if (bl3) {
            boolean bl4 = PluginUtil.a(object);
            if (!bl4 && !(bl4 = TextUtils.equals((CharSequence)(object = object2[2]), (CharSequence)(object2 = "1")))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public static void onAppOpened(Context context, String string2, String string3) {
        e.a(context, string2, string3, "appHasOpenedId");
    }

    public static boolean onDataMessage(Context context, String object, String string2, boolean bl2) {
        String string3 = "PluginUtil";
        String string4 = "onDataMessage";
        HMSLog.i(string3, string4);
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (bl3) {
            HMSLog.i(string3, "Empty message received");
            return true;
        }
        if (bl2) {
            PluginUtil.a(context, (String)object);
        }
        Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
        string3 = context.getPackageName();
        intent.setPackage(string3);
        string3 = new Bundle();
        string3.putString("message_id", (String)object);
        object = w.a;
        object = string2.getBytes((Charset)object);
        string3.putByteArray("message_body", (byte[])object);
        string3.putString("message_type", "received_message");
        object = new h();
        return ((h)object).a(context, (Bundle)string3, intent);
    }

    public static boolean onDeletedMessages(Context context) {
        String string2 = "PluginUtil";
        String string3 = "onDeletedMessages";
        HMSLog.i(string2, string3);
        if (context == null) {
            return false;
        }
        string2 = new Intent("com.huawei.push.action.MESSAGING_EVENT");
        string3 = context.getPackageName();
        string2.setPackage(string3);
        string3 = new Bundle();
        Object object = ProxyCenter.getProxy().getProxyType();
        string3.putString("message_proxy_type", (String)object);
        string3.putString("message_type", "server_deleted_message");
        object = new h();
        return ((h)object).a(context, (Bundle)string3, (Intent)string2);
    }

    public static void onMessage(Context context, String[] object) {
        int bl2;
        int bl3;
        Object string2 = "PluginUtil";
        String string3 = "onMessage";
        HMSLog.i((String)string2, string3);
        if (context != null && object != null && (bl3 = ((Object)object).length) >= (bl2 = 5)) {
            string2 = ResourceLoaderUtil.getmContext();
            if (string2 == null) {
                string2 = context.getApplicationContext();
                ResourceLoaderUtil.setmContext((Context)string2);
            }
            bl3 = (int)(PluginUtil.a(context, (String[])object) ? 1 : 0);
            int n10 = 4;
            int n11 = 0;
            Object object2 = null;
            if (bl3 != 0) {
                string2 = object[0];
                n11 = 3;
                object2 = object[n11];
                object = object[n10];
                PluginUtil.a(context, (String)string2, (String)object2, (String)object);
            } else {
                string2 = object[0];
                object = object[n10];
                boolean bl4 = true;
                PluginUtil.onDataMessage(context, (String)string2, (String)object, bl4);
            }
        }
    }

    public static boolean onNewToken(Context context, String object, String string2, ErrorEnum object2) {
        HMSLog.i("PluginUtil", "onNewToken called.");
        Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
        String string3 = context.getPackageName();
        intent.setPackage(string3);
        string3 = new Bundle();
        int n10 = object2.getInternalCode();
        string3.putInt("error", n10);
        String string4 = "new_token";
        string3.putString("message_type", string4);
        string3.putString("device_token", (String)object);
        object = context.getPackageName();
        boolean bl2 = TextUtils.equals((CharSequence)string2, (CharSequence)object);
        object2 = "subjectId";
        if (bl2) {
            bl2 = false;
            object = null;
            string3.putString((String)object2, null);
        } else {
            string3.putString((String)object2, string2);
        }
        object = ProxyCenter.getProxy().getProxyType();
        string3.putString("message_proxy_type", (String)object);
        object = new h();
        return ((h)object).a(context, (Bundle)string3, intent);
    }

    public static void onNotificationArrived(Context context, String string2, String string3) {
        e.a(context, string2, string3, "100");
    }

    public static void onNotificationClicked(Context context, String string2, String string3) {
        e.a(context, string2, string3, "1");
        PluginUtil.onAppOpened(context, string2, string3);
    }

    public static boolean onOldDataMessage(Context context, String string2, String string3) {
        Context context2 = ResourceLoaderUtil.getmContext();
        if (context2 == null) {
            context2 = context.getApplicationContext();
            ResourceLoaderUtil.setmContext(context2);
        }
        string3 = PluginUtil.a(string3);
        return PluginUtil.onDataMessage(context, string2, string3, true);
    }

    public static void saveNotifySwitch(Context context, boolean bl2) {
        PushPreferences pushPreferences = new PushPreferences(context, "push_notify_flag");
        pushPreferences.saveBoolean("notify_msg_enable", bl2);
    }
}

