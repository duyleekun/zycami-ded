/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.opengl.GLES20
 *  android.opengl.GLUtils
 */
package d.v.r;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.google.mediapipe.glutil.CommonShaders;
import com.google.mediapipe.glutil.ShaderUtil;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class f {
    private static final String A = "ExternalTextureRend";
    private static final int B = 1;
    private static final int C = 2;
    public static final int D = 1;
    public static final int E = 4;
    public static float[] F;
    public static final FloatBuffer G;
    public static final FloatBuffer H;
    public static final String I = "uniform mat4 texture_transform;\nattribute vec4 position;\nattribute mediump vec4 texture_coordinate;\nvarying mediump vec2 sample_coordinate;\n\nvoid main() {\n  gl_Position = position;\n  sample_coordinate = (texture_transform * texture_coordinate).xy;\n}";
    public static float[] J;
    public static float[] K;
    public static Bitmap w;
    private static final FloatBuffer x;
    private static final FloatBuffer y;
    public static float[] z;
    private int a = 0;
    private int b;
    private int c;
    private float[] d;
    private boolean e;
    private FloatBuffer f;
    private FloatBuffer g;
    public int[] h;
    public float[] i;
    private FloatBuffer j;
    private FloatBuffer k;
    private ShortBuffer l;
    public boolean m;
    public boolean n;
    private short[] o;
    public ReentrantLock p;
    private int q;
    private int r;
    private int s;
    private int t;
    private final String u;
    public Bitmap v;

    static {
        float[] fArray;
        float[] fArray2;
        int n10 = 8;
        float[] fArray3 = fArray2 = new float[n10];
        float[] fArray4 = fArray2;
        fArray3[0] = 0.0f;
        fArray4[1] = 0.0f;
        fArray3[2] = 1.0f;
        fArray4[3] = 0.0f;
        fArray3[4] = 0.0f;
        fArray4[5] = 1.0f;
        fArray3[6] = 1.0f;
        fArray4[7] = 1.0f;
        x = ShaderUtil.floatBuffer(fArray2);
        float[] fArray5 = fArray2 = new float[n10];
        float[] fArray6 = fArray2;
        fArray5[0] = 0.0f;
        fArray6[1] = 1.0f;
        fArray5[2] = 1.0f;
        fArray6[3] = 1.0f;
        fArray5[4] = 0.0f;
        fArray6[5] = 0.0f;
        fArray5[6] = 1.0f;
        fArray6[7] = 0.0f;
        y = ShaderUtil.floatBuffer(fArray2);
        float[] fArray7 = fArray2 = new float[12];
        float[] fArray8 = fArray2;
        fArray7[0] = -1.0f;
        fArray8[1] = 1.0f;
        fArray7[2] = 0.0f;
        fArray8[3] = -1.0f;
        fArray7[4] = -1.0f;
        fArray8[5] = 0.0f;
        fArray7[6] = 1.0f;
        fArray8[7] = -1.0f;
        fArray7[8] = 0.0f;
        fArray8[9] = 1.0f;
        fArray7[10] = 1.0f;
        fArray8[11] = 0.0f;
        z = fArray2;
        float[] fArray9 = fArray2 = new float[n10];
        float[] fArray10 = fArray2;
        fArray9[0] = 0.0f;
        fArray10[1] = 0.0f;
        fArray9[2] = 0.0f;
        fArray10[3] = 1.0f;
        fArray9[4] = 1.0f;
        fArray10[5] = 1.0f;
        fArray9[6] = 1.0f;
        fArray10[7] = 0.0f;
        F = fArray2;
        float[] fArray11 = fArray2 = new float[n10];
        float[] fArray12 = fArray2;
        fArray11[0] = -1.0f;
        fArray12[1] = -1.0f;
        fArray11[2] = 1.0f;
        fArray12[3] = -1.0f;
        fArray11[4] = -1.0f;
        fArray12[5] = 1.0f;
        fArray11[6] = 1.0f;
        fArray12[7] = 1.0f;
        G = ShaderUtil.floatBuffer(fArray2);
        float[] fArray13 = fArray2 = new float[n10];
        float[] fArray14 = fArray2;
        fArray13[0] = -1.0f;
        fArray14[1] = 1.0f;
        fArray13[2] = -1.0f;
        fArray14[3] = -1.0f;
        fArray13[4] = 1.0f;
        fArray14[5] = 1.0f;
        fArray13[6] = 1.0f;
        fArray14[7] = -1.0f;
        H = ShaderUtil.floatBuffer(fArray2);
        float[] fArray15 = fArray2 = new float[n10];
        float[] fArray16 = fArray2;
        fArray15[0] = -1.0f;
        fArray16[1] = -1.0f;
        fArray15[2] = 1.0f;
        fArray16[3] = -1.0f;
        fArray15[4] = -1.0f;
        fArray16[5] = 1.0f;
        fArray15[6] = 1.0f;
        fArray16[7] = 1.0f;
        J = fArray2;
        float[] fArray17 = fArray = new float[n10];
        float[] fArray18 = fArray;
        fArray17[0] = 0.0f;
        fArray18[1] = 1.0f;
        fArray17[2] = 1.0f;
        fArray18[3] = 1.0f;
        fArray17[4] = 0.0f;
        fArray18[5] = 0.0f;
        fArray17[6] = 1.0f;
        fArray18[7] = 0.0f;
        K = fArray;
    }

    public f() {
        int n10 = 16;
        Object object = new float[n10];
        this.d = object;
        int n11 = 4;
        Object object2 = new int[n11];
        this.h = object2;
        Object object3 = new float[n10];
        this.i = object3;
        this.m = true;
        this.n = false;
        object3 = new short[6];
        Object[] objectArray = object3;
        Object[] objectArray2 = object3;
        objectArray[0] = 0.0f;
        objectArray2[1] = 1.0f;
        objectArray[2] = 2;
        objectArray2[3] = 0.0f;
        objectArray[4] = 2;
        objectArray2[5] = 3;
        this.o = (short[])object3;
        object3 = new ReentrantLock;
        this.p = object3;
        this.u = "#extension GL_OES_EGL_image_external : require\nvarying mediump vec2 sample_coordinate;\nuniform sampler2D video_frame;\n\nvoid main() {\n  gl_FragColor = texture2D(video_frame, sample_coordinate);\n}";
        object3 = ByteBuffer.allocateDirect(z.length * n11);
        object2 = ByteOrder.nativeOrder();
        ((ByteBuffer)object3).order((ByteOrder)object2);
        this.j = object3 = ((ByteBuffer)object3).asFloatBuffer();
        object2 = z;
        ((FloatBuffer)object3).put((float[])object2);
        this.j.position(0);
        object3 = ByteBuffer.allocateDirect(F.length * n11);
        object = ByteOrder.nativeOrder();
        ((ByteBuffer)object3).order((ByteOrder)object);
        this.k = object3 = ((ByteBuffer)object3).asFloatBuffer();
        object = F;
        ((FloatBuffer)object3).put((float[])object);
        this.k.position(0);
        object3 = ByteBuffer.allocateDirect(this.o.length * 2);
        object = ByteOrder.nativeOrder();
        ((ByteBuffer)object3).order((ByteOrder)object);
        this.l = object3 = ((ByteBuffer)object3).asShortBuffer();
        object = this.o;
        ((ShortBuffer)object3).put((short[])object);
        this.l.position(0);
    }

    private void b() {
        Buffer buffer = ByteBuffer.allocateDirect(J.length * 4);
        Object object = ByteOrder.nativeOrder();
        ((ByteBuffer)buffer).order((ByteOrder)object);
        buffer = ((ByteBuffer)buffer).asFloatBuffer();
        this.f = buffer;
        object = J;
        ((FloatBuffer)buffer).put((float[])object);
        this.f.position(0);
        buffer = ByteBuffer.allocateDirect(K.length * 4);
        Object object2 = ByteOrder.nativeOrder();
        ((ByteBuffer)buffer).order((ByteOrder)object2);
        buffer = ((ByteBuffer)buffer).asFloatBuffer();
        this.g = buffer;
        object2 = K;
        ((FloatBuffer)buffer).put((float[])object2);
        this.g.position(0);
    }

    private Bitmap c(int n10, int n11) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(n10 * n11 * 4);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        byteBuffer.order(byteOrder);
        GLES20.glReadPixels((int)0, (int)0, (int)n10, (int)n11, (int)6408, (int)5121, (Buffer)byteBuffer);
        byteBuffer.rewind();
        byteOrder = Bitmap.Config.ARGB_8888;
        Bitmap bitmap = Bitmap.createBitmap((int)n10, (int)n11, (Bitmap.Config)byteOrder);
        bitmap.copyPixelsFromBuffer((Buffer)byteBuffer);
        return bitmap;
    }

    public void a(Bitmap bitmap) {
        int n10;
        this.p.lock();
        this.q = n10 = bitmap.getWidth();
        this.r = n10 = bitmap.getHeight();
        this.v = bitmap;
        this.p.unlock();
    }

    public void d() {
        GLES20.glDeleteProgram((int)this.a);
    }

    public void e(int n10) {
        int n11 = 3553;
        GLES20.glBindTexture((int)n11, (int)n10);
        Object object = this.v;
        GLUtils.texImage2D((int)n11, (int)0, (Bitmap)object, (int)0);
        GLES20.glBindTexture((int)n11, (int)0);
        GLES20.glBindFramebuffer((int)36160, (int)0);
        GLES20.glClearColor((float)0.0f, (float)0.0f, (float)0.0f, (float)1.0f);
        GLES20.glClear((int)16384);
        GLES20.glUseProgram((int)this.a);
        int n12 = 33984;
        GLES20.glActiveTexture((int)n12);
        GLES20.glBindTexture((int)n11, (int)n10);
        GLES20.glUniform1i((int)this.b, (int)0);
        n10 = this.c;
        object = this.d;
        int n13 = 1;
        GLES20.glUniformMatrix4fv((int)n10, (int)n13, (boolean)false, (float[])object, (int)0);
        Object object2 = "glUniformMatrix4fv";
        ShaderUtil.checkGlError((String)object2);
        GLES20.glEnableVertexAttribArray((int)n13);
        FloatBuffer floatBuffer = CommonShaders.SQUARE_VERTICES;
        int n14 = 1;
        int n15 = 2;
        int n16 = 5126;
        GLES20.glVertexAttribPointer((int)n14, (int)n15, (int)n16, (boolean)false, (int)0, (Buffer)floatBuffer);
        GLES20.glEnableVertexAttribArray((int)2);
        n10 = (int)(this.e ? 1 : 0);
        object2 = n10 != 0 ? y : x;
        GLES20.glVertexAttribPointer((int)2, (int)2, (int)5126, (boolean)false, (int)0, (Buffer)object2);
        ShaderUtil.checkGlError("program setup");
        GLES20.glDrawArrays((int)5, (int)0, (int)4);
        GLES20.glBindTexture((int)n11, (int)0);
        ShaderUtil.checkGlError("glDrawArrays");
    }

    public void f(boolean bl2) {
        this.e = bl2;
    }

    public void g() {
        int n10;
        this.b();
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        Integer n11 = 1;
        hashMap.put("position", n11);
        n11 = 2;
        hashMap.put("texture_coordinate", n11);
        this.a = n10 = ShaderUtil.createProgram(I, "#extension GL_OES_EGL_image_external : require\nvarying mediump vec2 sample_coordinate;\nuniform sampler2D video_frame;\n\nvoid main() {\n  gl_FragColor = texture2D(video_frame, sample_coordinate);\n}", hashMap);
        this.b = n10 = GLES20.glGetUniformLocation((int)n10, (String)"video_frame");
        this.c = n10 = GLES20.glGetUniformLocation((int)this.a, (String)"texture_transform");
        ShaderUtil.checkGlError("glGetUniformLocation");
    }
}

