/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMException;
import cn.leancloud.im.v2.callback.AVIMMessagesQueryCallback;
import java.util.ArrayList;
import java.util.List;

public class AVIMConversation$13
extends AVIMMessagesQueryCallback {
    public final /* synthetic */ AVIMConversation this$0;
    public final /* synthetic */ AVIMMessagesQueryCallback val$callback;
    public final /* synthetic */ List val$continuousMessages;

    public AVIMConversation$13(AVIMConversation aVIMConversation, List list, AVIMMessagesQueryCallback aVIMMessagesQueryCallback) {
        this.this$0 = aVIMConversation;
        this.val$continuousMessages = list;
        this.val$callback = aVIMMessagesQueryCallback;
    }

    public void done(List object, AVIMException object2) {
        if (object2 != null) {
            object = this.val$continuousMessages;
            int n10 = object.size();
            if (n10 > 0) {
                object = this.val$callback;
                object2 = this.val$continuousMessages;
                ((AVCallback)object).internalDone(object2, null);
            } else {
                object = this.val$callback;
                ((AVCallback)object).internalDone((AVException)object2);
            }
        } else {
            if (object == null) {
                object = new ArrayList();
            }
            this.val$continuousMessages.addAll(object);
            object = this.this$0;
            object2 = this.val$continuousMessages;
            AVIMConversation.access$200((AVIMConversation)object, (List)object2);
            object = this.val$callback;
            object2 = this.val$continuousMessages;
            ((AVCallback)object).internalDone(object2, null);
        }
    }
}

