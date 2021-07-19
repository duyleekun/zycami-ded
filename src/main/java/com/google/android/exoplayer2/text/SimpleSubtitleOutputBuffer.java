/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.decoder.OutputBuffer$Owner;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;

public final class SimpleSubtitleOutputBuffer
extends SubtitleOutputBuffer {
    private final OutputBuffer$Owner owner;

    public SimpleSubtitleOutputBuffer(OutputBuffer$Owner outputBuffer$Owner) {
        this.owner = outputBuffer$Owner;
    }

    public final void release() {
        this.owner.releaseOutputBuffer(this);
    }
}

