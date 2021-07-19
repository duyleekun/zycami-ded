/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.opengl.GLES20
 *  android.opengl.GLES30
 *  android.opengl.GLUtils
 *  android.opengl.Matrix
 *  android.util.Log
 */
package d.v.b0.f.c.b;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.util.Log;
import d.v.b0.j.b;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;

public abstract class e {
    public static final String a = "GlUtil";
    public static final float[] b;
    private static final int c = 4;
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    public static final int g = 3;
    public static final int h = 4;

    static {
        float[] fArray = new float[16];
        b = fArray;
        Matrix.setIdentityM((float[])fArray, (int)0);
    }

    private e() {
    }

    public static float[] a(int n10, int n11, int n12, int n13) {
        float[] fArray = b;
        int n14 = fArray.length;
        fArray = Arrays.copyOf(fArray, n14);
        d.v.b0.f.c.b.e.o(fArray, 1, n12, n13, n10, n11);
        return fArray;
    }

    public static float[] b(int n10, int n11, int n12, int n13) {
        float[] fArray = b;
        int n14 = fArray.length;
        fArray = Arrays.copyOf(fArray, n14);
        d.v.b0.f.c.b.e.o(fArray, 3, n12, n13, n10, n11);
        return fArray;
    }

    public static float[] c(float f10, float f11, float f12, float f13) {
        f10 = f10 * f13 / f11 / f12;
        float[] fArray = b;
        int n10 = fArray.length;
        fArray = Arrays.copyOf(fArray, n10);
        n10 = 1065353216;
        f12 = 1.0f;
        float f14 = f10 - f12;
        Object object = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
        float f15 = object > 0 ? f12 / f10 : f12;
        if (object > 0) {
            f10 = f12;
        }
        Matrix.scaleM((float[])fArray, (int)0, (float)f15, (float)f10, (float)f12);
        return fArray;
    }

    public static void d(String string2) {
        int n10 = GLES20.glGetError();
        if (n10 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(": glError 0x");
            string2 = Integer.toHexString(n10);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            d.v.b0.j.b.b(string2);
        }
    }

    public static void e(int n10, String string2) {
        if (n10 < 0) {
            CharSequence charSequence = new StringBuilder();
            String string3 = "Unable to locate '";
            charSequence.append(string3);
            charSequence.append(string2);
            string2 = "' in program";
            charSequence.append(string2);
            charSequence = charSequence.toString();
            d.v.b0.j.b.b((String)charSequence);
        }
    }

    public static FloatBuffer f(float[] fArray) {
        Buffer buffer = ByteBuffer.allocateDirect(fArray.length * 4);
        ByteOrder byteOrder = ByteOrder.nativeOrder();
        ((ByteBuffer)buffer).order(byteOrder);
        buffer = ((ByteBuffer)buffer).asFloatBuffer();
        ((FloatBuffer)buffer).put(fArray);
        ((FloatBuffer)buffer).position(0);
        return buffer;
    }

    public static void g(int[] nArray, int[] nArray2, int n10, int n11) {
        GLES20.glGenFramebuffers((int)nArray2.length, (int[])nArray2, (int)0);
        GLES20.glGenTextures((int)nArray.length, (int[])nArray, (int)0);
        int n12 = nArray2[0];
        int n13 = 36160;
        GLES20.glBindFramebuffer((int)n13, (int)n12);
        n12 = nArray[0];
        int n14 = 3553;
        GLES20.glBindTexture((int)n14, (int)n12);
        GLES20.glTexImage2D((int)3553, (int)0, (int)6408, (int)n10, (int)n11, (int)0, (int)6408, (int)5121, null);
        n10 = 33071;
        GLES20.glTexParameteri((int)n14, (int)10242, (int)n10);
        GLES20.glTexParameteri((int)n14, (int)10243, (int)n10);
        n10 = 9729;
        GLES20.glTexParameteri((int)n14, (int)10240, (int)n10);
        GLES20.glTexParameteri((int)n14, (int)10241, (int)n10);
        int n15 = nArray[0];
        GLES20.glFramebufferTexture2D((int)n13, (int)36064, (int)n14, (int)n15, (int)0);
        GLES20.glBindTexture((int)n14, (int)0);
        GLES20.glBindFramebuffer((int)n13, (int)0);
    }

