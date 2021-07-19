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
import com.google.android.gms.vision.barcode.Barcode$CalendarDateTime;

public final class zzd
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel object) {
        int n10 = SafeParcelReader.validateObjectHeader(object);
        int n11 = 0;
        int n12 = 0;
        int n13 = 0;
        int n14 = 0;
        int n15 = 0;
        int n16 = 0;
        int n17 = 0;
        int n18 = 0;
        boolean bl2 = false;
        String string2 = null;
        block10: while ((n11 = object.dataPosition()) < n10) {
            n11 = SafeParcelReader.readHeader(object);
            n12 = SafeParcelReader.getFieldId(n11);
            switch (n12) {
                default: {
                    SafeParcelReader.skipUnknownField(object, n11);
                    continue block10;
                }
                case 9: {
                    string2 = SafeParcelReader.createString(object, n11);
                    continue block10;
                }
                case 8: {
                    bl2 = SafeParcelReader.readBoolean(object, n11);
                    continue block10;
                }
                case 7: {
                    n18 = SafeParcelReader.readInt(object, n11);
                    continue block10;
                }
                case 6: {
                    n17 = SafeParcelReader.readInt(object, n11);
                    continue block10;
                }
                case 5: {
                    n16 = SafeParcelReader.readInt(object, n11);
                    continue block10;
                }
                case 4: {
                    n15 = SafeParcelReader.readInt(object, n11);
                    continue block10;
                }
                case 3: {
                    n14 = SafeParcelReader.readInt(object, n11);
                    continue block10;
                }
                case 2: 
            }
            n13 = SafeParcelReader.readInt(object, n11);
        }
        SafeParcelReader.ensureAtEnd(object, n10);
        object = new Barcode$CalendarDateTime(n13, n14, n15, n16, n17, n18, bl2, string2);
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new Barcode$CalendarDateTime[n10];
    }
}

