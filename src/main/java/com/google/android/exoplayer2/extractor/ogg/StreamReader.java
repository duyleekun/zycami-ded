/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
import com.google.android.exoplayer2.extractor.ogg.OggPacket;
import com.google.android.exoplayer2.extractor.ogg.OggPageHeader;
import com.google.android.exoplayer2.extractor.ogg.OggSeeker;
import com.google.android.exoplayer2.extractor.ogg.StreamReader$SetupData;
import com.google.android.exoplayer2.extractor.ogg.StreamReader$UnseekableOggSeeker;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

public abstract class StreamReader {
    private static final int STATE_END_OF_INPUT = 3;
    private static final int STATE_READ_HEADERS = 0;
    private static final int STATE_READ_PAYLOAD = 2;
    private static final int STATE_SKIP_HEADERS = 1;
    private long currentGranule;
    private ExtractorOutput extractorOutput;
    private boolean formatSet;
    private long lengthOfReadPacket;
    private final OggPacket oggPacket;
    private OggSeeker oggSeeker;
    private long payloadStartPosition;
    private int sampleRate;
    private boolean seekMapSet;
    private StreamReader$SetupData setupData;
    private int state;
    private long targetGranule;
    private TrackOutput trackOutput;

    public StreamReader() {
        Object object = new OggPacket();
        this.oggPacket = object;
        this.setupData = object = new StreamReader$SetupData();
    }

    private void assertInitialized() {
        Assertions.checkStateNotNull(this.trackOutput);
        Util.castNonNull(this.extractorOutput);
    }

    private boolean readHeaders(ExtractorInput extractorInput) {
        while (true) {
            StreamReader$SetupData streamReader$SetupData;
            long l10;
            Object object;
            boolean bl2;
            if (!(bl2 = ((OggPacket)(object = this.oggPacket)).populate(extractorInput))) {
                this.state = 3;
                return false;
            }
            long l11 = extractorInput.getPosition();
            long l12 = this.payloadStartPosition;
            this.lengthOfReadPacket = l11 -= l12;
            object = this.oggPacket.getPayload();
            bl2 = this.readHeaders((ParsableByteArray)object, l10 = this.payloadStartPosition, streamReader$SetupData = this.setupData);
            if (!bl2) break;
            this.payloadStartPosition = l11 = extractorInput.getPosition();
        }
        return true;
    }

    private int readHeadersAndUpdateState(ExtractorInput extractorInput) {
        Object object;
        int n10;
        Object object2 = this.readHeaders(extractorInput);
        if (!object2) {
            return -1;
        }
        Object object3 = this.setupData.format;
        this.sampleRate = n10 = ((Format)object3).sampleRate;
        n10 = (int)(this.formatSet ? 1 : 0);
        boolean bl2 = true;
        if (n10 == 0) {
            object = this.trackOutput;
            object.format((Format)object3);
            this.formatSet = bl2;
        }
        if ((object3 = this.setupData.oggSeeker) != null) {
            this.oggSeeker = object3;
        } else {
            long l10;
            long l11 = extractorInput.getLength();
            long l12 = l11 - (l10 = (long)-1);
            object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (!object2) {
                n10 = 0;
                object = null;
                this.oggSeeker = object3 = new StreamReader$UnseekableOggSeeker(null);
            } else {
                DefaultOggSeeker defaultOggSeeker;
                object3 = this.oggPacket.getPageHeader();
                n10 = ((OggPageHeader)object3).type & 4;
                boolean bl3 = n10 != 0 ? bl2 : false;
                long l13 = this.payloadStartPosition;
                long l14 = extractorInput.getLength();
                n10 = ((OggPageHeader)object3).headerSize;
                int n11 = ((OggPageHeader)object3).bodySize;
                long l15 = n10 += n11;
                long l16 = ((OggPageHeader)object3).granulePosition;
                object3 = defaultOggSeeker;
                object = this;
                defaultOggSeeker = new DefaultOggSeeker(this, l13, l14, l15, l16, bl3);
                this.oggSeeker = defaultOggSeeker;
            }
        }
        this.state = 2;
        this.oggPacket.trimPayload();
        return 0;
    }