    public static int h(Bitmap bitmap) {
        int n10 = 1;
        int[] nArray = new int[n10];
        GLES20.glGenTextures((int)n10, (int[])nArray, (int)0);
        n10 = nArray[0];
        d.v.b0.f.c.b.e.d("glGenTextures");
        int n11 = 3553;
        GLES20.glBindTexture((int)n11, (int)n10);
        int n12 = 9729;
        GLES20.glTexParameteri((int)n11, (int)10241, (int)n12);
        GLES20.glTexParameteri((int)n11, (int)10240, (int)n12);
        n12 = 33071;
        GLES20.glTexParameteri((int)n11, (int)10242, (int)n12);
        GLES20.glTexParameteri((int)n11, (int)10243, (int)n12);
        String string2 = "loadImageTexture";
        d.v.b0.f.c.b.e.d(string2);
        GLUtils.texImage2D((int)n11, (int)0, (Bitmap)bitmap, (int)0);
        d.v.b0.f.c.b.e.d(string2);
        return n10;
    }

    public static int i(ByteBuffer byteBuffer, int n10, int n11, int n12) {
        int n13 = 1;
        Object object = new int[n13];
        GLES20.glGenTextures((int)n13, (int[])object, (int)0);
        n13 = object[0];
        d.v.b0.f.c.b.e.d("glGenTextures");
        int n14 = 3553;
        GLES20.glBindTexture((int)n14, (int)n13);
        int n15 = 9729;
        GLES20.glTexParameteri((int)n14, (int)10241, (int)n15);
        GLES20.glTexParameteri((int)n14, (int)10240, (int)n15);
        object = "loadImageTexture";
        d.v.b0.f.c.b.e.d((String)object);
        GLES20.glTexImage2D((int)3553, (int)0, (int)n12, (int)n10, (int)n11, (int)0, (int)n12, (int)5121, (Buffer)byteBuffer);
        d.v.b0.f.c.b.e.d((String)object);
        return n13;
    }

    public static int j(String string2, String object) {
        int n10 = d.v.b0.f.c.b.e.q(35633, string2);
        int n11 = 0;
        if (n10 == 0) {
            return 0;
        }
        int n12 = 35632;
        Object object2 = d.v.b0.f.c.b.e.q(n12, (String)object);
        if (object2 == 0) {
            return 0;
        }
        n12 = GLES20.glCreateProgram();
        d.v.b0.f.c.b.e.d("glCreateProgram");
        String string3 = a;
        if (n12 == 0) {
            String string4 = "Could not create program";
            Log.e((String)string3, (String)string4);
        }
        GLES20.glAttachShader((int)n12, (int)n10);
        string2 = "glAttachShader";
        d.v.b0.f.c.b.e.d(string2);
        GLES20.glAttachShader((int)n12, (int)object2);
        d.v.b0.f.c.b.e.d(string2);
        GLES20.glLinkProgram((int)n12);
        n10 = 1;
        object = new int[n10];
        int n13 = 35714;
        GLES20.glGetProgramiv((int)n12, (int)n13, (int[])object, (int)0);
        object2 = object[0];
        if (object2 != n10) {
            Log.e((String)string3, (String)"Could not link program: ");
            string2 = GLES20.glGetProgramInfoLog((int)n12);
            Log.e((String)string3, (String)string2);
            GLES20.glDeleteProgram((int)n12);
        } else {
            n11 = n12;
        }
        return n11;
    }

    public static int k(int n10) {
        int n11 = 1;
        Object object = new int[n11];
        GLES20.glGenTextures((int)n11, (int[])object, (int)0);
        d.v.b0.f.c.b.e.d("glGenTextures");
        n11 = object[0];
        GLES20.glBindTexture((int)n10, (int)n11);
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("glBindTexture ");
        ((StringBuilder)object).append(n11);
        d.v.b0.f.c.b.e.d(((StringBuilder)object).toString());
        float f10 = 9729.0f;
        GLES20.glTexParameterf((int)n10, (int)10241, (float)f10);
        GLES20.glTexParameterf((int)n10, (int)10240, (float)f10);
        int n12 = 33071;
        GLES20.glTexParameteri((int)n10, (int)10242, (int)n12);
        GLES20.glTexParameteri((int)n10, (int)10243, (int)n12);
        d.v.b0.f.c.b.e.d("glTexParameter");
        return n11;
    }

