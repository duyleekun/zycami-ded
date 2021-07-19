/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString$1;
import com.google.protobuf.ByteString$ByteArrayCopier;
import java.util.Arrays;

public final class ByteString$ArraysByteArrayCopier
implements ByteString$ByteArrayCopier {
    private ByteString$ArraysByteArrayCopier() {
    }

    public /* synthetic */ ByteString$ArraysByteArrayCopier(ByteString$1 byteString$1) {
        this();
    }

    public byte[] copyFrom(byte[] byArray, int n10, int n11) {
        return Arrays.copyOfRange(byArray, n10, n11 += n10);
    }
}

