/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$1;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$Builder;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePart;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePartOrBuilder;
import com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
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
import java.util.Objects;

public final class DescriptorProtos$UninterpretedOption
extends GeneratedMessageV3
implements DescriptorProtos$UninterpretedOptionOrBuilder {
    public static final int AGGREGATE_VALUE_FIELD_NUMBER = 8;
    private static final DescriptorProtos$UninterpretedOption DEFAULT_INSTANCE;
    public static final int DOUBLE_VALUE_FIELD_NUMBER = 6;
    public static final int IDENTIFIER_VALUE_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 2;
    public static final int NEGATIVE_INT_VALUE_FIELD_NUMBER = 5;
    public static final Parser PARSER;
    public static final int POSITIVE_INT_VALUE_FIELD_NUMBER = 4;
    public static final int STRING_VALUE_FIELD_NUMBER = 7;
    private static final long serialVersionUID;
    private volatile Object aggregateValue_;
    private int bitField0_;
    private double doubleValue_;
    private volatile Object identifierValue_;
    private byte memoizedIsInitialized;
    private List name_;
    private long negativeIntValue_;
    private long positiveIntValue_;
    private ByteString stringValue_;

    static {
        Object object = new DescriptorProtos$UninterpretedOption();
        DEFAULT_INSTANCE = object;
        PARSER = object = new DescriptorProtos$UninterpretedOption$1();
    }

    private DescriptorProtos$UninterpretedOption() {
        ByteString byteString;
        this.memoizedIsInitialized = (byte)-1;
        Object object = Collections.emptyList();
        this.name_ = object;
        this.identifierValue_ = object = "";
        this.stringValue_ = byteString = ByteString.EMPTY;
        this.aggregateValue_ = object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private DescriptorProtos$UninterpretedOption(CodedInputStream list, ExtensionRegistryLite list2) {
        int n10;
        UnknownFieldSet$Builder unknownFieldSet$Builder;
        block18: {
            Throwable throwable2;
            this();
            Objects.requireNonNull(list2);
            unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
            int n11 = 0;
            n10 = 0;
            while (true) {
                int n12 = 1;
                if (n11 != 0) break block18;
                try {
                    try {
                        block19: {
                            int n13 = ((CodedInputStream)((Object)list)).readTag();
                            if (n13 != 0) {
                                Iterable iterable;
                                int n14 = 18;
                                if (n13 != n14) {
                                    n14 = 26;
                                    if (n13 != n14) {
                                        long l10;
                                        n14 = 32;
                                        if (n13 != n14) {
                                            int n15 = 40;
                                            if (n13 != n15) {
                                                double d10;
                                                n15 = 49;
                                                if (n13 != n15) {
                                                    n15 = 58;
                                                    if (n13 != n15) {
                                                        n15 = 66;
                                                        if (n13 != n15) {
                                                            if ((n13 = (int)(this.parseUnknownField((CodedInputStream)((Object)list), unknownFieldSet$Builder, (ExtensionRegistryLite)((Object)list2), n13) ? 1 : 0)) != 0) continue;
                                                            break block19;
                                                        } else {
                                                            iterable = ((CodedInputStream)((Object)list)).readBytes();
                                                            n15 = this.bitField0_;
                                                            this.bitField0_ = n14 |= n15;
                                                            this.aggregateValue_ = iterable;
                                                            continue;
                                                        }
                                                    }
                                                    this.bitField0_ = n13 = this.bitField0_ | 0x10;
                                                    iterable = ((CodedInputStream)((Object)list)).readBytes();
                                                    this.stringValue_ = iterable;
                                                    continue;
                                                }
                                                this.bitField0_ = n13 = this.bitField0_ | 8;
                                                this.doubleValue_ = d10 = ((CodedInputStream)((Object)list)).readDouble();
                                                continue;
                                            }
                                            this.bitField0_ = n13 = this.bitField0_ | 4;
                                            this.negativeIntValue_ = l10 = ((CodedInputStream)((Object)list)).readInt64();
                                            continue;
                                        }
                                        this.bitField0_ = n13 = this.bitField0_ | 2;
                                        this.positiveIntValue_ = l10 = ((CodedInputStream)((Object)list)).readUInt64();
                                        continue;
                                    }
                                    iterable = ((CodedInputStream)((Object)list)).readBytes();
                                    this.bitField0_ = n14 = this.bitField0_ | n12;
                                    this.identifierValue_ = iterable;
                                    continue;
                                }
                                n13 = n10 & 1;
                                if (n13 == 0) {
                                    this.name_ = iterable;
                                    n10 |= 1;
                                }
                                iterable = this.name_;
                                Object object = DescriptorProtos$UninterpretedOption$NamePart.PARSER;
                                object = ((CodedInputStream)((Object)list)).readMessage((Parser)object, (ExtensionRegistryLite)((Object)list2));
                                iterable.add(object);
                                continue;
                            }
                        }
                        n11 = n12;
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
            boolean bl2 = n10 & true;
            if (bl2) {
                this.name_ = list2 = Collections.unmodifiableList(this.name_);
            }
            list2 = unknownFieldSet$Builder.build();
            this.unknownFields = list2;
            this.makeExtensionsImmutable();
            throw throwable2;
        }
        boolean bl3 = n10 & true;
        if (bl3) {
            this.name_ = list = Collections.unmodifiableList(this.name_);
        }
        list = unknownFieldSet$Builder.build();
        this.unknownFields = list;
        this.makeExtensionsImmutable();
    }

    public /* synthetic */ DescriptorProtos$UninterpretedOption(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private DescriptorProtos$UninterpretedOption(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
        this.memoizedIsInitialized = (byte)-1;
    }

    public /* synthetic */ DescriptorProtos$UninterpretedOption(GeneratedMessageV3$Builder generatedMessageV3$Builder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ List access$26200(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
        return descriptorProtos$UninterpretedOption.name_;
    }

    public static /* synthetic */ List access$26202(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption, List list) {
        descriptorProtos$UninterpretedOption.name_ = list;
        return list;
    }

    public static /* synthetic */ Object access$26300(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
        return descriptorProtos$UninterpretedOption.identifierValue_;
    }

    public static /* synthetic */ Object access$26302(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption, Object object) {
        descriptorProtos$UninterpretedOption.identifierValue_ = object;
        return object;
    }

    public static /* synthetic */ long access$26402(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption, long l10) {
        descriptorProtos$UninterpretedOption.positiveIntValue_ = l10;
        return l10;
    }

    public static /* synthetic */ long access$26502(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption, long l10) {
        descriptorProtos$UninterpretedOption.negativeIntValue_ = l10;
        return l10;
    }

    public static /* synthetic */ double access$26602(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption, double d10) {
        descriptorProtos$UninterpretedOption.doubleValue_ = d10;
        return d10;
    }

    public static /* synthetic */ ByteString access$26702(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption, ByteString byteString) {
        descriptorProtos$UninterpretedOption.stringValue_ = byteString;
        return byteString;
    }

    public static /* synthetic */ Object access$26800(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
        return descriptorProtos$UninterpretedOption.aggregateValue_;
    }

    public static /* synthetic */ Object access$26802(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption, Object object) {
        descriptorProtos$UninterpretedOption.aggregateValue_ = object;
        return object;
    }

    public static /* synthetic */ int access$26902(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption, int n10) {
        descriptorProtos$UninterpretedOption.bitField0_ = n10;
        return n10;
    }

    public static DescriptorProtos$UninterpretedOption getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$24800();
    }

    public static DescriptorProtos$UninterpretedOption$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$UninterpretedOption$Builder newBuilder(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$UninterpretedOption);
    }

    public static DescriptorProtos$UninterpretedOption parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$UninterpretedOption)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$UninterpretedOption parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$UninterpretedOption)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$UninterpretedOption parseFrom(ByteString byteString) {
        return (DescriptorProtos$UninterpretedOption)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$UninterpretedOption parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$UninterpretedOption)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$UninterpretedOption parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$UninterpretedOption)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static DescriptorProtos$UninterpretedOption parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$UninterpretedOption)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$UninterpretedOption parseFrom(InputStream inputStream) {
        return (DescriptorProtos$UninterpretedOption)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$UninterpretedOption parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$UninterpretedOption)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$UninterpretedOption parseFrom(ByteBuffer byteBuffer) {
        return (DescriptorProtos$UninterpretedOption)PARSER.parseFrom(byteBuffer);
    }

    public static DescriptorProtos$UninterpretedOption parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$UninterpretedOption)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static DescriptorProtos$UninterpretedOption parseFrom(byte[] byArray) {
        return (DescriptorProtos$UninterpretedOption)PARSER.parseFrom(byArray);
    }

    public static DescriptorProtos$UninterpretedOption parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$UninterpretedOption)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        double d10;
        double d11;
        long l10;
        long l11;
        long l12;
        long l13;
        long l14;
        Object object2;
        boolean bl2;
        boolean bl3 = true;
        if (object == this) {
            return bl3;
        }
        boolean bl4 = object instanceof DescriptorProtos$UninterpretedOption;
        if (!bl4) {
            return super.equals(object);
        }
        object = (DescriptorProtos$UninterpretedOption)object;
        Object object3 = this.getNameList();
        List list = ((DescriptorProtos$UninterpretedOption)object).getNameList();
        bl4 = object3.equals(list);
        list = null;
        if (!bl4) {
            return false;
        }
        bl4 = this.hasIdentifierValue();
        if (bl4 != (bl2 = ((DescriptorProtos$UninterpretedOption)object).hasIdentifierValue())) {
            return false;
        }
        bl4 = this.hasIdentifierValue();
        if (bl4 && !(bl4 = ((String)(object3 = this.getIdentifierValue())).equals(object2 = ((DescriptorProtos$UninterpretedOption)object).getIdentifierValue()))) {
            return false;
        }
        bl4 = this.hasPositiveIntValue();
        if (bl4 != (bl2 = ((DescriptorProtos$UninterpretedOption)object).hasPositiveIntValue())) {
            return false;
        }
        bl4 = this.hasPositiveIntValue();
        if (bl4 && (bl4 = (l14 = (l13 = this.getPositiveIntValue()) - (l12 = ((DescriptorProtos$UninterpretedOption)object).getPositiveIntValue())) == 0L ? 0 : (l14 < 0L ? -1 : 1))) {
            return false;
        }
        bl4 = this.hasNegativeIntValue();
        if (bl4 != (bl2 = ((DescriptorProtos$UninterpretedOption)object).hasNegativeIntValue())) {
            return false;
        }
        bl4 = this.hasNegativeIntValue();
        if (bl4 && (bl4 = (l11 = (l13 = this.getNegativeIntValue()) - (l12 = ((DescriptorProtos$UninterpretedOption)object).getNegativeIntValue())) == 0L ? 0 : (l11 < 0L ? -1 : 1))) {
            return false;
        }
        bl4 = this.hasDoubleValue();
        if (bl4 != (bl2 = ((DescriptorProtos$UninterpretedOption)object).hasDoubleValue())) {
            return false;
        }
        bl4 = this.hasDoubleValue();
        if (bl4 && (bl4 = (l10 = (l13 = Double.doubleToLongBits(d11 = this.getDoubleValue())) - (l12 = Double.doubleToLongBits(d10 = ((DescriptorProtos$UninterpretedOption)object).getDoubleValue()))) == 0L ? 0 : (l10 < 0L ? -1 : 1))) {
            return false;
        }
        bl4 = this.hasStringValue();
        if (bl4 != (bl2 = ((DescriptorProtos$UninterpretedOption)object).hasStringValue())) {
            return false;
        }
        bl4 = this.hasStringValue();
        if (bl4 && !(bl4 = ((ByteString)(object3 = this.getStringValue())).equals(object2 = ((DescriptorProtos$UninterpretedOption)object).getStringValue()))) {
            return false;
        }
        bl4 = this.hasAggregateValue();
        if (bl4 != (bl2 = ((DescriptorProtos$UninterpretedOption)object).hasAggregateValue())) {
            return false;
        }
        bl4 = this.hasAggregateValue();
        if (bl4 && !(bl4 = ((String)(object3 = this.getAggregateValue())).equals(object2 = ((DescriptorProtos$UninterpretedOption)object).getAggregateValue()))) {
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

    public String getAggregateValue() {
        Object object = this.aggregateValue_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.aggregateValue_ = string2;
        }
        return string2;
    }

    public ByteString getAggregateValueBytes() {
        Object object = this.aggregateValue_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.aggregateValue_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public DescriptorProtos$UninterpretedOption getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public double getDoubleValue() {
        return this.doubleValue_;
    }

    public String getIdentifierValue() {
        Object object = this.identifierValue_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.identifierValue_ = string2;
        }
        return string2;
    }

    public ByteString getIdentifierValueBytes() {
        Object object = this.identifierValue_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.identifierValue_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public DescriptorProtos$UninterpretedOption$NamePart getName(int n10) {
        return (DescriptorProtos$UninterpretedOption$NamePart)this.name_.get(n10);
    }

    public int getNameCount() {
        return this.name_.size();
    }

    public List getNameList() {
        return this.name_;
    }

    public DescriptorProtos$UninterpretedOption$NamePartOrBuilder getNameOrBuilder(int n10) {
        return (DescriptorProtos$UninterpretedOption$NamePartOrBuilder)this.name_.get(n10);
    }

    public List getNameOrBuilderList() {
        return this.name_;
    }

    public long getNegativeIntValue() {
        return this.negativeIntValue_;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public long getPositiveIntValue() {
        return this.positiveIntValue_;
    }

    public int getSerializedSize() {
        int n10;
        int n11;
        Object object;
        int n12 = this.memoizedSize;
        int n13 = -1;
        if (n12 != n13) {
            return n12;
        }
        n12 = 0;
        Object object2 = null;
        n13 = 0;
        while (true) {
            object = this.name_;
            n11 = object.size();
            n10 = 2;
            if (n12 >= n11) break;
            object = (MessageLite)this.name_.get(n12);
            n11 = CodedOutputStream.computeMessageSize(n10, (MessageLite)object);
            n13 += n11;
            ++n12;
        }
        n12 = this.bitField0_ & 1;
        if (n12 != 0) {
            object = this.identifierValue_;
            n12 = GeneratedMessageV3.computeStringSize(3, object);
            n13 += n12;
        }
        n12 = this.bitField0_ & n10;
        n11 = 4;
        if (n12 != 0) {
            long l10 = this.positiveIntValue_;
            n12 = CodedOutputStream.computeUInt64Size(n11, l10);
            n13 += n12;
        }
        if ((n12 = this.bitField0_ & n11) != 0) {
            long l11 = this.negativeIntValue_;
            n12 = CodedOutputStream.computeInt64Size(5, l11);
            n13 += n12;
        }
        n12 = this.bitField0_;
        n11 = 8;
        if ((n12 &= n11) != 0) {
            double d10 = this.doubleValue_;
            n12 = CodedOutputStream.computeDoubleSize(6, d10);
            n13 += n12;
        }
        if ((n12 = this.bitField0_ & 0x10) != 0) {
            ByteString byteString = this.stringValue_;
            n12 = CodedOutputStream.computeBytesSize(7, byteString);
            n13 += n12;
        }
        if ((n12 = this.bitField0_ & 0x20) != 0) {
            object2 = this.aggregateValue_;
            n12 = GeneratedMessageV3.computeStringSize(n11, object2);
            n13 += n12;
        }
        n12 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n13 += n12;
        return n13;
    }

    public ByteString getStringValue() {
        return this.stringValue_;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public boolean hasAggregateValue() {
        int n10 = this.bitField0_ & 0x20;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasDoubleValue() {
        int n10 = this.bitField0_ & 8;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasIdentifierValue() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean hasNegativeIntValue() {
        int n10 = this.bitField0_ & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasPositiveIntValue() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasStringValue() {
        int n10 = this.bitField0_ & 0x10;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public int hashCode() {
        long l10;
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = DescriptorProtos$UninterpretedOption.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = this.getNameCount();
        if (n11 > 0) {
            n10 = (n10 * 37 + 2) * 53;
            object = this.getNameList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasIdentifierValue() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 3) * 53;
            object = this.getIdentifierValue();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasPositiveIntValue() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 4) * 53;
            l10 = this.getPositiveIntValue();
            n11 = Internal.hashLong(l10);
            n10 += n11;
        }
        if ((n11 = (int)(this.hasNegativeIntValue() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 5) * 53;
            l10 = this.getNegativeIntValue();
            n11 = Internal.hashLong(l10);
            n10 += n11;
        }
        if ((n11 = (int)(this.hasDoubleValue() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 6) * 53;
            double d10 = this.getDoubleValue();
            l10 = Double.doubleToLongBits(d10);
            n11 = Internal.hashLong(l10);
            n10 += n11;
        }
        if ((n11 = (int)(this.hasStringValue() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 7) * 53;
            object = this.getStringValue();
            n11 = ((ByteString)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasAggregateValue() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 8) * 53;
            object = this.getAggregateValue();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$24900().ensureFieldAccessorsInitialized(DescriptorProtos$UninterpretedOption.class, DescriptorProtos$UninterpretedOption$Builder.class);
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
        for (n11 = 0; n11 < (n10 = this.getNameCount()); ++n11) {
            DescriptorProtos$UninterpretedOption$NamePart descriptorProtos$UninterpretedOption$NamePart = this.getName(n11);
            n10 = descriptorProtos$UninterpretedOption$NamePart.isInitialized();
            if (n10 != 0) continue;
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = (byte)n12;
        return n12 != 0;
    }

    public DescriptorProtos$UninterpretedOption$Builder newBuilderForType() {
        return DescriptorProtos$UninterpretedOption.newBuilder();
    }

    public DescriptorProtos$UninterpretedOption$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOption$Builder = new DescriptorProtos$UninterpretedOption$Builder(generatedMessageV3$BuilderParent, null);
        return descriptorProtos$UninterpretedOption$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new DescriptorProtos$UninterpretedOption();
        return object;
    }

    public DescriptorProtos$UninterpretedOption$Builder toBuilder() {
        DescriptorProtos$UninterpretedOptionOrBuilder descriptorProtos$UninterpretedOptionOrBuilder = DEFAULT_INSTANCE;
        if (this == descriptorProtos$UninterpretedOptionOrBuilder) {
            descriptorProtos$UninterpretedOptionOrBuilder = new DescriptorProtos$UninterpretedOption$Builder(null);
        } else {
            descriptorProtos$UninterpretedOptionOrBuilder = new DescriptorProtos$UninterpretedOption$Builder(null);
            descriptorProtos$UninterpretedOptionOrBuilder = ((DescriptorProtos$UninterpretedOption$Builder)descriptorProtos$UninterpretedOptionOrBuilder).mergeFrom(this);
        }
        return descriptorProtos$UninterpretedOptionOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        int n10;
        int n11;
        Object object;
        int n12 = 0;
        Object object2 = null;
        while (true) {
            object = this.name_;
            n11 = object.size();
            n10 = 2;
            if (n12 >= n11) break;
            object = (MessageLite)this.name_.get(n12);
            codedOutputStream.writeMessage(n10, (MessageLite)object);
            ++n12;
        }
        n12 = this.bitField0_ & 1;
        if (n12 != 0) {
            n12 = 3;
            object = this.identifierValue_;
            GeneratedMessageV3.writeString(codedOutputStream, n12, object);
        }
        n12 = this.bitField0_ & n10;
        n11 = 4;
        if (n12 != 0) {
            long l10 = this.positiveIntValue_;
            codedOutputStream.writeUInt64(n11, l10);
        }
        if ((n12 = this.bitField0_ & n11) != 0) {
            n12 = 5;
            long l11 = this.negativeIntValue_;
            codedOutputStream.writeInt64(n12, l11);
        }
        n12 = this.bitField0_;
        n11 = 8;
        if ((n12 &= n11) != 0) {
            n12 = 6;
            double d10 = this.doubleValue_;
            codedOutputStream.writeDouble(n12, d10);
        }
        if ((n12 = this.bitField0_ & 0x10) != 0) {
            n12 = 7;
            ByteString byteString = this.stringValue_;
            codedOutputStream.writeBytes(n12, byteString);
        }
        if ((n12 = this.bitField0_ & 0x20) != 0) {
            object2 = this.aggregateValue_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object2);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

