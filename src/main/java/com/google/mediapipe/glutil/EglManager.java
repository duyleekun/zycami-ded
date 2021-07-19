/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.opengl.EGL14
 *  android.opengl.EGLConfig
 *  android.opengl.EGLContext
 *  android.opengl.EGLDisplay
 *  android.opengl.EGLSurface
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.Surface
 *  android.view.SurfaceHolder
 *  android.view.SurfaceView
 *  javax.microedition.khronos.egl.EGL10
 *  javax.microedition.khronos.egl.EGLConfig
 *  javax.microedition.khronos.egl.EGLContext
 *  javax.microedition.khronos.egl.EGLDisplay
 *  javax.microedition.khronos.egl.EGLSurface
 */
package com.google.mediapipe.glutil;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLDisplay;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.google.mediapipe.framework.Compat;
import java.util.HashMap;
import java.util.Map;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLSurface;

public class EglManager {
    public static final int EGL14_API_LEVEL = 17;
    public static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
    public static final int EGL_DRAW = 12377;
    public static final int EGL_OPENGL_ES2_BIT = 4;
    public static final int EGL_OPENGL_ES3_BIT_KHR = 64;
    public static final int EGL_READ = 12378;
    private static final String TAG = "EglManager";
    private EGL10 egl;
    private android.opengl.EGLContext egl14Context;
    private EGLConfig eglConfig;
    private EGLContext eglContext;
    private javax.microedition.khronos.egl.EGLDisplay eglDisplay;
    private int glVersion;
    private long nativeEglContext;
    private int[] singleIntArray;

    public EglManager(Object object) {
        this(object, null);
    }

    public EglManager(Object object, int[] object2) {
        block6: {
            block7: {
                Object object3;
                block11: {
                    Object object4;
                    int n10;
                    Object object5;
                    int n11;
                    block9: {
                        block10: {
                            block8: {
                                long l10;
                                Object object6;
                                object3 = EGL10.EGL_NO_DISPLAY;
                                this.eglDisplay = object3;
                                this.eglConfig = null;
                                this.eglContext = object6 = EGL10.EGL_NO_CONTEXT;
                                this.nativeEglContext = l10 = 0L;
                                this.egl14Context = null;
                                n11 = 1;
                                object3 = new int[n11];
                                this.singleIntArray = (int[])object3;
                                object3 = (EGL10)EGLContext.getEGL();
                                this.egl = object3;
                                object6 = EGL10.EGL_DEFAULT_DISPLAY;
                                object3 = object3.eglGetDisplay(object6);
                                this.eglDisplay = object3;
                                object6 = EGL10.EGL_NO_DISPLAY;
                                if (object3 == object6) break block6;
                                object5 = this.egl;
                                n10 = 2;
                                object4 = new int[n10];
                                n11 = (int)(object5.eglInitialize((javax.microedition.khronos.egl.EGLDisplay)object3, object4) ? 1 : 0);
                                if (n11 == 0) break block7;
                                if (object != null) break block8;
                                object = EGL10.EGL_NO_CONTEXT;
                                break block9;
                            }
                            n11 = object instanceof EGLContext;
                            if (n11 == 0) break block10;
                            object = (EGLContext)object;
                            break block9;
                        }
                        n11 = Build.VERSION.SDK_INT;
                        int n12 = 17;
                        if (n11 < n12 || (n11 = object instanceof android.opengl.EGLContext) == 0) break block11;
                        object3 = EGL14.EGL_NO_CONTEXT;
                        if (object == object3) {
                            object = EGL10.EGL_NO_CONTEXT;
                        } else {
                            object = (android.opengl.EGLContext)object;
                            object = this.egl10ContextFromEgl14Context((android.opengl.EGLContext)object);
                        }
                    }
                    n11 = 3;
                    this.createContext((EGLContext)object, n11, (int[])object2);
                    try {
                        this.glVersion = n11;
                    }
                    catch (RuntimeException runtimeException) {
                        object4 = new StringBuilder;
                        object5 = "could not create GLES 3 context: ";
                        object4.append((String)object5);
                        object4.append(runtimeException);
                        String string2 = object4.toString();
                        object4 = TAG;
                        Log.w((String)object4, (String)string2);
                        this.createContext((EGLContext)object, n10, (int[])object2);
                        this.glVersion = n10;
                    }
                    return;
                }
                object2 = new RuntimeException;
                super();
                ((StringBuilder)object3).append("invalid parent context: ");
                ((StringBuilder)object3).append(object);
                object = ((StringBuilder)object3).toString();
                super((String)object);
                throw object2;
            }
            object = new RuntimeException("eglInitialize failed");
            throw object;
        }
        object = new RuntimeException("eglGetDisplay failed");
        throw object;
    }

