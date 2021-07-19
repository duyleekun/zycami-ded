/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.me.remote;

import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.zhiyun.cama.data.me.remote.AliyunManager;
import com.zhiyun.cama.data.me.remote.AliyunManager$OnAliyunProgressCallback;

public class AliyunManager$2
implements OSSProgressCallback {
    public final /* synthetic */ AliyunManager this$0;
    public final /* synthetic */ AliyunManager$OnAliyunProgressCallback val$onProgress;

    public AliyunManager$2(AliyunManager aliyunManager, AliyunManager$OnAliyunProgressCallback aliyunManager$OnAliyunProgressCallback) {
        this.this$0 = aliyunManager;
        this.val$onProgress = aliyunManager$OnAliyunProgressCallback;
    }

    public void onProgress(PutObjectRequest object, long l10, long l11) {
        object = this.val$onProgress;
        if (object != null) {
            long l12 = 100;
            l10 = l10 * l12 / l11;
            int n10 = (int)l10;
            object.onProgress(n10);
        }
    }
}

