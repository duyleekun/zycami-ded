/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;

public final class AtomParsers$StsdData {
    public static final int STSD_HEADER_SIZE = 8;
    public Format format;
    public int nalUnitLengthFieldLength;
    public int requiredSampleTransformation;
    public final TrackEncryptionBox[] trackEncryptionBoxes;

    public AtomParsers$StsdData(int n10) {
        TrackEncryptionBox[] trackEncryptionBoxArray = new TrackEncryptionBox[n10];
        this.trackEncryptionBoxes = trackEncryptionBoxArray;
        this.requiredSampleTransformation = 0;
    }
}

