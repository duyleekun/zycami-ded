/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMException;
import cn.leancloud.im.v2.AVIMMessage;
import cn.leancloud.im.v2.AVIMMessage$AVIMMessageStatus;
import cn.leancloud.im.v2.callback.AVIMCommonJsonCallback;
import cn.leancloud.im.v2.callback.AVIMMessageRecalledCallback;
import cn.leancloud.im.v2.messages.AVIMRecalledMessage;
import java.util.Map;

public class AVIMConversation$5
extends AVIMCommonJsonCallback {
    public final /* synthetic */ AVIMConversation this$0;
    public final /* synthetic */ AVIMMessageRecalledCallback val$callback;
    public final /* synthetic */ AVIMMessage val$message;

    public AVIMConversation$5(AVIMConversation aVIMConversation, AVIMMessageRecalledCallback aVIMMessageRecalledCallback, AVIMMessage aVIMMessage) {
        this.this$0 = aVIMConversation;
        this.val$callback = aVIMMessageRecalledCallback;
        this.val$message = aVIMMessage;
    }

    public void done(Map object, AVIMException object2) {
        if (object2 == null && object != null) {
            long l10 = 0L;
            object2 = "message_patch_time";
            boolean bl2 = object.containsKey(object2);
            if (bl2) {
                object = (Long)object.get(object2);
                l10 = (Long)object;
            }
            object = new AVIMRecalledMessage();
            object2 = this.this$0;
            AVIMMessage aVIMMessage = this.val$message;
            AVIMConversation.access$100((AVIMConversation)object2, aVIMMessage, (AVIMMessage)object);
            ((AVIMMessage)object).setUpdateAt(l10);
            object2 = AVIMMessage$AVIMMessageStatus.AVIMMessageStatusRecalled;
            ((AVIMMessage)object).setMessageStatus((AVIMMessage$AVIMMessageStatus)((Object)object2));
            this.this$0.updateLocalMessage((AVIMMessage)object);
            object2 = this.val$callback;
            if (object2 != null) {
                ((AVCallback)object2).internalDone(object, null);
            }
        } else {
            object = this.val$callback;
            if (object != null) {
                ((AVCallback)object).internalDone(null, (AVException)object2);
            }
        }
    }
}

