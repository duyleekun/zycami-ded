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
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper$Stub;
import com.google.android.gms.internal.vision.zza;
import com.google.android.gms.internal.vision.zzd;
import com.google.android.gms.internal.vision.zzu;
import com.google.android.gms.vision.face.internal.client.zzh;

public abstract class zzg
extends zza
implements zzh {
    public zzg() {
        super("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
    }

    public final boolean zza(int n10, Parcel object, Parcel parcel, int n11) {
        n11 = 1;
        if (n10 != n11) {
            int n12 = 2;
            if (n10 != n12) {
                n12 = 3;
                if (n10 != n12) {
                    n12 = 4;
                    if (n10 != n12) {
                        return false;
                    }
                    IObjectWrapper iObjectWrapper = IObjectWrapper$Stub.asInterface(object.readStrongBinder());
                    IObjectWrapper iObjectWrapper2 = IObjectWrapper$Stub.asInterface(object.readStrongBinder());
                    IObjectWrapper iObjectWrapper3 = IObjectWrapper$Stub.asInterface(object.readStrongBinder());
                    int n13 = object.readInt();
                    int n14 = object.readInt();
                    int n15 = object.readInt();
                    int n16 = object.readInt();
                    int n17 = object.readInt();
                    int n18 = object.readInt();
                    Parcelable[] parcelableArray = zzu.CREATOR;
                    Object object2 = parcelableArray = zzd.zza(object, (Parcelable.Creator)parcelableArray);
                    object2 = (zzu)parcelableArray;
                    zzg zzg2 = this;
                    parcelableArray = this.zza(iObjectWrapper, iObjectWrapper2, iObjectWrapper3, n13, n14, n15, n16, n17, n18, (zzu)object2);
                    parcel.writeNoException();
                    parcel.writeTypedArray(parcelableArray, n11);
                } else {
                    this.zzo();
                    parcel.writeNoException();
                }
            } else {
                n10 = object.readInt();
                n10 = (int)(this.zzd(n10) ? 1 : 0);
                parcel.writeNoException();
                zzd.writeBoolean(parcel, n10 != 0);
            }
        } else {
            Parcelable[] parcelableArray = IObjectWrapper$Stub.asInterface(object.readStrongBinder());
            Parcelable.Creator creator = zzu.CREATOR;
            object = (zzu)zzd.zza(object, creator);
            parcelableArray = this.zzc((IObjectWrapper)parcelableArray, (zzu)object);
            parcel.writeNoException();
            parcel.writeTypedArray(parcelableArray, n11);
        }
        return n11 != 0;
    }
}

