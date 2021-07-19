/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMException;
import cn.leancloud.im.v2.callback.AVIMCommonJsonCallback;
import cn.leancloud.session.AVConversationHolder;
import cn.leancloud.session.AVConversationHolder$SimpleCallback;
import java.util.Map;

public class AVConversationHolder$21
extends AVIMCommonJsonCallback {
    public final /* synthetic */ AVConversationHolder this$0;
    public final /* synthetic */ AVConversationHolder$SimpleCallback val$callback;
    public final /* synthetic */ AVIMConversation val$conversation;

    public AVConversationHolder$21(AVConversationHolder aVConversationHolder, AVIMConversation aVIMConversation, AVConversationHolder$SimpleCallback aVConversationHolder$SimpleCallback) {
        this.this$0 = aVConversationHolder;
        this.val$conversation = aVIMConversation;
        this.val$callback = aVConversationHolder$SimpleCallback;
    }

    public void done(Map object, AVIMException object2) {
        if (object != null) {
            object2 = this.val$conversation;
            String string2 = "callbackData";
            object = (String)object.get(string2);
            ((AVIMConversation)object2).processQueryResult((String)object);
            object = this.val$callback;
            if (object != null) {
                ((AVConversationHolder$SimpleCallback)object).done();
            }
        }
    }
}

