/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.mlkit.vision.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.mlkit.vision.common.internal.VisionImageMetadataParcel;

public final class zze
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel object) {
        int n10 = SafeParcelReader.validateObjectHeader(object);
        int n11 = 0;
        long l10 = 0L;
        int n12 = 0;
        int n13 = 0;
        int n14 = 0;
        int n15 = 0;
        long l11 = l10;
        while ((n11 = object.dataPosition()) < n10) {
            int n16;
            n11 = SafeParcelReader.readHeader(object);
            int n17 = SafeParcelReader.getFieldId(n11);
            if (n17 != (n16 = 1)) {
                n16 = 2;
                if (n17 != n16) {
                    n16 = 3;
                    if (n17 != n16) {
                        n16 = 4;
                        if (n17 != n16) {
                            n16 = 5;
                            if (n17 != n16) {
                                SafeParcelReader.skipUnknownField(object, n11);
                                continue;
                            }
                            n15 = SafeParcelReader.readInt(object, n11);
                            continue;
                        }
                        l11 = SafeParcelReader.readLong(object, n11);
                        continue;
                    }
                    n14 = SafeParcelReader.readInt(object, n11);
                    continue;
                }
                n13 = SafeParcelReader.readInt(object, n11);
                continue;
            }
            n12 = SafeParcelReader.readInt(object, n11);
        }
        SafeParcelReader.ensureAtEnd(object, n10);
        object = new VisionImageMetadataParcel(n12, n13, n14, l11, n15);
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new VisionImageMetadataParcel[n10];
    }
}

