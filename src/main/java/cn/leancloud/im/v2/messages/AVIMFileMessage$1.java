/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2.messages;

import cn.leancloud.AVException;
import cn.leancloud.callback.SaveCallback;
import cn.leancloud.im.v2.messages.AVIMFileMessage;

public class AVIMFileMessage$1
extends SaveCallback {
    public final /* synthetic */ AVIMFileMessage this$0;
    public final /* synthetic */ SaveCallback val$callback;

    public AVIMFileMessage$1(AVIMFileMessage aVIMFileMessage, SaveCallback saveCallback) {
        this.this$0 = aVIMFileMessage;
        this.val$callback = saveCallback;
    }

    public void done(AVException object) {
        if (object != null) {
            SaveCallback saveCallback = this.val$callback;
            saveCallback.internalDone((AVException)object);
        } else {
            object = this.this$0;
            SaveCallback saveCallback = this.val$callback;
            ((AVIMFileMessage)object).fulFillFileInfo(saveCallback);
        }
    }
}

