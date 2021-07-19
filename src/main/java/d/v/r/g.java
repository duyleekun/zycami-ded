/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.Log
 *  javax.microedition.khronos.egl.EGLContext
 *  javax.microedition.khronos.egl.EGLSurface
 */
package d.v.r;

import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.mediapipe.glutil.EglManager;
import com.google.mediapipe.glutil.ShaderUtil;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLSurface;

public class g
extends Thread {
    private static final String h = "MyGLThread";
    private static final String i = "mediapipe.glutil.MyGLThread";
    private boolean a;
    private final Object b;
    public volatile EglManager c;
    public EGLSurface d;
    public Handler e;
    public Looper f;
    public int g;

    public g(Object object) {
        this(object, null);
    }

    public g(Object object, int[] nArray) {
        Object object2;
        this.b = object2 = new Object();
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = 0;
        this.c = object2 = new EglManager(object, nArray);
        this.setName(i);
    }

    public void b(int n10, int n11, int n12) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Name: Texture binding ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        String string2 = "TEXT_NAME";
        Log.d((String)string2, (String)charSequence);
        int n13 = this.g;
        int n14 = 36160;
        GLES20.glBindFramebuffer((int)n14, (int)n13);
        int n15 = 3553;
        GLES20.glFramebufferTexture2D((int)n14, (int)36064, (int)n15, (int)n10, (int)0);
        n10 = GLES20.glCheckFramebufferStatus((int)n14);
        n13 = 36053;
        if (n10 == n13) {
            GLES20.glViewport((int)0, (int)0, (int)n11, (int)n12);
            ShaderUtil.checkGlError("glViewport");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Framebuffer not complete, status=");
        stringBuilder.append(n10);
        String string3 = stringBuilder.toString();
        RuntimeException runtimeException = new RuntimeException(string3);
        throw runtimeException;
    }

    public EGLSurface c() {
        EglManager eglManager = this.c;
        int n10 = 1;
        return eglManager.createOffscreenSurface(n10, n10);
    }

    public Handler d() {
        Handler handler = new Handler();
        return handler;
    }

    public EGLContext e() {
        return this.c.getContext();
    }

    public EglManager f() {
        return this.c;
    }

    public int g() {
        return this.g;
    }

    public Handler h() {
        return this.e;
    }

    public Looper i() {
        return this.f;
    }

    public void j() {
        Object object = this.c();
        this.d = object;
        object = this.c;
        Object object2 = this.d;
        ((EglManager)object).makeCurrent((EGLSurface)object2, (EGLSurface)object2);
        Object object3 = 1;
        object2 = new int[object3];
        GLES20.glGenFramebuffers((int)object3, (int[])object2, (int)0);
        this.g = object3 = (Object)object2[0];
    }

    public boolean k() {
        Looper looper = this.f;
        if (looper == null) {
            return false;
        }
        looper.quitSafely();
        return true;
    }

    public void l() {
        int n10 = this.g;
        if (n10 != 0) {
            int n11 = 1;
            int[] nArray = new int[n11];
            nArray[0] = n10;
            GLES20.glDeleteFramebuffers((int)n11, (int[])nArray, (int)0);
            this.g = 0;
        }
        this.c.makeNothingCurrent();
        Object object = this.d;
        if (object != null) {
            object = this.c;
            EGLSurface eGLSurface = this.d;
            ((EglManager)object).releaseSurface(eGLSurface);
            n10 = 0;
            object = null;
            this.d = null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void m() {
        Object object = this.b;
        synchronized (object) {
            boolean bl2;
            while (!(bl2 = this.a)) {
                Object object2 = this.b;
                object2.wait();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Object object;
        Looper.prepare();
        this.e = object = this.d();
        object = Looper.myLooper();
        this.f = object;
        int n10 = 1;
        Object object2 = new Object[n10];
        String string2 = this.getName();
        object2[0] = string2;
        Object object3 = String.format("Starting GL thread %s", object2);
        Log.d((String)h, (String)object3);
        this.j();
        object = this.b;
        synchronized (object) {
            this.a = n10;
            object3 = this.b;
            object3.notify();
        }
        Looper.loop();
        this.f = null;
        this.l();
        this.c.release();
        object = h;
        Object[] objectArray = new Object[n10];
        objectArray[0] = object2 = this.getName();
        object3 = String.format("Stopping GL thread %s", objectArray);
        Log.d((String)object, (String)object3);
        object3 = this.b;
        synchronized (object3) {
            this.a = false;
            return;
        }
    }
}

