/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.EGL14
 *  android.opengl.EGLConfig
 *  android.opengl.EGLContext
 *  android.opengl.EGLDisplay
 *  android.opengl.EGLSurface
 *  android.opengl.GLES10
 *  android.opengl.GLES20
 *  android.os.Build$VERSION
 *  android.util.Log
 *  javax.microedition.khronos.egl.EGL10
 *  javax.microedition.khronos.egl.EGLConfig
 *  javax.microedition.khronos.egl.EGLContext
 *  javax.microedition.khronos.egl.EGLDisplay
 *  javax.microedition.khronos.egl.EGLSurface
 */
package d.t.a.i;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.GLES10;
import android.opengl.GLES20;
import android.os.Build;
import android.util.Log;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLSurface;

public class c {
    private static final String a = "EglUtils";

    private c() {
    }

    private static int a() {
        Object object;
        EGL10 eGL10 = (EGL10)javax.microedition.khronos.egl.EGLContext.getEGL();
        Object object2 = EGL10.EGL_DEFAULT_DISPLAY;
        javax.microedition.khronos.egl.EGLDisplay eGLDisplay = eGL10.eglGetDisplay(object2);
        object2 = new int[2];
        eGL10.eglInitialize(eGLDisplay, (int[])object2);
        int[] nArray = object = new int[7];
        int[] nArray2 = object;
        nArray[0] = 12351;
        nArray2[1] = 12430;
        nArray[2] = 12329;
        nArray2[3] = 0;
        nArray[4] = 12339;
        nArray2[5] = 1;
        nArray2[6] = 12344;
        int n10 = 1;
        javax.microedition.khronos.egl.EGLConfig[] eGLConfigArray = new javax.microedition.khronos.egl.EGLConfig[n10];
        int[] nArray3 = new int[n10];
        int n11 = 1;
        object2 = eGL10;
        javax.microedition.khronos.egl.EGLDisplay eGLDisplay2 = eGLDisplay;
        Object[] objectArray = eGLConfigArray;
        Object object3 = nArray3;
        eGL10.eglChooseConfig(eGLDisplay, object, eGLConfigArray, n11, nArray3);
        object2 = null;
        int n12 = nArray3[0];
        if (n12 == 0) {
            return 0;
        }
        eGLDisplay2 = eGLConfigArray[0];
        int[] nArray4 = object = new int[5];
        int[] nArray5 = object;
        nArray4[0] = 12375;
        nArray5[1] = 64;
        nArray4[2] = 12374;
        nArray5[3] = 64;
        nArray5[4] = 12344;
        object = eGL10.eglCreatePbufferSurface(eGLDisplay, (javax.microedition.khronos.egl.EGLConfig)eGLDisplay2, object);
        Object[] objectArray2 = objectArray = (Object[])new int[3];
        objectArray[0] = (javax.microedition.khronos.egl.EGLConfig)12440;
        objectArray2[1] = (javax.microedition.khronos.egl.EGLConfig)true;
        objectArray2[2] = (javax.microedition.khronos.egl.EGLConfig)12344;
        javax.microedition.khronos.egl.EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
        eGLDisplay2 = eGL10.eglCreateContext(eGLDisplay, (javax.microedition.khronos.egl.EGLConfig)eGLDisplay2, eGLContext, (int[])objectArray);
        eGL10.eglMakeCurrent(eGLDisplay, (EGLSurface)object, (EGLSurface)object, (javax.microedition.khronos.egl.EGLContext)eGLDisplay2);
        objectArray = new int[n10];
        GLES10.glGetIntegerv((int)3379, (int[])objectArray, (int)0);
        eGLContext = EGL10.EGL_NO_SURFACE;
        object3 = EGL10.EGL_NO_CONTEXT;
        eGL10.eglMakeCurrent(eGLDisplay, (EGLSurface)eGLContext, (EGLSurface)eGLContext, (javax.microedition.khronos.egl.EGLContext)object3);
        eGL10.eglDestroySurface(eGLDisplay, (EGLSurface)object);
        eGL10.eglDestroyContext(eGLDisplay, (javax.microedition.khronos.egl.EGLContext)eGLDisplay2);
        eGL10.eglTerminate(eGLDisplay);
        return (int)objectArray[0];
    }

    private static int b() {
        Object object;
        EGLDisplay eGLDisplay = EGL14.eglGetDisplay((int)0);
        Object object2 = new int[2];
        int n10 = 1;
        EGL14.eglInitialize((EGLDisplay)eGLDisplay, (int[])object2, (int)0, (int[])object2, (int)n10);
        int[] nArray = object = new int[9];
        int[] nArray2 = object;
        nArray[0] = 12351;
        nArray2[1] = 12430;
        nArray[2] = 12329;
        nArray2[3] = 0;
        nArray[4] = 12352;
        nArray2[5] = 4;
        nArray[6] = 12339;
        nArray2[7] = 1;
        nArray2[8] = 12344;
        EGLContext eGLContext = new EGLConfig[n10];
        int[] nArray3 = new int[n10];
        int[] nArray4 = null;
        EGLContext eGLContext2 = null;
        int n11 = 1;
        object2 = eGLDisplay;
        EGLContext eGLContext3 = eGLContext;
        EGL14.eglChooseConfig((EGLDisplay)eGLDisplay, (int[])object, (int)0, (EGLConfig[])eGLContext, (int)0, (int)n11, (int[])nArray3, (int)0);
        int n12 = nArray3[0];
        if (n12 == 0) {
            return 0;
        }
        object2 = eGLContext[0];
        int[] nArray5 = object = new int[5];
        int[] nArray6 = object;
        nArray5[0] = 12375;
        nArray6[1] = 64;
        nArray5[2] = 12374;
        nArray6[3] = 64;
        nArray6[4] = 12344;
        object = EGL14.eglCreatePbufferSurface((EGLDisplay)eGLDisplay, (EGLConfig)object2, (int[])object, (int)0);
        int[] nArray7 = nArray4 = new int[3];
        nArray4[0] = 12440;
        nArray7[1] = 2;
        nArray7[2] = 12344;
        eGLContext3 = EGL14.EGL_NO_CONTEXT;
        object2 = EGL14.eglCreateContext((EGLDisplay)eGLDisplay, (EGLConfig)object2, (EGLContext)eGLContext3, (int[])nArray4, (int)0);
        EGL14.eglMakeCurrent((EGLDisplay)eGLDisplay, (android.opengl.EGLSurface)object, (android.opengl.EGLSurface)object, (EGLContext)object2);
        nArray4 = new int[n10];
        GLES20.glGetIntegerv((int)3379, (int[])nArray4, (int)0);
        eGLContext3 = EGL14.EGL_NO_SURFACE;
        eGLContext2 = EGL14.EGL_NO_CONTEXT;
        EGL14.eglMakeCurrent((EGLDisplay)eGLDisplay, (android.opengl.EGLSurface)eGLContext3, (android.opengl.EGLSurface)eGLContext3, (EGLContext)eGLContext2);
        EGL14.eglDestroySurface((EGLDisplay)eGLDisplay, (android.opengl.EGLSurface)object);
        EGL14.eglDestroyContext((EGLDisplay)eGLDisplay, (EGLContext)object2);
        EGL14.eglTerminate((EGLDisplay)eGLDisplay);
        return nArray4[0];
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int c() {
        try {
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 17;
            if (n10 < n11) return c.a();
        }
        catch (Exception exception) {
            Log.d((String)a, (String)"getMaxTextureSize: ", (Throwable)exception);
            return 0;
        }
        return c.b();
    }
}

