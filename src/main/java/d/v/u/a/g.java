/*
 * Decompiled with CFR 0.151.
 */
package d.v.u.a;

import androidx.arch.core.util.Function;
import com.zhiyun.net.download.DownLoadHelper;
import com.zhiyun.net.download.DownLoadHelper$OnDownloadCallback;

public final class g
implements Function {
    public final /* synthetic */ DownLoadHelper$OnDownloadCallback a;
    public final /* synthetic */ int b;

    public /* synthetic */ g(DownLoadHelper$OnDownloadCallback downLoadHelper$OnDownloadCallback, int n10) {
        this.a = downLoadHelper$OnDownloadCallback;
        this.b = n10;
    }

    public final Object apply(Object object) {
        DownLoadHelper$OnDownloadCallback downLoadHelper$OnDownloadCallback = this.a;
        int n10 = this.b;
        object = (Void)object;
        return DownLoadHelper.h(downLoadHelper$OnDownloadCallback, n10, (Void)object);
    }
}

