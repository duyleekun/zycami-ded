/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.opengl.EGL14
 *  android.opengl.GLES20
 *  android.opengl.GLES30
 *  android.opengl.GLUtils
 *  android.os.Build$VERSION
 *  javax.microedition.khronos.egl.EGL10
 *  javax.microedition.khronos.egl.EGLContext
 */
package com.tencent.liteav.basic.opengl;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLUtils;
import android.os.Build;
import com.tencent.liteav.basic.log.TXCLog;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;

public class TXCOpenGlUtils {
    public static FloatBuffer a;
    public static FloatBuffer b;
    public static FloatBuffer c;
    public static FloatBuffer d;
    public static FloatBuffer e;
    private static float[] f;
    private static float[] g;
    private static float[] h;
    private static float[] i;
    private static float[] j;
    private static int k;

    static {
        float[] fArray;
        float[] fArray2;
        float[] fArray3;
        int n10 = 8;
        float[] fArray4 = fArray3 = new float[n10];
        float[] fArray5 = fArray3;
        fArray4[0] = -1.0f;
        fArray5[1] = -1.0f;
        fArray4[2] = 1.0f;
        fArray5[3] = -1.0f;
        fArray4[4] = -1.0f;
        fArray5[5] = 1.0f;
        fArray4[6] = 1.0f;
        fArray5[7] = 1.0f;
        f = fArray3;
        float[] fArray6 = fArray2 = new float[n10];
        float[] fArray7 = fArray2;
        fArray6[0] = 0.0f;
        fArray7[1] = 0.0f;
        fArray6[2] = 1.0f;
        fArray7[3] = 0.0f;
        fArray6[4] = 0.0f;
        fArray7[5] = 1.0f;
        fArray6[6] = 1.0f;
        fArray7[7] = 1.0f;
        g = fArray2;
        float[] fArray8 = fArray2 = new float[n10];
        float[] fArray9 = fArray2;
        fArray8[0] = 0.0f;
        fArray9[1] = 1.0f;
        fArray8[2] = 0.0f;
        fArray9[3] = 0.0f;
        fArray8[4] = 1.0f;
        fArray9[5] = 1.0f;
        fArray8[6] = 1.0f;
        fArray9[7] = 0.0f;
        h = fArray2;
        float[] fArray10 = fArray2 = new float[n10];
        float[] fArray11 = fArray2;
        fArray10[0] = 1.0f;
        fArray11[1] = 0.0f;
        fArray10[2] = 1.0f;
        fArray11[3] = 1.0f;
        fArray10[4] = 0.0f;
        fArray11[5] = 0.0f;
        fArray10[6] = 0.0f;
        fArray11[7] = 1.0f;
        i = fArray2;
        float[] fArray12 = fArray = new float[n10];
        float[] fArray13 = fArray;
        fArray12[0] = 1.0f;
        fArray13[1] = 0.0f;
        fArray12[2] = 0.0f;
        fArray13[3] = 0.0f;
        fArray12[4] = 1.0f;
        fArray13[5] = 1.0f;
        fArray12[6] = 0.0f;
        fArray13[7] = 1.0f;
        j = fArray;
        a = TXCOpenGlUtils.a(fArray3);
        b = TXCOpenGlUtils.a(g);
        c = TXCOpenGlUtils.a(h);
        d = TXCOpenGlUtils.a(i);
        e = TXCOpenGlUtils.a(j);
        k = 2;
    }

    public static final int a() {
        return k;
    }

    public static int a(int n10, int n11, int n12, int n13) {
        return TXCOpenGlUtils.a(n10, n11, n12, n13, null);
    }

    public static int a(int n10, int n11, int n12, int n13, IntBuffer intBuffer) {
        int n14 = TXCOpenGlUtils.c();
        int n15 = 3553;
        GLES20.glBindTexture((int)n15, (int)n14);
        GLES20.glTexImage2D((int)3553, (int)0, (int)n12, (int)n10, (int)n11, (int)0, (int)n13, (int)5121, (Buffer)intBuffer);
        GLES20.glBindTexture((int)n15, (int)0);
        return n14;
    }

    public static int a(int n10, int n11, int n12, int n13, int[] nArray) {
        GLES20.glGenTextures((int)1, (int[])nArray, (int)0);
        int n14 = nArray[0];
        int n15 = 3553;
        GLES20.glBindTexture((int)n15, (int)n14);
        int n16 = 33071;
        GLES20.glTexParameteri((int)n15, (int)10242, (int)n16);
        GLES20.glTexParameteri((int)n15, (int)10243, (int)n16);
        GLES20.glTexParameteri((int)n15, (int)10241, (int)9728);
        GLES20.glTexParameteri((int)n15, (int)10240, (int)9729);
        GLES20.glTexImage2D((int)3553, (int)0, (int)n12, (int)n10, (int)n11, (int)0, (int)n13, (int)5121, null);
        return nArray[0];
    }

