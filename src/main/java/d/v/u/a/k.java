/*
 * Decompiled with CFR 0.151.
 */
package d.v.u.a;

import androidx.arch.core.util.Function;
import com.zhiyun.net.download.DownLoadHelper;
import com.zhiyun.net.download.DownLoadHelper$OnDownloadCallback;

public final class k
implements Function {
    public final /* synthetic */ DownLoadHelper$OnDownloadCallback a;
    public final /* synthetic */ Throwable b;

    public /* synthetic */ k(DownLoadHelper$OnDownloadCallback downLoadHelper$OnDownloadCallback, Throwable throwable) {
        this.a = downLoadHelper$OnDownloadCallback;
        this.b = throwable;
    }

    public final Object apply(Object object) {
        DownLoadHelper$OnDownloadCallback downLoadHelper$OnDownloadCallback = this.a;
        Throwable throwable = this.b;
        object = (Void)object;
        return DownLoadHelper.e(downLoadHelper$OnDownloadCallback, throwable, (Void)object);
    }
}

