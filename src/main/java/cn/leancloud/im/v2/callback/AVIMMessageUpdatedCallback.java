/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2.callback;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.im.v2.AVIMMessage;

public abstract class AVIMMessageUpdatedCallback
extends AVCallback {
    public abstract void done(AVIMMessage var1, AVException var2);

    public void internalDone0(AVIMMessage aVIMMessage, AVException aVException) {
        this.done(aVIMMessage, aVException);
    }
}

