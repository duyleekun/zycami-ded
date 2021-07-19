/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$GeneratedCodeInfo;
import com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$Annotation;
import com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$Annotation$Builder;
import com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder;
import com.google.protobuf.DescriptorProtos$GeneratedCodeInfoOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class DescriptorProtos$GeneratedCodeInfo$Builder
extends GeneratedMessageV3$Builder
implements DescriptorProtos$GeneratedCodeInfoOrBuilder {
    private RepeatedFieldBuilderV3 annotationBuilder_;
    private List annotation_;
    private int bitField0_;

    private DescriptorProtos$GeneratedCodeInfo$Builder() {
        List list;
        this.annotation_ = list = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$GeneratedCodeInfo$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    private DescriptorProtos$GeneratedCodeInfo$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        this.annotation_ = object = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$GeneratedCodeInfo$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private void ensureAnnotationIsMutable() {
        int n10 = this.bitField0_ & 1;
        if (n10 == 0) {
            ArrayList arrayList;
            List list = this.annotation_;
            this.annotation_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | 1;
        }
    }

    private RepeatedFieldBuilderV3 getAnnotationFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.annotationBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            List list = this.annotation_;
            int n10 = this.bitField0_;
            int n11 = 1;
            if ((n10 &= n11) == 0) {
                n11 = 0;
            }
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.annotationBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, n11 != 0, generatedMessageV3$BuilderParent, bl2);
            repeatedFieldBuilderV3 = null;
            this.annotation_ = null;
        }
        return this.annotationBuilder_;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$29000();
    }

    private void maybeForceBuilderInitialization() {
        boolean bl2 = GeneratedMessageV3.alwaysUseFieldBuilders;
        if (bl2) {
            this.getAnnotationFieldBuilder();
        }
    }

    public DescriptorProtos$GeneratedCodeInfo$Builder addAllAnnotation(Iterable iterable) {
        Object object = this.annotationBuilder_;
        if (object == null) {
            this.ensureAnnotationIsMutable();
            object = this.annotation_;
            AbstractMessageLite$Builder.addAll(iterable, (List)object);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addAllMessages(iterable);
        }
        return this;
    }

    public DescriptorProtos$GeneratedCodeInfo$Builder addAnnotation(int n10, DescriptorProtos$GeneratedCodeInfo$Annotation$Builder descriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder) {
        Object object = this.annotationBuilder_;
        if (object == null) {
            this.ensureAnnotationIsMutable();
            object = this.annotation_;
            descriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder = ((DescriptorProtos$GeneratedCodeInfo$Annotation$Builder)descriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder).build();
            object.add(n10, descriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder = ((DescriptorProtos$GeneratedCodeInfo$Annotation$Builder)descriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage(n10, (AbstractMessage)((Object)descriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$GeneratedCodeInfo$Builder addAnnotation(int n10, DescriptorProtos$GeneratedCodeInfo$Annotation descriptorProtos$GeneratedCodeInfo$Annotation) {
        Object object = this.annotationBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$GeneratedCodeInfo$Annotation);
            this.ensureAnnotationIsMutable();
            object = this.annotation_;
            object.add(n10, descriptorProtos$GeneratedCodeInfo$Annotation);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(n10, descriptorProtos$GeneratedCodeInfo$Annotation);
        }
        return this;
    }

    public DescriptorProtos$GeneratedCodeInfo$Builder addAnnotation(DescriptorProtos$GeneratedCodeInfo$Annotation$Builder descriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder) {
        Object object = this.annotationBuilder_;
        if (object == null) {
            this.ensureAnnotationIsMutable();
            object = this.annotation_;
            descriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder = ((DescriptorProtos$GeneratedCodeInfo$Annotation$Builder)descriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder).build();
            object.add(descriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder = ((DescriptorProtos$GeneratedCodeInfo$Annotation$Builder)descriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage((AbstractMessage)((Object)descriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$GeneratedCodeInfo$Builder addAnnotation(DescriptorProtos$GeneratedCodeInfo$Annotation descriptorProtos$GeneratedCodeInfo$Annotation) {
        Object object = this.annotationBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$GeneratedCodeInfo$Annotation);
            this.ensureAnnotationIsMutable();
            object = this.annotation_;
            object.add(descriptorProtos$GeneratedCodeInfo$Annotation);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(descriptorProtos$GeneratedCodeInfo$Annotation);
        }
        return this;
    }

    public DescriptorProtos$GeneratedCodeInfo$Annotation$Builder addAnnotationBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getAnnotationFieldBuilder();
        DescriptorProtos$GeneratedCodeInfo$Annotation descriptorProtos$GeneratedCodeInfo$Annotation = DescriptorProtos$GeneratedCodeInfo$Annotation.getDefaultInstance();
        return (DescriptorProtos$GeneratedCodeInfo$Annotation$Builder)repeatedFieldBuilderV3.addBuilder(descriptorProtos$GeneratedCodeInfo$Annotation);
    }

    public DescriptorProtos$GeneratedCodeInfo$Annotation$Builder addAnnotationBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getAnnotationFieldBuilder();
        DescriptorProtos$GeneratedCodeInfo$Annotation descriptorProtos$GeneratedCodeInfo$Annotation = DescriptorProtos$GeneratedCodeInfo$Annotation.getDefaultInstance();
        return (DescriptorProtos$GeneratedCodeInfo$Annotation$Builder)repeatedFieldBuilderV3.addBuilder(n10, descriptorProtos$GeneratedCodeInfo$Annotation);
    }

    public DescriptorProtos$GeneratedCodeInfo$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$GeneratedCodeInfo$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$GeneratedCodeInfo build() {
        DescriptorProtos$GeneratedCodeInfo descriptorProtos$GeneratedCodeInfo = this.buildPartial();
        boolean bl2 = descriptorProtos$GeneratedCodeInfo.isInitialized();
        if (bl2) {
            return descriptorProtos$GeneratedCodeInfo;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(descriptorProtos$GeneratedCodeInfo);
    }

    public DescriptorProtos$GeneratedCodeInfo buildPartial() {
        List list = null;
        DescriptorProtos$GeneratedCodeInfo descriptorProtos$GeneratedCodeInfo = new DescriptorProtos$GeneratedCodeInfo(this, null);
        int n10 = this.bitField0_;
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.annotationBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            if ((n10 &= 1) != 0) {
                this.annotation_ = list = Collections.unmodifiableList(this.annotation_);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
            }
            list = this.annotation_;
            DescriptorProtos$GeneratedCodeInfo.access$30602(descriptorProtos$GeneratedCodeInfo, list);
        } else {
            list = repeatedFieldBuilderV3.build();
            DescriptorProtos$GeneratedCodeInfo.access$30602(descriptorProtos$GeneratedCodeInfo, list);
        }
        this.onBuilt();
        return descriptorProtos$GeneratedCodeInfo;
    }

    public DescriptorProtos$GeneratedCodeInfo$Builder clear() {
        super.clear();
        Object object = this.annotationBuilder_;
        if (object == null) {
            int n10;
            this.annotation_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public DescriptorProtos$GeneratedCodeInfo$Builder clearAnnotation() {
        Object object = this.annotationBuilder_;
        if (object == null) {
            int n10;
            this.annotation_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public DescriptorProtos$GeneratedCodeInfo$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (DescriptorProtos$GeneratedCodeInfo$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public DescriptorProtos$GeneratedCodeInfo$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (DescriptorProtos$GeneratedCodeInfo$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public DescriptorProtos$GeneratedCodeInfo$Builder clone() {
        return (DescriptorProtos$GeneratedCodeInfo$Builder)super.clone();
    }

    public DescriptorProtos$GeneratedCodeInfo$Annotation getAnnotation(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.annotationBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (DescriptorProtos$GeneratedCodeInfo$Annotation)this.annotation_.get(n10);
        }
        return (DescriptorProtos$GeneratedCodeInfo$Annotation)repeatedFieldBuilderV3.getMessage(n10);
    }

    public DescriptorProtos$GeneratedCodeInfo$Annotation$Builder getAnnotationBuilder(int n10) {
        return (DescriptorProtos$GeneratedCodeInfo$Annotation$Builder)this.getAnnotationFieldBuilder().getBuilder(n10);
    }

    public List getAnnotationBuilderList() {
        return this.getAnnotationFieldBuilder().getBuilderList();
    }

    public int getAnnotationCount() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.annotationBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return this.annotation_.size();
        }
        return repeatedFieldBuilderV3.getCount();
    }

    public List getAnnotationList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.annotationBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return Collections.unmodifiableList(this.annotation_);
        }
        return repeatedFieldBuilderV3.getMessageList();
    }

    public DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder getAnnotationOrBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.annotationBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder)this.annotation_.get(n10);
        }
        return (DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(n10);
    }

    public List getAnnotationOrBuilderList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.annotationBuilder_;
        if (repeatedFieldBuilderV3 != null) {
            return repeatedFieldBuilderV3.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(this.annotation_);
    }

    public DescriptorProtos$GeneratedCodeInfo getDefaultInstanceForType() {
        return DescriptorProtos$GeneratedCodeInfo.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$29000();
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$29100().ensureFieldAccessorsInitialized(DescriptorProtos$GeneratedCodeInfo.class, DescriptorProtos$GeneratedCodeInfo$Builder.class);
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
    public DescriptorProtos$GeneratedCodeInfo$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = DescriptorProtos$GeneratedCodeInfo.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (DescriptorProtos$GeneratedCodeInfo)object;
            if (object == null) break block7;
            this.mergeFrom((DescriptorProtos$GeneratedCodeInfo)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (DescriptorProtos$GeneratedCodeInfo)object2;
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
            this.mergeFrom((DescriptorProtos$GeneratedCodeInfo)object3);
        }
        throw var1_6;
    }

    public DescriptorProtos$GeneratedCodeInfo$Builder mergeFrom(DescriptorProtos$GeneratedCodeInfo messageLite) {
        Object object = DescriptorProtos$GeneratedCodeInfo.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        object = this.annotationBuilder_;
        if (object == null) {
            object = DescriptorProtos$GeneratedCodeInfo.access$30600(messageLite);
            int n10 = object.isEmpty();
            if (n10 == 0) {
                object = this.annotation_;
                n10 = object.isEmpty();
                if (n10 != 0) {
                    this.annotation_ = object = DescriptorProtos$GeneratedCodeInfo.access$30600(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
                } else {
                    this.ensureAnnotationIsMutable();
                    object = this.annotation_;
                    List list = DescriptorProtos$GeneratedCodeInfo.access$30600(messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = DescriptorProtos$GeneratedCodeInfo.access$30600(messageLite);
            boolean bl2 = object.isEmpty();
            if (!bl2) {
                object = this.annotationBuilder_;
                bl2 = ((RepeatedFieldBuilderV3)object).isEmpty();
                if (bl2) {
                    int n11;
                    List list;
                    this.annotationBuilder_.dispose();
                    bl2 = false;
                    object = null;
                    this.annotationBuilder_ = null;
                    this.annotation_ = list = DescriptorProtos$GeneratedCodeInfo.access$30600(messageLite);
                    this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
                    n11 = (int)(GeneratedMessageV3.alwaysUseFieldBuilders ? 1 : 0);
                    if (n11 != 0) {
                        object = this.getAnnotationFieldBuilder();
                    }
                    this.annotationBuilder_ = object;
                } else {
                    object = this.annotationBuilder_;
                    List list = DescriptorProtos$GeneratedCodeInfo.access$30600(messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages(list);
                }
            }
        }
        messageLite = messageLite.unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$GeneratedCodeInfo$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof DescriptorProtos$GeneratedCodeInfo;
        if (bl2) {
            message = (DescriptorProtos$GeneratedCodeInfo)message;
            return this.mergeFrom((DescriptorProtos$GeneratedCodeInfo)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final DescriptorProtos$GeneratedCodeInfo$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$GeneratedCodeInfo$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public DescriptorProtos$GeneratedCodeInfo$Builder removeAnnotation(int n10) {
        Object object = this.annotationBuilder_;
        if (object == null) {
            this.ensureAnnotationIsMutable();
            object = this.annotation_;
            object.remove(n10);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).remove(n10);
        }
        return this;
    }

    public DescriptorProtos$GeneratedCodeInfo$Builder setAnnotation(int n10, DescriptorProtos$GeneratedCodeInfo$Annotation$Builder descriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder) {
        Object object = this.annotationBuilder_;
        if (object == null) {
            this.ensureAnnotationIsMutable();
            object = this.annotation_;
            descriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder = ((DescriptorProtos$GeneratedCodeInfo$Annotation$Builder)descriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder).build();
            object.set(n10, descriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder = ((DescriptorProtos$GeneratedCodeInfo$Annotation$Builder)descriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).setMessage(n10, (AbstractMessage)((Object)descriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$GeneratedCodeInfo$Builder setAnnotation(int n10, DescriptorProtos$GeneratedCodeInfo$Annotation descriptorProtos$GeneratedCodeInfo$Annotation) {
        Object object = this.annotationBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$GeneratedCodeInfo$Annotation);
            this.ensureAnnotationIsMutable();
            object = this.annotation_;
            object.set(n10, descriptorProtos$GeneratedCodeInfo$Annotation);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).setMessage(n10, descriptorProtos$GeneratedCodeInfo$Annotation);
        }
        return this;
    }

    public DescriptorProtos$GeneratedCodeInfo$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$GeneratedCodeInfo$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$GeneratedCodeInfo$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (DescriptorProtos$GeneratedCodeInfo$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final DescriptorProtos$GeneratedCodeInfo$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$GeneratedCodeInfo$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