    public static int a(int n10, int n11, int[] nArray) {
        n10 = n10 * n11 * 4;
        GLES30.glGenBuffers((int)1, (int[])nArray, (int)0);
        n11 = nArray[0];
        int n12 = 35051;
        GLES30.glBindBuffer((int)n12, (int)n11);
        GLES30.glBufferData((int)n12, (int)n10, null, (int)35049);
        GLES30.glBindBuffer((int)n12, (int)0);
        return nArray[0];
    }

    public static int a(Bitmap bitmap, int n10, boolean bl2) {
        int n11 = 1;
        float f10 = Float.MIN_VALUE;
        int[] nArray = new int[n11];
        int n12 = 3553;
        int n13 = -1;
        if (n10 == n13) {
            GLES20.glGenTextures((int)n11, (int[])nArray, (int)0);
            n10 = nArray[0];
            GLES20.glBindTexture((int)n12, (int)n10);
            f10 = 9729.0f;
            GLES20.glTexParameterf((int)n12, (int)10240, (float)f10);
            GLES20.glTexParameterf((int)n12, (int)10241, (float)f10);
            n11 = 1191259904;
            f10 = 33071.0f;
            GLES20.glTexParameterf((int)n12, (int)10242, (float)f10);
            n10 = 10243;
            GLES20.glTexParameterf((int)n12, (int)n10, (float)f10);
            GLUtils.texImage2D((int)n12, (int)0, (Bitmap)bitmap, (int)0);
        } else {
            GLES20.glBindTexture((int)n12, (int)n10);
            GLUtils.texSubImage2D((int)n12, (int)0, (int)0, (int)0, (Bitmap)bitmap);
            nArray[0] = n10;
        }
        if (bl2) {
            bitmap.recycle();
        }
        return nArray[0];
    }

