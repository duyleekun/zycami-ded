/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects$ToStringHelper;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.zzb;

public class Feature
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final String zza;
    private final int zzb;
    private final long zzc;

    static {
        zzb zzb2 = new zzb();
        CREATOR = zzb2;
    }

    public Feature(String string2, int n10, long l10) {
        this.zza = string2;
        this.zzb = n10;
        this.zzc = l10;
    }

    public Feature(String string2, long l10) {
        this.zza = string2;
        this.zzc = l10;
        this.zzb = -1;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof Feature;
        if (bl2) {
            long l10;
            long l11;
            long l12;
            long l13;
            String string2;
            object = (Feature)object;
            String string3 = this.getName();
            if ((string3 != null && (bl2 = (string3 = this.getName()).equals(string2 = ((Feature)object).getName())) || (string3 = this.getName()) == null && (string3 = ((Feature)object).getName()) == null) && (l13 = (l12 = (l11 = this.getVersion()) - (l10 = ((Feature)object).getVersion())) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == false) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return this.zza;
    }

    public long getVersion() {
        long l10 = this.zzc;
        long l11 = -1;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            int n10 = this.zzb;
            l10 = n10;
        }
        return l10;
    }

    public int hashCode() {
        Object object = this.getName();
        Object[] objectArray = new Object[]{object, object = Long.valueOf(this.getVersion())};
        return Objects.hashCode(objectArray);
    }

    public String toString() {
        Objects$ToStringHelper objects$ToStringHelper = Objects.toStringHelper(this);
        Object object = this.getName();
        objects$ToStringHelper = objects$ToStringHelper.add("name", object);
        object = this.getVersion();
        return objects$ToStringHelper.add("version", object).toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = SafeParcelWriter.beginObjectHeader(parcel);
        String string2 = this.getName();
        SafeParcelWriter.writeString(parcel, 1, string2, false);
        int n11 = this.zzb;
        SafeParcelWriter.writeInt(parcel, 2, n11);
        long l10 = this.getVersion();
        SafeParcelWriter.writeLong(parcel, 3, l10);
        SafeParcelWriter.finishObjectHeader(parcel, n10);
    }
}

