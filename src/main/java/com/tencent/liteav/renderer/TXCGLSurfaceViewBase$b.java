/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  javax.microedition.khronos.egl.EGL10
 *  javax.microedition.khronos.egl.EGLConfig
 *  javax.microedition.khronos.egl.EGLDisplay
 */
package com.tencent.liteav.renderer;

import com.tencent.liteav.renderer.TXCGLSurfaceViewBase;
import com.tencent.liteav.renderer.TXCGLSurfaceViewBase$a;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

public class TXCGLSurfaceViewBase$b
extends TXCGLSurfaceViewBase$a {
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public final /* synthetic */ TXCGLSurfaceViewBase i;
    private int[] j;

    public TXCGLSurfaceViewBase$b(TXCGLSurfaceViewBase object, int n10, int n11, int n12, int n13, int n14, int n15) {
        this.i = object;
        int[] nArray = new int[13];
        nArray[0] = 12324;
        int n16 = 1;
        nArray[n16] = n10;
        nArray[2] = 12323;
        nArray[3] = n11;
        nArray[4] = 12322;
        nArray[5] = n12;
        nArray[6] = 12321;
        nArray[7] = n13;
        nArray[8] = 12325;
        nArray[9] = n14;
        nArray[10] = 12326;
        nArray[11] = n15;
        nArray[12] = 12344;
        super((TXCGLSurfaceViewBase)((Object)object), nArray);
        object = new int[n16];
        this.j = (int[])object;
        this.c = n10;
        this.d = n11;
        this.e = n12;
        this.f = n13;
        this.g = n14;
        this.h = n15;
    }

    private int a(EGL10 eGL10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int n10, int n11) {
        int[] nArray = this.j;
        boolean bl2 = eGL10.eglGetConfigAttrib(eGLDisplay, eGLConfig, n10, nArray);
        if (bl2) {
            return this.j[0];
        }
        return n11;
    }

    public EGLConfig a(EGL10 eGL10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArray) {
        for (EGLConfig eGLConfig : eGLConfigArray) {
            int n10 = this.a(eGL10, eGLDisplay, eGLConfig, 12325, 0);
            int n11 = 12326;
            int n12 = this.a(eGL10, eGLDisplay, eGLConfig, n11, 0);
            int n13 = this.g;
            if (n10 < n13 || n12 < (n13 = this.h)) continue;
            n10 = this.a(eGL10, eGLDisplay, eGLConfig, 12324, 0);
            int n14 = this.a(eGL10, eGLDisplay, eGLConfig, 12323, 0);
            int n15 = this.a(eGL10, eGLDisplay, eGLConfig, 12322, 0);
            n11 = 12321;
            n12 = this.a(eGL10, eGLDisplay, eGLConfig, n11, 0);
            n13 = this.c;
            if (n10 != n13 || n14 != (n13 = this.d) || n15 != (n13 = this.e) || n12 != (n13 = this.f)) continue;
            return eGLConfig;
        }
        return null;
    }
}

