/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package com.huawei.hms.opendevice;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.opendevice.h;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;

public class f
implements Runnable {
    public Context a;

    public f(Context context) {
        this.a = context;
    }

    /*
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Object object;
        Object object2;
        String string2 = "push kit sdk not exists";
        String string3 = "Push init failed";
        String string4 = "AutoInit";
        Object object3 = ErrorEnum.SUCCESS;
        int n10 = ((ErrorEnum)((Object)object3)).getInternalCode();
        String string5 = null;
        try {
            object2 = this.a;
            object2 = HmsInstanceId.getInstance((Context)object2);
            object = this.a;
            object = Util.getAppId(object);
            string5 = ((HmsInstanceId)object2).getToken((String)object, null);
            object2 = "Push init succeed";
            HMSLog.i(string4, (String)object2);
            boolean bl2 = TextUtils.isEmpty((CharSequence)string5);
            if (bl2) {
                return;
            }
        }
        catch (ApiException apiException) {
            n10 = apiException.getStatusCode();
            HMSLog.e(string4, string3);
        }
        try {
            object2 = this.a;
            object2 = object2.getPackageManager();
            object = this.a;
            object = object.getPackageName();
            int n11 = 128;
            object2 = object2.getApplicationInfo((String)object, n11);
            object2 = ((ApplicationInfo)object2).metaData;
            if (object2 != null && (object2 = object2.getString((String)(object = "com.huawei.hms.client.service.name:push"))) != null) {
                object = "com.huawei.push.action.MESSAGING_EVENT";
                object2 = new Intent((String)object);
                object = this.a;
                object = object.getPackageName();
                object2.setPackage((String)object);
                object = new Bundle();
                String string6 = "message_type";
                String string7 = "new_token";
                object.putString(string6, string7);
                string6 = "device_token";
                object.putString(string6, string5);
                string5 = "error";
                object.putInt(string5, n10);
                object3 = new h();
                string5 = this.a;
                n10 = (int)(((h)object3).a((Context)string5, (Bundle)object, (Intent)object2) ? 1 : 0);
                if (n10 == 0) {
                    object3 = "start service failed";
                    HMSLog.e(string4, (String)object3);
                }
            } else {
                HMSLog.i(string4, string2);
            }
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            try {
                HMSLog.i(string4, string2);
            }
            catch (Exception exception) {
                HMSLog.e(string4, string3, exception);
            }
        }
    }
}

