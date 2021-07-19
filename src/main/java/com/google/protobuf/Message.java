/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;

public interface Message
extends MessageLite,
MessageOrBuilder {
    public boolean equals(Object var1);

    public Parser getParserForType();

    public int hashCode();

    public Message$Builder newBuilderForType();

    public Message$Builder toBuilder();

    public String toString();
}

