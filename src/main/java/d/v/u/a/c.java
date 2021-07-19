/*
 * Decompiled with CFR 0.151.
 */
package d.v.u.a;

import androidx.arch.core.util.Function;
import com.zhiyun.net.api.entity.DownloadEntity;
import com.zhiyun.net.download.DownLoadHelper;
import com.zhiyun.net.download.DownLoadHelper$OnDownloadFileEntityCallback;

public final class c
implements Function {
    public final /* synthetic */ DownLoadHelper$OnDownloadFileEntityCallback a;
    public final /* synthetic */ DownloadEntity b;
    public final /* synthetic */ Throwable c;

    public /* synthetic */ c(DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback, DownloadEntity downloadEntity, Throwable throwable) {
        this.a = downLoadHelper$OnDownloadFileEntityCallback;
        this.b = downloadEntity;
        this.c = throwable;
    }

    public final Object apply(Object object) {
        DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback = this.a;
        DownloadEntity downloadEntity = this.b;
        Throwable throwable = this.c;
        object = (Void)object;
        return DownLoadHelper.d(downLoadHelper$OnDownloadFileEntityCallback, downloadEntity, throwable, (Void)object);
    }
}

