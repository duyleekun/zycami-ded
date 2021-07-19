/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class Atom$LeafAtom
extends Atom {
    public final ParsableByteArray data;

    public Atom$LeafAtom(int n10, ParsableByteArray parsableByteArray) {
        super(n10);
        this.data = parsableByteArray;
    }
}

