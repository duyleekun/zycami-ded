/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.android.exoplayer2.audio.MpegAudioUtil$Header;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.Id3Peeker;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.mp3.ConstantBitrateSeeker;
import com.google.android.exoplayer2.extractor.mp3.IndexSeeker;
import com.google.android.exoplayer2.extractor.mp3.MlltSeeker;
import com.google.android.exoplayer2.extractor.mp3.Seeker;
import com.google.android.exoplayer2.extractor.mp3.Seeker$UnseekableSeeker;
import com.google.android.exoplayer2.extractor.mp3.VbriSeeker;
import com.google.android.exoplayer2.extractor.mp3.XingSeeker;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder$FramePredicate;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import d.h.a.a.h0.f.a;
import d.h.a.a.h0.f.b;
import java.io.EOFException;

public final class Mp3Extractor
implements Extractor {
    public static final ExtractorsFactory FACTORY = a.a;
    public static final int FLAG_DISABLE_ID3_METADATA = 4;
    public static final int FLAG_ENABLE_CONSTANT_BITRATE_SEEKING = 1;
    public static final int FLAG_ENABLE_INDEX_SEEKING = 2;
    private static final int MAX_SNIFF_BYTES = 32768;
    private static final int MAX_SYNC_BYTES = 131072;
    private static final int MPEG_AUDIO_HEADER_MASK = 16649216;
    private static final Id3Decoder$FramePredicate REQUIRED_ID3_FRAME_PREDICATE = b.a;
    private static final int SCRATCH_LENGTH = 10;
    private static final int SEEK_HEADER_INFO = 1231971951;
    private static final int SEEK_HEADER_UNSET = 0;
    private static final int SEEK_HEADER_VBRI = 1447187017;
    private static final int SEEK_HEADER_XING = 1483304551;
    private long basisTimeUs;
    private TrackOutput currentTrackOutput;
    private boolean disableSeeking;
    private ExtractorOutput extractorOutput;
    private long firstSamplePosition;
    private final int flags;
    private final long forcedFirstSampleTimestampUs;
    private final GaplessInfoHolder gaplessInfoHolder;
    private final Id3Peeker id3Peeker;
    private boolean isSeekInProgress;
    private Metadata metadata;
    private TrackOutput realTrackOutput;
    private int sampleBytesRemaining;
    private long samplesRead;
    private final ParsableByteArray scratch;
    private long seekTimeUs;
    private Seeker seeker;
    private final TrackOutput skippingTrackOutput;
    private final MpegAudioUtil$Header synchronizedHeader;
    private int synchronizedHeaderData;

    public Mp3Extractor() {
        this(0);
    }

    public Mp3Extractor(int n10) {
        this(n10, -9223372036854775807L);
    }

    public Mp3Extractor(int n10, long l10) {
        this.flags = n10;
        this.forcedFirstSampleTimestampUs = l10;
        Object object = new ParsableByteArray(10);
        this.scratch = object;
        this.synchronizedHeader = object = new MpegAudioUtil$Header();
        this.gaplessInfoHolder = object = new GaplessInfoHolder();
        this.basisTimeUs = -9223372036854775807L;
        this.id3Peeker = object = new Id3Peeker();
        this.skippingTrackOutput = object = new DummyTrackOutput();
        this.currentTrackOutput = object;
    }

    public static /* synthetic */ Extractor[] a() {
        Extractor[] extractorArray = new Extractor[1];
        Mp3Extractor mp3Extractor = new Mp3Extractor();
        extractorArray[0] = mp3Extractor;
        return extractorArray;
    }

    private void assertInitialized() {
        Assertions.checkStateNotNull(this.realTrackOutput);
        Util.castNonNull(this.extractorOutput);
    }

    public static /* synthetic */ boolean b(int n10, int n11, int n12, int n13, int n14) {
        int n15 = 2;
        int n16 = 77;
        int n17 = 67;
        n10 = n11 == n17 && n12 == (n17 = 79) && n13 == n16 && (n14 == n16 || n10 == n15) || n11 == n16 && n12 == (n11 = 76) && n13 == n11 && (n14 == (n11 = 84) || n10 == n15) ? 1 : 0;
        return n10 != 0;
    }

    /*
     * Unable to fully structure code
     */
    private Seeker computeSeeker(ExtractorInput var1_1) {
        var2_2 = this.maybeReadSeekFrame((ExtractorInput)var1_1);
        var3_3 = this.metadata;
        var4_4 = var1_1.getPosition();
        var3_3 = Mp3Extractor.maybeHandleSeekMetadata((Metadata)var3_3, var4_4);
        var6_5 = this.disableSeeking;
        if (var6_5) {
            var1_1 = new Seeker$UnseekableSeeker();
            return var1_1;
        }
        var6_5 = false;
        var7_6 = this.flags & 2;
        if (var7_6 != 0) {
            var4_4 = -1;
            if (var3_3 != null) {
                var4_4 = var3_3.getDurationUs();
                var8_7 = var3_3.getDataEndPosition();
lbl16:
                // 2 sources

                while (true) {
                    var10_9 = var8_7;
                    var12_10 = var4_4;
                    break;
                }
            } else {
                if (var2_2 != null) {
                    var4_4 = var2_2.getDurationUs();
                    var8_7 = var2_2.getDataEndPosition();
                    ** continue;
                }
                var2_2 = this.metadata;
                var12_10 = var8_8 = Mp3Extractor.getId3TlenUs((Metadata)var2_2);
                var10_9 = var4_4;
            }
            var14_11 = var1_1.getPosition();
            var2_2 = new IndexSeeker(var12_10, var14_11, var10_9);
        } else if (var3_3 != null) {
            var2_2 = var3_3;
        } else if (var2_2 == null) {
            var2_2 = null;
        }
        if (var2_2 == null || (var16_12 = var2_2.isSeekable()) == 0 && (var16_12 = this.flags & 1) != 0) {
            var2_2 = this.getConstantBitrateSeeker((ExtractorInput)var1_1);
        }
        return var2_2;
    }

    private long computeTimeUs(long l10) {
        long l11 = this.basisTimeUs;
        l10 *= 1000000L;
        long l12 = this.synchronizedHeader.sampleRate;
        return l11 + (l10 /= l12);
    }

    private Seeker getConstantBitrateSeeker(ExtractorInput extractorInput) {
        Object object = this.scratch.getData();
        extractorInput.peekFully((byte[])object, 0, 4);
        this.scratch.setPosition(0);
        object = this.synchronizedHeader;
        int n10 = this.scratch.readInt();
        ((MpegAudioUtil$Header)object).setForHeaderData(n10);
        long l10 = extractorInput.getLength();
        long l11 = extractorInput.getPosition();
        MpegAudioUtil$Header mpegAudioUtil$Header = this.synchronizedHeader;
        object = new ConstantBitrateSeeker(l10, l11, mpegAudioUtil$Header);
        return object;
    }

    private static long getId3TlenUs(Metadata metadata) {
        if (metadata != null) {
            int n10 = metadata.length();
            for (int i10 = 0; i10 < n10; ++i10) {
                Metadata$Entry metadata$Entry = metadata.get(i10);
                boolean bl2 = metadata$Entry instanceof TextInformationFrame;
                if (!bl2) continue;
                metadata$Entry = (TextInformationFrame)metadata$Entry;
                String string2 = ((Id3Frame)metadata$Entry).id;
                String string3 = "TLEN";
                bl2 = string2.equals(string3);
                if (!bl2) continue;
                return C.msToUs(Long.parseLong(((TextInformationFrame)metadata$Entry).value));
            }
        }
        return -9223372036854775807L;
    }

    private static int getSeekFrameHeader(ParsableByteArray parsableByteArray, int n10) {
        int n11;
        int n12 = parsableByteArray.limit();
        if (n12 >= (n11 = n10 + 4)) {
            parsableByteArray.setPosition(n10);
            n10 = parsableByteArray.readInt();
            n12 = 1483304551;
            if (n10 == n12 || n10 == (n12 = 1231971951)) {
                return n10;
            }
        }
        if ((n10 = parsableByteArray.limit()) >= (n12 = 40)) {
            parsableByteArray.setPosition(36);
            int n13 = parsableByteArray.readInt();
            n10 = 1447187017;
            if (n13 == n10) {
                return n10;
            }
        }
        return 0;
    }

    private static boolean headersMatch(int n10, long l10) {
        int n11 = -128000;
        long l11 = n10 & n11;
        long l12 = 4294839296L;
        long l13 = l10 & l12;
        long l14 = l11 - l13;
        n10 = (n10 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1))) == 0 ? 1 : 0;
        return n10 != 0;
    }

    private static MlltSeeker maybeHandleSeekMetadata(Metadata metadata, long l10) {
        if (metadata != null) {
            int n10 = metadata.length();
            for (int i10 = 0; i10 < n10; ++i10) {
                Metadata$Entry metadata$Entry = metadata.get(i10);
                boolean bl2 = metadata$Entry instanceof MlltFrame;
                if (!bl2) continue;
                metadata$Entry = (MlltFrame)metadata$Entry;
                long l11 = Mp3Extractor.getId3TlenUs(metadata);
                return MlltSeeker.create(l10, (MlltFrame)metadata$Entry, l11);
            }
        }
        return null;
    }

    private Seeker maybeReadSeekFrame(ExtractorInput extractorInput) {
        int n10 = this.synchronizedHeader.frameSize;
        ParsableByteArray parsableByteArray = new ParsableByteArray(n10);
        Object object = parsableByteArray.getData();
        Object object2 = this.synchronizedHeader;
        int n11 = ((MpegAudioUtil$Header)object2).frameSize;
        extractorInput.peekFully((byte[])object, 0, n11);
        object = this.synchronizedHeader;
        n11 = ((MpegAudioUtil$Header)object).version;
        int n12 = 1;
        int n13 = 21;
        if ((n11 &= n12) != 0) {
            n10 = ((MpegAudioUtil$Header)object).channels;
            if (n10 != n12) {
                n13 = 36;
            }
        } else {
            n10 = ((MpegAudioUtil$Header)object).channels;
            if (n10 == n12) {
                n13 = 13;
            }
        }
        int n14 = n13;
        int n15 = Mp3Extractor.getSeekFrameHeader(parsableByteArray, n13);
        n10 = 1483304551;
        int n16 = 1231971951;
        if (n15 != n10 && n15 != n16) {
            n10 = 1447187017;
            if (n15 == n10) {
                long l10 = extractorInput.getLength();
                long l11 = extractorInput.getPosition();
                MpegAudioUtil$Header mpegAudioUtil$Header = this.synchronizedHeader;
                object = VbriSeeker.create(l10, l11, mpegAudioUtil$Header, parsableByteArray);
                object2 = this.synchronizedHeader;
                n11 = ((MpegAudioUtil$Header)object2).frameSize;
                extractorInput.skipFully(n11);
            } else {
                n10 = 0;
                object = null;
                extractorInput.resetPeekPosition();
            }
        } else {
            MpegAudioUtil$Header mpegAudioUtil$Header;
            long l12;
            long l13 = extractorInput.getLength();
            object = XingSeeker.create(l13, l12 = extractorInput.getPosition(), mpegAudioUtil$Header = this.synchronizedHeader, parsableByteArray);
            if (object != null && (n11 = (int)(((GaplessInfoHolder)(object2 = this.gaplessInfoHolder)).hasGaplessInfo() ? 1 : 0)) == 0) {
                extractorInput.resetPeekPosition();
                extractorInput.advancePeekPosition(n14 += 141);
                object2 = this.scratch.getData();
                extractorInput.peekFully((byte[])object2, 0, 3);
                this.scratch.setPosition(0);
                object2 = this.gaplessInfoHolder;
                ParsableByteArray parsableByteArray2 = this.scratch;
                n12 = parsableByteArray2.readUnsignedInt24();
                ((GaplessInfoHolder)object2).setFromXingHeaderValue(n12);
            }
            object2 = this.synchronizedHeader;
            n11 = ((MpegAudioUtil$Header)object2).frameSize;
            extractorInput.skipFully(n11);
            if (object != null && (n11 = (int)(object.isSeekable() ? 1 : 0)) == 0 && n15 == n16) {
                return this.getConstantBitrateSeeker(extractorInput);
            }
        }
        return object;
    }

    private boolean peekEndOfStreamOrHeader(ExtractorInput extractorInput) {
        long l10;
        long l11;
        long l12;
        long l13;
        long l14;
        long l15;
        Object object = this.seeker;
        boolean bl2 = true;
        if (object != null && (l15 = (l14 = (l13 = object.getDataEndPosition()) - (l12 = (long)-1)) == 0L ? 0 : (l14 < 0L ? -1 : 1)) != false && (l15 = (l11 = (l12 = extractorInput.getPeekPosition()) - (l13 -= (l10 = (long)4))) == 0L ? 0 : (l11 < 0L ? -1 : 1)) > 0) {
            return bl2;
        }
        try {
            object = this.scratch;
        }
        catch (EOFException eOFException) {
            return bl2;
        }
        object = ((ParsableByteArray)object).getData();
        int n10 = 4;
        return extractorInput.peekFully((byte[])object, 0, n10, bl2) ^ bl2;
    }

    private int readInternal(ExtractorInput extractorInput) {
        Object object;
        int n10 = this.synchronizedHeaderData;
        if (n10 == 0) {
            n10 = 0;
            object = null;
            try {
                this.synchronize(extractorInput, false);
            }
            catch (EOFException eOFException) {
                return -1;
            }
        }
        if ((object = this.seeker) == null) {
            long l10;
            object = this.computeSeeker(extractorInput);
            this.seeker = object;
            this.extractorOutput.seekMap((SeekMap)object);
            object = this.currentTrackOutput;
            Object object2 = new Format$Builder();
            Object object3 = this.synchronizedHeader.mimeType;
            object2 = ((Format$Builder)object2).setSampleMimeType((String)object3).setMaxInputSize(4096);
            int n11 = this.synchronizedHeader.channels;
            object2 = ((Format$Builder)object2).setChannelCount(n11);
            n11 = this.synchronizedHeader.sampleRate;
            object2 = ((Format$Builder)object2).setSampleRate(n11);
            n11 = this.gaplessInfoHolder.encoderDelay;
            object2 = ((Format$Builder)object2).setEncoderDelay(n11);
            object3 = this.gaplessInfoHolder;
            n11 = ((GaplessInfoHolder)object3).encoderPadding;
            object2 = ((Format$Builder)object2).setEncoderPadding(n11);
            n11 = this.flags & 4;
            if (n11 != 0) {
                n11 = 0;
                object3 = null;
            } else {
                object3 = this.metadata;
            }
            object2 = ((Format$Builder)object2).setMetadata((Metadata)object3).build();
            object.format((Format)object2);
            this.firstSamplePosition = l10 = extractorInput.getPosition();
        } else {
            long l11;
            long l12;
            long l13 = this.firstSamplePosition;
            long l14 = 0L;
            long l15 = l13 - l14;
            n10 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
            if (n10 != 0 && (l12 = (l11 = (l13 = extractorInput.getPosition()) - (l14 = this.firstSamplePosition)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) < 0) {
                n10 = (int)(l14 -= l13);
                extractorInput.skipFully(n10);
            }
        }
        return this.readSample(extractorInput);
    }

    private int readSample(ExtractorInput extractorInput) {
        int n10;
        long l10;
        Object object;
        int n11;
        long l11;
        Object object2;
        int n12 = this.sampleBytesRemaining;
        int n13 = 1;
        int n14 = -1;
        if (n12 == 0) {
            extractorInput.resetPeekPosition();
            n12 = (int)(this.peekEndOfStreamOrHeader(extractorInput) ? 1 : 0);
            if (n12 != 0) {
                return n14;
            }
            this.scratch.setPosition(0);
            object2 = this.scratch;
            n12 = ((ParsableByteArray)object2).readInt();
            l11 = this.synchronizedHeaderData;
            n11 = (int)(Mp3Extractor.headersMatch(n12, l11) ? 1 : 0);
            if (n11 != 0 && (n11 = MpegAudioUtil.getFrameSize(n12)) != n14) {
                object = this.synchronizedHeader;
                ((MpegAudioUtil$Header)object).setForHeaderData(n12);
                l11 = this.basisTimeUs;
                long l12 = -9223372036854775807L;
                n12 = (int)(l11 == l12 ? 0 : (l11 < l12 ? -1 : 1));
                if (n12 == 0) {
                    object2 = this.seeker;
                    l11 = extractorInput.getPosition();
                    this.basisTimeUs = l11 = object2.getTimeUs(l11);
                    l11 = this.forcedFirstSampleTimestampUs;
                    long l13 = l11 - l12;
                    n12 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
                    if (n12 != 0) {
                        object2 = this.seeker;
                        l11 = object2.getTimeUs(0L);
                        l12 = this.basisTimeUs;
                        long l14 = this.forcedFirstSampleTimestampUs - l11;
                        this.basisTimeUs = l12 += l14;
                    }
                }
                object2 = this.synchronizedHeader;
                this.sampleBytesRemaining = n11 = ((MpegAudioUtil$Header)object2).frameSize;
                object = this.seeker;
                boolean bl2 = object instanceof IndexSeeker;
                if (bl2) {
                    object = (IndexSeeker)object;
                    l10 = this.samplesRead;
                    long l15 = ((MpegAudioUtil$Header)object2).samplesPerFrame;
                    l10 += l15;
                    l10 = this.computeTimeUs(l10);
                    l15 = extractorInput.getPosition();
                    object2 = this.synchronizedHeader;
                    long l16 = ((MpegAudioUtil$Header)object2).frameSize;
                    ((IndexSeeker)object).maybeAddSeekPoint(l10, l15 += l16);
                    n12 = (int)(this.isSeekInProgress ? 1 : 0);
                    if (n12 != 0 && (n12 = (int)(((IndexSeeker)object).isTimeUsInIndex(l10 = this.seekTimeUs) ? 1 : 0)) != 0) {
                        this.isSeekInProgress = false;
                        this.currentTrackOutput = object2 = this.realTrackOutput;
                    }
                }
            } else {
                extractorInput.skipFully(n13);
                this.synchronizedHeaderData = 0;
                return 0;
            }
        }
        if ((n10 = (object2 = this.currentTrackOutput).sampleData(extractorInput, n11 = this.sampleBytesRemaining, n13 != 0)) == n14) {
            return n14;
        }
        this.sampleBytesRemaining = n12 = this.sampleBytesRemaining - n10;
        if (n12 > 0) {
            return 0;
        }
        object = this.currentTrackOutput;
        long l17 = this.samplesRead;
        l10 = this.computeTimeUs(l17);
        int n15 = this.synchronizedHeader.frameSize;
        object.sampleMetadata(l10, 1, n15, 0, null);
        l17 = this.samplesRead;
        l11 = this.synchronizedHeader.samplesPerFrame;
        this.samplesRead = l17 += l11;
        this.sampleBytesRemaining = 0;
        return 0;
    }

    private boolean synchronize(ExtractorInput object, boolean bl2) {
        int n10;
        Object object2;
        Object object3;
        int n11 = bl2 ? 32768 : 131072;
        object.resetPeekPosition();
        long l10 = object.getPosition();
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        int n12 = 4;
        int n13 = 1;
        if (l12 == false) {
            l12 = this.flags & n12;
            if (l12 == false) {
                l12 = n13;
            } else {
                l12 = 0;
                object3 = null;
            }
            if (l12 != false) {
                l12 = 0;
                object3 = null;
            } else {
                object3 = REQUIRED_ID3_FRAME_PREDICATE;
            }
            object2 = this.id3Peeker;
            this.metadata = object3 = ((Id3Peeker)object2).peekId3Data((ExtractorInput)object, (Id3Decoder$FramePredicate)object3);
            if (object3 != null) {
                object2 = this.gaplessInfoHolder;
                ((GaplessInfoHolder)object2).setFromMetadata((Metadata)object3);
            }
            long l13 = object.getPeekPosition();
            l12 = (int)l13;
            if (!bl2) {
                object.skipFully((int)l12);
            }
            n10 = 0;
            object2 = null;
        } else {
            l12 = 0;
            object3 = null;
            n10 = 0;
            object2 = null;
        }
        int n14 = 0;
        int n15 = 0;
        while (true) {
            block24: {
                block22: {
                    block23: {
                        int n16;
                        long l14;
                        int n17;
                        int n18;
                        block21: {
                            if ((n18 = this.peekEndOfStreamOrHeader((ExtractorInput)object)) == 0) break block21;
                            if (n14 <= 0) {
                                object = new EOFException();
                                throw object;
                            }
                            break block22;
                        }
                        this.scratch.setPosition(0);
                        ParsableByteArray parsableByteArray = this.scratch;
                        n18 = parsableByteArray.readInt();
                        if (n10 != 0 && (n17 = (int)(Mp3Extractor.headersMatch(n18, l14 = (long)n10) ? 1 : 0)) == 0 || (n17 = MpegAudioUtil.getFrameSize(n18)) == (n16 = -1)) {
                            n10 = n15 + 1;
                            if (n15 == n11) {
                                if (bl2) {
                                    return false;
                                }
                                object = new ParserException("Searched too many bytes.");
                                throw object;
                            }
                            if (bl2) {
                                object.resetPeekPosition();
                                n14 = (int)(l12 + n10);
                                object.advancePeekPosition(n14);
                            } else {
                                object.skipFully(n13);
                            }
                            n14 = 0;
                            n15 = n10;
                            n10 = 0;
                            object2 = null;
                            continue;
                        }
                        if (++n14 != n13) break block23;
                        object2 = this.synchronizedHeader;
                        ((MpegAudioUtil$Header)object2).setForHeaderData(n18);
                        n10 = n18;
                        break block24;
                    }
                    if (n14 != n12) break block24;
                }
                if (bl2) {
                    object.skipFully((int)(l12 += n15));
                } else {
                    object.resetPeekPosition();
                }
                this.synchronizedHeaderData = n10;
                return n13 != 0;
            }
            object.advancePeekPosition(n17 += -4);
        }
    }

    public void disableSeeking() {
        this.disableSeeking = true;
    }

    public void init(ExtractorOutput object) {
        this.extractorOutput = object;
        this.realTrackOutput = object = object.track(0, 1);
        this.currentTrackOutput = object;
        this.extractorOutput.endTracks();
    }

    public int read(ExtractorInput extractorInput, PositionHolder object) {
        this.assertInitialized();
        int n10 = this.readInternal(extractorInput);
        int n11 = -1;
        if (n10 == n11 && (n11 = (object = this.seeker) instanceof IndexSeeker) != 0) {
            long l10 = this.samplesRead;
            l10 = this.computeTimeUs(l10);
            object = this.seeker;
            long l11 = object.getDurationUs();
            long l12 = l11 - l10;
            n11 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n11 != 0) {
                ((IndexSeeker)this.seeker).setDurationUs(l10);
                object = this.extractorOutput;
                Seeker seeker = this.seeker;
                object.seekMap(seeker);
            }
        }
        return n10;
    }

    public void release() {
    }

    public void seek(long l10, long l11) {
        long l12;
        boolean bl2 = false;
        this.synchronizedHeaderData = 0;
        this.basisTimeUs = -9223372036854775807L;
        this.samplesRead = l12 = 0L;
        this.sampleBytesRemaining = 0;
        this.seekTimeUs = l11;
        Object object = this.seeker;
        boolean bl3 = object instanceof IndexSeeker;
        if (bl3 && !(bl2 = ((IndexSeeker)(object = (IndexSeeker)object)).isTimeUsInIndex(l11))) {
            this.isSeekInProgress = bl2 = true;
            this.currentTrackOutput = object = this.skippingTrackOutput;
        }
    }

    public boolean sniff(ExtractorInput extractorInput) {
        return this.synchronize(extractorInput, true);
    }
}

