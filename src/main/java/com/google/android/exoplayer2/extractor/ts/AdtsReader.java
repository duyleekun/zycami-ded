/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.audio.AacUtil$Config;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader$TrackIdGenerator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class AdtsReader
implements ElementaryStreamReader {
    private static final int CRC_SIZE = 2;
    private static final int HEADER_SIZE = 5;
    private static final int ID3_HEADER_SIZE = 10;
    private static final byte[] ID3_IDENTIFIER;
    private static final int ID3_SIZE_OFFSET = 6;
    private static final int MATCH_STATE_FF = 512;
    private static final int MATCH_STATE_I = 768;
    private static final int MATCH_STATE_ID = 1024;
    private static final int MATCH_STATE_START = 256;
    private static final int MATCH_STATE_VALUE_SHIFT = 8;
    private static final int STATE_CHECKING_ADTS_HEADER = 1;
    private static final int STATE_FINDING_SAMPLE = 0;
    private static final int STATE_READING_ADTS_HEADER = 3;
    private static final int STATE_READING_ID3_HEADER = 2;
    private static final int STATE_READING_SAMPLE = 4;
    private static final String TAG = "AdtsReader";
    private static final int VERSION_UNSET = 255;
    private final ParsableBitArray adtsScratch;
    private int bytesRead;
    private int currentFrameVersion;
    private TrackOutput currentOutput;
    private long currentSampleDuration;
    private final boolean exposeId3;
    private int firstFrameSampleRateIndex;
    private int firstFrameVersion;
    private String formatId;
    private boolean foundFirstFrame;
    private boolean hasCrc;
    private boolean hasOutputFormat;
    private final ParsableByteArray id3HeaderBuffer;
    private TrackOutput id3Output;
    private final String language;
    private int matchState;
    private TrackOutput output;
    private long sampleDurationUs;
    private int sampleSize;
    private int state;
    private long timeUs;

    static {
        byte[] byArray;
        byte[] byArray2 = byArray = new byte[3];
        byArray[0] = 73;
        byArray2[1] = 68;
        byArray2[2] = 51;
        ID3_IDENTIFIER = byArray;
    }

    public AdtsReader(boolean bl2) {
        this(bl2, null);
    }

    public AdtsReader(boolean bl2, String string2) {
        int n10;
        byte[] byArray = new byte[7];
        Object object = new ParsableBitArray(byArray);
        this.adtsScratch = object;
        byArray = Arrays.copyOf(ID3_IDENTIFIER, 10);
        this.id3HeaderBuffer = object = new ParsableByteArray(byArray);
        this.setFindingSampleState();
        this.firstFrameVersion = n10 = -1;
        this.firstFrameSampleRateIndex = n10;
        this.sampleDurationUs = -9223372036854775807L;
        this.exposeId3 = bl2;
        this.language = string2;
    }

    private void assertTracksCreated() {
        Assertions.checkNotNull(this.output);
        Util.castNonNull(this.currentOutput);
        Util.castNonNull(this.id3Output);
    }

    private void checkAdtsHeader(ParsableByteArray object) {
        int n10 = ((ParsableByteArray)object).bytesLeft();
        if (n10 == 0) {
            return;
        }
        byte[] byArray = this.adtsScratch.data;
        byte[] byArray2 = ((ParsableByteArray)object).getData();
        int n11 = ((ParsableByteArray)object).getPosition();
        byArray[0] = n11 = byArray2[n11];
        this.adtsScratch.setPosition(2);
        object = this.adtsScratch;
        n11 = ((ParsableBitArray)object).readBits(4);
        n10 = this.firstFrameSampleRateIndex;
        int n12 = -1;
        if (n10 != n12 && n11 != n10) {
            this.resetSync();
            return;
        }
        n10 = (int)(this.foundFirstFrame ? 1 : 0);
        if (n10 == 0) {
            this.foundFirstFrame = true;
            this.firstFrameVersion = n10 = this.currentFrameVersion;
            this.firstFrameSampleRateIndex = n11;
        }
        this.setReadingAdtsHeaderState();
    }

    private boolean checkSyncPositionValid(ParsableByteArray parsableByteArray, int n10) {
        Object object;
        int n11 = n10 + 1;
        parsableByteArray.setPosition(n11);
        Object object2 = this.adtsScratch.data;
        int n12 = 1;
        n11 = (int)(this.tryRead(parsableByteArray, (byte[])object2, n12) ? 1 : 0);
        if (n11 == 0) {
            return false;
        }
        object2 = this.adtsScratch;
        int n13 = 4;
        ((ParsableBitArray)object2).setPosition(n13);
        object2 = this.adtsScratch;
        n11 = ((ParsableBitArray)object2).readBits(n12);
        int n14 = this.firstFrameVersion;
        int n15 = -1;
        if (n14 != n15 && n11 != n14) {
            return false;
        }
        n14 = this.firstFrameSampleRateIndex;
        int n16 = 2;
        if (n14 != n15) {
            object = this.adtsScratch.data;
            n14 = (int)(this.tryRead(parsableByteArray, (byte[])object, n12) ? 1 : 0);
            if (n14 == 0) {
                return n12 != 0;
            }
            this.adtsScratch.setPosition(n16);
            object = this.adtsScratch;
            n14 = object.readBits(n13);
            int n17 = this.firstFrameSampleRateIndex;
            if (n14 != n17) {
                return false;
            }
            n14 = n10 + 2;
            parsableByteArray.setPosition(n14);
        }
        if ((n13 = (int)(this.tryRead(parsableByteArray, (byte[])(object = this.adtsScratch.data), n13) ? 1 : 0)) == 0) {
            return n12 != 0;
        }
        this.adtsScratch.setPosition(14);
        ParsableBitArray parsableBitArray = this.adtsScratch;
        n13 = parsableBitArray.readBits(13);
        n14 = 7;
        if (n13 < n14) {
            return false;
        }
        object = parsableByteArray.getData();
        int n18 = parsableByteArray.limit();
        if ((n10 += n13) >= n18) {
            return n12 != 0;
        }
        n13 = object[n10];
        if (n13 == n15) {
            if ((n10 += n12) == n18) {
                return n12 != 0;
            }
            n18 = object[n10];
            if ((n18 = (int)(this.isAdtsSyncBytes((byte)n15, (byte)n18) ? 1 : 0)) == 0 || (n18 = (object[n10] & 8) >> 3) != n11) {
                n12 = 0;
            }
            return n12 != 0;
        }
        n11 = object[n10];
        n13 = 73;
        if (n11 != n13) {
            return false;
        }
        n11 = n10 + 1;
        if (n11 == n18) {
            return n12 != 0;
        }
        n13 = 68;
        if ((n11 = object[n11]) != n13) {
            return false;
        }
        if ((n10 += n16) == n18) {
            return n12 != 0;
        }
        n18 = object[n10];
        if (n18 != (n10 = 51)) {
            n12 = 0;
        }
        return n12 != 0;
    }

    private boolean continueRead(ParsableByteArray parsableByteArray, byte[] byArray, int n10) {
        int n11 = parsableByteArray.bytesLeft();
        int n12 = this.bytesRead;
        n12 = n10 - n12;
        n11 = Math.min(n11, n12);
        n12 = this.bytesRead;
        parsableByteArray.readBytes(byArray, n12, n11);
        int n13 = this.bytesRead + n11;
        this.bytesRead = n13;
        if (n13 == n10) {
            n13 = 1;
        } else {
            n13 = 0;
            parsableByteArray = null;
        }
        return n13;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void findNextSample(ParsableByteArray parsableByteArray) {
        byte[] byArray = parsableByteArray.getData();
        int n10 = parsableByteArray.getPosition();
        int n11 = parsableByteArray.limit();
        while (true) {
            int n12;
            block18: {
                block16: {
                    int n13;
                    block17: {
                        int n14;
                        int n15;
                        block14: {
                            int n16;
                            block15: {
                                if (n10 >= n11) {
                                    parsableByteArray.setPosition(n10);
                                    return;
                                }
                                n12 = n10 + 1;
                                n10 = byArray[n10] & 0xFF;
                                n15 = this.matchState;
                                n13 = 512;
                                if (n15 != n13) break block14;
                                n15 = (byte)n10;
                                n14 = -1;
                                if ((n15 = (int)(this.isAdtsSyncBytes((byte)n14, (byte)n15) ? 1 : 0)) == 0) break block14;
                                n15 = (int)(this.foundFirstFrame ? 1 : 0);
                                if (n15 != 0) break block15;
                                n15 = n12 + -2;
                                if ((n15 = (int)(this.checkSyncPositionValid(parsableByteArray, n15) ? 1 : 0)) == 0) break block14;
                            }
                            this.currentFrameVersion = n16 = (n10 & 8) >> 3;
                            n16 = 1;
                            if ((n10 &= n16) != 0) {
                                n16 = 0;
                                byArray = null;
                            }
                            this.hasCrc = n16;
                            n16 = (int)(this.foundFirstFrame ? 1 : 0);
                            if (n16 == 0) {
                                this.setCheckingAdtsHeaderState();
                            } else {
                                this.setReadingAdtsHeaderState();
                            }
                            parsableByteArray.setPosition(n12);
                            return;
                        }
                        if ((n10 |= (n15 = this.matchState)) == (n14 = 329)) break block16;
                        n14 = 511;
                        if (n10 == n14) break block17;
                        n13 = 836;
                        if (n10 != n13) {
                            n13 = 1075;
                            if (n10 == n13) {
                                this.setReadingId3HeaderState();
                                parsableByteArray.setPosition(n12);
                                return;
                            }
                            n10 = 256;
                            if (n15 != n10) {
                                this.matchState = n10;
                                n12 += -1;
                            }
                            break block18;
                        } else {
                            this.matchState = n10 = 1024;
                        }
                        break block18;
                    }
                    this.matchState = n13;
                    break block18;
                }
                this.matchState = n10 = 768;
            }
            n10 = n12;
        }
    }

    private boolean isAdtsSyncBytes(byte by2, byte by3) {
        by2 = (byte)((by2 & 0xFF) << 8);
        by3 = (byte)(by3 & 0xFF);
        return AdtsReader.isAdtsSyncWord(by2 | by3);
    }

    public static boolean isAdtsSyncWord(int n10) {
        char c10 = (char)-16;
        n10 = (n10 &= (char)-10) == c10 ? 1 : 0;
        return n10 != 0;
    }

    private void parseAdtsHeader() {
        int n10;
        int n11;
        Object object = this.adtsScratch;
        ((ParsableBitArray)object).setPosition(0);
        int n12 = this.hasOutputFormat;
        int n13 = 5;
        int n14 = 2;
        if (n12 == 0) {
            long l10;
            Object object2;
            Object object3;
            int n15;
            object = this.adtsScratch;
            n12 = ((ParsableBitArray)object).readBits(n14);
            n11 = 1;
            if ((n12 += n11) != n14) {
                n15 = 61;
                object3 = new StringBuilder(n15);
                ((StringBuilder)object3).append("Detected audio object type: ");
                ((StringBuilder)object3).append(n12);
                ((StringBuilder)object3).append(", but assuming AAC LC.");
                object = ((StringBuilder)object3).toString();
                object2 = TAG;
                Log.w((String)object2, (String)object);
                n12 = n14;
            }
            this.adtsScratch.skipBits(n13);
            n15 = this.adtsScratch.readBits(3);
            int n16 = this.firstFrameSampleRateIndex;
            object = AacUtil.buildAudioSpecificConfig(n12, n16, n15);
            object2 = AacUtil.parseAudioSpecificConfig((byte[])object);
            object3 = new Format$Builder();
            String string2 = this.formatId;
            object3 = ((Format$Builder)object3).setId(string2).setSampleMimeType("audio/mp4a-latm");
            string2 = ((AacUtil$Config)object2).codecs;
            object3 = ((Format$Builder)object3).setCodecs(string2);
            n10 = ((AacUtil$Config)object2).channelCount;
            object3 = ((Format$Builder)object3).setChannelCount(n10);
            n15 = ((AacUtil$Config)object2).sampleRateHz;
            object2 = ((Format$Builder)object3).setSampleRate(n15);
            object = Collections.singletonList(object);
            object = ((Format$Builder)object2).setInitializationData((List)object);
            object2 = this.language;
            object = ((Format$Builder)object).setLanguage((String)object2).build();
            n10 = ((Format)object).sampleRate;
            long l11 = n10;
            this.sampleDurationUs = l10 = 1024000000L / l11;
            object2 = this.output;
            object2.format((Format)object);
            this.hasOutputFormat = n11;
        } else {
            object = this.adtsScratch;
            n11 = 10;
            ((ParsableBitArray)object).skipBits(n11);
        }
        this.adtsScratch.skipBits(4);
        object = this.adtsScratch;
        n11 = 13;
        n12 = ((ParsableBitArray)object).readBits(n11) - n14 - n13;
        n13 = (int)(this.hasCrc ? 1 : 0);
        if (n13 != 0) {
            n12 += -2;
        }
        n10 = n12;
        TrackOutput trackOutput = this.output;
        long l12 = this.sampleDurationUs;
        this.setReadingSampleState(trackOutput, l12, 0, n12);
    }

    private void parseId3Header() {
        TrackOutput trackOutput = this.id3Output;
        ParsableByteArray parsableByteArray = this.id3HeaderBuffer;
        trackOutput.sampleData(parsableByteArray, 10);
        this.id3HeaderBuffer.setPosition(6);
        TrackOutput trackOutput2 = this.id3Output;
        int n10 = this.id3HeaderBuffer.readSynchSafeInt() + 10;
        this.setReadingSampleState(trackOutput2, 0L, 10, n10);
    }

    private void readSample(ParsableByteArray parsableByteArray) {
        int n10;
        int n11 = parsableByteArray.bytesLeft();
        int n12 = this.sampleSize;
        int n13 = this.bytesRead;
        n11 = Math.min(n11, n12 -= n13);
        TrackOutput trackOutput = this.currentOutput;
        trackOutput.sampleData(parsableByteArray, n11);
        this.bytesRead = n10 = this.bytesRead + n11;
        int n14 = this.sampleSize;
        if (n10 == n14) {
            TrackOutput trackOutput2 = this.currentOutput;
            long l10 = this.timeUs;
            int n15 = 1;
            trackOutput2.sampleMetadata(l10, n15, n14, 0, null);
            long l11 = this.timeUs;
            long l12 = this.currentSampleDuration;
            this.timeUs = l11 += l12;
            this.setFindingSampleState();
        }
    }

    private void resetSync() {
        this.foundFirstFrame = false;
        this.setFindingSampleState();
    }

    private void setCheckingAdtsHeaderState() {
        this.state = 1;
        this.bytesRead = 0;
    }

    private void setFindingSampleState() {
        this.state = 0;
        this.bytesRead = 0;
        this.matchState = 256;
    }

    private void setReadingAdtsHeaderState() {
        this.state = 3;
        this.bytesRead = 0;
    }

    private void setReadingId3HeaderState() {
        int n10;
        this.state = 2;
        this.bytesRead = n10 = ID3_IDENTIFIER.length;
        this.sampleSize = 0;
        this.id3HeaderBuffer.setPosition(0);
    }

    private void setReadingSampleState(TrackOutput trackOutput, long l10, int n10, int n11) {
        this.state = 4;
        this.bytesRead = n10;
        this.currentOutput = trackOutput;
        this.currentSampleDuration = l10;
        this.sampleSize = n11;
    }

    private boolean tryRead(ParsableByteArray parsableByteArray, byte[] byArray, int n10) {
        int n11 = parsableByteArray.bytesLeft();
        if (n11 < n10) {
            return false;
        }
        parsableByteArray.readBytes(byArray, 0, n10);
        return true;
    }

    public void consume(ParsableByteArray object) {
        int n10;
        this.assertTracksCreated();
        while ((n10 = ((ParsableByteArray)object).bytesLeft()) > 0) {
            n10 = this.state;
            if (n10 != 0) {
                int n11 = 1;
                if (n10 != n11) {
                    n11 = 2;
                    if (n10 != n11) {
                        n11 = 3;
                        if (n10 != n11) {
                            n11 = 4;
                            if (n10 == n11) {
                                this.readSample((ParsableByteArray)object);
                                continue;
                            }
                            object = new IllegalStateException();
                            throw object;
                        }
                        n10 = (int)(this.hasCrc ? 1 : 0);
                        n10 = n10 != 0 ? 7 : 5;
                        byte[] byArray = this.adtsScratch.data;
                        if ((n10 = (int)(this.continueRead((ParsableByteArray)object, byArray, n10) ? 1 : 0)) == 0) continue;
                        this.parseAdtsHeader();
                        continue;
                    }
                    byte[] byArray = this.id3HeaderBuffer.getData();
                    n10 = (int)(this.continueRead((ParsableByteArray)object, byArray, n11 = 10) ? 1 : 0);
                    if (n10 == 0) continue;
                    this.parseId3Header();
                    continue;
                }
                this.checkAdtsHeader((ParsableByteArray)object);
                continue;
            }
            this.findNextSample((ParsableByteArray)object);
        }
    }

    public void createTracks(ExtractorOutput object, TsPayloadReader$TrackIdGenerator object2) {
        ((TsPayloadReader$TrackIdGenerator)object2).generateNewId();
        Object object3 = ((TsPayloadReader$TrackIdGenerator)object2).getFormatId();
        this.formatId = object3;
        int n10 = ((TsPayloadReader$TrackIdGenerator)object2).getTrackId();
        int n11 = 1;
        this.output = object3 = object.track(n10, n11);
        this.currentOutput = object3;
        n10 = (int)(this.exposeId3 ? 1 : 0);
        if (n10 != 0) {
            ((TsPayloadReader$TrackIdGenerator)object2).generateNewId();
            n10 = ((TsPayloadReader$TrackIdGenerator)object2).getTrackId();
            n11 = 5;
            this.id3Output = object = object.track(n10, n11);
            object3 = new Format$Builder();
            object2 = ((TsPayloadReader$TrackIdGenerator)object2).getFormatId();
            object2 = ((Format$Builder)object3).setId((String)object2);
            object3 = "application/id3";
            object2 = ((Format$Builder)object2).setSampleMimeType((String)object3).build();
            object.format((Format)object2);
        } else {
            this.id3Output = object = new DummyTrackOutput();
        }
    }

    public long getSampleDurationUs() {
        return this.sampleDurationUs;
    }

    public void packetFinished() {
    }

    public void packetStarted(long l10, int n10) {
        this.timeUs = l10;
    }

    public void seek() {
        this.resetSync();
    }
}

