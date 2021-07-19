/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 */
package com.google.android.gms.vision.face.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.vision.zzb;
import com.google.android.gms.internal.vision.zzd;
import com.google.android.gms.vision.face.internal.client.zzf;
import com.google.android.gms.vision.face.internal.client.zzh;
import com.google.android.gms.vision.face.internal.client.zzi;
import com.google.android.gms.vision.face.internal.client.zzj;

public final class zzk
extends zzb
implements zzi {
    public zzk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.face.internal.client.INativeFaceDetectorCreator");
    }

    public final zzh newFaceDetector(IObjectWrapper iObjectWrapper, zzf object) {
        Object object2 = this.zza();
        zzd.zza(object2, iObjectWrapper);
        zzd.zza(object2, (Parcelable)object);
        int n10 = 1;
        iObjectWrapper = this.zza(n10, (Parcel)object2);
        object = iObjectWrapper.readStrongBinder();
        if (object == null) {
            object = null;
        } else {
            object2 = object.queryLocalInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
            boolean bl2 = object2 instanceof zzh;
            if (bl2) {
                object = object2;
                object = (zzh)object2;
            } else {
                object2 = new zzj((IBinder)object);
                object = object2;
            }
        }
        iObjectWrapper.recycle();
        return object;
    }
}

