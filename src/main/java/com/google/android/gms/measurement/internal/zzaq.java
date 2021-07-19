/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.measurement.internal.zzap;
import com.google.android.gms.measurement.internal.zzar;
import java.util.Iterator;

public final class zzaq
extends AbstractSafeParcelable
implements Iterable {
    public static final Parcelable.Creator CREATOR;
    private final Bundle zza;

    static {
        zzar zzar2 = new zzar();
        CREATOR = zzar2;
    }

    public zzaq(Bundle bundle) {
        this.zza = bundle;
    }

    public static /* synthetic */ Bundle zzg(zzaq zzaq2) {
        return zzaq2.zza;
    }

    public final Iterator iterator() {
        zzap zzap2 = new zzap(this);
        return zzap2;
    }

    public final String toString() {
        return this.zza.toString();
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        n10 = SafeParcelWriter.beginObjectHeader(parcel);
        Bundle bundle = this.zzf();
        SafeParcelWriter.writeBundle(parcel, 2, bundle, false);
        SafeParcelWriter.finishObjectHeader(parcel, n10);
    }

    public final Object zza(String string2) {
        return this.zza.get(string2);
    }

    public final Long zzb(String string2) {
        return this.zza.getLong("value");
    }

    public final Double zzc(String string2) {
        return this.zza.getDouble("value");
    }

    public final String zzd(String string2) {
        return this.zza.getString(string2);
    }

    public final int zze() {
        return this.zza.size();
    }

    public final Bundle zzf() {
        Bundle bundle = this.zza;
        Bundle bundle2 = new Bundle(bundle);
        return bundle2;
    }
}

