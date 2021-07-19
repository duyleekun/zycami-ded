/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.opengl.i;

public class h
extends i {
    private int r;
    private float s;

    public h() {
        this(1.2f);
    }

    public h(float f10) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform lowp float gamma;\n \n void main()\n {\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n     gl_FragColor = vec4(pow(textureColor.rgb, vec3(gamma)), textureColor.w);\n }");
        this.s = f10;
    }

    public void a(float f10) {
        this.s = f10;
        int n10 = this.r;
        this.a(n10, f10);
    }

    public boolean b() {
        int n10;
        boolean bl2 = super.b();
        this.r = n10 = GLES20.glGetUniformLocation((int)this.q(), (String)"gamma");
        return bl2;
    }

    public void c() {
        super.c();
        float f10 = this.s;
        this.a(f10);
    }
}

