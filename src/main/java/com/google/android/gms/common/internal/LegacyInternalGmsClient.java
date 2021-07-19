/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.IInterface
 *  android.os.Looper
 */
package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.GmsClientEventManager;

public abstract class LegacyInternalGmsClient
extends GmsClient {
    private final GmsClientEventManager zags;

    public LegacyInternalGmsClient(Context context, int n10, ClientSettings clientSettings, GoogleApiClient$ConnectionCallbacks googleApiClient$ConnectionCallbacks, GoogleApiClient$OnConnectionFailedListener googleApiClient$OnConnectionFailedListener) {
        GmsClientEventManager gmsClientEventManager;
        Looper looper = context.getMainLooper();
        super(context, looper, n10, clientSettings);
        context = context.getMainLooper();
        this.zags = gmsClientEventManager = new GmsClientEventManager((Looper)context, this);
        gmsClientEventManager.registerConnectionCallbacks(googleApiClient$ConnectionCallbacks);
        gmsClientEventManager.registerConnectionFailedListener(googleApiClient$OnConnectionFailedListener);
    }

    public void checkAvailabilityAndConnect() {
        this.zags.enableCallbacks();
        super.checkAvailabilityAndConnect();
    }

    public void disconnect() {
        this.zags.disableCallbacks();
        super.disconnect();
    }

    public int getMinApkVersion() {
        return super.getMinApkVersion();
    }

    public boolean isConnectionCallbacksRegistered(GoogleApiClient$ConnectionCallbacks googleApiClient$ConnectionCallbacks) {
        return this.zags.isConnectionCallbacksRegistered(googleApiClient$ConnectionCallbacks);
    }

    public boolean isConnectionFailedListenerRegistered(GoogleApiClient$OnConnectionFailedListener googleApiClient$OnConnectionFailedListener) {
        return this.zags.isConnectionFailedListenerRegistered(googleApiClient$OnConnectionFailedListener);
    }

    public void onConnectedLocked(IInterface object) {
        super.onConnectedLocked((IInterface)object);
        object = this.zags;
        Bundle bundle = this.getConnectionHint();
        ((GmsClientEventManager)object).onConnectionSuccess(bundle);
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        super.onConnectionFailed(connectionResult);
        this.zags.onConnectionFailure(connectionResult);
    }

    public void onConnectionSuspended(int n10) {
        super.onConnectionSuspended(n10);
        this.zags.onUnintentionalDisconnection(n10);
    }

    public void registerConnectionCallbacks(GoogleApiClient$ConnectionCallbacks googleApiClient$ConnectionCallbacks) {
        this.zags.registerConnectionCallbacks(googleApiClient$ConnectionCallbacks);
    }

    public void registerConnectionFailedListener(GoogleApiClient$OnConnectionFailedListener googleApiClient$OnConnectionFailedListener) {
        this.zags.registerConnectionFailedListener(googleApiClient$OnConnectionFailedListener);
    }

    public void unregisterConnectionCallbacks(GoogleApiClient$ConnectionCallbacks googleApiClient$ConnectionCallbacks) {
        this.zags.unregisterConnectionCallbacks(googleApiClient$ConnectionCallbacks);
    }

    public void unregisterConnectionFailedListener(GoogleApiClient$OnConnectionFailedListener googleApiClient$OnConnectionFailedListener) {
        this.zags.unregisterConnectionFailedListener(googleApiClient$OnConnectionFailedListener);
    }
}

