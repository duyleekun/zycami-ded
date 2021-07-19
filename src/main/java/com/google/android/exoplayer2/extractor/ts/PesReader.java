/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader$TrackIdGenerator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;

public final class PesReader
implements TsPayloadReader {
    private static final int HEADER_SIZE = 9;
    private static final int MAX_HEADER_EXTENSION_SIZE = 10;
    private static final int PES_SCRATCH_SIZE = 10;
    private static final int STATE_FINDING_HEADER = 0;
    private static final int STATE_READING_BODY = 3;
    private static final int STATE_READING_HEADER = 1;
    private static final int STATE_READING_HEADER_EXTENSION = 2;
    private static final String TAG = "PesReader";
    private int bytesRead;
    private boolean dataAlignmentIndicator;
    private boolean dtsFlag;
    private int extendedHeaderLength;
    private int payloadSize;
    private final ParsableBitArray pesScratch;
    private boolean ptsFlag;
    private final ElementaryStreamReader reader;
    private boolean seenFirstDts;
    private int state;
    private long timeUs;
    private TimestampAdjuster timestampAdjuster;

    public PesReader(ElementaryStreamReader object) {
        this.reader = object;
        byte[] byArray = new byte[10];
        this.pesScratch = object = new ParsableBitArray(byArray);
        this.state = 0;
    }

    private boolean continueRead(ParsableByteArray parsableByteArray, byte[] byArray, int n10) {
        boolean bl2;
        int n11;
        int n12 = parsableByteArray.bytesLeft();
        int n13 = this.bytesRead;
        n13 = n10 - n13;
        n12 = Math.min(n12, n13);
        boolean bl3 = true;
        if (n12 <= 0) {
            return bl3;
        }
        if (byArray == null) {
            parsableByteArray.skipBytes(n12);
        } else {
            int n14 = this.bytesRead;
            parsableByteArray.readBytes(byArray, n14, n12);
        }
        this.bytesRead = n11 = this.bytesRead + n12;
        if (n11 != n10) {
            bl2 = false;
        }
        return bl2;
    }

    private boolean parseHeader() {
        boolean bl2;
        Object object = this.pesScratch;
        int n10 = 0;
        String string2 = null;
        ((ParsableBitArray)object).setPosition(0);
        object = this.pesScratch;
        int n11 = 24;
        int n12 = ((ParsableBitArray)object).readBits(n11);
        String string3 = TAG;
        int n13 = 1;
        int n14 = -1;
        if (n12 != n13) {
            StringBuilder stringBuilder = new StringBuilder(41);
            stringBuilder.append("Unexpected start code prefix: ");
            stringBuilder.append(n12);
            object = stringBuilder.toString();
            Log.w(string3, (String)object);
            this.payloadSize = n14;
            return false;
        }
        object = this.pesScratch;
        n10 = 8;
        ((ParsableBitArray)object).skipBits(n10);
        object = this.pesScratch;
        n12 = ((ParsableBitArray)object).readBits(16);
        this.pesScratch.skipBits(5);
        this.dataAlignmentIndicator = bl2 = this.pesScratch.readBit();
        this.pesScratch.skipBits(2);
        this.ptsFlag = bl2 = this.pesScratch.readBit();
        this.dtsFlag = bl2 = this.pesScratch.readBit();
        Object object2 = this.pesScratch;
        int n15 = 6;
        ((ParsableBitArray)object2).skipBits(n15);
        object2 = this.pesScratch;
        this.extendedHeaderLength = n10 = ((ParsableBitArray)object2).readBits(n10);
        if (n12 == 0) {
            this.payloadSize = n14;
        } else {
            this.payloadSize = n12 = n12 + n15 + -9 - n10;
            if (n12 < 0) {
                n10 = 47;
                object2 = new StringBuilder(n10);
                string2 = "Found negative packet payload size: ";
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append(n12);
                object = ((StringBuilder)object2).toString();
                Log.w(string3, (String)object);
                this.payloadSize = n14;
            }
        }
        return n13 != 0;
    }

    private void parseHeaderExtension() {
        long l10;
        Object object = this.pesScratch;
        int n10 = 0;
        ParsableBitArray parsableBitArray = null;
        ((ParsableBitArray)object).setPosition(0);
        this.timeUs = l10 = -9223372036854775807L;
        int n11 = this.ptsFlag;
        if (n11 != 0) {
            object = this.pesScratch;
            n10 = 4;
            ((ParsableBitArray)object).skipBits(n10);
            object = this.pesScratch;
            int n12 = 3;
            long l11 = ((ParsableBitArray)object).readBits(n12);
            n11 = 30;
            l11 <<= n11;
            ParsableBitArray parsableBitArray2 = this.pesScratch;
            int n13 = 1;
            parsableBitArray2.skipBits(n13);
            parsableBitArray2 = this.pesScratch;
            int n14 = 15;
            long l12 = parsableBitArray2.readBits(n14) << n14;
            l11 |= l12;
            this.pesScratch.skipBits(n13);
            l12 = this.pesScratch.readBits(n14);
            l11 |= l12;
            parsableBitArray2 = this.pesScratch;
            parsableBitArray2.skipBits(n13);
            boolean bl2 = this.seenFirstDts;
            if (!bl2 && (bl2 = this.dtsFlag)) {
                parsableBitArray2 = this.pesScratch;
                parsableBitArray2.skipBits(n10);
                parsableBitArray = this.pesScratch;
                n10 = parsableBitArray.readBits(n12);
                long l13 = n10;
                l10 = l13 << n11;
                this.pesScratch.skipBits(n13);
                l12 = this.pesScratch.readBits(n14) << n14;
                l10 |= l12;
                this.pesScratch.skipBits(n13);
                n12 = this.pesScratch.readBits(n14);
                long l14 = n12;
                this.pesScratch.skipBits(n13);
                TimestampAdjuster timestampAdjuster = this.timestampAdjuster;
                timestampAdjuster.adjustTsTimestamp(l10 |= l14);
                this.seenFirstDts = n13;
            }
            object = this.timestampAdjuster;
            this.timeUs = l10 = ((TimestampAdjuster)object).adjustTsTimestamp(l11);
        }
    }

    private void setState(int n10) {
        this.state = n10;
        this.bytesRead = 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void consume(ParsableByteArray object, int n10) {
        Object object2;
        int n11;
        Object object3;
        Object object4 = this.timestampAdjuster;
        Assertions.checkStateNotNull(object4);
        int n12 = n10 & 1;
        int n13 = -1;
        int n14 = 3;
        int n15 = 2;
        int n16 = 1;
        if (n12 != 0) {
            n12 = this.state;
            if (n12 != 0 && n12 != n16) {
                object3 = TAG;
                if (n12 != n15) {
                    if (n12 != n14) {
                        object = new IllegalStateException();
                        throw object;
                    }
                    n12 = this.payloadSize;
                    if (n12 != n13) {
                        n11 = 59;
                        StringBuilder stringBuilder = new StringBuilder(n11);
                        object2 = "Unexpected start indicator: expected ";
                        stringBuilder.append((String)object2);
                        stringBuilder.append(n12);
                        stringBuilder.append(" more bytes");
                        object4 = stringBuilder.toString();
                        Log.w((String)object3, (String)object4);
                    }
                    object4 = this.reader;
                    object4.packetFinished();
                } else {
                    object4 = "Unexpected start indicator reading extended header";
                    Log.w((String)object3, (String)object4);
                }
            }
            this.setState(n16);
        }
        while ((n12 = ((ParsableByteArray)object).bytesLeft()) > 0) {
            n12 = this.state;
            if (n12 != 0) {
                int n17 = 0;
                object3 = null;
                if (n12 != n16) {
                    if (n12 != n15) {
                        if (n12 != n14) {
                            object = new IllegalStateException();
                            throw object;
                        }
                        n12 = ((ParsableByteArray)object).bytesLeft();
                        n11 = this.payloadSize;
                        if (n11 != n13) {
                            n17 = n12 - n11;
                        }
                        if (n17 > 0) {
                            n12 -= n17;
                            n17 = ((ParsableByteArray)object).getPosition() + n12;
                            ((ParsableByteArray)object).setLimit(n17);
                        }
                        object3 = this.reader;
                        object3.consume((ParsableByteArray)object);
                        n17 = this.payloadSize;
                        if (n17 == n13) continue;
                        this.payloadSize = n17 -= n12;
                        if (n17 != 0) continue;
                        object4 = this.reader;
                        object4.packetFinished();
                        this.setState(n16);
                        continue;
                    }
                    n11 = this.extendedHeaderLength;
                    n12 = Math.min(10, n11);
                    object2 = this.pesScratch.data;
                    if ((n12 = (int)(this.continueRead((ParsableByteArray)object, (byte[])object2, n12) ? 1 : 0)) == 0) continue;
                    object4 = null;
                    n11 = this.extendedHeaderLength;
                    n12 = (int)(this.continueRead((ParsableByteArray)object, null, n11) ? 1 : 0);
                    if (n12 == 0) continue;
                    this.parseHeaderExtension();
                    n12 = (int)(this.dataAlignmentIndicator ? 1 : 0);
                    if (n12 != 0) {
                        n17 = 4;
                    }
                    object4 = this.reader;
                    long l10 = this.timeUs;
                    object4.packetStarted(l10, n10 |= n17);
                    this.setState(n14);
                    continue;
                }
                object4 = this.pesScratch.data;
                n11 = 9;
                n12 = (int)(this.continueRead((ParsableByteArray)object, (byte[])object4, n11) ? 1 : 0);
                if (n12 == 0) continue;
                n12 = (int)(this.parseHeader() ? 1 : 0);
                if (n12 != 0) {
                    n17 = n15;
                }
                this.setState(n17);
                continue;
            }
            n12 = ((ParsableByteArray)object).bytesLeft();
            ((ParsableByteArray)object).skipBytes(n12);
        }
        return;
    }

    public void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader$TrackIdGenerator tsPayloadReader$TrackIdGenerator) {
        this.timestampAdjuster = timestampAdjuster;
        this.reader.createTracks(extractorOutput, tsPayloadReader$TrackIdGenerator);
    }

    public final void seek() {
        this.state = 0;
        this.bytesRead = 0;
        this.seenFirstDts = false;
        this.reader.seek();
    }
}

