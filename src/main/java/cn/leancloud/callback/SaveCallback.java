/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.callback;

import cn.leancloud.AVException;
import cn.leancloud.AVObject;
import cn.leancloud.callback.AVCallback;

public abstract class SaveCallback
extends AVCallback {
    public abstract void done(AVException var1);

    public final void internalDone0(AVObject aVObject, AVException aVException) {
        this.done(aVException);
    }
}

