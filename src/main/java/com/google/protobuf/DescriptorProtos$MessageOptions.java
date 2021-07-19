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
import com.google.protobuf.DescriptorProtos$MessageOptions$1;
import com.google.protobuf.DescriptorProtos$MessageOptions$Builder;
import com.google.protobuf.DescriptorProtos$MessageOptionsOrBuilder;
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

public final class DescriptorProtos$MessageOptions
extends GeneratedMessageV3$ExtendableMessage
implements DescriptorProtos$MessageOptionsOrBuilder {
    private static final DescriptorProtos$MessageOptions DEFAULT_INSTANCE;
    public static final int DEPRECATED_FIELD_NUMBER = 3;
    public static final int MAP_ENTRY_FIELD_NUMBER = 7;
    public static final int MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER = 1;
    public static final int NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER = 2;
    public static final Parser PARSER;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private static final long serialVersionUID;
    private int bitField0_;
    private boolean deprecated_;
    private boolean mapEntry_;
    private byte memoizedIsInitialized;
    private boolean messageSetWireFormat_;
    private boolean noStandardDescriptorAccessor_;
    private List uninterpretedOption_;

    static {
        Object object = new DescriptorProtos$MessageOptions();
        DEFAULT_INSTANCE = object;
        PARSER = object = new DescriptorProtos$MessageOptions$1();
    }

    private DescriptorProtos$MessageOptions() {
        List list;
        this.memoizedIsInitialized = (byte)-1;
        this.uninterpretedOption_ = list = Collections.emptyList();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private DescriptorProtos$MessageOptions(CodedInputStream list, ExtensionRegistryLite list2) {
        int n10;
        UnknownFieldSet$Builder unknownFieldSet$Builder;
        block16: {
            Throwable throwable2;
            this();
            Objects.requireNonNull(list2);
            unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
            int n11 = 0;
            n10 = 0;
            while (true) {
                int n12 = 16;
                if (n11 != 0) break block16;
                try {
                    try {
                        int n13;
                        block17: {
                            int n14 = ((CodedInputStream)((Object)list)).readTag();
                            n13 = 1;
                            if (n14 != 0) {
                                int n15 = 8;
                                if (n14 != n15) {
                                    if (n14 != n12) {
                                        int n16 = 24;
                                        if (n14 != n16) {
                                            n16 = 56;
                                            if (n14 != n16) {
                                                n15 = 7994;
                                                if (n14 != n15) {
                                                    n12 = (int)(this.parseUnknownField((CodedInputStream)((Object)list), unknownFieldSet$Builder, (ExtensionRegistryLite)((Object)list2), n14) ? 1 : 0);
                                                    if (n12 != 0) continue;
                                                    break block17;
                                                } else {
                                                    List<Object> list3;
                                                    n14 = n10 & 0x10;
                                                    if (n14 == 0) {
                                                        this.uninterpretedOption_ = list3 = new List<Object>();
                                                        n10 |= 0x10;
                                                    }
                                                    list3 = this.uninterpretedOption_;
                                                    Object object = DescriptorProtos$UninterpretedOption.PARSER;
                                                    object = ((CodedInputStream)((Object)list)).readMessage((Parser)object, (ExtensionRegistryLite)((Object)list2));
                                                    list3.add(object);
                                                    continue;
                                                }
                                            }
                                            this.bitField0_ = n14 = this.bitField0_ | n15;
                                            n14 = (int)(((CodedInputStream)((Object)list)).readBool() ? 1 : 0);
                                            this.mapEntry_ = n14;
                                            continue;
                                        }
                                        this.bitField0_ = n14 = this.bitField0_ | 4;
                                        n14 = (int)(((CodedInputStream)((Object)list)).readBool() ? 1 : 0);
                                        this.deprecated_ = n14;
                                        continue;
                                    }
                                    this.bitField0_ = n14 = this.bitField0_ | 2;
                                    n14 = (int)(((CodedInputStream)((Object)list)).readBool() ? 1 : 0);
                                    this.noStandardDescriptorAccessor_ = n14;
                                    continue;
                                }
                                this.bitField0_ = n14 = this.bitField0_ | n13;
                                n14 = (int)(((CodedInputStream)((Object)list)).readBool() ? 1 : 0);
                                this.messageSetWireFormat_ = n14;
                                continue;
                            }
                        }
                        n11 = n13;
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
            int n17 = n10 & 0x10;
            if (n17 != 0) {
                this.uninterpretedOption_ = list2 = Collections.unmodifiableList(this.uninterpretedOption_);
            }
            list2 = unknownFieldSet$Builder.build();
            this.unknownFields = list2;
            this.makeExtensionsImmutable();
            throw throwable2;
        }
        int n18 = n10 & 0x10;
        if (n18 != 0) {
            this.uninterpretedOption_ = list = Collections.unmodifiableList(this.uninterpretedOption_);
        }
        list = unknownFieldSet$Builder.build();
        this.unknownFields = list;
        this.makeExtensionsImmutable();
    }

    public /* synthetic */ DescriptorProtos$MessageOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private DescriptorProtos$MessageOptions(GeneratedMessageV3$ExtendableBuilder generatedMessageV3$ExtendableBuilder) {
        super(generatedMessageV3$ExtendableBuilder);
        this.memoizedIsInitialized = (byte)-1;
    }

    public /* synthetic */ DescriptorProtos$MessageOptions(GeneratedMessageV3$ExtendableBuilder generatedMessageV3$ExtendableBuilder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$ExtendableBuilder);
    }

    public static /* synthetic */ boolean access$18202(DescriptorProtos$MessageOptions descriptorProtos$MessageOptions, boolean bl2) {
        descriptorProtos$MessageOptions.messageSetWireFormat_ = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean access$18302(DescriptorProtos$MessageOptions descriptorProtos$MessageOptions, boolean bl2) {
        descriptorProtos$MessageOptions.noStandardDescriptorAccessor_ = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean access$18402(DescriptorProtos$MessageOptions descriptorProtos$MessageOptions, boolean bl2) {
        descriptorProtos$MessageOptions.deprecated_ = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean access$18502(DescriptorProtos$MessageOptions descriptorProtos$MessageOptions, boolean bl2) {
        descriptorProtos$MessageOptions.mapEntry_ = bl2;
        return bl2;
    }

    public static /* synthetic */ List access$18600(DescriptorProtos$MessageOptions descriptorProtos$MessageOptions) {
        return descriptorProtos$MessageOptions.uninterpretedOption_;
    }

    public static /* synthetic */ List access$18602(DescriptorProtos$MessageOptions descriptorProtos$MessageOptions, List list) {
        descriptorProtos$MessageOptions.uninterpretedOption_ = list;
        return list;
    }

    public static /* synthetic */ int access$18702(DescriptorProtos$MessageOptions descriptorProtos$MessageOptions, int n10) {
        descriptorProtos$MessageOptions.bitField0_ = n10;
        return n10;
    }

    public static DescriptorProtos$MessageOptions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$17700();
    }

    public static DescriptorProtos$MessageOptions$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$MessageOptions$Builder newBuilder(DescriptorProtos$MessageOptions descriptorProtos$MessageOptions) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$MessageOptions);
    }

    public static DescriptorProtos$MessageOptions parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$MessageOptions)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$MessageOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MessageOptions)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$MessageOptions parseFrom(ByteString byteString) {
        return (DescriptorProtos$MessageOptions)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$MessageOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MessageOptions)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$MessageOptions parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$MessageOptions)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static DescriptorProtos$MessageOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MessageOptions)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$MessageOptions parseFrom(InputStream inputStream) {
        return (DescriptorProtos$MessageOptions)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$MessageOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MessageOptions)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$MessageOptions parseFrom(ByteBuffer byteBuffer) {
        return (DescriptorProtos$MessageOptions)PARSER.parseFrom(byteBuffer);
    }

    public static DescriptorProtos$MessageOptions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MessageOptions)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static DescriptorProtos$MessageOptions parseFrom(byte[] byArray) {
        return (DescriptorProtos$MessageOptions)PARSER.parseFrom(byArray);
    }

    public static DescriptorProtos$MessageOptions parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MessageOptions)PARSER.parseFrom(byArray, extensionRegistryLite);
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
        boolean bl4 = object instanceof DescriptorProtos$MessageOptions;
        if (!bl4) {
            return super.equals(object);
        }
        object = (DescriptorProtos$MessageOptions)object;
        bl4 = this.hasMessageSetWireFormat();
        if (bl4 != (bl2 = ((DescriptorProtos$MessageOptions)object).hasMessageSetWireFormat())) {
            return false;
        }
        bl4 = this.hasMessageSetWireFormat();
        if (bl4 && (bl4 = this.getMessageSetWireFormat()) != (bl2 = ((DescriptorProtos$MessageOptions)object).getMessageSetWireFormat())) {
            return false;
        }
        bl4 = this.hasNoStandardDescriptorAccessor();
        if (bl4 != (bl2 = ((DescriptorProtos$MessageOptions)object).hasNoStandardDescriptorAccessor())) {
            return false;
        }
        bl4 = this.hasNoStandardDescriptorAccessor();
        if (bl4 && (bl4 = this.getNoStandardDescriptorAccessor()) != (bl2 = ((DescriptorProtos$MessageOptions)object).getNoStandardDescriptorAccessor())) {
            return false;
        }
        bl4 = this.hasDeprecated();
        if (bl4 != (bl2 = ((DescriptorProtos$MessageOptions)object).hasDeprecated())) {
            return false;
        }
        bl4 = this.hasDeprecated();
        if (bl4 && (bl4 = this.getDeprecated()) != (bl2 = ((DescriptorProtos$MessageOptions)object).getDeprecated())) {
            return false;
        }
        bl4 = this.hasMapEntry();
        if (bl4 != (bl2 = ((DescriptorProtos$MessageOptions)object).hasMapEntry())) {
            return false;
        }
        bl4 = this.hasMapEntry();
        if (bl4 && (bl4 = this.getMapEntry()) != (bl2 = ((DescriptorProtos$MessageOptions)object).getMapEntry())) {
            return false;
        }
        Object object3 = this.getUninterpretedOptionList();
        bl4 = object3.equals(object2 = ((DescriptorProtos$MessageOptions)object).getUninterpretedOptionList());
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

    public DescriptorProtos$MessageOptions getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public boolean getDeprecated() {
        return this.deprecated_;
    }

    public boolean getMapEntry() {
        return this.mapEntry_;
    }

    public boolean getMessageSetWireFormat() {
        return this.messageSetWireFormat_;
    }

    public boolean getNoStandardDescriptorAccessor() {
        return this.noStandardDescriptorAccessor_;
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
            n10 = (int)(this.messageSetWireFormat_ ? 1 : 0);
            n10 = CodedOutputStream.computeBoolSize(n11, n10 != 0) + 0;
        } else {
            n10 = 0;
        }
        n11 = this.bitField0_;
        int n13 = 2;
        if ((n11 &= n13) != 0) {
            n11 = (int)(this.noStandardDescriptorAccessor_ ? 1 : 0);
            n11 = CodedOutputStream.computeBoolSize(n13, n11 != 0);
            n10 += n11;
        }
        if ((n11 = this.bitField0_ & 4) != 0) {
            n13 = (int)(this.deprecated_ ? 1 : 0);
            n11 = CodedOutputStream.computeBoolSize(3, n13 != 0);
            n10 += n11;
        }
        if ((n11 = this.bitField0_ & 8) != 0) {
            n13 = this.mapEntry_;
            n11 = CodedOutputStream.computeBoolSize(7, n13 != 0);
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

    public boolean hasDeprecated() {
        int n10 = this.bitField0_ & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasMapEntry() {
        int n10 = this.bitField0_ & 8;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasMessageSetWireFormat() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean hasNoStandardDescriptorAccessor() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = DescriptorProtos$MessageOptions.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasMessageSetWireFormat() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            n11 = Internal.hashBoolean(this.getMessageSetWireFormat());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasNoStandardDescriptorAccessor() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 2) * 53;
            n11 = Internal.hashBoolean(this.getNoStandardDescriptorAccessor());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasDeprecated() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 3) * 53;
            n11 = Internal.hashBoolean(this.getDeprecated());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasMapEntry() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 7) * 53;
            n11 = Internal.hashBoolean(this.getMapEntry());
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
        return DescriptorProtos.access$17800().ensureFieldAccessorsInitialized(DescriptorProtos$MessageOptions.class, DescriptorProtos$MessageOptions$Builder.class);
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

    public DescriptorProtos$MessageOptions$Builder newBuilderForType() {
        return DescriptorProtos$MessageOptions.newBuilder();
    }

    public DescriptorProtos$MessageOptions$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        DescriptorProtos$MessageOptions$Builder descriptorProtos$MessageOptions$Builder = new DescriptorProtos$MessageOptions$Builder(generatedMessageV3$BuilderParent, null);
        return descriptorProtos$MessageOptions$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new DescriptorProtos$MessageOptions();
        return object;
    }

    public DescriptorProtos$MessageOptions$Builder toBuilder() {
        DescriptorProtos$MessageOptionsOrBuilder descriptorProtos$MessageOptionsOrBuilder = DEFAULT_INSTANCE;
        if (this == descriptorProtos$MessageOptionsOrBuilder) {
            descriptorProtos$MessageOptionsOrBuilder = new DescriptorProtos$MessageOptions$Builder(null);
        } else {
            descriptorProtos$MessageOptionsOrBuilder = new DescriptorProtos$MessageOptions$Builder(null);
            descriptorProtos$MessageOptionsOrBuilder = ((DescriptorProtos$MessageOptions$Builder)descriptorProtos$MessageOptionsOrBuilder).mergeFrom(this);
        }
        return descriptorProtos$MessageOptionsOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        List list;
        GeneratedMessageV3$ExtendableMessage$ExtensionWriter generatedMessageV3$ExtendableMessage$ExtensionWriter = this.newExtensionWriter();
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) != 0) {
            n10 = (int)(this.messageSetWireFormat_ ? 1 : 0);
            codedOutputStream.writeBool(n11, n10 != 0);
        }
        n10 = this.bitField0_;
        n11 = 2;
        if ((n10 &= n11) != 0) {
            n10 = (int)(this.noStandardDescriptorAccessor_ ? 1 : 0);
            codedOutputStream.writeBool(n11, n10 != 0);
        }
        if ((n10 = this.bitField0_ & 4) != 0) {
            n10 = 3;
            n11 = (int)(this.deprecated_ ? 1 : 0);
            codedOutputStream.writeBool(n10, n11 != 0);
        }
        if ((n10 = this.bitField0_ & 8) != 0) {
            n10 = 7;
            n11 = this.mapEntry_;
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

