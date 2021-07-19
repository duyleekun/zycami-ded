/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zaa
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel object) {
        int n10;
        int n11 = SafeParcelReader.validateObjectHeader(object);
        int n12 = 0;
        Bundle bundle = null;
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
                    bundle = SafeParcelReader.createBundle(object, n10);
                    continue;
                }
                n13 = SafeParcelReader.readInt(object, n10);
                continue;
            }
            n12 = SafeParcelReader.readInt(object, n10);
        }
        SafeParcelReader.ensureAtEnd(object, n11);
        object = new GoogleSignInOptionsExtensionParcelable(n12, n13, bundle);
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new GoogleSignInOptionsExtensionParcelable[n10];
    }
}

