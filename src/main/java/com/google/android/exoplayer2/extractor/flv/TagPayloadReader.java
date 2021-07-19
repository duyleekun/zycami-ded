/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;

public abstract class TagPayloadReader {
    public final TrackOutput output;

    public TagPayloadReader(TrackOutput trackOutput) {
        this.output = trackOutput;
    }

    public final boolean consume(ParsableByteArray parsableByteArray, long l10) {
        boolean bl2;
        boolean bl3 = this.parseHeader(parsableByteArray);
        if (bl3 && (bl2 = this.parsePayload(parsableByteArray, l10))) {
            bl2 = true;
        } else {
            bl2 = false;
            parsableByteArray = null;
        }
        return bl2;
    }

    public abstract boolean parseHeader(ParsableByteArray var1);

    public abstract boolean parsePayload(ParsableByteArray var1, long var2);

    public abstract void seek();
}

