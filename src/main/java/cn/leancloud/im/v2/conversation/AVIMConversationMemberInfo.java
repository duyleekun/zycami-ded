/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2.conversation;

import cn.leancloud.im.v2.conversation.ConversationMemberRole;
import cn.leancloud.utils.StringUtil;
import java.util.HashMap;
import java.util.Map;

public class AVIMConversationMemberInfo {
    public static final String ATTR_CLIENTID = "clientId";
    public static final String ATTR_CONVID = "conversationId";
    public static final String ATTR_CONVID_SIMPLE = "cid";
    private static final String ATTR_CREATEDAT = "createdAt";
    private static final String ATTR_INVITER = "inviter";
    public static final String ATTR_MEMBERID = "peerId";
    private static final String ATTR_NICKNAME = "nickname";
    public static final String ATTR_OJBECTID = "infoId";
    public static final String ATTR_OJBECTID2 = "objectId";
    public static final String ATTR_ROLE = "role";
    private String conversationId = null;
    private String createdAt = null;
    private String inviter = null;
    private boolean isOwner = false;
    private String memberId = null;
    private String nickname = null;
    private String objectId = null;
    private ConversationMemberRole role;

    public AVIMConversationMemberInfo(String string2, String string3, ConversationMemberRole conversationMemberRole) {
        this(null, string2, string3, conversationMemberRole);
    }

    public AVIMConversationMemberInfo(String string2, String string3, String string4, ConversationMemberRole conversationMemberRole) {
        this.objectId = string2;
        this.conversationId = string3;
        this.memberId = string4;
        this.role = conversationMemberRole;
    }

    public static AVIMConversationMemberInfo createInstance(Map object) {
        String string2;
        boolean bl2;
        if (object == null) {
            return null;
        }
        String string3 = (String)object.get(ATTR_CONVID);
        boolean bl3 = StringUtil.isEmpty(string3);
        if (bl3) {
            string3 = (String)object.get(ATTR_CONVID_SIMPLE);
        }
        if (bl2 = StringUtil.isEmpty(string2 = (String)object.get(ATTR_MEMBERID))) {
            string2 = (String)object.get(ATTR_CLIENTID);
        }
        Object object2 = (String)object.get(ATTR_ROLE);
        Object object3 = (String)object.get(ATTR_OJBECTID);
        boolean bl4 = StringUtil.isEmpty(object3);
        if (bl4) {
            object = object.get(ATTR_OJBECTID2);
            object3 = object;
            object3 = (String)object;
        }
        object = ConversationMemberRole.fromString((String)object2);
        object2 = new AVIMConversationMemberInfo((String)object3, string3, string2, (ConversationMemberRole)((Object)object));
        return object2;
    }

    public String getConversationId() {
        return this.conversationId;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public String getInviter() {
        return this.inviter;
    }

    public String getMemberId() {
        return this.memberId;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public ConversationMemberRole getRole() {
        return this.role;
    }

    public Map getUpdateAttrs() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        String string2 = this.getMemberId();
        hashMap.put(ATTR_MEMBERID, string2);
        string2 = this.getRole().getName();
        String string3 = ATTR_ROLE;
        hashMap.put(string3, string2);
        string2 = this.getObjectId();
        boolean bl2 = StringUtil.isEmpty(string2);
        if (!bl2) {
            string2 = this.getObjectId();
            string3 = ATTR_OJBECTID;
            hashMap.put(string3, string2);
        }
        return hashMap;
    }

    public boolean isOwner() {
        return this.isOwner;
    }

    public void setCreatedAt(String string2) {
        this.createdAt = string2;
    }

    public void setInviter(String string2) {
        this.inviter = string2;
    }

    public void setNickname(String string2) {
        this.nickname = string2;
    }

    public void setRole(ConversationMemberRole conversationMemberRole) {
        this.role = conversationMemberRole;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("convId:");
        String string2 = this.conversationId;
        stringBuilder.append(string2);
        stringBuilder.append(", memberId:");
        string2 = this.memberId;
        stringBuilder.append(string2);
        stringBuilder.append(", role:");
        string2 = this.role.toString();
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

