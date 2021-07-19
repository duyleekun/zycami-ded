/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteOutput;
import com.google.protobuf.ByteString;
import java.nio.ByteBuffer;

public final class UnsafeByteOperations {
    private UnsafeByteOperations() {
    }

    public static ByteString unsafeWrap(ByteBuffer byteBuffer) {
        return ByteString.wrap(byteBuffer);
    }

    public static ByteString unsafeWrap(byte[] byArray) {
        return ByteString.wrap(byArray);
    }

    public static ByteString unsafeWrap(byte[] byArray, int n10, int n11) {
        return ByteString.wrap(byArray, n10, n11);
    }

    public static void unsafeWriteTo(ByteString byteString, ByteOutput byteOutput) {
        byteString.writeTo(byteOutput);
    }
}