    private int readPayload(ExtractorInput extractorInput, PositionHolder positionHolder) {
        long l10;
        long l11;
        boolean bl2;
        long l12;
        int n10;
        long l13;
        StreamReader streamReader = this;
        Object object = extractorInput;
        Object object2 = this.oggSeeker;
        long l14 = object2.read(extractorInput);
        long l15 = 0L;
        Object object3 = l14 == l15 ? 0 : (l14 < l15 ? -1 : 1);
        int n11 = 1;
        if (object3 >= 0) {
            positionHolder.position = l14;
            return n11;
        }
        long l16 = -1;
        long l17 = l14 - l16;
        object3 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
        if (object3 < 0) {
            l13 = 2;
            l14 = -(l14 + l13);
            this.onSeekEnd(l14);
        }
        if ((n10 = streamReader.seekMapSet) == 0) {
            object2 = (SeekMap)Assertions.checkStateNotNull(streamReader.oggSeeker.createSeekMap());
            ExtractorOutput extractorOutput = streamReader.extractorOutput;
            extractorOutput.seekMap((SeekMap)object2);
            streamReader.seekMapSet = n11;
        }
        if ((n10 = (l12 = (l14 = streamReader.lengthOfReadPacket) - l15) == 0L ? 0 : (l12 < 0L ? -1 : 1)) <= 0 && !(bl2 = ((OggPacket)(object2 = streamReader.oggPacket)).populate((ExtractorInput)object))) {
            streamReader.state = 3;
            return -1;
        }
        streamReader.lengthOfReadPacket = l15;
        object = streamReader.oggPacket.getPayload();
        l14 = streamReader.preparePayload((ParsableByteArray)object);
        long l18 = l14 - l15;
        Object object4 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
        if (object4 >= 0 && (object3 = (l11 = (l10 = (l15 = streamReader.currentGranule) + l14) - (l13 = streamReader.targetGranule)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) >= 0) {
            long l19 = streamReader.convertGranuleToTime(l15);
            TrackOutput trackOutput = streamReader.trackOutput;
            int n12 = ((ParsableByteArray)object).limit();
            trackOutput.sampleData((ParsableByteArray)object, n12);
            TrackOutput trackOutput2 = streamReader.trackOutput;
            int n13 = 1;
            int n14 = ((ParsableByteArray)object).limit();
            trackOutput2.sampleMetadata(l19, n13, n14, 0, null);
            streamReader.targetGranule = l16;
        }
        streamReader.currentGranule = l15 = streamReader.currentGranule + l14;
        return 0;
    }

    public long convertGranuleToTime(long l10) {
        long l11 = this.sampleRate;
        return (l10 *= 1000000L) / l11;
    }

    public long convertTimeToGranule(long l10) {
        return (long)this.sampleRate * l10 / 1000000L;
    }

    public void init(ExtractorOutput extractorOutput, TrackOutput trackOutput) {
        this.extractorOutput = extractorOutput;
        this.trackOutput = trackOutput;
        this.reset(true);
    }

    public void onSeekEnd(long l10) {
        this.currentGranule = l10;
    }

    public abstract long preparePayload(ParsableByteArray var1);

    public final int read(ExtractorInput object, PositionHolder positionHolder) {
        this.assertInitialized();
        int n10 = this.state;
        if (n10 != 0) {
            int n11 = 1;
            int n12 = 2;
            if (n10 != n11) {
                if (n10 == n12) {
                    Util.castNonNull(this.oggSeeker);
                    return this.readPayload((ExtractorInput)object, positionHolder);
                }
                object = new IllegalStateException();
                throw object;
            }
            int n13 = (int)this.payloadStartPosition;
            object.skipFully(n13);
            this.state = n12;
            return 0;
        }
        return this.readHeadersAndUpdateState((ExtractorInput)object);
    }

    public abstract boolean readHeaders(ParsableByteArray var1, long var2, StreamReader$SetupData var4);

    public void reset(boolean bl2) {
        long l10 = 0L;
        if (bl2) {
            StreamReader$SetupData streamReader$SetupData;
            this.setupData = streamReader$SetupData = new StreamReader$SetupData();
            this.payloadStartPosition = l10;
            bl2 = false;
            streamReader$SetupData = null;
            this.state = 0;
        } else {
            bl2 = true;
            this.state = (int)(bl2 ? 1 : 0);
        }
        this.targetGranule = -1;
        this.currentGranule = l10;
    }

    public final void seek(long l10, long l11) {
        OggPacket oggPacket = this.oggPacket;
        oggPacket.reset();
        long l12 = 0L;
        long l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
        if (l13 == false) {
            l13 = this.seekMapSet ^ 1;
            this.reset((boolean)l13);
        } else {
            l13 = this.state;
            if (l13 != false) {
                this.targetGranule = l10 = this.convertTimeToGranule(l11);
                OggSeeker oggSeeker = (OggSeeker)Util.castNonNull(this.oggSeeker);
                long l14 = this.targetGranule;
                oggSeeker.startSeek(l14);
                l13 = 2;
                this.state = (int)l13;
            }
        }
    }
}

