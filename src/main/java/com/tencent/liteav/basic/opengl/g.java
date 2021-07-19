/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.graphics.SurfaceTexture$OnFrameAvailableListener
 *  android.opengl.GLES20
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Message
 *  javax.microedition.khronos.egl.EGLContext
 */
package com.tencent.liteav.basic.opengl;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.TXCOpenGlUtils;
import com.tencent.liteav.basic.opengl.g$1;
import com.tencent.liteav.basic.opengl.g$2;
import com.tencent.liteav.basic.opengl.h;
import com.tencent.liteav.basic.opengl.h$a;
import com.tencent.liteav.basic.opengl.m;
import com.tencent.liteav.basic.opengl.n;
import javax.microedition.khronos.egl.EGLContext;

public class g
implements h$a,
m {
    public int a = 25;
    private volatile HandlerThread b = null;
    private volatile h c = null;
    private n d;
    private int[] e = null;
    private SurfaceTexture f = null;
    private boolean g = false;
    private long h;
    private long i;
    private float[] j;

    public g() {
        long l10;
        this.h = l10 = 0L;
        this.i = l10;
        float[] fArray = new float[16];
        this.j = fArray;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(int n10) {
        synchronized (this) {
            h h10 = this.c;
            if (h10 != null) {
                h10 = this.c;
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
    private void a(int n10, long l10) {
        synchronized (this) {
            h h10 = this.c;
            if (h10 != null) {
                h10 = this.c;
                h10.sendEmptyMessageDelayed(n10, l10);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(int n10, Runnable runnable) {
        synchronized (this) {
            h h10 = this.c;
            if (h10 != null) {
                h10 = new Message();
                ((Message)h10).what = n10;
                ((Message)h10).obj = runnable;
                h h11 = this.c;
                h11.sendMessage((Message)h10);
            }
            return;
        }
    }

    public static /* synthetic */ void a(g g10, int n10) {
        g10.a(n10);
    }

    public static /* synthetic */ void a(g g10, int n10, Runnable runnable) {
        g10.a(n10, runnable);
    }

    public static /* synthetic */ boolean a(g g10, boolean bl2) {
        g10.g = bl2;
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b() {
        this.f();
        synchronized (this) {
            int n10;
            Object object;
            CharSequence charSequence = "TXGLSurfaceTextureThread";
            object = this.b = (object = new HandlerThread((String)charSequence));
            object.start();
            charSequence = this.b;
            charSequence = charSequence.getLooper();
            object = new h((Looper)charSequence);
            this.c = object;
            object = this.c;
            object.a(this);
            object = this.c;
            object.a = n10 = 1280;
            object = this.c;
            object.b = n10 = 720;
            object = "TXGLSurfaceTextureThread";
            charSequence = new StringBuilder();
            String string2 = "create gl thread ";
            ((StringBuilder)charSequence).append(string2);
            string2 = this.b;
            string2 = string2.getName();
            ((StringBuilder)charSequence).append(string2);
            charSequence = ((StringBuilder)charSequence).toString();
            TXCLog.w((String)object, (String)charSequence);
        }
        this.a(100);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void f() {
        synchronized (this) {
            Object object = this.c;
            if (object != null) {
                object = this.c;
                Object object2 = this.b;
                com.tencent.liteav.basic.opengl.h.a(object, object2);
                object = "TXGLSurfaceTextureThread";
                object2 = "destroy gl thread";
                TXCLog.w((String)object, (String)object2);
            }
            object = null;
            this.c = null;
            this.b = null;
            return;
        }
    }

    private void g() {
        String string2 = "destroy surface texture ";
        TXCLog.w("TXGLSurfaceTextureThread", string2);
        Object object = this.d;
        if (object != null) {
            string2 = this.f;
            object.b((SurfaceTexture)string2);
        }
        object = this.f;
        string2 = null;
        if (object != null) {
            object.setOnFrameAvailableListener(null);
            object = this.f;
            object.release();
            this.g = false;
            this.f = null;
        }
        if ((object = (Object)this.e) != null) {
            int n10 = 1;
            GLES20.glDeleteTextures((int)n10, (int[])object, (int)0);
            this.e = null;
        }
    }

    private void h() {
        Object object = "init surface texture ";
        TXCLog.w("TXGLSurfaceTextureThread", (String)object);
        Object object2 = new int[1];
        this.e = object2;
        int n10 = TXCOpenGlUtils.b();
        int n11 = 0;
        object2[0] = n10;
        object2 = this.e;
        int n12 = object2[0];
        if (n12 <= 0) {
            this.e = null;
            return;
        }
        object2 = new SurfaceTexture;
        n10 = this.e[0];
        object2(n10);
        this.f = (SurfaceTexture)object2;
        n10 = 1280;
        n11 = 720;
        object2.setDefaultBufferSize(n10, n11);
        object2 = this.f;
        object = new g$2(this);
        object2.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener)object);
        object2 = this.d;
        if (object2 != null) {
            object = this.f;
            object2.a((SurfaceTexture)object);
        }
    }

    private boolean i() {
        long l10;
        Object object = this.g;
        long l11 = 0L;
        if (object == 0) {
            this.h = l11;
            this.i = l11 = System.nanoTime();
            return false;
        }
        long l12 = System.nanoTime();
        long l13 = this.i;
        long l14 = this.h;
        long l15 = 1000L;
        l14 = l14 * l15 * l15 * l15;
        l15 = this.a;
        long l16 = l12 - (l14 = l14 / l15 + l13);
        object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object < 0) {
            return false;
        }
        object = l13 == l11 ? 0 : (l13 < l11 ? -1 : 1);
        if (object == 0) {
            this.i = l12;
        } else {
            l10 = 1000000000L;
            long l17 = l12 - (l13 += l10);
            object = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
            if (object > 0) {
                this.h = l11;
                this.i = l12;
            }
        }
        this.h = l10 = this.h + 1L;
        return true;
    }

    public void a() {
        this.f();
    }

    public void a(int n10, boolean bl2) {
        this.a = n10;
        this.b();
    }

    public void a(int n10, boolean bl2, int n11, int n12, int n13, boolean bl3) {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(Runnable runnable) {
        synchronized (this) {
            h h10 = this.c;
            if (h10 != null) {
                h10 = this.c;
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
    public void a(boolean bl2) {
        synchronized (this) {
            Throwable throwable2;
            block7: {
                Object object;
                Object object2;
                try {
                    try {
                        object2 = this.c;
                        if (object2 != null) {
                            object2 = this.c;
                            object = null;
                            object2.removeCallbacksAndMessages(null);
                        }
                        object2 = null;
                        this.g = false;
                        object2 = this.f;
                        if (object2 == null || (object = (Object)this.e) == null) {
                            return;
                        }
                        object2.updateTexImage();
                    }
                    catch (Exception exception) {
                        object = "TXGLSurfaceTextureThread";
                        StringBuilder stringBuilder = new StringBuilder();
                        String string2 = "updateTexImage failed.";
                        stringBuilder.append(string2);
                        object2 = exception.getMessage();
                        stringBuilder.append((String)object2);
                        object2 = stringBuilder.toString();
                        TXCLog.e((String)object, (String)object2);
                    }
                }
                catch (Throwable throwable2) {
                    break block7;
                }
                object2 = this.f;
                object = new g$1(this);
                object2.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener)object);
                return;
            }
            throw throwable2;
        }
    }

    public void a(byte[] byArray) {
    }

    public void c() {
        this.h();
    }

    public void d() {
        Object object;
        long l10 = 5;
        this.a(102, l10);
        boolean bl2 = this.i();
        if (!bl2) {
            return;
        }
        Object object2 = this.f;
        if (object2 != null && (object = this.e) != null) {
            Object object3;
            object2.updateTexImage();
            object2 = this.f;
            object = this.j;
            try {
                object2.getTransformMatrix((float[])object);
            }
            catch (Exception exception) {
                object = new StringBuilder;
                object();
                object3 = "onMsgRend Exception ";
                object.append((String)object3);
                object2 = exception.getMessage();
                object.append((String)object2);
                object2 = object.toString();
                object = "TXGLSurfaceTextureThread";
                TXCLog.e((String)object, (String)object2);
            }
            object2 = this.d;
            if (object2 != null) {
                object = this.e;
                int n10 = object[0];
                object3 = this.j;
                object2.a(n10, (float[])object3);
            }
        }
    }

    public void e() {
        this.g();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public EGLContext getGLContext() {
        synchronized (this) {
            h h10 = this.c;
            if (h10 == null) return null;
            h10 = this.c;
            return h10.a();
        }
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.f;
    }

    public void setRendMirror(int n10) {
    }

    public void setRendMode(int n10) {
    }

    public void setSurfaceTextureListener(n n10) {
        this.d = n10;
    }
}

