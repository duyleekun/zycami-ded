/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString$CodedBuilder;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Schema;
import com.google.protobuf.UninitializedMessageException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.List;

public abstract class AbstractMessageLite
implements MessageLite {
    public int memoizedHashCode = 0;

    public static void addAll(Iterable iterable, Collection collection) {
        collection = (List)collection;
        AbstractMessageLite$Builder.addAll(iterable, (List)collection);
    }

    public static void addAll(Iterable iterable, List list) {
        AbstractMessageLite$Builder.addAll(iterable, list);
    }

    public static void checkByteStringIsUtf8(ByteString serializable) {
        boolean bl2 = serializable.isValidUtf8();
        if (bl2) {
            return;
        }
        serializable = new IllegalArgumentException("Byte string is not UTF-8.");
        throw serializable;
    }

    private String getSerializingExceptionMessage(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Serializing ");
        String string3 = this.getClass().getName();
        stringBuilder.append(string3);
        stringBuilder.append(" to a ");
        stringBuilder.append(string2);
        stringBuilder.append(" threw an IOException (should never happen).");
        return stringBuilder.toString();
    }

    public int getMemoizedSerializedSize() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public int getSerializedSize(Schema schema) {
        int n10;
        int n11 = this.getMemoizedSerializedSize();
        if (n11 == (n10 = -1)) {
            n11 = schema.getSerializedSize(this);
            this.setMemoizedSerializedSize(n11);
        }
        return n11;
    }

    public UninitializedMessageException newUninitializedMessageException() {
        UninitializedMessageException uninitializedMessageException = new UninitializedMessageException(this);
        return uninitializedMessageException;
    }

    public void setMemoizedSerializedSize(int n10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public byte[] toByteArray() {
        Object object;
        int n10;
        try {
            n10 = this.getSerializedSize();
        }
        catch (IOException iOException) {
            String string2 = this.getSerializingExceptionMessage("byte array");
            object = new RuntimeException(string2, iOException);
            throw object;
        }
        byte[] byArray = new byte[n10];
        object = CodedOutputStream.newInstance(byArray);
        this.writeTo((CodedOutputStream)object);
        ((CodedOutputStream)object).checkNoSpaceLeft();
        return byArray;
    }

    public ByteString toByteString() {
        Object object;
        int n10;
        try {
            n10 = this.getSerializedSize();
        }
        catch (IOException iOException) {
            String string2 = this.getSerializingExceptionMessage("ByteString");
            object = new RuntimeException(string2, iOException);
            throw object;
        }
        ByteString$CodedBuilder byteString$CodedBuilder = ByteString.newCodedBuilder(n10);
        object = byteString$CodedBuilder.getCodedOutput();
        this.writeTo((CodedOutputStream)object);
        return byteString$CodedBuilder.build();
    }

    public void writeDelimitedTo(OutputStream object) {
        int n10 = this.getSerializedSize();
        int n11 = CodedOutputStream.computePreferredBufferSize(CodedOutputStream.computeRawVarint32Size(n10) + n10);
        object = CodedOutputStream.newInstance((OutputStream)object, n11);
        ((CodedOutputStream)object).writeRawVarint32(n10);
        this.writeTo((CodedOutputStream)object);
        ((CodedOutputStream)object).flush();
    }

    public void writeTo(OutputStream object) {
        int n10 = CodedOutputStream.computePreferredBufferSize(this.getSerializedSize());
        object = CodedOutputStream.newInstance((OutputStream)object, n10);
        this.writeTo((CodedOutputStream)object);
        ((CodedOutputStream)object).flush();
    }
}

