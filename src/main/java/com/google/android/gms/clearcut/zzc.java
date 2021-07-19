/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.clearcut.zzd;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzc
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final boolean zzad;
    private final long zzae;
    private final long zzaf;

    static {
        zzd zzd2 = new zzd();
        CREATOR = zzd2;
    }

    public zzc(boolean bl2, long l10, long l11) {
        this.zzad = bl2;
        this.zzae = l10;
        this.zzaf = l11;
    }

    public final boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        boolean bl3 = object instanceof zzc;
        if (bl3) {
            long l10;
            long l11;
            long l12;
            long l13;
            long l14;
            object = (zzc)object;
            bl3 = this.zzad;
            boolean bl4 = ((zzc)object).zzad;
            if (bl3 == bl4 && !(bl3 = (l14 = (l13 = this.zzae) - (l12 = ((zzc)object).zzae)) == 0L ? 0 : (l14 < 0L ? -1 : 1)) && (l11 = (l10 = (l13 = this.zzaf) - (l12 = ((zzc)object).zzaf)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) == false) {
                return bl2;
            }
        }
        return false;
    }

    public final int hashCode() {
        Object[] objectArray = new Object[3];
        Comparable<Boolean> comparable = this.zzad;
        objectArray[0] = comparable;
        comparable = this.zzae;
        objectArray[1] = comparable;
        comparable = this.zzaf;
        objectArray[2] = comparable;
        return Objects.hashCode(objectArray);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("CollectForDebugParcelable[skipPersistentStorage: ");
        boolean bl2 = this.zzad;
        stringBuilder.append(bl2);
        stringBuilder.append(",collectForDebugStartTimeMillis: ");
        long l10 = this.zzae;
        stringBuilder.append(l10);
        stringBuilder.append(",collectForDebugExpiryTimeMillis: ");
        l10 = this.zzaf;
        stringBuilder.append(l10);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        n10 = SafeParcelWriter.beginObjectHeader(parcel);
        boolean bl2 = this.zzad;
        SafeParcelWriter.writeBoolean(parcel, 1, bl2);
        long l10 = this.zzaf;
        SafeParcelWriter.writeLong(parcel, 2, l10);
        l10 = this.zzae;
        SafeParcelWriter.writeLong(parcel, 3, l10);
        SafeParcelWriter.finishObjectHeader(parcel, n10);
    }
}

