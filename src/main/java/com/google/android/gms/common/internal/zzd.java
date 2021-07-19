/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzd
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Object object = parcel;
        int n10 = SafeParcelReader.validateObjectHeader(parcel);
        int n11 = 0;
        Scope[] scopeArray = null;
        int n12 = 0;
        Parcelable.Creator creator = null;
        int n13 = 0;
        int n14 = 0;
        int n15 = 0;
        boolean bl2 = false;
        int n16 = 0;
        String string2 = null;
        IBinder iBinder = null;
        Scope[] scopeArray2 = null;
        Bundle bundle = null;
        Scope[] scopeArray3 = null;
        Scope[] scopeArray4 = null;
        Scope[] scopeArray5 = null;
        block14: while ((n11 = parcel.dataPosition()) < n10) {
            n11 = SafeParcelReader.readHeader(parcel);
            n12 = SafeParcelReader.getFieldId(n11);
            switch (n12) {
                default: {
                    SafeParcelReader.skipUnknownField(object, n11);
                    continue block14;
                }
                case 13: {
                    n16 = SafeParcelReader.readInt(object, n11);
                    continue block14;
                }
                case 12: {
                    bl2 = SafeParcelReader.readBoolean(object, n11);
                    continue block14;
                }
                case 11: {
                    creator = Feature.CREATOR;
                    scopeArray5 = scopeArray = SafeParcelReader.createTypedArray(object, n11, creator);
                    scopeArray5 = (Feature[])scopeArray;
                    continue block14;
                }
                case 10: {
                    creator = Feature.CREATOR;
                    scopeArray4 = scopeArray = SafeParcelReader.createTypedArray(object, n11, creator);
                    scopeArray4 = (Feature[])scopeArray;
                    continue block14;
                }
                case 8: {
                    creator = Account.CREATOR;
                    scopeArray3 = scopeArray = SafeParcelReader.createParcelable(object, n11, creator);
                    scopeArray3 = scopeArray;
                    continue block14;
                }
                case 7: {
                    bundle = SafeParcelReader.createBundle(object, n11);
                    continue block14;
                }
                case 6: {
                    creator = Scope.CREATOR;
                    scopeArray2 = scopeArray = SafeParcelReader.createTypedArray(object, n11, creator);
                    scopeArray2 = scopeArray;
                    continue block14;
                }
                case 5: {
                    iBinder = SafeParcelReader.readIBinder(object, n11);
                    continue block14;
                }
                case 4: {
                    string2 = SafeParcelReader.createString(object, n11);
                    continue block14;
                }
                case 3: {
                    n15 = SafeParcelReader.readInt(object, n11);
                    continue block14;
                }
                case 2: {
                    n14 = SafeParcelReader.readInt(object, n11);
                    continue block14;
                }
                case 1: 
            }
            n13 = SafeParcelReader.readInt(object, n11);
        }
        SafeParcelReader.ensureAtEnd(object, n10);
        object = new GetServiceRequest(n13, n14, n15, string2, iBinder, scopeArray2, bundle, (Account)scopeArray3, (Feature[])scopeArray4, (Feature[])scopeArray5, bl2, n16);
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new GetServiceRequest[n10];
    }
}

