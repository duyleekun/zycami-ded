/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.hms.aaid.task;

import android.content.Context;
import com.huawei.hms.common.internal.BaseHmsClient$ConnectionCallbacks;
import com.huawei.hms.common.internal.BaseHmsClient$OnConnectionFailedListener;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.common.internal.HmsClient;

public class PushClient
extends HmsClient {
    public PushClient(Context context, ClientSettings clientSettings, BaseHmsClient$OnConnectionFailedListener baseHmsClient$OnConnectionFailedListener, BaseHmsClient$ConnectionCallbacks baseHmsClient$ConnectionCallbacks) {
        super(context, clientSettings, baseHmsClient$OnConnectionFailedListener, baseHmsClient$ConnectionCallbacks);
    }
}

