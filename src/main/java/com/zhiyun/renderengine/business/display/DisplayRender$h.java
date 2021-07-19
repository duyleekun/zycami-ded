/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.opengl.EGL14
 *  android.opengl.EGLContext
 */
package com.zhiyun.renderengine.business.display;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import com.zhiyun.renderengine.business.display.DisplayRender;
import com.zhiyun.renderengine.engine.IRenderEngine;
import d.v.b0.c.c.c;
import d.v.b0.c.e.b;

public class DisplayRender$h
implements Runnable {
    public final /* synthetic */ byte[] a;
    public final /* synthetic */ b b;
    public final /* synthetic */ DisplayRender c;

    public DisplayRender$h(DisplayRender displayRender, byte[] byArray, b b10) {
        this.c = displayRender;
        this.a = byArray;
        this.b = b10;
    }

    public void run() {
        Object object;
        Object object2;
        Object object3;
        c c10 = DisplayRender.y(this.c);
        if (c10 == null) {
            c10 = EGL14.eglGetCurrentContext();
            object3 = this.c;
            object2 = DisplayRender.A(this.c);
            Context context = DisplayRender.u(this.c);
            object = new c((EGLContext)c10, (IRenderEngine)object2, context);
            DisplayRender.z((DisplayRender)object3, (c)object);
            c10 = DisplayRender.y(this.c);
            c10.start();
        }
        c10 = DisplayRender.y(this.c);
        object3 = this.a;
        object = DisplayRender.C(this.c);
        object2 = this.b;
        c10.d((byte[])object3, object, (b)object2);
    }
}

