/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.q0;

import com.zhiyun.editortemplate.util.download.DownloadEvent;
import d.v.c.s0.h7.q0.z;

public final class u
implements Runnable {
    public final /* synthetic */ z a;
    public final /* synthetic */ DownloadEvent b;

    public /* synthetic */ u(z z10, DownloadEvent downloadEvent) {
        this.a = z10;
        this.b = downloadEvent;
    }

    public final void run() {
        z z10 = this.a;
        DownloadEvent downloadEvent = this.b;
        z10.r(downloadEvent);
    }
}

