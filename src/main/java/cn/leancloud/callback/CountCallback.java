/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.callback;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;

public abstract class CountCallback
extends AVCallback {
    public abstract void done(int var1, AVException var2);

    public final void internalDone0(Integer n10, AVException aVException) {
        int n11 = n10 == null ? -1 : n10;
        this.done(n11, aVException);
    }
}

