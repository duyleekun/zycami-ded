/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zaa
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel object) {
        int n10 = SafeParcelReader.validateObjectHeader(object);
        int n11 = 0;
        Scope[] scopeArray = null;
        int n12 = 0;
        Parcelable.Creator creator = null;
        IBinder iBinder = null;
        Scope[] scopeArray2 = null;
        Integer n13 = null;
        Integer n14 = null;
        Scope[] scopeArray3 = null;
        int n15 = 0;
        block8: while ((n11 = object.dataPosition()) < n10) {
            n11 = SafeParcelReader.readHeader(object);
            n12 = SafeParcelReader.getFieldId(n11);
            switch (n12) {
                default: {
                    SafeParcelReader.skipUnknownField(object, n11);
                    continue block8;
                }
                case 6: {
                    creator = Account.CREATOR;
                    scopeArray3 = scopeArray = SafeParcelReader.createParcelable(object, n11, creator);
                    scopeArray3 = scopeArray;
                    continue block8;
                }
                case 5: {
                    n14 = SafeParcelReader.readIntegerObject(object, n11);
                    continue block8;
                }
                case 4: {
                    n13 = SafeParcelReader.readIntegerObject(object, n11);
                    continue block8;
                }
                case 3: {
                    creator = Scope.CREATOR;
                    scopeArray2 = scopeArray = SafeParcelReader.createTypedArray(object, n11, creator);
                    scopeArray2 = scopeArray;
                    continue block8;
                }
                case 2: {
                    iBinder = SafeParcelReader.readIBinder(object, n11);
                    continue block8;
                }
                case 1: 
            }
            n15 = SafeParcelReader.readInt(object, n11);
        }
        SafeParcelReader.ensureAtEnd(object, n10);
        object = new AuthAccountRequest(n15, iBinder, scopeArray2, n13, n14, (Account)scopeArray3);
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new AuthAccountRequest[n10];
    }
}

