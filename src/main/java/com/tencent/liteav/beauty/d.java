/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.content.Context
 *  android.content.pm.ConfigurationInfo
 *  android.graphics.Bitmap
 *  android.os.Build$VERSION
 */
package com.tencent.liteav.beauty;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.graphics.Bitmap;
import android.os.Build;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.TXCOpenGlUtils;
import com.tencent.liteav.beauty.a;
import com.tencent.liteav.beauty.c;
import com.tencent.liteav.beauty.d$a;
import com.tencent.liteav.beauty.d$b;
import com.tencent.liteav.beauty.d$c;
import com.tencent.liteav.beauty.d$d;
import com.tencent.liteav.beauty.e;
import com.tencent.liteav.beauty.f;

public class d
extends com.tencent.liteav.basic.module.a
implements e {
    public Context a;
    public boolean b;
    public boolean c;
    public int d;
    public int e;
    public int f;
    public com.tencent.liteav.basic.opengl.a g;
    public c h;
    public d$b i;
    public d$c j;
    public f k;
    private d$d l;
    private long m;
    private long n;
    private long o;
    private Object p;
    private d$a q;

    public d(Context context, boolean bl2) {
        c c10;
        long l10;
        Object object;
        int n10;
        this.b = n10 = 1;
        boolean bl3 = false;
        this.c = false;
        this.d = 0;
        this.e = 0;
        this.f = n10;
        n10 = 0;
        this.g = null;
        Object object2 = new d$b();
        this.i = object2;
        this.j = null;
        this.l = object = d$d.c;
        this.m = l10 = 0L;
        this.n = l10;
        this.o = l10;
        super(this);
        this.q = object;
        object = (ActivityManager)context.getSystemService("activity");
        object2 = "TXCVideoPreprocessor";
        CharSequence charSequence = "TXCVideoPreprocessor version: VideoPreprocessor-v1.1";
        TXCLog.i((String)object2, (String)charSequence);
        object = object.getDeviceConfigurationInfo();
        if (object != null) {
            super();
            ((StringBuilder)charSequence).append("opengl es version ");
            int n11 = ((ConfigurationInfo)object).reqGlEsVersion;
            ((StringBuilder)charSequence).append(n11);
            charSequence = ((StringBuilder)charSequence).toString();
            TXCLog.i((String)object2, (String)charSequence);
            super();
            String string2 = "set GLContext ";
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(bl2);
            charSequence = ((StringBuilder)charSequence).toString();
            TXCLog.i((String)object2, (String)charSequence);
            n10 = ((ConfigurationInfo)object).reqGlEsVersion;
            int n12 = 131072;
            if (n10 > n12) {
                object = "This devices is OpenGlUtils.OPENGL_ES_3";
                TXCLog.i((String)object2, (String)object);
                n10 = 3;
                TXCOpenGlUtils.a(n10);
            } else {
                object = "This devices is OpenGlUtils.OPENGL_ES_2";
                TXCLog.i((String)object2, (String)object);
                n10 = 2;
                TXCOpenGlUtils.a(n10);
            }
        } else {
            object = "getDeviceConfigurationInfo opengl Info failed!";
            TXCLog.e((String)object2, (String)object);
        }
        this.a = context;
        this.b = bl2;
        object = this.a;
        bl3 = this.b;
        this.h = c10 = new c((Context)object, bl3);
        com.tencent.liteav.beauty.a.a().a(context);
    }

    private boolean a(int n10, int n11, int n12, int n13, int n14) {
        Object object;
        int n15;
        com.tencent.liteav.basic.opengl.a a10;
        int n16;
        Object object2;
        int n17;
        Object object3 = this.j;
        if (object3 == null) {
            long l10;
            n17 = 0;
            object2 = null;
            object3 = new d$c(null);
            this.j = object3;
            this.n = 0L;
            this.o = l10 = System.currentTimeMillis();
        }
        object3 = this.j;
        n17 = ((d$c)object3).b;
        if (!(n10 != n17 || n11 != (n17 = ((d$c)object3).c) || n12 != (n17 = ((d$c)object3).d) || (n17 = this.d) > 0 && n17 != (n16 = ((d$c)object3).f) || (n17 = this.e) > 0 && n17 != (n16 = ((d$c)object3).g) || (object2 = this.g) != null && ((n16 = ((com.tencent.liteav.basic.opengl.a)object2).c) > 0 && ((a10 = ((d$c)object3).j) == null || n16 != (n15 = a10.c)) || (n16 = ((com.tencent.liteav.basic.opengl.a)object2).d) > 0 && ((a10 = ((d$c)object3).j) == null || n16 != (n15 = a10.d)) || (n16 = ((com.tencent.liteav.basic.opengl.a)object2).a) >= 0 && ((a10 = ((d$c)object3).j) == null || n16 != (n15 = a10.a)) || (n17 = ((com.tencent.liteav.basic.opengl.a)object2).b) >= 0 && ((object = ((d$c)object3).j) == null || n17 != (n16 = ((com.tencent.liteav.basic.opengl.a)object).b))) || (n17 = (int)(this.c ? 1 : 0)) != (n16 = (int)(((d$c)object3).e ? 1 : 0)) || (n17 = ((d$c)object3).h) != n13)) {
            if (n13 != n17 || n14 != (n10 = ((d$c)object3).i)) {
                ((d$c)object3).h = n13;
                Object object4 = this.i;
                ((d$b)object4).k = n13;
                ((d$c)object3).i = n14;
                ((d$b)object4).l = n14;
                object4 = this.h;
                ((c)((Object)object4)).b(n14);
            }
        } else {
            d$d d$d;
            Object object5;
            int n18;
            object3 = "TXCVideoPreprocessor";
            TXCLog.i((String)object3, "Init sdk");
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Input widht ");
            ((StringBuilder)object2).append(n10);
            object = " height ";
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(n11);
            object2 = ((StringBuilder)object2).toString();
            TXCLog.i((String)object3, (String)object2);
            object2 = this.j;
            ((d$c)object2).b = n10;
            ((d$c)object2).c = n11;
            object2 = this.g;
            if (object2 != null && (n16 = ((com.tencent.liteav.basic.opengl.a)object2).a) >= 0 && (n16 = ((com.tencent.liteav.basic.opengl.a)object2).b) >= 0 && (n16 = ((com.tencent.liteav.basic.opengl.a)object2).c) > 0 && (n17 = ((com.tencent.liteav.basic.opengl.a)object2).d) > 0) {
                TXCLog.i((String)object3, "set Crop Rect; init ");
                object2 = this.g;
                n16 = ((com.tencent.liteav.basic.opengl.a)object2).a;
                n15 = n10 - n16;
                n18 = ((com.tencent.liteav.basic.opengl.a)object2).c;
                n10 = n15 > n18 ? n18 : (n10 -= n16);
                n16 = ((com.tencent.liteav.basic.opengl.a)object2).b;
                n15 = n11 - n16;
                n18 = ((com.tencent.liteav.basic.opengl.a)object2).d;
                n11 = n15 > n18 ? n18 : (n11 -= n16);
                ((com.tencent.liteav.basic.opengl.a)object2).c = n10;
                ((com.tencent.liteav.basic.opengl.a)object2).d = n11;
            }
            n15 = n10;
            n18 = n11;
            Object object6 = this.j;
            ((d$c)object6).j = object5 = this.g;
            ((d$c)object6).d = n12;
            n11 = (int)(this.b ? 1 : 0);
            ((d$c)object6).a = n11;
            ((d$c)object6).h = n13;
            ((d$c)object6).i = n14;
            ((d$c)object6).f = n11 = this.d;
            ((d$c)object6).g = n13 = this.e;
            n14 = 270;
            n17 = 90;
            if (n11 <= 0 || n13 <= 0) {
                if (n17 != n12 && n14 != n12) {
                    ((d$c)object6).f = n15;
                    ((d$c)object6).g = n18;
                } else {
                    ((d$c)object6).f = n18;
                    ((d$c)object6).g = n15;
                }
            }
            if ((object5 = this.l) == (d$d = d$d.a)) {
                if (n17 != n12 && n14 != n12) {
                    n15 = ((d$c)object6).f;
                    n18 = ((d$c)object6).g;
                } else {
                    n15 = ((d$c)object6).g;
                    n18 = ((d$c)object6).f;
                }
            } else {
                d$d = d$d.b;
                if (object5 != d$d) {
                    int n19 = ((d$c)object6).f;
                    int n20 = ((d$c)object6).g;
                    object = this;
                    object6 = this.b(n15, n18, n12, n19, n20);
                    n11 = (((com.tencent.liteav.basic.util.e)object6).a + 7) / 8;
                    n15 = n11 * 8;
                    n10 = (((com.tencent.liteav.basic.util.e)object6).b + 7) / 8;
                    n18 = n10 * 8;
                }
            }
            object6 = this.j;
            n11 = (int)(this.c ? 1 : 0);
            ((d$c)object6).e = n11;
            n10 = (int)(this.a((d$c)object6, n15, n18) ? 1 : 0);
            if (n10 == 0) {
                TXCLog.e((String)object3, "init failed!");
                return false;
            }
        }
        return true;
    }

    private boolean a(d$c object, int n10, int n11) {
        com.tencent.liteav.basic.opengl.a a10;
        int n12;
        d$b d$b = this.i;
        d$b.d = n12 = ((d$c)object).b;
        d$b.e = n12 = ((d$c)object).c;
        d$b.m = a10 = ((d$c)object).j;
        d$b.g = n10;
        d$b.f = n11;
        d$b.h = n10 = (((d$c)object).d + 360) % 360;
        d$b.b = n10 = ((d$c)object).f;
        d$b.c = n10 = ((d$c)object).g;
        d$b.a = 0;
        n10 = (int)(((d$c)object).a ? 1 : 0);
        d$b.j = n10;
        n10 = (int)(((d$c)object).e ? 1 : 0);
        d$b.i = n10;
        d$b.k = n10 = ((d$c)object).h;
        d$b.l = n10 = ((d$c)object).i;
        Object object2 = this.h;
        if (object2 == null) {
            Context context = this.a;
            int n13 = ((d$c)object).a;
            object2 = new c(context, n13 != 0);
            this.h = object2;
            n13 = this.f;
            object2.a(n13);
        }
        object = this.h;
        object2 = this.i;
        return ((c)((Object)object)).a((d$b)object2);
    }

    private com.tencent.liteav.basic.util.e b(int n10, int n11, int n12, int n13, int n14) {
        int[] nArray;
        int n15 = 90;
        if (n12 == n15 || n12 == (n15 = 270)) {
            int n16 = n14;
            n14 = n13;
            n13 = n16;
        }
        n12 = Math.min(n13, n14);
        n15 = Math.min(n10, n11);
        int n17 = 3;
        int[] nArray2 = nArray = new int[n17];
        nArray[0] = 720;
        nArray2[1] = 1080;
        nArray2[2] = 1280;
        for (int i10 = 0; i10 < n17; ++i10) {
            int n18 = nArray[i10];
            if (n12 > n18 || n15 < n18) continue;
            float f10 = (float)n18 * 1.0f;
            float f11 = n12;
            n12 = (int)((float)n13 * (f10 /= f11));
            float f12 = n14;
            n11 = (int)(f10 * f12);
            com.tencent.liteav.basic.util.e e10 = new com.tencent.liteav.basic.util.e(n12, n11);
            return e10;
        }
        com.tencent.liteav.basic.util.e e11 = new com.tencent.liteav.basic.util.e(n10, n11);
        return e11;
    }

    private void c() {
        int n10;
        long l10;
        long l11 = this.m;
        long l12 = 0L;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object != false) {
            l11 = System.currentTimeMillis();
            l10 = this.m;
            n10 = 3002;
            Long l14 = l11 -= l10;
            this.setStatusValue(n10, l14);
        }
        l11 = this.n;
        double d10 = Double.MIN_VALUE;
        this.n = ++l11;
        l11 = System.currentTimeMillis();
        l10 = this.o;
        double d11 = 9.88E-321;
        long l15 = 2000L + l10;
        long l16 = l11 - l15;
        Object object2 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object2 > 0) {
            l15 = this.n;
            d11 = l15;
            double d12 = 1000.0;
            d11 *= d12;
            l10 = l11 - l10;
            d10 = l10;
            n10 = 3003;
            Double d13 = d11 /= d10;
            this.setStatusValue(n10, d13);
            this.n = l12;
            this.o = l11;
        }
    }

    private int z(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 == n11) {
                    n10 = 270;
                }
            } else {
                n10 = 180;
            }
        } else {
            n10 = 90;
        }
        return n10;
    }

    public int a(int n10, int n11, int n12) {
        Object object = this.k;
        boolean bl2 = false;
        if (object != null) {
            object = new com.tencent.liteav.basic.structs.b();
            ((com.tencent.liteav.basic.structs.b)object).e = n11;
            ((com.tencent.liteav.basic.structs.b)object).f = n12;
            ((com.tencent.liteav.basic.structs.b)object).j = 0;
            d$c d$c = this.j;
            if (d$c != null) {
                bl2 = d$c.e;
            }
            ((com.tencent.liteav.basic.structs.b)object).i = bl2;
            ((com.tencent.liteav.basic.structs.b)object).a = n10;
            return this.k.a((com.tencent.liteav.basic.structs.b)object);
        }
        return 0;
    }

    public int a(int n10, int n11, int n12, int n13, int n14, int n15, long l10) {
        synchronized (this) {
            int n16 = this.z(n13);
            this.a(n11, n12, n16, n14, n15);
            c c10 = this.h;
            d$b d$b = this.i;
            c10.b(d$b);
            c10 = this.h;
            n10 = c10.a(n10, n14, l10);
            return n10;
        }
    }

    public int a(com.tencent.liteav.basic.structs.b b10, int n10, int n11, long l10) {
        synchronized (this) {
            int n12;
            Object object;
            block21: {
                long l11 = System.currentTimeMillis();
                this.m = l11;
                object = b10.l;
                this.a((com.tencent.liteav.basic.opengl.a)object);
                int n13 = b10.g;
                n12 = b10.h;
                this.a(n13, n12);
                n13 = (int)(b10.i ? 1 : 0);
                this.b(n13 != 0);
                object = b10.c;
                this.a((float[])object);
                n13 = b10.d;
                this.a(n13 != 0);
                byte[] byArray = b10.m;
                if (byArray == null) break block21;
                n13 = b10.a;
                n12 = -1;
                if (n13 != n12) break block21;
                int n14 = b10.e;
                int n15 = b10.f;
                int n16 = b10.j;
                int n17 = this.a(byArray, n14, n15, n16, n10, n11);
                return n17;
            }
            n12 = b10.a;
            int n18 = b10.e;
            int n19 = b10.f;
            int n20 = b10.j;
            object = this;
            int n21 = n10;
            int n22 = this.a(n12, n18, n19, n20, n10, n11, l10);
            return n22;
            finally {
            }
        }
    }

    public int a(byte[] byArray, int n10, int n11, int n12, int n13, int n14) {
        synchronized (this) {
            int n15 = this.z(n12);
            this.a(n10, n11, n15, n13, n14);
            c c10 = this.h;
            d$b d$b = this.i;
            c10.b(d$b);
            c10 = this.h;
            int n16 = c10.a(byArray, n13);
            return n16;
        }
    }

    public Object a() {
        synchronized (this) {
            Object object = this.p;
            return object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(float f10) {
        synchronized (this) {
            c c10 = this.h;
            if (c10 != null) {
                c10.a(f10);
            }
            return;
        }
    }

    public void a(int n10) {
        int n11 = this.f;
        if (n10 != n11) {
            this.f = n10;
            c c10 = this.h;
            if (c10 != null) {
                c10.a(n10);
            }
        }
    }

    public void a(int n10, int n11) {
        synchronized (this) {
            this.d = n10;
            this.e = n11;
            return;
        }
    }

    public void a(int n10, int n11, int n12, long l10) {
        this.c();
        Object object = this.k;
        if (object != null) {
            object = new com.tencent.liteav.basic.structs.b();
            ((com.tencent.liteav.basic.structs.b)object).e = n11;
            ((com.tencent.liteav.basic.structs.b)object).f = n12;
            n11 = 0;
            ((com.tencent.liteav.basic.structs.b)object).j = 0;
            d$c d$c = this.j;
            if (d$c != null) {
                n11 = (int)(d$c.e ? 1 : 0);
            }
            ((com.tencent.liteav.basic.structs.b)object).i = n11;
            ((com.tencent.liteav.basic.structs.b)object).a = n10;
            f f10 = this.k;
            f10.a((com.tencent.liteav.basic.structs.b)object, l10);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(Bitmap bitmap) {
        synchronized (this) {
            c c10 = this.h;
            if (c10 != null) {
                c10.a(bitmap);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(Bitmap object, float f10, float f11, float f12) {
        synchronized (this) {
            double d10;
            double d11;
            double d12;
            float f13;
            int n10 = 0;
            c c10 = null;
            float f14 = f10 - 0.0f;
            float f15 = f14 == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1);
            if (f15 >= 0 && (n10 = (f13 = f11 - 0.0f) == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1)) >= 0 && (n10 = (int)((d12 = (d11 = (double)f12) - (d10 = 0.0)) == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1))) >= 0) {
                c10 = this.h;
                if (c10 != null) {
                    c10.a((Bitmap)object, f10, f11, f12);
                }
                return;
            }
            String string2 = "TXCVideoPreprocessor";
            String string3 = "WaterMark param is Error!";
            TXCLog.e(string2, string3);
            return;
        }
    }

    public void a(b object) {
        synchronized (this) {
            Object object2;
            block5: {
                object2 = this.h;
                if (object2 != null) break block5;
                object = "TXCVideoPreprocessor";
                object2 = "setListener mDrawer is null!";
                TXCLog.e((String)object, (String)object2);
                return;
            }
            object2.a((b)object);
            return;
        }
    }

    public void a(com.tencent.liteav.basic.opengl.a a10) {
        synchronized (this) {
            this.g = a10;
            return;
        }
    }

    public void a(d$d object) {
        synchronized (this) {
            this.l = object;
            String string2 = "TXCVideoPreprocessor";
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = "set Process SDK performance ";
            stringBuilder.append(string3);
            stringBuilder.append(object);
            object = stringBuilder.toString();
            TXCLog.i(string2, (String)object);
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void a(f object) {
        synchronized (this) {
            Object object2;
            block9: {
                block8: {
                    object2 = this.h;
                    if (object2 != null) break block8;
                    object = "TXCVideoPreprocessor";
                    object2 = "setListener mDrawer is null!";
                    TXCLog.e((String)object, (String)object2);
                    return;
                }
                this.k = object;
                if (object != null) break block9;
                object = null;
                ((c)((Object)object2)).a((e)null);
                return;
            }
            ((c)((Object)object2)).a(this);
            return;
        }
    }

    public void a(Object object) {
        synchronized (this) {
            this.p = object;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(String string2) {
        synchronized (this) {
            c c10 = this.h;
            if (c10 != null) {
                c10.a(string2);
            }
            return;
        }
    }

    public void a(boolean bl2) {
        c c10 = this.h;
        if (c10 != null) {
            c10.a(bl2);
        }
    }

    public void a(byte[] byArray, int n10, int n11, int n12, long l10) {
        f f10 = this.k;
        if (f10 != null) {
            f10.b(byArray, n10, n11, n12, l10);
        }
    }

    public void a(float[] fArray) {
        c c10 = this.h;
        if (c10 != null) {
            c10.a(fArray);
        }
    }

    public boolean a(String string2, boolean bl2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 < n11) {
            return false;
        }
        c c10 = this.h;
        if (c10 != null) {
            c10.a(string2, bl2);
        }
        return true;
    }

    public void b() {
        synchronized (this) {
            c c10;
            block5: {
                c10 = this.h;
                if (c10 == null) break block5;
                c10.a();
            }
            c10 = null;
            this.j = null;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(int n10) {
        synchronized (this) {
            Object object = this.h;
            if (object != null) {
                ((c)((Object)object)).d(n10);
            }
            object = this.q;
            String string2 = "beautyStyle";
            ((d$a)object).a(string2, n10);
            return;
        }
    }

    public void b(boolean bl2) {
        synchronized (this) {
            this.c = bl2;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c(int n10) {
        synchronized (this) {
            Throwable throwable2;
            block7: {
                Object object;
                String string2;
                block6: {
                    int n11 = 9;
                    if (n10 > n11) {
                        String string3 = "TXCVideoPreprocessor";
                        string2 = "Beauty value too large! set max value 9";
                        try {
                            TXCLog.e(string3, string2);
                            n10 = n11;
                            break block6;
                        }
                        catch (Throwable throwable2) {
                            break block7;
                        }
                    }
                    if (n10 < 0) {
                        String string4 = "TXCVideoPreprocessor";
                        object = "Beauty < 0; set 0";
                        TXCLog.e(string4, (String)object);
                        n10 = 0;
                        string4 = null;
                    }
                }
                object = this.h;
                if (object != null) {
                    ((c)((Object)object)).c(n10);
                }
                object = this.q;
                string2 = "beautyLevel";
                ((d$a)object).a(string2, n10);
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c(boolean bl2) {
        synchronized (this) {
            c c10 = this.h;
            if (c10 != null) {
                c10.b(bl2);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void d(int n10) {
        synchronized (this) {
            Throwable throwable2;
            block7: {
                Object object;
                String string2;
                block6: {
                    int n11 = 9;
                    if (n10 > n11) {
                        String string3 = "TXCVideoPreprocessor";
                        string2 = "Brightness value too large! set max value 9";
                        try {
                            TXCLog.e(string3, string2);
                            n10 = n11;
                            break block6;
                        }
                        catch (Throwable throwable2) {
                            break block7;
                        }
                    }
                    if (n10 < 0) {
                        String string4 = "TXCVideoPreprocessor";
                        object = "Brightness < 0; set 0";
                        TXCLog.e(string4, (String)object);
                        n10 = 0;
                        string4 = null;
                    }
                }
                object = this.h;
                if (object != null) {
                    ((c)((Object)object)).e(n10);
                }
                object = this.q;
                string2 = "whiteLevel";
                ((d$a)object).a(string2, n10);
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void e(int n10) {
        synchronized (this) {
            Throwable throwable2;
            block7: {
                Object object;
                String string2;
                block6: {
                    int n11 = 9;
                    if (n10 > n11) {
                        String string3 = "TXCVideoPreprocessor";
                        string2 = "Ruddy value too large! set max value 9";
                        try {
                            TXCLog.e(string3, string2);
                            n10 = n11;
                            break block6;
                        }
                        catch (Throwable throwable2) {
                            break block7;
                        }
                    }
                    if (n10 < 0) {
                        String string4 = "TXCVideoPreprocessor";
                        object = "Ruddy < 0; set 0";
                        TXCLog.e(string4, (String)object);
                        n10 = 0;
                        string4 = null;
                    }
                }
                object = this.h;
                if (object != null) {
                    ((c)((Object)object)).g(n10);
                }
                object = this.q;
                string2 = "ruddyLevel";
                ((d$a)object).a(string2, n10);
                return;
            }
            throw throwable2;
        }
    }

    public void f(int n10) {
        Object object = "TXCVideoPreprocessor";
        int n11 = 9;
        if (n10 > n11) {
            String string2 = "Brightness value too large! set max value 9";
            TXCLog.e((String)object, string2);
            n10 = n11;
        } else if (n10 < 0) {
            TXCLog.e((String)object, "Brightness < 0; set 0");
            n10 = 0;
            Object var4_5 = null;
        }
        object = this.h;
        if (object != null) {
            ((c)((Object)object)).f(n10);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void g(int n10) {
        synchronized (this) {
            Object object = this.h;
            if (object != null) {
                ((c)((Object)object)).h(n10);
            }
            object = this.q;
            String string2 = "eyeBigScale";
            ((d$a)object).a(string2, n10);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void h(int n10) {
        synchronized (this) {
            Object object = this.h;
            if (object != null) {
                ((c)((Object)object)).i(n10);
            }
            object = this.q;
            String string2 = "faceSlimLevel";
            ((d$a)object).a(string2, n10);
            return;
        }
    }

    public void i(int n10) {
        c c10 = this.h;
        if (c10 != null) {
            c10.j(n10);
        }
        this.q.a("faceVLevel", n10);
    }

    public void j(int n10) {
        c c10 = this.h;
        if (c10 != null) {
            c10.k(n10);
        }
        this.q.a("faceShortLevel", n10);
    }

    public void k(int n10) {
        c c10 = this.h;
        if (c10 != null) {
            c10.l(n10);
        }
        this.q.a("chinLevel", n10);
    }

    public void l(int n10) {
        c c10 = this.h;
        if (c10 != null) {
            c10.m(n10);
        }
        this.q.a("noseSlimLevel", n10);
    }

    public void m(int n10) {
        c c10 = this.h;
        if (c10 != null) {
            c10.n(n10);
        }
        this.q.a("eyeLightenLevel", n10);
    }

    public void n(int n10) {
        c c10 = this.h;
        if (c10 != null) {
            c10.o(n10);
        }
        this.q.a("toothWhitenLevel", n10);
    }

    public void o(int n10) {
        c c10 = this.h;
        if (c10 != null) {
            c10.p(n10);
        }
        this.q.a("wrinkleRemoveLevel", n10);
    }

    public void p(int n10) {
        c c10 = this.h;
        if (c10 != null) {
            c10.q(n10);
        }
        this.q.a("pounchRemoveLevel", n10);
    }

    public void q(int n10) {
        c c10 = this.h;
        if (c10 != null) {
            c10.r(n10);
        }
        this.q.a("smileLinesRemoveLevel", n10);
    }

    public void r(int n10) {
        c c10 = this.h;
        if (c10 != null) {
            c10.s(n10);
        }
        this.q.a("foreheadLevel", n10);
    }

    public void s(int n10) {
        c c10 = this.h;
        if (c10 != null) {
            c10.t(n10);
        }
        this.q.a("eyeDistanceLevel", n10);
    }

    public void setID(String string2) {
        super.setID(string2);
        string2 = this.q.a();
        this.setStatusValue(3001, string2);
    }

    public void t(int n10) {
        c c10 = this.h;
        if (c10 != null) {
            c10.u(n10);
        }
        this.q.a("eyeAngleLevel", n10);
    }

    public void u(int n10) {
        c c10 = this.h;
        if (c10 != null) {
            c10.v(n10);
        }
        this.q.a("mouthShapeLevel", n10);
    }

    public void v(int n10) {
        c c10 = this.h;
        if (c10 != null) {
            c10.w(n10);
        }
        this.q.a("noseWingLevel", n10);
    }

    public void w(int n10) {
        c c10 = this.h;
        if (c10 != null) {
            c10.x(n10);
        }
        this.q.a("nosePositionLevel", n10);
    }

    public void x(int n10) {
        c c10 = this.h;
        if (c10 != null) {
            c10.y(n10);
        }
        this.q.a("lipsThicknessLevel", n10);
    }

    public void y(int n10) {
        c c10 = this.h;
        if (c10 != null) {
            c10.z(n10);
        }
        this.q.a("faceBeautyLevel", n10);
    }
}

