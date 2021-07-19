/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.callback;

import cn.leancloud.AVException;
import cn.leancloud.AVStatus;
import cn.leancloud.callback.AVCallback;

public abstract class StatusCallback
extends AVCallback {
    public abstract void done(AVStatus var1, AVException var2);

    public final void internalDone0(AVStatus aVStatus, AVException aVException) {
        this.done(aVStatus, aVException);
    }
}

