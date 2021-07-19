/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 *  javax.microedition.khronos.egl.EGL10
 *  javax.microedition.khronos.egl.EGLConfig
 *  javax.microedition.khronos.egl.EGLContext
 *  javax.microedition.khronos.egl.EGLDisplay
 *  javax.microedition.khronos.egl.EGLSurface
 */
package com.tencent.liteav.basic.opengl;

import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.d;
import com.tencent.liteav.basic.util.e;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class b {
    public static final String a = "b";
    private static int[] l;
    private static int[] m;
    private EGL10 b;
    private EGLDisplay c;
    private EGLConfig d;
    private boolean e;
    private EGLContext f;
    private boolean g;
    private EGLSurface h;
    private int i = 0;
    private int j = 0;
    private int[] k;

    static {
        int[] nArray;
        int[] nArray2 = nArray = new int[17];
        int[] nArray3 = nArray;
        nArray2[0] = 12339;
        nArray3[1] = 1;
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
        nArray2[12] = 12326;
        nArray3[13] = 0;
        nArray2[14] = 12352;
        nArray3[15] = 4;
        nArray3[16] = 12344;
        l = nArray;
        int[] nArray4 = nArray = new int[19];
        int[] nArray5 = nArray;
        nArray4[0] = 12339;
        nArray5[1] = 4;
        nArray4[2] = 12324;
        nArray5[3] = 8;
        nArray4[4] = 12323;
        nArray5[5] = 8;
        nArray4[6] = 12322;
        nArray5[7] = 8;
        nArray4[8] = 12321;
        nArray5[9] = 8;
        nArray4[10] = 12325;
        nArray5[11] = 0;
        nArray4[12] = 12326;
        nArray5[13] = 0;
        nArray4[14] = 12352;
        nArray5[15] = 4;
        nArray4[16] = 12610;
        nArray5[17] = 1;
        nArray5[18] = 12344;
        m = nArray;
    }

    private b() {
        int[] nArray = new int[2];
        this.k = nArray;
    }

    public static b a(EGLConfig eGLConfig, EGLContext eGLContext, Surface surface, int n10, int n11) {
        b b10 = new b();
        b10.i = n10;
        b10.j = n11;
        boolean bl2 = b10.a(eGLConfig, eGLContext, surface);
        if (bl2) {
            return b10;
        }
        return null;
    }

    private EGLContext a(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int n10, EGLContext eGLContext) {
        int n11;
        int n12;
        int n13 = 3;
        int[] nArray = new int[n13];
        nArray[0] = n12 = 12440;
        nArray[1] = n10;
        n10 = 2;
        nArray[n10] = n11 = 12344;
        if (eGLContext == null) {
            eGLContext = EGL10.EGL_NO_CONTEXT;
        }
        eGLDisplay = this.b.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, nArray);
        this.g();
        return eGLDisplay;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean a(EGLConfig eGLConfig, EGLContext object, Surface object2) {
        Object object3;
        Object object4;
        EGL10 eGL10;
        this.b = eGL10 = (EGL10)EGLContext.getEGL();
        Object object5 = EGL10.EGL_DEFAULT_DISPLAY;
        eGL10 = eGL10.eglGetDisplay(object5);
        this.c = eGL10;
        object5 = this.b;
        Object object6 = this.k;
        object5.eglInitialize((EGLDisplay)eGL10, object6);
        eGL10 = null;
        boolean bl2 = true;
        if (eGLConfig == null) {
            int[] nArray = new int[bl2];
            eGLConfig = new EGLConfig[bl2];
            object6 = this.b;
            object4 = this.c;
            object3 = object2 == null ? l : m;
            int n10 = 1;
            object6.eglChooseConfig(object4, object3, (EGLConfig[])eGLConfig, n10, nArray);
            this.d = eGLConfig = eGLConfig[0];
            this.e = bl2;
        } else {
            this.d = eGLConfig;
        }
        if (object != null) {
            this.g = bl2;
        }
        int n11 = 3;
        int n12 = 2;
        try {
            object4 = this.c;
            object3 = this.d;
            object4 = this.a((EGLDisplay)object4, (EGLConfig)object3, n12, (EGLContext)object);
            this.f = object4;
        }
        catch (d d10) {
            object4 = a;
            object3 = "failed to create EGLContext of OpenGL ES 2.0, try 3.0";
            TXCLog.i((String)object4, (String)object3);
            try {
                object4 = this.c;
                object3 = this.d;
                this.f = object = this.a((EGLDisplay)object4, (EGLConfig)object3, n11, (EGLContext)object);
            }
            catch (d d11) {
                object = a;
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("failed to create EGLContext of 3.0. ");
                ((StringBuilder)object2).append(d11);
                String string2 = ((StringBuilder)object2).toString();
                TXCLog.e((String)object, string2);
                return false;
            }
        }
        int n13 = 5;
        object = new int[n13];
        object[0] = (EGLContext)12375;
        int n14 = this.i;
        object[bl2] = (EGLContext)n14;
        n14 = 12374;
        object[n12] = (EGLContext)n14;
        n12 = this.j;
        object[n11] = (EGLContext)n12;
        n11 = 4;
        n12 = 12344;
        object[n11] = (EGLContext)n12;
        if (object2 == null) {
            eGLConfig = this.b;
            object2 = this.c;
            object6 = this.d;
            eGLConfig = eGLConfig.eglCreatePbufferSurface((EGLDisplay)object2, (EGLConfig)object6, (int[])object);
            this.h = eGLConfig;
        } else {
            eGLConfig = this.b;
            object = this.c;
            object6 = this.d;
            n14 = 0;
            object4 = null;
            eGLConfig = eGLConfig.eglCreateWindowSurface((EGLDisplay)object, (EGLConfig)object6, object2, null);
            this.h = eGLConfig;
        }
        eGLConfig = this.h;
        object = EGL10.EGL_NO_SURFACE;
        if (eGLConfig == object) {
            this.e();
            return false;
        }
        object = this.b;
        object2 = this.c;
        object6 = this.f;
        n11 = (int)(object.eglMakeCurrent((EGLDisplay)object2, (EGLSurface)eGLConfig, (EGLSurface)eGLConfig, (EGLContext)object6) ? 1 : 0);
        if (n11 == 0) {
            this.e();
            return false;
        }
        return bl2;
    }

    private void g() {
        int n10;
        EGL10 eGL10 = this.b;
        int n11 = eGL10.eglGetError();
        if (n11 == (n10 = 12288)) {
            return;
        }
        d d10 = new d(n11);
        throw d10;
    }

    public boolean a() {
        EGL10 eGL10 = this.b;
        EGLDisplay eGLDisplay = this.c;
        EGLSurface eGLSurface = this.h;
        boolean bl2 = eGL10.eglSwapBuffers(eGLDisplay, eGLSurface);
        this.e();
        return bl2;
    }

    public void b() {
        EGL10 eGL10 = this.b;
        EGLDisplay eGLDisplay = this.c;
        EGLSurface eGLSurface = this.h;
        EGLContext eGLContext = this.f;
        eGL10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext);
        this.e();
    }

    public void c() {
        EGL10 eGL10 = this.b;
        EGLDisplay eGLDisplay = this.c;
        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
        EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
        eGL10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext);
        eGL10 = this.h;
        if (eGL10 != null) {
            eGLDisplay = this.b;
            eGLSurface = this.c;
            eGLDisplay.eglDestroySurface((EGLDisplay)eGLSurface, (EGLSurface)eGL10);
        }
        if ((eGL10 = this.f) != null) {
            eGLDisplay = this.b;
            eGLSurface = this.c;
            eGLDisplay.eglDestroyContext((EGLDisplay)eGLSurface, (EGLContext)eGL10);
        }
        eGL10 = this.b;
        eGLDisplay = this.c;
        eGL10.eglTerminate(eGLDisplay);
        this.e();
        this.c = null;
        this.h = null;
        this.c = null;
    }

    public EGLContext d() {
        return this.f;
    }

    public void e() {
        int n10;
        Object object = this.b;
        int n11 = object.eglGetError();
        if (n11 != (n10 = 12288)) {
            String string2 = a;
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = "EGL error: 0x";
            stringBuilder.append(string3);
            object = Integer.toHexString(n11);
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            TXCLog.e(string2, (String)object);
        }
    }

    public e f() {
        int n10 = 1;
        int[] nArray = new int[n10];
        Object object = new int[n10];
        Object object2 = this.b;
        EGLDisplay eGLDisplay = this.c;
        EGLSurface eGLSurface = this.h;
        int n11 = 12375;
        boolean bl2 = object2.eglQuerySurface(eGLDisplay, eGLSurface, n11, nArray);
        eGLDisplay = this.b;
        eGLSurface = this.c;
        EGLSurface eGLSurface2 = this.h;
        int n12 = 12374;
        boolean bl3 = eGLDisplay.eglQuerySurface((EGLDisplay)eGLSurface, eGLSurface2, n12, object);
        eGLSurface = null;
        if (bl2 && bl3) {
            int n13 = nArray[0];
            n10 = object[0];
            object2 = new e(n13, n10);
            return object2;
        }
        object = new e;
        object(0, 0);
        return object;
    }
}

