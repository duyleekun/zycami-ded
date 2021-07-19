/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.text.pgs;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.pgs.PgsDecoder$CueBuilder;
import com.google.android.exoplayer2.text.pgs.PgsSubtitle;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.Inflater;

public final class PgsDecoder
extends SimpleSubtitleDecoder {
    private static final byte INFLATE_HEADER = 120;
    private static final int SECTION_TYPE_BITMAP_PICTURE = 21;
    private static final int SECTION_TYPE_END = 128;
    private static final int SECTION_TYPE_IDENTIFIER = 22;
    private static final int SECTION_TYPE_PALETTE = 20;
    private final ParsableByteArray buffer;
    private final PgsDecoder$CueBuilder cueBuilder;
    private final ParsableByteArray inflatedBuffer;
    private Inflater inflater;

    public PgsDecoder() {
        super("PgsDecoder");
        Object object = new ParsableByteArray();
        this.buffer = object;
        object = new ParsableByteArray();
        this.inflatedBuffer = object;
        this.cueBuilder = object = new PgsDecoder$CueBuilder();
    }

    private void maybeInflateData(ParsableByteArray parsableByteArray) {
        int n10;
        int n11 = parsableByteArray.bytesLeft();
        if (n11 > 0 && (n11 = parsableByteArray.peekUnsignedByte()) == (n10 = 120)) {
            Object object;
            Object object2 = this.inflater;
            if (object2 == null) {
                this.inflater = object2 = new Inflater();
            }
            if ((n11 = (int)(Util.inflate(parsableByteArray, (ParsableByteArray)(object2 = this.inflatedBuffer), (Inflater)(object = this.inflater)) ? 1 : 0)) != 0) {
                object2 = this.inflatedBuffer.getData();
                object = this.inflatedBuffer;
                n10 = ((ParsableByteArray)object).limit();
                parsableByteArray.reset((byte[])object2, n10);
            }
        }
    }

    private static Cue readNextSection(ParsableByteArray parsableByteArray, PgsDecoder$CueBuilder pgsDecoder$CueBuilder) {
        int n10 = parsableByteArray.limit();
        int n11 = parsableByteArray.readUnsignedByte();
        int n12 = parsableByteArray.readUnsignedShort();
        int n13 = parsableByteArray.getPosition() + n12;
        Cue cue = null;
        if (n13 > n10) {
            parsableByteArray.setPosition(n10);
            return null;
        }
        n10 = 128;
        if (n11 != n10) {
            switch (n11) {
                default: {
                    break;
                }
                case 22: {
                    PgsDecoder$CueBuilder.access$200(pgsDecoder$CueBuilder, parsableByteArray, n12);
                    break;
                }
                case 21: {
                    PgsDecoder$CueBuilder.access$100(pgsDecoder$CueBuilder, parsableByteArray, n12);
                    break;
                }
                case 20: {
                    PgsDecoder$CueBuilder.access$000(pgsDecoder$CueBuilder, parsableByteArray, n12);
                    break;
                }
            }
        } else {
            cue = pgsDecoder$CueBuilder.build();
            pgsDecoder$CueBuilder.reset();
        }
        parsableByteArray.setPosition(n13);
        return cue;
    }

    public Subtitle decode(byte[] object, int n10, boolean n11) {
        Object object2;
        Object object3 = this.buffer;
        ((ParsableByteArray)object3).reset((byte[])object, n10);
        object = this.buffer;
        this.maybeInflateData((ParsableByteArray)object);
        this.cueBuilder.reset();
        object = new ArrayList;
        ((ArrayList)object)();
        while ((n10 = ((ParsableByteArray)(object2 = this.buffer)).bytesLeft()) >= (n11 = 3)) {
            object2 = this.buffer;
            object3 = this.cueBuilder;
            if ((object2 = PgsDecoder.readNextSection((ParsableByteArray)object2, (PgsDecoder$CueBuilder)object3)) == null) continue;
            ((ArrayList)object).add(object2);
        }
        object = Collections.unmodifiableList(object);
        object2 = new PgsSubtitle((List)object);
        return object2;
    }
}

