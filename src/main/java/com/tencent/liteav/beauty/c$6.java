/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package com.tencent.liteav.beauty;

import android.graphics.Bitmap;
import com.tencent.liteav.beauty.a;
import com.tencent.liteav.beauty.b.m;
import com.tencent.liteav.beauty.c;

public class c$6
implements Runnable {
    public final /* synthetic */ float a;
    public final /* synthetic */ Bitmap b;
    public final /* synthetic */ float c;
    public final /* synthetic */ Bitmap d;
    public final /* synthetic */ float e;
    public final /* synthetic */ c f;

    public c$6(c c10, float f10, Bitmap bitmap, float f11, Bitmap bitmap2, float f12) {
        this.f = c10;
        this.a = f10;
        this.b = bitmap;
        this.c = f11;
        this.d = bitmap2;
        this.e = f12;
    }

    public void run() {
        Object object = com.tencent.liteav.beauty.c.a(this.f);
        if (object != null) {
            object = com.tencent.liteav.beauty.a.a();
            ((a)object).e();
        }
        if ((object = com.tencent.liteav.beauty.c.h(this.f)) == null && (object = com.tencent.liteav.beauty.c.i(this.f)) == null) {
            object = com.tencent.liteav.beauty.c.a(this.f);
            if (object != null) {
                com.tencent.liteav.beauty.c.a(this.f).d();
                object = this.f;
                Object var2_2 = null;
                com.tencent.liteav.beauty.c.a((c)((Object)object), null);
            }
        } else {
            object = com.tencent.liteav.beauty.c.a(this.f);
            if (object == null) {
                c c10 = this.f;
                int n10 = com.tencent.liteav.beauty.c.f(c10);
                int n11 = com.tencent.liteav.beauty.c.g(this.f);
                float f10 = com.tencent.liteav.beauty.c.j(this.f);
                Bitmap bitmap = com.tencent.liteav.beauty.c.h(this.f);
                float f11 = com.tencent.liteav.beauty.c.k(this.f);
                Bitmap bitmap2 = com.tencent.liteav.beauty.c.i(this.f);
                object = this.f;
                float f12 = com.tencent.liteav.beauty.c.l((c)((Object)object));
                com.tencent.liteav.beauty.c.a(c10, n10, n11, f10, bitmap, f11, bitmap2, f12);
            } else {
                object = this.f;
                m m10 = com.tencent.liteav.beauty.c.a((c)((Object)object));
                float f13 = this.a;
                Bitmap bitmap = this.b;
                float f14 = this.c;
                Bitmap bitmap3 = this.d;
                float f15 = this.e;
                m10.a(f13, bitmap, f14, bitmap3, f15);
            }
        }
    }
}

