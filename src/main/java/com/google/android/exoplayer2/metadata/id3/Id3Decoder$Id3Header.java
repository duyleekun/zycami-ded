/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.metadata.id3;

public final class Id3Decoder$Id3Header {
    private final int framesSize;
    private final boolean isUnsynchronized;
    private final int majorVersion;

    public Id3Decoder$Id3Header(int n10, boolean bl2, int n11) {
        this.majorVersion = n10;
        this.isUnsynchronized = bl2;
        this.framesSize = n11;
    }

    public static /* synthetic */ int access$000(Id3Decoder$Id3Header id3Decoder$Id3Header) {
        return id3Decoder$Id3Header.majorVersion;
    }

    public static /* synthetic */ int access$100(Id3Decoder$Id3Header id3Decoder$Id3Header) {
        return id3Decoder$Id3Header.framesSize;
    }

    public static /* synthetic */ boolean access$200(Id3Decoder$Id3Header id3Decoder$Id3Header) {
        return id3Decoder$Id3Header.isUnsynchronized;
    }
}

