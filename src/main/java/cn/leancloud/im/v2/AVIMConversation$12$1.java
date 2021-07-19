/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMConversation$12;
import cn.leancloud.im.v2.AVIMException;
import cn.leancloud.im.v2.AVIMMessage;
import cn.leancloud.im.v2.callback.AVIMMessagesQueryCallback;
import java.util.LinkedList;
import java.util.List;

public class AVIMConversation$12$1
extends AVIMMessagesQueryCallback {
    public final /* synthetic */ AVIMConversation$12 this$1;
    public final /* synthetic */ AVIMMessage val$indicatorMessage;

    public AVIMConversation$12$1(AVIMConversation$12 aVIMConversation$12, AVIMMessage aVIMMessage) {
        this.this$1 = aVIMConversation$12;
        this.val$indicatorMessage = aVIMMessage;
    }

    public void done(List object, AVIMException serializable) {
        if (serializable != null) {
            object = this.this$1.val$callback;
            ((AVCallback)object).internalDone((AVException)serializable);
        } else {
            serializable = new LinkedList();
            Object object2 = this.val$indicatorMessage;
            if (object2 != null) {
                serializable.add(object2);
            }
            if (object != null) {
                serializable.addAll(object);
            }
            AVIMConversation.access$200(this.this$1.this$0, (List)((Object)serializable));
            object = this.this$1;
            object2 = ((AVIMConversation$12)object).this$0;
            String string2 = ((AVIMConversation$12)object).val$msgId;
            long l10 = ((AVIMConversation$12)object).val$timestamp;
            int n10 = ((AVIMConversation$12)object).val$limit;
            AVIMMessagesQueryCallback aVIMMessagesQueryCallback = ((AVIMConversation$12)object).val$callback;
            AVIMConversation.access$300((AVIMConversation)object2, string2, l10, n10, aVIMMessagesQueryCallback);
        }
    }
}

