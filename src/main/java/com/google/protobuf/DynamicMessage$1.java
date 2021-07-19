/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.DynamicMessage$Builder;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.io.IOException;

public class DynamicMessage$1
extends AbstractParser {
    public final /* synthetic */ DynamicMessage this$0;

    public DynamicMessage$1(DynamicMessage dynamicMessage) {
        this.this$0 = dynamicMessage;
    }

    public DynamicMessage parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite object) {
        DynamicMessage$Builder dynamicMessage$Builder = DynamicMessage.newBuilder(DynamicMessage.access$200(this.this$0));
        try {
            dynamicMessage$Builder.mergeFrom(codedInputStream, (ExtensionRegistryLite)object);
            return dynamicMessage$Builder.buildPartial();
        }
        catch (IOException iOException) {
            object = new InvalidProtocolBufferException(iOException);
            DynamicMessage dynamicMessage = dynamicMessage$Builder.buildPartial();
            throw ((InvalidProtocolBufferException)object).setUnfinishedMessage(dynamicMessage);
        }
        catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            object = dynamicMessage$Builder.buildPartial();
            throw invalidProtocolBufferException.setUnfinishedMessage((MessageLite)object);
        }
    }
}

