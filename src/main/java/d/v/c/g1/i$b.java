/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.g1;

import com.zhiyun.net.download.DownLoadHelper$OnDownloadCallback;
import d.v.c.g1.i;
import e.a.b0;

public class i$b
implements DownLoadHelper$OnDownloadCallback {
    public final /* synthetic */ b0 a;
    public final /* synthetic */ i b;

    public i$b(i i10, b0 b02) {
        this.b = i10;
        this.a = b02;
    }

    public void downloadFailed(Throwable throwable) {
        this.a.onError(throwable);
    }

    public void downloadProgress(int n10) {
    }

    public void downloadSuccess(String string2) {
        this.a.onNext(string2);
    }
}

