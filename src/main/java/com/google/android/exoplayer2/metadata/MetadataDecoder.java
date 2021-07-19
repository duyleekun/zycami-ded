/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.metadata;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;

public interface MetadataDecoder {
    public Metadata decode(MetadataInputBuffer var1);
}

