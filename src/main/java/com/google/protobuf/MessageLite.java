/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.OutputStream;

public interface MessageLite
extends MessageLiteOrBuilder {
    public Parser getParserForType();

    public int getSerializedSize();

    public MessageLite$Builder newBuilderForType();

    public MessageLite$Builder toBuilder();

    public byte[] toByteArray();

    public ByteString toByteString();

    public void writeDelimitedTo(OutputStream var1);

    public void writeTo(CodedOutputStream var1);

    public void writeTo(OutputStream var1);
}

