/*
 * Decompiled with CFR 0.151.
 */
package d.v.u.a;

import androidx.arch.core.util.Function;
import com.zhiyun.net.api.entity.DownloadEntity;
import com.zhiyun.net.download.DownLoadHelper;
import com.zhiyun.net.download.DownLoadHelper$OnDownloadFileEntityCallback;

public final class n
implements Function {
    public final /* synthetic */ DownLoadHelper$OnDownloadFileEntityCallback a;
    public final /* synthetic */ DownloadEntity b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    public /* synthetic */ n(DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback, DownloadEntity downloadEntity, int n10, int n11) {
        this.a = downLoadHelper$OnDownloadFileEntityCallback;
        this.b = downloadEntity;
        this.c = n10;
        this.d = n11;
    }

    public final Object apply(Object object) {
        DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback = this.a;
        DownloadEntity downloadEntity = this.b;
        int n10 = this.c;
        int n11 = this.d;
        object = (Void)object;
        return DownLoadHelper.c(downLoadHelper$OnDownloadFileEntityCallback, downloadEntity, n10, n11, (Void)object);
    }
}

