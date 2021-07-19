/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.callback;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.types.AVNull;

public abstract class SendCallback
extends AVCallback {
    public abstract void done(AVException var1);

    public final void internalDone0(AVNull aVNull, AVException aVException) {
        this.done(aVException);
    }
}

