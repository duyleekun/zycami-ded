/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.hardware.Camera$Size
 *  android.opengl.GLES20
 *  android.opengl.GLUtils
 *  android.text.TextUtils
 *  android.util.Log
 */
package d.v.b0.j;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.text.TextUtils;
import android.util.Log;
import d.v.b0.f.c.b.e;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class d {
    private static final String a = "RenderEngine";
    public static final int b = 255;
    private static final int c = 4;

    private static void a(int n10, FloatBuffer floatBuffer) {
        int n11 = 34962;
        GLES20.glBindBuffer((int)n11, (int)n10);
        n10 = floatBuffer.capacity() * 4;
        GLES20.glBufferData((int)n11, (int)n10, (Buffer)floatBuffer, (int)35044);
        GLES20.glBindBuffer((int)n11, (int)0);
    }

    public static int b(FloatBuffer floatBuffer) {
        int n10 = 1;
        int[] nArray = new int[n10];
        GLES20.glGenBuffers((int)n10, (int[])nArray, (int)0);
        d.a(nArray[0], floatBuffer);
        return nArray[0];
    }

    public static int c(float[] fArray) {
        return d.b(d.p(fArray));
    }

    public static int d() {
        int n10 = 1;
        int[] nArray = new int[n10];
        GLES20.glGenTextures((int)n10, (int[])nArray, (int)0);
        n10 = nArray[0];
        int n11 = 36197;
        GLES20.glBindTexture((int)n11, (int)n10);
        float f10 = 9729.0f;
        GLES20.glTexParameterf((int)n11, (int)10241, (float)f10);
        GLES20.glTexParameterf((int)n11, (int)10240, (float)f10);
        f10 = 33071.0f;
        GLES20.glTexParameterf((int)n11, (int)10242, (float)f10);
        GLES20.glTexParameterf((int)n11, (int)10243, (float)f10);
        GLES20.glBindTexture((int)n11, (int)0);
        return nArray[0];
    }

    public static int e(String string2, String string3) {
        return e.j(string2, string3);
    }

    public static int f(Resources object, String string2, String string3) {
        string2 = d.h(string2, object);
        object = d.h(string3, object);
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)object))) {
            return e.j(string2, (String)object);
        }
        Log.e((String)a, (String)"vertexShaderStr or fragmentShaderStr can not be null or empty.");
        return -1;
    }

    public static String g(float[] fArray) {
        int n10;
        int n11;
        if (fArray != null && (n11 = fArray.length) == (n10 = 16)) {
            int n12;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("\n[");
            n10 = 0;
            String string2 = null;
            while (n10 < (n12 = fArray.length)) {
                CharSequence charSequence;
                n12 = n10 % 4;
                if (n12 != 0) {
                    charSequence = ", ";
                    stringBuffer.append((String)charSequence);
                }
                charSequence = new StringBuilder();
                String string3 = "";
                ((StringBuilder)charSequence).append(string3);
                float f10 = fArray[n10];
                ((StringBuilder)charSequence).append(f10);
                charSequence = ((StringBuilder)charSequence).toString();
                stringBuffer.append((String)charSequence);
                n12 = n10 + 1;
                int n13 = n12 % 4;
                if (n13 == 0) {
                    n13 = 15;
                    f10 = 2.1E-44f;
                    if (n10 != n13) {
                        string2 = "\n";
                        stringBuffer.append(string2);
                    }
                }
                n10 = n12;
            }
            stringBuffer.append("]");
            return stringBuffer.toString();
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String h(String object, Resources object2) {
        Object object3;
        Object object4;
        block5: {
            object4 = null;
            try {
                int n10;
                int n11;
                object2 = object2.getAssets();
                object = object2.open((String)object);
                int n12 = 1024;
                object2 = new byte[n12];
                object3 = new ByteArrayOutputStream();
                while ((n11 = ((InputStream)object).read((byte[])object2)) != (n10 = -1)) {
                    if (n11 < 0) continue;
                    n10 = 0;
                    ((ByteArrayOutputStream)object3).write((byte[])object2, 0, n11);
                }
                object2 = ((ByteArrayOutputStream)object3).toByteArray();
                ((OutputStream)object3).flush();
                ((ByteArrayOutputStream)object3).close();
                ((InputStream)object).close();
                object3 = "UTF-8";
                object = new String((byte[])object2, (String)object3);
                object2 = "\\r\\n";
                object4 = "\n";
            }
            catch (Exception exception) {
                // empty catch block
                break block5;
            }
            try {
                return ((String)object).replaceAll((String)object2, (String)object4);
            }
            catch (Exception exception) {
                object4 = object;
                object = exception;
            }
        }
        ((Throwable)object).printStackTrace();
        object2 = new StringBuilder();
        object3 = "OpenGlUtils loadFromAssetsFile , Exception:";
        object2.append((String)object3);
        object = ((Throwable)object).toString();
        object2.append((String)object);
        object = object2.toString();
        object2 = a;
        Log.e((String)object2, (String)object);
        return object4;
    }

    public static int i(String string2, String string3) {
        int n10 = 1;
        int[] nArray = new int[n10];
        int n11 = 35633;
        int n12 = d.j(string2, n11);
        String string4 = "Load Program";
        if (n12 == 0) {
            Log.d((String)string4, (String)"Vertex Shader Failed");
            return 0;
        }
        int n13 = 35632;
        int n14 = d.j(string3, n13);
        if (n14 == 0) {
            Log.d((String)string4, (String)"Fragment Shader Failed");
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
            Log.d((String)string4, (String)"Linking Failed");
            return 0;
        }
        GLES20.glDeleteShader((int)n12);
        GLES20.glDeleteShader((int)n14);
        return n13;
    }

    public static int j(String charSequence, int n10) {
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
            Log.d((String)"Load Shader Failed", (String)charSequence);
            return 0;
        }
        return n10;
    }

    public static int k(Bitmap bitmap, int n10) {
        return d.l(bitmap, n10, true);
    }

    public static int l(Bitmap bitmap, int n10, boolean bl2) {
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

    public static int m(IntBuffer intBuffer, int n10, int n11, int n12) {
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
            GLES20.glTexImage2D((int)n16, (int)0, (int)n17, (int)n10, (int)n11, (int)0, (int)n18, (int)n19, (Buffer)intBuffer);
        } else {
            GLES20.glBindTexture((int)n15, (int)n12);
            int n20 = 3553;
            int n21 = 6408;
            int n22 = 5121;
            GLES20.glTexSubImage2D((int)n20, (int)0, (int)0, (int)0, (int)n10, (int)n11, (int)n21, (int)n22, (Buffer)intBuffer);
            nArray[0] = n12;
        }
        return nArray[0];
    }

    public static int n(IntBuffer object, Camera.Size size, int n10) {
        object = ((IntBuffer)object).array();
        int n11 = size.width;
        int n12 = size.height;
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        return d.k(Bitmap.createBitmap((int[])object, (int)n11, (int)n12, (Bitmap.Config)config), n10);
    }

    public static float o(float f10, float f11) {
        float f12 = (float)Math.random();
        f11 = (f11 - f10) * f12;
        return f10 + f11;
    }

    public static FloatBuffer p(float[] fArray) {
        Buffer buffer = ByteBuffer.allocateDirect(fArray.length * 4);
        ByteOrder byteOrder = ByteOrder.nativeOrder();
        buffer = ((ByteBuffer)buffer).order(byteOrder).asFloatBuffer();
        ((FloatBuffer)buffer).put(fArray).position(0);
        return buffer;
    }
}

