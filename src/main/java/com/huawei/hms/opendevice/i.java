/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.aaid.encrypt.PushEncrypter;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.support.log.HMSLog;

public class i
extends PushPreferences {
    public static final String TAG = "i";
    public Context b;

    public i(Context context) {
        super(context, "push_client_self_info");
        this.b = context;
    }

    public static i a(Context context) {
        i i10 = new i(context);
        return i10;
    }

    public String a(String string2) {
        Object object;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        String string3 = "";
        if (bl2) {
            return string3;
        }
        try {
            object = this.b;
        }
        catch (Exception exception) {
            object = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getSecureData");
            String string4 = exception.getMessage();
            stringBuilder.append(string4);
            string4 = stringBuilder.toString();
            HMSLog.e((String)object, string4);
            return string3;
        }
        string2 = this.getString(string2);
        return PushEncrypter.decrypter(object, string2);
    }

    public void a() {
        Object object;
        Object object2 = this.getAll();
        boolean bl2 = object2.isEmpty();
        if (!bl2 && !(bl2 = (object = object2.keySet()).isEmpty())) {
            object2 = object2.keySet().iterator();
            while (bl2 = object2.hasNext()) {
                String string2 = "push_kit_auto_init_enabled";
                object = (String)object2.next();
                boolean bl3 = string2.equals(object);
                if (bl3 || (bl3 = (string2 = "_proxy_init").equals(object))) continue;
                this.removeKey((String)object);
            }
        }
    }

    public boolean a(String string2, String string3) {
        Object object;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return false;
        }
        try {
            object = this.b;
        }
        catch (Exception exception) {
            string3 = TAG;
            object = new StringBuilder();
            ((StringBuilder)object).append("saveSecureData");
            String string4 = exception.getMessage();
            ((StringBuilder)object).append(string4);
            string4 = ((StringBuilder)object).toString();
            HMSLog.e(string3, string4);
            return false;
        }
        string3 = PushEncrypter.encrypter((Context)object, string3);
        return this.saveString(string2, string3);
    }

    public String b(String string2) {
        block4: {
            try {
                boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
                if (!bl2) break block4;
                string2 = "token_info_v2";
            }
            catch (Exception exception) {
                String string3 = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("getSecureData");
                String string4 = exception.getMessage();
                stringBuilder.append(string4);
                string4 = stringBuilder.toString();
                HMSLog.e(string3, string4);
                return "";
            }
            return this.a(string2);
        }
        return this.a(string2);
    }

    public boolean b(String string2, String string3) {
        block4: {
            try {
                boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
                if (!bl2) break block4;
                string2 = "token_info_v2";
            }
            catch (Exception exception) {
                string3 = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("saveSecureData");
                String string4 = exception.getMessage();
                stringBuilder.append(string4);
                string4 = stringBuilder.toString();
                HMSLog.e(string3, string4);
                return false;
            }
            return this.a(string2, string3);
        }
        return this.a(string2, string3);
    }

    public boolean c(String string2) {
        block4: {
            try {
                boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
                if (!bl2) break block4;
                string2 = "token_info_v2";
            }
            catch (Exception exception) {
                String string3 = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("removeToken");
                String string4 = exception.getMessage();
                stringBuilder.append(string4);
                string4 = stringBuilder.toString();
                HMSLog.e(string3, string4);
                return false;
            }
            return this.removeKey(string2);
        }
        return this.removeKey(string2);
    }
}

