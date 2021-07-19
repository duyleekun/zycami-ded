/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Reader;
import com.google.protobuf.UnknownFieldSchema;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import com.google.protobuf.UnknownFieldSet$Field;
import com.google.protobuf.Writer;

public class UnknownFieldSetSchema
extends UnknownFieldSchema {
    private final boolean proto3;

    public UnknownFieldSetSchema(boolean bl2) {
        this.proto3 = bl2;
    }

    public void addFixed32(UnknownFieldSet$Builder unknownFieldSet$Builder, int n10, int n11) {
        UnknownFieldSet$Field unknownFieldSet$Field = UnknownFieldSet$Field.newBuilder().addFixed32(n11).build();
        unknownFieldSet$Builder.mergeField(n10, unknownFieldSet$Field);
    }

    public void addFixed64(UnknownFieldSet$Builder unknownFieldSet$Builder, int n10, long l10) {
        UnknownFieldSet$Field unknownFieldSet$Field = UnknownFieldSet$Field.newBuilder().addFixed64(l10).build();
        unknownFieldSet$Builder.mergeField(n10, unknownFieldSet$Field);
    }

    public void addGroup(UnknownFieldSet$Builder unknownFieldSet$Builder, int n10, UnknownFieldSet object) {
        object = UnknownFieldSet$Field.newBuilder().addGroup((UnknownFieldSet)object).build();
        unknownFieldSet$Builder.mergeField(n10, (UnknownFieldSet$Field)object);
    }

    public void addLengthDelimited(UnknownFieldSet$Builder unknownFieldSet$Builder, int n10, ByteString object) {
        object = UnknownFieldSet$Field.newBuilder().addLengthDelimited((ByteString)object).build();
        unknownFieldSet$Builder.mergeField(n10, (UnknownFieldSet$Field)object);
    }

    public void addVarint(UnknownFieldSet$Builder unknownFieldSet$Builder, int n10, long l10) {
        UnknownFieldSet$Field unknownFieldSet$Field = UnknownFieldSet$Field.newBuilder().addVarint(l10).build();
        unknownFieldSet$Builder.mergeField(n10, unknownFieldSet$Field);
    }

    public UnknownFieldSet$Builder getBuilderFromMessage(Object object) {
        return ((GeneratedMessageV3)object).unknownFields.toBuilder();
    }

    public UnknownFieldSet getFromMessage(Object object) {
        return ((GeneratedMessageV3)object).unknownFields;
    }

    public int getSerializedSize(UnknownFieldSet unknownFieldSet) {
        return unknownFieldSet.getSerializedSize();
    }

    public int getSerializedSizeAsMessageSet(UnknownFieldSet unknownFieldSet) {
        return unknownFieldSet.getSerializedSizeAsMessageSet();
    }

    public void makeImmutable(Object object) {
    }

    public UnknownFieldSet merge(UnknownFieldSet unknownFieldSet, UnknownFieldSet unknownFieldSet2) {
        return ((UnknownFieldSet$Builder)unknownFieldSet.toBuilder()).mergeFrom(unknownFieldSet2).build();
    }

    public UnknownFieldSet$Builder newBuilder() {
        return UnknownFieldSet.newBuilder();
    }

    public void setBuilderToMessage(Object object, UnknownFieldSet$Builder messageLiteOrBuilder) {
        object = (GeneratedMessageV3)object;
        messageLiteOrBuilder = messageLiteOrBuilder.build();
        ((GeneratedMessageV3)object).unknownFields = messageLiteOrBuilder;
    }

    public void setToMessage(Object object, UnknownFieldSet unknownFieldSet) {
        ((GeneratedMessageV3)object).unknownFields = unknownFieldSet;
    }

    public boolean shouldDiscardUnknownFields(Reader reader) {
        return reader.shouldDiscardUnknownFields();
    }

    public UnknownFieldSet toImmutable(UnknownFieldSet$Builder unknownFieldSet$Builder) {
        return unknownFieldSet$Builder.build();
    }

    public void writeAsMessageSetTo(UnknownFieldSet unknownFieldSet, Writer writer) {
        unknownFieldSet.writeAsMessageSetTo(writer);
    }

    public void writeTo(UnknownFieldSet unknownFieldSet, Writer writer) {
        unknownFieldSet.writeTo(writer);
    }
}

