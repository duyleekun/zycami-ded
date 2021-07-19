/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 */
package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.measurement.zza;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zzp;
import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.internal.measurement.zzv;
import com.google.android.gms.internal.measurement.zzx;
import com.google.android.gms.internal.measurement.zzy;
import java.util.Map;

public final class zzn
extends zza
implements zzp {
    public zzn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public final void beginAdUnitExposure(String string2, long l10) {
        Parcel parcel = this.zza();
        parcel.writeString(string2);
        parcel.writeLong(l10);
        this.zzc(23, parcel);
    }

    public final void clearConditionalUserProperty(String string2, String string3, Bundle bundle) {
        Parcel parcel = this.zza();
        parcel.writeString(string2);
        parcel.writeString(string3);
        zzc.zzd(parcel, (Parcelable)bundle);
        this.zzc(9, parcel);
    }

    public final void clearMeasurementEnabled(long l10) {
        Parcel parcel = this.zza();
        parcel.writeLong(l10);
        this.zzc(43, parcel);
    }

    public final void endAdUnitExposure(String string2, long l10) {
        Parcel parcel = this.zza();
        parcel.writeString(string2);
        parcel.writeLong(l10);
        this.zzc(24, parcel);
    }

    public final void generateEventId(zzs zzs2) {
        Parcel parcel = this.zza();
        zzc.zze(parcel, zzs2);
        this.zzc(22, parcel);
    }

    public final void getAppInstanceId(zzs zzs2) {
        Parcel parcel = this.zza();
        zzc.zze(parcel, zzs2);
        this.zzc(20, parcel);
    }

    public final void getCachedAppInstanceId(zzs zzs2) {
        Parcel parcel = this.zza();
        zzc.zze(parcel, zzs2);
        this.zzc(19, parcel);
    }

    public final void getConditionalUserProperties(String string2, String string3, zzs zzs2) {
        Parcel parcel = this.zza();
        parcel.writeString(string2);
        parcel.writeString(string3);
        zzc.zze(parcel, zzs2);
        this.zzc(10, parcel);
    }

    public final void getCurrentScreenClass(zzs zzs2) {
        Parcel parcel = this.zza();
        zzc.zze(parcel, zzs2);
        this.zzc(17, parcel);
    }

    public final void getCurrentScreenName(zzs zzs2) {
        Parcel parcel = this.zza();
        zzc.zze(parcel, zzs2);
        this.zzc(16, parcel);
    }

    public final void getGmpAppId(zzs zzs2) {
        Parcel parcel = this.zza();
        zzc.zze(parcel, zzs2);
        this.zzc(21, parcel);
    }

    public final void getMaxUserProperties(String string2, zzs zzs2) {
        Parcel parcel = this.zza();
        parcel.writeString(string2);
        zzc.zze(parcel, zzs2);
        this.zzc(6, parcel);
    }

    public final void getTestFlag(zzs zzs2, int n10) {
        Parcel parcel = this.zza();
        zzc.zze(parcel, zzs2);
        parcel.writeInt(n10);
        this.zzc(38, parcel);
    }

    public final void getUserProperties(String string2, String string3, boolean bl2, zzs zzs2) {
        Parcel parcel = this.zza();
        parcel.writeString(string2);
        parcel.writeString(string3);
        zzc.zzb(parcel, bl2);
        zzc.zze(parcel, zzs2);
        this.zzc(5, parcel);
    }

    public final void initForTests(Map map) {
        throw null;
    }

    public final void initialize(IObjectWrapper iObjectWrapper, zzy zzy2, long l10) {
        Parcel parcel = this.zza();
        zzc.zze(parcel, iObjectWrapper);
        zzc.zzd(parcel, zzy2);
        parcel.writeLong(l10);
        this.zzc(1, parcel);
    }

    public final void isDataCollectionEnabled(zzs zzs2) {
        throw null;
    }

    public final void logEvent(String string2, String string3, Bundle bundle, boolean bl2, boolean bl3, long l10) {
        Parcel parcel = this.zza();
        parcel.writeString(string2);
        parcel.writeString(string3);
        zzc.zzd(parcel, (Parcelable)bundle);
        zzc.zzb(parcel, bl2);
        zzc.zzb(parcel, bl3);
        parcel.writeLong(l10);
        this.zzc(2, parcel);
    }

    public final void logEventAndBundle(String string2, String string3, Bundle bundle, zzs zzs2, long l10) {
        throw null;
    }

    public final void logHealthData(int n10, String string2, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        Parcel parcel = this.zza();
        parcel.writeInt(5);
        parcel.writeString(string2);
        zzc.zze(parcel, iObjectWrapper);
        zzc.zze(parcel, iObjectWrapper2);
        zzc.zze(parcel, iObjectWrapper3);
        this.zzc(33, parcel);
    }

    public final void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long l10) {
        Parcel parcel = this.zza();
        zzc.zze(parcel, iObjectWrapper);
        zzc.zzd(parcel, (Parcelable)bundle);
        parcel.writeLong(l10);
        this.zzc(27, parcel);
    }

    public final void onActivityDestroyed(IObjectWrapper iObjectWrapper, long l10) {
        Parcel parcel = this.zza();
        zzc.zze(parcel, iObjectWrapper);
        parcel.writeLong(l10);
        this.zzc(28, parcel);
    }

    public final void onActivityPaused(IObjectWrapper iObjectWrapper, long l10) {
        Parcel parcel = this.zza();
        zzc.zze(parcel, iObjectWrapper);
        parcel.writeLong(l10);
        this.zzc(29, parcel);
    }

    public final void onActivityResumed(IObjectWrapper iObjectWrapper, long l10) {
        Parcel parcel = this.zza();
        zzc.zze(parcel, iObjectWrapper);
        parcel.writeLong(l10);
        this.zzc(30, parcel);
    }

    public final void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzs zzs2, long l10) {
        Parcel parcel = this.zza();
        zzc.zze(parcel, iObjectWrapper);
        zzc.zze(parcel, zzs2);
        parcel.writeLong(l10);
        this.zzc(31, parcel);
    }

    public final void onActivityStarted(IObjectWrapper iObjectWrapper, long l10) {
        Parcel parcel = this.zza();
        zzc.zze(parcel, iObjectWrapper);
        parcel.writeLong(l10);
        this.zzc(25, parcel);
    }

    public final void onActivityStopped(IObjectWrapper iObjectWrapper, long l10) {
        Parcel parcel = this.zza();
        zzc.zze(parcel, iObjectWrapper);
        parcel.writeLong(l10);
        this.zzc(26, parcel);
    }

    public final void performAction(Bundle bundle, zzs zzs2, long l10) {
        Parcel parcel = this.zza();
        zzc.zzd(parcel, (Parcelable)bundle);
        zzc.zze(parcel, zzs2);
        parcel.writeLong(l10);
        this.zzc(32, parcel);
    }

    public final void registerOnMeasurementEventListener(zzv zzv2) {
        Parcel parcel = this.zza();
        zzc.zze(parcel, zzv2);
        this.zzc(35, parcel);
    }

    public final void resetAnalyticsData(long l10) {
        Parcel parcel = this.zza();
        parcel.writeLong(l10);
        this.zzc(12, parcel);
    }

    public final void setConditionalUserProperty(Bundle bundle, long l10) {
        Parcel parcel = this.zza();
        zzc.zzd(parcel, (Parcelable)bundle);
        parcel.writeLong(l10);
        this.zzc(8, parcel);
    }

    public final void setConsent(Bundle bundle, long l10) {
        Parcel parcel = this.zza();
        zzc.zzd(parcel, (Parcelable)bundle);
        parcel.writeLong(l10);
        this.zzc(44, parcel);
    }

    public final void setConsentThirdParty(Bundle bundle, long l10) {
        Parcel parcel = this.zza();
        zzc.zzd(parcel, (Parcelable)bundle);
        parcel.writeLong(l10);
        this.zzc(45, parcel);
    }

    public final void setCurrentScreen(IObjectWrapper iObjectWrapper, String string2, String string3, long l10) {
        Parcel parcel = this.zza();
        zzc.zze(parcel, iObjectWrapper);
        parcel.writeString(string2);
        parcel.writeString(string3);
        parcel.writeLong(l10);
        this.zzc(15, parcel);
    }

    public final void setDataCollectionEnabled(boolean bl2) {
        Parcel parcel = this.zza();
        zzc.zzb(parcel, bl2);
        this.zzc(39, parcel);
    }

    public final void setDefaultEventParameters(Bundle bundle) {
        Parcel parcel = this.zza();
        zzc.zzd(parcel, (Parcelable)bundle);
        this.zzc(42, parcel);
    }

    public final void setEventInterceptor(zzv zzv2) {
        Parcel parcel = this.zza();
        zzc.zze(parcel, zzv2);
        this.zzc(34, parcel);
    }

    public final void setInstanceIdProvider(zzx zzx2) {
        throw null;
    }

    public final void setMeasurementEnabled(boolean bl2, long l10) {
        Parcel parcel = this.zza();
        zzc.zzb(parcel, bl2);
        parcel.writeLong(l10);
        this.zzc(11, parcel);
    }

    public final void setMinimumSessionDuration(long l10) {
        throw null;
    }

    public final void setSessionTimeoutDuration(long l10) {
        Parcel parcel = this.zza();
        parcel.writeLong(l10);
        this.zzc(14, parcel);
    }

    public final void setUserId(String string2, long l10) {
        Parcel parcel = this.zza();
        parcel.writeString(string2);
        parcel.writeLong(l10);
        this.zzc(7, parcel);
    }

    public final void setUserProperty(String string2, String string3, IObjectWrapper iObjectWrapper, boolean bl2, long l10) {
        Parcel parcel = this.zza();
        parcel.writeString(string2);
        parcel.writeString(string3);
        zzc.zze(parcel, iObjectWrapper);
        zzc.zzb(parcel, bl2);
        parcel.writeLong(l10);
        this.zzc(4, parcel);
    }

    public final void unregisterOnMeasurementEventListener(zzv zzv2) {
        Parcel parcel = this.zza();
        zzc.zze(parcel, zzv2);
        this.zzc(36, parcel);
    }
}

