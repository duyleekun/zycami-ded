/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.command;

import cn.leancloud.Messages$GenericCommand$Builder;
import cn.leancloud.Messages$ReadCommand;
import cn.leancloud.Messages$ReadCommand$Builder;
import cn.leancloud.Messages$ReadTuple$Builder;
import cn.leancloud.command.PeerBasedCommandPacket;
import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.utils.StringUtil;

public class UnreadMessagesClearPacket
extends PeerBasedCommandPacket {
    public String conversationId;
    public String messageId;
    public long messageTS;

    public UnreadMessagesClearPacket() {
        this.setCmd("read");
    }

    public static UnreadMessagesClearPacket getUnreadClearPacket(String string2, String string3, String string4, long l10, int n10) {
        int n11;
        UnreadMessagesClearPacket unreadMessagesClearPacket = new UnreadMessagesClearPacket();
        int n12 = AVIMClient.getClientsCount();
        if (n12 > (n11 = 1)) {
            unreadMessagesClearPacket.setPeerId(string2);
        }
        unreadMessagesClearPacket.setConversationId(string3);
        unreadMessagesClearPacket.setRequestId(n10);
        unreadMessagesClearPacket.setMessageId(string4);
        unreadMessagesClearPacket.setMessageTS(l10);
        return unreadMessagesClearPacket;
    }

    public String getConversationId() {
        return this.conversationId;
    }

    public Messages$GenericCommand$Builder getGenericCommandBuilder() {
        Messages$GenericCommand$Builder messages$GenericCommand$Builder = super.getGenericCommandBuilder();
        Messages$ReadCommand messages$ReadCommand = this.getReadCommand();
        messages$GenericCommand$Builder.setReadMessage(messages$ReadCommand);
        return messages$GenericCommand$Builder;
    }

    public Messages$ReadCommand getReadCommand() {
        long l10;
        long l11;
        long l12;
        long l13;
        Messages$ReadCommand$Builder messages$ReadCommand$Builder = Messages$ReadCommand.newBuilder();
        Messages$ReadTuple$Builder messages$ReadTuple$Builder = messages$ReadCommand$Builder.addConvsBuilder();
        String string2 = this.messageId;
        boolean bl2 = StringUtil.isEmpty(string2);
        if (!bl2) {
            string2 = this.messageId;
            messages$ReadTuple$Builder.setMid(string2);
        }
        if ((l13 = (l12 = (l11 = this.messageTS) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
            messages$ReadTuple$Builder.setTimestamp(l11);
        }
        string2 = this.conversationId;
        messages$ReadTuple$Builder.setCid(string2);
        return messages$ReadCommand$Builder.build();
    }

    public void setConversationId(String string2) {
        this.conversationId = string2;
    }

    public void setMessageId(String string2) {
        this.messageId = string2;
    }

    public void setMessageTS(long l10) {
        this.messageTS = l10;
    }
}

