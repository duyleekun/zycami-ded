/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages$1;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Descriptors$FileDescriptor$InternalDescriptorAssigner;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;

public final class Messages {
    private static Descriptors$FileDescriptor descriptor;
    private static final Descriptors$Descriptor internal_static_cn_leancloud_AckCommand_descriptor;
    private static final GeneratedMessageV3$FieldAccessorTable internal_static_cn_leancloud_AckCommand_fieldAccessorTable;
    private static final Descriptors$Descriptor internal_static_cn_leancloud_AndroidVersion_descriptor;
    private static final GeneratedMessageV3$FieldAccessorTable internal_static_cn_leancloud_AndroidVersion_fieldAccessorTable;
    private static final Descriptors$Descriptor internal_static_cn_leancloud_BlacklistCommand_descriptor;
    private static final GeneratedMessageV3$FieldAccessorTable internal_static_cn_leancloud_BlacklistCommand_fieldAccessorTable;
    private static final Descriptors$Descriptor internal_static_cn_leancloud_ConvCommand_descriptor;
    private static final GeneratedMessageV3$FieldAccessorTable internal_static_cn_leancloud_ConvCommand_fieldAccessorTable;
    private static final Descriptors$Descriptor internal_static_cn_leancloud_ConvMemberInfo_descriptor;
    private static final GeneratedMessageV3$FieldAccessorTable internal_static_cn_leancloud_ConvMemberInfo_fieldAccessorTable;
    private static final Descriptors$Descriptor internal_static_cn_leancloud_DataCommand_descriptor;
    private static final GeneratedMessageV3$FieldAccessorTable internal_static_cn_leancloud_DataCommand_fieldAccessorTable;
    private static final Descriptors$Descriptor internal_static_cn_leancloud_DirectCommand_descriptor;
    private static final GeneratedMessageV3$FieldAccessorTable internal_static_cn_leancloud_DirectCommand_fieldAccessorTable;
    private static final Descriptors$Descriptor internal_static_cn_leancloud_ErrorCommand_descriptor;
    private static final GeneratedMessageV3$FieldAccessorTable internal_static_cn_leancloud_ErrorCommand_fieldAccessorTable;
    private static final Descriptors$Descriptor internal_static_cn_leancloud_GenericCommand_descriptor;
    private static final GeneratedMessageV3$FieldAccessorTable internal_static_cn_leancloud_GenericCommand_fieldAccessorTable;
    private static final Descriptors$Descriptor internal_static_cn_leancloud_JsonObjectMessage_descriptor;
    private static final GeneratedMessageV3$FieldAccessorTable internal_static_cn_leancloud_JsonObjectMessage_fieldAccessorTable;
    private static final Descriptors$Descriptor internal_static_cn_leancloud_LogItem_descriptor;
    private static final GeneratedMessageV3$FieldAccessorTable internal_static_cn_leancloud_LogItem_fieldAccessorTable;
    private static final Descriptors$Descriptor internal_static_cn_leancloud_LoggedinCommand_descriptor;
    private static final GeneratedMessageV3$FieldAccessorTable internal_static_cn_leancloud_LoggedinCommand_fieldAccessorTable;
    private static final Descriptors$Descriptor internal_static_cn_leancloud_LoginCommand_descriptor;
    private static final GeneratedMessageV3$FieldAccessorTable internal_static_cn_leancloud_LoginCommand_fieldAccessorTable;
    private static final Descriptors$Descriptor internal_static_cn_leancloud_LogsCommand_descriptor;
    private static final GeneratedMessageV3$FieldAccessorTable internal_static_cn_leancloud_LogsCommand_fieldAccessorTable;
    private static final Descriptors$Descriptor internal_static_cn_leancloud_MaxReadTuple_descriptor;
    private static final GeneratedMessageV3$FieldAccessorTable internal_static_cn_leancloud_MaxReadTuple_fieldAccessorTable;
    private static final Descriptors$Descriptor internal_static_cn_leancloud_PatchCommand_descriptor;
    private static final GeneratedMessageV3$FieldAccessorTable internal_static_cn_leancloud_PatchCommand_fieldAccessorTable;
    private static final Descriptors$Descriptor internal_static_cn_leancloud_PatchItem_descriptor;
    private static final GeneratedMessageV3$FieldAccessorTable internal_static_cn_leancloud_PatchItem_fieldAccessorTable;
    private static final Descriptors$Descriptor internal_static_cn_leancloud_PresenceCommand_descriptor;
    private static final GeneratedMessageV3$FieldAccessorTable internal_static_cn_leancloud_PresenceCommand_fieldAccessorTable;
    private static final Descriptors$Descriptor internal_static_cn_leancloud_PubsubCommand_descriptor;
    private static final GeneratedMessageV3$FieldAccessorTable internal_static_cn_leancloud_PubsubCommand_fieldAccessorTable;
    private static final Descriptors$Descriptor internal_static_cn_leancloud_RcpCommand_descriptor;
    private static final GeneratedMessageV3$FieldAccessorTable internal_static_cn_leancloud_RcpCommand_fieldAccessorTable;
    private static final Descriptors$Descriptor internal_static_cn_leancloud_ReadCommand_descriptor;
    private static final GeneratedMessageV3$FieldAccessorTable internal_static_cn_leancloud_ReadCommand_fieldAccessorTable;
    private static final Descriptors$Descriptor internal_static_cn_leancloud_ReadTuple_descriptor;
    private static final GeneratedMessageV3$FieldAccessorTable internal_static_cn_leancloud_ReadTuple_fieldAccessorTable;
    private static final Descriptors$Descriptor internal_static_cn_leancloud_ReportCommand_descriptor;
    private static final GeneratedMessageV3$FieldAccessorTable internal_static_cn_leancloud_ReportCommand_fieldAccessorTable;
    private static final Descriptors$Descriptor internal_static_cn_leancloud_RoomCommand_descriptor;
    private static final GeneratedMessageV3$FieldAccessorTable internal_static_cn_leancloud_RoomCommand_fieldAccessorTable;
    private static final Descriptors$Descriptor internal_static_cn_leancloud_SemanticVersion_descriptor;
    private static final GeneratedMessageV3$FieldAccessorTable internal_static_cn_leancloud_SemanticVersion_fieldAccessorTable;
    private static final Descriptors$Descriptor internal_static_cn_leancloud_SessionCommand_descriptor;
    private static final GeneratedMessageV3$FieldAccessorTable internal_static_cn_leancloud_SessionCommand_fieldAccessorTable;
    private static final Descriptors$Descriptor internal_static_cn_leancloud_SystemInfo_descriptor;
    private static final GeneratedMessageV3$FieldAccessorTable internal_static_cn_leancloud_SystemInfo_fieldAccessorTable;
    private static final Descriptors$Descriptor internal_static_cn_leancloud_UnreadCommand_descriptor;
    private static final GeneratedMessageV3$FieldAccessorTable internal_static_cn_leancloud_UnreadCommand_fieldAccessorTable;
    private static final Descriptors$Descriptor internal_static_cn_leancloud_UnreadTuple_descriptor;
    private static final GeneratedMessageV3$FieldAccessorTable internal_static_cn_leancloud_UnreadTuple_fieldAccessorTable;

