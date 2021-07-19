/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
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
import com.google.protobuf.SourceContext;
import com.google.protobuf.SourceContext$1;
import com.google.protobuf.SourceContextOrBuilder;
import com.google.protobuf.SourceContextProto;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.Objects;

public final class SourceContext$Builder
extends GeneratedMessageV3$Builder
implements SourceContextOrBuilder {
    private Object fileName_ = "";

    private SourceContext$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private SourceContext$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        super(generatedMessageV3$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ SourceContext$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, SourceContext$1 sourceContext$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public /* synthetic */ SourceContext$Builder(SourceContext$1 sourceContext$1) {
        this();
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return SourceContextProto.internal_static_google_protobuf_SourceContext_descriptor;
    }

    private void maybeForceBuilderInitialization() {
    }

    public SourceContext$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (SourceContext$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public SourceContext build() {
        Message message = this.buildPartial();
        boolean bl2 = ((SourceContext)message).isInitialized();
        if (bl2) {
            return message;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(message);
    }

    public SourceContext buildPartial() {
        SourceContext sourceContext = new SourceContext(this, null);
        Object object = this.fileName_;
        SourceContext.access$302(sourceContext, object);
        this.onBuilt();
        return sourceContext;
    }

    public SourceContext$Builder clear() {
        super.clear();
        this.fileName_ = "";
        return this;
    }

    public SourceContext$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (SourceContext$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public SourceContext$Builder clearFileName() {
        String string2 = SourceContext.getDefaultInstance().getFileName();
        this.fileName_ = string2;
        this.onChanged();
        return this;
    }

    public SourceContext$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (SourceContext$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public SourceContext$Builder clone() {
        return (SourceContext$Builder)super.clone();
    }

    public SourceContext getDefaultInstanceForType() {
        return SourceContext.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return SourceContextProto.internal_static_google_protobuf_SourceContext_descriptor;
    }

    public String getFileName() {
        Object object = this.fileName_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            this.fileName_ = object = ((ByteString)object).toStringUtf8();
            return object;
        }
        return (String)object;
    }

    public ByteString getFileNameBytes() {
        Object object = this.fileName_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.fileName_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return SourceContextProto.internal_static_google_protobuf_SourceContext_fieldAccessorTable.ensureFieldAccessorsInitialized(SourceContext.class, SourceContext$Builder.class);
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
    public SourceContext$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = SourceContext.access$400();
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (SourceContext)object;
            if (object == null) break block7;
            this.mergeFrom((SourceContext)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (SourceContext)object2;
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
            this.mergeFrom((SourceContext)object3);
        }
        throw var1_6;
    }

    public SourceContext$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof SourceContext;
        if (bl2) {
            message = (SourceContext)message;
            return this.mergeFrom((SourceContext)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public SourceContext$Builder mergeFrom(SourceContext messageLite) {
        Object object = SourceContext.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        object = messageLite.getFileName();
        boolean bl2 = ((String)object).isEmpty();
        if (!bl2) {
            this.fileName_ = object = SourceContext.access$300(messageLite);
            this.onChanged();
        }
        messageLite = messageLite.unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public final SourceContext$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (SourceContext$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public SourceContext$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (SourceContext$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public SourceContext$Builder setFileName(String string2) {
        Objects.requireNonNull(string2);
        this.fileName_ = string2;
        this.onChanged();
        return this;
    }

    public SourceContext$Builder setFileNameBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.fileName_ = byteString;
        this.onChanged();
        return this;
    }

    public SourceContext$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (SourceContext$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final SourceContext$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (SourceContext$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

