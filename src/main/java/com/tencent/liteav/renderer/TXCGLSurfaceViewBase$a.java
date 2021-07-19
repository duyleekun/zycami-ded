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
import com.tencent.liteav.renderer.TXCGLSurfaceViewBase$e;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

public abstract class TXCGLSurfaceViewBase$a
implements TXCGLSurfaceViewBase$e {
    public int[] a;
    public final /* synthetic */ TXCGLSurfaceViewBase b;

    public TXCGLSurfaceViewBase$a(TXCGLSurfaceViewBase object, int[] nArray) {
        this.b = object;
        object = this.a(nArray);
        this.a = (int[])object;
    }

    private int[] a(int[] nArray) {
        int n10;
        TXCGLSurfaceViewBase tXCGLSurfaceViewBase = this.b;
        int n11 = TXCGLSurfaceViewBase.h(tXCGLSurfaceViewBase);
        if (n11 != (n10 = 2)) {
            return nArray;
        }
        n11 = nArray.length;
        int[] nArray2 = new int[n11 + 2];
        int n12 = n11 + -1;
        System.arraycopy(nArray, 0, nArray2, 0, n12);
        nArray2[n12] = 12352;
        nArray2[n11] = 4;
        nArray2[++n11] = 12344;
        return nArray2;
    }

    public EGLConfig a(EGL10 object, EGLDisplay eGLDisplay) {
        int n10 = 1;
        int[] nArray = new int[n10];
        int[] nArray2 = this.a;
        int n11 = 0;
        boolean bl2 = object.eglChooseConfig(eGLDisplay, nArray2, null, 0, nArray);
        if (bl2) {
            bl2 = false;
            n11 = nArray[0];
            if (n11 > 0) {
                nArray2 = this.a;
                EGLConfig[] eGLConfigArray = new EGLConfig[n11];
                n10 = (int)(object.eglChooseConfig(eGLDisplay, nArray2, eGLConfigArray, n11, nArray) ? 1 : 0);
                if (n10 != 0) {
                    if ((object = this.a((EGL10)object, eGLDisplay, eGLConfigArray)) != null) {
                        return object;
                    }
                    object = new IllegalArgumentException("No config chosen");
                    throw object;
                }
                object = new IllegalArgumentException("eglChooseConfig#2 failed");
                throw object;
            }
            object = new IllegalArgumentException("No configs match configSpec");
            throw object;
        }
        object = new IllegalArgumentException("eglChooseConfig failed");
        throw object;
    }

    public abstract EGLConfig a(EGL10 var1, EGLDisplay var2, EGLConfig[] var3);
}