    public static void l(int[] nArray) {
        int n10;
        if (nArray != null && (n10 = nArray.length) > 0) {
            n10 = nArray.length;
            GLES20.glDeleteFramebuffers((int)n10, (int[])nArray, (int)0);
        }
    }

    public static void m(int[] nArray) {
        int n10;
        if (nArray != null && (n10 = nArray.length) > 0) {
            n10 = nArray.length;
            GLES20.glDeleteTextures((int)n10, (int[])nArray, (int)0);
        }
    }

    public static int n() {
        int[] nArray = new int[1];
        GLES30.glGetIntegerv((int)33307, (int[])nArray, (int)0);
        return nArray[0];
    }

    public static void o(float[] fArray, int n10, int n11, int n12, int n13, int n14) {
        int n15 = n12;
        int n16 = n14;
        if (n12 > 0 && n11 > 0 && n13 > 0 && n14 > 0) {
            float f10;
            int n17 = 16;
            float[] fArray2 = new float[n17];
            float[] fArray3 = new float[n17];
            float f11 = n13;
            float f12 = n14;
            float f13 = n11;
            float f14 = n12;
            float f15 = (f13 /= f14) - (f11 /= f12);
            n15 = (int)(f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1));
            n16 = 4;
            f12 = 5.6E-45f;
            int n18 = 3;
            int n19 = 2;
            int n20 = 1;
            float f16 = Float.MIN_VALUE;
            float f17 = 1.0f;
            float f18 = 2.0f;
            if (n15 > 0) {
                if (n10 != n20) {
                    if (n10 != n19) {
                        if (n10 != n18) {
                            if (n10 == n16) {
                                n19 = 0;
                                n20 = -1082130432;
                                f16 = -1.0f;
                                f10 = 1.0f;
                                n15 = -1082130432;
                                f14 = -1.0f;
                                f13 = f13 * f18 / f11;
                                float f19 = f13 - f17;
                                float f20 = 1.0f;
                                float f21 = 3.0f;
                                f17 = f10;
                                f18 = f14;
                                Matrix.orthoM((float[])fArray2, (int)0, (float)f16, (float)f10, (float)f14, (float)f19, (float)f20, (float)f21);
                            }
                        } else {
                            n19 = 0;
                            n20 = -1082130432;
                            f16 = -1.0f;
                            f10 = 1.0f;
                            f13 = f13 * f18 / f11;
                            f18 = f17 - f13;
                            float f22 = 1.0f;
                            float f23 = 1.0f;
                            float f24 = 3.0f;
                            f17 = f10;
                            Matrix.orthoM((float[])fArray2, (int)0, (float)f16, (float)f10, (float)f18, (float)f22, (float)f23, (float)f24);
                        }
                    } else {
                        n19 = 0;
                        n20 = -1082130432;
                        f16 = -1.0f;
                        f17 = 1.0f;
                        f10 = -f13;
                        f18 = f10 / f11;
                        float f25 = f13 / f11;
                        float f26 = 1.0f;
                        float f27 = 3.0f;
                        Matrix.orthoM((float[])fArray2, (int)0, (float)f16, (float)f17, (float)f18, (float)f25, (float)f26, (float)f27);
                    }
                } else {
                    n19 = 0;
                    f10 = -f11;
                    f16 = f10 / f13;
                    f17 = f11 / f13;
                    f18 = -1.0f;
                    float f28 = 1.0f;
                    float f29 = 1.0f;
                    float f30 = 3.0f;
                    Matrix.orthoM((float[])fArray2, (int)0, (float)f16, (float)f17, (float)f18, (float)f28, (float)f29, (float)f30);
                }
            } else if (n10 != n20) {
                if (n10 != n19) {
                    if (n10 != n18) {
                        if (n10 == n16) {
                            n19 = 0;
                            f11 = f11 * f18 / f13;
                            f16 = f17 - f11;
                            f17 = 1.0f;
                            f18 = -1.0f;
                            float f31 = 1.0f;
                            float f32 = 1.0f;
                            float f33 = 3.0f;
                            Matrix.orthoM((float[])fArray2, (int)0, (float)f16, (float)f17, (float)f18, (float)f31, (float)f32, (float)f33);
                        }
                    } else {
                        n19 = 0;
                        n20 = -1082130432;
                        f16 = -1.0f;
                        f11 = f11 * f18 / f13;
                        f17 = f11 - f17;
                        f18 = -1.0f;
                        float f34 = 1.0f;
                        float f35 = 1.0f;
                        float f36 = 3.0f;
                        Matrix.orthoM((float[])fArray2, (int)0, (float)f16, (float)f17, (float)f18, (float)f34, (float)f35, (float)f36);
                    }
                } else {
                    n19 = 0;
                    f10 = -f11;
                    f16 = f10 / f13;
                    f17 = f11 / f13;
                    f18 = -1.0f;
                    float f37 = 1.0f;
                    float f38 = 1.0f;
                    float f39 = 3.0f;
                    Matrix.orthoM((float[])fArray2, (int)0, (float)f16, (float)f17, (float)f18, (float)f37, (float)f38, (float)f39);
                }
            } else {
                n19 = 0;
                n20 = -1082130432;
                f16 = -1.0f;
                f17 = 1.0f;
                f10 = -f13;
                f18 = f10 / f11;
                float f40 = f13 / f11;
                float f41 = 1.0f;
                float f42 = 3.0f;
                Matrix.orthoM((float[])fArray2, (int)0, (float)f16, (float)f17, (float)f18, (float)f40, (float)f41, (float)f42);
            }
            float f43 = 1.0f;
            float f44 = 1.0f;
            Matrix.setLookAtM((float[])fArray3, (int)0, (float)0.0f, (float)0.0f, (float)f43, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)f44, (float)0.0f);
            f10 = 0.0f;
            f13 = 0.0f;
            n15 = 0;
            f14 = 0.0f;
            n10 = 0;
            n12 = 0;
            n14 = 0;
            Matrix.multiplyMM((float[])fArray, (int)0, (float[])fArray2, (int)0, (float[])fArray3, (int)0);
        }
    }

    public static int p(Context object) {
        String string2 = "activity";
        object = ((ActivityManager)object.getSystemService(string2)).getDeviceConfigurationInfo();
        int n10 = object.reqGlEsVersion;
        int n11 = 196608;
        n10 = n10 >= n11 ? 3 : 2;
        String string3 = object.getGlEsVersion();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("reqGlEsVersion: ");
        object = Integer.toHexString(object.reqGlEsVersion);
        stringBuilder.append((String)object);
        stringBuilder.append(", glEsVersion: ");
        stringBuilder.append(string3);
        stringBuilder.append(", return: ");
        stringBuilder.append(n10);
        object = stringBuilder.toString();
        Log.d((String)a, (String)object);
        return n10;
    }

    public static int q(int n10, String object) {
        int n11 = GLES20.glCreateShader((int)n10);
        CharSequence charSequence = new StringBuilder();
        charSequence.append("glCreateShader type=");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        d.v.b0.f.c.b.e.d((String)charSequence);
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
            object = a;
            Log.e((String)object, (String)charSequence2);
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append(" ");
            charSequence = GLES20.glGetShaderInfoLog((int)n11);
            ((StringBuilder)charSequence2).append((String)charSequence);
            charSequence2 = ((StringBuilder)charSequence2).toString();
            Log.e((String)object, (String)charSequence2);
            GLES20.glDeleteShader((int)n11);
            n11 = 0;
        }
        return n11;
    }

    public static void r() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("vendor  : ");
        int n10 = 7936;
        String string2 = GLES20.glGetString((int)n10);
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        string2 = a;
        Log.i((String)string2, (String)object);
        object = new StringBuilder();
        ((StringBuilder)object).append("renderer: ");
        String string3 = GLES20.glGetString((int)7937);
        ((StringBuilder)object).append(string3);
        object = ((StringBuilder)object).toString();
        Log.i((String)string2, (String)object);
        object = new StringBuilder();
        ((StringBuilder)object).append("version : ");
        string3 = GLES20.glGetString((int)7938);
        ((StringBuilder)object).append(string3);
        object = ((StringBuilder)object).toString();
        Log.i((String)string2, (String)object);
        object = new int[1];
        StringBuilder stringBuilder = null;
        GLES30.glGetIntegerv((int)33307, (int[])object, (int)0);
        Object object2 = object[0];
        int n11 = 33308;
        GLES30.glGetIntegerv((int)n11, (int[])object, (int)0);
        Object object3 = object[0];
        int n12 = GLES30.glGetError();
        if (n12 == 0) {
            stringBuilder = new StringBuilder();
            String string4 = "glVersion: ";
            stringBuilder.append(string4);
            stringBuilder.append((int)object2);
            string3 = ".";
            stringBuilder.append(string3);
            stringBuilder.append((int)object3);
            object = stringBuilder.toString();
            Log.i((String)string2, (String)object);
        }
    }

    public static float[] s(float f10, float f11, float f12, float f13) {
        float f14;
        float f15;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("scaleMatrix viewWidth:");
        charSequence.append(f10);
        charSequence.append("  viewHeight:");
        charSequence.append(f11);
        charSequence.append("  textureWidth:");
        charSequence.append(f12);
        String string2 = " textureHeight:";
        charSequence.append(string2);
        charSequence.append(f13);
        charSequence = charSequence.toString();
        d.v.b0.j.b.c((String)charSequence);
        float f16 = f10 / f12;
        float f17 = f11 / f13;
        float[] fArray = b;
        int n10 = fArray.length;
        fArray = Arrays.copyOf(fArray, n10);
        n10 = (int)(f10 == f12 ? 0 : (f10 > f12 ? 1 : -1));
        String string3 = " scale:";
        String string4 = "  scaleY:";
        float f18 = 1.0f;
        if (n10 >= 0 && (f15 = f11 == f13 ? 0 : (f11 > f13 ? 1 : -1)) >= 0) {
            f10 = Math.max(f16, f17);
            Matrix.scaleM((float[])fArray, (int)0, (float)f10, (float)f10, (float)f18);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("viewWidth >= textureWidth  viewHeight >= textureHeight , scaleX:");
            stringBuilder.append(f16);
            stringBuilder.append(string4);
            stringBuilder.append(f17);
            stringBuilder.append(string3);
            stringBuilder.append(f10);
            d.v.b0.j.b.c(stringBuilder.toString());
            return fArray;
        }
        Object object = f10 == f12 ? 0 : (f10 < f12 ? -1 : 1);
        if (object <= 0 && (f14 = f11 == f13 ? 0 : (f11 < f13 ? -1 : 1)) <= 0) {
            f10 = Math.min(f16, f17);
            Matrix.scaleM((float[])fArray, (int)0, (float)f10, (float)f10, (float)f18);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("viewWidth <= textureWidth  viewHeight <= textureHeight , scaleX:");
            stringBuilder.append(f16);
            stringBuilder.append(string4);
            stringBuilder.append(f17);
            stringBuilder.append(string3);
            stringBuilder.append(f10);
            d.v.b0.j.b.c(stringBuilder.toString());
            return fArray;
        }
        if (n10 >= 0 && (f14 = f11 == f13 ? 0 : (f11 < f13 ? -1 : 1)) <= 0) {
            Matrix.scaleM((float[])fArray, (int)0, (float)f16, (float)f16, (float)f18);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("viewWidth >= textureWidth  viewHeight <= textureHeight , scaleX:");
            stringBuilder.append(f16);
            stringBuilder.append(string4);
            stringBuilder.append(f17);
            stringBuilder.append(string3);
            stringBuilder.append(f16);
            d.v.b0.j.b.c(stringBuilder.toString());
            return fArray;
        }
        if (object <= 0 && (object = f11 == f13 ? 0 : (f11 > f13 ? 1 : -1)) >= 0) {
            Matrix.scaleM((float[])fArray, (int)0, (float)f17, (float)f17, (float)f18);
            CharSequence charSequence2 = new StringBuilder();
            String string5 = "viewWidth <= textureWidth  viewHeight >= textureHeight , scaleX:";
            charSequence2.append(string5);
            charSequence2.append(f16);
            charSequence2.append(string4);
            charSequence2.append(f17);
            charSequence2.append(string3);
            charSequence2.append(f17);
            charSequence2 = charSequence2.toString();
            d.v.b0.j.b.c((String)charSequence2);
        }
        return fArray;
    }
}

