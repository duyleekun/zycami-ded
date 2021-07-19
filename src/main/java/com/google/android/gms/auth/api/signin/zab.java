/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zab
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Object object = parcel;
        int n10 = SafeParcelReader.validateObjectHeader(parcel);
        int n11 = 0;
        Parcelable parcelable = null;
        int n12 = 0;
        Parcelable.Creator creator = null;
        long l10 = 0L;
        String string2 = null;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        Parcelable parcelable2 = null;
        String string6 = null;
        String string7 = null;
        ArrayList arrayList = null;
        String string8 = null;
        String string9 = null;
        int n13 = 0;
        long l11 = l10;
        block14: while ((n11 = parcel.dataPosition()) < n10) {
            n11 = SafeParcelReader.readHeader(parcel);
            n12 = SafeParcelReader.getFieldId(n11);
            switch (n12) {
                default: {
                    SafeParcelReader.skipUnknownField(object, n11);
                    continue block14;
                }
                case 12: {
                    string9 = SafeParcelReader.createString(object, n11);
                    continue block14;
                }
                case 11: {
                    string8 = SafeParcelReader.createString(object, n11);
                    continue block14;
                }
                case 10: {
                    creator = Scope.CREATOR;
                    arrayList = SafeParcelReader.createTypedList(object, n11, creator);
                    continue block14;
                }
                case 9: {
                    string7 = SafeParcelReader.createString(object, n11);
                    continue block14;
                }
                case 8: {
                    l11 = SafeParcelReader.readLong(object, n11);
                    continue block14;
                }
                case 7: {
                    string6 = SafeParcelReader.createString(object, n11);
                    continue block14;
                }
                case 6: {
                    creator = Uri.CREATOR;
                    parcelable2 = parcelable = SafeParcelReader.createParcelable(object, n11, creator);
                    parcelable2 = (Uri)parcelable;
                    continue block14;
                }
                case 5: {
                    string5 = SafeParcelReader.createString(object, n11);
                    continue block14;
                }
                case 4: {
                    string4 = SafeParcelReader.createString(object, n11);
                    continue block14;
                }
                case 3: {
                    string3 = SafeParcelReader.createString(object, n11);
                    continue block14;
                }
                case 2: {
                    string2 = SafeParcelReader.createString(object, n11);
                    continue block14;
                }
                case 1: 
            }
            n13 = SafeParcelReader.readInt(object, n11);
        }
        SafeParcelReader.ensureAtEnd(object, n10);
        object = new GoogleSignInAccount(n13, string2, string3, string4, string5, (Uri)parcelable2, string6, l11, string7, arrayList, string8, string9);
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new GoogleSignInAccount[n10];
    }
}

