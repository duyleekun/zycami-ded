/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.EGL14
 *  android.opengl.EGLConfig
 *  android.opengl.EGLContext
 *  android.opengl.EGLDisplay
 *  android.opengl.EGLExt
 *  android.opengl.EGLSurface
 *  android.util.Log
 *  android.view.Surface
 */
package com.tencent.liteav.basic.opengl;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.util.Log;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.d;
import com.tencent.liteav.basic.util.e;

public class c {
    private static int a = 2;
    private static final String b = "c";
    private static int[] k;
    private static int[] l;
    private EGLDisplay c;
    private EGLContext d;
    private EGLConfig e;
    private int f;
    private int g;
    private boolean h;
    private EGLSurface i;
    private int j;

    static {
        int n10;
        int n11;
        int n12;
        int n13;
        int n14;
        int n15;
        int n16;
        int n17;
        int n18;
        int[] nArray = new int[17];
        int n19 = 0;
        nArray[0] = n18 = 12324;
        int n20 = 1;
        nArray[n20] = n17 = 8;
        int n21 = 2;
        nArray[n21] = n16 = 12323;
        int n22 = 3;
        nArray[n22] = n17;
        int n23 = 4;
        nArray[n23] = n15 = 12322;
        int n24 = 5;
        nArray[n24] = n17;
        int n25 = 6;
        nArray[n25] = n14 = 12321;
        int n26 = 7;
        nArray[n26] = n17;
        nArray[n17] = n13 = 12325;
        int n27 = 9;
        nArray[n27] = 0;
        int n28 = 10;
        nArray[n28] = n12 = 12326;
        int n29 = 11;
        nArray[n29] = 0;
        int n30 = 12;
        nArray[n30] = n11 = 12352;
        int n31 = a;
        int n32 = n31 == n21 ? n23 : 68;
        int n33 = 13;
        nArray[n33] = n32;
        nArray[14] = 12610;
        nArray[15] = n20;
        nArray[16] = n10 = 12344;
        k = nArray;
        int n34 = 19;
        nArray = new int[n34];
        nArray[0] = n32 = 12339;
        nArray[n20] = n20;
        nArray[n21] = n18;
        nArray[n22] = n17;
        nArray[n23] = n16;
        nArray[n24] = n17;
        nArray[n25] = n15;
        nArray[n26] = n17;
        nArray[n17] = n14;
        nArray[n27] = n17;
        nArray[n28] = n13;
        nArray[n29] = 0;
        nArray[n30] = n12;
        nArray[n33] = 0;
        nArray[14] = n11;
        n19 = 15;
        if (n31 != n21) {
            n23 = 68;
        }
        nArray[n19] = n23;
        nArray[16] = 12610;
        nArray[17] = n20;
        nArray[18] = 12344;
        l = nArray;
    }

    public c() {
        EGLDisplay eGLDisplay;
        this.c = eGLDisplay = EGL14.EGL_NO_DISPLAY;
        eGLDisplay = EGL14.EGL_NO_CONTEXT;
        this.d = eGLDisplay;
        this.e = null;
        this.f = 0;
        this.g = 0;
        this.j = -1;
    }

    private static EGLContext a(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int n10, EGLContext eGLContext) {
        int[] nArray = new int[]{12440, n10, 12344};
        eGLDisplay = EGL14.eglCreateContext((EGLDisplay)eGLDisplay, (EGLConfig)eGLConfig, (EGLContext)eGLContext, (int[])nArray, (int)0);
        com.tencent.liteav.basic.opengl.c.g();
        return eGLDisplay;
    }

