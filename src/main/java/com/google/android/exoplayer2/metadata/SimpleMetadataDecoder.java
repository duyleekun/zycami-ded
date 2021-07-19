/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.metadata;

import com.google.android.exoplayer2.decoder.Buffer;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataDecoder;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import java.nio.ByteBuffer;

public abstract class SimpleMetadataDecoder
implements MetadataDecoder {
    /*
     * WARNING - void declaration
     */
    public final Metadata decode(MetadataInputBuffer object) {
        void var3_8;
        int n10;
        boolean bl2;
        ByteBuffer byteBuffer = (ByteBuffer)Assertions.checkNotNull(((DecoderInputBuffer)object).data);
        int n102 = byteBuffer.position();
        if (n102 == 0 && (bl2 = byteBuffer.hasArray()) && (n10 = byteBuffer.arrayOffset()) == 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        Assertions.checkArgument((boolean)var3_8);
        boolean bl5 = ((Buffer)object).isDecodeOnly();
        object = bl5 ? null : this.decode((MetadataInputBuffer)object, byteBuffer);
        return object;
    }

    public abstract Metadata decode(MetadataInputBuffer var1, ByteBuffer var2);
}

