/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Point
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.vision.barcode;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.Barcode$CalendarEvent;
import com.google.android.gms.vision.barcode.Barcode$ContactInfo;
import com.google.android.gms.vision.barcode.Barcode$DriverLicense;
import com.google.android.gms.vision.barcode.Barcode$Email;
import com.google.android.gms.vision.barcode.Barcode$GeoPoint;
import com.google.android.gms.vision.barcode.Barcode$Phone;
import com.google.android.gms.vision.barcode.Barcode$Sms;
import com.google.android.gms.vision.barcode.Barcode$UrlBookmark;
import com.google.android.gms.vision.barcode.Barcode$WiFi;

public final class zzb
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Object object = parcel;
        int n10 = SafeParcelReader.validateObjectHeader(parcel);
        int n11 = 0;
        Object[] objectArray = null;
        int n12 = 0;
        Parcelable.Creator creator = null;
        int n13 = 0;
        int n14 = 0;
        boolean bl2 = false;
        String string2 = null;
        String string3 = null;
        Object[] objectArray2 = null;
        Object object2 = null;
        Object object3 = null;
        Object object4 = null;
        Object object5 = null;
        Object object6 = null;
        Object object7 = null;
        Object object8 = null;
        Object object9 = null;
        Object object10 = null;
        byte[] byArray = null;
        block18: while ((n11 = parcel.dataPosition()) < n10) {
            n11 = SafeParcelReader.readHeader(parcel);
            n12 = SafeParcelReader.getFieldId(n11);
            switch (n12) {
                default: {
                    SafeParcelReader.skipUnknownField(object, n11);
                    continue block18;
                }
                case 17: {
                    bl2 = SafeParcelReader.readBoolean(object, n11);
                    continue block18;
                }
                case 16: {
                    byArray = SafeParcelReader.createByteArray(object, n11);
                    continue block18;
                }
                case 15: {
                    creator = Barcode$DriverLicense.CREATOR;
                    object10 = objectArray = SafeParcelReader.createParcelable(object, n11, creator);
                    object10 = (Barcode$DriverLicense)objectArray;
                    continue block18;
                }
                case 14: {
                    creator = Barcode$ContactInfo.CREATOR;
                    object9 = objectArray = SafeParcelReader.createParcelable(object, n11, creator);
                    object9 = (Barcode$ContactInfo)objectArray;
                    continue block18;
                }
                case 13: {
                    creator = Barcode$CalendarEvent.CREATOR;
                    object8 = objectArray = SafeParcelReader.createParcelable(object, n11, creator);
                    object8 = (Barcode$CalendarEvent)objectArray;
                    continue block18;
                }
                case 12: {
                    creator = Barcode$GeoPoint.CREATOR;
                    object7 = objectArray = SafeParcelReader.createParcelable(object, n11, creator);
                    object7 = (Barcode$GeoPoint)objectArray;
                    continue block18;
                }
                case 11: {
                    creator = Barcode$UrlBookmark.CREATOR;
                    object6 = objectArray = SafeParcelReader.createParcelable(object, n11, creator);
                    object6 = (Barcode$UrlBookmark)objectArray;
                    continue block18;
                }
                case 10: {
                    creator = Barcode$WiFi.CREATOR;
                    object5 = objectArray = SafeParcelReader.createParcelable(object, n11, creator);
                    object5 = (Barcode$WiFi)objectArray;
                    continue block18;
                }
                case 9: {
                    creator = Barcode$Sms.CREATOR;
                    object4 = objectArray = SafeParcelReader.createParcelable(object, n11, creator);
                    object4 = (Barcode$Sms)objectArray;
                    continue block18;
                }
                case 8: {
                    creator = Barcode$Phone.CREATOR;
                    object3 = objectArray = SafeParcelReader.createParcelable(object, n11, creator);
                    object3 = (Barcode$Phone)objectArray;
                    continue block18;
                }
                case 7: {
                    creator = Barcode$Email.CREATOR;
                    object2 = objectArray = SafeParcelReader.createParcelable(object, n11, creator);
                    object2 = (Barcode$Email)objectArray;
                    continue block18;
                }
                case 6: {
                    creator = Point.CREATOR;
                    objectArray2 = objectArray = SafeParcelReader.createTypedArray(object, n11, creator);
                    objectArray2 = (Point[])objectArray;
                    continue block18;
                }
                case 5: {
                    n14 = SafeParcelReader.readInt(object, n11);
                    continue block18;
                }
                case 4: {
                    string3 = SafeParcelReader.createString(object, n11);
                    continue block18;
                }
                case 3: {
                    string2 = SafeParcelReader.createString(object, n11);
                    continue block18;
                }
                case 2: 
            }
            n13 = SafeParcelReader.readInt(object, n11);
        }
        SafeParcelReader.ensureAtEnd(object, n10);
        object = new Barcode(n13, string2, string3, n14, (Point[])objectArray2, (Barcode$Email)object2, (Barcode$Phone)object3, (Barcode$Sms)object4, (Barcode$WiFi)object5, (Barcode$UrlBookmark)object6, (Barcode$GeoPoint)object7, (Barcode$CalendarEvent)object8, (Barcode$ContactInfo)object9, (Barcode$DriverLicense)object10, byArray, bl2);
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new Barcode[n10];
    }
}

