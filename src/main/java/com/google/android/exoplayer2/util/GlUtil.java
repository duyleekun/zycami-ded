/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.opengl.EGL14
 *  android.opengl.EGLDisplay
 *  android.opengl.GLES20
 *  android.opengl.GLU
 *  android.text.TextUtils
 */
package com.google.android.exoplayer2.util;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.EGLDisplay;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.GlUtil$Attribute;
import com.google.android.exoplayer2.util.GlUtil$Uniform;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public final class GlUtil {
    private static final String EXTENSION_PROTECTED_CONTENT = "EGL_EXT_protected_content";
    private static final String EXTENSION_SURFACELESS_CONTEXT = "EGL_KHR_surfaceless_context";
    private static final String TAG = "GlUtil";

    private GlUtil() {
    }

    public static /* synthetic */ int access$000(byte[] byArray) {
        return GlUtil.strlen(byArray);
    }

    private static void addShader(int n10, String string2, int n11) {
        n10 = GLES20.glCreateShader((int)n10);
        GLES20.glShaderSource((int)n10, (String)string2);
        GLES20.glCompileShader((int)n10);
        int n12 = 1;
        Object object = new int[n12];
        int n13 = 0;
        StringBuilder stringBuilder = null;
        object[0] = 0;
        int n14 = 35713;
        GLES20.glGetShaderiv((int)n10, (int)n14, (int[])object, (int)0);
        int n15 = object[0];
        if (n15 != n12) {
            String string3 = GLES20.glGetShaderInfoLog((int)n10);
            object = String.valueOf(string3);
            n15 = ((String)object).length() + 10;
            n13 = String.valueOf(string2).length();
            stringBuilder = new StringBuilder(n15 += n13);
            stringBuilder.append(string3);
            string3 = ", source: ";
            stringBuilder.append(string3);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            GlUtil.throwGlError(string2);
        }
        GLES20.glAttachShader((int)n11, (int)n10);
        GLES20.glDeleteShader((int)n10);
        GlUtil.checkGlError();
    }

    public static void checkGlError() {
        int n10;
        while ((n10 = GLES20.glGetError()) != 0) {
            String string2 = "glError ";
            String string3 = String.valueOf(GLU.gluErrorString((int)n10));
            int n11 = string3.length();
            string3 = n11 != 0 ? string2.concat(string3) : new String(string2);
            string2 = TAG;
            Log.e(string2, string3);
        }
    }

    public static int compileProgram(String object, String object2) {
        int n10 = GLES20.glCreateProgram();
        GlUtil.checkGlError();
        GlUtil.addShader(35633, (String)object, n10);
        GlUtil.addShader(35632, (String)object2, n10);
        GLES20.glLinkProgram((int)n10);
        int n11 = 1;
        object2 = new int[n11];
        int n12 = 0;
        object2[0] = false;
        int n13 = 35714;
        GLES20.glGetProgramiv((int)n10, (int)n13, (int[])object2, (int)0);
        Object object3 = object2[0];
        if (object3 != n11) {
            object = "Unable to link shader program: \n";
            object2 = String.valueOf(GLES20.glGetProgramInfoLog((int)n10));
            n12 = ((String)object2).length();
            object = n12 != 0 ? ((String)object).concat((String)object2) : (object2 = new String((String)object));
            GlUtil.throwGlError((String)object);
        }
        GlUtil.checkGlError();
        return n10;
    }

    public static int compileProgram(String[] object, String[] object2) {
        String string2 = "\n";
        object = TextUtils.join((CharSequence)string2, (Object[])object);
        object2 = TextUtils.join((CharSequence)string2, (Object[])object2);
        return GlUtil.compileProgram((String)object, (String)object2);
    }

    public static FloatBuffer createBuffer(int n10) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(n10 * 4);
        ByteOrder byteOrder = ByteOrder.nativeOrder();
        return byteBuffer.order(byteOrder).asFloatBuffer();
    }

    public static FloatBuffer createBuffer(float[] fArray) {
        return (FloatBuffer)GlUtil.createBuffer(fArray.length).put(fArray).flip();
    }

    public static int createExternalTexture() {
        int n10 = 1;
        int[] nArray = new int[n10];
        IntBuffer intBuffer = IntBuffer.wrap(nArray);
        GLES20.glGenTextures((int)n10, (IntBuffer)intBuffer);
        int n11 = nArray[0];
        int n12 = 36197;
        GLES20.glBindTexture((int)n12, (int)n11);
        int n13 = 9729;
        GLES20.glTexParameteri((int)n12, (int)10241, (int)n13);
        GLES20.glTexParameteri((int)n12, (int)10240, (int)n13);
        n13 = 33071;
        GLES20.glTexParameteri((int)n12, (int)10242, (int)n13);
        GLES20.glTexParameteri((int)n12, (int)10243, (int)n13);
        GlUtil.checkGlError();
        return nArray[0];
    }

    public static GlUtil$Attribute[] getAttributes(int n10) {
        int n11 = 1;
        int[] nArray = new int[n11];
        GLES20.glGetProgramiv((int)n10, (int)35721, (int[])nArray, (int)0);
        int n12 = nArray[0];
        int n13 = 2;
        if (n12 == n13) {
            int n14;
            n12 = nArray[0];
            GlUtil$Attribute[] glUtil$AttributeArray = new GlUtil$Attribute[n12];
            for (n13 = 0; n13 < (n14 = nArray[0]); ++n13) {
                GlUtil$Attribute glUtil$Attribute;
                glUtil$AttributeArray[n13] = glUtil$Attribute = new GlUtil$Attribute(n10, n13);
            }
            return glUtil$AttributeArray;
        }
        IllegalStateException illegalStateException = new IllegalStateException("expected two attributes");
        throw illegalStateException;
    }

    public static GlUtil$Uniform[] getUniforms(int n10) {
        int n11;
        int n12 = 1;
        int[] nArray = new int[n12];
        GLES20.glGetProgramiv((int)n10, (int)35718, (int[])nArray, (int)0);
        int n13 = nArray[0];
        GlUtil$Uniform[] glUtil$UniformArray = new GlUtil$Uniform[n13];
        for (int i10 = 0; i10 < (n11 = nArray[0]); ++i10) {
            GlUtil$Uniform glUtil$Uniform;
            glUtil$UniformArray[i10] = glUtil$Uniform = new GlUtil$Uniform(n10, i10);
        }
        return glUtil$UniformArray;
    }

    public static boolean isProtectedContentExtensionSupported(Context object) {
        String string2;
        boolean bl2;
        String string3;
        String string4;
        boolean bl3;
        int n10 = Util.SDK_INT;
        boolean bl4 = false;
        int n11 = 24;
        if (n10 < n11) {
            return false;
        }
        n11 = 26;
        if (n10 < n11 && ((bl3 = (string4 = "samsung").equals(string3 = Util.MANUFACTURER)) || (bl3 = (string4 = "XT1650").equals(string3 = Util.MODEL)))) {
            return false;
        }
        if (n10 < n11 && !(bl2 = (object = object.getPackageManager()).hasSystemFeature(string2 = "android.hardware.vr.high_performance"))) {
            return false;
        }
        object = EGL14.eglGetDisplay((int)0);
        n10 = 12373;
        if ((object = EGL14.eglQueryString((EGLDisplay)object, (int)n10)) != null && (bl2 = ((String)object).contains(string2 = EXTENSION_PROTECTED_CONTENT))) {
            bl4 = true;
        }
        return bl4;
    }

    public static boolean isSurfacelessContextExtensionSupported() {
        String string2;
        int n10 = Util.SDK_INT;
        boolean bl2 = false;
        int n11 = 17;
        if (n10 < n11) {
            return false;
        }
        Object object = EGL14.eglGetDisplay((int)0);
        n11 = 12373;
        if ((object = EGL14.eglQueryString((EGLDisplay)object, (int)n11)) != null && (n10 = (int)(((String)object).contains(string2 = EXTENSION_SURFACELESS_CONTEXT) ? 1 : 0)) != 0) {
            bl2 = true;
        }
        return bl2;
    }

    private static int strlen(byte[] byArray) {
        int n10;
        for (int i10 = 0; i10 < (n10 = byArray.length); ++i10) {
            n10 = byArray[i10];
            if (n10 != 0) continue;
            return i10;
        }
        return byArray.length;
    }

    private static void throwGlError(String string2) {
        Log.e(TAG, string2);
    }
}

