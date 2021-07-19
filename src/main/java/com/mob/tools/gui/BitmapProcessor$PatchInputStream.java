/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.gui;

import java.io.FilterInputStream;
import java.io.InputStream;

public class BitmapProcessor$PatchInputStream
extends FilterInputStream {
    public InputStream in;

    public BitmapProcessor$PatchInputStream(InputStream inputStream) {
        super(inputStream);
        this.in = inputStream;
    }

    public long skip(long l10) {
        long l11;
        InputStream inputStream;
        long l12;
        long l13;
        long l14;
        long l15;
        long l16;
        long l17 = l16 = 0L;
        while ((l15 = l17 == l10 ? 0 : (l17 < l10 ? -1 : 1)) < 0 && (l14 = (l13 = (l12 = (inputStream = this.in).skip(l11 = l10 - l17)) - l16) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false) {
            l17 += l12;
        }
        return l17;
    }
}

