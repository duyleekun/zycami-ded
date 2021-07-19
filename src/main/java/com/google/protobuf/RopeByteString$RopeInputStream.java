/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString$LeafByteString;
import com.google.protobuf.RopeByteString;
import com.google.protobuf.RopeByteString$PieceIterator;
import java.io.InputStream;
import java.util.Objects;

public class RopeByteString$RopeInputStream
extends InputStream {
    private ByteString$LeafByteString currentPiece;
    private int currentPieceIndex;
    private int currentPieceOffsetInRope;
    private int currentPieceSize;
    private int mark;
    private RopeByteString$PieceIterator pieceIterator;
    public final /* synthetic */ RopeByteString this$0;

    public RopeByteString$RopeInputStream(RopeByteString ropeByteString) {
        this.this$0 = ropeByteString;
        this.initialize();
    }

    private void advanceIfCurrentPieceFullyRead() {
        int n10;
        int n11;
        ByteString$LeafByteString byteString$LeafByteString = this.currentPiece;
        if (byteString$LeafByteString != null && (n11 = this.currentPieceIndex) == (n10 = this.currentPieceSize)) {
            this.currentPieceOffsetInRope = n11 = this.currentPieceOffsetInRope + n10;
            n11 = 0;
            byteString$LeafByteString = null;
            this.currentPieceIndex = 0;
            RopeByteString$PieceIterator ropeByteString$PieceIterator = this.pieceIterator;
            n10 = (int)(ropeByteString$PieceIterator.hasNext() ? 1 : 0);
            if (n10 != 0) {
                this.currentPiece = byteString$LeafByteString = this.pieceIterator.next();
                this.currentPieceSize = n11 = byteString$LeafByteString.size();
            } else {
                n10 = 0;
                ropeByteString$PieceIterator = null;
                this.currentPiece = null;
                this.currentPieceSize = 0;
            }
        }
    }

    private void initialize() {
        int n10;
        RopeByteString ropeByteString = this.this$0;
        Object object = new RopeByteString$PieceIterator(ropeByteString, null);
        this.pieceIterator = object;
        this.currentPiece = object = ((RopeByteString$PieceIterator)object).next();
        this.currentPieceSize = n10 = ((ByteString)object).size();
        this.currentPieceIndex = 0;
        this.currentPieceOffsetInRope = 0;
    }

    private int readSkipInternal(byte[] byArray, int n10, int n11) {
        int n12;
        int n13;
        for (n12 = n11; n12 > 0; n12 -= n13) {
            this.advanceIfCurrentPieceFullyRead();
            ByteString$LeafByteString byteString$LeafByteString = this.currentPiece;
            if (byteString$LeafByteString == null) break;
            n13 = this.currentPieceSize;
            int n14 = this.currentPieceIndex;
            n13 = Math.min(n13 - n14, n12);
            if (byArray != null) {
                ByteString$LeafByteString byteString$LeafByteString2 = this.currentPiece;
                int n15 = this.currentPieceIndex;
                byteString$LeafByteString2.copyTo(byArray, n15, n10, n13);
                n10 += n13;
            }
            this.currentPieceIndex = n14 = this.currentPieceIndex + n13;
        }
        return n11 - n12;
    }

    public int available() {
        int n10 = this.currentPieceOffsetInRope;
        int n11 = this.currentPieceIndex;
        return this.this$0.size() - (n10 += n11);
    }

    public void mark(int n10) {
        n10 = this.currentPieceOffsetInRope;
        int n11 = this.currentPieceIndex;
        this.mark = n10 += n11;
    }

    public boolean markSupported() {
        return true;
    }

    public int read() {
        int n10;
        this.advanceIfCurrentPieceFullyRead();
        ByteString$LeafByteString byteString$LeafByteString = this.currentPiece;
        if (byteString$LeafByteString == null) {
            return -1;
        }
        int n11 = this.currentPieceIndex;
        this.currentPieceIndex = n10 = n11 + 1;
        return byteString$LeafByteString.byteAt(n11) & 0xFF;
    }

    public int read(byte[] object, int n10, int n11) {
        int n12;
        Objects.requireNonNull(object);
        if (n10 >= 0 && n11 >= 0 && n11 <= (n12 = ((byte[])object).length - n10)) {
            int n13 = this.readSkipInternal((byte[])object, n10, n11);
            if (n13 == 0) {
                n13 = -1;
            }
            return n13;
        }
        object = new IndexOutOfBoundsException;
        object();
        throw object;
    }

    public void reset() {
        synchronized (this) {
            this.initialize();
            Object var1_1 = null;
            int n10 = this.mark;
            this.readSkipInternal(null, 0, n10);
            return;
        }
    }

    public long skip(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            l11 = Integer.MAX_VALUE;
            long l13 = l10 - l11;
            Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object2 > 0) {
                l10 = l11;
            }
            int n10 = (int)l10;
            return this.readSkipInternal(null, 0, n10);
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
        throw indexOutOfBoundsException;
    }
}

