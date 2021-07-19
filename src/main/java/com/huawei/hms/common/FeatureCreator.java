/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.huawei.hms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.Feature;
import com.huawei.hms.common.internal.safeparcel.SafeParcelReader;

public final class FeatureCreator
implements Parcelable.Creator {
    public final Feature createFromParcel(Parcel object) {
        int n10;
        long l10;
        int n11 = SafeParcelReader.validateObjectHeader(object);
        long l11 = l10 = (long)-1;
        String string2 = null;
        int n12 = 0;
        for (int i10 = 0; i10 <= n11 && (n10 = object.dataPosition()) < n11; ++i10) {
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
                    l11 = SafeParcelReader.readLong(object, n10);
                    continue;
                }
                n12 = SafeParcelReader.readInt(object, n10);
                continue;
            }
            string2 = SafeParcelReader.createString(object, n10);
        }
        SafeParcelReader.ensureAtEnd(object, n11);
        object = new Feature(string2, n12, l11);
        return object;
    }

    public final Feature[] newArray(int n10) {
        return new Feature[n10];
    }
}

