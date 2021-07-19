/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString$AbstractByteIterator;
import com.google.protobuf.ByteString$ByteIterator;
import com.google.protobuf.RopeByteString;
import com.google.protobuf.RopeByteString$PieceIterator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RopeByteString$1
extends ByteString$AbstractByteIterator {
    public ByteString$ByteIterator current;
    public final RopeByteString$PieceIterator pieces;
    public final /* synthetic */ RopeByteString this$0;

    public RopeByteString$1(RopeByteString object) {
        RopeByteString$PieceIterator ropeByteString$PieceIterator;
        this.this$0 = object;
        this.pieces = ropeByteString$PieceIterator = new RopeByteString$PieceIterator((ByteString)object, null);
        this.current = object = this.nextPiece();
    }

    private ByteString$ByteIterator nextPiece() {
        Iterator iterator2 = this.pieces;
        boolean bl2 = iterator2.hasNext();
        if (bl2) {
            iterator2 = ((ByteString)this.pieces.next()).iterator();
        } else {
            bl2 = false;
            iterator2 = null;
        }
        return iterator2;
    }

    public boolean hasNext() {
        boolean bl2;
        ByteString$ByteIterator byteString$ByteIterator = this.current;
        if (byteString$ByteIterator != null) {
            bl2 = true;
        } else {
            bl2 = false;
            byteString$ByteIterator = null;
        }
        return bl2;
    }

    public byte nextByte() {
        Object object = this.current;
        if (object != null) {
            byte by2 = object.nextByte();
            ByteString$ByteIterator byteString$ByteIterator = this.current;
            boolean bl2 = byteString$ByteIterator.hasNext();
            if (!bl2) {
                this.current = byteString$ByteIterator = this.nextPiece();
            }
            return by2;
        }
        object = new NoSuchElementException();
        throw object;
    }
}

