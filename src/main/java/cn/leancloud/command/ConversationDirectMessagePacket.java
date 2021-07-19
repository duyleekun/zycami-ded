/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.command;

import cn.leancloud.Messages$DirectCommand;
import cn.leancloud.Messages$DirectCommand$Builder;
import cn.leancloud.Messages$GenericCommand$Builder;
import cn.leancloud.command.PeerBasedCommandPacket;
import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMMessageOption;
import cn.leancloud.im.v2.AVIMMessageOption$MessagePriority;
import cn.leancloud.utils.StringUtil;
import com.google.protobuf.ByteString;
import java.util.List;

public class ConversationDirectMessagePacket
extends PeerBasedCommandPacket {
    public ByteString binaryMessage = null;
    public String conversationId;
    public boolean mentionAll = false;
    public List mentionList = null;
    public String message = null;
    public AVIMMessageOption messageOption;
    public String messageToken = null;

    public ConversationDirectMessagePacket() {
        this.setCmd("direct");
    }

    public static ConversationDirectMessagePacket getConversationMessagePacket(String string2, String string3, String string4, byte[] byArray, boolean bl2, List list, AVIMMessageOption aVIMMessageOption, int n10) {
        int n11;
        ConversationDirectMessagePacket conversationDirectMessagePacket = new ConversationDirectMessagePacket();
        int n12 = AVIMClient.getClientsCount();
        if (n12 > (n11 = 1)) {
            conversationDirectMessagePacket.setPeerId(string2);
        }
        conversationDirectMessagePacket.setConversationId(string3);
        conversationDirectMessagePacket.setRequestId(n10);
        conversationDirectMessagePacket.setMessageOption(aVIMMessageOption);
        conversationDirectMessagePacket.setMessage(string4);
        conversationDirectMessagePacket.setMentionAll(bl2);
        conversationDirectMessagePacket.setMentionList(list);
        conversationDirectMessagePacket.setBinaryMessage(byArray);
        return conversationDirectMessagePacket;
    }

    public static ConversationDirectMessagePacket getConversationMessagePacket(String string2, String string3, String string4, byte[] byArray, boolean bl2, List list, String string5, AVIMMessageOption aVIMMessageOption, int n10) {
        Object object = string2;
        object = ConversationDirectMessagePacket.getConversationMessagePacket(string2, string3, string4, byArray, bl2, list, aVIMMessageOption, n10);
        ((ConversationDirectMessagePacket)object).messageToken = string5;
        return object;
    }

    private void setMessageOption(AVIMMessageOption aVIMMessageOption) {
        this.messageOption = aVIMMessageOption;
    }

    public String getConversationId() {
        return this.conversationId;
    }

    public Messages$DirectCommand getDirectCommand() {
        Messages$DirectCommand$Builder messages$DirectCommand$Builder = Messages$DirectCommand.newBuilder();
        Object object = this.message;
        if (object != null) {
            messages$DirectCommand$Builder.setMsg((String)object);
        }
        object = this.conversationId;
        messages$DirectCommand$Builder.setCid((String)object);
        int n10 = this.mentionAll;
        if (n10 != 0) {
            messages$DirectCommand$Builder.setMentionAll(n10 != 0);
        }
        if ((object = this.mentionList) != null && (n10 = object.size()) > 0) {
            object = this.mentionList;
            messages$DirectCommand$Builder.addAllMentionPids((Iterable)object);
        }
        if ((object = this.messageOption) != null) {
            boolean bl2;
            n10 = (int)(((AVIMMessageOption)object).isReceipt() ? 1 : 0);
            boolean bl3 = true;
            if (n10 != 0) {
                messages$DirectCommand$Builder.setR(bl3);
            }
            if ((n10 = (int)(((AVIMMessageOption)(object = this.messageOption)).isTransient() ? 1 : 0)) != 0) {
                messages$DirectCommand$Builder.setTransient(bl3);
            }
            if (!(bl2 = StringUtil.isEmpty((String)(object = this.messageOption.getPushData())))) {
                messages$DirectCommand$Builder.setPushData((String)object);
            }
            if ((n10 = (int)(((AVIMMessageOption)(object = this.messageOption)).isWill() ? 1 : 0)) != 0) {
                messages$DirectCommand$Builder.setWill(bl3);
            }
        }
        if ((n10 = (int)(StringUtil.isEmpty((String)(object = this.messageToken)) ? 1 : 0)) == 0) {
            object = this.messageToken;
            messages$DirectCommand$Builder.setDt((String)object);
        }
        if ((object = this.binaryMessage) != null) {
            messages$DirectCommand$Builder.setBinaryMsg((ByteString)object);
        }
        return messages$DirectCommand$Builder.build();
    }

    public Messages$GenericCommand$Builder getGenericCommandBuilder() {
        Messages$GenericCommand$Builder messages$GenericCommand$Builder = super.getGenericCommandBuilder();
        Object object = this.getDirectCommand();
        messages$GenericCommand$Builder.setDirectMessage((Messages$DirectCommand)object);
        object = this.messageOption;
        if (object != null && (object = ((AVIMMessageOption)object).getPriority()) != null) {
            object = this.messageOption.getPriority();
            int n10 = ((AVIMMessageOption$MessagePriority)((Object)object)).getNumber();
            messages$GenericCommand$Builder.setPriority(n10);
        }
        return messages$GenericCommand$Builder;
    }

    public List getMentionList() {
        return this.mentionList;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean isMentionAll() {
        return this.mentionAll;
    }

    public void setBinaryMessage(byte[] object) {
        if (object == null) {
            object = null;
            this.binaryMessage = null;
        } else {
            object = ByteString.copyFrom(object);
            this.binaryMessage = object;
        }
    }

    public void setConversationId(String string2) {
        this.conversationId = string2;
    }

    public void setMentionAll(boolean bl2) {
        this.mentionAll = bl2;
    }

    public void setMentionList(List list) {
        this.mentionList = list;
    }

    public void setMessage(String string2) {
        this.message = string2;
    }
}

