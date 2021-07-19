/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.util.Log
 */
package com.google.android.exoplayer2.source;

import android.os.Looper;
import android.util.Log;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.Buffer;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSession$DrmSessionException;
import com.google.android.exoplayer2.drm.DrmSessionEventListener$EventDispatcher;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.TrackOutput$CryptoData;
import com.google.android.exoplayer2.source.SampleDataQueue;
import com.google.android.exoplayer2.source.SampleQueue$SampleExtrasHolder;
import com.google.android.exoplayer2.source.SampleQueue$UpstreamFormatChangedListener;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

public class SampleQueue
implements TrackOutput {
    public static final int SAMPLE_CAPACITY_INCREMENT = 1000;
    private static final String TAG = "SampleQueue";
    private int absoluteFirstIndex;
    private int capacity;
    private TrackOutput$CryptoData[] cryptoDatas;
    private DrmSession currentDrmSession;
    private Format downstreamFormat;
    private final DrmSessionEventListener$EventDispatcher drmEventDispatcher;
    private final DrmSessionManager drmSessionManager;
    private final SampleQueue$SampleExtrasHolder extrasHolder;
    private int[] flags;
    private Format[] formats;
    private boolean isLastSampleQueued;
    private long largestDiscardedTimestampUs;
    private long largestQueuedTimestampUs;
    private int length;
    private boolean loggedUnexpectedNonSyncSample;
    private long[] offsets;
    private boolean pendingSplice;
    private final Looper playbackLooper;
    private int readPosition;
    private int relativeFirstIndex;
    private final SampleDataQueue sampleDataQueue;
    private long sampleOffsetUs;
    private int[] sizes;
    private int[] sourceIds;
    private long startTimeUs;
    private long[] timesUs;
    private Format unadjustedUpstreamFormat;
    private boolean upstreamAllSamplesAreSyncSamples;
    private Format upstreamCommittedFormat;
    private Format upstreamFormat;
    private boolean upstreamFormatAdjustmentRequired;
    private SampleQueue$UpstreamFormatChangedListener upstreamFormatChangeListener;
    private boolean upstreamFormatRequired;
    private boolean upstreamKeyframeRequired;
    private int upstreamSourceId;

    public SampleQueue(Allocator formatArray, Looper trackOutput$CryptoDataArray, DrmSessionManager drmSessionManager, DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher) {
        long l10;
        int n10;
        this.playbackLooper = trackOutput$CryptoDataArray;
        this.drmSessionManager = drmSessionManager;
        this.drmEventDispatcher = drmSessionEventListener$EventDispatcher;
        super((Allocator)formatArray);
        this.sampleDataQueue = trackOutput$CryptoDataArray;
        formatArray = new SampleQueue$SampleExtrasHolder();
        this.extrasHolder = formatArray;
        this.capacity = n10 = 1000;
        trackOutput$CryptoDataArray = (TrackOutput$CryptoData[])new int[n10];
        this.sourceIds = (int[])trackOutput$CryptoDataArray;
        trackOutput$CryptoDataArray = (TrackOutput$CryptoData[])new long[n10];
        this.offsets = (long[])trackOutput$CryptoDataArray;
        trackOutput$CryptoDataArray = (TrackOutput$CryptoData[])new long[n10];
        this.timesUs = (long[])trackOutput$CryptoDataArray;
        trackOutput$CryptoDataArray = (TrackOutput$CryptoData[])new int[n10];
        this.flags = (int[])trackOutput$CryptoDataArray;
        trackOutput$CryptoDataArray = (TrackOutput$CryptoData[])new int[n10];
        this.sizes = (int[])trackOutput$CryptoDataArray;
        trackOutput$CryptoDataArray = new TrackOutput$CryptoData[n10];
        this.cryptoDatas = trackOutput$CryptoDataArray;
        formatArray = new Format[n10];
        this.formats = formatArray;
        this.startTimeUs = l10 = Long.MIN_VALUE;
        this.largestDiscardedTimestampUs = l10;
        this.largestQueuedTimestampUs = l10;
        n10 = 1;
        this.upstreamFormatRequired = n10;
        this.upstreamKeyframeRequired = n10;
    }

    private boolean attemptSplice(long l10) {
        synchronized (this) {
            boolean bl2;
            int n10;
            block9: {
                block10: {
                    n10 = this.length;
                    bl2 = true;
                    if (n10 != 0) break block9;
                    long l11 = this.largestDiscardedTimestampUs;
                    long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                    if (l12 > 0) break block10;
                    bl2 = false;
                }
                return bl2;
            }
            long l13 = this.getLargestReadTimestampUs();
            n10 = (int)(l13 == l10 ? 0 : (l13 < l10 ? -1 : 1));
            if (n10 >= 0) {
                return false;
            }
            int n11 = this.countUnreadSamplesBefore(l10);
            int n12 = this.absoluteFirstIndex + n11;
            this.discardUpstreamSampleMetadata(n12);
            return bl2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void commitSample(long l10, int n10, long l11, int n11, TrackOutput$CryptoData object) {
        synchronized (this) {
            int n12;
            int n13;
            Format format;
            int[] nArray;
            int n14 = this.length;
            int n15 = 1;
            if (n14 > 0) {
                n14 -= n15;
                n14 = this.getRelativeIndex(n14);
                long[] lArray = this.offsets;
                long l12 = lArray[n14];
                int[] nArray2 = this.sizes;
                long l13 = nArray2[n14];
                long l14 = (l12 += l13) - l11;
                if ((n14 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1))) <= 0) {
                    n14 = n15;
                } else {
                    n14 = 0;
                    nArray = null;
                }
                Assertions.checkArgument(n14 != 0);
            }
            if ((n14 = 0x20000000 & n10) != 0) {
                n14 = n15;
            } else {
                n14 = 0;
                nArray = null;
            }
            this.isLastSampleQueued = n14;
            long l15 = this.largestQueuedTimestampUs;
            this.largestQueuedTimestampUs = l15 = Math.max(l15, l10);
            n14 = this.length;
            n14 = this.getRelativeIndex(n14);
            long[] lArray = this.timesUs;
            lArray[n14] = l10;
            long[] lArray2 = this.offsets;
            lArray2[n14] = l11;
            int[] nArray3 = this.sizes;
            nArray3[n14] = n11;
            int[] nArray4 = this.flags;
            nArray4[n14] = n10;
            TrackOutput$CryptoData[] trackOutput$CryptoDataArray = this.cryptoDatas;
            trackOutput$CryptoDataArray[n14] = object;
            Format[] formatArray = this.formats;
            formatArray[n14] = format = this.upstreamFormat;
            int[] nArray5 = this.sourceIds;
            nArray5[n14] = n13 = this.upstreamSourceId;
            this.upstreamCommittedFormat = format;
            this.length = n12 = this.length + n15;
            n10 = this.capacity;
            if (n12 == n10) {
                n12 = n10 + 1000;
                int[] nArray6 = new int[n12];
                long[] lArray3 = new long[n12];
                long[] lArray4 = new long[n12];
                object = new int[n12];
                nArray = new int[n12];
                TrackOutput$CryptoData[] trackOutput$CryptoDataArray2 = new TrackOutput$CryptoData[n12];
                Format[] formatArray2 = new Format[n12];
                int n16 = this.relativeFirstIndex;
                System.arraycopy(lArray2, n16, lArray3, 0, n10 -= n16);
                long[] lArray5 = this.timesUs;
                n16 = this.relativeFirstIndex;
                System.arraycopy(lArray5, n16, lArray4, 0, n10);
                int[] nArray7 = this.flags;
                n16 = this.relativeFirstIndex;
                System.arraycopy(nArray7, n16, object, 0, n10);
                int[] nArray8 = this.sizes;
                n16 = this.relativeFirstIndex;
                System.arraycopy(nArray8, n16, nArray, 0, n10);
                TrackOutput$CryptoData[] trackOutput$CryptoDataArray3 = this.cryptoDatas;
                n16 = this.relativeFirstIndex;
                System.arraycopy(trackOutput$CryptoDataArray3, n16, trackOutput$CryptoDataArray2, 0, n10);
                Format[] formatArray3 = this.formats;
                n16 = this.relativeFirstIndex;
                System.arraycopy(formatArray3, n16, formatArray2, 0, n10);
                int[] nArray9 = this.sourceIds;
                n16 = this.relativeFirstIndex;
                System.arraycopy(nArray9, n16, nArray6, 0, n10);
                int n17 = this.relativeFirstIndex;
                long[] lArray6 = this.offsets;
                System.arraycopy(lArray6, 0, lArray3, n10, n17);
                long[] lArray7 = this.timesUs;
                System.arraycopy(lArray7, 0, lArray4, n10, n17);
                int[] nArray10 = this.flags;
                System.arraycopy(nArray10, 0, object, n10, n17);
                int[] nArray11 = this.sizes;
                System.arraycopy(nArray11, 0, nArray, n10, n17);
                TrackOutput$CryptoData[] trackOutput$CryptoDataArray4 = this.cryptoDatas;
                System.arraycopy(trackOutput$CryptoDataArray4, 0, trackOutput$CryptoDataArray2, n10, n17);
                Format[] formatArray4 = this.formats;
                System.arraycopy(formatArray4, 0, formatArray2, n10, n17);
                int[] nArray12 = this.sourceIds;
                System.arraycopy(nArray12, 0, nArray6, n10, n17);
                this.offsets = lArray3;
                this.timesUs = lArray4;
                this.flags = (int[])object;
                this.sizes = nArray;
                this.cryptoDatas = trackOutput$CryptoDataArray2;
                this.formats = formatArray2;
                this.sourceIds = nArray6;
                this.relativeFirstIndex = 0;
                this.capacity = n12;
            }
            return;
        }
    }

    private int countUnreadSamplesBefore(long l10) {
        long[] lArray;
        long l11;
        long l12;
        int n10;
        int n11;
        int n12 = n11 + -1;
        n12 = this.getRelativeIndex(n12);
        for (n11 = this.length; n11 > (n10 = this.readPosition) && (n10 = (int)((l12 = (l11 = (lArray = this.timesUs)[n12]) - l10) == 0L ? 0 : (l12 < 0L ? -1 : 1))) >= 0; n11 += -1) {
            n10 = -1;
            if ((n12 += -1) != n10) continue;
            n12 = this.capacity + -1;
        }
        return n11;
    }

    public static SampleQueue createWithDrm(Allocator allocator, Looper looper, DrmSessionManager drmSessionManager, DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher) {
        looper = (Looper)Assertions.checkNotNull(looper);
        drmSessionManager = (DrmSessionManager)Assertions.checkNotNull(drmSessionManager);
        drmSessionEventListener$EventDispatcher = (DrmSessionEventListener$EventDispatcher)Assertions.checkNotNull(drmSessionEventListener$EventDispatcher);
        SampleQueue sampleQueue = new SampleQueue(allocator, looper, drmSessionManager, drmSessionEventListener$EventDispatcher);
        return sampleQueue;
    }

    public static SampleQueue createWithoutDrm(Allocator allocator) {
        SampleQueue sampleQueue = new SampleQueue(allocator, null, null, null);
        return sampleQueue;
    }

    private long discardSampleMetadataTo(long l10, boolean bl2, boolean n10) {
        synchronized (this) {
            long l11;
            block11: {
                int n11 = this.length;
                l11 = -1;
                if (n11 != 0) {
                    int n12;
                    block13: {
                        int n13;
                        block12: {
                            long[] lArray = this.timesUs;
                            n13 = this.relativeFirstIndex;
                            long l12 = lArray[n13];
                            long l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
                            if (l13 < 0) break block11;
                            if (n10 == 0) break block12;
                            n10 = this.readPosition;
                            if (n10 == n11) break block12;
                            n11 = n10 + 1;
                        }
                        n12 = this.findSampleBefore(n13, n11, l10, bl2);
                        int n14 = -1;
                        if (n12 != n14) break block13;
                        return l11;
                    }
                    l10 = this.discardSamples(n12);
                    return l10;
                }
            }
            return l11;
            finally {
            }
        }
    }

    private long discardSampleMetadataToEnd() {
        synchronized (this) {
            int n10;
            block5: {
                n10 = this.length;
                if (n10 != 0) break block5;
                return -1;
            }
            long l10 = this.discardSamples(n10);
            return l10;
        }
    }

    private long discardSamples(int n10) {
        long[] lArray;
        int n11;
        int n12;
        long l10 = this.largestDiscardedTimestampUs;
        long l11 = this.getLargestTimestamp(n10);
        this.largestDiscardedTimestampUs = l10 = Math.max(l10, l11);
        this.length = n12 = this.length - n10;
        this.absoluteFirstIndex = n11 = this.absoluteFirstIndex + n10;
        this.relativeFirstIndex = n11 = this.relativeFirstIndex + n10;
        int n13 = this.capacity;
        if (n11 >= n13) {
            this.relativeFirstIndex = n11 -= n13;
        }
        this.readPosition = n11 = this.readPosition - n10;
        if (n11 < 0) {
            n10 = 0;
            lArray = null;
            this.readPosition = 0;
        }
        if (n12 == 0) {
            n10 = this.relativeFirstIndex;
            if (n10 != 0) {
                n13 = n10;
            }
            l10 = this.offsets[n13 += -1];
            l11 = this.sizes[n13];
            return l10 + l11;
        }
        lArray = this.offsets;
        n12 = this.relativeFirstIndex;
        return lArray[n12];
    }

    /*
     * Unable to fully structure code
     */
    private long discardUpstreamSampleMetadata(int var1_1) {
        var2_2 = this.getWriteIndex() - var1_1;
        var1_1 = 0;
        var3_3 = 1;
        if (var2_2 < 0) ** GOTO lbl-1000
        var4_4 = this.length;
        var5_5 = this.readPosition;
        if (var2_2 <= (var4_4 -= var5_5)) {
            var4_4 = var3_3;
        } else lbl-1000:
        // 2 sources

        {
            var4_4 = 0;
        }
        Assertions.checkArgument((boolean)var4_4);
        this.length = var4_4 = this.length - var2_2;
        var6_6 = this.largestDiscardedTimestampUs;
        var8_7 = this.getLargestTimestamp(var4_4);
        this.largestQueuedTimestampUs = var10_8 = Math.max(var6_6, var8_7);
        if (var2_2 == 0 && (var2_2 = (int)this.isLastSampleQueued) != 0) {
            var1_1 = var3_3;
        }
        this.isLastSampleQueued = var1_1;
        var1_1 = this.length;
        if (var1_1 != 0) {
            var1_1 -= var3_3;
            var1_1 = this.getRelativeIndex(var1_1);
            var12_9 = this.offsets[var1_1];
            var6_6 = this.sizes[var1_1];
            return var12_9 + var6_6;
        }
        return 0L;
    }

    private int findSampleBefore(int n10, int n11, long l10, boolean bl2) {
        long[] lArray;
        long l11;
        long l12;
        long l13;
        int n12 = -1;
        for (int i10 = 0; i10 < n11 && (l13 = (l12 = (l11 = (lArray = this.timesUs)[n10]) - l10) == 0L ? 0 : (l12 < 0L ? -1 : 1)) <= 0; ++i10) {
            int n13;
            int[] nArray;
            if (!bl2 || (l13 = (long)((nArray = this.flags)[n10] & 1)) != false) {
                l11 = lArray[n10];
                long l14 = l11 - l10;
                n12 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
                if (n12 == 0) {
                    n12 = i10;
                    break;
                }
                n12 = i10;
            }
            if (++n10 != (n13 = this.capacity)) continue;
            n10 = 0;
        }
        return n12;
    }

    private long getLargestTimestamp(int n10) {
        long l10 = Long.MIN_VALUE;
        if (n10 == 0) {
            return l10;
        }
        int n11 = n10 + -1;
        n11 = this.getRelativeIndex(n11);
        for (int i10 = 0; i10 < n10; ++i10) {
            long l11 = this.timesUs[n11];
            l10 = Math.max(l10, l11);
            int[] nArray = this.flags;
            int n12 = nArray[n11] & 1;
            if (n12 != 0) break;
            n12 = -1;
            if ((n11 += -1) != n12) continue;
            n11 = this.capacity + -1;
        }
        return l10;
    }

    private int getRelativeIndex(int n10) {
        int n11 = this.relativeFirstIndex + n10;
        if (n11 >= (n10 = this.capacity)) {
            n11 -= n10;
        }
        return n11;
    }

    private boolean hasNextSample() {
        int n10 = this.readPosition;
        int n11 = this.length;
        n10 = n10 != n11 ? 1 : 0;
        return n10 != 0;
    }

    /*
     * WARNING - void declaration
     */
    private boolean mayReadSample(int object) {
        void var1_7;
        DrmSession drmSession;
        boolean bl2;
        Object object2;
        int n10;
        int n11;
        int n12;
        Object object3 = this.currentDrmSession;
        if (!(object3 == null || (n12 = object3.getState()) == (n11 = 4) || (n10 = (object2 = (object3 = (Object)this.flags)[object]) & (n12 = 0x40000000)) == 0 && (bl2 = (drmSession = this.currentDrmSession).playClearSamplesWithoutKeys()))) {
            boolean bl3 = false;
            drmSession = null;
        } else {
            boolean bl4 = true;
        }
        return (boolean)var1_7;
    }

    private void onFormatResult(Format object, FormatHolder formatHolder) {
        boolean bl2;
        DrmSessionManager drmSessionManager;
        boolean bl3;
        Object object2 = this.downstreamFormat;
        if (object2 == null) {
            bl3 = true;
        } else {
            bl3 = false;
            drmSessionManager = null;
        }
        if (bl3) {
            bl2 = false;
            object2 = null;
        } else {
            object2 = ((Format)object2).drmInitData;
        }
        this.downstreamFormat = object;
        DrmInitData drmInitData = ((Format)object).drmInitData;
        Object object3 = this.drmSessionManager;
        if (object3 != null) {
            object3 = object3.getExoMediaCryptoType((Format)object);
            object3 = ((Format)object).copyWithExoMediaCryptoType((Class)object3);
        } else {
            object3 = object;
        }
        formatHolder.format = object3;
        formatHolder.drmSession = object3 = this.currentDrmSession;
        object3 = this.drmSessionManager;
        if (object3 == null) {
            return;
        }
        if (!bl3 && (bl2 = Util.areEqual(object2, drmInitData))) {
            return;
        }
        object2 = this.currentDrmSession;
        drmSessionManager = this.drmSessionManager;
        drmInitData = (Looper)Assertions.checkNotNull(this.playbackLooper);
        object3 = this.drmEventDispatcher;
        this.currentDrmSession = object = drmSessionManager.acquireSession((Looper)drmInitData, (DrmSessionEventListener$EventDispatcher)object3, (Format)object);
        formatHolder.drmSession = object;
        if (object2 != null) {
            object = this.drmEventDispatcher;
            object2.release((DrmSessionEventListener$EventDispatcher)object);
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private int peekSampleMetadata(FormatHolder object, DecoderInputBuffer object2, boolean bl2, boolean bl3, SampleQueue$SampleExtrasHolder sampleQueue$SampleExtrasHolder) {
        synchronized (this) {
            Format[] formatArray;
            Format format;
            void var3_9;
            Object object3;
            boolean bl4 = false;
            Format format2 = null;
            ((DecoderInputBuffer)object3).waitingForKeys = false;
            bl4 = this.hasNextSample();
            int n10 = -5;
            int n11 = -3;
            int n12 = -4;
            if (!bl4) {
                boolean bl5;
                void var4_10;
                if (var4_10 == false && !(bl5 = this.isLastSampleQueued)) {
                    Format format3;
                    object3 = this.upstreamFormat;
                    if (object3 != null && (var3_9 != false || object3 != (format3 = this.downstreamFormat))) {
                        object3 = Assertions.checkNotNull(object3);
                        object3 = (Format)object3;
                        this.onFormatResult((Format)object3, (FormatHolder)object);
                        return n10;
                    }
                    return n11;
                }
                int n13 = 4;
                ((Buffer)object3).setFlags(n13);
                return n12;
            }
            int n15 = this.readPosition;
            n15 = this.getRelativeIndex(n15);
            if (var3_9 == false && (format = (formatArray = this.formats)[n15]) == (format2 = this.downstreamFormat)) {
                TrackOutput$CryptoData trackOutput$CryptoData;
                long l10;
                int n16;
                long l11;
                boolean bl6 = this.mayReadSample(n15);
                if (!bl6) {
                    boolean bl7;
                    ((DecoderInputBuffer)object3).waitingForKeys = bl7 = true;
                    return n11;
                }
                int[] nArray = this.flags;
                int n17 = nArray[n15];
                ((Buffer)object3).setFlags(n17);
                long[] lArray = this.timesUs;
                ((DecoderInputBuffer)object3).timeUs = l11 = lArray[n15];
                long l12 = this.startTimeUs;
                long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
                if (l13 < 0) {
                    int n18 = -1 << -1;
                    ((Buffer)object3).addFlag(n18);
                }
                int[] nArray2 = this.sizes;
                var5_14.size = n16 = nArray2[n15];
                long[] lArray2 = this.offsets;
                var5_14.offset = l10 = lArray2[n15];
                TrackOutput$CryptoData[] trackOutput$CryptoDataArray = this.cryptoDatas;
                var5_14.cryptoData = trackOutput$CryptoData = trackOutput$CryptoDataArray[n15];
                return n12;
            }
            object3 = this.formats;
            object3 = object3[n15];
            this.onFormatResult((Format)object3, (FormatHolder)object);
            return n10;
        }
    }

    private void releaseDrmSessionReferences() {
        DrmSession drmSession = this.currentDrmSession;
        if (drmSession != null) {
            DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher = this.drmEventDispatcher;
            drmSession.release(drmSessionEventListener$EventDispatcher);
            drmSession = null;
            this.currentDrmSession = null;
            this.downstreamFormat = null;
        }
    }

    private void rewind() {
        synchronized (this) {
            SampleDataQueue sampleDataQueue = null;
            this.readPosition = 0;
            sampleDataQueue = this.sampleDataQueue;
            sampleDataQueue.rewind();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean setUpstreamFormat(Format object) {
        synchronized (this) {
            boolean bl2;
            this.upstreamFormatRequired = false;
            Object object2 = this.upstreamFormat;
            boolean bl3 = Util.areEqual(object, object2);
            if (bl3) {
                return false;
            }
            object2 = this.upstreamCommittedFormat;
            bl3 = Util.areEqual(object, object2);
            this.upstreamFormat = bl3 ? (object = this.upstreamCommittedFormat) : object;
            object = this.upstreamFormat;
            object2 = ((Format)object).sampleMimeType;
            object = ((Format)object).codecs;
            this.upstreamAllSamplesAreSyncSamples = bl2 = MimeTypes.allSamplesAreSyncSamples((String)object2, (String)object);
            this.loggedUnexpectedNonSyncSample = false;
            return true;
        }
    }

    public long discardSampleMetadataToRead() {
        synchronized (this) {
            int n10;
            block5: {
                n10 = this.readPosition;
                if (n10 != 0) break block5;
                return -1;
            }
            long l10 = this.discardSamples(n10);
            return l10;
        }
    }

    public final void discardTo(long l10, boolean bl2, boolean bl3) {
        SampleDataQueue sampleDataQueue = this.sampleDataQueue;
        l10 = this.discardSampleMetadataTo(l10, bl2, bl3);
        sampleDataQueue.discardDownstreamTo(l10);
    }

    public final void discardToEnd() {
        SampleDataQueue sampleDataQueue = this.sampleDataQueue;
        long l10 = this.discardSampleMetadataToEnd();
        sampleDataQueue.discardDownstreamTo(l10);
    }

    public final void discardToRead() {
        SampleDataQueue sampleDataQueue = this.sampleDataQueue;
        long l10 = this.discardSampleMetadataToRead();
        sampleDataQueue.discardDownstreamTo(l10);
    }

    public final void discardUpstreamFrom(long l10) {
        int n10 = this.length;
        if (!n10) {
            return;
        }
        long l11 = this.getLargestReadTimestampUs();
        long l12 = l10 - l11;
        n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
        n10 = n10 > 0 ? 1 : 0;
        Assertions.checkArgument(n10 != 0);
        int n11 = this.countUnreadSamplesBefore(l10);
        int n12 = this.absoluteFirstIndex + n11;
        this.discardUpstreamSamples(n12);
    }

    public final void discardUpstreamSamples(int n10) {
        SampleDataQueue sampleDataQueue = this.sampleDataQueue;
        long l10 = this.discardUpstreamSampleMetadata(n10);
        sampleDataQueue.discardUpstreamSampleBytes(l10);
    }

    public final void format(Format format) {
        Format format2 = this.getAdjustedUpstreamFormat(format);
        this.upstreamFormatAdjustmentRequired = false;
        this.unadjustedUpstreamFormat = format;
        boolean bl2 = this.setUpstreamFormat(format2);
        SampleQueue$UpstreamFormatChangedListener sampleQueue$UpstreamFormatChangedListener = this.upstreamFormatChangeListener;
        if (sampleQueue$UpstreamFormatChangedListener != null && bl2) {
            sampleQueue$UpstreamFormatChangedListener.onUpstreamFormatChanged(format2);
        }
    }

    public Format getAdjustedUpstreamFormat(Format format) {
        long l10;
        long l11 = this.sampleOffsetUs;
        long l12 = 0L;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object != false && (object = (l10 = (l11 = format.subsampleOffsetUs) - (l12 = Long.MAX_VALUE)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            Format$Builder format$Builder = format.buildUpon();
            long l14 = format.subsampleOffsetUs;
            long l15 = this.sampleOffsetUs;
            format = format$Builder.setSubsampleOffsetUs(l14 += l15).build();
        }
        return format;
    }

    public final int getFirstIndex() {
        return this.absoluteFirstIndex;
    }

    public final long getFirstTimestampUs() {
        synchronized (this) {
            long l10;
            block7: {
                long l11;
                block6: {
                    int n10 = this.length;
                    if (n10 != 0) break block6;
                    l10 = Long.MIN_VALUE;
                    break block7;
                }
                long[] lArray = this.timesUs;
                int n11 = this.relativeFirstIndex;
                l10 = l11 = lArray[n11];
            }
            return l10;
        }
    }

    public final long getLargestQueuedTimestampUs() {
        synchronized (this) {
            long l10 = this.largestQueuedTimestampUs;
            return l10;
        }
    }

    public final long getLargestReadTimestampUs() {
        synchronized (this) {
            long l10 = this.largestDiscardedTimestampUs;
            int n10 = this.readPosition;
            long l11 = this.getLargestTimestamp(n10);
            l10 = Math.max(l10, l11);
            return l10;
        }
    }

    public final int getReadIndex() {
        int n10 = this.absoluteFirstIndex;
        int n11 = this.readPosition;
        return n10 + n11;
    }

    public final int getSkipCount(long l10, boolean bl2) {
        synchronized (this) {
            block15: {
                int n10 = this.readPosition;
                int n11 = this.getRelativeIndex(n10);
                n10 = (int)(this.hasNextSample() ? 1 : 0);
                if (n10 == 0) break block15;
                long[] lArray = this.timesUs;
                long l11 = lArray[n11];
                n10 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
                if (n10 >= 0) {
                    int n12;
                    block16: {
                        long l12 = this.largestQueuedTimestampUs;
                        n10 = (int)(l10 == l12 ? 0 : (l10 < l12 ? -1 : 1));
                        if (n10 > 0 && bl2) {
                            int n122 = this.length;
                            int n16 = this.readPosition;
                            return n122 -= n16;
                        }
                        int n13 = this.length;
                        n10 = this.readPosition;
                        int n14 = n13 - n10;
                        boolean bl3 = true;
                        n12 = this.findSampleBefore(n11, n14, l10, bl3);
                        int n15 = -1;
                        if (n12 != n15) break block16;
                        return 0;
                    }
                    return n12;
                }
            }
            return 0;
        }
    }

    public final Format getUpstreamFormat() {
        synchronized (this) {
            Format format;
            block5: {
                boolean bl2 = this.upstreamFormatRequired;
                if (!bl2) break block5;
                bl2 = false;
                format = null;
            }
            format = this.upstreamFormat;
            return format;
            finally {
            }
        }
    }

    public final int getWriteIndex() {
        int n10 = this.absoluteFirstIndex;
        int n11 = this.length;
        return n10 + n11;
    }

    public final void invalidateUpstreamFormatAdjustment() {
        this.upstreamFormatAdjustmentRequired = true;
    }

    public final boolean isLastSampleQueued() {
        synchronized (this) {
            boolean bl2 = this.isLastSampleQueued;
            return bl2;
        }
    }

    public boolean isReady(boolean bl2) {
        synchronized (this) {
            int n10;
            block16: {
                boolean bl3;
                block13: {
                    block14: {
                        block15: {
                            boolean bl4 = this.hasNextSample();
                            bl3 = true;
                            if (bl4) break block13;
                            if (bl2) break block14;
                            boolean bl5 = this.isLastSampleQueued;
                            if (bl5) break block14;
                            Format format = this.upstreamFormat;
                            if (format == null) break block15;
                            Format format2 = this.downstreamFormat;
                            if (format != format2) break block14;
                        }
                        bl3 = false;
                    }
                    return bl3;
                }
                int n10 = this.readPosition;
                n10 = this.getRelativeIndex(n10);
                Object object = this.formats;
                object = object[n10];
                Format format = this.downstreamFormat;
                if (object == format) break block16;
                return bl3;
            }
            boolean bl6 = this.mayReadSample(n10);
            return bl6;
        }
    }

    public void maybeThrowError() {
        int n10;
        int n11;
        DrmSession drmSession = this.currentDrmSession;
        if (drmSession != null && (n11 = drmSession.getState()) == (n10 = 1)) {
            throw (DrmSession$DrmSessionException)Assertions.checkNotNull(this.currentDrmSession.getError());
        }
    }

    public final int peek(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean n10, boolean bl2) {
        SampleQueue$SampleExtrasHolder sampleQueue$SampleExtrasHolder = this.extrasHolder;
        int n11 = this.peekSampleMetadata(formatHolder, decoderInputBuffer, n10 != 0, bl2, sampleQueue$SampleExtrasHolder);
        if (n11 == (n10 = -4) && (n10 = (int)(decoderInputBuffer.isEndOfStream() ? 1 : 0)) == 0 && (n10 = (int)(decoderInputBuffer.isFlagsOnly() ? 1 : 0)) == 0) {
            SampleDataQueue sampleDataQueue = this.sampleDataQueue;
            SampleQueue$SampleExtrasHolder sampleQueue$SampleExtrasHolder2 = this.extrasHolder;
            sampleDataQueue.peekToBuffer(decoderInputBuffer, sampleQueue$SampleExtrasHolder2);
        }
        return n11;
    }

    public final int peekSourceId() {
        synchronized (this) {
            int n10;
            block9: {
                n10 = this.readPosition;
                n10 = this.getRelativeIndex(n10);
                boolean bl2 = this.hasNextSample();
                if (!bl2) break block9;
                int[] nArray = this.sourceIds;
                n10 = nArray[n10];
            }
            n10 = this.upstreamSourceId;
            return n10;
            finally {
            }
        }
    }

    public void preRelease() {
        this.discardToEnd();
        this.releaseDrmSessionReferences();
    }

    public int read(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean n10, boolean bl2) {
        SampleQueue$SampleExtrasHolder sampleQueue$SampleExtrasHolder = this.extrasHolder;
        int n11 = this.peekSampleMetadata(formatHolder, decoderInputBuffer, n10 != 0, bl2, sampleQueue$SampleExtrasHolder);
        if (n11 == (n10 = -4) && (n10 = (int)(decoderInputBuffer.isEndOfStream() ? 1 : 0)) == 0 && (n10 = (int)(decoderInputBuffer.isFlagsOnly() ? 1 : 0)) == 0) {
            int n12;
            SampleDataQueue sampleDataQueue = this.sampleDataQueue;
            SampleQueue$SampleExtrasHolder sampleQueue$SampleExtrasHolder2 = this.extrasHolder;
            sampleDataQueue.readToBuffer(decoderInputBuffer, sampleQueue$SampleExtrasHolder2);
            this.readPosition = n12 = this.readPosition + 1;
        }
        return n11;
    }

    public void release() {
        this.reset(true);
        this.releaseDrmSessionReferences();
    }

    public final void reset() {
        this.reset(false);
    }

    public void reset(boolean bl2) {
        long l10;
        boolean bl3;
        this.sampleDataQueue.reset();
        this.length = 0;
        this.absoluteFirstIndex = 0;
        this.relativeFirstIndex = 0;
        this.readPosition = 0;
        this.upstreamKeyframeRequired = bl3 = true;
        this.startTimeUs = l10 = Long.MIN_VALUE;
        this.largestDiscardedTimestampUs = l10;
        this.largestQueuedTimestampUs = l10;
        this.isLastSampleQueued = false;
        this.upstreamCommittedFormat = null;
        if (bl2) {
            this.unadjustedUpstreamFormat = null;
            this.upstreamFormat = null;
            this.upstreamFormatRequired = bl3;
        }
    }

    public final int sampleData(DataReader dataReader, int n10, boolean bl2, int n11) {
        return this.sampleDataQueue.sampleData(dataReader, n10, bl2);
    }

    public final void sampleData(ParsableByteArray parsableByteArray, int n10, int n11) {
        this.sampleDataQueue.sampleData(parsableByteArray, n10);
    }

    /*
     * Unable to fully structure code
     */
    public void sampleMetadata(long var1_1, int var3_2, int var4_3, int var5_4, TrackOutput$CryptoData var6_5) {
        var7_6 = this;
        var8_7 = this.upstreamFormatAdjustmentRequired;
        if (var8_7 != 0) {
            var9_8 = (Format)Assertions.checkStateNotNull(this.unadjustedUpstreamFormat);
            this.format((Format)var9_8);
        }
        var8_7 = var3_2 & 1;
        var10_9 = 1;
        var11_10 = var8_7 != 0 ? var10_9 : 0;
        var12_11 = var7_6.upstreamKeyframeRequired;
        if (var12_11) {
            if (var11_10 == 0) {
                return;
            }
            var7_6.upstreamKeyframeRequired = false;
        }
        var13_12 = var7_6.sampleOffsetUs + var1_1;
        var15_13 = var7_6.upstreamAllSamplesAreSyncSamples;
        if (var15_13 == 0) ** GOTO lbl-1000
        var16_14 = var7_6.startTimeUs;
        cfr_temp_0 = var13_12 - var16_14;
        var15_13 = (int)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
        if (var15_13 < 0) {
            return;
        }
        if (var8_7 == 0) {
            var8_7 = (int)var7_6.loggedUnexpectedNonSyncSample;
            if (var8_7 == 0) {
                var9_8 = String.valueOf(var7_6.upstreamFormat);
                var15_13 = String.valueOf(var9_8).length() + 50;
                var18_15 = new StringBuilder(var15_13);
                var18_15.append("Overriding unexpected non-sync sample for format: ");
                var18_15.append((String)var9_8);
                var9_8 = var18_15.toString();
                var19_16 = "SampleQueue";
                Log.w((String)var19_16, (String)var9_8);
                var7_6.loggedUnexpectedNonSyncSample = var10_9;
            }
            var15_13 = var8_7 = var3_2 | 1;
        } else lbl-1000:
        // 2 sources

        {
            var15_13 = var3_2;
        }
        var8_7 = (int)var7_6.pendingSplice;
        if (var8_7 != 0) {
            if (var11_10 != 0 && (var8_7 = (int)this.attemptSplice(var13_12)) != 0) {
                var7_6.pendingSplice = false;
            } else {
                return;
            }
        }
        var20_17 = var7_6.sampleDataQueue.getTotalBytesWritten();
        var22_18 = var4_3;
        var20_17 -= var22_18;
        var10_9 = var5_4;
        var22_18 = var5_4;
        var24_19 = var20_17 - var22_18;
        var9_8 = this;
        var26_20 = var13_12;
        var11_10 = var15_13;
        var13_12 = var24_19;
        var15_13 = var4_3;
        var18_15 = var6_5;
        this.commitSample(var26_20, var11_10, var24_19, var4_3, var6_5);
    }

    public final boolean seekTo(int n10) {
        synchronized (this) {
            block6: {
                this.rewind();
                int n11 = this.absoluteFirstIndex;
                if (n10 < n11) break block6;
                int n12 = this.length + n11;
                if (n10 > n12) break block6;
                long l10 = Long.MIN_VALUE;
                this.startTimeUs = l10;
                n10 -= n11;
                this.readPosition = n10;
                return true;
            }
            return false;
        }
    }

    public final boolean seekTo(long l10, boolean n10) {
        synchronized (this) {
            block15: {
                this.rewind();
                int n11 = this.readPosition;
                int n12 = this.getRelativeIndex(n11);
                n11 = (int)(this.hasNextSample() ? 1 : 0);
                if (n11 == 0) break block15;
                long[] lArray = this.timesUs;
                long l11 = lArray[n12];
                n11 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
                if (n11 >= 0) {
                    long l12 = this.largestQueuedTimestampUs;
                    n11 = (int)(l10 == l12 ? 0 : (l10 < l12 ? -1 : 1));
                    if (n11 <= 0 || n10 != 0) {
                        block16: {
                            n10 = this.length;
                            n11 = this.readPosition;
                            int n13 = n10 - n11;
                            boolean bl2 = true;
                            n10 = this.findSampleBefore(n12, n13, l10, bl2);
                            n11 = -1;
                            if (n10 != n11) break block16;
                            return false;
                        }
                        this.startTimeUs = l10;
                        int n14 = this.readPosition + n10;
                        this.readPosition = n14;
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public final void setSampleOffsetUs(long l10) {
        long l11 = this.sampleOffsetUs;
        long l12 = l11 - l10;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            this.sampleOffsetUs = l10;
            this.invalidateUpstreamFormatAdjustment();
        }
    }

    public final void setStartTimeUs(long l10) {
        this.startTimeUs = l10;
    }

    public final void setUpstreamFormatChangeListener(SampleQueue$UpstreamFormatChangedListener sampleQueue$UpstreamFormatChangedListener) {
        this.upstreamFormatChangeListener = sampleQueue$UpstreamFormatChangedListener;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void skip(int n10) {
        synchronized (this) {
            Throwable throwable2;
            block6: {
                int n11;
                block5: {
                    block4: {
                        if (n10 >= 0) {
                            try {
                                n11 = this.readPosition + n10;
                                int n12 = this.length;
                                if (n11 > n12) break block4;
                                n11 = 1;
                                break block5;
                            }
                            catch (Throwable throwable2) {
                                break block6;
                            }
                        }
                    }
                    n11 = 0;
                }
                Assertions.checkArgument(n11 != 0);
                this.readPosition = n11 = this.readPosition + n10;
                return;
            }
            throw throwable2;
        }
    }

    public final void sourceId(int n10) {
        this.upstreamSourceId = n10;
    }

    public final void splice() {
        this.pendingSplice = true;
    }
}

