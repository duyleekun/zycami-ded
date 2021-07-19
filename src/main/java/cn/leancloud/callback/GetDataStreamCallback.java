/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.callback;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import java.io.InputStream;

public abstract class GetDataStreamCallback
extends AVCallback {
    public abstract void done(InputStream var1, AVException var2);

    public final void internalDone0(InputStream inputStream, AVException aVException) {
        this.done(inputStream, aVException);
    }
}

