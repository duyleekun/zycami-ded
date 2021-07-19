/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$LoggedinCommand;
import cn.leancloud.Messages$LoggedinCommandOrBuilder;
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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;

public final class Messages$LoggedinCommand$Builder
extends GeneratedMessageV3$Builder
implements Messages$LoggedinCommandOrBuilder {
    private int bitField0_;
    private boolean pushDisabled_;

    private Messages$LoggedinCommand$Builder() {
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$LoggedinCommand$Builder(Messages$1 messages$1) {
        this();
    }

    private Messages$LoggedinCommand$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        super(generatedMessageV3$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$LoggedinCommand$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Messages$1 messages$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$10900();
    }

    private void maybeForceBuilderInitialization() {
        Messages$LoggedinCommand.access$11300();
    }

    public Messages$LoggedinCommand$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$LoggedinCommand$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Messages$LoggedinCommand build() {
        Messages$LoggedinCommand messages$LoggedinCommand = this.buildPartial();
        boolean bl2 = messages$LoggedinCommand.isInitialized();
        if (bl2) {
            return messages$LoggedinCommand;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(messages$LoggedinCommand);
    }

    public Messages$LoggedinCommand buildPartial() {
        Messages$LoggedinCommand messages$LoggedinCommand = new Messages$LoggedinCommand(this, null);
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) != n11) {
            n11 = 0;
        }
        n10 = (int)(this.pushDisabled_ ? 1 : 0);
        Messages$LoggedinCommand.access$11502(messages$LoggedinCommand, n10 != 0);
        Messages$LoggedinCommand.access$11602(messages$LoggedinCommand, n11);
        this.onBuilt();
        return messages$LoggedinCommand;
    }

    public Messages$LoggedinCommand$Builder clear() {
        int n10;
        super.clear();
        this.pushDisabled_ = false;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        return this;
    }

    public Messages$LoggedinCommand$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Messages$LoggedinCommand$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Messages$LoggedinCommand$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Messages$LoggedinCommand$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Messages$LoggedinCommand$Builder clearPushDisabled() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.pushDisabled_ = false;
        this.onChanged();
        return this;
    }

    public Messages$LoggedinCommand$Builder clone() {
        return (Messages$LoggedinCommand$Builder)super.clone();
    }

    public Messages$LoggedinCommand getDefaultInstanceForType() {
        return Messages$LoggedinCommand.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return Messages.access$10900();
    }

    public boolean getPushDisabled() {
        return this.pushDisabled_;
    }

    public boolean hasPushDisabled() {
        int bl2 = this.bitField0_;
        int n10 = 1;
        int n11 = bl2 & n10;
        if (n11 != n10) {
            n10 = 0;
        }
        return n10 != 0;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$11000().ensureFieldAccessorsInitialized(Messages$LoggedinCommand.class, Messages$LoggedinCommand$Builder.class);
    }

    public final boolean isInitialized() {
        return true;
    }

    public Messages$LoggedinCommand$Builder mergeFrom(Messages$LoggedinCommand messageLite) {
        Messages$LoggedinCommand messages$LoggedinCommand = Messages$LoggedinCommand.getDefaultInstance();
        if (messageLite == messages$LoggedinCommand) {
            return this;
        }
        boolean bl2 = messageLite.hasPushDisabled();
        if (bl2) {
            bl2 = messageLite.getPushDisabled();
            this.setPushDisabled(bl2);
        }
        messageLite = Messages$LoggedinCommand.access$11700(messageLite);
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
    public Messages$LoggedinCommand$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Messages$LoggedinCommand.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Messages$LoggedinCommand)object;
            if (object == null) break block7;
            this.mergeFrom((Messages$LoggedinCommand)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Messages$LoggedinCommand)object2;
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
            this.mergeFrom((Messages$LoggedinCommand)object3);
        }
        throw var1_6;
    }

    public Messages$LoggedinCommand$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Messages$LoggedinCommand;
        if (bl2) {
            message = (Messages$LoggedinCommand)message;
            return this.mergeFrom((Messages$LoggedinCommand)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final Messages$LoggedinCommand$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$LoggedinCommand$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Messages$LoggedinCommand$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$LoggedinCommand$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Messages$LoggedinCommand$Builder setPushDisabled(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.pushDisabled_ = bl2;
        this.onChanged();
        return this;
    }

    public Messages$LoggedinCommand$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Messages$LoggedinCommand$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final Messages$LoggedinCommand$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$LoggedinCommand$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

