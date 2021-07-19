/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.CursorWindow
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.huawei.hms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.data.DataHolder;
import com.huawei.hms.common.internal.safeparcel.SafeParcelReader;

public final class DataHolderCreator
implements Parcelable.Creator {
    public final DataHolder createFromParcel(Parcel object) {
        Object object2;
        int n10 = SafeParcelReader.validateObjectHeader(object);
        int n11 = 0;
        Object[] objectArray = null;
        String[] stringArray = null;
        Object[] objectArray2 = null;
        Bundle bundle = null;
        int n12 = 0;
        int n13 = 0;
        for (int i10 = 0; i10 <= n10 && (n11 = object.dataPosition()) < n10; ++i10) {
            int n14;
            n11 = SafeParcelReader.readHeader(object);
            int n15 = SafeParcelReader.getFieldId(n11);
            if (n15 != (n14 = 1000)) {
                n14 = 1;
                if (n15 != n14) {
                    n14 = 2;
                    if (n15 != n14) {
                        n14 = 3;
                        if (n15 != n14) {
                            n14 = 4;
                            if (n15 != n14) {
                                SafeParcelReader.skipUnknownField(object, n11);
                                continue;
                            }
                            bundle = SafeParcelReader.createBundle(object, n11);
                            continue;
                        }
                        n13 = SafeParcelReader.readInt(object, n11);
                        continue;
                    }
                    object2 = CursorWindow.CREATOR;
                    objectArray2 = objectArray = SafeParcelReader.createTypedArray(object, n11, (Parcelable.Creator)object2);
                    objectArray2 = (CursorWindow[])objectArray;
                    continue;
                }
                stringArray = SafeParcelReader.createStringArray(object, n11);
                continue;
            }
            n12 = SafeParcelReader.readInt(object, n11);
        }
        SafeParcelReader.ensureAtEnd(object, n10);
        object2 = object;
        object = new DataHolder(n12, stringArray, (CursorWindow[])objectArray2, n13, bundle);
        return object;
    }

    public final DataHolder[] newArray(int n10) {
        return new DataHolder[n10];
    }
}

