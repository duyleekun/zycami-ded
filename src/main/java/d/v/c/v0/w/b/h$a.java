/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.w.b;

import com.zhiyun.cama.data.database.model.SplashAd;
import com.zhiyun.net.download.DownLoadHelper$OnDownloadCallback;
import d.v.c.v0.w.b.h;

public class h$a
implements DownLoadHelper$OnDownloadCallback {
    public final /* synthetic */ SplashAd a;
    public final /* synthetic */ h b;

    public h$a(h h10, SplashAd splashAd) {
        this.b = h10;
        this.a = splashAd;
    }

    public void downloadFailed(Throwable throwable) {
    }

    public void downloadProgress(int n10) {
    }

    public void downloadSuccess(String string2) {
        h h10 = this.b;
        SplashAd splashAd = this.a;
        h.a(h10, splashAd, string2);
    }
}

