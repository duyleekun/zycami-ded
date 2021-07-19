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
import com.google.android.gms.internal.vision.zzaa;

public final class zzab
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public final int height;
    public final int left;
    public final int top;
    public final int width;
    public final float zzen;

    static {
        zzaa zzaa2 = new zzaa();
        CREATOR = zzaa2;
    }

    public zzab(int n10, int n11, int n12, int n13, float f10) {
        this.left = n10;
        this.top = n11;
        this.width = n12;
        this.height = n13;
        this.zzen = f10;
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        n10 = SafeParcelWriter.beginObjectHeader(parcel);
        int n11 = this.left;
        SafeParcelWriter.writeInt(parcel, 2, n11);
        n11 = this.top;
        SafeParcelWriter.writeInt(parcel, 3, n11);
        n11 = this.width;
        SafeParcelWriter.writeInt(parcel, 4, n11);
        n11 = this.height;
        SafeParcelWriter.writeInt(parcel, 5, n11);
        float f10 = this.zzen;
        SafeParcelWriter.writeFloat(parcel, 6, f10);
        SafeParcelWriter.finishObjectHeader(parcel, n10);
    }
}

