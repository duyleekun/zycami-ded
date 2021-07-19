/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.me.remote;

public interface SharePlatformManager$OnShareCallback {
    default public void onShareCancel() {
    }

    public void onShareFailed(String var1);

    public void onShareSuccess();
}

