/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString$LeafByteString;
import com.google.protobuf.RopeByteString;
import com.google.protobuf.RopeByteString$1;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class RopeByteString$PieceIterator
implements Iterator {
    private final ArrayDeque breadCrumbs;
    private ByteString$LeafByteString next;

    private RopeByteString$PieceIterator(ByteString byteString) {
        boolean bl2 = byteString instanceof RopeByteString;
        if (bl2) {
            ArrayDeque<ByteString> arrayDeque;
            byteString = (RopeByteString)byteString;
            int n10 = ((RopeByteString)byteString).getTreeDepth();
            this.breadCrumbs = arrayDeque = new ArrayDeque<ByteString>(n10);
            arrayDeque.push(byteString);
            byteString = RopeByteString.access$400((RopeByteString)byteString);
            byteString = this.getLeafByLeft(byteString);
            this.next = byteString;
        } else {
            bl2 = false;
            Object var3_4 = null;
            this.breadCrumbs = null;
            byteString = (ByteString$LeafByteString)byteString;
            this.next = byteString;
        }
    }

    public /* synthetic */ RopeByteString$PieceIterator(ByteString byteString, RopeByteString$1 ropeByteString$1) {
        this(byteString);
    }

    private ByteString$LeafByteString getLeafByLeft(ByteString byteString) {
        boolean bl2;
        while (bl2 = byteString instanceof RopeByteString) {
            byteString = (RopeByteString)byteString;
            ArrayDeque arrayDeque = this.breadCrumbs;
            arrayDeque.push(byteString);
            byteString = RopeByteString.access$400((RopeByteString)byteString);
        }
        return (ByteString$LeafByteString)byteString;
    }

    private ByteString$LeafByteString getNextNonEmptyLeaf() {
        boolean bl2;
        Iterable iterable;
        while ((iterable = this.breadCrumbs) != null && !(bl2 = ((ArrayDeque)iterable).isEmpty())) {
            iterable = RopeByteString.access$500((RopeByteString)this.breadCrumbs.pop());
            boolean bl3 = ((ByteString)(iterable = this.getLeafByLeft((ByteString)iterable))).isEmpty();
            if (bl3) continue;
            return iterable;
        }
        return null;
    }

    public boolean hasNext() {
        boolean bl2;
        ByteString$LeafByteString byteString$LeafByteString = this.next;
        if (byteString$LeafByteString != null) {
            bl2 = true;
        } else {
            bl2 = false;
            byteString$LeafByteString = null;
        }
        return bl2;
    }

    public ByteString$LeafByteString next() {
        Serializable serializable = this.next;
        if (serializable != null) {
            ByteString$LeafByteString byteString$LeafByteString;
            this.next = byteString$LeafByteString = this.getNextNonEmptyLeaf();
            return serializable;
        }
        serializable = new NoSuchElementException();
        throw serializable;
    }

    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}

