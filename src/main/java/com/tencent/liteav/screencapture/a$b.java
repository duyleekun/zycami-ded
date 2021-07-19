/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.graphics.SurfaceTexture$OnFrameAvailableListener
 *  android.opengl.GLES20
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.view.Surface
 *  javax.microedition.khronos.egl.EGLContext
 */
package com.tencent.liteav.screencapture;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.TXCOpenGlUtils;
import com.tencent.liteav.basic.opengl.b;
import com.tencent.liteav.basic.opengl.i;
import com.tencent.liteav.basic.opengl.j;
import com.tencent.liteav.basic.opengl.k;
import com.tencent.liteav.basic.opengl.l;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.f;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.screencapture.a;
import com.tencent.liteav.screencapture.a$b$1;
import com.tencent.liteav.screencapture.a$b$2;
import com.tencent.liteav.screencapture.a$b$3;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLContext;

public class a$b
extends Handler {
    public int a;
    public int[] b;
    public Surface c;
    public SurfaceTexture d;
    public int e;
    public int f;
    public int g;
    public boolean h;
    public long i;
    public long j;
    public b k;
    public j l;
    public float[] m;
    public final /* synthetic */ a n;
    private boolean o;

    public a$b(a a10, Looper objectArray, a object) {
        long l10;
        this.n = a10;
        super((Looper)objectArray);
        this.a = 0;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = 720;
        this.f = 1280;
        this.g = 25;
        this.h = false;
        this.i = l10 = 0L;
        this.j = l10;
        this.k = null;
        this.l = null;
        objectArray = new float[16];
        this.m = (float[])objectArray;
        int n10 = 1;
        this.o = n10;
        objectArray = new Object[n10];
        objectArray[0] = object = Integer.valueOf(((Object)((Object)this)).hashCode());
        TXCLog.i("TXCScreenCapture", "TXCScreenCaptureGLThreadHandler inited. hashCode: %d", objectArray);
    }

    public void a() {
        Object object;
        boolean bl2 = this.o;
        if (bl2 && (object = this.k) != null) {
            object = new Bundle();
            String string2 = "Screen recording started successfully";
            object.putString("EVT_MSG", string2);
            WeakReference weakReference = com.tencent.liteav.screencapture.a.a(this.n);
            int n10 = 1004;
            com.tencent.liteav.basic.util.g.a(weakReference, n10, (Bundle)object);
            object = this.n;
            ((a)object).c(0);
        }
        this.o = false;
    }

    public void a(Message object) {
        long l10;
        this.i = l10 = 0L;
        this.j = l10;
        boolean bl2 = this.b();
        if (!bl2) {
            this.c();
            this.n.b();
            object = this.n;
            int n10 = 20000003;
            ((a)object).c(n10);
        }
    }

    public void b(Message object) {
        object = this.n;
        Object object2 = null;
        ((a)object).i = false;
        if ((object = com.tencent.liteav.screencapture.a.b((a)object)) != null) {
            object.a(0);
        }
        if ((object = this.n.c()) != null) {
            object2 = com.tencent.liteav.screencapture.a.f(this.n);
            object.a(object2);
        }
        this.c();
    }

    public boolean b() {
        Object object = new Object[2];
        Object object2 = this.e;
        float[] fArray = null;
        object[0] = object2;
        object2 = this.f;
        boolean bl2 = true;
        object[bl2] = object2;
        object = String.format("init egl size[%d/%d]", (Object[])object);
        object2 = "TXCScreenCapture";
        TXCLog.i((String)object2, (String)object);
        int n10 = this.e;
        int n11 = this.f;
        int n12 = 0;
        object = com.tencent.liteav.basic.opengl.b.a(null, null, null, n10, n11);
        this.k = object;
        if (object == null) {
            return false;
        }
        this.l = object = new j();
        n10 = (int)(((i)object).a() ? 1 : 0);
        if (n10 == 0) {
            return false;
        }
        this.l.a(bl2);
        object = this.l;
        n11 = this.e;
        n12 = this.f;
        ((i)object).a(n11, n12);
        object = this.l;
        object2 = com.tencent.liteav.basic.opengl.l.e;
        fArray = com.tencent.liteav.basic.opengl.l.a(com.tencent.liteav.basic.opengl.k.a, false, false);
        ((i)object).a((float[])object2, fArray);
        this.e();
        return bl2;
    }

    public void c() {
        this.d();
        Object object = this.l;
        if (object != null) {
            ((i)object).d();
            this.l = null;
        }
        if ((object = this.k) != null) {
            ((b)object).c();
            this.k = null;
        }
    }

    public void c(Message object) {
        Object object2;
        object = this.n;
        Object object3 = 102;
        long l10 = 5;
        ((a)object).a((int)object3, l10);
        object = this.n;
        Object object4 = ((a)object).i;
        if (object4 == 0) {
            return;
        }
        object = this.k;
        Object object5 = "TXCScreenCapture";
        if (object == null) {
            TXCLog.e((String)object5, "eglhelper is null");
            return;
        }
        object4 = this.h;
        l10 = 0L;
        if (object4 == 0) {
            long l11;
            this.i = l10;
            this.j = l11 = System.nanoTime();
            return;
        }
        long l12 = System.nanoTime();
        long l13 = this.j;
        long l14 = this.i;
        long l15 = 1000L;
        l14 = l14 * l15 * l15 * l15;
        l15 = this.g;
        long l16 = l12 - (l14 = l14 / l15 + l13);
        object4 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object4 < 0) {
            return;
        }
        object4 = l13 == l10 ? 0 : (l13 < l10 ? -1 : 1);
        if (object4 == 0) {
            this.j = l12;
        } else {
            l14 = 1000000000L;
            long l17 = l12 - (l13 += l14);
            object4 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
            if (object4 > 0) {
                this.i = l10;
                this.j = l12;
            }
        }
        l10 = this.i;
        l12 = 1L;
        this.i = l10 += l12;
        object = this.d;
        if (object != null && (object2 = this.b) != null) {
            String string2;
            object2 = this.m;
            object.getTransformMatrix((float[])object2);
            object = this.d;
            try {
                object.updateTexImage();
            }
            catch (Exception exception) {
                object2 = new StringBuilder;
                ((StringBuilder)object2)();
                string2 = "onMsgRend Exception ";
                ((StringBuilder)object2).append(string2);
                object = exception.getMessage();
                ((StringBuilder)object2).append((String)object);
                object = ((StringBuilder)object2).toString();
                TXCLog.e((String)object5, (String)object);
            }
            object = this.l;
            object5 = this.m;
            ((j)object).a((float[])object5);
            object4 = this.e;
            object3 = this.f;
            GLES20.glViewport((int)0, (int)0, (int)object4, (int)object3);
            object = this.l;
            object5 = this.b;
            object3 = object5[0];
            int n10 = ((i)object).b((int)object3);
            object2 = this.n;
            string2 = null;
            object = this.k;
            EGLContext eGLContext = ((b)object).d();
            int n11 = this.e;
            int n12 = this.f;
            l14 = TXCTimeUtil.getTimeTick();
            ((a)object2).a(0, eGLContext, n10, n11, n12, l14);
        }
    }

    public void d() {
        Object object = Looper.getMainLooper();
        Object object2 = new f((Looper)object);
        object = new a$b$1(this);
        object2.a((Runnable)object);
        object2 = this.c;
        object = null;
        if (object2 != null) {
            object2.release();
            this.c = null;
        }
        if ((object2 = this.d) != null) {
            object2.setOnFrameAvailableListener(null);
            object2 = this.d;
            object2.release();
            this.h = false;
            this.d = null;
        }
        if ((object2 = (Object)this.b) != null) {
            int n10 = 1;
            GLES20.glDeleteTextures((int)n10, (int[])object2, (int)0);
            this.b = null;
        }
    }

    public void d(Message message) {
        long l10;
        if (message == null) {
            return;
        }
        int n10 = message.arg1;
        int n11 = 1;
        if (n10 < n11) {
            n10 = n11;
        }
        this.g = n10;
        this.i = l10 = 0L;
        this.j = l10;
    }

    public void e() {
        Object object = new int[1];
        this.b = object;
        int n10 = TXCOpenGlUtils.b();
        int n11 = 0;
        object[0] = n10;
        object = this.b;
        int n12 = object[0];
        if (n12 <= 0) {
            this.b = null;
            return;
        }
        object = new SurfaceTexture;
        n10 = this.b[0];
        object(n10);
        this.d = (SurfaceTexture)object;
        object = new Surface;
        Object object2 = this.d;
        object(object2);
        this.c = (Surface)object;
        object = this.d;
        n10 = this.e;
        n11 = this.f;
        object.setDefaultBufferSize(n10, n11);
        object = this.d;
        object2 = new a$b$2(this);
        object.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener)object2);
        object = new Handler;
        object2 = Looper.getMainLooper();
        object((Looper)object2);
        object2 = new a$b$3(this);
        object.post((Runnable)object2);
    }

    public void e(Message object) {
        int n10;
        int n11;
        if (object == null) {
            return;
        }
        this.e = n11 = ((Message)object).arg1;
        this.f = n10 = ((Message)object).arg2;
        this.d();
        object = this.l;
        n11 = this.e;
        int n12 = this.f;
        ((i)object).a(n11, n12);
        this.e();
        object = new Object[2];
        Integer n13 = com.tencent.liteav.screencapture.a.d(this.n);
        object[0] = n13;
        n13 = com.tencent.liteav.screencapture.a.e(this.n);
        object[1] = n13;
        object = String.format("set screen capture size[%d/%d]", (Object[])object);
        TXCLog.i("TXCScreenCapture", (String)object);
    }

    public void handleMessage(Message object) {
        if (object == null) {
            return;
        }
        int n10 = this.a;
        Object object2 = this.n;
        int n11 = ((a)object2).e;
        if (n10 != n11 && (n10 = 101) != (n11 = ((Message)object).what)) {
            return;
        }
        n10 = ((Message)object).what;
        switch (n10) {
            default: {
                break;
            }
            case 106: {
                this.a();
                break;
            }
            case 105: {
                this.e((Message)object);
                break;
            }
            case 103: {
                this.d((Message)object);
                break;
            }
            case 102: {
                try {
                    this.c((Message)object);
                }
                catch (Exception exception) {
                    object2 = "TXCScreenCapture";
                    String string2 = "render failed.";
                    TXCLog.e((String)object2, string2, exception);
                }
                break;
            }
            case 101: {
                this.b((Message)object);
                break;
            }
            case 100: {
                this.a((Message)object);
            }
        }
        if (object != null && (object = ((Message)object).obj) != null) {
            object = (Runnable)object;
            object.run();
        }
    }
}

