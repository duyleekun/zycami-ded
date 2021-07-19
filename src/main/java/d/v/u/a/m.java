/*
 * Decompiled with CFR 0.151.
 */
package d.v.u.a;

import androidx.arch.core.util.Function;
import com.zhiyun.net.download.DownLoadHelper;
import com.zhiyun.net.download.DownLoadHelper$OnDownloadFileCallback;

public final class m
implements Function {
    public final /* synthetic */ DownLoadHelper$OnDownloadFileCallback a;
    public final /* synthetic */ int b;

    public /* synthetic */ m(DownLoadHelper$OnDownloadFileCallback downLoadHelper$OnDownloadFileCallback, int n10) {
        this.a = downLoadHelper$OnDownloadFileCallback;
        this.b = n10;
    }

    public final Object apply(Object object) {
        DownLoadHelper$OnDownloadFileCallback downLoadHelper$OnDownloadFileCallback = this.a;
        int n10 = this.b;
        object = (Void)object;
        return DownLoadHelper.j(downLoadHelper$OnDownloadFileCallback, n10, (Void)object);
    }
}

