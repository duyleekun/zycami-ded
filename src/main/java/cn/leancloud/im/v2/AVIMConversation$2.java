/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.callback.SaveCallback;
import cn.leancloud.im.InternalConfiguration;
import cn.leancloud.im.OperationTube;
import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMMessage;
import cn.leancloud.im.v2.AVIMMessage$AVIMMessageStatus;
import cn.leancloud.im.v2.AVIMMessageOption;
import cn.leancloud.im.v2.callback.AVIMCommonJsonCallback;
import cn.leancloud.im.v2.callback.AVIMConversationCallback;
import cn.leancloud.session.AVConnectionManager;

public class AVIMConversation$2
extends SaveCallback {
    public final /* synthetic */ AVIMConversation this$0;
    public final /* synthetic */ AVIMConversationCallback val$callback;
    public final /* synthetic */ AVIMMessage val$message;
    public final /* synthetic */ AVIMMessageOption val$messageOption;
    public final /* synthetic */ AVIMCommonJsonCallback val$wrapperCallback;

    public AVIMConversation$2(AVIMConversation aVIMConversation, AVIMMessage aVIMMessage, AVIMConversationCallback aVIMConversationCallback, AVIMMessageOption aVIMMessageOption, AVIMCommonJsonCallback aVIMCommonJsonCallback) {
        this.this$0 = aVIMConversation;
        this.val$message = aVIMMessage;
        this.val$callback = aVIMConversationCallback;
        this.val$messageOption = aVIMMessageOption;
        this.val$wrapperCallback = aVIMCommonJsonCallback;
    }

    public void done(AVException object) {
        if (object != null) {
            Object object2 = this.val$message;
            AVIMMessage$AVIMMessageStatus aVIMMessage$AVIMMessageStatus = AVIMMessage$AVIMMessageStatus.AVIMMessageStatusFailed;
            ((AVIMMessage)object2).setMessageStatus(aVIMMessage$AVIMMessageStatus);
            object2 = this.val$callback;
            if (object2 != null) {
                ((AVCallback)object2).internalDone((AVException)object);
            }
        } else {
            OperationTube operationTube = InternalConfiguration.getOperationTube();
            AVConnectionManager aVConnectionManager = this.this$0.client.getConnectionManager();
            String string2 = this.this$0.client.getClientId();
            String string3 = this.this$0.getConversationId();
            object = this.this$0;
            int n10 = ((AVIMConversation)object).getType();
            AVIMMessage aVIMMessage = this.val$message;
            AVIMMessageOption aVIMMessageOption = this.val$messageOption;
            AVIMCommonJsonCallback aVIMCommonJsonCallback = this.val$wrapperCallback;
            operationTube.sendMessage(aVConnectionManager, string2, string3, n10, aVIMMessage, aVIMMessageOption, aVIMCommonJsonCallback);
        }
    }
}

