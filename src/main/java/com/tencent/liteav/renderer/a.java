/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.graphics.SurfaceTexture$OnFrameAvailableListener
 *  android.opengl.GLES20
 */
package com.tencent.liteav.renderer;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.renderer.TXCYuvTextureRender;
import com.tencent.liteav.renderer.a$a;
import com.tencent.liteav.renderer.b;
import com.tencent.liteav.renderer.c;
import com.tencent.liteav.renderer.d;
import com.tencent.liteav.renderer.e;
import com.tencent.liteav.renderer.g;
import com.tencent.liteav.renderer.h;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;

public class a
extends e
implements SurfaceTexture.OnFrameAvailableListener {
    private c A;
    private TXSVideoFrame B;
    private TXCYuvTextureRender C;
    private Object D;
    private Object E;
    private h F;
    private TXCYuvTextureRender G;
    private final Queue H;
    public g a;
    public a$a b;
    public a$a c;
    private final int q;
    private final int r;
    private final int s;
    private final int t;
    private Object u;
    private b v;
    private SurfaceTexture w;
    private c x;
    private boolean y;
    private float[] z;

    public a() {
        Object object;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = object = new Object();
        this.D = null;
        this.E = object = new Object();
        object = new LinkedList();
        this.H = object;
        object = new float[16];
        this.z = (float[])object;
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean e(int n10, int n11) {
        int n12;
        Object object;
        Object object2;
        TXSVideoFrame tXSVideoFrame;
        int n13;
        Object object3;
        int n14;
        Object object4;
        int n15;
        int n16;
        synchronized (this) {
            n16 = this.y;
            n15 = 0;
            object4 = null;
            n14 = 0;
            object3 = null;
            if (n16 != 0) {
                this.y = false;
                n13 = 0;
                tXSVideoFrame = null;
            } else {
                object2 = this.B;
                if (object2 == null) return false;
                this.B = null;
                tXSVideoFrame = object2;
                n16 = 0;
                object2 = null;
            }
        }
        if (n10 <= 0) return false;
        if (n11 <= 0) {
            return false;
        }
        GLES20.glViewport((int)0, (int)0, (int)n10, (int)n11);
        n10 = this.l;
        n11 = 1;
        if (n10 == n11) {
            object = this.b();
        } else {
            n10 = 0;
            object = null;
        }
        a$a a$a = this.c;
        int n17 = 36160;
        if (n16 != 0) {
            object2 = this.w;
            if (object2 != null) {
                object2.updateTexImage();
                object2 = this.w;
                object4 = this.z;
                object2.getTransformMatrix((float[])object4);
            }
            if ((object2 = this.a) != null) {
                object4 = this.x;
                if (object4 != null) {
                    n15 = ((c)object4).a();
                    object3 = this.z;
                    object2.a(n15, (float[])object3);
                }
            } else {
                object2 = this.x;
                if (object2 != null) {
                    GLES20.glBindFramebuffer((int)n17, (int)0);
                    object2 = this.x;
                    object4 = this.w;
                    ((c)object2).a((SurfaceTexture)object4);
                }
            }
            if (a$a != null) {
                object2 = this.x;
                n16 = ((c)object2).a();
                object4 = this.F;
                if (object4 == null) {
                    object3 = Boolean.TRUE;
                    this.F = object4 = new h((Boolean)object3);
                    ((h)object4).b();
                    this.F.a(n11 != 0);
                    this.F.b(180);
                    object4 = this.F;
                    n14 = com.tencent.liteav.renderer.h.a;
                    ((h)object4).a(n14);
                }
                object4 = this.F;
                object3 = this.z;
                ((h)object4).a((float[])object3);
                object4 = this.F;
                n14 = this.h;
                n13 = this.i;
                ((h)object4).b(n14, n13);
                object4 = this.F;
                n14 = this.h;
                n13 = this.i;
                ((h)object4).a(n14, n13);
                object4 = this.F;
                n16 = ((h)object4).d(n16);
                n15 = this.h();
                n14 = this.i();
                n13 = this.k;
                a$a.onTextureProcess(n16, n15, n14, n13);
            }
            if ((n16 = this.l) != n11) return n11 != 0;
            object2 = this.x;
            if (object2 == null) return n11 != 0;
            n16 = ((c)object2).a();
            object4 = this.z;
            this.a(object, n16, (float[])object4, n11 != 0);
            return n11 != 0;
        }
        if (tXSVideoFrame == null) return n11 != 0;
        object2 = this.C;
        if (object2 == null) return n11 != 0;
        a$a a$a2 = this.b;
        int n18 = -1;
        if (a$a2 != null) {
            n17 = this.h;
            n12 = this.i;
            ((TXCYuvTextureRender)object2).setHasFrameBuffer(n17, n12);
            object2 = this.C;
            n16 = ((TXCYuvTextureRender)object2).drawToTexture(tXSVideoFrame);
            a$a a$a3 = this.b;
            n12 = this.h();
            int n19 = this.i();
            int n20 = this.k;
            a$a3.onTextureProcess(n16, n12, n19, n20);
        } else {
            n16 = this.l;
            if (n16 == 0) {
                GLES20.glBindFramebuffer((int)n17, (int)0);
                object2 = this.C;
                ((TXCYuvTextureRender)object2).drawFrame(tXSVideoFrame);
            }
            n16 = n18;
        }
        n17 = this.l;
        if (n17 == n11) {
            if (n16 == n18) {
                object2 = this.C;
                n17 = this.h;
                n12 = this.i;
                ((TXCYuvTextureRender)object2).setHasFrameBuffer(n17, n12);
                object2 = this.C;
                n16 = ((TXCYuvTextureRender)object2).drawToTexture(tXSVideoFrame);
            }
            this.a(object, n16, null, false);
        }
        if (a$a == null) return n11 != 0;
        object = this.G;
        if (object == null) {
            this.G = object = new TXCYuvTextureRender();
            ((TXCYuvTextureRender)object).createTexture();
            object = this.G;
            ((TXCYuvTextureRender)object).flipVertical(false);
        }
        object = this.G;
        n16 = this.h;
        n15 = this.i;
        ((TXCYuvTextureRender)object).setHasFrameBuffer(n16, n15);
        object = this.G;
        n10 = ((TXCYuvTextureRender)object).drawToTexture(tXSVideoFrame);
        n16 = this.h();
        n15 = this.i();
        n14 = this.k;
        a$a.onTextureProcess(n10, n16, n15, n14);
        return n11 != 0;
    }

    private void o() {
        Object object = new c(true);
        this.x = object;
        this.C = object = new TXCYuvTextureRender();
        this.A = object = new c(false);
    }

    public SurfaceTexture a() {
        return this.w;
    }

    public void a(int n10, int n11) {
        super.a(n10, n11);
        Object object = this.C;
        if (object != null) {
            ((TXCYuvTextureRender)object).setVideoSize(n10, n11);
        }
        if ((object = this.x) != null) {
            ((c)object).a(n10, n11);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(int n10, int n11, int n12, boolean bl2, int n13) {
        int n14 = this.f();
        int n15 = this.g();
        GLES20.glViewport((int)0, (int)0, (int)n14, (int)n15);
        c c10 = this.A;
        if (c10 != null) {
            c10.a(n10, bl2, n13);
        }
        super.a(n10, n11, n12, bl2, n13);
        Object object = this.u;
        synchronized (object) {
            b b10 = this.v;
            if (b10 != null) {
                b10.c();
            }
            return;
        }
    }

    public void a(SurfaceTexture surfaceTexture) {
        super.a(surfaceTexture);
        TXCLog.w("TXCVideoRender", "play:vrender: create render thread when onSurfaceCreate");
        this.c(null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(TXSVideoFrame object, int n10, int n11, int n12) {
        synchronized (this) {
            TXSVideoFrame tXSVideoFrame = this.B;
            if (tXSVideoFrame != null) {
                tXSVideoFrame.release();
            }
            this.B = object;
        }
        super.a((TXSVideoFrame)object, n10, n11, n12);
        object = this.u;
        synchronized (object) {
            b b10 = this.v;
            if (b10 != null) {
                b10.c();
            }
            return;
        }
    }

    public void a(a$a object) {
        this.b = object;
        if (object != null && (object = this.C) != null) {
            int n10 = this.h;
            int n11 = this.i;
            ((TXCYuvTextureRender)object).setHasFrameBuffer(n10, n11);
        }
    }

    public void a(g g10) {
        this.a = g10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(Object object) {
        Object object2 = this.E;
        synchronized (object2) {
            int n10;
            int n11;
            this.D = object;
            object = "TXCVideoRender";
            Object object3 = new StringBuilder();
            String string2 = "play:vrender: TXCGLRender initTextureRender ";
            ((StringBuilder)object3).append(string2);
            ((StringBuilder)object3).append(this);
            object3 = ((StringBuilder)object3).toString();
            TXCLog.w((String)object, (String)object3);
            this.o();
            object = this.e;
            if (object != null) {
                n11 = this.f;
                n10 = this.g;
                ((d)object).a(n11, n10);
                object = this.e;
                n11 = this.h;
                n10 = this.i;
                ((d)object).b(n11, n10);
            }
            if ((object = this.x) != null) {
                ((c)object).b();
                object3 = this.x;
                n11 = ((c)object3).a();
                object = new SurfaceTexture(n11);
                this.w = object;
                object.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener)this);
            }
            if ((object = this.C) != null) {
                ((TXCYuvTextureRender)object).createTexture();
            }
            if ((object = this.b) != null && (object = this.C) != null) {
                n11 = this.h;
                n10 = this.i;
                ((TXCYuvTextureRender)object).setHasFrameBuffer(n11, n10);
            }
            if ((object = this.A) != null) {
                ((c)object).b();
            }
            if ((object = this.o) != null) {
                object3 = this.w;
                object.onSurfaceTextureAvailable((SurfaceTexture)object3);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object b() {
        Object object = this.u;
        synchronized (object) {
            b b10 = this.v;
            if (b10 == null) return null;
            return b10.a();
        }
    }

    public void b(SurfaceTexture surfaceTexture) {
        super.b(surfaceTexture);
        TXCLog.w("TXCVideoRender", "play:vrender: quit render thread when onSurfaceRelease");
        this.d();
    }

    public void b(a$a object) {
        this.c = object;
        if (object != null && (object = this.C) != null) {
            int n10 = this.h;
            int n11 = this.i;
            ((TXCYuvTextureRender)object).setHasFrameBuffer(n10, n11);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(Object object) {
        Object object2 = this.E;
        synchronized (object2) {
            Object object3 = this.D;
            if (object3 != object) {
                object = "TXCVideoRender";
                object3 = new StringBuilder();
                String string2 = "play:vrender: TXCGLRender destroyTextureRender ignore when not the same gl thread ";
                ((StringBuilder)object3).append(string2);
                ((StringBuilder)object3).append(this);
                object3 = ((StringBuilder)object3).toString();
                TXCLog.w((String)object, (String)object3);
                return;
            }
            object = null;
            this.D = null;
            object3 = "TXCVideoRender";
            CharSequence charSequence = new StringBuilder();
            String string3 = "play:vrender: TXCGLRender destroyTextureRender ";
            charSequence.append(string3);
            charSequence.append(this);
            charSequence = charSequence.toString();
            TXCLog.w((String)object3, (String)charSequence);
            try {
                object3 = this.o;
                if (object3 != null) {
                    charSequence = this.w;
                    object3.onSurfaceTextureDestroy((SurfaceTexture)charSequence);
                }
            }
            catch (Exception exception) {
                charSequence = "TXCVideoRender";
                string3 = "callback failed.";
                TXCLog.e((String)charSequence, string3, exception);
            }
            if ((object3 = this.x) != null) {
                ((c)object3).c();
                this.x = null;
            }
            if ((object3 = this.C) != null) {
                ((TXCYuvTextureRender)object3).onSurfaceDestroy();
                this.C = null;
            }
            if ((object3 = this.A) != null) {
                ((c)object3).c();
                this.A = null;
            }
            this.w = null;
            object3 = this.F;
            if (object3 != null) {
                ((h)object3).c();
                this.F = null;
            }
            if ((object3 = this.G) != null) {
                ((TXCYuvTextureRender)object3).onSurfaceDestroy();
                this.G = null;
            }
            return;
        }
    }

    public boolean b(int n10, int n11) {
        Queue queue;
        boolean bl2;
        while (bl2 = this.a(queue = this.H)) {
        }
        return this.e(n10, n11);
    }

    public SurfaceTexture c() {
        Object object = this.d;
        object = object != null ? object.getSurfaceTexture() : null;
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c(Object object) {
        Object object2 = this.u;
        synchronized (object2) {
            Object object3 = this.v;
            if (object3 == null) {
                Object object4 = new WeakReference(this);
                this.v = object3 = new b((WeakReference)object4);
                ((b)object3).a(object);
                object3 = this.v;
                ((Thread)object3).start();
                object3 = this.v;
                ((b)object3).c();
                object3 = "TXCVideoRender";
                object4 = new StringBuilder();
                String string2 = "play:vrender: start render thread id ";
                ((StringBuilder)object4).append(string2);
                string2 = this.getID();
                ((StringBuilder)object4).append(string2);
                string2 = ", glContext ";
                ((StringBuilder)object4).append(string2);
                ((StringBuilder)object4).append(object);
                object = ", ";
                ((StringBuilder)object4).append((String)object);
                ((StringBuilder)object4).append(this);
                object = ((StringBuilder)object4).toString();
                TXCLog.w((String)object3, (String)object);
            } else {
                object = "TXCVideoRender";
                object3 = new StringBuilder();
                String string3 = "play:vrender: start render thread when running ";
                ((StringBuilder)object3).append(string3);
                string3 = this.getID();
                ((StringBuilder)object3).append(string3);
                string3 = ", ";
                ((StringBuilder)object3).append(string3);
                ((StringBuilder)object3).append(this);
                object3 = ((StringBuilder)object3).toString();
                TXCLog.w((String)object, (String)object3);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void d() {
        Object object = this.u;
        synchronized (object) {
            Object object2 = this.v;
            if (object2 != null) {
                ((b)object2).b();
                object2 = this.v;
                ((b)object2).c();
                object2 = null;
                this.v = null;
                object2 = "TXCVideoRender";
                CharSequence charSequence = new StringBuilder();
                String string2 = "play:vrender: quit render thread id";
                charSequence.append(string2);
                string2 = this.getID();
                charSequence.append(string2);
                string2 = ", ";
                charSequence.append(string2);
                charSequence.append(this);
                charSequence = charSequence.toString();
                TXCLog.w((String)object2, (String)charSequence);
            }
            return;
        }
    }

    public void finalize() {
        super.finalize();
        String string2 = "TXCVideoRender";
        String string3 = "play:vrender: quit render thread when finalize";
        TXCLog.w(string2, string3);
        try {
            this.d();
        }
        catch (Exception exception) {
            String string4 = "quit render thread failed.";
            TXCLog.e(string2, string4, exception);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onFrameAvailable(SurfaceTexture object) {
        synchronized (this) {
            boolean bl2;
            this.y = bl2 = true;
        }
        object = this.u;
        synchronized (object) {
            b b10 = this.v;
            if (b10 != null) {
                b10.c();
            }
            return;
        }
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}

