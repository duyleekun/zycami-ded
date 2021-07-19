/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Point
 *  android.graphics.Rect
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.vision.barcode;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.vision.barcode.Barcode$CalendarEvent;
import com.google.android.gms.vision.barcode.Barcode$ContactInfo;
import com.google.android.gms.vision.barcode.Barcode$DriverLicense;
import com.google.android.gms.vision.barcode.Barcode$Email;
import com.google.android.gms.vision.barcode.Barcode$GeoPoint;
import com.google.android.gms.vision.barcode.Barcode$Phone;
import com.google.android.gms.vision.barcode.Barcode$Sms;
import com.google.android.gms.vision.barcode.Barcode$UrlBookmark;
import com.google.android.gms.vision.barcode.Barcode$WiFi;
import com.google.android.gms.vision.barcode.zzb;

public class Barcode
extends AbstractSafeParcelable {
    public static final int ALL_FORMATS = 0;
    public static final int AZTEC = 4096;
    public static final int CALENDAR_EVENT = 11;
    public static final int CODABAR = 8;
    public static final int CODE_128 = 1;
    public static final int CODE_39 = 2;
    public static final int CODE_93 = 4;
    public static final int CONTACT_INFO = 1;
    public static final Parcelable.Creator CREATOR;
    public static final int DATA_MATRIX = 16;
    public static final int DRIVER_LICENSE = 12;
    public static final int EAN_13 = 32;
    public static final int EAN_8 = 64;
    public static final int EMAIL = 2;
    public static final int GEO = 10;
    public static final int ISBN = 3;
    public static final int ITF = 128;
    public static final int PDF417 = 2048;
    public static final int PHONE = 4;
    public static final int PRODUCT = 5;
    public static final int QR_CODE = 256;
    public static final int SMS = 6;
    public static final int TEXT = 7;
    public static final int UPC_A = 512;
    public static final int UPC_E = 1024;
    public static final int URL = 8;
    public static final int WIFI = 9;
    public Barcode$CalendarEvent calendarEvent;
    public Barcode$ContactInfo contactInfo;
    public Point[] cornerPoints;
    public String displayValue;
    public Barcode$DriverLicense driverLicense;
    public Barcode$Email email;
    public int format;
    public Barcode$GeoPoint geoPoint;
    public boolean isRecognized;
    public Barcode$Phone phone;
    public byte[] rawBytes;
    public String rawValue;
    public Barcode$Sms sms;
    public Barcode$UrlBookmark url;
    public int valueFormat;
    public Barcode$WiFi wifi;

    static {
        zzb zzb2 = new zzb();
        CREATOR = zzb2;
    }

    public Barcode() {
    }

    public Barcode(int n10, String string2, String string3, int n11, Point[] pointArray, Barcode$Email barcode$Email, Barcode$Phone barcode$Phone, Barcode$Sms barcode$Sms, Barcode$WiFi barcode$WiFi, Barcode$UrlBookmark barcode$UrlBookmark, Barcode$GeoPoint barcode$GeoPoint, Barcode$CalendarEvent barcode$CalendarEvent, Barcode$ContactInfo barcode$ContactInfo, Barcode$DriverLicense barcode$DriverLicense, byte[] byArray, boolean bl2) {
        this.format = n10;
        this.rawValue = string2;
        this.rawBytes = byArray;
        this.displayValue = string3;
        this.valueFormat = n11;
        this.cornerPoints = pointArray;
        this.isRecognized = bl2;
        this.email = barcode$Email;
        this.phone = barcode$Phone;
        this.sms = barcode$Sms;
        this.wifi = barcode$WiFi;
        this.url = barcode$UrlBookmark;
        this.geoPoint = barcode$GeoPoint;
        this.calendarEvent = barcode$CalendarEvent;
        this.contactInfo = barcode$ContactInfo;
        this.driverLicense = barcode$DriverLicense;
    }

    public Rect getBoundingBox() {
        Point point;
        int n10;
        int n11 = -1 << -1;
        int n12 = -1 >>> 1;
        Rect rect = null;
        int n13 = n11;
        int n14 = n12;
        for (int i10 = 0; i10 < (n10 = ((Point[])(point = this.cornerPoints)).length); ++i10) {
            point = point[i10];
            n10 = point.x;
            n14 = Math.min(n14, n10);
            n10 = point.x;
            n11 = Math.max(n11, n10);
            n10 = point.y;
            n12 = Math.min(n12, n10);
            int n15 = point.y;
            n13 = Math.max(n13, n15);
        }
        rect = new Rect(n14, n12, n11, n13);
        return rect;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        int n11 = SafeParcelWriter.beginObjectHeader(parcel);
        int n12 = this.format;
        SafeParcelWriter.writeInt(parcel, 2, n12);
        Object object = this.rawValue;
        SafeParcelWriter.writeString(parcel, 3, (String)object, false);
        object = this.displayValue;
        SafeParcelWriter.writeString(parcel, 4, (String)object, false);
        n12 = this.valueFormat;
        SafeParcelWriter.writeInt(parcel, 5, n12);
        object = this.cornerPoints;
        SafeParcelWriter.writeTypedArray(parcel, 6, (Parcelable[])object, n10, false);
        object = this.email;
        SafeParcelWriter.writeParcelable(parcel, 7, (Parcelable)object, n10, false);
        object = this.phone;
        SafeParcelWriter.writeParcelable(parcel, 8, (Parcelable)object, n10, false);
        object = this.sms;
        SafeParcelWriter.writeParcelable(parcel, 9, (Parcelable)object, n10, false);
        object = this.wifi;
        SafeParcelWriter.writeParcelable(parcel, 10, (Parcelable)object, n10, false);
        object = this.url;
        SafeParcelWriter.writeParcelable(parcel, 11, (Parcelable)object, n10, false);
        object = this.geoPoint;
        SafeParcelWriter.writeParcelable(parcel, 12, (Parcelable)object, n10, false);
        object = this.calendarEvent;
        SafeParcelWriter.writeParcelable(parcel, 13, (Parcelable)object, n10, false);
        object = this.contactInfo;
        SafeParcelWriter.writeParcelable(parcel, 14, (Parcelable)object, n10, false);
        object = this.driverLicense;
        SafeParcelWriter.writeParcelable(parcel, 15, (Parcelable)object, n10, false);
        byte[] byArray = this.rawBytes;
        SafeParcelWriter.writeByteArray(parcel, 16, byArray, false);
        n10 = (int)(this.isRecognized ? 1 : 0);
        SafeParcelWriter.writeBoolean(parcel, 17, n10 != 0);
        SafeParcelWriter.finishObjectHeader(parcel, n11);
    }
}

