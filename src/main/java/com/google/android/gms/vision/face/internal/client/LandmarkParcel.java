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
import com.google.android.gms.vision.face.internal.client.zzm;

public final class LandmarkParcel
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public final int type;
    private final int versionCode;
    public final float x;
    public final float y;

    static {
        zzm zzm2 = new zzm();
        CREATOR = zzm2;
    }

    public LandmarkParcel(int n10, float f10, float f11, int n11) {
        this.versionCode = n10;
        this.x = f10;
        this.y = f11;
        this.type = n11;
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        n10 = SafeParcelWriter.beginObjectHeader(parcel);
        int n11 = this.versionCode;
        SafeParcelWriter.writeInt(parcel, 1, n11);
        float f10 = this.x;
        SafeParcelWriter.writeFloat(parcel, 2, f10);
        f10 = this.y;
        SafeParcelWriter.writeFloat(parcel, 3, f10);
        n11 = this.type;
        SafeParcelWriter.writeInt(parcel, 4, n11);
        SafeParcelWriter.finishObjectHeader(parcel, n10);
    }
}

