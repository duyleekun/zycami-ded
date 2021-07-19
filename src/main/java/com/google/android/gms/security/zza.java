/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.AsyncTask
 */
package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;
import com.google.android.gms.security.ProviderInstaller$ProviderInstallListener;

public final class zza
extends AsyncTask {
    private final /* synthetic */ Context zza;
    private final /* synthetic */ ProviderInstaller$ProviderInstallListener zzb;

    public zza(Context context, ProviderInstaller$ProviderInstallListener providerInstaller$ProviderInstallListener) {
        this.zza = context;
        this.zzb = providerInstaller$ProviderInstallListener;
    }

    private final Integer zza(Void ... context) {
        context = this.zza;
        try {
            ProviderInstaller.installIfNeeded(context);
        }
        catch (GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException) {
            return googlePlayServicesNotAvailableException.errorCode;
        }
        catch (GooglePlayServicesRepairableException googlePlayServicesRepairableException) {
            return googlePlayServicesRepairableException.getConnectionStatusCode();
        }
        return 0;
    }

    public final /* synthetic */ Object doInBackground(Object[] objectArray) {
        objectArray = (Void[])objectArray;
        return this.zza((Void[])objectArray);
    }

    public final /* synthetic */ void onPostExecute(Object object) {
        int n10 = (Integer)(object = (Integer)object);
        if (n10 == 0) {
            this.zzb.onProviderInstalled();
            return;
        }
        GoogleApiAvailabilityLight googleApiAvailabilityLight = ProviderInstaller.zza();
        Object object2 = this.zza;
        int n11 = (Integer)object;
        googleApiAvailabilityLight = googleApiAvailabilityLight.getErrorResolutionIntent((Context)object2, n11, "pi");
        object2 = this.zzb;
        int n12 = (Integer)object;
        object2.onProviderInstallFailed(n12, (Intent)googleApiAvailabilityLight);
    }
}

