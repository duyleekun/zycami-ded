/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.vision.zzab;

public final class zzaa
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel object) {
        int n10 = SafeParcelReader.validateObjectHeader(object);
        int n11 = 0;
        int n12 = 0;
        int n13 = 0;
        int n14 = 0;
        int n15 = 0;
        int n16 = 0;
        float f10 = 0.0f;
        while ((n11 = object.dataPosition()) < n10) {
            int n17;
            n11 = SafeParcelReader.readHeader(object);
            n12 = SafeParcelReader.getFieldId(n11);
            if (n12 != (n17 = 2)) {
                n17 = 3;
                if (n12 != n17) {
                    n17 = 4;
                    if (n12 != n17) {
                        n17 = 5;
                        if (n12 != n17) {
                            n17 = 6;
                            if (n12 != n17) {
                                SafeParcelReader.skipUnknownField(object, n11);
                                continue;
                            }
                            f10 = SafeParcelReader.readFloat(object, n11);
                            continue;
                        }
                        n16 = SafeParcelReader.readInt(object, n11);
                        continue;
                    }
                    n15 = SafeParcelReader.readInt(object, n11);
                    continue;
                }
                n14 = SafeParcelReader.readInt(object, n11);
                continue;
            }
            n13 = SafeParcelReader.readInt(object, n11);
        }
        SafeParcelReader.ensureAtEnd(object, n10);
        object = new zzab(n13, n14, n15, n16, f10);
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new zzab[n10];
    }
}

