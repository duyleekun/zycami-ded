/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$MethodDescriptorProto;
import com.google.protobuf.DescriptorProtos$MethodDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProto;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$ServiceOptions;
import com.google.protobuf.DescriptorProtos$ServiceOptions$Builder;
import com.google.protobuf.DescriptorProtos$ServiceOptionsOrBuilder;
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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class DescriptorProtos$ServiceDescriptorProto$Builder
extends GeneratedMessageV3$Builder
implements DescriptorProtos$ServiceDescriptorProtoOrBuilder {
    private int bitField0_;
    private RepeatedFieldBuilderV3 methodBuilder_;
    private List method_;
    private Object name_ = "";
    private SingleFieldBuilderV3 optionsBuilder_;
    private DescriptorProtos$ServiceOptions options_;

    private DescriptorProtos$ServiceDescriptorProto$Builder() {
        List list;
        this.method_ = list = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$ServiceDescriptorProto$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    private DescriptorProtos$ServiceDescriptorProto$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        this.method_ = object = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$ServiceDescriptorProto$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private void ensureMethodIsMutable() {
        int n10 = this.bitField0_ & 2;
        if (n10 == 0) {
            ArrayList arrayList;
            List list = this.method_;
            this.method_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | 2;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$12600();
    }

    private RepeatedFieldBuilderV3 getMethodFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.methodBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            List list = this.method_;
            int n10 = this.bitField0_ & 2;
            n10 = n10 != 0 ? 1 : 0;
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.methodBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, n10 != 0, generatedMessageV3$BuilderParent, bl2);
            repeatedFieldBuilderV3 = null;
            this.method_ = null;
        }
        return this.methodBuilder_;
    }

    private SingleFieldBuilderV3 getOptionsFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.optionsBuilder_;
        if (singleFieldBuilderV3 == null) {
            DescriptorProtos$ServiceOptions descriptorProtos$ServiceOptions = this.getOptions();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.optionsBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(descriptorProtos$ServiceOptions, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.options_ = null;
        }
        return this.optionsBuilder_;
    }

    private void maybeForceBuilderInitialization() {
        boolean bl2 = GeneratedMessageV3.alwaysUseFieldBuilders;
        if (bl2) {
            this.getMethodFieldBuilder();
            this.getOptionsFieldBuilder();
        }
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder addAllMethod(Iterable iterable) {
        Object object = this.methodBuilder_;
        if (object == null) {
            this.ensureMethodIsMutable();
            object = this.method_;
            AbstractMessageLite$Builder.addAll(iterable, (List)object);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addAllMessages(iterable);
        }
        return this;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder addMethod(int n10, DescriptorProtos$MethodDescriptorProto$Builder descriptorProtos$MethodDescriptorProtoOrBuilder) {
        Object object = this.methodBuilder_;
        if (object == null) {
            this.ensureMethodIsMutable();
            object = this.method_;
            descriptorProtos$MethodDescriptorProtoOrBuilder = ((DescriptorProtos$MethodDescriptorProto$Builder)descriptorProtos$MethodDescriptorProtoOrBuilder).build();
            object.add(n10, descriptorProtos$MethodDescriptorProtoOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$MethodDescriptorProtoOrBuilder = ((DescriptorProtos$MethodDescriptorProto$Builder)descriptorProtos$MethodDescriptorProtoOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage(n10, (AbstractMessage)((Object)descriptorProtos$MethodDescriptorProtoOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder addMethod(int n10, DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto) {
        Object object = this.methodBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$MethodDescriptorProto);
            this.ensureMethodIsMutable();
            object = this.method_;
            object.add(n10, descriptorProtos$MethodDescriptorProto);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(n10, descriptorProtos$MethodDescriptorProto);
        }
        return this;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder addMethod(DescriptorProtos$MethodDescriptorProto$Builder descriptorProtos$MethodDescriptorProtoOrBuilder) {
        Object object = this.methodBuilder_;
        if (object == null) {
            this.ensureMethodIsMutable();
            object = this.method_;
            descriptorProtos$MethodDescriptorProtoOrBuilder = ((DescriptorProtos$MethodDescriptorProto$Builder)descriptorProtos$MethodDescriptorProtoOrBuilder).build();
            object.add(descriptorProtos$MethodDescriptorProtoOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$MethodDescriptorProtoOrBuilder = ((DescriptorProtos$MethodDescriptorProto$Builder)descriptorProtos$MethodDescriptorProtoOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage((AbstractMessage)((Object)descriptorProtos$MethodDescriptorProtoOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder addMethod(DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto) {
        Object object = this.methodBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$MethodDescriptorProto);
            this.ensureMethodIsMutable();
            object = this.method_;
            object.add(descriptorProtos$MethodDescriptorProto);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(descriptorProtos$MethodDescriptorProto);
        }
        return this;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder addMethodBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getMethodFieldBuilder();
        DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto = DescriptorProtos$MethodDescriptorProto.getDefaultInstance();
        return (DescriptorProtos$MethodDescriptorProto$Builder)repeatedFieldBuilderV3.addBuilder(descriptorProtos$MethodDescriptorProto);
    }

    public DescriptorProtos$MethodDescriptorProto$Builder addMethodBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getMethodFieldBuilder();
        DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto = DescriptorProtos$MethodDescriptorProto.getDefaultInstance();
        return (DescriptorProtos$MethodDescriptorProto$Builder)repeatedFieldBuilderV3.addBuilder(n10, descriptorProtos$MethodDescriptorProto);
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$ServiceDescriptorProto$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$ServiceDescriptorProto build() {
        DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto = this.buildPartial();
        boolean bl2 = descriptorProtos$ServiceDescriptorProto.isInitialized();
        if (bl2) {
            return descriptorProtos$ServiceDescriptorProto;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(descriptorProtos$ServiceDescriptorProto);
    }

    public DescriptorProtos$ServiceDescriptorProto buildPartial() {
        Object object = null;
        DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto = new DescriptorProtos$ServiceDescriptorProto(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        n11 = n11 != 0 ? 1 : 0;
        List list = this.name_;
        DescriptorProtos$ServiceDescriptorProto.access$13102(descriptorProtos$ServiceDescriptorProto, list);
        list = this.methodBuilder_;
        if (list == null) {
            int n12 = this.bitField0_ & 2;
            if (n12 != 0) {
                this.method_ = list = Collections.unmodifiableList(this.method_);
                this.bitField0_ = n12 = this.bitField0_ & 0xFFFFFFFD;
            }
            list = this.method_;
            DescriptorProtos$ServiceDescriptorProto.access$13202(descriptorProtos$ServiceDescriptorProto, list);
        } else {
            list = ((RepeatedFieldBuilderV3)((Object)list)).build();
            DescriptorProtos$ServiceDescriptorProto.access$13202(descriptorProtos$ServiceDescriptorProto, list);
        }
        if ((n10 &= 4) != 0) {
            object = this.optionsBuilder_;
            if (object == null) {
                object = this.options_;
                DescriptorProtos$ServiceDescriptorProto.access$13302(descriptorProtos$ServiceDescriptorProto, (DescriptorProtos$ServiceOptions)object);
            } else {
                object = (DescriptorProtos$ServiceOptions)((SingleFieldBuilderV3)object).build();
                DescriptorProtos$ServiceDescriptorProto.access$13302(descriptorProtos$ServiceDescriptorProto, (DescriptorProtos$ServiceOptions)object);
            }
            n11 |= 2;
        }
        DescriptorProtos$ServiceDescriptorProto.access$13402(descriptorProtos$ServiceDescriptorProto, n11);
        this.onBuilt();
        return descriptorProtos$ServiceDescriptorProto;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder clear() {
        int n10;
        super.clear();
        this.name_ = "";
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        Object object = this.methodBuilder_;
        if (object == null) {
            this.method_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        object = this.optionsBuilder_;
        if (object == null) {
            n10 = 0;
            object = null;
            this.options_ = null;
        } else {
            ((SingleFieldBuilderV3)object).clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        return this;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (DescriptorProtos$ServiceDescriptorProto$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder clearMethod() {
        Object object = this.methodBuilder_;
        if (object == null) {
            int n10;
            this.method_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder clearName() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        String string2 = DescriptorProtos$ServiceDescriptorProto.getDefaultInstance().getName();
        this.name_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (DescriptorProtos$ServiceDescriptorProto$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder clearOptions() {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.optionsBuilder_;
        if (singleFieldBuilderV3 == null) {
            n10 = 0;
            singleFieldBuilderV3 = null;
            this.options_ = null;
            this.onChanged();
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        return this;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder clone() {
        return (DescriptorProtos$ServiceDescriptorProto$Builder)super.clone();
    }

    public DescriptorProtos$ServiceDescriptorProto getDefaultInstanceForType() {
        return DescriptorProtos$ServiceDescriptorProto.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$12600();
    }

    public DescriptorProtos$MethodDescriptorProto getMethod(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.methodBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (DescriptorProtos$MethodDescriptorProto)this.method_.get(n10);
        }
        return (DescriptorProtos$MethodDescriptorProto)repeatedFieldBuilderV3.getMessage(n10);
    }

    public DescriptorProtos$MethodDescriptorProto$Builder getMethodBuilder(int n10) {
        return (DescriptorProtos$MethodDescriptorProto$Builder)this.getMethodFieldBuilder().getBuilder(n10);
    }

    public List getMethodBuilderList() {
        return this.getMethodFieldBuilder().getBuilderList();
    }

    public int getMethodCount() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.methodBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return this.method_.size();
        }
        return repeatedFieldBuilderV3.getCount();
    }

    public List getMethodList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.methodBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return Collections.unmodifiableList(this.method_);
        }
        return repeatedFieldBuilderV3.getMessageList();
    }

    public DescriptorProtos$MethodDescriptorProtoOrBuilder getMethodOrBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.methodBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (DescriptorProtos$MethodDescriptorProtoOrBuilder)this.method_.get(n10);
        }
        return (DescriptorProtos$MethodDescriptorProtoOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(n10);
    }

    public List getMethodOrBuilderList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.methodBuilder_;
        if (repeatedFieldBuilderV3 != null) {
            return repeatedFieldBuilderV3.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(this.method_);
    }

    public String getName() {
        Object object = this.name_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.name_ = string2;
            }
            return string2;
        }
        return (String)object;
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

    public DescriptorProtos$ServiceOptions getOptions() {
        Object object = this.optionsBuilder_;
        if (object == null) {
            object = this.options_;
            if (object == null) {
                object = DescriptorProtos$ServiceOptions.getDefaultInstance();
            }
            return object;
        }
        return (DescriptorProtos$ServiceOptions)((SingleFieldBuilderV3)object).getMessage();
    }

    public DescriptorProtos$ServiceOptions$Builder getOptionsBuilder() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.onChanged();
        return (DescriptorProtos$ServiceOptions$Builder)this.getOptionsFieldBuilder().getBuilder();
    }

    public DescriptorProtos$ServiceOptionsOrBuilder getOptionsOrBuilder() {
        Object object = this.optionsBuilder_;
        if (object != null) {
            return (DescriptorProtos$ServiceOptionsOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.options_;
        if (object == null) {
            object = DescriptorProtos$ServiceOptions.getDefaultInstance();
        }
        return object;
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
        int n10 = this.bitField0_ & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$12700().ensureFieldAccessorsInitialized(DescriptorProtos$ServiceDescriptorProto.class, DescriptorProtos$ServiceDescriptorProto$Builder.class);
    }

    public final boolean isInitialized() {
        int n10;
        int n11;
        DescriptorProtos$ServiceOptions descriptorProtos$ServiceOptions = null;
        for (n11 = 0; n11 < (n10 = this.getMethodCount()); ++n11) {
            DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto = this.getMethod(n11);
            n10 = (int)(descriptorProtos$MethodDescriptorProto.isInitialized() ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        n11 = (int)(this.hasOptions() ? 1 : 0);
        return n11 == 0 || (n11 = (int)((descriptorProtos$ServiceOptions = this.getOptions()).isInitialized() ? 1 : 0)) != 0;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public DescriptorProtos$ServiceDescriptorProto$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = DescriptorProtos$ServiceDescriptorProto.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (DescriptorProtos$ServiceDescriptorProto)object;
            if (object == null) break block7;
            this.mergeFrom((DescriptorProtos$ServiceDescriptorProto)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (DescriptorProtos$ServiceDescriptorProto)object2;
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
            this.mergeFrom((DescriptorProtos$ServiceDescriptorProto)object3);
        }
        throw var1_6;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder mergeFrom(DescriptorProtos$ServiceDescriptorProto messageLite) {
        Object object = DescriptorProtos$ServiceDescriptorProto.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        int n10 = messageLite.hasName();
        if (n10 != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 1;
            this.name_ = object = DescriptorProtos$ServiceDescriptorProto.access$13100(messageLite);
            this.onChanged();
        }
        if ((object = this.methodBuilder_) == null) {
            object = DescriptorProtos$ServiceDescriptorProto.access$13200(messageLite);
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object = this.method_;
                n10 = (int)(object.isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    this.method_ = object = DescriptorProtos$ServiceDescriptorProto.access$13200(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
                } else {
                    this.ensureMethodIsMutable();
                    object = this.method_;
                    List list = DescriptorProtos$ServiceDescriptorProto.access$13200(messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = DescriptorProtos$ServiceDescriptorProto.access$13200(messageLite);
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object = this.methodBuilder_;
                n10 = (int)(((RepeatedFieldBuilderV3)object).isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    int n11;
                    List list;
                    this.methodBuilder_.dispose();
                    n10 = 0;
                    object = null;
                    this.methodBuilder_ = null;
                    this.method_ = list = DescriptorProtos$ServiceDescriptorProto.access$13200(messageLite);
                    this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFD;
                    n11 = (int)(GeneratedMessageV3.alwaysUseFieldBuilders ? 1 : 0);
                    if (n11 != 0) {
                        object = this.getMethodFieldBuilder();
                    }
                    this.methodBuilder_ = object;
                } else {
                    object = this.methodBuilder_;
                    List list = DescriptorProtos$ServiceDescriptorProto.access$13200(messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages(list);
                }
            }
        }
        if ((n10 = (int)(messageLite.hasOptions() ? 1 : 0)) != 0) {
            object = messageLite.getOptions();
            this.mergeOptions((DescriptorProtos$ServiceOptions)object);
        }
        messageLite = messageLite.unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof DescriptorProtos$ServiceDescriptorProto;
        if (bl2) {
            message = (DescriptorProtos$ServiceDescriptorProto)message;
            return this.mergeFrom((DescriptorProtos$ServiceDescriptorProto)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder mergeOptions(DescriptorProtos$ServiceOptions descriptorProtos$ServiceOptions) {
        int n10;
        Object object = this.optionsBuilder_;
        if (object == null) {
            DescriptorProtos$ServiceOptions descriptorProtos$ServiceOptions2;
            int n11 = this.bitField0_ & 4;
            if (n11 != 0 && (object = this.options_) != null && object != (descriptorProtos$ServiceOptions2 = DescriptorProtos$ServiceOptions.getDefaultInstance())) {
                object = DescriptorProtos$ServiceOptions.newBuilder(this.options_);
                this.options_ = descriptorProtos$ServiceOptions = ((DescriptorProtos$ServiceOptions$Builder)object).mergeFrom(descriptorProtos$ServiceOptions).buildPartial();
            } else {
                this.options_ = descriptorProtos$ServiceOptions;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(descriptorProtos$ServiceOptions);
        }
        this.bitField0_ = n10 = this.bitField0_ | 4;
        return this;
    }

    public final DescriptorProtos$ServiceDescriptorProto$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$ServiceDescriptorProto$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder removeMethod(int n10) {
        Object object = this.methodBuilder_;
        if (object == null) {
            this.ensureMethodIsMutable();
            object = this.method_;
            object.remove(n10);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).remove(n10);
        }
        return this;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$ServiceDescriptorProto$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder setMethod(int n10, DescriptorProtos$MethodDescriptorProto$Builder descriptorProtos$MethodDescriptorProtoOrBuilder) {
        Object object = this.methodBuilder_;
        if (object == null) {
            this.ensureMethodIsMutable();
            object = this.method_;
            descriptorProtos$MethodDescriptorProtoOrBuilder = ((DescriptorProtos$MethodDescriptorProto$Builder)descriptorProtos$MethodDescriptorProtoOrBuilder).build();
            object.set(n10, descriptorProtos$MethodDescriptorProtoOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$MethodDescriptorProtoOrBuilder = ((DescriptorProtos$MethodDescriptorProto$Builder)descriptorProtos$MethodDescriptorProtoOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).setMessage(n10, (AbstractMessage)((Object)descriptorProtos$MethodDescriptorProtoOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder setMethod(int n10, DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto) {
        Object object = this.methodBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$MethodDescriptorProto);
            this.ensureMethodIsMutable();
            object = this.method_;
            object.set(n10, descriptorProtos$MethodDescriptorProto);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).setMessage(n10, descriptorProtos$MethodDescriptorProto);
        }
        return this;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder setName(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.name_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder setNameBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.name_ = byteString;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder setOptions(DescriptorProtos$ServiceOptions$Builder descriptorProtos$ServiceOptionsOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.optionsBuilder_;
        if (singleFieldBuilderV3 == null) {
            descriptorProtos$ServiceOptionsOrBuilder = descriptorProtos$ServiceOptionsOrBuilder.build();
            this.options_ = descriptorProtos$ServiceOptionsOrBuilder;
            this.onChanged();
        } else {
            descriptorProtos$ServiceOptionsOrBuilder = descriptorProtos$ServiceOptionsOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)descriptorProtos$ServiceOptionsOrBuilder));
        }
        this.bitField0_ = n10 = this.bitField0_ | 4;
        return this;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder setOptions(DescriptorProtos$ServiceOptions descriptorProtos$ServiceOptions) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.optionsBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(descriptorProtos$ServiceOptions);
            this.options_ = descriptorProtos$ServiceOptions;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(descriptorProtos$ServiceOptions);
        }
        this.bitField0_ = n10 = this.bitField0_ | 4;
        return this;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (DescriptorProtos$ServiceDescriptorProto$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final DescriptorProtos$ServiceDescriptorProto$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$ServiceDescriptorProto$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

