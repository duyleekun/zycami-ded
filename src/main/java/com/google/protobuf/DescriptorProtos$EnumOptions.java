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
import com.google.protobuf.DescriptorProtos$EnumOptions$1;
import com.google.protobuf.DescriptorProtos$EnumOptions$Builder;
import com.google.protobuf.DescriptorProtos$EnumOptionsOrBuilder;
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

public final class DescriptorProtos$EnumOptions
extends GeneratedMessageV3$ExtendableMessage
implements DescriptorProtos$EnumOptionsOrBuilder {
    public static final int ALLOW_ALIAS_FIELD_NUMBER = 2;
    private static final DescriptorProtos$EnumOptions DEFAULT_INSTANCE;
    public static final int DEPRECATED_FIELD_NUMBER = 3;
    public static final Parser PARSER;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private static final long serialVersionUID;
    private boolean allowAlias_;
    private int bitField0_;
    private boolean deprecated_;
    private byte memoizedIsInitialized = (byte)-1;
    private List uninterpretedOption_;

    static {
        Object object = new DescriptorProtos$EnumOptions();
        DEFAULT_INSTANCE = object;
        PARSER = object = new DescriptorProtos$EnumOptions$1();
    }

    private DescriptorProtos$EnumOptions() {
        List list;
        this.uninterpretedOption_ = list = Collections.emptyList();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private DescriptorProtos$EnumOptions(CodedInputStream list, ExtensionRegistryLite list2) {
        this();
        Objects.requireNonNull(list2);
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        int n10 = 0;
        int n11 = 0;
        while (n10 == 0) {
            try {
                try {
                    int n12;
                    block14: {
                        int n13 = ((CodedInputStream)((Object)list)).readTag();
                        n12 = 1;
                        if (n13 != 0) {
                            int n14 = 16;
                            if (n13 != n14) {
                                n14 = 24;
                                if (n13 != n14) {
                                    n14 = 7994;
                                    if (n13 != n14) {
                                        if ((n13 = (int)(this.parseUnknownField((CodedInputStream)((Object)list), unknownFieldSet$Builder, (ExtensionRegistryLite)((Object)list2), n13) ? 1 : 0)) != 0) continue;
                                        break block14;
                                    } else {
                                        List<Object> list3;
                                        n13 = n11 & 4;
                                        if (n13 == 0) {
                                            this.uninterpretedOption_ = list3 = new List<Object>();
                                            n11 |= 4;
                                        }
                                        list3 = this.uninterpretedOption_;
                                        Object object = DescriptorProtos$UninterpretedOption.PARSER;
                                        object = ((CodedInputStream)((Object)list)).readMessage((Parser)object, (ExtensionRegistryLite)((Object)list2));
                                        list3.add(object);
                                        continue;
                                    }
                                }
                                this.bitField0_ = n13 = this.bitField0_ | 2;
                                n13 = (int)(((CodedInputStream)((Object)list)).readBool() ? 1 : 0);
                                this.deprecated_ = n13;
                                continue;
                            }
                            this.bitField0_ = n13 = this.bitField0_ | n12;
                            n13 = (int)(((CodedInputStream)((Object)list)).readBool() ? 1 : 0);
                            this.allowAlias_ = n13;
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
            int n15 = n11 & 4;
            if (n15 != 0) {
                this.uninterpretedOption_ = list2 = Collections.unmodifiableList(this.uninterpretedOption_);
            }
            list2 = unknownFieldSet$Builder.build();
            this.unknownFields = list2;
            this.makeExtensionsImmutable();
            throw throwable;
        }
        int n16 = n11 & 4;
        if (n16 != 0) {
            this.uninterpretedOption_ = list = Collections.unmodifiableList(this.uninterpretedOption_);
        }
        list = unknownFieldSet$Builder.build();
        this.unknownFields = list;
        this.makeExtensionsImmutable();
    }

    public /* synthetic */ DescriptorProtos$EnumOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private DescriptorProtos$EnumOptions(GeneratedMessageV3$ExtendableBuilder generatedMessageV3$ExtendableBuilder) {
        super(generatedMessageV3$ExtendableBuilder);
    }

    public /* synthetic */ DescriptorProtos$EnumOptions(GeneratedMessageV3$ExtendableBuilder generatedMessageV3$ExtendableBuilder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$ExtendableBuilder);
    }

    public static /* synthetic */ boolean access$21502(DescriptorProtos$EnumOptions descriptorProtos$EnumOptions, boolean bl2) {
        descriptorProtos$EnumOptions.allowAlias_ = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean access$21602(DescriptorProtos$EnumOptions descriptorProtos$EnumOptions, boolean bl2) {
        descriptorProtos$EnumOptions.deprecated_ = bl2;
        return bl2;
    }

    public static /* synthetic */ List access$21700(DescriptorProtos$EnumOptions descriptorProtos$EnumOptions) {
        return descriptorProtos$EnumOptions.uninterpretedOption_;
    }

    public static /* synthetic */ List access$21702(DescriptorProtos$EnumOptions descriptorProtos$EnumOptions, List list) {
        descriptorProtos$EnumOptions.uninterpretedOption_ = list;
        return list;
    }

    public static /* synthetic */ int access$21802(DescriptorProtos$EnumOptions descriptorProtos$EnumOptions, int n10) {
        descriptorProtos$EnumOptions.bitField0_ = n10;
        return n10;
    }

    public static DescriptorProtos$EnumOptions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$21000();
    }

    public static DescriptorProtos$EnumOptions$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$EnumOptions$Builder newBuilder(DescriptorProtos$EnumOptions descriptorProtos$EnumOptions) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$EnumOptions);
    }

    public static DescriptorProtos$EnumOptions parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$EnumOptions)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$EnumOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumOptions)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumOptions parseFrom(ByteString byteString) {
        return (DescriptorProtos$EnumOptions)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$EnumOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumOptions)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumOptions parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$EnumOptions)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static DescriptorProtos$EnumOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumOptions)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumOptions parseFrom(InputStream inputStream) {
        return (DescriptorProtos$EnumOptions)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$EnumOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumOptions)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumOptions parseFrom(ByteBuffer byteBuffer) {
        return (DescriptorProtos$EnumOptions)PARSER.parseFrom(byteBuffer);
    }

    public static DescriptorProtos$EnumOptions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumOptions)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumOptions parseFrom(byte[] byArray) {
        return (DescriptorProtos$EnumOptions)PARSER.parseFrom(byArray);
    }

    public static DescriptorProtos$EnumOptions parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumOptions)PARSER.parseFrom(byArray, extensionRegistryLite);
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
        boolean bl4 = object instanceof DescriptorProtos$EnumOptions;
        if (!bl4) {
            return super.equals(object);
        }
        object = (DescriptorProtos$EnumOptions)object;
        bl4 = this.hasAllowAlias();
        if (bl4 != (bl2 = ((DescriptorProtos$EnumOptions)object).hasAllowAlias())) {
            return false;
        }
        bl4 = this.hasAllowAlias();
        if (bl4 && (bl4 = this.getAllowAlias()) != (bl2 = ((DescriptorProtos$EnumOptions)object).getAllowAlias())) {
            return false;
        }
        bl4 = this.hasDeprecated();
        if (bl4 != (bl2 = ((DescriptorProtos$EnumOptions)object).hasDeprecated())) {
            return false;
        }
        bl4 = this.hasDeprecated();
        if (bl4 && (bl4 = this.getDeprecated()) != (bl2 = ((DescriptorProtos$EnumOptions)object).getDeprecated())) {
            return false;
        }
        Object object3 = this.getUninterpretedOptionList();
        bl4 = object3.equals(object2 = ((DescriptorProtos$EnumOptions)object).getUninterpretedOptionList());
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

    public boolean getAllowAlias() {
        return this.allowAlias_;
    }

    public DescriptorProtos$EnumOptions getDefaultInstanceForType() {
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
        n10 = this.bitField0_ & 1;
        n11 = 2;
        int n12 = 0;
        if (n10 != 0) {
            n10 = (int)(this.allowAlias_ ? 1 : 0);
            n10 = CodedOutputStream.computeBoolSize(n11, n10 != 0) + 0;
        } else {
            n10 = 0;
        }
        int n13 = this.bitField0_;
        if ((n11 &= n13) != 0) {
            n13 = (int)(this.deprecated_ ? 1 : 0);
            n11 = CodedOutputStream.computeBoolSize(3, n13 != 0);
            n10 += n11;
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

    public boolean hasAllowAlias() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean hasDeprecated() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = DescriptorProtos$EnumOptions.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasAllowAlias() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 2) * 53;
            n11 = Internal.hashBoolean(this.getAllowAlias());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasDeprecated() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 3) * 53;
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
        return DescriptorProtos.access$21100().ensureFieldAccessorsInitialized(DescriptorProtos$EnumOptions.class, DescriptorProtos$EnumOptions$Builder.class);
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

    public DescriptorProtos$EnumOptions$Builder newBuilderForType() {
        return DescriptorProtos$EnumOptions.newBuilder();
    }

    public DescriptorProtos$EnumOptions$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        DescriptorProtos$EnumOptions$Builder descriptorProtos$EnumOptions$Builder = new DescriptorProtos$EnumOptions$Builder(generatedMessageV3$BuilderParent, null);
        return descriptorProtos$EnumOptions$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new DescriptorProtos$EnumOptions();
        return object;
    }

    public DescriptorProtos$EnumOptions$Builder toBuilder() {
        DescriptorProtos$EnumOptionsOrBuilder descriptorProtos$EnumOptionsOrBuilder = DEFAULT_INSTANCE;
        if (this == descriptorProtos$EnumOptionsOrBuilder) {
            descriptorProtos$EnumOptionsOrBuilder = new DescriptorProtos$EnumOptions$Builder(null);
        } else {
            descriptorProtos$EnumOptionsOrBuilder = new DescriptorProtos$EnumOptions$Builder(null);
            descriptorProtos$EnumOptionsOrBuilder = ((DescriptorProtos$EnumOptions$Builder)descriptorProtos$EnumOptionsOrBuilder).mergeFrom(this);
        }
        return descriptorProtos$EnumOptionsOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        List list;
        GeneratedMessageV3$ExtendableMessage$ExtensionWriter generatedMessageV3$ExtendableMessage$ExtensionWriter = this.newExtensionWriter();
        int n10 = this.bitField0_ & 1;
        int n11 = 2;
        if (n10 != 0) {
            n10 = (int)(this.allowAlias_ ? 1 : 0);
            codedOutputStream.writeBool(n11, n10 != 0);
        }
        if ((n10 = this.bitField0_ & n11) != 0) {
            n10 = 3;
            n11 = (int)(this.deprecated_ ? 1 : 0);
            codedOutputStream.writeBool(n10, n11 != 0);
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

