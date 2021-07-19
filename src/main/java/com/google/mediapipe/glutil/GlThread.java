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
package com.google.mediapipe.glutil;

import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.mediapipe.glutil.EglManager;
import com.google.mediapipe.glutil.ShaderUtil;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLSurface;

public class GlThread
extends Thread {
    private static final String TAG = "GlThread";
    private static final String THREAD_NAME = "mediapipe.glutil.GlThread";
    public volatile EglManager eglManager;
    public EGLSurface eglSurface;
    public int framebuffer;
    public Handler handler;
    public Looper looper;
    private boolean ready;
    private final Object startLock;

    public GlThread(Object object) {
        this(object, null);
    }

    public GlThread(Object object, int[] nArray) {
        Object object2;
        this.startLock = object2 = new Object();
        this.eglSurface = null;
        this.handler = null;
        this.looper = null;
        this.framebuffer = 0;
        this.eglManager = object2 = new EglManager(object, nArray);
        this.setName(THREAD_NAME);
    }

    public void bindFramebuffer(int n10, int n11, int n12) {
        int n13 = this.framebuffer;
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
        String string2 = stringBuilder.toString();
        RuntimeException runtimeException = new RuntimeException(string2);
        throw runtimeException;
    }

    public EGLSurface createEglSurface() {
        EglManager eglManager = this.eglManager;
        int n10 = 1;
        return eglManager.createOffscreenSurface(n10, n10);
    }

    public Handler createHandler() {
        Handler handler = new Handler();
        return handler;
    }

    public EGLContext getEGLContext() {
        return this.eglManager.getContext();
    }

    public EglManager getEglManager() {
        return this.eglManager;
    }

    public int getFramebuffer() {
        return this.framebuffer;
    }

    public Handler getHandler() {
        return this.handler;
    }

    public Looper getLooper() {
        return this.looper;
    }

    public void prepareGl() {
        Object object = this.createEglSurface();
        this.eglSurface = object;
        object = this.eglManager;
        Object object2 = this.eglSurface;
        ((EglManager)object).makeCurrent((EGLSurface)object2, (EGLSurface)object2);
        GLES20.glDisable((int)2929);
        GLES20.glDisable((int)2884);
        Object object3 = 1;
        object2 = new int[object3];
        GLES20.glGenFramebuffers((int)object3, (int[])object2, (int)0);
        this.framebuffer = object3 = (Object)object2[0];
    }

    public boolean quitSafely() {
        Looper looper = this.looper;
        if (looper == null) {
            return false;
        }
        looper.quitSafely();
        return true;
    }

    public void releaseGl() {
        int n10 = this.framebuffer;
        if (n10 != 0) {
            int n11 = 1;
            int[] nArray = new int[n11];
            nArray[0] = n10;
            GLES20.glDeleteFramebuffers((int)n11, (int[])nArray, (int)0);
            this.framebuffer = 0;
        }
        this.eglManager.makeNothingCurrent();
        Object object = this.eglSurface;
        if (object != null) {
            object = this.eglManager;
            EGLSurface eGLSurface = this.eglSurface;
            ((EglManager)object).releaseSurface(eGLSurface);
            n10 = 0;
            object = null;
            this.eglSurface = null;
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
        this.handler = object = this.createHandler();
        object = Looper.myLooper();
        this.looper = object;
        int n10 = 1;
        Object object2 = new Object[n10];
        String string2 = this.getName();
        object2[0] = string2;
        Object object3 = String.format("Starting GL thread %s", object2);
        Log.d((String)TAG, (String)object3);
        this.prepareGl();
        object = this.startLock;
        synchronized (object) {
            this.ready = n10;
            object3 = this.startLock;
            object3.notify();
        }
        Looper.loop();
        this.looper = null;
        this.releaseGl();
        this.eglManager.release();
        object = TAG;
        Object[] objectArray = new Object[n10];
        objectArray[0] = object2 = this.getName();
        object3 = String.format("Stopping GL thread %s", objectArray);
        Log.d((String)object, (String)object3);
        object3 = this.startLock;
        synchronized (object3) {
            this.ready = false;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void waitUntilReady() {
        Object object = this.startLock;
        synchronized (object) {
            boolean bl2;
            while (!(bl2 = this.ready)) {
                Object object2 = this.startLock;
                object2.wait();
            }
            return;
        }
    }
}

