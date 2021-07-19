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
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray$1;
import java.util.Arrays;

public final class TrackGroupArray
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public static final TrackGroupArray EMPTY;
    private int hashCode;
    public final int length;
    private final TrackGroup[] trackGroups;

    static {
        TrackGroup[] trackGroupArray = new TrackGroup[]{};
        Object object = new TrackGroupArray(trackGroupArray);
        EMPTY = object;
        object = new TrackGroupArray$1();
        CREATOR = object;
    }

    public TrackGroupArray(Parcel parcel) {
        int n10;
        int n11;
        this.length = n11 = parcel.readInt();
        TrackGroup[] trackGroupArray = new TrackGroup[n11];
        this.trackGroups = trackGroupArray;
        trackGroupArray = null;
        for (n11 = 0; n11 < (n10 = this.length); ++n11) {
            TrackGroup[] trackGroupArray2 = this.trackGroups;
            Object object = TrackGroup.class.getClassLoader();
            trackGroupArray2[n11] = object = (TrackGroup)parcel.readParcelable((ClassLoader)object);
        }
    }

    public TrackGroupArray(TrackGroup ... trackGroupArray) {
        int n10;
        this.trackGroups = trackGroupArray;
        this.length = n10 = trackGroupArray.length;
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
        if (objectArray != null && (objectArray2 = TrackGroupArray.class) == (clazz = objectArray.getClass())) {
            boolean bl3;
            objectArray = (TrackGroupArray)objectArray;
            int n10 = this.length;
            int n11 = objectArray.length;
            if (n10 != n11 || !(bl3 = Arrays.equals(objectArray2 = this.trackGroups, objectArray = objectArray.trackGroups))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public TrackGroup get(int n10) {
        return this.trackGroups[n10];
    }

    public int hashCode() {
        int n10 = this.hashCode;
        if (n10 == 0) {
            Object[] objectArray = this.trackGroups;
            this.hashCode = n10 = Arrays.hashCode(objectArray);
        }
        return this.hashCode;
    }

    public int indexOf(TrackGroup trackGroup) {
        int n10;
        for (int i10 = 0; i10 < (n10 = this.length); ++i10) {
            TrackGroup trackGroup2 = this.trackGroups[i10];
            if (trackGroup2 != trackGroup) continue;
            return i10;
        }
        return -1;
    }

    public boolean isEmpty() {
        int n10 = this.length;
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        int n11;
        n10 = this.length;
        parcel.writeInt(n10);
        n10 = 0;
        for (int i10 = 0; i10 < (n11 = this.length); ++i10) {
            TrackGroup trackGroup = this.trackGroups[i10];
            parcel.writeParcelable((Parcelable)trackGroup, 0);
        }
    }
}

