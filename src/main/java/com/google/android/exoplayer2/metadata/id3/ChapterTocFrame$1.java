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
import com.google.android.exoplayer2.metadata.id3.ChapterTocFrame;

public class ChapterTocFrame$1
implements Parcelable.Creator {
    public ChapterTocFrame createFromParcel(Parcel parcel) {
        ChapterTocFrame chapterTocFrame = new ChapterTocFrame(parcel);
        return chapterTocFrame;
    }

    public ChapterTocFrame[] newArray(int n10) {
        return new ChapterTocFrame[n10];
    }
}

