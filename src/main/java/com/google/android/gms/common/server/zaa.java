/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.FavaDiagnosticsEntity;

public final class zaa
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel object) {
        int n10;
        int n11 = SafeParcelReader.validateObjectHeader(object);
        int n12 = 0;
        String string2 = null;
        int n13 = 0;
        while ((n10 = object.dataPosition()) < n11) {
            int n14;
            n10 = SafeParcelReader.readHeader(object);
            int n15 = SafeParcelReader.getFieldId(n10);
            if (n15 != (n14 = 1)) {
                n14 = 2;
                if (n15 != n14) {
                    n14 = 3;
                    if (n15 != n14) {
                        SafeParcelReader.skipUnknownField(object, n10);
                        continue;
                    }
                    n13 = SafeParcelReader.readInt(object, n10);
                    continue;
                }
                string2 = SafeParcelReader.createString(object, n10);
                continue;
            }
            n12 = SafeParcelReader.readInt(object, n10);
        }
        SafeParcelReader.ensureAtEnd(object, n11);
        object = new FavaDiagnosticsEntity(n12, string2, n13);
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new FavaDiagnosticsEntity[n10];
    }
}

