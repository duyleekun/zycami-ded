/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString$1;
import com.google.protobuf.ByteString$ByteArrayCopier;

public final class ByteString$SystemByteArrayCopier
implements ByteString$ByteArrayCopier {
    private ByteString$SystemByteArrayCopier() {
    }

    public /* synthetic */ ByteString$SystemByteArrayCopier(ByteString$1 byteString$1) {
        this();
    }

    public byte[] copyFrom(byte[] byArray, int n10, int n11) {
        byte[] byArray2 = new byte[n11];
        System.arraycopy(byArray, n10, byArray2, 0, n11);
        return byArray2;
    }
}

