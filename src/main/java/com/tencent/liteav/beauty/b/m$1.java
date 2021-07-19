/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.opengl.GLES20
 */
package com.tencent.liteav.beauty.b;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.liteav.basic.opengl.TXCOpenGlUtils;
import com.tencent.liteav.beauty.b.m;

public class m$1
implements Runnable {
    public final /* synthetic */ Bitmap a;
    public final /* synthetic */ Bitmap b;
    public final /* synthetic */ m c;

    public m$1(m m10, Bitmap bitmap, Bitmap bitmap2) {
        this.c = m10;
        this.a = bitmap;
        this.b = bitmap2;
    }

    public void run() {
        int n10;
        Object object = this.c;
        Object object2 = this.a;
        m.a((m)object, object2);
        object = this.c;
        object2 = this.b;
        m.b((m)object, object2);
        object = this.a;
        object2 = null;
        int n11 = 1065353216;
        float f10 = 1.0f;
        int n12 = -1;
        int n13 = 1;
        if (object != null) {
            m m10 = this.c;
            int n14 = m.a(m10);
            n10 = TXCOpenGlUtils.a((Bitmap)object, n14, false);
            m.a(m10, n10);
            object = m.b(this.c);
            object[0] = f10;
        } else {
            object = this.c;
            n10 = m.a((m)object);
            if (n10 != n12) {
                object = new int[n13];
                m m11 = this.c;
                int n15 = m.a(m11);
                object[0] = n15;
                GLES20.glDeleteTextures((int)n13, (int[])object, (int)0);
            }
            m.a(this.c, n12);
            object = m.b(this.c);
            object[0] = 0.0f;
        }
        object = this.b;
        if (object != null) {
            object2 = this.c;
            n12 = m.c((m)object2);
            n10 = TXCOpenGlUtils.a((Bitmap)object, n12, false);
            m.b((m)object2, n10);
            object = m.b(this.c);
            object[n13] = f10;
        } else {
            object = this.c;
            n10 = m.c((m)object);
            if (n10 != n12) {
                object = new int[n13];
                m m12 = this.c;
                n11 = m.c(m12);
                object[0] = n11;
                GLES20.glDeleteTextures((int)n13, (int[])object, (int)0);
            }
            m.b(this.c, n12);
            object = m.b(this.c);
            object[n13] = 0.0f;
        }
    }
}

