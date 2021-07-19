/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.opengl.GLES20
 */
package com.tencent.liteav.beauty.b;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.liteav.basic.opengl.i;
import com.tencent.liteav.beauty.b.m$1;
import java.nio.FloatBuffer;

public class m
extends i {
    private int A;
    private float[] B;
    private int C;
    private float[] D;
    private float r;
    private Bitmap s;
    private int t;
    private int u;
    private float v;
    private Bitmap w;
    private int x;
    private int y;
    private float z;

    public m() {
        int n10;
        this.u = n10 = -1;
        this.y = n10;
    }

    public m(float f10, Bitmap bitmap, float f11, Bitmap bitmap2, float f12) {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2; // lookup texture 1\n uniform sampler2D inputImageTexture3; // lookup texture 2\n \n \n uniform lowp vec3 v3_params;\n uniform lowp vec2 v2_texs;\n \n \n void main()\n {\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n     mediump float blueColor = textureColor.b * 63.0;\n     \n     mediump vec2 quad1;\n     quad1.y = floor(floor(blueColor) / 8.0);\n     quad1.x = floor(blueColor) - (quad1.y * 8.0);\n     \n     mediump vec2 quad2;\n     quad2.y = floor(ceil(blueColor) / 8.0);\n     quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n     \n     highp vec2 texPos1;\n     texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\n     texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\n     \n     highp vec2 texPos2;\n     texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\n     texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\n     \n     lowp vec4 newColor1;\n     lowp vec4 newColor2;\n     if(textureCoordinate.x <= v3_params.x) { \n       if(v2_texs.x == 1.0) { \n         newColor1 = texture2D(inputImageTexture2, texPos1);\n         newColor2 = texture2D(inputImageTexture2, texPos2);\n         lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n         gl_FragColor = mix(textureColor, vec4(newColor.rgb, textureColor.w), v3_params.y);\n       } else { \n         gl_FragColor = textureColor;\n       } \n     } else {\n       if(v2_texs.y == 1.0) { \n         newColor1 = texture2D(inputImageTexture3, texPos1);\n         newColor2 = texture2D(inputImageTexture3, texPos2);\n         lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n         gl_FragColor = mix(textureColor, vec4(newColor.rgb, textureColor.w), v3_params.z);\n       } else { \n         gl_FragColor = textureColor;\n       } \n     }\n }");
        float[] fArray = new float[3];
        this.B = fArray;
        fArray = new float[2];
        this.D = fArray;
        this.r = f10;
        this.s = bitmap;
        this.w = bitmap2;
        this.v = f11;
        this.z = f12;
    }

    public m(String string2, String string3) {
        super(string2, string3);
        int n10;
        this.u = n10 = -1;
        this.y = n10;
    }

    public static /* synthetic */ int a(m m10) {
        return m10.u;
    }

    public static /* synthetic */ int a(m m10, int n10) {
        m10.u = n10;
        return n10;
    }

    public static /* synthetic */ Bitmap a(m m10, Bitmap bitmap) {
        m10.s = bitmap;
        return bitmap;
    }

    public static /* synthetic */ int b(m m10, int n10) {
        m10.y = n10;
        return n10;
    }

    public static /* synthetic */ Bitmap b(m m10, Bitmap bitmap) {
        m10.w = bitmap;
        return bitmap;
    }

    public static /* synthetic */ float[] b(m m10) {
        return m10.D;
    }

    public static /* synthetic */ int c(m m10) {
        return m10.y;
    }

    public void a(float f10) {
        float f11 = this.r;
        this.a(f11, f10, 0.0f);
    }

    public void a(float f10, float f11, float f12) {
        this.r = f10;
        this.v = f11;
        this.z = f12;
        float[] fArray = this.B;
        fArray[0] = f10;
        fArray[1] = f11;
        fArray[2] = f12;
    }

    public void a(float f10, Bitmap bitmap, float f11, Bitmap bitmap2, float f12) {
        this.a(f10, f11, f12);
        m$1 m$1 = new m$1(this, bitmap, bitmap2);
        this.a(m$1);
    }

    public boolean b() {
        int n10;
        this.t = n10 = GLES20.glGetUniformLocation((int)this.q(), (String)"inputImageTexture2");
        this.x = n10 = GLES20.glGetUniformLocation((int)this.q(), (String)"inputImageTexture3");
        this.A = n10 = GLES20.glGetUniformLocation((int)this.q(), (String)"v3_params");
        this.C = n10 = GLES20.glGetUniformLocation((int)this.q(), (String)"v2_texs");
        return super.b();
    }

    public void c() {
        super.c();
        float f10 = this.r;
        Bitmap bitmap = this.s;
        float f11 = this.v;
        Bitmap bitmap2 = this.w;
        float f12 = this.z;
        this.a(f10, bitmap, f11, bitmap2, f12);
    }

    public void e() {
        int n10;
        super.e();
        int n11 = 2;
        int[] nArray = new int[n11];
        nArray[0] = n10 = this.u;
        nArray[1] = n10 = this.y;
        GLES20.glDeleteTextures((int)n11, (int[])nArray, (int)0);
        this.u = n11 = -1;
        this.y = n11;
    }

    public void i() {
        int n10 = this.u;
        int n11 = 3553;
        int n12 = -1;
        if (n10 != n12) {
            GLES20.glActiveTexture((int)33987);
            n10 = this.u;
            GLES20.glBindTexture((int)n11, (int)n10);
            n10 = this.t;
            int n13 = 3;
            GLES20.glUniform1i((int)n10, (int)n13);
        }
        if ((n10 = this.y) != n12) {
            GLES20.glActiveTexture((int)33988);
            n10 = this.y;
            GLES20.glBindTexture((int)n11, (int)n10);
            n10 = this.x;
            n11 = 4;
            GLES20.glUniform1i((int)n10, (int)n11);
        }
        n10 = this.C;
        FloatBuffer floatBuffer = FloatBuffer.wrap(this.D);
        n12 = 1;
        GLES20.glUniform2fv((int)n10, (int)n12, (FloatBuffer)floatBuffer);
        n10 = this.A;
        floatBuffer = FloatBuffer.wrap(this.B);
        GLES20.glUniform3fv((int)n10, (int)n12, (FloatBuffer)floatBuffer);
    }

    public void j() {
        int n10 = this.u;
        int n11 = 33984;
        int n12 = 3553;
        int n13 = -1;
        if (n10 != n13) {
            n10 = 33987;
            GLES20.glActiveTexture((int)n10);
            GLES20.glBindTexture((int)n12, (int)0);
            GLES20.glActiveTexture((int)n11);
        }
        if ((n10 = this.y) != n13) {
            n10 = 33988;
            GLES20.glActiveTexture((int)n10);
            GLES20.glBindTexture((int)n12, (int)0);
            GLES20.glActiveTexture((int)n11);
        }
    }
}