    public static c a(EGLConfig eGLConfig, EGLContext eGLContext, Surface surface, int n10, int n11) {
        c c10 = new c();
        c10.f = n10;
        c10.g = n11;
        boolean bl2 = c10.a(eGLConfig, eGLContext, surface);
        if (bl2) {
            return c10;
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean a(EGLConfig eGLContext, EGLContext eGLContext2, Surface surface) {
        int n10;
        Object object;
        boolean bl2;
        int n11;
        Object object2;
        int n12;
        c c10 = this;
        Object object3 = eGLContext;
        Object object4 = surface;
        Object object5 = EGL14.eglGetDisplay((int)0);
        this.c = object5;
        Object object6 = EGL14.EGL_NO_DISPLAY;
        if (object5 == object6) {
            object5 = b;
            object6 = "unable to get EGL14 display";
            TXCLog.e((String)object5, (String)object6);
        }
        if ((n12 = EGL14.eglInitialize((EGLDisplay)(object2 = c10.c), (int[])(object6 = (Object)new int[n11 = 2]), (int)0, (int[])object6, (int)((bl2 = true) ? 1 : 0))) == 0) {
            n12 = 0;
            c10.c = null;
            object6 = b;
            object2 = "unable to initialize EGL14";
            TXCLog.e((String)object6, (String)object2);
        }
        if (object3 != null) {
            c10.e = object3;
        } else {
            int[] nArray;
            int n13;
            object = c10.c;
            object6 = object4 == null ? (Object)l : (Object)k;
            n12 = (int)(EGL14.eglChooseConfig((EGLDisplay)object, (int[])object6, (int)0, (EGLConfig[])(object3 = new EGLConfig[bl2]), (int)0, (int)(n13 = 1), (int[])(nArray = new int[bl2]), (int)0) ? 1 : 0);
            if (n12 == 0) {
                return false;
            }
            object3 = object3[0];
            c10.e = object3;
        }
        if (eGLContext2 != null) {
            c10.h = bl2;
            object3 = eGLContext2;
        } else {
            object3 = EGL14.EGL_NO_CONTEXT;
        }
        n12 = 3;
        try {
            object2 = c10.c;
            object = c10.e;
            object2 = com.tencent.liteav.basic.opengl.c.a(object2, (EGLConfig)object, n11, object3);
            c10.d = object2;
        }
        catch (d d10) {
            object2 = b;
            object = "failed to create EGLContext of OpenGL ES 2.0, try 3.0";
            TXCLog.i((String)object2, (String)object);
            try {
                object2 = c10.c;
                object = c10.e;
                c10.d = object3 = com.tencent.liteav.basic.opengl.c.a(object2, (EGLConfig)object, n12, object3);
            }
            catch (d d11) {
                object4 = b;
                object5 = new StringBuilder();
                ((StringBuilder)object5).append("failed to create EGLContext of 3.0. ");
                ((StringBuilder)object5).append(d11);
                String string2 = ((StringBuilder)object5).toString();
                TXCLog.e((String)object4, string2);
                return false;
            }
        }
        object3 = new int[bl2];
        int n14 = 12344;
        object3[0] = (EGLContext)n14;
        if (object4 == null) {
            n10 = 5;
            object3 = new int[n10];
            object3[0] = (EGLContext)12375;
            int n15 = c10.f;
            object3[bl2] = (EGLContext)n15;
            object3[n11] = (EGLContext)12374;
            n15 = c10.g;
            object3[n12] = (EGLContext)n15;
            n15 = 4;
            object3[n15] = (EGLContext)n14;
            object4 = c10.c;
            object5 = c10.e;
            object3 = EGL14.eglCreatePbufferSurface((EGLDisplay)object4, (EGLConfig)object5, (int[])object3, (int)0);
            c10.i = object3;
        } else {
            object5 = c10.c;
            object6 = c10.e;
            object3 = EGL14.eglCreateWindowSurface((EGLDisplay)object5, (EGLConfig)object6, (Object)object4, (int[])object3, (int)0);
            c10.i = object3;
        }
        this.a();
        object3 = c10.c;
        object4 = c10.i;
        object5 = c10.d;
        n10 = (int)(EGL14.eglMakeCurrent((EGLDisplay)object3, (EGLSurface)object4, (EGLSurface)object4, (EGLContext)object5) ? 1 : 0);
        if (n10 == 0) {
            this.a();
            return false;
        }
        return bl2;
    }

    private static void g() {
        int n10;
        int n11 = EGL14.eglGetError();
        if (n11 == (n10 = 12288)) {
            return;
        }
        d d10 = new d(n11);
        throw d10;
    }

    public void a() {
        int n10;
        int n11 = EGL14.eglGetError();
        if (n11 != (n10 = 12288)) {
            String string2 = b;
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = "EGL error:";
            stringBuilder.append(string3);
            stringBuilder.append(n11);
            String string4 = stringBuilder.toString();
            TXCLog.e(string2, string4);
        }
    }

    public void a(long l10) {
        EGLDisplay eGLDisplay = this.c;
        EGLSurface eGLSurface = this.i;
        EGLExt.eglPresentationTimeANDROID((EGLDisplay)eGLDisplay, (EGLSurface)eGLSurface, (long)l10);
    }

    public void b() {
        EGLContext eGLContext;
        boolean bl2;
        Object object = this.c;
        Object object2 = EGL14.EGL_NO_DISPLAY;
        if (object == object2) {
            object = b;
            object2 = "NOTE: makeCurrent w/o display";
            Log.d((String)object, (String)object2);
        }
        if (!(bl2 = EGL14.eglMakeCurrent((EGLDisplay)(object = this.c), (EGLSurface)(object2 = this.i), (EGLSurface)object2, (EGLContext)(eGLContext = this.d)))) {
            object = b;
            object2 = "eglMakeCurrent failed";
            TXCLog.e((String)object, (String)object2);
        }
    }

    public e c() {
        int n10 = 2;
        Object object = new int[n10];
        Object object2 = this.c;
        EGLSurface eGLSurface = this.i;
        int n11 = 12375;
        boolean bl2 = EGL14.eglQuerySurface((EGLDisplay)object2, (EGLSurface)eGLSurface, (int)n11, (int[])object, (int)0);
        eGLSurface = this.c;
        EGLSurface eGLSurface2 = this.i;
        int n12 = 12374;
        int n13 = 1;
        int n14 = EGL14.eglQuerySurface((EGLDisplay)eGLSurface, (EGLSurface)eGLSurface2, (int)n12, (int[])object, (int)n13);
        if (bl2 && n14 != 0) {
            n14 = object[0];
            n10 = object[n13];
            object2 = new e(n14, n10);
            return object2;
        }
        object = new e;
        object(0, 0);
        return object;
    }

    public void d() {
        EGLDisplay eGLDisplay = this.c;
        EGLDisplay eGLDisplay2 = EGL14.EGL_NO_DISPLAY;
        if (eGLDisplay != eGLDisplay2) {
            eGLDisplay2 = EGL14.EGL_NO_SURFACE;
            EGLContext eGLContext = EGL14.EGL_NO_CONTEXT;
            EGL14.eglMakeCurrent((EGLDisplay)eGLDisplay, (EGLSurface)eGLDisplay2, (EGLSurface)eGLDisplay2, (EGLContext)eGLContext);
            eGLDisplay = this.c;
            eGLDisplay2 = this.i;
            EGL14.eglDestroySurface((EGLDisplay)eGLDisplay, (EGLSurface)eGLDisplay2);
            eGLDisplay = this.c;
            eGLDisplay2 = this.d;
            EGL14.eglDestroyContext((EGLDisplay)eGLDisplay, (EGLContext)eGLDisplay2);
            eGLDisplay = EGL14.EGL_NO_CONTEXT;
            this.d = eGLDisplay;
            EGL14.eglReleaseThread();
            eGLDisplay = this.c;
            EGL14.eglTerminate((EGLDisplay)eGLDisplay);
        }
        this.c = eGLDisplay = EGL14.EGL_NO_DISPLAY;
    }

    public boolean e() {
        EGLDisplay eGLDisplay = this.c;
        EGLSurface eGLSurface = this.i;
        return EGL14.eglSwapBuffers((EGLDisplay)eGLDisplay, (EGLSurface)eGLSurface);
    }

    public EGLContext f() {
        return this.d;
    }
}

