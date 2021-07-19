/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.AccountAccessor;
import com.google.android.gms.common.internal.IAccountAccessor$Stub;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.zzd;

public class GetServiceRequest
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public String zza;
    public IBinder zzb;
    public Scope[] zzc;
    public Bundle zzd;
    public Account zze;
    public Feature[] zzf;
    public Feature[] zzg;
    private final int zzh;
    private final int zzi;
    private int zzj;
    private boolean zzk;
    private int zzl;

    static {
        zzd zzd2 = new zzd();
        CREATOR = zzd2;
    }

    public GetServiceRequest(int n10) {
        int n11;
        this.zzh = 4;
        this.zzj = n11 = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        this.zzi = n10;
        this.zzk = true;
    }

    public GetServiceRequest(int n10, int n11, int n12, String string2, IBinder iBinder, Scope[] scopeArray, Bundle bundle, Account account, Feature[] featureArray, Feature[] featureArray2, boolean bl2, int n13) {
        this.zzh = n10;
        this.zzi = n11;
        this.zzj = n12;
        String string3 = "com.google.android.gms";
        n12 = (int)(string3.equals(string2) ? 1 : 0);
        this.zza = n12 != 0 ? string3 : string2;
        n11 = 2;
        if (n10 < n11) {
            n10 = 0;
            Account account2 = null;
            if (iBinder != null) {
                account2 = AccountAccessor.getAccountBinderSafe(IAccountAccessor$Stub.asInterface(iBinder));
            }
            this.zze = account2;
        } else {
            this.zzb = iBinder;
            this.zze = account;
        }
        this.zzc = scopeArray;
        this.zzd = bundle;
        this.zzf = featureArray;
        this.zzg = featureArray2;
        this.zzk = bl2;
        this.zzl = n13;
    }

    public Bundle getExtraArgs() {
        return this.zzd;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        int n11 = SafeParcelWriter.beginObjectHeader(parcel);
        int n12 = this.zzh;
        SafeParcelWriter.writeInt(parcel, 1, n12);
        n12 = this.zzi;
        SafeParcelWriter.writeInt(parcel, 2, n12);
        n12 = this.zzj;
        SafeParcelWriter.writeInt(parcel, 3, n12);
        Parcelable[] parcelableArray = this.zza;
        SafeParcelWriter.writeString(parcel, 4, (String)parcelableArray, false);
        parcelableArray = this.zzb;
        SafeParcelWriter.writeIBinder(parcel, 5, (IBinder)parcelableArray, false);
        parcelableArray = this.zzc;
        SafeParcelWriter.writeTypedArray(parcel, 6, parcelableArray, n10, false);
        parcelableArray = this.zzd;
        SafeParcelWriter.writeBundle(parcel, 7, (Bundle)parcelableArray, false);
        parcelableArray = this.zze;
        SafeParcelWriter.writeParcelable(parcel, 8, (Parcelable)parcelableArray, n10, false);
        parcelableArray = this.zzf;
        SafeParcelWriter.writeTypedArray(parcel, 10, parcelableArray, n10, false);
        parcelableArray = this.zzg;
        SafeParcelWriter.writeTypedArray(parcel, 11, parcelableArray, n10, false);
        n10 = (int)(this.zzk ? 1 : 0);
        SafeParcelWriter.writeBoolean(parcel, 12, n10 != 0);
        n10 = this.zzl;
        SafeParcelWriter.writeInt(parcel, 13, n10);
        SafeParcelWriter.finishObjectHeader(parcel, n11);
    }
}

