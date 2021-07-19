/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;

public final class DiscardUnknownFieldsParser$1
extends AbstractParser {
    public final /* synthetic */ Parser val$parser;

    public DiscardUnknownFieldsParser$1(Parser parser) {
        this.val$parser = parser;
    }

    public Message parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite object) {
        try {
            codedInputStream.discardUnknownFields();
            Parser parser = this.val$parser;
            object = parser.parsePartialFrom(codedInputStream, (ExtensionRegistryLite)object);
            object = (Message)object;
            return object;
        }
        finally {
            codedInputStream.unsetDiscardUnknownFields();
        }
    }
}

