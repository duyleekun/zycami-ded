/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMException;
import cn.leancloud.im.v2.AVIMMessage;
import cn.leancloud.im.v2.callback.AVIMCommonJsonCallback;
import cn.leancloud.im.v2.callback.AVIMMessageUpdatedCallback;
import java.util.Map;

public class AVIMConversation$3
extends AVIMCommonJsonCallback {
    public final /* synthetic */ AVIMConversation this$0;
    public final /* synthetic */ AVIMMessageUpdatedCallback val$callback;
    public final /* synthetic */ AVIMMessage val$newMessage;
    public final /* synthetic */ AVIMMessage val$oldMessage;

    public AVIMConversation$3(AVIMConversation aVIMConversation, AVIMMessageUpdatedCallback aVIMMessageUpdatedCallback, AVIMMessage aVIMMessage, AVIMMessage aVIMMessage2) {
        this.this$0 = aVIMConversation;
        this.val$callback = aVIMMessageUpdatedCallback;
        this.val$oldMessage = aVIMMessage;
        this.val$newMessage = aVIMMessage2;
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
            object = this.this$0;
            object2 = this.val$oldMessage;
            AVIMMessage aVIMMessage = this.val$newMessage;
            AVIMConversation.access$100((AVIMConversation)object, (AVIMMessage)object2, aVIMMessage);
            this.val$newMessage.setUpdateAt(l10);
            object = this.this$0;
            object2 = this.val$newMessage;
            ((AVIMConversation)object).updateLocalMessage((AVIMMessage)object2);
            object = this.val$callback;
            if (object != null) {
                object2 = this.val$newMessage;
                ((AVCallback)object).internalDone(object2, null);
            }
        } else {
            object = this.val$callback;
            if (object != null) {
                ((AVCallback)object).internalDone(null, (AVException)object2);
            }
        }
    }
}

