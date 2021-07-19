/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.AVLogger;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.im.v2.AVIMConversationsQuery;
import cn.leancloud.im.v2.AVIMException;
import cn.leancloud.im.v2.callback.AVIMConversationQueryCallback;
import java.util.List;
import java.util.Map;

public class AVIMConversationsQuery$1
extends AVIMConversationQueryCallback {
    public final /* synthetic */ AVIMConversationsQuery this$0;
    public final /* synthetic */ AVIMConversationQueryCallback val$callback;
    public final /* synthetic */ Map val$queryParams;

    public AVIMConversationsQuery$1(AVIMConversationsQuery aVIMConversationsQuery, AVIMConversationQueryCallback aVIMConversationQueryCallback, Map map) {
        this.this$0 = aVIMConversationsQuery;
        this.val$callback = aVIMConversationQueryCallback;
        this.val$queryParams = map;
    }

    public void done(List object, AVIMException object2) {
        if (object2 != null) {
            object = AVIMConversationsQuery.access$000();
            Object object3 = new StringBuilder();
            String string2 = "failed to query cache. cause:";
            ((StringBuilder)object3).append(string2);
            object2 = ((Throwable)object2).getMessage();
            ((StringBuilder)object3).append((String)object2);
            object2 = ((StringBuilder)object3).toString();
            ((AVLogger)object).d((String)object2);
            object = this.this$0;
            object2 = this.val$callback;
            object3 = this.val$queryParams;
            AVIMConversationsQuery.access$100((AVIMConversationsQuery)object, (AVIMConversationQueryCallback)object2, (Map)object3);
        } else {
            object2 = this.val$callback;
            if (object2 != null) {
                Object var3_4 = null;
                ((AVCallback)object2).internalDone(object, null);
            }
        }
    }
}

