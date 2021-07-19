/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$AckCommand;
import cn.leancloud.Messages$AckCommand$Builder;
import cn.leancloud.Messages$AckCommandOrBuilder;
import cn.leancloud.Messages$BlacklistCommand;
import cn.leancloud.Messages$BlacklistCommand$Builder;
import cn.leancloud.Messages$BlacklistCommandOrBuilder;
import cn.leancloud.Messages$CommandType;
import cn.leancloud.Messages$ConvCommand;
import cn.leancloud.Messages$ConvCommand$Builder;
import cn.leancloud.Messages$ConvCommandOrBuilder;
import cn.leancloud.Messages$DataCommand;
import cn.leancloud.Messages$DataCommand$Builder;
import cn.leancloud.Messages$DataCommandOrBuilder;
import cn.leancloud.Messages$DirectCommand;
import cn.leancloud.Messages$DirectCommand$Builder;
import cn.leancloud.Messages$DirectCommandOrBuilder;
import cn.leancloud.Messages$ErrorCommand;
import cn.leancloud.Messages$ErrorCommand$Builder;
import cn.leancloud.Messages$ErrorCommandOrBuilder;
import cn.leancloud.Messages$GenericCommand;
import cn.leancloud.Messages$GenericCommandOrBuilder;
import cn.leancloud.Messages$LoggedinCommand;
import cn.leancloud.Messages$LoggedinCommand$Builder;
import cn.leancloud.Messages$LoggedinCommandOrBuilder;
import cn.leancloud.Messages$LoginCommand;
import cn.leancloud.Messages$LoginCommand$Builder;
import cn.leancloud.Messages$LoginCommandOrBuilder;
import cn.leancloud.Messages$LogsCommand;
import cn.leancloud.Messages$LogsCommand$Builder;
import cn.leancloud.Messages$LogsCommandOrBuilder;
import cn.leancloud.Messages$OpType;
import cn.leancloud.Messages$PatchCommand;
import cn.leancloud.Messages$PatchCommand$Builder;
import cn.leancloud.Messages$PatchCommandOrBuilder;
import cn.leancloud.Messages$PresenceCommand;
import cn.leancloud.Messages$PresenceCommand$Builder;
import cn.leancloud.Messages$PresenceCommandOrBuilder;
import cn.leancloud.Messages$PubsubCommand;
import cn.leancloud.Messages$PubsubCommand$Builder;
import cn.leancloud.Messages$PubsubCommandOrBuilder;
import cn.leancloud.Messages$RcpCommand;
import cn.leancloud.Messages$RcpCommand$Builder;
import cn.leancloud.Messages$RcpCommandOrBuilder;
import cn.leancloud.Messages$ReadCommand;
import cn.leancloud.Messages$ReadCommand$Builder;
import cn.leancloud.Messages$ReadCommandOrBuilder;
import cn.leancloud.Messages$ReportCommand;
import cn.leancloud.Messages$ReportCommand$Builder;
import cn.leancloud.Messages$ReportCommandOrBuilder;
import cn.leancloud.Messages$RoomCommand;
import cn.leancloud.Messages$RoomCommand$Builder;
import cn.leancloud.Messages$RoomCommandOrBuilder;
import cn.leancloud.Messages$SessionCommand;
import cn.leancloud.Messages$SessionCommand$Builder;
import cn.leancloud.Messages$SessionCommandOrBuilder;
import cn.leancloud.Messages$UnreadCommand;
import cn.leancloud.Messages$UnreadCommand$Builder;
import cn.leancloud.Messages$UnreadCommandOrBuilder;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.ByteString;
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

