/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.vision.barcode.Barcode$CalendarDateTime;
import com.google.android.gms.vision.barcode.Barcode$CalendarEvent;

public final class zzf
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel object) {
        Object object2;
        int n10 = SafeParcelReader.validateObjectHeader(object);
        int n11 = 0;
        Parcelable parcelable = null;
        String string2 = null;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        String string6 = null;
        Parcelable parcelable2 = null;
        Parcelable parcelable3 = null;
        block9: while ((n11 = object.dataPosition()) < n10) {
            n11 = SafeParcelReader.readHeader(object);
            int n12 = SafeParcelReader.getFieldId(n11);
            switch (n12) {
                default: {
                    SafeParcelReader.skipUnknownField(object, n11);
                    continue block9;
                }
                case 8: {
                    object2 = Barcode$CalendarDateTime.CREATOR;
                    parcelable3 = parcelable = SafeParcelReader.createParcelable(object, n11, (Parcelable.Creator)object2);
                    parcelable3 = (Barcode$CalendarDateTime)parcelable;
                    continue block9;
                }
                case 7: {
                    object2 = Barcode$CalendarDateTime.CREATOR;
                    parcelable2 = parcelable = SafeParcelReader.createParcelable(object, n11, (Parcelable.Creator)object2);
                    parcelable2 = (Barcode$CalendarDateTime)parcelable;
                    continue block9;
                }
                case 6: {
                    string6 = SafeParcelReader.createString(object, n11);
                    continue block9;
                }
                case 5: {
                    string5 = SafeParcelReader.createString(object, n11);
                    continue block9;
                }
                case 4: {
                    string4 = SafeParcelReader.createString(object, n11);
                    continue block9;
                }
                case 3: {
                    string3 = SafeParcelReader.createString(object, n11);
                    continue block9;
                }
                case 2: 
            }
            string2 = SafeParcelReader.createString(object, n11);
        }
        SafeParcelReader.ensureAtEnd(object, n10);
        object2 = object;
        object = new Barcode$CalendarEvent(string2, string3, string4, string5, string6, (Barcode$CalendarDateTime)parcelable2, (Barcode$CalendarDateTime)parcelable3);
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new Barcode$CalendarEvent[n10];
    }
}

