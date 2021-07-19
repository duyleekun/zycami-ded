/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.graphics.SurfaceTexture$OnFrameAvailableListener
 *  android.opengl.EGL14
 *  android.opengl.EGLConfig
 *  android.opengl.EGLContext
 *  android.opengl.EGLDisplay
 *  android.opengl.EGLSurface
 *  android.opengl.GLES20
 *  android.os.Handler
 */
package com.google.android.exoplayer2.util;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.EGLSurfaceTexture$1;
import com.google.android.exoplayer2.util.EGLSurfaceTexture$GlException;
import com.google.android.exoplayer2.util.EGLSurfaceTexture$TextureImageListener;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.util.Util;

public final class EGLSurfaceTexture
implements SurfaceTexture.OnFrameAvailableListener,
Runnable {
    private static final int[] EGL_CONFIG_ATTRIBUTES;
    private static final int EGL_PROTECTED_CONTENT_EXT = 12992;
    private static final int EGL_SURFACE_HEIGHT = 1;
    private static final int EGL_SURFACE_WIDTH = 1;
    public static final int SECURE_MODE_NONE = 0;
    public static final int SECURE_MODE_PROTECTED_PBUFFER = 2;
    public static final int SECURE_MODE_SURFACELESS_CONTEXT = 1;
    private final EGLSurfaceTexture$TextureImageListener callback;
    private EGLContext context;
    private EGLDisplay display;
    private final Handler handler;
    private EGLSurface surface;
    private SurfaceTexture texture;
    private final int[] textureIdHolder;

    static {
        int[] nArray;
        int[] nArray2 = nArray = new int[17];
        int[] nArray3 = nArray;
        nArray2[0] = 12352;
        nArray3[1] = 4;
        nArray2[2] = 12324;
        nArray3[3] = 8;
        nArray2[4] = 12323;
        nArray3[5] = 8;
        nArray2[6] = 12322;
        nArray3[7] = 8;
        nArray2[8] = 12321;
        nArray3[9] = 8;
        nArray2[10] = 12325;
        nArray3[11] = 0;
        nArray2[12] = 12327;
        nArray3[13] = 12344;
        nArray2[14] = 12339;
        nArray3[15] = 4;
        nArray3[16] = 12344;
        EGL_CONFIG_ATTRIBUTES = nArray;
    }

    public EGLSurfaceTexture(Handler handler) {
        this(handler, null);
    }

    public EGLSurfaceTexture(Handler object, EGLSurfaceTexture$TextureImageListener eGLSurfaceTexture$TextureImageListener) {
        this.handler = object;
        this.callback = eGLSurfaceTexture$TextureImageListener;
        object = new int[1];
        this.textureIdHolder = (int[])object;
    }

    private static EGLConfig chooseEGLConfig(EGLDisplay object) {
        int n10;
        int n11 = 1;
        EGLConfig[] eGLConfigArray = new EGLConfig[n11];
        int[] nArray = new int[n11];
        Object object2 = EGL_CONFIG_ATTRIBUTES;
        Object[] objectArray = null;
        int n12 = 1;
        boolean bl2 = EGL14.eglChooseConfig((EGLDisplay)object, (int[])object2, (int)0, (EGLConfig[])eGLConfigArray, (int)0, (int)n12, (int[])nArray, (int)0);
        if (bl2 && (n10 = nArray[0]) > 0 && (object2 = (Object)eGLConfigArray[0]) != null) {
            return eGLConfigArray[0];
        }
        object2 = new EGLSurfaceTexture$GlException;
        objectArray = new Object[3];
        object = bl2;
        objectArray[0] = object;
        object = nArray[0];
        objectArray[n11] = object;
        EGLConfig eGLConfig = eGLConfigArray[0];
        objectArray[2] = eGLConfig;
        object = Util.formatInvariant("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", objectArray);
        object2((String)object, (EGLSurfaceTexture$1)null);
        throw object2;
    }

    private static EGLContext createEGLContext(EGLDisplay object, EGLConfig eGLConfig, int n10) {
        int[] nArray;
        if (n10 == 0) {
            n10 = 3;
            int[] nArray2 = nArray = new int[n10];
            nArray[0] = 12440;
            nArray2[1] = 2;
            nArray2[2] = 12344;
        } else {
            n10 = 5;
            int[] nArray3 = nArray = new int[n10];
            int[] nArray4 = nArray;
            nArray3[0] = 12440;
            nArray4[1] = 2;
            nArray3[2] = 12992;
            nArray4[3] = 1;
            nArray4[4] = 12344;
        }
        EGLContext eGLContext = EGL14.EGL_NO_CONTEXT;
        object = EGL14.eglCreateContext((EGLDisplay)object, (EGLConfig)eGLConfig, (EGLContext)eGLContext, (int[])nArray, (int)0);
        if (object != null) {
            return object;
        }
        object = new EGLSurfaceTexture$GlException("eglCreateContext failed", null);
        throw object;
    }

    private static EGLSurface createEGLSurface(EGLDisplay object, EGLConfig eGLConfig, EGLContext eGLContext, int n10) {
        block8: {
            block7: {
                int[] nArray;
                int n11;
                block6: {
                    n11 = 1;
                    if (n10 != n11) break block6;
                    eGLConfig = EGL14.EGL_NO_SURFACE;
                    break block7;
                }
                n11 = 2;
                if (n10 == n11) {
                    n10 = 7;
                    int[] nArray2 = nArray = new int[n10];
                    int[] nArray3 = nArray;
                    nArray2[0] = 12375;
                    nArray3[1] = 1;
                    nArray2[2] = 12374;
                    nArray3[3] = 1;
                    nArray2[4] = 12992;
                    nArray3[5] = 1;
                    nArray3[6] = 12344;
                } else {
                    n10 = 5;
                    int[] nArray4 = nArray = new int[n10];
                    int[] nArray5 = nArray;
                    nArray4[0] = 12375;
                    nArray5[1] = 1;
                    nArray4[2] = 12374;
                    nArray5[3] = 1;
                    nArray5[4] = 12344;
                }
                n11 = 0;
                eGLConfig = EGL14.eglCreatePbufferSurface((EGLDisplay)object, (EGLConfig)eGLConfig, (int[])nArray, (int)0);
                if (eGLConfig == null) break block8;
            }
            boolean bl2 = EGL14.eglMakeCurrent((EGLDisplay)object, (EGLSurface)eGLConfig, (EGLSurface)eGLConfig, (EGLContext)eGLContext);
            if (bl2) {
                return eGLConfig;
            }
            object = new EGLSurfaceTexture$GlException("eglMakeCurrent failed", null);
            throw object;
        }
        object = new EGLSurfaceTexture$GlException("eglCreatePbufferSurface failed", null);
        throw object;
    }

    private void dispatchOnFrameAvailable() {
        EGLSurfaceTexture$TextureImageListener eGLSurfaceTexture$TextureImageListener = this.callback;
        if (eGLSurfaceTexture$TextureImageListener != null) {
            eGLSurfaceTexture$TextureImageListener.onFrameAvailable();
        }
    }

    private static void generateTextureIds(int[] nArray) {
        GLES20.glGenTextures((int)1, (int[])nArray, (int)0);
        GlUtil.checkGlError();
    }

    private static EGLDisplay getDefaultDisplay() {
        boolean bl2 = false;
        EGLSurfaceTexture$GlException eGLSurfaceTexture$GlException = null;
        EGLDisplay eGLDisplay = EGL14.eglGetDisplay((int)0);
        if (eGLDisplay != null) {
            int n10 = 2;
            int[] nArray = new int[n10];
            int n11 = 1;
            bl2 = EGL14.eglInitialize((EGLDisplay)eGLDisplay, (int[])nArray, (int)0, (int[])nArray, (int)n11);
            if (bl2) {
                return eGLDisplay;
            }
            eGLSurfaceTexture$GlException = new EGLSurfaceTexture$GlException("eglInitialize failed", null);
            throw eGLSurfaceTexture$GlException;
        }
        eGLSurfaceTexture$GlException = new EGLSurfaceTexture$GlException("eglGetDisplay failed", null);
        throw eGLSurfaceTexture$GlException;
    }

    public SurfaceTexture getSurfaceTexture() {
        return (SurfaceTexture)Assertions.checkNotNull(this.texture);
    }

    public void init(int n10) {
        EGLSurface eGLSurface;
        EGLContext eGLContext;
        EGLDisplay eGLDisplay;
        this.display = eGLDisplay = EGLSurfaceTexture.getDefaultDisplay();
        eGLDisplay = EGLSurfaceTexture.chooseEGLConfig(eGLDisplay);
        this.context = eGLContext = EGLSurfaceTexture.createEGLContext(this.display, (EGLConfig)eGLDisplay, n10);
        this.surface = eGLSurface = EGLSurfaceTexture.createEGLSurface(this.display, (EGLConfig)eGLDisplay, eGLContext, n10);
        EGLSurfaceTexture.generateTextureIds(this.textureIdHolder);
        int n11 = this.textureIdHolder[0];
        eGLSurface = new SurfaceTexture(n11);
        this.texture = eGLSurface;
        eGLSurface.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener)this);
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.handler.post((Runnable)this);
    }

    public void release() {
        int n10;
        EGLDisplay eGLDisplay;
        Object object;
        SurfaceTexture surfaceTexture;
        int n11;
        Handler handler;
        block15: {
            handler = this.handler;
            handler.removeCallbacks((Runnable)this);
            n11 = 19;
            try {
                surfaceTexture = this.texture;
                if (surfaceTexture == null) break block15;
            }
            catch (Throwable throwable) {
                int n12;
                object = this.display;
                if (object != null && (n12 = object.equals((Object)(eGLDisplay = EGL14.EGL_NO_DISPLAY))) == 0) {
                    object = this.display;
                    eGLDisplay = EGL14.EGL_NO_SURFACE;
                    EGLContext eGLContext = EGL14.EGL_NO_CONTEXT;
                    EGL14.eglMakeCurrent((EGLDisplay)object, (EGLSurface)eGLDisplay, (EGLSurface)eGLDisplay, (EGLContext)eGLContext);
                }
                if ((object = this.surface) != null && (n12 = object.equals((Object)(eGLDisplay = EGL14.EGL_NO_SURFACE))) == 0) {
                    object = this.display;
                    eGLDisplay = this.surface;
                    EGL14.eglDestroySurface((EGLDisplay)object, (EGLSurface)eGLDisplay);
                }
                if ((object = this.context) != null) {
                    eGLDisplay = this.display;
                    EGL14.eglDestroyContext((EGLDisplay)eGLDisplay, (EGLContext)object);
                }
                if ((n12 = Util.SDK_INT) >= n11) {
                    EGL14.eglReleaseThread();
                }
                if ((handler = this.display) != null && (n11 = (int)(handler.equals(object = EGL14.EGL_NO_DISPLAY) ? 1 : 0)) == 0) {
                    handler = this.display;
                    EGL14.eglTerminate((EGLDisplay)handler);
                }
                this.display = null;
                this.context = null;
                this.surface = null;
                this.texture = null;
                throw throwable;
            }
            surfaceTexture.release();
            n10 = 1;
            object = this.textureIdHolder;
            eGLDisplay = null;
            GLES20.glDeleteTextures((int)n10, (int[])object, (int)0);
        }
        if ((surfaceTexture = this.display) != null && (n10 = surfaceTexture.equals(object = EGL14.EGL_NO_DISPLAY)) == 0) {
            surfaceTexture = this.display;
            object = EGL14.EGL_NO_SURFACE;
            eGLDisplay = EGL14.EGL_NO_CONTEXT;
            EGL14.eglMakeCurrent((EGLDisplay)surfaceTexture, (EGLSurface)object, (EGLSurface)object, (EGLContext)eGLDisplay);
        }
        if ((surfaceTexture = this.surface) != null && (n10 = (int)(surfaceTexture.equals(object = EGL14.EGL_NO_SURFACE) ? 1 : 0)) == 0) {
            surfaceTexture = this.display;
            object = this.surface;
            EGL14.eglDestroySurface((EGLDisplay)surfaceTexture, (EGLSurface)object);
        }
        if ((surfaceTexture = this.context) != null) {
            object = this.display;
            EGL14.eglDestroyContext((EGLDisplay)object, (EGLContext)surfaceTexture);
        }
        if ((n10 = Util.SDK_INT) >= n11) {
            EGL14.eglReleaseThread();
        }
        if ((handler = this.display) != null && (n11 = (int)(handler.equals((Object)(surfaceTexture = EGL14.EGL_NO_DISPLAY)) ? 1 : 0)) == 0) {
            handler = this.display;
            EGL14.eglTerminate((EGLDisplay)handler);
        }
        this.display = null;
        this.context = null;
        this.surface = null;
        this.texture = null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        this.dispatchOnFrameAvailable();
        SurfaceTexture surfaceTexture = this.texture;
        if (surfaceTexture == null) return;
        try {
            surfaceTexture.updateTexImage();
            return;
        }
        catch (RuntimeException runtimeException) {
            return;
        }
    }
}

