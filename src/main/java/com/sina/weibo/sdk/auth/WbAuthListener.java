/*
 * Decompiled with CFR 0.151.
 */
package com.sina.weibo.sdk.auth;

import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.common.UiError;

public interface WbAuthListener {
    public void onCancel();

    public void onComplete(Oauth2AccessToken var1);

    public void onError(UiError var1);
}

