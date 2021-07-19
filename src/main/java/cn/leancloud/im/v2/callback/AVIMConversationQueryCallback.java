/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2.callback;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.im.v2.AVIMException;
import java.util.List;

public abstract class AVIMConversationQueryCallback
extends AVCallback {
    public abstract void done(List var1, AVIMException var2);

    public final void internalDone0(List list, AVException aVException) {
        aVException = AVIMException.wrapperAVException(aVException);
        this.done(list, (AVIMException)aVException);
    }
}

