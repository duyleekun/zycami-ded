/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.internal.vision;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.vision.zzaj;

public final class zzai
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel object) {
        int n10;
        int n11 = SafeParcelReader.validateObjectHeader(object);
        Parcelable.Creator creator = null;
        while ((n10 = object.dataPosition()) < n11) {
            int n12;
            n10 = SafeParcelReader.readHeader(object);
            int n13 = SafeParcelReader.getFieldId(n10);
            if (n13 != (n12 = 2)) {
                SafeParcelReader.skipUnknownField(object, n10);
                continue;
            }
            creator = Rect.CREATOR;
            creator = (Rect)SafeParcelReader.createParcelable(object, n10, creator);
        }
        SafeParcelReader.ensureAtEnd(object, n11);
        object = new zzaj((Rect)creator);
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new zzaj[n10];
    }
}

