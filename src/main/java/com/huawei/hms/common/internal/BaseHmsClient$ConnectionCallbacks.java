/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.common.internal;

public interface BaseHmsClient$ConnectionCallbacks {
    public static final int CAUSE_API_CLIENT_EXPIRED = 3;
    public static final int CAUSE_NETWORK_LOST = 2;
    public static final int CAUSE_SERVICE_DISCONNECTED = 1;

    public void onConnected();

    public void onConnectionSuspended(int var1);
}

