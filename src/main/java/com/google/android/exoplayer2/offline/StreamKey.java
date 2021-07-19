/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.offline;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.offline.StreamKey$1;

public final class StreamKey
implements Comparable,
Parcelable {
    public static final Parcelable.Creator CREATOR;
    public final int groupIndex;
    public final int periodIndex;
    public final int trackIndex;

    static {
        StreamKey$1 streamKey$1 = new StreamKey$1();
        CREATOR = streamKey$1;
    }

    public StreamKey(int n10, int n11) {
        this(0, n10, n11);
    }

    public StreamKey(int n10, int n11, int n12) {
        this.periodIndex = n10;
        this.groupIndex = n11;
        this.trackIndex = n12;
    }

    public StreamKey(Parcel parcel) {
        int n10;
        int n11;
        this.periodIndex = n11 = parcel.readInt();
        this.groupIndex = n11 = parcel.readInt();
        this.trackIndex = n10 = parcel.readInt();
    }

    public int compareTo(StreamKey streamKey) {
        int n10 = this.periodIndex;
        int n11 = streamKey.periodIndex;
        if ((n10 -= n11) == 0) {
            n10 = this.groupIndex;
            n11 = streamKey.groupIndex;
            if ((n10 -= n11) == 0) {
                n10 = this.trackIndex;
                int n12 = streamKey.trackIndex;
                n10 -= n12;
            }
        }
        return n10;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Class<StreamKey> clazz2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (clazz2 = StreamKey.class) == (clazz = object.getClass())) {
            int n10;
            object = (StreamKey)object;
            int n11 = this.periodIndex;
            int n12 = ((StreamKey)object).periodIndex;
            if (n11 != n12 || (n11 = this.groupIndex) != (n12 = ((StreamKey)object).groupIndex) || (n11 = this.trackIndex) != (n10 = ((StreamKey)object).trackIndex)) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10 = this.periodIndex * 31;
        int n11 = this.groupIndex;
        n10 = (n10 + n11) * 31;
        n11 = this.trackIndex;
        return n10 + n11;
    }

    public String toString() {
        int n10 = this.periodIndex;
        int n11 = this.groupIndex;
        int n12 = this.trackIndex;
        StringBuilder stringBuilder = new StringBuilder(35);
        stringBuilder.append(n10);
        String string2 = ".";
        stringBuilder.append(string2);
        stringBuilder.append(n11);
        stringBuilder.append(string2);
        stringBuilder.append(n12);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = this.periodIndex;
        parcel.writeInt(n10);
        n10 = this.groupIndex;
        parcel.writeInt(n10);
        n10 = this.trackIndex;
        parcel.writeInt(n10);
    }
}

