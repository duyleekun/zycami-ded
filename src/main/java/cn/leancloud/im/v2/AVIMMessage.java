/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.codec.Base64Decoder;
import cn.leancloud.codec.Base64Encoder;
import cn.leancloud.im.AVIMOptions;
import cn.leancloud.im.v2.AVIMBinaryMessage;
import cn.leancloud.im.v2.AVIMMessage$AVIMMessageIOType;
import cn.leancloud.im.v2.AVIMMessage$AVIMMessageStatus;
import cn.leancloud.im.v2.AVIMMessageManager;
import cn.leancloud.im.v2.AVIMTypedMessage;
import cn.leancloud.json.JSON;
import cn.leancloud.utils.StringUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class AVIMMessage {
    public byte[] bytes;
    public String content;
    public String conversationId;
    public String currentClient = null;
    public long deliveredAt;
    public String from;
    public AVIMMessage$AVIMMessageIOType ioType;
    private boolean isTransient = false;
    public boolean mentionAll = false;
    public List mentionList = null;
    public String messageId;
    public long readAt;
    public AVIMMessage$AVIMMessageStatus status;
    public long timestamp;
    public String uniqueToken;
    public long updateAt;

    public AVIMMessage() {
        this(null, null);
    }

    public AVIMMessage(String string2, String string3) {
        this(string2, string3, 0L, 0L);
    }

    public AVIMMessage(String string2, String string3, long l10, long l11) {
        this(string2, string3, l10, l11, 0L);
    }

    public AVIMMessage(String string2, String string3, long l10, long l11, long l12) {
        Enum enum_ = AVIMMessage$AVIMMessageIOType.AVIMMessageIOTypeOut;
        this.ioType = enum_;
        this.status = enum_ = AVIMMessage$AVIMMessageStatus.AVIMMessageStatusNone;
        this.conversationId = string2;
        this.from = string3;
        this.timestamp = l10;
        this.deliveredAt = l11;
        this.readAt = l12;
    }

    public static AVIMMessage parseJSON(Map object) {
        boolean bl2;
        boolean bl3;
        long l10;
        int n10;
        AVIMMessage aVIMMessage;
        if (object == null) {
            return null;
        }
        Object object2 = "binaryMsg";
        boolean bl4 = object.containsKey(object2);
        String string2 = "typeMsgData";
        if (bl4) {
            aVIMMessage = new AVIMBinaryMessage();
            Object object3 = object.get(object2);
            int n11 = object3 instanceof String;
            if (n11 != 0) {
                object2 = Base64Decoder.decodeToBytes((String)object.get(object2));
                ((AVIMBinaryMessage)aVIMMessage).setBytes((byte[])object2);
            } else {
                boolean bl32 = object3 instanceof byte[];
                if (bl32) {
                    object3 = (byte[])object3;
                    ((AVIMBinaryMessage)aVIMMessage).setBytes((byte[])object3);
                } else {
                    boolean bl5 = object3 instanceof List;
                    if (bl5) {
                        int n12;
                        object2 = ((List)object3).toArray();
                        n10 = ((Object[])object2).length;
                        object3 = new byte[n10];
                        for (n11 = 0; n11 < (n12 = ((Object[])object2).length); ++n11) {
                            Integer n13 = (Integer)object2[n11];
                            n12 = n13.byteValue();
                            object3[n11] = n12;
                        }
                        ((AVIMBinaryMessage)aVIMMessage).setBytes((byte[])object3);
                    }
                }
            }
        } else {
            boolean bl6 = object.containsKey(string2);
            if (bl6) {
                aVIMMessage = new AVIMMessage();
                object2 = object.get(string2);
                n10 = object2 instanceof String;
                if (n10 != 0) {
                    object2 = (String)object2;
                    aVIMMessage.setContent((String)object2);
                } else {
                    object2 = JSON.toJSONString(object2);
                    aVIMMessage.setContent((String)object2);
                }
            } else {
                aVIMMessage = new AVIMMessage();
                object2 = (String)object.get("msg");
                aVIMMessage.setContent((String)object2);
            }
        }
        object2 = "clientId";
        n10 = object.containsKey(object2);
        if (n10 != 0) {
            object2 = (String)object.get(object2);
            aVIMMessage.setCurrentClient((String)object2);
        }
        if ((n10 = (int)(object.containsKey(object2 = "uniqueToken") ? 1 : 0)) != 0) {
            object2 = (String)object.get(object2);
            aVIMMessage.setUniqueToken((String)object2);
        }
        if ((n10 = (int)(object.containsKey(object2 = "io") ? 1 : 0)) != 0) {
            int n14 = (Integer)object.get(object2);
            object2 = AVIMMessage$AVIMMessageIOType.getMessageIOType(n14);
            aVIMMessage.setMessageIOType((AVIMMessage$AVIMMessageIOType)((Object)object2));
        }
        if ((n10 = (int)(object.containsKey(object2 = "status") ? 1 : 0)) != 0) {
            int n15 = (Integer)object.get(object2);
            object2 = AVIMMessage$AVIMMessageStatus.getMessageStatus(n15);
            aVIMMessage.setMessageStatus((AVIMMessage$AVIMMessageStatus)((Object)object2));
        }
        if ((n10 = (int)(object.containsKey(object2 = "timestamp") ? 1 : 0)) != 0) {
            object2 = (Number)object.get(object2);
            l10 = object2.longValue();
            aVIMMessage.setTimestamp(l10);
        }
        if ((n10 = (int)(object.containsKey(object2 = "ackAt") ? 1 : 0)) != 0) {
            object2 = (Number)object.get(object2);
            l10 = object2.longValue();
            aVIMMessage.setDeliveredAt(l10);
        }
        if ((n10 = (int)(object.containsKey(object2 = "readAt") ? 1 : 0)) != 0) {
            object2 = (Number)object.get(object2);
            l10 = object2.longValue();
            aVIMMessage.setReadAt(l10);
        }
        if ((n10 = (int)(object.containsKey(object2 = "patchTimestamp") ? 1 : 0)) != 0) {
            object2 = (Number)object.get(object2);
            l10 = object2.longValue();
            aVIMMessage.setUpdateAt(l10);
        }
        if ((n10 = (int)(object.containsKey(object2 = "mentionAll") ? 1 : 0)) != 0) {
            object2 = (Boolean)object.get(object2);
            boolean bl7 = object2.booleanValue();
            aVIMMessage.setMentionAll(bl7);
        }
        if ((n10 = (int)(object.containsKey(object2 = "mentionPids") ? 1 : 0)) != 0) {
            object2 = (List)object.get(object2);
            aVIMMessage.setMentionList((List)object2);
        }
        if ((n10 = (int)(object.containsKey(object2 = "id") ? 1 : 0)) != 0) {
            object2 = (String)object.get(object2);
            aVIMMessage.setMessageId((String)object2);
        }
        if ((n10 = (int)(object.containsKey(object2 = "from") ? 1 : 0)) != 0) {
            object2 = (String)object.get(object2);
            aVIMMessage.setFrom((String)object2);
        }
        if ((n10 = (int)(object.containsKey(object2 = "conversationId") ? 1 : 0)) != 0) {
            object2 = (String)object.get(object2);
            aVIMMessage.setConversationId((String)object2);
        }
        if (bl3 = object.containsKey(string2)) {
            aVIMMessage = AVIMMessageManager.parseTypedMessage(aVIMMessage);
        }
        if (bl2 = object.containsKey(object2 = "transient")) {
            object = (Boolean)object.get(object2);
            boolean bl8 = (Boolean)object;
            aVIMMessage.setTransient(bl8);
        }
        return aVIMMessage;
    }

    public static AVIMMessage parseJSONString(String string2) {
        boolean bl2 = StringUtil.isEmpty(string2);
        if (bl2) {
            return null;
        }
        return AVIMMessage.parseJSON((Map)JSON.parseObject(string2, Map.class));
    }

    public Map dumpRawData() {
        long l10;
        long l11;
        long l12;
        long l13;
        long l14;
        long l15;
        long l16;
        long l17;
        String string2;
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Object object = this.conversationId;
        int n10 = StringUtil.isEmpty((String)object);
        if (n10 == 0) {
            object = this.conversationId;
            string2 = "conversationId";
            hashMap.put(string2, object);
        }
        if ((n10 = StringUtil.isEmpty((String)(object = this.messageId))) == 0) {
            object = this.messageId;
            string2 = "id";
            hashMap.put(string2, object);
        }
        if ((n10 = StringUtil.isEmpty((String)(object = this.from))) == 0) {
            object = this.from;
            string2 = "from";
            hashMap.put(string2, object);
        }
        if ((n10 = StringUtil.isEmpty((String)(object = this.currentClient))) == 0) {
            object = this.currentClient;
            string2 = "clientId";
            hashMap.put(string2, object);
        }
        if ((n10 = StringUtil.isEmpty((String)(object = this.uniqueToken))) == 0) {
            object = this.uniqueToken;
            string2 = "uniqueToken";
            hashMap.put(string2, object);
        }
        if ((l17 = (l16 = (l15 = this.timestamp) - (l14 = 0L)) == 0L ? 0 : (l16 < 0L ? -1 : 1)) > 0) {
            object = l15;
            string2 = "timestamp";
            hashMap.put(string2, object);
        }
        if ((l17 = (l13 = (l15 = this.updateAt) - l14) == 0L ? 0 : (l13 < 0L ? -1 : 1)) > 0) {
            object = l15;
            string2 = "patchTimestamp";
            hashMap.put(string2, object);
        }
        if ((l17 = (l12 = (l15 = this.deliveredAt) - l14) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
            object = l15;
            string2 = "ackAt";
            hashMap.put(string2, object);
        }
        if ((l11 = (l10 = (l15 = this.readAt) - l14) == 0L ? 0 : (l10 < 0L ? -1 : 1)) > 0) {
            object = l15;
            string2 = "readAt";
            hashMap.put(string2, object);
        }
        if ((n10 = this.isTransient) != 0) {
            object = Boolean.TRUE;
            string2 = "transient";
            hashMap.put(string2, object);
        }
        object = this.ioType.getIOType();
        hashMap.put("io", object);
        object = this.status.getStatusCode();
        hashMap.put("status", object);
        n10 = this.mentionAll;
        object = n10 != 0;
        string2 = "mentionAll";
        hashMap.put(string2, object);
        object = this.mentionList;
        if (object != null && (n10 = object.size()) > 0) {
            object = this.mentionList;
            string2 = "mentionPids";
            hashMap.put(string2, object);
        }
        if ((object = (Object)this.bytes) != null && (n10 = this instanceof AVIMBinaryMessage) != 0) {
            object = AVIMOptions.getGlobalOptions();
            n10 = (int)(((AVIMOptions)object).isWrapMessageBinaryBufferAsString() ? 1 : 0);
            string2 = "binaryMsg";
            if (n10 != 0) {
                object = Base64Encoder.encode(this.bytes);
                hashMap.put(string2, object);
            } else {
                object = this.bytes;
                hashMap.put(string2, object);
            }
        } else {
            n10 = this instanceof AVIMTypedMessage;
            if (n10 != 0) {
                object = JSON.parseObject(this.getContent(), Map.class);
                string2 = "typeMsgData";
                hashMap.put(string2, object);
            } else {
                object = this.getContent();
                boolean bl2 = StringUtil.isEmpty((String)object);
                if (!bl2) {
                    string2 = "msg";
                    hashMap.put(string2, object);
                }
            }
        }
        return hashMap;
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3;
        long l10;
        long l11;
        long l12;
        long l13;
        long l14;
        long l15;
        boolean bl4 = false;
        if (object == null) {
            return false;
        }
        boolean bl5 = true;
        if (this == object) {
            return bl5;
        }
        boolean bl6 = object instanceof AVIMMessage;
        if (!bl6) {
            return false;
        }
        object = (AVIMMessage)object;
        Object object2 = this.conversationId;
        Object object3 = ((AVIMMessage)object).conversationId;
        bl6 = StringUtil.equals(object2, object3);
        if (bl6 && (bl6 = StringUtil.equals(object2 = this.content, object3 = ((AVIMMessage)object).content)) && (bl6 = StringUtil.equals(object2 = this.from, object3 = ((AVIMMessage)object).from)) && !(bl6 = (l15 = (l14 = this.timestamp) - (l13 = ((AVIMMessage)object).timestamp)) == 0L ? 0 : (l15 < 0L ? -1 : 1)) && !(bl6 = (l12 = (l14 = this.deliveredAt) - (l13 = ((AVIMMessage)object).deliveredAt)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) && !(bl6 = (l11 = (l14 = this.readAt) - (l13 = ((AVIMMessage)object).readAt)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) && !(bl6 = (l10 = (l14 = this.updateAt) - (l13 = ((AVIMMessage)object).updateAt)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) && (object2 = this.getMessageStatus()) == (object3 = ((AVIMMessage)object).getMessageStatus()) && (object2 = this.getMessageIOType()) == (object3 = ((AVIMMessage)object).getMessageIOType()) && (bl6 = StringUtil.equals(object2 = this.messageId, object3 = ((AVIMMessage)object).messageId)) && (bl6 = StringUtil.equals((List)(object2 = this.mentionList), (List)(object3 = ((AVIMMessage)object).mentionList))) && (bl6 = this.mentionAll) == (bl3 = ((AVIMMessage)object).mentionAll) && (bl2 = StringUtil.equals(object2 = this.uniqueToken, (String)(object = ((AVIMMessage)object).uniqueToken)))) {
            bl4 = bl5;
        }
        return bl4;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void generateUniqueToken() {
        synchronized (this) {
            Object object = this.uniqueToken;
            boolean bl2 = StringUtil.isEmpty((String)object);
            if (bl2) {
                object = UUID.randomUUID();
                this.uniqueToken = object = ((UUID)object).toString();
            }
            return;
        }
    }

    public String getContent() {
        return this.content;
    }

    public String getConversationId() {
        return this.conversationId;
    }

    public long getDeliveredAt() {
        return this.deliveredAt;
    }

    public String getFrom() {
        return this.from;
    }

    public List getMentionList() {
        return this.mentionList;
    }

    public String getMentionListString() {
        Object object;
        int n10;
        Object object2 = this.mentionList;
        if (object2 == null) {
            return "";
        }
        object2 = new StringBuilder();
        for (int i10 = 0; i10 < (n10 = (object = this.mentionList).size()); ++i10) {
            object = (String)this.mentionList.get(i10);
            ((StringBuilder)object2).append((String)object);
            object = this.mentionList;
            n10 = object.size() + -1;
            if (i10 == n10) continue;
            object = ",";
            ((StringBuilder)object2).append((String)object);
        }
        return ((StringBuilder)object2).toString();
    }

    public AVIMMessage$AVIMMessageIOType getMessageIOType() {
        return this.ioType;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public AVIMMessage$AVIMMessageStatus getMessageStatus() {
        return this.status;
    }

    public long getReadAt() {
        return this.readAt;
    }

    public long getReceiptTimestamp() {
        return this.getDeliveredAt();
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getUniqueToken() {
        return this.uniqueToken;
    }

    public long getUpdateAt() {
        return this.updateAt;
    }

    public int hashCode() {
        int n10;
        Object object = this.conversationId;
        int n11 = 0;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = ((String)object).hashCode();
        }
        int n12 = (217 + n10) * 31;
        object = this.content;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = ((String)object).hashCode();
        }
        n12 = (n12 + n10) * 31;
        object = this.from;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = ((String)object).hashCode();
        }
        n12 = (n12 + n10) * 31;
        object = this.messageId;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = ((String)object).hashCode();
        }
        n12 = (n12 + n10) * 31;
        object = this.mentionList;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = object.hashCode();
        }
        n12 = (n12 + n10) * 31;
        object = this.uniqueToken;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = ((String)object).hashCode();
        }
        n12 = (n12 + n10) * 31;
        n10 = (int)this.timestamp;
        n12 = (n12 + n10) * 31;
        n10 = (int)this.deliveredAt;
        n12 = (n12 + n10) * 31;
        n10 = (int)this.readAt;
        n12 = (n12 + n10) * 31;
        long l10 = this.updateAt;
        n10 = (int)l10;
        n12 = (n12 + n10) * 31;
        n10 = (int)(this.mentionAll ? 1 : 0);
        if (n10 != 0) {
            n11 = 17;
        }
        n12 = (n12 + n11) * 31;
        n10 = this.ioType.hashCode();
        n12 = (n12 + n10) * 31;
        n10 = this.status.hashCode();
        return n12 + n10;
    }

    public boolean isMentionAll() {
        return this.mentionAll;
    }

    public boolean mentioned() {
        String string2;
        List list;
        boolean bl2 = this.isMentionAll();
        if (!(bl2 || (list = this.mentionList) != null && (bl2 = list.contains(string2 = this.currentClient)))) {
            bl2 = false;
            list = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public void setContent(String string2) {
        this.content = string2;
    }

    public void setConversationId(String string2) {
        this.conversationId = string2;
    }

    public void setCurrentClient(String string2) {
        this.currentClient = string2;
    }

    public void setDeliveredAt(long l10) {
        this.deliveredAt = l10;
    }

    public void setFrom(String string2) {
        this.from = string2;
    }

    public void setMentionAll(boolean bl2) {
        this.mentionAll = bl2;
    }

    public void setMentionList(List list) {
        this.mentionList = list;
    }

    public void setMentionListString(String stringArray) {
        int n10 = StringUtil.isEmpty((String)stringArray);
        if (n10 != 0) {
            stringArray = null;
            this.mentionList = null;
        } else {
            Object object = new ArrayList();
            this.mentionList = object;
            object = "[,\\s]";
            for (String string2 : stringArray.split((String)object)) {
                boolean bl2 = StringUtil.isEmpty(string2);
                if (bl2) continue;
                List list = this.mentionList;
                list.add(string2);
            }
        }
    }

    public void setMessageIOType(AVIMMessage$AVIMMessageIOType aVIMMessage$AVIMMessageIOType) {
        this.ioType = aVIMMessage$AVIMMessageIOType;
    }

    public void setMessageId(String string2) {
        this.messageId = string2;
    }

    public void setMessageStatus(AVIMMessage$AVIMMessageStatus aVIMMessage$AVIMMessageStatus) {
        this.status = aVIMMessage$AVIMMessageStatus;
    }

    public void setReadAt(long l10) {
        this.readAt = l10;
    }

    public void setReceiptTimestamp(long l10) {
        this.setDeliveredAt(l10);
    }

    public void setTimestamp(long l10) {
        this.timestamp = l10;
    }

    public void setTransient(boolean bl2) {
        this.isTransient = bl2;
    }

    public void setUniqueToken(String string2) {
        this.uniqueToken = string2;
    }

    public void setUpdateAt(long l10) {
        this.updateAt = l10;
    }

    public String toJSONString() {
        return JSON.toJSONString(this.dumpRawData());
    }
}

