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
import com.google.android.gms.internal.vision.zzad;
import com.google.android.gms.internal.vision.zzah;
import com.google.android.gms.internal.vision.zzaj;
import com.google.android.gms.internal.vision.zzb;
import com.google.android.gms.internal.vision.zzd;
import com.google.android.gms.internal.vision.zzu;

public final class zzac
extends zzb
implements zzad {
    public zzac(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.text.internal.client.INativeTextRecognizer");
    }

    public final zzah[] zza(IObjectWrapper iObjectWrapper, zzu zzahArray, zzaj zzaj2) {
        Parcel parcel = this.zza();
        zzd.zza(parcel, iObjectWrapper);
        zzd.zza(parcel, (Parcelable)zzahArray);
        zzd.zza(parcel, zzaj2);
        iObjectWrapper = this.zza(3, parcel);
        zzahArray = zzah.CREATOR;
        zzahArray = (zzah[])iObjectWrapper.createTypedArray((Parcelable.Creator)zzahArray);
        iObjectWrapper.recycle();
        return zzahArray;
    }

    public final void zzs() {
        Parcel parcel = this.zza();
        this.zzb(2, parcel);
    }
}

