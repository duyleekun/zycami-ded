/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.content.Context
 *  android.graphics.SurfaceTexture
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  javax.microedition.khronos.egl.EGLContext
 */
package com.tencent.liteav;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.opengl.m;
import com.tencent.liteav.c$1;
import com.tencent.liteav.c$2;
import com.tencent.liteav.c$3;
import com.tencent.liteav.capturer.a;
import com.tencent.liteav.capturer.a$a;
import com.tencent.liteav.g;
import com.tencent.liteav.n;
import com.tencent.liteav.o;
import com.tencent.liteav.renderer.TXCGLSurfaceView;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLContext;

public class c
implements b,
com.tencent.liteav.basic.opengl.n,
com.tencent.liteav.capturer.b,
n {
    public WeakReference a;
    private Context b;
    private final a c;
    private o d;
    private boolean e;
    private g f;
    private int g = 0;
    private m h = null;
    private boolean i = false;
    private long j;
    private long k;
    private long l;
    private int m;
    private Object n;
    private HandlerThread o;
    private Handler p;
    private String q;
    private boolean r;

    public c(Context objectArray, g object, m m10, boolean bl2) {
        String string2;
        Object object2;
        long l10;
        this.j = l10 = 0L;
        this.l = l10;
        this.m = 0;
        this.n = object2 = new Object();
        this.o = null;
        this.p = null;
        this.q = string2 = "";
        int n10 = 1;
        this.r = n10;
        this.c = object2 = new a();
        object = ((g)object).clone();
        object = (g)object;
        try {
            this.f = object;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            this.f = object2 = new g();
            cloneNotSupportedException.printStackTrace();
        }
        this.b = objectArray;
        this.h = m10;
        m10.setSurfaceTextureListener(this);
        objectArray = this.f;
        objectArray.W = bl2;
        object = this.c;
        boolean bl3 = objectArray.U;
        ((a)object).b(bl3);
        objectArray = new Object[n10];
        objectArray[0] = object = Boolean.valueOf(this.f.W);
        TXCLog.i("TXCCameraCaptureSource", "camera capture with nv21: %b", objectArray);
    }

    public static /* synthetic */ g a(c c10) {
        return c10.f;
    }

    private void a(int n10, String string2) {
        com.tencent.liteav.basic.util.g.a(this.a, n10, string2);
    }

    private void a(int n10, byte[] object, float[] object2, int n11) {
        long l10;
        int n12;
        int n13;
        int n14;
        Object object3;
        Object object4;
        boolean bl2 = this.e;
        if (!bl2) {
            return;
        }
        bl2 = this.i;
        String string2 = "CameraCapture";
        int n15 = 2;
        int n16 = 1;
        if (!bl2) {
            object4 = new Object[n16];
            object4[0] = object3 = Integer.valueOf(this.hashCode());
            object4 = String.format("VideoCapture[%d]: capture first frame", object4);
            object3 = "";
            Monitor.a(n15, (String)object4, (String)object3, 0);
            object4 = this.a;
            n14 = 1007;
            String string3 = "First frame capture completed";
            com.tencent.liteav.basic.util.g.a((WeakReference)object4, n14, string3);
            this.i = n16;
            this.r = n16;
            object4 = "trtc_render: render first frame";
            TXCLog.i(string2, (String)object4);
        }
        object4 = new com.tencent.liteav.basic.structs.b();
        object4.e = n14 = this.c.f();
        object4.f = n14 = this.c.g();
        object3 = this.f;
        object4.g = n13 = ((g)object3).a;
        object4.h = n14 = ((g)object3).b;
        object4.j = n14 = this.c.d();
        object3 = this.c;
        n14 = (int)(((a)object3).e() ? 1 : 0);
        if (n14 != 0) {
            object3 = this.f;
            n14 = (int)(((g)object3).S ? 1 : 0);
            if (n14 == 0) {
                n14 = n16;
            } else {
                n14 = 0;
                object3 = null;
            }
        } else {
            object3 = this.f;
            n14 = (int)(((g)object3).S ? 1 : 0);
        }
        object4.i = n14;
        object4.a = n10;
        object4.c = object2;
        Object object5 = this.f;
        object4.d = n12 = object5.W;
        object4.m = object;
        object4.b = n11;
        int n17 = object4.j;
        if (n17 != 0 && n17 != (n12 = 180)) {
            object4.g = n17 = object5.a;
            object4.h = n17 = object5.b;
        } else {
            object4.g = n17 = object5.b;
            object4.h = n17 = object5.a;
        }
        n17 = object4.e;
        n12 = object4.f;
        n11 = object5.b;
        n10 = object5.a;
        object5 = com.tencent.liteav.basic.util.g.a(n17, n12, n11, n10);
        object4.l = object5;
        object5 = this.d;
        if (object5 != null) {
            object5.b((com.tencent.liteav.basic.structs.b)object4);
        }
        if ((n10 = (int)(this.r ? 1 : 0)) != 0) {
            this.r = false;
            n10 = 3;
            object5 = new Object[n10];
            object = object4.g;
            object5[0] = object;
            object = object4.h;
            object5[n16] = object;
            n17 = object4.j;
            object = n17;
            object5[n15] = object;
            object = "vsize onCaptureFrame w*h:%d*%d angle:%d";
            object5 = String.format((String)object, object5);
            TXCLog.i(string2, (String)object5);
        }
        this.j = l10 = this.j + 1L;
        l10 = System.currentTimeMillis();
        long l11 = this.k;
        l10 -= l11;
        l11 = 1000L;
        double d10 = 4.94E-321;
        n12 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
        if (n12 >= 0) {
            l11 = this.j;
            long l12 = this.l;
            d10 = l11 - l12;
            l12 = 4652007308841189376L;
            d10 *= 1000.0;
            double d11 = l10;
            object4 = this.q;
            int n18 = 1001;
            n15 = this.m;
            object2 = d10 /= d11;
            TXCStatus.a((String)object4, n18, n15, object2);
            this.l = l11 = this.j;
            this.k = l11 = this.k + l10;
        }
    }

    public static /* synthetic */ boolean b(c c10) {
        return c10.j();
    }

    public static /* synthetic */ a c(c c10) {
        return c10.c;
    }

    private void c(SurfaceTexture object) {
        Object object2;
        int n10;
        if (object != null && (n10 = this.e) == 0 && (object2 = this.c) != null) {
            object2.a(this);
            this.c.a((SurfaceTexture)object);
            object = this.c;
            n10 = this.f.h;
            ((a)object).a(n10);
            object = this.c;
            n10 = this.f.l;
            ((a)object).c(n10);
            object = this.c;
            n10 = (int)(this.f.K ? 1 : 0);
            ((a)object).c(n10 != 0);
            object = this.c;
            object2 = this.i();
            ((a)object).a((a$a)((Object)object2));
            object = this.c;
            object2 = this.f;
            boolean bl2 = object2.W;
            int n11 = object2.a;
            n10 = object2.b;
            ((a)object).a(bl2, n11, n10);
            object = this.c;
            object2 = this.f;
            n10 = (int)(object2.m ? 1 : 0);
            int n12 = ((a)object).d(n10 != 0);
            n10 = 3;
            String string2 = "w*h:%d*%d orientation:%d";
            Object object3 = "front";
            String string3 = "back";
            int n13 = 1;
            int n14 = 2;
            if (n12 == 0) {
                Object object4;
                long l10;
                this.e = n13;
                this.k = l10 = System.currentTimeMillis();
                object = new Object[n14];
                object[0] = object4 = Integer.valueOf(this.hashCode());
                object4 = this.f;
                boolean bl3 = ((g)object4).m;
                if (!bl3) {
                    object3 = string3;
                }
                object[n13] = object3;
                object = String.format("VideoCapture[%d]: start %s camera successfully", (Object[])object);
                object2 = new Object[n10];
                object2[0] = object3 = Integer.valueOf(this.f.a);
                object2[n13] = object3 = Integer.valueOf(this.f.b);
                n11 = this.f.l;
                object2[n14] = object3 = Integer.valueOf(n11);
                object2 = String.format(string2, object2);
                Monitor.a(n14, (String)object, (String)object2, 0);
                n12 = 1003;
                object2 = "Enabled camera successfully";
                this.a(n12, (String)object2);
                this.i = false;
            } else {
                Object object5;
                this.e = false;
                n12 = -1301;
                this.a(n12, "Failed to open camera, please confirm whether the camera permission is turned on");
                object = new Object[n14];
                object[0] = object5 = Integer.valueOf(this.hashCode());
                object5 = this.f;
                boolean bl4 = ((g)object5).m;
                if (!bl4) {
                    object3 = string3;
                }
                object[n13] = object3;
                object = String.format("VideoCapture[%d]: start %s camera failed", (Object[])object);
                object2 = new Object[n10];
                object2[0] = object3 = Integer.valueOf(this.f.a);
                object2[n13] = object3 = Integer.valueOf(this.f.b);
                n11 = this.f.l;
                object2[n14] = object3 = Integer.valueOf(n11);
                object2 = String.format(string2, object2);
                Monitor.a(n14, (String)object, (String)object2, 0);
            }
        }
    }

    public static /* synthetic */ m d(c c10) {
        return c10.h;
    }

    public static /* synthetic */ Handler e(c c10) {
        return c10.p;
    }

    private a$a i() {
        Object object = this.f;
        int n10 = ((g)object).T;
        if (n10 != 0) {
            return a$a.i;
        }
        int[] nArray = c$3.a;
        object = ((g)object).k;
        int n11 = ((Enum)object).ordinal();
        n10 = 1;
        if ((n11 = nArray[n11]) != n10) {
            n10 = 2;
            if (n11 != n10) {
                n10 = 3;
                if (n11 != n10) {
                    n10 = 4;
                    if (n11 != n10) {
                        n10 = 5;
                        if (n11 != n10) {
                            return a$a.g;
                        }
                        return a$a.d;
                    }
                    return a$a.h;
                }
                return a$a.f;
            }
            return a$a.e;
        }
        return a$a.a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean j() {
        try {
            int n10;
            Object object = this.b;
            if (object == null) return false;
            String string2 = "activity";
            object = object.getSystemService(string2);
            object = (ActivityManager)object;
            object = object.getRunningAppProcesses();
            string2 = "CameraCapture";
            if (object == null) {
                object = "List of RunningAppProcessInfo is null";
                TXCLog.w(string2, (String)object);
                return false;
            }
            for (int i10 = 0; i10 < (n10 = object.size()); ++i10) {
                Object e10 = object.get(i10);
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)e10;
                if (runningAppProcessInfo == null) {
                    String string3 = "ActivityManager.RunningAppProcessInfo is null";
                    TXCLog.w(string2, string3);
                    continue;
                }
                String string4 = runningAppProcessInfo.processName;
                Context context = this.b;
                String string5 = context.getPackageName();
                int n11 = string4.equals(string5);
                if (n11 == 0 || (n10 = runningAppProcessInfo.importance) != (n11 = 100)) continue;
                return true;
            }
            return false;
        }
        catch (Exception exception) {}
        return false;
    }

    public int a(int n10, float[] fArray) {
        this.a(n10, null, fArray, 4);
        return 0;
    }

    public void a() {
        int n10 = 2;
        Object object = new Object[n10];
        int n11 = this.hashCode();
        Integer n12 = n11;
        object[0] = n12;
        n12 = this.h.getSurfaceTexture();
        if (n12 == null) {
            n11 = 0;
            n12 = null;
        } else {
            n12 = this.h.getSurfaceTexture();
            n11 = ((Object)n12).hashCode();
        }
        n12 = n11;
        int n13 = 1;
        object[n13] = n12;
        object = String.format("VideoCapture[%d]: start camera. sufaceTexture:%d", object);
        Monitor.a(n10, (String)object, "", 0);
        m m10 = this.h;
        object = this.f;
        n11 = object.h;
        boolean bl2 = object.W ^ n13;
        m10.a(n11, bl2);
        m10 = this.h.getSurfaceTexture();
        this.c((SurfaceTexture)m10);
    }

    public void a(float f10) {
        this.c.a(f10);
    }

    public void a(float f10, float f11) {
        a a10 = this.c;
        if (a10 != null) {
            g g10 = this.f;
            boolean bl2 = g10.K;
            if (bl2) {
                a10.a(f10, f11);
            }
        }
    }

    public void a(int n10, int n11) {
        Object object;
        Object[] objectArray = this.f;
        objectArray.a = n10;
        objectArray.b = n11;
        n11 = 1;
        this.r = n11;
        objectArray = new Object[3];
        objectArray[0] = object = Integer.valueOf(n10);
        objectArray[n11] = object = Integer.valueOf(this.f.b);
        objectArray[2] = object = Integer.valueOf(this.f.l);
        object = String.format("vsize setVideoEncSize w*h:%d*%d orientation:%d", objectArray);
        TXCLog.i("CameraCapture", (String)object);
    }

    public void a(SurfaceTexture surfaceTexture) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("onSurfaceTextureAvailable->enter with mListener:");
        Object object2 = this.d;
        ((StringBuilder)object).append(object2);
        object = ((StringBuilder)object).toString();
        object2 = "CameraCapture";
        TXCLog.i((String)object2, (String)object);
        this.c(surfaceTexture);
        object = this.d;
        if (object != null) {
            object.a(surfaceTexture);
        }
    }

    public void a(com.tencent.liteav.basic.a.c c10) {
        this.f.k = c10;
        this.r = true;
    }

    public void a(b b10) {
        WeakReference<b> weakReference;
        this.a = weakReference = new WeakReference<b>(b10);
    }

    public void a(com.tencent.liteav.basic.structs.b object) {
        m m10 = this.h;
        if (m10 != null) {
            int n10 = ((com.tencent.liteav.basic.structs.b)object).a;
            boolean bl2 = ((com.tencent.liteav.basic.structs.b)object).i;
            int n11 = this.g;
            int n12 = ((com.tencent.liteav.basic.structs.b)object).e;
            int n13 = ((com.tencent.liteav.basic.structs.b)object).f;
            object = this.c;
            boolean bl3 = ((a)object).e();
            m10.a(n10, bl2, n11, n12, n13, bl3);
        }
    }

    public void a(o o10) {
        this.d = o10;
    }

    public void a(Runnable runnable) {
        this.h.a(runnable);
    }

    public void a(String string2) {
        this.q = string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(boolean bl2) {
        int n10 = 1;
        Object object = new Object[n10];
        Integer n11 = this.hashCode();
        String string2 = null;
        object[0] = n11;
        Object object2 = String.format("VideoCapture[%d]: stop camera", (Object[])object);
        object = "";
        int n12 = 2;
        Monitor.a(n12, (String)object2, (String)object, 0);
        this.c();
        this.h.a();
        object2 = this.n;
        synchronized (object2) {
            object = this.p;
            n12 = 0;
            n11 = null;
            if (object != null) {
                object.removeCallbacksAndMessages(null);
            }
            if ((object = this.o) != null) {
                object = "CameraCapture";
                string2 = "stop camera monitor ";
                TXCLog.w((String)object, string2);
                object = this.o;
                object.quit();
                this.o = null;
                this.p = null;
            }
            return;
        }
    }

    public void a(byte[] byArray) {
        m m10 = this.h;
        if (m10 != null) {
            m10.a(byArray);
        }
    }

    public void a(byte[] byArray, float[] fArray) {
        this.a(-1, byArray, fArray, 3);
    }

    public boolean a(int n10) {
        return this.c.b(n10);
    }

    public void b() {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("startCapture->enter with getSurfaceTexture:");
        SurfaceTexture surfaceTexture = this.h.getSurfaceTexture();
        charSequence.append(surfaceTexture);
        charSequence = charSequence.toString();
        TXCLog.i("CameraCapture", (String)charSequence);
        charSequence = this.h.getSurfaceTexture();
        this.c((SurfaceTexture)charSequence);
    }

    public void b(int n10) {
        this.g = n10;
    }

    public void b(SurfaceTexture object) {
        this.c();
        object = new StringBuilder();
        ((StringBuilder)object).append("onSurfaceTextureDestroy->enter with mListener:");
        Object object2 = this.d;
        ((StringBuilder)object).append(object2);
        object = ((StringBuilder)object).toString();
        object2 = "CameraCapture";
        TXCLog.i((String)object2, (String)object);
        object = this.d;
        if (object != null) {
            object.m();
        }
    }

    /*
     * WARNING - void declaration
     */
    public void b(boolean bl2) {
        Object object;
        int n10 = this.e;
        if (n10 != 0 && (object = this.c) != null) {
            void var1_6;
            Object object2;
            Object object3 = this.f;
            int n11 = 1;
            if (bl2) {
                boolean bl3 = ((g)object3).m;
                if (!bl3) {
                    int n12 = n11;
                } else {
                    boolean bl4 = false;
                    object2 = null;
                }
            } else {
                boolean bl5 = ((g)object3).m;
            }
            ((g)object3).m = var1_6;
            object.c();
            this.h.a(false);
            object2 = this.c;
            n10 = this.f.h;
            object2.a(n10);
            object2 = this.c;
            n10 = this.f.l;
            object2.c(n10);
            object2 = this.c;
            object = this.i();
            object2.a((a$a)((Object)object));
            object2 = this.c;
            object = this.f;
            boolean bl6 = object.W;
            int n13 = object.a;
            n10 = object.b;
            object2.a(bl6, n13, n10);
            this.c.a(this);
            object2 = this.c;
            object = this.h.getSurfaceTexture();
            object2.a((SurfaceTexture)object);
            object2 = this.c;
            object = this.f;
            n10 = (int)(object.m ? 1 : 0);
            int n14 = object2.d(n10 != 0);
            n10 = 3;
            object3 = "w*h:%d*%d orientation:%d";
            Object object4 = "front";
            String string2 = "back";
            int n15 = 2;
            if (n14 == 0) {
                Object object5;
                this.e = n11;
                object2 = new Object[n15];
                object2[0] = object5 = Integer.valueOf(this.hashCode());
                object5 = this.f;
                boolean bl7 = ((g)object5).m;
                if (!bl7) {
                    object4 = string2;
                }
                object2[n11] = object4;
                object2 = String.format("VideoCapture[%d]: start %s camera successfully", object2);
                object = new Object[n10];
                object[0] = object4 = Integer.valueOf(this.f.a);
                n13 = this.f.b;
                object[n11] = object4 = Integer.valueOf(n13);
                n11 = this.f.l;
                Integer n16 = n11;
                object[n15] = n16;
                object = String.format((String)object3, object);
                Monitor.a(n15, (String)object2, (String)object, 0);
                int n17 = 1003;
                object = "Enabled camera successfully";
                this.a(n17, (String)object);
            } else {
                Object object6;
                this.e = false;
                int n18 = -1301;
                this.a(n18, "Failed to open the camera, please confirm whether the camera permission is turned on");
                object2 = new Object[n15];
                object2[0] = object6 = Integer.valueOf(this.hashCode());
                object6 = this.f;
                boolean bl8 = ((g)object6).m;
                if (!bl8) {
                    object4 = string2;
                }
                object2[n11] = object4;
                object2 = String.format("VideoCapture[%d]: start %s camera failed", object2);
                object = new Object[n10];
                object[0] = object4 = Integer.valueOf(this.f.a);
                n13 = this.f.b;
                object[n11] = object4 = Integer.valueOf(n13);
                n11 = this.f.l;
                Integer n19 = n11;
                object[n15] = n19;
                object = String.format((String)object3, object);
                Monitor.a(n15, (String)object2, (String)object, 0);
            }
            this.i = false;
        }
    }

    public void c() {
        TXCLog.i("CameraCapture", "stopCapture->enter with null");
        this.c.a((com.tencent.liteav.capturer.b)null);
        this.c.c();
        this.e = false;
    }

    public void c(int n10) {
        m m10 = this.h;
        if (m10 != null) {
            m10.setRendMode(n10);
        }
    }

    public void c(boolean bl2) {
        c$1 c$1 = new c$1(this, bl2);
        this.a(c$1);
    }

    public void d(int n10) {
        m m10 = this.h;
        if (m10 != null) {
            m10.setRendMirror(n10);
        }
    }

    public boolean d() {
        return this.e;
    }

    public boolean d(boolean bl2) {
        return this.c.a(bl2);
    }

    public int e() {
        return this.c.b();
    }

    public void e(int n10) {
        Object object;
        this.f.l = n10;
        this.c.c(n10);
        n10 = 1;
        this.r = n10;
        Object[] objectArray = new Object[3];
        Integer n11 = this.f.a;
        objectArray[0] = n11;
        n11 = this.f.b;
        objectArray[n10] = n11;
        objectArray[2] = object = Integer.valueOf(this.f.l);
        object = String.format("vsize setCaptureOrientation w*h:%d*%d orientation:%d", objectArray);
        TXCLog.i("CameraCapture", (String)object);
    }

    public void e(boolean bl2) {
        this.f.U = bl2;
        this.c.b(bl2);
        this.r = true;
    }

    public EGLContext f() {
        return this.h.getGLContext();
    }

    public void f(int n10) {
        boolean bl2;
        this.f.h = n10;
        Object object = this.c;
        if (object != null) {
            ((a)object).a(n10);
        }
        if ((object = this.h) != null && (bl2 = object instanceof TXCGLSurfaceView)) {
            object = (TXCGLSurfaceView)object;
            ((TXCGLSurfaceView)object).setFPS(n10);
        }
    }

    public void g(int n10) {
        this.m = n10;
    }

    public boolean g() {
        a a10 = this.c;
        if (a10 != null) {
            return a10.e();
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void h() {
        Object object = this.c.h();
        if (object != null) {
            object = this.c;
            ((a)object).c();
        }
        object = this.n;
        synchronized (object) {
            Object object2;
            Object object3 = this.o;
            if (object3 == null) {
                object2 = "cameraMonitorThread";
                this.o = object3 = new HandlerThread((String)object2);
                object3.start();
                object2 = this.o;
                object2 = object2.getLooper();
                object3 = new Handler((Looper)object2);
                this.p = object3;
                object3 = "CameraCapture";
                object2 = "start camera monitor ";
                TXCLog.w((String)object3, (String)object2);
            }
            if ((object3 = this.p) != null) {
                object2 = new c$2(this);
                long l10 = 2000L;
                object3.postDelayed((Runnable)object2, l10);
            }
            return;
        }
    }

    public void onNotifyEvent(int n10, Bundle bundle) {
        com.tencent.liteav.basic.util.g.a(this.a, n10, bundle);
    }
}

