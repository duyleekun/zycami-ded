/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.callback;

import cn.leancloud.AVException;
import cn.leancloud.callback.GenericObjectCallback;

public abstract class GenericRetryCallback
extends GenericObjectCallback {
    public GenericObjectCallback callback;

    public GenericRetryCallback(GenericObjectCallback genericObjectCallback) {
        this.callback = genericObjectCallback;
    }

    public boolean isRequestStatisticNeed() {
        return this.callback.isRequestStatisticNeed();
    }

    public void onFailure(Throwable throwable, String string2) {
        GenericObjectCallback genericObjectCallback = this.callback;
        if (genericObjectCallback != null) {
            genericObjectCallback.onFailure(throwable, string2);
        }
    }

    public void onSuccess(String string2, AVException aVException) {
        GenericObjectCallback genericObjectCallback = this.callback;
        if (genericObjectCallback != null) {
            genericObjectCallback.onSuccess(string2, aVException);
        }
    }
}

