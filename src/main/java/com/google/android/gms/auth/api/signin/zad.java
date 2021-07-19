/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zad
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel object) {
        int n10 = SafeParcelReader.validateObjectHeader(object);
        int n11 = 0;
        Parcelable parcelable = null;
        int n12 = 0;
        Parcelable.Creator creator = null;
        int n13 = 0;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        ArrayList arrayList = null;
        Parcelable parcelable2 = null;
        String string2 = null;
        String string3 = null;
        ArrayList arrayList2 = null;
        block11: while ((n11 = object.dataPosition()) < n10) {
            n11 = SafeParcelReader.readHeader(object);
            n12 = SafeParcelReader.getFieldId(n11);
            switch (n12) {
                default: {
                    SafeParcelReader.skipUnknownField(object, n11);
                    continue block11;
                }
                case 9: {
                    creator = GoogleSignInOptionsExtensionParcelable.CREATOR;
                    arrayList2 = SafeParcelReader.createTypedList(object, n11, creator);
                    continue block11;
                }
                case 8: {
                    string3 = SafeParcelReader.createString(object, n11);
                    continue block11;
                }
                case 7: {
                    string2 = SafeParcelReader.createString(object, n11);
                    continue block11;
                }
                case 6: {
                    bl4 = SafeParcelReader.readBoolean(object, n11);
                    continue block11;
                }
                case 5: {
                    bl3 = SafeParcelReader.readBoolean(object, n11);
                    continue block11;
                }
                case 4: {
                    bl2 = SafeParcelReader.readBoolean(object, n11);
                    continue block11;
                }
                case 3: {
                    creator = Account.CREATOR;
                    parcelable2 = parcelable = SafeParcelReader.createParcelable(object, n11, creator);
                    parcelable2 = (Account)parcelable;
                    continue block11;
                }
                case 2: {
                    creator = Scope.CREATOR;
                    arrayList = SafeParcelReader.createTypedList(object, n11, creator);
                    continue block11;
                }
                case 1: 
            }
            n13 = SafeParcelReader.readInt(object, n11);
        }
        SafeParcelReader.ensureAtEnd(object, n10);
        object = new GoogleSignInOptions(n13, arrayList, (Account)parcelable2, bl2, bl3, bl4, string2, string3, arrayList2);
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new GoogleSignInOptions[n10];
    }
}

