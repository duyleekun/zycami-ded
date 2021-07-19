/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.opengl.GLES20
 *  android.opengl.GLUtils
 *  android.util.Log
 */
package com.tencent.liteav.beauty.b;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.i;
import com.tencent.liteav.beauty.b.x$a;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.List;

public class x
extends i {
    private static final float[] A;
    public static final short[] v;
    private static final float[] z;
    private String B;
    public x$a[] r = null;
    public List s = null;
    public boolean t = false;
    public int u;
    public ShortBuffer w;
    private x$a x = null;
    private int y;

    static {
        Object[] objectArray;
        short[] sArray = objectArray = new short[6];
        short[] sArray2 = objectArray;
        sArray[0] = 1;
        sArray2[1] = 2;
        sArray[2] = 0;
        sArray2[3] = 2;
        sArray[4] = 0;
        sArray2[5] = 3;
        v = objectArray;
        Object[] objectArray2 = objectArray = (Object[])new float[8];
        Object[] objectArray3 = objectArray;
        objectArray2[0] = (short)0.0f;
        objectArray3[1] = (short)0.0f;
        objectArray2[2] = (short)0.0f;
        objectArray3[3] = (short)0.0f;
        objectArray2[4] = (short)0.0f;
        objectArray3[5] = (short)0.0f;
        objectArray2[6] = (short)0.0f;
        objectArray3[7] = (short)0.0f;
        z = objectArray;
        Object[] objectArray4 = objectArray = (Object[])new float[16];
        Object[] objectArray5 = objectArray;
        objectArray4[0] = (short)0.0f;
        objectArray5[1] = (short)0.0f;
        objectArray4[2] = (short)0.0f;
        objectArray5[3] = (short)1.0f;
        objectArray4[4] = (short)0.0f;
        objectArray5[5] = (short)1.0f;
        objectArray4[6] = (short)0.0f;
        objectArray5[7] = (short)1.0f;
        objectArray4[8] = (short)1.0f;
        objectArray5[9] = (short)1.0f;
        objectArray4[10] = (short)0.0f;
        objectArray5[11] = (short)1.0f;
        objectArray4[12] = (short)1.0f;
        objectArray5[13] = (short)0.0f;
        objectArray4[14] = (short)0.0f;
        objectArray5[15] = (short)1.0f;
        A = objectArray;
    }

    public x() {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    public x(String object, String string2) {
        super((String)object, string2);
        int n10;
        this.u = n10 = 1;
        this.y = n10;
        this.w = null;
        this.B = "GPUWatermark";
        object = v;
        Buffer buffer = ByteBuffer.allocateDirect(((Object)object).length * 2);
        ByteOrder byteOrder = ByteOrder.nativeOrder();
        ((ByteBuffer)buffer).order(byteOrder);
        buffer = ((ByteBuffer)buffer).asShortBuffer();
        this.w = buffer;
        ((ShortBuffer)buffer).put((short[])object);
        this.w.position(0);
        this.o = n10;
    }

    private void r() {
        x$a[] x$aArray = this.r;
        if (x$aArray != null) {
            Object[] objectArray;
            int n10;
            x$aArray = null;
            for (int i10 = 0; i10 < (n10 = (objectArray = this.r).length); ++i10) {
                Object object = objectArray[i10];
                if (object == null) continue;
                object = objectArray[i10].d;
                if (object != null) {
                    objectArray = objectArray[i10].d;
                    n10 = 1;
                    GLES20.glDeleteTextures((int)n10, (int[])objectArray, (int)0);
                }
                objectArray = this.r;
                objectArray[i10].d = null;
                object = objectArray[i10];
                ((x$a)object).c = null;
                objectArray[i10] = null;
            }
        }
        this.r = null;
    }

    public void a(int n10, int n11, float f10, float f11, float f12, int n12) {
        int n13;
        float[] fArray = z;
        int n14 = fArray.length;
        int n15 = 4;
        Buffer buffer = ByteBuffer.allocateDirect(n14 * n15);
        Object object = ByteOrder.nativeOrder();
        buffer.order((ByteOrder)object);
        object = this.r[n12];
        buffer = buffer.asFloatBuffer();
        ((x$a)object).a = buffer;
        int n16 = fArray.length;
        fArray = new float[n16];
        float f13 = n11;
        float f14 = n10;
        f13 = f13 / f14 * f12;
        f14 = this.e;
        f13 *= f14;
        f14 = this.f;
        f13 /= f14;
        n10 = 0x40000000;
        f14 = 2.0f;
        f10 *= f14;
        float f15 = 1.0f;
        object = null;
        fArray[0] = f10 -= f15;
        f10 = Float.MIN_VALUE;
        fArray[n13] = f15 -= (f11 *= f14);
        f11 = fArray[0];
        n14 = 2;
        f15 = 2.8E-45f;
        fArray[n14] = f11;
        f11 = fArray[n13];
        n11 = 3;
        fArray[n11] = f11 -= (f13 *= f14);
        f11 = fArray[0];
        fArray[n15] = f11 += (f12 *= f14);
        fArray[5] = f14 = fArray[n11];
        fArray[6] = f14 = fArray[n15];
        f14 = fArray[n13];
        n11 = 7;
        f13 = 9.8E-45f;
        fArray[n11] = f14;
        for (n13 = 1; n13 <= n11; n13 += 2) {
            f14 = fArray[n13];
            f11 = -1.0f;
            fArray[n13] = f14 *= f11;
        }
        this.r[n12].a.put(fArray);
        this.r[n12].a.position(0);
        float[] fArray2 = A;
        Buffer buffer2 = ByteBuffer.allocateDirect(fArray2.length * n15);
        Object object2 = ByteOrder.nativeOrder();
        buffer2.order((ByteOrder)object2);
        object2 = this.r[n12];
        buffer2 = buffer2.asFloatBuffer();
        ((x$a)object2).b = buffer2;
        this.r[n12].b.put(fArray2);
        this.r[n12].b.position(0);
    }

    public void a(Bitmap object, float f10, float f11, float f12) {
        x$a x$a;
        x$a[] x$aArray = this.r;
        if (x$aArray == null) {
            int n10 = 1;
            this.r = x$aArray = new x$a[n10];
        }
        if ((x$a = (x$aArray = this.r)[0]) == null) {
            x$aArray[0] = x$a = new x$a(this);
        }
        this.a((Bitmap)object, f10, f11, f12, 0);
        object = this.r[0];
        this.x = object;
    }

    public void a(Bitmap object, float f10, float f11, float f12, int n10) {
        int n11;
        int n12 = 1;
        if (object == null) {
            object = this.r;
            if (object != null && (object = object[n10]) != null) {
                object = this.B;
                Object object2 = new StringBuilder();
                ((StringBuilder)object2).append("release ");
                ((StringBuilder)object2).append(n10);
                String string2 = " water mark!";
                ((StringBuilder)object2).append(string2);
                object2 = ((StringBuilder)object2).toString();
                Log.i((String)object, (String)object2);
                object = this.r;
                object2 = object[n10].d;
                if (object2 != null) {
                    object = object[n10].d;
                    GLES20.glDeleteTextures((int)n12, (int[])object, (int)0);
                }
                object = this.r;
                object2 = object[n10];
                f11 = 0.0f;
                string2 = null;
                ((x$a)object2).d = null;
                object2 = object[n10];
                ((x$a)object2).c = null;
                object[n10] = null;
            }
            return;
        }
        Object[] objectArray = this.r;
        Object object3 = objectArray[n10];
        if (object3 != null && n10 < (n11 = objectArray.length)) {
            int n13;
            int n14 = object.getWidth();
            int n15 = object.getHeight();
            object3 = this;
            this.a(n14, n15, f10, f11, f12, n10);
            Object object4 = this.r;
            Object object5 = object4[n10].d;
            int n16 = 3553;
            f12 = 4.979E-42f;
            if (object5 == null) {
                object5 = object4[n10];
                objectArray = new int[n12];
                object5.d = (int[])objectArray;
                object4 = object4[n10].d;
                GLES20.glGenTextures((int)n12, (int[])object4, (int)0);
                object4 = this.r[n10].d;
                n13 = object4[0];
                GLES20.glBindTexture((int)n16, (int)n13);
                f11 = 9729.0f;
                GLES20.glTexParameterf((int)n16, (int)10240, (float)f11);
                GLES20.glTexParameterf((int)n16, (int)10241, (float)f11);
                f11 = 33071.0f;
                GLES20.glTexParameterf((int)n16, (int)10242, (float)f11);
                n13 = 10243;
                f10 = 1.4354E-41f;
                GLES20.glTexParameterf((int)n16, (int)n13, (float)f11);
            }
            object4 = this.r;
            object5 = object4[n10].c;
            if (object5 == null || (n13 = (object4 = object4[n10].c).equals(object)) == false) {
                object4 = this.r[n10].d;
                n13 = object4[0];
                GLES20.glBindTexture((int)n16, (int)n13);
                n13 = (int)(object.isRecycled() ? 1 : 0);
                if (n13 == 0) {
                    GLUtils.texImage2D((int)n16, (int)0, (Bitmap)object, (int)0);
                } else {
                    object4 = this.B;
                    object5 = "SetWaterMark when bitmap is recycled";
                    TXCLog.e((String)object4, (String)object5);
                }
            }
            this.r[n10].c = object;
            return;
        }
        Log.e((String)this.B, (String)"index is too large for mSzWaterMark!");
    }

    public void c(boolean bl2) {
        this.t = bl2;
    }

    public void d() {
        super.d();
        this.t = false;
        this.r();
    }

    public void j() {
        super.j();
        int n10 = this.t;
        if (n10 != 0) {
            Object object;
            int n11;
            n10 = 3042;
            GLES20.glEnable((int)n10);
            GLES20.glBlendFunc((int)this.u, (int)771);
            GLES20.glActiveTexture((int)33984);
            for (int i10 = 0; i10 < (n11 = ((x$a[])(object = this.r)).length); ++i10) {
                Object object2 = object[i10];
                if (object2 == null) continue;
                int n12 = object[i10].d[0];
                GLES20.glBindTexture((int)3553, (int)n12);
                GLES20.glUniform1i((int)this.c, (int)0);
                n11 = this.b;
                int n13 = 5126;
                FloatBuffer floatBuffer = this.r[i10].a;
                GLES20.glVertexAttribPointer((int)n11, (int)2, (int)n13, (boolean)false, (int)8, (Buffer)floatBuffer);
                GLES20.glEnableVertexAttribArray((int)this.b);
                n11 = this.d;
                int n14 = 16;
                object = this.r[i10];
                floatBuffer = object.b;
                GLES20.glVertexAttribPointer((int)n11, (int)4, (int)n13, (boolean)false, (int)n14, (Buffer)floatBuffer);
                GLES20.glEnableVertexAttribArray((int)this.d);
                object2 = v;
                n11 = ((Object)object2).length;
                int n15 = 5123;
                ShortBuffer shortBuffer = this.w;
                GLES20.glDrawElements((int)4, (int)n11, (int)n15, (Buffer)shortBuffer);
                GLES20.glDisableVertexAttribArray((int)this.b);
                n12 = this.d;
                GLES20.glDisableVertexAttribArray((int)n12);
            }
            GLES20.glDisable((int)n10);
        }
    }
}

