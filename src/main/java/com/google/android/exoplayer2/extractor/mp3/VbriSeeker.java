/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.audio.MpegAudioUtil$Header;
import com.google.android.exoplayer2.extractor.SeekMap$SeekPoints;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.mp3.Seeker;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

public final class VbriSeeker
implements Seeker {
    private static final String TAG = "VbriSeeker";
    private final long dataEndPosition;
    private final long durationUs;
    private final long[] positions;
    private final long[] timesUs;

    private VbriSeeker(long[] lArray, long[] lArray2, long l10, long l11) {
        this.timesUs = lArray;
        this.positions = lArray2;
        this.durationUs = l10;
        this.dataEndPosition = l11;
    }

    public static VbriSeeker create(long l10, long l11, MpegAudioUtil$Header mpegAudioUtil$Header, ParsableByteArray parsableByteArray) {
        Object object;
        int n10;
        long l12 = l10;
        Object object2 = mpegAudioUtil$Header;
        Object object3 = parsableByteArray;
        parsableByteArray.skipBytes(10);
        int n11 = parsableByteArray.readInt();
        if (n11 <= 0) {
            return null;
        }
        int n12 = mpegAudioUtil$Header.sampleRate;
        long l13 = n11;
        long l14 = 1000000L;
        n11 = 32000;
        n11 = n12 >= n11 ? 1152 : 576;
        long l15 = n11;
        l14 *= l15;
        l15 = n12;
        long l16 = Util.scaleLargeTimestamp(l13, l14, l15);
        n11 = parsableByteArray.readUnsignedShort();
        n12 = parsableByteArray.readUnsignedShort();
        int n13 = parsableByteArray.readUnsignedShort();
        int n14 = 2;
        ((ParsableByteArray)object3).skipBytes(n14);
        l14 = ((MpegAudioUtil$Header)object2).frameSize;
        l14 = l11 + l14;
        long[] lArray = new long[n11];
        long[] lArray2 = new long[n11];
        object2 = null;
        l15 = l11;
        for (n10 = 0; n10 < n11; ++n10) {
            int n15;
            int n16;
            int n17 = n12;
            long l17 = (long)n10 * l16;
            long l18 = n11;
            lArray[n10] = l17 /= l18;
            l17 = l14;
            lArray2[n10] = l18 = Math.max(l15, l14);
            n14 = 1;
            if (n13 != n14) {
                n14 = 2;
                if (n13 != n14) {
                    n16 = 3;
                    if (n13 != n16) {
                        n16 = 4;
                        if (n13 != n16) {
                            return null;
                        }
                        n16 = 0;
                        n15 = parsableByteArray.readUnsignedIntToInt();
                    } else {
                        n16 = 0;
                        n15 = parsableByteArray.readUnsignedInt24();
                    }
                } else {
                    n16 = 0;
                    n15 = parsableByteArray.readUnsignedShort();
                }
            } else {
                n14 = 2;
                n16 = 0;
                n15 = parsableByteArray.readUnsignedByte();
            }
            l18 = n15 *= n17;
            l15 += l18;
            l14 = l17;
            n12 = n17;
            n14 = 2;
        }
        long l19 = -1;
        long l20 = l12 - l19;
        n10 = (int)(l20 == 0L ? 0 : (l20 < 0L ? -1 : 1));
        if (n10 != 0 && (n10 = (int)(l12 == l15 ? 0 : (l12 < l15 ? -1 : 1))) != 0) {
            n10 = 67;
            object3 = new StringBuilder(n10);
            object2 = "VBRI data size mismatch: ";
            ((StringBuilder)object3).append((String)object2);
            ((StringBuilder)object3).append(l12);
            ((StringBuilder)object3).append(", ");
            ((StringBuilder)object3).append(l15);
            object = ((StringBuilder)object3).toString();
            String string2 = TAG;
            Log.w(string2, (String)object);
        }
        object = new VbriSeeker(lArray, lArray2, l16, l15);
        return object;
    }

    public long getDataEndPosition() {
        return this.dataEndPosition;
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public SeekMap$SeekPoints getSeekPoints(long l10) {
        Object object;
        long[] lArray = this.timesUs;
        int n10 = 1;
        int n11 = Util.binarySearchFloor(lArray, l10, n10 != 0, n10 != 0);
        long l11 = this.timesUs[n11];
        long[] lArray2 = this.positions;
        long l12 = lArray2[n11];
        SeekPoint seekPoint = new SeekPoint(l11, l12);
        long l13 = seekPoint.timeUs;
        long l14 = l13 - l10;
        Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object2 < 0 && n11 != (object2 = (Object)(((Object)(object = (Object)this.timesUs)).length - n10))) {
            Object object3 = this.timesUs;
            l13 = object3[n11 += n10];
            long l15 = this.positions[n11];
            object = new SeekPoint(l13, l15);
            object3 = new SeekMap$SeekPoints;
            object3(seekPoint, (SeekPoint)object);
            return object3;
        }
        object = new SeekMap$SeekPoints(seekPoint);
        return object;
    }

    public long getTimeUs(long l10) {
        long[] lArray = this.timesUs;
        long[] lArray2 = this.positions;
        boolean bl2 = true;
        int n10 = Util.binarySearchFloor(lArray2, l10, bl2, bl2);
        return lArray[n10];
    }

    public boolean isSeekable() {
        return true;
    }
}

