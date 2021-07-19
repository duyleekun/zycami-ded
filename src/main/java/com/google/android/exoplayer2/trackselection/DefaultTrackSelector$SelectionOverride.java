/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.trackselection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$SelectionOverride$1;
import java.util.Arrays;

public final class DefaultTrackSelector$SelectionOverride
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public final int data;
    public final int groupIndex;
    public final int length;
    public final int reason;
    public final int[] tracks;

    static {
        DefaultTrackSelector$SelectionOverride$1 defaultTrackSelector$SelectionOverride$1 = new DefaultTrackSelector$SelectionOverride$1();
        CREATOR = defaultTrackSelector$SelectionOverride$1;
    }

    public DefaultTrackSelector$SelectionOverride(int n10, int ... nArray) {
        this(n10, nArray, 2, 0);
    }

    public DefaultTrackSelector$SelectionOverride(int n10, int[] nArray, int n11, int n12) {
        int n13;
        this.groupIndex = n10;
        n10 = nArray.length;
        int[] nArray2 = Arrays.copyOf(nArray, n10);
        this.tracks = nArray2;
        this.length = n13 = nArray.length;
        this.reason = n11;
        this.data = n12;
        Arrays.sort(nArray2);
    }

    public DefaultTrackSelector$SelectionOverride(Parcel parcel) {
        int n10;
        int n11;
        this.groupIndex = n11 = parcel.readInt();
        this.length = n11 = (int)parcel.readByte();
        int[] nArray = new int[n11];
        this.tracks = nArray;
        parcel.readIntArray(nArray);
        this.reason = n11 = parcel.readInt();
        this.data = n10 = parcel.readInt();
    }

    public boolean containsTrack(int n10) {
        for (int n11 : this.tracks) {
            if (n11 != n10) continue;
            return true;
        }
        return false;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = DefaultTrackSelector$SelectionOverride.class) == (object2 = object.getClass())) {
            int n10;
            object = (DefaultTrackSelector$SelectionOverride)object;
            int n11 = this.groupIndex;
            int n12 = ((DefaultTrackSelector$SelectionOverride)object).groupIndex;
            if (n11 != n12 || (n11 = (int)(Arrays.equals((int[])(object3 = (Object)this.tracks), (int[])(object2 = (Object)((DefaultTrackSelector$SelectionOverride)object).tracks)) ? 1 : 0)) == 0 || (n11 = this.reason) != (n12 = ((DefaultTrackSelector$SelectionOverride)object).reason) || (n11 = this.data) != (n10 = ((DefaultTrackSelector$SelectionOverride)object).data)) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10 = this.groupIndex * 31;
        int n11 = Arrays.hashCode(this.tracks);
        n10 = (n10 + n11) * 31;
        n11 = this.reason;
        n10 = (n10 + n11) * 31;
        n11 = this.data;
        return n10 + n11;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = this.groupIndex;
        parcel.writeInt(n10);
        n10 = this.tracks.length;
        parcel.writeInt(n10);
        int[] nArray = this.tracks;
        parcel.writeIntArray(nArray);
        n10 = this.reason;
        parcel.writeInt(n10);
        n10 = this.data;
        parcel.writeInt(n10);
    }
}

