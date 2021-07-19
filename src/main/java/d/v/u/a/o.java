/*
 * Decompiled with CFR 0.151.
 */
package d.v.u.a;

import androidx.arch.core.util.Function;
import com.zhiyun.net.download.DownLoadHelper;
import com.zhiyun.net.download.DownLoadHelper$OnDownloadFileCallback;

public final class o
implements Function {
    public final /* synthetic */ DownLoadHelper$OnDownloadFileCallback a;
    public final /* synthetic */ Throwable b;

    public /* synthetic */ o(DownLoadHelper$OnDownloadFileCallback downLoadHelper$OnDownloadFileCallback, Throwable throwable) {
        this.a = downLoadHelper$OnDownloadFileCallback;
        this.b = throwable;
    }

    public final Object apply(Object object) {
        DownLoadHelper$OnDownloadFileCallback downLoadHelper$OnDownloadFileCallback = this.a;
        Throwable throwable = this.b;
        object = (Void)object;
        return DownLoadHelper.f(downLoadHelper$OnDownloadFileCallback, throwable, (Void)object);
    }
}