    private void checkEglError(String string2) {
        int n10;
        EGL10 eGL10 = this.egl;
        int n11 = eGL10.eglGetError();
        if (n11 == (n10 = 12288)) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(": EGL error: 0x");
        string2 = Integer.toHexString(n11);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        RuntimeException runtimeException = new RuntimeException(string2);
        throw runtimeException;
    }

    private void createContext(EGLContext object, int n10, int[] object2) {
        object2 = this.getConfig(n10, (int[])object2);
        this.eglConfig = (EGLConfig)object2;
        if (object2 != null) {
            int n11;
            int n12;
            int n13 = 3;
            Object object3 = new int[n13];
            object3[0] = n12 = 12440;
            object3[1] = n10;
            n10 = 2;
            object3[n10] = n11 = 12344;
            Object object4 = this.egl;
            javax.microedition.khronos.egl.EGLDisplay eGLDisplay = this.eglDisplay;
            this.eglContext = object = object4.eglCreateContext(eGLDisplay, (EGLConfig)object2, object, object3);
            if (object == null) {
                object = this.egl;
                int n14 = object.eglGetError();
                object2 = new StringBuilder;
                ((StringBuilder)object2)();
                ((StringBuilder)object2).append("Could not create GL context: EGL error: 0x");
                object3 = Integer.toHexString(n14);
                ((StringBuilder)object2).append((String)object3);
                n13 = 12294;
                object = n14 == n13 ? ": parent context uses a different version of OpenGL" : "";
                ((StringBuilder)object2).append((String)object);
                object = ((StringBuilder)object2).toString();
                object4 = new RuntimeException((String)object);
                throw object4;
            }
            return;
        }
        object = new RuntimeException("Unable to find a suitable EGLConfig");
        throw object;
    }

    private EGLContext egl10ContextFromEgl14Context(android.opengl.EGLContext eGLContext) {
        Object object;
        android.opengl.EGLContext eGLContext2 = EGL14.eglGetCurrentContext();
        EGLDisplay eGLDisplay = EGL14.eglGetCurrentDisplay();
        int n10 = 12377;
        android.opengl.EGLSurface eGLSurface = EGL14.eglGetCurrentSurface((int)n10);
        int n11 = 12378;
        android.opengl.EGLSurface eGLSurface2 = EGL14.eglGetCurrentSurface((int)n11);
        android.opengl.EGLSurface eGLSurface3 = null;
        EGLDisplay eGLDisplay2 = EGL14.eglGetDisplay((int)0);
        int n12 = eGLContext2.equals((Object)eGLContext);
        if (n12 == 0) {
            n12 = 5;
            int[] nArray = object = new int[n12];
            int[] nArray2 = object;
            nArray[0] = 12375;
            nArray2[1] = 1;
            nArray[2] = 12374;
            nArray2[3] = 1;
            nArray2[4] = 12344;
            android.opengl.EGLConfig eGLConfig = this.getThrowawayConfig(eGLDisplay2);
            eGLSurface3 = EGL14.eglCreatePbufferSurface((EGLDisplay)eGLDisplay, (android.opengl.EGLConfig)eGLConfig, (int[])object, (int)0);
            EGL14.eglMakeCurrent((EGLDisplay)eGLDisplay2, (android.opengl.EGLSurface)eGLSurface3, (android.opengl.EGLSurface)eGLSurface3, (android.opengl.EGLContext)eGLContext);
        } else {
            eGLSurface3 = null;
        }
        object = this.egl.eglGetCurrentContext();
        boolean bl2 = eGLContext2.equals((Object)eGLContext);
        if (!bl2) {
            EGL14.eglMakeCurrent((EGLDisplay)eGLDisplay, (android.opengl.EGLSurface)eGLSurface, (android.opengl.EGLSurface)eGLSurface2, (android.opengl.EGLContext)eGLContext2);
            EGL14.eglDestroySurface((EGLDisplay)eGLDisplay2, eGLSurface3);
        }
        return object;
    }

