/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.AVException;
import cn.leancloud.AVLogger;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMException;
import cn.leancloud.im.v2.callback.AVIMCommonJsonCallback;
import cn.leancloud.im.v2.callback.AVIMConversationCallback;
import java.util.Map;

public class AVIMConversation$6
extends AVIMCommonJsonCallback {
    public final /* synthetic */ AVIMConversation this$0;
    public final /* synthetic */ AVIMConversationCallback val$callback;

    public AVIMConversation$6(AVIMConversation aVIMConversation, AVIMConversationCallback aVIMConversationCallback) {
        this.this$0 = aVIMConversation;
        this.val$callback = aVIMConversationCallback;
    }

    public void done(Map object, AVIMException object2) {
        Object object3 = this.val$callback;
        if (object3 == null) {
            return;
        }
        if (object2 == null && object != null) {
            long l10;
            object2 = "callbackReadAt";
            boolean bl2 = object.containsKey(object2);
            long l11 = 0L;
            if (bl2) {
                object2 = (Long)object.get(object2);
                l10 = (Long)object2;
            } else {
                l10 = l11;
            }
            object2 = "callbackDeliveredAt";
            bl2 = object.containsKey(object2);
            if (bl2) {
                object = (Long)object.get(object2);
                l11 = (Long)object;
            }
            object = AVIMConversation.access$000();
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("lastReadAt=");
            ((StringBuilder)object2).append(l10);
            object3 = ", lastDeliverAt=";
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append(l11);
            object2 = ((StringBuilder)object2).toString();
            ((AVLogger)object).d((String)object2);
            this.this$0.setLastReadAt(l10, false);
            this.this$0.setLastDeliveredAt(l11, false);
            object = this.this$0;
            ((AVIMConversation)object).storage.updateConversationTimes((AVIMConversation)object);
            object = this.val$callback;
            object2 = null;
            ((AVCallback)object).internalDone(null, null);
        } else {
            ((AVCallback)object3).internalDone((AVException)object2);
        }
    }
}

