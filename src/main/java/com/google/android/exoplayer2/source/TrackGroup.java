/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup$1;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;

public final class TrackGroup
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private final Format[] formats;
    private int hashCode;
    public final int length;

    static {
        TrackGroup$1 trackGroup$1 = new TrackGroup$1();
        CREATOR = trackGroup$1;
    }

    public TrackGroup(Parcel parcel) {
        int n10;
        int n11;
        this.length = n11 = parcel.readInt();
        Format[] formatArray = new Format[n11];
        this.formats = formatArray;
        formatArray = null;
        for (n11 = 0; n11 < (n10 = this.length); ++n11) {
            Format[] formatArray2 = this.formats;
            Object object = Format.class.getClassLoader();
            formatArray2[n11] = object = (Format)parcel.readParcelable((ClassLoader)object);
        }
    }

    public TrackGroup(Format ... formatArray) {
        int n10;
        boolean bl2 = formatArray.length;
        bl2 = bl2 > false;
        Assertions.checkState(bl2);
        this.formats = formatArray;
        this.length = n10 = formatArray.length;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object objectArray) {
        Class<?> clazz;
        Object[] objectArray2;
        boolean bl2 = true;
        if (this == objectArray) {
            return bl2;
        }
        if (objectArray != null && (objectArray2 = TrackGroup.class) == (clazz = objectArray.getClass())) {
            boolean bl3;
            objectArray = (TrackGroup)objectArray;
            int n10 = this.length;
            int n11 = objectArray.length;
            if (n10 != n11 || !(bl3 = Arrays.equals(objectArray2 = this.formats, objectArray = objectArray.formats))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public Format getFormat(int n10) {
        return this.formats[n10];
    }

    public int hashCode() {
        int n10 = this.hashCode;
        if (n10 == 0) {
            Object[] objectArray = this.formats;
            int n11 = Arrays.hashCode(objectArray);
            this.hashCode = n10 = 527 + n11;
        }
        return this.hashCode;
    }

    public int indexOf(Format format) {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((Format[])(object = this.formats)).length); ++i10) {
            if (format != (object = object[i10])) continue;
            return i10;
        }
        return -1;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        int n11;
        n10 = this.length;
        parcel.writeInt(n10);
        n10 = 0;
        for (int i10 = 0; i10 < (n11 = this.length); ++i10) {
            Format format = this.formats[i10];
            parcel.writeParcelable((Parcelable)format, 0);
        }
    }
}

