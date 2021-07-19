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
import com.google.android.gms.vision.barcode.Barcode$WiFi;

public final class zzm
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel object) {
        int n10;
        int n11 = SafeParcelReader.validateObjectHeader(object);
        String string2 = null;
        int n12 = 0;
        String string3 = null;
        while ((n10 = object.dataPosition()) < n11) {
            int n13;
            n10 = SafeParcelReader.readHeader(object);
            int n14 = SafeParcelReader.getFieldId(n10);
            if (n14 != (n13 = 2)) {
                n13 = 3;
                if (n14 != n13) {
                    n13 = 4;
                    if (n14 != n13) {
                        SafeParcelReader.skipUnknownField(object, n10);
                        continue;
                    }
                    n12 = SafeParcelReader.readInt(object, n10);
                    continue;
                }
                string3 = SafeParcelReader.createString(object, n10);
                continue;
            }
            string2 = SafeParcelReader.createString(object, n10);
        }
        SafeParcelReader.ensureAtEnd(object, n11);
        object = new Barcode$WiFi(string2, string3, n12);
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new Barcode$WiFi[n10];
    }
}

