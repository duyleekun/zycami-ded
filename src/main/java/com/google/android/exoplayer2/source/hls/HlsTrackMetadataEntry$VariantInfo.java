/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 */
package com.google.android.exoplayer2.source.hls;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry$VariantInfo$1;

public final class HlsTrackMetadataEntry$VariantInfo
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public final String audioGroupId;
    public final int averageBitrate;
    public final String captionGroupId;
    public final int peakBitrate;
    public final String subtitleGroupId;
    public final String videoGroupId;

    static {
        HlsTrackMetadataEntry$VariantInfo$1 hlsTrackMetadataEntry$VariantInfo$1 = new HlsTrackMetadataEntry$VariantInfo$1();
        CREATOR = hlsTrackMetadataEntry$VariantInfo$1;
    }

    public HlsTrackMetadataEntry$VariantInfo(int n10, int n11, String string2, String string3, String string4, String string5) {
        this.averageBitrate = n10;
        this.peakBitrate = n11;
        this.videoGroupId = string2;
        this.audioGroupId = string3;
        this.subtitleGroupId = string4;
        this.captionGroupId = string5;
    }

    public HlsTrackMetadataEntry$VariantInfo(Parcel object) {
        String string2;
        int n10;
        this.averageBitrate = n10 = object.readInt();
        this.peakBitrate = n10 = object.readInt();
        this.videoGroupId = string2 = object.readString();
        this.audioGroupId = string2 = object.readString();
        this.subtitleGroupId = string2 = object.readString();
        object = object.readString();
        this.captionGroupId = object;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = HlsTrackMetadataEntry$VariantInfo.class) == (object2 = object.getClass())) {
            boolean bl3;
            object = (HlsTrackMetadataEntry$VariantInfo)object;
            int n10 = this.averageBitrate;
            int n11 = ((HlsTrackMetadataEntry$VariantInfo)object).averageBitrate;
            if (n10 != n11 || (n10 = this.peakBitrate) != (n11 = ((HlsTrackMetadataEntry$VariantInfo)object).peakBitrate) || (n10 = (int)(TextUtils.equals((CharSequence)(object3 = this.videoGroupId), (CharSequence)(object2 = ((HlsTrackMetadataEntry$VariantInfo)object).videoGroupId)) ? 1 : 0)) == 0 || (n10 = (int)(TextUtils.equals((CharSequence)(object3 = this.audioGroupId), (CharSequence)(object2 = ((HlsTrackMetadataEntry$VariantInfo)object).audioGroupId)) ? 1 : 0)) == 0 || (n10 = (int)(TextUtils.equals((CharSequence)(object3 = this.subtitleGroupId), (CharSequence)(object2 = ((HlsTrackMetadataEntry$VariantInfo)object).subtitleGroupId)) ? 1 : 0)) == 0 || !(bl3 = TextUtils.equals((CharSequence)(object3 = this.captionGroupId), (CharSequence)(object = ((HlsTrackMetadataEntry$VariantInfo)object).captionGroupId)))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10 = this.averageBitrate * 31;
        int n11 = this.peakBitrate;
        n10 = (n10 + n11) * 31;
        String string2 = this.videoGroupId;
        int n12 = 0;
        if (string2 != null) {
            n11 = string2.hashCode();
        } else {
            n11 = 0;
            string2 = null;
        }
        n10 = (n10 + n11) * 31;
        string2 = this.audioGroupId;
        if (string2 != null) {
            n11 = string2.hashCode();
        } else {
            n11 = 0;
            string2 = null;
        }
        n10 = (n10 + n11) * 31;
        string2 = this.subtitleGroupId;
        if (string2 != null) {
            n11 = string2.hashCode();
        } else {
            n11 = 0;
            string2 = null;
        }
        n10 = (n10 + n11) * 31;
        string2 = this.captionGroupId;
        if (string2 != null) {
            n12 = string2.hashCode();
        }
        return n10 + n12;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = this.averageBitrate;
        parcel.writeInt(n10);
        n10 = this.peakBitrate;
        parcel.writeInt(n10);
        String string2 = this.videoGroupId;
        parcel.writeString(string2);
        string2 = this.audioGroupId;
        parcel.writeString(string2);
        string2 = this.subtitleGroupId;
        parcel.writeString(string2);
        string2 = this.captionGroupId;
        parcel.writeString(string2);
    }
}

