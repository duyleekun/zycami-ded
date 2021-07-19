/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.support.api.opendevice;

import com.huawei.hms.api.Api;
import com.huawei.hms.support.api.opendevice.HuaweiOpendeviceApi;
import com.huawei.hms.support.api.opendevice.HuaweiOpendeviceApiImpl;

public class HuaweiOpendevice {
    public static final HuaweiOpendeviceApi HuaweiOpendeviceApi;
    public static final Api OPEN_DEVICE_API;

    static {
        Object object = new Api("HuaweiOpenDevice.API");
        OPEN_DEVICE_API = object;
        HuaweiOpendeviceApi = object = new HuaweiOpendeviceApiImpl();
    }
}

