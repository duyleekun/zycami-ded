/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.tencent.liteav.basic.opengl;

import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.TXCOpenGlUtils;
import com.tencent.liteav.basic.opengl.a;
import com.tencent.liteav.basic.opengl.i$1;
import com.tencent.liteav.basic.opengl.i$2;
import com.tencent.liteav.basic.opengl.i$3;
import com.tencent.liteav.basic.opengl.i$4;
import com.tencent.liteav.basic.opengl.i$5;
import com.tencent.liteav.basic.opengl.i$a;
import com.tencent.liteav.basic.opengl.k;
import com.tencent.liteav.basic.opengl.l;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.AbstractCollection;
import java.util.LinkedList;

public class i {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public FloatBuffer h;
    public FloatBuffer i;
    public float[] j;
    public float[] k;
    public i$a l;
    public int m;
    public int n;
    public boolean o;
    public boolean p;
    public boolean q;
    private final LinkedList r;
    private final String s;
    private final String t;
    private boolean u = false;
    private int v;
    private float[] w;

    public i() {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}", false);
    }

    public i(String string2, String string3) {
        this(string2, string3, false);
    }

    public i(String object, String object2, boolean bl2) {
        Object object3;
        int n10;
        this.v = n10 = -1;
        this.w = null;
        this.m = n10;
        this.n = n10;
        this.o = false;
        this.p = false;
        this.q = false;
        Object object4 = new LinkedList();
        this.r = object4;
        this.s = object;
        this.t = object2;
        this.q = bl2;
        boolean bl3 = true;
        if (bl3 == bl2) {
            object2 = "TXCGPUFilter";
            object3 = "set Oes fileter";
            TXCLog.i((String)object2, (String)object3);
        }
        object2 = com.tencent.liteav.basic.opengl.l.e;
        object3 = ByteBuffer.allocateDirect(((Object)object2).length * 4);
        object4 = ByteOrder.nativeOrder();
        this.h = object3 = ((ByteBuffer)object3).order((ByteOrder)object4).asFloatBuffer();
        this.j = (float[])object2;
        ((FloatBuffer)object3).put((float[])object2).position(0);
        object2 = ByteBuffer.allocateDirect(com.tencent.liteav.basic.opengl.l.a.length * 4);
        object3 = ByteOrder.nativeOrder();
        this.i = object2 = ((ByteBuffer)object2).order((ByteOrder)object3).asFloatBuffer();
        object = com.tencent.liteav.basic.opengl.l.a(com.tencent.liteav.basic.opengl.k.a, false, bl3);
        this.k = (float[])object;
        this.i.put((float[])object).position(0);
    }

    private static float[] a(FloatBuffer floatBuffer) {
        int n10;
        int n11 = floatBuffer.limit();
        if (n11 <= 0) {
            return null;
        }
        n11 = floatBuffer.limit();
        float[] fArray = new float[n11];
        for (int i10 = 0; i10 < (n10 = floatBuffer.limit()); ++i10) {
            float f10;
            fArray[i10] = f10 = floatBuffer.get(i10);
        }
        return fArray;
    }

    public int a(int n10) {
        FloatBuffer floatBuffer = this.h;
        FloatBuffer floatBuffer2 = this.i;
        return this.b(n10, floatBuffer, floatBuffer2);
    }

    public int a(int n10, int n11, int n12) {
        int n13 = this.g;
        if (n13 == 0) {
            return -1;
        }
        n13 = 36160;
        GLES20.glBindFramebuffer((int)n13, (int)n11);
        FloatBuffer floatBuffer = this.h;
        FloatBuffer floatBuffer2 = this.i;
        this.a(n10, floatBuffer, floatBuffer2);
        i$a i$a = this.l;
        n11 = i$a instanceof i$a;
        if (n11 != 0) {
            i$a.a(n12);
        }
        GLES20.glBindFramebuffer((int)n13, (int)0);
        return n12;
    }

    public void a(int n10, float f10) {
        i$2 i$2 = new i$2(this, n10, f10);
        this.a(i$2);
    }

    public void a(int n10, int n11) {
        int n12 = this.f;
        if (n12 == n11 && (n12 = this.e) == n10) {
            return;
        }
        this.e = n10;
        this.f = n11;
        n12 = (int)(this.o ? 1 : 0);
        if (n12 != 0) {
            n12 = this.m;
            int n13 = -1;
            if (n12 != n13) {
                this.f();
            }
            n12 = 1;
            int[] nArray = new int[n12];
            GLES20.glGenFramebuffers((int)n12, (int[])nArray, (int)0);
            this.m = n12 = nArray[0];
            n12 = 6408;
            this.n = n10 = TXCOpenGlUtils.a(n10, n11, n12, n12);
            n10 = this.m;
            n11 = 36160;
            GLES20.glBindFramebuffer((int)n11, (int)n10);
            n10 = 36064;
            n12 = 3553;
            n13 = this.n;
            GLES20.glFramebufferTexture2D((int)n11, (int)n10, (int)n12, (int)n13, (int)0);
            GLES20.glBindFramebuffer((int)n11, (int)0);
        }
    }

    public void a(int n10, int n11, int n12, float[] fArray, float f10, boolean bl2, boolean bl3) {
        int n13;
        int n14;
        float f11;
        int n15;
        float f12;
        Object object;
        float f13;
        int n16;
        float[] fArray2;
        float f14 = 0.0f;
        float[] fArray3 = null;
        int n17 = 1;
        if (fArray == null) {
            fArray2 = com.tencent.liteav.basic.opengl.l.a(com.tencent.liteav.basic.opengl.k.a, false, n17 != 0);
            n16 = n10;
        } else {
            n16 = n10;
            fArray2 = fArray;
        }
        float f15 = n16;
        int n18 = n11;
        float f16 = n11;
        float f17 = f15 / f16;
        Object object2 = f17 == f10 ? 0 : (f17 > f10 ? 1 : -1);
        if (object2 > 0) {
            f13 = f16 * f10;
            n16 = (int)f13;
        } else {
            object = f17 == f10 ? 0 : (f17 < f10 ? -1 : 1);
            if (object < 0) {
                f12 = f15 / f10;
                n18 = (int)f12;
            }
        }
        f13 = (float)n16 / f15;
        f15 = (float)n18 / f16;
        n18 = 1065353216;
        f12 = 1.0f;
        f13 = f12 - f13;
        f16 = 2.0f;
        f13 /= f16;
        f15 = (f12 - f15) / f16;
        int n19 = 0;
        f16 = 0.0f;
        while (true) {
            object = fArray2.length;
            object2 = 2;
            float f18 = 2.8E-45f;
            if (n19 >= (object /= object2)) break;
            object = n19 * 2;
            f18 = fArray2[object];
            n15 = 0x3F000000;
            f11 = 0.5f;
            float f19 = f18 - f11;
            object2 = f19 == 0.0f ? 0 : (f19 < 0.0f ? -1 : 1);
            fArray2[object] = object2 < 0 ? (f18 = fArray2[object] + f13) : (f18 = fArray2[object] - f13);
            f18 = fArray2[++object];
            object2 = f18 == f11 ? 0 : (f18 < f11 ? -1 : 1);
            fArray2[object] = object2 < 0 ? (f18 = fArray2[object] + f15) : (f18 = fArray2[object] - f15);
            ++n19;
        }
        n16 = n12 / 90;
        int n20 = 0;
        f15 = 0.0f;
        while (true) {
            float f20;
            n19 = 5;
            f16 = 7.0E-45f;
            object = 4;
            f17 = 5.6E-45f;
            n15 = 7;
            f11 = 9.8E-45f;
            n14 = 6;
            float f21 = 8.4E-45f;
            n13 = 3;
            float f22 = 4.2E-45f;
            if (n20 >= n16) break;
            float f23 = fArray2[0];
            float f24 = fArray2[n17];
            fArray2[0] = f20 = fArray2[object2];
            fArray2[n17] = f20 = fArray2[n13];
            fArray2[object2] = f20 = fArray2[n14];
            fArray2[n13] = f20 = fArray2[n15];
            fArray2[n14] = f22 = fArray2[object];
            fArray2[n15] = f21 = fArray2[n19];
            fArray2[object] = f23;
            fArray2[n19] = f24;
            ++n20;
        }
        if (n16 != 0 && n16 != object2) {
            if (bl3) {
                f13 = fArray2[0];
                fArray2[0] = f13 = f12 - f13;
                f14 = fArray2[object2];
                fArray2[object2] = f14 = f12 - f14;
                f14 = fArray2[object];
                fArray2[object] = f14 = f12 - f14;
                f14 = fArray2[n14];
                fArray2[n14] = f14 = f12 - f14;
            }
            if (bl2) {
                f14 = fArray2[n17];
                fArray2[n17] = f14 = f12 - f14;
                f14 = fArray2[n13];
                fArray2[n13] = f14 = f12 - f14;
                f14 = fArray2[n19];
                fArray2[n19] = f14 = f12 - f14;
                f14 = fArray2[n15];
                fArray2[n15] = f12 -= f14;
            }
        } else {
            if (bl2) {
                f13 = fArray2[0];
                fArray2[0] = f13 = f12 - f13;
                f14 = fArray2[object2];
                fArray2[object2] = f14 = f12 - f14;
                f14 = fArray2[object];
                fArray2[object] = f14 = f12 - f14;
                f14 = fArray2[n14];
                fArray2[n14] = f14 = f12 - f14;
            }
            if (bl3) {
                f14 = fArray2[n17];
                fArray2[n17] = f14 = f12 - f14;
                f14 = fArray2[n13];
                fArray2[n13] = f14 = f12 - f14;
                f14 = fArray2[n19];
                fArray2[n19] = f14 = f12 - f14;
                f14 = fArray2[n15];
                fArray2[n15] = f12 -= f14;
            }
        }
        fArray3 = (float[])com.tencent.liteav.basic.opengl.l.e.clone();
        this.a(fArray3, fArray2);
    }

    public void a(int n10, FloatBuffer object) {
        int n11 = 1;
        object = object == null ? (Object)com.tencent.liteav.basic.opengl.l.a(com.tencent.liteav.basic.opengl.k.a, false, n11 != 0) : (Object)com.tencent.liteav.basic.opengl.i.a((FloatBuffer)object);
        for (int i10 = 0; i10 < (n10 /= 90); ++i10) {
            Object object2;
            Object object3;
            Object object4;
            Object object5 = object[0];
            Object object6 = object[n11];
            int n12 = 2;
            object[0] = object4 = object[n12];
            int n13 = 3;
            object[n11] = object3 = object[n13];
            int n14 = 6;
            object[n12] = object2 = object[n14];
            n12 = 7;
            object[n13] = object2 = object[n12];
            n13 = 4;
            object4 = 5.6E-45f;
            object[n14] = object2 = object[n13];
            n14 = 5;
            object3 = 7.0E-45f;
            object[n12] = object2 = object[n14];
            object[n13] = object5;
            object[n14] = object6;
        }
        float[] fArray = (float[])com.tencent.liteav.basic.opengl.l.e.clone();
        this.a(fArray, (float[])object);
    }

    public void a(int n10, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        float[] fArray;
        GLES20.glUseProgram((int)this.a);
        this.k();
        boolean bl2 = this.g;
        if (!bl2) {
            return;
        }
        bl2 = false;
        floatBuffer.position(0);
        int n11 = this.b;
        int n12 = 2;
        int n13 = 5126;
        GLES20.glVertexAttribPointer((int)n11, (int)n12, (int)n13, (boolean)false, (int)0, (Buffer)floatBuffer);
        GLES20.glEnableVertexAttribArray((int)this.b);
        floatBuffer2.position(0);
        n11 = this.d;
        GLES20.glVertexAttribPointer((int)n11, (int)n12, (int)n13, (boolean)false, (int)0, (Buffer)floatBuffer2);
        GLES20.glEnableVertexAttribArray((int)this.d);
        int n14 = this.v;
        int n15 = 1;
        if (n14 >= 0 && (fArray = this.w) != null) {
            GLES20.glUniformMatrix4fv((int)n14, (int)n15, (boolean)false, (float[])fArray, (int)0);
        }
        n14 = -1;
        n11 = 36197;
        n12 = 3553;
        if (n10 != n14) {
            GLES20.glActiveTexture((int)33984);
            n14 = (int)(this.q ? 1 : 0);
            if (n15 == n14) {
                GLES20.glBindTexture((int)n11, (int)n10);
            } else {
                GLES20.glBindTexture((int)n12, (int)n10);
            }
            n10 = this.c;
            GLES20.glUniform1i((int)n10, (int)0);
        }
        this.i();
        n14 = 4;
        GLES20.glDrawArrays((int)5, (int)0, (int)n14);
        GLES20.glDisableVertexAttribArray((int)this.b);
        GLES20.glDisableVertexAttribArray((int)this.d);
        this.j();
        n10 = (int)(this.q ? 1 : 0);
        if (n15 == n10) {
            GLES20.glBindTexture((int)n11, (int)0);
        } else {
            GLES20.glBindTexture((int)n12, (int)0);
        }
    }

    public void a(int n10, float[] fArray) {
        i$3 i$3 = new i$3(this, n10, fArray);
        this.a(i$3);
    }

    public void a(i$a i$a) {
        boolean bl2 = i$a != null;
        this.u = bl2;
        this.l = i$a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(Runnable runnable) {
        LinkedList linkedList = this.r;
        synchronized (linkedList) {
            LinkedList linkedList2 = this.r;
            linkedList2.addLast(runnable);
            return;
        }
    }

    public void a(boolean bl2) {
        this.o = bl2;
    }

    public void a(float[] fArray) {
        this.w = fArray;
    }

    public void a(float[] object, float[] fArray) {
        this.j = object;
        Buffer buffer = ByteBuffer.allocateDirect(com.tencent.liteav.basic.opengl.l.e.length * 4);
        ByteOrder byteOrder = ByteOrder.nativeOrder();
        buffer = ((ByteBuffer)buffer).order(byteOrder).asFloatBuffer();
        this.h = buffer;
        ((FloatBuffer)buffer).put((float[])object).position(0);
        this.k = fArray;
        object = ByteBuffer.allocateDirect(com.tencent.liteav.basic.opengl.l.a.length * 4);
        byteOrder = ByteOrder.nativeOrder();
        this.i = object = ((ByteBuffer)object).order(byteOrder).asFloatBuffer();
        ((FloatBuffer)object).put(fArray).position(0);
    }

    public boolean a() {
        int n10;
        String string2 = this.s;
        String string3 = this.t;
        this.a = n10 = TXCOpenGlUtils.a(string2, string3);
        if (n10 != 0 && (n10 = (int)(this.b() ? 1 : 0)) != 0) {
            n10 = 1;
            this.g = n10;
        } else {
            n10 = 0;
            string2 = null;
            this.g = false;
        }
        this.c();
        return this.g;
    }

    public float[] a(int n10, int n11, FloatBuffer object, a a10, int n12) {
        float f10;
        int n13 = 0;
        if (object == null) {
            int n14 = 4;
            if (n14 == n12) {
                object = com.tencent.liteav.basic.opengl.l.a(com.tencent.liteav.basic.opengl.k.a, false, false);
            } else {
                object = com.tencent.liteav.basic.opengl.k.a;
                n12 = 1;
                f10 = Float.MIN_VALUE;
                object = com.tencent.liteav.basic.opengl.l.a((k)((Object)object), false, n12 != 0);
            }
        } else {
            object = com.tencent.liteav.basic.opengl.i.a((FloatBuffer)object);
        }
        if (a10 != null) {
            n12 = a10.a;
            float f11 = n12;
            float f12 = n10;
            float f13 = 1.0f;
            f11 /= (f12 *= f13);
            n10 -= n12;
            n12 = a10.c;
            float f14 = (float)(n10 -= n12) / f12;
            n12 = a10.b;
            f12 = n12;
            float f15 = (float)n11 * f13;
            f12 /= f15;
            n11 -= n12;
            int n15 = a10.d;
            float f16 = (float)(n11 -= n15) / f15;
            while (n13 < (n15 = ((Object)object).length / 2)) {
                n15 = n13 * 2;
                f10 = (float)object[n15];
                f13 = 0.5f;
                float f17 = f10 - f13;
                n12 = (int)(f17 == 0.0f ? 0 : (f17 < 0.0f ? -1 : 1));
                if (n12 < 0) {
                    f10 = (float)(object[n15] + f11);
                    object[n15] = f10;
                } else {
                    f10 = (float)(object[n15] - f14);
                    object[n15] = f10;
                }
                f10 = (float)object[++n15];
                n12 = (int)(f10 == f13 ? 0 : (f10 < f13 ? -1 : 1));
                if (n12 < 0) {
                    f10 = (float)(object[n15] + f12);
                    object[n15] = f10;
                } else {
                    f10 = (float)(object[n15] - f16);
                    object[n15] = f10;
                }
                ++n13;
            }
        }
        return object;
    }

    public int b(int n10) {
        int n11 = this.m;
        int n12 = this.n;
        return this.a(n10, n11, n12);
    }

    public int b(int n10, FloatBuffer object, FloatBuffer floatBuffer) {
        boolean bl2 = this.g;
        if (!bl2) {
            return -1;
        }
        this.a(n10, (FloatBuffer)object, floatBuffer);
        object = this.l;
        boolean bl3 = object instanceof i$a;
        if (bl3) {
            ((i$a)object).a(n10);
        }
        return 1;
    }

    public void b(int n10, int n11) {
        i$1 i$1 = new i$1(this, n10, n11);
        this.a(i$1);
    }

    public void b(int n10, float[] fArray) {
        i$4 i$4 = new i$4(this, n10, fArray);
        this.a(i$4);
    }

    public void b(boolean bl2) {
        this.p = bl2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("set Nearest model ");
        stringBuilder.append(bl2);
        String string2 = stringBuilder.toString();
        TXCLog.i("TXCGPUFilter", string2);
    }

    public boolean b() {
        int n10;
        this.b = n10 = GLES20.glGetAttribLocation((int)this.a, (String)"position");
        this.c = n10 = GLES20.glGetUniformLocation((int)this.a, (String)"inputImageTexture");
        this.v = n10 = GLES20.glGetUniformLocation((int)this.a, (String)"textureTransform");
        this.d = n10 = GLES20.glGetAttribLocation((int)this.a, (String)"inputTextureCoordinate");
        return true;
    }

    public void c() {
    }

    public void c(int n10, float[] fArray) {
        i$5 i$5 = new i$5(this, n10, fArray);
        this.a(i$5);
    }

    public void d() {
        GLES20.glDeleteProgram((int)this.a);
        this.e();
        this.g = false;
    }

    public void e() {
        int n10;
        this.f();
        this.f = n10 = -1;
        this.e = n10;
    }

    public void f() {
        int[] nArray;
        int n10 = this.m;
        int n11 = 1;
        int n12 = -1;
        if (n10 != n12) {
            nArray = new int[n11];
            nArray[0] = n10;
            GLES20.glDeleteFramebuffers((int)n11, (int[])nArray, (int)0);
            this.m = n12;
        }
        if ((n10 = this.n) != n12) {
            nArray = new int[n11];
            nArray[0] = n10;
            GLES20.glDeleteTextures((int)n11, (int[])nArray, (int)0);
            this.n = n12;
        }
    }

    public void g() {
        float[] fArray = this.k;
        if (fArray != null) {
            float[] fArray2;
            int n10;
            fArray = null;
            for (int i10 = 0; i10 < (n10 = 8); i10 += 2) {
                float f10;
                fArray2 = this.k;
                float f11 = fArray2[i10];
                fArray2[i10] = f10 = 1.0f - f11;
            }
            fArray = this.j;
            fArray2 = this.k;
            this.a(fArray, fArray2);
        }
    }

    public void h() {
        float[] fArray = this.k;
        if (fArray != null) {
            float[] fArray2;
            int n10;
            for (int i10 = 1; i10 < (n10 = 8); i10 += 2) {
                float f10;
                fArray2 = this.k;
                float f11 = fArray2[i10];
                fArray2[i10] = f10 = 1.0f - f11;
            }
            fArray = this.j;
            fArray2 = this.k;
            this.a(fArray, fArray2);
        }
    }

    public void i() {
    }

    public void j() {
    }

    public void k() {
        Object object;
        boolean bl2;
        while (!(bl2 = ((AbstractCollection)(object = this.r)).isEmpty())) {
            object = (Runnable)this.r.removeFirst();
            object.run();
        }
    }

    public int l() {
        return this.n;
    }

    public int m() {
        return this.m;
    }

    public boolean n() {
        return this.g;
    }

    public int o() {
        return this.e;
    }

    public int p() {
        return this.f;
    }

    public int q() {
        return this.a;
    }
}

