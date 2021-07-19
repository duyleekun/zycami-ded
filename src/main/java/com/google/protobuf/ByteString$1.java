/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString$AbstractByteIterator;
import java.util.NoSuchElementException;

public class ByteString$1
extends ByteString$AbstractByteIterator {
    private final int limit;
    private int position = 0;
    public final /* synthetic */ ByteString this$0;

    public ByteString$1(ByteString byteString) {
        int n10;
        this.this$0 = byteString;
        this.limit = n10 = byteString.size();
    }

    public boolean hasNext() {
        int n10 = this.position;
        int n11 = this.limit;
        n10 = n10 < n11 ? 1 : 0;
        return n10 != 0;
    }

    public byte nextByte() {
        int n10 = this.position;
        int n11 = this.limit;
        if (n10 < n11) {
            this.position = n11 = n10 + 1;
            return this.this$0.internalByteAt(n10);
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }
}