    private int findConfigAttrib(EGLConfig eGLConfig, int n10, int n11) {
        EGL10 eGL10 = this.egl;
        javax.microedition.khronos.egl.EGLDisplay eGLDisplay = this.eglDisplay;
        int[] nArray = this.singleIntArray;
        boolean bl2 = eGL10.eglGetConfigAttrib(eGLDisplay, eGLConfig, n10, nArray);
        if (bl2) {
            return this.singleIntArray[0];
        }
        return n11;
    }

    private EGLConfig getConfig(int n10, int[] nArray) {
        int n11;
        int n12;
        int n13;
        int n14;
        int n15;
        int n16;
        EglManager eglManager = this;
        int n17 = 15;
        Object object = new int[n17];
        object[0] = n16 = 12324;
        object[1] = n15 = 8;
        object[2] = n14 = 12323;
        int n18 = 3;
        object[n18] = n15;
        int n19 = 4;
        object[n19] = n13 = 12322;
        int n20 = 5;
        object[n20] = n15;
        object[6] = n12 = 12321;
        object[7] = n15;
        object[n15] = 12325;
        object[9] = 16;
        object[10] = n11 = 12352;
        if (n10 == n18) {
            n19 = 64;
        }
        object[11] = n19;
        object[12] = 12339;
        object[13] = n20;
        n18 = 14;
        object[n18] = 12344;
        int[] nArray2 = nArray;
        object = eglManager.mergeAttribLists((int[])object, nArray);
        nArray2 = eglManager.singleIntArray;
        EGL10 eGL10 = eglManager.egl;
        javax.microedition.khronos.egl.EGLDisplay eGLDisplay = eglManager.eglDisplay;
        int n21 = 0;
        n19 = (int)(eGL10.eglChooseConfig(eGLDisplay, object, null, 0, nArray2) ? 1 : 0);
        if (n19 != 0) {
            n19 = nArray2[0];
            if (n19 > 0) {
                eGL10 = eglManager.egl;
                eGLDisplay = eglManager.eglDisplay;
                n19 = nArray2[0];
                EGLConfig[] eGLConfigArray = new EGLConfig[n19];
                n17 = (int)(eGL10.eglChooseConfig(eGLDisplay, object, eGLConfigArray, n19, nArray2) ? 1 : 0);
                if (n17 != 0) {
                    n17 = 0;
                    object = null;
                    nArray2 = null;
                    for (n18 = 0; n18 < n19; ++n18) {
                        EGLConfig eGLConfig = eGLConfigArray[n18];
                        n11 = eglManager.findConfigAttrib(eGLConfig, n16, 0);
                        int n22 = eglManager.findConfigAttrib(eGLConfig, n14, 0);
                        int n23 = eglManager.findConfigAttrib(eGLConfig, n13, 0);
                        n21 = eglManager.findConfigAttrib(eGLConfig, n12, 0);
                        if (n11 != n15 || n22 != n15 || n23 != n15 || n21 != n15) continue;
                        object = eGLConfig;
                        break;
                    }
                    if (object == null) {
                        object = eGLConfigArray[0];
                    }
                    return object;
                }
                object = new IllegalArgumentException;
                object("eglChooseConfig#2 failed");
                throw object;
            }
            object = new IllegalArgumentException;
            object("No configs match requested attributes");
            throw object;
        }
        object = new IllegalArgumentException;
        object("eglChooseConfig failed");
        throw object;
    }

