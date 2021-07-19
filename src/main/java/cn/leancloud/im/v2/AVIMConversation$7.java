/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.im.AVIMOptions;
import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMException;
import cn.leancloud.im.v2.callback.AVIMMessagesQueryCallback;
import java.util.List;

public class AVIMConversation$7
extends AVIMMessagesQueryCallback {
    public final /* synthetic */ AVIMConversation this$0;
    public final /* synthetic */ AVIMMessagesQueryCallback val$callback;

    public AVIMConversation$7(AVIMConversation aVIMConversation, AVIMMessagesQueryCallback aVIMMessagesQueryCallback) {
        this.this$0 = aVIMConversation;
        this.val$callback = aVIMMessagesQueryCallback;
    }

    public void done(List object, AVIMException object2) {
        if (object2 == null) {
            object2 = AVIMOptions.getGlobalOptions();
            boolean bl2 = ((AVIMOptions)object2).isMessageQueryCacheEnabled();
            if (bl2) {
                object2 = this.this$0;
                AVIMConversation.access$200((AVIMConversation)object2, (List)object);
            }
            object2 = this.val$callback;
            ((AVCallback)object2).internalDone(object, null);
        } else {
            object = this.val$callback;
            ((AVCallback)object).internalDone(null, (AVException)object2);
        }
    }
}

