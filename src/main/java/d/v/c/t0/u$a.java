/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.t0;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.net.download.DownLoadHelper$OnDownloadFileCallback;
import d.v.c.t0.l0;
import d.v.c.t0.u;

public class u$a
implements DownLoadHelper$OnDownloadFileCallback {
    public final /* synthetic */ u a;

    public u$a(u u10) {
        this.a = u10;
    }

    public void cancel() {
        this.downloadFailed(null);
    }

    public void downloadCount(int n10) {
    }

    public void downloadFailed(Throwable object) {
        object = this.a.b;
        l0 l02 = new l0(false);
        ((MutableLiveData)object).setValue(l02);
    }

    public void downloadProgress(int n10) {
    }

    public void downloadSuccess(String object) {
        object = this.a.b;
        l0 l02 = new l0(true);
        ((MutableLiveData)object).setValue(l02);
    }

    public void saveFailed(Throwable throwable) {
        this.downloadFailed(throwable);
    }
}

