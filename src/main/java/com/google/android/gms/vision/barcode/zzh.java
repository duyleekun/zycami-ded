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
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.vision.barcode.Barcode$DriverLicense;

public final class zzh
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Object object = parcel;
        int n10 = SafeParcelReader.validateObjectHeader(parcel);
        int n11 = 0;
        String string2 = null;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        String string6 = null;
        String string7 = null;
        String string8 = null;
        String string9 = null;
        String string10 = null;
        String string11 = null;
        String string12 = null;
        String string13 = null;
        String string14 = null;
        String string15 = null;
        block16: while ((n11 = parcel.dataPosition()) < n10) {
            n11 = SafeParcelReader.readHeader(parcel);
            int n12 = SafeParcelReader.getFieldId(n11);
            switch (n12) {
                default: {
                    SafeParcelReader.skipUnknownField(object, n11);
                    continue block16;
                }
                case 15: {
                    string15 = SafeParcelReader.createString(object, n11);
                    continue block16;
                }
                case 14: {
                    string14 = SafeParcelReader.createString(object, n11);
                    continue block16;
                }
                case 13: {
                    string13 = SafeParcelReader.createString(object, n11);
                    continue block16;
                }
                case 12: {
                    string12 = SafeParcelReader.createString(object, n11);
                    continue block16;
                }
                case 11: {
                    string11 = SafeParcelReader.createString(object, n11);
                    continue block16;
                }
                case 10: {
                    string10 = SafeParcelReader.createString(object, n11);
                    continue block16;
                }
                case 9: {
                    string9 = SafeParcelReader.createString(object, n11);
                    continue block16;
                }
                case 8: {
                    string8 = SafeParcelReader.createString(object, n11);
                    continue block16;
                }
                case 7: {
                    string7 = SafeParcelReader.createString(object, n11);
                    continue block16;
                }
                case 6: {
                    string6 = SafeParcelReader.createString(object, n11);
                    continue block16;
                }
                case 5: {
                    string5 = SafeParcelReader.createString(object, n11);
                    continue block16;
                }
                case 4: {
                    string4 = SafeParcelReader.createString(object, n11);
                    continue block16;
                }
                case 3: {
                    string3 = SafeParcelReader.createString(object, n11);
                    continue block16;
                }
                case 2: 
            }
            string2 = SafeParcelReader.createString(object, n11);
        }
        SafeParcelReader.ensureAtEnd(object, n10);
        object = new Barcode$DriverLicense(string2, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, string13, string14, string15);
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new Barcode$DriverLicense[n10];
    }
}

