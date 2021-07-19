/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$Location;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.Internal$IntList;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class DescriptorProtos$SourceCodeInfo$Location$Builder
extends GeneratedMessageV3$Builder
implements DescriptorProtos$SourceCodeInfo$LocationOrBuilder {
    private int bitField0_;
    private Object leadingComments_;
    private LazyStringList leadingDetachedComments_;
    private Internal$IntList path_;
    private Internal$IntList span_;
    private Object trailingComments_;

    private DescriptorProtos$SourceCodeInfo$Location$Builder() {
        Object object = GeneratedMessageV3.emptyIntList();
        this.path_ = object;
        object = GeneratedMessageV3.emptyIntList();
        this.span_ = object;
        this.leadingComments_ = object = "";
        this.trailingComments_ = object;
        this.leadingDetachedComments_ = object = LazyStringArrayList.EMPTY;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$SourceCodeInfo$Location$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    private DescriptorProtos$SourceCodeInfo$Location$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        this.path_ = object = GeneratedMessageV3.emptyIntList();
        this.span_ = object = GeneratedMessageV3.emptyIntList();
        this.leadingComments_ = object = "";
        this.trailingComments_ = object;
        this.leadingDetachedComments_ = object = LazyStringArrayList.EMPTY;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$SourceCodeInfo$Location$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private void ensureLeadingDetachedCommentsIsMutable() {
        int n10 = this.bitField0_ & 0x10;
        if (n10 == 0) {
            LazyStringList lazyStringList = this.leadingDetachedComments_;
            LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(lazyStringList);
            this.leadingDetachedComments_ = lazyStringArrayList;
            this.bitField0_ = n10 = this.bitField0_ | 0x10;
        }
    }

    private void ensurePathIsMutable() {
        int n10 = this.bitField0_ & 1;
        if (n10 == 0) {
            Internal$IntList internal$IntList;
            this.path_ = internal$IntList = GeneratedMessageV3.mutableCopy(this.path_);
            this.bitField0_ = n10 = this.bitField0_ | 1;
        }
    }

    private void ensureSpanIsMutable() {
        int n10 = this.bitField0_ & 2;
        if (n10 == 0) {
            Internal$IntList internal$IntList;
            this.span_ = internal$IntList = GeneratedMessageV3.mutableCopy(this.span_);
            this.bitField0_ = n10 = this.bitField0_ | 2;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$27300();
    }

    private void maybeForceBuilderInitialization() {
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder addAllLeadingDetachedComments(Iterable iterable) {
        this.ensureLeadingDetachedCommentsIsMutable();
        LazyStringList lazyStringList = this.leadingDetachedComments_;
        AbstractMessageLite$Builder.addAll(iterable, lazyStringList);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder addAllPath(Iterable iterable) {
        this.ensurePathIsMutable();
        Internal$IntList internal$IntList = this.path_;
        AbstractMessageLite$Builder.addAll(iterable, internal$IntList);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder addAllSpan(Iterable iterable) {
        this.ensureSpanIsMutable();
        Internal$IntList internal$IntList = this.span_;
        AbstractMessageLite$Builder.addAll(iterable, internal$IntList);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder addLeadingDetachedComments(String string2) {
        Objects.requireNonNull(string2);
        this.ensureLeadingDetachedCommentsIsMutable();
        this.leadingDetachedComments_.add(string2);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder addLeadingDetachedCommentsBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        this.ensureLeadingDetachedCommentsIsMutable();
        this.leadingDetachedComments_.add(byteString);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder addPath(int n10) {
        this.ensurePathIsMutable();
        this.path_.addInt(n10);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$SourceCodeInfo$Location$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder addSpan(int n10) {
        this.ensureSpanIsMutable();
        this.span_.addInt(n10);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location build() {
        DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location = this.buildPartial();
        boolean bl2 = descriptorProtos$SourceCodeInfo$Location.isInitialized();
        if (bl2) {
            return descriptorProtos$SourceCodeInfo$Location;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(descriptorProtos$SourceCodeInfo$Location);
    }

    public DescriptorProtos$SourceCodeInfo$Location buildPartial() {
        Internal$IntList internal$IntList;
        Object object = null;
        DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location = new DescriptorProtos$SourceCodeInfo$Location(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        if (n11 != 0) {
            internal$IntList = this.path_;
            internal$IntList.makeImmutable();
            this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
        }
        internal$IntList = this.path_;
        DescriptorProtos$SourceCodeInfo$Location.access$27802(descriptorProtos$SourceCodeInfo$Location, internal$IntList);
        n11 = this.bitField0_ & 2;
        if (n11 != 0) {
            internal$IntList = this.span_;
            internal$IntList.makeImmutable();
            this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFD;
        }
        internal$IntList = this.span_;
        DescriptorProtos$SourceCodeInfo$Location.access$27902(descriptorProtos$SourceCodeInfo$Location, internal$IntList);
        n11 = n10 & 4;
        if (n11 != 0) {
            n11 = 1;
        } else {
            n11 = 0;
            internal$IntList = null;
        }
        Object object2 = this.leadingComments_;
        DescriptorProtos$SourceCodeInfo$Location.access$28002(descriptorProtos$SourceCodeInfo$Location, object2);
        if ((n10 &= 8) != 0) {
            n11 |= 2;
        }
        object = this.trailingComments_;
        DescriptorProtos$SourceCodeInfo$Location.access$28102(descriptorProtos$SourceCodeInfo$Location, object);
        n10 = this.bitField0_ & 0x10;
        if (n10 != 0) {
            this.leadingDetachedComments_ = object = this.leadingDetachedComments_.getUnmodifiableView();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
        }
        object = this.leadingDetachedComments_;
        DescriptorProtos$SourceCodeInfo$Location.access$28202(descriptorProtos$SourceCodeInfo$Location, (LazyStringList)object);
        DescriptorProtos$SourceCodeInfo$Location.access$28302(descriptorProtos$SourceCodeInfo$Location, n11);
        this.onBuilt();
        return descriptorProtos$SourceCodeInfo$Location;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder clear() {
        Object object;
        int n10;
        Internal$IntList internal$IntList;
        super.clear();
        this.path_ = internal$IntList = GeneratedMessageV3.emptyIntList();
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.span_ = internal$IntList = GeneratedMessageV3.emptyIntList();
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.leadingComments_ = object = "";
        this.bitField0_ = n10 &= 0xFFFFFFFB;
        this.trailingComments_ = object;
        this.bitField0_ = n10 &= 0xFFFFFFF7;
        this.leadingDetachedComments_ = object = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 &= 0xFFFFFFEF;
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (DescriptorProtos$SourceCodeInfo$Location$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder clearLeadingComments() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        String string2 = DescriptorProtos$SourceCodeInfo$Location.getDefaultInstance().getLeadingComments();
        this.leadingComments_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder clearLeadingDetachedComments() {
        int n10;
        LazyStringList lazyStringList;
        this.leadingDetachedComments_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (DescriptorProtos$SourceCodeInfo$Location$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder clearPath() {
        int n10;
        Internal$IntList internal$IntList;
        this.path_ = internal$IntList = GeneratedMessageV3.emptyIntList();
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder clearSpan() {
        int n10;
        Internal$IntList internal$IntList;
        this.span_ = internal$IntList = GeneratedMessageV3.emptyIntList();
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder clearTrailingComments() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        String string2 = DescriptorProtos$SourceCodeInfo$Location.getDefaultInstance().getTrailingComments();
        this.trailingComments_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder clone() {
        return (DescriptorProtos$SourceCodeInfo$Location$Builder)super.clone();
    }

    public DescriptorProtos$SourceCodeInfo$Location getDefaultInstanceForType() {
        return DescriptorProtos$SourceCodeInfo$Location.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$27300();
    }

    public String getLeadingComments() {
        Object object = this.leadingComments_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.leadingComments_ = string2;
            }
            return string2;
        }
        return (String)object;
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
        return this.leadingDetachedComments_.getUnmodifiableView();
    }

    public int getPath(int n10) {
        return this.path_.getInt(n10);
    }

    public int getPathCount() {
        return this.path_.size();
    }

    public List getPathList() {
        int n10 = this.bitField0_ & 1;
        List list = n10 != 0 ? Collections.unmodifiableList(this.path_) : this.path_;
        return list;
    }

    public int getSpan(int n10) {
        return this.span_.getInt(n10);
    }

    public int getSpanCount() {
        return this.span_.size();
    }

    public List getSpanList() {
        int n10 = this.bitField0_ & 2;
        List list = n10 != 0 ? Collections.unmodifiableList(this.span_) : this.span_;
        return list;
    }

    public String getTrailingComments() {
        Object object = this.trailingComments_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.trailingComments_ = string2;
            }
            return string2;
        }
        return (String)object;
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

    public boolean hasLeadingComments() {
        int n10 = this.bitField0_ & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasTrailingComments() {
        int n10 = this.bitField0_ & 8;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$27400().ensureFieldAccessorsInitialized(DescriptorProtos$SourceCodeInfo$Location.class, DescriptorProtos$SourceCodeInfo$Location$Builder.class);
    }

    public final boolean isInitialized() {
        return true;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public DescriptorProtos$SourceCodeInfo$Location$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = DescriptorProtos$SourceCodeInfo$Location.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (DescriptorProtos$SourceCodeInfo$Location)object;
            if (object == null) break block7;
            this.mergeFrom((DescriptorProtos$SourceCodeInfo$Location)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (DescriptorProtos$SourceCodeInfo$Location)object2;
            }
            try {
                IOException iOException = invalidProtocolBufferException.unwrapIOException();
                throw iOException;
            }
            catch (Throwable throwable) {
                object3 = object2;
            }
        }
        if (object3 != null) {
            this.mergeFrom((DescriptorProtos$SourceCodeInfo$Location)object3);
        }
        throw var1_6;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder mergeFrom(DescriptorProtos$SourceCodeInfo$Location messageLite) {
        List list;
        Object object = DescriptorProtos$SourceCodeInfo$Location.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        object = DescriptorProtos$SourceCodeInfo$Location.access$27800(messageLite);
        int n10 = object.isEmpty();
        if (n10 == 0) {
            object = this.path_;
            n10 = object.isEmpty();
            if (n10 != 0) {
                this.path_ = object = DescriptorProtos$SourceCodeInfo$Location.access$27800(messageLite);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
            } else {
                this.ensurePathIsMutable();
                object = this.path_;
                list = DescriptorProtos$SourceCodeInfo$Location.access$27800(messageLite);
                object.addAll(list);
            }
            this.onChanged();
        }
        if ((n10 = (object = DescriptorProtos$SourceCodeInfo$Location.access$27900(messageLite)).isEmpty()) == 0) {
            object = this.span_;
            n10 = object.isEmpty();
            if (n10 != 0) {
                this.span_ = object = DescriptorProtos$SourceCodeInfo$Location.access$27900(messageLite);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
            } else {
                this.ensureSpanIsMutable();
                object = this.span_;
                list = DescriptorProtos$SourceCodeInfo$Location.access$27900(messageLite);
                object.addAll(list);
            }
            this.onChanged();
        }
        if ((n10 = messageLite.hasLeadingComments()) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 4;
            this.leadingComments_ = object = DescriptorProtos$SourceCodeInfo$Location.access$28000(messageLite);
            this.onChanged();
        }
        if ((n10 = messageLite.hasTrailingComments()) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 8;
            this.trailingComments_ = object = DescriptorProtos$SourceCodeInfo$Location.access$28100(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)((object = DescriptorProtos$SourceCodeInfo$Location.access$28200(messageLite)).isEmpty() ? 1 : 0)) == 0) {
            object = this.leadingDetachedComments_;
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 != 0) {
                this.leadingDetachedComments_ = object = DescriptorProtos$SourceCodeInfo$Location.access$28200(messageLite);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
            } else {
                this.ensureLeadingDetachedCommentsIsMutable();
                object = this.leadingDetachedComments_;
                list = DescriptorProtos$SourceCodeInfo$Location.access$28200(messageLite);
                object.addAll(list);
            }
            this.onChanged();
        }
        messageLite = messageLite.unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof DescriptorProtos$SourceCodeInfo$Location;
        if (bl2) {
            message = (DescriptorProtos$SourceCodeInfo$Location)message;
            return this.mergeFrom((DescriptorProtos$SourceCodeInfo$Location)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final DescriptorProtos$SourceCodeInfo$Location$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$SourceCodeInfo$Location$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$SourceCodeInfo$Location$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder setLeadingComments(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.leadingComments_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder setLeadingCommentsBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.leadingComments_ = byteString;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder setLeadingDetachedComments(int n10, String string2) {
        Objects.requireNonNull(string2);
        this.ensureLeadingDetachedCommentsIsMutable();
        this.leadingDetachedComments_.set(n10, string2);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder setPath(int n10, int n11) {
        this.ensurePathIsMutable();
        this.path_.setInt(n10, n11);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (DescriptorProtos$SourceCodeInfo$Location$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder setSpan(int n10, int n11) {
        this.ensureSpanIsMutable();
        this.span_.setInt(n10, n11);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder setTrailingComments(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.trailingComments_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder setTrailingCommentsBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.trailingComments_ = byteString;
        this.onChanged();
        return this;
    }

    public final DescriptorProtos$SourceCodeInfo$Location$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$SourceCodeInfo$Location$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

