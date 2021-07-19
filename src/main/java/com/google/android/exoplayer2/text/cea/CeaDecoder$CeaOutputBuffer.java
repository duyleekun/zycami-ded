/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.text.cea;

import com.google.android.exoplayer2.decoder.OutputBuffer$Owner;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;

public final class CeaDecoder$CeaOutputBuffer
extends SubtitleOutputBuffer {
    private OutputBuffer$Owner owner;

    public CeaDecoder$CeaOutputBuffer(OutputBuffer$Owner outputBuffer$Owner) {
        this.owner = outputBuffer$Owner;
    }

    public final void release() {
        this.owner.releaseOutputBuffer(this);
    }
}

