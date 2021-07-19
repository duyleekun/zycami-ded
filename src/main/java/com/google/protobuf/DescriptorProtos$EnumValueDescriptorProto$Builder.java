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
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProto;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumValueOptions;
import com.google.protobuf.DescriptorProtos$EnumValueOptions$Builder;
import com.google.protobuf.DescriptorProtos$EnumValueOptionsOrBuilder;
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

public final class DescriptorProtos$EnumValueDescriptorProto$Builder
extends GeneratedMessageV3$Builder
implements DescriptorProtos$EnumValueDescriptorProtoOrBuilder {
    private int bitField0_;
    private Object name_ = "";
    private int number_;
    private SingleFieldBuilderV3 optionsBuilder_;
    private DescriptorProtos$EnumValueOptions options_;

    private DescriptorProtos$EnumValueDescriptorProto$Builder() {
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$EnumValueDescriptorProto$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    private DescriptorProtos$EnumValueDescriptorProto$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        super(generatedMessageV3$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$EnumValueDescriptorProto$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$11600();
    }

    private SingleFieldBuilderV3 getOptionsFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.optionsBuilder_;
        if (singleFieldBuilderV3 == null) {
            DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions = this.getOptions();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.optionsBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(descriptorProtos$EnumValueOptions, generatedMessageV3$BuilderParent, bl2);
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

    public DescriptorProtos$EnumValueDescriptorProto$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$EnumValueDescriptorProto$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$EnumValueDescriptorProto build() {
        DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto = this.buildPartial();
        boolean bl2 = descriptorProtos$EnumValueDescriptorProto.isInitialized();
        if (bl2) {
            return descriptorProtos$EnumValueDescriptorProto;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(descriptorProtos$EnumValueDescriptorProto);
    }

    public DescriptorProtos$EnumValueDescriptorProto buildPartial() {
        Object object = null;
        DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto = new DescriptorProtos$EnumValueDescriptorProto(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        n11 = n11 != 0 ? 1 : 0;
        Object object2 = this.name_;
        DescriptorProtos$EnumValueDescriptorProto.access$12102(descriptorProtos$EnumValueDescriptorProto, object2);
        int n12 = n10 & 2;
        if (n12 != 0) {
            n12 = this.number_;
            DescriptorProtos$EnumValueDescriptorProto.access$12202(descriptorProtos$EnumValueDescriptorProto, n12);
            n11 |= 2;
        }
        if ((n10 &= 4) != 0) {
            object = this.optionsBuilder_;
            if (object == null) {
                object = this.options_;
                DescriptorProtos$EnumValueDescriptorProto.access$12302(descriptorProtos$EnumValueDescriptorProto, (DescriptorProtos$EnumValueOptions)object);
            } else {
                object = (DescriptorProtos$EnumValueOptions)((SingleFieldBuilderV3)object).build();
                DescriptorProtos$EnumValueDescriptorProto.access$12302(descriptorProtos$EnumValueDescriptorProto, (DescriptorProtos$EnumValueOptions)object);
            }
            n11 |= 4;
        }
        DescriptorProtos$EnumValueDescriptorProto.access$12402(descriptorProtos$EnumValueDescriptorProto, n11);
        this.onBuilt();
        return descriptorProtos$EnumValueDescriptorProto;
    }

    public DescriptorProtos$EnumValueDescriptorProto$Builder clear() {
        int n10;
        super.clear();
        this.name_ = "";
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.number_ = 0;
        this.bitField0_ = n10 &= 0xFFFFFFFD;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.optionsBuilder_;
        if (singleFieldBuilderV3 == null) {
            n10 = 0;
            singleFieldBuilderV3 = null;
            this.options_ = null;
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        return this;
    }

    public DescriptorProtos$EnumValueDescriptorProto$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (DescriptorProtos$EnumValueDescriptorProto$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public DescriptorProtos$EnumValueDescriptorProto$Builder clearName() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        String string2 = DescriptorProtos$EnumValueDescriptorProto.getDefaultInstance().getName();
        this.name_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$EnumValueDescriptorProto$Builder clearNumber() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.number_ = 0;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$EnumValueDescriptorProto$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (DescriptorProtos$EnumValueDescriptorProto$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public DescriptorProtos$EnumValueDescriptorProto$Builder clearOptions() {
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

    public DescriptorProtos$EnumValueDescriptorProto$Builder clone() {
        return (DescriptorProtos$EnumValueDescriptorProto$Builder)super.clone();
    }

    public DescriptorProtos$EnumValueDescriptorProto getDefaultInstanceForType() {
        return DescriptorProtos$EnumValueDescriptorProto.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$11600();
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

    public int getNumber() {
        return this.number_;
    }

    public DescriptorProtos$EnumValueOptions getOptions() {
        Object object = this.optionsBuilder_;
        if (object == null) {
            object = this.options_;
            if (object == null) {
                object = DescriptorProtos$EnumValueOptions.getDefaultInstance();
            }
            return object;
        }
        return (DescriptorProtos$EnumValueOptions)((SingleFieldBuilderV3)object).getMessage();
    }

    public DescriptorProtos$EnumValueOptions$Builder getOptionsBuilder() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.onChanged();
        return (DescriptorProtos$EnumValueOptions$Builder)this.getOptionsFieldBuilder().getBuilder();
    }

    public DescriptorProtos$EnumValueOptionsOrBuilder getOptionsOrBuilder() {
        Object object = this.optionsBuilder_;
        if (object != null) {
            return (DescriptorProtos$EnumValueOptionsOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.options_;
        if (object == null) {
            object = DescriptorProtos$EnumValueOptions.getDefaultInstance();
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

    public boolean hasNumber() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasOptions() {
        int n10 = this.bitField0_ & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$11700().ensureFieldAccessorsInitialized(DescriptorProtos$EnumValueDescriptorProto.class, DescriptorProtos$EnumValueDescriptorProto$Builder.class);
    }

    public final boolean isInitialized() {
        DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions;
        boolean bl2 = this.hasOptions();
        return !bl2 || (bl2 = (descriptorProtos$EnumValueOptions = this.getOptions()).isInitialized());
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public DescriptorProtos$EnumValueDescriptorProto$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = DescriptorProtos$EnumValueDescriptorProto.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (DescriptorProtos$EnumValueDescriptorProto)object;
            if (object == null) break block7;
            this.mergeFrom((DescriptorProtos$EnumValueDescriptorProto)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (DescriptorProtos$EnumValueDescriptorProto)object2;
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
            this.mergeFrom((DescriptorProtos$EnumValueDescriptorProto)object3);
        }
        throw var1_6;
    }

    public DescriptorProtos$EnumValueDescriptorProto$Builder mergeFrom(DescriptorProtos$EnumValueDescriptorProto messageLite) {
        Object object = DescriptorProtos$EnumValueDescriptorProto.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        int n10 = messageLite.hasName();
        if (n10 != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 1;
            this.name_ = object = DescriptorProtos$EnumValueDescriptorProto.access$12100(messageLite);
            this.onChanged();
        }
        if ((n10 = messageLite.hasNumber()) != 0) {
            n10 = messageLite.getNumber();
            this.setNumber(n10);
        }
        if ((n10 = (int)(messageLite.hasOptions() ? 1 : 0)) != 0) {
            object = messageLite.getOptions();
            this.mergeOptions((DescriptorProtos$EnumValueOptions)object);
        }
        messageLite = messageLite.unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$EnumValueDescriptorProto$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof DescriptorProtos$EnumValueDescriptorProto;
        if (bl2) {
            message = (DescriptorProtos$EnumValueDescriptorProto)message;
            return this.mergeFrom((DescriptorProtos$EnumValueDescriptorProto)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public DescriptorProtos$EnumValueDescriptorProto$Builder mergeOptions(DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions) {
        int n10;
        Object object = this.optionsBuilder_;
        if (object == null) {
            DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions2;
            int n11 = this.bitField0_ & 4;
            if (n11 != 0 && (object = this.options_) != null && object != (descriptorProtos$EnumValueOptions2 = DescriptorProtos$EnumValueOptions.getDefaultInstance())) {
                object = DescriptorProtos$EnumValueOptions.newBuilder(this.options_);
                this.options_ = descriptorProtos$EnumValueOptions = ((DescriptorProtos$EnumValueOptions$Builder)object).mergeFrom(descriptorProtos$EnumValueOptions).buildPartial();
            } else {
                this.options_ = descriptorProtos$EnumValueOptions;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(descriptorProtos$EnumValueOptions);
        }
        this.bitField0_ = n10 = this.bitField0_ | 4;
        return this;
    }

    public final DescriptorProtos$EnumValueDescriptorProto$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$EnumValueDescriptorProto$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public DescriptorProtos$EnumValueDescriptorProto$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$EnumValueDescriptorProto$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$EnumValueDescriptorProto$Builder setName(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.name_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$EnumValueDescriptorProto$Builder setNameBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.name_ = byteString;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$EnumValueDescriptorProto$Builder setNumber(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 2;
        this.number_ = n10;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$EnumValueDescriptorProto$Builder setOptions(DescriptorProtos$EnumValueOptions$Builder descriptorProtos$EnumValueOptionsOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.optionsBuilder_;
        if (singleFieldBuilderV3 == null) {
            descriptorProtos$EnumValueOptionsOrBuilder = descriptorProtos$EnumValueOptionsOrBuilder.build();
            this.options_ = descriptorProtos$EnumValueOptionsOrBuilder;
            this.onChanged();
        } else {
            descriptorProtos$EnumValueOptionsOrBuilder = descriptorProtos$EnumValueOptionsOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)descriptorProtos$EnumValueOptionsOrBuilder));
        }
        this.bitField0_ = n10 = this.bitField0_ | 4;
        return this;
    }

    public DescriptorProtos$EnumValueDescriptorProto$Builder setOptions(DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.optionsBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(descriptorProtos$EnumValueOptions);
            this.options_ = descriptorProtos$EnumValueOptions;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(descriptorProtos$EnumValueOptions);
        }
        this.bitField0_ = n10 = this.bitField0_ | 4;
        return this;
    }

    public DescriptorProtos$EnumValueDescriptorProto$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (DescriptorProtos$EnumValueDescriptorProto$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final DescriptorProtos$EnumValueDescriptorProto$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$EnumValueDescriptorProto$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

