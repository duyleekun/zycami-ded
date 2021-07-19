/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.opengl.EGL14
 *  android.opengl.EGLConfig
 *  android.opengl.EGLContext
 *  android.opengl.EGLDisplay
 *  android.opengl.EGLExt
 *  android.opengl.EGLSurface
 *  android.util.Log
 *  android.view.Surface
 */
package d.v.b0.f.c.b;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.util.Log;
import android.view.Surface;

public final class b {
    private static final String e = "GlUtil";
    public static final int f = 1;
    public static final int g = 2;
    private static final int h = 12610;
    private EGLDisplay a;
    private EGLContext b;
    private EGLConfig c;
    private int d;

    public b() {
        this(null, 0);
    }

    public b(EGLContext object, int n10) {
        int n11;
        Object object2;
        EGLDisplay eGLDisplay;
        this.a = eGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.b = object2 = EGL14.EGL_NO_CONTEXT;
        int n12 = 0;
        object2 = null;
        this.c = null;
        this.d = n11 = -1;
        EGLDisplay eGLDisplay2 = EGL14.EGL_NO_DISPLAY;
        if (eGLDisplay == eGLDisplay2) {
            if (object == null) {
                object = EGL14.EGL_NO_CONTEXT;
            }
            eGLDisplay = null;
            this.a = eGLDisplay2 = EGL14.eglGetDisplay((int)0);
            EGLDisplay eGLDisplay3 = EGL14.EGL_NO_DISPLAY;
            if (eGLDisplay2 != eGLDisplay3) {
                int n13 = 2;
                Object object3 = new int[n13];
                int n14 = 1;
                n11 = (int)(EGL14.eglInitialize((EGLDisplay)eGLDisplay2, (int[])object3, (int)0, (int[])object3, (int)n14) ? 1 : 0);
                if (n11 != 0) {
                    Object object4;
                    n12 = n10 & 2;
                    n11 = 3;
                    if (n12 != 0 && (object2 = this.d(n10, n11)) != null) {
                        int n15;
                        Object object5 = object3 = new int[n11];
                        object3[0] = 12440;
                        object5[1] = 3;
                        object5[2] = 12344;
                        EGLDisplay eGLDisplay4 = this.a;
                        object3 = EGL14.eglCreateContext((EGLDisplay)eGLDisplay4, (EGLConfig)object2, (EGLContext)object, (int[])object3, (int)0);
                        int n16 = EGL14.eglGetError();
                        if (n16 == (n15 = 12288)) {
                            this.c = object2;
                            this.b = (EGLContext)object3;
                            this.d = n11;
                        }
                    }
                    if ((object2 = this.b) == (object3 = (Object)EGL14.EGL_NO_CONTEXT)) {
                        object4 = this.d(n10, n13);
                        if (object4 != null) {
                            Object object6 = object2 = (Object)new int[n11];
                            object6[0] = (EGLContext)12440;
                            object6[1] = (EGLContext)2;
                            object6[2] = (EGLContext)12344;
                            eGLDisplay2 = this.a;
                            object = EGL14.eglCreateContext((EGLDisplay)eGLDisplay2, (EGLConfig)object4, (EGLContext)object, (int[])object2, (int)0);
                            object2 = "eglCreateContext";
                            this.a((String)object2);
                            this.c = object4;
                            this.b = object;
                            this.d = n13;
                        } else {
                            super("Unable to find a suitable EGLConfig");
                            throw object;
                        }
                    }
                    object = new int[n14];
                    object4 = this.a;
                    object2 = this.b;
                    EGL14.eglQueryContext((EGLDisplay)object4, (EGLContext)object2, (int)12440, (int[])object, (int)0);
                    super();
                    ((StringBuilder)object4).append("EGLContext created, client version ");
                    EGLContext eGLContext = object[0];
                    ((StringBuilder)object4).append((int)eGLContext);
                    object = ((StringBuilder)object4).toString();
                    Log.d((String)e, (String)object);
                    return;
                }
                this.a = null;
                super("unable to initialize EGL14");
                throw object;
            }
            super("unable to get EGL14 display");
            throw object;
        }
        super("EGL already set up");
        throw object;
    }

    private void a(String string2) {
        int n10;
        int n11 = EGL14.eglGetError();
        if (n11 != (n10 = 12288)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(": EGL error: 0x");
            string2 = Integer.toHexString(n11);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            String string3 = e;
            Log.e((String)string3, (String)string2);
        }
    }

