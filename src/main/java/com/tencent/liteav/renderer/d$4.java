/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.renderer;

import com.tencent.liteav.renderer.d;

public class d$4
implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ d b;

    public d$4(d d10, boolean bl2) {
        this.b = d10;
        this.a = bl2;
    }

    public void run() {
        Object object = d.e(this.b);
        if (object != null) {
            object = this.b;
            float f10 = Math.abs(d.f((d)object));
            d.a((d)object, f10);
            boolean bl2 = this.a;
            if (bl2) {
                object = this.b;
                f10 = -d.f((d)object);
                d.a((d)object, f10);
            }
            object = d.e(this.b);
            f10 = d.f(this.b);
            object.setScaleX(f10);
            object = d.e(this.b);
            d d10 = this.b;
            f10 = Math.abs(d.f(d10));
            object.setScaleY(f10);
        }
    }
}

