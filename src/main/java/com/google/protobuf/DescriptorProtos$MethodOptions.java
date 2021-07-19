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
import com.google.protobuf.DescriptorProtos$MethodOptions$1;
import com.google.protobuf.DescriptorProtos$MethodOptions$Builder;
import com.google.protobuf.DescriptorProtos$MethodOptions$IdempotencyLevel;
import com.google.protobuf.DescriptorProtos$MethodOptionsOrBuilder;
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

public final class DescriptorProtos$MethodOptions
extends GeneratedMessageV3$ExtendableMessage
implements DescriptorProtos$MethodOptionsOrBuilder {
    private static final DescriptorProtos$MethodOptions DEFAULT_INSTANCE;
    public static final int DEPRECATED_FIELD_NUMBER = 33;
    public static final int IDEMPOTENCY_LEVEL_FIELD_NUMBER = 34;
    public static final Parser PARSER;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private static final long serialVersionUID;
    private int bitField0_;
    private boolean deprecated_;
    private int idempotencyLevel_;
    private byte memoizedIsInitialized = (byte)-1;
    private List uninterpretedOption_;

    static {
        Object object = new DescriptorProtos$MethodOptions();
        DEFAULT_INSTANCE = object;
        PARSER = object = new DescriptorProtos$MethodOptions$1();
    }

    private DescriptorProtos$MethodOptions() {
        List list;
        this.idempotencyLevel_ = 0;
        this.uninterpretedOption_ = list = Collections.emptyList();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private DescriptorProtos$MethodOptions(CodedInputStream list, ExtensionRegistryLite list2) {
        this();
        Objects.requireNonNull(list2);
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        int n10 = 0;
        int n11 = 0;
        while (n10 == 0) {
            try {
                try {
                    int n12;
                    block15: {
                        int n13 = ((CodedInputStream)((Object)list)).readTag();
                        n12 = 1;
                        if (n13 != 0) {
                            int n14 = 264;
                            if (n13 != n14) {
                                Object object;
                                n14 = 272;
                                if (n13 != n14) {
                                    n14 = 7994;
                                    if (n13 != n14) {
                                        if ((n13 = (int)(this.parseUnknownField((CodedInputStream)((Object)list), unknownFieldSet$Builder, (ExtensionRegistryLite)((Object)list2), n13) ? 1 : 0)) != 0) continue;
                                        break block15;
                                    } else {
                                        List<Object> list3;
                                        n13 = n11 & 4;
                                        if (n13 == 0) {
                                            this.uninterpretedOption_ = list3 = new List<Object>();
                                            n11 |= 4;
                                        }
                                        list3 = this.uninterpretedOption_;
                                        object = DescriptorProtos$UninterpretedOption.PARSER;
                                        object = ((CodedInputStream)((Object)list)).readMessage((Parser)object, (ExtensionRegistryLite)((Object)list2));
                                        list3.add(object);
                                        continue;
                                    }
                                }
                                n13 = ((CodedInputStream)((Object)list)).readEnum();
                                object = DescriptorProtos$MethodOptions$IdempotencyLevel.valueOf(n13);
                                if (object == null) {
                                    n12 = 34;
                                    unknownFieldSet$Builder.mergeVarintField(n12, n13);
                                    continue;
                                }
                                this.bitField0_ = n12 = this.bitField0_ | 2;
                                this.idempotencyLevel_ = n13;
                                continue;
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

    public /* synthetic */ DescriptorProtos$MethodOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private DescriptorProtos$MethodOptions(GeneratedMessageV3$ExtendableBuilder generatedMessageV3$ExtendableBuilder) {
        super(generatedMessageV3$ExtendableBuilder);
    }

    public /* synthetic */ DescriptorProtos$MethodOptions(GeneratedMessageV3$ExtendableBuilder generatedMessageV3$ExtendableBuilder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$ExtendableBuilder);
    }

    public static /* synthetic */ boolean access$24302(DescriptorProtos$MethodOptions descriptorProtos$MethodOptions, boolean bl2) {
        descriptorProtos$MethodOptions.deprecated_ = bl2;
        return bl2;
    }

    public static /* synthetic */ int access$24402(DescriptorProtos$MethodOptions descriptorProtos$MethodOptions, int n10) {
        descriptorProtos$MethodOptions.idempotencyLevel_ = n10;
        return n10;
    }

    public static /* synthetic */ List access$24500(DescriptorProtos$MethodOptions descriptorProtos$MethodOptions) {
        return descriptorProtos$MethodOptions.uninterpretedOption_;
    }

    public static /* synthetic */ List access$24502(DescriptorProtos$MethodOptions descriptorProtos$MethodOptions, List list) {
        descriptorProtos$MethodOptions.uninterpretedOption_ = list;
        return list;
    }

    public static /* synthetic */ int access$24602(DescriptorProtos$MethodOptions descriptorProtos$MethodOptions, int n10) {
        descriptorProtos$MethodOptions.bitField0_ = n10;
        return n10;
    }

    public static DescriptorProtos$MethodOptions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$23800();
    }

    public static DescriptorProtos$MethodOptions$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$MethodOptions$Builder newBuilder(DescriptorProtos$MethodOptions descriptorProtos$MethodOptions) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$MethodOptions);
    }

    public static DescriptorProtos$MethodOptions parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$MethodOptions)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$MethodOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MethodOptions)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$MethodOptions parseFrom(ByteString byteString) {
        return (DescriptorProtos$MethodOptions)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$MethodOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MethodOptions)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$MethodOptions parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$MethodOptions)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static DescriptorProtos$MethodOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MethodOptions)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$MethodOptions parseFrom(InputStream inputStream) {
        return (DescriptorProtos$MethodOptions)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$MethodOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MethodOptions)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$MethodOptions parseFrom(ByteBuffer byteBuffer) {
        return (DescriptorProtos$MethodOptions)PARSER.parseFrom(byteBuffer);
    }

    public static DescriptorProtos$MethodOptions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MethodOptions)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static DescriptorProtos$MethodOptions parseFrom(byte[] byArray) {
        return (DescriptorProtos$MethodOptions)PARSER.parseFrom(byArray);
    }

    public static DescriptorProtos$MethodOptions parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MethodOptions)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        Object object2;
        int n10;
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n11 = object instanceof DescriptorProtos$MethodOptions;
        if (n11 == 0) {
            return super.equals(object);
        }
        object = (DescriptorProtos$MethodOptions)object;
        n11 = this.hasDeprecated();
        if (n11 != (n10 = ((DescriptorProtos$MethodOptions)object).hasDeprecated())) {
            return false;
        }
        n11 = this.hasDeprecated();
        if (n11 != 0 && (n11 = this.getDeprecated()) != (n10 = ((DescriptorProtos$MethodOptions)object).getDeprecated())) {
            return false;
        }
        n11 = this.hasIdempotencyLevel();
        if (n11 != (n10 = ((DescriptorProtos$MethodOptions)object).hasIdempotencyLevel())) {
            return false;
        }
        n11 = this.hasIdempotencyLevel();
        if (n11 != 0 && (n11 = this.idempotencyLevel_) != (n10 = ((DescriptorProtos$MethodOptions)object).idempotencyLevel_)) {
            return false;
        }
        Object object3 = this.getUninterpretedOptionList();
        n11 = (int)(object3.equals(object2 = ((DescriptorProtos$MethodOptions)object).getUninterpretedOptionList()) ? 1 : 0);
        if (n11 == 0) {
            return false;
        }
        object3 = this.unknownFields;
        object2 = ((GeneratedMessageV3)object).unknownFields;
        n11 = (int)(((UnknownFieldSet)object3).equals(object2) ? 1 : 0);
        if (n11 == 0) {
            return false;
        }
        object3 = this.getExtensionFields();
        boolean bl3 = object3.equals(object = ((GeneratedMessageV3$ExtendableMessage)object).getExtensionFields());
        if (!bl3) {
            return false;
        }
        return bl2;
    }

    public DescriptorProtos$MethodOptions getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public boolean getDeprecated() {
        return this.deprecated_;
    }

    public DescriptorProtos$MethodOptions$IdempotencyLevel getIdempotencyLevel() {
        int n10 = this.idempotencyLevel_;
        DescriptorProtos$MethodOptions$IdempotencyLevel descriptorProtos$MethodOptions$IdempotencyLevel = DescriptorProtos$MethodOptions$IdempotencyLevel.valueOf(n10);
        if (descriptorProtos$MethodOptions$IdempotencyLevel == null) {
            descriptorProtos$MethodOptions$IdempotencyLevel = DescriptorProtos$MethodOptions$IdempotencyLevel.IDEMPOTENCY_UNKNOWN;
        }
        return descriptorProtos$MethodOptions$IdempotencyLevel;
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
        n11 = this.bitField0_ & 1;
        n12 = 0;
        if (n11 != 0) {
            n10 = this.deprecated_;
            n11 = CodedOutputStream.computeBoolSize(33, n10 != 0) + 0;
        } else {
            n11 = 0;
        }
        n10 = this.bitField0_ & 2;
        if (n10 != 0) {
            int n13 = this.idempotencyLevel_;
            n10 = CodedOutputStream.computeEnumSize(34, n13);
            n11 += n10;
        }
        while (n12 < (n10 = (list = this.uninterpretedOption_).size())) {
            MessageLite messageLite = (MessageLite)this.uninterpretedOption_.get(n12);
            n10 = CodedOutputStream.computeMessageSize(999, messageLite);
            n11 += n10;
            ++n12;
        }
        n12 = this.extensionsSerializedSize();
        n11 += n12;
        n12 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n11 += n12;
        return n11;
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

    public boolean hasIdempotencyLevel() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = DescriptorProtos$MethodOptions.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasDeprecated() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 33) * 53;
            n11 = Internal.hashBoolean(this.getDeprecated());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasIdempotencyLevel() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 34) * 53;
            n11 = this.idempotencyLevel_;
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
        return DescriptorProtos.access$23900().ensureFieldAccessorsInitialized(DescriptorProtos$MethodOptions.class, DescriptorProtos$MethodOptions$Builder.class);
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

    public DescriptorProtos$MethodOptions$Builder newBuilderForType() {
        return DescriptorProtos$MethodOptions.newBuilder();
    }

    public DescriptorProtos$MethodOptions$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        DescriptorProtos$MethodOptions$Builder descriptorProtos$MethodOptions$Builder = new DescriptorProtos$MethodOptions$Builder(generatedMessageV3$BuilderParent, null);
        return descriptorProtos$MethodOptions$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new DescriptorProtos$MethodOptions();
        return object;
    }

    public DescriptorProtos$MethodOptions$Builder toBuilder() {
        DescriptorProtos$MethodOptionsOrBuilder descriptorProtos$MethodOptionsOrBuilder = DEFAULT_INSTANCE;
        if (this == descriptorProtos$MethodOptionsOrBuilder) {
            descriptorProtos$MethodOptionsOrBuilder = new DescriptorProtos$MethodOptions$Builder(null);
        } else {
            descriptorProtos$MethodOptionsOrBuilder = new DescriptorProtos$MethodOptions$Builder(null);
            descriptorProtos$MethodOptionsOrBuilder = ((DescriptorProtos$MethodOptions$Builder)descriptorProtos$MethodOptionsOrBuilder).mergeFrom(this);
        }
        return descriptorProtos$MethodOptionsOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        List list;
        int n10;
        GeneratedMessageV3$ExtendableMessage$ExtensionWriter generatedMessageV3$ExtendableMessage$ExtensionWriter = this.newExtensionWriter();
        int n11 = this.bitField0_ & 1;
        if (n11 != 0) {
            n11 = 33;
            n10 = this.deprecated_;
            codedOutputStream.writeBool(n11, n10 != 0);
        }
        if ((n11 = this.bitField0_ & 2) != 0) {
            n11 = 34;
            n10 = this.idempotencyLevel_;
            codedOutputStream.writeEnum(n11, n10);
        }
        for (n11 = 0; n11 < (n10 = (list = this.uninterpretedOption_).size()); ++n11) {
            n10 = 999;
            MessageLite messageLite = (MessageLite)this.uninterpretedOption_.get(n11);
            codedOutputStream.writeMessage(n10, messageLite);
        }
        generatedMessageV3$ExtendableMessage$ExtensionWriter.writeUntil(0x20000000, codedOutputStream);
        this.unknownFields.writeTo(codedOutputStream);
    }
}

