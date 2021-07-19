/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.vision.face.internal.client;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.vision.face.internal.client.zza;

public final class zzc
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel object) {
        int n10;
        int n11 = SafeParcelReader.validateObjectHeader(object);
        PointF[] pointFArray = null;
        int n12 = 0;
        while ((n10 = object.dataPosition()) < n11) {
            int n13;
            n10 = SafeParcelReader.readHeader(object);
            int n14 = SafeParcelReader.getFieldId(n10);
            if (n14 != (n13 = 2)) {
                n13 = 3;
                if (n14 != n13) {
                    SafeParcelReader.skipUnknownField(object, n10);
                    continue;
                }
                n12 = SafeParcelReader.readInt(object, n10);
                continue;
            }
            pointFArray = PointF.CREATOR;
            pointFArray = (PointF[])SafeParcelReader.createTypedArray(object, n10, (Parcelable.Creator)pointFArray);
        }
        SafeParcelReader.ensureAtEnd(object, n11);
        object = new zza(pointFArray, n12);
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new zza[n10];
    }
}

