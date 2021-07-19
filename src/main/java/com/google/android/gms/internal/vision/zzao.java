/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.vision.zzab;
import com.google.android.gms.internal.vision.zzal;
import com.google.android.gms.internal.vision.zzar;

public final class zzao
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final float zzdv;
    public final String zzej;
    public final zzab zzep;
    private final zzab zzeq;
    public final String zzes;
    private final zzal[] zzey;
    private final boolean zzez;

    static {
        zzar zzar2 = new zzar();
        CREATOR = zzar2;
    }

    public zzao(zzal[] zzalArray, zzab zzab2, zzab zzab3, String string2, float f10, String string3, boolean bl2) {
        this.zzey = zzalArray;
        this.zzep = zzab2;
        this.zzeq = zzab3;
        this.zzes = string2;
        this.zzdv = f10;
        this.zzej = string3;
        this.zzez = bl2;
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        int n11 = SafeParcelWriter.beginObjectHeader(parcel);
        Object object = this.zzey;
        SafeParcelWriter.writeTypedArray(parcel, 2, object, n10, false);
        object = this.zzep;
        SafeParcelWriter.writeParcelable(parcel, 3, (Parcelable)object, n10, false);
        object = this.zzeq;
        SafeParcelWriter.writeParcelable(parcel, 4, (Parcelable)object, n10, false);
        String string2 = this.zzes;
        SafeParcelWriter.writeString(parcel, 5, string2, false);
        float f10 = this.zzdv;
        SafeParcelWriter.writeFloat(parcel, 6, f10);
        string2 = this.zzej;
        SafeParcelWriter.writeString(parcel, 7, string2, false);
        n10 = (int)(this.zzez ? 1 : 0);
        SafeParcelWriter.writeBoolean(parcel, 8, n10 != 0);
        SafeParcelWriter.finishObjectHeader(parcel, n11);
    }
}

