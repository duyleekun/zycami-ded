/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.audio.AacUtil$Config;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader$TrackIdGenerator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;
import java.util.List;

public final class LatmReader
implements ElementaryStreamReader {
    private static final int INITIAL_BUFFER_SIZE = 1024;
    private static final int STATE_FINDING_SYNC_1 = 0;
    private static final int STATE_FINDING_SYNC_2 = 1;
    private static final int STATE_READING_HEADER = 2;
    private static final int STATE_READING_SAMPLE = 3;
    private static final int SYNC_BYTE_FIRST = 86;
    private static final int SYNC_BYTE_SECOND = 224;
    private int audioMuxVersionA;
    private int bytesRead;
    private int channelCount;
    private String codecs;
    private Format format;
    private String formatId;
    private int frameLengthType;
    private final String language;
    private int numSubframes;
    private long otherDataLenBits;
    private boolean otherDataPresent;
    private TrackOutput output;
    private final ParsableBitArray sampleBitArray;
    private final ParsableByteArray sampleDataBuffer;
    private long sampleDurationUs;
    private int sampleRateHz;
    private int sampleSize;
    private int secondHeaderByte;
    private int state;
    private boolean streamMuxRead;
    private long timeUs;

    public LatmReader(String object) {
        ParsableBitArray parsableBitArray;
        this.language = object;
        this.sampleDataBuffer = object = new ParsableByteArray(1024);
        object = ((ParsableByteArray)object).getData();
        this.sampleBitArray = parsableBitArray = new ParsableBitArray((byte[])object);
    }

    private static long latmGetValue(ParsableBitArray parsableBitArray) {
        int n10 = (parsableBitArray.readBits(2) + 1) * 8;
        return parsableBitArray.readBits(n10);
    }

    private void parseAudioMuxElement(ParsableBitArray object) {
        boolean n10 = ((ParsableBitArray)object).readBit();
        if (!n10) {
            boolean bl2;
            this.streamMuxRead = bl2 = true;
            this.parseStreamMuxConfig((ParsableBitArray)object);
        } else {
            boolean bl3 = this.streamMuxRead;
            if (!bl3) {
                return;
            }
        }
        int n11 = this.audioMuxVersionA;
        if (n11 == 0) {
            int n12 = this.numSubframes;
            if (n12 == 0) {
                int n13 = this.parsePayloadLengthInfo((ParsableBitArray)object);
                this.parsePayloadMux((ParsableBitArray)object, n13);
                boolean bl4 = this.otherDataPresent;
                if (bl4) {
                    long l10 = this.otherDataLenBits;
                    int n14 = (int)l10;
                    ((ParsableBitArray)object).skipBits(n14);
                }
                return;
            }
            object = new ParserException();
            throw object;
        }
        object = new ParserException();
        throw object;
    }

    private int parseAudioSpecificConfig(ParsableBitArray parsableBitArray) {
        int n10;
        int n11;
        String string2;
        int n12 = parsableBitArray.bitsLeft();
        AacUtil$Config aacUtil$Config = AacUtil.parseAudioSpecificConfig(parsableBitArray, true);
        this.codecs = string2 = aacUtil$Config.codecs;
        this.sampleRateHz = n11 = aacUtil$Config.sampleRateHz;
        this.channelCount = n10 = aacUtil$Config.channelCount;
        int n13 = parsableBitArray.bitsLeft();
        return n12 - n13;
    }

    private void parseFrameLength(ParsableBitArray object) {
        int n10;
        int n11 = 3;
        this.frameLengthType = n10 = ((ParsableBitArray)object).readBits(n11);
        if (n10 != 0) {
            int n12 = 1;
            if (n10 != n12) {
                int n13 = 6;
                if (n10 != n11 && n10 != (n11 = 4) && n10 != (n11 = 5)) {
                    if (n10 != n13 && n10 != (n11 = 7)) {
                        object = new IllegalStateException();
                        throw object;
                    }
                    ((ParsableBitArray)object).skipBits(n12);
                } else {
                    ((ParsableBitArray)object).skipBits(n13);
                }
            } else {
                n11 = 9;
                ((ParsableBitArray)object).skipBits(n11);
            }
        } else {
            n11 = 8;
            ((ParsableBitArray)object).skipBits(n11);
        }
    }

    private int parsePayloadLengthInfo(ParsableBitArray object) {
        int n10 = this.frameLengthType;
        if (n10 == 0) {
            int n11;
            int n12;
            n10 = 0;
            do {
                n12 = ((ParsableBitArray)object).readBits(8);
                n10 += n12;
            } while (n12 == (n11 = 255));
            return n10;
        }
        object = new ParserException();
        throw object;
    }

    private void parsePayloadMux(ParsableBitArray object, int n10) {
        Object object2;
        int n11 = ((ParsableBitArray)object).getPosition();
        int n12 = n11 & 7;
        if (n12 == 0) {
            object = this.sampleDataBuffer;
            ((ParsableByteArray)object).setPosition(n11 >>= 3);
        } else {
            object2 = this.sampleDataBuffer.getData();
            n12 = n10 * 8;
            ((ParsableBitArray)object).readBits((byte[])object2, 0, n12);
            object = this.sampleDataBuffer;
            ((ParsableByteArray)object).setPosition(0);
        }
        object = this.output;
        object2 = this.sampleDataBuffer;
        object.sampleData((ParsableByteArray)object2, n10);
        TrackOutput trackOutput = this.output;
        long l10 = this.timeUs;
        trackOutput.sampleMetadata(l10, 1, n10, 0, null);
        long l11 = this.timeUs;
        long l12 = this.sampleDurationUs;
        this.timeUs = l11 += l12;
    }

    private void parseStreamMuxConfig(ParsableBitArray object) {
        int n10 = 1;
        int n11 = ((ParsableBitArray)object).readBits(n10);
        int n12 = 0;
        Object object2 = null;
        int n13 = n11 == n10 ? ((ParsableBitArray)object).readBits(n10) : 0;
        this.audioMuxVersionA = n13;
        if (n13 == 0) {
            if (n11 == n10) {
                LatmReader.latmGetValue((ParsableBitArray)object);
            }
            if ((n13 = (int)(((ParsableBitArray)object).readBit() ? 1 : 0)) != 0) {
                this.numSubframes = n13 = ((ParsableBitArray)object).readBits(6);
                n13 = ((ParsableBitArray)object).readBits(4);
                int n14 = ((ParsableBitArray)object).readBits(3);
                if (n13 == 0 && n14 == 0) {
                    long l10;
                    n13 = 8;
                    if (n11 == 0) {
                        n14 = ((ParsableBitArray)object).getPosition();
                        int n15 = this.parseAudioSpecificConfig((ParsableBitArray)object);
                        ((ParsableBitArray)object).setPosition(n14);
                        Object object3 = new byte[(n15 + 7) / n13];
                        ((ParsableBitArray)object).readBits((byte[])object3, 0, n15);
                        object2 = new Format$Builder();
                        String string2 = this.formatId;
                        object2 = ((Format$Builder)object2).setId(string2).setSampleMimeType("audio/mp4a-latm");
                        string2 = this.codecs;
                        object2 = ((Format$Builder)object2).setCodecs(string2);
                        n15 = this.channelCount;
                        object2 = ((Format$Builder)object2).setChannelCount(n15);
                        n15 = this.sampleRateHz;
                        object2 = ((Format$Builder)object2).setSampleRate(n15);
                        object3 = Collections.singletonList(object3);
                        object2 = ((Format$Builder)object2).setInitializationData((List)object3);
                        object3 = this.language;
                        object2 = ((Format$Builder)object2).setLanguage((String)object3).build();
                        object3 = this.format;
                        n14 = (int)(((Format)object2).equals(object3) ? 1 : 0);
                        if (n14 == 0) {
                            this.format = object2;
                            int n16 = ((Format)object2).sampleRate;
                            long l11 = n16;
                            this.sampleDurationUs = l10 = 1024000000L / l11;
                            object3 = this.output;
                            object3.format((Format)object2);
                        }
                    } else {
                        l10 = LatmReader.latmGetValue((ParsableBitArray)object);
                        n12 = (int)l10;
                        n14 = this.parseAudioSpecificConfig((ParsableBitArray)object);
                        ((ParsableBitArray)object).skipBits(n12 -= n14);
                    }
                    this.parseFrameLength((ParsableBitArray)object);
                    n12 = (int)(((ParsableBitArray)object).readBit() ? 1 : 0);
                    this.otherDataPresent = n12;
                    this.otherDataLenBits = l10 = 0L;
                    if (n12 != 0) {
                        if (n11 == n10) {
                            long l12;
                            this.otherDataLenBits = l12 = LatmReader.latmGetValue((ParsableBitArray)object);
                        } else {
                            do {
                                n10 = (int)(((ParsableBitArray)object).readBit() ? 1 : 0);
                                long l13 = this.otherDataLenBits << n13;
                                n14 = ((ParsableBitArray)object).readBits(n13);
                                l10 = n14;
                                this.otherDataLenBits = l13 += l10;
                            } while (n10 != 0);
                        }
                    }
                    if ((n10 = (int)(((ParsableBitArray)object).readBit() ? 1 : 0)) != 0) {
                        ((ParsableBitArray)object).skipBits(n13);
                    }
                    return;
                }
                object = new ParserException();
                throw object;
            }
            object = new ParserException();
            throw object;
        }
        object = new ParserException();
        throw object;
    }

    private void resetBufferForSize(int n10) {
        this.sampleDataBuffer.reset(n10);
        ParsableBitArray parsableBitArray = this.sampleBitArray;
        byte[] byArray = this.sampleDataBuffer.getData();
        parsableBitArray.reset(byArray);
    }

    public void consume(ParsableByteArray object) {
        int n10;
        Object object2 = this.output;
        Assertions.checkStateNotNull(object2);
        while ((n10 = ((ParsableByteArray)object).bytesLeft()) > 0) {
            n10 = this.state;
            int n11 = 86;
            int n12 = 1;
            if (n10 != 0) {
                int n13;
                int n14 = 2;
                if (n10 != n12) {
                    n11 = 3;
                    if (n10 != n14) {
                        if (n10 == n11) {
                            n10 = ((ParsableByteArray)object).bytesLeft();
                            n11 = this.sampleSize;
                            n12 = this.bytesRead;
                            n10 = Math.min(n10, n11 -= n12);
                            byte[] byArray = this.sampleBitArray.data;
                            n12 = this.bytesRead;
                            ((ParsableByteArray)object).readBytes(byArray, n12, n10);
                            this.bytesRead = n11 = this.bytesRead + n10;
                            n10 = this.sampleSize;
                            if (n11 != n10) continue;
                            this.sampleBitArray.setPosition(0);
                            object2 = this.sampleBitArray;
                            this.parseAudioMuxElement((ParsableBitArray)object2);
                            this.state = 0;
                            continue;
                        }
                        object = new IllegalStateException();
                        throw object;
                    }
                    n10 = (this.secondHeaderByte & 0xFFFFFF1F) << 8;
                    n12 = ((ParsableByteArray)object).readUnsignedByte();
                    this.sampleSize = n10 |= n12;
                    byte[] byArray = this.sampleDataBuffer.getData();
                    n12 = byArray.length;
                    if (n10 > n12) {
                        n10 = this.sampleSize;
                        this.resetBufferForSize(n10);
                    }
                    this.bytesRead = 0;
                    this.state = n11;
                    continue;
                }
                n10 = ((ParsableByteArray)object).readUnsignedByte();
                n12 = n10 & 0xE0;
                if (n12 == (n13 = 224)) {
                    this.secondHeaderByte = n10;
                    this.state = n14;
                    continue;
                }
                if (n10 == n11) continue;
                this.state = 0;
                continue;
            }
            n10 = ((ParsableByteArray)object).readUnsignedByte();
            if (n10 != n11) continue;
            this.state = n12;
        }
    }

    public void createTracks(ExtractorOutput object, TsPayloadReader$TrackIdGenerator tsPayloadReader$TrackIdGenerator) {
        tsPayloadReader$TrackIdGenerator.generateNewId();
        int n10 = tsPayloadReader$TrackIdGenerator.getTrackId();
        this.output = object = object.track(n10, 1);
        this.formatId = object = tsPayloadReader$TrackIdGenerator.getFormatId();
    }

    public void packetFinished() {
    }

    public void packetStarted(long l10, int n10) {
        this.timeUs = l10;
    }

    public void seek() {
        this.state = 0;
        this.streamMuxRead = false;
    }
}

