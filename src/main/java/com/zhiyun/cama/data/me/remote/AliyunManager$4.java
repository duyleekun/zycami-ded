/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.me.remote;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.zhiyun.cama.data.me.remote.AliyunManager;
import com.zhiyun.cama.data.me.remote.AliyunManager$OnAliyunCallback;
import m.a.a;

public class AliyunManager$4
implements OSSCompletedCallback {
    public final /* synthetic */ AliyunManager this$0;
    public final /* synthetic */ String val$aliyunUrl;
    public final /* synthetic */ AliyunManager$OnAliyunCallback val$callback;

    public AliyunManager$4(AliyunManager aliyunManager, AliyunManager$OnAliyunCallback aliyunManager$OnAliyunCallback, String string2) {
        this.this$0 = aliyunManager;
        this.val$callback = aliyunManager$OnAliyunCallback;
        this.val$aliyunUrl = string2;
    }

    public void onFailure(PutObjectRequest object, ClientException objectArray, ServiceException serviceException) {
        object = this.val$callback;
        if (object != null) {
            object.onFailed((ClientException)objectArray, serviceException);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("OSSAsyncTask onFailure: clientException = ");
        objectArray = objectArray.toString();
        ((StringBuilder)object).append((String)objectArray);
        ((StringBuilder)object).append(",serviceException = ");
        objectArray = serviceException.toString();
        ((StringBuilder)object).append((String)objectArray);
        object = ((StringBuilder)object).toString();
        objectArray = new Object[]{};
        a.i((String)object, objectArray);
    }

    public void onSuccess(PutObjectRequest object, PutObjectResult objectArray) {
        object = this.val$callback;
        if (object != null) {
            String string2 = this.val$aliyunUrl;
            object.onSuccess(string2);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("OSSAsyncTask onSuccess:");
        objectArray = objectArray.getETag();
        ((StringBuilder)object).append((String)objectArray);
        ((StringBuilder)object).append(" ");
        objectArray = this.val$aliyunUrl;
        ((StringBuilder)object).append((String)objectArray);
        object = ((StringBuilder)object).toString();
        objectArray = new Object[]{};
        a.i((String)object, objectArray);
    }
}

