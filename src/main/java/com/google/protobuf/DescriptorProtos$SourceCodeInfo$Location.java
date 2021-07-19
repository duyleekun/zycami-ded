/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$Location$1;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$Location$Builder;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.GeneratedMessageV3$UnusedPrivateParameter;
import com.google.protobuf.Internal$IntList;
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
import java.util.List;
import java.util.Objects;

public final class DescriptorProtos$SourceCodeInfo$Location
extends GeneratedMessageV3
implements DescriptorProtos$SourceCodeInfo$LocationOrBuilder {
    private static final DescriptorProtos$SourceCodeInfo$Location DEFAULT_INSTANCE;
    public static final int LEADING_COMMENTS_FIELD_NUMBER = 3;
    public static final int LEADING_DETACHED_COMMENTS_FIELD_NUMBER = 6;
    public static final Parser PARSER;
    public static final int PATH_FIELD_NUMBER = 1;
    public static final int SPAN_FIELD_NUMBER = 2;
    public static final int TRAILING_COMMENTS_FIELD_NUMBER = 4;
    private static final long serialVersionUID;
    private int bitField0_;
    private volatile Object leadingComments_;
    private LazyStringList leadingDetachedComments_;
    private byte memoizedIsInitialized;
    private int pathMemoizedSerializedSize;
    private Internal$IntList path_;
    private int spanMemoizedSerializedSize;
    private Internal$IntList span_;
    private volatile Object trailingComments_;

    static {
        Object object = new DescriptorProtos$SourceCodeInfo$Location();
        DEFAULT_INSTANCE = object;
        PARSER = object = new DescriptorProtos$SourceCodeInfo$Location$1();
    }

    private DescriptorProtos$SourceCodeInfo$Location() {
        int n10;
        this.pathMemoizedSerializedSize = n10 = -1;
        this.spanMemoizedSerializedSize = n10;
        this.memoizedIsInitialized = (byte)n10;
        Object object = GeneratedMessageV3.emptyIntList();
        this.path_ = object;
        object = GeneratedMessageV3.emptyIntList();
        this.span_ = object;
        this.leadingComments_ = object = "";
        this.trailingComments_ = object;
        this.leadingDetachedComments_ = object = LazyStringArrayList.EMPTY;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private DescriptorProtos$SourceCodeInfo$Location(CodedInputStream object, ExtensionRegistryLite object2) {
        int n10;
        UnknownFieldSet$Builder unknownFieldSet$Builder;
        block28: {
            Throwable throwable2;
            this();
            Objects.requireNonNull(object2);
            unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
            int n11 = 0;
            n10 = 0;
            while (true) {
                int n12 = 16;
                if (n11 != 0) break block28;
                try {
                    try {
                        int n13;
                        block29: {
                            int n14 = ((CodedInputStream)object).readTag();
                            n13 = 1;
                            if (n14 != 0) {
                                Iterable iterable;
                                int n15 = 8;
                                if (n14 != n15) {
                                    List list;
                                    n15 = 10;
                                    if (n14 != n15) {
                                        if (n14 != n12) {
                                            n15 = 18;
                                            if (n14 != n15) {
                                                n15 = 26;
                                                if (n14 != n15) {
                                                    n15 = 34;
                                                    if (n14 != n15) {
                                                        n15 = 50;
                                                        if (n14 != n15) {
                                                            n12 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n14) ? 1 : 0);
                                                            if (n12 != 0) continue;
                                                            break block29;
                                                        } else {
                                                            iterable = ((CodedInputStream)object).readBytes();
                                                            n13 = n10 & 0x10;
                                                            if (n13 == 0) {
                                                                this.leadingDetachedComments_ = list;
                                                                n10 |= 0x10;
                                                            }
                                                            list = this.leadingDetachedComments_;
                                                            list.add((ByteString)iterable);
                                                            continue;
                                                        }
                                                    }
                                                    iterable = ((CodedInputStream)object).readBytes();
                                                    this.bitField0_ = n13 = this.bitField0_ | 2;
                                                    this.trailingComments_ = iterable;
                                                    continue;
                                                }
                                                iterable = ((CodedInputStream)object).readBytes();
                                                n15 = this.bitField0_;
                                                this.bitField0_ = n13 |= n15;
                                                this.leadingComments_ = iterable;
                                                continue;
                                            }
                                            n14 = ((CodedInputStream)object).readRawVarint32();
                                            n14 = ((CodedInputStream)object).pushLimit(n14);
                                            n13 = n10 & 2;
                                            if (n13 == 0 && (n13 = ((CodedInputStream)object).getBytesUntilLimit()) > 0) {
                                                list = GeneratedMessageV3.newIntList();
                                                this.span_ = list;
                                                n10 |= 2;
                                            }
                                            while ((n13 = ((CodedInputStream)object).getBytesUntilLimit()) > 0) {
                                                list = this.span_;
                                                n15 = ((CodedInputStream)object).readInt32();
                                                list.addInt(n15);
                                            }
                                            ((CodedInputStream)object).popLimit(n14);
                                            continue;
                                        }
                                        n14 = n10 & 2;
                                        if (n14 == 0) {
                                            iterable = GeneratedMessageV3.newIntList();
                                            this.span_ = iterable;
                                            n10 |= 2;
                                        }
                                        iterable = this.span_;
                                        n13 = ((CodedInputStream)object).readInt32();
                                        iterable.addInt(n13);
                                        continue;
                                    }
                                    n14 = ((CodedInputStream)object).readRawVarint32();
                                    n14 = ((CodedInputStream)object).pushLimit(n14);
                                    n13 = n10 & 1;
                                    if (n13 == 0 && (n13 = ((CodedInputStream)object).getBytesUntilLimit()) > 0) {
                                        list = GeneratedMessageV3.newIntList();
                                        this.path_ = list;
                                        n10 |= 1;
                                    }
                                    while ((n13 = ((CodedInputStream)object).getBytesUntilLimit()) > 0) {
                                        list = this.path_;
                                        n15 = ((CodedInputStream)object).readInt32();
                                        list.addInt(n15);
                                    }
                                    ((CodedInputStream)object).popLimit(n14);
                                    continue;
                                }
                                n14 = n10 & 1;
                                if (n14 == 0) {
                                    iterable = GeneratedMessageV3.newIntList();
                                    this.path_ = iterable;
                                    n10 |= 1;
                                }
                                iterable = this.path_;
                                n13 = ((CodedInputStream)object).readInt32();
                                iterable.addInt(n13);
                                continue;
                            }
                        }
                        n11 = n13;
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
            int n16 = n10 & 1;
            if (n16 != 0) {
                object2 = this.path_;
                object2.makeImmutable();
            }
            if ((n16 = n10 & 2) != 0) {
                object2 = this.span_;
                object2.makeImmutable();
            }
            if ((n16 = n10 & 0x10) != 0) {
                this.leadingDetachedComments_ = object2 = this.leadingDetachedComments_.getUnmodifiableView();
            }
            this.unknownFields = object2 = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
            throw throwable2;
        }
        int n17 = n10 & 1;
        if (n17 != 0) {
            object = this.path_;
            object.makeImmutable();
        }
        if ((n17 = n10 & 2) != 0) {
            object = this.span_;
            object.makeImmutable();
        }
        if ((n17 = n10 & 0x10) != 0) {
            this.leadingDetachedComments_ = object = this.leadingDetachedComments_.getUnmodifiableView();
        }
        this.unknownFields = object = unknownFieldSet$Builder.build();
        this.makeExtensionsImmutable();
    }

    public /* synthetic */ DescriptorProtos$SourceCodeInfo$Location(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private DescriptorProtos$SourceCodeInfo$Location(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
        int n10;
        this.pathMemoizedSerializedSize = n10 = -1;
        this.spanMemoizedSerializedSize = n10;
        this.memoizedIsInitialized = (byte)n10;
    }

    public /* synthetic */ DescriptorProtos$SourceCodeInfo$Location(GeneratedMessageV3$Builder generatedMessageV3$Builder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ Internal$IntList access$27800(DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location) {
        return descriptorProtos$SourceCodeInfo$Location.path_;
    }

    public static /* synthetic */ Internal$IntList access$27802(DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location, Internal$IntList internal$IntList) {
        descriptorProtos$SourceCodeInfo$Location.path_ = internal$IntList;
        return internal$IntList;
    }

    public static /* synthetic */ Internal$IntList access$27900(DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location) {
        return descriptorProtos$SourceCodeInfo$Location.span_;
    }

    public static /* synthetic */ Internal$IntList access$27902(DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location, Internal$IntList internal$IntList) {
        descriptorProtos$SourceCodeInfo$Location.span_ = internal$IntList;
        return internal$IntList;
    }

    public static /* synthetic */ Object access$28000(DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location) {
        return descriptorProtos$SourceCodeInfo$Location.leadingComments_;
    }

    public static /* synthetic */ Object access$28002(DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location, Object object) {
        descriptorProtos$SourceCodeInfo$Location.leadingComments_ = object;
        return object;
    }

    public static /* synthetic */ Object access$28100(DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location) {
        return descriptorProtos$SourceCodeInfo$Location.trailingComments_;
    }

    public static /* synthetic */ Object access$28102(DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location, Object object) {
        descriptorProtos$SourceCodeInfo$Location.trailingComments_ = object;
        return object;
    }

    public static /* synthetic */ LazyStringList access$28200(DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location) {
        return descriptorProtos$SourceCodeInfo$Location.leadingDetachedComments_;
    }

    public static /* synthetic */ LazyStringList access$28202(DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location, LazyStringList lazyStringList) {
        descriptorProtos$SourceCodeInfo$Location.leadingDetachedComments_ = lazyStringList;
        return lazyStringList;
    }

    public static /* synthetic */ int access$28302(DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location, int n10) {
        descriptorProtos$SourceCodeInfo$Location.bitField0_ = n10;
        return n10;
    }

    public static DescriptorProtos$SourceCodeInfo$Location getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$27300();
    }

    public static DescriptorProtos$SourceCodeInfo$Location$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$SourceCodeInfo$Location$Builder newBuilder(DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$SourceCodeInfo$Location);
    }

    public static DescriptorProtos$SourceCodeInfo$Location parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$SourceCodeInfo$Location)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$SourceCodeInfo$Location parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$SourceCodeInfo$Location)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$SourceCodeInfo$Location parseFrom(ByteString byteString) {
        return (DescriptorProtos$SourceCodeInfo$Location)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$SourceCodeInfo$Location parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$SourceCodeInfo$Location)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$SourceCodeInfo$Location parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$SourceCodeInfo$Location)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static DescriptorProtos$SourceCodeInfo$Location parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$SourceCodeInfo$Location)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$SourceCodeInfo$Location parseFrom(InputStream inputStream) {
        return (DescriptorProtos$SourceCodeInfo$Location)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$SourceCodeInfo$Location parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$SourceCodeInfo$Location)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$SourceCodeInfo$Location parseFrom(ByteBuffer byteBuffer) {
        return (DescriptorProtos$SourceCodeInfo$Location)PARSER.parseFrom(byteBuffer);
    }

    public static DescriptorProtos$SourceCodeInfo$Location parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$SourceCodeInfo$Location)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static DescriptorProtos$SourceCodeInfo$Location parseFrom(byte[] byArray) {
        return (DescriptorProtos$SourceCodeInfo$Location)PARSER.parseFrom(byArray);
    }

    public static DescriptorProtos$SourceCodeInfo$Location parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$SourceCodeInfo$Location)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        boolean bl2;
        Object object2;
        boolean bl3 = true;
        if (object == this) {
            return bl3;
        }
        boolean bl4 = object instanceof DescriptorProtos$SourceCodeInfo$Location;
        if (!bl4) {
            return super.equals(object);
        }
        object = (DescriptorProtos$SourceCodeInfo$Location)object;
        Object object3 = this.getPathList();
        List list = ((DescriptorProtos$SourceCodeInfo$Location)object).getPathList();
        bl4 = object3.equals(list);
        list = null;
        if (!bl4) {
            return false;
        }
        object3 = this.getSpanList();
        bl4 = object3.equals(object2 = ((DescriptorProtos$SourceCodeInfo$Location)object).getSpanList());
        if (!bl4) {
            return false;
        }
        bl4 = this.hasLeadingComments();
        if (bl4 != (bl2 = ((DescriptorProtos$SourceCodeInfo$Location)object).hasLeadingComments())) {
            return false;
        }
        bl4 = this.hasLeadingComments();
        if (bl4 && !(bl4 = ((String)(object3 = this.getLeadingComments())).equals(object2 = ((DescriptorProtos$SourceCodeInfo$Location)object).getLeadingComments()))) {
            return false;
        }
        bl4 = this.hasTrailingComments();
        if (bl4 != (bl2 = ((DescriptorProtos$SourceCodeInfo$Location)object).hasTrailingComments())) {
            return false;
        }
        bl4 = this.hasTrailingComments();
        if (bl4 && !(bl4 = ((String)(object3 = this.getTrailingComments())).equals(object2 = ((DescriptorProtos$SourceCodeInfo$Location)object).getTrailingComments()))) {
            return false;
        }
        object3 = this.getLeadingDetachedCommentsList();
        bl4 = object3.equals(object2 = ((DescriptorProtos$SourceCodeInfo$Location)object).getLeadingDetachedCommentsList());
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

    public DescriptorProtos$SourceCodeInfo$Location getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public String getLeadingComments() {
        Object object = this.leadingComments_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.leadingComments_ = string2;
        }
        return string2;
    }

    public ByteString getLeadingCommentsBytes() {
        Object object = this.leadingComments_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.leadingComments_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public String getLeadingDetachedComments(int n10) {
        return (String)this.leadingDetachedComments_.get(n10);
    }

    public ByteString getLeadingDetachedCommentsBytes(int n10) {
        return this.leadingDetachedComments_.getByteString(n10);
    }

    public int getLeadingDetachedCommentsCount() {
        return this.leadingDetachedComments_.size();
    }

    public ProtocolStringList getLeadingDetachedCommentsList() {
        return this.leadingDetachedComments_;
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
        Object object;
        int n11;
        int n12 = this.memoizedSize;
        int n13 = -1;
        if (n12 != n13) {
            return n12;
        }
        n12 = 0;
        int n14 = 0;
        List list = null;
        for (n13 = 0; n13 < (n11 = (object = this.path_).size()); ++n13) {
            object = this.path_;
            n11 = CodedOutputStream.computeInt32SizeNoTag(object.getInt(n13));
            n14 += n11;
        }
        n13 = 0 + n14;
        object = this.getPathList();
        n11 = (int)(object.isEmpty() ? 1 : 0);
        if (n11 == 0) {
            ++n13;
            n11 = CodedOutputStream.computeInt32SizeNoTag(n14);
            n13 += n11;
        }
        this.pathMemoizedSerializedSize = n14;
        list = null;
        n11 = 0;
        object = null;
        for (n14 = 0; n14 < (n10 = (internal$IntList = this.span_).size()); ++n14) {
            internal$IntList = this.span_;
            n10 = CodedOutputStream.computeInt32SizeNoTag(internal$IntList.getInt(n14));
            n11 += n10;
        }
        n13 += n11;
        list = this.getSpanList();
        n14 = (int)(list.isEmpty() ? 1 : 0);
        if (n14 == 0) {
            ++n13;
            n14 = CodedOutputStream.computeInt32SizeNoTag(n11);
            n13 += n14;
        }
        this.spanMemoizedSerializedSize = n11;
        n14 = this.bitField0_ & 1;
        if (n14 != 0) {
            object = this.leadingComments_;
            n14 = GeneratedMessageV3.computeStringSize(3, object);
            n13 += n14;
        }
        if ((n14 = this.bitField0_ & 2) != 0) {
            object = this.trailingComments_;
            n14 = GeneratedMessageV3.computeStringSize(4, object);
            n13 += n14;
        }
        n14 = 0;
        list = null;
        while (n12 < (n11 = (object = this.leadingDetachedComments_).size())) {
            object = this.leadingDetachedComments_.getRaw(n12);
            n11 = GeneratedMessageV3.computeStringSizeNoTag(object);
            n14 += n11;
            ++n12;
        }
        n13 += n14;
        n12 = this.getLeadingDetachedCommentsList().size() * 1;
        n13 += n12;
        n12 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n13 += n12;
        return n13;
    }

    public int getSpan(int n10) {
        return this.span_.getInt(n10);
    }

    public int getSpanCount() {
        return this.span_.size();
    }

    public List getSpanList() {
        return this.span_;
    }

    public String getTrailingComments() {
        Object object = this.trailingComments_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.trailingComments_ = string2;
        }
        return string2;
    }

    public ByteString getTrailingCommentsBytes() {
        Object object = this.trailingComments_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.trailingComments_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public boolean hasLeadingComments() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean hasTrailingComments() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = DescriptorProtos$SourceCodeInfo$Location.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = this.getPathCount();
        if (n11 > 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getPathList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = this.getSpanCount()) > 0) {
            n10 = (n10 * 37 + 2) * 53;
            object = this.getSpanList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasLeadingComments() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 3) * 53;
            object = this.getLeadingComments();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasTrailingComments() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 4) * 53;
            object = this.getTrailingComments();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = this.getLeadingDetachedCommentsCount()) > 0) {
            n10 = (n10 * 37 + 6) * 53;
            object = this.getLeadingDetachedCommentsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$27400().ensureFieldAccessorsInitialized(DescriptorProtos$SourceCodeInfo$Location.class, DescriptorProtos$SourceCodeInfo$Location$Builder.class);
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

    public DescriptorProtos$SourceCodeInfo$Location$Builder newBuilderForType() {
        return DescriptorProtos$SourceCodeInfo$Location.newBuilder();
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        DescriptorProtos$SourceCodeInfo$Location$Builder descriptorProtos$SourceCodeInfo$Location$Builder = new DescriptorProtos$SourceCodeInfo$Location$Builder(generatedMessageV3$BuilderParent, null);
        return descriptorProtos$SourceCodeInfo$Location$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new DescriptorProtos$SourceCodeInfo$Location();
        return object;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder toBuilder() {
        DescriptorProtos$SourceCodeInfo$LocationOrBuilder descriptorProtos$SourceCodeInfo$LocationOrBuilder = DEFAULT_INSTANCE;
        if (this == descriptorProtos$SourceCodeInfo$LocationOrBuilder) {
            descriptorProtos$SourceCodeInfo$LocationOrBuilder = new DescriptorProtos$SourceCodeInfo$Location$Builder(null);
        } else {
            descriptorProtos$SourceCodeInfo$LocationOrBuilder = new DescriptorProtos$SourceCodeInfo$Location$Builder(null);
            descriptorProtos$SourceCodeInfo$LocationOrBuilder = ((DescriptorProtos$SourceCodeInfo$Location$Builder)descriptorProtos$SourceCodeInfo$LocationOrBuilder).mergeFrom(this);
        }
        return descriptorProtos$SourceCodeInfo$LocationOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        Object object;
        int n10;
        int n11;
        this.getSerializedSize();
        List list = this.getPathList();
        int n12 = list.size();
        if (n12 > 0) {
            codedOutputStream.writeUInt32NoTag(10);
            n12 = this.pathMemoizedSerializedSize;
            codedOutputStream.writeUInt32NoTag(n12);
        }
        n12 = 0;
        list = null;
        List list2 = null;
        for (n11 = 0; n11 < (n10 = (object = this.path_).size()); ++n11) {
            object = this.path_;
            n10 = object.getInt(n11);
            codedOutputStream.writeInt32NoTag(n10);
        }
        list2 = this.getSpanList();
        n11 = list2.size();
        if (n11 > 0) {
            codedOutputStream.writeUInt32NoTag(18);
            n11 = this.spanMemoizedSerializedSize;
            codedOutputStream.writeUInt32NoTag(n11);
        }
        list2 = null;
        for (n11 = 0; n11 < (n10 = (object = this.span_).size()); ++n11) {
            object = this.span_;
            n10 = object.getInt(n11);
            codedOutputStream.writeInt32NoTag(n10);
        }
        n11 = this.bitField0_ & 1;
        if (n11 != 0) {
            n11 = 3;
            object = this.leadingComments_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        if ((n11 = this.bitField0_ & 2) != 0) {
            n11 = 4;
            object = this.trailingComments_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        while (n12 < (n11 = (list2 = this.leadingDetachedComments_).size())) {
            n11 = 6;
            object = this.leadingDetachedComments_.getRaw(n12);
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
            ++n12;
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

