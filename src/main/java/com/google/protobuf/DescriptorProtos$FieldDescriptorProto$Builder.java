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
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Label;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Type;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FieldOptions;
import com.google.protobuf.DescriptorProtos$FieldOptions$Builder;
import com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder;
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

public final class DescriptorProtos$FieldDescriptorProto$Builder
extends GeneratedMessageV3$Builder
implements DescriptorProtos$FieldDescriptorProtoOrBuilder {
    private int bitField0_;
    private Object defaultValue_;
    private Object extendee_;
    private Object jsonName_;
    private int label_;
    private Object name_;
    private int number_;
    private int oneofIndex_;
    private SingleFieldBuilderV3 optionsBuilder_;
    private DescriptorProtos$FieldOptions options_;
    private Object typeName_;
    private int type_;

    private DescriptorProtos$FieldDescriptorProto$Builder() {
        int n10;
        String string2 = "";
        this.name_ = string2;
        this.label_ = n10 = 1;
        this.type_ = n10;
        this.typeName_ = string2;
        this.extendee_ = string2;
        this.defaultValue_ = string2;
        this.jsonName_ = string2;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$FieldDescriptorProto$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    private DescriptorProtos$FieldDescriptorProto$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        int n10;
        this.name_ = object = "";
        this.label_ = n10 = 1;
        this.type_ = n10;
        this.typeName_ = object;
        this.extendee_ = object;
        this.defaultValue_ = object;
        this.jsonName_ = object;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$FieldDescriptorProto$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$6900();
    }

    private SingleFieldBuilderV3 getOptionsFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.optionsBuilder_;
        if (singleFieldBuilderV3 == null) {
            DescriptorProtos$FieldOptions descriptorProtos$FieldOptions = this.getOptions();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.optionsBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(descriptorProtos$FieldOptions, generatedMessageV3$BuilderParent, bl2);
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

    public DescriptorProtos$FieldDescriptorProto$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$FieldDescriptorProto$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$FieldDescriptorProto build() {
        DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto = this.buildPartial();
        boolean bl2 = descriptorProtos$FieldDescriptorProto.isInitialized();
        if (bl2) {
            return descriptorProtos$FieldDescriptorProto;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(descriptorProtos$FieldDescriptorProto);
    }

    public DescriptorProtos$FieldDescriptorProto buildPartial() {
        Object object = null;
        DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto = new DescriptorProtos$FieldDescriptorProto(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        n11 = n11 != 0 ? 1 : 0;
        Object object2 = this.name_;
        DescriptorProtos$FieldDescriptorProto.access$7402(descriptorProtos$FieldDescriptorProto, object2);
        int n12 = n10 & 2;
        if (n12 != 0) {
            n12 = this.number_;
            DescriptorProtos$FieldDescriptorProto.access$7502(descriptorProtos$FieldDescriptorProto, n12);
            n11 |= 2;
        }
        if ((n12 = n10 & 4) != 0) {
            n11 |= 4;
        }
        n12 = this.label_;
        DescriptorProtos$FieldDescriptorProto.access$7602(descriptorProtos$FieldDescriptorProto, n12);
        n12 = n10 & 8;
        if (n12 != 0) {
            n11 |= 8;
        }
        n12 = this.type_;
        DescriptorProtos$FieldDescriptorProto.access$7702(descriptorProtos$FieldDescriptorProto, n12);
        n12 = n10 & 0x10;
        if (n12 != 0) {
            n11 |= 0x10;
        }
        object2 = this.typeName_;
        DescriptorProtos$FieldDescriptorProto.access$7802(descriptorProtos$FieldDescriptorProto, object2);
        n12 = n10 & 0x20;
        if (n12 != 0) {
            n11 |= 0x20;
        }
        object2 = this.extendee_;
        DescriptorProtos$FieldDescriptorProto.access$7902(descriptorProtos$FieldDescriptorProto, object2);
        n12 = n10 & 0x40;
        if (n12 != 0) {
            n11 |= 0x40;
        }
        object2 = this.defaultValue_;
        DescriptorProtos$FieldDescriptorProto.access$8002(descriptorProtos$FieldDescriptorProto, object2);
        n12 = n10 & 0x80;
        if (n12 != 0) {
            n12 = this.oneofIndex_;
            DescriptorProtos$FieldDescriptorProto.access$8102(descriptorProtos$FieldDescriptorProto, n12);
            n11 |= 0x80;
        }
        if ((n12 = n10 & 0x100) != 0) {
            n11 |= 0x100;
        }
        object2 = this.jsonName_;
        DescriptorProtos$FieldDescriptorProto.access$8202(descriptorProtos$FieldDescriptorProto, object2);
        if ((n10 &= 0x200) != 0) {
            object = this.optionsBuilder_;
            if (object == null) {
                object = this.options_;
                DescriptorProtos$FieldDescriptorProto.access$8302(descriptorProtos$FieldDescriptorProto, (DescriptorProtos$FieldOptions)object);
            } else {
                object = (DescriptorProtos$FieldOptions)((SingleFieldBuilderV3)object).build();
                DescriptorProtos$FieldDescriptorProto.access$8302(descriptorProtos$FieldDescriptorProto, (DescriptorProtos$FieldOptions)object);
            }
            n11 |= 0x200;
        }
        DescriptorProtos$FieldDescriptorProto.access$8402(descriptorProtos$FieldDescriptorProto, n11);
        this.onBuilt();
        return descriptorProtos$FieldDescriptorProto;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder clear() {
        int n10;
        int n11;
        int n12;
        Object object;
        super.clear();
        this.name_ = object = "";
        this.bitField0_ = n12 = this.bitField0_ & 0xFFFFFFFE;
        this.number_ = 0;
        this.bitField0_ = n12 &= 0xFFFFFFFD;
        this.label_ = n11 = 1;
        this.bitField0_ = n12 &= 0xFFFFFFFB;
        this.type_ = n11;
        this.bitField0_ = n12 &= 0xFFFFFFF7;
        this.typeName_ = object;
        this.bitField0_ = n12 &= 0xFFFFFFEF;
        this.extendee_ = object;
        this.bitField0_ = n12 &= 0xFFFFFFDF;
        this.defaultValue_ = object;
        this.bitField0_ = n12 &= 0xFFFFFFBF;
        this.oneofIndex_ = 0;
        this.bitField0_ = n12 &= 0xFFFFFF7F;
        this.jsonName_ = object;
        this.bitField0_ = n10 = n12 & 0xFFFFFEFF;
        object = this.optionsBuilder_;
        if (object == null) {
            n10 = 0;
            object = null;
            this.options_ = null;
        } else {
            ((SingleFieldBuilderV3)object).clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFDFF;
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder clearDefaultValue() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFBF;
        String string2 = DescriptorProtos$FieldDescriptorProto.getDefaultInstance().getDefaultValue();
        this.defaultValue_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder clearExtendee() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFDF;
        String string2 = DescriptorProtos$FieldDescriptorProto.getDefaultInstance().getExtendee();
        this.extendee_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (DescriptorProtos$FieldDescriptorProto$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public DescriptorProtos$FieldDescriptorProto$Builder clearJsonName() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFEFF;
        String string2 = DescriptorProtos$FieldDescriptorProto.getDefaultInstance().getJsonName();
        this.jsonName_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder clearLabel() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        this.label_ = 1;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder clearName() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        String string2 = DescriptorProtos$FieldDescriptorProto.getDefaultInstance().getName();
        this.name_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder clearNumber() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.number_ = 0;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (DescriptorProtos$FieldDescriptorProto$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public DescriptorProtos$FieldDescriptorProto$Builder clearOneofIndex() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFF7F;
        this.oneofIndex_ = 0;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder clearOptions() {
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
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFDFF;
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder clearType() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        this.type_ = 1;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder clearTypeName() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
        String string2 = DescriptorProtos$FieldDescriptorProto.getDefaultInstance().getTypeName();
        this.typeName_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder clone() {
        return (DescriptorProtos$FieldDescriptorProto$Builder)super.clone();
    }

    public DescriptorProtos$FieldDescriptorProto getDefaultInstanceForType() {
        return DescriptorProtos$FieldDescriptorProto.getDefaultInstance();
    }

    public String getDefaultValue() {
        Object object = this.defaultValue_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.defaultValue_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getDefaultValueBytes() {
        Object object = this.defaultValue_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.defaultValue_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$6900();
    }

    public String getExtendee() {
        Object object = this.extendee_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.extendee_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getExtendeeBytes() {
        Object object = this.extendee_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.extendee_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public String getJsonName() {
        Object object = this.jsonName_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.jsonName_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getJsonNameBytes() {
        Object object = this.jsonName_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.jsonName_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public DescriptorProtos$FieldDescriptorProto$Label getLabel() {
        int n10 = this.label_;
        DescriptorProtos$FieldDescriptorProto$Label descriptorProtos$FieldDescriptorProto$Label = DescriptorProtos$FieldDescriptorProto$Label.valueOf(n10);
        if (descriptorProtos$FieldDescriptorProto$Label == null) {
            descriptorProtos$FieldDescriptorProto$Label = DescriptorProtos$FieldDescriptorProto$Label.LABEL_OPTIONAL;
        }
        return descriptorProtos$FieldDescriptorProto$Label;
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

    public int getOneofIndex() {
        return this.oneofIndex_;
    }

    public DescriptorProtos$FieldOptions getOptions() {
        Object object = this.optionsBuilder_;
        if (object == null) {
            object = this.options_;
            if (object == null) {
                object = DescriptorProtos$FieldOptions.getDefaultInstance();
            }
            return object;
        }
        return (DescriptorProtos$FieldOptions)((SingleFieldBuilderV3)object).getMessage();
    }

    public DescriptorProtos$FieldOptions$Builder getOptionsBuilder() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x200;
        this.onChanged();
        return (DescriptorProtos$FieldOptions$Builder)this.getOptionsFieldBuilder().getBuilder();
    }

    public DescriptorProtos$FieldOptionsOrBuilder getOptionsOrBuilder() {
        Object object = this.optionsBuilder_;
        if (object != null) {
            return (DescriptorProtos$FieldOptionsOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.options_;
        if (object == null) {
            object = DescriptorProtos$FieldOptions.getDefaultInstance();
        }
        return object;
    }

    public DescriptorProtos$FieldDescriptorProto$Type getType() {
        int n10 = this.type_;
        DescriptorProtos$FieldDescriptorProto$Type descriptorProtos$FieldDescriptorProto$Type = DescriptorProtos$FieldDescriptorProto$Type.valueOf(n10);
        if (descriptorProtos$FieldDescriptorProto$Type == null) {
            descriptorProtos$FieldDescriptorProto$Type = DescriptorProtos$FieldDescriptorProto$Type.TYPE_DOUBLE;
        }
        return descriptorProtos$FieldDescriptorProto$Type;
    }

    public String getTypeName() {
        Object object = this.typeName_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.typeName_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getTypeNameBytes() {
        Object object = this.typeName_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.typeName_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public boolean hasDefaultValue() {
        int n10 = this.bitField0_ & 0x40;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasExtendee() {
        int n10 = this.bitField0_ & 0x20;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasJsonName() {
        int n10 = this.bitField0_ & 0x100;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasLabel() {
        int n10 = this.bitField0_ & 4;
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

    public boolean hasNumber() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasOneofIndex() {
        int n10 = this.bitField0_ & 0x80;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasOptions() {
        int n10 = this.bitField0_ & 0x200;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasType() {
        int n10 = this.bitField0_ & 8;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasTypeName() {
        int n10 = this.bitField0_ & 0x10;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$7000().ensureFieldAccessorsInitialized(DescriptorProtos$FieldDescriptorProto.class, DescriptorProtos$FieldDescriptorProto$Builder.class);
    }

    public final boolean isInitialized() {
        DescriptorProtos$FieldOptions descriptorProtos$FieldOptions;
        boolean bl2 = this.hasOptions();
        return !bl2 || (bl2 = (descriptorProtos$FieldOptions = this.getOptions()).isInitialized());
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public DescriptorProtos$FieldDescriptorProto$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = DescriptorProtos$FieldDescriptorProto.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (DescriptorProtos$FieldDescriptorProto)object;
            if (object == null) break block7;
            this.mergeFrom((DescriptorProtos$FieldDescriptorProto)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (DescriptorProtos$FieldDescriptorProto)object2;
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
            this.mergeFrom((DescriptorProtos$FieldDescriptorProto)object3);
        }
        throw var1_6;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder mergeFrom(DescriptorProtos$FieldDescriptorProto messageLite) {
        Object object = DescriptorProtos$FieldDescriptorProto.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        int n10 = messageLite.hasName();
        if (n10 != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 1;
            this.name_ = object = DescriptorProtos$FieldDescriptorProto.access$7400(messageLite);
            this.onChanged();
        }
        if ((n10 = messageLite.hasNumber()) != 0) {
            n10 = messageLite.getNumber();
            this.setNumber(n10);
        }
        if ((n10 = (int)(messageLite.hasLabel() ? 1 : 0)) != 0) {
            object = messageLite.getLabel();
            this.setLabel((DescriptorProtos$FieldDescriptorProto$Label)object);
        }
        if ((n10 = (int)(messageLite.hasType() ? 1 : 0)) != 0) {
            object = messageLite.getType();
            this.setType((DescriptorProtos$FieldDescriptorProto$Type)object);
        }
        if ((n10 = (int)(messageLite.hasTypeName() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 0x10;
            this.typeName_ = object = DescriptorProtos$FieldDescriptorProto.access$7800(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasExtendee() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 0x20;
            this.extendee_ = object = DescriptorProtos$FieldDescriptorProto.access$7900(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasDefaultValue() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 0x40;
            this.defaultValue_ = object = DescriptorProtos$FieldDescriptorProto.access$8000(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasOneofIndex() ? 1 : 0)) != 0) {
            n10 = messageLite.getOneofIndex();
            this.setOneofIndex(n10);
        }
        if ((n10 = (int)(messageLite.hasJsonName() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 0x100;
            this.jsonName_ = object = DescriptorProtos$FieldDescriptorProto.access$8200(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasOptions() ? 1 : 0)) != 0) {
            object = messageLite.getOptions();
            this.mergeOptions((DescriptorProtos$FieldOptions)object);
        }
        messageLite = messageLite.unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof DescriptorProtos$FieldDescriptorProto;
        if (bl2) {
            message = (DescriptorProtos$FieldDescriptorProto)message;
            return this.mergeFrom((DescriptorProtos$FieldDescriptorProto)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder mergeOptions(DescriptorProtos$FieldOptions descriptorProtos$FieldOptions) {
        int n10;
        Object object = this.optionsBuilder_;
        if (object == null) {
            DescriptorProtos$FieldOptions descriptorProtos$FieldOptions2;
            int n11 = this.bitField0_ & 0x200;
            if (n11 != 0 && (object = this.options_) != null && object != (descriptorProtos$FieldOptions2 = DescriptorProtos$FieldOptions.getDefaultInstance())) {
                object = DescriptorProtos$FieldOptions.newBuilder(this.options_);
                this.options_ = descriptorProtos$FieldOptions = ((DescriptorProtos$FieldOptions$Builder)object).mergeFrom(descriptorProtos$FieldOptions).buildPartial();
            } else {
                this.options_ = descriptorProtos$FieldOptions;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(descriptorProtos$FieldOptions);
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x200;
        return this;
    }

    public final DescriptorProtos$FieldDescriptorProto$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$FieldDescriptorProto$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public DescriptorProtos$FieldDescriptorProto$Builder setDefaultValue(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x40;
        this.defaultValue_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder setDefaultValueBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x40;
        this.defaultValue_ = byteString;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder setExtendee(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x20;
        this.extendee_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder setExtendeeBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x20;
        this.extendee_ = byteString;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$FieldDescriptorProto$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$FieldDescriptorProto$Builder setJsonName(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x100;
        this.jsonName_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder setJsonNameBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x100;
        this.jsonName_ = byteString;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder setLabel(DescriptorProtos$FieldDescriptorProto$Label descriptorProtos$FieldDescriptorProto$Label) {
        int n10;
        int n11;
        Objects.requireNonNull(descriptorProtos$FieldDescriptorProto$Label);
        this.bitField0_ = n11 = this.bitField0_ | 4;
        this.label_ = n10 = descriptorProtos$FieldDescriptorProto$Label.getNumber();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder setName(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.name_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder setNameBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.name_ = byteString;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder setNumber(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 2;
        this.number_ = n10;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder setOneofIndex(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 0x80;
        this.oneofIndex_ = n10;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder setOptions(DescriptorProtos$FieldOptions$Builder descriptorProtos$FieldOptionsOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.optionsBuilder_;
        if (singleFieldBuilderV3 == null) {
            descriptorProtos$FieldOptionsOrBuilder = descriptorProtos$FieldOptionsOrBuilder.build();
            this.options_ = descriptorProtos$FieldOptionsOrBuilder;
            this.onChanged();
        } else {
            descriptorProtos$FieldOptionsOrBuilder = descriptorProtos$FieldOptionsOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)descriptorProtos$FieldOptionsOrBuilder));
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x200;
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder setOptions(DescriptorProtos$FieldOptions descriptorProtos$FieldOptions) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.optionsBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(descriptorProtos$FieldOptions);
            this.options_ = descriptorProtos$FieldOptions;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(descriptorProtos$FieldOptions);
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x200;
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (DescriptorProtos$FieldDescriptorProto$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public DescriptorProtos$FieldDescriptorProto$Builder setType(DescriptorProtos$FieldDescriptorProto$Type descriptorProtos$FieldDescriptorProto$Type) {
        int n10;
        int n11;
        Objects.requireNonNull(descriptorProtos$FieldDescriptorProto$Type);
        this.bitField0_ = n11 = this.bitField0_ | 8;
        this.type_ = n10 = descriptorProtos$FieldDescriptorProto$Type.getNumber();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder setTypeName(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x10;
        this.typeName_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder setTypeNameBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x10;
        this.typeName_ = byteString;
        this.onChanged();
        return this;
    }

    public final DescriptorProtos$FieldDescriptorProto$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$FieldDescriptorProto$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

