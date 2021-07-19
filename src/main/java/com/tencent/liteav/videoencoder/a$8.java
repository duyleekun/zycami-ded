/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.videoencoder;

import com.tencent.liteav.basic.opengl.b;
import com.tencent.liteav.basic.opengl.i;
import com.tencent.liteav.videoencoder.a;
import com.tencent.liteav.videoencoder.c;
import com.tencent.liteav.videoencoder.d;

public class a$8
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ long b;
    public final /* synthetic */ a c;

    public a$8(a a10, int n10, long l10) {
        this.c = a10;
        this.a = n10;
        this.b = l10;
    }

    public void run() {
        int n10;
        Object object = this.c;
        int n11 = com.tencent.liteav.videoencoder.a.b((a)object);
        if (n11 != (n10 = 1) && (object = com.tencent.liteav.videoencoder.a.c(this.c)) != null) {
            int n12;
            n11 = this.a;
            long l10 = this.b;
            com.tencent.liteav.videoencoder.a.a(this.c, l10);
            Object object2 = this.c;
            int n13 = ((c)object2).mRotation;
            int n14 = (720 - n13) % 360;
            n13 = 270;
            float f10 = 3.78E-43f;
            int n15 = 90;
            int n16 = n14 != n15 && n14 != n13 ? ((c)object2).mOutputWidth : ((c)object2).mOutputHeight;
            n13 = n14 != n15 && n14 != n13 ? ((c)object2).mOutputHeight : ((c)object2).mOutputWidth;
            i i10 = ((c)object2).mEncodeFilter;
            int n17 = ((c)object2).mInputWidth;
            int n18 = ((c)object2).mInputHeight;
            float f11 = n16;
            f10 = n13;
            f10 = f11 / f10;
            boolean bl2 = ((c)object2).mEnableXMirror;
            boolean bl3 = true;
            n16 = n17;
            n17 = n18;
            n18 = 0;
            i10.a(n16, n17, n14, null, f10, bl2, bl3);
            object2 = this.c.mEncodeFilter;
            ((i)object2).a(n11);
            object = com.tencent.liteav.videoencoder.a.c(this.c);
            n11 = object instanceof com.tencent.liteav.basic.opengl.c;
            if (n11 != 0) {
                object = (com.tencent.liteav.basic.opengl.c)com.tencent.liteav.videoencoder.a.c(this.c);
                long l11 = 1000000L;
                ((com.tencent.liteav.basic.opengl.c)object).a(l10 *= l11);
                object = (com.tencent.liteav.basic.opengl.c)com.tencent.liteav.videoencoder.a.c(this.c);
                ((com.tencent.liteav.basic.opengl.c)object).e();
            }
            if ((n11 = (object = com.tencent.liteav.videoencoder.a.c(this.c)) instanceof b) != 0) {
                object = (b)com.tencent.liteav.videoencoder.a.c(this.c);
                ((b)object).a();
            }
            object = this.c;
            d d10 = ((c)object).mListener;
            if (d10 != null) {
                n11 = ((c)object).mStreamType;
                d10.h(n11);
            }
            while ((n11 = com.tencent.liteav.videoencoder.a.c((a)(object = this.c), n10)) > 0) {
            }
            int n19 = -1;
            if (n11 != n19 && n11 != (n12 = -2)) {
                com.tencent.liteav.videoencoder.a.d(this.c);
                return;
            }
            if (n11 == n19) {
                object = this.c;
                n19 = 10000005;
                ((c)object).callDelegate(n19);
            }
            com.tencent.liteav.videoencoder.a.a(this.c, n10 != 0);
            object = this.c;
            com.tencent.liteav.videoencoder.a.a((a)object);
        }
    }
}

