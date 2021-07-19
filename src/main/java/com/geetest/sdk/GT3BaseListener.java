/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk;

import com.geetest.sdk.GT3ErrorBean;

public interface GT3BaseListener {
    public void onButtonClick();

    public void onClosed(int var1);

    public void onDialogReady(String var1);

    public void onDialogResult(String var1);

    public void onFailed(GT3ErrorBean var1);

    public void onReceiveCaptchaCode(int var1);

    public void onStatistics(String var1);

    public void onSuccess(String var1);
}

