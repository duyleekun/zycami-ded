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
import com.google.android.exoplayer2.metadata.id3.CommentFrame;

public class CommentFrame$1
implements Parcelable.Creator {
    public CommentFrame createFromParcel(Parcel parcel) {
        CommentFrame commentFrame = new CommentFrame(parcel);
        return commentFrame;
    }

    public CommentFrame[] newArray(int n10) {
        return new CommentFrame[n10];
    }
}

