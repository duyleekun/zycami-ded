/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.zzv;

public final class zzu
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel object) {
        int n10;
        int n11 = SafeParcelReader.validateObjectHeader(object);
        int n12 = 0;
        while ((n10 = object.dataPosition()) < n11) {
            int n13;
            n10 = SafeParcelReader.readHeader(object);
            int n14 = SafeParcelReader.getFieldId(n10);
            if (n14 != (n13 = 1)) {
                SafeParcelReader.skipUnknownField(object, n10);
                continue;
            }
            n12 = SafeParcelReader.readInt(object, n10);
        }
        SafeParcelReader.ensureAtEnd(object, n11);
        object = new zzv(n12);
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new zzv[n10];
    }
}

