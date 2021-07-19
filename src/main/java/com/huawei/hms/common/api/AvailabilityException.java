/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.hms.common.api;

import android.content.Context;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.api.HuaweiApiCallable;
import com.huawei.hms.support.log.HMSLog;

public class AvailabilityException
extends Exception {
    private String TAG = "AvailabilityException";
    private String message = null;

    private ConnectionResult generateConnectionResult(int n10) {
        Object object = this.TAG;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("The availability check result is: ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        HMSLog.i((String)object, (String)charSequence);
        this.setMessage(n10);
        object = new ConnectionResult(n10);
        return object;
    }

    private void setMessage(int n10) {
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        int n11 = 21;
        this.message = n10 != n11 ? (n10 != 0 ? (n10 != (n11 = 1) ? (n10 != (n11 = 2) ? (n10 != (n11 = 3) ? (string7 = "INTERNAL_ERROR") : (string6 = "SERVICE_DISABLED")) : (string5 = "SERVICE_VERSION_UPDATE_REQUIRED")) : (string4 = "SERVICE_MISSING")) : (string3 = "success")) : (string2 = "ANDROID_VERSION_UNSUPPORT");
    }

    public ConnectionResult getConnectionResult(HuaweiApi huaweiApi) {
        if (huaweiApi == null) {
            HMSLog.e(this.TAG, "The huaweiApi is null.");
            return this.generateConnectionResult(8);
        }
        huaweiApi = huaweiApi.getContext();
        int n10 = HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable((Context)huaweiApi, 30000000);
        return this.generateConnectionResult(n10);
    }

    public ConnectionResult getConnectionResult(HuaweiApiCallable huaweiApiCallable) {
        HuaweiApi huaweiApi;
        if (huaweiApiCallable != null && (huaweiApi = huaweiApiCallable.getHuaweiApi()) != null) {
            huaweiApiCallable = huaweiApiCallable.getHuaweiApi().getContext();
            int n10 = HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable((Context)huaweiApiCallable, 30000000);
            return this.generateConnectionResult(n10);
        }
        HMSLog.e(this.TAG, "The huaweiApi is null.");
        return this.generateConnectionResult(8);
    }

    public String getMessage() {
        return this.message;
    }
}

