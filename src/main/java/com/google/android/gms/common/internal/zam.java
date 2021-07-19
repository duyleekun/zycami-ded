/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zam
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel object) {
        int n10;
        int n11 = SafeParcelReader.validateObjectHeader(object);
        Parcelable.Creator creator = null;
        int n12 = 0;
        int n13 = 0;
        Object object2 = null;
        while ((n10 = object.dataPosition()) < n11) {
            int n14;
            n10 = SafeParcelReader.readHeader(object);
            int n15 = SafeParcelReader.getFieldId(n10);
            if (n15 != (n14 = 1)) {
                n14 = 2;
                if (n15 != n14) {
                    n14 = 3;
                    if (n15 != n14) {
                        n14 = 4;
                        if (n15 != n14) {
                            SafeParcelReader.skipUnknownField(object, n10);
                            continue;
                        }
                        object2 = GoogleSignInAccount.CREATOR;
                        object2 = (GoogleSignInAccount)SafeParcelReader.createParcelable(object, n10, object2);
                        continue;
                    }
                    n13 = SafeParcelReader.readInt(object, n10);
                    continue;
                }
                creator = Account.CREATOR;
                creator = (Account)SafeParcelReader.createParcelable(object, n10, creator);
                continue;
            }
            n12 = SafeParcelReader.readInt(object, n10);
        }
        SafeParcelReader.ensureAtEnd(object, n11);
        object = new ResolveAccountRequest(n12, (Account)creator, n13, (GoogleSignInAccount)object2);
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new ResolveAccountRequest[n10];
    }
}

