/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.hms.push.ups;

import android.content.Context;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.HmsMessaging;
import com.huawei.hms.push.s;
import com.huawei.hms.push.ups.UPSService$1;
import com.huawei.hms.push.ups.UPSService$2;
import com.huawei.hms.push.ups.entity.TokenResult;
import com.huawei.hms.push.ups.entity.UPSRegisterCallBack;
import com.huawei.hms.push.ups.entity.UPSTurnCallBack;
import com.huawei.hms.push.ups.entity.UPSUnRegisterCallBack;
import com.huawei.hms.support.log.HMSLog;
import d.j.d.a.g;
import d.j.d.a.k;

public final class UPSService {
    public static void registerToken(Context object, String object2, String string2, String string3, UPSRegisterCallBack uPSRegisterCallBack) {
        string2 = "UPSService";
        string3 = "invoke registerToken";
        HMSLog.i(string2, string3);
        Preconditions.checkNotNull(uPSRegisterCallBack);
        int n10 = s.b();
        if (n10 == 0) {
            int n11 = ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.getExternalCode();
            object = new TokenResult(n11);
            uPSRegisterCallBack.onResult(object);
            return;
        }
        object = HmsInstanceId.getInstance((Context)object);
        n10 = 0;
        string2 = null;
        object = ((HmsInstanceId)object).getToken((String)object2, null);
        object2 = new TokenResult((String)object);
        try {
            uPSRegisterCallBack.onResult(object2);
        }
        catch (ApiException apiException) {
            n10 = apiException.getStatusCode();
            String string4 = apiException.getMessage();
            object2 = new TokenResult(n10, string4);
            uPSRegisterCallBack.onResult(object2);
        }
    }

    public static void turnOffPush(Context object, UPSTurnCallBack uPSTurnCallBack) {
        Object object2 = "UPSService";
        String string2 = "invoke turnOffPush";
        HMSLog.i((String)object2, string2);
        Preconditions.checkNotNull(uPSTurnCallBack);
        int n10 = s.b();
        if (n10 == 0) {
            n10 = ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.getExternalCode();
            object = new TokenResult(n10);
            uPSTurnCallBack.onResult(object);
            return;
        }
        object = HmsMessaging.getInstance((Context)object).turnOffPush();
        object2 = new UPSService$2(uPSTurnCallBack);
        ((k)object).e((g)object2);
    }

    public static void turnOnPush(Context object, UPSTurnCallBack uPSTurnCallBack) {
        Object object2 = "UPSService";
        String string2 = "invoke turnOnPush";
        HMSLog.i((String)object2, string2);
        Preconditions.checkNotNull(uPSTurnCallBack);
        int n10 = s.b();
        if (n10 == 0) {
            n10 = ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.getExternalCode();
            object = new TokenResult(n10);
            uPSTurnCallBack.onResult(object);
            return;
        }
        object = HmsMessaging.getInstance((Context)object).turnOnPush();
        object2 = new UPSService$1(uPSTurnCallBack);
        ((k)object).e((g)object2);
    }

    public static void unRegisterToken(Context object, UPSUnRegisterCallBack uPSUnRegisterCallBack) {
        Object object2 = "UPSService";
        String string2 = "invoke unRegisterToken";
        HMSLog.i((String)object2, string2);
        Preconditions.checkNotNull(uPSUnRegisterCallBack);
        int n10 = s.b();
        if (n10 == 0) {
            n10 = ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.getExternalCode();
            object = new TokenResult(n10);
            uPSUnRegisterCallBack.onResult(object);
            return;
        }
        object = HmsInstanceId.getInstance((Context)object);
        n10 = 0;
        object2 = null;
        ((HmsInstanceId)object).deleteToken(null, null);
        object = new TokenResult();
        try {
            uPSUnRegisterCallBack.onResult(object);
        }
        catch (ApiException apiException) {
            int n11 = apiException.getStatusCode();
            String string3 = apiException.getMessage();
            object2 = new TokenResult(n11, string3);
            uPSUnRegisterCallBack.onResult(object2);
        }
    }
}

