/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Reader;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;

public abstract class UnknownFieldSchema {
    public abstract void addFixed32(Object var1, int var2, int var3);

    public abstract void addFixed64(Object var1, int var2, long var3);

    public abstract void addGroup(Object var1, int var2, Object var3);

    public abstract void addLengthDelimited(Object var1, int var2, ByteString var3);

    public abstract void addVarint(Object var1, int var2, long var3);

    public abstract Object getBuilderFromMessage(Object var1);

    public abstract Object getFromMessage(Object var1);

    public abstract int getSerializedSize(Object var1);

    public abstract int getSerializedSizeAsMessageSet(Object var1);

    public abstract void makeImmutable(Object var1);

    public abstract Object merge(Object var1, Object var2);

    public final void mergeFrom(Object object, Reader reader) {
        int n10;
        int n11;
        while ((n11 = reader.getFieldNumber()) != (n10 = -1 >>> 1) && (n11 = (int)(this.mergeOneFieldFrom(object, reader) ? 1 : 0)) != 0) {
        }
    }

    public final boolean mergeOneFieldFrom(Object object, Reader object2) {
        int bl2 = object2.getTag();
        int n10 = WireFormat.getTagFieldNumber(bl2);
        int n11 = WireFormat.getTagWireType(bl2);
        int n12 = 1;
        if (n11) {
            if (n11 != n12) {
                int n13 = 2;
                if (n11 != n13) {
                    int n14 = 3;
                    int n15 = 4;
                    if (n11 != n14) {
                        if (n11 != n15) {
                            int n16 = 5;
                            if (n11 == n16) {
                                int n17 = object2.readFixed32();
                                this.addFixed32(object, n10, n17);
                                return n12;
                            }
                            throw InvalidProtocolBufferException.invalidWireType();
                        }
                        return false;
                    }
                    Object object3 = this.newBuilder();
                    int n18 = WireFormat.makeTag(n10, n15);
                    this.mergeFrom(object3, (Reader)object2);
                    int n19 = object2.getTag();
                    if (n18 == n19) {
                        object2 = this.toImmutable(object3);
                        this.addGroup(object, n10, object2);
                        return n12;
                    }
                    throw InvalidProtocolBufferException.invalidEndTag();
                }
                object2 = object2.readBytes();
                this.addLengthDelimited(object, n10, (ByteString)object2);
                return n12;
            }
            long l10 = object2.readFixed64();
            this.addFixed64(object, n10, l10);
            return n12;
        }
        long l11 = object2.readInt64();
        this.addVarint(object, n10, l11);
        return n12;
    }

    public abstract Object newBuilder();

    public abstract void setBuilderToMessage(Object var1, Object var2);

    public abstract void setToMessage(Object var1, Object var2);

    public abstract boolean shouldDiscardUnknownFields(Reader var1);

    public abstract Object toImmutable(Object var1);

    public abstract void writeAsMessageSetTo(Object var1, Writer var2);

    public abstract void writeTo(Object var1, Writer var2);
}