    private android.opengl.EGLConfig getThrowawayConfig(EGLDisplay object) {
        int[] nArray;
        int[] nArray2 = nArray = new int[3];
        nArray[0] = 12339;
        nArray2[1] = 5;
        nArray2[2] = 12344;
        int n10 = 1;
        android.opengl.EGLConfig[] eGLConfigArray = new android.opengl.EGLConfig[n10];
        int n11 = 1;
        int[] nArray3 = this.singleIntArray;
        boolean bl2 = EGL14.eglChooseConfig((EGLDisplay)object, (int[])nArray, (int)0, (android.opengl.EGLConfig[])eGLConfigArray, (int)0, (int)n11, (int[])nArray3, (int)0);
        if (bl2) {
            bl2 = false;
            object = null;
            int n12 = nArray3[0];
            if (n12 > 0) {
                return eGLConfigArray[0];
            }
            object = new IllegalArgumentException("No configs match requested attributes");
            throw object;
        }
        object = new IllegalArgumentException("eglChooseConfig failed");
        throw object;
    }

    private void grabContextVariants() {
        android.opengl.EGLContext eGLContext;
        long l10;
        EGLContext eGLContext2 = this.egl.eglGetCurrentContext();
        javax.microedition.khronos.egl.EGLDisplay eGLDisplay = this.egl.eglGetCurrentDisplay();
        EGL10 eGL10 = this.egl;
        int n10 = 12377;
        eGL10 = eGL10.eglGetCurrentSurface(n10);
        EGL10 eGL102 = this.egl;
        int n11 = 12378;
        eGL102 = eGL102.eglGetCurrentSurface(n11);
        EGLContext eGLContext3 = this.eglContext;
        if (eGLContext2 != eGLContext3) {
            n11 = 1;
            eGLContext3 = this.createOffscreenSurface(n11, n11);
            this.makeCurrent((EGLSurface)eGLContext3, (EGLSurface)eGLContext3);
        } else {
            n11 = 0;
            eGLContext3 = null;
        }
        this.nativeEglContext = l10 = Compat.getCurrentNativeEGLContext();
        int n12 = Build.VERSION.SDK_INT;
        int n13 = 17;
        if (n12 >= n13) {
            this.egl14Context = eGLContext = EGL14.eglGetCurrentContext();
        }
        if (eGLContext2 != (eGLContext = this.eglContext)) {
            eGLContext = this.egl;
            eGLContext.eglMakeCurrent(eGLDisplay, (EGLSurface)eGL10, (EGLSurface)eGL102, eGLContext2);
            this.releaseSurface((EGLSurface)eGLContext3);
        }
    }

    private int[] mergeAttribLists(int[] nArray, int[] object) {
        int n10;
        int n11;
        if (object == null) {
            return nArray;
        }
        Object object2 = new HashMap();
        int n12 = 2;
        Object object3 = new int[n12][];
        int n13 = 0;
        object3[0] = nArray;
        int n14 = 1;
        object3[n14] = object;
        int n15 = 0;
        object = null;
        while (true) {
            int n16;
            n11 = 12344;
            if (n15 >= n12) break;
            int[] nArray2 = object3[n15];
            for (int i10 = 0; i10 < (n16 = nArray2.length / n12); ++i10) {
                n16 = i10 * 2;
                int n17 = nArray2[n16];
                n16 += n14;
                n16 = nArray2[n16];
                if (n17 == n11) break;
                Integer n18 = n17;
                Integer n19 = n16;
                ((HashMap)object2).put(n18, n19);
            }
            ++n15;
        }
        n15 = ((HashMap)object2).size() * n12 + n14;
        nArray = new int[n15];
        object = ((HashMap)object2).entrySet().iterator();
        while ((n10 = object.hasNext()) != 0) {
            int n20;
            object2 = (Map.Entry)object.next();
            n12 = n13 + 1;
            object3 = (Integer)object2.getKey();
            nArray[n13] = n20 = ((Integer)object3).intValue();
            n13 = n12 + 1;
            object2 = (Integer)object2.getValue();
            nArray[n12] = n10 = ((Integer)object2).intValue();
        }
        nArray[n13] = n11;
        return nArray;
    }

    public EGLSurface createOffscreenSurface(int n10, int n11) {
        int n12;
        int n13;
        int n14 = 5;
        int[] nArray = new int[n14];
        nArray[0] = n13 = 12375;
        nArray[1] = n10;
        nArray[2] = n12 = 12374;
        nArray[3] = n11;
        n10 = 4;
        nArray[n10] = n11 = 12344;
        Object object = this.egl;
        Object object2 = this.eglDisplay;
        EGLConfig eGLConfig = this.eglConfig;
        object = object.eglCreatePbufferSurface(object2, eGLConfig, nArray);
        object2 = "eglCreatePbufferSurface";
        this.checkEglError((String)object2);
        if (object != null) {
            return object;
        }
        object = new RuntimeException("surface was null");
        throw object;
    }

