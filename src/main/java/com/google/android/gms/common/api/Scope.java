/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class Scope
extends AbstractSafeParcelable
implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR;
    private final int zza;
    private final String zzb;

    static {
        zza zza2 = new zza();
        CREATOR = zza2;
    }

    public Scope(int n10, String string2) {
        Preconditions.checkNotEmpty(string2, "scopeUri must not be null or empty");
        this.zza = n10;
        this.zzb = string2;
    }

    public Scope(String string2) {
        this(1, string2);
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl2 = object instanceof Scope;
        if (!bl2) {
            return false;
        }
        String string2 = this.zzb;
        object = ((Scope)object).zzb;
        return string2.equals(object);
    }

    public final String getScopeUri() {
        return this.zzb;
    }

    public final int hashCode() {
        return this.zzb.hashCode();
    }

    public final String toString() {
        return this.zzb;
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        n10 = SafeParcelWriter.beginObjectHeader(parcel);
        int n11 = this.zza;
        SafeParcelWriter.writeInt(parcel, 1, n11);
        String string2 = this.getScopeUri();
        SafeParcelWriter.writeString(parcel, 2, string2, false);
        SafeParcelWriter.finishObjectHeader(parcel, n10);
    }
}

