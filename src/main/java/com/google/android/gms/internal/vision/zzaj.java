/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.internal.vision;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.vision.zzai;

public final class zzaj
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public final Rect zzex;

    static {
        zzai zzai2 = new zzai();
        CREATOR = zzai2;
    }

    public zzaj() {
        Rect rect;
        this.zzex = rect = new Rect();
    }

    public zzaj(Rect rect) {
        this.zzex = rect;
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        int n11 = SafeParcelWriter.beginObjectHeader(parcel);
        Rect rect = this.zzex;
        SafeParcelWriter.writeParcelable(parcel, 2, (Parcelable)rect, n10, false);
        SafeParcelWriter.finishObjectHeader(parcel, n11);
    }
}