    public static int a(String charSequence, int n10) {
        int n11 = 1;
        int[] nArray = new int[n11];
        n10 = GLES20.glCreateShader((int)n10);
        GLES20.glShaderSource((int)n10, (String)charSequence);
        GLES20.glCompileShader((int)n10);
        GLES20.glGetShaderiv((int)n10, (int)35713, (int[])nArray, (int)0);
        int n12 = nArray[0];
        if (n12 == 0) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("Compilation\n");
            String string2 = GLES20.glGetShaderInfoLog((int)n10);
            ((StringBuilder)charSequence).append(string2);
            charSequence = ((StringBuilder)charSequence).toString();
            TXCLog.w("Load Shader Failed", (String)charSequence);
            return 0;
        }
        return n10;
    }

    public static int a(String string2, String string3) {
        int n10 = 1;
        int[] nArray = new int[n10];
        int n11 = 35633;
        int n12 = TXCOpenGlUtils.a(string2, n11);
        String string4 = "Load Program";
        if (n12 == 0) {
            TXCLog.w(string4, "Vertex Shader Failed");
            return 0;
        }
        int n13 = 35632;
        int n14 = TXCOpenGlUtils.a(string3, n13);
        if (n14 == 0) {
            TXCLog.w(string4, "Fragment Shader Failed");
            return 0;
        }
        n13 = GLES20.glCreateProgram();
        GLES20.glAttachShader((int)n13, (int)n12);
        GLES20.glAttachShader((int)n13, (int)n14);
        GLES20.glLinkProgram((int)n13);
        int n15 = 35714;
        GLES20.glGetProgramiv((int)n13, (int)n15, (int[])nArray, (int)0);
        n10 = nArray[0];
        if (n10 <= 0) {
            TXCLog.w(string4, "Linking Failed");
            return 0;
        }
        GLES20.glDeleteShader((int)n12);
        GLES20.glDeleteShader((int)n14);
        return n13;
    }

    public static int a(ByteBuffer byteBuffer, int n10, int n11, int n12) {
        int n13 = n12;
        int n14 = 1;
        float f10 = Float.MIN_VALUE;
        int[] nArray = new int[n14];
        int n15 = 3553;
        int n16 = -1;
        if (n12 == n16) {
            GLES20.glGenTextures((int)n14, (int[])nArray, (int)0);
            n13 = nArray[0];
            GLES20.glBindTexture((int)n15, (int)n13);
            f10 = 9729.0f;
            GLES20.glTexParameterf((int)n15, (int)10240, (float)f10);
            GLES20.glTexParameterf((int)n15, (int)10241, (float)f10);
            n14 = 1191259904;
            f10 = 33071.0f;
            GLES20.glTexParameterf((int)n15, (int)10242, (float)f10);
            n13 = 10243;
            GLES20.glTexParameterf((int)n15, (int)n13, (float)f10);
            n16 = 3553;
            int n17 = 6408;
            int n18 = 6408;
            int n19 = 5121;
            GLES20.glTexImage2D((int)n16, (int)0, (int)n17, (int)n10, (int)n11, (int)0, (int)n18, (int)n19, (Buffer)byteBuffer);
        } else {
            GLES20.glBindTexture((int)n15, (int)n12);
            int n20 = 3553;
            int n21 = 6408;
            int n22 = 5121;
            GLES20.glTexSubImage2D((int)n20, (int)0, (int)0, (int)0, (int)n10, (int)n11, (int)n21, (int)n22, (Buffer)byteBuffer);
            nArray[0] = n12;
        }
        return nArray[0];
    }

    public static FloatBuffer a(float[] fArray) {
        Buffer buffer = ByteBuffer.allocateDirect(fArray.length * 4);
        ByteOrder byteOrder = ByteOrder.nativeOrder();
        ((ByteBuffer)buffer).order(byteOrder);
        buffer = ((ByteBuffer)buffer).asFloatBuffer();
        ((FloatBuffer)buffer).put(fArray);
        ((FloatBuffer)buffer).position(0);
        return buffer;
    }

    public static void a(int n10) {
        k = n10;
    }

    public static void a(int n10, int n11) {
        int n12 = 36160;
        GLES20.glBindFramebuffer((int)n12, (int)n11);
        GLES20.glFramebufferTexture2D((int)n12, (int)36064, (int)3553, (int)n10, (int)0);
        GLES20.glBindFramebuffer((int)n12, (int)0);
    }

    public static void a(String string2) {
        int n10 = GLES20.glGetError();
        if (n10 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(": glError 0x");
            string2 = Integer.toHexString(n10);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            String string3 = "OpenGlUtils";
            TXCLog.e(string3, string2);
        }
    }

    public static void a(ByteBuffer object, int n10, int n11, int n12, int[] nArray) {
        boolean bl2 = ((ByteBuffer)object).isDirect();
        if (bl2) {
            TXCOpenGlUtils.nativeLoadYuv420ByteBufferToTextures((ByteBuffer)object, n10, n11, n12, nArray);
        } else {
            object = ((ByteBuffer)object).array();
            TXCOpenGlUtils.nativeLoadYuv420ByteArrayToTextures((byte[])object, n10, n11, n12, nArray);
        }
    }

    public static int b() {
        int n10 = 1;
        int[] nArray = new int[n10];
        GLES20.glGenTextures((int)n10, (int[])nArray, (int)0);
        n10 = nArray[0];
        int n11 = 36197;
        GLES20.glBindTexture((int)n11, (int)n10);
        float f10 = 9729.0f;
        GLES20.glTexParameterf((int)n11, (int)10241, (float)f10);
        GLES20.glTexParameterf((int)n11, (int)10240, (float)f10);
        int n12 = 33071;
        GLES20.glTexParameteri((int)n11, (int)10242, (int)n12);
        GLES20.glTexParameteri((int)n11, (int)10243, (int)n12);
        return nArray[0];
    }

    public static void b(int n10) {
        int n11 = -1;
        if (n10 != n11) {
            n11 = 1;
            int[] nArray = new int[n11];
            nArray[0] = n10;
            GLES20.glDeleteFramebuffers((int)n11, (int[])nArray, (int)0);
        }
    }

    public static int c() {
        int n10 = 1;
        int[] nArray = new int[n10];
        GLES20.glGenTextures((int)n10, (int[])nArray, (int)0);
        n10 = nArray[0];
        int n11 = 3553;
        GLES20.glBindTexture((int)n11, (int)n10);
        float f10 = 9729.0f;
        GLES20.glTexParameterf((int)n11, (int)10241, (float)f10);
        GLES20.glTexParameterf((int)n11, (int)10240, (float)f10);
        int n12 = 33071;
        GLES20.glTexParameteri((int)n11, (int)10242, (int)n12);
        GLES20.glTexParameteri((int)n11, (int)10243, (int)n12);
        GLES20.glBindTexture((int)n11, (int)0);
        return nArray[0];
    }

    public static void c(int n10) {
        int n11 = -1;
        if (n10 != n11) {
            n11 = 1;
            int[] nArray = new int[n11];
            nArray[0] = n10;
            GLES20.glDeleteTextures((int)n11, (int[])nArray, (int)0);
        }
    }

    public static int d() {
        int n10 = 1;
        int[] nArray = new int[n10];
        GLES20.glGenFramebuffers((int)n10, (int[])nArray, (int)0);
        return nArray[0];
    }

    public static void d(int n10) {
        int n11 = 36160;
        GLES20.glBindFramebuffer((int)n11, (int)n10);
        GLES20.glFramebufferTexture2D((int)n11, (int)36064, (int)3553, (int)0, (int)0);
        GLES20.glBindFramebuffer((int)n11, (int)0);
    }

    public static Object e() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 >= n11) {
            return EGL14.eglGetCurrentContext();
        }
        return ((EGL10)EGLContext.getEGL()).eglGetCurrentContext();
    }

    private static native void nativeLoadYuv420ByteArrayToTextures(byte[] var0, int var1, int var2, int var3, int[] var4);

    private static native void nativeLoadYuv420ByteBufferToTextures(ByteBuffer var0, int var1, int var2, int var3, int[] var4);
}

