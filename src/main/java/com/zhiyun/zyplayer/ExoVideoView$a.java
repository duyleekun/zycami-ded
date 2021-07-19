/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.zyplayer;

import com.google.android.exoplayer2.ui.PlayerControlView$VisibilityListener;
import com.zhiyun.zyplayer.ExoVideoView;
import d.v.j0.c;

public class ExoVideoView$a
implements PlayerControlView$VisibilityListener {
    public final /* synthetic */ c a;
    public final /* synthetic */ ExoVideoView b;

    public ExoVideoView$a(ExoVideoView exoVideoView, c c10) {
        this.b = exoVideoView;
        this.a = c10;
    }

    public void onVisibilityChange(int n10) {
        c c10 = this.a;
        if (c10 != null) {
            c10.onVisibilityChange(n10);
        }
    }
}

