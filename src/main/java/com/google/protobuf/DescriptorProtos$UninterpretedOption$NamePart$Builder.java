/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePart;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePartOrBuilder;
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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.Objects;

public final class DescriptorProtos$UninterpretedOption$NamePart$Builder
extends GeneratedMessageV3$Builder
implements DescriptorProtos$UninterpretedOption$NamePartOrBuilder {
    private int bitField0_;
    private boolean isExtension_;
    private Object namePart_ = "";

    private DescriptorProtos$UninterpretedOption$NamePart$Builder() {
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$UninterpretedOption$NamePart$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    private DescriptorProtos$UninterpretedOption$NamePart$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        super(generatedMessageV3$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$UninterpretedOption$NamePart$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$25000();
    }

    private void maybeForceBuilderInitialization() {
    }

    public DescriptorProtos$UninterpretedOption$NamePart$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$UninterpretedOption$NamePart$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$UninterpretedOption$NamePart build() {
        DescriptorProtos$UninterpretedOption$NamePart descriptorProtos$UninterpretedOption$NamePart = this.buildPartial();
        boolean bl2 = descriptorProtos$UninterpretedOption$NamePart.isInitialized();
        if (bl2) {
            return descriptorProtos$UninterpretedOption$NamePart;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(descriptorProtos$UninterpretedOption$NamePart);
    }

    public DescriptorProtos$UninterpretedOption$NamePart buildPartial() {
        DescriptorProtos$UninterpretedOption$NamePart descriptorProtos$UninterpretedOption$NamePart = new DescriptorProtos$UninterpretedOption$NamePart(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        n11 = n11 != 0 ? 1 : 0;
        Object object = this.namePart_;
        DescriptorProtos$UninterpretedOption$NamePart.access$25502(descriptorProtos$UninterpretedOption$NamePart, object);
        if ((n10 &= 2) != 0) {
            n10 = (int)(this.isExtension_ ? 1 : 0);
            DescriptorProtos$UninterpretedOption$NamePart.access$25602(descriptorProtos$UninterpretedOption$NamePart, n10 != 0);
            n11 |= 2;
        }
        DescriptorProtos$UninterpretedOption$NamePart.access$25702(descriptorProtos$UninterpretedOption$NamePart, n11);
        this.onBuilt();
        return descriptorProtos$UninterpretedOption$NamePart;
    }

    public DescriptorProtos$UninterpretedOption$NamePart$Builder clear() {
        int n10;
        super.clear();
        this.namePart_ = "";
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.isExtension_ = false;
        this.bitField0_ = n10 &= 0xFFFFFFFD;
        return this;
    }

    public DescriptorProtos$UninterpretedOption$NamePart$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (DescriptorProtos$UninterpretedOption$NamePart$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public DescriptorProtos$UninterpretedOption$NamePart$Builder clearIsExtension() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.isExtension_ = false;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$UninterpretedOption$NamePart$Builder clearNamePart() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        String string2 = DescriptorProtos$UninterpretedOption$NamePart.getDefaultInstance().getNamePart();
        this.namePart_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$UninterpretedOption$NamePart$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (DescriptorProtos$UninterpretedOption$NamePart$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public DescriptorProtos$UninterpretedOption$NamePart$Builder clone() {
        return (DescriptorProtos$UninterpretedOption$NamePart$Builder)super.clone();
    }

    public DescriptorProtos$UninterpretedOption$NamePart getDefaultInstanceForType() {
        return DescriptorProtos$UninterpretedOption$NamePart.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$25000();
    }

    public boolean getIsExtension() {
        return this.isExtension_;
    }

    public String getNamePart() {
        Object object = this.namePart_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.namePart_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getNamePartBytes() {
        Object object = this.namePart_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.namePart_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public boolean hasIsExtension() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasNamePart() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$25100().ensureFieldAccessorsInitialized(DescriptorProtos$UninterpretedOption$NamePart.class, DescriptorProtos$UninterpretedOption$NamePart$Builder.class);
    }

    public final boolean isInitialized() {
        boolean bl2 = this.hasNamePart();
        if (!bl2) {
            return false;
        }
        bl2 = this.hasIsExtension();
        return bl2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public DescriptorProtos$UninterpretedOption$NamePart$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = DescriptorProtos$UninterpretedOption$NamePart.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (DescriptorProtos$UninterpretedOption$NamePart)object;
            if (object == null) break block7;
            this.mergeFrom((DescriptorProtos$UninterpretedOption$NamePart)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (DescriptorProtos$UninterpretedOption$NamePart)object2;
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
            this.mergeFrom((DescriptorProtos$UninterpretedOption$NamePart)object3);
        }
        throw var1_6;
    }

    public DescriptorProtos$UninterpretedOption$NamePart$Builder mergeFrom(DescriptorProtos$UninterpretedOption$NamePart messageLite) {
        boolean bl2;
        Object object = DescriptorProtos$UninterpretedOption$NamePart.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        boolean bl22 = ((DescriptorProtos$UninterpretedOption$NamePart)messageLite).hasNamePart();
        if (bl22) {
            int n10;
            this.bitField0_ = n10 = this.bitField0_ | 1;
            this.namePart_ = object = DescriptorProtos$UninterpretedOption$NamePart.access$25500((DescriptorProtos$UninterpretedOption$NamePart)messageLite);
            this.onChanged();
        }
        if (bl2 = ((DescriptorProtos$UninterpretedOption$NamePart)messageLite).hasIsExtension()) {
            boolean bl3 = ((DescriptorProtos$UninterpretedOption$NamePart)messageLite).getIsExtension();
            this.setIsExtension(bl3);
        }
        messageLite = ((GeneratedMessageV3)messageLite).unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$UninterpretedOption$NamePart$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof DescriptorProtos$UninterpretedOption$NamePart;
        if (bl2) {
            message = (DescriptorProtos$UninterpretedOption$NamePart)message;
            return this.mergeFrom((DescriptorProtos$UninterpretedOption$NamePart)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final DescriptorProtos$UninterpretedOption$NamePart$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$UninterpretedOption$NamePart$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public DescriptorProtos$UninterpretedOption$NamePart$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$UninterpretedOption$NamePart$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$UninterpretedOption$NamePart$Builder setIsExtension(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.isExtension_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$UninterpretedOption$NamePart$Builder setNamePart(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.namePart_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$UninterpretedOption$NamePart$Builder setNamePartBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.namePart_ = byteString;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$UninterpretedOption$NamePart$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (DescriptorProtos$UninterpretedOption$NamePart$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final DescriptorProtos$UninterpretedOption$NamePart$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$UninterpretedOption$NamePart$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

