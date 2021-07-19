/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.Duration;
import com.google.protobuf.Duration$1;
import com.google.protobuf.DurationOrBuilder;
import com.google.protobuf.DurationProto;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;

public final class Duration$Builder
extends GeneratedMessageV3$Builder
implements DurationOrBuilder {
    private int nanos_;
    private long seconds_;

    private Duration$Builder() {
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Duration$Builder(Duration$1 duration$1) {
        this();
    }

    private Duration$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        super(generatedMessageV3$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Duration$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Duration$1 duration$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DurationProto.internal_static_google_protobuf_Duration_descriptor;
    }

    private void maybeForceBuilderInitialization() {
    }

    public Duration$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Duration$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Duration build() {
        Duration duration = this.buildPartial();
        boolean bl2 = duration.isInitialized();
        if (bl2) {
            return duration;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(duration);
    }

    public Duration buildPartial() {
        Duration duration = new Duration(this, null);
        long l10 = this.seconds_;
        Duration.access$302(duration, l10);
        int n10 = this.nanos_;
        Duration.access$402(duration, n10);
        this.onBuilt();
        return duration;
    }

    public Duration$Builder clear() {
        super.clear();
        this.seconds_ = 0L;
        this.nanos_ = 0;
        return this;
    }

    public Duration$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Duration$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Duration$Builder clearNanos() {
        this.nanos_ = 0;
        this.onChanged();
        return this;
    }

    public Duration$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Duration$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Duration$Builder clearSeconds() {
        this.seconds_ = 0L;
        this.onChanged();
        return this;
    }

    public Duration$Builder clone() {
        return (Duration$Builder)super.clone();
    }

    public Duration getDefaultInstanceForType() {
        return Duration.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return DurationProto.internal_static_google_protobuf_Duration_descriptor;
    }

    public int getNanos() {
        return this.nanos_;
    }

    public long getSeconds() {
        return this.seconds_;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DurationProto.internal_static_google_protobuf_Duration_fieldAccessorTable.ensureFieldAccessorsInitialized(Duration.class, Duration$Builder.class);
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
    public Duration$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Duration.access$500();
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Duration)object;
            if (object == null) break block7;
            this.mergeFrom((Duration)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Duration)object2;
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
            this.mergeFrom((Duration)object3);
        }
        throw var1_6;
    }

    public Duration$Builder mergeFrom(Duration messageLite) {
        long l10;
        Duration duration = Duration.getDefaultInstance();
        if (messageLite == duration) {
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

    public Duration$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Duration;
        if (bl2) {
            message = (Duration)message;
            return this.mergeFrom((Duration)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final Duration$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Duration$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Duration$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Duration$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Duration$Builder setNanos(int n10) {
        this.nanos_ = n10;
        this.onChanged();
        return this;
    }

    public Duration$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Duration$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public Duration$Builder setSeconds(long l10) {
        this.seconds_ = l10;
        this.onChanged();
        return this;
    }

    public final Duration$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Duration$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

