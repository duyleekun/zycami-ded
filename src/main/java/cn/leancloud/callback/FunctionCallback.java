/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.callback;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;

public abstract class FunctionCallback
extends AVCallback {
    public abstract void done(Object var1, AVException var2);

    public final void internalDone0(Object object, AVException aVException) {
        this.done(object, aVException);
    }
}

