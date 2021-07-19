/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.vision.zzj;

public final class zzk
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public int zzbt;
    private boolean zzbu;

    static {
        zzj zzj2 = new zzj();
        CREATOR = zzj2;
    }

    public zzk() {
    }

    public zzk(int n10, boolean bl2) {
        this.zzbt = n10;
        this.zzbu = bl2;
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        n10 = SafeParcelWriter.beginObjectHeader(parcel);
        int bl2 = this.zzbt;
        SafeParcelWriter.writeInt(parcel, 2, bl2);
        boolean bl3 = this.zzbu;
        SafeParcelWriter.writeBoolean(parcel, 3, bl3);
        SafeParcelWriter.finishObjectHeader(parcel, n10);
    }
}

