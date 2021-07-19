/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteOutput;
import com.google.protobuf.ByteString;

public abstract class ByteString$LeafByteString
extends ByteString {
    public abstract boolean equalsRange(ByteString var1, int var2, int var3);

    public final int getTreeDepth() {
        return 0;
    }

    public final boolean isBalanced() {
        return true;
    }

    public void writeToReverse(ByteOutput byteOutput) {
        this.writeTo(byteOutput);
    }
}

