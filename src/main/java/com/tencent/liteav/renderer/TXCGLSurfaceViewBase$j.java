/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  javax.microedition.khronos.opengles.GL10
 */
package com.tencent.liteav.renderer;

import com.tencent.liteav.renderer.TXCGLSurfaceViewBase$1;
import com.tencent.liteav.renderer.TXCGLSurfaceViewBase$i;
import javax.microedition.khronos.opengles.GL10;

public class TXCGLSurfaceViewBase$j {
    private static String a = "GLThreadManager";
    private boolean b;
    private int c;
    private boolean d;
    private boolean e;
    private boolean f;
    private TXCGLSurfaceViewBase$i g;

    private TXCGLSurfaceViewBase$j() {
    }

    public /* synthetic */ TXCGLSurfaceViewBase$j(TXCGLSurfaceViewBase$1 tXCGLSurfaceViewBase$1) {
        this();
    }

    private void c() {
        boolean bl2;
        this.c = 131072;
        this.e = bl2 = true;
        this.b = bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(TXCGLSurfaceViewBase$i tXCGLSurfaceViewBase$i) {
        synchronized (this) {
            boolean bl2 = true;
            TXCGLSurfaceViewBase$i.a(tXCGLSurfaceViewBase$i, bl2);
            TXCGLSurfaceViewBase$i tXCGLSurfaceViewBase$i2 = this.g;
            if (tXCGLSurfaceViewBase$i2 == tXCGLSurfaceViewBase$i) {
                tXCGLSurfaceViewBase$i = null;
                this.g = null;
            }
            this.notifyAll();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(GL10 object) {
        synchronized (this) {
            int n10 = this.d;
            if (n10 == 0) {
                boolean bl2;
                this.c();
                n10 = 7937;
                object = object.glGetString(n10);
                n10 = this.c;
                int n11 = 131072;
                boolean bl3 = false;
                boolean bl4 = true;
                if (n10 < n11) {
                    String string2 = "Q3Dimension MSM7500 ";
                    bl2 = ((String)object).startsWith(string2);
                    if (!bl2) {
                        bl2 = bl4;
                    } else {
                        bl2 = false;
                        object = null;
                    }
                    this.e = bl2;
                    this.notifyAll();
                }
                if (!(bl2 = this.e)) {
                    bl3 = bl4;
                }
                this.f = bl3;
                this.d = bl4;
            }
            return;
        }
    }

    public boolean a() {
        synchronized (this) {
            boolean bl2 = this.f;
            return bl2;
        }
    }

    public boolean b() {
        synchronized (this) {
            this.c();
            boolean bl2 = this.e ^ true;
            return bl2;
        }
    }

    public boolean b(TXCGLSurfaceViewBase$i tXCGLSurfaceViewBase$i) {
        TXCGLSurfaceViewBase$i tXCGLSurfaceViewBase$i2 = this.g;
        boolean bl2 = true;
        if (tXCGLSurfaceViewBase$i2 != tXCGLSurfaceViewBase$i && tXCGLSurfaceViewBase$i2 != null) {
            this.c();
            boolean bl3 = this.e;
            if (bl3) {
                return bl2;
            }
            tXCGLSurfaceViewBase$i = this.g;
            if (tXCGLSurfaceViewBase$i != null) {
                tXCGLSurfaceViewBase$i.i();
            }
            return false;
        }
        this.g = tXCGLSurfaceViewBase$i;
        this.notifyAll();
        return bl2;
    }

    public void c(TXCGLSurfaceViewBase$i tXCGLSurfaceViewBase$i) {
        TXCGLSurfaceViewBase$i tXCGLSurfaceViewBase$i2 = this.g;
        if (tXCGLSurfaceViewBase$i2 == tXCGLSurfaceViewBase$i) {
            tXCGLSurfaceViewBase$i = null;
            this.g = null;
        }
        this.notifyAll();
    }
}

