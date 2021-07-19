/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.callback;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.OSSResult;

public interface OSSCompletedCallback {
    public void onFailure(OSSRequest var1, ClientException var2, ServiceException var3);

    public void onSuccess(OSSRequest var1, OSSResult var2);
}

