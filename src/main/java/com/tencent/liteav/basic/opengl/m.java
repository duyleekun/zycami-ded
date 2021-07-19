/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  javax.microedition.khronos.egl.EGLContext
 */
package com.tencent.liteav.basic.opengl;

import android.graphics.SurfaceTexture;
import com.tencent.liteav.basic.opengl.n;
import javax.microedition.khronos.egl.EGLContext;

public interface m {
    public void a();

    public void a(int var1, boolean var2);

    public void a(int var1, boolean var2, int var3, int var4, int var5, boolean var6);

    public void a(Runnable var1);

    public void a(boolean var1);

    public void a(byte[] var1);

    public EGLContext getGLContext();

    public SurfaceTexture getSurfaceTexture();

    public void setRendMirror(int var1);

    public void setRendMode(int var1);

    public void setSurfaceTextureListener(n var1);
}

