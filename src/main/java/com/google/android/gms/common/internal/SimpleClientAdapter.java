/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Looper
 */
package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api$SimpleClient;
import com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;

public class SimpleClientAdapter
extends GmsClient {
    private final Api$SimpleClient zapg;

    public SimpleClientAdapter(Context context, Looper looper, int n10, GoogleApiClient$ConnectionCallbacks googleApiClient$ConnectionCallbacks, GoogleApiClient$OnConnectionFailedListener googleApiClient$OnConnectionFailedListener, ClientSettings clientSettings, Api$SimpleClient api$SimpleClient) {
        super(context, looper, n10, clientSettings, googleApiClient$ConnectionCallbacks, googleApiClient$OnConnectionFailedListener);
        this.zapg = api$SimpleClient;
    }

    public IInterface createServiceInterface(IBinder iBinder) {
        return this.zapg.createServiceInterface(iBinder);
    }

    public Api$SimpleClient getClient() {
        return this.zapg;
    }

    public int getMinApkVersion() {
        return super.getMinApkVersion();
    }

    public String getServiceDescriptor() {
        return this.zapg.getServiceDescriptor();
    }

    public String getStartServiceAction() {
        return this.zapg.getStartServiceAction();
    }

    public void onSetConnectState(int n10, IInterface iInterface) {
        this.zapg.setState(n10, iInterface);
    }
}

