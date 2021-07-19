/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMMessageStorage$StorageQueryCallback;
import cn.leancloud.im.v2.callback.AVIMMessagesQueryCallback;
import java.util.Collections;
import java.util.List;

public class AVIMConversation$8
implements AVIMMessageStorage$StorageQueryCallback {
    public final /* synthetic */ AVIMConversation this$0;
    public final /* synthetic */ AVIMMessagesQueryCallback val$callback;

    public AVIMConversation$8(AVIMConversation aVIMConversation, AVIMMessagesQueryCallback aVIMMessagesQueryCallback) {
        this.this$0 = aVIMConversation;
        this.val$callback = aVIMMessagesQueryCallback;
    }

    public void done(List list, List list2) {
        if (list != null) {
            Collections.reverse(list);
        }
        this.val$callback.internalDone(list, null);
    }
}

