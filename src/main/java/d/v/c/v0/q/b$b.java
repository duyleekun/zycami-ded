/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.q;

import com.zhiyun.net.download.DownLoadHelper$OnDownloadFileCallback;
import d.v.c.v0.q.b;
import d.v.c.v0.q.c;

public class b$b
implements DownLoadHelper$OnDownloadFileCallback {
    public final /* synthetic */ c a;
    public final /* synthetic */ b b;

    public b$b(b b10, c c10) {
        this.b = b10;
        this.a = c10;
    }

    public void cancel() {
        this.downloadFailed(null);
    }

    public void downloadCount(int n10) {
    }

    public void downloadFailed(Throwable throwable) {
        b b10 = this.b;
        c c10 = this.a;
        d.v.c.v0.q.b.D(b10, c10);
        if (throwable != null) {
            throwable.printStackTrace();
        }
    }

    public void downloadProgress(int n10) {
        b b10 = this.b;
        c c10 = this.a;
        d.v.c.v0.q.b.A(b10, c10, n10);
    }

    public void downloadSuccess(String object) {
        object = this.b;
        c c10 = this.a;
        d.v.c.v0.q.b.B((b)object, c10);
        object = this.b;
        c10 = this.a;
        d.v.c.v0.q.b.C((b)object, c10);
    }

    public void saveFailed(Throwable throwable) {
        this.downloadFailed(throwable);
    }
}

