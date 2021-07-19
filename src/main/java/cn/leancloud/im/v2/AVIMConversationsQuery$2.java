/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.AVException;
import cn.leancloud.im.v2.AVIMConversationsQuery;
import cn.leancloud.im.v2.callback.AVIMConversationQueryCallback;
import e.a.g0;
import e.a.s0.b;
import java.util.List;

public class AVIMConversationsQuery$2
implements g0 {
    public final /* synthetic */ AVIMConversationsQuery this$0;
    public final /* synthetic */ AVIMConversationQueryCallback val$callback;

    public AVIMConversationsQuery$2(AVIMConversationsQuery aVIMConversationsQuery, AVIMConversationQueryCallback aVIMConversationQueryCallback) {
        this.this$0 = aVIMConversationsQuery;
        this.val$callback = aVIMConversationQueryCallback;
    }

    public void onComplete() {
    }

    public void onError(Throwable throwable) {
        AVIMConversationQueryCallback aVIMConversationQueryCallback = this.val$callback;
        if (aVIMConversationQueryCallback != null) {
            AVException aVException = new AVException(throwable);
            aVIMConversationQueryCallback.internalDone(null, aVException);
        }
    }

    public void onNext(List list) {
        AVIMConversationQueryCallback aVIMConversationQueryCallback = this.val$callback;
        if (aVIMConversationQueryCallback != null) {
            aVIMConversationQueryCallback.internalDone(list, null);
        }
    }

    public void onSubscribe(b b10) {
    }
}

