/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.SurfaceTexture
 *  android.graphics.SurfaceTexture$OnFrameAvailableListener
 *  android.opengl.GLES20
 *  android.opengl.GLSurfaceView$Renderer
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.util.AttributeSet
 *  javax.microedition.khronos.egl.EGL10
 *  javax.microedition.khronos.egl.EGLConfig
 *  javax.microedition.khronos.egl.EGLContext
 *  javax.microedition.khronos.opengles.GL10
 */
package com.tencent.liteav.renderer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.AttributeSet;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.TXCOpenGlUtils;
import com.tencent.liteav.basic.opengl.i;
import com.tencent.liteav.basic.opengl.k;
import com.tencent.liteav.basic.opengl.l;
import com.tencent.liteav.basic.opengl.m;
import com.tencent.liteav.basic.opengl.n;
import com.tencent.liteav.basic.opengl.o;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.renderer.TXCGLSurfaceView$1;
import com.tencent.liteav.renderer.TXCGLSurfaceView$2;
import com.tencent.liteav.renderer.TXCGLSurfaceView$3;
import com.tencent.liteav.renderer.TXCGLSurfaceView$4;
import com.tencent.liteav.renderer.TXCGLSurfaceView$5;
import com.tencent.liteav.renderer.TXCGLSurfaceViewBase;
import java.lang.ref.WeakReference;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Queue;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;

