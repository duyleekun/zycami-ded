/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.tencent.liteav.videoencoder;

import android.opengl.GLES20;
import com.tencent.liteav.basic.opengl.i;
import com.tencent.liteav.beauty.b.k;
import com.tencent.liteav.videoencoder.b;

public class b$2
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ byte[] d;
    public final /* synthetic */ long e;
    public final /* synthetic */ b f;

    public b$2(b b10, int n10, int n11, int n12, byte[] byArray, long l10) {
        this.f = b10;
        this.a = n10;
        this.b = n11;
        this.c = n12;
        this.d = byArray;
        this.e = l10;
    }

    public void run() {
        int n10;
        int n11;
        Object object;
        int n12;
        int n13;
        Object object2 = com.tencent.liteav.videoencoder.b.b(this.f);
        if (object2 == null || (n13 = ((i)(object2 = com.tencent.liteav.videoencoder.b.b(this.f))).o()) != (n12 = this.a) || (n13 = ((i)(object2 = com.tencent.liteav.videoencoder.b.b(this.f))).p()) != (n12 = this.b)) {
            object2 = com.tencent.liteav.videoencoder.b.b(this.f);
            n12 = 0;
            object = null;
            if (object2 != null) {
                com.tencent.liteav.videoencoder.b.b(this.f).d();
                object2 = this.f;
                com.tencent.liteav.videoencoder.b.a((b)object2, null);
            }
            object2 = this.f;
            n11 = this.c;
            k k10 = new k(n11);
            com.tencent.liteav.videoencoder.b.a((b)object2, k10);
            object2 = com.tencent.liteav.videoencoder.b.b(this.f);
            n13 = (int)(((k)object2).a() ? 1 : 0);
            if (n13 == 0) {
                object2 = com.tencent.liteav.videoencoder.b.a(this.f);
                if (object2 != null) {
                    com.tencent.liteav.videoencoder.b.a(this.f).c();
                    object2 = this.f;
                    com.tencent.liteav.videoencoder.b.a((b)object2, null);
                }
                com.tencent.liteav.videoencoder.b.a(this.f, null);
                return;
            }
            com.tencent.liteav.videoencoder.b.b(this.f).a(true);
            object2 = com.tencent.liteav.videoencoder.b.b(this.f);
            n12 = this.a;
            n10 = this.b;
            ((k)object2).a(n12, n10);
        }
        object2 = com.tencent.liteav.videoencoder.b.b(this.f);
        object = this.d;
        ((k)object2).a((byte[])object);
        n13 = this.a;
        n12 = this.b;
        GLES20.glViewport((int)0, (int)0, (int)n13, (int)n12);
        n10 = com.tencent.liteav.videoencoder.b.b(this.f).r();
        GLES20.glFlush();
        object = this.f;
        n11 = this.a;
        int n14 = this.b;
        long l10 = this.e;
        ((b)object).a(n10, n11, n14, l10);
    }
}

