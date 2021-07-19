/*
 * Decompiled with CFR 0.151.
 */
package d.v.u.a;

import androidx.arch.core.util.Function;
import com.zhiyun.net.download.DownLoadHelper;
import com.zhiyun.net.download.DownLoadHelper$OnDownloadFileCallback;

public final class h
implements Function {
    public final /* synthetic */ DownLoadHelper$OnDownloadFileCallback a;

    public /* synthetic */ h(DownLoadHelper$OnDownloadFileCallback downLoadHelper$OnDownloadFileCallback) {
        this.a = downLoadHelper$OnDownloadFileCallback;
    }

    public final Object apply(Object object) {
        DownLoadHelper$OnDownloadFileCallback downLoadHelper$OnDownloadFileCallback = this.a;
        object = (Void)object;
        return DownLoadHelper.b(downLoadHelper$OnDownloadFileCallback, (Void)object);
    }
}

