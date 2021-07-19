/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.audio.MpegAudioUtil$Header;
import com.google.android.exoplayer2.extractor.ConstantBitrateSeekMap;
import com.google.android.exoplayer2.extractor.mp3.Seeker;

public final class ConstantBitrateSeeker
extends ConstantBitrateSeekMap
implements Seeker {
    public ConstantBitrateSeeker(long l10, long l11, MpegAudioUtil$Header mpegAudioUtil$Header) {
        int n10 = mpegAudioUtil$Header.bitrate;
        int n11 = mpegAudioUtil$Header.frameSize;
        super(l10, l11, n10, n11);
    }

    public long getDataEndPosition() {
        return -1;
    }

    public long getTimeUs(long l10) {
        return this.getTimeUsAtPosition(l10);
    }
}

