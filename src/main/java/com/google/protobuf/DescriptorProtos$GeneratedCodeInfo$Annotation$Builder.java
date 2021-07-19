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
import com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$Annotation;
import com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder;
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
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class DescriptorProtos$GeneratedCodeInfo$Annotation$Builder
extends GeneratedMessageV3$Builder
implements DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder {
    private int begin_;
    private int bitField0_;
    private int end_;
    private Internal$IntList path_;
    private Object sourceFile_;

    private DescriptorProtos$GeneratedCodeInfo$Annotation$Builder() {
        Internal$IntList internal$IntList;
        this.path_ = internal$IntList = GeneratedMessageV3.emptyIntList();
        this.sourceFile_ = "";
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$GeneratedCodeInfo$Annotation$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    private DescriptorProtos$GeneratedCodeInfo$Annotation$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        this.path_ = object = GeneratedMessageV3.emptyIntList();
        this.sourceFile_ = "";
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$GeneratedCodeInfo$Annotation$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private void ensurePathIsMutable() {
        int n10 = this.bitField0_ & 1;
        if (n10 == 0) {
            Internal$IntList internal$IntList;
            this.path_ = internal$IntList = GeneratedMessageV3.mutableCopy(this.path_);
            this.bitField0_ = n10 = this.bitField0_ | 1;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$29200();
    }

    private void maybeForceBuilderInitialization() {
    }

    public DescriptorProtos$GeneratedCodeInfo$Annotation$Builder addAllPath(Iterable iterable) {
        this.ensurePathIsMutable();
        Internal$IntList internal$IntList = this.path_;
        AbstractMessageLite$Builder.addAll(iterable, internal$IntList);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$GeneratedCodeInfo$Annotation$Builder addPath(int n10) {
        this.ensurePathIsMutable();
        this.path_.addInt(n10);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$GeneratedCodeInfo$Annotation$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$GeneratedCodeInfo$Annotation$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$GeneratedCodeInfo$Annotation build() {
        DescriptorProtos$GeneratedCodeInfo$Annotation descriptorProtos$GeneratedCodeInfo$Annotation = this.buildPartial();
        boolean bl2 = descriptorProtos$GeneratedCodeInfo$Annotation.isInitialized();
        if (bl2) {
            return descriptorProtos$GeneratedCodeInfo$Annotation;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(descriptorProtos$GeneratedCodeInfo$Annotation);
    }

    public DescriptorProtos$GeneratedCodeInfo$Annotation buildPartial() {
        Internal$IntList internal$IntList;
        DescriptorProtos$GeneratedCodeInfo$Annotation descriptorProtos$GeneratedCodeInfo$Annotation = new DescriptorProtos$GeneratedCodeInfo$Annotation(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        if (n11 != 0) {
            internal$IntList = this.path_;
            internal$IntList.makeImmutable();
            this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
        }
        internal$IntList = this.path_;
        DescriptorProtos$GeneratedCodeInfo$Annotation.access$29702(descriptorProtos$GeneratedCodeInfo$Annotation, internal$IntList);
        n11 = n10 & 2;
        if (n11 != 0) {
            n11 = 1;
        } else {
            n11 = 0;
            internal$IntList = null;
        }
        Object object = this.sourceFile_;
        DescriptorProtos$GeneratedCodeInfo$Annotation.access$29802(descriptorProtos$GeneratedCodeInfo$Annotation, object);
        int n12 = n10 & 4;
        if (n12 != 0) {
            n12 = this.begin_;
            DescriptorProtos$GeneratedCodeInfo$Annotation.access$29902(descriptorProtos$GeneratedCodeInfo$Annotation, n12);
            n11 |= 2;
        }
        if ((n10 &= 8) != 0) {
            n10 = this.end_;
            DescriptorProtos$GeneratedCodeInfo$Annotation.access$30002(descriptorProtos$GeneratedCodeInfo$Annotation, n10);
            n11 |= 4;
        }
        DescriptorProtos$GeneratedCodeInfo$Annotation.access$30102(descriptorProtos$GeneratedCodeInfo$Annotation, n11);
        this.onBuilt();
        return descriptorProtos$GeneratedCodeInfo$Annotation;
    }

    public DescriptorProtos$GeneratedCodeInfo$Annotation$Builder clear() {
        int n10;
        Internal$IntList internal$IntList;
        super.clear();
        this.path_ = internal$IntList = GeneratedMessageV3.emptyIntList();
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.sourceFile_ = "";
        this.bitField0_ = n10 &= 0xFFFFFFFD;
        this.begin_ = 0;
        this.bitField0_ = n10 &= 0xFFFFFFFB;
        this.end_ = 0;
        this.bitField0_ = n10 &= 0xFFFFFFF7;
        return this;
    }

    public DescriptorProtos$GeneratedCodeInfo$Annotation$Builder clearBegin() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        this.begin_ = 0;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$GeneratedCodeInfo$Annotation$Builder clearEnd() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        this.end_ = 0;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$GeneratedCodeInfo$Annotation$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (DescriptorProtos$GeneratedCodeInfo$Annotation$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public DescriptorProtos$GeneratedCodeInfo$Annotation$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (DescriptorProtos$GeneratedCodeInfo$Annotation$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public DescriptorProtos$GeneratedCodeInfo$Annotation$Builder clearPath() {
        int n10;
        Internal$IntList internal$IntList;
        this.path_ = internal$IntList = GeneratedMessageV3.emptyIntList();
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$GeneratedCodeInfo$Annotation$Builder clearSourceFile() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        String string2 = DescriptorProtos$GeneratedCodeInfo$Annotation.getDefaultInstance().getSourceFile();
        this.sourceFile_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$GeneratedCodeInfo$Annotation$Builder clone() {
        return (DescriptorProtos$GeneratedCodeInfo$Annotation$Builder)super.clone();
    }

    public int getBegin() {
        return this.begin_;
    }

    public DescriptorProtos$GeneratedCodeInfo$Annotation getDefaultInstanceForType() {
        return DescriptorProtos$GeneratedCodeInfo$Annotation.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$29200();
    }

    public int getEnd() {
        return this.end_;
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

    public String getSourceFile() {
        Object object = this.sourceFile_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.sourceFile_ = string2;
            }
            return string2;
        }
        return (String)object;
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

    public boolean hasBegin() {
        int n10 = this.bitField0_ & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasEnd() {
        int n10 = this.bitField0_ & 8;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasSourceFile() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$29300().ensureFieldAccessorsInitialized(DescriptorProtos$GeneratedCodeInfo$Annotation.class, DescriptorProtos$GeneratedCodeInfo$Annotation$Builder.class);
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
    public DescriptorProtos$GeneratedCodeInfo$Annotation$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = DescriptorProtos$GeneratedCodeInfo$Annotation.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (DescriptorProtos$GeneratedCodeInfo$Annotation)object;
            if (object == null) break block7;
            this.mergeFrom((DescriptorProtos$GeneratedCodeInfo$Annotation)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (DescriptorProtos$GeneratedCodeInfo$Annotation)object2;
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
            this.mergeFrom((DescriptorProtos$GeneratedCodeInfo$Annotation)object3);
        }
        throw var1_6;
    }

    public DescriptorProtos$GeneratedCodeInfo$Annotation$Builder mergeFrom(DescriptorProtos$GeneratedCodeInfo$Annotation messageLite) {
        Object object = DescriptorProtos$GeneratedCodeInfo$Annotation.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        object = DescriptorProtos$GeneratedCodeInfo$Annotation.access$29700(messageLite);
        int n10 = object.isEmpty();
        if (n10 == 0) {
            object = this.path_;
            n10 = object.isEmpty();
            if (n10 != 0) {
                this.path_ = object = DescriptorProtos$GeneratedCodeInfo$Annotation.access$29700(messageLite);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
            } else {
                this.ensurePathIsMutable();
                object = this.path_;
                Internal$IntList internal$IntList = DescriptorProtos$GeneratedCodeInfo$Annotation.access$29700(messageLite);
                object.addAll(internal$IntList);
            }
            this.onChanged();
        }
        if ((n10 = messageLite.hasSourceFile()) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 2;
            this.sourceFile_ = object = DescriptorProtos$GeneratedCodeInfo$Annotation.access$29800(messageLite);
            this.onChanged();
        }
        if ((n10 = messageLite.hasBegin()) != 0) {
            n10 = messageLite.getBegin();
            this.setBegin(n10);
        }
        if ((n10 = (int)(messageLite.hasEnd() ? 1 : 0)) != 0) {
            n10 = messageLite.getEnd();
            this.setEnd(n10);
        }
        messageLite = messageLite.unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$GeneratedCodeInfo$Annotation$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof DescriptorProtos$GeneratedCodeInfo$Annotation;
        if (bl2) {
            message = (DescriptorProtos$GeneratedCodeInfo$Annotation)message;
            return this.mergeFrom((DescriptorProtos$GeneratedCodeInfo$Annotation)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final DescriptorProtos$GeneratedCodeInfo$Annotation$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$GeneratedCodeInfo$Annotation$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public DescriptorProtos$GeneratedCodeInfo$Annotation$Builder setBegin(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 4;
        this.begin_ = n10;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$GeneratedCodeInfo$Annotation$Builder setEnd(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 8;
        this.end_ = n10;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$GeneratedCodeInfo$Annotation$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$GeneratedCodeInfo$Annotation$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$GeneratedCodeInfo$Annotation$Builder setPath(int n10, int n11) {
        this.ensurePathIsMutable();
        this.path_.setInt(n10, n11);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$GeneratedCodeInfo$Annotation$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (DescriptorProtos$GeneratedCodeInfo$Annotation$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public DescriptorProtos$GeneratedCodeInfo$Annotation$Builder setSourceFile(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.sourceFile_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$GeneratedCodeInfo$Annotation$Builder setSourceFileBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.sourceFile_ = byteString;
        this.onChanged();
        return this;
    }

    public final DescriptorProtos$GeneratedCodeInfo$Annotation$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$GeneratedCodeInfo$Annotation$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

