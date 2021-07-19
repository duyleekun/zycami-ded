/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.text.TextUtils
 */
package com.huawei.hms.opendevice;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import d.j.a.f.a;
import java.util.UUID;

public class o {
    public static DeleteTokenReq a(Context context, String string2) {
        return o.a(context, null, null, string2, null);
    }

    public static DeleteTokenReq a(Context context, String string2, String string3) {
        return o.a(context, string2, null, null, string3);
    }

    public static DeleteTokenReq a(Context object, String string2, String string3, String string4, String string5) {
        DeleteTokenReq deleteTokenReq = new DeleteTokenReq();
        deleteTokenReq.setAppId(string2);
        deleteTokenReq.setScope(string5);
        deleteTokenReq.setProjectId(string3);
        String string6 = object.getPackageName();
        deleteTokenReq.setPkgName(string6);
        deleteTokenReq.setSubjectId(string4);
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            string2 = Util.getAppId(object);
            deleteTokenReq.setAppId(string2);
        }
        if (bl2 = TextUtils.isEmpty((CharSequence)string5)) {
            string2 = "HCM";
            deleteTokenReq.setScope(string2);
        }
        if (bl2 = TextUtils.isEmpty((CharSequence)string3)) {
            object = o.d(object);
            deleteTokenReq.setProjectId((String)object);
        }
        return deleteTokenReq;
    }

    public static String a(Context context) {
        String string2 = "aaid";
        PushPreferences pushPreferences = new PushPreferences(context, string2);
        boolean bl2 = pushPreferences.containsKey(string2);
        if (bl2) {
            return pushPreferences.getString(string2);
        }
        return null;
    }

    public static DeleteTokenReq b(Context context) {
        return o.a(context, null, null, null, null);
    }

    public static TokenReq b(Context context, String string2) {
        return o.b(context, null, null, string2, null);
    }

    public static TokenReq b(Context context, String string2, String string3) {
        return o.b(context, string2, null, null, string3);
    }

    public static TokenReq b(Context object, String string2, String string3, String string4, String string5) {
        boolean bl2;
        TokenReq tokenReq = new TokenReq();
        String string6 = object.getPackageName();
        tokenReq.setPackageName(string6);
        tokenReq.setAppId(string2);
        tokenReq.setScope(string5);
        tokenReq.setProjectId(string3);
        tokenReq.setSubjectId(string4);
        string4 = null;
        tokenReq.setMultiSender(false);
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (bl3) {
            string2 = Util.getAppId((Context)object);
            tokenReq.setAppId(string2);
        }
        if (bl3 = TextUtils.isEmpty((CharSequence)string3)) {
            string2 = o.d((Context)object);
            tokenReq.setProjectId(string2);
        }
        if (bl3 = TextUtils.isEmpty((CharSequence)string5)) {
            string2 = "HCM";
            tokenReq.setScope(string2);
        }
        if (!(bl2 = ((PushPreferences)(object = i.a((Context)object))).getBoolean(string2 = "hasRequestAgreement"))) {
            bl2 = true;
            tokenReq.setFirstTime(bl2);
            ((PushPreferences)object).saveBoolean(string2, bl2);
        } else {
            tokenReq.setFirstTime(false);
        }
        return tokenReq;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String c(Context object) {
        Class<o> clazz = o.class;
        synchronized (clazz) {
            PushPreferences pushPreferences;
            Object object2;
            block11: {
                object2 = "aaid";
                pushPreferences = new PushPreferences((Context)object, (String)object2);
                object = "aaid";
                boolean bl2 = pushPreferences.containsKey((String)object);
                if (!bl2) break block11;
                object = "aaid";
                return pushPreferences.getString((String)object);
            }
            object = UUID.randomUUID();
            object = ((UUID)object).toString();
            object2 = "aaid";
            pushPreferences.saveString((String)object2, (String)object);
            long l10 = System.currentTimeMillis();
            object2 = l10;
            String string2 = "creationTime";
            pushPreferences.saveLong(string2, (Long)object2);
            return object;
        }
    }

    public static String d(Context context) {
        return a.a(context).g("client/project_id");
    }

    public static boolean e(Context object) {
        block9: {
            block8: {
                Object object2 = object.getPackageManager();
                object = object.getPackageName();
                int n10 = 128;
                object = object2.getApplicationInfo((String)object, n10);
                object2 = null;
                if (object == null) break block8;
                object = object.metaData;
                if (object == null) break block8;
                String string2 = "com.huawei.hms.client.service.name:base";
                object = object.getString(string2);
                try {
                    boolean bl2 = TextUtils.isEmpty((CharSequence)object);
                    if (!bl2) break block9;
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    object = HmsInstanceId.TAG;
                    object2 = "isIntegratedBaseSdk failed.";
                    HMSLog.e((String)object, (String)object2);
                }
            }
            return false;
        }
        return true;
    }
}

