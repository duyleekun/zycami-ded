/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2.callback;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMException;

public abstract class AVIMConversationCreatedCallback
extends AVCallback {
    public abstract void done(AVIMConversation var1, AVIMException var2);

    public final void internalDone0(AVIMConversation aVIMConversation, AVException aVException) {
        aVException = AVIMException.wrapperAVException(aVException);
        this.done(aVIMConversation, (AVIMException)aVException);
    }
}

