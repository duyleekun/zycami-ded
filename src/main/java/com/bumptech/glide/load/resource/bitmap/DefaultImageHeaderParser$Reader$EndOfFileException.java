/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.load.resource.bitmap;

import java.io.IOException;

public final class DefaultImageHeaderParser$Reader$EndOfFileException
extends IOException {
    private static final long serialVersionUID = 1L;

    public DefaultImageHeaderParser$Reader$EndOfFileException() {
        super("Unexpectedly reached end of a file");
    }
}

