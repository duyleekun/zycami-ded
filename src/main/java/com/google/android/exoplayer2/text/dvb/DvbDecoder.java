/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.text.dvb;

import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.dvb.DvbParser;
import com.google.android.exoplayer2.text.dvb.DvbSubtitle;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.List;

public final class DvbDecoder
extends SimpleSubtitleDecoder {
    private final DvbParser parser;

    public DvbDecoder(List object) {
        super("DvbDecoder");
        DvbParser dvbParser;
        object = (byte[])object.get(0);
        ParsableByteArray parsableByteArray = new ParsableByteArray((byte[])object);
        int n10 = parsableByteArray.readUnsignedShort();
        int n11 = parsableByteArray.readUnsignedShort();
        this.parser = dvbParser = new DvbParser(n10, n11);
    }

    public Subtitle decode(byte[] object, int n10, boolean bl2) {
        Object object2;
        if (bl2) {
            object2 = this.parser;
            ((DvbParser)object2).reset();
        }
        object = this.parser.decode((byte[])object, n10);
        object2 = new DvbSubtitle((List)object);
        return object2;
    }
}

