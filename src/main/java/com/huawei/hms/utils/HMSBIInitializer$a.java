/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  com.huawei.hianalytics.process.HiAnalyticsConfig
 *  com.huawei.hianalytics.process.HiAnalyticsConfig$Builder
 *  com.huawei.hianalytics.process.HiAnalyticsInstance$Builder
 */
package com.huawei.hms.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.process.HiAnalyticsConfig;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hms.framework.network.grs.IQueryUrlCallBack;
import com.huawei.hms.hatool.HmsHiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSBIInitializer;

public class HMSBIInitializer$a
implements IQueryUrlCallBack {
    public final /* synthetic */ HMSBIInitializer a;

    public HMSBIInitializer$a(HMSBIInitializer hMSBIInitializer) {
        this.a = hMSBIInitializer;
    }

    public void onCallBackFail(int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("get grs failed, the errorcode is ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        HMSLog.e("HMSBIInitializer", string2);
        HMSBIInitializer.c(this.a).set(false);
    }

    public void onCallBackSuccess(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            Object object = this.a;
            bl2 = HMSBIInitializer.a((HMSBIInitializer)object);
            if (!bl2) {
                object = this.a;
                Context context = HMSBIInitializer.b((HMSBIInitializer)object);
                Object var5_6 = null;
                String string3 = "com.huawei.hwid";
                HmsHiAnalyticsUtils.init(context, false, false, false, string2, string3);
            } else {
                object = new HiAnalyticsConfig.Builder();
                object = object.setEnableImei(false).setEnableUDID(false).setEnableSN(false).setCollectURL(string2).build();
                HiAnalyticsConfig.Builder builder = new HiAnalyticsConfig.Builder();
                string2 = builder.setEnableImei(false).setEnableUDID(false).setEnableSN(false).setCollectURL(string2).build();
                Context context = HMSBIInitializer.b(this.a);
                builder = new HiAnalyticsInstance.Builder(context);
                HMSBIInitializer.a(builder.setOperConf((HiAnalyticsConfig)object).setMaintConf((HiAnalyticsConfig)string2).create("hms_config_tag"));
                string2 = HMSBIInitializer.a();
                object = "com.huawei.hwid";
                string2.setAppid((String)object);
            }
            string2 = "HMSBIInitializer";
            object = "BI URL acquired successfully";
            HMSLog.i(string2, (String)object);
        }
        HMSBIInitializer.c(this.a).set(false);
    }
}

