/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2.callback;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMException;

public abstract class AVIMClientCallback
extends AVCallback {
    public abstract void done(AVIMClient var1, AVIMException var2);

    public void internalDone0(AVIMClient aVIMClient, AVException aVException) {
        aVException = AVIMException.wrapperAVException(aVException);
        this.done(aVIMClient, (AVIMException)aVException);
    }
}

