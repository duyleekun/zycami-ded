/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.audio.MpegAudioUtil$Header;
import com.google.android.exoplayer2.extractor.SeekMap$SeekPoints;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.mp3.Seeker;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

public final class XingSeeker
implements Seeker {
    private static final String TAG = "XingSeeker";
    private final long dataEndPosition;
    private final long dataSize;
    private final long dataStartPosition;
    private final long durationUs;
    private final long[] tableOfContents;
    private final int xingFrameSize;

    private XingSeeker(long l10, int n10, long l11) {
        this(l10, n10, l11, -1, null);
    }

    private XingSeeker(long l10, int n10, long l11, long l12, long[] lArray) {
        this.dataStartPosition = l10;
        this.xingFrameSize = n10;
        this.durationUs = l11;
        this.tableOfContents = lArray;
        this.dataSize = l12;
        long l13 = -1;
        long l14 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        if (l14 != false) {
            l13 = l10 + l12;
        }
        this.dataEndPosition = l13;
    }

    public static XingSeeker create(long l10, long l11, MpegAudioUtil$Header mpegAudioUtil$Header, ParsableByteArray parsableByteArray) {
        int n10;
        long l12 = l10;
        MpegAudioUtil$Header mpegAudioUtil$Header2 = mpegAudioUtil$Header;
        int n11 = mpegAudioUtil$Header.samplesPerFrame;
        int n12 = mpegAudioUtil$Header.sampleRate;
        int n13 = parsableByteArray.readInt();
        int n14 = n13 & 1;
        if (n14 == (n10 = 1) && (n14 = parsableByteArray.readUnsignedIntToInt()) != 0) {
            Object object;
            long l13;
            long l14 = n14;
            long l15 = (long)n11 * 1000000L;
            long l16 = n12;
            long l17 = Util.scaleLargeTimestamp(l14, l15, l16);
            n12 = n13 & 6;
            n11 = 6;
            if (n12 != n11) {
                int n15 = mpegAudioUtil$Header.frameSize;
                XingSeeker xingSeeker = new XingSeeker(l11, n15, l17);
                return xingSeeker;
            }
            long l18 = parsableByteArray.readUnsignedInt();
            n11 = 100;
            long[] lArray = new long[n11];
            for (n13 = 0; n13 < n11; ++n13) {
                long l19;
                n14 = parsableByteArray.readUnsignedByte();
                lArray[n13] = l19 = (long)n14;
            }
            long l20 = -1;
            long l21 = l12 - l20;
            n11 = (int)(l21 == 0L ? 0 : (l21 < 0L ? -1 : 1));
            if (n11 != 0 && (n11 = (int)((l13 = l12 - (l20 = l11 + l18)) == 0L ? 0 : (l13 < 0L ? -1 : 1))) != 0) {
                n11 = 67;
                StringBuilder stringBuilder = new StringBuilder(n11);
                String string2 = "XING data size mismatch: ";
                stringBuilder.append(string2);
                stringBuilder.append(l12);
                stringBuilder.append(", ");
                stringBuilder.append(l20);
                object = stringBuilder.toString();
                String string3 = TAG;
                Log.w(string3, (String)object);
            }
            int n16 = mpegAudioUtil$Header2.frameSize;
            object = new XingSeeker(l11, n16, l17, l18, lArray);
            return object;
        }
        return null;
    }

    private long getTimeUsForTableIndex(int n10) {
        long l10 = this.durationUs;
        long l11 = n10;
        return l10 * l11 / (long)100;
    }

    public long getDataEndPosition() {
        return this.dataEndPosition;
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public SeekMap$SeekPoints getSeekPoints(long l10) {
        Object object;
        boolean bl2 = this.isSeekable();
        if (!bl2) {
            long l11 = this.dataStartPosition;
            long l12 = this.xingFrameSize;
            SeekPoint seekPoint = new SeekPoint(0L, l11 += l12);
            SeekMap$SeekPoints seekMap$SeekPoints = new SeekMap$SeekPoints(seekPoint);
            return seekMap$SeekPoints;
        }
        long l13 = 0L;
        long l14 = this.durationUs;
        long l15 = l10;
        l10 = Util.constrainValue(l10, l13, l14);
        double d10 = l10;
        long l16 = 4636737291354636288L;
        double d11 = 100.0;
        d10 *= d11;
        double d12 = this.durationUs;
        d10 /= d12;
        l15 = 0L;
        d12 = 0.0;
        double d13 = d10 == d12 ? 0 : (d10 < d12 ? -1 : 1);
        long l17 = 0x4070000000000000L;
        double d14 = 256.0;
        if (d13 > 0) {
            Object object2 = d10 == d11 ? 0 : (d10 > d11 ? 1 : -1);
            if (object2 >= 0) {
                l15 = l17;
                d12 = d14;
            } else {
                double d15;
                object2 = (int)d10;
                object = (long[])Assertions.checkStateNotNull(this.tableOfContents);
                l15 = object[object2];
                d12 = l15;
                d13 = 99;
                if (object2 == d13) {
                    long l18 = l17;
                    d15 = d14;
                } else {
                    d13 = object2 + true;
                    long l19 = object[d13];
                    d15 = l19;
                }
                d11 = object2;
                d10 -= d11;
                d10 *= (d15 -= d12);
                d12 += d10;
            }
        }
        d10 = this.dataSize;
        l13 = Math.round((d12 /= d14) * d10);
        l14 = this.xingFrameSize;
        long l20 = this.dataSize - 1L;
        long l21 = Util.constrainValue(l13, l14, l20);
        object = new SeekPoint;
        l15 = this.dataStartPosition + l21;
        object(l10, l15);
        SeekMap$SeekPoints seekMap$SeekPoints = new SeekMap$SeekPoints((SeekPoint)object);
        return seekMap$SeekPoints;
    }

    public long getTimeUs(long l10) {
        long l11;
        long l12 = this.dataStartPosition;
        l10 -= l12;
        int n10 = this.isSeekable();
        if (n10 != 0 && (n10 = (l11 = l10 - (l12 = (long)this.xingFrameSize)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) > 0) {
            double d10;
            long[] lArray = (long[])Assertions.checkStateNotNull(this.tableOfContents);
            double d11 = (double)l10 * 256.0;
            double d12 = this.dataSize;
            long l13 = (long)(d11 /= d12);
            boolean bl2 = true;
            int n11 = Util.binarySearchFloor(lArray, l13, bl2, bl2);
            long l14 = this.getTimeUsForTableIndex(n11);
            long l15 = lArray[n11];
            int n12 = n11 + 1;
            long l16 = this.getTimeUsForTableIndex(n12);
            int n13 = 99;
            if (n11 == n13) {
                l12 = 256L;
                d10 = 1.265E-321;
            } else {
                long l17;
                l12 = l17 = lArray[n12];
            }
            n12 = (int)(l15 == l12 ? 0 : (l15 < l12 ? -1 : 1));
            if (n12 == 0) {
                l10 = 0L;
                d11 = 0.0;
            } else {
                double d13 = l15;
                d11 -= d13;
                d10 = l12 -= l15;
                d11 /= d10;
            }
            d10 = l16 - l14;
            l10 = Math.round(d11 * d10);
            return l14 + l10;
        }
        return 0L;
    }

    public boolean isSeekable() {
        boolean bl2;
        long[] lArray = this.tableOfContents;
        if (lArray != null) {
            bl2 = true;
        } else {
            bl2 = false;
            lArray = null;
        }
        return bl2;
    }
}

