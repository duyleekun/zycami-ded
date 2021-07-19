/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.hms.aaid.task;

import android.content.Context;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.BaseHmsClient$ConnectionCallbacks;
import com.huawei.hms.common.internal.BaseHmsClient$OnConnectionFailedListener;
import com.huawei.hms.common.internal.ClientSettings;
import java.util.Arrays;
import java.util.List;

public class PushClientBuilder
extends AbstractClientBuilder {
    public PushClient buildClient(Context context, ClientSettings clientSettings, BaseHmsClient$OnConnectionFailedListener baseHmsClient$OnConnectionFailedListener, BaseHmsClient$ConnectionCallbacks baseHmsClient$ConnectionCallbacks) {
        Object object = Arrays.asList("HuaweiPush.API", "Core.API");
        clientSettings.setApiName((List)object);
        object = new PushClient(context, clientSettings, baseHmsClient$OnConnectionFailedListener, baseHmsClient$ConnectionCallbacks);
        return object;
    }
}

