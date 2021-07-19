/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.clearcut.zzc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzd
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel object) {
        int n10;
        int n11 = SafeParcelReader.validateObjectHeader(object);
        long l10 = 0L;
        int n12 = 0;
        long l11 = l10;
        long l12 = l10;
        boolean bl2 = false;
        while ((n10 = object.dataPosition()) < n11) {
            n10 = SafeParcelReader.readHeader(object);
            int n13 = SafeParcelReader.getFieldId(n10);
            if (n13 != (n12 = 1)) {
                n12 = 2;
                if (n13 != n12) {
                    n12 = 3;
                    if (n13 != n12) {
                        SafeParcelReader.skipUnknownField(object, n10);
                        continue;
                    }
                    l11 = SafeParcelReader.readLong(object, n10);
                    continue;
                }
                l12 = SafeParcelReader.readLong(object, n10);
                continue;
            }
            bl2 = SafeParcelReader.readBoolean(object, n10);
        }
        SafeParcelReader.ensureAtEnd(object, n11);
        object = new zzc(bl2, l11, l12);
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new zzc[n10];
    }
}

