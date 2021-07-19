/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.source.hls;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry;

public class HlsTrackMetadataEntry$1
implements Parcelable.Creator {
    public HlsTrackMetadataEntry createFromParcel(Parcel parcel) {
        HlsTrackMetadataEntry hlsTrackMetadataEntry = new HlsTrackMetadataEntry(parcel);
        return hlsTrackMetadataEntry;
    }

    public HlsTrackMetadataEntry[] newArray(int n10) {
        return new HlsTrackMetadataEntry[n10];
    }
}

