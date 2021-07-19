/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodecInfo
 *  android.media.MediaCodecInfo$CodecCapabilities
 */
package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodecInfo;

public interface MediaCodecUtil$MediaCodecListCompat {
    public int getCodecCount();

    public MediaCodecInfo getCodecInfoAt(int var1);

    public boolean isFeatureRequired(String var1, String var2, MediaCodecInfo.CodecCapabilities var3);

    public boolean isFeatureSupported(String var1, String var2, MediaCodecInfo.CodecCapabilities var3);

    public boolean secureDecodersExplicit();
}

