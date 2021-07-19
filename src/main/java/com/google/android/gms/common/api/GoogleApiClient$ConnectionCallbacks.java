/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.common.api;

import android.os.Bundle;

public interface GoogleApiClient$ConnectionCallbacks {
    public static final int CAUSE_NETWORK_LOST = 2;
    public static final int CAUSE_SERVICE_DISCONNECTED = 1;

    public void onConnected(Bundle var1);

    public void onConnectionSuspended(int var1);
}

