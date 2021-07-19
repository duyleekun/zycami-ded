/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.os.Handler
 *  android.util.Log
 *  javax.microedition.khronos.egl.EGLContext
 */
package com.google.mediapipe.components;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.util.Log;
import com.google.mediapipe.components.ExternalTextureConverter$RenderThread;
import com.google.mediapipe.components.TextureFrameConsumer;
import com.google.mediapipe.components.TextureFrameProducer;
import com.google.mediapipe.glutil.GlThread;
import d.h.b.a.b;
import d.h.b.a.d;
import d.h.b.a.e;
import javax.microedition.khronos.egl.EGLContext;

public class ExternalTextureConverter
implements TextureFrameProducer {
    private static final int DEFAULT_NUM_BUFFERS = 2;
    private static final String TAG = "ExternalTextureConv";
    private static final String THREAD_NAME = "ExternalTextureConverter";
    private ExternalTextureConverter$RenderThread thread;

    public ExternalTextureConverter(EGLContext eGLContext) {
        this(eGLContext, 2);
    }

    public ExternalTextureConverter(EGLContext object, int n10) {
        Object object2 = new ExternalTextureConverter$RenderThread((EGLContext)object, n10);
        this.thread = object2;
        ((Thread)object2).setName(THREAD_NAME);
        object = this.thread;
        ((Thread)object).start();
        try {
            object = this.thread;
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            Object object3 = new StringBuilder();
            ((StringBuilder)object3).append("thread was unexpectedly interrupted: ");
            object2 = interruptedException.getMessage();
            ((StringBuilder)object3).append((String)object2);
            object3 = ((StringBuilder)object3).toString();
            Log.e((String)TAG, (String)object3);
            object3 = new RuntimeException(interruptedException);
            throw object3;
        }
        ((GlThread)object).waitUntilReady();
    }

    public ExternalTextureConverter(EGLContext eGLContext, SurfaceTexture surfaceTexture, int n10, int n11) {
        this(eGLContext);
        this.thread.setSurfaceTexture(surfaceTexture, n10, n11);
    }

    private /* synthetic */ void a() {
        this.thread.setSurfaceTexture(null, 0, 0);
    }

    private /* synthetic */ void c(SurfaceTexture surfaceTexture, int n10, int n11) {
        this.thread.setSurfaceTexture(surfaceTexture, n10, n11);
    }

    private /* synthetic */ void e(SurfaceTexture surfaceTexture, int n10, int n11) {
        this.thread.setSurfaceTextureAndAttachToGLContext(surfaceTexture, n10, n11);
    }

    public void addConsumer(TextureFrameConsumer textureFrameConsumer) {
        this.thread.addConsumer(textureFrameConsumer);
    }

    public /* synthetic */ void b() {
        this.a();
    }

    public void close() {
        ExternalTextureConverter$RenderThread externalTextureConverter$RenderThread = this.thread;
        if (externalTextureConverter$RenderThread == null) {
            return;
        }
        externalTextureConverter$RenderThread = externalTextureConverter$RenderThread.getHandler();
        Object object = new d(this);
        externalTextureConverter$RenderThread.post((Runnable)object);
        externalTextureConverter$RenderThread = this.thread;
        externalTextureConverter$RenderThread.quitSafely();
        try {
            externalTextureConverter$RenderThread = this.thread;
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            object = new StringBuilder();
            ((StringBuilder)object).append("thread was unexpectedly interrupted: ");
            String string2 = interruptedException.getMessage();
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
            Log.e((String)TAG, (String)object);
            object = new RuntimeException(interruptedException);
            throw object;
        }
        externalTextureConverter$RenderThread.join();
    }

    public /* synthetic */ void d(SurfaceTexture surfaceTexture, int n10, int n11) {
        this.c(surfaceTexture, n10, n11);
    }

    public /* synthetic */ void f(SurfaceTexture surfaceTexture, int n10, int n11) {
        this.e(surfaceTexture, n10, n11);
    }

    public void removeConsumer(TextureFrameConsumer textureFrameConsumer) {
        this.thread.removeConsumer(textureFrameConsumer);
    }

    public void setConsumer(TextureFrameConsumer textureFrameConsumer) {
        this.thread.setConsumer(textureFrameConsumer);
    }

    public void setFlipY(boolean bl2) {
        this.thread.setFlipY(bl2);
    }

    public void setSurfaceTexture(SurfaceTexture object, int n10, int n11) {
        if (object != null && (n10 == 0 || n11 == 0)) {
            object = new RuntimeException("ExternalTextureConverter: setSurfaceTexture dimensions cannot be zero");
            throw object;
        }
        Handler handler = this.thread.getHandler();
        b b10 = new b(this, (SurfaceTexture)object, n10, n11);
        handler.post((Runnable)b10);
    }

    public void setSurfaceTextureAndAttachToGLContext(SurfaceTexture object, int n10, int n11) {
        if (object != null && (n10 == 0 || n11 == 0)) {
            object = new RuntimeException("ExternalTextureConverter: setSurfaceTexture dimensions cannot be zero");
            throw object;
        }
        Handler handler = this.thread.getHandler();
        e e10 = new e(this, (SurfaceTexture)object, n10, n11);
        handler.post((Runnable)e10);
    }

    public void setTimestampOffsetNanos(long l10) {
        this.thread.setTimestampOffsetNanos(l10);
    }
}

