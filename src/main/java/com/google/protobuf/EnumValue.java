/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.EnumValue$1;
import com.google.protobuf.EnumValue$Builder;
import com.google.protobuf.EnumValueOrBuilder;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.GeneratedMessageV3$UnusedPrivateParameter;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Option;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.TypeProto;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class EnumValue
extends GeneratedMessageV3
implements EnumValueOrBuilder {
    private static final EnumValue DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int NUMBER_FIELD_NUMBER = 2;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static final Parser PARSER;
    private static final long serialVersionUID;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private int number_;
    private List options_;

    static {
        Object object = new EnumValue();
        DEFAULT_INSTANCE = object;
        PARSER = object = new EnumValue$1();
    }

    private EnumValue() {
        List list;
        this.memoizedIsInitialized = (byte)-1;
        this.name_ = "";
        this.options_ = list = Collections.emptyList();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private EnumValue(CodedInputStream list, ExtensionRegistryLite list2) {
        int n10;
        UnknownFieldSet$Builder unknownFieldSet$Builder;
        block14: {
            Throwable throwable2;
            this();
            Objects.requireNonNull(list2);
            unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
            boolean bl2 = false;
            n10 = 0;
            while (true) {
                boolean bl3 = true;
                if (bl2) break block14;
                try {
                    try {
                        block15: {
                            int n11 = ((CodedInputStream)((Object)list)).readTag();
                            if (n11 != 0) {
                                ArrayList<Object> arrayList;
                                int n12 = 10;
                                if (n11 != n12) {
                                    n12 = 16;
                                    if (n11 != n12) {
                                        n12 = 26;
                                        if (n11 != n12) {
                                            if ((n11 = (int)(this.parseUnknownField((CodedInputStream)((Object)list), unknownFieldSet$Builder, (ExtensionRegistryLite)((Object)list2), n11) ? 1 : 0)) != 0) continue;
                                            break block15;
                                        } else {
                                            n11 = n10 & 1;
                                            if (n11 == 0) {
                                                this.options_ = arrayList = new ArrayList<Object>();
                                                n10 |= 1;
                                            }
                                            arrayList = this.options_;
                                            Object object = Option.parser();
                                            object = ((CodedInputStream)((Object)list)).readMessage((Parser)object, (ExtensionRegistryLite)((Object)list2));
                                            arrayList.add(object);
                                            continue;
                                        }
                                    }
                                    this.number_ = n11 = ((CodedInputStream)((Object)list)).readInt32();
                                    continue;
                                }
                                arrayList = ((CodedInputStream)((Object)list)).readStringRequireUtf8();
                                this.name_ = arrayList;
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
                this.options_ = list2 = Collections.unmodifiableList(this.options_);
            }
            list2 = unknownFieldSet$Builder.build();
            this.unknownFields = list2;
            this.makeExtensionsImmutable();
            throw throwable2;
        }
        boolean bl5 = n10 & true;
        if (bl5) {
            this.options_ = list = Collections.unmodifiableList(this.options_);
        }
        list = unknownFieldSet$Builder.build();
        this.unknownFields = list;
        this.makeExtensionsImmutable();
    }

    public /* synthetic */ EnumValue(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, EnumValue$1 enumValue$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private EnumValue(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
        this.memoizedIsInitialized = (byte)-1;
    }

    public /* synthetic */ EnumValue(GeneratedMessageV3$Builder generatedMessageV3$Builder, EnumValue$1 enumValue$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ Object access$300(EnumValue enumValue) {
        return enumValue.name_;
    }

    public static /* synthetic */ Object access$302(EnumValue enumValue, Object object) {
        enumValue.name_ = object;
        return object;
    }

    public static /* synthetic */ int access$402(EnumValue enumValue, int n10) {
        enumValue.number_ = n10;
        return n10;
    }

    public static /* synthetic */ List access$500(EnumValue enumValue) {
        return enumValue.options_;
    }

    public static /* synthetic */ List access$502(EnumValue enumValue, List list) {
        enumValue.options_ = list;
        return list;
    }

    public static /* synthetic */ Parser access$600() {
        return PARSER;
    }

    public static EnumValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_EnumValue_descriptor;
    }

    public static EnumValue$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static EnumValue$Builder newBuilder(EnumValue enumValue) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(enumValue);
    }

    public static EnumValue parseDelimitedFrom(InputStream inputStream) {
        return (EnumValue)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static EnumValue parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (EnumValue)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static EnumValue parseFrom(ByteString byteString) {
        return (EnumValue)PARSER.parseFrom(byteString);
    }

    public static EnumValue parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (EnumValue)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static EnumValue parseFrom(CodedInputStream codedInputStream) {
        return (EnumValue)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static EnumValue parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (EnumValue)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static EnumValue parseFrom(InputStream inputStream) {
        return (EnumValue)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static EnumValue parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (EnumValue)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static EnumValue parseFrom(ByteBuffer byteBuffer) {
        return (EnumValue)PARSER.parseFrom(byteBuffer);
    }

    public static EnumValue parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (EnumValue)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static EnumValue parseFrom(byte[] byArray) {
        return (EnumValue)PARSER.parseFrom(byArray);
    }

    public static EnumValue parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (EnumValue)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        List list;
        int n10;
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean n11 = object instanceof EnumValue;
        if (!n11) {
            return super.equals(object);
        }
        object = (EnumValue)object;
        Object object2 = this.getName();
        String string2 = ((EnumValue)object).getName();
        boolean bl3 = ((String)object2).equals(string2);
        string2 = null;
        if (!bl3) {
            return false;
        }
        int n12 = this.getNumber();
        if (n12 != (n10 = ((EnumValue)object).getNumber())) {
            return false;
        }
        object2 = this.getOptionsList();
        boolean bl4 = object2.equals(list = ((EnumValue)object).getOptionsList());
        if (!bl4) {
            return false;
        }
        object2 = this.unknownFields;
        object = ((GeneratedMessageV3)object).unknownFields;
        boolean bl5 = ((UnknownFieldSet)object2).equals(object);
        if (!bl5) {
            return false;
        }
        return bl2;
    }

    public EnumValue getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public String getName() {
        Object object = this.name_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        this.name_ = object = ((ByteString)object).toStringUtf8();
        return object;
    }

    public ByteString getNameBytes() {
        Object object = this.name_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.name_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public int getNumber() {
        return this.number_;
    }

    public Option getOptions(int n10) {
        return (Option)this.options_.get(n10);
    }

    public int getOptionsCount() {
        return this.options_.size();
    }

    public List getOptionsList() {
        return this.options_;
    }

    public OptionOrBuilder getOptionsOrBuilder(int n10) {
        return (OptionOrBuilder)this.options_.get(n10);
    }

    public List getOptionsOrBuilderList() {
        return this.options_;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        List list;
        int n10;
        int n11 = this.memoizedSize;
        int n12 = -1;
        if (n11 != n12) {
            return n11;
        }
        Object object = this.getNameBytes();
        n11 = (int)(((ByteString)object).isEmpty() ? 1 : 0);
        n12 = 0;
        if (n11 == 0) {
            object = this.name_;
            n10 = 1;
            n11 = GeneratedMessageV3.computeStringSize(n10, object) + 0;
        } else {
            n11 = 0;
            object = null;
        }
        n10 = this.number_;
        if (n10 != 0) {
            int n13 = 2;
            n10 = CodedOutputStream.computeInt32Size(n13, n10);
            n11 += n10;
        }
        while (n12 < (n10 = (list = this.options_).size())) {
            MessageLite messageLite = (MessageLite)this.options_.get(n12);
            n10 = CodedOutputStream.computeMessageSize(3, messageLite);
            n11 += n10;
            ++n12;
        }
        n12 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n11 += n12;
        return n11;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        int n11 = EnumValue.getDescriptor().hashCode();
        n10 = ((779 + n11) * 37 + 1) * 53;
        Object object = this.getName();
        n11 = ((String)object).hashCode();
        n10 = ((n10 + n11) * 37 + 2) * 53;
        n11 = this.getNumber();
        n10 += n11;
        n11 = this.getOptionsCount();
        if (n11 > 0) {
            n10 = (n10 * 37 + 3) * 53;
            object = this.getOptionsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_EnumValue_fieldAccessorTable.ensureFieldAccessorsInitialized(EnumValue.class, EnumValue$Builder.class);
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

    public EnumValue$Builder newBuilderForType() {
        return EnumValue.newBuilder();
    }

    public EnumValue$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        EnumValue$Builder enumValue$Builder = new EnumValue$Builder(generatedMessageV3$BuilderParent, null);
        return enumValue$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new EnumValue();
        return object;
    }

    public EnumValue$Builder toBuilder() {
        EnumValueOrBuilder enumValueOrBuilder = DEFAULT_INSTANCE;
        if (this == enumValueOrBuilder) {
            enumValueOrBuilder = new EnumValue$Builder(null);
        } else {
            enumValueOrBuilder = new EnumValue$Builder(null);
            enumValueOrBuilder = ((EnumValue$Builder)enumValueOrBuilder).mergeFrom(this);
        }
        return enumValueOrBuilder;
    }

    /*
     * WARNING - void declaration
     */
    public void writeTo(CodedOutputStream codedOutputStream) {
        List list;
        void var3_6;
        int n10;
        int n11;
        Object object = this.getNameBytes();
        boolean n112 = ((ByteString)object).isEmpty();
        if (!n112) {
            object = this.name_;
            n11 = 1;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        if ((n10 = this.number_) != 0) {
            n11 = 2;
            codedOutputStream.writeInt32(n11, n10);
        }
        boolean bl2 = false;
        object = null;
        while (++var3_6 < (n11 = (list = this.options_).size())) {
            n11 = 3;
            MessageLite messageLite = (MessageLite)this.options_.get((int)var3_6);
            codedOutputStream.writeMessage(n11, messageLite);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

