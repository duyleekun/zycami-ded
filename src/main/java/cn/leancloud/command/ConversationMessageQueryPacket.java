/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.command;

import cn.leancloud.Messages$GenericCommand$Builder;
import cn.leancloud.Messages$LogsCommand;
import cn.leancloud.Messages$LogsCommand$Builder;
import cn.leancloud.Messages$LogsCommand$QueryDirection;
import cn.leancloud.command.PeerBasedCommandPacket;
import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.utils.StringUtil;

public class ConversationMessageQueryPacket
extends PeerBasedCommandPacket {
    public String conversationId;
    public int direct;
    public int limit;
    public String msgId;
    public int msgType;
    public int requestId;
    public boolean sclosed;
    public boolean tclosed;
    public long timestamp;
    public String toMsgId;
    public long toTimestamp;

    public ConversationMessageQueryPacket() {
        this.setCmd("logs");
    }

    public static ConversationMessageQueryPacket getConversationMessageQueryPacket(String string2, String string3, String string4, long l10, boolean bl2, String string5, long l11, boolean bl3, int n10, int n11, int n12, int n13) {
        int n14;
        ConversationMessageQueryPacket conversationMessageQueryPacket = new ConversationMessageQueryPacket();
        int n15 = AVIMClient.getClientsCount();
        if (n15 > (n14 = 1)) {
            conversationMessageQueryPacket.setPeerId(string2);
        }
        conversationMessageQueryPacket.setConversationId(string3);
        conversationMessageQueryPacket.setMsgId(string4);
        n15 = n11;
        conversationMessageQueryPacket.setLimit(n11);
        n15 = n10;
        conversationMessageQueryPacket.setDirect(n10);
        conversationMessageQueryPacket.setTimestamp(l10);
        n15 = (int)(bl2 ? 1 : 0);
        conversationMessageQueryPacket.setSclosed(bl2);
        n15 = n13;
        conversationMessageQueryPacket.setRequestId(n13);
        conversationMessageQueryPacket.setToMsgId(string5);
        conversationMessageQueryPacket.setToTimestamp(l11);
        n15 = (int)(bl3 ? 1 : 0);
        conversationMessageQueryPacket.setTclosed(bl3);
        n15 = n12;
        conversationMessageQueryPacket.setMsgType(n12);
        return conversationMessageQueryPacket;
    }

    public String getConversationId() {
        return this.conversationId;
    }

    public int getDirect() {
        return this.direct;
    }

    public Messages$GenericCommand$Builder getGenericCommandBuilder() {
        Messages$GenericCommand$Builder messages$GenericCommand$Builder = super.getGenericCommandBuilder();
        Messages$LogsCommand messages$LogsCommand = this.getLogsCommand();
        messages$GenericCommand$Builder.setLogsMessage(messages$LogsCommand);
        int n10 = this.requestId;
        messages$GenericCommand$Builder.setI(n10);
        return messages$GenericCommand$Builder;
    }

    public int getLimit() {
        return this.limit;
    }

    public Messages$LogsCommand getLogsCommand() {
        long l10;
        long l11;
        long l12;
        long l13;
        long l14;
        long l15;
        Messages$LogsCommand$Builder messages$LogsCommand$Builder = Messages$LogsCommand.newBuilder();
        Object object = this.conversationId;
        messages$LogsCommand$Builder.setCid((String)object);
        int n10 = this.limit;
        messages$LogsCommand$Builder.setLimit(n10);
        object = this.msgId;
        n10 = (int)(StringUtil.isEmpty((String)object) ? 1 : 0);
        if (n10 == 0) {
            object = this.msgId;
            messages$LogsCommand$Builder.setMid((String)object);
        }
        if ((l15 = (l14 = (l13 = this.timestamp) - (l12 = 0L)) == 0L ? 0 : (l14 < 0L ? -1 : 1)) > 0) {
            messages$LogsCommand$Builder.setT(l13);
        }
        n10 = (int)(this.sclosed ? 1 : 0);
        messages$LogsCommand$Builder.setTIncluded(n10 != 0);
        object = this.toMsgId;
        n10 = StringUtil.isEmpty((String)object);
        if (n10 == 0) {
            object = this.toMsgId;
            messages$LogsCommand$Builder.setTmid((String)object);
        }
        if ((l11 = (l10 = (l13 = this.toTimestamp) - l12) == 0L ? 0 : (l10 < 0L ? -1 : 1)) > 0) {
            messages$LogsCommand$Builder.setTt(l13);
        }
        n10 = this.tclosed;
        messages$LogsCommand$Builder.setTtIncluded(n10 != 0);
        n10 = this.direct;
        if (n10 == 0) {
            object = Messages$LogsCommand$QueryDirection.OLD;
            messages$LogsCommand$Builder.setDirection((Messages$LogsCommand$QueryDirection)object);
        } else {
            object = Messages$LogsCommand$QueryDirection.NEW;
            messages$LogsCommand$Builder.setDirection((Messages$LogsCommand$QueryDirection)object);
        }
        n10 = this.msgType;
        if (n10 != 0) {
            messages$LogsCommand$Builder.setLctype(n10);
        }
        return messages$LogsCommand$Builder.build();
    }

    public String getMsgId() {
        return this.msgId;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public int getRequestId() {
        return this.requestId;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getToMsgId() {
        return this.toMsgId;
    }

    public long getToTimestamp() {
        return this.toTimestamp;
    }

    public boolean isSclosed() {
        return this.sclosed;
    }

    public boolean isTclosed() {
        return this.tclosed;
    }

    public void setConversationId(String string2) {
        this.conversationId = string2;
    }

    public void setDirect(int n10) {
        this.direct = n10;
    }

    public void setLimit(int n10) {
        this.limit = n10;
    }

    public void setMsgId(String string2) {
        this.msgId = string2;
    }

    public void setMsgType(int n10) {
        this.msgType = n10;
    }

    public void setRequestId(int n10) {
        this.requestId = n10;
    }

    public void setSclosed(boolean bl2) {
        this.sclosed = bl2;
    }

    public void setTclosed(boolean bl2) {
        this.tclosed = bl2;
    }

    public void setTimestamp(long l10) {
        this.timestamp = l10;
    }

    public void setToMsgId(String string2) {
        this.toMsgId = string2;
    }

    public void setToTimestamp(long l10) {
        this.toTimestamp = l10;
    }
}

