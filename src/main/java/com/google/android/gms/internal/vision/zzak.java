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
import com.google.android.gms.internal.vision.zzal;

public final class zzak
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel object) {
        int n10;
        int n11 = SafeParcelReader.validateObjectHeader(object);
        while ((n10 = object.dataPosition()) < n11) {
            n10 = SafeParcelReader.readHeader(object);
            SafeParcelReader.getFieldId(n10);
            SafeParcelReader.skipUnknownField(object, n10);
        }
        SafeParcelReader.ensureAtEnd(object, n11);
        object = new zzal();
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new zzal[n10];
    }
}

