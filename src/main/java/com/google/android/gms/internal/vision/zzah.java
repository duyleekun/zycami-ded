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
import com.google.android.gms.internal.vision.zzag;
import com.google.android.gms.internal.vision.zzao;

public final class zzah
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final float zzdv;
    public final String zzej;
    public final zzao[] zzeo;
    public final zzab zzep;
    private final zzab zzeq;
    private final zzab zzer;
    public final String zzes;
    private final int zzet;
    public final boolean zzeu;
    public final int zzev;
    public final int zzew;

    static {
        zzag zzag2 = new zzag();
        CREATOR = zzag2;
    }

    public zzah(zzao[] zzaoArray, zzab zzab2, zzab zzab3, zzab zzab4, String string2, float f10, String string3, int n10, boolean bl2, int n11, int n12) {
        this.zzeo = zzaoArray;
        this.zzep = zzab2;
        this.zzeq = zzab3;
        this.zzer = zzab4;
        this.zzes = string2;
        this.zzdv = f10;
        this.zzej = string3;
        this.zzet = n10;
        this.zzeu = bl2;
        this.zzev = n11;
        this.zzew = n12;
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        int n11 = SafeParcelWriter.beginObjectHeader(parcel);
        Object object = this.zzeo;
        SafeParcelWriter.writeTypedArray(parcel, 2, object, n10, false);
        object = this.zzep;
        SafeParcelWriter.writeParcelable(parcel, 3, (Parcelable)object, n10, false);
        object = this.zzeq;
        SafeParcelWriter.writeParcelable(parcel, 4, (Parcelable)object, n10, false);
        object = this.zzer;
        SafeParcelWriter.writeParcelable(parcel, 5, (Parcelable)object, n10, false);
        String string2 = this.zzes;
        SafeParcelWriter.writeString(parcel, 6, string2, false);
        float f10 = this.zzdv;
        SafeParcelWriter.writeFloat(parcel, 7, f10);
        string2 = this.zzej;
        SafeParcelWriter.writeString(parcel, 8, string2, false);
        n10 = this.zzet;
        SafeParcelWriter.writeInt(parcel, 9, n10);
        n10 = (int)(this.zzeu ? 1 : 0);
        SafeParcelWriter.writeBoolean(parcel, 10, n10 != 0);
        n10 = this.zzev;
        SafeParcelWriter.writeInt(parcel, 11, n10);
        n10 = this.zzew;
        SafeParcelWriter.writeInt(parcel, 12, n10);
        SafeParcelWriter.finishObjectHeader(parcel, n11);
    }
}

