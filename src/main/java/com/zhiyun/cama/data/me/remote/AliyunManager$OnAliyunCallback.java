/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.me.remote;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;

public interface AliyunManager$OnAliyunCallback {
    public void onFailed(ClientException var1, ServiceException var2);

    public void onProgress(int var1);

    public void onSuccess(String var1);
}

