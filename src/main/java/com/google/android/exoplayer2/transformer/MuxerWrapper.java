/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.util.SparseLongArray
 */
package com.google.android.exoplayer2.transformer;

import android.util.SparseIntArray;
import android.util.SparseLongArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.transformer.Muxer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;

public final class MuxerWrapper {
    private static final long MAX_TRACK_WRITE_AHEAD_US = C.msToUs(500L);
    private boolean isReady;
    private long minTrackTimeUs;
    private final Muxer muxer;
    private int previousTrackType;
    private int trackCount;
    private int trackFormatCount;
    private final SparseIntArray trackTypeToIndex;
    private final SparseLongArray trackTypeToTimeUs;

    public MuxerWrapper(Muxer muxer) {
        this.muxer = muxer;
        this.trackTypeToIndex = muxer;
        super();
        this.trackTypeToTimeUs = muxer;
        this.previousTrackType = 7;
    }

    private boolean canWriteSampleOfType(int n10) {
        long l10;
        SparseLongArray sparseLongArray = this.trackTypeToTimeUs;
        long l11 = -9223372036854775807L;
        long l12 = sparseLongArray.get(n10, l11);
        long l13 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1);
        boolean bl2 = false;
        boolean bl3 = true;
        if (l13 != false) {
            l13 = (long)bl3;
        } else {
            l13 = 0;
            sparseLongArray = null;
        }
        Assertions.checkState((boolean)l13);
        l13 = (long)this.isReady;
        if (l13 == false) {
            return false;
        }
        sparseLongArray = this.trackTypeToTimeUs;
        l13 = sparseLongArray.size();
        if (l13 == bl3) {
            return bl3;
        }
        l13 = this.previousTrackType;
        if (n10 != l13) {
            SparseLongArray sparseLongArray2 = this.trackTypeToTimeUs;
            this.minTrackTimeUs = l10 = Util.minValue(sparseLongArray2);
        }
        l10 = this.minTrackTimeUs;
        long l14 = (l12 -= l10) - (l10 = MAX_TRACK_WRITE_AHEAD_US);
        n10 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
        if (n10 <= 0) {
            bl2 = bl3;
        }
        return bl2;
    }

    public void addTrackFormat(Format format) {
        String string2;
        int n10 = this.trackCount;
        int n11 = 0;
        SparseIntArray sparseIntArray = null;
        int n12 = 1;
        if (n10 > 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        String string3 = "All tracks should be registered before the formats are added.";
        Assertions.checkState(n10 != 0, string3);
        n10 = this.trackFormatCount;
        int n13 = this.trackCount;
        if (n10 < n13) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        string3 = "All track formats have already been added.";
        Assertions.checkState(n10 != 0, string3);
        string2 = format.sampleMimeType;
        n13 = (int)(MimeTypes.isAudio(string2) ? 1 : 0);
        int n14 = MimeTypes.isVideo(string2);
        if (n13 == 0 && n14 == 0) {
            n13 = 0;
            string3 = null;
        } else {
            n13 = n12;
        }
        CharSequence charSequence = "Unsupported track format: ";
        String string4 = String.valueOf(string2);
        int n15 = string4.length();
        if (n15 != 0) {
            charSequence = ((String)charSequence).concat(string4);
        } else {
            string4 = new String((String)charSequence);
            charSequence = string4;
        }
        Assertions.checkState(n13 != 0, charSequence);
        n10 = MimeTypes.getTrackType(string2);
        string3 = this.trackTypeToIndex;
        n14 = -1;
        n13 = string3.get(n10, n14);
        if (n13 == n14) {
            n11 = n12;
        }
        n13 = 44;
        charSequence = new StringBuilder(n13);
        ((StringBuilder)charSequence).append("There is already a track of type ");
        ((StringBuilder)charSequence).append(n10);
        string3 = ((StringBuilder)charSequence).toString();
        Assertions.checkState(n11 != 0, string3);
        int n16 = this.muxer.addTrack(format);
        sparseIntArray = this.trackTypeToIndex;
        sparseIntArray.put(n10, n16);
        format = this.trackTypeToTimeUs;
        long l10 = 0L;
        format.put(n10, l10);
        this.trackFormatCount = n16 = this.trackFormatCount + n12;
        n10 = this.trackCount;
        if (n16 == n10) {
            this.isReady = n12;
        }
    }

    public void endTrack(int n10) {
        this.trackTypeToIndex.delete(n10);
        this.trackTypeToTimeUs.delete(n10);
    }

    public int getTrackCount() {
        return this.trackCount;
    }

    public void registerTrack() {
        int n10 = this.trackFormatCount;
        int n11 = 1;
        n10 = n10 == 0 ? n11 : 0;
        Assertions.checkState(n10 != 0, "Tracks cannot be registered after track formats have been added.");
        this.trackCount = n10 = this.trackCount + n11;
    }

    public void release(boolean bl2) {
        this.isReady = false;
        this.muxer.release(bl2);
    }

    public boolean supportsSampleMimeType(String string2) {
        return this.muxer.supportsSampleMimeType(string2);
    }

    /*
     * WARNING - void declaration
     */
    public boolean writeSample(int n10, ByteBuffer byteBuffer, boolean bl2, long l10) {
        void var7_9;
        SparseIntArray sparseIntArray = this.trackTypeToIndex;
        int bl3 = -1;
        int n11 = sparseIntArray.get(n10, bl3);
        sparseIntArray = null;
        boolean bl4 = true;
        if (n11 != bl3) {
            boolean bl5 = bl4;
        } else {
            boolean bl6 = false;
        }
        int n12 = 68;
        Comparable<StringBuilder> comparable = new StringBuilder(n12);
        comparable.append("Could not write sample because there is no track of type ");
        comparable.append(n10);
        Object object = comparable.toString();
        Assertions.checkState((boolean)var7_9, object);
        boolean bl7 = this.canWriteSampleOfType(n10);
        if (!bl7) {
            return false;
        }
        if (byteBuffer == null) {
            return bl4;
        }
        object = this.muxer;
        comparable = byteBuffer;
        object.writeSampleData(n11, byteBuffer, bl2, l10);
        this.trackTypeToTimeUs.put(n10, l10);
        this.previousTrackType = n10;
        return bl4;
    }
}

