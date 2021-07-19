/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.GeneratedMessageV3$UnusedPrivateParameter;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.ListValue$1;
import com.google.protobuf.ListValue$Builder;
import com.google.protobuf.ListValueOrBuilder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.StructProto;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import com.google.protobuf.Value;
import com.google.protobuf.ValueOrBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class ListValue
extends GeneratedMessageV3
implements ListValueOrBuilder {
    private static final ListValue DEFAULT_INSTANCE;
    private static final Parser PARSER;
    public static final int VALUES_FIELD_NUMBER = 1;
    private static final long serialVersionUID;
    private byte memoizedIsInitialized;
    private List values_;

    static {
        Object object = new ListValue();
        DEFAULT_INSTANCE = object;
        PARSER = object = new ListValue$1();
    }

    private ListValue() {
        List list;
        this.memoizedIsInitialized = (byte)-1;
        this.values_ = list = Collections.emptyList();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private ListValue(CodedInputStream list, ExtensionRegistryLite list2) {
        int n10;
        UnknownFieldSet$Builder unknownFieldSet$Builder;
        block12: {
            Throwable throwable2;
            this();
            Objects.requireNonNull(list2);
            unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
            boolean bl2 = false;
            n10 = 0;
            while (true) {
                boolean bl3 = true;
                if (bl2) break block12;
                try {
                    try {
                        int n11 = ((CodedInputStream)((Object)list)).readTag();
                        if (n11 != 0) {
                            int n12 = 10;
                            if (n11 != n12) {
                                if ((n11 = (int)(this.parseUnknownField((CodedInputStream)((Object)list), unknownFieldSet$Builder, (ExtensionRegistryLite)((Object)list2), n11) ? 1 : 0)) != 0) continue;
                            } else {
                                List<Object> list3;
                                n11 = n10 & 1;
                                if (n11 == 0) {
                                    this.values_ = list3 = new List<Object>();
                                    n10 |= 1;
                                }
                                list3 = this.values_;
                                Object object = Value.parser();
                                object = ((CodedInputStream)((Object)list)).readMessage((Parser)object, (ExtensionRegistryLite)((Object)list2));
                                list3.add(object);
                                continue;
                            }
                        }
                        bl2 = bl3;
                        continue;
                    }
                    catch (IOException iOException) {
                        list2 = new List(iOException);
                        InvalidProtocolBufferException invalidProtocolBufferException = ((InvalidProtocolBufferException)((Object)list2)).setUnfinishedMessage(this);
                        throw invalidProtocolBufferException;
                    }
                    catch (InvalidProtocolBufferException invalidProtocolBufferException) {
                        InvalidProtocolBufferException invalidProtocolBufferException2 = invalidProtocolBufferException.setUnfinishedMessage(this);
                        throw invalidProtocolBufferException2;
                    }
                }
                catch (Throwable throwable2) {}
                break;
            }
            boolean bl4 = n10 & true;
            if (bl4) {
                this.values_ = list2 = Collections.unmodifiableList(this.values_);
            }
            list2 = unknownFieldSet$Builder.build();
            this.unknownFields = list2;
            this.makeExtensionsImmutable();
            throw throwable2;
        }
        boolean bl5 = n10 & true;
        if (bl5) {
            this.values_ = list = Collections.unmodifiableList(this.values_);
        }
        list = unknownFieldSet$Builder.build();
        this.unknownFields = list;
        this.makeExtensionsImmutable();
    }

    public /* synthetic */ ListValue(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, ListValue$1 listValue$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private ListValue(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
        this.memoizedIsInitialized = (byte)-1;
    }

    public /* synthetic */ ListValue(GeneratedMessageV3$Builder generatedMessageV3$Builder, ListValue$1 listValue$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ List access$300(ListValue listValue) {
        return listValue.values_;
    }

    public static /* synthetic */ List access$302(ListValue listValue, List list) {
        listValue.values_ = list;
        return list;
    }

    public static /* synthetic */ Parser access$400() {
        return PARSER;
    }

    public static ListValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return StructProto.internal_static_google_protobuf_ListValue_descriptor;
    }

    public static ListValue$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static ListValue$Builder newBuilder(ListValue listValue) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(listValue);
    }

    public static ListValue parseDelimitedFrom(InputStream inputStream) {
        return (ListValue)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ListValue parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ListValue)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ListValue parseFrom(ByteString byteString) {
        return (ListValue)PARSER.parseFrom(byteString);
    }

    public static ListValue parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ListValue)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static ListValue parseFrom(CodedInputStream codedInputStream) {
        return (ListValue)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static ListValue parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ListValue)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static ListValue parseFrom(InputStream inputStream) {
        return (ListValue)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static ListValue parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ListValue)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ListValue parseFrom(ByteBuffer byteBuffer) {
        return (ListValue)PARSER.parseFrom(byteBuffer);
    }

    public static ListValue parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (ListValue)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static ListValue parseFrom(byte[] byArray) {
        return (ListValue)PARSER.parseFrom(byArray);
    }

    public static ListValue parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (ListValue)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof ListValue;
        if (!bl3) {
            return super.equals(object);
        }
        object = (ListValue)object;
        Object object2 = this.getValuesList();
        List list = ((ListValue)object).getValuesList();
        bl3 = object2.equals(list);
        list = null;
        if (!bl3) {
            return false;
        }
        object2 = this.unknownFields;
        object = ((GeneratedMessageV3)object).unknownFields;
        boolean bl4 = ((UnknownFieldSet)object2).equals(object);
        if (!bl4) {
            return false;
        }
        return bl2;
    }

    public ListValue getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        Object object;
        int n10;
        int n11 = this.memoizedSize;
        int n12 = -1;
        if (n11 != n12) {
            return n11;
        }
        n12 = 0;
        for (n11 = 0; n11 < (n10 = (object = this.values_).size()); ++n11) {
            object = (MessageLite)this.values_.get(n11);
            int n13 = 1;
            n10 = CodedOutputStream.computeMessageSize(n13, (MessageLite)object);
            n12 += n10;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n12 += n11;
        return n12;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public Value getValues(int n10) {
        return (Value)this.values_.get(n10);
    }

    public int getValuesCount() {
        return this.values_.size();
    }

    public List getValuesList() {
        return this.values_;
    }

    public ValueOrBuilder getValuesOrBuilder(int n10) {
        return (ValueOrBuilder)this.values_.get(n10);
    }

    public List getValuesOrBuilderList() {
        return this.values_;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = ListValue.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = this.getValuesCount();
        if (n11 > 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getValuesList();
            n11 = object.hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return StructProto.internal_static_google_protobuf_ListValue_fieldAccessorTable.ensureFieldAccessorsInitialized(ListValue.class, ListValue$Builder.class);
    }

    public final boolean isInitialized() {
        byte by2 = this.memoizedIsInitialized;
        byte by3 = 1;
        if (by2 == by3) {
            return by3 != 0;
        }
        if (!by2) {
            return false;
        }
        this.memoizedIsInitialized = by3;
        return by3 != 0;
    }

    public ListValue$Builder newBuilderForType() {
        return ListValue.newBuilder();
    }

    public ListValue$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        ListValue$Builder listValue$Builder = new ListValue$Builder(generatedMessageV3$BuilderParent, null);
        return listValue$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new ListValue();
        return object;
    }

    public ListValue$Builder toBuilder() {
        ListValueOrBuilder listValueOrBuilder = DEFAULT_INSTANCE;
        if (this == listValueOrBuilder) {
            listValueOrBuilder = new ListValue$Builder(null);
        } else {
            listValueOrBuilder = new ListValue$Builder(null);
            listValueOrBuilder = ((ListValue$Builder)listValueOrBuilder).mergeFrom(this);
        }
        return listValueOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = (object = this.values_).size()); ++i10) {
            object = (MessageLite)this.values_.get(i10);
            int n11 = 1;
            codedOutputStream.writeMessage(n11, (MessageLite)object);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

