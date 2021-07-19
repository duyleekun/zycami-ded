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
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl;
import com.google.android.gms.common.api.internal.zaaw;
import com.google.android.gms.common.api.internal.zabd;
import com.google.android.gms.common.api.internal.zabe;
import java.util.Collections;

public final class zaav
implements zabd {
    private final zabe zaft;

    public zaav(zabe zabe2) {
        this.zaft = zabe2;
    }

    public final void begin() {
        Object object;
        boolean bl2;
        Object object2 = this.zaft.zagz.values().iterator();
        while (bl2 = object2.hasNext()) {
            object = (Api$Client)object2.next();
            object.disconnect();
        }
        object2 = this.zaft.zaee;
        ((zaaw)object2).zaha = object = Collections.emptySet();
    }

    public final void connect() {
        this.zaft.zaaz();
    }

    public final boolean disconnect() {
        return true;
    }

    public final BaseImplementation$ApiMethodImpl enqueue(BaseImplementation$ApiMethodImpl baseImplementation$ApiMethodImpl) {
        this.zaft.zaee.zafc.add(baseImplementation$ApiMethodImpl);
        return baseImplementation$ApiMethodImpl;
    }

    public final BaseImplementation$ApiMethodImpl execute(BaseImplementation$ApiMethodImpl object) {
        object = new IllegalStateException("GoogleApiClient is not connected yet.");
        throw object;
    }

    public final void onConnected(Bundle bundle) {
    }

    public final void onConnectionSuspended(int n10) {
    }

    public final void zaa(ConnectionResult connectionResult, Api api, boolean bl2) {
    }
}

