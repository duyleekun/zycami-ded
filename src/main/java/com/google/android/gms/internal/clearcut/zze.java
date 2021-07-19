/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.gms.internal.clearcut;

import android.content.Context;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.clearcut.zzb;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.internal.clearcut.zzh;

public final class zze
extends GoogleApi
implements zzb {
    private zze(Context context) {
        Api api = ClearcutLogger.API;
        ApiExceptionMapper apiExceptionMapper = new ApiExceptionMapper();
        super(context, api, null, (StatusExceptionMapper)apiExceptionMapper);
    }

    public static zzb zzb(Context context) {
        zze zze2 = new zze(context);
        return zze2;
    }

    public final PendingResult zzb(com.google.android.gms.clearcut.zze zze2) {
        GoogleApiClient googleApiClient = this.asGoogleApiClient();
        zzh zzh2 = new zzh(zze2, googleApiClient);
        return this.doBestEffortWrite(zzh2);
    }
}

