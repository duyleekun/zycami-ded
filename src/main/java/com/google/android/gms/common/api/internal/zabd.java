/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl;

public interface zabd {
    public void begin();

    public void connect();

    public boolean disconnect();

    public BaseImplementation$ApiMethodImpl enqueue(BaseImplementation$ApiMethodImpl var1);

    public BaseImplementation$ApiMethodImpl execute(BaseImplementation$ApiMethodImpl var1);

    public void onConnected(Bundle var1);

    public void onConnectionSuspended(int var1);

    public void zaa(ConnectionResult var1, Api var2, boolean var3);
}

