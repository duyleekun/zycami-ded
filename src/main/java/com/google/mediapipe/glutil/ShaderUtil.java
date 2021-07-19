/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.opengl.GLES20
 *  android.opengl.GLUtils
 */
package com.google.mediapipe.glutil;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.google.common.flogger.FluentLogger;
import com.google.common.flogger.FluentLogger$Api;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Map;

public class ShaderUtil {
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    public static void checkGlError(String string2) {
        int n10 = GLES20.glGetError();
        if (n10 == 0) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(": GL error: 0x");
        string2 = Integer.toHexString(n10);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        RuntimeException runtimeException = new RuntimeException(string2);
        throw runtimeException;
    }

    public static int createProgram(String object, String object2, Map object3) {
        int n10;
        int n11 = ShaderUtil.loadShader(35633, (String)object);
        int n12 = 0;
        if (n11 == 0) {
            return 0;
        }
        int n13 = 35632;
        Object object4 = ShaderUtil.loadShader(n13, (String)object2);
        if (object4 == 0) {
            return 0;
        }
        n13 = GLES20.glCreateProgram();
        if (n13 == 0) {
            FluentLogger$Api fluentLogger$Api = (FluentLogger$Api)logger.atSevere();
            String string2 = "Could not create program";
            fluentLogger$Api.log(string2);
        }
        GLES20.glAttachShader((int)n13, (int)n11);
        GLES20.glAttachShader((int)n13, (int)object4);
        if (object3 != null) {
            object = object3.entrySet().iterator();
            while ((object4 = (Object)object.hasNext()) != 0) {
                object2 = (Map.Entry)object.next();
                object3 = (Integer)object2.getValue();
                n10 = (Integer)object3;
                object2 = (String)object2.getKey();
                GLES20.glBindAttribLocation((int)n13, (int)n10, (String)object2);
            }
        }
        GLES20.glLinkProgram((int)n13);
        n11 = 1;
        object2 = new int[n11];
        n10 = 35714;
        GLES20.glGetProgramiv((int)n13, (int)n10, (int[])object2, (int)0);
        object4 = object2[0];
        if (object4 != n11) {
            object = (FluentLogger$Api)logger.atSevere();
            object2 = GLES20.glGetProgramInfoLog((int)n13);
            object3 = "Could not link program: %s";
            object.log((String)object3, object2);
            GLES20.glDeleteProgram((int)n13);
        } else {
            n12 = n13;
        }
        return n12;
    }

    public static int createRgbaTexture(int n10, int n11) {
        int n12 = 1;
        int[] nArray = new int[n12];
        nArray[0] = 0;
        GLES20.glGenTextures((int)n12, (int[])nArray, (int)0);
        GLES20.glActiveTexture((int)33984);
        n12 = nArray[0];
        int n13 = 3553;
        GLES20.glBindTexture((int)n13, (int)n12);
        GLES20.glTexImage2D((int)3553, (int)0, (int)6408, (int)n10, (int)n11, (int)0, (int)6408, (int)5121, null);
        ShaderUtil.checkGlError("glTexImage2D");
        n11 = 9729;
        GLES20.glTexParameteri((int)n13, (int)10241, (int)n11);
        GLES20.glTexParameteri((int)n13, (int)10240, (int)n11);
        n11 = 33071;
        GLES20.glTexParameteri((int)n13, (int)10242, (int)n11);
        GLES20.glTexParameteri((int)n13, (int)10243, (int)n11);
        ShaderUtil.checkGlError("texture setup");
        return nArray[0];
    }

    public static int createRgbaTexture(Bitmap bitmap) {
        int n10 = 1;
        int[] nArray = new int[n10];
        nArray[0] = 0;
        GLES20.glGenTextures((int)n10, (int[])nArray, (int)0);
        GLES20.glActiveTexture((int)33984);
        n10 = nArray[0];
        int n11 = 3553;
        GLES20.glBindTexture((int)n11, (int)n10);
        GLUtils.texImage2D((int)n11, (int)0, (Bitmap)bitmap, (int)0);
        ShaderUtil.checkGlError("texImage2D");
        n10 = 9729;
        GLES20.glTexParameteri((int)n11, (int)10241, (int)n10);
        GLES20.glTexParameteri((int)n11, (int)10240, (int)n10);
        n10 = 33071;
        GLES20.glTexParameteri((int)n11, (int)10242, (int)n10);
        GLES20.glTexParameteri((int)n11, (int)10243, (int)n10);
        ShaderUtil.checkGlError("texture setup");
        return nArray[0];
    }

    public static FloatBuffer floatBuffer(float ... fArray) {
        Buffer buffer = ByteBuffer.allocateDirect(fArray.length * 4);
        ByteOrder byteOrder = ByteOrder.nativeOrder();
        ((ByteBuffer)buffer).order(byteOrder);
        buffer = ((ByteBuffer)buffer).asFloatBuffer();
        ((FloatBuffer)buffer).put(fArray);
        ((FloatBuffer)buffer).position(0);
        return buffer;
    }

    public static int loadShader(int n10, String object) {
        int n11 = GLES20.glCreateShader((int)n10);
        GLES20.glShaderSource((int)n11, (String)object);
        GLES20.glCompileShader((int)n11);
        object = new int[1];
        int n12 = 35713;
        GLES20.glGetShaderiv((int)n11, (int)n12, (int[])object, (int)0);
        Object object2 = object[0];
        if (object2 == false) {
            object = (FluentLogger$Api)logger.atSevere();
            String string2 = GLES20.glGetShaderInfoLog((int)n11);
            String string3 = "Could not compile shader %d: %s";
            object.log(string3, n10, (Object)string2);
            GLES20.glDeleteShader((int)n11);
            n11 = 0;
        }
        return n11;
    }
}

