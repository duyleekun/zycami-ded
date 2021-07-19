/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.AVException;
import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMException;
import cn.leancloud.im.v2.callback.AVIMConversationMemberQueryCallback;
import e.a.g0;
import e.a.s0.b;
import java.util.List;

public class AVIMClient$4
implements g0 {
    public final /* synthetic */ AVIMClient this$0;
    public final /* synthetic */ AVIMConversationMemberQueryCallback val$callback;

    public AVIMClient$4(AVIMClient aVIMClient, AVIMConversationMemberQueryCallback aVIMConversationMemberQueryCallback) {
        this.this$0 = aVIMClient;
        this.val$callback = aVIMConversationMemberQueryCallback;
    }

    public void onComplete() {
    }

    public void onError(Throwable throwable) {
        AVIMConversationMemberQueryCallback aVIMConversationMemberQueryCallback = this.val$callback;
        throwable = AVIMException.wrapperAVException(throwable);
        aVIMConversationMemberQueryCallback.internalDone(null, (AVException)throwable);
    }

    public void onNext(List list) {
        this.val$callback.internalDone(list, null);
    }

    public void onSubscribe(b b10) {
    }
}

