/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2.callback;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.im.v2.AVIMClient$AVIMClientStatus;

public abstract class AVIMClientStatusCallback
extends AVCallback {
    public abstract void done(AVIMClient$AVIMClientStatus var1);

    public void internalDone0(AVIMClient$AVIMClientStatus aVIMClient$AVIMClientStatus, AVException aVException) {
        this.done(aVIMClient$AVIMClientStatus);
    }
}

