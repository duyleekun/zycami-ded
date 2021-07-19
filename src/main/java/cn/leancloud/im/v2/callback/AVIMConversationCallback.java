/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2.callback;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.im.v2.AVIMException;

public abstract class AVIMConversationCallback
extends AVCallback {
    public abstract void done(AVIMException var1);

    public final void internalDone0(Void object, AVException aVException) {
        object = AVIMException.wrapperAVException(aVException);
        this.done((AVIMException)object);
    }
}

