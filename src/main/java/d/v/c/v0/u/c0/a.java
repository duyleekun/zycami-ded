/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.u.c0;

import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.model.ResumableUploadRequest;
import com.zhiyun.cama.data.me.remote.AliyunManager;
import com.zhiyun.cama.data.me.remote.AliyunManager$OnAliyunProgressCallback;

public final class a
implements OSSProgressCallback {
    public final /* synthetic */ AliyunManager$OnAliyunProgressCallback a;

    public /* synthetic */ a(AliyunManager$OnAliyunProgressCallback aliyunManager$OnAliyunProgressCallback) {
        this.a = aliyunManager$OnAliyunProgressCallback;
    }

    public final void onProgress(Object object, long l10, long l11) {
        AliyunManager$OnAliyunProgressCallback aliyunManager$OnAliyunProgressCallback = this.a;
        Object object2 = object;
        object2 = (ResumableUploadRequest)object;
        AliyunManager.a(aliyunManager$OnAliyunProgressCallback, (ResumableUploadRequest)object2, l10, l11);
    }
}

