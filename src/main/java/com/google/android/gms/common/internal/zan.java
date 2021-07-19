/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zan
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel object) {
        int n10 = SafeParcelReader.validateObjectHeader(object);
        int n11 = 0;
        Parcelable parcelable = null;
        int n12 = 0;
        Parcelable.Creator creator = null;
        IBinder iBinder = null;
        Parcelable parcelable2 = null;
        int n13 = 0;
        boolean bl2 = false;
        boolean bl3 = false;
        while ((n11 = object.dataPosition()) < n10) {
            int n14;
            n11 = SafeParcelReader.readHeader(object);
            n12 = SafeParcelReader.getFieldId(n11);
            if (n12 != (n14 = 1)) {
                n14 = 2;
                if (n12 != n14) {
                    n14 = 3;
                    if (n12 != n14) {
                        n14 = 4;
                        if (n12 != n14) {
                            n14 = 5;
                            if (n12 != n14) {
                                SafeParcelReader.skipUnknownField(object, n11);
                                continue;
                            }
                            bl3 = SafeParcelReader.readBoolean(object, n11);
                            continue;
                        }
                        bl2 = SafeParcelReader.readBoolean(object, n11);
                        continue;
                    }
                    creator = ConnectionResult.CREATOR;
                    parcelable2 = parcelable = SafeParcelReader.createParcelable(object, n11, creator);
                    parcelable2 = (ConnectionResult)parcelable;
                    continue;
                }
                iBinder = SafeParcelReader.readIBinder(object, n11);
                continue;
            }
            n13 = SafeParcelReader.readInt(object, n11);
        }
        SafeParcelReader.ensureAtEnd(object, n10);
        object = new ResolveAccountResponse(n13, iBinder, (ConnectionResult)parcelable2, bl2, bl3);
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new ResolveAccountResponse[n10];
    }
}

