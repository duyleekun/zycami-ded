/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 */
package com.huawei.hms.opendevice;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api$ApiOptions;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.opendevice.OpenDeviceClient;
import com.huawei.hms.opendevice.OpenDeviceHmsClientBuilder;
import com.huawei.hms.opendevice.OpenDeviceOptions;
import com.huawei.hms.opendevice.OpenDeviceTaskApiCall;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.utils.JsonUtil;
import d.j.d.a.k;

public class OpenDeviceClientImpl
extends HuaweiApi
implements OpenDeviceClient {
    public static final OpenDeviceHmsClientBuilder a;
    public static final Api b;
    public static OpenDeviceOptions c;

    static {
        Object object = new OpenDeviceHmsClientBuilder();
        a = object;
        b = object = new Api("HuaweiOpenDevice.API");
        c = object = new OpenDeviceOptions();
    }

    public OpenDeviceClientImpl(Activity activity) {
        Api api = b;
        OpenDeviceOptions openDeviceOptions = c;
        OpenDeviceHmsClientBuilder openDeviceHmsClientBuilder = a;
        super(activity, api, (Api$ApiOptions)openDeviceOptions, (AbstractClientBuilder)openDeviceHmsClientBuilder);
        super.setKitSdkVersion(50101300);
    }

    public OpenDeviceClientImpl(Context context) {
        Api api = b;
        OpenDeviceOptions openDeviceOptions = c;
        OpenDeviceHmsClientBuilder openDeviceHmsClientBuilder = a;
        super(context, api, (Api$ApiOptions)openDeviceOptions, (AbstractClientBuilder)openDeviceHmsClientBuilder);
        super.setKitSdkVersion(50101300);
    }

    public k getOdid() {
        Object object = this.getContext();
        String string2 = "opendevice.getodid";
        object = HiAnalyticsClient.reportEntry(object, string2, 50101300);
        String string3 = JsonUtil.createJsonString(null);
        OpenDeviceTaskApiCall openDeviceTaskApiCall = new OpenDeviceTaskApiCall(string2, string3, (String)object);
        return this.doWrite(openDeviceTaskApiCall);
    }
}

