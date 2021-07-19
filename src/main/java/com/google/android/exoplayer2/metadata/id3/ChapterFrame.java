/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.id3.ChapterFrame$1;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class ChapterFrame
extends Id3Frame {
    public static final Parcelable.Creator CREATOR;
    public static final String ID = "CHAP";
    public final String chapterId;
    public final long endOffset;
    public final int endTimeMs;
    public final long startOffset;
    public final int startTimeMs;
    private final Id3Frame[] subFrames;

    static {
        ChapterFrame$1 chapterFrame$1 = new ChapterFrame$1();
        CREATOR = chapterFrame$1;
    }

    public ChapterFrame(Parcel parcel) {
        super(ID);
        long l10;
        int n10;
        String string2;
        this.chapterId = string2 = (String)Util.castNonNull(parcel.readString());
        this.startTimeMs = n10 = parcel.readInt();
        this.endTimeMs = n10 = parcel.readInt();
        this.startOffset = l10 = parcel.readLong();
        this.endOffset = l10 = parcel.readLong();
        n10 = parcel.readInt();
        Id3Frame[] id3FrameArray = new Id3Frame[n10];
        this.subFrames = id3FrameArray;
        id3FrameArray = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            Id3Frame[] id3FrameArray2 = this.subFrames;
            Object object = Id3Frame.class.getClassLoader();
            id3FrameArray2[i10] = object = (Id3Frame)parcel.readParcelable((ClassLoader)object);
        }
    }

    public ChapterFrame(String string2, int n10, int n11, long l10, long l11, Id3Frame[] id3FrameArray) {
        super(ID);
        this.chapterId = string2;
        this.startTimeMs = n10;
        this.endTimeMs = n11;
        this.startOffset = l10;
        this.endOffset = l11;
        this.subFrames = id3FrameArray;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object objectArray) {
        Object object;
        Object[] objectArray2;
        boolean bl2 = true;
        if (this == objectArray) {
            return bl2;
        }
        if (objectArray != null && (objectArray2 = ChapterFrame.class) == (object = objectArray.getClass())) {
            boolean bl3;
            long l10;
            long l11;
            long l12;
            long l13;
            objectArray = (ChapterFrame)objectArray;
            int n10 = this.startTimeMs;
            int n11 = objectArray.startTimeMs;
            if (n10 != n11 || (n10 = this.endTimeMs) != (n11 = objectArray.endTimeMs) || (n10 = (int)((l13 = (l12 = this.startOffset) - (l11 = objectArray.startOffset)) == 0L ? 0 : (l13 < 0L ? -1 : 1))) != 0 || (n10 = (int)((l10 = (l12 = this.endOffset) - (l11 = objectArray.endOffset)) == 0L ? 0 : (l10 < 0L ? -1 : 1))) != 0 || (n10 = (int)(Util.areEqual(objectArray2 = this.chapterId, object = objectArray.chapterId) ? 1 : 0)) == 0 || !(bl3 = Arrays.equals(objectArray2 = this.subFrames, objectArray = objectArray.subFrames))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public Id3Frame getSubFrame(int n10) {
        return this.subFrames[n10];
    }

    public int getSubFrameCount() {
        return this.subFrames.length;
    }

    public int hashCode() {
        int n10 = this.startTimeMs;
        int n11 = (527 + n10) * 31;
        n10 = this.endTimeMs;
        n11 = (n11 + n10) * 31;
        n10 = (int)this.startOffset;
        n11 = (n11 + n10) * 31;
        long l10 = this.endOffset;
        n10 = (int)l10;
        n11 = (n11 + n10) * 31;
        String string2 = this.chapterId;
        if (string2 != null) {
            n10 = string2.hashCode();
        } else {
            n10 = 0;
            string2 = null;
        }
        return n11 + n10;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        Id3Frame[] id3FrameArray = this.chapterId;
        parcel.writeString((String)id3FrameArray);
        n10 = this.startTimeMs;
        parcel.writeInt(n10);
        n10 = this.endTimeMs;
        parcel.writeInt(n10);
        long l10 = this.startOffset;
        parcel.writeLong(l10);
        l10 = this.endOffset;
        parcel.writeLong(l10);
        n10 = this.subFrames.length;
        parcel.writeInt(n10);
        for (Id3Frame id3Frame : this.subFrames) {
            parcel.writeParcelable((Parcelable)id3Frame, 0);
        }
    }
}

