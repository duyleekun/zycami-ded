/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.zyplayer;

import com.google.android.exoplayer2.video.VideoListener;
import com.zhiyun.zyplayer.ExoVideoView;
import d.v.j0.d$c;

public class ExoVideoView$c
implements VideoListener {
    public final /* synthetic */ ExoVideoView a;

    public ExoVideoView$c(ExoVideoView exoVideoView) {
        this.a = exoVideoView;
    }

    public void onRenderedFirstFrame() {
        d$c d$c = ExoVideoView.e(this.a);
        if (d$c != null) {
            d$c = ExoVideoView.e(this.a);
            ExoVideoView exoVideoView = this.a;
            int n10 = 3;
            d$c.a(exoVideoView, n10, 0);
        }
    }

    public void onVideoSizeChanged(int n10, int n11, int n12, float f10) {
        ExoVideoView.m(this.a, n10);
        ExoVideoView.n(this.a, n11);
    }
}

