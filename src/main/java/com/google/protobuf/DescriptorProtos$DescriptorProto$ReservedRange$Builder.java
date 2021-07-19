/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRange;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder;
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

public final class DescriptorProtos$DescriptorProto$ReservedRange$Builder
extends GeneratedMessageV3$Builder
implements DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder {
    private int bitField0_;
    private int end_;
    private int start_;

    private DescriptorProtos$DescriptorProto$ReservedRange$Builder() {
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$DescriptorProto$ReservedRange$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    private DescriptorProtos$DescriptorProto$ReservedRange$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        super(generatedMessageV3$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$DescriptorProto$ReservedRange$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$3800();
    }

    private void maybeForceBuilderInitialization() {
    }

    public DescriptorProtos$DescriptorProto$ReservedRange$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$DescriptorProto$ReservedRange$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$DescriptorProto$ReservedRange build() {
        DescriptorProtos$DescriptorProto$ReservedRange descriptorProtos$DescriptorProto$ReservedRange = this.buildPartial();
        boolean bl2 = descriptorProtos$DescriptorProto$ReservedRange.isInitialized();
        if (bl2) {
            return descriptorProtos$DescriptorProto$ReservedRange;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(descriptorProtos$DescriptorProto$ReservedRange);
    }

    public DescriptorProtos$DescriptorProto$ReservedRange buildPartial() {
        DescriptorProtos$DescriptorProto$ReservedRange descriptorProtos$DescriptorProto$ReservedRange = new DescriptorProtos$DescriptorProto$ReservedRange(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        if (n11 != 0) {
            n11 = this.start_;
            DescriptorProtos$DescriptorProto$ReservedRange.access$4302(descriptorProtos$DescriptorProto$ReservedRange, n11);
            n11 = 1;
        } else {
            n11 = 0;
        }
        if ((n10 &= 2) != 0) {
            n10 = this.end_;
            DescriptorProtos$DescriptorProto$ReservedRange.access$4402(descriptorProtos$DescriptorProto$ReservedRange, n10);
            n11 |= 2;
        }
        DescriptorProtos$DescriptorProto$ReservedRange.access$4502(descriptorProtos$DescriptorProto$ReservedRange, n11);
        this.onBuilt();
        return descriptorProtos$DescriptorProto$ReservedRange;
    }

    public DescriptorProtos$DescriptorProto$ReservedRange$Builder clear() {
        int n10;
        int n11;
        super.clear();
        this.start_ = 0;
        this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
        this.end_ = 0;
        this.bitField0_ = n10 = n11 & 0xFFFFFFFD;
        return this;
    }

    public DescriptorProtos$DescriptorProto$ReservedRange$Builder clearEnd() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.end_ = 0;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$ReservedRange$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (DescriptorProtos$DescriptorProto$ReservedRange$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public DescriptorProtos$DescriptorProto$ReservedRange$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (DescriptorProtos$DescriptorProto$ReservedRange$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public DescriptorProtos$DescriptorProto$ReservedRange$Builder clearStart() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.start_ = 0;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$ReservedRange$Builder clone() {
        return (DescriptorProtos$DescriptorProto$ReservedRange$Builder)super.clone();
    }

    public DescriptorProtos$DescriptorProto$ReservedRange getDefaultInstanceForType() {
        return DescriptorProtos$DescriptorProto$ReservedRange.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$3800();
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
        return DescriptorProtos.access$3900().ensureFieldAccessorsInitialized(DescriptorProtos$DescriptorProto$ReservedRange.class, DescriptorProtos$DescriptorProto$ReservedRange$Builder.class);
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
    public DescriptorProtos$DescriptorProto$ReservedRange$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = DescriptorProtos$DescriptorProto$ReservedRange.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (DescriptorProtos$DescriptorProto$ReservedRange)object;
            if (object == null) break block7;
            this.mergeFrom((DescriptorProtos$DescriptorProto$ReservedRange)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (DescriptorProtos$DescriptorProto$ReservedRange)object2;
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
            this.mergeFrom((DescriptorProtos$DescriptorProto$ReservedRange)object3);
        }
        throw var1_6;
    }

    public DescriptorProtos$DescriptorProto$ReservedRange$Builder mergeFrom(DescriptorProtos$DescriptorProto$ReservedRange messageLite) {
        DescriptorProtos$DescriptorProto$ReservedRange descriptorProtos$DescriptorProto$ReservedRange = DescriptorProtos$DescriptorProto$ReservedRange.getDefaultInstance();
        if (messageLite == descriptorProtos$DescriptorProto$ReservedRange) {
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

    public DescriptorProtos$DescriptorProto$ReservedRange$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof DescriptorProtos$DescriptorProto$ReservedRange;
        if (bl2) {
            message = (DescriptorProtos$DescriptorProto$ReservedRange)message;
            return this.mergeFrom((DescriptorProtos$DescriptorProto$ReservedRange)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final DescriptorProtos$DescriptorProto$ReservedRange$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$DescriptorProto$ReservedRange$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public DescriptorProtos$DescriptorProto$ReservedRange$Builder setEnd(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 2;
        this.end_ = n10;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$ReservedRange$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$DescriptorProto$ReservedRange$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$DescriptorProto$ReservedRange$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (DescriptorProtos$DescriptorProto$ReservedRange$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public DescriptorProtos$DescriptorProto$ReservedRange$Builder setStart(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 1;
        this.start_ = n10;
        this.onChanged();
        return this;
    }

    public final DescriptorProtos$DescriptorProto$ReservedRange$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$DescriptorProto$ReservedRange$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

