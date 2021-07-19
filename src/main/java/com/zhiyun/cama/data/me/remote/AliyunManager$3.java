/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.me.remote;

import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.zhiyun.cama.data.me.remote.AliyunManager;
import com.zhiyun.cama.data.me.remote.AliyunManager$OnAliyunCallback;
import m.a.a;

public class AliyunManager$3
implements OSSProgressCallback {
    public final /* synthetic */ AliyunManager this$0;
    public final /* synthetic */ AliyunManager$OnAliyunCallback val$callback;

    public AliyunManager$3(AliyunManager aliyunManager, AliyunManager$OnAliyunCallback aliyunManager$OnAliyunCallback) {
        this.this$0 = aliyunManager;
        this.val$callback = aliyunManager$OnAliyunCallback;
    }

    public void onProgress(PutObjectRequest object, long l10, long l11) {
        long l12 = (long)100 * l10 / l11;
        int n10 = (int)l12;
        Object object2 = this.val$callback;
        if (object2 != null) {
            object2.onProgress(n10);
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("onProgress:");
        ((StringBuilder)object2).append(l10);
        ((StringBuilder)object2).append("/");
        ((StringBuilder)object2).append(l11);
        ((StringBuilder)object2).append("   ");
        ((StringBuilder)object2).append(n10);
        object = ((StringBuilder)object2).toString();
        Object[] objectArray = new Object[]{};
        a.i((String)object, objectArray);
    }
}

