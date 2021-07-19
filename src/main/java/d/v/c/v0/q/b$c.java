/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.q;

import com.zhiyun.net.api.entity.DownloadEntity;
import com.zhiyun.net.download.DownLoadHelper;
import com.zhiyun.net.download.DownLoadHelper$OnDownloadFileEntityCallback;
import d.v.c.v0.q.b;
import d.v.c.v0.q.c;

public class b$c
implements DownLoadHelper$OnDownloadFileEntityCallback {
    public final /* synthetic */ c a;
    public final /* synthetic */ b b;

    public b$c(b b10, c c10) {
        this.b = b10;
        this.a = c10;
    }

    public void cancel(DownloadEntity downloadEntity) {
        this.downloadFailed(downloadEntity, null);
    }

    public void downloadCount(DownloadEntity downloadEntity, int n10, int n11) {
    }

    public void downloadFailed(DownloadEntity object, Throwable throwable) {
        object = this.b;
        c c10 = this.a;
        d.v.c.v0.q.b.F((b)object, c10);
        if (throwable != null) {
            throwable.printStackTrace();
        }
    }

    public void downloadProgress(DownloadEntity downloadEntity, int n10, long l10, long l11) {
        int n11 = DownLoadHelper.getProgress(n10, 0, 1);
        b b10 = this.b;
        c c10 = this.a;
        d.v.c.v0.q.b.G(b10, c10, n11);
    }

    public void downloadSuccess(DownloadEntity object) {
        Object object2 = this.b;
        object = (c)((DownloadEntity)object).getT();
        d.v.c.v0.q.b.B((b)object2, (c)object);
        object = this.b;
        object2 = this.a;
        d.v.c.v0.q.b.E((b)object, object2);
    }

    public void saveFailed(DownloadEntity downloadEntity, Throwable throwable) {
        this.downloadFailed(downloadEntity, throwable);
    }
}

