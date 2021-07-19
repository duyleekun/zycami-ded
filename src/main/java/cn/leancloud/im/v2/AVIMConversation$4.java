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
import cn.leancloud.im.v2.callback.AVIMCommonJsonCallback;
import cn.leancloud.im.v2.callback.AVIMMessageUpdatedCallback;
import cn.leancloud.session.AVConnectionManager;

public class AVIMConversation$4
extends SaveCallback {
    public final /* synthetic */ AVIMConversation this$0;
    public final /* synthetic */ AVIMMessageUpdatedCallback val$callback;
    public final /* synthetic */ AVIMMessage val$newMessage;
    public final /* synthetic */ AVIMMessage val$oldMessage;
    public final /* synthetic */ AVIMCommonJsonCallback val$tmpCallback;

    public AVIMConversation$4(AVIMConversation aVIMConversation, AVIMMessage aVIMMessage, AVIMMessageUpdatedCallback aVIMMessageUpdatedCallback, AVIMMessage aVIMMessage2, AVIMCommonJsonCallback aVIMCommonJsonCallback) {
        this.this$0 = aVIMConversation;
        this.val$newMessage = aVIMMessage;
        this.val$callback = aVIMMessageUpdatedCallback;
        this.val$oldMessage = aVIMMessage2;
        this.val$tmpCallback = aVIMCommonJsonCallback;
    }

    public void done(AVException object) {
        if (object != null) {
            Object object2 = this.val$newMessage;
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
            object = this.this$0;
            int n10 = ((AVIMConversation)object).getType();
            AVIMMessage aVIMMessage = this.val$oldMessage;
            AVIMMessage aVIMMessage2 = this.val$newMessage;
            AVIMCommonJsonCallback aVIMCommonJsonCallback = this.val$tmpCallback;
            operationTube.updateMessage(aVConnectionManager, string2, n10, aVIMMessage, aVIMMessage2, aVIMCommonJsonCallback);
        }
    }
}

