/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.opengl.GLES20
 *  android.opengl.GLES30
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Log
 */
package com.tencent.liteav.beauty;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.TXCOpenGlUtils;
import com.tencent.liteav.basic.opengl.TXCOpenGlUtils$a;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.liteav.beauty.b.b;
import com.tencent.liteav.beauty.b.b.a;
import com.tencent.liteav.beauty.b.i;
import com.tencent.liteav.beauty.b.j;
import com.tencent.liteav.beauty.b.k;
import com.tencent.liteav.beauty.b.l;
import com.tencent.liteav.beauty.b.m;
import com.tencent.liteav.beauty.b.n;
import com.tencent.liteav.beauty.b.o;
import com.tencent.liteav.beauty.b.x;
import com.tencent.liteav.beauty.c$1;
import com.tencent.liteav.beauty.c$10;
import com.tencent.liteav.beauty.c$11;
import com.tencent.liteav.beauty.c$12;
import com.tencent.liteav.beauty.c$13;
import com.tencent.liteav.beauty.c$2;
import com.tencent.liteav.beauty.c$3;
import com.tencent.liteav.beauty.c$4;
import com.tencent.liteav.beauty.c$5;
import com.tencent.liteav.beauty.c$6;
import com.tencent.liteav.beauty.c$7;
import com.tencent.liteav.beauty.c$8;
import com.tencent.liteav.beauty.c$9;
import com.tencent.liteav.beauty.c$a;
import com.tencent.liteav.beauty.d$b;
import com.tencent.liteav.beauty.d$e;
import com.tencent.liteav.beauty.d$f;
import com.tencent.liteav.beauty.e;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class c
extends HandlerThread {
    private int A = 0;
    private Context B = null;
    private boolean C;
    private boolean D;
    private d$e E;
    private d$f F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private float M;
    private int N;
    private int O;
    private int P;
    private boolean Q;
    private float[] R;
    private boolean S;
    private int T;
    private int U;
    private com.tencent.liteav.basic.opengl.a V;
    private Bitmap W;
    private k X;
    private o Y;
    private b Z;
    public boolean a;
    private int aA;
    private int aB;
    private int aC;
    private int aD;
    private boolean aE;
    private com.tencent.liteav.beauty.a.a.c aF;
    private com.tencent.liteav.beauty.a.a.a aG;
    private Bitmap aH;
    private List aI;
    private long aJ;
    private int aK;
    private final int aL;
    private final float aM;
    private byte[] aN;
    private int[] aO;
    private boolean aP;
    private byte[] aQ;
    private int aR;
    private int aS;
    private int aT;
    private int aU;
    private e aV;
    private WeakReference aW;
    private com.tencent.liteav.beauty.b.a aX;
    private final com.tencent.liteav.basic.util.c aY;
    private TXCOpenGlUtils$a aZ;
    private com.tencent.liteav.beauty.b.a.a aa;
    private a ab;
    private com.tencent.liteav.beauty.b.c ac;
    private com.tencent.liteav.beauty.b.c.a ad;
    private Bitmap ae;
    private Bitmap af;
    private float ag;
    private float ah;
    private float ai;
    private m aj;
    private n ak;
    private x al;
    private j am;
    private i an;
    private com.tencent.liteav.basic.opengl.i ao;
    private l ap;
    private com.tencent.liteav.basic.opengl.j aq;
    private com.tencent.liteav.basic.opengl.i ar;
    private final Queue as;
    private boolean at;
    private Object au;
    private Object av;
    private Handler aw;
    private c$a ax;
    private float ay;
    private int az;
    public int[] b;
    public int[] c;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private int m = 0;
    private int n = 0;
    private int o = 0;
    private int p = 0;
    private int q = 0;
    private int r = 0;
    private int s = 0;
    private int t = 0;
    private int u = 0;
    private int v = 0;
    private int w = 0;
    private int x = 0;
    private int y = 0;
    private int z = 0;

    public c(Context object, boolean bl2) {
        super("TXCFilterDrawer");
        int n10;
        d$e d$e;
        boolean bl3;
        this.C = bl3 = true;
        this.D = false;
        this.E = d$e = new d$e();
        this.F = null;
        this.G = n10 = -1;
        this.H = n10;
        this.I = n10;
        this.J = n10;
        this.K = n10;
        this.L = n10;
        this.M = 1.0f;
        this.N = n10;
        this.O = n10;
        this.P = (int)(bl3 ? 1 : 0);
        this.Q = false;
        this.R = null;
        this.S = false;
        this.T = 0;
        this.U = 0;
        this.V = null;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.aa = null;
        this.ab = null;
        this.ac = null;
        this.ad = null;
        this.ak = null;
        this.al = null;
        this.am = null;
        this.an = null;
        this.ao = null;
        this.ap = null;
        this.aq = null;
        this.ar = null;
        Object object2 = new LinkedList();
        this.as = object2;
        this.a = false;
        this.au = object2 = new Object();
        this.av = object2 = new Object();
        this.ay = 0.5f;
        this.az = 0;
        this.aA = 0;
        this.aB = 0;
        this.aC = 0;
        this.aD = 0;
        this.aE = false;
        this.aF = null;
        this.aG = null;
        this.aH = null;
        this.aI = null;
        this.aJ = 0L;
        this.aK = 0;
        this.aL = 100;
        this.aM = 1000.0f;
        this.aN = null;
        this.aO = null;
        this.aP = false;
        this.aQ = null;
        this.b = null;
        this.c = null;
        this.aR = n10;
        this.aS = 0;
        this.aT = (int)(bl3 ? 1 : 0);
        this.aU = n10;
        this.aV = null;
        Object object3 = new WeakReference(null);
        this.aW = object3;
        this.aX = object3 = new com.tencent.liteav.beauty.b.a();
        this.aZ = object3 = new c$12(this);
        this.B = object;
        object3 = this.B.getMainLooper();
        object = new Handler((Looper)object3);
        this.aw = object;
        this.at = bl2;
        int n11 = (int)TimeUnit.SECONDS.toMillis(5);
        this.aY = object = new com.tencent.liteav.basic.util.c("filter-drawer", n11);
    }

    private int A(int n10) {
        int n11 = this.G;
        int n12 = this.H;
        GLES20.glViewport((int)0, (int)0, (int)n11, (int)n12);
        n11 = this.X.r();
        return this.a(n11, n10, 0L);
    }

    public static /* synthetic */ float a(c c10, float f10) {
        c10.ay = f10;
        return f10;
    }

    private int a(int n10, int n11) {
        int n12 = 1;
        int n13 = this.at;
        if (n12 == n13) {
            Object object = this.aV;
            if (object != null) {
                object = this.aN;
                NativeLoad.nativeGlReadPixs(n10, n11, (byte[])object);
                e e10 = this.aV;
                byte[] byArray = this.aN;
                int n14 = this.N;
                int n15 = this.O;
                int n16 = this.U;
                long l10 = TXCTimeUtil.generatePtsMS();
                e10.a(byArray, n14, n15, n16, l10);
            } else {
                object = this.aQ;
                if (object != null) {
                    NativeLoad.nativeGlReadPixs(n10, n11, (byte[])object);
                }
            }
        } else {
            n13 = 3;
            float f10 = 4.2E-45f;
            int n17 = TXCOpenGlUtils.a();
            if (n13 == n17) {
                Object object;
                float f11;
                int n18;
                long l11 = 0L;
                long l12 = this.aJ;
                long l13 = l11 - l12;
                n13 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
                if (n13 == 0) {
                    this.aJ = l11 = TXCTimeUtil.getTimeTick();
                }
                this.aK = n13 = this.aK + n12;
                n17 = 100;
                float f12 = 1.4E-43f;
                String string2 = "TXCFilterDrawer";
                if (n13 >= n17) {
                    n13 = 1120403456;
                    l12 = TXCTimeUtil.getTimeTick();
                    long l14 = this.aJ;
                    f12 = l12 - l14;
                    n18 = 1148846080;
                    f11 = 1000.0f;
                    f10 = 100.0f / (f12 /= f11);
                    StringBuilder stringBuilder = new StringBuilder();
                    object = "Real fps ";
                    stringBuilder.append((String)object);
                    stringBuilder.append(f10);
                    String string3 = stringBuilder.toString();
                    TXCLog.i(string2, string3);
                    this.aK = 0;
                    this.aJ = l12 = TXCTimeUtil.getTimeTick();
                }
                f10 = 4.67E-42f;
                GLES30.glPixelStorei((int)3333, (int)n12);
                n13 = Build.VERSION.SDK_INT;
                n17 = 18;
                f12 = 2.5E-44f;
                if (n13 >= n17) {
                    n18 = 1029;
                    f11 = 1.442E-42f;
                    GLES30.glReadBuffer((int)n18);
                }
                n18 = this.aO[0];
                int n19 = 35051;
                GLES30.glBindBuffer((int)n19, (int)n18);
                n18 = 0;
                f11 = 0.0f;
                object = null;
                NativeLoad.nativeGlReadPixs(n10, n11, null);
                if (n13 >= n17) {
                    n18 = n10 * n11 * 4;
                    Buffer buffer = GLES30.glMapBufferRange((int)n19, (int)0, (int)n18, (int)n12);
                    object = buffer;
                    object = (ByteBuffer)buffer;
                    if (object == null) {
                        TXCLog.e(string2, "glMapBufferRange is null");
                        return -1;
                    }
                }
                NativeLoad.nativeGlMapBufferToQueue(n10, n11, (ByteBuffer)object);
                if (n13 >= n17) {
                    GLES30.glUnmapBuffer((int)n19);
                }
                GLES30.glBindBuffer((int)n19, (int)0);
            } else {
                NativeLoad.nativeGlReadPixsToQueue(n10, n11);
            }
        }
        return 0;
    }

    private int a(int n10, long l10) {
        int n11 = this.U;
        if (n11 == 0) {
            e e10 = this.aV;
            if (e10 != null) {
                long l11 = 0L;
                long l12 = l10 - l11;
                n11 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
                if (n11 == 0) {
                    l10 = TXCTimeUtil.generatePtsMS();
                }
                e10 = this.aV;
                int n12 = this.N;
                int n13 = this.O;
                int n14 = n10;
                e10.a(n10, n12, n13, l10);
            }
            return n10;
        }
        int n15 = 1;
        String string2 = "TXCFilterDrawer";
        int n16 = 2;
        int n17 = 3;
        if (n15 != n11 && n17 != n11 && n16 != n11) {
            TXCLog.e(string2, "Don't support format!");
            return -1;
        }
        n15 = this.N;
        n11 = this.O;
        boolean bl2 = false;
        GLES20.glViewport((int)0, (int)0, (int)n15, (int)n11);
        o o10 = this.Y;
        if (o10 == null) {
            TXCLog.e(string2, "mRGBA2I420Filter is null!");
            return n10;
        }
        n15 = this.b[0];
        int n18 = 36160;
        GLES20.glBindFramebuffer((int)n18, (int)n15);
        o10 = this.Y;
        o10.a(n10);
        n15 = this.U;
        if (n16 == n15) {
            n15 = this.N;
            n11 = this.O;
            this.a(n15, n11);
        } else {
            n15 = this.N;
            n11 = this.O * n17 / 8;
            this.a(n15, n11);
        }
        GLES20.glBindFramebuffer((int)n18, (int)0);
        return n10;
    }

    public static /* synthetic */ int a(c c10, int n10) {
        c10.U = n10;
        return n10;
    }

    public static /* synthetic */ com.tencent.liteav.beauty.a.a.a a(c c10, com.tencent.liteav.beauty.a.a.a a10) {
        c10.aG = a10;
        return a10;
    }

    public static /* synthetic */ com.tencent.liteav.beauty.a.a.c a(c c10, com.tencent.liteav.beauty.a.a.c c11) {
        c10.aF = c11;
        return c11;
    }

    public static /* synthetic */ m a(c c10) {
        return c10.aj;
    }

    public static /* synthetic */ m a(c c10, m m10) {
        c10.aj = m10;
        return m10;
    }

    public static /* synthetic */ x a(c c10, x x10) {
        c10.al = x10;
        return x10;
    }

    private void a(int n10, int n11, float f10, Bitmap bitmap, float f11, Bitmap bitmap2, float f12) {
        Object object = this.aj;
        if (object == null) {
            m m10;
            object = "TXCFilterDrawer";
            TXCLog.i((String)object, "createComLooKupFilter");
            this.aj = m10 = new m(f10, bitmap, f11, bitmap2, f12);
            boolean bl2 = m10.a();
            boolean bl3 = true;
            if (bl3 == bl2) {
                this.aj.a(bl3);
                m m11 = this.aj;
                m11.a(n10, n11);
            } else {
                String string2 = "mLookupFilterGroup init failed!";
                TXCLog.e((String)object, string2);
            }
        }
    }

    private void a(int n10, int n11, int n12) {
        Object object;
        String string2 = "TXCFilterDrawer";
        String string3 = "create Beauty Filter!";
        TXCLog.i(string2, string3);
        int n13 = 1;
        if (n12 == 0) {
            object = this.aa;
            if (object == null) {
                object = new com.tencent.liteav.beauty.b.a.a();
                this.aa = object;
            }
            object = this.aa;
            this.Z = object;
            object = "0 BeautyFilter";
            Log.i((String)string2, (String)object);
        } else if (n13 == n12) {
            object = this.ab;
            if (object == null) {
                this.ab = object = new a();
            }
            this.Z = object = this.ab;
            object = "1 BeautyFilter";
            Log.i((String)string2, (String)object);
        } else {
            int n14 = 2;
            if (n14 == n12) {
                object = this.ad;
                if (object == null) {
                    this.ad = object = new com.tencent.liteav.beauty.b.c.a();
                }
                this.Z = object = this.ad;
                object = "2 BeautyFilter";
                Log.i((String)string2, (String)object);
            } else {
                n14 = 3;
                if (n14 == n12) {
                    object = this.ac;
                    if (object == null) {
                        this.ac = object = new com.tencent.liteav.beauty.b.c();
                    }
                    this.Z = object = this.ac;
                    object = "3 BeautyFilter";
                    Log.i((String)string2, (String)object);
                }
            }
        }
        object = this.Z;
        if (object == null) {
            TXCLog.e(string2, "mBeautyFilter set error!");
            return;
        }
        ((com.tencent.liteav.basic.opengl.i)object).a(n13 != 0);
        object = this.Z;
        n10 = (int)(((b)object).c(n10, n11) ? 1 : 0);
        if (n13 == n10) {
            b b10;
            n10 = this.aA;
            if (n10 > 0) {
                b10 = this.Z;
                b10.c(n10);
            }
            if ((n10 = this.aB) > 0) {
                b10 = this.Z;
                b10.d(n10);
            }
            if ((n10 = this.aD) > 0) {
                b10 = this.Z;
                b10.e(n10);
            }
            if ((n10 = this.aC) > 0) {
                b10 = this.Z;
                b10.f(n10);
            }
        } else {
            String string4 = "mBeautyFilter init failed!";
            TXCLog.e(string2, string4);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(int n10, int n11, int n12, int n13, int n14) {
        Object object = this.av;
        synchronized (object) {
            Object object2;
            Object object3;
            n14 += 360;
            Object object4 = "TXCFilterDrawer";
            CharSequence charSequence = new StringBuilder();
            String string2 = "real outputAngle ";
            charSequence.append(string2);
            charSequence.append(n14 %= 360);
            charSequence = charSequence.toString();
            TXCLog.i((String)object4, (String)charSequence);
            object4 = this.ao;
            if (object4 == null) {
                if (n10 == n12 && n11 == n13 && n14 == 0) {
                    String string3 = "TXCFilterDrawer";
                    String string4 = "Don't need change output Image, don't create out filter!";
                    TXCLog.i(string3, string4);
                    return;
                }
                object3 = new com.tencent.liteav.basic.opengl.i();
                this.ao = object3;
                n11 = 1;
                n10 = (int)(((com.tencent.liteav.basic.opengl.i)object3).a() ? 1 : 0);
                if (n11 == n10) {
                    object3 = this.ao;
                    ((com.tencent.liteav.basic.opengl.i)object3).a(n11 != 0);
                } else {
                    object3 = "TXCFilterDrawer";
                    object2 = "mOutputZoomFilter init failed!";
                    TXCLog.e((String)object3, (String)object2);
                }
            }
            object3 = this.ao;
            ((com.tencent.liteav.basic.opengl.i)object3).a(n12, n13);
            n10 = 720 - n14;
            object2 = this.ao;
            n12 = 0;
            ((com.tencent.liteav.basic.opengl.i)object2).a(n10 %= 360, (FloatBuffer)null);
            return;
        }
    }

    private void a(com.tencent.liteav.basic.opengl.a a10, int n10, int n11, int n12, int n13, boolean bl2, int n14, int n15) {
        Object object;
        int n16;
        float f10;
        int n17;
        c c10 = this;
        Object object2 = this.ap;
        if (object2 == null) {
            object2 = "TXCFilterDrawer";
            Object object3 = "Create CropFilter";
            TXCLog.i((String)object2, (String)object3);
            n17 = 4;
            f10 = 5.6E-45f;
            n16 = 1;
            if (n17 == n15) {
                object = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nuniform mat4 textureTransform;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (textureTransform * inputTextureCoordinate).xy;\n}";
                String string2 = "#extension GL_OES_EGL_image_external : require\n\nvarying lowp vec2 textureCoordinate;\n \nuniform samplerExternalOES inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}";
                this.ap = object3 = new l((String)object, string2, n16 != 0);
            } else {
                this.ap = object3 = new l();
            }
            object3 = c10.ap;
            n17 = (int)(((com.tencent.liteav.basic.opengl.i)object3).a() ? 1 : 0);
            if (n16 == n17) {
                object2 = c10.ap;
                ((com.tencent.liteav.basic.opengl.i)object2).a(n16 != 0);
            } else {
                object3 = "mInputCropFilter init failed!";
                TXCLog.e((String)object2, (String)object3);
            }
        }
        object2 = c10.ap;
        n17 = n12;
        n16 = n13;
        ((com.tencent.liteav.basic.opengl.i)object2).a(n12, n13);
        object = c10.ap;
        int n18 = c10.G;
        int n19 = c10.H;
        Object object4 = a10;
        float[] fArray = ((com.tencent.liteav.basic.opengl.i)object).a(n18, n19, null, a10, n15);
        int n20 = n14;
        int n21 = (720 - n14) % 360;
        n20 = 270;
        float f11 = 3.78E-43f;
        int n22 = 90;
        n18 = n21 != n22 && n21 != n20 ? n12 : n16;
        if (n21 != n22 && n21 != n20) {
            n17 = n16;
        }
        object4 = c10.ap;
        f11 = n18;
        f10 = n17;
        float f12 = f11 / f10;
        ((com.tencent.liteav.basic.opengl.i)object4).a(n10, n11, n21, fArray, f12, bl2, false);
    }

    public static /* synthetic */ void a(c c10, int n10, int n11, float f10, Bitmap bitmap, float f11, Bitmap bitmap2, float f12) {
        c10.a(n10, n11, f10, bitmap, f11, bitmap2, f12);
    }

    public static /* synthetic */ void a(c c10, int n10, int n11, int n12) {
        c10.a(n10, n11, n12);
    }

    public static /* synthetic */ void a(c c10, byte[] byArray) {
        c10.b(byArray);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(Runnable runnable) {
        Queue queue = this.as;
        synchronized (queue) {
            Queue queue2 = this.as;
            queue2.add(runnable);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void a(Queue queue) {
        while (true) {
            Runnable runnable = null;
            // MONITORENTER : queue
            boolean bl2 = queue.isEmpty();
            if (!bl2) {
                runnable = (Runnable)queue.poll();
                runnable = runnable;
            }
            // MONITOREXIT : queue
            if (runnable == null) return;
            runnable.run();
        }
    }

    private void a(byte[] byArray, boolean bl2) {
        c c10 = this;
        String string2 = "TXCFilterDrawer";
        if (!bl2) {
            Object object = this.aV;
            if (object != null) {
                int n10 = this.N;
                int n11 = this.O;
                int n12 = this.U;
                long l10 = TXCTimeUtil.generatePtsMS();
                byte[] byArray2 = byArray;
                object.a(byArray, n10, n11, n12, l10);
            } else {
                object = "First Frame, don't process!";
                TXCLog.i(string2, (String)object);
            }
        } else {
            int n13 = this.O;
            int n14 = n13 * 3 / 8;
            int n15 = 2;
            int n16 = this.U;
            if (n15 != n16) {
                n13 = n14;
            }
            e e10 = c10.aV;
            String string3 = "nativeGlReadPixsFromQueue Failed";
            if (e10 != null) {
                n14 = c10.N;
                n14 = 1;
                Object object = c10.aN;
                if (n14 == (n13 = (int)(NativeLoad.nativeGlReadPixsFromQueue(n14, n13, object) ? 1 : 0))) {
                    object = c10.aV;
                    byte[] byArray3 = c10.aN;
                    int n17 = c10.N;
                    int n18 = c10.O;
                    int n19 = c10.U;
                    long l11 = TXCTimeUtil.generatePtsMS();
                    object.a(byArray3, n17, n18, n19, l11);
                } else {
                    TXCLog.d(string2, string3);
                    e e11 = c10.aV;
                    int n20 = c10.N;
                    int n21 = c10.O;
                    int n22 = c10.U;
                    long l12 = TXCTimeUtil.generatePtsMS();
                    e11.a(byArray, n20, n21, n22, l12);
                }
            } else {
                n14 = c10.N;
                byte[] byArray4 = c10.aQ;
                if ((n13 = (int)(NativeLoad.nativeGlReadPixsFromQueue(n14, n13, byArray4) ? 1 : 0)) == 0) {
                    TXCLog.d(string2, string3);
                }
            }
        }
    }

    private void a(int[] nArray, int[] nArray2, int n10, int n11) {
        GLES20.glGenFramebuffers((int)1, (int[])nArray, (int)0);
        int n12 = 6408;
        nArray2[0] = n10 = TXCOpenGlUtils.a(n10, n11, n12, n12, nArray2);
        int n13 = nArray[0];
        n10 = 36160;
        GLES20.glBindFramebuffer((int)n10, (int)n13);
        n13 = nArray2[0];
        GLES20.glFramebufferTexture2D((int)n10, (int)36064, (int)3553, (int)n13, (int)0);
        GLES20.glBindFramebuffer((int)n10, (int)0);
    }

    public static /* synthetic */ boolean a(c c10, d$b d$b) {
        return c10.c(d$b);
    }

    public static /* synthetic */ boolean a(c c10, boolean bl2) {
        c10.S = bl2;
        return bl2;
    }

    public static /* synthetic */ float[] a(c c10, float[] fArray) {
        c10.R = fArray;
        return fArray;
    }

    public static /* synthetic */ int b(c c10, int n10) {
        return c10.A(n10);
    }

    public static /* synthetic */ x b(c c10) {
        return c10.al;
    }

    private void b() {
        Object object;
        String string2 = "TXCFilterDrawer";
        TXCLog.i(string2, "come into releaseInternal");
        this.aP = false;
        Object object2 = this.X;
        if (object2 != null) {
            ((com.tencent.liteav.basic.opengl.i)object2).d();
            this.X = null;
        }
        if ((object2 = this.Y) != null) {
            ((com.tencent.liteav.basic.opengl.i)object2).d();
            this.Y = null;
        }
        this.c();
        object2 = this.aj;
        if (object2 != null) {
            ((com.tencent.liteav.basic.opengl.i)object2).d();
            this.aj = null;
        }
        if ((object2 = this.ak) != null) {
            object2.a();
            this.ak = null;
        }
        if ((object2 = this.aq) != null) {
            ((com.tencent.liteav.basic.opengl.i)object2).d();
            this.aq = null;
        }
        if ((object2 = this.ap) != null) {
            ((com.tencent.liteav.basic.opengl.i)object2).d();
            this.ap = null;
        }
        if ((object2 = this.ao) != null) {
            ((com.tencent.liteav.basic.opengl.i)object2).d();
            this.ao = null;
        }
        if ((object2 = this.al) != null) {
            ((x)object2).d();
            this.al = null;
        }
        if ((object2 = this.am) != null) {
            ((j)object2).a();
            this.am = null;
        }
        if ((object2 = this.an) != null) {
            ((com.tencent.liteav.basic.opengl.i)object2).d();
            this.an = null;
        }
        if ((object2 = this.ar) != null) {
            ((com.tencent.liteav.basic.opengl.i)object2).d();
            this.ar = null;
        }
        object2 = this.b;
        int n10 = 1;
        if (object2 != null) {
            GLES20.glDeleteFramebuffers((int)n10, (int[])object2, (int)0);
            this.b = null;
        }
        if ((object2 = (Object)this.c) != null) {
            GLES20.glDeleteTextures((int)n10, (int[])object2, (int)0);
            this.c = null;
        }
        if ((object2 = (Object)this.aO) != null && (object = object2[0]) > 0) {
            GLES30.glDeleteBuffers((int)n10, (int[])object2, (int)0);
            this.aO = null;
        }
        TXCLog.i(string2, "come out releaseInternal");
    }

    private void b(int n10, int n11) {
        Object object = this.ar;
        if (object == null) {
            object = "TXCFilterDrawer";
            TXCLog.i((String)object, "createRecoverScaleFilter");
            Object object2 = new com.tencent.liteav.basic.opengl.i();
            this.ar = object2;
            boolean bl2 = ((com.tencent.liteav.basic.opengl.i)object2).a();
            boolean bl3 = true;
            if (bl3 == bl2) {
                object = this.ar;
                ((com.tencent.liteav.basic.opengl.i)object).a(bl3);
            } else {
                object2 = "mRecoverScaleFilter init failed!";
                TXCLog.e((String)object, (String)object2);
            }
        }
        if ((object = this.ar) != null) {
            ((com.tencent.liteav.basic.opengl.i)object).a(n10, n11);
        }
    }

    private void b(byte[] byArray) {
        k k10 = this.X;
        if (k10 == null) {
            TXCLog.e("TXCFilterDrawer", "mI4202RGBAFilter is null!");
            return;
        }
        k10.a(byArray);
    }

    public static /* synthetic */ boolean b(c c10, d$b d$b) {
        return c10.d(d$b);
    }

    public static /* synthetic */ boolean b(c c10, boolean bl2) {
        c10.aE = bl2;
        return bl2;
    }

    public static /* synthetic */ int c(c c10) {
        return c10.I;
    }

    private void c() {
        b b10 = this.aa;
        if (b10 != null) {
            b10.d();
            this.aa = null;
        }
        if ((b10 = this.ab) != null) {
            b10.d();
            this.ab = null;
        }
        if ((b10 = this.ac) != null) {
            b10.d();
            this.ac = null;
        }
        if ((b10 = this.ad) != null) {
            b10.d();
            this.ad = null;
        }
        this.Z = null;
    }

    private boolean c(d$b d$b) {
        Bitmap bitmap;
        float f10;
        int n10;
        float f11;
        int n11;
        int n12;
        int n13;
        int n14;
        int n15;
        int n16;
        Object object;
        int n17;
        String string2;
        Object object2;
        c c10;
        block18: {
            block17: {
                c10 = this;
                object2 = d$b;
                string2 = "TXCFilterDrawer";
                TXCLog.i(string2, "come into initInternal");
                this.b();
                this.at = n17 = d$b.j;
                this.G = n17 = d$b.d;
                this.H = n17 = d$b.e;
                object = d$b.m;
                this.V = object;
                n16 = d$b.g;
                n15 = d$b.f;
                n14 = d$b.h;
                n17 = (int)(d$b.i ? 1 : 0);
                this.Q = n17;
                this.N = n17 = d$b.b;
                this.O = n13 = d$b.c;
                n12 = d$b.a;
                this.I = n16;
                this.J = n15;
                n11 = 90;
                f11 = 1.26E-43f;
                if (n14 == n11) break block17;
                n11 = 270;
                f11 = 3.78E-43f;
                if (n14 != n11) break block18;
            }
            c10.I = n15;
            c10.J = n16;
        }
        c10.U = n11 = object2.l;
        c10.T = n10 = object2.k;
        object2 = new byte[n17 * n13 * 4];
        c10.aN = (byte[])object2;
        int n18 = 3;
        object2 = new Object[n18];
        object2[0] = object = Float.valueOf(c10.M);
        object = c10.I;
        int n19 = 1;
        object2[n19] = object;
        n13 = c10.J;
        Integer n20 = n13;
        object2[2] = n20;
        object = "processWidth mPituScaleRatio is %f, process size: %d x %d";
        TXCLog.i(string2, (String)object, (Object[])object2);
        float f12 = c10.M;
        n17 = 1065353216;
        float f13 = 1.0f;
        n10 = (int)(f12 == f13 ? 0 : (f12 > f13 ? 1 : -1));
        if (n10 != 0) {
            float f14;
            n10 = c10.I;
            n13 = c10.J;
            if (n10 >= n13) {
                n10 = n13;
            }
            n13 = 368;
            f10 = 5.16E-43f;
            if (n10 > n13) {
                n13 = 1138229248;
                f12 = n10;
                c10.M = f10 = 432.0f / f12;
            }
            if ((n10 = (int)((f14 = (f12 = c10.M) - f13) == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1))) > 0) {
                c10.M = f13;
            }
        }
        f12 = c10.I;
        f13 = c10.M;
        c10.K = n10 = (int)(f12 *= f13);
        f10 = (float)c10.J * f13;
        c10.L = n17 = (int)f10;
        n13 = c10.az;
        c10.a(n10, n17, n13);
        object2 = c10.F;
        if (object2 != null && (object2 = object2.a) != null && (object2 = c10.al) == null) {
            TXCLog.i(string2, "reset water mark!");
            object2 = c10.F;
            object = object2.a;
            f10 = object2.b;
            f11 = object2.c;
            f12 = object2.d;
            c10.a((Bitmap)object, f10, f11, f12);
        }
        if (((bitmap = c10.ae) != null || (object2 = c10.af) != null) && (object2 = c10.aj) == null) {
            n17 = c10.K;
            n13 = c10.L;
            f11 = c10.ag;
            float f15 = c10.ah;
            Bitmap bitmap2 = c10.af;
            f12 = c10.ai;
            object2 = this;
            n18 = n19;
            this.a(n17, n13, f11, bitmap, f15, bitmap2, f12);
        } else {
            n18 = n19;
        }
        object = c10.V;
        int n21 = c10.K;
        int n22 = c10.L;
        boolean bl2 = c10.Q;
        n19 = c10.T;
        object2 = this;
        n13 = n16;
        n11 = n15;
        int n23 = n19;
        n19 = n14;
        n14 = n23;
        this.a((com.tencent.liteav.basic.opengl.a)object, n16, n15, n21, n22, bl2, n19, n23);
        n17 = c10.I;
        n13 = c10.J;
        n11 = c10.N;
        n21 = c10.O;
        n22 = n12;
        this.a(n17, n13, n11, n21, n12);
        object2 = c10.b;
        if (object2 == null) {
            object2 = new int[n18];
            c10.b = (int[])object2;
        } else {
            GLES20.glDeleteFramebuffers((int)n18, (int[])object2, (int)0);
        }
        object2 = c10.c;
        if (object2 == null) {
            object2 = new int[n18];
            c10.c = (int[])object2;
        } else {
            GLES20.glDeleteTextures((int)n18, (int[])object2, (int)0);
        }
        object2 = c10.b;
        object = c10.c;
        n13 = c10.N;
        n11 = c10.O;
        c10.a((int[])object2, (int[])object, n13, n11);
        n10 = TXCOpenGlUtils.a();
        n17 = 3;
        f13 = 4.2E-45f;
        if (n17 == n10) {
            object2 = c10.aO;
            if (object2 == null) {
                object2 = new int[n18];
                c10.aO = (int[])object2;
            } else {
                TXCLog.i(string2, "m_pbo0 is not null, delete Buffers, and recreate");
                object2 = c10.aO;
                GLES30.glDeleteBuffers((int)n18, (int[])object2, (int)0);
            }
            TXCLog.i(string2, "opengl es 3.0, use PBO");
            object2 = c10.aO;
            TXCOpenGlUtils.a(n16, n15, (int[])object2);
        }
        TXCLog.i(string2, "come out initInternal");
        return n18 != 0;
    }

    public static /* synthetic */ int d(c c10) {
        return c10.J;
    }

    private boolean d(d$b d$b) {
        com.tencent.liteav.basic.opengl.i i10;
        int n10 = d$b.k;
        int n11 = 0;
        String string2 = "TXCFilterDrawer";
        int n12 = 2;
        int n13 = 3;
        int n14 = 1;
        if ((n14 == n10 || n13 == n10 || n12 == n10) && (i10 = this.X) == null) {
            int n15 = d$b.k;
            i10 = new k(n15);
            this.X = i10;
            i10.a(n14 != 0);
            i10 = this.X;
            n10 = (int)(((k)i10).a() ? 1 : 0);
            if (n10 == 0) {
                TXCLog.e(string2, "mI4202RGBAFilter init failed!!, break init");
                return false;
            }
            i10 = this.X;
            n15 = d$b.d;
            int n16 = d$b.e;
            ((k)i10).a(n15, n16);
        }
        if ((n14 == (n10 = d$b.l) || n13 == n10 || n12 == n10) && (i10 = this.Y) == null) {
            n12 = d$b.l;
            i10 = new o(n12);
            this.Y = i10;
            n10 = (int)(((o)i10).a() ? 1 : 0);
            if (n10 == 0) {
                TXCLog.e(string2, "mRGBA2I420Filter init failed!!, break init");
                return false;
            }
            i10 = this.Y;
            n11 = d$b.b;
            int n17 = d$b.c;
            ((o)i10).a(n11, n17);
        }
        return n14 != 0;
    }

    public static /* synthetic */ b e(c c10) {
        return c10.Z;
    }

    public static /* synthetic */ int f(c c10) {
        return c10.K;
    }

    public static /* synthetic */ int g(c c10) {
        return c10.L;
    }

    public static /* synthetic */ Bitmap h(c c10) {
        return c10.ae;
    }

    public static /* synthetic */ Bitmap i(c c10) {
        return c10.af;
    }

    public static /* synthetic */ float j(c c10) {
        return c10.ag;
    }

    public static /* synthetic */ float k(c c10) {
        return c10.ah;
    }

    public static /* synthetic */ float l(c c10) {
        return c10.ai;
    }

    public static /* synthetic */ com.tencent.liteav.beauty.a.a.a m(c c10) {
        return c10.aG;
    }

    public static /* synthetic */ com.tencent.liteav.beauty.a.a.c n(c c10) {
        return c10.aF;
    }

    public static /* synthetic */ void o(c c10) {
        c10.b();
    }

    public static /* synthetic */ com.tencent.liteav.beauty.b.a p(c c10) {
        return c10.aX;
    }

    public static /* synthetic */ float q(c c10) {
        return c10.ay;
    }

    public int a(int n10, int n11, long l10) {
        Object object;
        this.aY.a();
        Queue queue = this.as;
        this.a(queue);
        float f10 = this.M;
        float f11 = f10 - 1.0f;
        float f12 = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
        int n12 = 1;
        float f13 = Float.MIN_VALUE;
        if (f12 != false) {
            f12 = n12;
            f10 = f13;
        } else {
            f12 = 0.0f;
            queue = null;
            f10 = 0.0f;
        }
        int n13 = this.K;
        int n14 = this.L;
        GLES20.glViewport((int)0, (int)0, (int)n13, (int)n14);
        l l11 = this.ap;
        if (l11 != null) {
            n14 = 4;
            if (n14 == n11 || n12 == (n11 = (int)(this.S ? 1 : 0))) {
                object = this.R;
                l11.a((float[])object);
                object = this.ap;
                n12 = (int)(this.S ? 1 : 0);
                ((l)object).c(n12 != 0);
            }
            object = this.ap;
            n10 = ((com.tencent.liteav.basic.opengl.i)object).b(n10);
        }
        if ((object = this.Z) != null) {
            n11 = this.N;
            n12 = this.O;
            n11 = Math.min(n11, n12);
            n12 = 540;
            f13 = 7.57E-43f;
            if (n11 < n12) {
                n11 = 0;
                object = null;
            } else {
                n11 = this.aC;
            }
            b b10 = this.Z;
            b10.f(n11);
            n11 = this.aA;
            if (n11 > 0 || (n11 = this.aB) > 0 || (n11 = this.aD) > 0) {
                object = this.Z;
                n10 = ((com.tencent.liteav.basic.opengl.i)object).b(n10);
            }
        }
        if ((object = this.aj) != null) {
            n10 = ((com.tencent.liteav.basic.opengl.i)object).b(n10);
        }
        n11 = this.I;
        n12 = this.J;
        GLES20.glViewport((int)0, (int)0, (int)n11, (int)n12);
        object = this.am;
        if (object != null) {
            n10 = ((j)object).a(n10);
            f12 = 0.0f;
            queue = null;
            f10 = 0.0f;
        }
        if ((object = this.an) != null) {
            n10 = ((com.tencent.liteav.basic.opengl.i)object).b(n10);
            f12 = 0.0f;
            queue = null;
            f10 = 0.0f;
        }
        if (f12 != false) {
            n11 = this.I;
            f12 = this.J;
            this.b(n11, (int)f12);
            object = this.ar;
            if (object != null) {
                n11 = this.I;
                f12 = this.J;
                GLES20.glViewport((int)0, (int)0, (int)n11, (int)f12);
                object = this.ar;
                n10 = ((com.tencent.liteav.basic.opengl.i)object).b(n10);
            }
        }
        if ((object = this.aV) != null && (n11 = object.a(n10, (int)(f12 = (float)this.I), n12 = this.J)) > 0) {
            n10 = n11;
        }
        n11 = this.I;
        f12 = this.J;
        GLES20.glViewport((int)0, (int)0, (int)n11, (int)f12);
        object = this.al;
        if (object != null) {
            n10 = ((com.tencent.liteav.basic.opengl.i)object).b(n10);
        }
        if ((object = this.ao) != null) {
            n11 = this.N;
            f12 = this.O;
            GLES20.glViewport((int)0, (int)0, (int)n11, (int)f12);
            object = this.ao;
            n10 = ((com.tencent.liteav.basic.opengl.i)object).b(n10);
        }
        this.a(n10, l10);
        return n10;
    }

    public int a(byte[] byArray, int n10) {
        int n11;
        this.a(byArray);
        boolean bl2 = this.at;
        if (!bl2) {
            byArray = (byte[])byArray.clone();
            Object object = this.ax;
            int n12 = 2;
            object = object.obtainMessage(n12, byArray);
            object.sendToTarget();
            bl2 = this.aP;
            if (!bl2) {
                object = "TXCFilterDrawer";
                String string2 = "First Frame, clear queue";
                TXCLog.i((String)object, string2);
                NativeLoad.nativeClearQueue();
            }
            object = this.ax;
            n12 = 3;
            Message message = object.obtainMessage(n12, n10, 0);
            message.sendToTarget();
            n10 = (int)(this.aP ? 1 : 0);
            this.a(byArray, n10 != 0);
            this.aP = true;
            n11 = -1;
        } else {
            this.b(byArray);
            n11 = this.A(n10);
        }
        return n11;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        boolean bl2 = this.at;
        if (bl2) {
            this.b();
            return;
        }
        c$a c$a = this.ax;
        if (c$a == null) return;
        int n10 = 1;
        Message message = c$a.obtainMessage(n10);
        message.sendToTarget();
        try {
            com.tencent.liteav.beauty.b.a a10 = this.aX;
            a10.b();
            return;
        }
        catch (InterruptedException interruptedException) {
            return;
        }
    }

    public void a(float f10) {
        this.ay = f10;
        c$1 c$1 = new c$1(this, f10);
        this.a(c$1);
    }

    public void a(float f10, Bitmap object, float f11, Bitmap bitmap, float f12) {
        Object object2 = this.ae;
        if (object2 == object && (object2 = this.af) == bitmap) {
            float f13;
            float f14;
            float f15;
            float f16;
            float f17;
            object = this.aj;
            if (object != null && ((f17 = (f16 = (f15 = this.ag) - f10) == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1)) != false || (f17 = (f14 = (f15 = this.ah) - f11) == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1)) != false || (f17 = (f13 = (f15 = this.ai) - f12) == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1)) != false)) {
                this.ag = f10;
                this.ah = f11;
                this.ai = f12;
                object = new c$8(this, f10, f11, f12);
                this.a((Runnable)object);
            }
        } else {
            c$6 c$6;
            this.ae = object;
            this.af = bitmap;
            this.ag = f10;
            this.ah = f11;
            this.ai = f12;
            object2 = c$6;
            c$6 = new c$6(this, f10, (Bitmap)object, f11, bitmap, f12);
            this.a(c$6);
        }
    }

    public void a(int n10) {
    }

    public void a(Bitmap bitmap) {
        float f10 = this.ay;
        this.a(1.0f, bitmap, f10, null, 0.0f);
    }

    public void a(Bitmap bitmap, float f10, float f11, float f12) {
        boolean bl2;
        Object object = this.F;
        if (object == null) {
            object = new d$f();
            this.F = object;
        }
        if (bl2 = TXCCommonUtil.equals(object = this.F.a, bitmap)) {
            float f13;
            float f14;
            float f15;
            object = this.F;
            float f16 = ((d$f)object).b;
            float f17 = f10 - f16;
            Object object2 = f17 == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1);
            if (object2 == false && (object2 = (f15 = f11 - (f16 = ((d$f)object).c)) == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1)) == false && !(bl2 = (f14 = f12 - (f13 = ((d$f)object).d)) == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1)) && (object = this.al) != null) {
                Log.d((String)"TXCFilterDrawer", (String)"Same Water Mark; don't set again");
                return;
            }
        }
        object = this.F;
        ((d$f)object).a = bitmap;
        ((d$f)object).b = f10;
        ((d$f)object).c = f11;
        ((d$f)object).d = f12;
        object = new c$10(this, bitmap, f10, f11, f12);
        this.a((Runnable)object);
    }

    public void a(com.tencent.liteav.basic.b.b object) {
        String string2 = "set notify";
        TXCLog.i("TXCFilterDrawer", string2);
        Object object2 = new WeakReference(object);
        this.aW = object2;
        object = this.am;
        if (object != null) {
            object2 = (com.tencent.liteav.basic.b.b)((Reference)object2).get();
            ((j)object).a((com.tencent.liteav.basic.b.b)object2);
        }
    }

    public void a(e e10) {
        TXCLog.i("TXCFilterDrawer", "set listener");
        this.aV = e10;
    }

    public void a(String string2) {
    }

    public void a(String string2, boolean bl2) {
    }

    public void a(boolean bl2) {
        c$9 c$9 = new c$9(this, bl2);
        this.a(c$9);
    }

    public void a(byte[] byArray) {
        this.aQ = byArray;
    }

    public void a(float[] fArray) {
        c$7 c$7 = new c$7(this, fArray);
        this.a(c$7);
    }

    public boolean a(d$b object) {
        synchronized (this) {
            boolean bl2 = true;
            boolean bl3 = ((d$b)object).j;
            if (!bl3) {
                Looper looper;
                c$a c$a = this.ax;
                if (c$a == null) {
                    this.start();
                    looper = this.getLooper();
                    Context context = this.B;
                    this.ax = c$a = new c$a(this, looper, context);
                }
                c$a = this.ax;
                looper = null;
                object = c$a.obtainMessage(0, object);
                object.sendToTarget();
                object = this.ax;
                ((c$a)((Object)object)).b();
            } else {
                bl2 = this.c((d$b)object);
            }
            return bl2;
        }
    }

    public void b(int n10) {
        c$11 c$11 = new c$11(this, n10);
        this.a(c$11);
    }

    public void b(boolean bl2) {
    }

    public boolean b(d$b d$b) {
        boolean bl2 = this.at;
        if (!bl2) {
            c$a c$a = this.ax;
            if (c$a == null) {
                TXCLog.e("TXCFilterDrawer", "mThreadHandler is null!");
                return false;
            }
            int n10 = 5;
            d$b = c$a.obtainMessage(n10, 0, 0, d$b);
            d$b.sendToTarget();
        } else {
            this.d(d$b);
        }
        return true;
    }

    public void c(int n10) {
        this.aA = n10;
        c$13 c$13 = new c$13(this, n10);
        this.a(c$13);
    }

    public void d(int n10) {
        int n11 = this.az;
        if (n11 != n10 && n10 <= (n11 = 3) && n10 >= 0) {
            this.az = n10;
            c$2 c$2 = new c$2(this, n10);
            this.a(c$2);
        }
    }

    public void e(int n10) {
        this.aB = n10;
        c$3 c$3 = new c$3(this, n10);
        this.a(c$3);
    }

    public void f(int n10) {
        this.aC = n10;
        c$4 c$4 = new c$4(this, n10);
        this.a(c$4);
    }

    public void g(int n10) {
        this.aD = n10;
        c$5 c$5 = new c$5(this, n10);
        this.a(c$5);
    }

    public void h(int n10) {
    }

    public void i(int n10) {
    }

    public void j(int n10) {
    }

    public void k(int n10) {
    }

    public void l(int n10) {
    }

    public void m(int n10) {
    }

    public void n(int n10) {
    }

    public void o(int n10) {
    }

    public void p(int n10) {
    }

    public void q(int n10) {
    }

    public void r(int n10) {
    }

    public void s(int n10) {
    }

    public void t(int n10) {
    }

    public void u(int n10) {
    }

    public void v(int n10) {
    }

    public void w(int n10) {
    }

    public void x(int n10) {
    }

    public void y(int n10) {
    }

    public void z(int n10) {
    }
}

