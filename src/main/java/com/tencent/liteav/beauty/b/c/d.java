/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.tencent.liteav.beauty.b.c;

import android.opengl.GLES20;
import com.tencent.liteav.basic.opengl.i;

public class d
extends i {
    private final boolean r;
    private int s;
    private int t;
    private int u;
    private int v;

    public d(boolean bl2) {
        super(" attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n \n uniform float texelWidthOffset;\n uniform float texelHeightOffset;\n \n varying vec2 textureCoordinate;\n varying vec4 textureShift_1;\n varying vec4 textureShift_2;\n varying vec4 textureShift_3;\n varying vec4 textureShift_4;\n \n void main(void)\n {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n     \n     vec2 singleStepOffset = vec2(texelWidthOffset, texelHeightOffset);\n     textureShift_1 = vec4(textureCoordinate - singleStepOffset, textureCoordinate + singleStepOffset);\n     textureShift_2 = vec4(textureCoordinate - 2.0 * singleStepOffset, textureCoordinate + 2.0 * singleStepOffset);\n     textureShift_3 = vec4(textureCoordinate - 3.0 * singleStepOffset, textureCoordinate + 3.0 * singleStepOffset);\n     textureShift_4 = vec4(textureCoordinate - 4.0 * singleStepOffset, textureCoordinate + 4.0 * singleStepOffset);\n }\n", "uniform sampler2D inputImageTexture;\n varying highp vec2 textureCoordinate;\n varying highp vec4 textureShift_1;\n varying highp vec4 textureShift_2;\n varying highp vec4 textureShift_3;\n varying highp vec4 textureShift_4;\n \n void main()\n {\n     mediump vec3 sum = texture2D(inputImageTexture, textureCoordinate).rgb;\n     sum += texture2D(inputImageTexture, textureShift_1.xy).rgb;\n     sum += texture2D(inputImageTexture, textureShift_1.zw).rgb;\n     sum += texture2D(inputImageTexture, textureShift_2.xy).rgb;\n     sum += texture2D(inputImageTexture, textureShift_2.zw).rgb;\n     sum += texture2D(inputImageTexture, textureShift_3.xy).rgb;\n     sum += texture2D(inputImageTexture, textureShift_3.zw).rgb;\n     sum += texture2D(inputImageTexture, textureShift_4.xy).rgb;\n     sum += texture2D(inputImageTexture, textureShift_4.zw).rgb;\n     \n     gl_FragColor = vec4(sum * 0.1111, 1.0);\n }\n");
        int n10;
        this.s = n10 = -1;
        this.t = n10;
        this.r = bl2;
    }

    public void a(int n10, int n11) {
        float f10 = Math.min(n10, n11);
        int n12 = 1135869952;
        float f11 = 360.0f / f10;
        f10 = Math.min(1.0f, f11);
        this.u = n10 = Math.round((float)n10 * f10);
        float f12 = (float)n11 * f10;
        this.v = n10 = Math.round(f12);
        n11 = this.u;
        super.a(n11, n10);
        n10 = (int)(this.r ? 1 : 0);
        n11 = 0;
        float f13 = 0.0f;
        f10 = 1.5f;
        if (n10 != 0) {
            n10 = this.s;
            this.a(n10, 0.0f);
            n10 = this.t;
            n11 = this.v;
            f13 = n11;
            this.a(n10, f10 /= f13);
        } else {
            n10 = this.s;
            n12 = this.u;
            f11 = n12;
            this.a(n10, f10 /= f11);
            n10 = this.t;
            this.a(n10, 0.0f);
        }
    }

    public int b(int n10) {
        int n11 = this.u;
        int n12 = this.v;
        GLES20.glViewport((int)0, (int)0, (int)n11, (int)n12);
        n11 = this.m;
        n12 = this.n;
        return super.a(n10, n11, n12);
    }

    public boolean b() {
        int n10 = super.b();
        if (n10 == 0) {
            return false;
        }
        this.s = n10 = GLES20.glGetUniformLocation((int)this.q(), (String)"texelWidthOffset");
        this.t = n10 = GLES20.glGetUniformLocation((int)this.q(), (String)"texelHeightOffset");
        return true;
    }
}

