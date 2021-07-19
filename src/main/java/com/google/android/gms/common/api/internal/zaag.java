/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class zaag
extends GoogleApiClient {
    private final String zafs;

    public zaag(String string2) {
        this.zafs = string2;
    }

    public ConnectionResult blockingConnect() {
        String string2 = this.zafs;
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(string2);
        throw unsupportedOperationException;
    }

    public ConnectionResult blockingConnect(long l10, TimeUnit timeUnit) {
        String string2 = this.zafs;
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(string2);
        throw unsupportedOperationException;
    }

    public PendingResult clearDefaultAccountAndReconnect() {
        String string2 = this.zafs;
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(string2);
        throw unsupportedOperationException;
    }

    public void connect() {
        String string2 = this.zafs;
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(string2);
        throw unsupportedOperationException;
    }

    public void disconnect() {
        String string2 = this.zafs;
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(string2);
        throw unsupportedOperationException;
    }

    public void dump(String object, FileDescriptor object2, PrintWriter printWriter, String[] stringArray) {
        object2 = this.zafs;
        object = new UnsupportedOperationException((String)object2);
        throw object;
    }

    public ConnectionResult getConnectionResult(Api object) {
        String string2 = this.zafs;
        object = new UnsupportedOperationException(string2);
        throw object;
    }

    public boolean hasConnectedApi(Api object) {
        String string2 = this.zafs;
        object = new UnsupportedOperationException(string2);
        throw object;
    }

    public boolean isConnected() {
        String string2 = this.zafs;
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(string2);
        throw unsupportedOperationException;
    }

    public boolean isConnecting() {
        String string2 = this.zafs;
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(string2);
        throw unsupportedOperationException;
    }

    public boolean isConnectionCallbacksRegistered(GoogleApiClient$ConnectionCallbacks object) {
        String string2 = this.zafs;
        object = new UnsupportedOperationException(string2);
        throw object;
    }

    public boolean isConnectionFailedListenerRegistered(GoogleApiClient$OnConnectionFailedListener object) {
        String string2 = this.zafs;
        object = new UnsupportedOperationException(string2);
        throw object;
    }

    public void reconnect() {
        String string2 = this.zafs;
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(string2);
        throw unsupportedOperationException;
    }

    public void registerConnectionCallbacks(GoogleApiClient$ConnectionCallbacks object) {
        String string2 = this.zafs;
        object = new UnsupportedOperationException(string2);
        throw object;
    }

    public void registerConnectionFailedListener(GoogleApiClient$OnConnectionFailedListener object) {
        String string2 = this.zafs;
        object = new UnsupportedOperationException(string2);
        throw object;
    }

    public void stopAutoManage(FragmentActivity object) {
        String string2 = this.zafs;
        object = new UnsupportedOperationException(string2);
        throw object;
    }

    public void unregisterConnectionCallbacks(GoogleApiClient$ConnectionCallbacks object) {
        String string2 = this.zafs;
        object = new UnsupportedOperationException(string2);
        throw object;
    }

    public void unregisterConnectionFailedListener(GoogleApiClient$OnConnectionFailedListener object) {
        String string2 = this.zafs;
        object = new UnsupportedOperationException(string2);
        throw object;
    }
}

