/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Reader;
import com.google.protobuf.UnknownFieldSchema;
import com.google.protobuf.UnknownFieldSetLite;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;

public class UnknownFieldSetLiteSchema
extends UnknownFieldSchema {
    public void addFixed32(UnknownFieldSetLite unknownFieldSetLite, int n10, int n11) {
        n10 = WireFormat.makeTag(n10, 5);
        Integer n12 = n11;
        unknownFieldSetLite.storeField(n10, n12);
    }

    public void addFixed64(UnknownFieldSetLite unknownFieldSetLite, int n10, long l10) {
        n10 = WireFormat.makeTag(n10, 1);
        Long l11 = l10;
        unknownFieldSetLite.storeField(n10, l11);
    }

    public void addGroup(UnknownFieldSetLite unknownFieldSetLite, int n10, UnknownFieldSetLite unknownFieldSetLite2) {
        n10 = WireFormat.makeTag(n10, 3);
        unknownFieldSetLite.storeField(n10, unknownFieldSetLite2);
    }

    public void addLengthDelimited(UnknownFieldSetLite unknownFieldSetLite, int n10, ByteString byteString) {
        n10 = WireFormat.makeTag(n10, 2);
        unknownFieldSetLite.storeField(n10, byteString);
    }

    public void addVarint(UnknownFieldSetLite unknownFieldSetLite, int n10, long l10) {
        n10 = WireFormat.makeTag(n10, 0);
        Long l11 = l10;
        unknownFieldSetLite.storeField(n10, l11);
    }

    public UnknownFieldSetLite getBuilderFromMessage(Object object) {
        UnknownFieldSetLite unknownFieldSetLite;
        UnknownFieldSetLite unknownFieldSetLite2 = this.getFromMessage(object);
        if (unknownFieldSetLite2 == (unknownFieldSetLite = UnknownFieldSetLite.getDefaultInstance())) {
            unknownFieldSetLite2 = UnknownFieldSetLite.newInstance();
            this.setToMessage(object, unknownFieldSetLite2);
        }
        return unknownFieldSetLite2;
    }

    public UnknownFieldSetLite getFromMessage(Object object) {
        return ((GeneratedMessageLite)object).unknownFields;
    }

    public int getSerializedSize(UnknownFieldSetLite unknownFieldSetLite) {
        return unknownFieldSetLite.getSerializedSize();
    }

    public int getSerializedSizeAsMessageSet(UnknownFieldSetLite unknownFieldSetLite) {
        return unknownFieldSetLite.getSerializedSizeAsMessageSet();
    }

    public void makeImmutable(Object object) {
        this.getFromMessage(object).makeImmutable();
    }

    public UnknownFieldSetLite merge(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
        UnknownFieldSetLite unknownFieldSetLite3 = UnknownFieldSetLite.getDefaultInstance();
        boolean bl2 = unknownFieldSetLite2.equals(unknownFieldSetLite3);
        if (!bl2) {
            unknownFieldSetLite = UnknownFieldSetLite.mutableCopyOf(unknownFieldSetLite, unknownFieldSetLite2);
        }
        return unknownFieldSetLite;
    }

    public UnknownFieldSetLite newBuilder() {
        return UnknownFieldSetLite.newInstance();
    }

    public void setBuilderToMessage(Object object, UnknownFieldSetLite unknownFieldSetLite) {
        this.setToMessage(object, unknownFieldSetLite);
    }

    public void setToMessage(Object object, UnknownFieldSetLite unknownFieldSetLite) {
        ((GeneratedMessageLite)object).unknownFields = unknownFieldSetLite;
    }

    public boolean shouldDiscardUnknownFields(Reader reader) {
        return false;
    }

    public UnknownFieldSetLite toImmutable(UnknownFieldSetLite unknownFieldSetLite) {
        unknownFieldSetLite.makeImmutable();
        return unknownFieldSetLite;
    }

    public void writeAsMessageSetTo(UnknownFieldSetLite unknownFieldSetLite, Writer writer) {
        unknownFieldSetLite.writeAsMessageSetTo(writer);
    }

    public void writeTo(UnknownFieldSetLite unknownFieldSetLite, Writer writer) {
        unknownFieldSetLite.writeTo(writer);
    }
}

