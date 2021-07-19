/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.internal.InternalRequestOperation;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;

public class InternalRequestOperation$4
implements OSSCompletedCallback {
    public final /* synthetic */ InternalRequestOperation this$0;
    public final /* synthetic */ OSSCompletedCallback val$completedCallback;

    public InternalRequestOperation$4(InternalRequestOperation internalRequestOperation, OSSCompletedCallback oSSCompletedCallback) {
        this.this$0 = internalRequestOperation;
        this.val$completedCallback = oSSCompletedCallback;
    }

    public void onFailure(PutObjectRequest putObjectRequest, ClientException clientException, ServiceException serviceException) {
        this.val$completedCallback.onFailure(putObjectRequest, clientException, serviceException);
    }

    public void onSuccess(PutObjectRequest putObjectRequest, PutObjectResult putObjectResult) {
        InternalRequestOperation internalRequestOperation = this.this$0;
        OSSCompletedCallback oSSCompletedCallback = this.val$completedCallback;
        InternalRequestOperation.access$100(internalRequestOperation, putObjectRequest, putObjectResult, oSSCompletedCallback);
    }
}

