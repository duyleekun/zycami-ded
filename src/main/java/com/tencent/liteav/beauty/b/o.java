/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.i;
import com.tencent.liteav.beauty.NativeLoad;

public class o
extends i {
    private static float[] C;
    private static float[] D;
    private static float[] E;
    private String A;
    private int B;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    static {
        float[] fArray;
        float[] fArray2;
        int n10 = 9;
        float[] fArray3 = fArray2 = new float[n10];
        float[] fArray4 = fArray2;
        fArray3[0] = 0.1826f;
        fArray4[1] = 0.6142f;
        fArray3[2] = 0.062f;
        fArray4[3] = -0.1006f;
        fArray3[4] = -0.3386f;
        fArray4[5] = 0.4392f;
        fArray3[6] = 0.4392f;
        fArray4[7] = -0.3989f;
        fArray4[8] = -0.0403f;
        C = fArray2;
        float[] fArray5 = fArray = new float[n10];
        float[] fArray6 = fArray;
        fArray5[0] = 0.256816f;
        fArray6[1] = 0.504154f;
        fArray5[2] = 0.0979137f;
        fArray6[3] = -0.148246f;
        fArray5[4] = -0.29102f;
        fArray6[5] = 0.439266f;
        fArray5[6] = 0.439271f;
        fArray6[7] = -0.367833f;
        fArray6[8] = -0.071438f;
        D = fArray;
        float[] fArray7 = fArray = new float[3];
        fArray[0] = 0.0625f;
        fArray7[1] = 0.5f;
        fArray7[2] = 0.5f;
        E = fArray;
    }

    public o(int n10) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        int n11;
        this.r = n11 = -1;
        this.s = n11;
        this.t = n11;
        this.u = n11;
        this.v = n11;
        this.w = n11;
        this.x = n11;
        this.y = n11;
        this.z = n11;
        this.A = "RGBA2I420Filter";
        this.B = 1;
        this.B = n10;
    }

    public void a(int n10, int n11) {
        if (n10 > 0 && n11 > 0) {
            int n12 = this.f;
            if (n12 == n11 && (n12 = this.e) == n10) {
                return;
            }
            super.a(n10, n11);
            String string2 = this.A;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("RGBA2I420Filter width ");
            charSequence.append(n10);
            charSequence.append(" height ");
            charSequence.append(n11);
            charSequence = charSequence.toString();
            TXCLog.i(string2, (String)charSequence);
            n12 = this.r;
            float f10 = n10;
            this.a(n12, f10);
            n10 = this.s;
            float f11 = n11;
            this.a(n10, f11);
            return;
        }
        TXCLog.e(this.A, "width or height is error!");
    }

    public boolean a() {
        String string2;
        int n10 = this.B;
        int n11 = 8;
        int n12 = 1;
        if (n12 == n10) {
            this.a = n10 = NativeLoad.nativeLoadGLProgram(n11);
            string2 = this.A;
            String string3 = "RGB-->I420 init!";
            TXCLog.i(string2, string3);
        } else {
            int n13 = 3;
            if (n13 == n10) {
                string2 = this.A;
                String string4 = "RGB-->NV21 init!";
                TXCLog.i(string2, string4);
                this.a = n10 = NativeLoad.nativeLoadGLProgram(11);
            } else {
                n13 = 2;
                if (n13 == n10) {
                    TXCLog.i(this.A, "RGBA Format init!");
                    return super.a();
                }
                string2 = this.A;
                CharSequence charSequence = new StringBuilder();
                charSequence.append("don't support format ");
                int n14 = this.B;
                charSequence.append(n14);
                String string5 = " use default I420";
                charSequence.append(string5);
                charSequence = charSequence.toString();
                TXCLog.i(string2, (String)charSequence);
                this.a = n10 = NativeLoad.nativeLoadGLProgram(n11);
            }
        }
        n10 = this.a;
        if (n10 != 0 && (n10 = (int)(this.b() ? 1 : 0)) != 0) {
            this.g = n12;
        } else {
            n10 = 0;
            string2 = null;
            this.g = false;
        }
        this.c();
        return this.g;
    }

    public boolean b() {
        int n10;
        super.b();
        this.r = n10 = GLES20.glGetUniformLocation((int)this.a, (String)"width");
        this.s = n10 = GLES20.glGetUniformLocation((int)this.a, (String)"height");
        return true;
    }

    public void c() {
        super.c();
    }
}

