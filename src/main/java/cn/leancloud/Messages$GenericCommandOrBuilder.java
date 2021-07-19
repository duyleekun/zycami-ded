/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages$AckCommand;
import cn.leancloud.Messages$AckCommandOrBuilder;
import cn.leancloud.Messages$BlacklistCommand;
import cn.leancloud.Messages$BlacklistCommandOrBuilder;
import cn.leancloud.Messages$CommandType;
import cn.leancloud.Messages$ConvCommand;
import cn.leancloud.Messages$ConvCommandOrBuilder;
import cn.leancloud.Messages$DataCommand;
import cn.leancloud.Messages$DataCommandOrBuilder;
import cn.leancloud.Messages$DirectCommand;
import cn.leancloud.Messages$DirectCommandOrBuilder;
import cn.leancloud.Messages$ErrorCommand;
import cn.leancloud.Messages$ErrorCommandOrBuilder;
import cn.leancloud.Messages$LoggedinCommand;
import cn.leancloud.Messages$LoggedinCommandOrBuilder;
import cn.leancloud.Messages$LoginCommand;
import cn.leancloud.Messages$LoginCommandOrBuilder;
import cn.leancloud.Messages$LogsCommand;
import cn.leancloud.Messages$LogsCommandOrBuilder;
import cn.leancloud.Messages$OpType;
import cn.leancloud.Messages$PatchCommand;
import cn.leancloud.Messages$PatchCommandOrBuilder;
import cn.leancloud.Messages$PresenceCommand;
import cn.leancloud.Messages$PresenceCommandOrBuilder;
import cn.leancloud.Messages$PubsubCommand;
import cn.leancloud.Messages$PubsubCommandOrBuilder;
import cn.leancloud.Messages$RcpCommand;
import cn.leancloud.Messages$RcpCommandOrBuilder;
import cn.leancloud.Messages$ReadCommand;
import cn.leancloud.Messages$ReadCommandOrBuilder;
import cn.leancloud.Messages$ReportCommand;
import cn.leancloud.Messages$ReportCommandOrBuilder;
import cn.leancloud.Messages$RoomCommand;
import cn.leancloud.Messages$RoomCommandOrBuilder;
import cn.leancloud.Messages$SessionCommand;
import cn.leancloud.Messages$SessionCommandOrBuilder;
import cn.leancloud.Messages$UnreadCommand;
import cn.leancloud.Messages$UnreadCommandOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface Messages$GenericCommandOrBuilder
extends MessageOrBuilder {
    public Messages$AckCommand getAckMessage();

    public Messages$AckCommandOrBuilder getAckMessageOrBuilder();

    public String getAppId();

    public ByteString getAppIdBytes();

    public Messages$BlacklistCommand getBlacklistMessage();

    public Messages$BlacklistCommandOrBuilder getBlacklistMessageOrBuilder();

    public long getClientTs();

    public Messages$CommandType getCmd();

    public Messages$ConvCommand getConvMessage();

    public Messages$ConvCommandOrBuilder getConvMessageOrBuilder();

    public Messages$DataCommand getDataMessage();

    public Messages$DataCommandOrBuilder getDataMessageOrBuilder();

    public Messages$DirectCommand getDirectMessage();

    public Messages$DirectCommandOrBuilder getDirectMessageOrBuilder();

    public Messages$ErrorCommand getErrorMessage();

    public Messages$ErrorCommandOrBuilder getErrorMessageOrBuilder();

    public int getI();

    public String getInstallationId();

    public ByteString getInstallationIdBytes();

    public Messages$LoggedinCommand getLoggedinMessage();

    public Messages$LoggedinCommandOrBuilder getLoggedinMessageOrBuilder();

    public Messages$LoginCommand getLoginMessage();

    public Messages$LoginCommandOrBuilder getLoginMessageOrBuilder();

    public Messages$LogsCommand getLogsMessage();

    public Messages$LogsCommandOrBuilder getLogsMessageOrBuilder();

    public int getNotificationType();

    public Messages$OpType getOp();

    public Messages$PatchCommand getPatchMessage();

    public Messages$PatchCommandOrBuilder getPatchMessageOrBuilder();

    public String getPeerId();

    public ByteString getPeerIdBytes();

    public Messages.PresenceCommand getPresenceMessage();

    public Messages.PresenceCommandOrBuilder getPresenceMessageOrBuilder();

    public int getPriority();

    public Messages.PubsubCommand getPubsubMessage();

    public Messages.PubsubCommandOrBuilder getPubsubMessageOrBuilder();

    public Messages$RcpCommand getRcpMessage();

    public Messages$RcpCommandOrBuilder getRcpMessageOrBuilder();

    public Messages.ReadCommand getReadMessage();

    public Messages.ReadCommandOrBuilder getReadMessageOrBuilder();

    public Messages.ReportCommand getReportMessage();

    public Messages.ReportCommandOrBuilder getReportMessageOrBuilder();

    public Messages.RoomCommand getRoomMessage();

    public Messages.RoomCommandOrBuilder getRoomMessageOrBuilder();

    public long getServerTs();

    public int getService();

    public Messages$SessionCommand getSessionMessage();

    public Messages$SessionCommandOrBuilder getSessionMessageOrBuilder();

    public Messages$UnreadCommand getUnreadMessage();

    public Messages$UnreadCommandOrBuilder getUnreadMessageOrBuilder();

    public boolean hasAckMessage();

    public boolean hasAppId();

    public boolean hasBlacklistMessage();

    public boolean hasClientTs();

    public boolean hasCmd();

    public boolean hasConvMessage();

    public boolean hasDataMessage();

    public boolean hasDirectMessage();

    public boolean hasErrorMessage();

    public boolean hasI();

    public boolean hasInstallationId();

    public boolean hasLoggedinMessage();

    public boolean hasLoginMessage();

    public boolean hasLogsMessage();

    public boolean hasNotificationType();

    public boolean hasOp();

    public boolean hasPatchMessage();

    public boolean hasPeerId();

    public boolean hasPresenceMessage();

    public boolean hasPriority();

    public boolean hasPubsubMessage();

    public boolean hasRcpMessage();

    public boolean hasReadMessage();

    public boolean hasReportMessage();

    public boolean hasRoomMessage();

    public boolean hasServerTs();

    public boolean hasService();

    public boolean hasSessionMessage();

    public boolean hasUnreadMessage();
}

