/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.command;

import cn.leancloud.Messages$BlacklistCommand;
import cn.leancloud.Messages$BlacklistCommand$Builder;
import cn.leancloud.Messages$GenericCommand$Builder;
import cn.leancloud.Messages$OpType;
import cn.leancloud.command.PeerBasedCommandPacket;
import cn.leancloud.im.Signature;
import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.utils.StringUtil;
import java.util.List;

public class BlacklistCommandPacket
extends PeerBasedCommandPacket {
    public static final String BLACKLIST_CMD = "blacklist";
    private List clientIds;
    private String conversationId;
    private int limit = 0;
    private String nonce;
    private int offset = 0;
    private String op;
    private String signature;
    private long timestamp;

    public BlacklistCommandPacket() {
        this.setCmd(BLACKLIST_CMD);
    }

    public static BlacklistCommandPacket genBlacklistCommandPacket(String string2, String string3, String string4, int n10, int n11, int n12) {
        int n13;
        BlacklistCommandPacket blacklistCommandPacket = new BlacklistCommandPacket();
        int n14 = AVIMClient.getClientsCount();
        if (n14 > (n13 = 1)) {
            blacklistCommandPacket.setPeerId(string2);
        }
        blacklistCommandPacket.setConversationId(string3);
        blacklistCommandPacket.setOp(string4);
        blacklistCommandPacket.setOffset(n10);
        blacklistCommandPacket.setLimit(n11);
        blacklistCommandPacket.setRequestId(n12);
        return blacklistCommandPacket;
    }

    public static BlacklistCommandPacket genBlacklistCommandPacket(String string2, String string3, String string4, List list, Signature signature, int n10) {
        int n11;
        BlacklistCommandPacket blacklistCommandPacket = new BlacklistCommandPacket();
        int n12 = AVIMClient.getClientsCount();
        if (n12 > (n11 = 1)) {
            blacklistCommandPacket.setPeerId(string2);
        }
        blacklistCommandPacket.setConversationId(string3);
        blacklistCommandPacket.setOp(string4);
        blacklistCommandPacket.setClientIds(list);
        blacklistCommandPacket.setRequestId(n10);
        if (signature != null) {
            string2 = signature.getSignature();
            blacklistCommandPacket.setSignature(string2);
            string2 = signature.getNonce();
            blacklistCommandPacket.setNonce(string2);
            long l10 = signature.getTimestamp();
            blacklistCommandPacket.setTimestamp(l10);
        }
        return blacklistCommandPacket;
    }

    public Messages$BlacklistCommand getBlacklistCommand() {
        int n10;
        Messages$BlacklistCommand$Builder messages$BlacklistCommand$Builder = Messages$BlacklistCommand.newBuilder();
        Object object = this.getConversationId();
        messages$BlacklistCommand$Builder.setSrcCid((String)object);
        object = this.clientIds;
        if (object != null && (n10 = object.size()) > 0) {
            object = this.clientIds;
            messages$BlacklistCommand$Builder.addAllToPids((Iterable)object);
        }
        if ((n10 = this.offset) > 0) {
            object = Integer.toString(n10);
            messages$BlacklistCommand$Builder.setNext((String)object);
        }
        if ((n10 = this.limit) > 0) {
            messages$BlacklistCommand$Builder.setLimit(n10);
        }
        if ((n10 = (int)(StringUtil.isEmpty((String)(object = this.signature)) ? 1 : 0)) == 0) {
            object = this.getSignature();
            messages$BlacklistCommand$Builder.setS((String)object);
            long l10 = this.getTimestamp();
            messages$BlacklistCommand$Builder.setT(l10);
            object = this.getNonce();
            messages$BlacklistCommand$Builder.setN((String)object);
        }
        return messages$BlacklistCommand$Builder.build();
    }

    public List getClientIds() {
        return this.clientIds;
    }

    public String getConversationId() {
        return this.conversationId;
    }

    public Messages$GenericCommand$Builder getGenericCommandBuilder() {
        Messages$GenericCommand$Builder messages$GenericCommand$Builder = super.getGenericCommandBuilder();
        Object object = Messages$OpType.valueOf(this.op);
        messages$GenericCommand$Builder.setOp((Messages$OpType)object);
        object = this.getBlacklistCommand();
        messages$GenericCommand$Builder.setBlacklistMessage((Messages$BlacklistCommand)object);
        return messages$GenericCommand$Builder;
    }

    public int getLimit() {
        return this.limit;
    }

    public String getNonce() {
        return this.nonce;
    }

    public int getOffset() {
        return this.offset;
    }

    public String getOp() {
        return this.op;
    }

    public String getSignature() {
        return this.signature;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setClientIds(List list) {
        this.clientIds = list;
    }

    public void setConversationId(String string2) {
        this.conversationId = string2;
    }

    public void setLimit(int n10) {
        this.limit = n10;
    }

    public void setNonce(String string2) {
        this.nonce = string2;
    }

    public void setOffset(int n10) {
        this.offset = n10;
    }

    public void setOp(String string2) {
        this.op = string2;
    }

    public void setSignature(String string2) {
        this.signature = string2;
    }

    public void setTimestamp(long l10) {
        this.timestamp = l10;
    }
}

