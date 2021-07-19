/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$Annotation$1;
import com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$Annotation$Builder;
import com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.GeneratedMessageV3$UnusedPrivateParameter;
import com.google.protobuf.Internal$IntList;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Objects;

public final class DescriptorProtos$GeneratedCodeInfo$Annotation
extends GeneratedMessageV3
implements DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder {
    public static final int BEGIN_FIELD_NUMBER = 3;
    private static final DescriptorProtos$GeneratedCodeInfo$Annotation DEFAULT_INSTANCE;
    public static final int END_FIELD_NUMBER = 4;
    public static final Parser PARSER;
    public static final int PATH_FIELD_NUMBER = 1;
    public static final int SOURCE_FILE_FIELD_NUMBER = 2;
    private static final long serialVersionUID;
    private int begin_;
    private int bitField0_;
    private int end_;
    private byte memoizedIsInitialized;
    private int pathMemoizedSerializedSize;
    private Internal$IntList path_;
    private volatile Object sourceFile_;

    static {
        Object object = new DescriptorProtos$GeneratedCodeInfo$Annotation();
        DEFAULT_INSTANCE = object;
        PARSER = object = new DescriptorProtos$GeneratedCodeInfo$Annotation$1();
    }

    private DescriptorProtos$GeneratedCodeInfo$Annotation() {
        Internal$IntList internal$IntList;
        int n10;
        this.pathMemoizedSerializedSize = n10 = -1;
        this.memoizedIsInitialized = (byte)n10;
        this.path_ = internal$IntList = GeneratedMessageV3.emptyIntList();
        this.sourceFile_ = "";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private DescriptorProtos$GeneratedCodeInfo$Annotation(CodedInputStream object, ExtensionRegistryLite object2) {
        int n10;
        UnknownFieldSet$Builder unknownFieldSet$Builder;
        block18: {
            Throwable throwable2;
            this();
            Objects.requireNonNull(object2);
            unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
            int n11 = 0;
            n10 = 0;
            while (true) {
                int n12 = 1;
                if (n11 != 0) break block18;
                try {
                    try {
                        block19: {
                            int n13 = ((CodedInputStream)object).readTag();
                            if (n13 != 0) {
                                Iterable iterable;
                                int n14 = 8;
                                if (n13 != n14) {
                                    Internal$IntList internal$IntList;
                                    n14 = 10;
                                    if (n13 != n14) {
                                        n14 = 18;
                                        if (n13 != n14) {
                                            n14 = 24;
                                            if (n13 != n14) {
                                                n14 = 32;
                                                if (n13 != n14) {
                                                    if ((n13 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n13) ? 1 : 0)) != 0) continue;
                                                    break block19;
                                                } else {
                                                    this.bitField0_ = n13 = this.bitField0_ | 4;
                                                    this.end_ = n13 = ((CodedInputStream)object).readInt32();
                                                    continue;
                                                }
                                            }
                                            this.bitField0_ = n13 = this.bitField0_ | 2;
                                            this.begin_ = n13 = ((CodedInputStream)object).readInt32();
                                            continue;
                                        }
                                        iterable = ((CodedInputStream)object).readBytes();
                                        this.bitField0_ = n14 = this.bitField0_ | n12;
                                        this.sourceFile_ = iterable;
                                        continue;
                                    }
                                    n13 = ((CodedInputStream)object).readRawVarint32();
                                    n13 = ((CodedInputStream)object).pushLimit(n13);
                                    n14 = n10 & 1;
                                    if (n14 == 0 && (n14 = ((CodedInputStream)object).getBytesUntilLimit()) > 0) {
                                        this.path_ = internal$IntList = GeneratedMessageV3.newIntList();
                                        n10 |= 1;
                                    }
                                    while ((n14 = ((CodedInputStream)object).getBytesUntilLimit()) > 0) {
                                        internal$IntList = this.path_;
                                        int n15 = ((CodedInputStream)object).readInt32();
                                        internal$IntList.addInt(n15);
                                    }
                                    ((CodedInputStream)object).popLimit(n13);
                                    continue;
                                }
                                n13 = n10 & 1;
                                if (n13 == 0) {
                                    iterable = GeneratedMessageV3.newIntList();
                                    this.path_ = iterable;
                                    n10 |= 1;
                                }
                                iterable = this.path_;
                                n14 = ((CodedInputStream)object).readInt32();
                                iterable.addInt(n14);
                                continue;
                            }
                        }
                        n11 = n12;
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
            boolean bl2 = n10 & true;
            if (bl2) {
                object2 = this.path_;
                object2.makeImmutable();
            }
            this.unknownFields = object2 = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
            throw throwable2;
        }
        boolean bl3 = n10 & true;
        if (bl3) {
            object = this.path_;
            object.makeImmutable();
        }
        this.unknownFields = object = unknownFieldSet$Builder.build();
        this.makeExtensionsImmutable();
    }

    public /* synthetic */ DescriptorProtos$GeneratedCodeInfo$Annotation(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private DescriptorProtos$GeneratedCodeInfo$Annotation(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
        int n10;
        this.pathMemoizedSerializedSize = n10 = -1;
        this.memoizedIsInitialized = (byte)n10;
    }

    public /* synthetic */ DescriptorProtos$GeneratedCodeInfo$Annotation(GeneratedMessageV3$Builder generatedMessageV3$Builder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ Internal$IntList access$29700(DescriptorProtos$GeneratedCodeInfo$Annotation descriptorProtos$GeneratedCodeInfo$Annotation) {
        return descriptorProtos$GeneratedCodeInfo$Annotation.path_;
    }

    public static /* synthetic */ Internal$IntList access$29702(DescriptorProtos$GeneratedCodeInfo$Annotation descriptorProtos$GeneratedCodeInfo$Annotation, Internal$IntList internal$IntList) {
        descriptorProtos$GeneratedCodeInfo$Annotation.path_ = internal$IntList;
        return internal$IntList;
    }

    public static /* synthetic */ Object access$29800(DescriptorProtos$GeneratedCodeInfo$Annotation descriptorProtos$GeneratedCodeInfo$Annotation) {
        return descriptorProtos$GeneratedCodeInfo$Annotation.sourceFile_;
    }

    public static /* synthetic */ Object access$29802(DescriptorProtos$GeneratedCodeInfo$Annotation descriptorProtos$GeneratedCodeInfo$Annotation, Object object) {
        descriptorProtos$GeneratedCodeInfo$Annotation.sourceFile_ = object;
        return object;
    }

    public static /* synthetic */ int access$29902(DescriptorProtos$GeneratedCodeInfo$Annotation descriptorProtos$GeneratedCodeInfo$Annotation, int n10) {
        descriptorProtos$GeneratedCodeInfo$Annotation.begin_ = n10;
        return n10;
    }

    public static /* synthetic */ int access$30002(DescriptorProtos$GeneratedCodeInfo$Annotation descriptorProtos$GeneratedCodeInfo$Annotation, int n10) {
        descriptorProtos$GeneratedCodeInfo$Annotation.end_ = n10;
        return n10;
    }

    public static /* synthetic */ int access$30102(DescriptorProtos$GeneratedCodeInfo$Annotation descriptorProtos$GeneratedCodeInfo$Annotation, int n10) {
        descriptorProtos$GeneratedCodeInfo$Annotation.bitField0_ = n10;
        return n10;
    }

    public static DescriptorProtos$GeneratedCodeInfo$Annotation getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$29200();
    }

    public static DescriptorProtos$GeneratedCodeInfo$Annotation$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$GeneratedCodeInfo$Annotation$Builder newBuilder(DescriptorProtos$GeneratedCodeInfo$Annotation descriptorProtos$GeneratedCodeInfo$Annotation) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$GeneratedCodeInfo$Annotation);
    }

    public static DescriptorProtos$GeneratedCodeInfo$Annotation parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$GeneratedCodeInfo$Annotation)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$GeneratedCodeInfo$Annotation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$GeneratedCodeInfo$Annotation)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$GeneratedCodeInfo$Annotation parseFrom(ByteString byteString) {
        return (DescriptorProtos$GeneratedCodeInfo$Annotation)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$GeneratedCodeInfo$Annotation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$GeneratedCodeInfo$Annotation)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$GeneratedCodeInfo$Annotation parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$GeneratedCodeInfo$Annotation)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static DescriptorProtos$GeneratedCodeInfo$Annotation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$GeneratedCodeInfo$Annotation)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$GeneratedCodeInfo$Annotation parseFrom(InputStream inputStream) {
        return (DescriptorProtos$GeneratedCodeInfo$Annotation)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$GeneratedCodeInfo$Annotation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$GeneratedCodeInfo$Annotation)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$GeneratedCodeInfo$Annotation parseFrom(ByteBuffer byteBuffer) {
        return (DescriptorProtos$GeneratedCodeInfo$Annotation)PARSER.parseFrom(byteBuffer);
    }

    public static DescriptorProtos$GeneratedCodeInfo$Annotation parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$GeneratedCodeInfo$Annotation)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static DescriptorProtos$GeneratedCodeInfo$Annotation parseFrom(byte[] byArray) {
        return (DescriptorProtos$GeneratedCodeInfo$Annotation)PARSER.parseFrom(byArray);
    }

    public static DescriptorProtos$GeneratedCodeInfo$Annotation parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$GeneratedCodeInfo$Annotation)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        String string2;
        int n10;
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n11 = object instanceof DescriptorProtos$GeneratedCodeInfo$Annotation;
        if (n11 == 0) {
            return super.equals(object);
        }
        object = (DescriptorProtos$GeneratedCodeInfo$Annotation)object;
        Object object2 = this.getPathList();
        List list = ((DescriptorProtos$GeneratedCodeInfo$Annotation)object).getPathList();
        n11 = object2.equals(list);
        list = null;
        if (n11 == 0) {
            return false;
        }
        n11 = this.hasSourceFile();
        if (n11 != (n10 = ((DescriptorProtos$GeneratedCodeInfo$Annotation)object).hasSourceFile())) {
            return false;
        }
        n11 = this.hasSourceFile();
        if (n11 != 0 && (n11 = ((String)(object2 = this.getSourceFile())).equals(string2 = ((DescriptorProtos$GeneratedCodeInfo$Annotation)object).getSourceFile())) == 0) {
            return false;
        }
        n11 = this.hasBegin();
        if (n11 != (n10 = ((DescriptorProtos$GeneratedCodeInfo$Annotation)object).hasBegin())) {
            return false;
        }
        n11 = this.hasBegin();
        if (n11 != 0 && (n11 = this.getBegin()) != (n10 = ((DescriptorProtos$GeneratedCodeInfo$Annotation)object).getBegin())) {
            return false;
        }
        n11 = (int)(this.hasEnd() ? 1 : 0);
        if (n11 != (n10 = (int)(((DescriptorProtos$GeneratedCodeInfo$Annotation)object).hasEnd() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasEnd() ? 1 : 0);
        if (n11 != 0 && (n11 = this.getEnd()) != (n10 = ((DescriptorProtos$GeneratedCodeInfo$Annotation)object).getEnd())) {
            return false;
        }
        object2 = this.unknownFields;
        object = ((GeneratedMessageV3)object).unknownFields;
        boolean bl3 = ((UnknownFieldSet)object2).equals(object);
        if (!bl3) {
            return false;
        }
        return bl2;
    }

    public int getBegin() {
        return this.begin_;
    }

    public DescriptorProtos$GeneratedCodeInfo$Annotation getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public int getEnd() {
        return this.end_;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public int getPath(int n10) {
        return this.path_.getInt(n10);
    }

    public int getPathCount() {
        return this.path_.size();
    }

    public List getPathList() {
        return this.path_;
    }

    public int getSerializedSize() {
        Internal$IntList internal$IntList;
        int n10;
        int n11 = this.memoizedSize;
        int n12 = -1;
        if (n11 != n12) {
            return n11;
        }
        n11 = 0;
        Object object = null;
        int n13 = 0;
        for (n12 = 0; n12 < (n10 = (internal$IntList = this.path_).size()); ++n12) {
            internal$IntList = this.path_;
            n10 = CodedOutputStream.computeInt32SizeNoTag(internal$IntList.getInt(n12));
            n13 += n10;
        }
        n11 = 0 + n13;
        object = this.getPathList();
        n12 = (int)(object.isEmpty() ? 1 : 0);
        if (n12 == 0) {
            ++n11;
            n12 = CodedOutputStream.computeInt32SizeNoTag(n13);
            n11 += n12;
        }
        this.pathMemoizedSerializedSize = n13;
        n12 = this.bitField0_ & 1;
        n13 = 2;
        if (n12 != 0) {
            object = this.sourceFile_;
            n12 = GeneratedMessageV3.computeStringSize(n13, object);
            n11 += n12;
        }
        if ((n12 = this.bitField0_ & n13) != 0) {
            n13 = this.begin_;
            n12 = CodedOutputStream.computeInt32Size(3, n13);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n13 = 4;
        if ((n12 &= n13) != 0) {
            n12 = this.end_;
            n12 = CodedOutputStream.computeInt32Size(n13, n12);
            n11 += n12;
        }
        n12 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n11 += n12;
        return n11;
    }

    public String getSourceFile() {
        Object object = this.sourceFile_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.sourceFile_ = string2;
        }
        return string2;
    }

    public ByteString getSourceFileBytes() {
        Object object = this.sourceFile_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.sourceFile_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public boolean hasBegin() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasEnd() {
        int n10 = this.bitField0_ & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasSourceFile() {
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
        Object object = DescriptorProtos$GeneratedCodeInfo$Annotation.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = this.getPathCount();
        if (n11 > 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getPathList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasSourceFile() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 2) * 53;
            object = this.getSourceFile();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasBegin() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 3) * 53;
            n11 = this.getBegin();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasEnd() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 4) * 53;
            n11 = this.getEnd();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$29300().ensureFieldAccessorsInitialized(DescriptorProtos$GeneratedCodeInfo$Annotation.class, DescriptorProtos$GeneratedCodeInfo$Annotation$Builder.class);
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

    public DescriptorProtos$GeneratedCodeInfo$Annotation$Builder newBuilderForType() {
        return DescriptorProtos$GeneratedCodeInfo$Annotation.newBuilder();
    }

    public DescriptorProtos$GeneratedCodeInfo$Annotation$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        DescriptorProtos$GeneratedCodeInfo$Annotation$Builder descriptorProtos$GeneratedCodeInfo$Annotation$Builder = new DescriptorProtos$GeneratedCodeInfo$Annotation$Builder(generatedMessageV3$BuilderParent, null);
        return descriptorProtos$GeneratedCodeInfo$Annotation$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new DescriptorProtos$GeneratedCodeInfo$Annotation();
        return object;
    }

    public DescriptorProtos$GeneratedCodeInfo$Annotation$Builder toBuilder() {
        DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder descriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder = DEFAULT_INSTANCE;
        if (this == descriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder) {
            descriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder = new DescriptorProtos$GeneratedCodeInfo$Annotation$Builder(null);
        } else {
            descriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder = new DescriptorProtos$GeneratedCodeInfo$Annotation$Builder(null);
            descriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder = ((DescriptorProtos$GeneratedCodeInfo$Annotation$Builder)descriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder).mergeFrom(this);
        }
        return descriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        Internal$IntList internal$IntList;
        int n10;
        this.getSerializedSize();
        Object object = this.getPathList();
        int n11 = object.size();
        if (n11 > 0) {
            codedOutputStream.writeUInt32NoTag(10);
            n11 = this.pathMemoizedSerializedSize;
            codedOutputStream.writeUInt32NoTag(n11);
        }
        object = null;
        for (n11 = 0; n11 < (n10 = (internal$IntList = this.path_).size()); ++n11) {
            internal$IntList = this.path_;
            n10 = internal$IntList.getInt(n11);
            codedOutputStream.writeInt32NoTag(n10);
        }
        n11 = this.bitField0_ & 1;
        n10 = 2;
        if (n11 != 0) {
            object = this.sourceFile_;
            GeneratedMessageV3.writeString(codedOutputStream, n10, object);
        }
        if ((n11 = this.bitField0_ & n10) != 0) {
            n11 = 3;
            n10 = this.begin_;
            codedOutputStream.writeInt32(n11, n10);
        }
        n11 = this.bitField0_;
        n10 = 4;
        if ((n11 &= n10) != 0) {
            n11 = this.end_;
            codedOutputStream.writeInt32(n10, n11);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

