/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.command;

import cn.leancloud.Messages$AckCommand;
import cn.leancloud.Messages$AckCommand$Builder;
import cn.leancloud.Messages$GenericCommand$Builder;
import cn.leancloud.command.PeerBasedCommandPacket;
import cn.leancloud.utils.StringUtil;

public class ConversationAckPacket
extends PeerBasedCommandPacket {
    public String conversationId;
    public Long largestTimeStamp;
    public String messageId;

    public ConversationAckPacket() {
        super.setCmd("ack");
    }

    public static ConversationAckPacket getConversationAckPacket(String string2, String string3, Long l10) {
        ConversationAckPacket conversationAckPacket = new ConversationAckPacket();
        conversationAckPacket.setPeerId(string2);
        conversationAckPacket.setConversationId(string3);
        long l11 = l10;
        conversationAckPacket.setTimestamp(l11);
        return conversationAckPacket;
    }

    public static ConversationAckPacket getConversationAckPacket(String string2, String string3, String string4) {
        ConversationAckPacket conversationAckPacket = new ConversationAckPacket();
        conversationAckPacket.setPeerId(string2);
        conversationAckPacket.setConversationId(string3);
        conversationAckPacket.setMessageId(string4);
        return conversationAckPacket;
    }

    public Messages$AckCommand getAckCommand() {
        Messages$AckCommand$Builder messages$AckCommand$Builder = Messages$AckCommand.newBuilder();
        Object object = this.messageId;
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (!bl2) {
            object = this.messageId;
            messages$AckCommand$Builder.setMid((String)object);
        }
        if ((object = this.largestTimeStamp) != null) {
            long l10 = (Long)object;
            messages$AckCommand$Builder.setTots(l10);
        }
        if (!(bl2 = StringUtil.isEmpty((String)(object = this.conversationId)))) {
            object = this.conversationId;
            messages$AckCommand$Builder.setCid((String)object);
        }
        return messages$AckCommand$Builder.build();
    }

    public String getConversationId() {
        return this.conversationId;
    }

    public Messages$GenericCommand$Builder getGenericCommandBuilder() {
        Messages$GenericCommand$Builder messages$GenericCommand$Builder = super.getGenericCommandBuilder();
        Messages$AckCommand messages$AckCommand = this.getAckCommand();
        messages$GenericCommand$Builder.setAckMessage(messages$AckCommand);
        return messages$GenericCommand$Builder;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public void setConversationId(String string2) {
        this.conversationId = string2;
    }

    public void setMessageId(String string2) {
        this.messageId = string2;
    }

    public void setTimestamp(long l10) {
        Long l11;
        this.largestTimeStamp = l11 = Long.valueOf(l10);
    }
}

