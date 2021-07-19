/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 */
package com.huawei.hms.availableupdate;

import android.content.Intent;
import com.huawei.hms.availableupdate.f;
import com.huawei.hms.availableupdate.f0;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack;

public class f0$b
implements CheckUpdateCallBack {
    public final /* synthetic */ f a;
    public final /* synthetic */ f0 b;

    public f0$b(f0 f02, f f10) {
        this.b = f02;
        this.a = f10;
    }

    public void onMarketInstallInfo(Intent intent) {
    }

    public void onMarketStoreError(int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onMarketStoreError responseCode: ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        HMSLog.e("UpdateWizard", string2);
    }

    public void onUpdateInfo(Intent intent) {
        if (intent != null) {
            f0 f02 = this.b;
            f f10 = this.a;
            f0.a(f02, intent, f10);
        }
    }

    public void onUpdateStoreError(int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onUpdateStoreError responseCode: ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        HMSLog.e("UpdateWizard", string2);
    }
}

