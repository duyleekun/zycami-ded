/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.metadata;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.MetadataDecoder;
import com.google.android.exoplayer2.metadata.MetadataDecoderFactory$1;

public interface MetadataDecoderFactory {
    public static final MetadataDecoderFactory DEFAULT;

    static {
        MetadataDecoderFactory$1 metadataDecoderFactory$1 = new MetadataDecoderFactory$1();
        DEFAULT = metadataDecoderFactory$1;
    }

    public MetadataDecoder createDecoder(Format var1);

    public boolean supportsFormat(Format var1);
}

