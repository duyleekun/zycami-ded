/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.command;

import cn.leancloud.Messages$ConvCommand;
import cn.leancloud.Messages$ConvCommand$Builder;
import cn.leancloud.Messages$ConvMemberInfo;
import cn.leancloud.Messages$ConvMemberInfo$Builder;
import cn.leancloud.Messages$GenericCommand$Builder;
import cn.leancloud.Messages$JsonObjectMessage;
import cn.leancloud.Messages$JsonObjectMessage$Builder;
import cn.leancloud.Messages$OpType;
import cn.leancloud.command.PeerBasedCommandPacket;
import cn.leancloud.im.Signature;
import cn.leancloud.json.JSON;
import cn.leancloud.utils.StringUtil;
import java.util.List;
import java.util.Map;

public class ConversationControlPacket
extends PeerBasedCommandPacket {
    public static final String CONVERSATION_CMD = "conv";
    private Map attributes;
    private String conversationId;
    private boolean isTemporary = false;
    private boolean isTransient;
    private boolean isUnique;
    private Map memberInfo = null;
    private List members;
    private String nonce;
    private String op;
    private int queryLimit = 0;
    private int queryOffset = 0;
    private String signature;
    private int tempTTL = 0;
    private long timestamp;

    public ConversationControlPacket() {
        this.setCmd(CONVERSATION_CMD);
    }

    public static ConversationControlPacket genConversationCommand(String string2, String string3, List list, String string4, Map map, Signature signature, int n10) {
        return ConversationControlPacket.genConversationCommand(string2, string3, list, string4, map, signature, false, n10);
    }

    public static ConversationControlPacket genConversationCommand(String string2, String string3, List list, String string4, Map map, Signature signature, boolean bl2, int n10) {
        return ConversationControlPacket.genConversationCommand(string2, string3, list, string4, map, signature, bl2, false, false, 0, false, n10);
    }

    public static ConversationControlPacket genConversationCommand(String string2, String string3, List list, String string4, Map map, Signature signature, boolean bl2, boolean bl3, boolean bl4, int n10, boolean bl5, int n11) {
        int n12;
        ConversationControlPacket conversationControlPacket = new ConversationControlPacket();
        conversationControlPacket.setPeerId(string2);
        conversationControlPacket.setConversationId(string3);
        conversationControlPacket.setRequestId(n11);
        conversationControlPacket.setTransient(bl2);
        conversationControlPacket.setUnique(bl3);
        conversationControlPacket.setTemporary(bl4);
        if (bl4) {
            conversationControlPacket.setTempTTL(n10);
        }
        if (list != null && (n12 = list.size()) > 0) {
            conversationControlPacket.setMembers(list);
        }
        conversationControlPacket.setOp(string4);
        if (signature != null && ((n12 = (int)(string4.equals(string2 = "add") ? 1 : 0)) != 0 || (n12 = (int)(string4.equals(string2 = "remove") ? 1 : 0)) != 0 || (n12 = (int)(string4.equals(string2 = "start") ? 1 : 0)) != 0)) {
            string2 = signature.getSignature();
            conversationControlPacket.setSignature(string2);
            string2 = signature.getNonce();
            conversationControlPacket.setNonce(string2);
            long l10 = signature.getTimestamp();
            conversationControlPacket.setTimestamp(l10);
        }
        conversationControlPacket.setRequestId(n11);
        conversationControlPacket.setAttributes(map);
        return conversationControlPacket;
    }

    public static ConversationControlPacket genConversationMemberCommand(String string2, String string3, String string4, Map map, Signature signature, int n10) {
        Object object = string2;
        object = ConversationControlPacket.genConversationCommand(string2, string3, null, string4, null, signature, false, false, false, 0, false, n10);
        ((ConversationControlPacket)object).setMemberInfo(map);
        return object;
    }

    private Messages$ConvCommand getConvCommand() {
        Object object;
        int n10;
        Messages$ConvCommand$Builder messages$ConvCommand$Builder = Messages$ConvCommand.newBuilder();
        Object object2 = this.attributes;
        if (object2 != null && (n10 = object2.isEmpty()) == 0) {
            object2 = Messages$JsonObjectMessage.newBuilder();
            object = JSON.toJSONString(this.attributes);
            ((Messages$JsonObjectMessage$Builder)object2).setData((String)object);
            messages$ConvCommand$Builder.setAttr((Messages$JsonObjectMessage$Builder)object2);
        }
        if ((object2 = this.members) != null && (n10 = object2.size()) > 0) {
            object2 = this.members;
            messages$ConvCommand$Builder.addAllM((Iterable)object2);
        }
        if ((object2 = this.getSignature()) != null) {
            object2 = this.getSignature();
            messages$ConvCommand$Builder.setS((String)object2);
            long l10 = this.getTimestamp();
            messages$ConvCommand$Builder.setT(l10);
            object2 = this.getNonce();
            messages$ConvCommand$Builder.setN((String)object2);
        }
        if ((n10 = (int)(StringUtil.isEmpty((String)(object2 = this.conversationId)) ? 1 : 0)) == 0) {
            object2 = this.conversationId;
            messages$ConvCommand$Builder.setCid((String)object2);
        }
        if ((n10 = (int)(this.isTransient ? 1 : 0)) != 0) {
            messages$ConvCommand$Builder.setTransient(n10 != 0);
        }
        if ((n10 = this.isUnique) != 0) {
            messages$ConvCommand$Builder.setUnique(n10 != 0);
        }
        if ((n10 = this.isTemporary) != 0) {
            messages$ConvCommand$Builder.setTempConv(n10 != 0);
            n10 = this.tempTTL;
            messages$ConvCommand$Builder.setTempConvTTL(n10);
        }
        if ((object2 = this.memberInfo) != null) {
            object2 = Messages$ConvMemberInfo.newBuilder();
            object = this.memberInfo;
            String string2 = "peerId";
            boolean bl2 = object.containsKey(string2);
            if (bl2) {
                object = (String)this.memberInfo.get(string2);
                ((Messages$ConvMemberInfo$Builder)object2).setPid((String)object);
                object = (String)this.memberInfo.get(string2);
                messages$ConvCommand$Builder.setTargetClientId((String)object);
            }
            if (bl2 = (object = this.memberInfo).containsKey(string2 = "role")) {
                object = (String)this.memberInfo.get(string2);
                ((Messages$ConvMemberInfo$Builder)object2).setRole((String)object);
            }
            if (bl2 = (object = this.memberInfo).containsKey(string2 = "infoId")) {
                object = (String)this.memberInfo.get(string2);
                ((Messages$ConvMemberInfo$Builder)object2).setInfoId((String)object);
            }
            object2 = ((Messages$ConvMemberInfo$Builder)object2).build();
            messages$ConvCommand$Builder.setInfo((Messages$ConvMemberInfo)object2);
        }
        if ((n10 = this.queryOffset) > 0) {
            object2 = Integer.toString(n10);
            messages$ConvCommand$Builder.setNext((String)object2);
        }
        if ((n10 = this.queryLimit) > 0) {
            messages$ConvCommand$Builder.setLimit(n10);
        }
        return messages$ConvCommand$Builder.build();
    }

    public Map getAttributes() {
        return this.attributes;
    }

    public String getConversationId() {
        return this.conversationId;
    }

    public Messages$GenericCommand$Builder getGenericCommandBuilder() {
        Messages$GenericCommand$Builder messages$GenericCommand$Builder = super.getGenericCommandBuilder();
        Object object = Messages$OpType.valueOf(this.op);
        messages$GenericCommand$Builder.setOp((Messages$OpType)object);
        object = this.getConvCommand();
        messages$GenericCommand$Builder.setConvMessage((Messages$ConvCommand)object);
        return messages$GenericCommand$Builder;
    }

    public List getMembers() {
        return this.members;
    }

    public String getNonce() {
        return this.nonce;
    }

    public String getOp() {
        return this.op;
    }

    public int getQueryLimit() {
        return this.queryLimit;
    }

    public int getQueryOffset() {
        return this.queryOffset;
    }

    public String getSignature() {
        return this.signature;
    }

    public int getTempTTL() {
        return this.tempTTL;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public boolean isTemporary() {
        return this.isTemporary;
    }

    public boolean isTransient() {
        return this.isTransient;
    }

    public boolean isUnique() {
        return this.isUnique;
    }

    public void setAttributes(Map map) {
        this.attributes = map;
    }

    public void setConversationId(String string2) {
        this.conversationId = string2;
    }

    public void setMemberInfo(Map map) {
        this.memberInfo = map;
    }

    public void setMembers(List list) {
        this.members = list;
    }

    public void setNonce(String string2) {
        this.nonce = string2;
    }

    public void setOp(String string2) {
        this.op = string2;
    }

    public void setQueryLimit(int n10) {
        this.queryLimit = n10;
    }

    public void setQueryOffset(int n10) {
        this.queryOffset = n10;
    }

    public void setSignature(String string2) {
        this.signature = string2;
    }

    public void setTempTTL(int n10) {
        this.tempTTL = n10;
    }

    public void setTemporary(boolean bl2) {
        this.isTemporary = bl2;
    }

    public void setTimestamp(long l10) {
        this.timestamp = l10;
    }

    public void setTransient(boolean bl2) {
        this.isTransient = bl2;
    }

    public void setUnique(boolean bl2) {
        this.isUnique = bl2;
    }
}

