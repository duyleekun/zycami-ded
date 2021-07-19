/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.flac.VorbisComment;

public class VorbisComment$1
implements Parcelable.Creator {
    public VorbisComment createFromParcel(Parcel parcel) {
        VorbisComment vorbisComment = new VorbisComment(parcel);
        return vorbisComment;
    }

    public VorbisComment[] newArray(int n10) {
        return new VorbisComment[n10];
    }
}

