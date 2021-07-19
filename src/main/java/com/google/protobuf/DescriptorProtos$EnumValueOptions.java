/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$EnumValueOptions$1;
import com.google.protobuf.DescriptorProtos$EnumValueOptions$Builder;
import com.google.protobuf.DescriptorProtos$EnumValueOptionsOrBuilder;
import com.google.protobuf.DescriptorProtos$UninterpretedOption;
import com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$ExtendableBuilder;
import com.google.protobuf.GeneratedMessageV3$ExtendableMessage;
import com.google.protobuf.GeneratedMessageV3$ExtendableMessage$ExtensionWriter;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.GeneratedMessageV3$UnusedPrivateParameter;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class DescriptorProtos$EnumValueOptions
extends GeneratedMessageV3$ExtendableMessage
implements DescriptorProtos$EnumValueOptionsOrBuilder {
    private static final DescriptorProtos$EnumValueOptions DEFAULT_INSTANCE;
    public static final int DEPRECATED_FIELD_NUMBER = 1;
    public static final Parser PARSER;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private static final long serialVersionUID;
    private int bitField0_;
    private boolean deprecated_;
    private byte memoizedIsInitialized = (byte)-1;
    private List uninterpretedOption_;

    static {
        Object object = new DescriptorProtos$EnumValueOptions();
        DEFAULT_INSTANCE = object;
        PARSER = object = new DescriptorProtos$EnumValueOptions$1();
    }

    private DescriptorProtos$EnumValueOptions() {
        List list;
        this.uninterpretedOption_ = list = Collections.emptyList();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private DescriptorProtos$EnumValueOptions(CodedInputStream list, ExtensionRegistryLite list2) {
        this();
        Objects.requireNonNull(list2);
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        int n10 = 0;
        int n11 = 0;
        while (n10 == 0) {
            try {
                try {
                    int n12;
                    block13: {
                        int n13 = ((CodedInputStream)((Object)list)).readTag();
                        n12 = 1;
                        if (n13 != 0) {
                            int n14 = 8;
                            if (n13 != n14) {
                                n14 = 7994;
                                if (n13 != n14) {
                                    if ((n13 = (int)(this.parseUnknownField((CodedInputStream)((Object)list), unknownFieldSet$Builder, (ExtensionRegistryLite)((Object)list2), n13) ? 1 : 0)) != 0) continue;
                                    break block13;
                                } else {
                                    List<Object> list3;
                                    n13 = n11 & 2;
                                    if (n13 == 0) {
                                        this.uninterpretedOption_ = list3 = new List<Object>();
                                        n11 |= 2;
                                    }
                                    list3 = this.uninterpretedOption_;
                                    Object object = DescriptorProtos$UninterpretedOption.PARSER;
                                    object = ((CodedInputStream)((Object)list)).readMessage((Parser)object, (ExtensionRegistryLite)((Object)list2));
                                    list3.add(object);
                                    continue;
                                }
                            }
                            this.bitField0_ = n13 = this.bitField0_ | n12;
                            n13 = (int)(((CodedInputStream)((Object)list)).readBool() ? 1 : 0);
                            this.deprecated_ = n13;
                            continue;
                        }
                    }
                    n10 = n12;
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
            catch (Throwable throwable) {}
            int n15 = n11 & 2;
            if (n15 != 0) {
                this.uninterpretedOption_ = list2 = Collections.unmodifiableList(this.uninterpretedOption_);
            }
            list2 = unknownFieldSet$Builder.build();
            this.unknownFields = list2;
            this.makeExtensionsImmutable();
            throw throwable;
        }
        int n16 = n11 & 2;
        if (n16 != 0) {
            this.uninterpretedOption_ = list = Collections.unmodifiableList(this.uninterpretedOption_);
        }
        list = unknownFieldSet$Builder.build();
        this.unknownFields = list;
        this.makeExtensionsImmutable();
    }

    public /* synthetic */ DescriptorProtos$EnumValueOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private DescriptorProtos$EnumValueOptions(GeneratedMessageV3$ExtendableBuilder generatedMessageV3$ExtendableBuilder) {
        super(generatedMessageV3$ExtendableBuilder);
    }

    public /* synthetic */ DescriptorProtos$EnumValueOptions(GeneratedMessageV3$ExtendableBuilder generatedMessageV3$ExtendableBuilder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$ExtendableBuilder);
    }

    public static /* synthetic */ boolean access$22502(DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions, boolean bl2) {
        descriptorProtos$EnumValueOptions.deprecated_ = bl2;
        return bl2;
    }

    public static /* synthetic */ List access$22600(DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions) {
        return descriptorProtos$EnumValueOptions.uninterpretedOption_;
    }

    public static /* synthetic */ List access$22602(DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions, List list) {
        descriptorProtos$EnumValueOptions.uninterpretedOption_ = list;
        return list;
    }

    public static /* synthetic */ int access$22702(DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions, int n10) {
        descriptorProtos$EnumValueOptions.bitField0_ = n10;
        return n10;
    }

    public static DescriptorProtos$EnumValueOptions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$22000();
    }

    public static DescriptorProtos$EnumValueOptions$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$EnumValueOptions$Builder newBuilder(DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$EnumValueOptions);
    }

    public static DescriptorProtos$EnumValueOptions parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$EnumValueOptions)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$EnumValueOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumValueOptions)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumValueOptions parseFrom(ByteString byteString) {
        return (DescriptorProtos$EnumValueOptions)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$EnumValueOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumValueOptions)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumValueOptions parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$EnumValueOptions)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static DescriptorProtos$EnumValueOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumValueOptions)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumValueOptions parseFrom(InputStream inputStream) {
        return (DescriptorProtos$EnumValueOptions)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$EnumValueOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumValueOptions)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumValueOptions parseFrom(ByteBuffer byteBuffer) {
        return (DescriptorProtos$EnumValueOptions)PARSER.parseFrom(byteBuffer);
    }

    public static DescriptorProtos$EnumValueOptions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumValueOptions)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumValueOptions parseFrom(byte[] byArray) {
        return (DescriptorProtos$EnumValueOptions)PARSER.parseFrom(byArray);
    }

    public static DescriptorProtos$EnumValueOptions parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumValueOptions)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        Object object2;
        boolean bl2;
        boolean bl3 = true;
        if (object == this) {
            return bl3;
        }
        boolean bl4 = object instanceof DescriptorProtos$EnumValueOptions;
        if (!bl4) {
            return super.equals(object);
        }
        object = (DescriptorProtos$EnumValueOptions)object;
        bl4 = this.hasDeprecated();
        if (bl4 != (bl2 = ((DescriptorProtos$EnumValueOptions)object).hasDeprecated())) {
            return false;
        }
        bl4 = this.hasDeprecated();
        if (bl4 && (bl4 = this.getDeprecated()) != (bl2 = ((DescriptorProtos$EnumValueOptions)object).getDeprecated())) {
            return false;
        }
        Object object3 = this.getUninterpretedOptionList();
        bl4 = object3.equals(object2 = ((DescriptorProtos$EnumValueOptions)object).getUninterpretedOptionList());
        if (!bl4) {
            return false;
        }
        object3 = this.unknownFields;
        object2 = ((GeneratedMessageV3)object).unknownFields;
        bl4 = ((UnknownFieldSet)object3).equals(object2);
        if (!bl4) {
            return false;
        }
        object3 = this.getExtensionFields();
        boolean bl5 = object3.equals(object = ((GeneratedMessageV3$ExtendableMessage)object).getExtensionFields());
        if (!bl5) {
            return false;
        }
        return bl3;
    }

    public DescriptorProtos$EnumValueOptions getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public boolean getDeprecated() {
        return this.deprecated_;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        List list;
        int n10 = this.memoizedSize;
        int n11 = -1;
        if (n10 != n11) {
            return n10;
        }
        n10 = this.bitField0_;
        n11 = 1;
        int n12 = 0;
        if ((n10 &= n11) != 0) {
            n10 = (int)(this.deprecated_ ? 1 : 0);
            n10 = CodedOutputStream.computeBoolSize(n11, n10 != 0) + 0;
        } else {
            n10 = 0;
        }
        while (n12 < (n11 = (list = this.uninterpretedOption_).size())) {
            MessageLite messageLite = (MessageLite)this.uninterpretedOption_.get(n12);
            n11 = CodedOutputStream.computeMessageSize(999, messageLite);
            n10 += n11;
            ++n12;
        }
        n11 = this.extensionsSerializedSize();
        n10 += n11;
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n10 += n11;
        return n10;
    }

    public DescriptorProtos$UninterpretedOption getUninterpretedOption(int n10) {
        return (DescriptorProtos$UninterpretedOption)this.uninterpretedOption_.get(n10);
    }

    public int getUninterpretedOptionCount() {
        return this.uninterpretedOption_.size();
    }

    public List getUninterpretedOptionList() {
        return this.uninterpretedOption_;
    }

    public DescriptorProtos$UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int n10) {
        return (DescriptorProtos$UninterpretedOptionOrBuilder)this.uninterpretedOption_.get(n10);
    }

    public List getUninterpretedOptionOrBuilderList() {
        return this.uninterpretedOption_;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public boolean hasDeprecated() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = DescriptorProtos$EnumValueOptions.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasDeprecated() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            n11 = Internal.hashBoolean(this.getDeprecated());
            n10 += n11;
        }
        if ((n11 = this.getUninterpretedOptionCount()) > 0) {
            n10 = (n10 * 37 + 999) * 53;
            object = this.getUninterpretedOptionList();
            n11 = object.hashCode();
            n10 += n11;
        }
        object = this.getExtensionFields();
        n10 = AbstractMessage.hashFields(n10, (Map)object) * 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$22100().ensureFieldAccessorsInitialized(DescriptorProtos$EnumValueOptions.class, DescriptorProtos$EnumValueOptions$Builder.class);
    }

    public final boolean isInitialized() {
        int n10;
        int n11 = this.memoizedIsInitialized;
        int n12 = 1;
        if (n11 == n12) {
            return n12 != 0;
        }
        if (n11 == 0) {
            return false;
        }
        for (n11 = 0; n11 < (n10 = this.getUninterpretedOptionCount()); ++n11) {
            DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption = this.getUninterpretedOption(n11);
            n10 = (int)(descriptorProtos$UninterpretedOption.isInitialized() ? 1 : 0);
            if (n10 != 0) continue;
            this.memoizedIsInitialized = 0;
            return false;
        }
        n11 = (int)(this.extensionsAreInitialized() ? 1 : 0);
        if (n11 == 0) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = (byte)n12;
        return n12 != 0;
    }

    public DescriptorProtos$EnumValueOptions$Builder newBuilderForType() {
        return DescriptorProtos$EnumValueOptions.newBuilder();
    }

    public DescriptorProtos$EnumValueOptions$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        DescriptorProtos$EnumValueOptions$Builder descriptorProtos$EnumValueOptions$Builder = new DescriptorProtos$EnumValueOptions$Builder(generatedMessageV3$BuilderParent, null);
        return descriptorProtos$EnumValueOptions$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new DescriptorProtos$EnumValueOptions();
        return object;
    }

    public DescriptorProtos$EnumValueOptions$Builder toBuilder() {
        DescriptorProtos$EnumValueOptionsOrBuilder descriptorProtos$EnumValueOptionsOrBuilder = DEFAULT_INSTANCE;
        if (this == descriptorProtos$EnumValueOptionsOrBuilder) {
            descriptorProtos$EnumValueOptionsOrBuilder = new DescriptorProtos$EnumValueOptions$Builder(null);
        } else {
            descriptorProtos$EnumValueOptionsOrBuilder = new DescriptorProtos$EnumValueOptions$Builder(null);
            descriptorProtos$EnumValueOptionsOrBuilder = ((DescriptorProtos$EnumValueOptions$Builder)descriptorProtos$EnumValueOptionsOrBuilder).mergeFrom(this);
        }
        return descriptorProtos$EnumValueOptionsOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        List list;
        GeneratedMessageV3$ExtendableMessage$ExtensionWriter generatedMessageV3$ExtendableMessage$ExtensionWriter = this.newExtensionWriter();
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) != 0) {
            n10 = (int)(this.deprecated_ ? 1 : 0);
            codedOutputStream.writeBool(n11, n10 != 0);
        }
        for (n10 = 0; n10 < (n11 = (list = this.uninterpretedOption_).size()); ++n10) {
            n11 = 999;
            MessageLite messageLite = (MessageLite)this.uninterpretedOption_.get(n10);
            codedOutputStream.writeMessage(n11, messageLite);
        }
        generatedMessageV3$ExtendableMessage$ExtensionWriter.writeUntil(0x20000000, codedOutputStream);
        this.unknownFields.writeTo(codedOutputStream);
    }
}

