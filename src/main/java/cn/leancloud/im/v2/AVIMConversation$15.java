/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMException;
import cn.leancloud.im.v2.callback.AVIMCommonJsonCallback;
import cn.leancloud.im.v2.callback.AVIMConversationCallback;
import java.util.Map;

public class AVIMConversation$15
extends AVIMCommonJsonCallback {
    public final /* synthetic */ AVIMConversation this$0;
    public final /* synthetic */ AVIMConversationCallback val$callback;

    public AVIMConversation$15(AVIMConversation aVIMConversation, AVIMConversationCallback aVIMConversationCallback) {
        this.this$0 = aVIMConversation;
        this.val$callback = aVIMConversationCallback;
    }

    public void done(Map object, AVIMException object2) {
        String string2;
        if (object2 == null && object != null) {
            object2 = this.this$0;
            string2 = "callbackData";
            object = (String)object.get(string2);
            object2 = ((AVIMConversation)object2).processQueryResult((String)object);
        }
        if ((object = this.val$callback) != null) {
            string2 = null;
            ((AVCallback)object).internalDone(null, (AVException)object2);
        }
    }
}

