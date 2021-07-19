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
import com.google.protobuf.DescriptorProtos$MethodDescriptorProto;
import com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$MethodOptions;
import com.google.protobuf.DescriptorProtos$MethodOptions$Builder;
import com.google.protobuf.DescriptorProtos$MethodOptionsOrBuilder;
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

public final class DescriptorProtos$MethodDescriptorProto$Builder
extends GeneratedMessageV3$Builder
implements DescriptorProtos$MethodDescriptorProtoOrBuilder {
    private int bitField0_;
    private boolean clientStreaming_;
    private Object inputType_;
    private Object name_;
    private SingleFieldBuilderV3 optionsBuilder_;
    private DescriptorProtos$MethodOptions options_;
    private Object outputType_;
    private boolean serverStreaming_;

    private DescriptorProtos$MethodDescriptorProto$Builder() {
        String string2 = "";
        this.name_ = string2;
        this.inputType_ = string2;
        this.outputType_ = string2;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$MethodDescriptorProto$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    private DescriptorProtos$MethodDescriptorProto$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        this.name_ = object = "";
        this.inputType_ = object;
        this.outputType_ = object;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$MethodDescriptorProto$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$13600();
    }

    private SingleFieldBuilderV3 getOptionsFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.optionsBuilder_;
        if (singleFieldBuilderV3 == null) {
            DescriptorProtos$MethodOptions descriptorProtos$MethodOptions = this.getOptions();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.optionsBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(descriptorProtos$MethodOptions, generatedMessageV3$BuilderParent, bl2);
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

    public DescriptorProtos$MethodDescriptorProto$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$MethodDescriptorProto$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$MethodDescriptorProto build() {
        DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto = this.buildPartial();
        boolean bl2 = descriptorProtos$MethodDescriptorProto.isInitialized();
        if (bl2) {
            return descriptorProtos$MethodDescriptorProto;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(descriptorProtos$MethodDescriptorProto);
    }

    public DescriptorProtos$MethodDescriptorProto buildPartial() {
        int n10;
        DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto = new DescriptorProtos$MethodDescriptorProto(this, null);
        int n102 = this.bitField0_;
        int n11 = n102 & 1;
        n11 = n11 != 0 ? 1 : 0;
        Object object = this.name_;
        DescriptorProtos$MethodDescriptorProto.access$14102(descriptorProtos$MethodDescriptorProto, object);
        int bl2 = n102 & 2;
        if (bl2 != 0) {
            n11 |= 2;
        }
        object = this.inputType_;
        DescriptorProtos$MethodDescriptorProto.access$14202(descriptorProtos$MethodDescriptorProto, object);
        int n12 = n102 & 4;
        if (n12 != 0) {
            n11 |= 4;
        }
        object = this.outputType_;
        DescriptorProtos$MethodDescriptorProto.access$14302(descriptorProtos$MethodDescriptorProto, object);
        int n13 = n102 & 8;
        if (n13 != 0) {
            object = this.optionsBuilder_;
            if (object == null) {
                object = this.options_;
                DescriptorProtos$MethodDescriptorProto.access$14402(descriptorProtos$MethodDescriptorProto, (DescriptorProtos$MethodOptions)object);
            } else {
                object = (DescriptorProtos$MethodOptions)((SingleFieldBuilderV3)object).build();
                DescriptorProtos$MethodDescriptorProto.access$14402(descriptorProtos$MethodDescriptorProto, (DescriptorProtos$MethodOptions)object);
            }
            n11 |= 8;
        }
        if ((n10 = n102 & 0x10) != 0) {
            boolean bl3 = this.clientStreaming_;
            DescriptorProtos$MethodDescriptorProto.access$14502(descriptorProtos$MethodDescriptorProto, bl3);
            n11 |= 0x10;
        }
        if ((n102 &= 0x20) != 0) {
            n102 = (int)(this.serverStreaming_ ? 1 : 0);
            DescriptorProtos$MethodDescriptorProto.access$14602(descriptorProtos$MethodDescriptorProto, n102 != 0);
            n11 |= 0x20;
        }
        DescriptorProtos$MethodDescriptorProto.access$14702(descriptorProtos$MethodDescriptorProto, n11);
        this.onBuilt();
        return descriptorProtos$MethodDescriptorProto;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder clear() {
        int n10;
        int n11;
        Object object;
        super.clear();
        this.name_ = object = "";
        this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
        this.inputType_ = object;
        this.bitField0_ = n11 &= 0xFFFFFFFD;
        this.outputType_ = object;
        this.bitField0_ = n10 = n11 & 0xFFFFFFFB;
        object = this.optionsBuilder_;
        if (object == null) {
            n10 = 0;
            object = null;
            this.options_ = null;
        } else {
            ((SingleFieldBuilderV3)object).clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        this.clientStreaming_ = false;
        this.bitField0_ = n10 &= 0xFFFFFFEF;
        this.serverStreaming_ = false;
        this.bitField0_ = n10 &= 0xFFFFFFDF;
        return this;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder clearClientStreaming() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
        this.clientStreaming_ = false;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (DescriptorProtos$MethodDescriptorProto$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public DescriptorProtos$MethodDescriptorProto$Builder clearInputType() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        String string2 = DescriptorProtos$MethodDescriptorProto.getDefaultInstance().getInputType();
        this.inputType_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder clearName() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        String string2 = DescriptorProtos$MethodDescriptorProto.getDefaultInstance().getName();
        this.name_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (DescriptorProtos$MethodDescriptorProto$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public DescriptorProtos$MethodDescriptorProto$Builder clearOptions() {
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
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        return this;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder clearOutputType() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        String string2 = DescriptorProtos$MethodDescriptorProto.getDefaultInstance().getOutputType();
        this.outputType_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder clearServerStreaming() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFDF;
        this.serverStreaming_ = false;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder clone() {
        return (DescriptorProtos$MethodDescriptorProto$Builder)super.clone();
    }

    public boolean getClientStreaming() {
        return this.clientStreaming_;
    }

    public DescriptorProtos$MethodDescriptorProto getDefaultInstanceForType() {
        return DescriptorProtos$MethodDescriptorProto.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$13600();
    }

    public String getInputType() {
        Object object = this.inputType_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.inputType_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getInputTypeBytes() {
        Object object = this.inputType_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.inputType_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
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

    public DescriptorProtos$MethodOptions getOptions() {
        Object object = this.optionsBuilder_;
        if (object == null) {
            object = this.options_;
            if (object == null) {
                object = DescriptorProtos$MethodOptions.getDefaultInstance();
            }
            return object;
        }
        return (DescriptorProtos$MethodOptions)((SingleFieldBuilderV3)object).getMessage();
    }

    public DescriptorProtos$MethodOptions$Builder getOptionsBuilder() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.onChanged();
        return (DescriptorProtos$MethodOptions$Builder)this.getOptionsFieldBuilder().getBuilder();
    }

    public DescriptorProtos$MethodOptionsOrBuilder getOptionsOrBuilder() {
        Object object = this.optionsBuilder_;
        if (object != null) {
            return (DescriptorProtos$MethodOptionsOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.options_;
        if (object == null) {
            object = DescriptorProtos$MethodOptions.getDefaultInstance();
        }
        return object;
    }

    public String getOutputType() {
        Object object = this.outputType_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.outputType_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getOutputTypeBytes() {
        Object object = this.outputType_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.outputType_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public boolean getServerStreaming() {
        return this.serverStreaming_;
    }

    public boolean hasClientStreaming() {
        int n10 = this.bitField0_ & 0x10;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasInputType() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
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
        int n10 = this.bitField0_ & 8;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasOutputType() {
        int n10 = this.bitField0_ & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasServerStreaming() {
        int n10 = this.bitField0_ & 0x20;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$13700().ensureFieldAccessorsInitialized(DescriptorProtos$MethodDescriptorProto.class, DescriptorProtos$MethodDescriptorProto$Builder.class);
    }

    public final boolean isInitialized() {
        DescriptorProtos$MethodOptions descriptorProtos$MethodOptions;
        boolean bl2 = this.hasOptions();
        return !bl2 || (bl2 = (descriptorProtos$MethodOptions = this.getOptions()).isInitialized());
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public DescriptorProtos$MethodDescriptorProto$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = DescriptorProtos$MethodDescriptorProto.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (DescriptorProtos$MethodDescriptorProto)object;
            if (object == null) break block7;
            this.mergeFrom((DescriptorProtos$MethodDescriptorProto)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (DescriptorProtos$MethodDescriptorProto)object2;
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
            this.mergeFrom((DescriptorProtos$MethodDescriptorProto)object3);
        }
        throw var1_6;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder mergeFrom(DescriptorProtos$MethodDescriptorProto messageLite) {
        boolean bl2;
        boolean bl3;
        boolean bl4;
        boolean bl5;
        boolean bl6;
        Object object = DescriptorProtos$MethodDescriptorProto.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        boolean bl22 = ((DescriptorProtos$MethodDescriptorProto)messageLite).hasName();
        if (bl22) {
            int n10;
            this.bitField0_ = n10 = this.bitField0_ | 1;
            this.name_ = object = DescriptorProtos$MethodDescriptorProto.access$14100((DescriptorProtos$MethodDescriptorProto)messageLite);
            this.onChanged();
        }
        if (bl6 = ((DescriptorProtos$MethodDescriptorProto)messageLite).hasInputType()) {
            int n11;
            this.bitField0_ = n11 = this.bitField0_ | 2;
            this.inputType_ = object = DescriptorProtos$MethodDescriptorProto.access$14200((DescriptorProtos$MethodDescriptorProto)messageLite);
            this.onChanged();
        }
        if (bl5 = ((DescriptorProtos$MethodDescriptorProto)messageLite).hasOutputType()) {
            int n12;
            this.bitField0_ = n12 = this.bitField0_ | 4;
            this.outputType_ = object = DescriptorProtos$MethodDescriptorProto.access$14300((DescriptorProtos$MethodDescriptorProto)messageLite);
            this.onChanged();
        }
        if (bl4 = ((DescriptorProtos$MethodDescriptorProto)messageLite).hasOptions()) {
            object = ((DescriptorProtos$MethodDescriptorProto)messageLite).getOptions();
            this.mergeOptions((DescriptorProtos$MethodOptions)object);
        }
        if (bl3 = ((DescriptorProtos$MethodDescriptorProto)messageLite).hasClientStreaming()) {
            boolean bl7 = ((DescriptorProtos$MethodDescriptorProto)messageLite).getClientStreaming();
            this.setClientStreaming(bl7);
        }
        if (bl2 = ((DescriptorProtos$MethodDescriptorProto)messageLite).hasServerStreaming()) {
            boolean bl8 = ((DescriptorProtos$MethodDescriptorProto)messageLite).getServerStreaming();
            this.setServerStreaming(bl8);
        }
        messageLite = ((GeneratedMessageV3)messageLite).unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof DescriptorProtos$MethodDescriptorProto;
        if (bl2) {
            message = (DescriptorProtos$MethodDescriptorProto)message;
            return this.mergeFrom((DescriptorProtos$MethodDescriptorProto)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder mergeOptions(DescriptorProtos$MethodOptions descriptorProtos$MethodOptions) {
        int n10;
        Object object = this.optionsBuilder_;
        if (object == null) {
            DescriptorProtos$MethodOptions descriptorProtos$MethodOptions2;
            int n11 = this.bitField0_ & 8;
            if (n11 != 0 && (object = this.options_) != null && object != (descriptorProtos$MethodOptions2 = DescriptorProtos$MethodOptions.getDefaultInstance())) {
                object = DescriptorProtos$MethodOptions.newBuilder(this.options_);
                this.options_ = descriptorProtos$MethodOptions = ((DescriptorProtos$MethodOptions$Builder)object).mergeFrom(descriptorProtos$MethodOptions).buildPartial();
            } else {
                this.options_ = descriptorProtos$MethodOptions;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(descriptorProtos$MethodOptions);
        }
        this.bitField0_ = n10 = this.bitField0_ | 8;
        return this;
    }

    public final DescriptorProtos$MethodDescriptorProto$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$MethodDescriptorProto$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public DescriptorProtos$MethodDescriptorProto$Builder setClientStreaming(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x10;
        this.clientStreaming_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$MethodDescriptorProto$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$MethodDescriptorProto$Builder setInputType(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.inputType_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder setInputTypeBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.inputType_ = byteString;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder setName(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.name_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder setNameBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.name_ = byteString;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder setOptions(DescriptorProtos$MethodOptions$Builder descriptorProtos$MethodOptionsOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.optionsBuilder_;
        if (singleFieldBuilderV3 == null) {
            descriptorProtos$MethodOptionsOrBuilder = descriptorProtos$MethodOptionsOrBuilder.build();
            this.options_ = descriptorProtos$MethodOptionsOrBuilder;
            this.onChanged();
        } else {
            descriptorProtos$MethodOptionsOrBuilder = descriptorProtos$MethodOptionsOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)descriptorProtos$MethodOptionsOrBuilder));
        }
        this.bitField0_ = n10 = this.bitField0_ | 8;
        return this;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder setOptions(DescriptorProtos$MethodOptions descriptorProtos$MethodOptions) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.optionsBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(descriptorProtos$MethodOptions);
            this.options_ = descriptorProtos$MethodOptions;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(descriptorProtos$MethodOptions);
        }
        this.bitField0_ = n10 = this.bitField0_ | 8;
        return this;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder setOutputType(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.outputType_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder setOutputTypeBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.outputType_ = byteString;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (DescriptorProtos$MethodDescriptorProto$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public DescriptorProtos$MethodDescriptorProto$Builder setServerStreaming(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x20;
        this.serverStreaming_ = bl2;
        this.onChanged();
        return this;
    }

    public final DescriptorProtos$MethodDescriptorProto$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$MethodDescriptorProto$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

