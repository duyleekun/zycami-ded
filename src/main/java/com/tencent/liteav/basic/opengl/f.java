/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.opengl.EGLContext
 *  android.opengl.GLES20
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.view.Surface
 *  javax.microedition.khronos.egl.EGLContext
 */
package com.tencent.liteav.basic.opengl;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.f$1;
import com.tencent.liteav.basic.opengl.f$2;
import com.tencent.liteav.basic.opengl.f$3;
import com.tencent.liteav.basic.opengl.f$4;
import com.tencent.liteav.basic.opengl.h;
import com.tencent.liteav.basic.opengl.h$a;
import com.tencent.liteav.basic.opengl.i;
import com.tencent.liteav.basic.opengl.k;
import com.tencent.liteav.basic.opengl.l;
import com.tencent.liteav.basic.opengl.o;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import javax.microedition.khronos.egl.EGLContext;

public class f
implements h$a {
    private volatile HandlerThread a = null;
    private volatile h b = null;
    private i c = null;
    private int d = 0;
    private boolean e = false;
    private float f;
    private float g;
    private int h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private o m;
    private boolean n;

    public f() {
        float f10;
        this.f = f10 = 1.0f;
        this.g = f10;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = false;
        this.m = null;
        this.n = false;
    }

    public static /* synthetic */ int a(f f10, int n10) {
        f10.h = n10;
        return n10;
    }

    private void a(int n10, int n11) {
        int n12 = this.l;
        if (n12 != 0) {
            Thread thread;
            int n13;
            n12 = this.j;
            if (n12 != 0 && (n13 = this.k) != 0) {
                Bitmap.Config config;
                boolean bl2;
                if (n12 <= n13) {
                    bl2 = true;
                } else {
                    bl2 = false;
                    config = null;
                }
                int n14 = n13 >= n12 ? n13 : n12;
                if (n13 < n12) {
                    n12 = n13;
                }
                if (!bl2) {
                    int n15 = n14;
                    n14 = n12;
                    n12 = n15;
                }
                n13 = n12 * n14 * 4;
                ByteBuffer byteBuffer = ByteBuffer.allocate(n13);
                config = Bitmap.Config.ARGB_8888;
                config = Bitmap.createBitmap((int)n12, (int)n14, (Bitmap.Config)config);
                byteBuffer.position(0);
                int n16 = 6408;
                int n17 = 5121;
                Object object = byteBuffer;
                GLES20.glReadPixels((int)n10, (int)n11, (int)n12, (int)n14, (int)n16, (int)n17, (Buffer)byteBuffer);
                object = this.m;
                if (object != null) {
                    n16 = n12;
                    n17 = n14;
                    f$4 f$4 = new f$4(this, byteBuffer, (Bitmap)config, n12, n14, (o)object);
                    thread = new Thread(f$4);
                    thread.start();
                }
            }
            n10 = 0;
            thread = null;
            this.m = null;
            this.l = false;
        }
    }

    public static /* synthetic */ void a(f f10, int n10, boolean bl2, int n11, int n12, int n13, int n14, int n15, boolean bl3, boolean bl4) {
        f10.b(n10, bl2, n11, n12, n13, n14, n15, bl3, bl4);
    }

    private int[] a(int n10, int n11, int n12, int n13) {
        int n14 = 4;
        int[] nArray = new int[n14];
        float f10 = n11;
        float f11 = n10;
        float f12 = f10 / f11;
        float f13 = n13;
        float f14 = n12;
        float f15 = f12 - (f13 /= f14);
        n12 = (int)(f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1));
        int n15 = 2;
        f12 = 2.8E-45f;
        if (n12 > 0) {
            n12 = (int)(f11 *= f13);
            n13 = (n11 - n12) / n15;
            n11 = 0;
        } else {
            n12 = (int)(f10 /= f13);
            n10 = (n10 - n12) / n15;
            n13 = 0;
            f13 = 0.0f;
            int n16 = n11;
            n11 = n10;
            n10 = n12;
            n12 = n16;
        }
        nArray[0] = n10;
        nArray[1] = n12;
        nArray[n15] = n11;
        nArray[3] = n13;
        return nArray;
    }

    public static /* synthetic */ int b(f f10, int n10) {
        f10.i = n10;
        return n10;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private void b(int n10, boolean bl2, int n11, int n12, int n13, int n14, int n15, boolean bl3, boolean bl4) {
        Object object;
        float f10;
        float f11;
        float f12;
        void var16_23;
        void var26_57;
        int n16;
        int n17;
        f f13 = this;
        int n18 = n11;
        int n19 = n14;
        int n20 = n15;
        if (n14 == 0) return;
        if (n15 == 0) return;
        i i10 = this.c;
        if (i10 == null) {
            return;
        }
        int n21 = this.n;
        if (n21 != 0) {
            this.n = false;
            return;
        }
        int n22 = 36160;
        int n23 = 16640;
        int n24 = 1065353216;
        float f14 = 1.0f;
        int n25 = 0;
        float f15 = 0.0f;
        n21 = 1;
        float f16 = Float.MIN_VALUE;
        if (bl3) {
            GLES20.glClearColor((float)0.0f, (float)0.0f, (float)0.0f, (float)f14);
            GLES20.glClear((int)n23);
            GLES20.glBindFramebuffer((int)n22, (int)0);
            h h10 = this.b;
            if (h10 != null) {
                h h11 = this.b;
                h11.c();
            }
            f13.n = n21;
        }
        if (n12 != 0) {
            int n26 = n12;
        } else {
            int n27 = n19;
        }
        if (n13 != 0) {
            int n28 = n13;
        } else {
            int n29 = n20;
        }
        int n30 = f13.h;
        int n31 = 270;
        int n32 = 2;
        float f17 = 2.8E-45f;
        int n33 = 90;
        if (n30 != 0 && n30 == n21) {
            void var26_53;
            void var16_19;
            void var25_43;
            void var24_37;
            void var26_50;
            int n34 = (720 - n18) % 360;
            if (n34 != n33 && n34 != n31) {
                boolean bl5 = false;
            } else {
                int n35 = n21;
            }
            if (var26_50 != false) {
                int n36 = n20;
            } else {
                int n37 = n19;
            }
            if (var26_50 != false) {
                int n38 = n19;
            } else {
                int n39 = n20;
            }
            int[] nArray = f13.a((int)var24_37, (int)var25_43, (int)var16_19, (int)var26_53);
            int n40 = nArray[0];
            int n41 = nArray[n21];
            int n42 = nArray[n32];
            int n43 = 3;
            int n44 = nArray[n43];
            int n45 = n42;
            int n46 = n44;
            n17 = n40;
            n16 = n41;
            int n47 = n45;
        } else {
            boolean bl6 = false;
            boolean bl7 = false;
        }
        f13.j = n17;
        f13.k = n16;
        GLES20.glViewport((int)var26_57, (int)var16_23, (int)n17, (int)n16);
        n23 = f13.i;
        n23 = (n23 == n21 ? !bl4 : n23 == n32 && bl4) ? bl2 ^ 1 : (int)(bl2 ? 1 : 0);
        if (n16 != 0) {
            f17 = n17;
            f14 = n16;
            f17 /= f14;
        } else {
            n32 = 1065353216;
            f17 = 1.0f;
        }
        if (n20 != 0) {
            f14 = n19;
            f15 = n20;
            f14 /= f15;
        } else {
            n24 = 1065353216;
            f14 = 1.0f;
        }
        n25 = f13.e;
        if (n25 == n23 && (n25 = f13.d) == n18 && (n25 = (int)((f12 = (f15 = f13.f) - f17) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1))) == 0 && (n25 = (int)((f11 = (f15 = f13.g) - f14) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1))) == 0) {
            n23 = var26_57;
        } else {
            int n48;
            f13.e = n23;
            f13.d = n18;
            f13.f = f17;
            f13.g = f14;
            n23 = (n18 = 720 - n18) % 360;
            if (n23 != n33 && n23 != n31) {
                n24 = 0;
                f14 = 0.0f;
            } else {
                n24 = n21;
                f14 = f16;
            }
            n18 = n24 != 0 ? n16 : n17;
            if (n24 == 0) {
                n48 = n16;
            }
            i i11 = f13.c;
            float[] fArray = com.tencent.liteav.basic.opengl.l.a(com.tencent.liteav.basic.opengl.k.a, false, n21 != 0);
            f10 = n18;
            f16 = n48;
            f15 = f10 / f16;
            if (n24 != 0) {
                n32 = 0;
                f17 = 0.0f;
            } else {
                n32 = n18 = (int)(f13.e ? 1 : 0);
            }
            if (n24 != 0) {
                n18 = (int)(f13.e ? 1 : 0);
                n33 = n18;
            } else {
                n33 = 0;
            }
            object = i11;
            n19 = n14;
            n20 = n15;
            n21 = n23;
            float[] fArray2 = fArray;
            n23 = var26_57;
            int n49 = n32;
            n31 = n33;
            i11.a(n14, n15, n21, fArray, f15, n32 != 0, n33 != 0);
            if (n24 != 0) {
                object = f13.c;
                ((i)object).g();
            } else {
                object = f13.c;
                ((i)object).h();
            }
        }
        n18 = 1065353216;
        f10 = 1.0f;
        n19 = 0;
        GLES20.glClearColor((float)0.0f, (float)0.0f, (float)0.0f, (float)f10);
        GLES20.glClear((int)16640);
        n18 = 36160;
        f10 = 5.0671E-41f;
        GLES20.glBindFramebuffer((int)n18, (int)0);
        object = f13.c;
        n19 = n10;
        ((i)object).a(n10);
        f13.a(n23, (int)var16_23);
        object = f13.b;
        if (object == null) return;
        object = f13.b;
        ((h)((Object)object)).c();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b(Object object, Surface object2) {
        this.f();
        synchronized (this) {
            boolean bl2;
            Object object3;
            String string2 = "TXGLSurfaceRenderThread";
            object3 = this.a = (object3 = new HandlerThread(string2));
            object3.start();
            string2 = this.a;
            string2 = string2.getLooper();
            object3 = new h((Looper)string2);
            this.b = object3;
            object3 = this.b;
            object3.a(this);
            if (object != null && !(bl2 = object instanceof EGLContext)) {
                boolean bl3;
                object3 = this.b;
                object3.d = bl3 = true;
                object3 = this.b;
                object = (android.opengl.EGLContext)object;
                object3.f = object;
            } else {
                object3 = this.b;
                boolean bl4 = false;
                string2 = null;
                object3.d = false;
                object3 = this.b;
                object = (EGLContext)object;
                object3.h = object;
            }
            object = this.b;
            ((h)object).c = object2;
            object = "TXGLSurfaceRenderThread";
            object2 = new StringBuilder();
            object3 = "surface-render: create gl thread ";
            ((StringBuilder)object2).append((String)object3);
            object3 = this.a;
            object3 = object3.getName();
            ((StringBuilder)object2).append((String)object3);
            object2 = ((StringBuilder)object2).toString();
            TXCLog.w((String)object, (String)object2);
        }
        this.c(100);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void c(int n10) {
        synchronized (this) {
            h h10 = this.b;
            if (h10 != null) {
                h10 = this.b;
                h10.sendEmptyMessage(n10);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void f() {
        synchronized (this) {
            Object object = this.b;
            if (object != null) {
                object = this.b;
                Object object2 = this.a;
                com.tencent.liteav.basic.opengl.h.a(object, object2);
                object = "TXGLSurfaceRenderThread";
                object2 = "surface-render: destroy gl thread";
                TXCLog.w((String)object, (String)object2);
            }
            object = null;
            this.b = null;
            this.a = null;
            return;
        }
    }

    public void a() {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("surface-render: surface render stop ");
        charSequence.append(this);
        charSequence = charSequence.toString();
        TXCLog.i("TXGLSurfaceRenderThread", (String)charSequence);
        this.f();
    }

    public void a(int n10) {
        f$1 f$1 = new f$1(this, n10);
        this.a(f$1);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(int n10, boolean bl2, int n11, int n12, int n13, int n14, int n15, boolean bl3, boolean bl4) {
        GLES20.glFinish();
        synchronized (this) {
            h h10 = this.b;
            if (h10 != null) {
                h10 = this.b;
                f$3 f$3 = new f$3(this, n10, bl2, n11, n12, n13, n14, n15, bl3, bl4);
                h10.post(f$3);
            }
            return;
        }
    }

    public void a(o o10) {
        this.m = o10;
        this.l = true;
    }

    public void a(Object object, Surface surface) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("surface-render: surface render start ");
        charSequence.append(surface);
        charSequence.append(", ");
        charSequence.append(this);
        charSequence = charSequence.toString();
        TXCLog.i("TXGLSurfaceRenderThread", (String)charSequence);
        this.b(object, surface);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(Runnable runnable) {
        synchronized (this) {
            h h10 = this.b;
            if (h10 != null) {
                h10 = this.b;
                h10.post(runnable);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Surface b() {
        synchronized (this) {
            h h10 = this.b;
            if (h10 == null) return null;
            h10 = this.b;
            return h10.b();
        }
    }

    public void b(int n10) {
        f$2 f$2 = new f$2(this, n10);
        this.a(f$2);
    }

    public void c() {
        i i10;
        this.c = i10 = new i();
        boolean bl2 = i10.a();
        if (!bl2) {
            return;
        }
        i10 = this.c;
        float[] fArray = com.tencent.liteav.basic.opengl.l.e;
        float[] fArray2 = com.tencent.liteav.basic.opengl.l.a(com.tencent.liteav.basic.opengl.k.a, false, false);
        i10.a(fArray, fArray2);
    }

    public void d() {
    }

    public void e() {
        i i10 = this.c;
        if (i10 != null) {
            i10.d();
            i10 = null;
            this.c = null;
        }
    }
}

