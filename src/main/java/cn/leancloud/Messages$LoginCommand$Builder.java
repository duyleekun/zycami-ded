/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$LoginCommand;
import cn.leancloud.Messages$LoginCommandOrBuilder;
import cn.leancloud.Messages$SystemInfo;
import cn.leancloud.Messages$SystemInfo$Builder;
import cn.leancloud.Messages$SystemInfoOrBuilder;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.CodedInputStream;
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

public final class Messages$LoginCommand$Builder
extends GeneratedMessageV3$Builder
implements Messages$LoginCommandOrBuilder {
    private int bitField0_;
    private SingleFieldBuilderV3 systemInfoBuilder_;
    private Messages$SystemInfo systemInfo_ = null;

    private Messages$LoginCommand$Builder() {
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$LoginCommand$Builder(Messages$1 messages$1) {
        this();
    }

    private Messages$LoginCommand$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        super(generatedMessageV3$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$LoginCommand$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Messages$1 messages$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$9900();
    }

    private SingleFieldBuilderV3 getSystemInfoFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.systemInfoBuilder_;
        if (singleFieldBuilderV3 == null) {
            Messages$SystemInfo messages$SystemInfo = this.getSystemInfo();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.systemInfoBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(messages$SystemInfo, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.systemInfo_ = null;
        }
        return this.systemInfoBuilder_;
    }

    private void maybeForceBuilderInitialization() {
        boolean bl2 = Messages$LoginCommand.access$10300();
        if (bl2) {
            this.getSystemInfoFieldBuilder();
        }
    }

    public Messages$LoginCommand$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$LoginCommand$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Messages$LoginCommand build() {
        Messages$LoginCommand messages$LoginCommand = this.buildPartial();
        boolean bl2 = messages$LoginCommand.isInitialized();
        if (bl2) {
            return messages$LoginCommand;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(messages$LoginCommand);
    }

    public Messages$LoginCommand buildPartial() {
        Object object = null;
        Messages$LoginCommand messages$LoginCommand = new Messages$LoginCommand(this, null);
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) != n11) {
            n11 = 0;
        }
        object = this.systemInfoBuilder_;
        if (object == null) {
            object = this.systemInfo_;
            Messages$LoginCommand.access$10502(messages$LoginCommand, (Messages$SystemInfo)object);
        } else {
            object = (Messages$SystemInfo)((SingleFieldBuilderV3)object).build();
            Messages$LoginCommand.access$10502(messages$LoginCommand, (Messages$SystemInfo)object);
        }
        Messages$LoginCommand.access$10602(messages$LoginCommand, n11);
        this.onBuilt();
        return messages$LoginCommand;
    }

    public Messages$LoginCommand$Builder clear() {
        int n10;
        super.clear();
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.systemInfoBuilder_;
        if (singleFieldBuilderV3 == null) {
            n10 = 0;
            singleFieldBuilderV3 = null;
            this.systemInfo_ = null;
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        return this;
    }

    public Messages$LoginCommand$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Messages$LoginCommand$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Messages$LoginCommand$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Messages$LoginCommand$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Messages$LoginCommand$Builder clearSystemInfo() {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.systemInfoBuilder_;
        if (singleFieldBuilderV3 == null) {
            n10 = 0;
            singleFieldBuilderV3 = null;
            this.systemInfo_ = null;
            this.onChanged();
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        return this;
    }

    public Messages$LoginCommand$Builder clone() {
        return (Messages$LoginCommand$Builder)super.clone();
    }

    public Messages$LoginCommand getDefaultInstanceForType() {
        return Messages$LoginCommand.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return Messages.access$9900();
    }

    public Messages$SystemInfo getSystemInfo() {
        Object object = this.systemInfoBuilder_;
        if (object == null) {
            object = this.systemInfo_;
            if (object == null) {
                object = Messages$SystemInfo.getDefaultInstance();
            }
            return object;
        }
        return (Messages$SystemInfo)((SingleFieldBuilderV3)object).getMessage();
    }

    public Messages$SystemInfo$Builder getSystemInfoBuilder() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.onChanged();
        return (Messages$SystemInfo$Builder)this.getSystemInfoFieldBuilder().getBuilder();
    }

    public Messages$SystemInfoOrBuilder getSystemInfoOrBuilder() {
        Object object = this.systemInfoBuilder_;
        if (object != null) {
            return (Messages$SystemInfoOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.systemInfo_;
        if (object == null) {
            object = Messages$SystemInfo.getDefaultInstance();
        }
        return object;
    }

    public boolean hasSystemInfo() {
        int bl2 = this.bitField0_;
        int n10 = 1;
        int n11 = bl2 & n10;
        if (n11 != n10) {
            n10 = 0;
        }
        return n10 != 0;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$10000().ensureFieldAccessorsInitialized(Messages$LoginCommand.class, Messages$LoginCommand$Builder.class);
    }

    public final boolean isInitialized() {
        return true;
    }

    public Messages$LoginCommand$Builder mergeFrom(Messages$LoginCommand messageLite) {
        GeneratedMessageV3 generatedMessageV3 = Messages$LoginCommand.getDefaultInstance();
        if (messageLite == generatedMessageV3) {
            return this;
        }
        boolean bl2 = messageLite.hasSystemInfo();
        if (bl2) {
            generatedMessageV3 = messageLite.getSystemInfo();
            this.mergeSystemInfo((Messages$SystemInfo)generatedMessageV3);
        }
        messageLite = Messages$LoginCommand.access$10700(messageLite);
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
    public Messages$LoginCommand$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Messages$LoginCommand.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Messages$LoginCommand)object;
            if (object == null) break block7;
            this.mergeFrom((Messages$LoginCommand)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Messages$LoginCommand)object2;
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
            this.mergeFrom((Messages$LoginCommand)object3);
        }
        throw var1_6;
    }

    public Messages$LoginCommand$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Messages$LoginCommand;
        if (bl2) {
            message = (Messages$LoginCommand)message;
            return this.mergeFrom((Messages$LoginCommand)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public Messages$LoginCommand$Builder mergeSystemInfo(Messages$SystemInfo messages$SystemInfo) {
        int n10;
        Object object = this.systemInfoBuilder_;
        int n11 = 1;
        if (object == null) {
            Messages$SystemInfo messages$SystemInfo2;
            int n12 = this.bitField0_ & n11;
            if (n12 == n11 && (object = this.systemInfo_) != null && object != (messages$SystemInfo2 = Messages$SystemInfo.getDefaultInstance())) {
                object = Messages$SystemInfo.newBuilder(this.systemInfo_);
                this.systemInfo_ = messages$SystemInfo = ((Messages$SystemInfo$Builder)object).mergeFrom(messages$SystemInfo).buildPartial();
            } else {
                this.systemInfo_ = messages$SystemInfo;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(messages$SystemInfo);
        }
        this.bitField0_ = n10 = this.bitField0_ | n11;
        return this;
    }

    public final Messages$LoginCommand$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$LoginCommand$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Messages$LoginCommand$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$LoginCommand$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Messages$LoginCommand$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Messages$LoginCommand$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public Messages$LoginCommand$Builder setSystemInfo(Messages$SystemInfo$Builder messages$SystemInfoOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.systemInfoBuilder_;
        if (singleFieldBuilderV3 == null) {
            messages$SystemInfoOrBuilder = messages$SystemInfoOrBuilder.build();
            this.systemInfo_ = messages$SystemInfoOrBuilder;
            this.onChanged();
        } else {
            messages$SystemInfoOrBuilder = messages$SystemInfoOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)messages$SystemInfoOrBuilder));
        }
        this.bitField0_ = n10 = this.bitField0_ | 1;
        return this;
    }

    public Messages$LoginCommand$Builder setSystemInfo(Messages$SystemInfo messages$SystemInfo) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.systemInfoBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(messages$SystemInfo);
            this.systemInfo_ = messages$SystemInfo;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(messages$SystemInfo);
        }
        this.bitField0_ = n10 = this.bitField0_ | 1;
        return this;
    }

    public final Messages$LoginCommand$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$LoginCommand$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

