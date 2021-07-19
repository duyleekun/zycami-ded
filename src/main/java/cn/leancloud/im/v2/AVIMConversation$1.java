/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.AVLogger;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.im.AVIMOptions;
import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMException;
import cn.leancloud.im.v2.AVIMMessage;
import cn.leancloud.im.v2.AVIMMessage$AVIMMessageStatus;
import cn.leancloud.im.v2.AVIMMessageOption;
import cn.leancloud.im.v2.AVIMMessageStorage;
import cn.leancloud.im.v2.callback.AVIMCommonJsonCallback;
import cn.leancloud.im.v2.callback.AVIMConversationCallback;
import java.util.Date;
import java.util.Map;

public class AVIMConversation$1
extends AVIMCommonJsonCallback {
    public final /* synthetic */ AVIMConversation this$0;
    public final /* synthetic */ AVIMConversationCallback val$callback;
    public final /* synthetic */ AVIMMessage val$message;
    public final /* synthetic */ AVIMMessageOption val$messageOption;

    public AVIMConversation$1(AVIMConversation aVIMConversation, AVIMMessage aVIMMessage, AVIMMessageOption aVIMMessageOption, AVIMConversationCallback aVIMConversationCallback) {
        this.this$0 = aVIMConversation;
        this.val$message = aVIMMessage;
        this.val$messageOption = aVIMMessageOption;
        this.val$callback = aVIMConversationCallback;
    }

    public void done(Map object, AVIMException aVIMException) {
        if (aVIMException == null && object != null) {
            boolean bl2;
            Object object2 = (String)object.get("callbackMessageId");
            object = (Long)object.get("callbackMessageTimeStamp");
            Object object3 = this.val$message;
            object3.setMessageId((String)object2);
            if (object != null) {
                object2 = this.val$message;
                long l10 = (Long)object;
                ((AVIMMessage)object2).setTimestamp(l10);
            }
            object2 = this.val$message;
            object3 = AVIMMessage$AVIMMessageStatus.AVIMMessageStatusSent;
            ((AVIMMessage)object2).setMessageStatus((AVIMMessage$AVIMMessageStatus)((Object)object3));
            object2 = this.val$messageOption;
            if ((object2 == null || !(bl2 = ((AVIMMessageOption)object2).isTransient())) && (bl2 = ((AVIMOptions)(object2 = AVIMOptions.getGlobalOptions())).isMessageQueryCacheEnabled())) {
                object2 = this.this$0;
                object3 = this.val$message;
                ((AVIMConversation)object2).setLastMessage((AVIMMessage)object3);
                object2 = this.this$0.storage;
                object3 = this.val$message;
                ((AVIMMessageStorage)object2).insertMessage((AVIMMessage)object3, false);
            } else {
                object2 = AVIMConversation.access$000();
                object3 = "skip inserting into local storage.";
                ((AVLogger)object2).d((String)object3);
            }
            object2 = this.this$0;
            if (object != null) {
                long l11 = (Long)object;
                object3 = new Date(l11);
            } else {
                object3 = new Date();
            }
            ((AVIMConversation)object2).lastMessageAt = object3;
            object = this.this$0;
            object2 = ((AVIMConversation)object).storage;
            ((AVIMMessageStorage)object2).updateConversationLastMessageAt((AVIMConversation)object);
        } else {
            object = this.val$message;
            AVIMMessage$AVIMMessageStatus aVIMMessage$AVIMMessageStatus = AVIMMessage$AVIMMessageStatus.AVIMMessageStatusFailed;
            ((AVIMMessage)object).setMessageStatus(aVIMMessage$AVIMMessageStatus);
        }
        object = this.val$callback;
        if (object != null) {
            aVIMException = AVIMException.wrapperAVException(aVIMException);
            ((AVCallback)object).internalDone(aVIMException);
        }
    }
}

