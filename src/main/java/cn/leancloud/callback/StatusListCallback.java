/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.callback;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import java.util.List;

public abstract class StatusListCallback
extends AVCallback {
    public abstract void done(List var1, AVException var2);

    public final void internalDone0(List list, AVException aVException) {
        this.done(list, aVException);
    }
}

