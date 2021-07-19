/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.alibaba.sdk.android.oss.common.utils.CRC64
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.common.utils.CRC64;
import com.alibaba.sdk.android.oss.internal.InternalRequestOperation;
import com.alibaba.sdk.android.oss.model.AppendObjectRequest;
import com.alibaba.sdk.android.oss.model.AppendObjectResult;
import com.alibaba.sdk.android.oss.model.OSSRequest$CRC64Config;

public class InternalRequestOperation$5
implements OSSCompletedCallback {
    public final /* synthetic */ InternalRequestOperation this$0;
    public final /* synthetic */ OSSCompletedCallback val$completedCallback;

    public InternalRequestOperation$5(InternalRequestOperation internalRequestOperation, OSSCompletedCallback oSSCompletedCallback) {
        this.this$0 = internalRequestOperation;
        this.val$completedCallback = oSSCompletedCallback;
    }

    public void onFailure(AppendObjectRequest appendObjectRequest, ClientException clientException, ServiceException serviceException) {
        this.val$completedCallback.onFailure(appendObjectRequest, clientException, serviceException);
    }

    public void onSuccess(AppendObjectRequest appendObjectRequest, AppendObjectResult appendObjectResult) {
        boolean bl2;
        Object object;
        Object object2 = appendObjectRequest.getCRC64();
        if (object2 == (object = OSSRequest$CRC64Config.YES)) {
            bl2 = true;
        } else {
            bl2 = false;
            object2 = null;
        }
        object = appendObjectRequest.getInitCRC64();
        if (object != null && bl2) {
            long l10 = appendObjectRequest.getInitCRC64();
            long l11 = appendObjectResult.getClientCRC();
            long l12 = appendObjectResult.getNextPosition();
            long l13 = appendObjectRequest.getPosition();
            long l14 = CRC64.combine((long)l10, (long)l11, (long)(l12 -= l13));
            object2 = l14;
            appendObjectResult.setClientCRC((Long)object2);
        }
        object2 = this.this$0;
        object = this.val$completedCallback;
        InternalRequestOperation.access$100((InternalRequestOperation)object2, appendObjectRequest, appendObjectResult, (OSSCompletedCallback)object);
    }
}

