/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.CodedInputStream;
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
import com.google.protobuf.Timestamp;
import com.google.protobuf.Timestamp$1;
import com.google.protobuf.TimestampOrBuilder;
import com.google.protobuf.TimestampProto;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;

public final class Timestamp$Builder
extends GeneratedMessageV3$Builder
implements TimestampOrBuilder {
    private int nanos_;
    private long seconds_;

    private Timestamp$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private Timestamp$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        super(generatedMessageV3$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Timestamp$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Timestamp$1 timestamp$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public /* synthetic */ Timestamp$Builder(Timestamp$1 timestamp$1) {
        this();
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return TimestampProto.internal_static_google_protobuf_Timestamp_descriptor;
    }

    private void maybeForceBuilderInitialization() {
    }

    public Timestamp$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Timestamp$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Timestamp build() {
        Message message = this.buildPartial();
        boolean bl2 = ((Timestamp)message).isInitialized();
        if (bl2) {
            return message;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(message);
    }

    public Timestamp buildPartial() {
        Timestamp timestamp = new Timestamp(this, null);
        long l10 = this.seconds_;
        Timestamp.access$302(timestamp, l10);
        int n10 = this.nanos_;
        Timestamp.access$402(timestamp, n10);
        this.onBuilt();
        return timestamp;
    }

    public Timestamp$Builder clear() {
        super.clear();
        this.seconds_ = 0L;
        this.nanos_ = 0;
        return this;
    }

    public Timestamp$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Timestamp$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Timestamp$Builder clearNanos() {
        this.nanos_ = 0;
        this.onChanged();
        return this;
    }

    public Timestamp$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Timestamp$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Timestamp$Builder clearSeconds() {
        this.seconds_ = 0L;
        this.onChanged();
        return this;
    }

    public Timestamp$Builder clone() {
        return (Timestamp$Builder)super.clone();
    }

    public Timestamp getDefaultInstanceForType() {
        return Timestamp.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return TimestampProto.internal_static_google_protobuf_Timestamp_descriptor;
    }

    public int getNanos() {
        return this.nanos_;
    }

    public long getSeconds() {
        return this.seconds_;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return TimestampProto.internal_static_google_protobuf_Timestamp_fieldAccessorTable.ensureFieldAccessorsInitialized(Timestamp.class, Timestamp$Builder.class);
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
    public Timestamp$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Timestamp.access$500();
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Timestamp)object;
            if (object == null) break block7;
            this.mergeFrom((Timestamp)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Timestamp)object2;
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
            this.mergeFrom((Timestamp)object3);
        }
        throw var1_6;
    }

    public Timestamp$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Timestamp;
        if (bl2) {
            message = (Timestamp)message;
            return this.mergeFrom((Timestamp)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public Timestamp$Builder mergeFrom(Timestamp messageLite) {
        long l10;
        Timestamp timestamp = Timestamp.getDefaultInstance();
        if (messageLite == timestamp) {
            return this;
        }
        long l11 = messageLite.getSeconds();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            l11 = messageLite.getSeconds();
            this.setSeconds(l11);
        }
        if ((object = (Object)messageLite.getNanos()) != false) {
            object = messageLite.getNanos();
            this.setNanos((int)object);
        }
        messageLite = messageLite.unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public final Timestamp$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Timestamp$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Timestamp$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Timestamp$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Timestamp$Builder setNanos(int n10) {
        this.nanos_ = n10;
        this.onChanged();
        return this;
    }

    public Timestamp$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Timestamp$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public Timestamp$Builder setSeconds(long l10) {
        this.seconds_ = l10;
        this.onChanged();
        return this;
    }

    public final Timestamp$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Timestamp$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

