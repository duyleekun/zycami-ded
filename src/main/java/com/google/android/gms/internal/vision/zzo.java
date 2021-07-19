/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.internal.vision;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.vision.zzb;
import com.google.android.gms.internal.vision.zzd;
import com.google.android.gms.internal.vision.zzl;
import com.google.android.gms.internal.vision.zzu;
import com.google.android.gms.vision.barcode.Barcode;

public final class zzo
extends zzb
implements zzl {
    public zzo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
    }

    public final Barcode[] zza(IObjectWrapper iObjectWrapper, zzu barcodeArray) {
        Parcel parcel = this.zza();
        zzd.zza(parcel, iObjectWrapper);
        zzd.zza(parcel, (Parcelable)barcodeArray);
        iObjectWrapper = this.zza(1, parcel);
        barcodeArray = Barcode.CREATOR;
        barcodeArray = (Barcode[])iObjectWrapper.createTypedArray((Parcelable.Creator)barcodeArray);
        iObjectWrapper.recycle();
        return barcodeArray;
    }

    public final Barcode[] zzb(IObjectWrapper iObjectWrapper, zzu barcodeArray) {
        Parcel parcel = this.zza();
        zzd.zza(parcel, iObjectWrapper);
        zzd.zza(parcel, (Parcelable)barcodeArray);
        iObjectWrapper = this.zza(2, parcel);
        barcodeArray = Barcode.CREATOR;
        barcodeArray = (Barcode[])iObjectWrapper.createTypedArray((Parcelable.Creator)barcodeArray);
        iObjectWrapper.recycle();
        return barcodeArray;
    }

    public final void zzo() {
        Parcel parcel = this.zza();
        this.zzb(3, parcel);
    }
}

