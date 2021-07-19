/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.callback;

import cn.leancloud.AVException;
import cn.leancloud.AVUser;
import cn.leancloud.callback.AVCallback;

public abstract class SignUpCallback
extends AVCallback {
    public abstract void done(AVException var1);

    public final void internalDone0(AVUser aVUser, AVException aVException) {
        this.done(aVException);
    }
}

