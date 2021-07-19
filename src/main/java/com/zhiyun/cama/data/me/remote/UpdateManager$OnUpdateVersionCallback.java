/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.me.remote;

import com.zhiyun.cama.data.api.entity.VersionInfo;

public interface UpdateManager$OnUpdateVersionCallback {
    public void onError();

    public void onVersionInfo(VersionInfo var1);
}

