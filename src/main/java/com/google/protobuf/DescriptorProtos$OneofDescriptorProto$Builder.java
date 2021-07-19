/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$OneofDescriptorProto;
import com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$OneofOptions;
import com.google.protobuf.DescriptorProtos$OneofOptions$Builder;
import com.google.protobuf.DescriptorProtos$OneofOptionsOrBuilder;
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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.Objects;

public final class DescriptorProtos$OneofDescriptorProto$Builder
extends GeneratedMessageV3$Builder
implements DescriptorProtos$OneofDescriptorProtoOrBuilder {
    private int bitField0_;
    private Object name_ = "";
    private SingleFieldBuilderV3 optionsBuilder_;
    private DescriptorProtos$OneofOptions options_;

    private DescriptorProtos$OneofDescriptorProto$Builder() {
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$OneofDescriptorProto$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    private DescriptorProtos$OneofDescriptorProto$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        super(generatedMessageV3$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$OneofDescriptorProto$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$8600();
    }

    private SingleFieldBuilderV3 getOptionsFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.optionsBuilder_;
        if (singleFieldBuilderV3 == null) {
            DescriptorProtos$OneofOptions descriptorProtos$OneofOptions = this.getOptions();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.optionsBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(descriptorProtos$OneofOptions, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.options_ = null;
        }
        return this.optionsBuilder_;
    }

    private void maybeForceBuilderInitialization() {
        boolean bl2 = GeneratedMessageV3.alwaysUseFieldBuilders;
        if (bl2) {
            this.getOptionsFieldBuilder();
        }
    }

    public DescriptorProtos$OneofDescriptorProto$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$OneofDescriptorProto$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$OneofDescriptorProto build() {
        DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto = this.buildPartial();
        boolean bl2 = descriptorProtos$OneofDescriptorProto.isInitialized();
        if (bl2) {
            return descriptorProtos$OneofDescriptorProto;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(descriptorProtos$OneofDescriptorProto);
    }

    public DescriptorProtos$OneofDescriptorProto buildPartial() {
        Object object = null;
        DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto = new DescriptorProtos$OneofDescriptorProto(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        n11 = n11 != 0 ? 1 : 0;
        Object object2 = this.name_;
        DescriptorProtos$OneofDescriptorProto.access$9102(descriptorProtos$OneofDescriptorProto, object2);
        if ((n10 &= 2) != 0) {
            object = this.optionsBuilder_;
            if (object == null) {
                object = this.options_;
                DescriptorProtos$OneofDescriptorProto.access$9202(descriptorProtos$OneofDescriptorProto, (DescriptorProtos$OneofOptions)object);
            } else {
                object = (DescriptorProtos$OneofOptions)((SingleFieldBuilderV3)object).build();
                DescriptorProtos$OneofDescriptorProto.access$9202(descriptorProtos$OneofDescriptorProto, (DescriptorProtos$OneofOptions)object);
            }
            n11 |= 2;
        }
        DescriptorProtos$OneofDescriptorProto.access$9302(descriptorProtos$OneofDescriptorProto, n11);
        this.onBuilt();
        return descriptorProtos$OneofDescriptorProto;
    }

    public DescriptorProtos$OneofDescriptorProto$Builder clear() {
        int n10;
        super.clear();
        this.name_ = "";
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.optionsBuilder_;
        if (singleFieldBuilderV3 == null) {
            n10 = 0;
            singleFieldBuilderV3 = null;
            this.options_ = null;
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        return this;
    }

    public DescriptorProtos$OneofDescriptorProto$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (DescriptorProtos$OneofDescriptorProto$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public DescriptorProtos$OneofDescriptorProto$Builder clearName() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        String string2 = DescriptorProtos$OneofDescriptorProto.getDefaultInstance().getName();
        this.name_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$OneofDescriptorProto$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (DescriptorProtos$OneofDescriptorProto$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public DescriptorProtos$OneofDescriptorProto$Builder clearOptions() {
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
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        return this;
    }

    public DescriptorProtos$OneofDescriptorProto$Builder clone() {
        return (DescriptorProtos$OneofDescriptorProto$Builder)super.clone();
    }

    public DescriptorProtos$OneofDescriptorProto getDefaultInstanceForType() {
        return DescriptorProtos$OneofDescriptorProto.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$8600();
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

    public DescriptorProtos$OneofOptions getOptions() {
        Object object = this.optionsBuilder_;
        if (object == null) {
            object = this.options_;
            if (object == null) {
                object = DescriptorProtos$OneofOptions.getDefaultInstance();
            }
            return object;
        }
        return (DescriptorProtos$OneofOptions)((SingleFieldBuilderV3)object).getMessage();
    }

    public DescriptorProtos$OneofOptions$Builder getOptionsBuilder() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.onChanged();
        return (DescriptorProtos$OneofOptions$Builder)this.getOptionsFieldBuilder().getBuilder();
    }

    public DescriptorProtos$OneofOptionsOrBuilder getOptionsOrBuilder() {
        Object object = this.optionsBuilder_;
        if (object != null) {
            return (DescriptorProtos$OneofOptionsOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.options_;
        if (object == null) {
            object = DescriptorProtos$OneofOptions.getDefaultInstance();
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
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$8700().ensureFieldAccessorsInitialized(DescriptorProtos$OneofDescriptorProto.class, DescriptorProtos$OneofDescriptorProto$Builder.class);
    }

    public final boolean isInitialized() {
        DescriptorProtos$OneofOptions descriptorProtos$OneofOptions;
        boolean bl2 = this.hasOptions();
        return !bl2 || (bl2 = (descriptorProtos$OneofOptions = this.getOptions()).isInitialized());
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public DescriptorProtos$OneofDescriptorProto$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = DescriptorProtos$OneofDescriptorProto.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (DescriptorProtos$OneofDescriptorProto)object;
            if (object == null) break block7;
            this.mergeFrom((DescriptorProtos$OneofDescriptorProto)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (DescriptorProtos$OneofDescriptorProto)object2;
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
            this.mergeFrom((DescriptorProtos$OneofDescriptorProto)object3);
        }
        throw var1_6;
    }

    public DescriptorProtos$OneofDescriptorProto$Builder mergeFrom(DescriptorProtos$OneofDescriptorProto messageLite) {
        Object object = DescriptorProtos$OneofDescriptorProto.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        int n10 = messageLite.hasName();
        if (n10 != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 1;
            this.name_ = object = DescriptorProtos$OneofDescriptorProto.access$9100(messageLite);
            this.onChanged();
        }
        if ((n10 = messageLite.hasOptions()) != 0) {
            object = messageLite.getOptions();
            this.mergeOptions((DescriptorProtos$OneofOptions)object);
        }
        messageLite = messageLite.unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$OneofDescriptorProto$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof DescriptorProtos$OneofDescriptorProto;
        if (bl2) {
            message = (DescriptorProtos$OneofDescriptorProto)message;
            return this.mergeFrom((DescriptorProtos$OneofDescriptorProto)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public DescriptorProtos$OneofDescriptorProto$Builder mergeOptions(DescriptorProtos$OneofOptions descriptorProtos$OneofOptions) {
        int n10;
        Object object = this.optionsBuilder_;
        if (object == null) {
            DescriptorProtos$OneofOptions descriptorProtos$OneofOptions2;
            int n11 = this.bitField0_ & 2;
            if (n11 != 0 && (object = this.options_) != null && object != (descriptorProtos$OneofOptions2 = DescriptorProtos$OneofOptions.getDefaultInstance())) {
                object = DescriptorProtos$OneofOptions.newBuilder(this.options_);
                this.options_ = descriptorProtos$OneofOptions = ((DescriptorProtos$OneofOptions$Builder)object).mergeFrom(descriptorProtos$OneofOptions).buildPartial();
            } else {
                this.options_ = descriptorProtos$OneofOptions;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(descriptorProtos$OneofOptions);
        }
        this.bitField0_ = n10 = this.bitField0_ | 2;
        return this;
    }

    public final DescriptorProtos$OneofDescriptorProto$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$OneofDescriptorProto$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public DescriptorProtos$OneofDescriptorProto$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$OneofDescriptorProto$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$OneofDescriptorProto$Builder setName(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.name_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$OneofDescriptorProto$Builder setNameBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.name_ = byteString;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$OneofDescriptorProto$Builder setOptions(DescriptorProtos$OneofOptions$Builder descriptorProtos$OneofOptionsOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.optionsBuilder_;
        if (singleFieldBuilderV3 == null) {
            descriptorProtos$OneofOptionsOrBuilder = descriptorProtos$OneofOptionsOrBuilder.build();
            this.options_ = descriptorProtos$OneofOptionsOrBuilder;
            this.onChanged();
        } else {
            descriptorProtos$OneofOptionsOrBuilder = descriptorProtos$OneofOptionsOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)descriptorProtos$OneofOptionsOrBuilder));
        }
        this.bitField0_ = n10 = this.bitField0_ | 2;
        return this;
    }

    public DescriptorProtos$OneofDescriptorProto$Builder setOptions(DescriptorProtos$OneofOptions descriptorProtos$OneofOptions) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.optionsBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(descriptorProtos$OneofOptions);
            this.options_ = descriptorProtos$OneofOptions;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(descriptorProtos$OneofOptions);
        }
        this.bitField0_ = n10 = this.bitField0_ | 2;
        return this;
    }

    public DescriptorProtos$OneofDescriptorProto$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (DescriptorProtos$OneofDescriptorProto$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final DescriptorProtos$OneofDescriptorProto$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$OneofDescriptorProto$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

