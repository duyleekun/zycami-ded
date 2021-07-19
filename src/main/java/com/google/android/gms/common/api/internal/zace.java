/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.Log
 */
package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api$AbstractClientBuilder;
import com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener;
import com.google.android.gms.common.api.internal.zacf;
import com.google.android.gms.common.api.internal.zacg;
import com.google.android.gms.common.api.internal.zach;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.zac;
import com.google.android.gms.signin.internal.zaj;
import com.google.android.gms.signin.zaa;
import com.google.android.gms.signin.zad;
import java.util.Set;

public final class zace
extends zac
implements GoogleApiClient$ConnectionCallbacks,
GoogleApiClient$OnConnectionFailedListener {
    private static Api$AbstractClientBuilder zaki = zaa.zaph;
    private final Context mContext;
    private final Handler mHandler;
    private Set mScopes;
    private final Api$AbstractClientBuilder zaau;
    private ClientSettings zaet;
    private zad zagb;
    private zach zakj;

    public zace(Context context, Handler handler, ClientSettings clientSettings) {
        Api$AbstractClientBuilder api$AbstractClientBuilder = zaki;
        this(context, handler, clientSettings, api$AbstractClientBuilder);
    }

    public zace(Context object, Handler handler, ClientSettings clientSettings, Api$AbstractClientBuilder api$AbstractClientBuilder) {
        this.mContext = object;
        this.mHandler = handler;
        object = (ClientSettings)Preconditions.checkNotNull(clientSettings, "ClientSettings must not be null");
        this.zaet = object;
        object = clientSettings.getRequiredScopes();
        this.mScopes = object;
        this.zaau = api$AbstractClientBuilder;
    }

    public static /* synthetic */ zach zaa(zace zace2) {
        return zace2.zakj;
    }

    public static /* synthetic */ void zaa(zace zace2, zaj zaj2) {
        zace2.zac(zaj2);
    }

    private final void zac(zaj object) {
        Object object2 = ((zaj)object).getConnectionResult();
        boolean n10 = ((ConnectionResult)object2).isSuccess();
        if (n10) {
            object2 = ((ResolveAccountResponse)(object = ((zaj)object).zacx())).getConnectionResult();
            boolean bl2 = ((ConnectionResult)object2).isSuccess();
            if (!bl2) {
                object = String.valueOf(object2);
                int n11 = String.valueOf(object).length() + 48;
                StringBuilder stringBuilder = new StringBuilder(n11);
                stringBuilder.append("Sign-in succeeded with resolve account failure: ");
                stringBuilder.append((String)object);
                object = stringBuilder.toString();
                Exception exception = new Exception();
                Log.wtf((String)"SignInCoordinator", (String)object, (Throwable)exception);
                this.zakj.zag((ConnectionResult)object2);
                this.zagb.disconnect();
                return;
            }
            object2 = this.zakj;
            object = ((ResolveAccountResponse)object).getAccountAccessor();
            Set set = this.mScopes;
            object2.zaa((IAccountAccessor)object, set);
        } else {
            object = this.zakj;
            object.zag((ConnectionResult)object2);
        }
        this.zagb.disconnect();
    }

    public final void onConnected(Bundle bundle) {
        this.zagb.zaa(this);
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zakj.zag(connectionResult);
    }

    public final void onConnectionSuspended(int n10) {
        this.zagb.disconnect();
    }

    public final void zaa(zach object) {
        boolean bl2;
        Object object2 = this.zagb;
        if (object2 != null) {
            object2.disconnect();
        }
        object2 = this.zaet;
        int n10 = System.identityHashCode(this);
        Integer n11 = n10;
        ((ClientSettings)object2).setClientSessionId(n11);
        Api$AbstractClientBuilder api$AbstractClientBuilder = this.zaau;
        Context context = this.mContext;
        Looper looper = this.mHandler.getLooper();
        ClientSettings clientSettings = this.zaet;
        SignInOptions signInOptions = clientSettings.getSignInOptions();
        this.zagb = object2 = (zad)api$AbstractClientBuilder.buildClient(context, looper, clientSettings, signInOptions, this, this);
        this.zakj = object;
        object = this.mScopes;
        if (object != null && !(bl2 = object.isEmpty())) {
            this.zagb.connect();
            return;
        }
        object = this.mHandler;
        object2 = new zacf(this);
        object.post((Runnable)object2);
    }

    public final void zab(zaj zaj2) {
        Handler handler = this.mHandler;
        zacg zacg2 = new zacg(this, zaj2);
        handler.post((Runnable)zacg2);
    }

    public final zad zabq() {
        return this.zagb;
    }

    public final void zabs() {
        zad zad2 = this.zagb;
        if (zad2 != null) {
            zad2.disconnect();
        }
    }
}

