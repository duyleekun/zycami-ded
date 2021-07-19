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
import com.google.protobuf.DescriptorProtos$FieldOptions$1;
import com.google.protobuf.DescriptorProtos$FieldOptions$Builder;
import com.google.protobuf.DescriptorProtos$FieldOptions$CType;
import com.google.protobuf.DescriptorProtos$FieldOptions$JSType;
import com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder;
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

public final class DescriptorProtos$FieldOptions
extends GeneratedMessageV3$ExtendableMessage
implements DescriptorProtos$FieldOptionsOrBuilder {
    public static final int CTYPE_FIELD_NUMBER = 1;
    private static final DescriptorProtos$FieldOptions DEFAULT_INSTANCE;
    public static final int DEPRECATED_FIELD_NUMBER = 3;
    public static final int JSTYPE_FIELD_NUMBER = 6;
    public static final int LAZY_FIELD_NUMBER = 5;
    public static final int PACKED_FIELD_NUMBER = 2;
    public static final Parser PARSER;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    public static final int WEAK_FIELD_NUMBER = 10;
    private static final long serialVersionUID;
    private int bitField0_;
    private int ctype_;
    private boolean deprecated_;
    private int jstype_;
    private boolean lazy_;
    private byte memoizedIsInitialized = (byte)-1;
    private boolean packed_;
    private List uninterpretedOption_;
    private boolean weak_;

    static {
        Object object = new DescriptorProtos$FieldOptions();
        DEFAULT_INSTANCE = object;
        PARSER = object = new DescriptorProtos$FieldOptions$1();
    }

    private DescriptorProtos$FieldOptions() {
        List list;
        this.ctype_ = 0;
        this.jstype_ = 0;
        this.uninterpretedOption_ = list = Collections.emptyList();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private DescriptorProtos$FieldOptions(CodedInputStream list, ExtensionRegistryLite list2) {
        this();
        Objects.requireNonNull(list2);
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        int n10 = 0;
        int n11 = 0;
        while (n10 == 0) {
            try {
                try {
                    int n12;
                    block20: {
                        int n13 = ((CodedInputStream)((Object)list)).readTag();
                        n12 = 1;
                        if (n13 != 0) {
                            int n14 = 8;
                            if (n13 != n14) {
                                int n15 = 16;
                                if (n13 != n15) {
                                    int n16 = 24;
                                    if (n13 != n16) {
                                        n15 = 40;
                                        if (n13 != n15) {
                                            Object object;
                                            n14 = 48;
                                            if (n13 != n14) {
                                                n14 = 80;
                                                if (n13 != n14) {
                                                    n14 = 7994;
                                                    if (n13 != n14) {
                                                        if ((n13 = (int)(this.parseUnknownField((CodedInputStream)((Object)list), unknownFieldSet$Builder, (ExtensionRegistryLite)((Object)list2), n13) ? 1 : 0)) != 0) continue;
                                                        break block20;
                                                    } else {
                                                        List<Object> list3;
                                                        n13 = n11 & 0x40;
                                                        if (n13 == 0) {
                                                            this.uninterpretedOption_ = list3 = new List<Object>();
                                                            n11 |= 0x40;
                                                        }
                                                        list3 = this.uninterpretedOption_;
                                                        object = DescriptorProtos$UninterpretedOption.PARSER;
                                                        object = ((CodedInputStream)((Object)list)).readMessage((Parser)object, (ExtensionRegistryLite)((Object)list2));
                                                        list3.add(object);
                                                        continue;
                                                    }
                                                }
                                                this.bitField0_ = n13 = this.bitField0_ | 0x20;
                                                n13 = (int)(((CodedInputStream)((Object)list)).readBool() ? 1 : 0);
                                                this.weak_ = n13;
                                                continue;
                                            }
                                            n13 = ((CodedInputStream)((Object)list)).readEnum();
                                            object = DescriptorProtos$FieldOptions$JSType.valueOf(n13);
                                            if (object == null) {
                                                n12 = 6;
                                                unknownFieldSet$Builder.mergeVarintField(n12, n13);
                                                continue;
                                            }
                                            this.bitField0_ = n12 = this.bitField0_ | 4;
                                            this.jstype_ = n13;
                                            continue;
                                        }
                                        this.bitField0_ = n13 = this.bitField0_ | n14;
                                        n13 = (int)(((CodedInputStream)((Object)list)).readBool() ? 1 : 0);
                                        this.lazy_ = n13;
                                        continue;
                                    }
                                    this.bitField0_ = n13 = this.bitField0_ | n15;
                                    n13 = (int)(((CodedInputStream)((Object)list)).readBool() ? 1 : 0);
                                    this.deprecated_ = n13;
                                    continue;
                                }
                                this.bitField0_ = n13 = this.bitField0_ | 2;
                                n13 = (int)(((CodedInputStream)((Object)list)).readBool() ? 1 : 0);
                                this.packed_ = n13;
                                continue;
                            }
                            n13 = ((CodedInputStream)((Object)list)).readEnum();
                            DescriptorProtos$FieldOptions$CType descriptorProtos$FieldOptions$CType = DescriptorProtos$FieldOptions$CType.valueOf(n13);
                            if (descriptorProtos$FieldOptions$CType == null) {
                                unknownFieldSet$Builder.mergeVarintField(n12, n13);
                                continue;
                            }
                            n14 = this.bitField0_;
                            this.bitField0_ = n12 |= n14;
                            this.ctype_ = n13;
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
            int n17 = n11 & 0x40;
            if (n17 != 0) {
                this.uninterpretedOption_ = list2 = Collections.unmodifiableList(this.uninterpretedOption_);
            }
            list2 = unknownFieldSet$Builder.build();
            this.unknownFields = list2;
            this.makeExtensionsImmutable();
            throw throwable;
        }
        int n18 = n11 & 0x40;
        if (n18 != 0) {
            this.uninterpretedOption_ = list = Collections.unmodifiableList(this.uninterpretedOption_);
        }
        list = unknownFieldSet$Builder.build();
        this.unknownFields = list;
        this.makeExtensionsImmutable();
    }

    public /* synthetic */ DescriptorProtos$FieldOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private DescriptorProtos$FieldOptions(GeneratedMessageV3$ExtendableBuilder generatedMessageV3$ExtendableBuilder) {
        super(generatedMessageV3$ExtendableBuilder);
    }

    public /* synthetic */ DescriptorProtos$FieldOptions(GeneratedMessageV3$ExtendableBuilder generatedMessageV3$ExtendableBuilder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$ExtendableBuilder);
    }

    public static /* synthetic */ int access$19402(DescriptorProtos$FieldOptions descriptorProtos$FieldOptions, int n10) {
        descriptorProtos$FieldOptions.ctype_ = n10;
        return n10;
    }

    public static /* synthetic */ boolean access$19502(DescriptorProtos$FieldOptions descriptorProtos$FieldOptions, boolean bl2) {
        descriptorProtos$FieldOptions.packed_ = bl2;
        return bl2;
    }

    public static /* synthetic */ int access$19602(DescriptorProtos$FieldOptions descriptorProtos$FieldOptions, int n10) {
        descriptorProtos$FieldOptions.jstype_ = n10;
        return n10;
    }

    public static /* synthetic */ boolean access$19702(DescriptorProtos$FieldOptions descriptorProtos$FieldOptions, boolean bl2) {
        descriptorProtos$FieldOptions.lazy_ = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean access$19802(DescriptorProtos$FieldOptions descriptorProtos$FieldOptions, boolean bl2) {
        descriptorProtos$FieldOptions.deprecated_ = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean access$19902(DescriptorProtos$FieldOptions descriptorProtos$FieldOptions, boolean bl2) {
        descriptorProtos$FieldOptions.weak_ = bl2;
        return bl2;
    }

    public static /* synthetic */ List access$20000(DescriptorProtos$FieldOptions descriptorProtos$FieldOptions) {
        return descriptorProtos$FieldOptions.uninterpretedOption_;
    }

    public static /* synthetic */ List access$20002(DescriptorProtos$FieldOptions descriptorProtos$FieldOptions, List list) {
        descriptorProtos$FieldOptions.uninterpretedOption_ = list;
        return list;
    }

    public static /* synthetic */ int access$20102(DescriptorProtos$FieldOptions descriptorProtos$FieldOptions, int n10) {
        descriptorProtos$FieldOptions.bitField0_ = n10;
        return n10;
    }

    public static DescriptorProtos$FieldOptions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$18900();
    }

    public static DescriptorProtos$FieldOptions$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$FieldOptions$Builder newBuilder(DescriptorProtos$FieldOptions descriptorProtos$FieldOptions) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$FieldOptions);
    }

    public static DescriptorProtos$FieldOptions parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$FieldOptions)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$FieldOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FieldOptions)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$FieldOptions parseFrom(ByteString byteString) {
        return (DescriptorProtos$FieldOptions)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$FieldOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FieldOptions)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$FieldOptions parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$FieldOptions)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static DescriptorProtos$FieldOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FieldOptions)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$FieldOptions parseFrom(InputStream inputStream) {
        return (DescriptorProtos$FieldOptions)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$FieldOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FieldOptions)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$FieldOptions parseFrom(ByteBuffer byteBuffer) {
        return (DescriptorProtos$FieldOptions)PARSER.parseFrom(byteBuffer);
    }

    public static DescriptorProtos$FieldOptions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FieldOptions)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static DescriptorProtos$FieldOptions parseFrom(byte[] byArray) {
        return (DescriptorProtos$FieldOptions)PARSER.parseFrom(byArray);
    }

    public static DescriptorProtos$FieldOptions parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FieldOptions)PARSER.parseFrom(byArray, extensionRegistryLite);
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
        int n11 = object instanceof DescriptorProtos$FieldOptions;
        if (n11 == 0) {
            return super.equals(object);
        }
        object = (DescriptorProtos$FieldOptions)object;
        n11 = this.hasCtype();
        if (n11 != (n10 = ((DescriptorProtos$FieldOptions)object).hasCtype())) {
            return false;
        }
        n11 = this.hasCtype();
        if (n11 != 0 && (n11 = this.ctype_) != (n10 = ((DescriptorProtos$FieldOptions)object).ctype_)) {
            return false;
        }
        n11 = (int)(this.hasPacked() ? 1 : 0);
        if (n11 != (n10 = (int)(((DescriptorProtos$FieldOptions)object).hasPacked() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasPacked() ? 1 : 0);
        if (n11 != 0 && (n11 = (int)(this.getPacked() ? 1 : 0)) != (n10 = (int)(((DescriptorProtos$FieldOptions)object).getPacked() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasJstype() ? 1 : 0);
        if (n11 != (n10 = (int)(((DescriptorProtos$FieldOptions)object).hasJstype() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasJstype() ? 1 : 0);
        if (n11 != 0 && (n11 = this.jstype_) != (n10 = ((DescriptorProtos$FieldOptions)object).jstype_)) {
            return false;
        }
        n11 = (int)(this.hasLazy() ? 1 : 0);
        if (n11 != (n10 = (int)(((DescriptorProtos$FieldOptions)object).hasLazy() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasLazy() ? 1 : 0);
        if (n11 != 0 && (n11 = (int)(this.getLazy() ? 1 : 0)) != (n10 = (int)(((DescriptorProtos$FieldOptions)object).getLazy() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasDeprecated() ? 1 : 0);
        if (n11 != (n10 = (int)(((DescriptorProtos$FieldOptions)object).hasDeprecated() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasDeprecated() ? 1 : 0);
        if (n11 != 0 && (n11 = (int)(this.getDeprecated() ? 1 : 0)) != (n10 = (int)(((DescriptorProtos$FieldOptions)object).getDeprecated() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasWeak() ? 1 : 0);
        if (n11 != (n10 = (int)(((DescriptorProtos$FieldOptions)object).hasWeak() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasWeak() ? 1 : 0);
        if (n11 != 0 && (n11 = (int)(this.getWeak() ? 1 : 0)) != (n10 = (int)(((DescriptorProtos$FieldOptions)object).getWeak() ? 1 : 0))) {
            return false;
        }
        Object object3 = this.getUninterpretedOptionList();
        n11 = (int)(object3.equals(object2 = ((DescriptorProtos$FieldOptions)object).getUninterpretedOptionList()) ? 1 : 0);
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

    public DescriptorProtos$FieldOptions$CType getCtype() {
        int n10 = this.ctype_;
        DescriptorProtos$FieldOptions$CType descriptorProtos$FieldOptions$CType = DescriptorProtos$FieldOptions$CType.valueOf(n10);
        if (descriptorProtos$FieldOptions$CType == null) {
            descriptorProtos$FieldOptions$CType = DescriptorProtos$FieldOptions$CType.STRING;
        }
        return descriptorProtos$FieldOptions$CType;
    }

    public DescriptorProtos$FieldOptions getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public boolean getDeprecated() {
        return this.deprecated_;
    }

    public DescriptorProtos$FieldOptions$JSType getJstype() {
        int n10 = this.jstype_;
        DescriptorProtos$FieldOptions$JSType descriptorProtos$FieldOptions$JSType = DescriptorProtos$FieldOptions$JSType.valueOf(n10);
        if (descriptorProtos$FieldOptions$JSType == null) {
            descriptorProtos$FieldOptions$JSType = DescriptorProtos$FieldOptions$JSType.JS_NORMAL;
        }
        return descriptorProtos$FieldOptions$JSType;
    }

    public boolean getLazy() {
        return this.lazy_;
    }

    public boolean getPacked() {
        return this.packed_;
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
            n10 = this.ctype_;
            n10 = CodedOutputStream.computeEnumSize(n11, n10) + 0;
        } else {
            n10 = 0;
        }
        n11 = this.bitField0_;
        int n13 = 2;
        if ((n11 &= n13) != 0) {
            n11 = (int)(this.packed_ ? 1 : 0);
            n11 = CodedOutputStream.computeBoolSize(n13, n11 != 0);
            n10 += n11;
        }
        if ((n11 = this.bitField0_ & 0x10) != 0) {
            n13 = (int)(this.deprecated_ ? 1 : 0);
            n11 = CodedOutputStream.computeBoolSize(3, n13 != 0);
            n10 += n11;
        }
        if ((n11 = this.bitField0_ & 8) != 0) {
            n13 = this.lazy_;
            n11 = CodedOutputStream.computeBoolSize(5, n13 != 0);
            n10 += n11;
        }
        if ((n11 = this.bitField0_ & 4) != 0) {
            n13 = this.jstype_;
            n11 = CodedOutputStream.computeEnumSize(6, n13);
            n10 += n11;
        }
        if ((n11 = this.bitField0_ & 0x20) != 0) {
            n13 = (int)(this.weak_ ? 1 : 0);
            n11 = CodedOutputStream.computeBoolSize(10, n13 != 0);
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

    public boolean getWeak() {
        return this.weak_;
    }

    public boolean hasCtype() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean hasDeprecated() {
        int n10 = this.bitField0_ & 0x10;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasJstype() {
        int n10 = this.bitField0_ & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasLazy() {
        int n10 = this.bitField0_ & 8;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasPacked() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasWeak() {
        int n10 = this.bitField0_ & 0x20;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = DescriptorProtos$FieldOptions.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasCtype() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            n11 = this.ctype_;
            n10 += n11;
        }
        if ((n11 = (int)(this.hasPacked() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 2) * 53;
            n11 = Internal.hashBoolean(this.getPacked());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasJstype() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 6) * 53;
            n11 = this.jstype_;
            n10 += n11;
        }
        if ((n11 = (int)(this.hasLazy() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 5) * 53;
            n11 = Internal.hashBoolean(this.getLazy());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasDeprecated() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 3) * 53;
            n11 = Internal.hashBoolean(this.getDeprecated());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasWeak() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 10) * 53;
            n11 = Internal.hashBoolean(this.getWeak());
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
        return DescriptorProtos.access$19000().ensureFieldAccessorsInitialized(DescriptorProtos$FieldOptions.class, DescriptorProtos$FieldOptions$Builder.class);
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

    public DescriptorProtos$FieldOptions$Builder newBuilderForType() {
        return DescriptorProtos$FieldOptions.newBuilder();
    }

    public DescriptorProtos$FieldOptions$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        DescriptorProtos$FieldOptions$Builder descriptorProtos$FieldOptions$Builder = new DescriptorProtos$FieldOptions$Builder(generatedMessageV3$BuilderParent, null);
        return descriptorProtos$FieldOptions$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new DescriptorProtos$FieldOptions();
        return object;
    }

    public DescriptorProtos$FieldOptions$Builder toBuilder() {
        DescriptorProtos$FieldOptionsOrBuilder descriptorProtos$FieldOptionsOrBuilder = DEFAULT_INSTANCE;
        if (this == descriptorProtos$FieldOptionsOrBuilder) {
            descriptorProtos$FieldOptionsOrBuilder = new DescriptorProtos$FieldOptions$Builder(null);
        } else {
            descriptorProtos$FieldOptionsOrBuilder = new DescriptorProtos$FieldOptions$Builder(null);
            descriptorProtos$FieldOptionsOrBuilder = ((DescriptorProtos$FieldOptions$Builder)descriptorProtos$FieldOptionsOrBuilder).mergeFrom(this);
        }
        return descriptorProtos$FieldOptionsOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        List list;
        GeneratedMessageV3$ExtendableMessage$ExtensionWriter generatedMessageV3$ExtendableMessage$ExtensionWriter = this.newExtensionWriter();
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) != 0) {
            n10 = this.ctype_;
            codedOutputStream.writeEnum(n11, n10);
        }
        n10 = this.bitField0_;
        n11 = 2;
        if ((n10 &= n11) != 0) {
            n10 = (int)(this.packed_ ? 1 : 0);
            codedOutputStream.writeBool(n11, n10 != 0);
        }
        if ((n10 = this.bitField0_ & 0x10) != 0) {
            n10 = 3;
            n11 = (int)(this.deprecated_ ? 1 : 0);
            codedOutputStream.writeBool(n10, n11 != 0);
        }
        if ((n10 = this.bitField0_ & 8) != 0) {
            n10 = 5;
            n11 = this.lazy_;
            codedOutputStream.writeBool(n10, n11 != 0);
        }
        if ((n10 = this.bitField0_ & 4) != 0) {
            n10 = 6;
            n11 = this.jstype_;
            codedOutputStream.writeEnum(n10, n11);
        }
        if ((n10 = this.bitField0_ & 0x20) != 0) {
            n10 = 10;
            n11 = (int)(this.weak_ ? 1 : 0);
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

