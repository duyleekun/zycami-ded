/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata$1;
import com.google.common.primitives.Longs;

public final class MotionPhotoMetadata
implements Metadata$Entry {
    public static final Parcelable.Creator CREATOR;
    public final long photoPresentationTimestampUs;
    public final long photoSize;
    public final long photoStartPosition;
    public final long videoSize;
    public final long videoStartPosition;

    static {
        MotionPhotoMetadata$1 motionPhotoMetadata$1 = new MotionPhotoMetadata$1();
        CREATOR = motionPhotoMetadata$1;
    }

    public MotionPhotoMetadata(long l10, long l11, long l12, long l13, long l14) {
        this.photoStartPosition = l10;
        this.photoSize = l11;
        this.photoPresentationTimestampUs = l12;
        this.videoStartPosition = l13;
        this.videoSize = l14;
    }

    private MotionPhotoMetadata(Parcel parcel) {
        long l10;
        this.photoStartPosition = l10 = parcel.readLong();
        this.photoSize = l10 = parcel.readLong();
        this.photoPresentationTimestampUs = l10 = parcel.readLong();
        this.videoStartPosition = l10 = parcel.readLong();
        this.videoSize = l10 = parcel.readLong();
    }

    public /* synthetic */ MotionPhotoMetadata(Parcel parcel, MotionPhotoMetadata$1 motionPhotoMetadata$1) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Class<MotionPhotoMetadata> clazz2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (clazz2 = MotionPhotoMetadata.class) == (clazz = object.getClass())) {
            long l10;
            long l11;
            long l12;
            long l13;
            long l14;
            object = (MotionPhotoMetadata)object;
            long l15 = this.photoStartPosition;
            long l16 = ((MotionPhotoMetadata)object).photoStartPosition;
            long l17 = l15 - l16;
            Object object2 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
            if (object2 != false || (object2 = (l14 = (l15 = this.photoSize) - (l16 = ((MotionPhotoMetadata)object).photoSize)) == 0L ? 0 : (l14 < 0L ? -1 : 1)) != false || (object2 = (l13 = (l15 = this.photoPresentationTimestampUs) - (l16 = ((MotionPhotoMetadata)object).photoPresentationTimestampUs)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false || (object2 = (l12 = (l15 = this.videoStartPosition) - (l16 = ((MotionPhotoMetadata)object).videoStartPosition)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false || (l11 = (l10 = (l15 = this.videoSize) - (l16 = ((MotionPhotoMetadata)object).videoSize)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10 = Longs.hashCode(this.photoStartPosition);
        int n11 = (527 + n10) * 31;
        n10 = Longs.hashCode(this.photoSize);
        n11 = (n11 + n10) * 31;
        n10 = Longs.hashCode(this.photoPresentationTimestampUs);
        n11 = (n11 + n10) * 31;
        n10 = Longs.hashCode(this.videoStartPosition);
        n11 = (n11 + n10) * 31;
        n10 = Longs.hashCode(this.videoSize);
        return n11 + n10;
    }

    public String toString() {
        long l10 = this.photoStartPosition;
        long l11 = this.photoSize;
        long l12 = this.photoPresentationTimestampUs;
        long l13 = this.videoStartPosition;
        long l14 = this.videoSize;
        StringBuilder stringBuilder = new StringBuilder(218);
        stringBuilder.append("Motion photo metadata: photoStartPosition=");
        stringBuilder.append(l10);
        stringBuilder.append(", photoSize=");
        stringBuilder.append(l11);
        stringBuilder.append(", photoPresentationTimestampUs=");
        stringBuilder.append(l12);
        stringBuilder.append(", videoStartPosition=");
        stringBuilder.append(l13);
        stringBuilder.append(", videoSize=");
        stringBuilder.append(l14);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        long l10 = this.photoStartPosition;
        parcel.writeLong(l10);
        l10 = this.photoSize;
        parcel.writeLong(l10);
        l10 = this.photoPresentationTimestampUs;
        parcel.writeLong(l10);
        l10 = this.videoStartPosition;
        parcel.writeLong(l10);
        l10 = this.videoSize;
        parcel.writeLong(l10);
    }
}

