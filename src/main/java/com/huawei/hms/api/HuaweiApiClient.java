/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 */
package com.huawei.hms.api;

import android.app.Activity;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.CheckUpdatelistener;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.HuaweiApiClient$ConnectionCallbacks;
import com.huawei.hms.api.HuaweiApiClient$OnConnectionFailedListener;
import com.huawei.hms.support.api.client.AidlApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.SubAppInfo;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class HuaweiApiClient
implements AidlApiClient {
    public abstract void checkUpdate(Activity var1, CheckUpdatelistener var2);

    public void connect(int n10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public abstract void connect(Activity var1);

    public abstract void connectForeground();

    public abstract void disableLifeCycleManagement(Activity var1);

    public abstract PendingResult discardAndReconnect();

    public abstract void disconnect();

    public abstract Map getApiMap();

    public abstract ConnectionResult getConnectionResult(Api var1);

    public abstract List getPermissionInfos();

    public abstract List getScopes();

    public abstract Activity getTopActivity();

    public abstract boolean hasConnectedApi(Api var1);

    public abstract boolean hasConnectionFailureListener(HuaweiApiClient$OnConnectionFailedListener var1);

    public abstract boolean hasConnectionSuccessListener(HuaweiApiClient$ConnectionCallbacks var1);

    public abstract ConnectionResult holdUpConnect();

    public abstract ConnectionResult holdUpConnect(long var1, TimeUnit var3);

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract void onPause(Activity var1);

    public abstract void onResume(Activity var1);

    public abstract void print(String var1, FileDescriptor var2, PrintWriter var3, String[] var4);

    public abstract void reconnect();

    public abstract void removeConnectionFailureListener(HuaweiApiClient$OnConnectionFailedListener var1);

    public abstract void removeConnectionSuccessListener(HuaweiApiClient$ConnectionCallbacks var1);

    public abstract void setConnectionCallbacks(HuaweiApiClient$ConnectionCallbacks var1);

    public abstract void setConnectionFailedListener(HuaweiApiClient$OnConnectionFailedListener var1);

    public abstract boolean setSubAppInfo(SubAppInfo var1);
}

