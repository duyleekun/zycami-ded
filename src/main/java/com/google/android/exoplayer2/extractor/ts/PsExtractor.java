/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekMap$Unseekable;
import com.google.android.exoplayer2.extractor.ts.Ac3Reader;
import com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader;
import com.google.android.exoplayer2.extractor.ts.H262Reader;
import com.google.android.exoplayer2.extractor.ts.MpegAudioReader;
import com.google.android.exoplayer2.extractor.ts.PsBinarySearchSeeker;
import com.google.android.exoplayer2.extractor.ts.PsDurationReader;
import com.google.android.exoplayer2.extractor.ts.PsExtractor$PesReader;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader$TrackIdGenerator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import d.h.a.a.h0.i.d;

public final class PsExtractor
implements Extractor {
    public static final int AUDIO_STREAM = 192;
    public static final int AUDIO_STREAM_MASK = 224;
    public static final ExtractorsFactory FACTORY = d.a;
    private static final long MAX_SEARCH_LENGTH = 0x100000L;
    private static final long MAX_SEARCH_LENGTH_AFTER_AUDIO_AND_VIDEO_FOUND = 8192L;
    private static final int MAX_STREAM_ID_PLUS_ONE = 256;
    public static final int MPEG_PROGRAM_END_CODE = 441;
    public static final int PACKET_START_CODE_PREFIX = 1;
    public static final int PACK_START_CODE = 442;
    public static final int PRIVATE_STREAM_1 = 189;
    public static final int SYSTEM_HEADER_START_CODE = 443;
    public static final int VIDEO_STREAM = 224;
    public static final int VIDEO_STREAM_MASK = 240;
    private final PsDurationReader durationReader;
    private boolean foundAllTracks;
    private boolean foundAudioTrack;
    private boolean foundVideoTrack;
    private boolean hasOutputSeekMap;
    private long lastTrackPosition;
    private ExtractorOutput output;
    private PsBinarySearchSeeker psBinarySearchSeeker;
    private final ParsableByteArray psPacketBuffer;
    private final SparseArray psPayloadReaders;
    private final TimestampAdjuster timestampAdjuster;

    public PsExtractor() {
        TimestampAdjuster timestampAdjuster = new TimestampAdjuster(0L);
        this(timestampAdjuster);
    }

    public PsExtractor(TimestampAdjuster object) {
        this.timestampAdjuster = object;
        this.psPacketBuffer = object = new ParsableByteArray(4096);
        object = new SparseArray();
        this.psPayloadReaders = object;
        this.durationReader = object = new PsDurationReader();
    }

    public static /* synthetic */ Extractor[] a() {
        Extractor[] extractorArray = new Extractor[1];
        PsExtractor psExtractor = new PsExtractor();
        extractorArray[0] = psExtractor;
        return extractorArray;
    }

    private void maybeOutputSeekMap(long l10) {
        Object object = this.hasOutputSeekMap;
        if (!object) {
            long l11;
            this.hasOutputSeekMap = true;
            Object object2 = this.durationReader;
            long l12 = ((PsDurationReader)object2).getDurationUs();
            long l13 = l12 - (l11 = -9223372036854775807L);
            object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object) {
                TimestampAdjuster timestampAdjuster = this.durationReader.getScrTimestampAdjuster();
                long l14 = this.durationReader.getDurationUs();
                this.psBinarySearchSeeker = object2 = new PsBinarySearchSeeker(timestampAdjuster, l14, l10);
                ExtractorOutput extractorOutput = this.output;
                SeekMap seekMap = ((BinarySearchSeeker)object2).getSeekMap();
                extractorOutput.seekMap(seekMap);
            } else {
                ExtractorOutput extractorOutput = this.output;
                object2 = this.durationReader;
                l12 = ((PsDurationReader)object2).getDurationUs();
                SeekMap$Unseekable seekMap$Unseekable = new SeekMap$Unseekable(l12);
                extractorOutput.seekMap(seekMap$Unseekable);
            }
        }
    }

    public void init(ExtractorOutput extractorOutput) {
        this.output = extractorOutput;
    }

    public int read(ExtractorInput object, PositionHolder object2) {
        int n10;
        long l10;
        long l11;
        long l12;
        Object object3;
        int n11;
        Object object4 = this.output;
        Assertions.checkStateNotNull(object4);
        long l13 = object.getLength();
        long l14 = -1;
        long l15 = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1);
        int n12 = 1;
        if (l15 != false) {
            n11 = n12;
        } else {
            n11 = 0;
            object3 = null;
        }
        if (n11 != 0 && (n11 = ((PsDurationReader)(object3 = this.durationReader)).isDurationReadFinished()) == 0) {
            return this.durationReader.readDuration((ExtractorInput)object, (PositionHolder)object2);
        }
        this.maybeOutputSeekMap(l13);
        object3 = this.psBinarySearchSeeker;
        if (object3 != null && (n11 = ((BinarySearchSeeker)object3).isSeeking()) != 0) {
            return this.psBinarySearchSeeker.handlePendingSeek((ExtractorInput)object, (PositionHolder)object2);
        }
        object.resetPeekPosition();
        if (l15 != false) {
            l12 = object.getPeekPosition();
            l13 -= l12;
        } else {
            l13 = l14;
        }
        long l16 = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1);
        int n13 = -1;
        if (l16 != false && (l16 = (l11 = l13 - (l10 = (long)4)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) < 0) {
            return n13;
        }
        object2 = this.psPacketBuffer.getData();
        l16 = (long)object.peekFully((byte[])object2, 0, n10 = 4, n12 != 0);
        if (l16 == false) {
            return n13;
        }
        this.psPacketBuffer.setPosition(0);
        object2 = this.psPacketBuffer;
        l16 = ((ParsableByteArray)object2).readInt();
        n10 = 441;
        if (l16 == n10) {
            return n13;
        }
        n10 = 442;
        if (l16 == n10) {
            object2 = this.psPacketBuffer.getData();
            object.peekFully((byte[])object2, 0, 10);
            this.psPacketBuffer.setPosition(9);
            l16 = (this.psPacketBuffer.readUnsignedByte() & 7) + 14;
            object.skipFully((int)l16);
            return 0;
        }
        n10 = 443;
        int n14 = 2;
        n13 = 6;
        if (l16 == n10) {
            object2 = this.psPacketBuffer.getData();
            object.peekFully((byte[])object2, 0, n14);
            this.psPacketBuffer.setPosition(0);
            l16 = this.psPacketBuffer.readUnsignedShort() + n13;
            object.skipFully((int)l16);
            return 0;
        }
        n10 = (l16 & 0xFFFFFF00) >> 8;
        if (n10 != n12) {
            object.skipFully(n12);
            return 0;
        }
        l16 = l16 & 0xFF;
        object4 = (PsExtractor$PesReader)this.psPayloadReaders.get((int)l16);
        boolean bl2 = this.foundAllTracks;
        if (!bl2) {
            if (object4 == null) {
                bl2 = false;
                ElementaryStreamReader elementaryStreamReader = null;
                l15 = 189;
                if (l16 == l15) {
                    elementaryStreamReader = new Ac3Reader();
                    this.foundAudioTrack = n12;
                    this.lastTrackPosition = l12 = object.getPosition();
                } else {
                    l15 = l16 & 0xE0;
                    n11 = 192;
                    if (l15 == n11) {
                        elementaryStreamReader = new MpegAudioReader();
                        this.foundAudioTrack = n12;
                        this.lastTrackPosition = l12 = object.getPosition();
                    } else {
                        l15 = l16 & 0xF0;
                        n11 = 224;
                        if (l15 == n11) {
                            elementaryStreamReader = new H262Reader();
                            this.foundVideoTrack = n12;
                            this.lastTrackPosition = l12 = object.getPosition();
                        }
                    }
                }
                if (elementaryStreamReader != null) {
                    l15 = 256;
                    object4 = new TsPayloadReader$TrackIdGenerator((int)l16, (int)l15);
                    Object object5 = this.output;
                    elementaryStreamReader.createTracks((ExtractorOutput)object5, (TsPayloadReader$TrackIdGenerator)object4);
                    object5 = this.timestampAdjuster;
                    object4 = new PsExtractor$PesReader(elementaryStreamReader, (TimestampAdjuster)object5);
                    elementaryStreamReader = this.psPayloadReaders;
                    elementaryStreamReader.put((int)l16, object4);
                }
            }
            if ((l16 = (long)this.foundAudioTrack) != false && (l16 = (long)this.foundVideoTrack) != false) {
                l10 = this.lastTrackPosition;
                l12 = 8192L;
                l10 += l12;
            } else {
                l10 = 0x100000L;
            }
            l12 = object.getPosition();
            l16 = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1);
            if (l16 > 0) {
                this.foundAllTracks = n12;
                object2 = this.output;
                object2.endTracks();
            }
        }
        object2 = this.psPacketBuffer.getData();
        object.peekFully((byte[])object2, 0, n14);
        this.psPacketBuffer.setPosition(0);
        object2 = this.psPacketBuffer;
        l16 = ((ParsableByteArray)object2).readUnsignedShort() + n13;
        if (object4 == null) {
            object.skipFully((int)l16);
        } else {
            this.psPacketBuffer.reset((int)l16);
            byte[] byArray = this.psPacketBuffer.getData();
            object.readFully(byArray, 0, (int)l16);
            this.psPacketBuffer.setPosition(n13);
            object = this.psPacketBuffer;
            ((PsExtractor$PesReader)object4).consume((ParsableByteArray)object);
            object = this.psPacketBuffer;
            l16 = ((ParsableByteArray)object).capacity();
            ((ParsableByteArray)object).setLimit((int)l16);
        }
        return 0;
    }

    public void release() {
    }

    public void seek(long l10, long l11) {
        long l12;
        long l13;
        long l14;
        Object object = this.timestampAdjuster;
        l10 = ((TimestampAdjuster)object).getTimestampOffsetUs();
        long l15 = -9223372036854775807L;
        long l16 = l10 == l15 ? 0 : (l10 < l15 ? -1 : 1);
        int n10 = 0;
        if (l16 == false) {
            l16 = 1;
        } else {
            l16 = 0;
            object = null;
        }
        if (l16 != false || (l16 = (l14 = (l15 = ((TimestampAdjuster)(object = this.timestampAdjuster)).getFirstSampleTimestampUs()) - (l13 = 0L)) == 0L ? 0 : (l14 < 0L ? -1 : 1)) != false && (l16 = (l12 = (l15 = ((TimestampAdjuster)(object = this.timestampAdjuster)).getFirstSampleTimestampUs()) - l11) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            this.timestampAdjuster.reset();
            object = this.timestampAdjuster;
            ((TimestampAdjuster)object).setFirstSampleTimestampUs(l11);
        }
        if ((object = this.psBinarySearchSeeker) != null) {
            ((BinarySearchSeeker)object).setSeekTargetUs(l11);
        }
        while (n10 < (l16 = (long)(object = this.psPayloadReaders).size())) {
            object = (PsExtractor$PesReader)this.psPayloadReaders.valueAt(n10);
            ((PsExtractor$PesReader)object).seek();
            ++n10;
        }
    }

    public boolean sniff(ExtractorInput extractorInput) {
        int n10 = 14;
        byte[] byArray = new byte[n10];
        int n11 = 0;
        extractorInput.peekFully(byArray, 0, n10);
        n10 = (byArray[0] & 0xFF) << 24;
        int n12 = 1;
        int n13 = (byArray[n12] & 0xFF) << 16;
        n10 |= n13;
        n13 = 2;
        int n14 = byArray[n13] & 0xFF;
        int n15 = 8;
        n10 |= (n14 <<= n15);
        n14 = 3;
        int n16 = byArray[n14] & 0xFF;
        n10 |= n16;
        n16 = 442;
        if (n16 != n10) {
            return false;
        }
        n10 = 4;
        n16 = byArray[n10] & 0xC4;
        int n17 = 68;
        if (n16 != n17) {
            return false;
        }
        n16 = byArray[6] & n10;
        if (n16 != n10) {
            return false;
        }
        n16 = byArray[n15] & n10;
        if (n16 != n10) {
            return false;
        }
        n10 = byArray[9] & n12;
        if (n10 != n12) {
            return false;
        }
        n10 = byArray[12] & n14;
        if (n10 != n14) {
            return false;
        }
        n10 = byArray[13] & 7;
        extractorInput.advancePeekPosition(n10);
        extractorInput.peekFully(byArray, 0, n14);
        int n18 = (byArray[0] & 0xFF) << 16;
        n10 = (byArray[n12] & 0xFF) << n15;
        n18 |= n10;
        n10 = byArray[n13] & 0xFF;
        if (n12 == (n18 |= n10)) {
            n11 = n12;
        }
        return n11 != 0;
    }
}

