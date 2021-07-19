/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav;

import com.tencent.liteav.d;
import com.tencent.rtmp.ui.TXCloudVideoView;

public class d$7
implements Runnable {
    public final /* synthetic */ TXCloudVideoView a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ d c;

    public d$7(d d10, TXCloudVideoView tXCloudVideoView, boolean bl2) {
        this.c = d10;
        this.a = tXCloudVideoView;
        this.b = bl2;
    }

    public void run() {
        TXCloudVideoView tXCloudVideoView = this.a;
        if (tXCloudVideoView != null) {
            boolean bl2 = this.b;
            tXCloudVideoView.stop(bl2);
        }
    }
}

