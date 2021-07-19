/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2.callback;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.im.v2.AVIMException;
import cn.leancloud.im.v2.AVIMMessage;

public abstract class AVIMSingleMessageQueryCallback
extends AVCallback {
    public abstract void done(AVIMMessage var1, AVIMException var2);

    public final void internalDone0(AVIMMessage aVIMMessage, AVException aVException) {
        aVException = AVIMException.wrapperAVException(aVException);
        this.done(aVIMMessage, (AVIMException)aVException);
    }
}

