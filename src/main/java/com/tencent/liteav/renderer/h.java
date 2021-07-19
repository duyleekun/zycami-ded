/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 *  android.opengl.Matrix
 */
package com.tencent.liteav.renderer;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.liteav.basic.log.TXCLog;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class h {
    public static int a = 1;
    public static int b = 2;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g;
    private int h;
    private boolean i;
    private float[] j;
    private float[] k;
    private float l;
    private float m;
    private boolean n;
    private boolean o;
    private final float[] p;
    private FloatBuffer q;
    private float[] r;
    private float[] s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    public h(Boolean comparable) {
        boolean bl2;
        float f10;
        int n10;
        this.g = n10 = b;
        this.h = 0;
        this.i = false;
        n10 = 16;
        float[] fArray = new float[n10];
        this.j = fArray;
        fArray = new float[n10];
        this.k = fArray;
        this.l = f10 = 1.0f;
        this.m = f10;
        this.n = false;
        this.o = true;
        float[] fArray2 = fArray = new float[20];
        float[] fArray3 = fArray;
        fArray2[0] = -1.0f;
        fArray3[1] = -1.0f;
        fArray2[2] = 0.0f;
        fArray3[3] = 0.0f;
        fArray2[4] = 0.0f;
        fArray3[5] = 1.0f;
        fArray2[6] = -1.0f;
        fArray3[7] = 0.0f;
        fArray2[8] = 1.0f;
        fArray3[9] = 0.0f;
        fArray2[10] = -1.0f;
        fArray3[11] = 1.0f;
        fArray2[12] = 0.0f;
        fArray3[13] = 0.0f;
        fArray2[14] = 1.0f;
        fArray3[15] = 1.0f;
        fArray2[16] = 1.0f;
        fArray3[17] = 0.0f;
        fArray2[18] = 1.0f;
        fArray3[19] = 1.0f;
        this.p = fArray;
        float[] fArray4 = new float[n10];
        this.r = fArray4;
        Object object = new float[n10];
        this.s = object;
        this.u = n10 = -12345;
        this.v = n10;
        this.o = bl2 = ((Boolean)comparable).booleanValue();
        comparable = ByteBuffer.allocateDirect(fArray.length * 4);
        object = ByteOrder.nativeOrder();
        comparable = ((ByteBuffer)comparable).order((ByteOrder)object).asFloatBuffer();
        this.q = comparable;
        ((FloatBuffer)comparable).put(fArray).position(0);
        Matrix.setIdentityM((float[])this.s, (int)0);
    }

    private int a(int n10, String object) {
        int n11 = GLES20.glCreateShader((int)n10);
        CharSequence charSequence = new StringBuilder();
        charSequence.append("glCreateShader type=");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        this.a((String)charSequence);
        GLES20.glShaderSource((int)n11, (String)object);
        GLES20.glCompileShader((int)n11);
        object = new int[1];
        int n12 = 35713;
        GLES20.glGetShaderiv((int)n11, (int)n12, (int[])object, (int)0);
        Object object2 = object[0];
        if (object2 == false) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Could not compile shader ");
            ((StringBuilder)object).append(n10);
            ((StringBuilder)object).append(":");
            CharSequence charSequence2 = ((StringBuilder)object).toString();
            object = "TXTweenFilter";
            TXCLog.e((String)object, (String)charSequence2);
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append(" ");
            charSequence = GLES20.glGetShaderInfoLog((int)n11);
            ((StringBuilder)charSequence2).append((String)charSequence);
            charSequence2 = ((StringBuilder)charSequence2).toString();
            TXCLog.e((String)object, (String)charSequence2);
            GLES20.glDeleteShader((int)n11);
            n11 = 0;
        }
        return n11;
    }

    private int a(String string2, String object) {
        int n10 = this.a(35633, string2);
        int n11 = 0;
        if (n10 == 0) {
            return 0;
        }
        int n12 = 35632;
        Object object2 = this.a(n12, (String)object);
        if (object2 == 0) {
            return 0;
        }
        n12 = GLES20.glCreateProgram();
        this.a("glCreateProgram");
        String string3 = "TXTweenFilter";
        if (n12 == 0) {
            String string4 = "Could not create program";
            TXCLog.e(string3, string4);
        }
        GLES20.glAttachShader((int)n12, (int)n10);
        string2 = "glAttachShader";
        this.a(string2);
        GLES20.glAttachShader((int)n12, (int)object2);
        this.a(string2);
        GLES20.glLinkProgram((int)n12);
        n10 = 1;
        object = new int[n10];
        int n13 = 35714;
        GLES20.glGetProgramiv((int)n12, (int)n13, (int[])object, (int)0);
        object2 = object[0];
        if (object2 != n10) {
            TXCLog.e(string3, "Could not link program: ");
            string2 = GLES20.glGetProgramInfoLog((int)n12);
            TXCLog.e(string3, string2);
            GLES20.glDeleteProgram((int)n12);
        } else {
            n11 = n12;
        }
        return n11;
    }

    private void a(String string2) {
        int n10;
        while ((n10 = GLES20.glGetError()) != 0) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append(string2);
            String string3 = ": glError ";
            charSequence.append(string3);
            charSequence.append(n10);
            String string4 = charSequence.toString();
            charSequence = "TXTweenFilter";
            TXCLog.e((String)charSequence, string4);
        }
    }

    private void b(float[] fArray) {
        block7: {
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            float f15;
            int n10;
            int n11;
            int n12;
            int n13;
            int n14;
            int n15;
            block9: {
                block8: {
                    n15 = this.d;
                    if (n15 == 0 || (n14 = this.c) == 0) break block7;
                    n13 = this.e;
                    n12 = this.f;
                    n11 = this.h;
                    n10 = 270;
                    f15 = 3.78E-43f;
                    if (n11 == n10) break block8;
                    n10 = 90;
                    f15 = 1.26E-43f;
                    if (n11 != n10) break block9;
                }
                int n16 = n12;
                n12 = n13;
                n13 = n16;
            }
            float f16 = n14;
            n11 = 1065353216;
            float f17 = 1.0f;
            f16 *= f17;
            float f18 = n13;
            f15 = (float)n15 * f17;
            float f19 = n12;
            f15 /= f19;
            int n17 = this.g;
            int n18 = a;
            if (!(n17 != n18 ? (n15 = (int)((f14 = (f13 = f16 * f19) - (f12 = (float)n15)) == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1))) <= 0 : (n15 = (int)((f11 = (f13 = (f16 /= f18) * f19) - (f10 = (float)n15)) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1))) > 0)) {
                f16 = f15;
            }
            float[] fArray2 = this.k;
            n10 = 0;
            f15 = 0.0f;
            Matrix.setIdentityM((float[])fArray2, (int)0);
            n15 = (int)(this.i ? 1 : 0);
            if (n15 != 0) {
                n15 = this.h % 180;
                n17 = -1082130432;
                f13 = -1.0f;
                if (n15 == 0) {
                    fArray2 = this.k;
                    Matrix.scaleM((float[])fArray2, (int)0, (float)f13, (float)f17, (float)f17);
                } else {
                    fArray2 = this.k;
                    Matrix.scaleM((float[])fArray2, (int)0, (float)f17, (float)f13, (float)f17);
                }
            }
            fArray2 = this.k;
            f18 *= f16;
            n17 = this.c;
            f13 = n17;
            f18 = f18 / f13 * f17;
            f19 *= f16;
            f16 = this.d;
            f19 = f19 / f16 * f17;
            Matrix.scaleM((float[])fArray2, (int)0, (float)f18, (float)f19, (float)f17);
            float[] fArray3 = this.k;
            n18 = 0;
            n15 = this.h;
            float f20 = n15;
            float f21 = -1.0f;
            Matrix.rotateM((float[])fArray3, (int)0, (float)f20, (float)0.0f, (float)0.0f, (float)f21);
            n14 = 0;
            f16 = 0.0f;
            float[] fArray4 = this.j;
            n12 = 0;
            f19 = 0.0f;
            float[] fArray5 = this.k;
            n10 = 0;
            f15 = 0.0f;
            fArray2 = fArray;
            Matrix.multiplyMM((float[])fArray, (int)0, (float[])fArray4, (int)0, (float[])fArray5, (int)0);
        }
    }

    private void d() {
        int n10 = (int)(this.n ? 1 : 0);
        if (n10 == 0) {
            return;
        }
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("reloadFrameBuffer. size = ");
        int n11 = this.c;
        ((StringBuilder)charSequence).append(n11);
        ((StringBuilder)charSequence).append("*");
        n11 = this.d;
        ((StringBuilder)charSequence).append(n11);
        charSequence = ((StringBuilder)charSequence).toString();
        String string2 = "TXTweenFilter";
        TXCLog.i(string2, (String)charSequence);
        this.e();
        n10 = 1;
        int[] nArray = new int[n10];
        int[] nArray2 = new int[n10];
        GLES20.glGenTextures((int)n10, (int[])nArray, (int)0);
        GLES20.glGenFramebuffers((int)n10, (int[])nArray2, (int)0);
        this.u = n10 = nArray[0];
        this.v = n10 = nArray2[0];
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("frameBuffer id = ");
        int n12 = this.v;
        ((StringBuilder)charSequence).append(n12);
        ((StringBuilder)charSequence).append(", texture id = ");
        n12 = this.u;
        ((StringBuilder)charSequence).append(n12);
        charSequence = ((StringBuilder)charSequence).toString();
        TXCLog.d(string2, (String)charSequence);
        n10 = this.u;
        n11 = 3553;
        GLES20.glBindTexture((int)n11, (int)n10);
        this.a("glBindTexture mFrameBufferTextureID");
        int n13 = this.c;
        int n14 = this.d;
        GLES20.glTexImage2D((int)3553, (int)0, (int)6408, (int)n13, (int)n14, (int)0, (int)6408, (int)5121, null);
        float f10 = 9729.0f;
        GLES20.glTexParameterf((int)n11, (int)10241, (float)f10);
        GLES20.glTexParameterf((int)n11, (int)10240, (float)f10);
        n12 = 33071;
        GLES20.glTexParameteri((int)n11, (int)10242, (int)n12);
        GLES20.glTexParameteri((int)n11, (int)10243, (int)n12);
        this.a("glTexParameter");
        n10 = this.v;
        n12 = 36160;
        GLES20.glBindFramebuffer((int)n12, (int)n10);
        int n15 = this.u;
        GLES20.glFramebufferTexture2D((int)n12, (int)36064, (int)n11, (int)n15, (int)0);
        GLES20.glBindTexture((int)n11, (int)0);
        GLES20.glBindFramebuffer((int)n12, (int)0);
        this.n = false;
    }

    private void e() {
        int[] nArray;
        int n10 = this.v;
        int n11 = 1;
        int n12 = -12345;
        if (n10 != n12) {
            nArray = new int[n11];
            nArray[0] = n10;
            GLES20.glDeleteFramebuffers((int)n11, (int[])nArray, (int)0);
            this.v = n12;
        }
        if ((n10 = this.u) != n12) {
            nArray = new int[n11];
            nArray[0] = n10;
            GLES20.glDeleteTextures((int)n11, (int[])nArray, (int)0);
            this.u = n12;
        }
    }

    public void a(int n10) {
        this.g = n10;
    }

    public void a(int n10, int n11) {
        h h10 = this;
        int n12 = n10;
        int n13 = n11;
        int n14 = this.c;
        if (n10 == n14 && n11 == (n14 = this.d)) {
            return;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Output resolution change: ");
        int n15 = h10.c;
        charSequence.append(n15);
        Object object = "*";
        charSequence.append((String)object);
        int n16 = h10.d;
        charSequence.append(n16);
        String string2 = " -> ";
        charSequence.append(string2);
        charSequence.append(n12);
        charSequence.append((String)object);
        charSequence.append(n13);
        charSequence = charSequence.toString();
        object = "TXTweenFilter";
        TXCLog.i((String)object, (String)charSequence);
        h10.c = n12;
        h10.d = n13;
        n14 = 1065353216;
        float f10 = 1.0f;
        if (n12 > n13) {
            object = h10.j;
            n16 = 0;
            string2 = null;
            float f11 = -1.0f;
            float f12 = -1.0f;
            float f13 = 1.0f;
            float f14 = -1.0f;
            float f15 = 1.0f;
            float f16 = 1.0f;
            Matrix.orthoM((float[])object, (int)0, (float)f11, (float)f16, (float)f12, (float)f13, (float)f14, (float)f15);
            h10.l = f10;
            h10.m = f10;
        } else {
            float[] fArray = h10.j;
            float f17 = -1.0f;
            float f18 = 1.0f;
            float f19 = -1.0f;
            float f20 = -1.0f;
            float f21 = 1.0f;
            float f22 = 1.0f;
            Matrix.orthoM((float[])fArray, (int)0, (float)f17, (float)f18, (float)f19, (float)f22, (float)f20, (float)f21);
            h10.l = f10;
            h10.m = f10;
        }
        h10.n = true;
    }

    public void a(boolean bl2) {
        this.i = bl2;
    }

    public void a(float[] fArray) {
        this.s = fArray;
    }

    public boolean a() {
        return this.o;
    }

    public void b() {
        String string2;
        int n10 = this.o;
        String string3 = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
        if (n10 != 0) {
            string2 = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
            this.t = n10 = this.a(string3, string2);
        } else {
            string2 = "varying highp vec2 vTextureCoord;\n \nuniform sampler2D sTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(sTexture, vTextureCoord);\n}";
            this.t = n10 = this.a(string3, string2);
        }
        n10 = this.t;
        string3 = "TXTweenFilter";
        if (n10 == 0) {
            TXCLog.e(string3, "failed creating program");
            return;
        }
        String string4 = "aPosition";
        this.y = n10 = GLES20.glGetAttribLocation((int)n10, (String)string4);
        string2 = "glGetAttribLocation aPosition";
        this.a(string2);
        n10 = this.y;
        int n11 = -1;
        if (n10 == n11) {
            TXCLog.e(string3, "Could not get attrib location for aPosition");
            return;
        }
        n10 = this.t;
        String string5 = "aTextureCoord";
        this.z = n10 = GLES20.glGetAttribLocation((int)n10, (String)string5);
        string2 = "glGetAttribLocation aTextureCoord";
        this.a(string2);
        n10 = this.z;
        if (n10 == n11) {
            TXCLog.e(string3, "Could not get attrib location for aTextureCoord");
            return;
        }
        n10 = this.t;
        string5 = "uMVPMatrix";
        this.w = n10 = GLES20.glGetUniformLocation((int)n10, (String)string5);
        string2 = "glGetUniformLocation uMVPMatrix";
        this.a(string2);
        n10 = this.w;
        if (n10 == n11) {
            TXCLog.e(string3, "Could not get attrib location for uMVPMatrix");
            return;
        }
        n10 = this.t;
        string5 = "uSTMatrix";
        this.x = n10 = GLES20.glGetUniformLocation((int)n10, (String)string5);
        string2 = "glGetUniformLocation uSTMatrix";
        this.a(string2);
        n10 = this.x;
        if (n10 == n11) {
            string2 = "Could not get attrib location for uSTMatrix";
            TXCLog.e(string3, string2);
        }
    }

    public void b(int n10) {
        this.h = n10;
    }

    public void b(int n10, int n11) {
        int n12 = this.e;
        if (n10 == n12 && n11 == (n12 = this.f)) {
            return;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Input resolution change: ");
        int n13 = this.e;
        charSequence.append(n13);
        String string2 = "*";
        charSequence.append(string2);
        int n14 = this.f;
        charSequence.append(n14);
        charSequence.append(" -> ");
        charSequence.append(n10);
        charSequence.append(string2);
        charSequence.append(n11);
        charSequence = charSequence.toString();
        TXCLog.i("TXTweenFilter", (String)charSequence);
        this.e = n10;
        this.f = n11;
    }

    public void c() {
        GLES20.glDeleteProgram((int)this.t);
        this.e();
    }

    public void c(int n10) {
        int n11 = this.c;
        int n12 = this.d;
        GLES20.glViewport((int)0, (int)0, (int)n11, (int)n12);
        GLES20.glClearColor((float)0.0f, (float)0.0f, (float)0.0f, (float)1.0f);
        GLES20.glClear((int)16640);
        GLES20.glUseProgram((int)this.t);
        Object object = "glUseProgram";
        this.a((String)object);
        n11 = (int)(this.o ? 1 : 0);
        n12 = 36197;
        int n13 = 3553;
        int n14 = 33984;
        if (n11 != 0) {
            GLES20.glActiveTexture((int)n14);
            GLES20.glBindTexture((int)n12, (int)n10);
        } else {
            GLES20.glActiveTexture((int)n14);
            GLES20.glBindTexture((int)n13, (int)n10);
        }
        this.q.position(0);
        n14 = this.y;
        int n15 = 5126;
        int n16 = 20;
        FloatBuffer floatBuffer = this.q;
        GLES20.glVertexAttribPointer((int)n14, (int)3, (int)n15, (boolean)false, (int)n16, (Buffer)floatBuffer);
        this.a("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray((int)this.y);
        this.a("glEnableVertexAttribArray maPositionHandle");
        this.q.position(3);
        n14 = this.z;
        int n17 = 2;
        floatBuffer = this.q;
        GLES20.glVertexAttribPointer((int)n14, (int)n17, (int)n15, (boolean)false, (int)n16, (Buffer)floatBuffer);
        this.a("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray((int)this.z);
        this.a("glEnableVertexAttribArray maTextureHandle");
        Matrix.setIdentityM((float[])this.r, (int)0);
        Object object2 = this.r;
        this.b((float[])object2);
        n10 = this.w;
        object = this.r;
        n14 = 1;
        GLES20.glUniformMatrix4fv((int)n10, (int)n14, (boolean)false, (float[])object, (int)0);
        n10 = this.x;
        object = this.s;
        GLES20.glUniformMatrix4fv((int)n10, (int)n14, (boolean)false, (float[])object, (int)0);
        object2 = "glDrawArrays";
        this.a((String)object2);
        n11 = 5;
        n14 = 4;
        GLES20.glDrawArrays((int)n11, (int)0, (int)n14);
        this.a((String)object2);
        n10 = (int)(this.o ? 1 : 0);
        if (n10 != 0) {
            GLES20.glBindTexture((int)n12, (int)0);
        } else {
            GLES20.glBindTexture((int)n13, (int)0);
        }
    }

    public int d(int n10) {
        this.d();
        int n11 = this.v;
        int n12 = -12345;
        if (n11 == n12) {
            TXCLog.d("TXTweenFilter", "invalid frame buffer id");
            return n10;
        }
        n12 = 36160;
        GLES20.glBindFramebuffer((int)n12, (int)n11);
        this.c(n10);
        GLES20.glBindFramebuffer((int)n12, (int)0);
        return this.u;
    }
}

