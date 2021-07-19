/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedBytes;
import java.io.InputStream;
import java.io.Reader;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;

public final class ReaderInputStream
extends InputStream {
    private ByteBuffer byteBuffer;
    private CharBuffer charBuffer;
    private boolean doneFlushing;
    private boolean draining;
    private final CharsetEncoder encoder;
    private boolean endOfInput;
    private final Reader reader;
    private final byte[] singleByte;

    public ReaderInputStream(Reader reader, Charset object, int n10) {
        object = ((Charset)object).newEncoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
        object = ((CharsetEncoder)object).onMalformedInput(codingErrorAction);
        codingErrorAction = CodingErrorAction.REPLACE;
        object = ((CharsetEncoder)object).onUnmappableCharacter(codingErrorAction);
        this(reader, (CharsetEncoder)object, n10);
    }

    public ReaderInputStream(Reader object, CharsetEncoder charsetEncoder, int n10) {
        boolean bl2 = true;
        byte[] byArray = new byte[bl2];
        this.singleByte = byArray;
        object = (Reader)Preconditions.checkNotNull(object);
        this.reader = object;
        this.encoder = object = (CharsetEncoder)Preconditions.checkNotNull(charsetEncoder);
        if (n10 <= 0) {
            bl2 = false;
        }
        Preconditions.checkArgument(bl2, "bufferSize must be positive: %s", n10);
        charsetEncoder.reset();
        this.charBuffer = object = CharBuffer.allocate(n10);
        ((CharBuffer)object).flip();
        this.byteBuffer = object = ByteBuffer.allocate(n10);
    }

    private static int availableCapacity(Buffer buffer) {
        int n10 = buffer.capacity();
        int n11 = buffer.limit();
        return n10 - n11;
    }

    private int drain(byte[] byArray, int n10, int n11) {
        int n12 = this.byteBuffer.remaining();
        n11 = Math.min(n11, n12);
        this.byteBuffer.get(byArray, n10, n11);
        return n11;
    }

    private static CharBuffer grow(CharBuffer charBuffer) {
        Object object = charBuffer.array();
        int n10 = charBuffer.capacity() * 2;
        object = CharBuffer.wrap(Arrays.copyOf((char[])object, n10));
        n10 = charBuffer.position();
        ((CharBuffer)object).position(n10);
        int n11 = charBuffer.limit();
        ((CharBuffer)object).limit(n11);
        return object;
    }

    private void readMoreChars() {
        int n10;
        CharBuffer charBuffer;
        int n11;
        CharBuffer charBuffer2 = this.charBuffer;
        int n12 = ReaderInputStream.availableCapacity(charBuffer2);
        if (n12 == 0) {
            charBuffer2 = this.charBuffer;
            n12 = charBuffer2.position();
            if (n12 > 0) {
                charBuffer2 = this.charBuffer.compact();
                charBuffer2.flip();
            } else {
                this.charBuffer = charBuffer2 = ReaderInputStream.grow(this.charBuffer);
            }
        }
        charBuffer2 = this.charBuffer;
        n12 = charBuffer2.limit();
        Reader reader = this.reader;
        Object object = this.charBuffer.array();
        int n13 = reader.read((char[])object, n12, n11 = ReaderInputStream.availableCapacity(charBuffer = this.charBuffer));
        if (n13 == (n10 = -1)) {
            n12 = 1;
            this.endOfInput = n12;
        } else {
            object = this.charBuffer;
            object.limit(n12 += n13);
        }
    }

    private void startDraining(boolean bl2) {
        ByteBuffer byteBuffer;
        int n10;
        ByteBuffer byteBuffer2 = this.byteBuffer;
        byteBuffer2.flip();
        if (bl2 && (n10 = (byteBuffer = this.byteBuffer).remaining()) == 0) {
            int n11 = this.byteBuffer.capacity() * 2;
            this.byteBuffer = byteBuffer = ByteBuffer.allocate(n11);
        } else {
            boolean bl3;
            this.draining = bl3 = true;
        }
    }

    public void close() {
        this.reader.close();
    }

    public int read() {
        int n10;
        byte[] byArray = this.singleByte;
        int n11 = this.read(byArray);
        if (n11 == (n10 = 1)) {
            byArray = this.singleByte;
            n10 = 0;
            n11 = UnsignedBytes.toInt(byArray[0]);
        } else {
            n11 = -1;
        }
        return n11;
    }

    public int read(byte[] byArray, int n10, int n11) {
        Object object;
        int n12 = n10 + n11;
        int n13 = byArray.length;
        Preconditions.checkPositionIndexes(n10, n12, n13);
        n12 = 0;
        if (n11 == 0) {
            return 0;
        }
        n13 = (int)(this.endOfInput ? 1 : 0);
        int n14 = 0;
        block0: while (true) {
            int n15;
            int n16;
            if ((n16 = this.draining) != 0) {
                n16 = n10 + n14;
                if ((n14 += (n16 = this.drain(byArray, n16, n15 = n11 - n14))) != n11 && (n16 = (int)(this.doneFlushing ? 1 : 0)) == 0) {
                    this.draining = false;
                    object = this.byteBuffer;
                    ((ByteBuffer)object).clear();
                } else {
                    if (n14 <= 0) {
                        n14 = -1;
                    }
                    return n14;
                }
            }
            while (true) {
                Buffer buffer;
                if ((n16 = this.doneFlushing) != 0) {
                    object = CoderResult.UNDERFLOW;
                } else if (n13 != 0) {
                    object = this.encoder;
                    buffer = this.byteBuffer;
                    object = ((CharsetEncoder)object).flush((ByteBuffer)buffer);
                } else {
                    object = this.encoder;
                    buffer = this.charBuffer;
                    ByteBuffer byteBuffer = this.byteBuffer;
                    boolean bl2 = this.endOfInput;
                    object = ((CharsetEncoder)object).encode((CharBuffer)buffer, byteBuffer, bl2);
                }
                n15 = (int)(((CoderResult)object).isOverflow() ? 1 : 0);
                boolean bl3 = true;
                if (n15 != 0) {
                    this.startDraining(bl3);
                    continue block0;
                }
                n15 = (int)(((CoderResult)object).isUnderflow() ? 1 : 0);
                if (n15 != 0) {
                    if (n13 != 0) {
                        this.doneFlushing = bl3;
                        this.startDraining(false);
                        continue block0;
                    }
                    n16 = (int)(this.endOfInput ? 1 : 0);
                    if (n16 != 0) {
                        n13 = (int)(bl3 ? 1 : 0);
                        continue;
                    }
                    this.readMoreChars();
                    continue;
                }
                n15 = (int)(((CoderResult)object).isError() ? 1 : 0);
                if (n15 != 0) break block0;
            }
            break;
        }
        ((CoderResult)object).throwException();
        return 0;
    }
}

