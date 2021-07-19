/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.callback;

import cn.leancloud.AVException;
import cn.leancloud.AVFile;
import cn.leancloud.callback.AVCallback;

public abstract class GetFileCallback
extends AVCallback {
    public abstract void done(AVFile var1, AVException var2);

    public final void internalDone0(AVFile aVFile, AVException aVException) {
        this.done(aVFile, aVException);
    }
}

