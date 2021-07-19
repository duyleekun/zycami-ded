/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FieldMask;
import com.google.protobuf.FieldMask$1;
import com.google.protobuf.FieldMaskOrBuilder;
import com.google.protobuf.FieldMaskProto;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.Objects;

public final class FieldMask$Builder
extends GeneratedMessageV3$Builder
implements FieldMaskOrBuilder {
    private int bitField0_;
    private LazyStringList paths_;

    private FieldMask$Builder() {
        LazyStringList lazyStringList;
        this.paths_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ FieldMask$Builder(FieldMask$1 fieldMask$1) {
        this();
    }

    private FieldMask$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        this.paths_ = object = LazyStringArrayList.EMPTY;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ FieldMask$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, FieldMask$1 fieldMask$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private void ensurePathsIsMutable() {
        int n10 = this.bitField0_ & 1;
        if (n10 == 0) {
            LazyStringList lazyStringList = this.paths_;
            LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(lazyStringList);
            this.paths_ = lazyStringArrayList;
            this.bitField0_ = n10 = this.bitField0_ | 1;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return FieldMaskProto.internal_static_google_protobuf_FieldMask_descriptor;
    }

    private void maybeForceBuilderInitialization() {
    }

    public FieldMask$Builder addAllPaths(Iterable iterable) {
        this.ensurePathsIsMutable();
        LazyStringList lazyStringList = this.paths_;
        AbstractMessageLite$Builder.addAll(iterable, lazyStringList);
        this.onChanged();
        return this;
    }

    public FieldMask$Builder addPaths(String string2) {
        Objects.requireNonNull(string2);
        this.ensurePathsIsMutable();
        this.paths_.add(string2);
        this.onChanged();
        return this;
    }

    public FieldMask$Builder addPathsBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.ensurePathsIsMutable();
        this.paths_.add(byteString);
        this.onChanged();
        return this;
    }

    public FieldMask$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (FieldMask$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public FieldMask build() {
        FieldMask fieldMask = this.buildPartial();
        boolean bl2 = fieldMask.isInitialized();
        if (bl2) {
            return fieldMask;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(fieldMask);
    }

    public FieldMask buildPartial() {
        LazyStringList lazyStringList = null;
        FieldMask fieldMask = new FieldMask(this, null);
        int n10 = this.bitField0_ & 1;
        if (n10 != 0) {
            this.paths_ = lazyStringList = this.paths_.getUnmodifiableView();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        }
        lazyStringList = this.paths_;
        FieldMask.access$302(fieldMask, lazyStringList);
        this.onBuilt();
        return fieldMask;
    }

    public FieldMask$Builder clear() {
        int n10;
        LazyStringList lazyStringList;
        super.clear();
        this.paths_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        return this;
    }

    public FieldMask$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (FieldMask$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public FieldMask$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (FieldMask$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public FieldMask$Builder clearPaths() {
        int n10;
        LazyStringList lazyStringList;
        this.paths_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.onChanged();
        return this;
    }

    public FieldMask$Builder clone() {
        return (FieldMask$Builder)super.clone();
    }

    public FieldMask getDefaultInstanceForType() {
        return FieldMask.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return FieldMaskProto.internal_static_google_protobuf_FieldMask_descriptor;
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
        return this.paths_.getUnmodifiableView();
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return FieldMaskProto.internal_static_google_protobuf_FieldMask_fieldAccessorTable.ensureFieldAccessorsInitialized(FieldMask.class, FieldMask$Builder.class);
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
    public FieldMask$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = FieldMask.access$400();
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (FieldMask)object;
            if (object == null) break block7;
            this.mergeFrom((FieldMask)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (FieldMask)object2;
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
            this.mergeFrom((FieldMask)object3);
        }
        throw var1_6;
    }

    public FieldMask$Builder mergeFrom(FieldMask messageLite) {
        Object object = FieldMask.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        object = FieldMask.access$300(messageLite);
        int n10 = object.isEmpty();
        if (n10 == 0) {
            object = this.paths_;
            n10 = object.isEmpty();
            if (n10 != 0) {
                this.paths_ = object = FieldMask.access$300(messageLite);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
            } else {
                this.ensurePathsIsMutable();
                object = this.paths_;
                LazyStringList lazyStringList = FieldMask.access$300(messageLite);
                object.addAll(lazyStringList);
            }
            this.onChanged();
        }
        messageLite = messageLite.unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public FieldMask$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof FieldMask;
        if (bl2) {
            message = (FieldMask)message;
            return this.mergeFrom((FieldMask)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final FieldMask$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (FieldMask$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public FieldMask$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (FieldMask$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public FieldMask$Builder setPaths(int n10, String string2) {
        Objects.requireNonNull(string2);
        this.ensurePathsIsMutable();
        this.paths_.set(n10, string2);
        this.onChanged();
        return this;
    }

    public FieldMask$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (FieldMask$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final FieldMask$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (FieldMask$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

