/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.hms.support.api.client;

import android.content.Context;
import com.huawei.hms.support.api.client.SubAppInfo;

public interface ApiClient {
    public String getAppID();

    public Context getContext();

    public String getCpID();

    public String getPackageName();

    public String getSessionId();

    public SubAppInfo getSubAppInfo();

    public String getTransportName();

    public boolean isConnected();
}