public class TXCGLSurfaceView
extends TXCGLSurfaceViewBase
implements SurfaceTexture.OnFrameAvailableListener,
GLSurfaceView.Renderer,
m {
    private o A;
    private int B;
    private int C;
    private boolean D;
    private boolean E;
    private n F;
    private long G;
    private byte[] H;
    private long I;
    private int J;
    private int K;
    private final Queue L;
    public WeakReference a;
    private SurfaceTexture g;
    private EGLContext h;
    private i i;
    private int[] j;
    private float[] k;
    private int l;
    private boolean m;
    private float n;
    private float o;
    private int p;
    private long q;
    private long r;
    private int s;
    private boolean t;
    private boolean u;
    private Object v;
    private Handler w;
    private int x;
    private int y;
    private boolean z;

    public TXCGLSurfaceView(Context object) {
        super((Context)object);
        Object object2;
        boolean bl2;
        long l10;
        float f10;
        object = new float[16];
        this.k = (float[])object;
        this.l = 0;
        this.m = false;
        this.n = f10 = 1.0f;
        this.o = f10;
        this.p = 20;
        this.q = l10 = 0L;
        this.r = l10;
        this.s = 12288;
        this.t = bl2 = true;
        this.u = false;
        this.v = object2 = new Object();
        this.x = 0;
        this.y = 0;
        this.z = bl2;
        this.A = null;
        this.B = 0;
        this.C = 0;
        this.D = bl2;
        this.E = bl2;
        this.H = null;
        this.I = l10;
        this.J = 0;
        this.K = 0;
        super();
        this.L = object;
        this.setEGLContextClientVersion(2);
        this.a(8, 8, 8, 8, 16, 0);
        this.setRenderer(this);
    }

    public TXCGLSurfaceView(Context object, AttributeSet attributeSet) {
        super((Context)object, attributeSet);
        Object object2;
        boolean bl2;
        long l10;
        float f10;
        object = new float[16];
        this.k = (float[])object;
        this.l = 0;
        this.m = false;
        this.n = f10 = 1.0f;
        this.o = f10;
        this.p = 20;
        this.q = l10 = 0L;
        this.r = l10;
        this.s = 12288;
        this.t = bl2 = true;
        this.u = false;
        this.v = object2 = new Object();
        this.x = 0;
        this.y = 0;
        this.z = bl2;
        this.A = null;
        this.B = 0;
        this.C = 0;
        this.D = bl2;
        this.E = bl2;
        this.H = null;
        this.I = l10;
        this.J = 0;
        this.K = 0;
        super();
        this.L = object;
        this.setEGLContextClientVersion(2);
        this.a(8, 8, 8, 8, 16, 0);
        this.setRenderer(this);
    }

    public static /* synthetic */ int a(TXCGLSurfaceView tXCGLSurfaceView) {
        return tXCGLSurfaceView.p;
    }

    public static /* synthetic */ int a(TXCGLSurfaceView tXCGLSurfaceView, int n10) {
        tXCGLSurfaceView.p = n10;
        return n10;
    }

    public static /* synthetic */ long a(TXCGLSurfaceView tXCGLSurfaceView, long l10) {
        tXCGLSurfaceView.r = l10;
        return l10;
    }

    private void a(int n10, int n11) {
        int n12 = this.z;
        if (n12 != 0) {
            Thread thread;
            int n13;
            n12 = this.x;
            if (n12 != 0 && (n13 = this.y) != 0) {
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
                object = this.A;
                if (object != null) {
                    n16 = n12;
                    n17 = n14;
                    TXCGLSurfaceView$5 tXCGLSurfaceView$5 = new TXCGLSurfaceView$5(this, byteBuffer, (Bitmap)config, n12, n14, (o)object);
                    thread = new Thread(tXCGLSurfaceView$5);
                    thread.start();
                }
            }
            n10 = 0;
            thread = null;
            this.A = null;
            this.z = false;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void a(long l10) {
        try {
            Thread.sleep(l10);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private boolean a(Queue queue) {
        // MONITORENTER : queue
        boolean bl2 = queue.isEmpty();
        if (bl2) {
            // MONITOREXIT : queue
            return false;
        }
        Object object = queue.poll();
        object = (Runnable)object;
        // MONITOREXIT : queue
        if (object == null) {
            return false;
        }
        object.run();
        return true;
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

    public static /* synthetic */ int b(TXCGLSurfaceView tXCGLSurfaceView, int n10) {
        tXCGLSurfaceView.B = n10;
        return n10;
    }

    public static /* synthetic */ long b(TXCGLSurfaceView tXCGLSurfaceView, long l10) {
        tXCGLSurfaceView.q = l10;
        return l10;
    }

    public static /* synthetic */ int c(TXCGLSurfaceView tXCGLSurfaceView, int n10) {
        tXCGLSurfaceView.C = n10;
        return n10;
    }

    private void g() {
        boolean bl2 = this.E;
        if (bl2) {
            SurfaceTexture surfaceTexture = this.g;
            if (surfaceTexture != null) {
                int n10 = Build.VERSION.SDK_INT;
                int n11 = 21;
                if (n10 >= n11) {
                    Handler handler;
                    surfaceTexture = this.w;
                    if (surfaceTexture == null) {
                        surfaceTexture = new HandlerThread("VideoCaptureThread");
                        surfaceTexture.start();
                        surfaceTexture = surfaceTexture.getLooper();
                        this.w = handler = new Handler((Looper)surfaceTexture);
                    }
                    surfaceTexture = this.g;
                    handler = this.w;
                    surfaceTexture.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener)this, handler);
                } else {
                    surfaceTexture.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener)this);
                }
            }
        } else {
            SurfaceTexture surfaceTexture = this.g;
            if (surfaceTexture != null) {
                boolean bl3 = false;
                Object var5_8 = null;
                surfaceTexture.setOnFrameAvailableListener(null);
            }
        }
    }

    public void a() {
        this.b(false);
    }

    public void a(int n10, boolean bl2) {
        long l10;
        this.p = n10;
        boolean bl3 = true;
        if (n10 <= 0) {
            this.p = bl3;
        } else {
            int n11 = 60;
            if (n10 > n11) {
                this.p = n11;
            }
        }
        this.A = null;
        this.z = false;
        this.J = 0;
        this.I = l10 = 0L;
        this.K = 0;
        this.b(bl3);
        this.E = bl2;
        this.G = l10;
        this.g();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(int object, boolean bl2, int object2, int object3, int object4, boolean object5) {
        i i10;
        float f10;
        float f11;
        float f12;
        int n10;
        int n11;
        Object object6;
        Object object7;
        TXCGLSurfaceView tXCGLSurfaceView = this;
        Object object8 = object2;
        Object object9 = object4;
        Object object10 = object5;
        Object object11 = this.i;
        if (object11 == null) {
            return;
        }
        synchronized (this) {
            object7 = this.c;
            if (object7 != 0) {
                return;
            }
        }
        object7 = this.getWidth();
        Object object12 = this.getHeight();
        Object object13 = this.B;
        Object object14 = 270;
        float f13 = 3.78E-43f;
        Object object15 = 2;
        float f14 = 2.8E-45f;
        Object object16 = 90;
        Object object17 = 1;
        float f15 = Float.MIN_VALUE;
        if (object13 != 0 && object13 == object17) {
            object13 = (720 - object2) % 360;
            if (object13 != object16 && object13 != object14) {
                object13 = 0;
                object6 = null;
            } else {
                object13 = object17;
            }
            n11 = object13 != 0 ? object9 : object3;
            object13 = object13 != 0 ? object3 : object9;
            object11 = tXCGLSurfaceView.a((int)object7, (int)object12, n11, (int)object13);
            object12 = object11[0];
            object13 = object11[object17];
            n11 = (int)object11[object15];
            object7 = object11[3];
            n10 = n11;
            n11 = object7;
            object7 = object12;
            object12 = object13;
        } else {
            n11 = 0;
            n10 = 0;
        }
        tXCGLSurfaceView.x = object7;
        tXCGLSurfaceView.y = object12;
        GLES20.glViewport((int)n10, (int)n11, (int)object7, (int)object12);
        object13 = tXCGLSurfaceView.C;
        object13 = (object13 == object17 ? object10 == 0 : object13 == object15 && object10 != 0) ? bl2 ^ true : (Object)bl2;
        if (object12 != 0) {
            f14 = object7;
            float f16 = object12;
            f14 /= f16;
        } else {
            object15 = 1065353216;
            f14 = 1.0f;
        }
        if (object9 != 0) {
            f12 = object3;
            f15 = object9;
            f12 /= f15;
        } else {
            f12 = 1.0f;
        }
        object17 = tXCGLSurfaceView.m;
        if (object17 != object13 || (object17 = tXCGLSurfaceView.l) != object8 || (object17 = (Object)((f11 = (f15 = tXCGLSurfaceView.n) - f14) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1))) != 0 || (object17 = (Object)((f10 = (f15 = tXCGLSurfaceView.o) - f12) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1))) != 0 || (object17 = (Object)tXCGLSurfaceView.D) != object10) {
            tXCGLSurfaceView.m = object13;
            tXCGLSurfaceView.l = object8;
            tXCGLSurfaceView.n = f14;
            tXCGLSurfaceView.o = f12;
            tXCGLSurfaceView.D = object10;
            if ((object8 = (720 - object8) % 360) != object16 && object8 != object14) {
                object17 = 0;
                f15 = 0.0f;
            } else {
                object17 = 1;
                f15 = Float.MIN_VALUE;
            }
            object10 = object17 != 0 ? object12 : object7;
            if (object17 == 0) {
                object7 = object12;
            }
            i i11 = tXCGLSurfaceView.i;
            object6 = com.tencent.liteav.basic.opengl.k.a;
            object14 = 1;
            object6 = com.tencent.liteav.basic.opengl.l.a(object6, false, (boolean)object14);
            float f17 = object10;
            float f18 = object7;
            f13 = f17 / f18;
            if (object17 != 0) {
                object15 = 0;
                f14 = 0.0f;
            } else {
                object15 = object10 = tXCGLSurfaceView.m;
            }
            object16 = object17 != 0 ? (object10 = tXCGLSurfaceView.m) : 0;
            object7 = object3;
            object9 = object4;
            object12 = object8;
            i11.a((int)object3, (int)object4, (int)object8, (float[])object6, f13, (boolean)object15, (boolean)object16);
            if (object17 != 0) {
                i10 = tXCGLSurfaceView.i;
                i10.g();
            } else {
                i10 = tXCGLSurfaceView.i;
                i10.h();
            }
        }
        GLES20.glBindFramebuffer((int)36160, (int)0);
        GLES20.glClearColor((float)0.0f, (float)0.0f, (float)0.0f, (float)1.0f);
        GLES20.glClear((int)16640);
        i10 = tXCGLSurfaceView.i;
        object10 = object;
        i10.a((int)object);
        tXCGLSurfaceView.a(n10, n11);
    }

    public void a(o o10) {
        this.A = o10;
        this.z = true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(Runnable runnable) {
        Queue queue = this.L;
        synchronized (queue) {
            Queue queue2 = this.L;
            queue2.add(runnable);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(boolean bl2) {
        boolean bl3;
        this.t = bl3 = true;
        if (bl2) {
            bl3 = false;
            GLES20.glClearColor((float)0.0f, (float)0.0f, (float)0.0f, (float)1.0f);
            GLES20.glClear((int)16384);
            bl2 = this.e();
            this.s = (int)(bl2 ? 1 : 0);
        }
        synchronized (this) {
            bl2 = this.u;
            if (bl2) {
                bl2 = false;
                SurfaceTexture surfaceTexture = null;
                this.u = false;
                surfaceTexture = this.g;
                if (surfaceTexture != null) {
                    surfaceTexture.updateTexImage();
                }
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(byte[] byArray) {
        synchronized (this) {
            this.H = byArray;
            boolean bl2 = false;
            byArray = null;
            this.t = false;
            this.u = bl2 = true;
            return;
        }
    }

    public void b() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("onSurfaceDestroyed-->enter with mSurfaceTextureListener:");
        Object object2 = this.F;
        ((StringBuilder)object).append(object2);
        object = ((StringBuilder)object).toString();
        object2 = "TXCGLSurfaceView";
        TXCLog.i((String)object2, (String)object);
        object = this.F;
        if (object != null) {
            object2 = this.g;
            object.b((SurfaceTexture)object2);
        }
        if ((object = this.g) != null) {
            object.release();
            object = null;
            this.g = null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(Runnable runnable) {
        Queue queue = this.L;
        synchronized (queue) {
            Queue queue2 = this.L;
            queue2.add(runnable);
            return;
        }
    }

    public int c() {
        int n10 = this.s;
        int n11 = 12288;
        if (n10 != n11) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("background capture swapbuffer error : ");
            n11 = this.s;
            charSequence.append(n11);
            charSequence = charSequence.toString();
            String string2 = "TXCGLSurfaceView";
            TXCLog.e(string2, (String)charSequence);
        }
        return this.s;
    }

    public EGLContext getGLContext() {
        return this.h;
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.g;
    }

    public void onDetachedFromWindow() {
        Handler handler;
        super.onDetachedFromWindow();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11 && (handler = this.w) != null) {
            handler.getLooper().quitSafely();
            n10 = 0;
            handler = null;
            this.w = null;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onDrawFrame(GL10 var1_1) {
        var1_1 /* !! */  = this.L;
        this.a((Queue)var1_1 /* !! */ );
        var2_3 = 1;
        var3_4 = 0;
        var4_5 = null;
        var5_6 = var2_3;
        while (true) {
            var6_7 = System.currentTimeMillis();
            var8_8 = this.r;
            var10_9 = 0L;
            cfr_temp_0 = var8_8 - var10_9;
            var12_10 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
            if (var12_10 /* !! */  == false || (var13_11 = var6_7 == var8_8 ? 0 : (var6_7 < var8_8 ? -1 : 1)) < 0) {
                this.r = var6_7;
            }
            var8_8 = this.r;
            var10_9 = var6_7 - var8_8;
            var14_12 = this.q;
            var16_13 = 1000L;
            var14_12 *= var16_13;
            var18_14 = this.p;
            var19_15 = var18_14;
            cfr_temp_1 = var10_9 - (var14_12 /= var19_15);
            var12_10 /* !! */  = (long)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1));
            if (var12_10 /* !! */  >= 0) break;
            var21_16 = 15;
            this.a(var21_16);
            var5_6 = 0;
            var23_17 = null;
        }
        cfr_temp_2 = (var6_7 -= var8_8) - var16_13;
        var24_18 = cfr_temp_2 == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1);
        var25_19 = 1L;
        var27_20 = 4.9E-324;
        if (var24_18 > 0) {
            this.q = var25_19;
            this.r = var29_21 = System.currentTimeMillis();
            var24_18 = var2_3;
        } else {
            var24_18 = 0;
            var31_22 /* !! */  = null;
        }
        var32_23 = this.t;
        if (var32_23) {
            return;
        }
        try {
            synchronized (this) {
                var32_23 = this.u;
            }
        }
        catch (Exception var1_2) {
            var4_5 = "TXCGLSurfaceView";
            var23_17 = "onDrawFrame failed";
            TXCLog.e(var4_5, (String)var23_17, var1_2);
            return;
        }
        {
            var12_10 /* !! */  = 0;
            var33_24 = null;
            if (!var32_23) {
                var24_18 = var2_3;
            } else {
                var23_17 = this.H;
                if (var23_17 != null) {
                    this.H = null;
                    var34_25 = this.g;
                    if (var34_25 != null) {
                        var34_25.updateTexImage();
                        var34_25 = this.g;
                        var33_24 = this.k;
                        var34_25.getTransformMatrix((float[])var33_24);
                    }
                    var33_24 = var23_17;
                } else {
                    var23_17 = this.g;
                    if (var23_17 != null) {
                        var23_17.updateTexImage();
                        var23_17 = this.g;
                        var34_26 = this.k;
                        var23_17.getTransformMatrix(var34_26);
                    }
                }
                this.q = var24_18 == false ? (var21_16 = this.q + var25_19) : var25_19;
                this.u = false;
                var5_6 = 0;
                var23_17 = null;
                var24_18 = 0;
                var31_22 /* !! */  = null;
            }
            if (var2_3 != var24_18) ** GOTO lbl87
        }
        if (var2_3 != var5_6) return;
        var35_27 = 5;
        {
            this.a(var35_27);
            return;
lbl87:
            // 1 sources

            var21_16 = System.currentTimeMillis();
            var27_20 = var21_16;
            var37_29 = this.I;
        }
        var39_30 = var37_29;
        var41_31 = 1000.0;
        cfr_temp_3 = var27_20 - (var39_30 += var41_31);
        var43_32 /* !! */  = (double)(cfr_temp_3 == 0.0 ? 0 : (cfr_temp_3 > 0.0 ? 1 : -1));
        if (var43_32 /* !! */  <= 0) ** GOTO lbl102
        {
            var27_20 = (double)this.K * var41_31;
            var37_29 = var21_16 - var37_29;
        }
        var44_33 = var37_29;
        var43_32 /* !! */  = (int)(var27_20 /= var44_33) + var2_3;
        {
            this.J = (int)var43_32 /* !! */ ;
            this.I = var21_16;
            this.K = 0;
lbl102:
            // 2 sources

            this.K = var5_6 = this.K + var2_3;
            var23_17 = this.F;
            if (var23_17 != null) {
                if (var33_24 != null) {
                    var31_22 /* !! */  = this.k;
                    var23_17.a((byte[])var33_24, var31_22 /* !! */ );
                } else {
                    var31_22 /* !! */  = this.j;
                    var24_18 = (long)var31_22 /* !! */ [0];
                    var46_34 = this.k;
                    var23_17.a((int)var24_18, var46_34);
                }
            }
            ** synchronized (this)
        }
lbl-1000:
        // 1 sources

        {
            var5_6 = (int)this.c;
            if (var5_6 != 0) {
                var2_3 = 0;
                var1_1 /* !! */  = null;
            }
        }
        if (var2_3 == 0) return;
        {
            var2_3 = this.e();
            var3_4 = 12288;
            if (var2_3 == var3_4) return;
            var35_28 = System.currentTimeMillis();
            var6_7 = this.G;
        }
        cfr_temp_4 = (var35_28 -= var6_7) - (var6_7 = 2000L);
        var3_4 = (int)(cfr_temp_4 == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1));
        if (var3_4 <= 0) return;
        var4_5 = "TXCGLSurfaceView";
        {
            var23_17 = new StringBuilder();
            var31_22 /* !! */  = (float[])"background capture swapBuffer error : ";
            var23_17.append((String)var31_22 /* !! */ );
            var23_17.append(var2_3);
            var23_17 = var23_17.toString();
            TXCLog.w(var4_5, (String)var23_17);
            this.G = var35_28 = System.currentTimeMillis();
            var4_5 = new Bundle();
            var23_17 = "EVT_PARAM1";
            var4_5.putInt((String)var23_17, var2_3);
            var1_1 /* !! */  = "EVT_ID";
            var5_6 = 2110;
            var4_5.putInt((String)var1_1 /* !! */ , var5_6);
            var1_1 /* !! */  = "EVT_TIME";
            var6_7 = TXCTimeUtil.getTimeTick();
            var4_5.putLong((String)var1_1 /* !! */ , var6_7);
            var1_1 /* !! */  = "EVT_UTC_TIME";
            var6_7 = TXCTimeUtil.getUtcTimeTick();
            var4_5.putLong((String)var1_1 /* !! */ , var6_7);
            var1_1 /* !! */  = "EVT_MSG";
            var31_22 /* !! */  = (float[])"Failed to render video";
            var4_5.putCharSequence((String)var1_1 /* !! */ , (CharSequence)var31_22 /* !! */ );
            var1_1 /* !! */  = this.a;
            com.tencent.liteav.basic.util.g.a((WeakReference)var1_1 /* !! */ , var5_6, (Bundle)var4_5);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        surfaceTexture = null;
        this.t = false;
        synchronized (this) {
            boolean bl2;
            this.u = bl2 = true;
            return;
        }
    }

    public void onSurfaceChanged(GL10 gL10, int n10, int n11) {
    }

    public void onSurfaceCreated(GL10 object, EGLConfig object2) {
        object = ((EGL10)EGLContext.getEGL()).eglGetCurrentContext();
        this.h = object;
        object = new int[1];
        this.j = (int[])object;
        Object object3 = TXCOpenGlUtils.b();
        float[] fArray = null;
        object[0] = (GL10)object3;
        object = this.j;
        Object object4 = object[0];
        if (object4 <= 0) {
            this.j = null;
            TXCLog.e("TXCGLSurfaceView", "create oes texture error!! at glsurfaceview");
            return;
        }
        object2 = this.j;
        object3 = object2[0];
        object = new SurfaceTexture(object3);
        this.g = object;
        this.g();
        object = new i();
        this.i = object;
        object4 = ((i)object).a();
        if (object4 == false) {
            return;
        }
        object = this.i;
        object2 = com.tencent.liteav.basic.opengl.l.e;
        k k10 = com.tencent.liteav.basic.opengl.k.a;
        fArray = com.tencent.liteav.basic.opengl.l.a(k10, false, false);
        ((i)object).a((float[])object2, fArray);
        object = this.F;
        if (object != null) {
            object2 = this.g;
            object.a((SurfaceTexture)object2);
        }
    }

    public void setFPS(int n10) {
        TXCGLSurfaceView$1 tXCGLSurfaceView$1 = new TXCGLSurfaceView$1(this, n10);
        this.b(tXCGLSurfaceView$1);
    }

    public void setNotifyListener(b b10) {
        WeakReference<b> weakReference;
        this.a = weakReference = new WeakReference<b>(b10);
    }

    public void setRendMirror(int n10) {
        TXCGLSurfaceView$3 tXCGLSurfaceView$3 = new TXCGLSurfaceView$3(this, n10);
        this.b(tXCGLSurfaceView$3);
    }

    public void setRendMode(int n10) {
        TXCGLSurfaceView$2 tXCGLSurfaceView$2 = new TXCGLSurfaceView$2(this, n10);
        this.b(tXCGLSurfaceView$2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setRunInBackground(boolean bl2) {
        if (bl2) {
            synchronized (this) {
                String string2 = "TXCGLSurfaceView";
                String string3 = "background capture enter background";
                TXCLog.i(string2, string3);
                this.c = bl2 = true;
                return;
            }
        }
        TXCGLSurfaceView$4 tXCGLSurfaceView$4 = new TXCGLSurfaceView$4(this);
        this.b(tXCGLSurfaceView$4);
    }

    public void setSurfaceTextureListener(n n10) {
        this.F = n10;
    }
}

