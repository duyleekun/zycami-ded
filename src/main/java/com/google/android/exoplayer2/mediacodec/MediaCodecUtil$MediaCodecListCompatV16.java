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
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil$1;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil$MediaCodecListCompat;

public final class MediaCodecUtil$MediaCodecListCompatV16
implements MediaCodecUtil$MediaCodecListCompat {
    private MediaCodecUtil$MediaCodecListCompatV16() {
    }

    public /* synthetic */ MediaCodecUtil$MediaCodecListCompatV16(MediaCodecUtil$1 mediaCodecUtil$1) {
        this();
    }

    public int getCodecCount() {
        return MediaCodecList.getCodecCount();
    }

    public MediaCodecInfo getCodecInfoAt(int n10) {
        return MediaCodecList.getCodecInfoAt((int)n10);
    }

    public boolean isFeatureRequired(String string2, String string3, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return false;
    }

    public boolean isFeatureSupported(String string2, String string3, MediaCodecInfo.CodecCapabilities object) {
        object = "secure-playback";
        boolean bl2 = ((String)object).equals(string2);
        if (bl2 && (bl2 = (string2 = "video/avc").equals(string3))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public boolean secureDecodersExplicit() {
        return false;
    }
}

