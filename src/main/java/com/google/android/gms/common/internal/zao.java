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
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.SignInButtonConfig;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zao
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel object) {
        int n10;
        int n11 = SafeParcelReader.validateObjectHeader(object);
        int n12 = 0;
        int n13 = 0;
        Scope[] scopeArray = null;
        int n14 = 0;
        while ((n10 = object.dataPosition()) < n11) {
            int n15;
            n10 = SafeParcelReader.readHeader(object);
            int n16 = SafeParcelReader.getFieldId(n10);
            if (n16 != (n15 = 1)) {
                n15 = 2;
                if (n16 != n15) {
                    n15 = 3;
                    if (n16 != n15) {
                        n15 = 4;
                        if (n16 != n15) {
                            SafeParcelReader.skipUnknownField(object, n10);
                            continue;
                        }
                        scopeArray = Scope.CREATOR;
                        scopeArray = (Scope[])SafeParcelReader.createTypedArray(object, n10, (Parcelable.Creator)scopeArray);
                        continue;
                    }
                    n13 = SafeParcelReader.readInt(object, n10);
                    continue;
                }
                n14 = SafeParcelReader.readInt(object, n10);
                continue;
            }
            n12 = SafeParcelReader.readInt(object, n10);
        }
        SafeParcelReader.ensureAtEnd(object, n11);
        object = new SignInButtonConfig(n12, n14, n13, scopeArray);
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new SignInButtonConfig[n10];
    }
}

