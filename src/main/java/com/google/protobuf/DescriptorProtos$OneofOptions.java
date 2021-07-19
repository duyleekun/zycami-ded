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
import com.google.protobuf.DescriptorProtos$OneofOptions$1;
import com.google.protobuf.DescriptorProtos$OneofOptions$Builder;
import com.google.protobuf.DescriptorProtos$OneofOptionsOrBuilder;
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

public final class DescriptorProtos$OneofOptions
extends GeneratedMessageV3$ExtendableMessage
implements DescriptorProtos$OneofOptionsOrBuilder {
    private static final DescriptorProtos$OneofOptions DEFAULT_INSTANCE;
    public static final Parser PARSER;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private static final long serialVersionUID;
    private byte memoizedIsInitialized;
    private List uninterpretedOption_;

    static {
        Object object = new DescriptorProtos$OneofOptions();
        DEFAULT_INSTANCE = object;
        PARSER = object = new DescriptorProtos$OneofOptions$1();
    }

    private DescriptorProtos$OneofOptions() {
        List list;
        this.memoizedIsInitialized = (byte)-1;
        this.uninterpretedOption_ = list = Collections.emptyList();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private DescriptorProtos$OneofOptions(CodedInputStream list, ExtensionRegistryLite list2) {
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
                            int n12 = 7994;
                            if (n11 != n12) {
                                if ((n11 = (int)(this.parseUnknownField((CodedInputStream)((Object)list), unknownFieldSet$Builder, (ExtensionRegistryLite)((Object)list2), n11) ? 1 : 0)) != 0) continue;
                            } else {
                                List<Object> list3;
                                n11 = n10 & 1;
                                if (n11 == 0) {
                                    this.uninterpretedOption_ = list3 = new List<Object>();
                                    n10 |= 1;
                                }
                                list3 = this.uninterpretedOption_;
                                Object object = DescriptorProtos$UninterpretedOption.PARSER;
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
                this.uninterpretedOption_ = list2 = Collections.unmodifiableList(this.uninterpretedOption_);
            }
            list2 = unknownFieldSet$Builder.build();
            this.unknownFields = list2;
            this.makeExtensionsImmutable();
            throw throwable2;
        }
        boolean bl5 = n10 & true;
        if (bl5) {
            this.uninterpretedOption_ = list = Collections.unmodifiableList(this.uninterpretedOption_);
        }
        list = unknownFieldSet$Builder.build();
        this.unknownFields = list;
        this.makeExtensionsImmutable();
    }

    public /* synthetic */ DescriptorProtos$OneofOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private DescriptorProtos$OneofOptions(GeneratedMessageV3$ExtendableBuilder generatedMessageV3$ExtendableBuilder) {
        super(generatedMessageV3$ExtendableBuilder);
        this.memoizedIsInitialized = (byte)-1;
    }

    public /* synthetic */ DescriptorProtos$OneofOptions(GeneratedMessageV3$ExtendableBuilder generatedMessageV3$ExtendableBuilder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$ExtendableBuilder);
    }

    public static /* synthetic */ List access$20800(DescriptorProtos$OneofOptions descriptorProtos$OneofOptions) {
        return descriptorProtos$OneofOptions.uninterpretedOption_;
    }

    public static /* synthetic */ List access$20802(DescriptorProtos$OneofOptions descriptorProtos$OneofOptions, List list) {
        descriptorProtos$OneofOptions.uninterpretedOption_ = list;
        return list;
    }

    public static DescriptorProtos$OneofOptions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$20300();
    }

    public static DescriptorProtos$OneofOptions$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$OneofOptions$Builder newBuilder(DescriptorProtos$OneofOptions descriptorProtos$OneofOptions) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$OneofOptions);
    }

    public static DescriptorProtos$OneofOptions parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$OneofOptions)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$OneofOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$OneofOptions)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$OneofOptions parseFrom(ByteString byteString) {
        return (DescriptorProtos$OneofOptions)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$OneofOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$OneofOptions)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$OneofOptions parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$OneofOptions)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static DescriptorProtos$OneofOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$OneofOptions)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$OneofOptions parseFrom(InputStream inputStream) {
        return (DescriptorProtos$OneofOptions)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$OneofOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$OneofOptions)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$OneofOptions parseFrom(ByteBuffer byteBuffer) {
        return (DescriptorProtos$OneofOptions)PARSER.parseFrom(byteBuffer);
    }

    public static DescriptorProtos$OneofOptions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$OneofOptions)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static DescriptorProtos$OneofOptions parseFrom(byte[] byArray) {
        return (DescriptorProtos$OneofOptions)PARSER.parseFrom(byArray);
    }

    public static DescriptorProtos$OneofOptions parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$OneofOptions)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof DescriptorProtos$OneofOptions;
        if (!bl3) {
            return super.equals(object);
        }
        object = (DescriptorProtos$OneofOptions)object;
        Object object2 = this.getUninterpretedOptionList();
        List list = ((DescriptorProtos$OneofOptions)object).getUninterpretedOptionList();
        bl3 = object2.equals(list);
        list = null;
        if (!bl3) {
            return false;
        }
        object2 = this.unknownFields;
        UnknownFieldSet unknownFieldSet = ((GeneratedMessageV3)object).unknownFields;
        bl3 = ((UnknownFieldSet)object2).equals(unknownFieldSet);
        if (!bl3) {
            return false;
        }
        object2 = this.getExtensionFields();
        boolean bl4 = object2.equals(object = ((GeneratedMessageV3$ExtendableMessage)object).getExtensionFields());
        if (!bl4) {
            return false;
        }
        return bl2;
    }

    public DescriptorProtos$OneofOptions getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
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
        n12 = 0;
        for (n11 = 0; n11 < (n10 = (list = this.uninterpretedOption_).size()); ++n11) {
            MessageLite messageLite = (MessageLite)this.uninterpretedOption_.get(n11);
            n10 = CodedOutputStream.computeMessageSize(999, messageLite);
            n12 += n10;
        }
        n11 = this.extensionsSerializedSize();
        n12 += n11;
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n12 += n11;
        return n12;
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

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = DescriptorProtos$OneofOptions.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = this.getUninterpretedOptionCount();
        if (n11 > 0) {
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
        return DescriptorProtos.access$20400().ensureFieldAccessorsInitialized(DescriptorProtos$OneofOptions.class, DescriptorProtos$OneofOptions$Builder.class);
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

    public DescriptorProtos$OneofOptions$Builder newBuilderForType() {
        return DescriptorProtos$OneofOptions.newBuilder();
    }

    public DescriptorProtos$OneofOptions$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        DescriptorProtos$OneofOptions$Builder descriptorProtos$OneofOptions$Builder = new DescriptorProtos$OneofOptions$Builder(generatedMessageV3$BuilderParent, null);
        return descriptorProtos$OneofOptions$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new DescriptorProtos$OneofOptions();
        return object;
    }

    public DescriptorProtos$OneofOptions$Builder toBuilder() {
        DescriptorProtos$OneofOptionsOrBuilder descriptorProtos$OneofOptionsOrBuilder = DEFAULT_INSTANCE;
        if (this == descriptorProtos$OneofOptionsOrBuilder) {
            descriptorProtos$OneofOptionsOrBuilder = new DescriptorProtos$OneofOptions$Builder(null);
        } else {
            descriptorProtos$OneofOptionsOrBuilder = new DescriptorProtos$OneofOptions$Builder(null);
            descriptorProtos$OneofOptionsOrBuilder = ((DescriptorProtos$OneofOptions$Builder)descriptorProtos$OneofOptionsOrBuilder).mergeFrom(this);
        }
        return descriptorProtos$OneofOptionsOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        List list;
        int n10;
        GeneratedMessageV3$ExtendableMessage$ExtensionWriter generatedMessageV3$ExtendableMessage$ExtensionWriter = this.newExtensionWriter();
        for (int i10 = 0; i10 < (n10 = (list = this.uninterpretedOption_).size()); ++i10) {
            n10 = 999;
            MessageLite messageLite = (MessageLite)this.uninterpretedOption_.get(i10);
            codedOutputStream.writeMessage(n10, messageLite);
        }
        generatedMessageV3$ExtendableMessage$ExtensionWriter.writeUntil(0x20000000, codedOutputStream);
        this.unknownFields.writeTo(codedOutputStream);
    }
}

