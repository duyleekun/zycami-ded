/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2.callback;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.im.v2.messages.AVIMRecalledMessage;

public abstract class AVIMMessageRecalledCallback
extends AVCallback {
    public abstract void done(AVIMRecalledMessage var1, AVException var2);

    public void internalDone0(AVIMRecalledMessage aVIMRecalledMessage, AVException aVException) {
        this.done(aVIMRecalledMessage, aVException);
    }
}

