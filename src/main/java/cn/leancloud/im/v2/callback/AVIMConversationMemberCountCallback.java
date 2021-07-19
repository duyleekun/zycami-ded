/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2.callback;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.im.v2.AVIMException;

public abstract class AVIMConversationMemberCountCallback
extends AVCallback {
    public abstract void done(Integer var1, AVIMException var2);

    public final void internalDone0(Integer n10, AVException aVException) {
        aVException = AVIMException.wrapperAVException(aVException);
        this.done(n10, (AVIMException)aVException);
    }
}

