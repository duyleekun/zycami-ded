/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.BaseHmsClient$ConnectionCallbacks;
import com.huawei.hms.common.internal.BaseHmsClient$OnConnectionFailedListener;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.opendevice.OpenDeviceHmsClient;

public class OpenDeviceHmsClientBuilder
extends AbstractClientBuilder {
    public OpenDeviceHmsClient buildClient(Context context, ClientSettings clientSettings, BaseHmsClient$OnConnectionFailedListener baseHmsClient$OnConnectionFailedListener, BaseHmsClient$ConnectionCallbacks baseHmsClient$ConnectionCallbacks) {
        OpenDeviceHmsClient openDeviceHmsClient = new OpenDeviceHmsClient(context, clientSettings, baseHmsClient$OnConnectionFailedListener, baseHmsClient$ConnectionCallbacks);
        return openDeviceHmsClient;
    }
}

