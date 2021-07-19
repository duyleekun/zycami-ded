/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.f;

import com.zhiyun.editortemplate.util.download.DownloadEvent;
import d.v.j.f.g;

public final class d
implements Runnable {
    public final /* synthetic */ g a;
    public final /* synthetic */ long b;
    public final /* synthetic */ DownloadEvent c;

    public /* synthetic */ d(g g10, long l10, DownloadEvent downloadEvent) {
        this.a = g10;
        this.b = l10;
        this.c = downloadEvent;
    }

    public final void run() {
        g g10 = this.a;
        long l10 = this.b;
        DownloadEvent downloadEvent = this.c;
        g10.w(l10, downloadEvent);
    }
}

