/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.ParcelableVolumeInfo$1;

public class ParcelableVolumeInfo
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public int audioStream;
    public int controlType;
    public int currentVolume;
    public int maxVolume;
    public int volumeType;

    static {
        ParcelableVolumeInfo$1 parcelableVolumeInfo$1 = new ParcelableVolumeInfo$1();
        CREATOR = parcelableVolumeInfo$1;
    }

    public ParcelableVolumeInfo(int n10, int n11, int n12, int n13, int n14) {
        this.volumeType = n10;
        this.audioStream = n11;
        this.controlType = n12;
        this.maxVolume = n13;
        this.currentVolume = n14;
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        int n10;
        int n11;
        this.volumeType = n11 = parcel.readInt();
        this.controlType = n11 = parcel.readInt();
        this.maxVolume = n11 = parcel.readInt();
        this.currentVolume = n11 = parcel.readInt();
        this.audioStream = n10 = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = this.volumeType;
        parcel.writeInt(n10);
        n10 = this.controlType;
        parcel.writeInt(n10);
        n10 = this.maxVolume;
        parcel.writeInt(n10);
        n10 = this.currentVolume;
        parcel.writeInt(n10);
        n10 = this.audioStream;
        parcel.writeInt(n10);
    }
}

