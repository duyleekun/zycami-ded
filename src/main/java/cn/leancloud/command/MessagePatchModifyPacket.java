/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.command;

import cn.leancloud.Messages$GenericCommand$Builder;
import cn.leancloud.Messages$OpType;
import cn.leancloud.Messages$PatchCommand;
import cn.leancloud.Messages$PatchCommand$Builder;
import cn.leancloud.Messages$PatchItem;
import cn.leancloud.Messages$PatchItemOrBuilder;
import cn.leancloud.command.PeerBasedCommandPacket;
import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.utils.StringUtil;
import com.google.protobuf.ByteString;
import java.util.List;

public class MessagePatchModifyPacket
extends PeerBasedCommandPacket {
    private ByteString binaryData = null;
    private String conversationId;
    private boolean isRecall;
    private boolean mentionAll;
    private List mentionList;
    private String messageData;
    private String messageId;
    private long timestamp;

    public MessagePatchModifyPacket() {
        this.setCmd("patch");
    }

    public static MessagePatchModifyPacket getMessagePatchPacketForRecall(String string2, String string3, String string4, long l10, int n10) {
        int n11;
        MessagePatchModifyPacket messagePatchModifyPacket = new MessagePatchModifyPacket();
        messagePatchModifyPacket.conversationId = string3;
        messagePatchModifyPacket.messageId = string4;
        messagePatchModifyPacket.timestamp = l10;
        messagePatchModifyPacket.isRecall = n11 = 1;
        messagePatchModifyPacket.setRequestId(n10);
        int n12 = AVIMClient.getClientsCount();
        if (n12 > n11) {
            messagePatchModifyPacket.setPeerId(string2);
        }
        return messagePatchModifyPacket;
    }

    public static MessagePatchModifyPacket getMessagePatchPacketForUpdate(String string2, String object, String string3, String string4, byte[] byArray, boolean bl2, List list, long l10, int n10) {
        MessagePatchModifyPacket messagePatchModifyPacket = new MessagePatchModifyPacket();
        messagePatchModifyPacket.conversationId = object;
        messagePatchModifyPacket.messageId = string3;
        messagePatchModifyPacket.timestamp = l10;
        messagePatchModifyPacket.messageData = string4;
        if (byArray != null) {
            messagePatchModifyPacket.binaryData = object = ByteString.copyFrom(byArray);
        }
        object = null;
        messagePatchModifyPacket.isRecall = false;
        messagePatchModifyPacket.mentionAll = bl2;
        messagePatchModifyPacket.mentionList = list;
        messagePatchModifyPacket.setRequestId(n10);
        int n11 = AVIMClient.getClientsCount();
        int n12 = 1;
        if (n11 > n12) {
            messagePatchModifyPacket.setPeerId(string2);
        }
        return messagePatchModifyPacket;
    }

    private Messages$PatchCommand getPatchCommand() {
        Object object;
        boolean bl2;
        Messages$PatchCommand$Builder messages$PatchCommand$Builder = Messages$PatchCommand.newBuilder();
        Messages$PatchItemOrBuilder messages$PatchItemOrBuilder = Messages$PatchItem.newBuilder();
        long l10 = this.timestamp;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 > 0) {
            messages$PatchItemOrBuilder.setTimestamp(l10);
        }
        if (!(bl2 = StringUtil.isEmpty((String)(object = this.messageId)))) {
            object = this.messageId;
            messages$PatchItemOrBuilder.setMid((String)object);
        }
        if (!(bl2 = StringUtil.isEmpty((String)(object = this.conversationId)))) {
            object = this.conversationId;
            messages$PatchItemOrBuilder.setCid((String)object);
        }
        if (!(bl2 = StringUtil.isEmpty((String)(object = this.messageData)))) {
            object = this.messageData;
            messages$PatchItemOrBuilder.setData((String)object);
        }
        bl2 = this.mentionAll;
        messages$PatchItemOrBuilder.setMentionAll(bl2);
        object = this.mentionList;
        if (object != null) {
            messages$PatchItemOrBuilder.addAllMentionPids((Iterable)object);
        }
        bl2 = this.isRecall;
        messages$PatchItemOrBuilder.setRecall(bl2);
        object = this.binaryData;
        if (object != null) {
            messages$PatchItemOrBuilder.setDataBytes((ByteString)object);
        }
        messages$PatchItemOrBuilder = messages$PatchItemOrBuilder.build();
        messages$PatchCommand$Builder.addPatches((Messages$PatchItem)messages$PatchItemOrBuilder);
        return messages$PatchCommand$Builder.build();
    }

    public Messages$GenericCommand$Builder getGenericCommandBuilder() {
        Messages$GenericCommand$Builder messages$GenericCommand$Builder = super.getGenericCommandBuilder();
        Object object = Messages$OpType.modify;
        messages$GenericCommand$Builder.setOp((Messages$OpType)object);
        object = this.getPatchCommand();
        messages$GenericCommand$Builder.setPatchMessage((Messages$PatchCommand)object);
        return messages$GenericCommand$Builder;
    }
}

