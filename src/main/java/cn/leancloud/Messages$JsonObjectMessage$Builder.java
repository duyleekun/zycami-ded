/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$JsonObjectMessage;
import cn.leancloud.Messages$JsonObjectMessageOrBuilder;
import com.google.protobuf.AbstractMessage$Builder;
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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.Objects;

public final class Messages$JsonObjectMessage$Builder
extends GeneratedMessageV3$Builder
implements Messages$JsonObjectMessageOrBuilder {
    private int bitField0_;
    private Object data_ = "";

    private Messages$JsonObjectMessage$Builder() {
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$JsonObjectMessage$Builder(Messages$1 messages$1) {
        this();
    }

    private Messages$JsonObjectMessage$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        super(generatedMessageV3$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$JsonObjectMessage$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Messages$1 messages$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$3800();
    }

    private void maybeForceBuilderInitialization() {
        Messages$JsonObjectMessage.access$4200();
    }

    public Messages$JsonObjectMessage$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$JsonObjectMessage$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Messages$JsonObjectMessage build() {
        Messages$JsonObjectMessage messages$JsonObjectMessage = this.buildPartial();
        boolean bl2 = messages$JsonObjectMessage.isInitialized();
        if (bl2) {
            return messages$JsonObjectMessage;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(messages$JsonObjectMessage);
    }

    public Messages$JsonObjectMessage buildPartial() {
        Object object = null;
        Messages$JsonObjectMessage messages$JsonObjectMessage = new Messages$JsonObjectMessage(this, null);
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) != n11) {
            n11 = 0;
        }
        object = this.data_;
        Messages$JsonObjectMessage.access$4402(messages$JsonObjectMessage, object);
        Messages$JsonObjectMessage.access$4502(messages$JsonObjectMessage, n11);
        this.onBuilt();
        return messages$JsonObjectMessage;
    }

    public Messages$JsonObjectMessage$Builder clear() {
        int n10;
        super.clear();
        this.data_ = "";
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        return this;
    }

    public Messages$JsonObjectMessage$Builder clearData() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        String string2 = Messages$JsonObjectMessage.getDefaultInstance().getData();
        this.data_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$JsonObjectMessage$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Messages$JsonObjectMessage$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Messages$JsonObjectMessage$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Messages$JsonObjectMessage$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Messages$JsonObjectMessage$Builder clone() {
        return (Messages$JsonObjectMessage$Builder)super.clone();
    }

    public String getData() {
        Object object = this.data_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.data_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getDataBytes() {
        Object object = this.data_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.data_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public Messages$JsonObjectMessage getDefaultInstanceForType() {
        return Messages$JsonObjectMessage.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return Messages.access$3800();
    }

    public boolean hasData() {
        int bl2 = this.bitField0_;
        int n10 = 1;
        int n11 = bl2 & n10;
        if (n11 != n10) {
            n10 = 0;
        }
        return n10 != 0;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$3900().ensureFieldAccessorsInitialized(Messages$JsonObjectMessage.class, Messages$JsonObjectMessage$Builder.class);
    }

    public final boolean isInitialized() {
        boolean bl2 = this.hasData();
        return bl2;
    }

    public Messages$JsonObjectMessage$Builder mergeFrom(Messages$JsonObjectMessage messageLite) {
        Object object = Messages$JsonObjectMessage.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        int n10 = messageLite.hasData();
        if (n10 != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 1;
            this.data_ = object = Messages$JsonObjectMessage.access$4400(messageLite);
            this.onChanged();
        }
        messageLite = Messages$JsonObjectMessage.access$4600(messageLite);
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Messages$JsonObjectMessage$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Messages$JsonObjectMessage.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Messages$JsonObjectMessage)object;
            if (object == null) break block7;
            this.mergeFrom((Messages$JsonObjectMessage)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Messages$JsonObjectMessage)object2;
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
            this.mergeFrom((Messages$JsonObjectMessage)object3);
        }
        throw var1_6;
    }

    public Messages$JsonObjectMessage$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Messages$JsonObjectMessage;
        if (bl2) {
            message = (Messages$JsonObjectMessage)message;
            return this.mergeFrom((Messages$JsonObjectMessage)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final Messages$JsonObjectMessage$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$JsonObjectMessage$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Messages$JsonObjectMessage$Builder setData(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.data_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$JsonObjectMessage$Builder setDataBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.data_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$JsonObjectMessage$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$JsonObjectMessage$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Messages$JsonObjectMessage$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Messages$JsonObjectMessage$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final Messages$JsonObjectMessage$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$JsonObjectMessage$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

