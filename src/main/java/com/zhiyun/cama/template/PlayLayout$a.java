/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.template;

import com.zhiyun.cama.template.PlayLayout;
import d.v.e.l.m2$a;
import d.v.j0.d;

public class PlayLayout$a
implements m2$a {
    public final /* synthetic */ d a;
    public final /* synthetic */ PlayLayout b;

    public PlayLayout$a(PlayLayout playLayout, d d10) {
        this.b = playLayout;
        this.a = d10;
    }

    public void a(Long l10) {
        int n10 = this.a.getCurrentPosition();
        int n11 = this.a.getDuration();
        float f10 = (float)n10 * 100.0f;
        float f11 = n11;
        n10 = (int)(f10 / f11);
        this.b.setVideoProgress(n10);
    }

    public void onComplete() {
    }
}

