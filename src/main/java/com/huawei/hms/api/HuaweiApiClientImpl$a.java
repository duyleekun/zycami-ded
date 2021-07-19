/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 */
package com.huawei.hms.api;

import android.content.Intent;
import com.huawei.hms.api.HuaweiApiClientImpl;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack;

public class HuaweiApiClientImpl$a
implements CheckUpdateCallBack {
    public final /* synthetic */ HuaweiApiClientImpl a;

    public HuaweiApiClientImpl$a(HuaweiApiClientImpl huaweiApiClientImpl) {
        this.a = huaweiApiClientImpl;
    }

    public void onMarketInstallInfo(Intent object) {
        if (object != null) {
            int n10 = -99;
            int n11 = object.getIntExtra("downloadStatus", n10);
            int n12 = object.getIntExtra("installState", n10);
            int n13 = object.getIntExtra("installType", n10);
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "onMarketInstallInfo installState: ";
            stringBuilder.append(string2);
            stringBuilder.append(n12);
            String string3 = ",installType: ";
            stringBuilder.append(string3);
            stringBuilder.append(n13);
            stringBuilder.append(",downloadCode: ");
            stringBuilder.append(n11);
            object = stringBuilder.toString();
            String string4 = "HuaweiApiClientImpl";
            HMSLog.i(string4, (String)object);
        }
    }

    public void onMarketStoreError(int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onMarketStoreError responseCode: ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        HMSLog.e("HuaweiApiClientImpl", string2);
    }

    public void onUpdateInfo(Intent object) {
        block17: {
            int n10;
            String string2;
            block18: {
                int n11;
                int n12;
                block16: {
                    Object object2;
                    string2 = "HuaweiApiClientImpl";
                    if (object == null || (object2 = HuaweiApiClientImpl.a(this.a)) == null) break block17;
                    n12 = -1;
                    CharSequence charSequence = "status";
                    int n13 = -99;
                    n11 = object.getIntExtra((String)charSequence, n13);
                    String string3 = "failcause";
                    n13 = object.getIntExtra(string3, n13);
                    string3 = "compulsoryUpdateCancel";
                    boolean bl2 = object.getBooleanExtra(string3, false);
                    StringBuilder stringBuilder = new StringBuilder();
                    String string4 = "onUpdateInfo status: ";
                    stringBuilder.append(string4);
                    stringBuilder.append(n11);
                    string4 = ",failcause: ";
                    stringBuilder.append(string4);
                    stringBuilder.append(n13);
                    String string5 = ",isExit: ";
                    stringBuilder.append(string5);
                    stringBuilder.append(bl2);
                    string5 = stringBuilder.toString();
                    try {
                        HMSLog.i(string2, string5);
                        n13 = 7;
                        if (n11 != n13) break block16;
                    }
                    catch (Exception exception) {
                        charSequence = new StringBuilder();
                        string5 = "intent has some error";
                        ((StringBuilder)charSequence).append(string5);
                        Object object3 = exception.getMessage();
                        ((StringBuilder)charSequence).append((String)object3);
                        object3 = ((StringBuilder)charSequence).toString();
                        HMSLog.e(string2, (String)object3);
                        object3 = HuaweiApiClientImpl.a(this.a);
                        object3.onResult(n12);
                    }
                    object2 = "updatesdk_update_info";
                    if ((object = (ApkUpgradeInfo)object.getSerializableExtra((String)object2)) != null) {
                        object2 = new StringBuilder();
                        charSequence = "onUpdateInfo: ";
                        ((StringBuilder)object2).append((String)charSequence);
                        object = ((ApkUpgradeInfo)object).toString();
                        ((StringBuilder)object2).append((String)object);
                        object = ((StringBuilder)object2).toString();
                        HMSLog.i(string2, (String)object);
                    }
                    object = HuaweiApiClientImpl.a(this.a);
                    n10 = 1;
                    object.onResult(n10);
                    break block18;
                }
                int n14 = 3;
                if (n11 == n14) {
                    object = HuaweiApiClientImpl.a(this.a);
                    object.onResult(0);
                } else {
                    object = HuaweiApiClientImpl.a(this.a);
                    object.onResult(n12);
                }
            }
            object = this.a;
            n10 = 0;
            string2 = null;
            HuaweiApiClientImpl.a((HuaweiApiClientImpl)object, null);
        }
    }

    public void onUpdateStoreError(int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onUpdateStoreError responseCode: ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        HMSLog.e("HuaweiApiClientImpl", string2);
    }
}

