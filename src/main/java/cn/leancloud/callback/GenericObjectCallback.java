/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.callback;

import cn.leancloud.AVException;
import cn.leancloud.AVObject;

public abstract class GenericObjectCallback {
    public boolean isRequestStatisticNeed() {
        return true;
    }

    public boolean isRetryNeeded(int n10, Throwable throwable) {
        return false;
    }

    public void onFailure(int n10, Throwable throwable, String string2) {
        if ((n10 = (int)(this.isRetryNeeded(n10, throwable) ? 1 : 0)) != 0) {
            this.retry(throwable, string2);
        } else {
            this.onFailure(throwable, string2);
        }
    }

    public void onFailure(Throwable throwable, String string2) {
    }

    public void onGroupRequestFinished(int n10, int n11, AVObject aVObject) {
    }

    public void onSuccess(String string2, AVException aVException) {
    }

    public void retry(Throwable throwable, String string2) {
    }
}

