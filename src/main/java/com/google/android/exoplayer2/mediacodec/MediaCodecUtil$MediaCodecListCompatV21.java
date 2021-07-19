/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodecInfo
 *  android.media.MediaCodecInfo$CodecCapabilities
 *  android.media.MediaCodecList
 */
package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil$MediaCodecListCompat;

public final class MediaCodecUtil$MediaCodecListCompatV21
implements MediaCodecUtil$MediaCodecListCompat {
    private final int codecKind;
    private MediaCodecInfo[] mediaCodecInfos;

    public MediaCodecUtil$MediaCodecListCompatV21(boolean bl2, boolean bl3) {
        bl2 = bl2 || bl3;
        this.codecKind = (int)(bl2 ? 1 : 0);
    }

    private void ensureMediaCodecInfosInitialized() {
        MediaCodecInfo[] mediaCodecInfoArray = this.mediaCodecInfos;
        if (mediaCodecInfoArray == null) {
            int n10 = this.codecKind;
            mediaCodecInfoArray = new MediaCodecList(n10);
            mediaCodecInfoArray = mediaCodecInfoArray.getCodecInfos();
            this.mediaCodecInfos = mediaCodecInfoArray;
        }
    }

    public int getCodecCount() {
        this.ensureMediaCodecInfosInitialized();
        return this.mediaCodecInfos.length;
    }

    public MediaCodecInfo getCodecInfoAt(int n10) {
        this.ensureMediaCodecInfosInitialized();
        return this.mediaCodecInfos[n10];
    }

    public boolean isFeatureRequired(String string2, String string3, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureRequired(string2);
    }

    public boolean isFeatureSupported(String string2, String string3, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(string2);
    }

    public boolean secureDecodersExplicit() {
        return true;
    }
}

