/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 */
package com.google.android.gms.measurement.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.measurement.api.AppMeasurementSdk$EventInterceptor;
import com.google.android.gms.measurement.api.AppMeasurementSdk$OnEventListener;
import java.util.List;
import java.util.Map;

public class AppMeasurementSdk {
    private final zzbr zza;

    public AppMeasurementSdk(zzbr zzbr2) {
        this.zza = zzbr2;
    }

    public static AppMeasurementSdk getInstance(Context context) {
        return zzbr.zza(context, null, null, null, null).zzb();
    }

    public static AppMeasurementSdk getInstance(Context context, String string2, String string3, String string4, Bundle bundle) {
        return zzbr.zza(context, string2, string3, string4, bundle).zzb();
    }

    public void beginAdUnitExposure(String string2) {
        this.zza.zzu(string2);
    }

    public void clearConditionalUserProperty(String string2, String string3, Bundle bundle) {
        this.zza.zzl(string2, string3, bundle);
    }

    public void endAdUnitExposure(String string2) {
        this.zza.zzv(string2);
    }

    public long generateEventId() {
        return this.zza.zzy();
    }

    public String getAppIdOrigin() {
        return this.zza.zzG();
    }

    public String getAppInstanceId() {
        return this.zza.zzx();
    }

    public List getConditionalUserProperties(String string2, String string3) {
        return this.zza.zzm(string2, string3);
    }

    public String getCurrentScreenClass() {
        return this.zza.zzA();
    }

    public String getCurrentScreenName() {
        return this.zza.zzz();
    }

    public String getGmpAppId() {
        return this.zza.zzw();
    }

    public int getMaxUserProperties(String string2) {
        return this.zza.zzE(string2);
    }

    public Map getUserProperties(String string2, String string3, boolean bl2) {
        return this.zza.zzB(string2, string3, bl2);
    }

    public void logEvent(String string2, String string3, Bundle bundle) {
        this.zza.zzh(string2, string3, bundle);
    }

    public void logEventNoInterceptor(String string2, String string3, Bundle bundle, long l10) {
        this.zza.zzi(string2, string3, bundle, l10);
    }

    public void performAction(Bundle bundle) {
        this.zza.zzD(bundle, false);
    }

    public Bundle performActionWithResponse(Bundle bundle) {
        return this.zza.zzD(bundle, true);
    }

    public void registerOnMeasurementEventListener(AppMeasurementSdk$OnEventListener appMeasurementSdk$OnEventListener) {
        this.zza.zze(appMeasurementSdk$OnEventListener);
    }

    public void setConditionalUserProperty(Bundle bundle) {
        this.zza.zzk(bundle);
    }

    public void setConsent(Bundle bundle) {
        this.zza.zzq(bundle);
    }

    public void setCurrentScreen(Activity activity, String string2, String string3) {
        this.zza.zzo(activity, string2, string3);
    }

    public void setEventInterceptor(AppMeasurementSdk$EventInterceptor appMeasurementSdk$EventInterceptor) {
        this.zza.zzd(appMeasurementSdk$EventInterceptor);
    }

    public void setMeasurementEnabled(Boolean bl2) {
        this.zza.zzp(bl2);
    }

    public void setMeasurementEnabled(boolean bl2) {
        zzbr zzbr2 = this.zza;
        Boolean bl3 = bl2;
        zzbr2.zzp(bl3);
    }

    public void setUserProperty(String string2, String string3, Object object) {
        this.zza.zzj(string2, string3, object, true);
    }

    public void unregisterOnMeasurementEventListener(AppMeasurementSdk$OnEventListener appMeasurementSdk$OnEventListener) {
        this.zza.zzf(appMeasurementSdk$OnEventListener);
    }

    public final void zza(boolean bl2) {
        this.zza.zzI(bl2);
    }
}

