/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.vision.face.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.vision.zzb;
import com.google.android.gms.internal.vision.zzd;
import com.google.android.gms.internal.vision.zzu;
import com.google.android.gms.vision.face.internal.client.FaceParcel;
import com.google.android.gms.vision.face.internal.client.zzh;

public final class zzj
extends zzb
implements zzh {
    public zzj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
    }

    public final FaceParcel[] zza(IObjectWrapper iObjectWrapper, IObjectWrapper faceParcelArray, IObjectWrapper iObjectWrapper2, int n10, int n11, int n12, int n13, int n14, int n15, zzu zzu2) {
        Parcel parcel = this.zza();
        zzd.zza(parcel, iObjectWrapper);
        zzd.zza(parcel, (IInterface)faceParcelArray);
        zzd.zza(parcel, iObjectWrapper2);
        parcel.writeInt(n10);
        parcel.writeInt(n11);
        parcel.writeInt(n12);
        parcel.writeInt(n13);
        parcel.writeInt(n14);
        parcel.writeInt(n15);
        zzd.zza(parcel, zzu2);
        iObjectWrapper = this.zza(4, parcel);
        faceParcelArray = FaceParcel.CREATOR;
        faceParcelArray = (FaceParcel[])iObjectWrapper.createTypedArray((Parcelable.Creator)faceParcelArray);
        iObjectWrapper.recycle();
        return faceParcelArray;
    }

    public final FaceParcel[] zzc(IObjectWrapper iObjectWrapper, zzu faceParcelArray) {
        Parcel parcel = this.zza();
        zzd.zza(parcel, iObjectWrapper);
        zzd.zza(parcel, (Parcelable)faceParcelArray);
        iObjectWrapper = this.zza(1, parcel);
        faceParcelArray = FaceParcel.CREATOR;
        faceParcelArray = (FaceParcel[])iObjectWrapper.createTypedArray((Parcelable.Creator)faceParcelArray);
        iObjectWrapper.recycle();
        return faceParcelArray;
    }

    public final boolean zzd(int n10) {
        Parcel parcel = this.zza();
        parcel.writeInt(n10);
        Parcel parcel2 = this.zza(2, parcel);
        boolean bl2 = zzd.zza(parcel2);
        parcel2.recycle();
        return bl2;
    }

    public final void zzo() {
        Parcel parcel = this.zza();
        this.zzb(3, parcel);
    }
}

