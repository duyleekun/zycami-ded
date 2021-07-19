/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.vision.face.internal.client.LandmarkParcel;
import com.google.android.gms.vision.face.internal.client.zza;
import com.google.android.gms.vision.face.internal.client.zzd;

public class FaceParcel
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public final float centerX;
    public final float centerY;
    public final float height;
    public final int id;
    private final int versionCode;
    public final float width;
    public final float zzcm;
    public final float zzcn;
    public final float zzco;
    public final float zzcp;
    public final float zzdh;
    public final float zzdi;
    public final float zzdj;
    public final LandmarkParcel[] zzdk;
    public final zza[] zzdl;

    static {
        zzd zzd2 = new zzd();
        CREATOR = zzd2;
    }

    public FaceParcel(int n10, int n11, float f10, float f11, float f12, float f13, float f14, float f15, float f16, LandmarkParcel[] landmarkParcelArray, float f17, float f18, float f19, zza[] zzaArray, float f20) {
        this.versionCode = n10;
        this.id = n11;
        this.centerX = f10;
        this.centerY = f11;
        this.width = f12;
        this.height = f13;
        this.zzdh = f14;
        this.zzdi = f15;
        this.zzdj = f16;
        this.zzdk = landmarkParcelArray;
        this.zzcm = f17;
        this.zzcn = f18;
        this.zzco = f19;
        this.zzdl = zzaArray;
        this.zzcp = f20;
    }

    public FaceParcel(int n10, int n11, float f10, float f11, float f12, float f13, float f14, float f15, LandmarkParcel[] landmarkParcelArray, float f16, float f17, float f18) {
        zza[] zzaArray = new zza[]{};
        this(n10, n11, f10, f11, f12, f13, f14, f15, 0.0f, landmarkParcelArray, f16, f17, f18, zzaArray, -1.0f);
    }

    public void writeToParcel(Parcel parcel, int n10) {
        int n11 = SafeParcelWriter.beginObjectHeader(parcel);
        int n12 = this.versionCode;
        SafeParcelWriter.writeInt(parcel, 1, n12);
        n12 = this.id;
        SafeParcelWriter.writeInt(parcel, 2, n12);
        float f10 = this.centerX;
        SafeParcelWriter.writeFloat(parcel, 3, f10);
        f10 = this.centerY;
        SafeParcelWriter.writeFloat(parcel, 4, f10);
        f10 = this.width;
        SafeParcelWriter.writeFloat(parcel, 5, f10);
        f10 = this.height;
        SafeParcelWriter.writeFloat(parcel, 6, f10);
        f10 = this.zzdh;
        SafeParcelWriter.writeFloat(parcel, 7, f10);
        f10 = this.zzdi;
        SafeParcelWriter.writeFloat(parcel, 8, f10);
        Parcelable[] parcelableArray = this.zzdk;
        SafeParcelWriter.writeTypedArray(parcel, 9, parcelableArray, n10, false);
        f10 = this.zzcm;
        SafeParcelWriter.writeFloat(parcel, 10, f10);
        f10 = this.zzcn;
        SafeParcelWriter.writeFloat(parcel, 11, f10);
        f10 = this.zzco;
        SafeParcelWriter.writeFloat(parcel, 12, f10);
        parcelableArray = this.zzdl;
        SafeParcelWriter.writeTypedArray(parcel, 13, parcelableArray, n10, false);
        float f11 = this.zzdj;
        SafeParcelWriter.writeFloat(parcel, 14, f11);
        f11 = this.zzcp;
        SafeParcelWriter.writeFloat(parcel, 15, f11);
        SafeParcelWriter.finishObjectHeader(parcel, n11);
    }
}

