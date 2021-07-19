/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.signin.internal.zaj;

public final class zak
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel object) {
        int n10;
        int n11 = SafeParcelReader.validateObjectHeader(object);
        Object object2 = null;
        int n12 = 0;
        Object object3 = null;
        while ((n10 = object.dataPosition()) < n11) {
            int n13;
            n10 = SafeParcelReader.readHeader(object);
            int n14 = SafeParcelReader.getFieldId(n10);
            if (n14 != (n13 = 1)) {
                n13 = 2;
                if (n14 != n13) {
                    n13 = 3;
                    if (n14 != n13) {
                        SafeParcelReader.skipUnknownField(object, n10);
                        continue;
                    }
                    object3 = ResolveAccountResponse.CREATOR;
                    object3 = (ResolveAccountResponse)SafeParcelReader.createParcelable(object, n10, object3);
                    continue;
                }
                object2 = ConnectionResult.CREATOR;
                object2 = (ConnectionResult)SafeParcelReader.createParcelable(object, n10, object2);
                continue;
            }
            n12 = SafeParcelReader.readInt(object, n10);
        }
        SafeParcelReader.ensureAtEnd(object, n11);
        object = new zaj(n12, (ConnectionResult)object2, (ResolveAccountResponse)object3);
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new zaj[n10];
    }
}

