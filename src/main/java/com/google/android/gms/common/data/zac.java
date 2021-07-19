/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.CursorWindow
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zac
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel object) {
        int n10 = SafeParcelReader.validateObjectHeader((Parcel)object);
        int n11 = 0;
        Object[] objectArray = null;
        int n12 = 0;
        Parcelable.Creator creator = null;
        int n13 = 0;
        int n14 = 0;
        String[] stringArray = null;
        Object[] objectArray2 = null;
        Bundle bundle = null;
        while ((n11 = object.dataPosition()) < n10) {
            int n15;
            n11 = SafeParcelReader.readHeader((Parcel)object);
            n12 = SafeParcelReader.getFieldId(n11);
            if (n12 != (n15 = 1)) {
                n15 = 2;
                if (n12 != n15) {
                    n15 = 3;
                    if (n12 != n15) {
                        n15 = 4;
                        if (n12 != n15) {
                            n15 = 1000;
                            if (n12 != n15) {
                                SafeParcelReader.skipUnknownField((Parcel)object, n11);
                                continue;
                            }
                            n13 = SafeParcelReader.readInt((Parcel)object, n11);
                            continue;
                        }
                        bundle = SafeParcelReader.createBundle((Parcel)object, n11);
                        continue;
                    }
                    n14 = SafeParcelReader.readInt((Parcel)object, n11);
                    continue;
                }
                creator = CursorWindow.CREATOR;
                objectArray2 = objectArray = SafeParcelReader.createTypedArray((Parcel)object, n11, creator);
                objectArray2 = (CursorWindow[])objectArray;
                continue;
            }
            stringArray = SafeParcelReader.createStringArray((Parcel)object, n11);
        }
        SafeParcelReader.ensureAtEnd((Parcel)object, n10);
        object = new DataHolder(n13, stringArray, (CursorWindow[])objectArray2, n14, bundle);
        ((DataHolder)object).zaca();
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new DataHolder[n10];
    }
}

