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
import com.google.android.exoplayer2.metadata.id3.ChapterFrame;

public class ChapterFrame$1
implements Parcelable.Creator {
    public ChapterFrame createFromParcel(Parcel parcel) {
        ChapterFrame chapterFrame = new ChapterFrame(parcel);
        return chapterFrame;
    }

    public ChapterFrame[] newArray(int n10) {
        return new ChapterFrame[n10];
    }
}

