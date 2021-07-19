/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMException;
import cn.leancloud.im.v2.callback.AVIMClientCallback;
import cn.leancloud.im.v2.callback.AVIMConversationMemberQueryCallback;
import cn.leancloud.query.QueryConditions;

public class AVIMClient$3
extends AVIMClientCallback {
    public final /* synthetic */ AVIMClient this$0;
    public final /* synthetic */ AVIMConversationMemberQueryCallback val$cb;
    public final /* synthetic */ QueryConditions val$queryConditions;

    public AVIMClient$3(AVIMClient aVIMClient, AVIMConversationMemberQueryCallback aVIMConversationMemberQueryCallback, QueryConditions queryConditions) {
        this.this$0 = aVIMClient;
        this.val$cb = aVIMConversationMemberQueryCallback;
        this.val$queryConditions = queryConditions;
    }

    public void done(AVIMClient object, AVIMException object2) {
        if (object2 != null) {
            object = this.val$cb;
            Object var3_3 = null;
            object2 = AVIMException.wrapperAVException((Throwable)object2);
            ((AVCallback)object).internalDone(null, (AVException)object2);
        } else {
            object = this.this$0;
            object2 = this.val$queryConditions;
            AVIMConversationMemberQueryCallback aVIMConversationMemberQueryCallback = this.val$cb;
            AVIMClient.access$200((AVIMClient)object, (QueryConditions)object2, aVIMConversationMemberQueryCallback);
        }
    }
}

