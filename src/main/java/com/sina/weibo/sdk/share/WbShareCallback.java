/*
 * Decompiled with CFR 0.151.
 */
package com.sina.weibo.sdk.share;

import com.sina.weibo.sdk.common.UiError;

public interface WbShareCallback {
    public void onCancel();

    public void onComplete();

    public void onError(UiError var1);
}

