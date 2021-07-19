/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMConversation$12$1;
import cn.leancloud.im.v2.AVIMConversation$12$2;
import cn.leancloud.im.v2.AVIMMessage;
import cn.leancloud.im.v2.AVIMMessageStorage;
import cn.leancloud.im.v2.AVIMMessageStorage$StorageMessageCallback;
import cn.leancloud.im.v2.callback.AVIMMessagesQueryCallback;

public class AVIMConversation$12
implements AVIMMessageStorage$StorageMessageCallback {
    public final /* synthetic */ AVIMConversation this$0;
    public final /* synthetic */ AVIMMessagesQueryCallback val$callback;
    public final /* synthetic */ String val$conversationId;
    public final /* synthetic */ int val$limit;
    public final /* synthetic */ String val$msgId;
    public final /* synthetic */ long val$timestamp;

    public AVIMConversation$12(AVIMConversation aVIMConversation, String string2, long l10, int n10, AVIMMessagesQueryCallback aVIMMessagesQueryCallback, String string3) {
        this.this$0 = aVIMConversation;
        this.val$msgId = string2;
        this.val$timestamp = l10;
        this.val$limit = n10;
        this.val$callback = aVIMMessagesQueryCallback;
        this.val$conversationId = string3;
    }

    public void done(AVIMMessage aVIMMessage, boolean bl2) {
        AVIMConversation$12 aVIMConversation$12 = this;
        Object object = aVIMMessage;
        if (aVIMMessage != null && !bl2) {
            object = this.this$0;
            AVIMMessageStorage aVIMMessageStorage = ((AVIMConversation)object).storage;
            String string2 = this.val$msgId;
            long l10 = this.val$timestamp;
            int n10 = this.val$limit;
            String string3 = this.val$conversationId;
            AVIMConversation$12$2 aVIMConversation$12$2 = new AVIMConversation$12$2(this);
            aVIMMessageStorage.getMessages(string2, l10, n10, string3, aVIMConversation$12$2);
        } else {
            String string4 = aVIMConversation$12.val$msgId;
            long l11 = aVIMConversation$12.val$timestamp;
            int n11 = aVIMConversation$12.val$limit;
            AVIMConversation aVIMConversation = aVIMConversation$12.this$0;
            long l12 = 0L;
            AVIMConversation$12$1 aVIMConversation$12$1 = new AVIMConversation$12$1(aVIMConversation$12, (AVIMMessage)object);
            AVIMConversation.access$400(aVIMConversation, string4, l11, n11, null, l12, aVIMConversation$12$1);
        }
    }
}

