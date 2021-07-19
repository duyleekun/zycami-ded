/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Util;

public final class AudioProcessor$AudioFormat {
    public static final AudioProcessor$AudioFormat NOT_SET;
    public final int bytesPerFrame;
    public final int channelCount;
    public final int encoding;
    public final int sampleRate;

    static {
        AudioProcessor$AudioFormat audioProcessor$AudioFormat;
        int n10 = -1;
        NOT_SET = audioProcessor$AudioFormat = new AudioProcessor$AudioFormat(n10, n10, n10);
    }

    public AudioProcessor$AudioFormat(int n10, int n11, int n12) {
        this.sampleRate = n10;
        this.channelCount = n11;
        this.encoding = n12;
        n10 = (int)(Util.isEncodingLinearPcm(n12) ? 1 : 0);
        n10 = n10 != 0 ? Util.getPcmFrameSize(n12, n11) : -1;
        this.bytesPerFrame = n10;
    }

    public String toString() {
        int n10 = this.sampleRate;
        int n11 = this.channelCount;
        int n12 = this.encoding;
        StringBuilder stringBuilder = new StringBuilder(83);
        stringBuilder.append("AudioFormat[sampleRate=");
        stringBuilder.append(n10);
        stringBuilder.append(", channelCount=");
        stringBuilder.append(n11);
        stringBuilder.append(", encoding=");
        stringBuilder.append(n12);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

