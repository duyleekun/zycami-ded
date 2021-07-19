/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMConversation$12;
import cn.leancloud.im.v2.AVIMMessageStorage$StorageQueryCallback;
import cn.leancloud.im.v2.callback.AVIMMessagesQueryCallback;
import java.util.List;

public class AVIMConversation$12$2
implements AVIMMessageStorage$StorageQueryCallback {
    public final /* synthetic */ AVIMConversation$12 this$1;

    public AVIMConversation$12$2(AVIMConversation$12 aVIMConversation$12) {
        this.this$1 = aVIMConversation$12;
    }

    public void done(List list, List list2) {
        AVIMConversation$12 aVIMConversation$12 = this.this$1;
        AVIMConversation aVIMConversation = aVIMConversation$12.this$0;
        String string2 = aVIMConversation$12.val$msgId;
        long l10 = aVIMConversation$12.val$timestamp;
        int n10 = aVIMConversation$12.val$limit;
        AVIMMessagesQueryCallback aVIMMessagesQueryCallback = aVIMConversation$12.val$callback;
        AVIMConversation.access$500(aVIMConversation, list, list2, string2, l10, n10, aVIMMessagesQueryCallback);
    }
}

