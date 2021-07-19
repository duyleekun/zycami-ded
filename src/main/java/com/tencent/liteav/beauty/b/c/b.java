/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.tencent.liteav.beauty.b.c;

import android.opengl.GLES20;
import com.tencent.liteav.beauty.b.t;

public class b
extends t {
    private int r;
    private int s;

    public b() {
        super(" attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n \n varying vec2 textureCoordinate;\n \n void main(void)\n {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n }\n", " varying highp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n \n void main()\n {\n     lowp vec3 iColor = texture2D(inputImageTexture, textureCoordinate).rgb;\n     lowp vec3 meanColor = texture2D(inputImageTexture2, textureCoordinate).rgb;\n     highp vec3 diffColor = (iColor - meanColor) * 7.07;\n     diffColor = min(diffColor * diffColor, 1.0);\n     gl_FragColor = vec4(diffColor, 1.0);\n }\n");
    }

    public void a(int n10, int n11) {
        float f10 = Math.min(n10, n11);
        float f11 = 360.0f / f10;
        f10 = Math.min(1.0f, f11);
        this.r = n10 = Math.round((float)n10 * f10);
        this.s = n10 = Math.round((float)n11 * f10);
        n11 = this.r;
        super.a(n11, n10);
    }

    public int b(int n10) {
        int n11 = this.r;
        int n12 = this.s;
        GLES20.glViewport((int)0, (int)0, (int)n11, (int)n12);
        n11 = this.m;
        n12 = this.n;
        return super.a(n10, n11, n12);
    }
}

