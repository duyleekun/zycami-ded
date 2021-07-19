/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.SurfaceTexture
 *  android.graphics.SurfaceTexture$OnFrameAvailableListener
 *  android.opengl.GLES20
 *  android.opengl.Matrix
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Message
 */
package com.zhiyun.renderengine.business.display;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.zhiyun.renderengine.bean.TextureFormat;
import com.zhiyun.renderengine.business.display.DisplayRender$EngineCombinationMode;
import com.zhiyun.renderengine.business.display.DisplayRender$a;
import com.zhiyun.renderengine.business.display.DisplayRender$b;
import com.zhiyun.renderengine.business.display.DisplayRender$c;
import com.zhiyun.renderengine.business.display.DisplayRender$d;
import com.zhiyun.renderengine.business.display.DisplayRender$e;
import com.zhiyun.renderengine.business.display.DisplayRender$f;
import com.zhiyun.renderengine.business.display.DisplayRender$g;
import com.zhiyun.renderengine.business.display.DisplayRender$h;
import com.zhiyun.renderengine.business.display.DisplayRender$k;
import com.zhiyun.renderengine.business.display.DisplayRender$m;
import com.zhiyun.renderengine.business.display.DisplayRender$n;
import com.zhiyun.renderengine.business.display.DisplayRender$o;
import com.zhiyun.renderengine.business.display.DisplayRender$p;
import com.zhiyun.renderengine.business.display.DisplayRender$q;
import com.zhiyun.renderengine.business.display.DisplayRender$r;
import com.zhiyun.renderengine.business.display.DisplayRender$s;
import com.zhiyun.renderengine.business.display.DisplayRender$t;
import com.zhiyun.renderengine.business.display.DisplayRender$u;
import com.zhiyun.renderengine.business.display.DisplayRender$v;
import com.zhiyun.renderengine.business.display.DisplayRender$w;
import com.zhiyun.renderengine.business.display.DisplayRender$x;
import com.zhiyun.renderengine.engine.IRenderEngine;
import com.zhiyun.renderengine.engine.RenderEngineType;
import d.v.b0.c.b;
import d.v.b0.c.c.c;
import d.v.b0.c.d.f;
import d.v.b0.c.e.c$a;
import d.v.b0.c.e.d;
import d.v.b0.f.c.a;
import d.v.b0.f.c.b.e;
import d.v.b0.f.c.b.g;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DisplayRender {
    private static final float[] w0;
    private d.v.b0.b.b A;
    private d.v.b0.b.c B;
    private d.v.b0.d.d C;
    private d.v.b0.d.d D;
    private volatile DisplayRender$EngineCombinationMode E;
    private volatile RenderEngineType F;
    private float[] G;
    private float[] H;
    private float[] I;
    private float[] J;
    private float[] K;
    private float[] L;
    private d.v.b0.c.d.e M;
    private d.v.b0.c.d.e N;
    private d.v.b0.c.d.c O;
    private d.v.b0.c.d.c P;
    private f Q;
    private int[] R;
    private Context S;
    private volatile boolean T;
    private boolean U;
    private volatile boolean V;
    private boolean W;
    private Object X;
    public Map Y;
    private volatile int Z;
    private final int a;
    private DisplayRender$r a0;
    private final int b;
    private DisplayRender$s b0;
    private final int c;
    private Handler.Callback c0;
    private final int d;
    private SurfaceTexture.OnFrameAvailableListener d0;
    private final int e;
    public boolean e0;
    private final int f;
    private int f0;
    private final int g;
    private boolean g0;
    private final int h;
    private d.v.b0.j.a h0;
    private final int i;
    private Object i0;
    private final int j;
    private DisplayRender$x j0;
    private Handler k;
    private b k0;
    private HandlerThread l;
    private d.v.b0.j.a l0;
    private Handler m;
    private DisplayRender$v m0;
    private HandlerThread n;
    private d.v.b0.j.a n0;
    public boolean o;
    private DisplayRender$w o0;
    private volatile int p;
    private final int p0;
    private byte[] q;
    private final int q0;
    private byte[] r;
    private Map r0;
    private int s;
    private d s0;
    private int t;
    private d t0;
    private int u;
    private volatile c$a u0;
    private int v;
    private c v0;
    private d.v.b0.f.b w;
    private List x;
    private IRenderEngine y;
    private IRenderEngine z;

    static {
        float[] fArray;
        float[] fArray2 = fArray = new float[16];
        float[] fArray3 = fArray;
        fArray2[0] = 0.0f;
        fArray3[1] = -1.0f;
        fArray2[2] = 0.0f;
        fArray3[3] = 0.0f;
        fArray2[4] = 1.0f;
        fArray3[5] = 0.0f;
        fArray2[6] = 0.0f;
        fArray3[7] = 0.0f;
        fArray2[8] = 0.0f;
        fArray3[9] = 0.0f;
        fArray2[10] = 1.0f;
        fArray3[11] = 0.0f;
        fArray2[12] = 0.0f;
        fArray3[13] = 1.0f;
        fArray2[14] = 0.0f;
        fArray3[15] = 1.0f;
        w0 = fArray;
    }

    public DisplayRender(Context context) {
        Object object;
        int n10;
        int n11;
        this.a = 0;
        this.b = n11 = 1;
        this.c = 2;
        this.d = 5;
        this.e = 33;
        this.f = 34;
        this.g = 35;
        this.h = 36;
        this.i = 48;
        this.j = 80;
        this.o = n11;
        this.p = 0;
        this.q = null;
        this.r = null;
        this.s = n10 = -1;
        this.t = n10;
        this.x = object = new Object();
        object = DisplayRender$EngineCombinationMode.SELECT_ENGINE_APPLY;
        this.E = object;
        object = RenderEngineType.FACE_UNITY_ENGINE;
        this.F = object;
        n10 = 16;
        float[] fArray = new float[n10];
        this.G = fArray;
        fArray = w0;
        int n12 = fArray.length;
        fArray = Arrays.copyOf(fArray, n12);
        this.H = fArray;
        fArray = new float[n10];
        this.I = fArray;
        fArray = new float[n10];
        this.J = fArray;
        fArray = new float[n10];
        this.K = fArray;
        object = new float[n10];
        this.L = (float[])object;
        object = new int[4];
        this.R = (int[])object;
        this.T = n11;
        this.U = false;
        this.V = n11;
        this.W = false;
        this.X = object;
        super();
        this.Y = object;
        this.Z = 90;
        super(this, null);
        this.a0 = object;
        super(this);
        this.c0 = object;
        super(this);
        this.d0 = object;
        this.e0 = n11;
        this.f0 = 0;
        this.g0 = n11;
        super();
        this.h0 = object;
        super();
        this.i0 = object;
        this.j0 = null;
        super(this);
        this.k0 = object;
        super();
        this.l0 = object;
        super();
        this.n0 = object;
        this.o0 = null;
        this.p0 = 0;
        this.q0 = n11;
        Object object2 = new ConcurrentHashMap();
        this.r0 = object2;
        this.s0 = object2 = new DisplayRender$e(this);
        this.t0 = object2 = new DisplayRender$f(this);
        this.v0 = null;
        this.S = context = context.getApplicationContext();
        super("DisplayRender glThread");
        this.l = context;
        context.start();
        object2 = this.l.getLooper();
        Handler.Callback callback = this.c0;
        super((Looper)object2, callback);
        this.k = context;
        super("Business Thread");
        this.n = context;
        context.start();
        object2 = this.n.getLooper();
        super((Looper)object2);
        this.m = context;
        Matrix.setIdentityM((float[])this.G, (int)0);
        Matrix.setIdentityM((float[])this.I, (int)0);
        Matrix.setIdentityM((float[])this.J, (int)0);
        Matrix.setIdentityM((float[])this.K, (int)0);
        Matrix.setIdentityM((float[])this.L, (int)0);
    }

    public static /* synthetic */ IRenderEngine A(DisplayRender displayRender) {
        return displayRender.z;
    }

    private void A0(Message object) {
        Object object2;
        if (object != null && (object2 = ((Message)object).obj) != null) {
            d.v.b0.j.b.c("DisplayRender startRecord(Message)");
            object2 = (d.v.b0.b.c)((Message)object).obj;
            ((Message)object).obj = null;
            Object object3 = ((d.v.b0.b.c)object2).b();
            object3 = this.O((String)object3);
            int n10 = ((d.v.b0.b.c)object2).e();
            if (n10 > 0 && (n10 = ((d.v.b0.b.c)object2).d()) > 0) {
                n10 = ((d.v.b0.b.c)object2).e();
                int n11 = ((d.v.b0.b.c)object2).d();
                int n12 = this.s;
                int n13 = this.t;
                float[] fArray = d.v.b0.f.c.b.e.b(n10, n11, n12, n13);
                n11 = ((d.v.b0.b.c)object2).e();
                n12 = ((d.v.b0.b.c)object2).d();
                n13 = this.s;
                int n14 = this.t;
                float[] fArray2 = d.v.b0.f.c.b.e.a(n11, n12, n13, n14);
                int n15 = ((Message)object).arg1;
                if (n15 != 0) {
                    fArray = fArray2;
                }
                ((DisplayRender$t)object3).a = fArray;
            } else {
                n10 = this.u;
                int n16 = this.v;
                int n17 = this.s;
                int n18 = this.t;
                float[] fArray = d.v.b0.f.c.b.e.b(n10, n16, n17, n18);
                n16 = this.u;
                n17 = this.v;
                n18 = this.s;
                int n19 = this.t;
                float[] fArray3 = d.v.b0.f.c.b.e.a(n16, n17, n18, n19);
                int n20 = ((Message)object).arg1;
                if (n20 != 0) {
                    fArray = fArray3;
                }
                ((DisplayRender$t)object3).a = fArray;
            }
            this.w.e((d.v.b0.b.c)object2);
            object = ((DisplayRender$t)object3).b;
            if (object != null) {
                object = ((DisplayRender$t)object3).b;
                object.e();
            } else {
                object = "DisplayRender startRecord  recordInfo.recordListener = null";
                d.v.b0.j.b.b((String)object);
            }
        }
    }

    public static /* synthetic */ void B(DisplayRender displayRender, Message message) {
        displayRender.V(message);
    }

    public static /* synthetic */ c$a C(DisplayRender displayRender) {
        return displayRender.u0;
    }

    public static /* synthetic */ void D(DisplayRender displayRender) {
        displayRender.Y();
    }

    private void D0() {
        Handler handler = this.m;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.m = null;
        }
        if ((handler = this.n) != null) {
            handler.quitSafely();
            this.n = null;
        }
        if ((handler = this.k) != null) {
            handler.removeCallbacksAndMessages(null);
            this.k = null;
        }
        if ((handler = this.l) != null) {
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 18;
            if (n10 >= n11) {
                handler.quitSafely();
            }
            this.l = null;
        }
    }

    public static /* synthetic */ void E(DisplayRender displayRender, Message message) {
        displayRender.A0(message);
    }

    private void E0(Message object) {
        Object object2;
        if (object != null && (object2 = ((Message)object).obj) != null) {
            object2 = (d.v.b0.b.c)object2;
            ((Message)object).obj = null;
            object = this.w;
            if (object != null) {
                object.a((d.v.b0.b.c)object2);
            }
            object = ((d.v.b0.b.c)object2).b();
            object = this.O((String)object);
            object2 = ((DisplayRender$t)object).b;
            if (object2 != null) {
                object = ((DisplayRender$t)object).b;
                object.a();
            }
        }
    }

    public static /* synthetic */ void F(DisplayRender displayRender, Message message) {
        displayRender.b0(message);
    }

    public static /* synthetic */ void G(DisplayRender displayRender, Message message) {
        displayRender.f0(message);
    }

    public static /* synthetic */ void H(DisplayRender displayRender, Message message) {
        displayRender.E0(message);
    }

    public static /* synthetic */ void I(DisplayRender displayRender, Message message) {
        displayRender.i0(message);
    }

    private void J(int n10, int n11, float[] fArray, float[] fArray2, d.v.b0.c.d.c c10, d.v.b0.c.d.e e10) {
        if (n10 > 0) {
            c10.b(n10, fArray, fArray2);
        } else if (n11 >= 0) {
            e10.b(n11, fArray, fArray2);
        }
    }

    private d.v.b0.b.b M() {
        int n10 = d.v.b0.j.d.d();
        if (n10 >= 0) {
            SurfaceTexture surfaceTexture = new SurfaceTexture(n10);
            d.v.b0.b.b b10 = new d.v.b0.b.b(surfaceTexture);
            b10.d(n10);
            return b10;
        }
        return null;
    }

    private DisplayRender$t O(String string2) {
        DisplayRender$t displayRender$t = (DisplayRender$t)this.r0.get(string2);
        if (displayRender$t != null) {
            return displayRender$t;
        }
        displayRender$t = new DisplayRender$t();
        this.r0.put(string2, displayRender$t);
        return displayRender$t;
    }

    private void T(Message object) {
        if (object != null && (object = ((Message)object).obj) != null) {
            int n10;
            Object object2;
            Object object3;
            int n11;
            object = (SurfaceTexture)object;
            boolean bl3 = false;
            Object object4 = null;
            boolean bl4 = false;
            d.v.b0.d.d d10 = null;
            Object object5 = new d.v.b0.b.c(object, false, null);
            this.B = object5;
            object = this.w;
            if (object == null) {
                this.w = object = new a();
            }
            object = this.w;
            object5 = this.B;
            object.e((d.v.b0.b.c)object5);
            object = this.w;
            object5 = this.B;
            object.c((d.v.b0.b.c)object5);
            object = this.x;
            int bl5 = 1;
            float f10 = Float.MIN_VALUE;
            if (object != null && (n11 = object.size()) > 0) {
                object = this.x.iterator();
                while (bl3 = object.hasNext()) {
                    object4 = (IRenderEngine)object.next();
                    object3 = object4.j();
                    if (object3 == (object2 = RenderEngineType.FACE_UNITY_ENGINE)) {
                        this.y = object4;
                        object3 = this.S;
                        object4.k((Context)object3);
                        object3 = this.y.m(bl5);
                        object2 = this.S;
                        object3.o((Context)object2);
                        object2 = this.y;
                        object2.r((d.v.b0.d.d)object3);
                    }
                    if ((object3 = object4.j()) != (object2 = RenderEngineType.ZHI_YUN_ENGINE)) continue;
                    this.z = object4;
                    object3 = this.S;
                    object4.k((Context)object3);
                    object4 = this.z.m(101);
                    this.C = object4;
                    object3 = this.S;
                    object4.o((Context)object3);
                    object4 = this.z;
                    n10 = 105;
                    object4 = object4.m(n10);
                    this.D = object4;
                    object3 = this.S;
                    object4.o((Context)object3);
                }
            }
            this.O = object = new d.v.b0.c.d.c();
            this.M = object = new d.v.b0.c.d.e();
            this.P = object = new d.v.b0.c.d.c();
            this.N = object = new d.v.b0.c.d.e();
            object = this.b0;
            if (object != null) {
                this.A = object = this.M();
                if (object != null) {
                    if ((object = (SurfaceTexture)((d.v.b0.b.b)object).a()) != null) {
                        object4 = this.d0;
                        object.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener)object4);
                    }
                    object = this.b0;
                    object4 = this.A;
                    n10 = this.u;
                    int bl2 = this.v;
                    object.a((d.v.b0.b.b)object4, n10, bl2);
                } else {
                    object = new IllegalArgumentException("inputSurface can not be null.");
                    throw object;
                }
            }
            if ((object = this.y) != null) {
                float f11;
                object = this.Y;
                object4 = 0;
                n11 = (int)(object.containsKey(object4) ? 1 : 0);
                if (n11 != 0) {
                    object = this.Y;
                    object4 = 0;
                    object = (Float)object.get(object4);
                    float f12 = ((Float)object).floatValue();
                    object4 = this.y.d().iterator();
                    while ((n10 = (int)(object4.hasNext() ? 1 : 0)) != 0) {
                        object3 = (d.v.b0.d.d)object4.next();
                        if (object3 == null) continue;
                        f11 = 1.0f;
                        float f13 = f12 - f11;
                        Object object6 = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
                        if (object6 == false) {
                            object6 = bl5;
                            f11 = f10;
                        } else {
                            object6 = false;
                            object2 = null;
                            f11 = 0.0f;
                        }
                        object3.h((boolean)object6);
                    }
                    object = this.Y;
                    object5 = 0;
                    object.remove(object5);
                }
                if ((object = this.Y.entrySet()) != null) {
                    object = object.iterator();
                    while ((bl5 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                        object5 = (Map.Entry)object.next();
                        object4 = this.y.d().iterator();
                        while (bl4 = object4.hasNext()) {
                            d10 = (d.v.b0.d.d)object4.next();
                            if (d10 == null) continue;
                            object3 = (Integer)object5.getKey();
                            n10 = (Integer)object3;
                            object2 = (Float)object5.getValue();
                            f11 = ((Float)object2).floatValue();
                            d10.j(n10, f11);
                        }
                    }
                }
                object = this.Y;
                object.clear();
            }
            object = this.a0;
            ((DisplayRender$r)object).b();
        }
    }

    private void V(Message object) {
        Object object2;
        boolean bl2;
        Object object3;
        object = this.b0;
        if (object != null) {
            object3 = this.A;
            object.b((d.v.b0.b.b)object3);
        }
        object = null;
        this.b0 = null;
        this.m0 = null;
        this.o0 = null;
        object3 = this.r0.entrySet().iterator();
        while (bl2 = object3.hasNext()) {
            object2 = (DisplayRender$t)((Map.Entry)object3.next()).getValue();
            if (object2 == null) continue;
            ((DisplayRender$t)object2).b = null;
            ((DisplayRender$t)object2).a = null;
        }
        this.r0.clear();
        object3 = this.A;
        if (object3 != null) {
            int n10 = ((d.v.b0.b.b)object3).b();
            if (n10 != 0) {
                n10 = 1;
                object2 = new int[n10];
                d.v.b0.b.b b10 = this.A;
                int n11 = b10.b();
                object2[0] = n11;
                GLES20.glDeleteTextures((int)n10, (int[])object2, (int)0);
                object3 = this.A;
                ((d.v.b0.b.b)object3).d(0);
            }
            object3 = this.A;
            ((d.v.b0.b.b)object3).c();
            this.A = null;
        }
        if ((object3 = this.C) != null) {
            object3.f();
            this.C = null;
        }
        if ((object3 = this.D) != null) {
            object3.f();
            this.D = null;
        }
        if ((object3 = this.v0) != null) {
            ((c)object3).c();
            this.v0 = null;
        }
        if ((object3 = this.O) != null) {
            ((g)object3).f();
            this.O = null;
        }
        if ((object3 = this.M) != null) {
            ((g)object3).f();
            this.M = null;
        }
        if ((object3 = this.P) != null) {
            ((g)object3).f();
            this.P = null;
        }
        if ((object3 = this.N) != null) {
            ((g)object3).f();
            this.N = null;
        }
        if ((object3 = this.y) != null) {
            object3.n();
            this.y = null;
        }
        if ((object3 = this.z) != null) {
            object3.n();
            this.z = null;
        }
        if ((object3 = this.B) != null && (object3 = this.w) != null) {
            object3.release();
            this.w = null;
            this.B = null;
        }
        this.D0();
    }

    private void X(Message message) {
        int n10;
        int n11;
        if (message == null) {
            return;
        }
        this.u = n11 = message.arg1;
        this.v = n10 = message.arg2;
        DisplayRender$s displayRender$s = this.b0;
        if (displayRender$s != null) {
            d.v.b0.b.b b10 = this.A;
            displayRender$s.c(b10, n11, n10);
        }
        this.W = true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void Y() {
        Object object;
        float f10;
        int n10;
        int n11;
        float f11;
        Object object2;
        Object object3;
        Object object4;
        float f12;
        DisplayRender displayRender = this;
        Object object5 = this.A;
        if (object5 == null) return;
        object5 = this.J;
        if (object5 == null) return;
        object5 = this.w;
        if (object5 == null) {
            return;
        }
        GLES20.glClear((int)16640);
        object5 = this.w;
        Object object6 = this.B;
        object5.c((d.v.b0.b.c)object6);
        int n12 = this.e0;
        if (n12 != 0) {
            object5 = new StringBuilder();
            ((StringBuilder)object5).append("display render onDraw mTexMatrix before: ");
            object6 = d.v.b0.j.d.g(this.H);
            ((StringBuilder)object5).append((String)object6);
            object5 = ((StringBuilder)object5).toString();
            d.v.b0.j.b.a((String)object5);
        }
        object5 = (SurfaceTexture)displayRender.A.a();
        object5.updateTexImage();
        object6 = displayRender.H;
        object5.getTransformMatrix((float[])object6);
        Matrix.setIdentityM((float[])displayRender.G, (int)0);
        object6 = displayRender.G;
        Object object7 = 0;
        float f13 = 0.0f;
        Object object8 = null;
        Object object9 = displayRender.J;
        int n13 = false;
        Object object10 = null;
        float[] fArray = displayRender.I;
        int n14 = 0;
        Object object11 = null;
        Matrix.multiplyMM((float[])object6, (int)0, (float[])object9, (int)0, (float[])fArray, (int)0);
        object5 = displayRender.E;
        object6 = DisplayRender$EngineCombinationMode.ALL_ENGINE_APPLY;
        int n15 = 1;
        float f14 = Float.MIN_VALUE;
        if (object5 == object6) {
            n12 = n15;
        } else {
            n12 = 0;
            object5 = null;
        }
        Object object12 = -1;
        int n16 = displayRender.A.b();
        object7 = displayRender.u;
        Object object13 = displayRender.v;
        GLES20.glViewport((int)0, (int)0, (int)object7, (int)object13);
        object8 = displayRender.X;
        synchronized (object8) {
            object9 = displayRender.y;
            if (object9 != null && (object9 = (Object)displayRender.r) != null) {
                object9 = (Object)displayRender.E;
                object10 = DisplayRender$EngineCombinationMode.SELECT_ENGINE_APPLY;
                if (object9 == object10 && (object9 = (Object)((Object)displayRender.F)) == (object10 = RenderEngineType.FACE_UNITY_ENGINE)) {
                    object13 = n15;
                    f12 = f14;
                } else {
                    object13 = 0;
                    object9 = null;
                    f12 = 0.0f;
                }
                if (n12 != 0 || object13 != 0) {
                    object4 = displayRender.y;
                    byte[] byArray = displayRender.r;
                    object3 = TextureFormat.NV21;
                    object2 = 1;
                    f11 = Float.MIN_VALUE;
                    object12 = displayRender.s;
                    object13 = displayRender.t;
                    n11 = n16;
                    n10 = object13;
                    object12 = object4.e(byArray, (TextureFormat)((Object)object3), n16, (boolean)object2, (int)object12, (int)object13);
                }
            }
        }
        object8 = displayRender.z;
        if (object8 != null && (object7 = (Object)displayRender.V) != 0) {
            object8 = displayRender.E;
            object9 = (Object)DisplayRender$EngineCombinationMode.SELECT_ENGINE_APPLY;
            if (object8 == object9 && (object8 = displayRender.F) == (object9 = (Object)((Object)RenderEngineType.ZHI_YUN_ENGINE))) {
                object7 = n15;
                f13 = f14;
            } else {
                object7 = 0;
                object8 = null;
                f13 = 0.0f;
            }
            if (n12 != 0 || object7 != 0) {
                n12 = displayRender.u;
                object7 = displayRender.v;
                object13 = displayRender.W;
                if (object13 != 0) {
                    object9 = "======================> destroyFrameBuffer <=====================";
                    d.v.b0.j.b.b((String)object9);
                }
                if (object12 < 0 && (object9 = (Object)displayRender.C) != null) {
                    object12 = displayRender.W;
                    object12 = object9.n(n16, n12, (int)object7, (boolean)object12);
                }
                if (object12 > 0 && (object9 = (Object)displayRender.D) != null && (n12 = object9.n((int)object12, n12, (int)object7, (n13 = displayRender.W) != 0)) > 0) {
                    object12 = n12;
                }
                displayRender.W = false;
            }
        }
        n12 = object12;
        object6 = displayRender.j0;
        float f15 = -1.0f;
        Object object14 = 1065353216;
        float f16 = 1.0f;
        if (object6 != null && (object12 = (Object)displayRender.g0) != 0) {
            object8 = displayRender.R;
            GLES20.glGetIntegerv((int)2978, (int[])object8, (int)0);
            object12 = displayRender.e0;
            int n17 = 3;
            n11 = 2;
            if (object12 != 0) {
                object6 = new StringBuilder();
                ((StringBuilder)object6).append("viewport width:");
                object7 = displayRender.R[n11];
                ((StringBuilder)object6).append((int)object7);
                ((StringBuilder)object6).append("  viewport height:");
                object8 = displayRender.R;
                object7 = object8[n17];
                ((StringBuilder)object6).append((int)object7);
                object6 = ((StringBuilder)object6).toString();
                d.v.b0.j.b.c((String)object6);
            }
            object6 = displayRender.R;
            object7 = object6[n11];
            object12 = object6[n17];
            object13 = displayRender.t;
            if (object13 > 0 && (object13 = displayRender.s) > 0 && object7 > 0 && object12 > 0) {
                float f17;
                object12 = displayRender.Z;
                object7 = 270;
                f13 = 3.78E-43f;
                object13 = 90;
                f12 = 1.26E-43f;
                if (object12 != object13 && (object12 = displayRender.Z) != object7) {
                    object12 = displayRender.s;
                    n13 = displayRender.t;
                } else {
                    object12 = displayRender.t;
                    n13 = displayRender.s;
                }
                object2 = object12;
                n14 = n13;
                displayRender.h0.a((int)object12, n13);
                GLES20.glViewport((int)0, (int)0, (int)object12, (int)n13);
                Matrix.scaleM((float[])displayRender.K, (int)0, (float)f16, (float)f15, (float)f16);
                object6 = displayRender.K;
                n10 = 0;
                object10 = displayRender.I;
                f10 = 0.0f;
                Matrix.multiplyMM((float[])object6, (int)0, (float[])object6, (int)0, (float[])object10, (int)0);
                object12 = displayRender.p;
                if (object12 != n15) {
                    object12 = displayRender.Z;
                    if (object12 == object13 || (object12 = displayRender.Z) == object7) {
                        object6 = displayRender.K;
                        n10 = 0;
                        f17 = -90.0f;
                        f10 = 1.0f;
                        Matrix.rotateM((float[])object6, (int)0, (float)f17, (float)0.0f, (float)0.0f, (float)f10);
                    }
                } else {
                    object12 = displayRender.Z;
                    if (object12 == object13 || (object12 = displayRender.Z) == object7) {
                        object6 = displayRender.K;
                        n10 = 0;
                        f17 = 90.0f;
                        f10 = 1.0f;
                        Matrix.rotateM((float[])object6, (int)0, (float)f17, (float)0.0f, (float)0.0f, (float)f10);
                    }
                }
                object10 = displayRender.L;
                fArray = displayRender.K;
                object9 = displayRender.P;
                object8 = displayRender.N;
                object6 = this;
                object7 = n12;
                object13 = n16;
                object11 = object9;
                n10 = n16;
                object = object8;
                this.J(n12, n16, (float[])object10, fArray, (d.v.b0.c.d.c)object9, (d.v.b0.c.d.e)object8);
                Matrix.setIdentityM((float[])displayRender.K, (int)0);
                object6 = displayRender.i0;
                synchronized (object6) {
                    object8 = displayRender.j0;
                    if (object8 != null) {
                        object9 = displayRender.h0;
                        object13 = ((d.v.b0.j.a)object9).d();
                        object8.a((int)object13, (int)object2, n14);
                    }
                }
                displayRender.h0.e();
                object6 = displayRender.h0;
                ((d.v.b0.j.a)object6).c();
            } else {
                n10 = n16;
            }
            object6 = displayRender.R;
            object7 = object6[0];
            object13 = object6[n15];
            n13 = object6[n11];
            object12 = object6[n17];
            GLES20.glViewport((int)object7, (int)object13, (int)n13, (int)object12);
        } else {
            n10 = n16;
        }
        object6 = displayRender.w;
        object4 = object6.b();
        object3 = object4.iterator();
        while (true) {
            if ((object12 = (Object)object3.hasNext()) == 0) {
                object12 = displayRender.e0;
                if (object12 == 0) return;
                object6 = new StringBuilder();
                ((StringBuilder)object6).append("display render onDraw mTexMatrix: ");
                object8 = d.v.b0.j.d.g(displayRender.H);
                ((StringBuilder)object6).append((String)object8);
                d.v.b0.j.b.c(((StringBuilder)object6).toString());
                object6 = new StringBuilder();
                ((StringBuilder)object6).append("display render onDraw previewWidth: ");
                object7 = displayRender.s;
                ((StringBuilder)object6).append((int)object7);
                ((StringBuilder)object6).append("   previewHeight:");
                object7 = displayRender.t;
                ((StringBuilder)object6).append((int)object7);
                d.v.b0.j.b.c(((StringBuilder)object6).toString());
                object6 = new StringBuilder();
                ((StringBuilder)object6).append("display render onDraw viewWidth: ");
                object7 = displayRender.u;
                ((StringBuilder)object6).append((int)object7);
                ((StringBuilder)object6).append("    viewHeight: ");
                object7 = displayRender.v;
                ((StringBuilder)object6).append((int)object7);
                d.v.b0.j.b.c(((StringBuilder)object6).toString());
                object6 = new StringBuilder();
                object8 = "display render onDraw : m2DTexId:";
                ((StringBuilder)object6).append((String)object8);
                ((StringBuilder)object6).append(n12);
                ((StringBuilder)object6).append("   oesTextureId:");
                n12 = n10;
                ((StringBuilder)object6).append(n10);
                d.v.b0.j.b.c(((StringBuilder)object6).toString());
                object5 = new StringBuilder();
                object6 = "display render onDraw outputSurfaces size: ";
                ((StringBuilder)object5).append((String)object6);
                object12 = object4.size();
                ((StringBuilder)object5).append((int)object12);
                object5 = ((StringBuilder)object5).toString();
                d.v.b0.j.b.c((String)object5);
                displayRender.e0 = false;
                return;
            }
            Object object15 = object6 = object3.next();
            object15 = (d.v.b0.b.c)object6;
            if (object15 == null || (object12 = (Object)((d.v.b0.b.c)object15).h()) != 0) continue;
            object6 = displayRender.B;
            if (object15 != object6) {
                object6 = ((d.v.b0.b.c)object15).b();
                object6 = displayRender.O((String)object6);
                object8 = ((DisplayRender$t)object6).b;
                if (object8 == null) {
                    object7 = n15;
                    f13 = f14;
                } else {
                    object8 = ((DisplayRender$t)object6).b;
                    object7 = object8.b();
                }
                object6 = ((DisplayRender$t)object6).a;
                if (object6 == null) {
                    object7 = n15;
                    f13 = f14;
                }
                if (object7 == 0) continue;
            }
            if ((object12 = ((d.v.b0.b.c)object15).e()) > 0 && (object12 = ((d.v.b0.b.c)object15).d()) > 0) {
                object12 = ((d.v.b0.b.c)object15).e();
                object7 = ((d.v.b0.b.c)object15).d();
                GLES20.glViewport((int)0, (int)0, (int)object12, (int)object7);
            } else {
                object12 = displayRender.u;
                object7 = displayRender.v;
                GLES20.glViewport((int)0, (int)0, (int)object12, (int)object7);
            }
            object6 = displayRender.w;
            object6.c((d.v.b0.b.c)object15);
            object12 = displayRender.U;
            if (object12 != 0 && object15 == (object6 = displayRender.B)) {
                object6 = displayRender.l0;
                object7 = displayRender.u;
                object13 = displayRender.v;
                ((d.v.b0.j.a)object6).a((int)object7, (int)object13);
                object6 = displayRender.K;
                object7 = displayRender.p;
                if (object7 == n15) {
                    object7 = -1082130432;
                    f13 = -1.0f;
                } else {
                    object7 = object14;
                    f13 = f16;
                }
                f12 = -1.0f;
                Matrix.scaleM((float[])object6, (int)0, (float)f13, (float)f12, (float)f16);
                object6 = displayRender.K;
                object8 = displayRender.I;
                Matrix.multiplyMM((float[])object6, (int)0, (float[])object6, (int)0, (float[])object8, (int)0);
                object10 = displayRender.L;
                fArray = displayRender.K;
                object11 = displayRender.O;
                object = displayRender.M;
                object6 = this;
                object7 = n12;
                object13 = n10;
                this.J(n12, n10, (float[])object10, fArray, (d.v.b0.c.d.c)object11, (d.v.b0.c.d.e)object);
                Matrix.setIdentityM((float[])displayRender.K, (int)0);
                object12 = displayRender.u;
                object7 = displayRender.v;
                displayRender.k0((int)object12, (int)object7);
                displayRender.l0.e();
                object6 = displayRender.l0;
                ((d.v.b0.j.a)object6).c();
                displayRender.U = false;
            }
            if (object15 == (object6 = displayRender.B)) {
                object6 = displayRender.G;
                object2 = -1082130432;
                f11 = -1.0f;
                Matrix.scaleM((float[])object6, (int)0, (float)f16, (float)f11, (float)f16);
                object10 = displayRender.H;
                fArray = displayRender.G;
                object11 = displayRender.O;
                object = displayRender.M;
                object6 = this;
                object7 = n12;
                object13 = n10;
                this.J(n12, n10, (float[])object10, fArray, (d.v.b0.c.d.c)object11, (d.v.b0.c.d.e)object);
            } else {
                object2 = -1082130432;
                f11 = -1.0f;
                object6 = ((d.v.b0.b.c)object15).b();
                object6 = displayRender.O((String)object6);
                object8 = ((DisplayRender$t)object6).a;
                if (object8 != null) {
                    object8 = displayRender.K;
                    object13 = displayRender.p;
                    if (object13 == n15) {
                        object13 = object2;
                        f12 = f11;
                    } else {
                        object13 = object14;
                        f12 = f16;
                    }
                    Matrix.scaleM((float[])object8, (int)0, (float)f12, (float)f16, (float)f16);
                    object8 = displayRender.K;
                    f10 = 0.0f;
                    object6 = ((DisplayRender$t)object6).a;
                    Matrix.multiplyMM((float[])object8, (int)0, (float[])object8, (int)0, (float[])object6, (int)0);
                    object6 = displayRender.K;
                    object8 = displayRender.I;
                    Matrix.multiplyMM((float[])object6, (int)0, (float[])object6, (int)0, (float[])object8, (int)0);
                    object10 = displayRender.L;
                    fArray = displayRender.K;
                    object11 = displayRender.O;
                    object = displayRender.M;
                    object6 = this;
                    object7 = n12;
                    object13 = n10;
                    this.J(n12, n10, (float[])object10, fArray, (d.v.b0.c.d.c)object11, (d.v.b0.c.d.e)object);
                    object6 = displayRender.K;
                    Matrix.setIdentityM((float[])object6, (int)0);
                }
            }
            object6 = displayRender.w;
            object6.f((d.v.b0.b.c)object15);
        }
    }

    public static /* synthetic */ void a(DisplayRender displayRender, Message message) {
        displayRender.T(message);
    }

    public static /* synthetic */ DisplayRender$r b(DisplayRender displayRender) {
        return displayRender.a0;
    }

    private void b0(Message object) {
        Object object2;
        if (object != null && (object2 = ((Message)object).obj) != null) {
            object2 = (d.v.b0.b.c)object2;
            ((Message)object).obj = null;
            boolean bl2 = true;
            ((d.v.b0.b.c)object2).j(bl2);
            object = ((d.v.b0.b.c)object2).b();
            object = this.O((String)object);
            object2 = ((DisplayRender$t)object).b;
            if (object2 != null) {
                object = ((DisplayRender$t)object).b;
                object.d();
            }
        }
    }

    public static /* synthetic */ List c(DisplayRender displayRender) {
        return displayRender.x;
    }

    public static /* synthetic */ int d(DisplayRender displayRender) {
        return displayRender.s;
    }

    public static /* synthetic */ int e(DisplayRender displayRender, int n10) {
        displayRender.s = n10;
        return n10;
    }

    public static /* synthetic */ int f(DisplayRender displayRender) {
        return displayRender.t;
    }

    private void f0(Message object) {
        Object object2;
        if (object != null && (object2 = ((Message)object).obj) != null) {
            object2 = (d.v.b0.b.c)object2;
            ((Message)object).obj = null;
            ((d.v.b0.b.c)object2).j(false);
            object = ((d.v.b0.b.c)object2).b();
            object = this.O((String)object);
            object2 = ((DisplayRender$t)object).b;
            if (object2 != null) {
                object = ((DisplayRender$t)object).b;
                object.c();
            }
        }
    }

    public static /* synthetic */ int g(DisplayRender displayRender, int n10) {
        displayRender.t = n10;
        return n10;
    }

    public static /* synthetic */ boolean h(DisplayRender displayRender, boolean bl2) {
        displayRender.W = bl2;
        return bl2;
    }

    public static /* synthetic */ Object i(DisplayRender displayRender) {
        return displayRender.X;
    }

    private void i0(Message object) {
        if (object != null && (object = ((Message)object).obj) != null) {
            object = (Float)object;
            float f10 = ((Float)object).floatValue();
            Matrix.setIdentityM((float[])this.I, (int)0);
            float[] fArray = this.I;
            float f11 = 1.0f;
            Matrix.scaleM((float[])fArray, (int)0, (float)f10, (float)f10, (float)f11);
        }
    }

    public static /* synthetic */ byte[] j(DisplayRender displayRender) {
        return displayRender.q;
    }

    public static /* synthetic */ byte[] k(DisplayRender displayRender, byte[] byArray) {
        displayRender.q = byArray;
        return byArray;
    }

    private void k0(int n10, int n11) {
        long l10 = System.currentTimeMillis();
        int n12 = n10 * n11 * 4;
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(n12);
        Object object = ByteOrder.LITTLE_ENDIAN;
        byteBuffer.order((ByteOrder)object);
        object = new StringBuilder();
        ((StringBuilder)object).append("screen custom (allocate memory): ");
        long l11 = System.currentTimeMillis() - l10;
        ((StringBuilder)object).append(l11);
        String string2 = " ms";
        ((StringBuilder)object).append(string2);
        d.v.b0.j.b.c(((StringBuilder)object).toString());
        int n13 = 0;
        IRenderEngine iRenderEngine = null;
        int n14 = 6408;
        int n15 = 5121;
        GLES20.glReadPixels((int)0, (int)0, (int)n10, (int)n11, (int)n14, (int)n15, (Buffer)byteBuffer);
        byteBuffer.rewind();
        object = this.m0;
        if (object != null) {
            iRenderEngine = this.y;
            n13 = iRenderEngine.getDeviceOrientation();
            object.a(byteBuffer, n10, n11, n13);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("screen custom: ");
        long l12 = System.currentTimeMillis() - l10;
        stringBuilder.append(l12);
        stringBuilder.append(string2);
        d.v.b0.j.b.c(stringBuilder.toString());
    }

    public static /* synthetic */ float[] l(DisplayRender displayRender, float[] fArray) {
        displayRender.J = fArray;
        return fArray;
    }

    public static /* synthetic */ int m(DisplayRender displayRender, int n10) {
        displayRender.p = n10;
        return n10;
    }

    public static /* synthetic */ byte[] n(DisplayRender displayRender) {
        return displayRender.r;
    }

    public static /* synthetic */ byte[] o(DisplayRender displayRender, byte[] byArray) {
        displayRender.r = byArray;
        return byArray;
    }

    public static /* synthetic */ void p(DisplayRender displayRender, Message message) {
        displayRender.X(message);
    }

    public static /* synthetic */ Handler q(DisplayRender displayRender) {
        return displayRender.k;
    }

    public static /* synthetic */ IRenderEngine r(DisplayRender displayRender) {
        return displayRender.y;
    }

    public static /* synthetic */ boolean s(DisplayRender displayRender, boolean bl2) {
        displayRender.U = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean t(DisplayRender displayRender, boolean bl2) {
        displayRender.T = bl2;
        return bl2;
    }

    public static /* synthetic */ Context u(DisplayRender displayRender) {
        return displayRender.S;
    }

    public static /* synthetic */ d v(DisplayRender displayRender) {
        return displayRender.t0;
    }

    public static /* synthetic */ d.v.b0.d.d w(DisplayRender displayRender) {
        return displayRender.D;
    }

    public static /* synthetic */ boolean x(DisplayRender displayRender, boolean bl2) {
        displayRender.V = bl2;
        return bl2;
    }

    public static /* synthetic */ c y(DisplayRender displayRender) {
        return displayRender.v0;
    }

    public static /* synthetic */ c z(DisplayRender displayRender, c c10) {
        displayRender.v0 = c10;
        return c10;
    }

    public void B0(d.v.b0.b.c c10) {
        Handler handler = this.k;
        if (handler != null) {
            int n10;
            handler = Message.obtain();
            handler.what = n10 = 33;
            handler.obj = c10;
            handler.arg1 = 0;
            c10 = this.k;
            c10.sendMessage((Message)handler);
        }
    }

    public void C0(d.v.b0.b.c c10) {
        Handler handler = this.k;
        if (handler != null) {
            int n10;
            int n11;
            handler = Message.obtain();
            handler.what = n11 = 33;
            handler.obj = c10;
            handler.arg1 = n10 = 1;
            c10 = this.k;
            c10.sendMessage((Message)handler);
        }
    }

    public void F0(d.v.b0.b.c c10) {
        Handler handler = this.k;
        if (handler != null) {
            int n10;
            handler = Message.obtain();
            handler.what = n10 = 34;
            handler.obj = c10;
            c10 = this.k;
            c10.sendMessage((Message)handler);
        }
    }

    public void G0(Bitmap bitmap, DisplayRender$w object) {
        boolean bl2;
        if (bitmap != null && !(bl2 = bitmap.isRecycled()) && (bitmap = this.k) != null && (object = this.y) != null) {
            object = new DisplayRender$n(this);
            bitmap.post((Runnable)object);
        }
    }

    public void K(byte[] byArray, d.v.b0.c.e.b b10) {
        Object object;
        IRenderEngine iRenderEngine = this.z;
        if (iRenderEngine != null && byArray != null && (iRenderEngine = this.k) != null && (object = this.w) != null) {
            object = new DisplayRender$h(this, byArray, b10);
            iRenderEngine.post((Runnable)object);
        }
    }

    public b L() {
        return this.k0;
    }

    public long N() {
        return this.a0.d;
    }

    public float P() {
        return this.a0.a();
    }

    public boolean Q() {
        return this.T;
    }

    public boolean R() {
        return this.V;
    }

    public void S(SurfaceTexture surfaceTexture, int n10, int n11) {
        Handler handler = this.k;
        if (handler != null) {
            this.u = n10;
            this.v = n11;
            Message message = Message.obtain();
            n11 = 0;
            message.what = 0;
            message.obj = surfaceTexture;
            surfaceTexture = this.k;
            surfaceTexture.sendMessage(message);
        }
    }

    public void U() {
        Handler handler = this.k;
        if (handler != null) {
            int n10 = 2;
            handler.sendEmptyMessage(n10);
        }
    }

    public void W(int n10, int n11) {
        Handler handler = this.k;
        if (handler != null) {
            int n12;
            handler = Message.obtain();
            handler.what = n12 = 1;
            handler.arg1 = n10;
            handler.arg2 = n11;
            Handler handler2 = this.k;
            handler2.sendMessage((Message)handler);
        }
    }

    public void Z(boolean bl2) {
        Object object;
        Handler handler = this.k;
        if (handler != null && (object = this.y) != null) {
            object = new DisplayRender$o(this, bl2);
            handler.post((Runnable)object);
        }
    }

    public void a0(boolean bl2) {
        Object object;
        Handler handler = this.k;
        if (handler != null && (object = this.z) != null) {
            object = new DisplayRender$g(this, bl2);
            handler.post((Runnable)object);
        }
    }

    public void c0(d.v.b0.b.c c10) {
        Handler handler = this.k;
        if (handler != null) {
            int n10;
            handler = Message.obtain();
            handler.what = n10 = 35;
            handler.obj = c10;
            c10 = this.k;
            c10.sendMessage((Message)handler);
        }
    }

    public void d0(IRenderEngine[] iRenderEngineArray) {
        int n10;
        Handler handler = this.k;
        if (handler != null && iRenderEngineArray != null && (n10 = iRenderEngineArray.length) > 0) {
            DisplayRender$k displayRender$k = new DisplayRender$k(this, iRenderEngineArray);
            handler.post((Runnable)displayRender$k);
        }
    }

    public void e0() {
        Handler handler = this.k;
        if (handler != null) {
            int n10 = 5;
            handler.sendEmptyMessage(n10);
        }
    }

    public void g0(d.v.b0.b.c c10) {
        Handler handler = this.k;
        if (handler != null) {
            int n10;
            handler = Message.obtain();
            handler.what = n10 = 36;
            handler.obj = c10;
            c10 = this.k;
            c10.sendMessage((Message)handler);
        }
    }

    public void h0(float f10) {
        Handler handler = this.k;
        if (handler != null) {
            int n10;
            handler = Message.obtain();
            handler.what = n10 = 80;
            Float f11 = Float.valueOf(f10);
            handler.obj = f11;
            f11 = this.k;
            f11.sendMessage((Message)handler);
        }
    }

    public void j0() {
        Handler handler = this.k;
        if (handler != null) {
            DisplayRender$m displayRender$m = new DisplayRender$m(this);
            handler.post((Runnable)displayRender$m);
        }
    }

    public void l0(float f10) {
        Object object;
        Handler handler = this.k;
        if (handler != null && (object = this.y) != null) {
            object = new DisplayRender$d(this, f10);
            handler.post((Runnable)object);
        }
    }

    public void m0(float f10) {
        Object object;
        Handler handler = this.k;
        if (handler != null && (object = this.y) != null) {
            object = new DisplayRender$b(this, f10);
            handler.post((Runnable)object);
        }
    }

    public void n0(float f10) {
        Object object;
        Handler handler = this.k;
        if (handler != null && (object = this.y) != null) {
            object = new DisplayRender$q(this, f10);
            handler.post((Runnable)object);
        }
    }

    public void o0(DisplayRender$s displayRender$s) {
        this.b0 = displayRender$s;
    }

    public void p0(DisplayRender$EngineCombinationMode displayRender$EngineCombinationMode) {
        this.E = displayRender$EngineCombinationMode;
    }

    public void q0(int n10) {
        this.Z = n10;
    }

    public void r0(c$a c$a) {
        Object object;
        if (c$a != null && (object = this.z) != null) {
            boolean bl2;
            this.u0 = c$a;
            object = c$a.e;
            if (object != null && !(bl2 = object.isRecycled())) {
                object = this.t0;
                ((d)object).a = c$a;
                c$a = this.k;
                c$a.post((Runnable)object);
            } else {
                object = this.s0;
                ((d)object).a = c$a;
                c$a = this.m;
                c$a.post((Runnable)object);
            }
        }
    }

    public void s0(float f10) {
        Object object;
        Handler handler = this.k;
        if (handler != null && (object = this.y) != null) {
            object = new DisplayRender$a(this, f10);
            handler.post((Runnable)object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void t0(DisplayRender$x displayRender$x) {
        Object object = this.i0;
        synchronized (object) {
            this.j0 = displayRender$x;
            return;
        }
    }

    public void u0(boolean bl2) {
        this.a0.c = bl2;
    }

    public void v0(d.v.b0.b.c object, DisplayRender$u displayRender$u) {
        if (object != null) {
            object = ((d.v.b0.b.c)object).b();
            object = this.O((String)object);
            ((DisplayRender$t)object).b = displayRender$u;
        }
    }

    public void w0(float f10) {
        Object object;
        Handler handler = this.k;
        if (handler != null && (object = this.y) != null) {
            object = new DisplayRender$c(this, f10);
            handler.post((Runnable)object);
        }
    }

    public void x0(DisplayRender$v displayRender$v) {
        this.m0 = displayRender$v;
    }

    public void y0(RenderEngineType renderEngineType) {
        this.F = renderEngineType;
    }

    public void z0(float f10) {
        Object object;
        Handler handler = this.k;
        if (handler != null && (object = this.y) != null) {
            object = new DisplayRender$p(this, f10);
            handler.post((Runnable)object);
        }
    }
}

