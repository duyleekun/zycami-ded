/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;

public final class UnknownFieldSet$Parser
extends AbstractParser {
    public UnknownFieldSet parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite object) {
        object = UnknownFieldSet.newBuilder();
        try {
            ((UnknownFieldSet$Builder)object).mergeFrom(codedInputStream);
            return ((UnknownFieldSet$Builder)object).buildPartial();
        }
        catch (IOException iOException) {
            InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(iOException);
            MessageLite messageLite = ((UnknownFieldSet$Builder)object).buildPartial();
            throw invalidProtocolBufferException.setUnfinishedMessage(messageLite);
        }
        catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            object = ((UnknownFieldSet$Builder)object).buildPartial();
            throw invalidProtocolBufferException.setUnfinishedMessage((MessageLite)object);
        }
    }
}

