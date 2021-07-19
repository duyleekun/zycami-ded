/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteBufferWriter;
import com.google.protobuf.ByteOutput;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString$LeafByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Internal;
import com.google.protobuf.NioByteString$1;
import com.google.protobuf.RopeByteString;
import com.google.protobuf.Utf8;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

public final class NioByteString
extends ByteString$LeafByteString {
    private final ByteBuffer buffer;

    public NioByteString(ByteBuffer byteBuffer) {
        Internal.checkNotNull(byteBuffer, "buffer");
        byteBuffer = byteBuffer.slice();
        ByteOrder byteOrder = ByteOrder.nativeOrder();
        this.buffer = byteBuffer = byteBuffer.order(byteOrder);
    }

    public static /* synthetic */ ByteBuffer access$000(NioByteString nioByteString) {
        return nioByteString.buffer;
    }

    private void readObject(ObjectInputStream object) {
        object = new InvalidObjectException("NioByteString instances are not to be serialized directly");
        throw object;
    }

    private ByteBuffer slice(int n10, int n11) {
        Object object;
        Object object2 = this.buffer;
        int n12 = ((Buffer)object2).position();
        if (n10 >= n12 && n11 <= (n12 = ((Buffer)(object2 = this.buffer)).limit()) && n10 <= n11) {
            object2 = this.buffer.slice();
            int n13 = this.buffer.position();
            ((ByteBuffer)object2).position(n10 -= n13);
            n10 = this.buffer.position();
            ((ByteBuffer)object2).limit(n11 -= n10);
            return object2;
        }
        Object[] objectArray = new Object[2];
        objectArray[0] = object = Integer.valueOf(n10);
        Integer n14 = n11;
        objectArray[1] = n14;
        object = String.format("Invalid indices [%d, %d]", objectArray);
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    private Object writeReplace() {
        return ByteString.copyFrom(this.buffer.slice());
    }

    public ByteBuffer asReadOnlyByteBuffer() {
        return this.buffer.asReadOnlyBuffer();
    }

    public List asReadOnlyByteBufferList() {
        return Collections.singletonList(this.asReadOnlyByteBuffer());
    }

    public byte byteAt(int n10) {
        Object object = this.buffer;
        try {
            return ((ByteBuffer)object).get(n10);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            String string2 = indexOutOfBoundsException.getMessage();
            object = new ArrayIndexOutOfBoundsException(string2);
            throw object;
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            throw arrayIndexOutOfBoundsException;
        }
    }

    public void copyTo(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = this.buffer.slice();
        byteBuffer.put(byteBuffer2);
    }

    public void copyToInternal(byte[] byArray, int n10, int n11, int n12) {
        ByteBuffer byteBuffer = this.buffer.slice();
        byteBuffer.position(n10);
        byteBuffer.get(byArray, n11, n12);
    }

    public boolean equals(Object object) {
        int n10;
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof ByteString;
        int n11 = 0;
        if (!bl3) {
            return false;
        }
        Object object2 = object;
        object2 = (ByteString)object;
        int n12 = this.size();
        if (n12 != (n10 = ((ByteString)object2).size())) {
            return false;
        }
        n11 = this.size();
        if (n11 == 0) {
            return bl2;
        }
        bl2 = object instanceof NioByteString;
        if (bl2) {
            ByteBuffer byteBuffer = this.buffer;
            object = ((NioByteString)object).buffer;
            return byteBuffer.equals(object);
        }
        bl2 = object instanceof RopeByteString;
        if (bl2) {
            return object.equals(this);
        }
        object = this.buffer;
        ByteBuffer byteBuffer = ((ByteString)object2).asReadOnlyByteBuffer();
        return ((ByteBuffer)object).equals(byteBuffer);
    }

    public boolean equalsRange(ByteString byteString, int n10, int n11) {
        ByteString byteString2 = this.substring(0, n11);
        byteString = byteString.substring(n10, n11 += n10);
        return byteString2.equals(byteString);
    }

    public byte internalByteAt(int n10) {
        return this.byteAt(n10);
    }

    public boolean isValidUtf8() {
        return Utf8.isValidUtf8(this.buffer);
    }

    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(this.buffer, true);
    }

    public InputStream newInput() {
        NioByteString$1 nioByteString$1 = new NioByteString$1(this);
        return nioByteString$1;
    }

    public int partialHash(int n10, int n11, int n12) {
        int n13;
        for (int i10 = n11; i10 < (n13 = n11 + n12); ++i10) {
            n10 *= 31;
            ByteBuffer byteBuffer = this.buffer;
            n13 = byteBuffer.get(i10);
            n10 += n13;
        }
        return n10;
    }

    public int partialIsValidUtf8(int n10, int n11, int n12) {
        ByteBuffer byteBuffer = this.buffer;
        return Utf8.partialIsValidUtf8(n10, byteBuffer, n11, n12 += n11);
    }

    public int size() {
        return this.buffer.remaining();
    }

    public ByteString substring(int n10, int n11) {
        Serializable serializable;
        ByteBuffer byteBuffer = this.slice(n10, n11);
        try {
            serializable = new NioByteString(byteBuffer);
            return serializable;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            String string2 = indexOutOfBoundsException.getMessage();
            serializable = new ArrayIndexOutOfBoundsException(string2);
            throw serializable;
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            throw arrayIndexOutOfBoundsException;
        }
    }

    public String toStringInternal(Charset charset) {
        int n10;
        int n11;
        Object object = this.buffer;
        boolean bl2 = ((ByteBuffer)object).hasArray();
        if (bl2) {
            object = this.buffer.array();
            ByteBuffer byteBuffer = this.buffer;
            n11 = byteBuffer.arrayOffset();
            n10 = this.buffer.position();
            n11 += n10;
            ByteBuffer byteBuffer2 = this.buffer;
            n10 = byteBuffer2.remaining();
        } else {
            object = this.toByteArray();
            n11 = 0;
            Object var4_5 = null;
            n10 = ((Object)object).length;
        }
        String string2 = new String((byte[])object, n11, n10, charset);
        return string2;
    }

    public void writeTo(ByteOutput byteOutput) {
        ByteBuffer byteBuffer = this.buffer.slice();
        byteOutput.writeLazy(byteBuffer);
    }

    public void writeTo(OutputStream outputStream) {
        byte[] byArray = this.toByteArray();
        outputStream.write(byArray);
    }

    public void writeToInternal(OutputStream outputStream, int n10, int n11) {
        ByteBuffer byteBuffer = this.buffer;
        int n12 = byteBuffer.hasArray();
        if (n12 != 0) {
            n12 = this.buffer.arrayOffset();
            int n13 = this.buffer.position();
            n12 = n12 + n13 + n10;
            byte[] byArray = this.buffer.array();
            outputStream.write(byArray, n12, n11);
            return;
        }
        ByteBufferWriter.write(this.slice(n10, n11 += n10), outputStream);
    }
}

