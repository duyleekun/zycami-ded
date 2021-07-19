/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.publish;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import com.zhiyun.cama.publish.VideoCropFragment;
import com.zhiyun.zyplayer.ExoVideoView;
import d.v.c.m0;

public class VideoCropFragment$b
extends RecyclerView$OnScrollListener {
    private int a;
    public final /* synthetic */ LinearLayoutManager b;
    public final /* synthetic */ long c;
    public final /* synthetic */ VideoCropFragment d;

    public VideoCropFragment$b(VideoCropFragment videoCropFragment, LinearLayoutManager linearLayoutManager, long l10) {
        this.d = videoCropFragment;
        this.b = linearLayoutManager;
        this.c = l10;
    }

    public void onScrolled(RecyclerView object, int n10, int n11) {
        int n12;
        this.a = n12 = this.a + n10;
        object = this.b;
        n12 = ((LinearLayoutManager)object).findFirstVisibleItemPosition();
        n10 = Math.abs(this.a);
        n11 = m0.l;
        float f10 = (float)(n10 % n11) * 1.0f;
        float f11 = n11;
        f10 /= f11;
        float f12 = n12;
        f10 += f12;
        long l10 = this.c;
        f12 = l10;
        f10 *= f12;
        f12 = 1000.0f;
        n12 = (int)(f10 /= f12);
        Object object2 = VideoCropFragment.k((VideoCropFragment)this.d).k;
        n11 = 0;
        f11 = 0.0f;
        object2.setProgress(0);
        object2 = VideoCropFragment.k((VideoCropFragment)this.d).i;
        n10 = ((ExoVideoView)object2).getDuration();
        int n13 = 300000;
        if (n12 > (n10 -= n13)) {
            return;
        }
        VideoCropFragment.q(this.d, n12);
        object = this.d;
        n10 = VideoCropFragment.p((VideoCropFragment)object) + n13;
        VideoCropFragment.s((VideoCropFragment)object, n10);
        object = VideoCropFragment.k((VideoCropFragment)this.d).i;
        n10 = VideoCropFragment.p(this.d);
        ((ExoVideoView)object).c(n10);
        VideoCropFragment.j(this.d).c();
        VideoCropFragment.u(this.d, false);
    }
}

