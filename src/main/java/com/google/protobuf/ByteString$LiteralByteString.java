/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteOutput;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString$BoundedByteString;
import com.google.protobuf.ByteString$LeafByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Internal;
import com.google.protobuf.Utf8;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ByteString$LiteralByteString
extends ByteString$LeafByteString {
    private static final long serialVersionUID = 1L;
    public final byte[] bytes;

    public ByteString$LiteralByteString(byte[] byArray) {
        Objects.requireNonNull(byArray);
        this.bytes = byArray;
    }

    public final ByteBuffer asReadOnlyByteBuffer() {
        byte[] byArray = this.bytes;
        int n10 = this.getOffsetIntoBytes();
        int n11 = this.size();
        return ByteBuffer.wrap(byArray, n10, n11).asReadOnlyBuffer();
    }

    public final List asReadOnlyByteBufferList() {
        return Collections.singletonList(this.asReadOnlyByteBuffer());
    }

    public byte byteAt(int n10) {
        return this.bytes[n10];
    }

    public final void copyTo(ByteBuffer byteBuffer) {
        byte[] byArray = this.bytes;
        int n10 = this.getOffsetIntoBytes();
        int n11 = this.size();
        byteBuffer.put(byArray, n10, n11);
    }

    public void copyToInternal(byte[] byArray, int n10, int n11, int n12) {
        System.arraycopy(this.bytes, n10, byArray, n11, n12);
    }

    public final boolean equals(Object object) {
        int n10 = 1;
        if (object == this) {
            return n10 != 0;
        }
        int n11 = object instanceof ByteString;
        if (n11 == 0) {
            return false;
        }
        n11 = this.size();
        Object object2 = object;
        object2 = (ByteString)object;
        int n12 = ((ByteString)object2).size();
        if (n11 != n12) {
            return false;
        }
        n11 = this.size();
        if (n11 == 0) {
            return n10 != 0;
        }
        n10 = object instanceof ByteString$LiteralByteString;
        if (n10 != 0) {
            object = (ByteString$LiteralByteString)object;
            n10 = this.peekCachedHashCode();
            n11 = ((ByteString)object).peekCachedHashCode();
            if (n10 != 0 && n11 != 0 && n10 != n11) {
                return false;
            }
            n10 = this.size();
            return this.equalsRange((ByteString)object, 0, n10);
        }
        return object.equals(this);
    }

    public final boolean equalsRange(ByteString object, int n10, int n11) {
        int n12 = ((ByteString)object).size();
        if (n11 <= n12) {
            n12 = n10 + n11;
            int n13 = ((ByteString)object).size();
            if (n12 <= n13) {
                n13 = object instanceof ByteString$LiteralByteString;
                if (n13 != 0) {
                    object = (ByteString$LiteralByteString)object;
                    byte[] byArray = this.bytes;
                    byte[] byArray2 = ((ByteString$LiteralByteString)object).bytes;
                    int n14 = this.getOffsetIntoBytes() + n11;
                    n11 = this.getOffsetIntoBytes();
                    int n15 = ((ByteString$LiteralByteString)object).getOffsetIntoBytes() + n10;
                    while (n11 < n14) {
                        n10 = byArray[n11];
                        byte by2 = byArray2[n15];
                        if (n10 != by2) {
                            return false;
                        }
                        ++n11;
                        ++n15;
                    }
                    return true;
                }
                object = ((ByteString)object).substring(n10, n12);
                ByteString byteString = this.substring(0, n11);
                return ((ByteString)object).equals(byteString);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Ran off end of other: ");
            stringBuilder.append(n10);
            String string2 = ", ";
            stringBuilder.append(string2);
            stringBuilder.append(n11);
            stringBuilder.append(string2);
            int n16 = ((ByteString)object).size();
            stringBuilder.append(n16);
            object = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
            throw illegalArgumentException;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Length too large: ");
        charSequence.append(n11);
        n11 = this.size();
        charSequence.append(n11);
        charSequence = charSequence.toString();
        object = new IllegalArgumentException((String)charSequence);
        throw object;
    }

    public int getOffsetIntoBytes() {
        return 0;
    }

    public byte internalByteAt(int n10) {
        return this.bytes[n10];
    }

    public final boolean isValidUtf8() {
        int n10 = this.getOffsetIntoBytes();
        byte[] byArray = this.bytes;
        int n11 = this.size() + n10;
        return Utf8.isValidUtf8(byArray, n10, n11);
    }

    public final CodedInputStream newCodedInput() {
        byte[] byArray = this.bytes;
        int n10 = this.getOffsetIntoBytes();
        int n11 = this.size();
        return CodedInputStream.newInstance(byArray, n10, n11, true);
    }

    public final InputStream newInput() {
        byte[] byArray = this.bytes;
        int n10 = this.getOffsetIntoBytes();
        int n11 = this.size();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray, n10, n11);
        return byteArrayInputStream;
    }

    public final int partialHash(int n10, int n11, int n12) {
        byte[] byArray = this.bytes;
        int n13 = this.getOffsetIntoBytes() + n11;
        return Internal.partialHash(n10, byArray, n13, n12);
    }

    public final int partialIsValidUtf8(int n10, int n11, int n12) {
        int n13 = this.getOffsetIntoBytes() + n11;
        byte[] byArray = this.bytes;
        return Utf8.partialIsValidUtf8(n10, byArray, n13, n12 += n13);
    }

    public int size() {
        return this.bytes.length;
    }

    public final ByteString substring(int n10, int n11) {
        int n12 = this.size();
        if ((n11 = ByteString.checkRange(n10, n11, n12)) == 0) {
            return ByteString.EMPTY;
        }
        byte[] byArray = this.bytes;
        int n13 = this.getOffsetIntoBytes() + n10;
        ByteString$BoundedByteString byteString$BoundedByteString = new ByteString$BoundedByteString(byArray, n13, n11);
        return byteString$BoundedByteString;
    }

    public final String toStringInternal(Charset charset) {
        byte[] byArray = this.bytes;
        int n10 = this.getOffsetIntoBytes();
        int n11 = this.size();
        String string2 = new String(byArray, n10, n11, charset);
        return string2;
    }

    public final void writeTo(ByteOutput byteOutput) {
        byte[] byArray = this.bytes;
        int n10 = this.getOffsetIntoBytes();
        int n11 = this.size();
        byteOutput.writeLazy(byArray, n10, n11);
    }

    public final void writeTo(OutputStream outputStream) {
        byte[] byArray = this.toByteArray();
        outputStream.write(byArray);
    }

    public final void writeToInternal(OutputStream outputStream, int n10, int n11) {
        byte[] byArray = this.bytes;
        int n12 = this.getOffsetIntoBytes() + n10;
        outputStream.write(byArray, n12, n11);
    }
}

