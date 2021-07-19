/*
 * Decompiled with CFR 0.151.
 */
package d.v.u.a;

import androidx.arch.core.util.Function;
import com.zhiyun.net.api.entity.DownloadEntity;
import com.zhiyun.net.download.DownLoadHelper;
import com.zhiyun.net.download.DownLoadHelper$OnDownloadFileEntityCallback;

public final class f
implements Function {
    public final /* synthetic */ DownLoadHelper$OnDownloadFileEntityCallback a;
    public final /* synthetic */ DownloadEntity b;

    public /* synthetic */ f(DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback, DownloadEntity downloadEntity) {
        this.a = downLoadHelper$OnDownloadFileEntityCallback;
        this.b = downloadEntity;
    }

    public final Object apply(Object object) {
        DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback = this.a;
        DownloadEntity downloadEntity = this.b;
        object = (Void)object;
        return DownLoadHelper.a(downLoadHelper$OnDownloadFileEntityCallback, downloadEntity, (Void)object);
    }
}

