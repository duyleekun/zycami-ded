/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.graphics.SurfaceTexture$OnFrameAvailableListener
 *  android.opengl.GLES20
 *  android.opengl.GLSurfaceView$Renderer
 *  android.util.Log
 *  javax.microedition.khronos.egl.EGLConfig
 *  javax.microedition.khronos.opengles.GL10
 */
package i.f.b;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;
import i.f.b.g;
import i.f.b.g$a;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public abstract class f
implements GLSurfaceView.Renderer,
SurfaceTexture.OnFrameAvailableListener {
    public int A;
    public SurfaceTexture B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public g H;
    public final String a;
    private final String b;
    private final String c;
    private final String d;
    private final float[] e;
    private final float[] f;
    private final float[] g;
    private int[] h;
    private int[] i;
    private int[] j;
    private int[] k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private FloatBuffer r;
    private FloatBuffer s;
    private FloatBuffer t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    public f(g object) {
        int n10;
        float[] fArray;
        float[] fArray2;
        float[] fArray3;
        this.a = "CameraGLRendererBase";
        this.b = "attribute vec2 vPosition;\nattribute vec2 vTexCoord;\nvarying vec2 texCoord;\nvoid main() {\n  texCoord = vTexCoord;\n  gl_Position = vec4 ( vPosition.x, vPosition.y, 0.0, 1.0 );\n}";
        this.c = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nvarying vec2 texCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture,texCoord);\n}";
        this.d = "precision mediump float;\nuniform sampler2D sTexture;\nvarying vec2 texCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture,texCoord);\n}";
        int n11 = 8;
        float[] fArray4 = fArray3 = new float[n11];
        float[] fArray5 = fArray3;
        fArray4[0] = -1.0f;
        fArray5[1] = -1.0f;
        fArray4[2] = -1.0f;
        fArray5[3] = 1.0f;
        fArray4[4] = 1.0f;
        fArray5[5] = -1.0f;
        fArray4[6] = 1.0f;
        fArray5[7] = 1.0f;
        this.e = fArray3;
        float[] fArray6 = fArray2 = new float[n11];
        float[] fArray7 = fArray2;
        fArray6[0] = 0.0f;
        fArray7[1] = 1.0f;
        fArray6[2] = 0.0f;
        fArray7[3] = 0.0f;
        fArray6[4] = 1.0f;
        fArray7[5] = 1.0f;
        fArray6[6] = 1.0f;
        fArray7[7] = 0.0f;
        this.f = fArray2;
        float[] fArray8 = fArray = new float[n11];
        float[] fArray9 = fArray;
        fArray8[0] = 0.0f;
        fArray9[1] = 0.0f;
        fArray8[2] = 0.0f;
        fArray9[3] = 1.0f;
        fArray8[4] = 1.0f;
        fArray9[5] = 0.0f;
        fArray8[6] = 1.0f;
        fArray9[7] = 1.0f;
        this.g = fArray;
        int n12 = 1;
        int[] nArray = new int[n12];
        nArray[0] = 0;
        this.h = nArray;
        nArray = new int[n12];
        nArray[0] = 0;
        this.i = nArray;
        nArray = new int[n12];
        nArray[0] = 0;
        this.j = nArray;
        nArray = new int[n12];
        nArray[0] = 0;
        this.k = nArray;
        this.l = n10 = -1;
        this.m = n10;
        this.u = n10;
        this.v = n10;
        this.w = n10;
        this.x = n10;
        this.y = n10;
        this.z = n10;
        this.A = n10;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = n12;
        this.G = false;
        this.H = object;
        int n13 = fArray3.length * 32 / n11;
        Object object2 = ByteBuffer.allocateDirect(n13);
        ByteOrder byteOrder = ByteOrder.nativeOrder();
        object2 = ((ByteBuffer)object2).order(byteOrder).asFloatBuffer();
        this.r = object2;
        object2 = ByteBuffer.allocateDirect(n13);
        byteOrder = ByteOrder.nativeOrder();
        object2 = ((ByteBuffer)object2).order(byteOrder).asFloatBuffer();
        this.s = object2;
        object = ByteBuffer.allocateDirect(n13);
        object2 = ByteOrder.nativeOrder();
        this.t = object = ((ByteBuffer)object).order((ByteOrder)object2).asFloatBuffer();
        this.r.put(fArray3).position(0);
        this.s.put(fArray2).position(0);
        this.t.put(fArray).position(0);
    }

    private void b() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("deleteFBO(");
        int n10 = this.w;
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append("x");
        n10 = this.x;
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(")");
        object = ((StringBuilder)object).toString();
        Log.d((String)"CameraGLRendererBase", (String)object);
        GLES20.glBindFramebuffer((int)36160, (int)0);
        object = this.k;
        GLES20.glDeleteFramebuffers((int)1, (int[])object, (int)0);
        i.f.b.f.d(this.i);
        i.f.b.f.d(this.j);
        this.x = 0;
        this.w = 0;
    }

    private void c() {
        String string2 = "deleteSurfaceTexture";
        Log.d((String)"CameraGLRendererBase", (String)string2);
        Object object = this.B;
        if (object != null) {
            object.release();
            this.B = null;
            object = this.h;
            i.f.b.f.d((int[])object);
        }
    }

    private static void d(int[] nArray) {
        int n10 = nArray.length;
        int n11 = 1;
        if (n10 == n11) {
            n10 = 0;
            GLES20.glDeleteTextures((int)n11, (int[])nArray, (int)0);
        }
    }

    private void h(int n10, boolean bl2, int n11) {
        int n12;
        Object object;
        f f10 = this;
        int n13 = n10;
        int n14 = n11;
        GLES20.glBindFramebuffer((int)36160, (int)n11);
        if (n11 == 0) {
            object = this.H;
            n14 = object.getWidth();
            g g10 = this.H;
            n12 = g10.getHeight();
            GLES20.glViewport((int)0, (int)0, (int)n14, (int)n12);
        } else {
            n14 = this.w;
            n12 = this.x;
            GLES20.glViewport((int)0, (int)0, (int)n14, (int)n12);
        }
        n14 = 16384;
        GLES20.glClear((int)n14);
        if (bl2) {
            n14 = f10.l;
            GLES20.glUseProgram((int)n14);
            n12 = f10.n;
            int n15 = 2;
            int n16 = 5126;
            int n17 = 8;
            FloatBuffer floatBuffer = f10.r;
            GLES20.glVertexAttribPointer((int)n12, (int)n15, (int)n16, (boolean)false, (int)n17, (Buffer)floatBuffer);
            int n18 = f10.o;
            int n19 = 2;
            int n20 = 5126;
            int n21 = 8;
            FloatBuffer floatBuffer2 = f10.s;
            GLES20.glVertexAttribPointer((int)n18, (int)n19, (int)n20, (boolean)false, (int)n21, (Buffer)floatBuffer2);
        } else {
            n14 = f10.m;
            GLES20.glUseProgram((int)n14);
            n12 = f10.p;
            int n22 = 2;
            int n23 = 5126;
            int n24 = 8;
            FloatBuffer floatBuffer = f10.r;
            GLES20.glVertexAttribPointer((int)n12, (int)n22, (int)n23, (boolean)false, (int)n24, (Buffer)floatBuffer);
            int n25 = f10.q;
            int n26 = 2;
            int n27 = 5126;
            int n28 = 8;
            FloatBuffer floatBuffer3 = f10.t;
            GLES20.glVertexAttribPointer((int)n25, (int)n26, (int)n27, (boolean)false, (int)n28, (Buffer)floatBuffer3);
        }
        n14 = 33984;
        GLES20.glActiveTexture((int)n14);
        object = "sTexture";
        if (bl2) {
            n12 = 36197;
            GLES20.glBindTexture((int)n12, (int)n13);
            n13 = GLES20.glGetUniformLocation((int)f10.l, (String)object);
            GLES20.glUniform1i((int)n13, (int)0);
        } else {
            n12 = 3553;
            GLES20.glBindTexture((int)n12, (int)n13);
            n13 = GLES20.glGetUniformLocation((int)f10.m, (String)object);
            GLES20.glUniform1i((int)n13, (int)0);
        }
        GLES20.glDrawArrays((int)5, (int)0, (int)4);
        GLES20.glFlush();
    }

    private void j(int n10, int n11) {
        f f10 = this;
        int n12 = n10;
        int n13 = n11;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("initFBO(");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append("x");
        ((StringBuilder)object).append(n11);
        ((StringBuilder)object).append(")");
        object = ((StringBuilder)object).toString();
        String string2 = "CameraGLRendererBase";
        Log.d((String)string2, (String)object);
        this.b();
        object = this.j;
        int n14 = 1;
        GLES20.glGenTextures((int)n14, (int[])object, (int)0);
        int n15 = this.j[0];
        int n16 = 3553;
        GLES20.glBindTexture((int)n16, (int)n15);
        StringBuilder stringBuilder = null;
        int n17 = 6408;
        int n18 = n10;
        int n19 = n11;
        GLES20.glTexImage2D((int)3553, (int)0, (int)n17, (int)n10, (int)n11, (int)0, (int)6408, (int)5121, null);
        int n20 = 10242;
        int n21 = 33071;
        GLES20.glTexParameteri((int)n16, (int)n20, (int)n21);
        int n22 = 10243;
        GLES20.glTexParameteri((int)n16, (int)n22, (int)n21);
        int n23 = 10241;
        n19 = 9728;
        GLES20.glTexParameteri((int)n16, (int)n23, (int)n19);
        n18 = 10240;
        GLES20.glTexParameteri((int)n16, (int)n18, (int)n19);
        object = this.i;
        GLES20.glGenTextures((int)n14, (int[])object, (int)0);
        n15 = this.i[0];
        GLES20.glBindTexture((int)n16, (int)n15);
        int n24 = 6408;
        int n25 = 5121;
        n14 = n18;
        n18 = n10;
        int n26 = n19;
        n19 = n11;
        n14 = n23;
        n23 = 0;
        n14 = n22;
        n22 = n24;
        n26 = n21;
        n21 = n25;
        n14 = n20;
        n20 = 0;
        GLES20.glTexImage2D((int)3553, (int)0, (int)n17, (int)n10, (int)n11, (int)0, (int)n24, (int)n25, null);
        GLES20.glTexParameteri((int)n16, (int)n14, (int)n26);
        GLES20.glTexParameteri((int)n16, (int)10243, (int)n26);
        int n27 = 9728;
        GLES20.glTexParameteri((int)n16, (int)10241, (int)n27);
        GLES20.glTexParameteri((int)n16, (int)10240, (int)n27);
        object = this.k;
        GLES20.glGenFramebuffers((int)1, (int[])object, (int)0);
        n15 = this.k[0];
        n27 = 36160;
        GLES20.glBindFramebuffer((int)n27, (int)n15);
        n15 = this.i[0];
        n18 = 36064;
        GLES20.glFramebufferTexture2D((int)n27, (int)n18, (int)n16, (int)n15, (int)0);
        object = new StringBuilder();
        String string3 = "initFBO error status: ";
        ((StringBuilder)object).append(string3);
        n17 = GLES20.glGetError();
        ((StringBuilder)object).append(n17);
        object = ((StringBuilder)object).toString();
        Log.d((String)string2, (String)object);
        n15 = GLES20.glCheckFramebufferStatus((int)n27);
        n27 = 36053;
        if (n15 != n27) {
            stringBuilder = new StringBuilder();
            string3 = "initFBO failed, status: ";
            stringBuilder.append(string3);
            stringBuilder.append(n15);
            object = stringBuilder.toString();
            Log.e((String)string2, (String)object);
        }
        f10.w = n12;
        f10.x = n13;
    }

    private void k() {
        int n10;
        String string2;
        int n11 = 7938;
        float f10 = 1.1124E-41f;
        String string3 = GLES20.glGetString((int)n11);
        if (string3 != null) {
            CharSequence charSequence = new StringBuilder();
            string2 = "OpenGL ES version: ";
            charSequence.append(string2);
            charSequence.append(string3);
            string3 = charSequence.toString();
            charSequence = "CameraGLRendererBase";
            Log.i((String)charSequence, (String)string3);
        }
        f10 = 1.0f;
        GLES20.glClearColor((float)f10, (float)f10, (float)f10, (float)f10);
        string3 = "attribute vec2 vPosition;\nattribute vec2 vTexCoord;\nvarying vec2 texCoord;\nvoid main() {\n  texCoord = vTexCoord;\n  gl_Position = vec4 ( vPosition.x, vPosition.y, 0.0, 1.0 );\n}";
        this.l = n10 = i.f.b.f.n(string3, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nvarying vec2 texCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture,texCoord);\n}");
        string2 = "vPosition";
        this.n = n10 = GLES20.glGetAttribLocation((int)n10, (String)string2);
        n10 = this.l;
        String string4 = "vTexCoord";
        this.o = n10 = GLES20.glGetAttribLocation((int)n10, (String)string4);
        GLES20.glEnableVertexAttribArray((int)this.n);
        GLES20.glEnableVertexAttribArray((int)this.o);
        this.m = n11 = i.f.b.f.n(string3, "precision mediump float;\nuniform sampler2D sTexture;\nvarying vec2 texCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture,texCoord);\n}");
        this.p = n11 = GLES20.glGetAttribLocation((int)n11, (String)string2);
        this.q = n11 = GLES20.glGetAttribLocation((int)this.m, (String)string4);
        GLES20.glEnableVertexAttribArray((int)this.p);
        GLES20.glEnableVertexAttribArray((int)this.q);
    }

    private void l() {
        Log.d((String)"CameraGLRendererBase", (String)"initSurfaceTexture");
        this.c();
        Object object = this.h;
        this.m((int[])object);
        object = new SurfaceTexture;
        int n10 = this.h[0];
        object(n10);
        this.B = (SurfaceTexture)object;
        object.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener)this);
    }

    private void m(int[] nArray) {
        int n10 = nArray.length;
        int n11 = 1;
        if (n10 == n11) {
            GLES20.glGenTextures((int)n11, (int[])nArray, (int)0);
            int n12 = nArray[0];
            n10 = 36197;
            GLES20.glBindTexture((int)n10, (int)n12);
            n11 = 33071;
            GLES20.glTexParameteri((int)n10, (int)10242, (int)n11);
            GLES20.glTexParameteri((int)n10, (int)10243, (int)n11);
            n11 = 9728;
            GLES20.glTexParameteri((int)n10, (int)10241, (int)n11);
            n12 = 10240;
            GLES20.glTexParameteri((int)n10, (int)n12, (int)n11);
        }
    }

    private static int n(String object, String string2) {
        String string3 = "CameraGLRendererBase";
        String string4 = "loadShader";
        Log.d((String)string3, (String)string4);
        Object object2 = GLES20.glCreateShader((int)35633);
        GLES20.glShaderSource((int)object2, (String)object);
        GLES20.glCompileShader((int)object2);
        Object object3 = 1;
        object = new int[object3];
        int n10 = 35713;
        GLES20.glGetShaderiv((int)object2, (int)n10, (int[])object, (int)0);
        Object object4 = object[0];
        if (object4 == false) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Could not compile vertex shader: ");
            string2 = GLES20.glGetShaderInfoLog((int)object2);
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
            Log.e((String)string3, (String)object);
            GLES20.glDeleteShader((int)object2);
            return 0;
        }
        object4 = GLES20.glCreateShader((int)35632);
        GLES20.glShaderSource((int)object4, (String)string2);
        GLES20.glCompileShader((int)object4);
        GLES20.glGetShaderiv((int)object4, (int)n10, (int[])object, (int)0);
        Object object5 = object[0];
        if (object5 == false) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Could not compile fragment shader:");
            string2 = GLES20.glGetShaderInfoLog((int)object4);
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
            Log.e((String)string3, (String)object);
            GLES20.glDeleteShader((int)object2);
            GLES20.glDeleteShader((int)object4);
            return 0;
        }
        object5 = GLES20.glCreateProgram();
        GLES20.glAttachShader((int)object5, (int)object2);
        GLES20.glAttachShader((int)object5, (int)object4);
        GLES20.glLinkProgram((int)object5);
        GLES20.glDeleteShader((int)object2);
        GLES20.glDeleteShader((int)object4);
        GLES20.glGetProgramiv((int)object5, (int)35714, (int[])object, (int)0);
        object2 = object[0];
        if (object2 == 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Could not link shader program: ");
            string2 = GLES20.glGetProgramInfoLog((int)object5);
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
            Log.e((String)string3, (String)object);
            return 0;
        }
        GLES20.glValidateProgram((int)object5);
        object2 = 35715;
        GLES20.glGetProgramiv((int)object5, (int)object2, (int[])object, (int)0);
        object3 = object[0];
        if (object3 == 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Shader program validation error: ");
            string4 = GLES20.glGetProgramInfoLog((int)object5);
            ((StringBuilder)object).append(string4);
            object = ((StringBuilder)object).toString();
            Log.e((String)string3, (String)object);
            GLES20.glDeleteProgram((int)object5);
            return 0;
        }
        Log.d((String)string3, (String)"Shader program is built OK");
        return (int)object5;
    }

    public abstract void a();

    public void e() {
        synchronized (this) {
            String string2 = "CameraGLRendererBase";
            String string3 = "disableView";
            Log.d((String)string2, (String)string3);
            string2 = null;
            this.F = false;
            this.v();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void f() {
        synchronized (this) {
            int n10;
            String string2 = "CameraGLRendererBase";
            String string3 = "doStart";
            Log.d((String)string2, (String)string3);
            this.l();
            int n11 = this.A;
            this.q(n11);
            n11 = 1;
            this.G = n11;
            n11 = this.u;
            if (n11 > 0 && (n10 = this.v) > 0) {
                this.u(n11, n10);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void g() {
        g$a g$a;
        String string2 = "doStop";
        Log.d((String)"CameraGLRendererBase", (String)string2);
        synchronized (this) {
            g$a = null;
            this.E = false;
            this.G = false;
            this.D = false;
            this.a();
            this.c();
        }
        g$a = this.H.getCameraTextureListener();
        if (g$a != null) {
            g$a.a();
        }
    }

    public void i() {
        synchronized (this) {
            String string2 = "CameraGLRendererBase";
            String string3 = "enableView";
            Log.d((String)string2, (String)string3);
            boolean bl2 = true;
            this.F = bl2;
            this.v();
            return;
        }
    }

    public void o() {
        int n10;
        Log.i((String)"CameraGLRendererBase", (String)"onPause");
        this.C = false;
        this.v();
        this.v = n10 = -1;
        this.u = n10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onDrawFrame(GL10 object) {
        Object object2 = this.D;
        if (object2 == 0) {
            return;
        }
        synchronized (this) {
            object2 = this.E;
            if (object2 != 0) {
                object = this.B;
                object.updateTexImage();
                this.E = false;
            }
            object2 = 16384;
            GLES20.glClear((int)object2);
            object = this.H;
            object = object.getCameraTextureListener();
            int n10 = 1;
            if (object != null) {
                int[] nArray = this.h;
                int n11 = nArray[0];
                int[] nArray2 = this.k;
                int n12 = nArray2[0];
                this.h(n11, n10 != 0, n12);
                int[] nArray3 = this.i;
                n10 = nArray3[0];
                nArray = this.j;
                n11 = nArray[0];
                n12 = this.u;
                int n13 = this.v;
                object2 = object.c(n10, n11, n12, n13);
                if (object2 != 0) {
                    object = this.j;
                    object2 = object[0];
                    this.h((int)object2, false, 0);
                } else {
                    object = this.i;
                    object2 = object[0];
                    this.h((int)object2, false, 0);
                }
            } else {
                object = "CameraGLRendererBase";
                String string2 = "texCamera(OES) -> screen";
                Log.d((String)object, (String)string2);
                object = this.h;
                object2 = object[0];
                this.h((int)object2, n10 != 0, 0);
            }
            return;
        }
    }

    public void onFrameAvailable(SurfaceTexture object) {
        synchronized (this) {
            boolean bl2 = true;
            this.E = bl2;
            object = this.H;
            object.requestRender();
            return;
        }
    }

    public void onSurfaceChanged(GL10 object, int n10, int n11) {
        object = new StringBuilder();
        ((StringBuilder)object).append("onSurfaceChanged(");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append("x");
        ((StringBuilder)object).append(n11);
        ((StringBuilder)object).append(")");
        object = ((StringBuilder)object).toString();
        Log.i((String)"CameraGLRendererBase", (String)object);
        this.C = true;
        this.v();
        this.u(n10, n11);
    }

    public void onSurfaceCreated(GL10 gL10, EGLConfig eGLConfig) {
        Log.i((String)"CameraGLRendererBase", (String)"onSurfaceCreated");
        this.k();
    }

    public void p() {
        Log.i((String)"CameraGLRendererBase", (String)"onResume");
    }

    public abstract void q(int var1);

    public void r(int n10) {
        this.e();
        this.A = n10;
        this.i();
    }

    public abstract void s(int var1, int var2);

    public void t(int n10, int n11) {
        this.e();
        this.y = n10;
        this.z = n11;
        this.i();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void u(int n10, int n11) {
        int n12;
        synchronized (this) {
            n12 = 0;
            this.D = false;
            this.u = n10;
            this.v = n11;
            this.s(n10, n11);
            n10 = this.u;
            n11 = this.v;
            this.j(n10, n11);
            n10 = 1;
            this.D = n10;
        }
        g$a g$a = this.H.getCameraTextureListener();
        if (g$a != null) {
            n11 = this.u;
            n12 = this.v;
            g$a.b(n11, n12);
        }
    }

    public void v() {
        String string2 = "CameraGLRendererBase";
        Log.d((String)string2, (String)"updateState");
        Object object = new StringBuilder();
        object.append("mEnabled=");
        int n10 = this.F;
        object.append(n10 != 0);
        String string3 = ", mHaveSurface=";
        object.append(string3);
        n10 = this.C;
        object.append(n10 != 0);
        object = object.toString();
        Log.d((String)string2, (String)object);
        int n11 = this.F;
        if (n11 != 0 && (n11 = this.C) != 0 && (n11 = (object = this.H).getVisibility()) == 0) {
            n11 = 1;
        } else {
            n11 = 0;
            object = null;
        }
        n10 = this.G;
        if (n11 != n10) {
            if (n11 != 0) {
                this.f();
            } else {
                this.g();
            }
        } else {
            object = "keeping State unchanged";
            Log.d((String)string2, (String)object);
        }
        Log.d((String)string2, (String)"updateState end");
    }
}

