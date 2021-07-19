/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.vision.face.internal.client.zze;

public final class zzf
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public int landmarkType;
    public int mode;
    public float proportionalMinFaceSize;
    public boolean trackingEnabled;
    public boolean zzcv;
    public int zzcw;

    static {
        zze zze2 = new zze();
        CREATOR = zze2;
    }

    public zzf() {
    }

    public zzf(int n10, int n11, int n12, boolean bl2, boolean bl3, float f10) {
        this.mode = n10;
        this.landmarkType = n11;
        this.zzcw = n12;
        this.zzcv = bl2;
        this.trackingEnabled = bl3;
        this.proportionalMinFaceSize = f10;
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        n10 = SafeParcelWriter.beginObjectHeader(parcel);
        int bl2 = this.mode;
        SafeParcelWriter.writeInt(parcel, 2, bl2);
        int n11 = this.landmarkType;
        SafeParcelWriter.writeInt(parcel, 3, n11);
        int n12 = this.zzcw;
        SafeParcelWriter.writeInt(parcel, 4, n12);
        boolean bl3 = this.zzcv;
        SafeParcelWriter.writeBoolean(parcel, 5, bl3);
        boolean bl4 = this.trackingEnabled;
        SafeParcelWriter.writeBoolean(parcel, 6, bl4);
        float f10 = this.proportionalMinFaceSize;
        SafeParcelWriter.writeFloat(parcel, 7, f10);
        SafeParcelWriter.finishObjectHeader(parcel, n10);
    }
}

