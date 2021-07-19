/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package com.tencent.liteav.beauty;

import android.graphics.Bitmap;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.i;
import com.tencent.liteav.beauty.a;
import com.tencent.liteav.beauty.b.x;
import com.tencent.liteav.beauty.c;

public class c$10
implements Runnable {
    public final /* synthetic */ Bitmap a;
    public final /* synthetic */ float b;
    public final /* synthetic */ float c;
    public final /* synthetic */ float d;
    public final /* synthetic */ c e;

    public c$10(c c10, Bitmap bitmap, float f10, float f11, float f12) {
        this.e = c10;
        this.a = bitmap;
        this.b = f10;
        this.c = f11;
        this.d = f12;
    }

    public void run() {
        Object object = this.a;
        if (object != null) {
            object = com.tencent.liteav.beauty.a.a();
            ((a)object).g();
        }
        object = this.a;
        int n10 = 0;
        Object object2 = null;
        if (object == null) {
            object = com.tencent.liteav.beauty.c.b(this.e);
            if (object != null) {
                com.tencent.liteav.beauty.c.b(this.e).d();
                object = this.e;
                com.tencent.liteav.beauty.c.a((c)((Object)object), null);
            }
            return;
        }
        object = com.tencent.liteav.beauty.c.b(this.e);
        boolean bl2 = true;
        float f10 = Float.MIN_VALUE;
        if (object == null) {
            object = this.e;
            int n11 = com.tencent.liteav.beauty.c.c((c)((Object)object));
            Object object3 = "TXCFilterDrawer";
            if (n11 > 0 && (n11 = com.tencent.liteav.beauty.c.d((c)((Object)(object = this.e)))) > 0) {
                object = this.e;
                x x10 = new x();
                com.tencent.liteav.beauty.c.a((c)((Object)object), x10);
                com.tencent.liteav.beauty.c.b(this.e).a(bl2);
                object = com.tencent.liteav.beauty.c.b(this.e);
                n11 = (int)(((i)object).a() ? 1 : 0);
                if (n11 == 0) {
                    TXCLog.e(object3, "mWatermarkFilter.init failed!");
                    com.tencent.liteav.beauty.c.b(this.e).d();
                    com.tencent.liteav.beauty.c.a(this.e, null);
                    return;
                }
                object = com.tencent.liteav.beauty.c.b(this.e);
                object2 = this.e;
                n10 = com.tencent.liteav.beauty.c.c((c)((Object)object2));
                object3 = this.e;
                int n12 = com.tencent.liteav.beauty.c.d((c)((Object)object3));
                ((i)object).a(n10, n12);
            } else {
                TXCLog.e(object3, "output Width and Height is error!");
                return;
            }
        }
        com.tencent.liteav.beauty.c.b(this.e).c(bl2);
        object = com.tencent.liteav.beauty.c.b(this.e);
        object2 = this.a;
        f10 = this.b;
        float f11 = this.c;
        float f12 = this.d;
        ((x)object).a((Bitmap)object2, f10, f11, f12);
    }
}

