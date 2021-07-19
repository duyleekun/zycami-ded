/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.callback;

import cn.leancloud.AVException;
import cn.leancloud.AVObject;
import cn.leancloud.callback.AVCallback;

public abstract class GetCallback
extends AVCallback {
    public abstract void done(AVObject var1, AVException var2);

    public final void internalDone0(AVObject aVObject, AVException aVException) {
        this.done(aVObject, aVException);
    }
}

