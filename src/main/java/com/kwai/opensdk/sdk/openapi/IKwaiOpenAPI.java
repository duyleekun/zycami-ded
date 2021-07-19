/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 */
package com.kwai.opensdk.sdk.openapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.kwai.opensdk.sdk.model.base.BaseReq;
import com.kwai.opensdk.sdk.model.base.OpenSdkConfig;
import com.kwai.opensdk.sdk.openapi.IKwaiAPIEventListener;

public interface IKwaiOpenAPI {
    public void addKwaiAPIEventListerer(IKwaiAPIEventListener var1);

    public String getOpenAPISessionId();

    public void handleIntent(Intent var1);

    public boolean isAppSupportUri(Context var1, BaseReq var2);

    public void removeKwaiAPIEventListerer();

    public boolean sendReq(BaseReq var1, Activity var2);

    public void setOpenSdkConfig(OpenSdkConfig var1);

    public void updateKwaiAppId(String var1);
}

