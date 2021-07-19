/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.TXCOpenGlUtils;
import com.tencent.liteav.basic.opengl.i;
import com.tencent.liteav.beauty.NativeLoad;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class k
extends i {
    private static String y = "YUV420pToRGBFilter";
    private ByteBuffer r = null;
    private final int s;
    private int[] t = null;
    private int[] u = null;
    private int v = 0;
    private int w = 0;
    private int[] x = null;

    public k(int n10) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        this.s = n10;
        String string2 = y;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("yuv Type ");
        stringBuilder.append(n10);
        String string3 = stringBuilder.toString();
        TXCLog.i(string2, string3);
    }

    private int s() {
        int[] nArray = this.x;
        int n10 = nArray[0];
        int n11 = 3553;
        GLES20.glBindTexture((int)n11, (int)n10);
        ByteBuffer byteBuffer = this.r;
        if (byteBuffer != null) {
            int n12 = 3553;
            int n13 = 6408;
            int n14 = this.e;
            int n15 = this.f;
            int n16 = 6408;
            int n17 = 5121;
            GLES20.glTexImage2D((int)n12, (int)0, (int)n13, (int)n14, (int)n15, (int)0, (int)n16, (int)n17, (Buffer)byteBuffer);
        }
        return this.x[0];
    }

    private void t() {
        int n10;
        int[] nArray = this.t;
        int n11 = 1;
        if (nArray != null && (n10 = nArray[0]) > 0) {
            GLES20.glDeleteTextures((int)n11, (int[])nArray, (int)0);
            this.t = null;
        }
        if ((nArray = this.u) != null && (n10 = nArray[0]) > 0) {
            GLES20.glDeleteTextures((int)n11, (int[])nArray, (int)0);
            this.u = null;
        }
        if ((nArray = this.x) != null && (n10 = nArray[0]) > 0) {
            GLES20.glDeleteTextures((int)n11, (int[])nArray, (int)0);
            this.x = null;
        }
    }

    public void a(int n10, int n11) {
        int n12;
        int n13 = this.f;
        if (n13 == n11 && (n13 = this.e) == n10) {
            return;
        }
        this.t();
        int[] nArray = this.t;
        int n14 = 6409;
        int n15 = 1;
        if (nArray == null) {
            this.t = nArray = new int[n15];
            nArray[0] = n12 = TXCOpenGlUtils.a(n10, n11, n14, n14, nArray);
        }
        n13 = this.q();
        String string2 = "yTexture";
        this.v = n13 = GLES20.glGetUniformLocation((int)n13, (String)string2);
        n13 = this.q();
        String string3 = "uvTexture";
        this.w = n13 = GLES20.glGetUniformLocation((int)n13, (String)string3);
        n13 = this.s;
        if (n15 == n13) {
            nArray = new int[n15];
            this.u = nArray;
            n15 = n11 / 2;
            nArray[0] = n14 = TXCOpenGlUtils.a(n10, n15, n14, n14, nArray);
        } else {
            n14 = 3;
            if (n14 == n13) {
                this.v = n13 = GLES20.glGetUniformLocation((int)this.q(), (String)string2);
                this.w = n13 = GLES20.glGetUniformLocation((int)this.q(), (String)string3);
                nArray = new int[n15];
                this.u = nArray;
                n14 = n10 / 2;
                n15 = n11 / 2;
                n12 = 6410;
                nArray[0] = n14 = TXCOpenGlUtils.a(n14, n15, n12, n12, nArray);
            } else {
                n14 = 2;
                if (n14 == n13 && (nArray = this.x) == null) {
                    nArray = new int[n15];
                    this.x = nArray;
                    n14 = 6408;
                    nArray[0] = n14 = TXCOpenGlUtils.a(n10, n11, n14, n14, nArray);
                }
            }
        }
        super.a(n10, n11);
    }

    public void a(int n10, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        super.a(-1, floatBuffer, floatBuffer2);
    }

    public void a(ByteBuffer byteBuffer) {
        this.r = byteBuffer;
    }

    public void a(byte[] object) {
        if (object != null) {
            object = ByteBuffer.wrap(object);
            this.r = object;
        }
    }

    public boolean a() {
        String string2;
        int n10 = this.s;
        int n11 = 1;
        int n12 = 7;
        if (n10 != n11) {
            int n13 = 3;
            if (n10 == n13) {
                n12 = 9;
            } else {
                n13 = 2;
                if (n10 == n13) {
                    return super.a();
                }
                string2 = y;
                CharSequence charSequence = new StringBuilder();
                String string3 = "don't support yuv format ";
                charSequence.append(string3);
                int n14 = this.s;
                charSequence.append(n14);
                charSequence = charSequence.toString();
                TXCLog.e(string2, (String)charSequence);
            }
        }
        this.a = n10 = NativeLoad.nativeLoadGLProgram(n12);
        if (n10 != 0 && (n10 = (int)(this.b() ? 1 : 0)) != 0) {
            this.g = n11;
        } else {
            n10 = 0;
            string2 = null;
            this.g = false;
        }
        this.c();
        return this.g;
    }

    public void e() {
        super.e();
        this.t();
    }

    public void i() {
        int[] nArray;
        super.i();
        int n10 = this.e;
        int n11 = 4;
        int n12 = 3317;
        int n13 = 1;
        if ((n10 %= n11) != 0) {
            nArray = new int[n13];
            GLES20.glGetIntegerv((int)n12, (int[])nArray, (int)0);
            GLES20.glPixelStorei((int)n12, (int)n13);
        } else {
            n10 = 0;
            nArray = null;
        }
        int n14 = this.s;
        int n15 = 2;
        if (n15 == n14) {
            this.s();
        } else {
            int n16;
            ByteBuffer byteBuffer = this.r;
            n14 = n14 == n13 ? 6409 : 6410;
            int n17 = this.e;
            int n18 = this.f;
            int[] nArray2 = new int[n15];
            nArray2[0] = n16 = this.t[0];
            int[] nArray3 = this.u;
            nArray2[n13] = n16 = nArray3[0];
            TXCOpenGlUtils.a(byteBuffer, n14, n17, n18, nArray2);
            GLES20.glActiveTexture((int)33984);
            n14 = this.t[0];
            n15 = 3553;
            GLES20.glBindTexture((int)n15, (int)n14);
            GLES20.glUniform1i((int)this.v, (int)0);
            GLES20.glActiveTexture((int)33985);
            int[] nArray4 = this.u;
            n14 = nArray4[0];
            GLES20.glBindTexture((int)n15, (int)n14);
            n14 = this.w;
            GLES20.glUniform1i((int)n14, (int)n13);
        }
        n13 = this.e % n11;
        if (n13 != 0) {
            if (nArray != null && (n13 = nArray[0]) > 0) {
                n10 = nArray[0];
                GLES20.glPixelStorei((int)n12, (int)n10);
            } else {
                GLES20.glPixelStorei((int)n12, (int)n11);
            }
        }
    }

    public int r() {
        int n10 = 2;
        int n11 = this.s;
        if (n10 == n11) {
            n11 = this.s();
            GLES20.glBindTexture((int)3553, (int)0);
            return n11;
        }
        return super.b(-1);
    }
}

