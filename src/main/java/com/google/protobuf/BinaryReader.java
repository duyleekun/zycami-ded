/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.BinaryReader$1;
import com.google.protobuf.BinaryReader$SafeHeapReader;
import com.google.protobuf.Reader;
import java.nio.ByteBuffer;

public abstract class BinaryReader
implements Reader {
    private static final int FIXED32_MULTIPLE_MASK = 3;
    private static final int FIXED64_MULTIPLE_MASK = 7;

    private BinaryReader() {
    }

    public /* synthetic */ BinaryReader(BinaryReader$1 binaryReader$1) {
        this();
    }

    public static BinaryReader newInstance(ByteBuffer object, boolean bl2) {
        boolean bl3 = ((ByteBuffer)object).hasArray();
        if (bl3) {
            BinaryReader$SafeHeapReader binaryReader$SafeHeapReader = new BinaryReader$SafeHeapReader((ByteBuffer)object, bl2);
            return binaryReader$SafeHeapReader;
        }
        object = new IllegalArgumentException("Direct buffers not yet supported");
        throw object;
    }

    public abstract int getTotalBytesRead();

    public boolean shouldDiscardUnknownFields() {
        return false;
    }
}

