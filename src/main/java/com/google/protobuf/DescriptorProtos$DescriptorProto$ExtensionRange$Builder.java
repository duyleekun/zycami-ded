/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRange;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder;
import com.google.protobuf.DescriptorProtos$ExtensionRangeOptions;
import com.google.protobuf.DescriptorProtos$ExtensionRangeOptions$Builder;
import com.google.protobuf.DescriptorProtos$ExtensionRangeOptionsOrBuilder;
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

public final class DescriptorProtos$DescriptorProto$ExtensionRange$Builder
extends GeneratedMessageV3$Builder
implements DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder {
    private int bitField0_;
    private int end_;
    private SingleFieldBuilderV3 optionsBuilder_;
    private DescriptorProtos$ExtensionRangeOptions options_;
    private int start_;

    private DescriptorProtos$DescriptorProto$ExtensionRange$Builder() {
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$DescriptorProto$ExtensionRange$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    private DescriptorProtos$DescriptorProto$ExtensionRange$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        super(generatedMessageV3$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$DescriptorProto$ExtensionRange$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$2800();
    }

    private SingleFieldBuilderV3 getOptionsFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.optionsBuilder_;
        if (singleFieldBuilderV3 == null) {
            DescriptorProtos$ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions = this.getOptions();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.optionsBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(descriptorProtos$ExtensionRangeOptions, generatedMessageV3$BuilderParent, bl2);
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

    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$DescriptorProto$ExtensionRange$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$DescriptorProto$ExtensionRange build() {
        DescriptorProtos$DescriptorProto$ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange = this.buildPartial();
        boolean bl2 = descriptorProtos$DescriptorProto$ExtensionRange.isInitialized();
        if (bl2) {
            return descriptorProtos$DescriptorProto$ExtensionRange;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(descriptorProtos$DescriptorProto$ExtensionRange);
    }

    public DescriptorProtos$DescriptorProto$ExtensionRange buildPartial() {
        Object object = null;
        DescriptorProtos$DescriptorProto$ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange = new DescriptorProtos$DescriptorProto$ExtensionRange(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        if (n11 != 0) {
            n11 = this.start_;
            DescriptorProtos$DescriptorProto$ExtensionRange.access$3302(descriptorProtos$DescriptorProto$ExtensionRange, n11);
            n11 = 1;
        } else {
            n11 = 0;
        }
        int n12 = n10 & 2;
        if (n12 != 0) {
            n12 = this.end_;
            DescriptorProtos$DescriptorProto$ExtensionRange.access$3402(descriptorProtos$DescriptorProto$ExtensionRange, n12);
            n11 |= 2;
        }
        if ((n10 &= 4) != 0) {
            object = this.optionsBuilder_;
            if (object == null) {
                object = this.options_;
                DescriptorProtos$DescriptorProto$ExtensionRange.access$3502(descriptorProtos$DescriptorProto$ExtensionRange, (DescriptorProtos$ExtensionRangeOptions)object);
            } else {
                object = (DescriptorProtos$ExtensionRangeOptions)((SingleFieldBuilderV3)object).build();
                DescriptorProtos$DescriptorProto$ExtensionRange.access$3502(descriptorProtos$DescriptorProto$ExtensionRange, (DescriptorProtos$ExtensionRangeOptions)object);
            }
            n11 |= 4;
        }
        DescriptorProtos$DescriptorProto$ExtensionRange.access$3602(descriptorProtos$DescriptorProto$ExtensionRange, n11);
        this.onBuilt();
        return descriptorProtos$DescriptorProto$ExtensionRange;
    }

    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder clear() {
        int n10;
        int n11;
        super.clear();
        this.start_ = 0;
        this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
        this.end_ = 0;
        this.bitField0_ = n10 = n11 & 0xFFFFFFFD;
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

    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder clearEnd() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.end_ = 0;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (DescriptorProtos$DescriptorProto$ExtensionRange$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (DescriptorProtos$DescriptorProto$ExtensionRange$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder clearOptions() {
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

    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder clearStart() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.start_ = 0;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder clone() {
        return (DescriptorProtos$DescriptorProto$ExtensionRange$Builder)super.clone();
    }

    public DescriptorProtos$DescriptorProto$ExtensionRange getDefaultInstanceForType() {
        return DescriptorProtos$DescriptorProto$ExtensionRange.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$2800();
    }

    public int getEnd() {
        return this.end_;
    }

    public DescriptorProtos$ExtensionRangeOptions getOptions() {
        Object object = this.optionsBuilder_;
        if (object == null) {
            object = this.options_;
            if (object == null) {
                object = DescriptorProtos$ExtensionRangeOptions.getDefaultInstance();
            }
            return object;
        }
        return (DescriptorProtos$ExtensionRangeOptions)((SingleFieldBuilderV3)object).getMessage();
    }

    public DescriptorProtos$ExtensionRangeOptions$Builder getOptionsBuilder() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.onChanged();
        return (DescriptorProtos$ExtensionRangeOptions$Builder)this.getOptionsFieldBuilder().getBuilder();
    }

    public DescriptorProtos$ExtensionRangeOptionsOrBuilder getOptionsOrBuilder() {
        Object object = this.optionsBuilder_;
        if (object != null) {
            return (DescriptorProtos$ExtensionRangeOptionsOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.options_;
        if (object == null) {
            object = DescriptorProtos$ExtensionRangeOptions.getDefaultInstance();
        }
        return object;
    }

    public int getStart() {
        return this.start_;
    }

    public boolean hasEnd() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasOptions() {
        int n10 = this.bitField0_ & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasStart() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$2900().ensureFieldAccessorsInitialized(DescriptorProtos$DescriptorProto$ExtensionRange.class, DescriptorProtos$DescriptorProto$ExtensionRange$Builder.class);
    }

    public final boolean isInitialized() {
        DescriptorProtos$ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions;
        boolean bl2 = this.hasOptions();
        return !bl2 || (bl2 = (descriptorProtos$ExtensionRangeOptions = this.getOptions()).isInitialized());
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = DescriptorProtos$DescriptorProto$ExtensionRange.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (DescriptorProtos$DescriptorProto$ExtensionRange)object;
            if (object == null) break block7;
            this.mergeFrom((DescriptorProtos$DescriptorProto$ExtensionRange)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (DescriptorProtos$DescriptorProto$ExtensionRange)object2;
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
            this.mergeFrom((DescriptorProtos$DescriptorProto$ExtensionRange)object3);
        }
        throw var1_6;
    }

    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder mergeFrom(DescriptorProtos$DescriptorProto$ExtensionRange messageLite) {
        GeneratedMessageV3 generatedMessageV3 = DescriptorProtos$DescriptorProto$ExtensionRange.getDefaultInstance();
        if (messageLite == generatedMessageV3) {
            return this;
        }
        int n10 = messageLite.hasStart();
        if (n10 != 0) {
            n10 = messageLite.getStart();
            this.setStart(n10);
        }
        if ((n10 = (int)(messageLite.hasEnd() ? 1 : 0)) != 0) {
            n10 = messageLite.getEnd();
            this.setEnd(n10);
        }
        if ((n10 = (int)(messageLite.hasOptions() ? 1 : 0)) != 0) {
            generatedMessageV3 = messageLite.getOptions();
            this.mergeOptions((DescriptorProtos$ExtensionRangeOptions)generatedMessageV3);
        }
        messageLite = messageLite.unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof DescriptorProtos$DescriptorProto$ExtensionRange;
        if (bl2) {
            message = (DescriptorProtos$DescriptorProto$ExtensionRange)message;
            return this.mergeFrom((DescriptorProtos$DescriptorProto$ExtensionRange)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder mergeOptions(DescriptorProtos$ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions) {
        int n10;
        Object object = this.optionsBuilder_;
        if (object == null) {
            DescriptorProtos$ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions2;
            int n11 = this.bitField0_ & 4;
            if (n11 != 0 && (object = this.options_) != null && object != (descriptorProtos$ExtensionRangeOptions2 = DescriptorProtos$ExtensionRangeOptions.getDefaultInstance())) {
                object = DescriptorProtos$ExtensionRangeOptions.newBuilder(this.options_);
                this.options_ = descriptorProtos$ExtensionRangeOptions = ((DescriptorProtos$ExtensionRangeOptions$Builder)object).mergeFrom(descriptorProtos$ExtensionRangeOptions).buildPartial();
            } else {
                this.options_ = descriptorProtos$ExtensionRangeOptions;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(descriptorProtos$ExtensionRangeOptions);
        }
        this.bitField0_ = n10 = this.bitField0_ | 4;
        return this;
    }

    public final DescriptorProtos$DescriptorProto$ExtensionRange$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$DescriptorProto$ExtensionRange$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder setEnd(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 2;
        this.end_ = n10;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$DescriptorProto$ExtensionRange$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder setOptions(DescriptorProtos$ExtensionRangeOptions$Builder descriptorProtos$ExtensionRangeOptionsOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.optionsBuilder_;
        if (singleFieldBuilderV3 == null) {
            descriptorProtos$ExtensionRangeOptionsOrBuilder = descriptorProtos$ExtensionRangeOptionsOrBuilder.build();
            this.options_ = descriptorProtos$ExtensionRangeOptionsOrBuilder;
            this.onChanged();
        } else {
            descriptorProtos$ExtensionRangeOptionsOrBuilder = descriptorProtos$ExtensionRangeOptionsOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)descriptorProtos$ExtensionRangeOptionsOrBuilder));
        }
        this.bitField0_ = n10 = this.bitField0_ | 4;
        return this;
    }

    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder setOptions(DescriptorProtos$ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.optionsBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(descriptorProtos$ExtensionRangeOptions);
            this.options_ = descriptorProtos$ExtensionRangeOptions;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(descriptorProtos$ExtensionRangeOptions);
        }
        this.bitField0_ = n10 = this.bitField0_ | 4;
        return this;
    }

    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (DescriptorProtos$DescriptorProto$ExtensionRange$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder setStart(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 1;
        this.start_ = n10;
        this.onChanged();
        return this;
    }

    public final DescriptorProtos$DescriptorProto$ExtensionRange$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$DescriptorProto$ExtensionRange$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

