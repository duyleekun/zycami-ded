/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.vision.barcode.Barcode$GeoPoint;

public final class zzj
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel object) {
        int n10;
        double d10;
        int n11 = SafeParcelReader.validateObjectHeader(object);
        double d11 = d10 = 0.0;
        while ((n10 = object.dataPosition()) < n11) {
            int n12;
            n10 = SafeParcelReader.readHeader(object);
            int n13 = SafeParcelReader.getFieldId(n10);
            if (n13 != (n12 = 2)) {
                n12 = 3;
                if (n13 != n12) {
                    SafeParcelReader.skipUnknownField(object, n10);
                    continue;
                }
                d11 = SafeParcelReader.readDouble(object, n10);
                continue;
            }
            d10 = SafeParcelReader.readDouble(object, n10);
        }
        SafeParcelReader.ensureAtEnd(object, n11);
        object = new Barcode$GeoPoint(d10, d11);
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new Barcode$GeoPoint[n10];
    }
}

