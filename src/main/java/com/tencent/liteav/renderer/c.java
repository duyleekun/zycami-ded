/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.opengl.GLES20
 *  android.opengl.Matrix
 */
package com.tencent.liteav.renderer;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.liteav.basic.log.TXCLog;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class c {
    private final float[] a;
    private final float[] b;
    private FloatBuffer c;
    private float[] d;
    private float[] e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private boolean m;
    private boolean n;
    private int o;
    private int p;
    private int q;

    public c(boolean bl2) {
        int n10;
        Object object;
        Object object2;
        int n11 = 20;
        float[] fArray = object2 = new float[n11];
        float[] fArray2 = object2;
        fArray[0] = -1.0f;
        fArray2[1] = -1.0f;
        fArray[2] = 0.0f;
        fArray2[3] = 0.0f;
        fArray[4] = 0.0f;
        fArray2[5] = 1.0f;
        fArray[6] = -1.0f;
        fArray2[7] = 0.0f;
        fArray[8] = 1.0f;
        fArray2[9] = 0.0f;
        fArray[10] = -1.0f;
        fArray2[11] = 1.0f;
        fArray[12] = 0.0f;
        fArray2[13] = 0.0f;
        fArray[14] = 1.0f;
        fArray2[15] = 1.0f;
        fArray[16] = 1.0f;
        fArray2[17] = 0.0f;
        fArray[18] = 1.0f;
        fArray2[19] = 1.0f;
        this.a = object2;
        float[] fArray3 = object = new float[n11];
        float[] fArray4 = object;
        fArray3[0] = 1.0f;
        fArray4[1] = -1.0f;
        fArray3[2] = 0.0f;
        fArray4[3] = 1.0f;
        fArray3[4] = 1.0f;
        fArray4[5] = -1.0f;
        fArray3[6] = -1.0f;
        fArray4[7] = 0.0f;
        fArray3[8] = 0.0f;
        fArray4[9] = 1.0f;
        fArray3[10] = 1.0f;
        fArray4[11] = 1.0f;
        fArray3[12] = 0.0f;
        fArray4[13] = 1.0f;
        fArray3[14] = 0.0f;
        fArray4[15] = -1.0f;
        fArray3[16] = 1.0f;
        fArray4[17] = 0.0f;
        fArray3[18] = 0.0f;
        fArray4[19] = 0.0f;
        this.b = object;
        int n12 = 16;
        float[] fArray5 = new float[n12];
        this.d = fArray5;
        float[] fArray6 = new float[n12];
        this.e = fArray6;
        this.g = -12345;
        n12 = 0;
        fArray6 = null;
        this.l = false;
        this.m = true;
        this.n = false;
        this.o = n10 = -1;
        this.p = 0;
        this.q = 0;
        this.m = bl2;
        if (bl2) {
            int n13 = ((float[])object2).length * 4;
            Buffer buffer = ByteBuffer.allocateDirect(n13);
            object = ByteOrder.nativeOrder();
            buffer = ((ByteBuffer)buffer).order((ByteOrder)object).asFloatBuffer();
            this.c = buffer;
            buffer = ((FloatBuffer)buffer).put((float[])object2);
            ((FloatBuffer)buffer).position(0);
        } else {
            int n14 = ((float[])object).length * 4;
            Buffer buffer = ByteBuffer.allocateDirect(n14);
            object2 = ByteOrder.nativeOrder();
            buffer = ((ByteBuffer)buffer).order((ByteOrder)object2).asFloatBuffer();
            this.c = buffer;
            buffer = ((FloatBuffer)buffer).put((float[])object);
            ((FloatBuffer)buffer).position(0);
        }
        Matrix.setIdentityM((float[])this.e, (int)0);
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
            object = "TXCOesTextureRender";
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
        String string3 = "TXCOesTextureRender";
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

    private void b(int n10, int n11) {
        float f10;
        float[] fArray;
        String string2 = null;
        float f11 = 1.0f;
        GLES20.glClearColor((float)0.0f, (float)0.0f, (float)0.0f, (float)f11);
        GLES20.glClear((int)16640);
        boolean n12 = this.l;
        if (n12) {
            this.l = false;
            return;
        }
        GLES20.glUseProgram((int)this.f);
        string2 = "glUseProgram";
        this.a(string2);
        GLES20.glActiveTexture((int)33984);
        GLES20.glBindTexture((int)n10, (int)n11);
        this.c.position(0);
        int n13 = this.j;
        int n14 = 5126;
        int n15 = 20;
        FloatBuffer floatBuffer = this.c;
        GLES20.glVertexAttribPointer((int)n13, (int)3, (int)n14, (boolean)false, (int)n15, (Buffer)floatBuffer);
        this.a("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray((int)this.j);
        this.a("glEnableVertexAttribArray maPositionHandle");
        Object object = this.c;
        float f12 = 4.2E-45f;
        ((FloatBuffer)object).position(3);
        n13 = this.k;
        int n16 = 2;
        floatBuffer = this.c;
        GLES20.glVertexAttribPointer((int)n13, (int)n16, (int)n14, (boolean)false, (int)n15, (Buffer)floatBuffer);
        this.a("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray((int)this.k);
        this.a("glEnableVertexAttribArray maTextureHandle");
        object = this.d;
        Matrix.setIdentityM((float[])object, (int)0);
        n10 = this.h;
        float[] fArray2 = this.d;
        int n17 = 1;
        GLES20.glUniformMatrix4fv((int)n10, (int)n17, (boolean)false, (float[])fArray2, (int)0);
        n10 = this.p;
        n11 = n10 % 8;
        if (n11 != 0) {
            n11 = (n10 + 7) / 8 * 8;
            fArray = this.e;
            f10 = (float)(n10 -= n17) * f11;
            f12 = n11;
            Matrix.scaleM((float[])fArray, (int)0, (float)(f10 /= f12), (float)f11, (float)f11);
        }
        if ((n11 = (n10 = this.q) % 8) != 0) {
            n11 = (n10 + 7) / 8 * 8;
            fArray = this.e;
            f10 = (float)(n10 -= n17) * f11;
            f12 = n11;
            Matrix.scaleM((float[])fArray, (int)0, (float)f11, (float)(f10 /= f12), (float)f11);
        }
        n10 = this.i;
        fArray2 = this.e;
        GLES20.glUniformMatrix4fv((int)n10, (int)n17, (boolean)false, (float[])fArray2, (int)0);
        GLES20.glDrawArrays((int)5, (int)0, (int)4);
        this.a("glDrawArrays");
        GLES20.glFinish();
    }

    private void d() {
        int n10 = 1;
        int[] nArray = new int[n10];
        GLES20.glGenTextures((int)n10, (int[])nArray, (int)0);
        this.g = n10 = nArray[0];
        GLES20.glBindTexture((int)36197, (int)n10);
        this.a("glBindTexture mTextureID");
    }

    public int a() {
        return this.g;
    }

    public void a(int n10, int n11) {
        this.p = n10;
        this.q = n11;
    }

    public void a(int n10, boolean n11, int n12) {
        int n13 = this.n;
        if (n13 != n11 || (n13 = this.o) != n12) {
            float f10;
            int n14;
            this.n = n11;
            this.o = n12;
            n11 = 20;
            float f11 = 2.8E-44f;
            float[] fArray = new float[n11];
            float f12 = 0.0f;
            for (n14 = 0; n14 < n11; ++n14) {
                float[] fArray2 = this.b;
                fArray[n14] = f10 = fArray2[n14];
            }
            n11 = this.n;
            if (n11 != 0) {
                fArray[0] = f11 = -fArray[0];
                n11 = 5;
                fArray[n11] = f12 = -fArray[n11];
                n11 = 10;
                fArray[n11] = f12 = -fArray[n11];
                n11 = 15;
                f11 = 2.1E-44f;
                fArray[n11] = f12 = -fArray[n11];
            }
            FloatBuffer floatBuffer = null;
            f11 = 0.0f;
            for (n11 = 0; n11 < (n12 /= 90); ++n11) {
                float f13;
                n14 = 3;
                f10 = fArray[n14];
                int n15 = 4;
                float f14 = fArray[n15];
                int n16 = 8;
                fArray[n14] = f13 = fArray[n16];
                n14 = 9;
                fArray[n15] = f13 = fArray[n14];
                n15 = 18;
                fArray[n16] = f13 = fArray[n15];
                n16 = 19;
                fArray[n14] = f13 = fArray[n16];
                n14 = 13;
                f12 = 1.8E-44f;
                fArray[n15] = f13 = fArray[n14];
                n15 = 14;
                fArray[n16] = f13 = fArray[n15];
                fArray[n14] = f10;
                fArray[n15] = f14;
            }
            this.c.clear();
            floatBuffer = this.c.put(fArray);
            floatBuffer.position(0);
        }
        this.b(3553, n10);
    }

    public void a(SurfaceTexture surfaceTexture) {
        if (surfaceTexture == null) {
            return;
        }
        this.a("onDrawFrame start");
        float[] fArray = this.e;
        surfaceTexture.getTransformMatrix(fArray);
        int n10 = this.g;
        this.b(36197, n10);
    }

    public void a(String string2) {
        int n10 = GLES20.glGetError();
        if (n10 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(": glError ");
            stringBuilder.append(n10);
            string2 = stringBuilder.toString();
            String string3 = "TXCOesTextureRender";
            TXCLog.e(string3, string2);
        }
    }

    public void b() {
        String string2;
        int n10 = this.m;
        String string3 = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
        if (n10 != 0) {
            string2 = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
            this.f = n10 = this.a(string3, string2);
        } else {
            string2 = "varying highp vec2 vTextureCoord;\n \nuniform sampler2D sTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(sTexture, vTextureCoord);\n}";
            this.f = n10 = this.a(string3, string2);
        }
        n10 = this.f;
        string3 = "TXCOesTextureRender";
        if (n10 == 0) {
            TXCLog.e(string3, "failed creating program");
            return;
        }
        String string4 = "aPosition";
        this.j = n10 = GLES20.glGetAttribLocation((int)n10, (String)string4);
        string2 = "glGetAttribLocation aPosition";
        this.a(string2);
        n10 = this.j;
        int n11 = -1;
        float f10 = 0.0f / 0.0f;
        if (n10 == n11) {
            TXCLog.e(string3, "Could not get attrib location for aPosition");
            return;
        }
        n10 = this.f;
        String string5 = "aTextureCoord";
        this.k = n10 = GLES20.glGetAttribLocation((int)n10, (String)string5);
        string2 = "glGetAttribLocation aTextureCoord";
        this.a(string2);
        n10 = this.k;
        if (n10 == n11) {
            TXCLog.e(string3, "Could not get attrib location for aTextureCoord");
            return;
        }
        n10 = this.f;
        string5 = "uMVPMatrix";
        this.h = n10 = GLES20.glGetUniformLocation((int)n10, (String)string5);
        string2 = "glGetUniformLocation uMVPMatrix";
        this.a(string2);
        n10 = this.h;
        if (n10 == n11) {
            TXCLog.e(string3, "Could not get attrib location for uMVPMatrix");
            return;
        }
        n10 = this.f;
        string5 = "uSTMatrix";
        this.i = n10 = GLES20.glGetUniformLocation((int)n10, (String)string5);
        string2 = "glGetUniformLocation uSTMatrix";
        this.a(string2);
        n10 = this.i;
        if (n10 == n11) {
            TXCLog.e(string3, "Could not get attrib location for uSTMatrix");
            return;
        }
        n10 = (int)(this.m ? 1 : 0);
        if (n10 != 0) {
            this.d();
        }
        int n12 = 36197;
        f10 = 9729.0f;
        GLES20.glTexParameterf((int)n12, (int)10241, (float)f10);
        GLES20.glTexParameterf((int)n12, (int)10240, (float)f10);
        n11 = 33071;
        GLES20.glTexParameteri((int)n12, (int)10242, (int)n11);
        GLES20.glTexParameteri((int)n12, (int)10243, (int)n11);
        this.a("glTexParameter");
    }

    public void c() {
        int n10;
        int n11 = this.f;
        if (n11 != 0) {
            GLES20.glDeleteProgram((int)n11);
        }
        n11 = 1;
        int[] nArray = new int[n11];
        nArray[0] = n10 = this.g;
        GLES20.glDeleteTextures((int)n11, (int[])nArray, (int)0);
        this.g = -1;
    }
}

