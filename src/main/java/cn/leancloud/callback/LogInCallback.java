/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.callback;

import cn.leancloud.AVException;
import cn.leancloud.AVUser;
import cn.leancloud.callback.AVCallback;

public abstract class LogInCallback
extends AVCallback {
    public abstract void done(AVUser var1, AVException var2);

    public final void internalDone0(AVUser aVUser, AVException aVException) {
        this.done(aVUser, aVException);
    }
}