    private EGLConfig d(int n10, int n11) {
        int n12;
        int n13;
        int n14 = 3;
        int n15 = 4;
        int n16 = n11 >= n14 ? 68 : n15;
        int[] nArray = new int[13];
        nArray[0] = 12324;
        int n17 = 1;
        nArray[n17] = n13 = 8;
        int n18 = 2;
        nArray[n18] = n12 = 12323;
        nArray[n14] = n13;
        nArray[n15] = 12322;
        nArray[5] = n13;
        nArray[6] = 12321;
        nArray[7] = n13;
        nArray[n13] = 12352;
        nArray[9] = n16;
        n14 = 10;
        nArray[n14] = n15 = 12344;
        n16 = 11;
        nArray[n16] = 0;
        n13 = 12;
        nArray[n13] = n15;
        if ((n10 &= n17) != 0) {
            nArray[n14] = n10 = 12610;
            nArray[n16] = n17;
        }
        Object object = new EGLConfig[n17];
        int[] nArray2 = new int[n17];
        EGLDisplay eGLDisplay = this.a;
        n18 = 0;
        int n19 = 1;
        n14 = (int)(EGL14.eglChooseConfig((EGLDisplay)eGLDisplay, (int[])nArray, (int)0, (EGLConfig[])object, (int)0, (int)n19, (int[])nArray2, (int)0) ? 1 : 0);
        if (n14 == 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append("unable to find RGB8888 / ");
            ((StringBuilder)object).append(n11);
            ((StringBuilder)object).append(" EGLConfig");
            object = ((StringBuilder)object).toString();
            Log.w((String)e, (String)object);
            return null;
        }
        return object[0];
    }

