/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ogg.FlacReader;
import com.google.android.exoplayer2.extractor.ogg.OggPageHeader;
import com.google.android.exoplayer2.extractor.ogg.OpusReader;
import com.google.android.exoplayer2.extractor.ogg.StreamReader;
import com.google.android.exoplayer2.extractor.ogg.VorbisReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import d.h.a.a.h0.h.a;

public class OggExtractor
implements Extractor {
    public static final ExtractorsFactory FACTORY = a.a;
    private static final int MAX_VERIFICATION_BYTES = 8;
    private ExtractorOutput output;
    private StreamReader streamReader;
    private boolean streamReaderInitialized;

    public static /* synthetic */ Extractor[] a() {
        Extractor[] extractorArray = new Extractor[1];
        OggExtractor oggExtractor = new OggExtractor();
        extractorArray[0] = oggExtractor;
        return extractorArray;
    }

    private static ParsableByteArray resetPosition(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(0);
        return parsableByteArray;
    }

    private boolean sniffInternal(ExtractorInput object) {
        block2: {
            boolean bl2;
            block4: {
                boolean bl3;
                ParsableByteArray parsableByteArray;
                block5: {
                    block3: {
                        OggPageHeader oggPageHeader = new OggPageHeader();
                        bl2 = true;
                        int n10 = oggPageHeader.populate((ExtractorInput)object, bl2);
                        if (n10 == 0) break block2;
                        n10 = oggPageHeader.type;
                        int n11 = 2;
                        if ((n10 &= n11) != n11) break block2;
                        int n12 = oggPageHeader.bodySize;
                        n10 = 8;
                        n12 = Math.min(n12, n10);
                        parsableByteArray = new ParsableByteArray(n12);
                        byte[] byArray = parsableByteArray.getData();
                        object.peekFully(byArray, 0, n12);
                        object = OggExtractor.resetPosition(parsableByteArray);
                        bl3 = FlacReader.verifyBitstreamType((ParsableByteArray)object);
                        if (!bl3) break block3;
                        this.streamReader = object = new FlacReader();
                        break block4;
                    }
                    object = OggExtractor.resetPosition(parsableByteArray);
                    bl3 = VorbisReader.verifyBitstreamType((ParsableByteArray)object);
                    if (!bl3) break block5;
                    this.streamReader = object = new VorbisReader();
                    break block4;
                }
                object = OggExtractor.resetPosition(parsableByteArray);
                bl3 = OpusReader.verifyBitstreamType((ParsableByteArray)object);
                if (!bl3) break block2;
                this.streamReader = object = new OpusReader();
            }
            return bl2;
        }
        return false;
    }

    public void init(ExtractorOutput extractorOutput) {
        this.output = extractorOutput;
    }

    public int read(ExtractorInput object, PositionHolder positionHolder) {
        boolean bl2;
        Assertions.checkStateNotNull(this.output);
        Object object2 = this.streamReader;
        if (object2 == null) {
            bl2 = this.sniffInternal((ExtractorInput)object);
            if (bl2) {
                object.resetPeekPosition();
            } else {
                object = new ParserException("Failed to determine bitstream type");
                throw object;
            }
        }
        if (!(bl2 = this.streamReaderInitialized)) {
            object2 = this.output;
            int n10 = 1;
            object2 = object2.track(0, n10);
            this.output.endTracks();
            StreamReader streamReader = this.streamReader;
            ExtractorOutput extractorOutput = this.output;
            streamReader.init(extractorOutput, (TrackOutput)object2);
            this.streamReaderInitialized = n10;
        }
        return this.streamReader.read((ExtractorInput)object, positionHolder);
    }

    public void release() {
    }

    public void seek(long l10, long l11) {
        StreamReader streamReader = this.streamReader;
        if (streamReader != null) {
            streamReader.seek(l10, l11);
        }
    }

    public boolean sniff(ExtractorInput extractorInput) {
        try {
            return this.sniffInternal(extractorInput);
        }
        catch (ParserException parserException) {
            return false;
        }
    }
}

