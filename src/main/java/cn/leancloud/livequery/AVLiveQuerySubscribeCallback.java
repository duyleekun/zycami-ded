/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.livequery;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;

public abstract class AVLiveQuerySubscribeCallback
extends AVCallback {
    public abstract void done(AVException var1);

    public void internalDone0(Void void_, AVException aVException) {
        this.done(aVException);
    }
}

