/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Looper
 */
package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api$BaseClientBuilder;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;

public abstract class Api$AbstractClientBuilder
extends Api$BaseClientBuilder {
    public abstract Api$Client buildClient(Context var1, Looper var2, ClientSettings var3, Object var4, GoogleApiClient$ConnectionCallbacks var5, GoogleApiClient$OnConnectionFailedListener var6);
}

