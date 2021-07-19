/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.update;

import com.zhiyun.cama.update.DownloadAPKService;
import com.zhiyun.net.download.DownLoadHelper$OnDownloadCallback;

public class DownloadAPKService$a
implements DownLoadHelper$OnDownloadCallback {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ DownloadAPKService c;

    public DownloadAPKService$a(DownloadAPKService downloadAPKService, String string2, String string3) {
        this.c = downloadAPKService;
        this.a = string2;
        this.b = string3;
    }

    public void downloadFailed(Throwable throwable) {
        this.c.s();
    }

    public void downloadProgress(int n10) {
        String string2;
        long l10 = System.currentTimeMillis();
        Object object = DownloadAPKService.a(this.c);
        Object object2 = object.equals(string2 = this.a);
        if (object2 != 0) {
            object = this.c;
            long l11 = DownloadAPKService.b((DownloadAPKService)((Object)object));
            long l12 = 500L;
            long l13 = (l11 = l10 - l11) - l12;
            object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object2 > 0 && n10 != (object2 = DownloadAPKService.d((DownloadAPKService)((Object)(object = this.c))))) {
                this.c.u(n10);
                object = this.c;
                DownloadAPKService.c((DownloadAPKService)((Object)object), l10);
                DownloadAPKService downloadAPKService = this.c;
                DownloadAPKService.e(downloadAPKService, n10);
            }
        }
    }

    public void downloadSuccess(String string2) {
        DownloadAPKService downloadAPKService = this.c;
        String string3 = this.b;
        downloadAPKService.v(string3, string2);
    }
}

