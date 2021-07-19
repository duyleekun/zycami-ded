/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.vision.barcode.Barcode$Address;
import com.google.android.gms.vision.barcode.Barcode$ContactInfo;
import com.google.android.gms.vision.barcode.Barcode$Email;
import com.google.android.gms.vision.barcode.Barcode$PersonName;
import com.google.android.gms.vision.barcode.Barcode$Phone;

public final class zze
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel object) {
        Object object2;
        int n10 = SafeParcelReader.validateObjectHeader(object);
        int n11 = 0;
        Barcode$Address[] barcode$AddressArray = null;
        Object object3 = null;
        String string2 = null;
        String string3 = null;
        AbstractSafeParcelable[] abstractSafeParcelableArray = null;
        AbstractSafeParcelable[] abstractSafeParcelableArray2 = null;
        String[] stringArray = null;
        Barcode$Address[] barcode$AddressArray2 = null;
        block9: while ((n11 = object.dataPosition()) < n10) {
            n11 = SafeParcelReader.readHeader(object);
            int n12 = SafeParcelReader.getFieldId(n11);
            switch (n12) {
                default: {
                    SafeParcelReader.skipUnknownField(object, n11);
                    continue block9;
                }
                case 8: {
                    object2 = Barcode$Address.CREATOR;
                    barcode$AddressArray2 = barcode$AddressArray = SafeParcelReader.createTypedArray(object, n11, (Parcelable.Creator)object2);
                    barcode$AddressArray2 = barcode$AddressArray;
                    continue block9;
                }
                case 7: {
                    stringArray = SafeParcelReader.createStringArray(object, n11);
                    continue block9;
                }
                case 6: {
                    object2 = Barcode$Email.CREATOR;
                    barcode$AddressArray = SafeParcelReader.createTypedArray(object, n11, (Parcelable.Creator)object2);
                    abstractSafeParcelableArray2 = barcode$AddressArray;
                    abstractSafeParcelableArray2 = (Barcode$Email[])barcode$AddressArray;
                    continue block9;
                }
                case 5: {
                    object2 = Barcode$Phone.CREATOR;
                    barcode$AddressArray = SafeParcelReader.createTypedArray(object, n11, (Parcelable.Creator)object2);
                    abstractSafeParcelableArray = barcode$AddressArray;
                    abstractSafeParcelableArray = (Barcode$Phone[])barcode$AddressArray;
                    continue block9;
                }
                case 4: {
                    string3 = SafeParcelReader.createString(object, n11);
                    continue block9;
                }
                case 3: {
                    string2 = SafeParcelReader.createString(object, n11);
                    continue block9;
                }
                case 2: 
            }
            object2 = Barcode$PersonName.CREATOR;
            object3 = barcode$AddressArray = SafeParcelReader.createParcelable(object, n11, (Parcelable.Creator)object2);
            object3 = (Barcode$PersonName)barcode$AddressArray;
        }
        SafeParcelReader.ensureAtEnd(object, n10);
        object2 = object;
        object = new Barcode$ContactInfo((Barcode$PersonName)object3, string2, string3, (Barcode$Phone[])abstractSafeParcelableArray, (Barcode$Email[])abstractSafeParcelableArray2, stringArray, barcode$AddressArray2);
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new Barcode$ContactInfo[n10];
    }
}

