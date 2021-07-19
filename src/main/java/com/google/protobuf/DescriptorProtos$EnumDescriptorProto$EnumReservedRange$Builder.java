/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto$EnumReservedRange;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;

public final class DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder
extends GeneratedMessageV3$Builder
implements DescriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder {
    private int bitField0_;
    private int end_;
    private int start_;

    private DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder() {
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    private DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        super(generatedMessageV3$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$9700();
    }

    private void maybeForceBuilderInitialization() {
    }

    public DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$EnumDescriptorProto$EnumReservedRange build() {
        DescriptorProtos$EnumDescriptorProto$EnumReservedRange descriptorProtos$EnumDescriptorProto$EnumReservedRange = this.buildPartial();
        boolean bl2 = descriptorProtos$EnumDescriptorProto$EnumReservedRange.isInitialized();
        if (bl2) {
            return descriptorProtos$EnumDescriptorProto$EnumReservedRange;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(descriptorProtos$EnumDescriptorProto$EnumReservedRange);
    }

    public DescriptorProtos$EnumDescriptorProto$EnumReservedRange buildPartial() {
        DescriptorProtos$EnumDescriptorProto$EnumReservedRange descriptorProtos$EnumDescriptorProto$EnumReservedRange = new DescriptorProtos$EnumDescriptorProto$EnumReservedRange(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        if (n11 != 0) {
            n11 = this.start_;
            DescriptorProtos$EnumDescriptorProto$EnumReservedRange.access$10202(descriptorProtos$EnumDescriptorProto$EnumReservedRange, n11);
            n11 = 1;
        } else {
            n11 = 0;
        }
        if ((n10 &= 2) != 0) {
            n10 = this.end_;
            DescriptorProtos$EnumDescriptorProto$EnumReservedRange.access$10302(descriptorProtos$EnumDescriptorProto$EnumReservedRange, n10);
            n11 |= 2;
        }
        DescriptorProtos$EnumDescriptorProto$EnumReservedRange.access$10402(descriptorProtos$EnumDescriptorProto$EnumReservedRange, n11);
        this.onBuilt();
        return descriptorProtos$EnumDescriptorProto$EnumReservedRange;
    }

    public DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder clear() {
        int n10;
        int n11;
        super.clear();
        this.start_ = 0;
        this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
        this.end_ = 0;
        this.bitField0_ = n10 = n11 & 0xFFFFFFFD;
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder clearEnd() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.end_ = 0;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder clearStart() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.start_ = 0;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder clone() {
        return (DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder)super.clone();
    }

    public DescriptorProtos$EnumDescriptorProto$EnumReservedRange getDefaultInstanceForType() {
        return DescriptorProtos$EnumDescriptorProto$EnumReservedRange.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$9700();
    }

    public int getEnd() {
        return this.end_;
    }

    public int getStart() {
        return this.start_;
    }

    public boolean hasEnd() {
        int n10 = this.bitField0_ & 2;
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
        return DescriptorProtos.access$9800().ensureFieldAccessorsInitialized(DescriptorProtos$EnumDescriptorProto$EnumReservedRange.class, DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder.class);
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
    public DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = DescriptorProtos$EnumDescriptorProto$EnumReservedRange.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (DescriptorProtos$EnumDescriptorProto$EnumReservedRange)object;
            if (object == null) break block7;
            this.mergeFrom((DescriptorProtos$EnumDescriptorProto$EnumReservedRange)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (DescriptorProtos$EnumDescriptorProto$EnumReservedRange)object2;
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
            this.mergeFrom((DescriptorProtos$EnumDescriptorProto$EnumReservedRange)object3);
        }
        throw var1_6;
    }

    public DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder mergeFrom(DescriptorProtos$EnumDescriptorProto$EnumReservedRange messageLite) {
        DescriptorProtos$EnumDescriptorProto$EnumReservedRange descriptorProtos$EnumDescriptorProto$EnumReservedRange = DescriptorProtos$EnumDescriptorProto$EnumReservedRange.getDefaultInstance();
        if (messageLite == descriptorProtos$EnumDescriptorProto$EnumReservedRange) {
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
        messageLite = messageLite.unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof DescriptorProtos$EnumDescriptorProto$EnumReservedRange;
        if (bl2) {
            message = (DescriptorProtos$EnumDescriptorProto$EnumReservedRange)message;
            return this.mergeFrom((DescriptorProtos$EnumDescriptorProto$EnumReservedRange)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder setEnd(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 2;
        this.end_ = n10;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder setStart(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 1;
        this.start_ = n10;
        this.onChanged();
        return this;
    }

    public final DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

