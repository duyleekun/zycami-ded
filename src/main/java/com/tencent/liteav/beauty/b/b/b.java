/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.tencent.liteav.beauty.b.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.opengl.i;
import com.tencent.liteav.beauty.NativeLoad;

public class b
extends i {
    private int r;
    private int s;
    private float[] t;
    private String u;

    public b() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        int n10;
        this.r = n10 = -1;
        this.s = n10;
        float[] fArray = new float[4];
        this.t = fArray;
        this.u = "Beauty3Filter";
    }

    private void b(float[] fArray) {
        int n10 = this.s;
        this.c(n10, fArray);
    }

    public void a(float f10) {
        float[] fArray = this.t;
        fArray[0] = f10;
        this.b(fArray);
    }

    public void a(int n10, int n11) {
        super.a(n10, n11);
        this.c(n10, n11);
    }

    public boolean a() {
        int n10;
        this.a = n10 = NativeLoad.nativeLoadGLProgram(14);
        if (n10 != 0 && (n10 = (int)(this.b() ? 1 : 0)) != 0) {
            n10 = 1;
            this.g = n10;
        } else {
            n10 = 0;
            this.g = false;
        }
        this.c();
        return this.g;
    }

    public void b(float f10) {
        float[] fArray = this.t;
        fArray[1] = f10;
        this.b(fArray);
    }

    public boolean b() {
        int n10;
        boolean bl2 = super.b();
        this.r = n10 = GLES20.glGetUniformLocation((int)this.q(), (String)"singleStepOffset");
        this.s = n10 = GLES20.glGetUniformLocation((int)this.q(), (String)"beautyParams");
        this.a(5.0f);
        return bl2;
    }

    public void c(float f10) {
        float[] fArray = this.t;
        fArray[2] = f10;
        this.b(fArray);
    }

    public void c(int n10, int n11) {
        int n12 = this.r;
        float[] fArray = new float[2];
        float f10 = n10;
        float f11 = 2.0f;
        fArray[0] = f10 = f11 / f10;
        f10 = n11;
        fArray[1] = f11 /= f10;
        this.a(n12, fArray);
    }
}

