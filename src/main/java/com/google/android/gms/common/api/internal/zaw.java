/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 */
package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api$AbstractClientBuilder;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.GoogleApiManager$zaa;
import com.google.android.gms.common.api.internal.zace;
import com.google.android.gms.common.api.internal.zaq;
import com.google.android.gms.common.internal.ClientSettings;

public final class zaw
extends GoogleApi {
    private final Api$AbstractClientBuilder zace;
    private final Api$Client zaer;
    private final zaq zaes;
    private final ClientSettings zaet;

    public zaw(Context context, Api api, Looper looper, Api$Client api$Client, zaq zaq2, ClientSettings clientSettings, Api$AbstractClientBuilder api$AbstractClientBuilder) {
        super(context, api, looper);
        this.zaer = api$Client;
        this.zaes = zaq2;
        this.zaet = clientSettings;
        this.zace = api$AbstractClientBuilder;
        this.zabm.zaa(this);
    }

    public final Api$Client zaa(Looper looper, GoogleApiManager$zaa googleApiManager$zaa) {
        this.zaes.zaa(googleApiManager$zaa);
        return this.zaer;
    }

    public final zace zaa(Context context, Handler handler) {
        ClientSettings clientSettings = this.zaet;
        Api$AbstractClientBuilder api$AbstractClientBuilder = this.zace;
        zace zace2 = new zace(context, handler, clientSettings, api$AbstractClientBuilder);
        return zace2;
    }

    public final Api$Client zaab() {
        return this.zaer;
    }
}

