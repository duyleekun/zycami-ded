/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.phenotype.Configuration;
import com.google.android.gms.phenotype.zzi;

public final class zzc
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel object) {
        int n10;
        int n11 = SafeParcelReader.validateObjectHeader(object);
        zzi[] zziArray = null;
        int n12 = 0;
        String[] stringArray = null;
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
                    stringArray = SafeParcelReader.createStringArray(object, n10);
                    continue;
                }
                zziArray = zzi.CREATOR;
                zziArray = (zzi[])SafeParcelReader.createTypedArray(object, n10, (Parcelable.Creator)zziArray);
                continue;
            }
            n12 = SafeParcelReader.readInt(object, n10);
        }
        SafeParcelReader.ensureAtEnd(object, n11);
        object = new Configuration(n12, zziArray, stringArray);
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new Configuration[n10];
    }
}

