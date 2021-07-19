/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.MlltFrame$1;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class MlltFrame
extends Id3Frame {
    public static final Parcelable.Creator CREATOR;
    public static final String ID = "MLLT";
    public final int bytesBetweenReference;
    public final int[] bytesDeviations;
    public final int millisecondsBetweenReference;
    public final int[] millisecondsDeviations;
    public final int mpegFramesBetweenReference;

    static {
        MlltFrame$1 mlltFrame$1 = new MlltFrame$1();
        CREATOR = mlltFrame$1;
    }

    public MlltFrame(int n10, int n11, int n12, int[] nArray, int[] nArray2) {
        super(ID);
        this.mpegFramesBetweenReference = n10;
        this.bytesBetweenReference = n11;
        this.millisecondsBetweenReference = n12;
        this.bytesDeviations = nArray;
        this.millisecondsDeviations = nArray2;
    }

    public MlltFrame(Parcel object) {
        super(ID);
        int n10;
        this.mpegFramesBetweenReference = n10 = object.readInt();
        this.bytesBetweenReference = n10 = object.readInt();
        this.millisecondsBetweenReference = n10 = object.readInt();
        int[] nArray = (int[])Util.castNonNull(object.createIntArray());
        this.bytesDeviations = nArray;
        object = (int[])Util.castNonNull(object.createIntArray());
        this.millisecondsDeviations = (int[])object;
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
        if (object != null && (object3 = MlltFrame.class) == (object2 = object.getClass())) {
            boolean bl3;
            object = (MlltFrame)object;
            int n10 = this.mpegFramesBetweenReference;
            int n11 = ((MlltFrame)object).mpegFramesBetweenReference;
            if (n10 != n11 || (n10 = this.bytesBetweenReference) != (n11 = ((MlltFrame)object).bytesBetweenReference) || (n10 = this.millisecondsBetweenReference) != (n11 = ((MlltFrame)object).millisecondsBetweenReference) || (n10 = (int)(Arrays.equals((int[])(object3 = (Object)this.bytesDeviations), (int[])(object2 = (Object)((MlltFrame)object).bytesDeviations)) ? 1 : 0)) == 0 || !(bl3 = Arrays.equals((int[])(object3 = (Object)this.millisecondsDeviations), (int[])(object = (Object)((MlltFrame)object).millisecondsDeviations)))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10 = this.mpegFramesBetweenReference;
        int n11 = (527 + n10) * 31;
        n10 = this.bytesBetweenReference;
        n11 = (n11 + n10) * 31;
        n10 = this.millisecondsBetweenReference;
        n11 = (n11 + n10) * 31;
        n10 = Arrays.hashCode(this.bytesDeviations);
        n11 = (n11 + n10) * 31;
        n10 = Arrays.hashCode(this.millisecondsDeviations);
        return n11 + n10;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = this.mpegFramesBetweenReference;
        parcel.writeInt(n10);
        n10 = this.bytesBetweenReference;
        parcel.writeInt(n10);
        n10 = this.millisecondsBetweenReference;
        parcel.writeInt(n10);
        int[] nArray = this.bytesDeviations;
        parcel.writeIntArray(nArray);
        nArray = this.millisecondsDeviations;
        parcel.writeIntArray(nArray);
    }
}

