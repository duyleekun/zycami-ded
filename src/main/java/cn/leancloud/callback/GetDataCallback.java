/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.callback;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;

public abstract class GetDataCallback
extends AVCallback {
    public abstract void done(byte[] var1, AVException var2);

    public final void internalDone0(byte[] byArray, AVException aVException) {
        this.done(byArray, aVException);
    }
}

