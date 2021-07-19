/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto$1;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto$EnumReservedRange;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumOptions;
import com.google.protobuf.DescriptorProtos$EnumOptions$Builder;
import com.google.protobuf.DescriptorProtos$EnumOptionsOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProto;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProtoOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.GeneratedMessageV3$UnusedPrivateParameter;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class DescriptorProtos$EnumDescriptorProto
extends GeneratedMessageV3
implements DescriptorProtos$EnumDescriptorProtoOrBuilder {
    private static final DescriptorProtos$EnumDescriptorProto DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    public static final Parser PARSER;
    public static final int RESERVED_NAME_FIELD_NUMBER = 5;
    public static final int RESERVED_RANGE_FIELD_NUMBER = 4;
    public static final int VALUE_FIELD_NUMBER = 2;
    private static final long serialVersionUID;
    private int bitField0_;
    private byte memoizedIsInitialized = (byte)-1;
    private volatile Object name_;
    private DescriptorProtos$EnumOptions options_;
    private LazyStringList reservedName_;
    private List reservedRange_;
    private List value_;

    static {
        Object object = new DescriptorProtos$EnumDescriptorProto();
        DEFAULT_INSTANCE = object;
        PARSER = object = new DescriptorProtos$EnumDescriptorProto$1();
    }

    private DescriptorProtos$EnumDescriptorProto() {
        LazyStringList lazyStringList;
        this.name_ = "";
        this.value_ = lazyStringList = Collections.emptyList();
        this.reservedRange_ = lazyStringList = Collections.emptyList();
        this.reservedName_ = lazyStringList = LazyStringArrayList.EMPTY;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private DescriptorProtos$EnumDescriptorProto(CodedInputStream object, ExtensionRegistryLite object2) {
        this();
        Objects.requireNonNull(object2);
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        int n10 = 0;
        int n11 = 0;
        while (n10 == 0) {
            try {
                try {
                    int n12;
                    block24: {
                        int n13 = ((CodedInputStream)object).readTag();
                        n12 = 1;
                        if (n13 != 0) {
                            Object object3;
                            int n14 = 10;
                            if (n13 != n14) {
                                Object object4;
                                n14 = 18;
                                if (n13 != n14) {
                                    n14 = 26;
                                    if (n13 != n14) {
                                        n14 = 34;
                                        if (n13 != n14) {
                                            n14 = 42;
                                            if (n13 != n14) {
                                                if ((n13 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n13) ? 1 : 0)) != 0) continue;
                                                break block24;
                                            } else {
                                                object3 = ((CodedInputStream)object).readBytes();
                                                n12 = n11 & 0x10;
                                                if (n12 == 0) {
                                                    this.reservedName_ = object4 = new LazyStringArrayList();
                                                    n11 |= 0x10;
                                                }
                                                object4 = this.reservedName_;
                                                object4.add((ByteString)object3);
                                                continue;
                                            }
                                        }
                                        n13 = n11 & 8;
                                        if (n13 == 0) {
                                            this.reservedRange_ = object3;
                                            n11 |= 8;
                                        }
                                        object3 = this.reservedRange_;
                                        object4 = DescriptorProtos$EnumDescriptorProto$EnumReservedRange.PARSER;
                                        object4 = ((CodedInputStream)object).readMessage((Parser)object4, (ExtensionRegistryLite)object2);
                                        object3.add(object4);
                                        continue;
                                    }
                                    n13 = 0;
                                    object3 = null;
                                    n12 = this.bitField0_ & 2;
                                    if (n12 != 0) {
                                        object3 = this.options_;
                                        object3 = ((DescriptorProtos$EnumOptions)object3).toBuilder();
                                    }
                                    object4 = DescriptorProtos$EnumOptions.PARSER;
                                    object4 = ((CodedInputStream)object).readMessage((Parser)object4, (ExtensionRegistryLite)object2);
                                    this.options_ = object4 = (DescriptorProtos$EnumOptions)object4;
                                    if (object3 != null) {
                                        ((DescriptorProtos$EnumOptions$Builder)object3).mergeFrom((DescriptorProtos$EnumOptions)object4);
                                        this.options_ = object3 = ((DescriptorProtos$EnumOptions$Builder)object3).buildPartial();
                                    }
                                    this.bitField0_ = n13 = this.bitField0_ | 2;
                                    continue;
                                }
                                n13 = n11 & 2;
                                if (n13 == 0) {
                                    this.value_ = object3;
                                    n11 |= 2;
                                }
                                object3 = this.value_;
                                object4 = DescriptorProtos$EnumValueDescriptorProto.PARSER;
                                object4 = ((CodedInputStream)object).readMessage((Parser)object4, (ExtensionRegistryLite)object2);
                                object3.add(object4);
                                continue;
                            }
                            object3 = ((CodedInputStream)object).readBytes();
                            n14 = this.bitField0_;
                            this.bitField0_ = n12 |= n14;
                            this.name_ = object3;
                            continue;
                        }
                    }
                    n10 = n12;
                    continue;
                }
                catch (IOException iOException) {
                    object2 = new InvalidProtocolBufferException(iOException);
                    InvalidProtocolBufferException invalidProtocolBufferException = ((InvalidProtocolBufferException)object2).setUnfinishedMessage(this);
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
                object2 = Collections.unmodifiableList(this.value_);
                this.value_ = object2;
            }
            if ((n15 = n11 & 8) != 0) {
                object2 = Collections.unmodifiableList(this.reservedRange_);
                this.reservedRange_ = object2;
            }
            if ((n15 = n11 & 0x10) != 0) {
                this.reservedName_ = object2 = this.reservedName_.getUnmodifiableView();
            }
            this.unknownFields = object2 = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
            throw throwable;
        }
        int n16 = n11 & 2;
        if (n16 != 0) {
            this.value_ = object = Collections.unmodifiableList(this.value_);
        }
        if ((n16 = n11 & 8) != 0) {
            object = Collections.unmodifiableList(this.reservedRange_);
            this.reservedRange_ = object;
        }
        if ((n16 = n11 & 0x10) != 0) {
            this.reservedName_ = object = this.reservedName_.getUnmodifiableView();
        }
        this.unknownFields = object = unknownFieldSet$Builder.build();
        this.makeExtensionsImmutable();
    }

    public /* synthetic */ DescriptorProtos$EnumDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private DescriptorProtos$EnumDescriptorProto(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ DescriptorProtos$EnumDescriptorProto(GeneratedMessageV3$Builder generatedMessageV3$Builder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ Object access$10900(DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto) {
        return descriptorProtos$EnumDescriptorProto.name_;
    }

    public static /* synthetic */ Object access$10902(DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto, Object object) {
        descriptorProtos$EnumDescriptorProto.name_ = object;
        return object;
    }

    public static /* synthetic */ List access$11000(DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto) {
        return descriptorProtos$EnumDescriptorProto.value_;
    }

    public static /* synthetic */ List access$11002(DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto, List list) {
        descriptorProtos$EnumDescriptorProto.value_ = list;
        return list;
    }

    public static /* synthetic */ DescriptorProtos$EnumOptions access$11102(DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto, DescriptorProtos$EnumOptions descriptorProtos$EnumOptions) {
        descriptorProtos$EnumDescriptorProto.options_ = descriptorProtos$EnumOptions;
        return descriptorProtos$EnumOptions;
    }

    public static /* synthetic */ List access$11200(DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto) {
        return descriptorProtos$EnumDescriptorProto.reservedRange_;
    }

    public static /* synthetic */ List access$11202(DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto, List list) {
        descriptorProtos$EnumDescriptorProto.reservedRange_ = list;
        return list;
    }

    public static /* synthetic */ LazyStringList access$11300(DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto) {
        return descriptorProtos$EnumDescriptorProto.reservedName_;
    }

    public static /* synthetic */ LazyStringList access$11302(DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto, LazyStringList lazyStringList) {
        descriptorProtos$EnumDescriptorProto.reservedName_ = lazyStringList;
        return lazyStringList;
    }

    public static /* synthetic */ int access$11402(DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto, int n10) {
        descriptorProtos$EnumDescriptorProto.bitField0_ = n10;
        return n10;
    }

    public static DescriptorProtos$EnumDescriptorProto getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$9500();
    }

    public static DescriptorProtos$EnumDescriptorProto$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$EnumDescriptorProto$Builder newBuilder(DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$EnumDescriptorProto);
    }

    public static DescriptorProtos$EnumDescriptorProto parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$EnumDescriptorProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$EnumDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumDescriptorProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumDescriptorProto parseFrom(ByteString byteString) {
        return (DescriptorProtos$EnumDescriptorProto)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$EnumDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumDescriptorProto)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumDescriptorProto parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$EnumDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static DescriptorProtos$EnumDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumDescriptorProto parseFrom(InputStream inputStream) {
        return (DescriptorProtos$EnumDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$EnumDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumDescriptorProto parseFrom(ByteBuffer byteBuffer) {
        return (DescriptorProtos$EnumDescriptorProto)PARSER.parseFrom(byteBuffer);
    }

    public static DescriptorProtos$EnumDescriptorProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumDescriptorProto)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumDescriptorProto parseFrom(byte[] byArray) {
        return (DescriptorProtos$EnumDescriptorProto)PARSER.parseFrom(byArray);
    }

    public static DescriptorProtos$EnumDescriptorProto parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumDescriptorProto)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2;
        boolean bl3 = true;
        if (object == this) {
            return bl3;
        }
        boolean bl4 = object instanceof DescriptorProtos$EnumDescriptorProto;
        if (!bl4) {
            return super.equals(object);
        }
        object = (DescriptorProtos$EnumDescriptorProto)object;
        bl4 = this.hasName();
        if (bl4 != (bl2 = ((DescriptorProtos$EnumDescriptorProto)object).hasName())) {
            return false;
        }
        bl4 = this.hasName();
        if (bl4 && !(bl4 = ((String)(object3 = this.getName())).equals(object2 = ((DescriptorProtos$EnumDescriptorProto)object).getName()))) {
            return false;
        }
        object3 = this.getValueList();
        bl4 = object3.equals(object2 = ((DescriptorProtos$EnumDescriptorProto)object).getValueList());
        if (!bl4) {
            return false;
        }
        bl4 = this.hasOptions();
        if (bl4 != (bl2 = ((DescriptorProtos$EnumDescriptorProto)object).hasOptions())) {
            return false;
        }
        bl4 = this.hasOptions();
        if (bl4 && !(bl4 = ((DescriptorProtos$EnumOptions)(object3 = this.getOptions())).equals(object2 = ((DescriptorProtos$EnumDescriptorProto)object).getOptions()))) {
            return false;
        }
        object3 = this.getReservedRangeList();
        bl4 = object3.equals(object2 = ((DescriptorProtos$EnumDescriptorProto)object).getReservedRangeList());
        if (!bl4) {
            return false;
        }
        object3 = this.getReservedNameList();
        bl4 = object3.equals(object2 = ((DescriptorProtos$EnumDescriptorProto)object).getReservedNameList());
        if (!bl4) {
            return false;
        }
        object3 = this.unknownFields;
        object = ((GeneratedMessageV3)object).unknownFields;
        boolean bl5 = ((UnknownFieldSet)object3).equals(object);
        if (!bl5) {
            return false;
        }
        return bl3;
    }

    public DescriptorProtos$EnumDescriptorProto getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public String getName() {
        Object object = this.name_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.name_ = string2;
        }
        return string2;
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

    public DescriptorProtos$EnumOptions getOptions() {
        DescriptorProtos$EnumOptions descriptorProtos$EnumOptions = this.options_;
        if (descriptorProtos$EnumOptions == null) {
            descriptorProtos$EnumOptions = DescriptorProtos$EnumOptions.getDefaultInstance();
        }
        return descriptorProtos$EnumOptions;
    }

    public DescriptorProtos$EnumOptionsOrBuilder getOptionsOrBuilder() {
        DescriptorProtos$EnumOptions descriptorProtos$EnumOptions = this.options_;
        if (descriptorProtos$EnumOptions == null) {
            descriptorProtos$EnumOptions = DescriptorProtos$EnumOptions.getDefaultInstance();
        }
        return descriptorProtos$EnumOptions;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public String getReservedName(int n10) {
        return (String)this.reservedName_.get(n10);
    }

    public ByteString getReservedNameBytes(int n10) {
        return this.reservedName_.getByteString(n10);
    }

    public int getReservedNameCount() {
        return this.reservedName_.size();
    }

    public ProtocolStringList getReservedNameList() {
        return this.reservedName_;
    }

    public DescriptorProtos$EnumDescriptorProto$EnumReservedRange getReservedRange(int n10) {
        return (DescriptorProtos$EnumDescriptorProto$EnumReservedRange)this.reservedRange_.get(n10);
    }

    public int getReservedRangeCount() {
        return this.reservedRange_.size();
    }

    public List getReservedRangeList() {
        return this.reservedRange_;
    }

    public DescriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder getReservedRangeOrBuilder(int n10) {
        return (DescriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder)this.reservedRange_.get(n10);
    }

    public List getReservedRangeOrBuilderList() {
        return this.reservedRange_;
    }

    public int getSerializedSize() {
        int n10;
        int n11;
        Object object;
        Object object2;
        int n12 = this.memoizedSize;
        int n13 = -1;
        if (n12 != n13) {
            return n12;
        }
        n12 = this.bitField0_;
        n13 = 1;
        int n14 = 0;
        if ((n12 &= n13) != 0) {
            object2 = this.name_;
            n12 = GeneratedMessageV3.computeStringSize(n13, object2) + 0;
        } else {
            n12 = 0;
            object2 = null;
        }
        int n15 = 0;
        while (true) {
            object = this.value_;
            n11 = object.size();
            n10 = 2;
            if (n15 >= n11) break;
            object = (MessageLite)this.value_.get(n15);
            n11 = CodedOutputStream.computeMessageSize(n10, (MessageLite)object);
            n12 += n11;
            ++n15;
        }
        n15 = this.bitField0_ & n10;
        if (n15 != 0) {
            object = this.getOptions();
            n15 = CodedOutputStream.computeMessageSize(3, (MessageLite)object);
            n12 += n15;
        }
        for (n15 = 0; n15 < (n11 = (object = this.reservedRange_).size()); ++n15) {
            MessageLite messageLite = (MessageLite)this.reservedRange_.get(n15);
            n11 = CodedOutputStream.computeMessageSize(4, messageLite);
            n12 += n11;
        }
        n15 = 0;
        while (n14 < (n11 = (object = this.reservedName_).size())) {
            object = this.reservedName_.getRaw(n14);
            n11 = GeneratedMessageV3.computeStringSizeNoTag(object);
            n15 += n11;
            ++n14;
        }
        n12 += n15;
        n14 = this.getReservedNameList().size() * n13;
        n12 += n14;
        n13 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n12 += n13;
        return n12;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public DescriptorProtos$EnumValueDescriptorProto getValue(int n10) {
        return (DescriptorProtos$EnumValueDescriptorProto)this.value_.get(n10);
    }

    public int getValueCount() {
        return this.value_.size();
    }

    public List getValueList() {
        return this.value_;
    }

    public DescriptorProtos$EnumValueDescriptorProtoOrBuilder getValueOrBuilder(int n10) {
        return (DescriptorProtos$EnumValueDescriptorProtoOrBuilder)this.value_.get(n10);
    }

    public List getValueOrBuilderList() {
        return this.value_;
    }

    public boolean hasName() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean hasOptions() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = DescriptorProtos$EnumDescriptorProto.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasName() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getName();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = this.getValueCount()) > 0) {
            n10 = (n10 * 37 + 2) * 53;
            object = this.getValueList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasOptions() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 3) * 53;
            object = this.getOptions();
            n11 = ((DescriptorProtos$EnumOptions)object).hashCode();
            n10 += n11;
        }
        if ((n11 = this.getReservedRangeCount()) > 0) {
            n10 = (n10 * 37 + 4) * 53;
            object = this.getReservedRangeList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = this.getReservedNameCount()) > 0) {
            n10 = (n10 * 37 + 5) * 53;
            object = this.getReservedNameList();
            n11 = object.hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$9600().ensureFieldAccessorsInitialized(DescriptorProtos$EnumDescriptorProto.class, DescriptorProtos$EnumDescriptorProto$Builder.class);
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
        DescriptorProtos$EnumOptions descriptorProtos$EnumOptions = null;
        for (n11 = 0; n11 < (n10 = this.getValueCount()); ++n11) {
            DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto = this.getValue(n11);
            n10 = (int)(descriptorProtos$EnumValueDescriptorProto.isInitialized() ? 1 : 0);
            if (n10 != 0) continue;
            this.memoizedIsInitialized = 0;
            return false;
        }
        n11 = (int)(this.hasOptions() ? 1 : 0);
        if (n11 != 0 && (n11 = (descriptorProtos$EnumOptions = this.getOptions()).isInitialized()) == 0) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = (byte)n12;
        return n12 != 0;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder newBuilderForType() {
        return DescriptorProtos$EnumDescriptorProto.newBuilder();
    }

    public DescriptorProtos$EnumDescriptorProto$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        DescriptorProtos$EnumDescriptorProto$Builder descriptorProtos$EnumDescriptorProto$Builder = new DescriptorProtos$EnumDescriptorProto$Builder(generatedMessageV3$BuilderParent, null);
        return descriptorProtos$EnumDescriptorProto$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new DescriptorProtos$EnumDescriptorProto();
        return object;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder toBuilder() {
        DescriptorProtos$EnumDescriptorProtoOrBuilder descriptorProtos$EnumDescriptorProtoOrBuilder = DEFAULT_INSTANCE;
        if (this == descriptorProtos$EnumDescriptorProtoOrBuilder) {
            descriptorProtos$EnumDescriptorProtoOrBuilder = new DescriptorProtos$EnumDescriptorProto$Builder(null);
        } else {
            descriptorProtos$EnumDescriptorProtoOrBuilder = new DescriptorProtos$EnumDescriptorProto$Builder(null);
            descriptorProtos$EnumDescriptorProtoOrBuilder = ((DescriptorProtos$EnumDescriptorProto$Builder)descriptorProtos$EnumDescriptorProtoOrBuilder).mergeFrom(this);
        }
        return descriptorProtos$EnumDescriptorProtoOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        int n10;
        int n11;
        Object object;
        Object object2;
        int n12 = this.bitField0_;
        int n13 = 1;
        if ((n12 &= n13) != 0) {
            object2 = this.name_;
            GeneratedMessageV3.writeString(codedOutputStream, n13, object2);
        }
        n12 = 0;
        object2 = null;
        n13 = 0;
        LazyStringList lazyStringList = null;
        while (true) {
            object = this.value_;
            n11 = object.size();
            n10 = 2;
            if (n13 >= n11) break;
            object = (MessageLite)this.value_.get(n13);
            codedOutputStream.writeMessage(n10, (MessageLite)object);
            ++n13;
        }
        n13 = this.bitField0_ & n10;
        if (n13 != 0) {
            n13 = 3;
            object = this.getOptions();
            codedOutputStream.writeMessage(n13, (MessageLite)object);
        }
        lazyStringList = null;
        for (n13 = 0; n13 < (n11 = (object = this.reservedRange_).size()); ++n13) {
            n11 = 4;
            MessageLite messageLite = (MessageLite)this.reservedRange_.get(n13);
            codedOutputStream.writeMessage(n11, messageLite);
        }
        while (n12 < (n13 = (lazyStringList = this.reservedName_).size())) {
            n13 = 5;
            object = this.reservedName_.getRaw(n12);
            GeneratedMessageV3.writeString(codedOutputStream, n13, object);
            ++n12;
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