    public EGLSurface createWindowSurface(Object object) {
        int n10;
        int n11 = object instanceof Surface;
        if (n11 == 0 && (n11 = object instanceof SurfaceTexture) == 0 && (n11 = object instanceof SurfaceHolder) == 0 && (n11 = object instanceof SurfaceView) == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("invalid surface: ");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            RuntimeException runtimeException = new RuntimeException((String)object);
            throw runtimeException;
        }
        n11 = 1;
        Object object2 = new int[n11];
        object2[0] = n10 = 12344;
        EGL10 eGL10 = this.egl;
        javax.microedition.khronos.egl.EGLDisplay eGLDisplay = this.eglDisplay;
        EGLConfig eGLConfig = this.eglConfig;
        object = eGL10.eglCreateWindowSurface(eGLDisplay, eGLConfig, object, object2);
        object2 = "eglCreateWindowSurface";
        this.checkEglError((String)object2);
        if (object != null) {
            return object;
        }
        object = new RuntimeException("surface was null");
        throw object;
    }

    public EGLContext getContext() {
        return this.eglContext;
    }

    public android.opengl.EGLContext getEgl14Context() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 >= n11) {
            android.opengl.EGLContext eGLContext = this.egl14Context;
            if (eGLContext == null) {
                this.grabContextVariants();
            }
            return this.egl14Context;
        }
        RuntimeException runtimeException = new RuntimeException("cannot use EGL14 on API level < 17");
        throw runtimeException;
    }

    public int getGlMajorVersion() {
        return this.glVersion;
    }

    public long getNativeContext() {
        long l10 = this.nativeEglContext;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            this.grabContextVariants();
        }
        return this.nativeEglContext;
    }

    public void makeCurrent(EGLSurface object, EGLSurface eGLSurface) {
        EGL10 eGL10 = this.egl;
        javax.microedition.khronos.egl.EGLDisplay eGLDisplay = this.eglDisplay;
        EGLContext eGLContext = this.eglContext;
        boolean bl2 = eGL10.eglMakeCurrent(eGLDisplay, object, eGLSurface, eGLContext);
        if (bl2) {
            return;
        }
        object = new RuntimeException("eglMakeCurrent failed");
        throw object;
    }

    public void makeNothingCurrent() {
        Object object = this.egl;
        javax.microedition.khronos.egl.EGLDisplay eGLDisplay = this.eglDisplay;
        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
        EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
        boolean bl2 = object.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext);
        if (bl2) {
            return;
        }
        object = new RuntimeException("eglMakeCurrent failed");
        throw object;
    }

    public void release() {
        javax.microedition.khronos.egl.EGLDisplay eGLDisplay = this.eglDisplay;
        javax.microedition.khronos.egl.EGLDisplay eGLDisplay2 = EGL10.EGL_NO_DISPLAY;
        if (eGLDisplay != eGLDisplay2) {
            eGLDisplay2 = this.egl;
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            eGLDisplay2.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext);
            eGLDisplay = this.egl;
            eGLDisplay2 = this.eglDisplay;
            eGLSurface = this.eglContext;
            eGLDisplay.eglDestroyContext(eGLDisplay2, (EGLContext)eGLSurface);
            eGLDisplay = this.egl;
            eGLDisplay2 = this.eglDisplay;
            eGLDisplay.eglTerminate(eGLDisplay2);
        }
        this.eglDisplay = eGLDisplay = EGL10.EGL_NO_DISPLAY;
        eGLDisplay = EGL10.EGL_NO_CONTEXT;
        this.eglContext = eGLDisplay;
        this.eglConfig = null;
    }

    public void releaseSurface(EGLSurface eGLSurface) {
        EGL10 eGL10 = this.egl;
        javax.microedition.khronos.egl.EGLDisplay eGLDisplay = this.eglDisplay;
        eGL10.eglDestroySurface(eGLDisplay, eGLSurface);
    }
}