public final class Messages$GenericCommand$Builder
extends GeneratedMessageV3$Builder
implements Messages$GenericCommandOrBuilder {
    private SingleFieldBuilderV3 ackMessageBuilder_;
    private Messages$AckCommand ackMessage_;
    private Object appId_;
    private int bitField0_;
    private SingleFieldBuilderV3 blacklistMessageBuilder_;
    private Messages$BlacklistCommand blacklistMessage_;
    private long clientTs_;
    private int cmd_ = 0;
    private SingleFieldBuilderV3 convMessageBuilder_;
    private Messages$ConvCommand convMessage_;
    private SingleFieldBuilderV3 dataMessageBuilder_;
    private Messages$DataCommand dataMessage_;
    private SingleFieldBuilderV3 directMessageBuilder_;
    private Messages$DirectCommand directMessage_;
    private SingleFieldBuilderV3 errorMessageBuilder_;
    private Messages$ErrorCommand errorMessage_;
    private int i_;
    private Object installationId_;
    private SingleFieldBuilderV3 loggedinMessageBuilder_;
    private Messages$LoggedinCommand loggedinMessage_;
    private SingleFieldBuilderV3 loginMessageBuilder_;
    private Messages$LoginCommand loginMessage_;
    private SingleFieldBuilderV3 logsMessageBuilder_;
    private Messages$LogsCommand logsMessage_;
    private int notificationType_;
    private int op_ = 1;
    private SingleFieldBuilderV3 patchMessageBuilder_;
    private Messages$PatchCommand patchMessage_;
    private Object peerId_;
    private SingleFieldBuilderV3 presenceMessageBuilder_;
    private Messages$PresenceCommand presenceMessage_;
    private int priority_;
    private SingleFieldBuilderV3 pubsubMessageBuilder_;
    private Messages$PubsubCommand pubsubMessage_;
    private SingleFieldBuilderV3 rcpMessageBuilder_;
    private Messages$RcpCommand rcpMessage_;
    private SingleFieldBuilderV3 readMessageBuilder_;
    private Messages$ReadCommand readMessage_;
    private SingleFieldBuilderV3 reportMessageBuilder_;
    private Messages$ReportCommand reportMessage_;
    private SingleFieldBuilderV3 roomMessageBuilder_;
    private Messages$RoomCommand roomMessage_;
    private long serverTs_;
    private int service_;
    private SingleFieldBuilderV3 sessionMessageBuilder_;
    private Messages$SessionCommand sessionMessage_;
    private SingleFieldBuilderV3 unreadMessageBuilder_;
    private Messages$UnreadCommand unreadMessage_;

    private Messages$GenericCommand$Builder() {
        String string2 = "";
        this.appId_ = string2;
        this.peerId_ = string2;
        this.installationId_ = string2;
        this.loginMessage_ = null;
        this.dataMessage_ = null;
        this.sessionMessage_ = null;
        this.errorMessage_ = null;
        this.directMessage_ = null;
        this.ackMessage_ = null;
        this.unreadMessage_ = null;
        this.readMessage_ = null;
        this.rcpMessage_ = null;
        this.logsMessage_ = null;
        this.convMessage_ = null;
        this.roomMessage_ = null;
        this.presenceMessage_ = null;
        this.reportMessage_ = null;
        this.patchMessage_ = null;
        this.pubsubMessage_ = null;
        this.blacklistMessage_ = null;
        this.loggedinMessage_ = null;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$GenericCommand$Builder(Messages$1 messages$1) {
        this();
    }

    private Messages$GenericCommand$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        this.appId_ = object = "";
        this.peerId_ = object;
        this.installationId_ = object;
        this.loginMessage_ = null;
        this.dataMessage_ = null;
        this.sessionMessage_ = null;
        this.errorMessage_ = null;
        this.directMessage_ = null;
        this.ackMessage_ = null;
        this.unreadMessage_ = null;
        this.readMessage_ = null;
        this.rcpMessage_ = null;
        this.logsMessage_ = null;
        this.convMessage_ = null;
        this.roomMessage_ = null;
        this.presenceMessage_ = null;
        this.reportMessage_ = null;
        this.patchMessage_ = null;
        this.pubsubMessage_ = null;
        this.blacklistMessage_ = null;
        this.loggedinMessage_ = null;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$GenericCommand$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Messages$1 messages$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private SingleFieldBuilderV3 getAckMessageFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.ackMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            Messages$AckCommand messages$AckCommand = this.getAckMessage();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.ackMessageBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(messages$AckCommand, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.ackMessage_ = null;
        }
        return this.ackMessageBuilder_;
    }

    private SingleFieldBuilderV3 getBlacklistMessageFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.blacklistMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            Messages$BlacklistCommand messages$BlacklistCommand = this.getBlacklistMessage();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.blacklistMessageBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(messages$BlacklistCommand, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.blacklistMessage_ = null;
        }
        return this.blacklistMessageBuilder_;
    }

    private SingleFieldBuilderV3 getConvMessageFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.convMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            Messages$ConvCommand messages$ConvCommand = this.getConvMessage();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.convMessageBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(messages$ConvCommand, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.convMessage_ = null;
        }
        return this.convMessageBuilder_;
    }

    private SingleFieldBuilderV3 getDataMessageFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.dataMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            Messages$DataCommand messages$DataCommand = this.getDataMessage();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.dataMessageBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(messages$DataCommand, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.dataMessage_ = null;
        }
        return this.dataMessageBuilder_;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$47300();
    }

    private SingleFieldBuilderV3 getDirectMessageFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.directMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            Messages$DirectCommand messages$DirectCommand = this.getDirectMessage();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.directMessageBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(messages$DirectCommand, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.directMessage_ = null;
        }
        return this.directMessageBuilder_;
    }

    private SingleFieldBuilderV3 getErrorMessageFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.errorMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            Messages$ErrorCommand messages$ErrorCommand = this.getErrorMessage();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.errorMessageBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(messages$ErrorCommand, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.errorMessage_ = null;
        }
        return this.errorMessageBuilder_;
    }

    private SingleFieldBuilderV3 getLoggedinMessageFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.loggedinMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            Messages$LoggedinCommand messages$LoggedinCommand = this.getLoggedinMessage();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.loggedinMessageBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(messages$LoggedinCommand, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.loggedinMessage_ = null;
        }
        return this.loggedinMessageBuilder_;
    }

    private SingleFieldBuilderV3 getLoginMessageFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.loginMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            Messages$LoginCommand messages$LoginCommand = this.getLoginMessage();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.loginMessageBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(messages$LoginCommand, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.loginMessage_ = null;
        }
        return this.loginMessageBuilder_;
    }

    private SingleFieldBuilderV3 getLogsMessageFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.logsMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            Messages$LogsCommand messages$LogsCommand = this.getLogsMessage();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.logsMessageBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(messages$LogsCommand, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.logsMessage_ = null;
        }
        return this.logsMessageBuilder_;
    }

    private SingleFieldBuilderV3 getPatchMessageFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.patchMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            Messages$PatchCommand messages$PatchCommand = this.getPatchMessage();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.patchMessageBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(messages$PatchCommand, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.patchMessage_ = null;
        }
        return this.patchMessageBuilder_;
    }

    private SingleFieldBuilderV3 getPresenceMessageFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.presenceMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            Messages$PresenceCommand messages$PresenceCommand = this.getPresenceMessage();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.presenceMessageBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(messages$PresenceCommand, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.presenceMessage_ = null;
        }
        return this.presenceMessageBuilder_;
    }

    private SingleFieldBuilderV3 getPubsubMessageFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.pubsubMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            Messages$PubsubCommand messages$PubsubCommand = this.getPubsubMessage();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.pubsubMessageBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(messages$PubsubCommand, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.pubsubMessage_ = null;
        }
        return this.pubsubMessageBuilder_;
    }

    private SingleFieldBuilderV3 getRcpMessageFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.rcpMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            Messages$RcpCommand messages$RcpCommand = this.getRcpMessage();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.rcpMessageBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(messages$RcpCommand, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.rcpMessage_ = null;
        }
        return this.rcpMessageBuilder_;
    }

    private SingleFieldBuilderV3 getReadMessageFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.readMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            Messages$ReadCommand messages$ReadCommand = this.getReadMessage();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.readMessageBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(messages$ReadCommand, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.readMessage_ = null;
        }
        return this.readMessageBuilder_;
    }

    private SingleFieldBuilderV3 getReportMessageFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.reportMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            Messages$ReportCommand messages$ReportCommand = this.getReportMessage();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.reportMessageBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(messages$ReportCommand, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.reportMessage_ = null;
        }
        return this.reportMessageBuilder_;
    }

    private SingleFieldBuilderV3 getRoomMessageFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.roomMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            Messages$RoomCommand messages$RoomCommand = this.getRoomMessage();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.roomMessageBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(messages$RoomCommand, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.roomMessage_ = null;
        }
        return this.roomMessageBuilder_;
    }

    private SingleFieldBuilderV3 getSessionMessageFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.sessionMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            Messages$SessionCommand messages$SessionCommand = this.getSessionMessage();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.sessionMessageBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(messages$SessionCommand, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.sessionMessage_ = null;
        }
        return this.sessionMessageBuilder_;
    }

    private SingleFieldBuilderV3 getUnreadMessageFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.unreadMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            Messages$UnreadCommand messages$UnreadCommand = this.getUnreadMessage();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.unreadMessageBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(messages$UnreadCommand, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.unreadMessage_ = null;
        }
        return this.unreadMessageBuilder_;
    }

    private void maybeForceBuilderInitialization() {
        boolean bl2 = Messages$GenericCommand.access$47700();
        if (bl2) {
            this.getLoginMessageFieldBuilder();
            this.getDataMessageFieldBuilder();
            this.getSessionMessageFieldBuilder();
            this.getErrorMessageFieldBuilder();
            this.getDirectMessageFieldBuilder();
            this.getAckMessageFieldBuilder();
            this.getUnreadMessageFieldBuilder();
            this.getReadMessageFieldBuilder();
            this.getRcpMessageFieldBuilder();
            this.getLogsMessageFieldBuilder();
            this.getConvMessageFieldBuilder();
            this.getRoomMessageFieldBuilder();
            this.getPresenceMessageFieldBuilder();
            this.getReportMessageFieldBuilder();
            this.getPatchMessageFieldBuilder();
            this.getPubsubMessageFieldBuilder();
            this.getBlacklistMessageFieldBuilder();
            this.getLoggedinMessageFieldBuilder();
        }
    }

    public Messages$GenericCommand$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$GenericCommand$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Messages$GenericCommand build() {
        Messages$GenericCommand messages$GenericCommand = this.buildPartial();
        boolean bl2 = messages$GenericCommand.isInitialized();
        if (bl2) {
            return messages$GenericCommand;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(messages$GenericCommand);
    }

    public Messages$GenericCommand buildPartial() {
        Object object = null;
        Messages$GenericCommand messages$GenericCommand = new Messages$GenericCommand(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        int n12 = 1;
        if (n11 != n12) {
            n12 = 0;
        }
        n11 = this.cmd_;
        Messages$GenericCommand.access$47902(messages$GenericCommand, n11);
        n11 = n10 & 2;
        int n13 = 2;
        if (n11 == n13) {
            n12 |= 2;
        }
        n11 = this.op_;
        Messages$GenericCommand.access$48002(messages$GenericCommand, n11);
        n11 = n10 & 4;
        n13 = 4;
        if (n11 == n13) {
            n12 |= 4;
        }
        Object object2 = this.appId_;
        Messages$GenericCommand.access$48102(messages$GenericCommand, object2);
        n11 = n10 & 8;
        n13 = 8;
        if (n11 == n13) {
            n12 |= 8;
        }
        object2 = this.peerId_;
        Messages$GenericCommand.access$48202(messages$GenericCommand, object2);
        n11 = n10 & 0x10;
        n13 = 16;
        if (n11 == n13) {
            n12 |= 0x10;
        }
        n11 = this.i_;
        Messages$GenericCommand.access$48302(messages$GenericCommand, n11);
        n11 = n10 & 0x20;
        n13 = 32;
        if (n11 == n13) {
            n12 |= 0x20;
        }
        object2 = this.installationId_;
        Messages$GenericCommand.access$48402(messages$GenericCommand, object2);
        n11 = n10 & 0x40;
        n13 = 64;
        if (n11 == n13) {
            n12 |= 0x40;
        }
        n11 = this.priority_;
        Messages$GenericCommand.access$48502(messages$GenericCommand, n11);
        n11 = n10 & 0x80;
        n13 = 128;
        if (n11 == n13) {
            n12 |= 0x80;
        }
        n11 = this.service_;
        Messages$GenericCommand.access$48602(messages$GenericCommand, n11);
        n11 = n10 & 0x100;
        n13 = 256;
        if (n11 == n13) {
            n12 |= 0x100;
        }
        long l10 = this.serverTs_;
        Messages$GenericCommand.access$48702(messages$GenericCommand, l10);
        n11 = n10 & 0x200;
        n13 = 512;
        if (n11 == n13) {
            n12 |= 0x200;
        }
        l10 = this.clientTs_;
        Messages$GenericCommand.access$48802(messages$GenericCommand, l10);
        n11 = n10 & 0x400;
        n13 = 1024;
        if (n11 == n13) {
            n12 |= 0x400;
        }
        n11 = this.notificationType_;
        Messages$GenericCommand.access$48902(messages$GenericCommand, n11);
        n11 = n10 & 0x800;
        n13 = 2048;
        if (n11 == n13) {
            n12 |= 0x800;
        }
        if ((object2 = this.loginMessageBuilder_) == null) {
            object2 = this.loginMessage_;
            Messages$GenericCommand.access$49002(messages$GenericCommand, (Messages$LoginCommand)object2);
        } else {
            object2 = (Messages$LoginCommand)((SingleFieldBuilderV3)object2).build();
            Messages$GenericCommand.access$49002(messages$GenericCommand, (Messages$LoginCommand)object2);
        }
        n11 = n10 & 0x1000;
        n13 = 4096;
        if (n11 == n13) {
            n12 |= 0x1000;
        }
        if ((object2 = this.dataMessageBuilder_) == null) {
            object2 = this.dataMessage_;
            Messages$GenericCommand.access$49102(messages$GenericCommand, (Messages$DataCommand)object2);
        } else {
            object2 = (Messages$DataCommand)((SingleFieldBuilderV3)object2).build();
            Messages$GenericCommand.access$49102(messages$GenericCommand, (Messages$DataCommand)object2);
        }
        n11 = n10 & 0x2000;
        n13 = 8192;
        if (n11 == n13) {
            n12 |= 0x2000;
        }
        if ((object2 = this.sessionMessageBuilder_) == null) {
            object2 = this.sessionMessage_;
            Messages$GenericCommand.access$49202(messages$GenericCommand, (Messages$SessionCommand)object2);
        } else {
            object2 = (Messages$SessionCommand)((SingleFieldBuilderV3)object2).build();
            Messages$GenericCommand.access$49202(messages$GenericCommand, (Messages$SessionCommand)object2);
        }
        n11 = n10 & 0x4000;
        n13 = 16384;
        if (n11 == n13) {
            n12 |= 0x4000;
        }
        if ((object2 = this.errorMessageBuilder_) == null) {
            object2 = this.errorMessage_;
            Messages$GenericCommand.access$49302(messages$GenericCommand, (Messages$ErrorCommand)object2);
        } else {
            object2 = (Messages$ErrorCommand)((SingleFieldBuilderV3)object2).build();
            Messages$GenericCommand.access$49302(messages$GenericCommand, (Messages$ErrorCommand)object2);
        }
        n11 = 32768;
        n13 = n10 & n11;
        if (n13 == n11) {
            n12 |= n11;
        }
        if ((object2 = this.directMessageBuilder_) == null) {
            object2 = this.directMessage_;
            Messages$GenericCommand.access$49402(messages$GenericCommand, (Messages$DirectCommand)object2);
        } else {
            object2 = (Messages$DirectCommand)((SingleFieldBuilderV3)object2).build();
            Messages$GenericCommand.access$49402(messages$GenericCommand, (Messages$DirectCommand)object2);
        }
        n11 = 65536;
        n13 = n10 & n11;
        if (n13 == n11) {
            n12 |= n11;
        }
        if ((object2 = this.ackMessageBuilder_) == null) {
            object2 = this.ackMessage_;
            Messages$GenericCommand.access$49502(messages$GenericCommand, (Messages$AckCommand)object2);
        } else {
            object2 = (Messages$AckCommand)((SingleFieldBuilderV3)object2).build();
            Messages$GenericCommand.access$49502(messages$GenericCommand, (Messages$AckCommand)object2);
        }
        n11 = 131072;
        n13 = n10 & n11;
        if (n13 == n11) {
            n12 |= n11;
        }
        if ((object2 = this.unreadMessageBuilder_) == null) {
            object2 = this.unreadMessage_;
            Messages$GenericCommand.access$49602(messages$GenericCommand, (Messages$UnreadCommand)object2);
        } else {
            object2 = (Messages$UnreadCommand)((SingleFieldBuilderV3)object2).build();
            Messages$GenericCommand.access$49602(messages$GenericCommand, (Messages$UnreadCommand)object2);
        }
        n11 = 262144;
        n13 = n10 & n11;
        if (n13 == n11) {
            n12 |= n11;
        }
        if ((object2 = this.readMessageBuilder_) == null) {
            object2 = this.readMessage_;
            Messages$GenericCommand.access$49702(messages$GenericCommand, (Messages$ReadCommand)object2);
        } else {
            object2 = (Messages$ReadCommand)((SingleFieldBuilderV3)object2).build();
            Messages$GenericCommand.access$49702(messages$GenericCommand, (Messages$ReadCommand)object2);
        }
        n11 = 524288;
        n13 = n10 & n11;
        if (n13 == n11) {
            n12 |= n11;
        }
        if ((object2 = this.rcpMessageBuilder_) == null) {
            object2 = this.rcpMessage_;
            Messages$GenericCommand.access$49802(messages$GenericCommand, (Messages$RcpCommand)object2);
        } else {
            object2 = (Messages$RcpCommand)((SingleFieldBuilderV3)object2).build();
            Messages$GenericCommand.access$49802(messages$GenericCommand, (Messages$RcpCommand)object2);
        }
        n11 = 0x100000;
        n13 = n10 & n11;
        if (n13 == n11) {
            n12 |= n11;
        }
        if ((object2 = this.logsMessageBuilder_) == null) {
            object2 = this.logsMessage_;
            Messages$GenericCommand.access$49902(messages$GenericCommand, (Messages$LogsCommand)object2);
        } else {
            object2 = (Messages$LogsCommand)((SingleFieldBuilderV3)object2).build();
            Messages$GenericCommand.access$49902(messages$GenericCommand, (Messages$LogsCommand)object2);
        }
        n11 = 0x200000;
        n13 = n10 & n11;
        if (n13 == n11) {
            n12 |= n11;
        }
        if ((object2 = this.convMessageBuilder_) == null) {
            object2 = this.convMessage_;
            Messages$GenericCommand.access$50002(messages$GenericCommand, (Messages$ConvCommand)object2);
        } else {
            object2 = (Messages$ConvCommand)((SingleFieldBuilderV3)object2).build();
            Messages$GenericCommand.access$50002(messages$GenericCommand, (Messages$ConvCommand)object2);
        }
        n11 = 0x400000 & n10;
        n13 = 0x400000;
        if (n11 == n13) {
            n11 = 0x400000;
            n12 |= n11;
        }
        if ((object2 = this.roomMessageBuilder_) == null) {
            object2 = this.roomMessage_;
            Messages$GenericCommand.access$50102(messages$GenericCommand, (Messages$RoomCommand)object2);
        } else {
            object2 = (Messages$RoomCommand)((SingleFieldBuilderV3)object2).build();
            Messages$GenericCommand.access$50102(messages$GenericCommand, (Messages$RoomCommand)object2);
        }
        n11 = 0x800000 & n10;
        n13 = 0x800000;
        if (n11 == n13) {
            n11 = 0x800000;
            n12 |= n11;
        }
        if ((object2 = this.presenceMessageBuilder_) == null) {
            object2 = this.presenceMessage_;
            Messages$GenericCommand.access$50202(messages$GenericCommand, (Messages$PresenceCommand)object2);
        } else {
            object2 = (Messages$PresenceCommand)((SingleFieldBuilderV3)object2).build();
            Messages$GenericCommand.access$50202(messages$GenericCommand, (Messages$PresenceCommand)object2);
        }
        n11 = 0x1000000 & n10;
        n13 = 0x1000000;
        if (n11 == n13) {
            n11 = 0x1000000;
            n12 |= n11;
        }
        if ((object2 = this.reportMessageBuilder_) == null) {
            object2 = this.reportMessage_;
            Messages$GenericCommand.access$50302(messages$GenericCommand, (Messages$ReportCommand)object2);
        } else {
            object2 = (Messages$ReportCommand)((SingleFieldBuilderV3)object2).build();
            Messages$GenericCommand.access$50302(messages$GenericCommand, (Messages$ReportCommand)object2);
        }
        n11 = 0x2000000 & n10;
        n13 = 0x2000000;
        if (n11 == n13) {
            n11 = 0x2000000;
            n12 |= n11;
        }
        if ((object2 = this.patchMessageBuilder_) == null) {
            object2 = this.patchMessage_;
            Messages$GenericCommand.access$50402(messages$GenericCommand, (Messages$PatchCommand)object2);
        } else {
            object2 = (Messages$PatchCommand)((SingleFieldBuilderV3)object2).build();
            Messages$GenericCommand.access$50402(messages$GenericCommand, (Messages$PatchCommand)object2);
        }
        n11 = 0x4000000 & n10;
        n13 = 0x4000000;
        if (n11 == n13) {
            n11 = 0x4000000;
            n12 |= n11;
        }
        if ((object2 = this.pubsubMessageBuilder_) == null) {
            object2 = this.pubsubMessage_;
            Messages$GenericCommand.access$50502(messages$GenericCommand, (Messages$PubsubCommand)object2);
        } else {
            object2 = (Messages$PubsubCommand)((SingleFieldBuilderV3)object2).build();
            Messages$GenericCommand.access$50502(messages$GenericCommand, (Messages$PubsubCommand)object2);
        }
        n11 = 0x8000000 & n10;
        n13 = 0x8000000;
        if (n11 == n13) {
            n11 = 0x8000000;
            n12 |= n11;
        }
        if ((object2 = this.blacklistMessageBuilder_) == null) {
            object2 = this.blacklistMessage_;
            Messages$GenericCommand.access$50602(messages$GenericCommand, (Messages$BlacklistCommand)object2);
        } else {
            object2 = (Messages$BlacklistCommand)((SingleFieldBuilderV3)object2).build();
            Messages$GenericCommand.access$50602(messages$GenericCommand, (Messages$BlacklistCommand)object2);
        }
        n11 = 0x10000000;
        if ((n10 &= n11) == n11) {
            n10 = 0x10000000;
            n12 |= n10;
        }
        if ((object = this.loggedinMessageBuilder_) == null) {
            object = this.loggedinMessage_;
            Messages$GenericCommand.access$50702(messages$GenericCommand, (Messages$LoggedinCommand)object);
        } else {
            object = (Messages$LoggedinCommand)((SingleFieldBuilderV3)object).build();
            Messages$GenericCommand.access$50702(messages$GenericCommand, (Messages$LoggedinCommand)object);
        }
        Messages$GenericCommand.access$50802(messages$GenericCommand, n12);
        this.onBuilt();
        return messages$GenericCommand;
    }

    public Messages$GenericCommand$Builder clear() {
        int n10;
        long l10;
        int n11;
        int n12;
        super.clear();
        this.cmd_ = 0;
        this.bitField0_ = n12 = this.bitField0_ & 0xFFFFFFFE;
        this.op_ = n11 = 1;
        this.bitField0_ = n12 &= 0xFFFFFFFD;
        String string2 = "";
        this.appId_ = string2;
        this.bitField0_ = n12 &= 0xFFFFFFFB;
        this.peerId_ = string2;
        this.bitField0_ = n12 &= 0xFFFFFFF7;
        this.i_ = 0;
        this.bitField0_ = n12 &= 0xFFFFFFEF;
        this.installationId_ = string2;
        this.bitField0_ = n12 &= 0xFFFFFFDF;
        this.priority_ = 0;
        this.bitField0_ = n12 &= 0xFFFFFFBF;
        this.service_ = 0;
        this.bitField0_ = n12 &= 0xFFFFFF7F;
        this.serverTs_ = l10 = 0L;
        this.bitField0_ = n12 &= 0xFFFFFEFF;
        this.clientTs_ = l10;
        this.bitField0_ = n12 &= 0xFFFFFDFF;
        this.notificationType_ = 0;
        this.bitField0_ = n10 = n12 & 0xFFFFFBFF;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.loginMessageBuilder_;
        n12 = 0;
        if (singleFieldBuilderV3 == null) {
            this.loginMessage_ = null;
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFF7FF;
        singleFieldBuilderV3 = this.dataMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            this.dataMessage_ = null;
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFEFFF;
        singleFieldBuilderV3 = this.sessionMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            this.sessionMessage_ = null;
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFDFFF;
        singleFieldBuilderV3 = this.errorMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            this.errorMessage_ = null;
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFBFFF;
        singleFieldBuilderV3 = this.directMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            this.directMessage_ = null;
        } else {
            singleFieldBuilderV3.clear();
        }
        n10 = this.bitField0_;
        n11 = -32769;
        this.bitField0_ = n10 &= n11;
        singleFieldBuilderV3 = this.ackMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            this.ackMessage_ = null;
        } else {
            singleFieldBuilderV3.clear();
        }
        n10 = this.bitField0_;
        n11 = -65537;
        this.bitField0_ = n10 &= n11;
        singleFieldBuilderV3 = this.unreadMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            this.unreadMessage_ = null;
        } else {
            singleFieldBuilderV3.clear();
        }
        n10 = this.bitField0_;
        n11 = -131073;
        this.bitField0_ = n10 &= n11;
        singleFieldBuilderV3 = this.readMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            this.readMessage_ = null;
        } else {
            singleFieldBuilderV3.clear();
        }
        n10 = this.bitField0_;
        n11 = -262145;
        this.bitField0_ = n10 &= n11;
        singleFieldBuilderV3 = this.rcpMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            this.rcpMessage_ = null;
        } else {
            singleFieldBuilderV3.clear();
        }
        n10 = this.bitField0_;
        n11 = -524289;
        this.bitField0_ = n10 &= n11;
        singleFieldBuilderV3 = this.logsMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            this.logsMessage_ = null;
        } else {
            singleFieldBuilderV3.clear();
        }
        n10 = this.bitField0_;
        n11 = -1048577;
        this.bitField0_ = n10 &= n11;
        singleFieldBuilderV3 = this.convMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            this.convMessage_ = null;
        } else {
            singleFieldBuilderV3.clear();
        }
        n10 = this.bitField0_;
        n11 = -2097153;
        this.bitField0_ = n10 &= n11;
        singleFieldBuilderV3 = this.roomMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            this.roomMessage_ = null;
        } else {
            singleFieldBuilderV3.clear();
        }
        n10 = this.bitField0_;
        n11 = -4194305;
        this.bitField0_ = n10 &= n11;
        singleFieldBuilderV3 = this.presenceMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            this.presenceMessage_ = null;
        } else {
            singleFieldBuilderV3.clear();
        }
        n10 = this.bitField0_;
        n11 = -8388609;
        this.bitField0_ = n10 &= n11;
        singleFieldBuilderV3 = this.reportMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            this.reportMessage_ = null;
        } else {
            singleFieldBuilderV3.clear();
        }
        n10 = this.bitField0_;
        n11 = -16777217;
        this.bitField0_ = n10 &= n11;
        singleFieldBuilderV3 = this.patchMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            this.patchMessage_ = null;
        } else {
            singleFieldBuilderV3.clear();
        }
        n10 = this.bitField0_;
        n11 = -33554433;
        this.bitField0_ = n10 &= n11;
        singleFieldBuilderV3 = this.pubsubMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            this.pubsubMessage_ = null;
        } else {
            singleFieldBuilderV3.clear();
        }
        n10 = this.bitField0_;
        n11 = -67108865;
        this.bitField0_ = n10 &= n11;
        singleFieldBuilderV3 = this.blacklistMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            this.blacklistMessage_ = null;
        } else {
            singleFieldBuilderV3.clear();
        }
        n10 = this.bitField0_;
        n11 = -134217729;
        this.bitField0_ = n10 &= n11;
        singleFieldBuilderV3 = this.loggedinMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            this.loggedinMessage_ = null;
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xEFFFFFFF;
        return this;
    }

    public Messages$GenericCommand$Builder clearAckMessage() {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.ackMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            n10 = 0;
            singleFieldBuilderV3 = null;
            this.ackMessage_ = null;
            this.onChanged();
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFEFFFF;
        return this;
    }

    public Messages$GenericCommand$Builder clearAppId() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        String string2 = Messages$GenericCommand.getDefaultInstance().getAppId();
        this.appId_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$GenericCommand$Builder clearBlacklistMessage() {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.blacklistMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            n10 = 0;
            singleFieldBuilderV3 = null;
            this.blacklistMessage_ = null;
            this.onChanged();
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xF7FFFFFF;
        return this;
    }

    public Messages$GenericCommand$Builder clearClientTs() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFDFF;
        this.clientTs_ = 0L;
        this.onChanged();
        return this;
    }

    public Messages$GenericCommand$Builder clearCmd() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.cmd_ = 0;
        this.onChanged();
        return this;
    }

    public Messages$GenericCommand$Builder clearConvMessage() {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.convMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            n10 = 0;
            singleFieldBuilderV3 = null;
            this.convMessage_ = null;
            this.onChanged();
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFDFFFFF;
        return this;
    }

    public Messages$GenericCommand$Builder clearDataMessage() {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.dataMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            n10 = 0;
            singleFieldBuilderV3 = null;
            this.dataMessage_ = null;
            this.onChanged();
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFEFFF;
        return this;
    }

    public Messages$GenericCommand$Builder clearDirectMessage() {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.directMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            n10 = 0;
            singleFieldBuilderV3 = null;
            this.directMessage_ = null;
            this.onChanged();
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFF7FFF;
        return this;
    }

    public Messages$GenericCommand$Builder clearErrorMessage() {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.errorMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            n10 = 0;
            singleFieldBuilderV3 = null;
            this.errorMessage_ = null;
            this.onChanged();
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFBFFF;
        return this;
    }

    public Messages$GenericCommand$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Messages$GenericCommand$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Messages$GenericCommand$Builder clearI() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
        this.i_ = 0;
        this.onChanged();
        return this;
    }

    public Messages$GenericCommand$Builder clearInstallationId() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFDF;
        String string2 = Messages$GenericCommand.getDefaultInstance().getInstallationId();
        this.installationId_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$GenericCommand$Builder clearLoggedinMessage() {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.loggedinMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            n10 = 0;
            singleFieldBuilderV3 = null;
            this.loggedinMessage_ = null;
            this.onChanged();
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xEFFFFFFF;
        return this;
    }

    public Messages$GenericCommand$Builder clearLoginMessage() {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.loginMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            n10 = 0;
            singleFieldBuilderV3 = null;
            this.loginMessage_ = null;
            this.onChanged();
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFF7FF;
        return this;
    }

    public Messages$GenericCommand$Builder clearLogsMessage() {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.logsMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            n10 = 0;
            singleFieldBuilderV3 = null;
            this.logsMessage_ = null;
            this.onChanged();
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFEFFFFF;
        return this;
    }

    public Messages$GenericCommand$Builder clearNotificationType() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFBFF;
        this.notificationType_ = 0;
        this.onChanged();
        return this;
    }

    public Messages$GenericCommand$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Messages$GenericCommand$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Messages$GenericCommand$Builder clearOp() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.op_ = 1;
        this.onChanged();
        return this;
    }

    public Messages$GenericCommand$Builder clearPatchMessage() {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.patchMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            n10 = 0;
            singleFieldBuilderV3 = null;
            this.patchMessage_ = null;
            this.onChanged();
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFDFFFFFF;
        return this;
    }

    public Messages$GenericCommand$Builder clearPeerId() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        String string2 = Messages$GenericCommand.getDefaultInstance().getPeerId();
        this.peerId_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$GenericCommand$Builder clearPresenceMessage() {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.presenceMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            n10 = 0;
            singleFieldBuilderV3 = null;
            this.presenceMessage_ = null;
            this.onChanged();
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFF7FFFFF;
        return this;
    }

    public Messages$GenericCommand$Builder clearPriority() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFBF;
        this.priority_ = 0;
        this.onChanged();
        return this;
    }

    public Messages$GenericCommand$Builder clearPubsubMessage() {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.pubsubMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            n10 = 0;
            singleFieldBuilderV3 = null;
            this.pubsubMessage_ = null;
            this.onChanged();
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFBFFFFFF;
        return this;
    }

    public Messages$GenericCommand$Builder clearRcpMessage() {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.rcpMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            n10 = 0;
            singleFieldBuilderV3 = null;
            this.rcpMessage_ = null;
            this.onChanged();
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFF7FFFF;
        return this;
    }

    public Messages$GenericCommand$Builder clearReadMessage() {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.readMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            n10 = 0;
            singleFieldBuilderV3 = null;
            this.readMessage_ = null;
            this.onChanged();
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFBFFFF;
        return this;
    }

    public Messages$GenericCommand$Builder clearReportMessage() {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.reportMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            n10 = 0;
            singleFieldBuilderV3 = null;
            this.reportMessage_ = null;
            this.onChanged();
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFEFFFFFF;
        return this;
    }

    public Messages$GenericCommand$Builder clearRoomMessage() {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.roomMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            n10 = 0;
            singleFieldBuilderV3 = null;
            this.roomMessage_ = null;
            this.onChanged();
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFBFFFFF;
        return this;
    }

    public Messages$GenericCommand$Builder clearServerTs() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFEFF;
        this.serverTs_ = 0L;
        this.onChanged();
        return this;
    }

    public Messages$GenericCommand$Builder clearService() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFF7F;
        this.service_ = 0;
        this.onChanged();
        return this;
    }

    public Messages$GenericCommand$Builder clearSessionMessage() {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.sessionMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            n10 = 0;
            singleFieldBuilderV3 = null;
            this.sessionMessage_ = null;
            this.onChanged();
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFDFFF;
        return this;
    }

    public Messages$GenericCommand$Builder clearUnreadMessage() {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.unreadMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            n10 = 0;
            singleFieldBuilderV3 = null;
            this.unreadMessage_ = null;
            this.onChanged();
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFDFFFF;
        return this;
    }

    public Messages$GenericCommand$Builder clone() {
        return (Messages$GenericCommand$Builder)super.clone();
    }

    public Messages$AckCommand getAckMessage() {
        Object object = this.ackMessageBuilder_;
        if (object == null) {
            object = this.ackMessage_;
            if (object == null) {
                object = Messages$AckCommand.getDefaultInstance();
            }
            return object;
        }
        return (Messages$AckCommand)((SingleFieldBuilderV3)object).getMessage();
    }

    public Messages$AckCommand$Builder getAckMessageBuilder() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x10000;
        this.onChanged();
        return (Messages$AckCommand$Builder)this.getAckMessageFieldBuilder().getBuilder();
    }

    public Messages$AckCommandOrBuilder getAckMessageOrBuilder() {
        Object object = this.ackMessageBuilder_;
        if (object != null) {
            return (Messages$AckCommandOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.ackMessage_;
        if (object == null) {
            object = Messages$AckCommand.getDefaultInstance();
        }
        return object;
    }

    public String getAppId() {
        Object object = this.appId_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.appId_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getAppIdBytes() {
        Object object = this.appId_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.appId_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public Messages$BlacklistCommand getBlacklistMessage() {
        Object object = this.blacklistMessageBuilder_;
        if (object == null) {
            object = this.blacklistMessage_;
            if (object == null) {
                object = Messages$BlacklistCommand.getDefaultInstance();
            }
            return object;
        }
        return (Messages$BlacklistCommand)((SingleFieldBuilderV3)object).getMessage();
    }

    public Messages$BlacklistCommand$Builder getBlacklistMessageBuilder() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x8000000;
        this.onChanged();
        return (Messages$BlacklistCommand$Builder)this.getBlacklistMessageFieldBuilder().getBuilder();
    }

    public Messages$BlacklistCommandOrBuilder getBlacklistMessageOrBuilder() {
        Object object = this.blacklistMessageBuilder_;
        if (object != null) {
            return (Messages$BlacklistCommandOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.blacklistMessage_;
        if (object == null) {
            object = Messages$BlacklistCommand.getDefaultInstance();
        }
        return object;
    }

    public long getClientTs() {
        return this.clientTs_;
    }

    public Messages$CommandType getCmd() {
        int n10 = this.cmd_;
        Messages$CommandType messages$CommandType = Messages$CommandType.valueOf(n10);
        if (messages$CommandType == null) {
            messages$CommandType = Messages$CommandType.session;
        }
        return messages$CommandType;
    }

    public Messages$ConvCommand getConvMessage() {
        Object object = this.convMessageBuilder_;
        if (object == null) {
            object = this.convMessage_;
            if (object == null) {
                object = Messages$ConvCommand.getDefaultInstance();
            }
            return object;
        }
        return (Messages$ConvCommand)((SingleFieldBuilderV3)object).getMessage();
    }

    public Messages$ConvCommand$Builder getConvMessageBuilder() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x200000;
        this.onChanged();
        return (Messages$ConvCommand$Builder)this.getConvMessageFieldBuilder().getBuilder();
    }

    public Messages$ConvCommandOrBuilder getConvMessageOrBuilder() {
        Object object = this.convMessageBuilder_;
        if (object != null) {
            return (Messages$ConvCommandOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.convMessage_;
        if (object == null) {
            object = Messages$ConvCommand.getDefaultInstance();
        }
        return object;
    }

    public Messages$DataCommand getDataMessage() {
        Object object = this.dataMessageBuilder_;
        if (object == null) {
            object = this.dataMessage_;
            if (object == null) {
                object = Messages$DataCommand.getDefaultInstance();
            }
            return object;
        }
        return (Messages$DataCommand)((SingleFieldBuilderV3)object).getMessage();
    }

    public Messages$DataCommand$Builder getDataMessageBuilder() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x1000;
        this.onChanged();
        return (Messages$DataCommand$Builder)this.getDataMessageFieldBuilder().getBuilder();
    }

    public Messages$DataCommandOrBuilder getDataMessageOrBuilder() {
        Object object = this.dataMessageBuilder_;
        if (object != null) {
            return (Messages$DataCommandOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.dataMessage_;
        if (object == null) {
            object = Messages$DataCommand.getDefaultInstance();
        }
        return object;
    }

    public Messages$GenericCommand getDefaultInstanceForType() {
        return Messages$GenericCommand.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return Messages.access$47300();
    }

    public Messages$DirectCommand getDirectMessage() {
        Object object = this.directMessageBuilder_;
        if (object == null) {
            object = this.directMessage_;
            if (object == null) {
                object = Messages$DirectCommand.getDefaultInstance();
            }
            return object;
        }
        return (Messages$DirectCommand)((SingleFieldBuilderV3)object).getMessage();
    }

    public Messages$DirectCommand$Builder getDirectMessageBuilder() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x8000;
        this.onChanged();
        return (Messages$DirectCommand$Builder)this.getDirectMessageFieldBuilder().getBuilder();
    }

    public Messages$DirectCommandOrBuilder getDirectMessageOrBuilder() {
        Object object = this.directMessageBuilder_;
        if (object != null) {
            return (Messages$DirectCommandOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.directMessage_;
        if (object == null) {
            object = Messages$DirectCommand.getDefaultInstance();
        }
        return object;
    }

    public Messages$ErrorCommand getErrorMessage() {
        Object object = this.errorMessageBuilder_;
        if (object == null) {
            object = this.errorMessage_;
            if (object == null) {
                object = Messages$ErrorCommand.getDefaultInstance();
            }
            return object;
        }
        return (Messages$ErrorCommand)((SingleFieldBuilderV3)object).getMessage();
    }

    public Messages$ErrorCommand$Builder getErrorMessageBuilder() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x4000;
        this.onChanged();
        return (Messages$ErrorCommand$Builder)this.getErrorMessageFieldBuilder().getBuilder();
    }

    public Messages$ErrorCommandOrBuilder getErrorMessageOrBuilder() {
        Object object = this.errorMessageBuilder_;
        if (object != null) {
            return (Messages$ErrorCommandOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.errorMessage_;
        if (object == null) {
            object = Messages$ErrorCommand.getDefaultInstance();
        }
        return object;
    }

    public int getI() {
        return this.i_;
    }

    public String getInstallationId() {
        Object object = this.installationId_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.installationId_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getInstallationIdBytes() {
        Object object = this.installationId_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.installationId_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public Messages$LoggedinCommand getLoggedinMessage() {
        Object object = this.loggedinMessageBuilder_;
        if (object == null) {
            object = this.loggedinMessage_;
            if (object == null) {
                object = Messages$LoggedinCommand.getDefaultInstance();
            }
            return object;
        }
        return (Messages$LoggedinCommand)((SingleFieldBuilderV3)object).getMessage();
    }

    public Messages$LoggedinCommand$Builder getLoggedinMessageBuilder() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x10000000;
        this.onChanged();
        return (Messages$LoggedinCommand$Builder)this.getLoggedinMessageFieldBuilder().getBuilder();
    }

    public Messages$LoggedinCommandOrBuilder getLoggedinMessageOrBuilder() {
        Object object = this.loggedinMessageBuilder_;
        if (object != null) {
            return (Messages$LoggedinCommandOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.loggedinMessage_;
        if (object == null) {
            object = Messages$LoggedinCommand.getDefaultInstance();
        }
        return object;
    }

    public Messages$LoginCommand getLoginMessage() {
        Object object = this.loginMessageBuilder_;
        if (object == null) {
            object = this.loginMessage_;
            if (object == null) {
                object = Messages$LoginCommand.getDefaultInstance();
            }
            return object;
        }
        return (Messages$LoginCommand)((SingleFieldBuilderV3)object).getMessage();
    }

    public Messages$LoginCommand$Builder getLoginMessageBuilder() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x800;
        this.onChanged();
        return (Messages$LoginCommand$Builder)this.getLoginMessageFieldBuilder().getBuilder();
    }

    public Messages$LoginCommandOrBuilder getLoginMessageOrBuilder() {
        Object object = this.loginMessageBuilder_;
        if (object != null) {
            return (Messages$LoginCommandOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.loginMessage_;
        if (object == null) {
            object = Messages$LoginCommand.getDefaultInstance();
        }
        return object;
    }

    public Messages$LogsCommand getLogsMessage() {
        Object object = this.logsMessageBuilder_;
        if (object == null) {
            object = this.logsMessage_;
            if (object == null) {
                object = Messages$LogsCommand.getDefaultInstance();
            }
            return object;
        }
        return (Messages$LogsCommand)((SingleFieldBuilderV3)object).getMessage();
    }

    public Messages$LogsCommand$Builder getLogsMessageBuilder() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x100000;
        this.onChanged();
        return (Messages$LogsCommand$Builder)this.getLogsMessageFieldBuilder().getBuilder();
    }

    public Messages$LogsCommandOrBuilder getLogsMessageOrBuilder() {
        Object object = this.logsMessageBuilder_;
        if (object != null) {
            return (Messages$LogsCommandOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.logsMessage_;
        if (object == null) {
            object = Messages$LogsCommand.getDefaultInstance();
        }
        return object;
    }

    public int getNotificationType() {
        return this.notificationType_;
    }

    public Messages$OpType getOp() {
        int n10 = this.op_;
        Messages$OpType messages$OpType = Messages$OpType.valueOf(n10);
        if (messages$OpType == null) {
            messages$OpType = Messages$OpType.open;
        }
        return messages$OpType;
    }

    public Messages$PatchCommand getPatchMessage() {
        Object object = this.patchMessageBuilder_;
        if (object == null) {
            object = this.patchMessage_;
            if (object == null) {
                object = Messages$PatchCommand.getDefaultInstance();
            }
            return object;
        }
        return (Messages$PatchCommand)((SingleFieldBuilderV3)object).getMessage();
    }

    public Messages$PatchCommand$Builder getPatchMessageBuilder() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x2000000;
        this.onChanged();
        return (Messages$PatchCommand$Builder)this.getPatchMessageFieldBuilder().getBuilder();
    }

    public Messages$PatchCommandOrBuilder getPatchMessageOrBuilder() {
        Object object = this.patchMessageBuilder_;
        if (object != null) {
            return (Messages$PatchCommandOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.patchMessage_;
        if (object == null) {
            object = Messages$PatchCommand.getDefaultInstance();
        }
        return object;
    }

    public String getPeerId() {
        Object object = this.peerId_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.peerId_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getPeerIdBytes() {
        Object object = this.peerId_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.peerId_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public Messages$PresenceCommand getPresenceMessage() {
        Object object = this.presenceMessageBuilder_;
        if (object == null) {
            object = this.presenceMessage_;
            if (object == null) {
                object = Messages$PresenceCommand.getDefaultInstance();
            }
            return object;
        }
        return (Messages$PresenceCommand)((SingleFieldBuilderV3)object).getMessage();
    }

    public Messages$PresenceCommand$Builder getPresenceMessageBuilder() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x800000;
        this.onChanged();
        return (Messages$PresenceCommand$Builder)this.getPresenceMessageFieldBuilder().getBuilder();
    }

    public Messages$PresenceCommandOrBuilder getPresenceMessageOrBuilder() {
        Object object = this.presenceMessageBuilder_;
        if (object != null) {
            return (Messages$PresenceCommandOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.presenceMessage_;
        if (object == null) {
            object = Messages$PresenceCommand.getDefaultInstance();
        }
        return object;
    }

    public int getPriority() {
        return this.priority_;
    }

    public Messages$PubsubCommand getPubsubMessage() {
        Object object = this.pubsubMessageBuilder_;
        if (object == null) {
            object = this.pubsubMessage_;
            if (object == null) {
                object = Messages$PubsubCommand.getDefaultInstance();
            }
            return object;
        }
        return (Messages$PubsubCommand)((SingleFieldBuilderV3)object).getMessage();
    }

    public Messages$PubsubCommand$Builder getPubsubMessageBuilder() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x4000000;
        this.onChanged();
        return (Messages$PubsubCommand$Builder)this.getPubsubMessageFieldBuilder().getBuilder();
    }

    public Messages$PubsubCommandOrBuilder getPubsubMessageOrBuilder() {
        Object object = this.pubsubMessageBuilder_;
        if (object != null) {
            return (Messages$PubsubCommandOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.pubsubMessage_;
        if (object == null) {
            object = Messages$PubsubCommand.getDefaultInstance();
        }
        return object;
    }

    public Messages$RcpCommand getRcpMessage() {
        Object object = this.rcpMessageBuilder_;
        if (object == null) {
            object = this.rcpMessage_;
            if (object == null) {
                object = Messages$RcpCommand.getDefaultInstance();
            }
            return object;
        }
        return (Messages$RcpCommand)((SingleFieldBuilderV3)object).getMessage();
    }

    public Messages$RcpCommand$Builder getRcpMessageBuilder() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x80000;
        this.onChanged();
        return (Messages$RcpCommand$Builder)this.getRcpMessageFieldBuilder().getBuilder();
    }

    public Messages$RcpCommandOrBuilder getRcpMessageOrBuilder() {
        Object object = this.rcpMessageBuilder_;
        if (object != null) {
            return (Messages$RcpCommandOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.rcpMessage_;
        if (object == null) {
            object = Messages$RcpCommand.getDefaultInstance();
        }
        return object;
    }

    public Messages$ReadCommand getReadMessage() {
        Object object = this.readMessageBuilder_;
        if (object == null) {
            object = this.readMessage_;
            if (object == null) {
                object = Messages$ReadCommand.getDefaultInstance();
            }
            return object;
        }
        return (Messages$ReadCommand)((SingleFieldBuilderV3)object).getMessage();
    }

    public Messages$ReadCommand$Builder getReadMessageBuilder() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x40000;
        this.onChanged();
        return (Messages$ReadCommand$Builder)this.getReadMessageFieldBuilder().getBuilder();
    }

    public Messages$ReadCommandOrBuilder getReadMessageOrBuilder() {
        Object object = this.readMessageBuilder_;
        if (object != null) {
            return (Messages$ReadCommandOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.readMessage_;
        if (object == null) {
            object = Messages$ReadCommand.getDefaultInstance();
        }
        return object;
    }

    public Messages$ReportCommand getReportMessage() {
        Object object = this.reportMessageBuilder_;
        if (object == null) {
            object = this.reportMessage_;
            if (object == null) {
                object = Messages$ReportCommand.getDefaultInstance();
            }
            return object;
        }
        return (Messages$ReportCommand)((SingleFieldBuilderV3)object).getMessage();
    }

    public Messages$ReportCommand$Builder getReportMessageBuilder() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x1000000;
        this.onChanged();
        return (Messages$ReportCommand$Builder)this.getReportMessageFieldBuilder().getBuilder();
    }

    public Messages$ReportCommandOrBuilder getReportMessageOrBuilder() {
        Object object = this.reportMessageBuilder_;
        if (object != null) {
            return (Messages$ReportCommandOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.reportMessage_;
        if (object == null) {
            object = Messages$ReportCommand.getDefaultInstance();
        }
        return object;
    }

    public Messages$RoomCommand getRoomMessage() {
        Object object = this.roomMessageBuilder_;
        if (object == null) {
            object = this.roomMessage_;
            if (object == null) {
                object = Messages$RoomCommand.getDefaultInstance();
            }
            return object;
        }
        return (Messages$RoomCommand)((SingleFieldBuilderV3)object).getMessage();
    }

    public Messages$RoomCommand$Builder getRoomMessageBuilder() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x400000;
        this.onChanged();
        return (Messages$RoomCommand$Builder)this.getRoomMessageFieldBuilder().getBuilder();
    }

    public Messages$RoomCommandOrBuilder getRoomMessageOrBuilder() {
        Object object = this.roomMessageBuilder_;
        if (object != null) {
            return (Messages$RoomCommandOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.roomMessage_;
        if (object == null) {
            object = Messages$RoomCommand.getDefaultInstance();
        }
        return object;
    }

    public long getServerTs() {
        return this.serverTs_;
    }

    public int getService() {
        return this.service_;
    }

    public Messages$SessionCommand getSessionMessage() {
        Object object = this.sessionMessageBuilder_;
        if (object == null) {
            object = this.sessionMessage_;
            if (object == null) {
                object = Messages$SessionCommand.getDefaultInstance();
            }
            return object;
        }
        return (Messages$SessionCommand)((SingleFieldBuilderV3)object).getMessage();
    }

    public Messages$SessionCommand$Builder getSessionMessageBuilder() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x2000;
        this.onChanged();
        return (Messages$SessionCommand$Builder)this.getSessionMessageFieldBuilder().getBuilder();
    }

    public Messages$SessionCommandOrBuilder getSessionMessageOrBuilder() {
        Object object = this.sessionMessageBuilder_;
        if (object != null) {
            return (Messages$SessionCommandOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.sessionMessage_;
        if (object == null) {
            object = Messages$SessionCommand.getDefaultInstance();
        }
        return object;
    }

    public Messages$UnreadCommand getUnreadMessage() {
        Object object = this.unreadMessageBuilder_;
        if (object == null) {
            object = this.unreadMessage_;
            if (object == null) {
                object = Messages$UnreadCommand.getDefaultInstance();
            }
            return object;
        }
        return (Messages$UnreadCommand)((SingleFieldBuilderV3)object).getMessage();
    }

    public Messages$UnreadCommand$Builder getUnreadMessageBuilder() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x20000;
        this.onChanged();
        return (Messages$UnreadCommand$Builder)this.getUnreadMessageFieldBuilder().getBuilder();
    }

    public Messages$UnreadCommandOrBuilder getUnreadMessageOrBuilder() {
        Object object = this.unreadMessageBuilder_;
        if (object != null) {
            return (Messages$UnreadCommandOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.unreadMessage_;
        if (object == null) {
            object = Messages$UnreadCommand.getDefaultInstance();
        }
        return object;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasAckMessage() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 65536;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasAppId() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 4;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasBlacklistMessage() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 0x8000000;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasClientTs() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 512;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    public boolean hasCmd() {
        int bl2 = this.bitField0_;
        int n10 = 1;
        int n11 = bl2 & n10;
        if (n11 != n10) {
            n10 = 0;
        }
        return n10 != 0;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasConvMessage() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 0x200000;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasDataMessage() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 4096;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasDirectMessage() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 32768;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasErrorMessage() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 16384;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasI() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 16;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasInstallationId() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 32;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasLoggedinMessage() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 0x10000000;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasLoginMessage() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 2048;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasLogsMessage() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 0x100000;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasNotificationType() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 1024;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasOp() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 2;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasPatchMessage() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 0x2000000;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasPeerId() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 8;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasPresenceMessage() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 0x800000;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasPriority() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 64;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasPubsubMessage() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 0x4000000;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasRcpMessage() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 524288;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasReadMessage() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 262144;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasReportMessage() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 0x1000000;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasRoomMessage() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 0x400000;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasServerTs() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 256;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasService() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 128;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasSessionMessage() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 8192;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasUnreadMessage() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 131072;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$47400().ensureFieldAccessorsInitialized(Messages$GenericCommand.class, Messages$GenericCommand$Builder.class);
    }

    public final boolean isInitialized() {
        GeneratedMessageV3 generatedMessageV3;
        boolean bl2 = this.hasDataMessage();
        if (bl2 && !(bl2 = ((Messages$DataCommand)(generatedMessageV3 = this.getDataMessage())).isInitialized())) {
            return false;
        }
        bl2 = this.hasErrorMessage();
        if (bl2 && !(bl2 = ((Messages$ErrorCommand)(generatedMessageV3 = this.getErrorMessage())).isInitialized())) {
            return false;
        }
        bl2 = this.hasUnreadMessage();
        if (bl2 && !(bl2 = ((Messages$UnreadCommand)(generatedMessageV3 = this.getUnreadMessage())).isInitialized())) {
            return false;
        }
        bl2 = this.hasReadMessage();
        if (bl2 && !(bl2 = ((Messages$ReadCommand)(generatedMessageV3 = this.getReadMessage())).isInitialized())) {
            return false;
        }
        bl2 = this.hasConvMessage();
        if (bl2 && !(bl2 = ((Messages$ConvCommand)(generatedMessageV3 = this.getConvMessage())).isInitialized())) {
            return false;
        }
        bl2 = this.hasPubsubMessage();
        if (bl2 && !(bl2 = ((Messages$PubsubCommand)(generatedMessageV3 = this.getPubsubMessage())).isInitialized())) {
            return false;
        }
        bl2 = this.hasBlacklistMessage();
        return !bl2 || (bl2 = ((Messages$BlacklistCommand)(generatedMessageV3 = this.getBlacklistMessage())).isInitialized());
    }

    public Messages$GenericCommand$Builder mergeAckMessage(Messages$AckCommand messages$AckCommand) {
        int n10;
        Object object = this.ackMessageBuilder_;
        int n11 = 65536;
        if (object == null) {
            Messages$AckCommand messages$AckCommand2;
            int n12 = this.bitField0_ & n11;
            if (n12 == n11 && (object = this.ackMessage_) != null && object != (messages$AckCommand2 = Messages$AckCommand.getDefaultInstance())) {
                object = Messages$AckCommand.newBuilder(this.ackMessage_);
                this.ackMessage_ = messages$AckCommand = ((Messages$AckCommand$Builder)object).mergeFrom(messages$AckCommand).buildPartial();
            } else {
                this.ackMessage_ = messages$AckCommand;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(messages$AckCommand);
        }
        this.bitField0_ = n10 = this.bitField0_ | n11;
        return this;
    }

    public Messages$GenericCommand$Builder mergeBlacklistMessage(Messages$BlacklistCommand messages$BlacklistCommand) {
        int n10;
        Object object = this.blacklistMessageBuilder_;
        int n11 = 0x8000000;
        if (object == null) {
            Messages$BlacklistCommand messages$BlacklistCommand2;
            int n12 = this.bitField0_ & n11;
            if (n12 == n11 && (object = this.blacklistMessage_) != null && object != (messages$BlacklistCommand2 = Messages$BlacklistCommand.getDefaultInstance())) {
                object = Messages$BlacklistCommand.newBuilder(this.blacklistMessage_);
                this.blacklistMessage_ = messages$BlacklistCommand = ((Messages$BlacklistCommand$Builder)object).mergeFrom(messages$BlacklistCommand).buildPartial();
            } else {
                this.blacklistMessage_ = messages$BlacklistCommand;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(messages$BlacklistCommand);
        }
        this.bitField0_ = n10 = this.bitField0_ | n11;
        return this;
    }

    public Messages$GenericCommand$Builder mergeConvMessage(Messages$ConvCommand messages$ConvCommand) {
        int n10;
        Object object = this.convMessageBuilder_;
        int n11 = 0x200000;
        if (object == null) {
            Messages$ConvCommand messages$ConvCommand2;
            int n12 = this.bitField0_ & n11;
            if (n12 == n11 && (object = this.convMessage_) != null && object != (messages$ConvCommand2 = Messages$ConvCommand.getDefaultInstance())) {
                object = Messages$ConvCommand.newBuilder(this.convMessage_);
                this.convMessage_ = messages$ConvCommand = ((Messages$ConvCommand$Builder)object).mergeFrom(messages$ConvCommand).buildPartial();
            } else {
                this.convMessage_ = messages$ConvCommand;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(messages$ConvCommand);
        }
        this.bitField0_ = n10 = this.bitField0_ | n11;
        return this;
    }

    public Messages$GenericCommand$Builder mergeDataMessage(Messages$DataCommand messages$DataCommand) {
        int n10;
        Object object = this.dataMessageBuilder_;
        int n11 = 4096;
        if (object == null) {
            Messages$DataCommand messages$DataCommand2;
            int n12 = this.bitField0_ & n11;
            if (n12 == n11 && (object = this.dataMessage_) != null && object != (messages$DataCommand2 = Messages$DataCommand.getDefaultInstance())) {
                object = Messages$DataCommand.newBuilder(this.dataMessage_);
                this.dataMessage_ = messages$DataCommand = ((Messages$DataCommand$Builder)object).mergeFrom(messages$DataCommand).buildPartial();
            } else {
                this.dataMessage_ = messages$DataCommand;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(messages$DataCommand);
        }
        this.bitField0_ = n10 = this.bitField0_ | n11;
        return this;
    }

    public Messages$GenericCommand$Builder mergeDirectMessage(Messages$DirectCommand messages$DirectCommand) {
        int n10;
        Object object = this.directMessageBuilder_;
        int n11 = 32768;
        if (object == null) {
            Messages$DirectCommand messages$DirectCommand2;
            int n12 = this.bitField0_ & n11;
            if (n12 == n11 && (object = this.directMessage_) != null && object != (messages$DirectCommand2 = Messages$DirectCommand.getDefaultInstance())) {
                object = Messages$DirectCommand.newBuilder(this.directMessage_);
                this.directMessage_ = messages$DirectCommand = ((Messages$DirectCommand$Builder)object).mergeFrom(messages$DirectCommand).buildPartial();
            } else {
                this.directMessage_ = messages$DirectCommand;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(messages$DirectCommand);
        }
        this.bitField0_ = n10 = this.bitField0_ | n11;
        return this;
    }

    public Messages$GenericCommand$Builder mergeErrorMessage(Messages$ErrorCommand messages$ErrorCommand) {
        int n10;
        Object object = this.errorMessageBuilder_;
        int n11 = 16384;
        if (object == null) {
            Messages$ErrorCommand messages$ErrorCommand2;
            int n12 = this.bitField0_ & n11;
            if (n12 == n11 && (object = this.errorMessage_) != null && object != (messages$ErrorCommand2 = Messages$ErrorCommand.getDefaultInstance())) {
                object = Messages$ErrorCommand.newBuilder(this.errorMessage_);
                this.errorMessage_ = messages$ErrorCommand = ((Messages$ErrorCommand$Builder)object).mergeFrom(messages$ErrorCommand).buildPartial();
            } else {
                this.errorMessage_ = messages$ErrorCommand;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(messages$ErrorCommand);
        }
        this.bitField0_ = n10 = this.bitField0_ | n11;
        return this;
    }

    public Messages$GenericCommand$Builder mergeFrom(Messages$GenericCommand messageLite) {
        long l10;
        Object object = Messages$GenericCommand.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        int n10 = messageLite.hasCmd();
        if (n10 != 0) {
            object = messageLite.getCmd();
            this.setCmd((Messages$CommandType)object);
        }
        if ((n10 = messageLite.hasOp()) != 0) {
            object = messageLite.getOp();
            this.setOp((Messages$OpType)object);
        }
        if ((n10 = messageLite.hasAppId()) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 4;
            this.appId_ = object = Messages$GenericCommand.access$48100(messageLite);
            this.onChanged();
        }
        if ((n10 = messageLite.hasPeerId()) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 8;
            this.peerId_ = object = Messages$GenericCommand.access$48200(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasI() ? 1 : 0)) != 0) {
            n10 = messageLite.getI();
            this.setI(n10);
        }
        if ((n10 = (int)(messageLite.hasInstallationId() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 0x20;
            this.installationId_ = object = Messages$GenericCommand.access$48400(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasPriority() ? 1 : 0)) != 0) {
            n10 = messageLite.getPriority();
            this.setPriority(n10);
        }
        if ((n10 = (int)(messageLite.hasService() ? 1 : 0)) != 0) {
            n10 = messageLite.getService();
            this.setService(n10);
        }
        if ((n10 = (int)(messageLite.hasServerTs() ? 1 : 0)) != 0) {
            l10 = messageLite.getServerTs();
            this.setServerTs(l10);
        }
        if ((n10 = (int)(messageLite.hasClientTs() ? 1 : 0)) != 0) {
            l10 = messageLite.getClientTs();
            this.setClientTs(l10);
        }
        if ((n10 = (int)(messageLite.hasNotificationType() ? 1 : 0)) != 0) {
            n10 = messageLite.getNotificationType();
            this.setNotificationType(n10);
        }
        if ((n10 = (int)(messageLite.hasLoginMessage() ? 1 : 0)) != 0) {
            object = messageLite.getLoginMessage();
            this.mergeLoginMessage((Messages$LoginCommand)object);
        }
        if ((n10 = (int)(messageLite.hasDataMessage() ? 1 : 0)) != 0) {
            object = messageLite.getDataMessage();
            this.mergeDataMessage((Messages$DataCommand)object);
        }
        if ((n10 = (int)(messageLite.hasSessionMessage() ? 1 : 0)) != 0) {
            object = messageLite.getSessionMessage();
            this.mergeSessionMessage((Messages$SessionCommand)object);
        }
        if ((n10 = (int)(messageLite.hasErrorMessage() ? 1 : 0)) != 0) {
            object = messageLite.getErrorMessage();
            this.mergeErrorMessage((Messages$ErrorCommand)object);
        }
        if ((n10 = (int)(messageLite.hasDirectMessage() ? 1 : 0)) != 0) {
            object = messageLite.getDirectMessage();
            this.mergeDirectMessage((Messages$DirectCommand)object);
        }
        if ((n10 = (int)(messageLite.hasAckMessage() ? 1 : 0)) != 0) {
            object = messageLite.getAckMessage();
            this.mergeAckMessage((Messages$AckCommand)object);
        }
        if ((n10 = (int)(messageLite.hasUnreadMessage() ? 1 : 0)) != 0) {
            object = messageLite.getUnreadMessage();
            this.mergeUnreadMessage((Messages$UnreadCommand)object);
        }
        if ((n10 = (int)(messageLite.hasReadMessage() ? 1 : 0)) != 0) {
            object = messageLite.getReadMessage();
            this.mergeReadMessage((Messages$ReadCommand)object);
        }
        if ((n10 = (int)(messageLite.hasRcpMessage() ? 1 : 0)) != 0) {
            object = messageLite.getRcpMessage();
            this.mergeRcpMessage((Messages$RcpCommand)object);
        }
        if ((n10 = (int)(messageLite.hasLogsMessage() ? 1 : 0)) != 0) {
            object = messageLite.getLogsMessage();
            this.mergeLogsMessage((Messages$LogsCommand)object);
        }
        if ((n10 = (int)(messageLite.hasConvMessage() ? 1 : 0)) != 0) {
            object = messageLite.getConvMessage();
            this.mergeConvMessage((Messages$ConvCommand)object);
        }
        if ((n10 = (int)(messageLite.hasRoomMessage() ? 1 : 0)) != 0) {
            object = messageLite.getRoomMessage();
            this.mergeRoomMessage((Messages$RoomCommand)object);
        }
        if ((n10 = (int)(messageLite.hasPresenceMessage() ? 1 : 0)) != 0) {
            object = messageLite.getPresenceMessage();
            this.mergePresenceMessage((Messages$PresenceCommand)object);
        }
        if ((n10 = (int)(messageLite.hasReportMessage() ? 1 : 0)) != 0) {
            object = messageLite.getReportMessage();
            this.mergeReportMessage((Messages$ReportCommand)object);
        }
        if ((n10 = (int)(messageLite.hasPatchMessage() ? 1 : 0)) != 0) {
            object = messageLite.getPatchMessage();
            this.mergePatchMessage((Messages$PatchCommand)object);
        }
        if ((n10 = (int)(messageLite.hasPubsubMessage() ? 1 : 0)) != 0) {
            object = messageLite.getPubsubMessage();
            this.mergePubsubMessage((Messages$PubsubCommand)object);
        }
        if ((n10 = (int)(messageLite.hasBlacklistMessage() ? 1 : 0)) != 0) {
            object = messageLite.getBlacklistMessage();
            this.mergeBlacklistMessage((Messages$BlacklistCommand)object);
        }
        if ((n10 = (int)(messageLite.hasLoggedinMessage() ? 1 : 0)) != 0) {
            object = messageLite.getLoggedinMessage();
            this.mergeLoggedinMessage((Messages$LoggedinCommand)object);
        }
        messageLite = Messages$GenericCommand.access$50900(messageLite);
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
    public Messages$GenericCommand$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Messages$GenericCommand.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Messages$GenericCommand)object;
            if (object == null) break block7;
            this.mergeFrom((Messages$GenericCommand)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Messages$GenericCommand)object2;
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
            this.mergeFrom((Messages$GenericCommand)object3);
        }
        throw var1_6;
    }

    public Messages$GenericCommand$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Messages$GenericCommand;
        if (bl2) {
            message = (Messages$GenericCommand)message;
            return this.mergeFrom((Messages$GenericCommand)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public Messages$GenericCommand$Builder mergeLoggedinMessage(Messages$LoggedinCommand messages$LoggedinCommand) {
        int n10;
        Object object = this.loggedinMessageBuilder_;
        int n11 = 0x10000000;
        if (object == null) {
            Messages$LoggedinCommand messages$LoggedinCommand2;
            int n12 = this.bitField0_ & n11;
            if (n12 == n11 && (object = this.loggedinMessage_) != null && object != (messages$LoggedinCommand2 = Messages$LoggedinCommand.getDefaultInstance())) {
                object = Messages$LoggedinCommand.newBuilder(this.loggedinMessage_);
                this.loggedinMessage_ = messages$LoggedinCommand = ((Messages$LoggedinCommand$Builder)object).mergeFrom(messages$LoggedinCommand).buildPartial();
            } else {
                this.loggedinMessage_ = messages$LoggedinCommand;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(messages$LoggedinCommand);
        }
        this.bitField0_ = n10 = this.bitField0_ | n11;
        return this;
    }

    public Messages$GenericCommand$Builder mergeLoginMessage(Messages$LoginCommand messages$LoginCommand) {
        int n10;
        Object object = this.loginMessageBuilder_;
        int n11 = 2048;
        if (object == null) {
            Messages$LoginCommand messages$LoginCommand2;
            int n12 = this.bitField0_ & n11;
            if (n12 == n11 && (object = this.loginMessage_) != null && object != (messages$LoginCommand2 = Messages$LoginCommand.getDefaultInstance())) {
                object = Messages$LoginCommand.newBuilder(this.loginMessage_);
                this.loginMessage_ = messages$LoginCommand = ((Messages$LoginCommand$Builder)object).mergeFrom(messages$LoginCommand).buildPartial();
            } else {
                this.loginMessage_ = messages$LoginCommand;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(messages$LoginCommand);
        }
        this.bitField0_ = n10 = this.bitField0_ | n11;
        return this;
    }

    public Messages$GenericCommand$Builder mergeLogsMessage(Messages$LogsCommand messages$LogsCommand) {
        int n10;
        Object object = this.logsMessageBuilder_;
        int n11 = 0x100000;
        if (object == null) {
            Messages$LogsCommand messages$LogsCommand2;
            int n12 = this.bitField0_ & n11;
            if (n12 == n11 && (object = this.logsMessage_) != null && object != (messages$LogsCommand2 = Messages$LogsCommand.getDefaultInstance())) {
                object = Messages$LogsCommand.newBuilder(this.logsMessage_);
                this.logsMessage_ = messages$LogsCommand = ((Messages$LogsCommand$Builder)object).mergeFrom(messages$LogsCommand).buildPartial();
            } else {
                this.logsMessage_ = messages$LogsCommand;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(messages$LogsCommand);
        }
        this.bitField0_ = n10 = this.bitField0_ | n11;
        return this;
    }

    public Messages$GenericCommand$Builder mergePatchMessage(Messages$PatchCommand messages$PatchCommand) {
        int n10;
        Object object = this.patchMessageBuilder_;
        int n11 = 0x2000000;
        if (object == null) {
            Messages$PatchCommand messages$PatchCommand2;
            int n12 = this.bitField0_ & n11;
            if (n12 == n11 && (object = this.patchMessage_) != null && object != (messages$PatchCommand2 = Messages$PatchCommand.getDefaultInstance())) {
                object = Messages$PatchCommand.newBuilder(this.patchMessage_);
                this.patchMessage_ = messages$PatchCommand = ((Messages$PatchCommand$Builder)object).mergeFrom(messages$PatchCommand).buildPartial();
            } else {
                this.patchMessage_ = messages$PatchCommand;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(messages$PatchCommand);
        }
        this.bitField0_ = n10 = this.bitField0_ | n11;
        return this;
    }

    public Messages$GenericCommand$Builder mergePresenceMessage(Messages$PresenceCommand messages$PresenceCommand) {
        int n10;
        Object object = this.presenceMessageBuilder_;
        int n11 = 0x800000;
        if (object == null) {
            Messages$PresenceCommand messages$PresenceCommand2;
            int n12 = this.bitField0_ & n11;
            if (n12 == n11 && (object = this.presenceMessage_) != null && object != (messages$PresenceCommand2 = Messages$PresenceCommand.getDefaultInstance())) {
                object = Messages$PresenceCommand.newBuilder(this.presenceMessage_);
                this.presenceMessage_ = messages$PresenceCommand = ((Messages$PresenceCommand$Builder)object).mergeFrom(messages$PresenceCommand).buildPartial();
            } else {
                this.presenceMessage_ = messages$PresenceCommand;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(messages$PresenceCommand);
        }
        this.bitField0_ = n10 = this.bitField0_ | n11;
        return this;
    }

    public Messages$GenericCommand$Builder mergePubsubMessage(Messages$PubsubCommand messages$PubsubCommand) {
        int n10;
        Object object = this.pubsubMessageBuilder_;
        int n11 = 0x4000000;
        if (object == null) {
            Messages$PubsubCommand messages$PubsubCommand2;
            int n12 = this.bitField0_ & n11;
            if (n12 == n11 && (object = this.pubsubMessage_) != null && object != (messages$PubsubCommand2 = Messages$PubsubCommand.getDefaultInstance())) {
                object = Messages$PubsubCommand.newBuilder(this.pubsubMessage_);
                this.pubsubMessage_ = messages$PubsubCommand = ((Messages$PubsubCommand$Builder)object).mergeFrom(messages$PubsubCommand).buildPartial();
            } else {
                this.pubsubMessage_ = messages$PubsubCommand;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(messages$PubsubCommand);
        }
        this.bitField0_ = n10 = this.bitField0_ | n11;
        return this;
    }

    public Messages$GenericCommand$Builder mergeRcpMessage(Messages$RcpCommand messages$RcpCommand) {
        int n10;
        Object object = this.rcpMessageBuilder_;
        int n11 = 524288;
        if (object == null) {
            Messages$RcpCommand messages$RcpCommand2;
            int n12 = this.bitField0_ & n11;
            if (n12 == n11 && (object = this.rcpMessage_) != null && object != (messages$RcpCommand2 = Messages$RcpCommand.getDefaultInstance())) {
                object = Messages$RcpCommand.newBuilder(this.rcpMessage_);
                this.rcpMessage_ = messages$RcpCommand = ((Messages$RcpCommand$Builder)object).mergeFrom(messages$RcpCommand).buildPartial();
            } else {
                this.rcpMessage_ = messages$RcpCommand;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(messages$RcpCommand);
        }
        this.bitField0_ = n10 = this.bitField0_ | n11;
        return this;
    }

    public Messages$GenericCommand$Builder mergeReadMessage(Messages$ReadCommand messages$ReadCommand) {
        int n10;
        Object object = this.readMessageBuilder_;
        int n11 = 262144;
        if (object == null) {
            Messages$ReadCommand messages$ReadCommand2;
            int n12 = this.bitField0_ & n11;
            if (n12 == n11 && (object = this.readMessage_) != null && object != (messages$ReadCommand2 = Messages$ReadCommand.getDefaultInstance())) {
                object = Messages$ReadCommand.newBuilder(this.readMessage_);
                this.readMessage_ = messages$ReadCommand = ((Messages$ReadCommand$Builder)object).mergeFrom(messages$ReadCommand).buildPartial();
            } else {
                this.readMessage_ = messages$ReadCommand;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(messages$ReadCommand);
        }
        this.bitField0_ = n10 = this.bitField0_ | n11;
        return this;
    }

    public Messages$GenericCommand$Builder mergeReportMessage(Messages$ReportCommand messages$ReportCommand) {
        int n10;
        Object object = this.reportMessageBuilder_;
        int n11 = 0x1000000;
        if (object == null) {
            Messages$ReportCommand messages$ReportCommand2;
            int n12 = this.bitField0_ & n11;
            if (n12 == n11 && (object = this.reportMessage_) != null && object != (messages$ReportCommand2 = Messages$ReportCommand.getDefaultInstance())) {
                object = Messages$ReportCommand.newBuilder(this.reportMessage_);
                this.reportMessage_ = messages$ReportCommand = ((Messages$ReportCommand$Builder)object).mergeFrom(messages$ReportCommand).buildPartial();
            } else {
                this.reportMessage_ = messages$ReportCommand;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(messages$ReportCommand);
        }
        this.bitField0_ = n10 = this.bitField0_ | n11;
        return this;
    }

    public Messages$GenericCommand$Builder mergeRoomMessage(Messages$RoomCommand messages$RoomCommand) {
        int n10;
        Object object = this.roomMessageBuilder_;
        int n11 = 0x400000;
        if (object == null) {
            Messages$RoomCommand messages$RoomCommand2;
            int n12 = this.bitField0_ & n11;
            if (n12 == n11 && (object = this.roomMessage_) != null && object != (messages$RoomCommand2 = Messages$RoomCommand.getDefaultInstance())) {
                object = Messages$RoomCommand.newBuilder(this.roomMessage_);
                this.roomMessage_ = messages$RoomCommand = ((Messages$RoomCommand$Builder)object).mergeFrom(messages$RoomCommand).buildPartial();
            } else {
                this.roomMessage_ = messages$RoomCommand;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(messages$RoomCommand);
        }
        this.bitField0_ = n10 = this.bitField0_ | n11;
        return this;
    }

    public Messages$GenericCommand$Builder mergeSessionMessage(Messages$SessionCommand messages$SessionCommand) {
        int n10;
        Object object = this.sessionMessageBuilder_;
        int n11 = 8192;
        if (object == null) {
            Messages$SessionCommand messages$SessionCommand2;
            int n12 = this.bitField0_ & n11;
            if (n12 == n11 && (object = this.sessionMessage_) != null && object != (messages$SessionCommand2 = Messages$SessionCommand.getDefaultInstance())) {
                object = Messages$SessionCommand.newBuilder(this.sessionMessage_);
                this.sessionMessage_ = messages$SessionCommand = ((Messages$SessionCommand$Builder)object).mergeFrom(messages$SessionCommand).buildPartial();
            } else {
                this.sessionMessage_ = messages$SessionCommand;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(messages$SessionCommand);
        }
        this.bitField0_ = n10 = this.bitField0_ | n11;
        return this;
    }

    public final Messages$GenericCommand$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$GenericCommand$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Messages$GenericCommand$Builder mergeUnreadMessage(Messages$UnreadCommand messages$UnreadCommand) {
        int n10;
        Object object = this.unreadMessageBuilder_;
        int n11 = 131072;
        if (object == null) {
            Messages$UnreadCommand messages$UnreadCommand2;
            int n12 = this.bitField0_ & n11;
            if (n12 == n11 && (object = this.unreadMessage_) != null && object != (messages$UnreadCommand2 = Messages$UnreadCommand.getDefaultInstance())) {
                object = Messages$UnreadCommand.newBuilder(this.unreadMessage_);
                this.unreadMessage_ = messages$UnreadCommand = ((Messages$UnreadCommand$Builder)object).mergeFrom(messages$UnreadCommand).buildPartial();
            } else {
                this.unreadMessage_ = messages$UnreadCommand;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(messages$UnreadCommand);
        }
        this.bitField0_ = n10 = this.bitField0_ | n11;
        return this;
    }

    public Messages$GenericCommand$Builder setAckMessage(Messages$AckCommand$Builder messages$AckCommandOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.ackMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            messages$AckCommandOrBuilder = messages$AckCommandOrBuilder.build();
            this.ackMessage_ = messages$AckCommandOrBuilder;
            this.onChanged();
        } else {
            messages$AckCommandOrBuilder = messages$AckCommandOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)messages$AckCommandOrBuilder));
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x10000;
        return this;
    }

    public Messages$GenericCommand$Builder setAckMessage(Messages$AckCommand messages$AckCommand) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.ackMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(messages$AckCommand);
            this.ackMessage_ = messages$AckCommand;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(messages$AckCommand);
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x10000;
        return this;
    }

    public Messages$GenericCommand$Builder setAppId(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.appId_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$GenericCommand$Builder setAppIdBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.appId_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$GenericCommand$Builder setBlacklistMessage(Messages$BlacklistCommand$Builder messages$BlacklistCommandOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.blacklistMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            messages$BlacklistCommandOrBuilder = messages$BlacklistCommandOrBuilder.build();
            this.blacklistMessage_ = messages$BlacklistCommandOrBuilder;
            this.onChanged();
        } else {
            messages$BlacklistCommandOrBuilder = messages$BlacklistCommandOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)messages$BlacklistCommandOrBuilder));
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x8000000;
        return this;
    }

    public Messages$GenericCommand$Builder setBlacklistMessage(Messages$BlacklistCommand messages$BlacklistCommand) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.blacklistMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(messages$BlacklistCommand);
            this.blacklistMessage_ = messages$BlacklistCommand;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(messages$BlacklistCommand);
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x8000000;
        return this;
    }

    public Messages$GenericCommand$Builder setClientTs(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x200;
        this.clientTs_ = l10;
        this.onChanged();
        return this;
    }

    public Messages$GenericCommand$Builder setCmd(Messages$CommandType messages$CommandType) {
        int n10;
        int n11;
        Objects.requireNonNull(messages$CommandType);
        this.bitField0_ = n11 = this.bitField0_ | 1;
        this.cmd_ = n10 = messages$CommandType.getNumber();
        this.onChanged();
        return this;
    }

    public Messages$GenericCommand$Builder setConvMessage(Messages$ConvCommand$Builder messages$ConvCommandOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.convMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            messages$ConvCommandOrBuilder = messages$ConvCommandOrBuilder.build();
            this.convMessage_ = messages$ConvCommandOrBuilder;
            this.onChanged();
        } else {
            messages$ConvCommandOrBuilder = messages$ConvCommandOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)messages$ConvCommandOrBuilder));
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x200000;
        return this;
    }

    public Messages$GenericCommand$Builder setConvMessage(Messages$ConvCommand messages$ConvCommand) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.convMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(messages$ConvCommand);
            this.convMessage_ = messages$ConvCommand;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(messages$ConvCommand);
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x200000;
        return this;
    }

    public Messages$GenericCommand$Builder setDataMessage(Messages$DataCommand$Builder messages$DataCommandOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.dataMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            messages$DataCommandOrBuilder = messages$DataCommandOrBuilder.build();
            this.dataMessage_ = messages$DataCommandOrBuilder;
            this.onChanged();
        } else {
            messages$DataCommandOrBuilder = messages$DataCommandOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)messages$DataCommandOrBuilder));
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x1000;
        return this;
    }

    public Messages$GenericCommand$Builder setDataMessage(Messages$DataCommand messages$DataCommand) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.dataMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(messages$DataCommand);
            this.dataMessage_ = messages$DataCommand;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(messages$DataCommand);
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x1000;
        return this;
    }

    public Messages$GenericCommand$Builder setDirectMessage(Messages$DirectCommand$Builder messages$DirectCommandOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.directMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            messages$DirectCommandOrBuilder = messages$DirectCommandOrBuilder.build();
            this.directMessage_ = messages$DirectCommandOrBuilder;
            this.onChanged();
        } else {
            messages$DirectCommandOrBuilder = messages$DirectCommandOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)messages$DirectCommandOrBuilder));
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x8000;
        return this;
    }

    public Messages$GenericCommand$Builder setDirectMessage(Messages$DirectCommand messages$DirectCommand) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.directMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(messages$DirectCommand);
            this.directMessage_ = messages$DirectCommand;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(messages$DirectCommand);
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x8000;
        return this;
    }

    public Messages$GenericCommand$Builder setErrorMessage(Messages$ErrorCommand$Builder messages$ErrorCommandOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.errorMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            messages$ErrorCommandOrBuilder = messages$ErrorCommandOrBuilder.build();
            this.errorMessage_ = messages$ErrorCommandOrBuilder;
            this.onChanged();
        } else {
            messages$ErrorCommandOrBuilder = messages$ErrorCommandOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)messages$ErrorCommandOrBuilder));
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x4000;
        return this;
    }

    public Messages$GenericCommand$Builder setErrorMessage(Messages$ErrorCommand messages$ErrorCommand) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.errorMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(messages$ErrorCommand);
            this.errorMessage_ = messages$ErrorCommand;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(messages$ErrorCommand);
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x4000;
        return this;
    }

    public Messages$GenericCommand$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$GenericCommand$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Messages$GenericCommand$Builder setI(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 0x10;
        this.i_ = n10;
        this.onChanged();
        return this;
    }

    public Messages$GenericCommand$Builder setInstallationId(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x20;
        this.installationId_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$GenericCommand$Builder setInstallationIdBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x20;
        this.installationId_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$GenericCommand$Builder setLoggedinMessage(Messages$LoggedinCommand$Builder messages$LoggedinCommandOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.loggedinMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            messages$LoggedinCommandOrBuilder = messages$LoggedinCommandOrBuilder.build();
            this.loggedinMessage_ = messages$LoggedinCommandOrBuilder;
            this.onChanged();
        } else {
            messages$LoggedinCommandOrBuilder = messages$LoggedinCommandOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)messages$LoggedinCommandOrBuilder));
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x10000000;
        return this;
    }

    public Messages$GenericCommand$Builder setLoggedinMessage(Messages$LoggedinCommand messages$LoggedinCommand) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.loggedinMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(messages$LoggedinCommand);
            this.loggedinMessage_ = messages$LoggedinCommand;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(messages$LoggedinCommand);
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x10000000;
        return this;
    }

    public Messages$GenericCommand$Builder setLoginMessage(Messages$LoginCommand$Builder messages$LoginCommandOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.loginMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            messages$LoginCommandOrBuilder = messages$LoginCommandOrBuilder.build();
            this.loginMessage_ = messages$LoginCommandOrBuilder;
            this.onChanged();
        } else {
            messages$LoginCommandOrBuilder = messages$LoginCommandOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)messages$LoginCommandOrBuilder));
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x800;
        return this;
    }

    public Messages$GenericCommand$Builder setLoginMessage(Messages$LoginCommand messages$LoginCommand) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.loginMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(messages$LoginCommand);
            this.loginMessage_ = messages$LoginCommand;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(messages$LoginCommand);
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x800;
        return this;
    }

    public Messages$GenericCommand$Builder setLogsMessage(Messages$LogsCommand$Builder messages$LogsCommandOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.logsMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            messages$LogsCommandOrBuilder = messages$LogsCommandOrBuilder.build();
            this.logsMessage_ = messages$LogsCommandOrBuilder;
            this.onChanged();
        } else {
            messages$LogsCommandOrBuilder = messages$LogsCommandOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)messages$LogsCommandOrBuilder));
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x100000;
        return this;
    }

    public Messages$GenericCommand$Builder setLogsMessage(Messages$LogsCommand messages$LogsCommand) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.logsMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(messages$LogsCommand);
            this.logsMessage_ = messages$LogsCommand;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(messages$LogsCommand);
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x100000;
        return this;
    }

    public Messages$GenericCommand$Builder setNotificationType(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 0x400;
        this.notificationType_ = n10;
        this.onChanged();
        return this;
    }

    public Messages$GenericCommand$Builder setOp(Messages$OpType messages$OpType) {
        int n10;
        int n11;
        Objects.requireNonNull(messages$OpType);
        this.bitField0_ = n11 = this.bitField0_ | 2;
        this.op_ = n10 = messages$OpType.getNumber();
        this.onChanged();
        return this;
    }

    public Messages$GenericCommand$Builder setPatchMessage(Messages$PatchCommand$Builder messages$PatchCommandOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.patchMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            messages$PatchCommandOrBuilder = messages$PatchCommandOrBuilder.build();
            this.patchMessage_ = messages$PatchCommandOrBuilder;
            this.onChanged();
        } else {
            messages$PatchCommandOrBuilder = messages$PatchCommandOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)messages$PatchCommandOrBuilder));
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x2000000;
        return this;
    }

    public Messages$GenericCommand$Builder setPatchMessage(Messages$PatchCommand messages$PatchCommand) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.patchMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(messages$PatchCommand);
            this.patchMessage_ = messages$PatchCommand;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(messages$PatchCommand);
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x2000000;
        return this;
    }

    public Messages$GenericCommand$Builder setPeerId(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.peerId_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$GenericCommand$Builder setPeerIdBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.peerId_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$GenericCommand$Builder setPresenceMessage(Messages$PresenceCommand$Builder messages$PresenceCommandOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.presenceMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            messages$PresenceCommandOrBuilder = messages$PresenceCommandOrBuilder.build();
            this.presenceMessage_ = messages$PresenceCommandOrBuilder;
            this.onChanged();
        } else {
            messages$PresenceCommandOrBuilder = messages$PresenceCommandOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)messages$PresenceCommandOrBuilder));
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x800000;
        return this;
    }

    public Messages$GenericCommand$Builder setPresenceMessage(Messages$PresenceCommand messages$PresenceCommand) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.presenceMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(messages$PresenceCommand);
            this.presenceMessage_ = messages$PresenceCommand;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(messages$PresenceCommand);
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x800000;
        return this;
    }

    public Messages$GenericCommand$Builder setPriority(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 0x40;
        this.priority_ = n10;
        this.onChanged();
        return this;
    }

    public Messages$GenericCommand$Builder setPubsubMessage(Messages$PubsubCommand$Builder messages$PubsubCommandOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.pubsubMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            messages$PubsubCommandOrBuilder = messages$PubsubCommandOrBuilder.build();
            this.pubsubMessage_ = messages$PubsubCommandOrBuilder;
            this.onChanged();
        } else {
            messages$PubsubCommandOrBuilder = messages$PubsubCommandOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)messages$PubsubCommandOrBuilder));
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x4000000;
        return this;
    }

    public Messages$GenericCommand$Builder setPubsubMessage(Messages$PubsubCommand messages$PubsubCommand) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.pubsubMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(messages$PubsubCommand);
            this.pubsubMessage_ = messages$PubsubCommand;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(messages$PubsubCommand);
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x4000000;
        return this;
    }

    public Messages$GenericCommand$Builder setRcpMessage(Messages$RcpCommand$Builder messages$RcpCommandOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.rcpMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            messages$RcpCommandOrBuilder = messages$RcpCommandOrBuilder.build();
            this.rcpMessage_ = messages$RcpCommandOrBuilder;
            this.onChanged();
        } else {
            messages$RcpCommandOrBuilder = messages$RcpCommandOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)messages$RcpCommandOrBuilder));
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x80000;
        return this;
    }

    public Messages$GenericCommand$Builder setRcpMessage(Messages$RcpCommand messages$RcpCommand) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.rcpMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(messages$RcpCommand);
            this.rcpMessage_ = messages$RcpCommand;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(messages$RcpCommand);
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x80000;
        return this;
    }

    public Messages$GenericCommand$Builder setReadMessage(Messages$ReadCommand$Builder messages$ReadCommandOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.readMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            messages$ReadCommandOrBuilder = messages$ReadCommandOrBuilder.build();
            this.readMessage_ = messages$ReadCommandOrBuilder;
            this.onChanged();
        } else {
            messages$ReadCommandOrBuilder = messages$ReadCommandOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)messages$ReadCommandOrBuilder));
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x40000;
        return this;
    }

    public Messages$GenericCommand$Builder setReadMessage(Messages$ReadCommand messages$ReadCommand) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.readMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(messages$ReadCommand);
            this.readMessage_ = messages$ReadCommand;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(messages$ReadCommand);
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x40000;
        return this;
    }

    public Messages$GenericCommand$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Messages$GenericCommand$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public Messages$GenericCommand$Builder setReportMessage(Messages$ReportCommand$Builder messages$ReportCommandOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.reportMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            messages$ReportCommandOrBuilder = messages$ReportCommandOrBuilder.build();
            this.reportMessage_ = messages$ReportCommandOrBuilder;
            this.onChanged();
        } else {
            messages$ReportCommandOrBuilder = messages$ReportCommandOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)messages$ReportCommandOrBuilder));
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x1000000;
        return this;
    }

    public Messages$GenericCommand$Builder setReportMessage(Messages$ReportCommand messages$ReportCommand) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.reportMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(messages$ReportCommand);
            this.reportMessage_ = messages$ReportCommand;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(messages$ReportCommand);
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x1000000;
        return this;
    }

    public Messages$GenericCommand$Builder setRoomMessage(Messages$RoomCommand$Builder messages$RoomCommandOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.roomMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            messages$RoomCommandOrBuilder = messages$RoomCommandOrBuilder.build();
            this.roomMessage_ = messages$RoomCommandOrBuilder;
            this.onChanged();
        } else {
            messages$RoomCommandOrBuilder = messages$RoomCommandOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)messages$RoomCommandOrBuilder));
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x400000;
        return this;
    }

    public Messages$GenericCommand$Builder setRoomMessage(Messages$RoomCommand messages$RoomCommand) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.roomMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(messages$RoomCommand);
            this.roomMessage_ = messages$RoomCommand;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(messages$RoomCommand);
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x400000;
        return this;
    }

    public Messages$GenericCommand$Builder setServerTs(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x100;
        this.serverTs_ = l10;
        this.onChanged();
        return this;
    }

    public Messages$GenericCommand$Builder setService(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 0x80;
        this.service_ = n10;
        this.onChanged();
        return this;
    }

    public Messages$GenericCommand$Builder setSessionMessage(Messages$SessionCommand$Builder messages$SessionCommandOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.sessionMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            messages$SessionCommandOrBuilder = messages$SessionCommandOrBuilder.build();
            this.sessionMessage_ = messages$SessionCommandOrBuilder;
            this.onChanged();
        } else {
            messages$SessionCommandOrBuilder = messages$SessionCommandOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)messages$SessionCommandOrBuilder));
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x2000;
        return this;
    }

    public Messages$GenericCommand$Builder setSessionMessage(Messages$SessionCommand messages$SessionCommand) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.sessionMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(messages$SessionCommand);
            this.sessionMessage_ = messages$SessionCommand;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(messages$SessionCommand);
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x2000;
        return this;
    }

    public final Messages$GenericCommand$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$GenericCommand$Builder)super.setUnknownFields(unknownFieldSet);
    }

    public Messages$GenericCommand$Builder setUnreadMessage(Messages$UnreadCommand$Builder messages$UnreadCommandOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.unreadMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            messages$UnreadCommandOrBuilder = messages$UnreadCommandOrBuilder.build();
            this.unreadMessage_ = messages$UnreadCommandOrBuilder;
            this.onChanged();
        } else {
            messages$UnreadCommandOrBuilder = messages$UnreadCommandOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)messages$UnreadCommandOrBuilder));
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x20000;
        return this;
    }

    public Messages$GenericCommand$Builder setUnreadMessage(Messages$UnreadCommand messages$UnreadCommand) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.unreadMessageBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(messages$UnreadCommand);
            this.unreadMessage_ = messages$UnreadCommand;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(messages$UnreadCommand);
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x20000;
        return this;
    }
}