    public static void g(String string2) {
        EGLDisplay eGLDisplay = EGL14.eglGetCurrentDisplay();
        EGLContext eGLContext = EGL14.eglGetCurrentContext();
        EGLSurface eGLSurface = EGL14.eglGetCurrentSurface((int)12377);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Current EGL (");
        stringBuilder.append(string2);
        stringBuilder.append("): display=");
        stringBuilder.append(eGLDisplay);
        stringBuilder.append(", context=");
        stringBuilder.append(eGLContext);
        stringBuilder.append(", surface=");
        stringBuilder.append(eGLSurface);
        string2 = stringBuilder.toString();
        Log.i((String)e, (String)string2);
    }

    public EGLSurface b(int n10, int n11) {
        int n12;
        int n13 = 5;
        Object object = new int[n13];
        object[0] = 12375;
        object[1] = n10;
        object[2] = n12 = 12374;
        object[3] = n11;
        n10 = 4;
        object[n10] = n11 = 12344;
        EGLDisplay eGLDisplay = this.a;
        Object object2 = this.c;
        eGLDisplay = EGL14.eglCreatePbufferSurface((EGLDisplay)eGLDisplay, (EGLConfig)object2, (int[])object, (int)0);
        object2 = "eglCreatePbufferSurface";
        this.a((String)object2);
        if (eGLDisplay == null) {
            object = e;
            Log.e((String)object, (String)object2);
        }
        return eGLDisplay;
    }

    public EGLSurface c(Object object) {
        int n10;
        String string2;
        Object object2;
        int n11 = object instanceof Surface;
        String string3 = e;
        if (n11 == 0 && (n11 = object instanceof SurfaceTexture) == 0) {
            object2 = new StringBuilder;
            ((StringBuilder)object2)();
            string2 = "invalid surface: ";
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(object);
            object2 = ((StringBuilder)object2).toString();
            Log.e((String)string3, (String)object2);
        }
        n11 = 1;
        object2 = new int[n11];
        object2[0] = n10 = 12344;
        string2 = this.a;
        EGLConfig eGLConfig = this.c;
        object = EGL14.eglCreateWindowSurface((EGLDisplay)string2, (EGLConfig)eGLConfig, (Object)object, (int[])object2, (int)0);
        object2 = "eglCreateWindowSurface";
        this.a((String)object2);
        if (object == null) {
            object2 = "surface was null";
            Log.e((String)string3, (String)object2);
        }
        return object;
    }

    public int e() {
        return this.d;
    }

    public boolean f(EGLSurface eGLSurface) {
        boolean bl2;
        EGLContext eGLContext = this.b;
        EGLContext eGLContext2 = EGL14.eglGetCurrentContext();
        int n10 = eGLContext.equals((Object)eGLContext2);
        if (n10 != 0 && (bl2 = eGLSurface.equals((Object)(eGLContext = EGL14.eglGetCurrentSurface((int)(n10 = 12377)))))) {
            bl2 = true;
        } else {
            bl2 = false;
            eGLSurface = null;
        }
        return bl2;
    }

    public void finalize() {
        block5: {
            Object object = this.a;
            Object object2 = EGL14.EGL_NO_DISPLAY;
            if (object == object2) break block5;
            object = e;
            object2 = "WARNING: EglCore was not explicitly released -- state may be leaked";
            Log.w((String)object, (String)object2);
            this.m();
        }
        return;
        finally {
            super.finalize();
        }
    }

    public void h(EGLSurface object) {
        boolean bl2;
        Object object2 = this.a;
        EGLDisplay eGLDisplay = EGL14.EGL_NO_DISPLAY;
        String string2 = e;
        if (object2 == eGLDisplay) {
            object2 = "NOTE: makeCurrent w/o display";
            Log.d((String)string2, (String)object2);
        }
        if (!(bl2 = EGL14.eglMakeCurrent((EGLDisplay)(object2 = this.a), (EGLSurface)object, (EGLSurface)object, (EGLContext)(eGLDisplay = this.b)))) {
            object = "eglMakeCurrent failed";
            Log.e((String)string2, (String)object);
        }
    }

    public void i(EGLSurface object, EGLSurface eGLSurface) {
        boolean bl2;
        Object object2 = this.a;
        EGLDisplay eGLDisplay = EGL14.EGL_NO_DISPLAY;
        String string2 = e;
        if (object2 == eGLDisplay) {
            object2 = "NOTE: makeCurrent w/o display";
            Log.d((String)string2, (String)object2);
        }
        if (!(bl2 = EGL14.eglMakeCurrent((EGLDisplay)(object2 = this.a), (EGLSurface)object, (EGLSurface)eGLSurface, (EGLContext)(eGLDisplay = this.b)))) {
            object = "eglMakeCurrent failed";
            Log.e((String)string2, (String)object);
        }
    }

    public void j() {
        Object object = this.a;
        Object object2 = EGL14.EGL_NO_SURFACE;
        EGLContext eGLContext = EGL14.EGL_NO_CONTEXT;
        boolean bl2 = EGL14.eglMakeCurrent((EGLDisplay)object, (EGLSurface)object2, (EGLSurface)object2, (EGLContext)eGLContext);
        if (!bl2) {
            object = e;
            object2 = "eglMakeCurrent failed";
            Log.e((String)object, (String)object2);
        }
    }

    public String k(int n10) {
        return EGL14.eglQueryString((EGLDisplay)this.a, (int)n10);
    }

    public int l(EGLSurface eGLSurface, int n10) {
        int[] nArray = new int[1];
        EGL14.eglQuerySurface((EGLDisplay)this.a, (EGLSurface)eGLSurface, (int)n10, (int[])nArray, (int)0);
        return nArray[0];
    }

    public void m() {
        EGLDisplay eGLDisplay = this.a;
        EGLDisplay eGLDisplay2 = EGL14.EGL_NO_DISPLAY;
        if (eGLDisplay != eGLDisplay2) {
            eGLDisplay2 = EGL14.EGL_NO_SURFACE;
            EGLContext eGLContext = EGL14.EGL_NO_CONTEXT;
            EGL14.eglMakeCurrent((EGLDisplay)eGLDisplay, (EGLSurface)eGLDisplay2, (EGLSurface)eGLDisplay2, (EGLContext)eGLContext);
            eGLDisplay = this.a;
            eGLDisplay2 = this.b;
            EGL14.eglDestroyContext((EGLDisplay)eGLDisplay, (EGLContext)eGLDisplay2);
            EGL14.eglReleaseThread();
            eGLDisplay = this.a;
            EGL14.eglTerminate((EGLDisplay)eGLDisplay);
        }
        this.a = eGLDisplay = EGL14.EGL_NO_DISPLAY;
        eGLDisplay = EGL14.EGL_NO_CONTEXT;
        this.b = eGLDisplay;
        this.c = null;
    }

    public void n(EGLSurface eGLSurface) {
        EGL14.eglDestroySurface((EGLDisplay)this.a, (EGLSurface)eGLSurface);
    }

    public void o(EGLSurface eGLSurface, long l10) {
        EGLExt.eglPresentationTimeANDROID((EGLDisplay)this.a, (EGLSurface)eGLSurface, (long)l10);
    }

    public boolean p(EGLSurface eGLSurface) {
        return EGL14.eglSwapBuffers((EGLDisplay)this.a, (EGLSurface)eGLSurface);
    }
}

