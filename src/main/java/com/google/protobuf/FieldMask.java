/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FieldMask$1;
import com.google.protobuf.FieldMask$Builder;
import com.google.protobuf.FieldMaskOrBuilder;
import com.google.protobuf.FieldMaskProto;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.GeneratedMessageV3$UnusedPrivateParameter;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

public final class FieldMask
extends GeneratedMessageV3
implements FieldMaskOrBuilder {
    private static final FieldMask DEFAULT_INSTANCE;
    private static final Parser PARSER;
    public static final int PATHS_FIELD_NUMBER = 1;
    private static final long serialVersionUID;
    private byte memoizedIsInitialized;
    private LazyStringList paths_;

    static {
        Object object = new FieldMask();
        DEFAULT_INSTANCE = object;
        PARSER = object = new FieldMask$1();
    }

    private FieldMask() {
        LazyStringList lazyStringList;
        this.memoizedIsInitialized = (byte)-1;
        this.paths_ = lazyStringList = LazyStringArrayList.EMPTY;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private FieldMask(CodedInputStream object, ExtensionRegistryLite object2) {
        int n10;
        UnknownFieldSet$Builder unknownFieldSet$Builder;
        block12: {
            Throwable throwable2;
            this();
            Objects.requireNonNull(object2);
            unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
            boolean bl2 = false;
            n10 = 0;
            while (true) {
                boolean bl3 = true;
                if (bl2) break block12;
                try {
                    try {
                        int n11 = ((CodedInputStream)object).readTag();
                        if (n11 != 0) {
                            int n12 = 10;
                            if (n11 != n12) {
                                if ((n11 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n11) ? 1 : 0)) != 0) continue;
                            } else {
                                LazyStringList lazyStringList;
                                String string2 = ((CodedInputStream)object).readStringRequireUtf8();
                                n12 = n10 & 1;
                                if (n12 == 0) {
                                    this.paths_ = lazyStringList = new LazyStringArrayList();
                                    n10 |= 1;
                                }
                                lazyStringList = this.paths_;
                                lazyStringList.add(string2);
                                continue;
                            }
                        }
                        bl2 = bl3;
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
            boolean bl4 = n10 & true;
            if (bl4) {
                this.paths_ = object2 = this.paths_.getUnmodifiableView();
            }
            this.unknownFields = object2 = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
            throw throwable2;
        }
        boolean bl5 = n10 & true;
        if (bl5) {
            this.paths_ = object = this.paths_.getUnmodifiableView();
        }
        this.unknownFields = object = unknownFieldSet$Builder.build();
        this.makeExtensionsImmutable();
    }

    public /* synthetic */ FieldMask(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, FieldMask$1 fieldMask$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private FieldMask(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
        this.memoizedIsInitialized = (byte)-1;
    }

    public /* synthetic */ FieldMask(GeneratedMessageV3$Builder generatedMessageV3$Builder, FieldMask$1 fieldMask$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ LazyStringList access$300(FieldMask fieldMask) {
        return fieldMask.paths_;
    }

    public static /* synthetic */ LazyStringList access$302(FieldMask fieldMask, LazyStringList lazyStringList) {
        fieldMask.paths_ = lazyStringList;
        return lazyStringList;
    }

    public static /* synthetic */ Parser access$400() {
        return PARSER;
    }

    public static FieldMask getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return FieldMaskProto.internal_static_google_protobuf_FieldMask_descriptor;
    }

    public static FieldMask$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static FieldMask$Builder newBuilder(FieldMask fieldMask) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(fieldMask);
    }

    public static FieldMask parseDelimitedFrom(InputStream inputStream) {
        return (FieldMask)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static FieldMask parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (FieldMask)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static FieldMask parseFrom(ByteString byteString) {
        return (FieldMask)PARSER.parseFrom(byteString);
    }

    public static FieldMask parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (FieldMask)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static FieldMask parseFrom(CodedInputStream codedInputStream) {
        return (FieldMask)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static FieldMask parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (FieldMask)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static FieldMask parseFrom(InputStream inputStream) {
        return (FieldMask)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static FieldMask parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (FieldMask)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static FieldMask parseFrom(ByteBuffer byteBuffer) {
        return (FieldMask)PARSER.parseFrom(byteBuffer);
    }

    public static FieldMask parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (FieldMask)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static FieldMask parseFrom(byte[] byArray) {
        return (FieldMask)PARSER.parseFrom(byArray);
    }

    public static FieldMask parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (FieldMask)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof FieldMask;
        if (!bl3) {
            return super.equals(object);
        }
        object = (FieldMask)object;
        Object object2 = this.getPathsList();
        ProtocolStringList protocolStringList = ((FieldMask)object).getPathsList();
        bl3 = object2.equals(protocolStringList);
        protocolStringList = null;
        if (!bl3) {
            return false;
        }
        object2 = this.unknownFields;
        object = ((GeneratedMessageV3)object).unknownFields;
        boolean bl4 = ((UnknownFieldSet)object2).equals(object);
        if (!bl4) {
            return false;
        }
        return bl2;
    }

    public FieldMask getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public String getPaths(int n10) {
        return (String)this.paths_.get(n10);
    }

    public ByteString getPathsBytes(int n10) {
        return this.paths_.getByteString(n10);
    }

    public int getPathsCount() {
        return this.paths_.size();
    }

    public ProtocolStringList getPathsList() {
        return this.paths_;
    }

    public int getSerializedSize() {
        Object object;
        int n10;
        int n11 = this.memoizedSize;
        int n12 = -1;
        if (n11 != n12) {
            return n11;
        }
        n11 = 0;
        int n13 = 0;
        for (n12 = 0; n12 < (n10 = (object = this.paths_).size()); ++n12) {
            object = this.paths_.getRaw(n12);
            n10 = GeneratedMessageV3.computeStringSizeNoTag(object);
            n13 += n10;
        }
        n11 = 0 + n13;
        n12 = this.getPathsList().size() * 1;
        n11 += n12;
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
        Object object = FieldMask.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = this.getPathsCount();
        if (n11 > 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getPathsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return FieldMaskProto.internal_static_google_protobuf_FieldMask_fieldAccessorTable.ensureFieldAccessorsInitialized(FieldMask.class, FieldMask$Builder.class);
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

    public FieldMask$Builder newBuilderForType() {
        return FieldMask.newBuilder();
    }

    public FieldMask$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        FieldMask$Builder fieldMask$Builder = new FieldMask$Builder(generatedMessageV3$BuilderParent, null);
        return fieldMask$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new FieldMask();
        return object;
    }

    public FieldMask$Builder toBuilder() {
        FieldMaskOrBuilder fieldMaskOrBuilder = DEFAULT_INSTANCE;
        if (this == fieldMaskOrBuilder) {
            fieldMaskOrBuilder = new FieldMask$Builder(null);
        } else {
            fieldMaskOrBuilder = new FieldMask$Builder(null);
            fieldMaskOrBuilder = ((FieldMask$Builder)fieldMaskOrBuilder).mergeFrom(this);
        }
        return fieldMaskOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = (object = this.paths_).size()); ++i10) {
            object = this.paths_.getRaw(i10);
            int n11 = 1;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

