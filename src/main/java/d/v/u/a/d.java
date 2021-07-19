/*
 * Decompiled with CFR 0.151.
 */
package d.v.u.a;

import androidx.arch.core.util.Function;
import com.zhiyun.net.download.DownLoadHelper;
import com.zhiyun.net.download.DownLoadHelper$OnDownloadCallback;

public final class d
implements Function {
    public final /* synthetic */ DownLoadHelper$OnDownloadCallback a;
    public final /* synthetic */ String b;

    public /* synthetic */ d(DownLoadHelper$OnDownloadCallback downLoadHelper$OnDownloadCallback, String string2) {
        this.a = downLoadHelper$OnDownloadCallback;
        this.b = string2;
    }

    public final Object apply(Object object) {
        DownLoadHelper$OnDownloadCallback downLoadHelper$OnDownloadCallback = this.a;
        String string2 = this.b;
        object = (Void)object;
        return DownLoadHelper.l(downLoadHelper$OnDownloadCallback, string2, (Void)object);
    }
}