    static {
        Object object = new String[]{"\n\u000emessages.proto\u0012\fcn.leancloud\"a\n\u000fSemanticVersion\u0012\r\n\u0005major\u0018\u0001 \u0001(\u0005\u0012\r\n\u0005minor\u0018\u0002 \u0001(\u0005\u0012\r\n\u0005patch\u0018\u0003 \u0001(\u0005\u0012\u0012\n\npreRelease\u0018\u0004 \u0001(\t\u0012\r\n\u0005build\u0018\u0005 \u0001(\t\"4\n\u000eAndroidVersion\u0012\u0010\n\bcodename\u0018\u0001 \u0001(\t\u0012\u0010\n\bapiLevel\u0018\u0002 \u0001(\t\"\u00b6\u0001\n\nSystemInfo\u0012,\n\ndeviceType\u0018\u0001 \u0001(\u000e2\u0018.cn.leancloud.DeviceType\u00120\n\tosVersion\u0018\u0002 \u0001(\u000b2\u001d.cn.leancloud.SemanticVersion\u00124\n\u000eandroidVersion\u0018\u0003 \u0001(\u000b2\u001c.cn.leancloud.AndroidVersion\u0012\u0012\n\nisEmulator\u0018\u0004 \u0001(\b\"!\n\u0011JsonObjectMessage\u0012\f\n\u0004data\u0018\u0001 ", "\u0002(\t\"\u00b6\u0001\n\u000bUnreadTuple\u0012\u000b\n\u0003cid\u0018\u0001 \u0002(\t\u0012\u000e\n\u0006unread\u0018\u0002 \u0002(\u0005\u0012\u000b\n\u0003mid\u0018\u0003 \u0001(\t\u0012\u0011\n\ttimestamp\u0018\u0004 \u0001(\u0003\u0012\f\n\u0004from\u0018\u0005 \u0001(\t\u0012\f\n\u0004data\u0018\u0006 \u0001(\t\u0012\u0016\n\u000epatchTimestamp\u0018\u0007 \u0001(\u0003\u0012\u0011\n\tmentioned\u0018\b \u0001(\b\u0012\u0011\n\tbinaryMsg\u0018\t \u0001(\f\u0012\u0010\n\bconvType\u0018\n \u0001(\u0005\"\u00c6\u0001\n\u0007LogItem\u0012\f\n\u0004from\u0018\u0001 \u0001(\t\u0012\f\n\u0004data\u0018\u0002 \u0001(\t\u0012\u0011\n\ttimestamp\u0018\u0003 \u0001(\u0003\u0012\r\n\u0005msgId\u0018\u0004 \u0001(\t\u0012\r\n\u0005ackAt\u0018\u0005 \u0001(\u0003\u0012\u000e\n\u0006readAt\u0018\u0006 \u0001(\u0003\u0012\u0016\n\u000epatchTimestamp\u0018\u0007 \u0001(\u0003\u0012\u0012\n\nmentionAll\u0018\b \u0001(\b\u0012\u0013\n\u000bmentionPids\u0018\t \u0003(\t\u0012\u000b\n\u0003bin\u0018\n \u0001(\b\u0012\u0010\n\bconvType\u0018\u000b \u0001(\u0005\";\n\u000eConvMem", "berInfo\u0012\u000b\n\u0003pid\u0018\u0001 \u0001(\t\u0012\f\n\u0004role\u0018\u0002 \u0001(\t\u0012\u000e\n\u0006infoId\u0018\u0003 \u0001(\t\"<\n\fLoginCommand\u0012,\n\nsystemInfo\u0018\u0001 \u0001(\u000b2\u0018.cn.leancloud.SystemInfo\"'\n\u000fLoggedinCommand\u0012\u0014\n\fpushDisabled\u0018\u0001 \u0001(\b\"Y\n\u000bDataCommand\u0012\u000b\n\u0003ids\u0018\u0001 \u0003(\t\u0012,\n\u0003msg\u0018\u0002 \u0003(\u000b2\u001f.cn.leancloud.JsonObjectMessage\u0012\u000f\n\u0007offline\u0018\u0003 \u0001(\b\"\u00ff\u0002\n\u000eSessionCommand\u0012\t\n\u0001t\u0018\u0001 \u0001(\u0003\u0012\t\n\u0001n\u0018\u0002 \u0001(\t\u0012\t\n\u0001s\u0018\u0003 \u0001(\t\u0012\n\n\u0002ua\u0018\u0004 \u0001(\t\u0012\t\n\u0001r\u0018\u0005 \u0001(\b\u0012\u000b\n\u0003tag\u0018\u0006 \u0001(\t\u0012\u0010\n\bdeviceId\u0018\u0007 \u0001(\t\u0012\u0016\n\u000esessionPeerIds\u0018\b \u0003(\t\u0012\u001c\n\u0014onlineSessionPeerIds\u0018\t", " \u0003(\t\u0012\n\n\u0002st\u0018\n \u0001(\t\u0012\r\n\u0005stTtl\u0018\u000b \u0001(\u0005\u0012\f\n\u0004code\u0018\f \u0001(\u0005\u0012\u000e\n\u0006reason\u0018\r \u0001(\t\u0012\u0013\n\u000bdeviceToken\u0018\u000e \u0001(\t\u0012\n\n\u0002sp\u0018\u000f \u0001(\b\u0012\u000e\n\u0006detail\u0018\u0010 \u0001(\t\u0012\u001b\n\u0013lastUnreadNotifTime\u0018\u0011 \u0001(\u0003\u0012\u0015\n\rlastPatchTime\u0018\u0012 \u0001(\u0003\u0012\u0014\n\fconfigBitmap\u0018\u0013 \u0001(\u0003\u0012,\n\nsystemInfo\u0018\u0014 \u0001(\u000b2\u0018.cn.leancloud.SystemInfo\"k\n\fErrorCommand\u0012\f\n\u0004code\u0018\u0001 \u0002(\u0005\u0012\u000e\n\u0006reason\u0018\u0002 \u0002(\t\u0012\u000f\n\u0007appCode\u0018\u0003 \u0001(\u0005\u0012\u000e\n\u0006detail\u0018\u0004 \u0001(\t\u0012\f\n\u0004pids\u0018\u0005 \u0003(\t\u0012\u000e\n\u0006appMsg\u0018\u0006 \u0001(\t\"\u00de\u0002\n\rDirectCommand\u0012\u000b\n\u0003msg\u0018\u0001 \u0001(\t\u0012\u000b\n\u0003uid\u0018\u0002 \u0001(\t\u0012\u0012\n\nfromPeerId\u0018\u0003 ", "\u0001(\t\u0012\u0011\n\ttimestamp\u0018\u0004 \u0001(\u0003\u0012\u000f\n\u0007offline\u0018\u0005 \u0001(\b\u0012\u000f\n\u0007hasMore\u0018\u0006 \u0001(\b\u0012\u0011\n\ttoPeerIds\u0018\u0007 \u0003(\t\u0012\t\n\u0001r\u0018\n \u0001(\b\u0012\u000b\n\u0003cid\u0018\u000b \u0001(\t\u0012\n\n\u0002id\u0018\f \u0001(\t\u0012\u0011\n\ttransient\u0018\r \u0001(\b\u0012\n\n\u0002dt\u0018\u000e \u0001(\t\u0012\u000e\n\u0006roomId\u0018\u000f \u0001(\t\u0012\u0010\n\bpushData\u0018\u0010 \u0001(\t\u0012\f\n\u0004will\u0018\u0011 \u0001(\b\u0012\u0016\n\u000epatchTimestamp\u0018\u0012 \u0001(\u0003\u0012\u0011\n\tbinaryMsg\u0018\u0013 \u0001(\f\u0012\u0013\n\u000bmentionPids\u0018\u0014 \u0003(\t\u0012\u0012\n\nmentionAll\u0018\u0015 \u0001(\b\u0012\u0010\n\bconvType\u0018\u0016 \u0001(\u0005\"\u00b6\u0001\n\nAckCommand\u0012\f\n\u0004code\u0018\u0001 \u0001(\u0005\u0012\u000e\n\u0006reason\u0018\u0002 \u0001(\t\u0012\u000b\n\u0003mid\u0018\u0003 \u0001(\t\u0012\u000b\n\u0003cid\u0018\u0004 \u0001(\t\u0012\t\n\u0001t\u0018\u0005 \u0001(\u0003\u0012\u000b\n\u0003uid\u0018\u0006 \u0001(\t\u0012\u000e\n\u0006fromts\u0018\u0007 ", "\u0001(\u0003\u0012\f\n\u0004tots\u0018\b \u0001(\u0003\u0012\f\n\u0004type\u0018\t \u0001(\t\u0012\u000b\n\u0003ids\u0018\n \u0003(\t\u0012\u000f\n\u0007appCode\u0018\u000b \u0001(\u0005\u0012\u000e\n\u0006appMsg\u0018\f \u0001(\t\"L\n\rUnreadCommand\u0012(\n\u0005convs\u0018\u0001 \u0003(\u000b2\u0019.cn.leancloud.UnreadTuple\u0012\u0011\n\tnotifTime\u0018\u0002 \u0001(\u0003\"\u00e4\u0006\n\u000bConvCommand\u0012\t\n\u0001m\u0018\u0001 \u0003(\t\u0012\u0011\n\ttransient\u0018\u0002 \u0001(\b\u0012\u000e\n\u0006unique\u0018\u0003 \u0001(\b\u0012\u000b\n\u0003cid\u0018\u0004 \u0001(\t\u0012\r\n\u0005cdate\u0018\u0005 \u0001(\t\u0012\u000e\n\u0006initBy\u0018\u0006 \u0001(\t\u0012\f\n\u0004sort\u0018\u0007 \u0001(\t\u0012\r\n\u0005limit\u0018\b \u0001(\u0005\u0012\f\n\u0004skip\u0018\t \u0001(\u0005\u0012\f\n\u0004flag\u0018\n \u0001(\u0005\u0012\r\n\u0005count\u0018\u000b \u0001(\u0005\u0012\r\n\u0005udate\u0018\f \u0001(\t\u0012\t\n\u0001t\u0018\r \u0001(\u0003\u0012\t\n\u0001n\u0018\u000e \u0001(\t\u0012\t\n\u0001s\u0018\u000f \u0001(\t\u0012\u0011\n\tstatusSub\u0018\u0010 \u0001(\b", "\u0012\u0011\n\tstatusPub\u0018\u0011 \u0001(\b\u0012\u0011\n\tstatusTTL\u0018\u0012 \u0001(\u0005\u0012\u0010\n\buniqueId\u0018\u0013 \u0001(\t\u0012\u0016\n\u000etargetClientId\u0018\u0014 \u0001(\t\u0012\u0018\n\u0010maxReadTimestamp\u0018\u0015 \u0001(\u0003\u0012\u0017\n\u000fmaxAckTimestamp\u0018\u0016 \u0001(\u0003\u0012\u0017\n\u000fqueryAllMembers\u0018\u0017 \u0001(\b\u00121\n\rmaxReadTuples\u0018\u0018 \u0003(\u000b2\u001a.cn.leancloud.MaxReadTuple\u0012\f\n\u0004cids\u0018\u0019 \u0003(\t\u0012*\n\u0004info\u0018\u001a \u0001(\u000b2\u001c.cn.leancloud.ConvMemberInfo\u0012\u0010\n\btempConv\u0018\u001b \u0001(\b\u0012\u0013\n\u000btempConvTTL\u0018\u001c \u0001(\u0005\u0012\u0013\n\u000btempConvIds\u0018\u001d \u0003(\t\u0012\u0013\n\u000ballowedPids\u0018\u001e \u0003(\t\u0012.\n\nfailedPids\u0018\u001f \u0003(\u000b2\u001a.cn.leancloud.ErrorCommand\u0012\u0010\n\bex", "isting\u0018  \u0001(\b\u0012\f\n\u0004next\u0018( \u0001(\t\u00120\n\u0007results\u0018d \u0001(\u000b2\u001f.cn.leancloud.JsonObjectMessage\u0012.\n\u0005where\u0018e \u0001(\u000b2\u001f.cn.leancloud.JsonObjectMessage\u0012-\n\u0004attr\u0018g \u0001(\u000b2\u001f.cn.leancloud.JsonObjectMessage\u00125\n\fattrModified\u0018h \u0001(\u000b2\u001f.cn.leancloud.JsonObjectMessage\"x\n\u000bRoomCommand\u0012\u000e\n\u0006roomId\u0018\u0001 \u0001(\t\u0012\t\n\u0001s\u0018\u0002 \u0001(\t\u0012\t\n\u0001t\u0018\u0003 \u0001(\u0003\u0012\t\n\u0001n\u0018\u0004 \u0001(\t\u0012\u0011\n\ttransient\u0018\u0005 \u0001(\b\u0012\u0013\n\u000broomPeerIds\u0018\u0006 \u0003(\t\u0012\u0010\n\bbyPeerId\u0018\u0007 \u0001(\t\"\u00ca\u0002\n\u000bLogsCommand\u0012\u000b\n\u0003cid\u0018\u0001 \u0001(\t\u0012\t\n\u0001l\u0018\u0002 \u0001(\u0005\u0012\r\n\u0005limit\u0018\u0003 ", "\u0001(\u0005\u0012\t\n\u0001t\u0018\u0004 \u0001(\u0003\u0012\n\n\u0002tt\u0018\u0005 \u0001(\u0003\u0012\f\n\u0004tmid\u0018\u0006 \u0001(\t\u0012\u000b\n\u0003mid\u0018\u0007 \u0001(\t\u0012\u0010\n\bchecksum\u0018\b \u0001(\t\u0012\u000e\n\u0006stored\u0018\t \u0001(\b\u0012@\n\tdirection\u0018\n \u0001(\u000e2(.cn.leancloud.LogsCommand.QueryDirection:\u0003OLD\u0012\u0011\n\ttIncluded\u0018\u000b \u0001(\b\u0012\u0012\n\nttIncluded\u0018\f \u0001(\b\u0012\u000e\n\u0006lctype\u0018\r \u0001(\u0005\u0012#\n\u0004logs\u0018i \u0003(\u000b2\u0015.cn.leancloud.LogItem\"\"\n\u000eQueryDirection\u0012\u0007\n\u0003OLD\u0010\u0001\u0012\u0007\n\u0003NEW\u0010\u0002\"L\n\nRcpCommand\u0012\n\n\u0002id\u0018\u0001 \u0001(\t\u0012\u000b\n\u0003cid\u0018\u0002 \u0001(\t\u0012\t\n\u0001t\u0018\u0003 \u0001(\u0003\u0012\f\n\u0004read\u0018\u0004 \u0001(\b\u0012\f\n\u0004from\u0018\u0005 \u0001(\t\"8\n\tReadTuple\u0012\u000b\n\u0003cid\u0018\u0001 \u0002(\t\u0012\u0011\n\ttimestamp\u0018\u0002", " \u0001(\u0003\u0012\u000b\n\u0003mid\u0018\u0003 \u0001(\t\"N\n\fMaxReadTuple\u0012\u000b\n\u0003pid\u0018\u0001 \u0001(\t\u0012\u0017\n\u000fmaxAckTimestamp\u0018\u0002 \u0001(\u0003\u0012\u0018\n\u0010maxReadTimestamp\u0018\u0003 \u0001(\u0003\"P\n\u000bReadCommand\u0012\u000b\n\u0003cid\u0018\u0001 \u0001(\t\u0012\f\n\u0004cids\u0018\u0002 \u0003(\t\u0012&\n\u0005convs\u0018\u0003 \u0003(\u000b2\u0017.cn.leancloud.ReadTuple\"`\n\u000fPresenceCommand\u0012(\n\u0006status\u0018\u0001 \u0001(\u000e2\u0018.cn.leancloud.StatusType\u0012\u0016\n\u000esessionPeerIds\u0018\u0002 \u0003(\t\u0012\u000b\n\u0003cid\u0018\u0003 \u0001(\t\"?\n\rReportCommand\u0012\u0012\n\ninitiative\u0018\u0001 \u0001(\b\u0012\f\n\u0004type\u0018\u0002 \u0001(\t\u0012\f\n\u0004data\u0018\u0003 \u0001(\t\"\u00e0\u0001\n\tPatchItem\u0012\u000b\n\u0003cid\u0018\u0001 \u0001(\t\u0012\u000b\n\u0003mid\u0018\u0002 \u0001(\t\u0012\u0011\n\ttimestamp\u0018\u0003 \u0001(", "\u0003\u0012\u000e\n\u0006recall\u0018\u0004 \u0001(\b\u0012\f\n\u0004data\u0018\u0005 \u0001(\t\u0012\u0016\n\u000epatchTimestamp\u0018\u0006 \u0001(\u0003\u0012\f\n\u0004from\u0018\u0007 \u0001(\t\u0012\u0011\n\tbinaryMsg\u0018\b \u0001(\f\u0012\u0012\n\nmentionAll\u0018\t \u0001(\b\u0012\u0013\n\u000bmentionPids\u0018\n \u0003(\t\u0012\u0011\n\tpatchCode\u0018\u000b \u0001(\u0003\u0012\u0013\n\u000bpatchReason\u0018\f \u0001(\t\"O\n\fPatchCommand\u0012(\n\u0007patches\u0018\u0001 \u0003(\u000b2\u0017.cn.leancloud.PatchItem\u0012\u0015\n\rlastPatchTime\u0018\u0002 \u0001(\u0003\"\u00a0\u0001\n\rPubsubCommand\u0012\u000b\n\u0003cid\u0018\u0001 \u0001(\t\u0012\f\n\u0004cids\u0018\u0002 \u0003(\t\u0012\r\n\u0005topic\u0018\u0003 \u0001(\t\u0012\u0010\n\bsubtopic\u0018\u0004 \u0001(\t\u0012\u000e\n\u0006topics\u0018\u0005 \u0003(\t\u0012\u0011\n\tsubtopics\u0018\u0006 \u0003(\t\u00120\n\u0007results\u0018\u0007 \u0001(\u000b2\u001f.cn.leancloud.Json", "ObjectMessage\"\u00ff\u0001\n\u0010BlacklistCommand\u0012\u000e\n\u0006srcCid\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006toPids\u0018\u0002 \u0003(\t\u0012\u000e\n\u0006srcPid\u0018\u0003 \u0001(\t\u0012\u000e\n\u0006toCids\u0018\u0004 \u0003(\t\u0012\r\n\u0005limit\u0018\u0005 \u0001(\u0005\u0012\f\n\u0004next\u0018\u0006 \u0001(\t\u0012\u0013\n\u000bblockedPids\u0018\b \u0003(\t\u0012\u0013\n\u000bblockedCids\u0018\t \u0003(\t\u0012\u0013\n\u000ballowedPids\u0018\n \u0003(\t\u0012.\n\nfailedPids\u0018\u000b \u0003(\u000b2\u001a.cn.leancloud.ErrorCommand\u0012\t\n\u0001t\u0018\f \u0001(\u0003\u0012\t\n\u0001n\u0018\r \u0001(\t\u0012\t\n\u0001s\u0018\u000e \u0001(\t\"\u008f\t\n\u000eGenericCommand\u0012&\n\u0003cmd\u0018\u0001 \u0001(\u000e2\u0019.cn.leancloud.CommandType\u0012 \n\u0002op\u0018\u0002 \u0001(\u000e2\u0014.cn.leancloud.OpType\u0012\r\n\u0005appId\u0018\u0003 \u0001(\t\u0012\u000e\n\u0006peerId\u0018\u0004 \u0001(\t\u0012\t\n\u0001i", "\u0018\u0005 \u0001(\u0005\u0012\u0016\n\u000einstallationId\u0018\u0006 \u0001(\t\u0012\u0010\n\bpriority\u0018\u0007 \u0001(\u0005\u0012\u000f\n\u0007service\u0018\b \u0001(\u0005\u0012\u0010\n\bserverTs\u0018\t \u0001(\u0003\u0012\u0010\n\bclientTs\u0018\n \u0001(\u0003\u0012\u0018\n\u0010notificationType\u0018\u000b \u0001(\u0005\u00120\n\floginMessage\u0018d \u0001(\u000b2\u001a.cn.leancloud.LoginCommand\u0012.\n\u000bdataMessage\u0018e \u0001(\u000b2\u0019.cn.leancloud.DataCommand\u00124\n\u000esessionMessage\u0018f \u0001(\u000b2\u001c.cn.leancloud.SessionCommand\u00120\n\ferrorMessage\u0018g \u0001(\u000b2\u001a.cn.leancloud.ErrorCommand\u00122\n\rdirectMessage\u0018h \u0001(\u000b2\u001b.cn.leancloud.DirectCommand\u0012,\n\nackMessage\u0018i \u0001(", "\u000b2\u0018.cn.leancloud.AckCommand\u00122\n\runreadMessage\u0018j \u0001(\u000b2\u001b.cn.leancloud.UnreadCommand\u0012.\n\u000breadMessage\u0018k \u0001(\u000b2\u0019.cn.leancloud.ReadCommand\u0012,\n\nrcpMessage\u0018l \u0001(\u000b2\u0018.cn.leancloud.RcpCommand\u0012.\n\u000blogsMessage\u0018m \u0001(\u000b2\u0019.cn.leancloud.LogsCommand\u0012.\n\u000bconvMessage\u0018n \u0001(\u000b2\u0019.cn.leancloud.ConvCommand\u0012.\n\u000broomMessage\u0018o \u0001(\u000b2\u0019.cn.leancloud.RoomCommand\u00126\n\u000fpresenceMessage\u0018p \u0001(\u000b2\u001d.cn.leancloud.PresenceCommand\u00122\n\rreportMessage\u0018q \u0001(\u000b2\u001b.c", "n.leancloud.ReportCommand\u00120\n\fpatchMessage\u0018r \u0001(\u000b2\u001a.cn.leancloud.PatchCommand\u00122\n\rpubsubMessage\u0018s \u0001(\u000b2\u001b.cn.leancloud.PubsubCommand\u00128\n\u0010blacklistMessage\u0018t \u0001(\u000b2\u001e.cn.leancloud.BlacklistCommand\u00126\n\u000floggedinMessage\u0018u \u0001(\u000b2\u001d.cn.leancloud.LoggedinCommand*\u008b\u0002\n\u000bCommandType\u0012\u000b\n\u0007session\u0010\u0000\u0012\b\n\u0004conv\u0010\u0001\u0012\n\n\u0006direct\u0010\u0002\u0012\u0007\n\u0003ack\u0010\u0003\u0012\u0007\n\u0003rcp\u0010\u0004\u0012\n\n\u0006unread\u0010\u0005\u0012\b\n\u0004logs\u0010\u0006\u0012\t\n\u0005error\u0010\u0007\u0012\t\n\u0005login\u0010\b\u0012\b\n\u0004data\u0010\t\u0012\b\n\u0004room\u0010\n\u0012\b\n\u0004read\u0010\u000b\u0012\f\n\bpresence\u0010\f\u0012\n", "\n\u0006report\u0010\r\u0012\b\n\u0004echo\u0010\u000e\u0012\f\n\bloggedin\u0010\u000f\u0012\n\n\u0006logout\u0010\u0010\u0012\r\n\tloggedout\u0010\u0011\u0012\t\n\u0005patch\u0010\u0012\u0012\n\n\u0006pubsub\u0010\u0013\u0012\r\n\tblacklist\u0010\u0014\u0012\n\n\u0006goaway\u0010\u0015*\u008d\b\n\u0006OpType\u0012\b\n\u0004open\u0010\u0001\u0012\u0007\n\u0003add\u0010\u0002\u0012\n\n\u0006remove\u0010\u0003\u0012\t\n\u0005close\u0010\u0004\u0012\n\n\u0006opened\u0010\u0005\u0012\n\n\u0006closed\u0010\u0006\u0012\t\n\u0005query\u0010\u0007\u0012\u0010\n\fquery_result\u0010\b\u0012\f\n\bconflict\u0010\t\u0012\t\n\u0005added\u0010\n\u0012\u000b\n\u0007removed\u0010\u000b\u0012\u000b\n\u0007refresh\u0010\f\u0012\r\n\trefreshed\u0010\r\u0012\t\n\u0005start\u0010\u001e\u0012\u000b\n\u0007started\u0010\u001f\u0012\n\n\u0006joined\u0010 \u0012\u0012\n\u000emembers_joined\u0010!\u0012\b\n\u0004left\u0010'\u0012\u0010\n\fmembers_left\u0010(\u0012\u000b\n\u0007results\u0010*\u0012\t\n\u0005count\u0010+\u0012\n\n\u0006resul", "t\u0010,\u0012\n\n\u0006update\u0010-\u0012\u000b\n\u0007updated\u0010.\u0012\b\n\u0004mute\u0010/\u0012\n\n\u0006unmute\u00100\u0012\n\n\u0006status\u00101\u0012\u000b\n\u0007members\u00102\u0012\f\n\bmax_read\u00103\u0012\r\n\tis_member\u00104\u0012\u0016\n\u0012member_info_update\u00105\u0012\u0017\n\u0013member_info_updated\u00106\u0012\u0017\n\u0013member_info_changed\u00107\u0012\b\n\u0004join\u0010P\u0012\n\n\u0006invite\u0010Q\u0012\t\n\u0005leave\u0010R\u0012\b\n\u0004kick\u0010S\u0012\n\n\u0006reject\u0010T\u0012\u000b\n\u0007invited\u0010U\u0012\n\n\u0006kicked\u0010V\u0012\n\n\u0006upload\u0010d\u0012\f\n\buploaded\u0010e\u0012\r\n\tsubscribe\u0010x\u0012\u000e\n\nsubscribed\u0010y\u0012\u000f\n\u000bunsubscribe\u0010z\u0012\u0010\n\funsubscribed\u0010{\u0012\u0011\n\ris_subscribed\u0010|\u0012\u000b\n\u0006modify\u0010\u0096\u0001\u0012\r\n\bmodified\u0010\u0097\u0001\u0012\n\n", "\u0005block\u0010\u00aa\u0001\u0012\f\n\u0007unblock\u0010\u00ab\u0001\u0012\f\n\u0007blocked\u0010\u00ac\u0001\u0012\u000e\n\tunblocked\u0010\u00ad\u0001\u0012\u0014\n\u000fmembers_blocked\u0010\u00ae\u0001\u0012\u0016\n\u0011members_unblocked\u0010\u00af\u0001\u0012\u0010\n\u000bcheck_block\u0010\u00b0\u0001\u0012\u0011\n\fcheck_result\u0010\u00b1\u0001\u0012\u000f\n\nadd_shutup\u0010\u00b4\u0001\u0012\u0012\n\rremove_shutup\u0010\u00b5\u0001\u0012\u0011\n\fquery_shutup\u0010\u00b6\u0001\u0012\u0011\n\fshutup_added\u0010\u00b7\u0001\u0012\u0013\n\u000eshutup_removed\u0010\u00b8\u0001\u0012\u0012\n\rshutup_result\u0010\u00b9\u0001\u0012\r\n\bshutuped\u0010\u00ba\u0001\u0012\u000f\n\nunshutuped\u0010\u00bb\u0001\u0012\u0015\n\u0010members_shutuped\u0010\u00bc\u0001\u0012\u0017\n\u0012members_unshutuped\u0010\u00bd\u0001\u0012\u0011\n\fcheck_shutup\u0010\u00be\u0001*\u001d\n\nStatusType\u0012\u0006\n\u0002on\u0010\u0001\u0012\u0007\n\u0003off\u0010\u0002*/\n\nDeviceType\u0012\u000b\n\u0007", "unknown\u0010\u0000\u0012\u000b\n\u0007android\u0010\u0001\u0012\u0007\n\u0003ios\u0010\u0002B\u0007\u00a2\u0002\u0004AVIM"};
        Object object2 = new Messages$1();
        Object object3 = new Descriptors$FileDescriptor[]{};
        Descriptors$FileDescriptor.internalBuildGeneratedFileFrom(object, (Descriptors$FileDescriptor[])object3, (Descriptors$FileDescriptor$InternalDescriptorAssigner)object2);
        internal_static_cn_leancloud_SemanticVersion_descriptor = object = (Descriptors$Descriptor)Messages.getDescriptor().getMessageTypes().get(0);
        String[] stringArray = new String[]{"Major", "Minor", "Patch", "PreRelease", "Build"};
        internal_static_cn_leancloud_SemanticVersion_fieldAccessorTable = object2 = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, stringArray);
        internal_static_cn_leancloud_AndroidVersion_descriptor = object = (Descriptors$Descriptor)Messages.getDescriptor().getMessageTypes().get(1);
        stringArray = new String[]{"Codename", "ApiLevel"};
        internal_static_cn_leancloud_AndroidVersion_fieldAccessorTable = object2 = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, stringArray);
        internal_static_cn_leancloud_SystemInfo_descriptor = object = (Descriptors$Descriptor)Messages.getDescriptor().getMessageTypes().get(2);
        stringArray = new String[]{"DeviceType", "OsVersion", "AndroidVersion", "IsEmulator"};
        internal_static_cn_leancloud_SystemInfo_fieldAccessorTable = object2 = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, stringArray);
        internal_static_cn_leancloud_JsonObjectMessage_descriptor = object = (Descriptors$Descriptor)Messages.getDescriptor().getMessageTypes().get(3);
        stringArray = "Data";
        object3 = new String[]{stringArray};
        internal_static_cn_leancloud_JsonObjectMessage_fieldAccessorTable = object2 = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, (String[])object3);
        internal_static_cn_leancloud_UnreadTuple_descriptor = object = (Descriptors$Descriptor)Messages.getDescriptor().getMessageTypes().get(4);
        object3 = new String[]{"Cid", "Unread", "Mid", "Timestamp", "From", "Data", "PatchTimestamp", "Mentioned", "BinaryMsg", "ConvType"};
        internal_static_cn_leancloud_UnreadTuple_fieldAccessorTable = object2 = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, (String[])object3);
        internal_static_cn_leancloud_LogItem_descriptor = object = (Descriptors$Descriptor)Messages.getDescriptor().getMessageTypes().get(5);
        object3 = new String[]{"From", "Data", "Timestamp", "MsgId", "AckAt", "ReadAt", "PatchTimestamp", "MentionAll", "MentionPids", "Bin", "ConvType"};
        internal_static_cn_leancloud_LogItem_fieldAccessorTable = object2 = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, (String[])object3);
        internal_static_cn_leancloud_ConvMemberInfo_descriptor = object = (Descriptors$Descriptor)Messages.getDescriptor().getMessageTypes().get(6);
        object3 = "Pid";
        Object object4 = new String[]{object3, "Role", "InfoId"};
        internal_static_cn_leancloud_ConvMemberInfo_fieldAccessorTable = object2 = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, (String[])object4);
        internal_static_cn_leancloud_LoginCommand_descriptor = object = (Descriptors$Descriptor)Messages.getDescriptor().getMessageTypes().get(7);
        object4 = new String[]{"SystemInfo"};
        internal_static_cn_leancloud_LoginCommand_fieldAccessorTable = object2 = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, (String[])object4);
        internal_static_cn_leancloud_LoggedinCommand_descriptor = object = (Descriptors$Descriptor)Messages.getDescriptor().getMessageTypes().get(8);
        object4 = new String[]{"PushDisabled"};
        internal_static_cn_leancloud_LoggedinCommand_fieldAccessorTable = object2 = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, (String[])object4);
        internal_static_cn_leancloud_DataCommand_descriptor = object = (Descriptors$Descriptor)Messages.getDescriptor().getMessageTypes().get(9);
        object4 = new String[]{"Ids", "Msg", "Offline"};
        internal_static_cn_leancloud_DataCommand_fieldAccessorTable = object2 = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, (String[])object4);
        internal_static_cn_leancloud_SessionCommand_descriptor = object = (Descriptors$Descriptor)Messages.getDescriptor().getMessageTypes().get(10);
        object4 = new String[]{"T", "N", "S", "Ua", "R", "Tag", "DeviceId", "SessionPeerIds", "OnlineSessionPeerIds", "St", "StTtl", "Code", "Reason", "DeviceToken", "Sp", "Detail", "LastUnreadNotifTime", "LastPatchTime", "ConfigBitmap", "SystemInfo"};
        internal_static_cn_leancloud_SessionCommand_fieldAccessorTable = object2 = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, (String[])object4);
        internal_static_cn_leancloud_ErrorCommand_descriptor = object = (Descriptors$Descriptor)Messages.getDescriptor().getMessageTypes().get(11);
        object4 = new String[]{"Code", "Reason", "AppCode", "Detail", "Pids", "AppMsg"};
        internal_static_cn_leancloud_ErrorCommand_fieldAccessorTable = object2 = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, (String[])object4);
        internal_static_cn_leancloud_DirectCommand_descriptor = object = (Descriptors$Descriptor)Messages.getDescriptor().getMessageTypes().get(12);
        object4 = new String[]{"Msg", "Uid", "FromPeerId", "Timestamp", "Offline", "HasMore", "ToPeerIds", "R", "Cid", "Id", "Transient", "Dt", "RoomId", "PushData", "Will", "PatchTimestamp", "BinaryMsg", "MentionPids", "MentionAll", "ConvType"};
        internal_static_cn_leancloud_DirectCommand_fieldAccessorTable = object2 = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, (String[])object4);
        internal_static_cn_leancloud_AckCommand_descriptor = object = (Descriptors$Descriptor)Messages.getDescriptor().getMessageTypes().get(13);
        object4 = new String[]{"Code", "Reason", "Mid", "Cid", "T", "Uid", "Fromts", "Tots", "Type", "Ids", "AppCode", "AppMsg"};
        internal_static_cn_leancloud_AckCommand_fieldAccessorTable = object2 = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, (String[])object4);
        internal_static_cn_leancloud_UnreadCommand_descriptor = object = (Descriptors$Descriptor)Messages.getDescriptor().getMessageTypes().get(14);
        object4 = "Convs";
        String[] stringArray2 = new String[]{object4, "NotifTime"};
        internal_static_cn_leancloud_UnreadCommand_fieldAccessorTable = object2 = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, stringArray2);
        internal_static_cn_leancloud_ConvCommand_descriptor = object = (Descriptors$Descriptor)Messages.getDescriptor().getMessageTypes().get(15);
        stringArray2 = new String[]{"M", "Transient", "Unique", "Cid", "Cdate", "InitBy", "Sort", "Limit", "Skip", "Flag", "Count", "Udate", "T", "N", "S", "StatusSub", "StatusPub", "StatusTTL", "UniqueId", "TargetClientId", "MaxReadTimestamp", "MaxAckTimestamp", "QueryAllMembers", "MaxReadTuples", "Cids", "Info", "TempConv", "TempConvTTL", "TempConvIds", "AllowedPids", "FailedPids", "Existing", "Next", "Results", "Where", "Attr", "AttrModified"};
        internal_static_cn_leancloud_ConvCommand_fieldAccessorTable = object2 = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, stringArray2);
        internal_static_cn_leancloud_RoomCommand_descriptor = object = (Descriptors$Descriptor)Messages.getDescriptor().getMessageTypes().get(16);
        stringArray2 = new String[]{"RoomId", "S", "T", "N", "Transient", "RoomPeerIds", "ByPeerId"};
        internal_static_cn_leancloud_RoomCommand_fieldAccessorTable = object2 = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, stringArray2);
        internal_static_cn_leancloud_LogsCommand_descriptor = object = (Descriptors$Descriptor)Messages.getDescriptor().getMessageTypes().get(17);
        stringArray2 = new String[]{"Cid", "L", "Limit", "T", "Tt", "Tmid", "Mid", "Checksum", "Stored", "Direction", "TIncluded", "TtIncluded", "Lctype", "Logs"};
        internal_static_cn_leancloud_LogsCommand_fieldAccessorTable = object2 = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, stringArray2);
        internal_static_cn_leancloud_RcpCommand_descriptor = object = (Descriptors$Descriptor)Messages.getDescriptor().getMessageTypes().get(18);
        String string2 = "Cid";
        stringArray2 = new String[]{"Id", string2, "T", "Read", "From"};
        internal_static_cn_leancloud_RcpCommand_fieldAccessorTable = object2 = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, stringArray2);
        internal_static_cn_leancloud_ReadTuple_descriptor = object = (Descriptors$Descriptor)Messages.getDescriptor().getMessageTypes().get(19);
        stringArray2 = new String[]{string2, "Timestamp", "Mid"};
        internal_static_cn_leancloud_ReadTuple_fieldAccessorTable = object2 = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, stringArray2);
        internal_static_cn_leancloud_MaxReadTuple_descriptor = object = (Descriptors$Descriptor)Messages.getDescriptor().getMessageTypes().get(20);
        object3 = new String[]{object3, "MaxAckTimestamp", "MaxReadTimestamp"};
        internal_static_cn_leancloud_MaxReadTuple_fieldAccessorTable = object2 = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, (String[])object3);
        internal_static_cn_leancloud_ReadCommand_descriptor = object = (Descriptors$Descriptor)Messages.getDescriptor().getMessageTypes().get(21);
        object3 = new String[]{string2, "Cids", object4};
        internal_static_cn_leancloud_ReadCommand_fieldAccessorTable = object2 = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, (String[])object3);
        internal_static_cn_leancloud_PresenceCommand_descriptor = object = (Descriptors$Descriptor)Messages.getDescriptor().getMessageTypes().get(22);
        object3 = new String[]{"Status", "SessionPeerIds", string2};
        internal_static_cn_leancloud_PresenceCommand_fieldAccessorTable = object2 = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, (String[])object3);
        internal_static_cn_leancloud_ReportCommand_descriptor = object = (Descriptors$Descriptor)Messages.getDescriptor().getMessageTypes().get(23);
        stringArray = new String[]{"Initiative", "Type", stringArray};
        internal_static_cn_leancloud_ReportCommand_fieldAccessorTable = object2 = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, stringArray);
        internal_static_cn_leancloud_PatchItem_descriptor = object = (Descriptors$Descriptor)Messages.getDescriptor().getMessageTypes().get(24);
        stringArray = new String[]{"Cid", "Mid", "Timestamp", "Recall", "Data", "PatchTimestamp", "From", "BinaryMsg", "MentionAll", "MentionPids", "PatchCode", "PatchReason"};
        internal_static_cn_leancloud_PatchItem_fieldAccessorTable = object2 = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, stringArray);
        internal_static_cn_leancloud_PatchCommand_descriptor = object = (Descriptors$Descriptor)Messages.getDescriptor().getMessageTypes().get(25);
        stringArray = new String[]{"Patches", "LastPatchTime"};
        internal_static_cn_leancloud_PatchCommand_fieldAccessorTable = object2 = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, stringArray);
        internal_static_cn_leancloud_PubsubCommand_descriptor = object = (Descriptors$Descriptor)Messages.getDescriptor().getMessageTypes().get(26);
        stringArray = new String[]{"Cid", "Cids", "Topic", "Subtopic", "Topics", "Subtopics", "Results"};
        internal_static_cn_leancloud_PubsubCommand_fieldAccessorTable = object2 = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, stringArray);
        internal_static_cn_leancloud_BlacklistCommand_descriptor = object = (Descriptors$Descriptor)Messages.getDescriptor().getMessageTypes().get(27);
        stringArray = new String[]{"SrcCid", "ToPids", "SrcPid", "ToCids", "Limit", "Next", "BlockedPids", "BlockedCids", "AllowedPids", "FailedPids", "T", "N", "S"};
        internal_static_cn_leancloud_BlacklistCommand_fieldAccessorTable = object2 = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, stringArray);
        internal_static_cn_leancloud_GenericCommand_descriptor = object = (Descriptors$Descriptor)Messages.getDescriptor().getMessageTypes().get(28);
        stringArray = new String[]{"Cmd", "Op", "AppId", "PeerId", "I", "InstallationId", "Priority", "Service", "ServerTs", "ClientTs", "NotificationType", "LoginMessage", "DataMessage", "SessionMessage", "ErrorMessage", "DirectMessage", "AckMessage", "UnreadMessage", "ReadMessage", "RcpMessage", "LogsMessage", "ConvMessage", "RoomMessage", "PresenceMessage", "ReportMessage", "PatchMessage", "PubsubMessage", "BlacklistMessage", "LoggedinMessage"};
        internal_static_cn_leancloud_GenericCommand_fieldAccessorTable = object2 = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, stringArray);
    }

    private Messages() {
    }

    public static /* synthetic */ Descriptors$Descriptor access$000() {
        return internal_static_cn_leancloud_SemanticVersion_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3$FieldAccessorTable access$100() {
        return internal_static_cn_leancloud_SemanticVersion_fieldAccessorTable;
    }

    public static /* synthetic */ GeneratedMessageV3$FieldAccessorTable access$10000() {
        return internal_static_cn_leancloud_LoginCommand_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors$Descriptor access$10900() {
        return internal_static_cn_leancloud_LoggedinCommand_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3$FieldAccessorTable access$11000() {
        return internal_static_cn_leancloud_LoggedinCommand_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors$Descriptor access$11900() {
        return internal_static_cn_leancloud_DataCommand_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3$FieldAccessorTable access$12000() {
        return internal_static_cn_leancloud_DataCommand_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors$Descriptor access$13200() {
        return internal_static_cn_leancloud_SessionCommand_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3$FieldAccessorTable access$13300() {
        return internal_static_cn_leancloud_SessionCommand_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors$Descriptor access$1400() {
        return internal_static_cn_leancloud_AndroidVersion_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3$FieldAccessorTable access$1500() {
        return internal_static_cn_leancloud_AndroidVersion_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors$Descriptor access$16100() {
        return internal_static_cn_leancloud_ErrorCommand_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3$FieldAccessorTable access$16200() {
        return internal_static_cn_leancloud_ErrorCommand_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors$Descriptor access$17600() {
        return internal_static_cn_leancloud_DirectCommand_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3$FieldAccessorTable access$17700() {
        return internal_static_cn_leancloud_DirectCommand_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors$Descriptor access$20500() {
        return internal_static_cn_leancloud_AckCommand_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3$FieldAccessorTable access$20600() {
        return internal_static_cn_leancloud_AckCommand_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors$Descriptor access$22600() {
        return internal_static_cn_leancloud_UnreadCommand_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3$FieldAccessorTable access$22700() {
        return internal_static_cn_leancloud_UnreadCommand_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors$Descriptor access$23800() {
        return internal_static_cn_leancloud_ConvCommand_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3$FieldAccessorTable access$23900() {
        return internal_static_cn_leancloud_ConvCommand_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors$Descriptor access$2500() {
        return internal_static_cn_leancloud_SystemInfo_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3$FieldAccessorTable access$2600() {
        return internal_static_cn_leancloud_SystemInfo_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors$Descriptor access$28600() {
        return internal_static_cn_leancloud_RoomCommand_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3$FieldAccessorTable access$28700() {
        return internal_static_cn_leancloud_RoomCommand_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors$Descriptor access$30200() {
        return internal_static_cn_leancloud_LogsCommand_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3$FieldAccessorTable access$30300() {
        return internal_static_cn_leancloud_LogsCommand_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors$Descriptor access$32600() {
        return internal_static_cn_leancloud_RcpCommand_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3$FieldAccessorTable access$32700() {
        return internal_static_cn_leancloud_RcpCommand_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors$Descriptor access$34000() {
        return internal_static_cn_leancloud_ReadTuple_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3$FieldAccessorTable access$34100() {
        return internal_static_cn_leancloud_ReadTuple_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors$Descriptor access$35200() {
        return internal_static_cn_leancloud_MaxReadTuple_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3$FieldAccessorTable access$35300() {
        return internal_static_cn_leancloud_MaxReadTuple_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors$Descriptor access$36400() {
        return internal_static_cn_leancloud_ReadCommand_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3$FieldAccessorTable access$36500() {
        return internal_static_cn_leancloud_ReadCommand_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors$Descriptor access$37700() {
        return internal_static_cn_leancloud_PresenceCommand_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3$FieldAccessorTable access$37800() {
        return internal_static_cn_leancloud_PresenceCommand_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors$Descriptor access$3800() {
        return internal_static_cn_leancloud_JsonObjectMessage_descriptor;
    }

    public static /* synthetic */ Descriptors$Descriptor access$38900() {
        return internal_static_cn_leancloud_ReportCommand_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3$FieldAccessorTable access$3900() {
        return internal_static_cn_leancloud_JsonObjectMessage_fieldAccessorTable;
    }

    public static /* synthetic */ GeneratedMessageV3$FieldAccessorTable access$39000() {
        return internal_static_cn_leancloud_ReportCommand_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors$Descriptor access$40100() {
        return internal_static_cn_leancloud_PatchItem_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3$FieldAccessorTable access$40200() {
        return internal_static_cn_leancloud_PatchItem_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors$Descriptor access$42200() {
        return internal_static_cn_leancloud_PatchCommand_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3$FieldAccessorTable access$42300() {
        return internal_static_cn_leancloud_PatchCommand_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors$Descriptor access$43400() {
        return internal_static_cn_leancloud_PubsubCommand_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3$FieldAccessorTable access$43500() {
        return internal_static_cn_leancloud_PubsubCommand_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors$Descriptor access$45000() {
        return internal_static_cn_leancloud_BlacklistCommand_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3$FieldAccessorTable access$45100() {
        return internal_static_cn_leancloud_BlacklistCommand_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors$Descriptor access$47300() {
        return internal_static_cn_leancloud_GenericCommand_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3$FieldAccessorTable access$47400() {
        return internal_static_cn_leancloud_GenericCommand_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors$Descriptor access$4800() {
        return internal_static_cn_leancloud_UnreadTuple_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3$FieldAccessorTable access$4900() {
        return internal_static_cn_leancloud_UnreadTuple_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors$FileDescriptor access$51102(Descriptors$FileDescriptor fileDescriptor) {
        descriptor = fileDescriptor;
        return fileDescriptor;
    }

    public static /* synthetic */ Descriptors$Descriptor access$6700() {
        return internal_static_cn_leancloud_LogItem_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3$FieldAccessorTable access$6800() {
        return internal_static_cn_leancloud_LogItem_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors$Descriptor access$8700() {
        return internal_static_cn_leancloud_ConvMemberInfo_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3$FieldAccessorTable access$8800() {
        return internal_static_cn_leancloud_ConvMemberInfo_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors$Descriptor access$9900() {
        return internal_static_cn_leancloud_LoginCommand_descriptor;
    }

    public static Descriptors$FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        Messages.registerAllExtensions((ExtensionRegistryLite)extensionRegistry);
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}

