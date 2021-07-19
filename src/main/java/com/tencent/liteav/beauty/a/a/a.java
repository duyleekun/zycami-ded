/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  javax.microedition.khronos.egl.EGL10
 *  javax.microedition.khronos.egl.EGL11
 *  javax.microedition.khronos.egl.EGLConfig
 *  javax.microedition.khronos.egl.EGLContext
 *  javax.microedition.khronos.egl.EGLDisplay
 *  javax.microedition.khronos.egl.EGLSurface
 */
package com.tencent.liteav.beauty.a.a;

import com.tencent.liteav.basic.log.TXCLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGL11;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class a {
    private EGL10 a;
    private final EGLContext b;
    private EGLDisplay c;
    private EGLConfig d;
    private EGLSurface e;

    public a() {
        this(null);
    }

    public a(EGLConfig object) {
        EGL10 eGL10;
        this.a = eGL10 = (EGL10)EGLContext.getEGL();
        Object object2 = EGL10.EGL_DEFAULT_DISPLAY;
        eGL10 = eGL10.eglGetDisplay(object2);
        this.c = eGL10;
        object2 = EGL10.EGL_NO_DISPLAY;
        if (eGL10 != object2) {
            EGL10 eGL102 = this.a;
            int n10 = 2;
            object2 = new int[n10];
            boolean bl2 = eGL102.eglInitialize((EGLDisplay)eGL10, (int[])object2);
            if (bl2) {
                this.d = object != null ? object : (object = this.b());
                Object object3 = object = (Object)new int[3];
                object3[0] = (EGLConfig)12440;
                object3[1] = (EGLConfig)2;
                object3[2] = (EGLConfig)12344;
                eGL10 = this.a;
                object2 = this.c;
                eGL102 = this.d;
                EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
                object = eGL10.eglCreateContext((EGLDisplay)object2, (EGLConfig)eGL102, eGLContext, (int[])object);
                this.b = object;
                return;
            }
            this.c = null;
            super("unable to initialize EGL10");
            throw object;
        }
        super("unable to get EGL10 display");
        throw object;
    }

    private void a(String string2) {
        int n10;
        EGL10 eGL10 = this.a;
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

    private EGLConfig b() {
        int[] nArray;
        int[] nArray2 = nArray = new int[17];
        int[] nArray3 = nArray;
        nArray2[0] = 12339;
        nArray3[1] = 1;
        nArray2[2] = 12325;
        nArray3[3] = 16;
        nArray2[4] = 12326;
        nArray3[5] = 0;
        nArray2[6] = 12324;
        nArray3[7] = 8;
        nArray2[8] = 12323;
        nArray3[9] = 8;
        nArray2[10] = 12322;
        nArray3[11] = 8;
        nArray2[12] = 12321;
        nArray3[13] = 8;
        nArray2[14] = 12352;
        nArray3[15] = 4;
        nArray3[16] = 12344;
        int n10 = 1;
        EGL10 eGL10 = this.a;
        EGLDisplay eGLDisplay = this.c;
        EGLConfig[] eGLConfigArray = new EGLConfig[n10];
        int n11 = 1;
        int[] nArray4 = new int[n10];
        if ((n10 = (int)(eGL10.eglChooseConfig(eGLDisplay, nArray, eGLConfigArray, n11, nArray4) ? 1 : 0)) == 0) {
            TXCLog.w("ImageEglSurface", "unable to find RGB8888  EGLConfig");
            return null;
        }
        return eGLConfigArray[0];
    }

    public EGLSurface a(int n10, int n11) {
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
        Object object = this.a;
        EGLDisplay eGLDisplay = this.c;
        EGLConfig eGLConfig = this.d;
        object = object.eglCreatePbufferSurface(eGLDisplay, eGLConfig, nArray);
        this.e = object;
        this.a("eglCreatePbufferSurface");
        object = this.e;
        if (object != null) {
            return object;
        }
        object = new RuntimeException("surface was null");
        throw object;
    }

    public void a() {
        EGL10 eGL10 = this.a;
        EGLDisplay eGLDisplay = this.c;
        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
        EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
        eGL10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext);
        eGL10 = this.a;
        eGLDisplay = this.c;
        eGLSurface = this.b;
        eGL10.eglDestroyContext(eGLDisplay, (EGLContext)eGLSurface);
        eGL10 = this.a;
        eGLDisplay = this.c;
        eGL10.eglTerminate(eGLDisplay);
    }

    public void a(EGLSurface eGLSurface) {
        EGL10 eGL10 = this.a;
        EGLDisplay eGLDisplay = this.c;
        eGL10.eglDestroySurface(eGLDisplay, eGLSurface);
    }

    public void b(EGLSurface object) {
        boolean bl2;
        String string2;
        EGLDisplay eGLDisplay = this.c;
        Object object2 = EGL11.EGL_NO_DISPLAY;
        if (eGLDisplay == object2) {
            object2 = "EglCore";
            string2 = "NOTE: makeCurrent w/o display";
            TXCLog.i((String)object2, string2);
        }
        if (bl2 = (object2 = this.a).eglMakeCurrent(eGLDisplay, object, object, (EGLContext)(string2 = this.b))) {
            return;
        }
        object = new RuntimeException("eglMakeCurrent failed");
        throw object;
    }
}

