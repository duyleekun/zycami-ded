/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.google.android.gms.internal.clearcut;

import android.util.Log;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.clearcut.zze;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api$AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.internal.clearcut.zzfz;
import com.google.android.gms.internal.clearcut.zzha;
import com.google.android.gms.internal.clearcut.zzi;
import com.google.android.gms.internal.clearcut.zzj;
import com.google.android.gms.internal.clearcut.zzn;

public final class zzh
extends BaseImplementation$ApiMethodImpl {
    private final zze zzao;

    public zzh(zze zze2, GoogleApiClient googleApiClient) {
        Api api = ClearcutLogger.API;
        super(api, googleApiClient);
        this.zzao = zze2;
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final /* synthetic */ void doExecute(Api$AnyClient object) {
        zze zze2;
        object = (zzj)object;
        zzi zzi2 = new zzi(this);
        try {
            int n10;
            byte[] byArray;
            zzha zzha2;
            zze2 = this.zzao;
            Object object2 = zze2.zzt;
            if (object2 != null) {
                zzha2 = zze2.zzaa;
                byArray = zzha2.zzbjp;
                n10 = byArray.length;
                if (n10 == 0) {
                    object2 = object2.zza();
                    zzha2.zzbjp = (byte[])object2;
                }
            }
            if ((object2 = zze2.zzan) != null) {
                zzha2 = zze2.zzaa;
                byArray = zzha2.zzbjw;
                n10 = byArray.length;
                if (n10 == 0) {
                    object2 = object2.zza();
                    zzha2.zzbjw = (byte[])object2;
                }
            }
            object2 = zze2.zzaa;
            int n11 = ((zzfz)object2).zzas();
            byArray = new byte[n11];
            zzfz.zza((zzfz)object2, byArray, 0, n11);
            zze2.zzah = byArray;
        }
        catch (RuntimeException runtimeException) {
            Log.e((String)"ClearcutLoggerApiImpl", (String)"derived ClearcutLogger.MessageProducer ", (Throwable)runtimeException);
            Status status = new Status(10, "MessageProducer");
            this.setFailedResult(status);
            return;
        }
        object = (zzn)((BaseGmsClient)object).getService();
        zze2 = this.zzao;
        object.zza(zzi2, zze2);
    }
}

