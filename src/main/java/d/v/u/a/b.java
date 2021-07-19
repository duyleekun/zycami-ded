/*
 * Decompiled with CFR 0.151.
 */
package d.v.u.a;

import androidx.arch.core.util.Function;
import com.zhiyun.net.api.entity.DownloadEntity;
import com.zhiyun.net.download.DownLoadHelper;
import com.zhiyun.net.download.DownLoadHelper$OnDownloadFileEntityCallback;

public final class b
implements Function {
    public final /* synthetic */ DownLoadHelper$OnDownloadFileEntityCallback a;
    public final /* synthetic */ DownloadEntity b;
    public final /* synthetic */ int c;
    public final /* synthetic */ long d;
    public final /* synthetic */ long e;

    public /* synthetic */ b(DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback, DownloadEntity downloadEntity, int n10, long l10, long l11) {
        this.a = downLoadHelper$OnDownloadFileEntityCallback;
        this.b = downloadEntity;
        this.c = n10;
        this.d = l10;
        this.e = l11;
    }

    public final Object apply(Object object) {
        DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback = this.a;
        DownloadEntity downloadEntity = this.b;
        int n10 = this.c;
        long l10 = this.d;
        long l11 = this.e;
        Object object2 = object;
        object2 = (Void)object;
        return DownLoadHelper.i(downLoadHelper$OnDownloadFileEntityCallback, downloadEntity, n10, l10, l11, (Void)object2);
    }
}

