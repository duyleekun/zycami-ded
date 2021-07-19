/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.callback;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;

public abstract class ProgressCallback
extends AVCallback {
    public abstract void done(Integer var1);

    public final void internalDone0(Integer n10, AVException aVException) {
        this.done(n10);
    }
}

