/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2.callback;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.im.v2.AVIMException;
import cn.leancloud.im.v2.callback.AVIMConversationIterableResult;

public abstract class AVIMConversationIterableResultCallback
extends AVCallback {
    public abstract void done(AVIMConversationIterableResult var1, AVIMException var2);

    public final void internalDone0(AVIMConversationIterableResult aVIMConversationIterableResult, AVException aVException) {
        aVException = AVIMException.wrapperAVException(aVException);
        this.done(aVIMConversationIterableResult, (AVIMException)aVException);
    }
}

