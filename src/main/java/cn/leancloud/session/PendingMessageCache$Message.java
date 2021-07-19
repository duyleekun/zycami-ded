/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.session.PersistentQueue$HasId;

public class PendingMessageCache$Message
implements PersistentQueue$HasId {
    public String cid;
    public String id;
    public String msg;
    public boolean requestReceipt;
    public long timestamp;

    public static PendingMessageCache$Message getMessage(String string2, String string3, boolean bl2, String string4) {
        PendingMessageCache$Message pendingMessageCache$Message = new PendingMessageCache$Message();
        pendingMessageCache$Message.msg = string2;
        pendingMessageCache$Message.setId(string3);
        pendingMessageCache$Message.requestReceipt = bl2;
        pendingMessageCache$Message.cid = string4;
        return pendingMessageCache$Message;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String string2) {
        this.id = string2;
    }
}

