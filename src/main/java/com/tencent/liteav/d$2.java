/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav;

import com.tencent.liteav.d;
import com.tencent.liteav.g;
import com.tencent.liteav.n;
import com.tencent.rtmp.ui.TXCloudVideoView;

public class d$2
implements Runnable {
    public final /* synthetic */ TXCloudVideoView a;
    public final /* synthetic */ d b;

    public d$2(d d10, TXCloudVideoView tXCloudVideoView) {
        this.b = d10;
        this.a = tXCloudVideoView;
    }

    public void run() {
        TXCloudVideoView tXCloudVideoView = this.a;
        if (tXCloudVideoView != null) {
            g g10 = d.d(this.b);
            boolean bl2 = g10.K;
            g g11 = d.d(this.b);
            boolean bl3 = g11.L;
            n n10 = d.e(this.b);
            tXCloudVideoView.start(bl2, bl3, n10);
        }
    }
}

