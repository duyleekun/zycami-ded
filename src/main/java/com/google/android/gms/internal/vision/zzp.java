/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 */
package com.google.android.gms.internal.vision;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.vision.zzb;
import com.google.android.gms.internal.vision.zzd;
import com.google.android.gms.internal.vision.zzk;
import com.google.android.gms.internal.vision.zzl;
import com.google.android.gms.internal.vision.zzn;
import com.google.android.gms.internal.vision.zzo;

public final class zzp
extends zzb
implements zzn {
    public zzp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator");
    }

    public final zzl zza(IObjectWrapper iObjectWrapper, zzk object) {
        Object object2 = this.zza();
        zzd.zza(object2, iObjectWrapper);
        zzd.zza(object2, (Parcelable)object);
        int n10 = 1;
        iObjectWrapper = this.zza(n10, (Parcel)object2);
        object = iObjectWrapper.readStrongBinder();
        if (object == null) {
            object = null;
        } else {
            object2 = object.queryLocalInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
            boolean bl2 = object2 instanceof zzl;
            if (bl2) {
                object = object2;
                object = (zzl)object2;
            } else {
                object2 = new zzo((IBinder)object);
                object = object2;
            }
        }
        iObjectWrapper.recycle();
        return object;
    }
}

