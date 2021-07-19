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
import com.google.android.gms.internal.vision.zzac;
import com.google.android.gms.internal.vision.zzad;
import com.google.android.gms.internal.vision.zzaf;
import com.google.android.gms.internal.vision.zzam;
import com.google.android.gms.internal.vision.zzb;
import com.google.android.gms.internal.vision.zzd;

public final class zzae
extends zzb
implements zzaf {
    public zzae(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.text.internal.client.INativeTextRecognizerCreator");
    }

    public final zzad zza(IObjectWrapper iObjectWrapper, zzam object) {
        Object object2 = this.zza();
        zzd.zza(object2, iObjectWrapper);
        zzd.zza(object2, (Parcelable)object);
        int n10 = 1;
        iObjectWrapper = this.zza(n10, (Parcel)object2);
        object = iObjectWrapper.readStrongBinder();
        if (object == null) {
            object = null;
        } else {
            object2 = object.queryLocalInterface("com.google.android.gms.vision.text.internal.client.INativeTextRecognizer");
            boolean bl2 = object2 instanceof zzad;
            if (bl2) {
                object = object2;
                object = (zzad)object2;
            } else {
                object2 = new zzac((IBinder)object);
                object = object2;
            }
        }
        iObjectWrapper.recycle();
        return object;
    }
}

