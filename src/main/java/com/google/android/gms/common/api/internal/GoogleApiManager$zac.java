/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.util.Log
 */
package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.GoogleApiManager$zaa;
import com.google.android.gms.common.api.internal.zabo;
import com.google.android.gms.common.api.internal.zach;
import com.google.android.gms.common.api.internal.zai;
import com.google.android.gms.common.internal.BaseGmsClient$ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.util.Map;
import java.util.Set;

public final class GoogleApiManager$zac
implements zach,
BaseGmsClient$ConnectionProgressReportCallbacks {
    private final zai zafq;
    public final /* synthetic */ GoogleApiManager zaim;
    private final Api$Client zaio;
    private IAccountAccessor zajd = null;
    private Set zaje = null;
    private boolean zajf = false;

    public GoogleApiManager$zac(GoogleApiManager googleApiManager, Api$Client api$Client, zai zai2) {
        this.zaim = googleApiManager;
        this.zaio = api$Client;
        this.zafq = zai2;
    }

    public static /* synthetic */ Api$Client zaa(GoogleApiManager$zac googleApiManager$zac) {
        return googleApiManager$zac.zaio;
    }

    public static /* synthetic */ boolean zaa(GoogleApiManager$zac googleApiManager$zac, boolean bl2) {
        googleApiManager$zac.zajf = bl2 = true;
        return bl2;
    }

    public static /* synthetic */ void zab(GoogleApiManager$zac googleApiManager$zac) {
        googleApiManager$zac.zabr();
    }

    private final void zabr() {
        IAccountAccessor iAccountAccessor;
        boolean bl2 = this.zajf;
        if (bl2 && (iAccountAccessor = this.zajd) != null) {
            Api$Client api$Client = this.zaio;
            Set set = this.zaje;
            api$Client.getRemoteService(iAccountAccessor, set);
        }
    }

    public static /* synthetic */ zai zac(GoogleApiManager$zac googleApiManager$zac) {
        return googleApiManager$zac.zafq;
    }

    public final void onReportServiceBinding(ConnectionResult connectionResult) {
        Handler handler = GoogleApiManager.zaa(this.zaim);
        zabo zabo2 = new zabo(this, connectionResult);
        handler.post((Runnable)zabo2);
    }

    public final void zaa(IAccountAccessor object, Set set) {
        if (object != null && set != null) {
            this.zajd = object;
            this.zaje = set;
            this.zabr();
            return;
        }
        object = new Exception();
        Log.wtf((String)"GoogleApiManager", (String)"Received null response from onSignInSuccess", (Throwable)object);
        object = new ConnectionResult(4);
        this.zag((ConnectionResult)object);
    }

    public final void zag(ConnectionResult connectionResult) {
        Map map = GoogleApiManager.zaj(this.zaim);
        zai zai2 = this.zafq;
        ((GoogleApiManager$zaa)map.get(zai2)).zag(connectionResult);
    }
}

