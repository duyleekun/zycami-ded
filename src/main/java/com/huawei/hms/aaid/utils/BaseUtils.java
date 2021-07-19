/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.content.Context
 *  android.os.Process
 *  android.text.TextUtils
 */
package com.huawei.hms.aaid.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.opendevice.b;
import com.huawei.hms.opendevice.d;
import com.huawei.hms.opendevice.e;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.opendevice.n;
import com.huawei.hms.support.log.HMSLog;
import java.util.Map;

public class BaseUtils {
    public static void clearSubjectIds(Context context) {
        i.a(context).removeKey("subjectId");
    }

    public static void delLocalToken(Context context, String string2) {
        i.a(context).c(string2);
    }

    public static void deleteAllTokenCache(Context context) {
        i.a(context).a();
    }

    public static void deleteCacheData(Context context, String string2) {
        i.a(context).removeKey(string2);
    }

    public static String getBaseUrl(Context context, String string2, String string3, String string4, String string5) {
        return e.a(context, string2, string3, string4, string5);
    }

    public static String getCacheData(Context context, String string2, boolean bl2) {
        if (bl2) {
            return i.a(context).a(string2);
        }
        return i.a(context).getString(string2);
    }

    public static String getLocalToken(Context context, String string2) {
        return i.a(context).b(string2);
    }

    public static boolean getProxyInit(Context context) {
        return i.a(context).getBoolean("_proxy_init");
    }

    public static String[] getSubjectIds(Context object) {
        object = i.a((Context)object);
        String string2 = "subjectId";
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = ((PushPreferences)object).getString(string2)));
        if (bl2) {
            return new String[0];
        }
        return ((String)object).split(",");
    }

    public static void initSecret(Context context) {
        b.a(context);
    }

    public static boolean isMainProc(Context object) {
        boolean bl2;
        Object object2 = ((ActivityManager)object.getSystemService("activity")).getRunningAppProcesses();
        object = object.getApplicationInfo().processName;
        int n10 = Process.myPid();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("my.pid -> ");
        charSequence.append(n10);
        charSequence.append(", mainProcessName -> ");
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        String string2 = "BaseUtils";
        HMSLog.d(string2, (String)charSequence);
        object2 = object2.iterator();
        while (bl2 = object2.hasNext()) {
            charSequence = (ActivityManager.RunningAppProcessInfo)object2.next();
            CharSequence charSequence2 = new StringBuilder();
            charSequence2.append("info.pid -> ");
            int n11 = ((ActivityManager.RunningAppProcessInfo)charSequence).pid;
            charSequence2.append(n11);
            charSequence2.append(", info.processName -> ");
            String string3 = ((ActivityManager.RunningAppProcessInfo)charSequence).processName;
            charSequence2.append(string3);
            charSequence2 = charSequence2.toString();
            HMSLog.d(string2, (String)charSequence2);
            int n12 = ((ActivityManager.RunningAppProcessInfo)charSequence).pid;
            if (n12 != n10 || !(bl2 = ((String)object).equals(charSequence = ((ActivityManager.RunningAppProcessInfo)charSequence).processName))) continue;
            return true;
        }
        return false;
    }

    public static void reportAaidToken(Context context, String string2) {
        n.a(context, string2);
    }

    public static boolean saveCacheData(Context context, String string2, String string3, boolean bl2) {
        if (bl2) {
            return i.a(context).a(string2, string3);
        }
        return i.a(context).saveString(string2, string3);
    }

    public static void saveProxyInit(Context context, boolean bl2) {
        i.a(context).saveBoolean("_proxy_init", bl2);
    }

    public static void saveToken(Context context, String string2, String string3) {
        i.a(context).b(string2, string3);
    }

    public static String sendPostRequest(Context context, String string2, String string3, Map map) {
        return d.a(context, string2, string3, map);
    }
}

