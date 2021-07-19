/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString$LiteralByteString;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

public final class ByteString$BoundedByteString
extends ByteString$LiteralByteString {
    private static final long serialVersionUID = 1L;
    private final int bytesLength;
    private final int bytesOffset;

    public ByteString$BoundedByteString(byte[] byArray, int n10, int n11) {
        super(byArray);
        int n12 = n10 + n11;
        int n13 = byArray.length;
        ByteString.checkRange(n10, n12, n13);
        this.bytesOffset = n10;
        this.bytesLength = n11;
    }

    private void readObject(ObjectInputStream object) {
        object = new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        throw object;
    }

    public byte byteAt(int n10) {
        int n11 = this.size();
        ByteString.checkIndex(n10, n11);
        byte[] byArray = this.bytes;
        int n12 = this.bytesOffset + n10;
        return byArray[n12];
    }

    public void copyToInternal(byte[] byArray, int n10, int n11, int n12) {
        byte[] byArray2 = this.bytes;
        int n13 = this.getOffsetIntoBytes() + n10;
        System.arraycopy(byArray2, n13, byArray, n11, n12);
    }

    public int getOffsetIntoBytes() {
        return this.bytesOffset;
    }

    public byte internalByteAt(int n10) {
        byte[] byArray = this.bytes;
        int n11 = this.bytesOffset + n10;
        return byArray[n11];
    }

    public int size() {
        return this.bytesLength;
    }

    public Object writeReplace() {
        return ByteString.wrap(this.toByteArray());
    }
}

