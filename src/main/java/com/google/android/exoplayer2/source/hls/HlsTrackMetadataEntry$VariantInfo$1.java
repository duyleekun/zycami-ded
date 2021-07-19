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
import com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry$VariantInfo;

public class HlsTrackMetadataEntry$VariantInfo$1
implements Parcelable.Creator {
    public HlsTrackMetadataEntry$VariantInfo createFromParcel(Parcel parcel) {
        HlsTrackMetadataEntry$VariantInfo hlsTrackMetadataEntry$VariantInfo = new HlsTrackMetadataEntry$VariantInfo(parcel);
        return hlsTrackMetadataEntry$VariantInfo;
    }

    public HlsTrackMetadataEntry$VariantInfo[] newArray(int n10) {
        return new HlsTrackMetadataEntry$VariantInfo[n10];
    }
}

