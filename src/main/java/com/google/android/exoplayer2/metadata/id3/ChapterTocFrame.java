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
import com.google.android.exoplayer2.metadata.id3.ChapterTocFrame$1;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class ChapterTocFrame
extends Id3Frame {
    public static final Parcelable.Creator CREATOR;
    public static final String ID = "CTOC";
    public final String[] children;
    public final String elementId;
    public final boolean isOrdered;
    public final boolean isRoot;
    private final Id3Frame[] subFrames;

    static {
        ChapterTocFrame$1 chapterTocFrame$1 = new ChapterTocFrame$1();
        CREATOR = chapterTocFrame$1;
    }

    public ChapterTocFrame(Parcel parcel) {
        super(ID);
        Id3Frame[] id3FrameArray;
        String[] stringArray = (String[])Util.castNonNull(parcel.readString());
        this.elementId = stringArray;
        int n10 = parcel.readByte();
        int n11 = 1;
        int n12 = 0;
        if (n10 != 0) {
            n10 = n11;
        } else {
            n10 = 0;
            stringArray = null;
        }
        this.isRoot = n10;
        n10 = parcel.readByte();
        if (n10 == 0) {
            n11 = 0;
            id3FrameArray = null;
        }
        this.isOrdered = n11;
        stringArray = (String[])Util.castNonNull(parcel.createStringArray());
        this.children = stringArray;
        n10 = parcel.readInt();
        id3FrameArray = new Id3Frame[n10];
        this.subFrames = id3FrameArray;
        while (n12 < n10) {
            id3FrameArray = this.subFrames;
            Object object = Id3Frame.class.getClassLoader();
            id3FrameArray[n12] = object = (Id3Frame)parcel.readParcelable((ClassLoader)object);
            ++n12;
        }
    }

    public ChapterTocFrame(String string2, boolean bl2, boolean bl3, String[] stringArray, Id3Frame[] id3FrameArray) {
        super(ID);
        this.elementId = string2;
        this.isRoot = bl2;
        this.isOrdered = bl3;
        this.children = stringArray;
        this.subFrames = id3FrameArray;
    }

    public boolean equals(Object objectArray) {
        Object[] objectArray2;
        Object[] objectArray3;
        boolean bl2 = true;
        if (this == objectArray) {
            return bl2;
        }
        if (objectArray != null && (objectArray3 = ChapterTocFrame.class) == (objectArray2 = objectArray.getClass())) {
            boolean bl3;
            objectArray = (ChapterTocFrame)objectArray;
            boolean bl4 = this.isRoot;
            boolean bl5 = objectArray.isRoot;
            if (!(bl4 == bl5 && (bl4 = this.isOrdered) == (bl5 = objectArray.isOrdered) && (bl4 = Util.areEqual(objectArray3 = this.elementId, objectArray2 = objectArray.elementId)) && (bl4 = Arrays.equals(objectArray3 = this.children, objectArray2 = objectArray.children)) && (bl3 = Arrays.equals(objectArray3 = this.subFrames, objectArray = objectArray.subFrames)))) {
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

    /*
     * WARNING - void declaration
     */
    public int hashCode() {
        void var1_5;
        int n10 = this.isRoot;
        int n11 = (527 + n10) * 31;
        int n12 = this.isOrdered;
        n11 = (n11 + n12) * 31;
        String string2 = this.elementId;
        if (string2 != null) {
            int n13 = string2.hashCode();
        } else {
            boolean bl2 = false;
            string2 = null;
        }
        return n11 + var1_5;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        Object[] objectArray = this.elementId;
        parcel.writeString((String)objectArray);
        n10 = (byte)(this.isRoot ? 1 : 0);
        parcel.writeByte((byte)n10);
        n10 = (byte)(this.isOrdered ? 1 : 0);
        parcel.writeByte((byte)n10);
        objectArray = this.children;
        parcel.writeStringArray((String[])objectArray);
        n10 = this.subFrames.length;
        parcel.writeInt(n10);
        for (Id3Frame id3Frame : this.subFrames) {
            parcel.writeParcelable((Parcelable)id3Frame, 0);
        }
    }
}

