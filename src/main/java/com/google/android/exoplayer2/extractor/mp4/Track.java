/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;

public final class Track {
    public static final int TRANSFORMATION_CEA608_CDAT = 1;
    public static final int TRANSFORMATION_NONE;
    public final long durationUs;
    public final long[] editListDurations;
    public final long[] editListMediaTimes;
    public final Format format;
    public final int id;
    public final long movieTimescale;
    public final int nalUnitLengthFieldLength;
    private final TrackEncryptionBox[] sampleDescriptionEncryptionBoxes;
    public final int sampleTransformation;
    public final long timescale;
    public final int type;

    public Track(int n10, int n11, long l10, long l11, long l12, Format format, int n12, TrackEncryptionBox[] trackEncryptionBoxArray, int n13, long[] lArray, long[] lArray2) {
        this.id = n10;
        this.type = n11;
        this.timescale = l10;
        this.movieTimescale = l11;
        this.durationUs = l12;
        this.format = format;
        this.sampleTransformation = n12;
        this.sampleDescriptionEncryptionBoxes = trackEncryptionBoxArray;
        this.nalUnitLengthFieldLength = n13;
        this.editListDurations = lArray;
        this.editListMediaTimes = lArray2;
    }

    public Track copyWithFormat(Format format) {
        int n10 = this.id;
        int n11 = this.type;
        long l10 = this.timescale;
        long l11 = this.movieTimescale;
        long l12 = this.durationUs;
        int n12 = this.sampleTransformation;
        TrackEncryptionBox[] trackEncryptionBoxArray = this.sampleDescriptionEncryptionBoxes;
        int n13 = this.nalUnitLengthFieldLength;
        long[] lArray = this.editListDurations;
        long[] lArray2 = this.editListMediaTimes;
        Track track = new Track(n10, n11, l10, l11, l12, format, n12, trackEncryptionBoxArray, n13, lArray, lArray2);
        return track;
    }

    public TrackEncryptionBox getSampleDescriptionEncryptionBox(int n10) {
        TrackEncryptionBox trackEncryptionBox;
        TrackEncryptionBox[] trackEncryptionBoxArray = this.sampleDescriptionEncryptionBoxes;
        if (trackEncryptionBoxArray == null) {
            n10 = 0;
            trackEncryptionBox = null;
        } else {
            trackEncryptionBox = trackEncryptionBoxArray[n10];
        }
        return trackEncryptionBox;
    }
}

