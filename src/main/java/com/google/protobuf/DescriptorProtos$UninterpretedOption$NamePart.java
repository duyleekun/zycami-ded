/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePart$1;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePart$Builder;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePartOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.GeneratedMessageV3$UnusedPrivateParameter;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

public final class DescriptorProtos$UninterpretedOption$NamePart
extends GeneratedMessageV3
implements DescriptorProtos$UninterpretedOption$NamePartOrBuilder {
    private static final DescriptorProtos$UninterpretedOption$NamePart DEFAULT_INSTANCE;
    public static final int IS_EXTENSION_FIELD_NUMBER = 2;
    public static final int NAME_PART_FIELD_NUMBER = 1;
    public static final Parser PARSER;
    private static final long serialVersionUID;
    private int bitField0_;
    private boolean isExtension_;
    private byte memoizedIsInitialized = (byte)-1;
    private volatile Object namePart_;

    static {
        Object object = new DescriptorProtos$UninterpretedOption$NamePart();
        DEFAULT_INSTANCE = object;
        PARSER = object = new DescriptorProtos$UninterpretedOption$NamePart$1();
    }

    private DescriptorProtos$UninterpretedOption$NamePart() {
        this.namePart_ = "";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private DescriptorProtos$UninterpretedOption$NamePart(CodedInputStream object, ExtensionRegistryLite object2) {
        this();
        Throwable throwable2;
        Objects.requireNonNull(object2);
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        int n10 = 0;
        while (true) {
            if (n10 != 0) {
                this.unknownFields = object = unknownFieldSet$Builder.build();
                this.makeExtensionsImmutable();
                return;
            }
            try {
                try {
                    int n11;
                    block11: {
                        int n12 = ((CodedInputStream)object).readTag();
                        n11 = 1;
                        if (n12 != 0) {
                            int n13 = 10;
                            if (n12 != n13) {
                                n13 = 16;
                                if (n12 != n13) {
                                    if ((n12 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n12) ? 1 : 0)) != 0) continue;
                                    break block11;
                                } else {
                                    this.bitField0_ = n12 = this.bitField0_ | 2;
                                    n12 = (int)(((CodedInputStream)object).readBool() ? 1 : 0);
                                    this.isExtension_ = n12;
                                    continue;
                                }
                            }
                            ByteString byteString = ((CodedInputStream)object).readBytes();
                            n13 = this.bitField0_;
                            this.bitField0_ = n11 |= n13;
                            this.namePart_ = byteString;
                            continue;
                        }
                    }
                    n10 = n11;
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
            catch (Throwable throwable2) {}
            break;
        }
        this.unknownFields = object2 = unknownFieldSet$Builder.build();
        this.makeExtensionsImmutable();
        throw throwable2;
    }

    public /* synthetic */ DescriptorProtos$UninterpretedOption$NamePart(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private DescriptorProtos$UninterpretedOption$NamePart(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ DescriptorProtos$UninterpretedOption$NamePart(GeneratedMessageV3$Builder generatedMessageV3$Builder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ Object access$25500(DescriptorProtos$UninterpretedOption$NamePart descriptorProtos$UninterpretedOption$NamePart) {
        return descriptorProtos$UninterpretedOption$NamePart.namePart_;
    }

    public static /* synthetic */ Object access$25502(DescriptorProtos$UninterpretedOption$NamePart descriptorProtos$UninterpretedOption$NamePart, Object object) {
        descriptorProtos$UninterpretedOption$NamePart.namePart_ = object;
        return object;
    }

    public static /* synthetic */ boolean access$25602(DescriptorProtos$UninterpretedOption$NamePart descriptorProtos$UninterpretedOption$NamePart, boolean bl2) {
        descriptorProtos$UninterpretedOption$NamePart.isExtension_ = bl2;
        return bl2;
    }

    public static /* synthetic */ int access$25702(DescriptorProtos$UninterpretedOption$NamePart descriptorProtos$UninterpretedOption$NamePart, int n10) {
        descriptorProtos$UninterpretedOption$NamePart.bitField0_ = n10;
        return n10;
    }

    public static DescriptorProtos$UninterpretedOption$NamePart getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$25000();
    }

    public static DescriptorProtos$UninterpretedOption$NamePart$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$UninterpretedOption$NamePart$Builder newBuilder(DescriptorProtos$UninterpretedOption$NamePart descriptorProtos$UninterpretedOption$NamePart) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$UninterpretedOption$NamePart);
    }

    public static DescriptorProtos$UninterpretedOption$NamePart parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$UninterpretedOption$NamePart)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$UninterpretedOption$NamePart parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$UninterpretedOption$NamePart)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$UninterpretedOption$NamePart parseFrom(ByteString byteString) {
        return (DescriptorProtos$UninterpretedOption$NamePart)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$UninterpretedOption$NamePart parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$UninterpretedOption$NamePart)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$UninterpretedOption$NamePart parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$UninterpretedOption$NamePart)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static DescriptorProtos$UninterpretedOption$NamePart parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$UninterpretedOption$NamePart)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$UninterpretedOption$NamePart parseFrom(InputStream inputStream) {
        return (DescriptorProtos$UninterpretedOption$NamePart)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$UninterpretedOption$NamePart parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$UninterpretedOption$NamePart)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$UninterpretedOption$NamePart parseFrom(ByteBuffer byteBuffer) {
        return (DescriptorProtos$UninterpretedOption$NamePart)PARSER.parseFrom(byteBuffer);
    }

    public static DescriptorProtos$UninterpretedOption$NamePart parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$UninterpretedOption$NamePart)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static DescriptorProtos$UninterpretedOption$NamePart parseFrom(byte[] byArray) {
        return (DescriptorProtos$UninterpretedOption$NamePart)PARSER.parseFrom(byArray);
    }

    public static DescriptorProtos$UninterpretedOption$NamePart parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$UninterpretedOption$NamePart)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        String string2;
        Object object2;
        boolean bl2;
        boolean bl3 = true;
        if (object == this) {
            return bl3;
        }
        boolean bl4 = object instanceof DescriptorProtos$UninterpretedOption$NamePart;
        if (!bl4) {
            return super.equals(object);
        }
        object = (DescriptorProtos$UninterpretedOption$NamePart)object;
        bl4 = this.hasNamePart();
        if (bl4 != (bl2 = ((DescriptorProtos$UninterpretedOption$NamePart)object).hasNamePart())) {
            return false;
        }
        bl4 = this.hasNamePart();
        if (bl4 && !(bl4 = ((String)(object2 = this.getNamePart())).equals(string2 = ((DescriptorProtos$UninterpretedOption$NamePart)object).getNamePart()))) {
            return false;
        }
        bl4 = this.hasIsExtension();
        if (bl4 != (bl2 = ((DescriptorProtos$UninterpretedOption$NamePart)object).hasIsExtension())) {
            return false;
        }
        bl4 = this.hasIsExtension();
        if (bl4 && (bl4 = this.getIsExtension()) != (bl2 = ((DescriptorProtos$UninterpretedOption$NamePart)object).getIsExtension())) {
            return false;
        }
        object2 = this.unknownFields;
        object = ((GeneratedMessageV3)object).unknownFields;
        boolean bl5 = ((UnknownFieldSet)object2).equals(object);
        if (!bl5) {
            return false;
        }
        return bl3;
    }

    public DescriptorProtos$UninterpretedOption$NamePart getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public boolean getIsExtension() {
        return this.isExtension_;
    }

    public String getNamePart() {
        Object object = this.namePart_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.namePart_ = string2;
        }
        return string2;
    }

    public ByteString getNamePartBytes() {
        Object object = this.namePart_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.namePart_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int n10 = this.memoizedSize;
        int n11 = -1;
        if (n10 != n11) {
            return n10;
        }
        n10 = 0;
        n11 = this.bitField0_;
        int n12 = 1;
        if ((n11 &= n12) != 0) {
            Object object = this.namePart_;
            n11 = GeneratedMessageV3.computeStringSize(n12, object);
            n10 = 0 + n11;
        }
        n11 = this.bitField0_;
        n12 = 2;
        if ((n11 &= n12) != 0) {
            n11 = (int)(this.isExtension_ ? 1 : 0);
            n11 = CodedOutputStream.computeBoolSize(n12, n11 != 0);
            n10 += n11;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n10 += n11;
        return n10;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public boolean hasIsExtension() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasNamePart() {
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
        Object object = DescriptorProtos$UninterpretedOption$NamePart.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasNamePart() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getNamePart();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasIsExtension() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 2) * 53;
            n11 = Internal.hashBoolean(this.getIsExtension());
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$25100().ensureFieldAccessorsInitialized(DescriptorProtos$UninterpretedOption$NamePart.class, DescriptorProtos$UninterpretedOption$NamePart$Builder.class);
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
        by2 = this.hasNamePart();
        if (!by2) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        by2 = this.hasIsExtension();
        if (!by2) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = by3;
        return by3 != 0;
    }

    public DescriptorProtos$UninterpretedOption$NamePart$Builder newBuilderForType() {
        return DescriptorProtos$UninterpretedOption$NamePart.newBuilder();
    }

    public DescriptorProtos$UninterpretedOption$NamePart$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        DescriptorProtos$UninterpretedOption$NamePart$Builder descriptorProtos$UninterpretedOption$NamePart$Builder = new DescriptorProtos$UninterpretedOption$NamePart$Builder(generatedMessageV3$BuilderParent, null);
        return descriptorProtos$UninterpretedOption$NamePart$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new DescriptorProtos$UninterpretedOption$NamePart();
        return object;
    }

    public DescriptorProtos$UninterpretedOption$NamePart$Builder toBuilder() {
        DescriptorProtos$UninterpretedOption$NamePartOrBuilder descriptorProtos$UninterpretedOption$NamePartOrBuilder = DEFAULT_INSTANCE;
        if (this == descriptorProtos$UninterpretedOption$NamePartOrBuilder) {
            descriptorProtos$UninterpretedOption$NamePartOrBuilder = new DescriptorProtos$UninterpretedOption$NamePart$Builder(null);
        } else {
            descriptorProtos$UninterpretedOption$NamePartOrBuilder = new DescriptorProtos$UninterpretedOption$NamePart$Builder(null);
            descriptorProtos$UninterpretedOption$NamePartOrBuilder = ((DescriptorProtos$UninterpretedOption$NamePart$Builder)descriptorProtos$UninterpretedOption$NamePartOrBuilder).mergeFrom(this);
        }
        return descriptorProtos$UninterpretedOption$NamePartOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        int n10;
        int n11;
        int bl2 = this.bitField0_;
        int n12 = 1;
        int n13 = bl2 & n12;
        if (n13 != 0) {
            Object object = this.namePart_;
            GeneratedMessageV3.writeString(codedOutputStream, n12, object);
        }
        if ((n11 = (n10 = this.bitField0_) & (n12 = 2)) != 0) {
            boolean bl3 = this.isExtension_;
            codedOutputStream.writeBool(n12, bl3);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

