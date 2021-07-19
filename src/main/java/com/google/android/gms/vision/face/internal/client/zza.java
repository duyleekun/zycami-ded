/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.vision.face.internal.client;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.vision.face.internal.client.zzc;

public final class zza
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public final int type;
    public final PointF[] zzdf;

    static {
        zzc zzc2 = new zzc();
        CREATOR = zzc2;
    }

    public zza(PointF[] pointFArray, int n10) {
        this.zzdf = pointFArray;
        this.type = n10;
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        int n11 = SafeParcelWriter.beginObjectHeader(parcel);
        PointF[] pointFArray = this.zzdf;
        SafeParcelWriter.writeTypedArray(parcel, 2, (Parcelable[])pointFArray, n10, false);
        n10 = this.type;
        SafeParcelWriter.writeInt(parcel, 3, n10);
        SafeParcelWriter.finishObjectHeader(parcel, n11);
    }
}

