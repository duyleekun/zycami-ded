/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.callback;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.query.AVCloudQueryResult;

public abstract class CloudQueryCallback
extends AVCallback {
    public abstract void done(AVCloudQueryResult var1, AVException var2);

    public final void internalDone0(AVCloudQueryResult aVCloudQueryResult, AVException aVException) {
        this.done(aVCloudQueryResult, aVException);
    }
}

