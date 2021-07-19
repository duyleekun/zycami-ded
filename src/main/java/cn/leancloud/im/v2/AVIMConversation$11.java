/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMException;
import cn.leancloud.im.v2.callback.AVIMMessagesQueryCallback;
import java.util.List;

public class AVIMConversation$11
extends AVIMMessagesQueryCallback {
    public final /* synthetic */ AVIMConversation this$0;
    public final /* synthetic */ AVIMMessagesQueryCallback val$callback;

    public AVIMConversation$11(AVIMConversation aVIMConversation, AVIMMessagesQueryCallback aVIMMessagesQueryCallback) {
        this.this$0 = aVIMConversation;
        this.val$callback = aVIMMessagesQueryCallback;
    }

    public void done(List list, AVIMException aVIMException) {
        AVIMMessagesQueryCallback aVIMMessagesQueryCallback = this.val$callback;
        if (aVIMMessagesQueryCallback != null) {
            if (aVIMException != null) {
                aVIMMessagesQueryCallback.internalDone(aVIMException);
            } else {
                aVIMException = null;
                aVIMMessagesQueryCallback.internalDone(list, null);
            }
        }
    }
}

