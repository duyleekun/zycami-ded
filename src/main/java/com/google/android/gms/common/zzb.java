/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzb
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel object) {
        int n10;
        int n11 = SafeParcelReader.validateObjectHeader(object);
        String string2 = null;
        int n12 = 0;
        long l10 = -1;
        while ((n10 = object.dataPosition()) < n11) {
            int n13;
            n10 = SafeParcelReader.readHeader(object);
            int n14 = SafeParcelReader.getFieldId(n10);
            if (n14 != (n13 = 1)) {
                n13 = 2;
                if (n14 != n13) {
                    n13 = 3;
                    if (n14 != n13) {
                        SafeParcelReader.skipUnknownField(object, n10);
                        continue;
                    }
                    l10 = SafeParcelReader.readLong(object, n10);
                    continue;
                }
                n12 = SafeParcelReader.readInt(object, n10);
                continue;
            }
            string2 = SafeParcelReader.createString(object, n10);
        }
        SafeParcelReader.ensureAtEnd(object, n11);
        object = new Feature(string2, n12, l10);
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new Feature[n10];
    }
}

