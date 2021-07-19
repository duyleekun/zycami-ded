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
import com.huawei.hms.opendevice.OpenDeviceClient;
import com.huawei.hms.opendevice.OpenDeviceClientImpl;
import com.huawei.hms.utils.Checker;

public class OpenDevice {
    public static OpenDeviceClient getOpenDeviceClient(Activity activity) {
        Checker.assertNonNull(activity);
        OpenDeviceClientImpl openDeviceClientImpl = new OpenDeviceClientImpl(activity);
        return openDeviceClientImpl;
    }

    public static OpenDeviceClient getOpenDeviceClient(Context context) {
        Checker.assertNonNull(context);
        OpenDeviceClientImpl openDeviceClientImpl = new OpenDeviceClientImpl(context);
        return openDeviceClientImpl;
    }
}

