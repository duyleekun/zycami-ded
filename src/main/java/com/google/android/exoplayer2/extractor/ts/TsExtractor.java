/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 *  android.util.SparseBooleanArray
 *  android.util.SparseIntArray
 */
package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekMap$Unseekable;
import com.google.android.exoplayer2.extractor.ts.DefaultTsPayloadReaderFactory;
import com.google.android.exoplayer2.extractor.ts.SectionReader;
import com.google.android.exoplayer2.extractor.ts.TsBinarySearchSeeker;
import com.google.android.exoplayer2.extractor.ts.TsDurationReader;
import com.google.android.exoplayer2.extractor.ts.TsExtractor$PatReader;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader$Factory;
import com.google.android.exoplayer2.extractor.ts.TsUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import d.h.a.a.h0.i.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class TsExtractor
implements Extractor {
    private static final long AC3_FORMAT_IDENTIFIER = 1094921523L;
    private static final long AC4_FORMAT_IDENTIFIER = 1094921524L;
    private static final int BUFFER_SIZE = 9400;
    public static final int DEFAULT_TIMESTAMP_SEARCH_BYTES = 112800;
    private static final long E_AC3_FORMAT_IDENTIFIER = 1161904947L;
    public static final ExtractorsFactory FACTORY = e.a;
    private static final long HEVC_FORMAT_IDENTIFIER = 1212503619L;
    private static final int MAX_PID_PLUS_ONE = 8192;
    public static final int MODE_HLS = 2;
    public static final int MODE_MULTI_PMT = 0;
    public static final int MODE_SINGLE_PMT = 1;
    private static final int SNIFF_TS_PACKET_COUNT = 5;
    public static final int TS_PACKET_SIZE = 188;
    private static final int TS_PAT_PID = 0;
    public static final int TS_STREAM_TYPE_AAC_ADTS = 15;
    public static final int TS_STREAM_TYPE_AAC_LATM = 17;
    public static final int TS_STREAM_TYPE_AC3 = 129;
    public static final int TS_STREAM_TYPE_AC4 = 172;
    public static final int TS_STREAM_TYPE_AIT = 257;
    public static final int TS_STREAM_TYPE_DTS = 138;
    public static final int TS_STREAM_TYPE_DVBSUBS = 89;
    public static final int TS_STREAM_TYPE_E_AC3 = 135;
    public static final int TS_STREAM_TYPE_H262 = 2;
    public static final int TS_STREAM_TYPE_H263 = 16;
    public static final int TS_STREAM_TYPE_H264 = 27;
    public static final int TS_STREAM_TYPE_H265 = 36;
    public static final int TS_STREAM_TYPE_HDMV_DTS = 130;
    public static final int TS_STREAM_TYPE_ID3 = 21;
    public static final int TS_STREAM_TYPE_MPA = 3;
    public static final int TS_STREAM_TYPE_MPA_LSF = 4;
    public static final int TS_STREAM_TYPE_SPLICE_INFO = 134;
    public static final int TS_SYNC_BYTE = 71;
    private int bytesSinceLastSync;
    private final SparseIntArray continuityCounters;
    private final TsDurationReader durationReader;
    private boolean hasOutputSeekMap;
    private TsPayloadReader id3Reader;
    private final int mode;
    private ExtractorOutput output;
    private final TsPayloadReader$Factory payloadReaderFactory;
    private int pcrPid;
    private boolean pendingSeekToStart;
    private int remainingPmts;
    private final List timestampAdjusters;
    private final int timestampSearchBytes;
    private final SparseBooleanArray trackIds;
    private final SparseBooleanArray trackPids;
    private boolean tracksEnded;
    private TsBinarySearchSeeker tsBinarySearchSeeker;
    private final ParsableByteArray tsPacketBuffer;
    private final SparseArray tsPayloadReaders;

    public TsExtractor() {
        this(0);
    }

    public TsExtractor(int n10) {
        this(1, n10, 112800);
    }

    public TsExtractor(int n10, int n11, int n12) {
        TimestampAdjuster timestampAdjuster = new TimestampAdjuster(0L);
        DefaultTsPayloadReaderFactory defaultTsPayloadReaderFactory = new DefaultTsPayloadReaderFactory(n11);
        this(n10, timestampAdjuster, defaultTsPayloadReaderFactory, n12);
    }

    public TsExtractor(int n10, TimestampAdjuster timestampAdjuster, TsPayloadReader$Factory tsPayloadReader$Factory) {
        this(n10, timestampAdjuster, tsPayloadReader$Factory, 112800);
    }

    public TsExtractor(int n10, TimestampAdjuster object, TsPayloadReader$Factory tsPayloadReader$Factory, int n11) {
        Object object2;
        this.payloadReaderFactory = tsPayloadReader$Factory = (TsPayloadReader$Factory)Assertions.checkNotNull(tsPayloadReader$Factory);
        this.timestampSearchBytes = n11;
        this.mode = n10;
        int n12 = 1;
        if (n10 != n12 && n10 != (n12 = 2)) {
            this.timestampAdjusters = object2 = new ArrayList();
            object2.add(object);
        } else {
            object2 = Collections.singletonList(object);
            this.timestampAdjusters = object2;
        }
        object = new byte[9400];
        this.tsPacketBuffer = object2 = new ParsableByteArray((byte[])object, 0);
        object2 = new SparseBooleanArray();
        this.trackIds = object2;
        object2 = new SparseBooleanArray();
        this.trackPids = object2;
        object2 = new SparseArray();
        this.tsPayloadReaders = object2;
        object2 = new SparseIntArray();
        this.continuityCounters = object2;
        this.durationReader = object2 = new TsDurationReader(n11);
        this.pcrPid = -1;
        this.resetPayloadReaders();
    }

    public static /* synthetic */ Extractor[] a() {
        Extractor[] extractorArray = new Extractor[1];
        TsExtractor tsExtractor = new TsExtractor();
        extractorArray[0] = tsExtractor;
        return extractorArray;
    }

    public static /* synthetic */ SparseArray access$000(TsExtractor tsExtractor) {
        return tsExtractor.tsPayloadReaders;
    }

    public static /* synthetic */ int access$100(TsExtractor tsExtractor) {
        return tsExtractor.remainingPmts;
    }

    public static /* synthetic */ boolean access$1000(TsExtractor tsExtractor) {
        return tsExtractor.tracksEnded;
    }

    public static /* synthetic */ boolean access$1002(TsExtractor tsExtractor, boolean bl2) {
        tsExtractor.tracksEnded = bl2;
        return bl2;
    }

    public static /* synthetic */ int access$102(TsExtractor tsExtractor, int n10) {
        tsExtractor.remainingPmts = n10;
        return n10;
    }

    public static /* synthetic */ int access$108(TsExtractor tsExtractor) {
        int n10;
        int n11 = tsExtractor.remainingPmts;
        tsExtractor.remainingPmts = n10 = n11 + 1;
        return n11;
    }

    public static /* synthetic */ int access$200(TsExtractor tsExtractor) {
        return tsExtractor.mode;
    }

    public static /* synthetic */ List access$300(TsExtractor tsExtractor) {
        return tsExtractor.timestampAdjusters;
    }

    public static /* synthetic */ int access$402(TsExtractor tsExtractor, int n10) {
        tsExtractor.pcrPid = n10;
        return n10;
    }

    public static /* synthetic */ TsPayloadReader access$500(TsExtractor tsExtractor) {
        return tsExtractor.id3Reader;
    }

    public static /* synthetic */ TsPayloadReader access$502(TsExtractor tsExtractor, TsPayloadReader tsPayloadReader) {
        tsExtractor.id3Reader = tsPayloadReader;
        return tsPayloadReader;
    }

    public static /* synthetic */ TsPayloadReader$Factory access$600(TsExtractor tsExtractor) {
        return tsExtractor.payloadReaderFactory;
    }

    public static /* synthetic */ ExtractorOutput access$700(TsExtractor tsExtractor) {
        return tsExtractor.output;
    }

    public static /* synthetic */ SparseBooleanArray access$800(TsExtractor tsExtractor) {
        return tsExtractor.trackIds;
    }

    public static /* synthetic */ SparseBooleanArray access$900(TsExtractor tsExtractor) {
        return tsExtractor.trackPids;
    }

    private boolean fillBufferWithAtLeastOnePacket(ExtractorInput extractorInput) {
        int n10;
        byte[] byArray = this.tsPacketBuffer.getData();
        ParsableByteArray parsableByteArray = this.tsPacketBuffer;
        int n11 = parsableByteArray.getPosition();
        int n12 = 188;
        if ((n11 = 9400 - n11) < n12) {
            ParsableByteArray parsableByteArray2;
            parsableByteArray = this.tsPacketBuffer;
            n11 = parsableByteArray.bytesLeft();
            if (n11 > 0) {
                parsableByteArray2 = this.tsPacketBuffer;
                n10 = parsableByteArray2.getPosition();
                System.arraycopy(byArray, n10, byArray, 0, n11);
            }
            parsableByteArray2 = this.tsPacketBuffer;
            parsableByteArray2.reset(byArray, n11);
        }
        while ((n11 = (parsableByteArray = this.tsPacketBuffer).bytesLeft()) < n12) {
            int n13;
            parsableByteArray = this.tsPacketBuffer;
            n11 = parsableByteArray.limit();
            n10 = 9400 - n11;
            if ((n10 = extractorInput.read(byArray, n11, n10)) == (n13 = -1)) {
                return false;
            }
            ParsableByteArray parsableByteArray3 = this.tsPacketBuffer;
            parsableByteArray3.setLimit(n11 += n10);
        }
        return true;
    }

    private int findEndOfFirstTsPacketInBuffer() {
        Object object = this.tsPacketBuffer;
        int n10 = ((ParsableByteArray)object).getPosition();
        ParsableByteArray parsableByteArray = this.tsPacketBuffer;
        int n11 = parsableByteArray.limit();
        byte[] byArray = this.tsPacketBuffer.getData();
        int n12 = TsUtil.findSyncBytePosition(byArray, n10, n11);
        ParsableByteArray parsableByteArray2 = this.tsPacketBuffer;
        parsableByteArray2.setPosition(n12);
        int n13 = n12 + 188;
        if (n13 > n11) {
            n11 = this.bytesSinceLastSync;
            this.bytesSinceLastSync = n11 += (n12 -= n10);
            n10 = this.mode;
            n12 = 2;
            if (n10 == n12 && n11 > (n10 = 376)) {
                object = new ParserException("Cannot find sync byte. Most likely not a Transport Stream.");
                throw object;
            }
        } else {
            n10 = 0;
            object = null;
            this.bytesSinceLastSync = 0;
        }
        return n13;
    }

    private void maybeOutputSeekMap(long l10) {
        Object object = this.hasOutputSeekMap;
        if (!object) {
            long l11;
            this.hasOutputSeekMap = true;
            Object object2 = this.durationReader;
            long l12 = ((TsDurationReader)object2).getDurationUs();
            long l13 = l12 - (l11 = -9223372036854775807L);
            object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object) {
                TimestampAdjuster timestampAdjuster = this.durationReader.getPcrTimestampAdjuster();
                long l14 = this.durationReader.getDurationUs();
                int n10 = this.pcrPid;
                int n11 = this.timestampSearchBytes;
                this.tsBinarySearchSeeker = object2 = new TsBinarySearchSeeker(timestampAdjuster, l14, l10, n10, n11);
                ExtractorOutput extractorOutput = this.output;
                SeekMap seekMap = ((BinarySearchSeeker)object2).getSeekMap();
                extractorOutput.seekMap(seekMap);
            } else {
                ExtractorOutput extractorOutput = this.output;
                object2 = this.durationReader;
                l12 = ((TsDurationReader)object2).getDurationUs();
                SeekMap$Unseekable seekMap$Unseekable = new SeekMap$Unseekable(l12);
                extractorOutput.seekMap(seekMap$Unseekable);
            }
        }
    }

    private void resetPayloadReaders() {
        this.trackIds.clear();
        this.tsPayloadReaders.clear();
        SparseArray sparseArray = this.payloadReaderFactory.createInitialPayloadReaders();
        int n10 = sparseArray.size();
        TsExtractor$PatReader tsExtractor$PatReader = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            SparseArray sparseArray2 = this.tsPayloadReaders;
            int n11 = sparseArray.keyAt(i10);
            TsPayloadReader tsPayloadReader = (TsPayloadReader)sparseArray.valueAt(i10);
            sparseArray2.put(n11, (Object)tsPayloadReader);
        }
        sparseArray = this.tsPayloadReaders;
        tsExtractor$PatReader = new TsExtractor$PatReader(this);
        SectionReader sectionReader = new SectionReader(tsExtractor$PatReader);
        sparseArray.put(0, (Object)sectionReader);
        this.id3Reader = null;
    }

    private boolean shouldConsumePacketPayload(int n10) {
        SparseBooleanArray sparseBooleanArray;
        int n11 = this.mode;
        boolean bl2 = false;
        int n12 = 2;
        if (n11 == n12 || (n11 = (int)(this.tracksEnded ? 1 : 0)) != 0 || (n10 = (int)((sparseBooleanArray = this.trackPids).get(n10, false) ? 1 : 0)) == 0) {
            bl2 = true;
        }
        return bl2;
    }

    public void init(ExtractorOutput extractorOutput) {
        this.output = extractorOutput;
    }

    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) {
        long l10;
        long l11;
        ParsableByteArray parsableByteArray;
        int n10;
        TsPayloadReader tsPayloadReader;
        int n11;
        int n12;
        Object object;
        TsExtractor tsExtractor = this;
        ExtractorInput extractorInput2 = extractorInput;
        Object object2 = positionHolder;
        long l12 = extractorInput.getLength();
        Object object3 = this.tracksEnded;
        long l13 = -1;
        int n13 = 2;
        int n14 = 1;
        if (object3 != 0) {
            object3 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
            if (object3 != 0 && (object3 = this.mode) != n13) {
                object3 = n14;
            } else {
                object3 = 0;
                object = null;
            }
            if (object3 != 0 && (object3 = (Object)((TsDurationReader)(object = tsExtractor.durationReader)).isDurationReadFinished()) == 0) {
                TsDurationReader tsDurationReader = tsExtractor.durationReader;
                int n15 = tsExtractor.pcrPid;
                return tsDurationReader.readDuration(extractorInput2, (PositionHolder)object2, n15);
            }
            tsExtractor.maybeOutputSeekMap(l12);
            object3 = tsExtractor.pendingSeekToStart;
            if (object3 != 0) {
                tsExtractor.pendingSeekToStart = false;
                long l14 = 0L;
                tsExtractor.seek(l14, l14);
                long l15 = extractorInput.getPosition();
                object3 = l15 == l14 ? 0 : (l15 < l14 ? -1 : 1);
                if (object3 != 0) {
                    ((PositionHolder)object2).position = l14;
                    return n14;
                }
            }
            if ((object = tsExtractor.tsBinarySearchSeeker) != null && (object3 = (Object)((BinarySearchSeeker)object).isSeeking()) != 0) {
                return tsExtractor.tsBinarySearchSeeker.handlePendingSeek(extractorInput2, (PositionHolder)object2);
            }
        }
        if ((n12 = this.fillBufferWithAtLeastOnePacket(extractorInput)) == 0) {
            return -1;
        }
        n12 = this.findEndOfFirstTsPacketInBuffer();
        if (n12 > (n11 = ((ParsableByteArray)(object2 = tsExtractor.tsPacketBuffer)).limit())) {
            return 0;
        }
        object = tsExtractor.tsPacketBuffer;
        object3 = ((ParsableByteArray)object).readInt();
        int n16 = 0x800000 & object3;
        if (n16 != 0) {
            tsExtractor.tsPacketBuffer.setPosition(n12);
            return 0;
        }
        n16 = 0x400000 & object3;
        n16 = n16 != 0 ? n14 : 0;
        n16 |= 0;
        int n17 = (0x1FFF00 & object3) >> 8;
        int n18 = object3 & 0x20;
        n18 = n18 != 0 ? n14 : 0;
        int n19 = object3 & 0x10;
        if (n19 != 0) {
            n19 = n14;
        } else {
            n19 = 0;
            tsPayloadReader = null;
        }
        if (n19 != 0) {
            tsPayloadReader = (TsPayloadReader)tsExtractor.tsPayloadReaders.get(n17);
        } else {
            n19 = 0;
            tsPayloadReader = null;
        }
        if (tsPayloadReader == null) {
            tsExtractor.tsPacketBuffer.setPosition(n12);
            return 0;
        }
        int n20 = tsExtractor.mode;
        if (n20 != n13) {
            SparseIntArray sparseIntArray = tsExtractor.continuityCounters;
            n10 = (object3 &= 0xF) + -1;
            n10 = sparseIntArray.get(n17, n10);
            SparseIntArray sparseIntArray2 = tsExtractor.continuityCounters;
            sparseIntArray2.put(n17, object3);
            if (n10 == object3) {
                tsExtractor.tsPacketBuffer.setPosition(n12);
                return 0;
            }
            if (object3 != (n10 = n10 + n14 & 0xF)) {
                tsPayloadReader.seek();
            }
        }
        if (n18 != 0) {
            object = tsExtractor.tsPacketBuffer;
            object3 = ((ParsableByteArray)object).readUnsignedByte();
            parsableByteArray = tsExtractor.tsPacketBuffer;
            n10 = parsableByteArray.readUnsignedByte() & 0x40;
            if (n10 != 0) {
                n10 = n13;
            } else {
                n10 = 0;
                parsableByteArray = null;
            }
            n16 |= n10;
            parsableByteArray = tsExtractor.tsPacketBuffer;
            parsableByteArray.skipBytes((int)(object3 -= n14));
        }
        object3 = tsExtractor.tracksEnded;
        n10 = tsExtractor.shouldConsumePacketPayload(n17);
        if (n10 != 0) {
            tsExtractor.tsPacketBuffer.setLimit(n12);
            parsableByteArray = tsExtractor.tsPacketBuffer;
            tsPayloadReader.consume(parsableByteArray, n16);
            parsableByteArray = tsExtractor.tsPacketBuffer;
            parsableByteArray.setLimit(n11);
        }
        if ((n11 = tsExtractor.mode) != n13 && object3 == 0 && (n11 = (int)(tsExtractor.tracksEnded ? 1 : 0)) != 0 && (n11 = (int)((l11 = l12 - (l10 = (long)-1)) == 0L ? 0 : (l11 < 0L ? -1 : 1))) != 0) {
            tsExtractor.pendingSeekToStart = n14;
        }
        tsExtractor.tsPacketBuffer.setPosition(n12);
        return 0;
    }

    public void release() {
    }

    public void seek(long l10, long l11) {
        Object object;
        long l12;
        Object object2;
        int n10 = this.mode;
        int n11 = 1;
        int n12 = 2;
        if (n10 != n12) {
            n10 = n11;
        } else {
            n10 = 0;
            object2 = null;
        }
        Assertions.checkState(n10 != 0);
        object2 = this.timestampAdjusters;
        n10 = object2.size();
        n12 = 0;
        while (true) {
            long l13;
            long l14;
            long l15;
            long l16;
            l12 = 0L;
            if (n12 >= n10) break;
            TimestampAdjuster timestampAdjuster = (TimestampAdjuster)this.timestampAdjusters.get(n12);
            long l17 = timestampAdjuster.getTimestampOffsetUs();
            long l18 = l17 - (l16 = -9223372036854775807L);
            Object object3 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
            object3 = object3 == false ? (Object)n11 : (Object)0;
            if (object3 != false || (l15 = (l14 = (l17 = timestampAdjuster.getTimestampOffsetUs()) - l12) == 0L ? 0 : (l14 < 0L ? -1 : 1)) != false && (l15 = (l13 = (l12 = timestampAdjuster.getFirstSampleTimestampUs()) - l11) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false) {
                timestampAdjuster.reset();
                timestampAdjuster.setFirstSampleTimestampUs(l11);
            }
            ++n12;
        }
        n10 = (int)(l11 == l12 ? 0 : (l11 < l12 ? -1 : 1));
        if (n10 != 0 && (object2 = this.tsBinarySearchSeeker) != null) {
            ((BinarySearchSeeker)object2).setSeekTargetUs(l11);
        }
        this.tsPacketBuffer.reset(0);
        this.continuityCounters.clear();
        object2 = null;
        for (n10 = 0; n10 < (n11 = (object = this.tsPayloadReaders).size()); ++n10) {
            object = (TsPayloadReader)this.tsPayloadReaders.valueAt(n10);
            object.seek();
        }
        this.bytesSinceLastSync = 0;
    }

    public boolean sniff(ExtractorInput extractorInput) {
        int n10;
        byte[] byArray = this.tsPacketBuffer.getData();
        extractorInput.peekFully(byArray, 0, 940);
        for (int i10 = 0; i10 < (n10 = 188); ++i10) {
            int n11;
            block3: {
                n10 = 0;
                while (true) {
                    int n12 = 5;
                    n11 = 1;
                    if (n10 >= n12) break;
                    n12 = n10 * 188 + i10;
                    int n13 = 71;
                    if ((n12 = byArray[n12]) != n13) {
                        n10 = 0;
                        break block3;
                    }
                    ++n10;
                }
                n10 = n11;
            }
            if (n10 == 0) continue;
            extractorInput.skipFully(i10);
            return n11 != 0;
        }
        return false;
    }
}

