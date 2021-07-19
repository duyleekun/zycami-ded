/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.zzb;

public final class zzc
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public Bundle zza;
    public Feature[] zzb;
    private int zzc;

    static {
        zzb zzb2 = new zzb();
        CREATOR = zzb2;
    }

    public zzc() {
    }

    public zzc(Bundle bundle, Feature[] featureArray, int n10) {
        this.zza = bundle;
        this.zzb = featureArray;
        this.zzc = n10;
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        int n11 = SafeParcelWriter.beginObjectHeader(parcel);
        Parcelable[] parcelableArray = this.zza;
        SafeParcelWriter.writeBundle(parcel, 1, (Bundle)parcelableArray, false);
        parcelableArray = this.zzb;
        SafeParcelWriter.writeTypedArray(parcel, 2, parcelableArray, n10, false);
        n10 = this.zzc;
        SafeParcelWriter.writeInt(parcel, 3, n10);
        SafeParcelWriter.finishObjectHeader(parcel, n11);
    }
}

