/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.i;
import com.tencent.liteav.beauty.b.e;
import com.tencent.liteav.beauty.b.p;
import com.tencent.liteav.beauty.b.w;

public class j {
    private static String j = "GPUGreenScreen";
    private int a;
    private int b;
    private boolean c;
    private w d;
    private boolean e;
    private com.tencent.liteav.basic.opengl.j f;
    private e g;
    private p h;
    private boolean i;
    private b k;

    private void b() {
        Object object = j;
        String string2 = "come into destroyPlayer";
        TXCLog.i((String)object, string2);
        object = this.d;
        if (object != null) {
            ((w)object).a();
        }
        this.d = null;
        this.e = false;
        this.i = false;
        TXCLog.i(j, "come out destroyPlayer");
    }

    private void c() {
        int[] nArray;
        int n10;
        int n11 = this.b;
        int n12 = 1;
        int n13 = -1;
        if (n11 != n13 && n11 != (n10 = this.a)) {
            nArray = new int[n12];
            nArray[0] = n11;
            GLES20.glDeleteTextures((int)n12, (int[])nArray, (int)0);
            this.b = n13;
        }
        if ((n11 = this.a) != n13) {
            nArray = new int[n12];
            nArray[0] = n11;
            GLES20.glDeleteTextures((int)n12, (int[])nArray, (int)0);
            this.a = n13;
        }
    }

    public int a(int n10) {
        return n10;
    }

    public void a() {
        TXCLog.i(j, "come into GreenScreen destroy");
        this.b();
        this.c();
        i i10 = this.f;
        if (i10 != null) {
            i10.d();
            this.f = null;
        }
        if ((i10 = this.g) != null) {
            i10.d();
            this.g = null;
        }
        if ((i10 = this.h) != null) {
            i10.d();
            this.h = null;
        }
        this.c = false;
        TXCLog.i(j, "come out GreenScreen destroy");
    }

    public void a(b b10) {
        TXCLog.i(j, "set notify");
        this.k = b10;
    }
}

