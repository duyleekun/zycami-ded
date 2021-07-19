/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.common.internal;

import android.os.Bundle;

public interface BaseGmsClient$BaseConnectionCallbacks {
    public static final int CAUSE_DEAD_OBJECT_EXCEPTION = 3;
    public static final int CAUSE_SERVICE_DISCONNECTED = 1;

    public void onConnected(Bundle var1);

    public void onConnectionSuspended(int var1);
}

