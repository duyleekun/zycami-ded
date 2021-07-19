/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory
 *  android.graphics.Canvas
 *  android.graphics.Point
 *  android.graphics.drawable.Drawable
 *  com.mob.tools.utils.BitmapHelper
 */
package cn.sharesdk.framework.utils.QRCodeUtil;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import cn.sharesdk.framework.utils.QRCodeUtil.a;
import cn.sharesdk.framework.utils.QRCodeUtil.c;
import cn.sharesdk.framework.utils.QRCodeUtil.e;
import cn.sharesdk.framework.utils.QRCodeUtil.f;
import cn.sharesdk.framework.utils.QRCodeUtil.k;
import cn.sharesdk.framework.utils.QRCodeUtil.l;
import com.mob.MobSDK;
import com.mob.tools.utils.BitmapHelper;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;

public class j {
    private int A;
    private Point B;
    private float C;
    private int D;
    private int E;
    private int F;
    private Bitmap G;
    private boolean H;
    private boolean I;
    private float[] J;
    private float[] K;
    private float[] L;
    private k M;
    public Bitmap a;
    public Point b;
    public Point c;
    public String d;
    public int e;
    public String f;
    public boolean g;
    public int h;
    public Bitmap i;
    public Drawable j;
    public String k;
    public String l;
    public int m;
    public int n;
    public boolean o;
    public int p;
    public Bitmap q;
    public Drawable r;
    public String s;
    public String t;
    public int u;
    public boolean v;
    private int w;
    private int x;
    private int y;
    private int z;

    public j() {
        int n10;
        int n11;
        Point point;
        int n12;
        Object object;
        this.B = object = new Point();
        this.D = n12 = 400;
        this.E = n12;
        this.b = point = new Point();
        this.c = point = new Point(n12, n12);
        this.d = null;
        this.e = n11 = 1;
        this.f = null;
        this.g = n11;
        this.h = 0;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.n = n10 = 6;
        this.o = n11;
        this.p = 0;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = n10;
        this.v = n11;
        this.I = n11;
        this.y = n12;
        this.w = n12;
        this.x = n12;
        this.z = 0;
        this.A = 80;
        this.m = -1;
        this.F = -16777216;
        this.M = object;
        this.e();
    }

    private Bitmap a(Drawable drawable2) {
        int n10;
        int n11 = drawable2.getIntrinsicWidth();
        int n12 = drawable2.getIntrinsicHeight();
        int n13 = drawable2.getOpacity();
        Bitmap.Config config = n13 != (n10 = -1) ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        config = Bitmap.createBitmap((int)n11, (int)n12, (Bitmap.Config)config);
        Canvas canvas = new Canvas((Bitmap)config);
        drawable2.setBounds(0, 0, n11, n12);
        drawable2.draw(canvas);
        return config;
    }

    private void a(Canvas object) {
        Bitmap bitmap = this.i;
        if (bitmap != null) {
            int n10;
            int n11;
            object = new float[2];
            float f10 = bitmap.getWidth();
            float f11 = this.w;
            f10 /= f11;
            f11 = 0.0f;
            object[0] = (Canvas)f10;
            bitmap = this.i;
            int n12 = bitmap.getHeight();
            f10 = n12;
            int n13 = this.x;
            float f12 = n13;
            f10 /= f12;
            int n14 = 1;
            f12 = Float.MIN_VALUE;
            object[n14] = (Canvas)f10;
            this.J = (float[])object;
            int[] nArray = new int[this.w * n13];
            object = null;
            for (int i10 = 0; i10 < (n11 = this.x); ++i10) {
                bitmap = null;
                f10 = 0.0f;
                for (n12 = 0; n12 < (n13 = this.w); ++n12) {
                    n13 = n13 * i10 + n12;
                    nArray[n13] = n10 = this.b(n12, i10);
                }
            }
            Bitmap bitmap2 = this.a;
            n10 = 0;
            int n15 = this.w;
            bitmap2.setPixels(nArray, 0, n15, 0, 0, n15, n11);
        } else {
            int n16 = this.m;
            object.drawColor(n16);
        }
    }

    private int b(int n10, int n11) {
        float[] fArray = this.J;
        if (fArray == null) {
            return this.m;
        }
        float f10 = n10;
        float f11 = fArray[0];
        n10 = (int)(f10 * f11);
        float f12 = n11;
        float f13 = fArray[1];
        n11 = (int)(f12 * f13);
        return this.i.getPixel(n10, n11);
    }

    private void b(Canvas canvas) {
        int n10;
        float f10;
        int n11;
        int n12;
        int n13;
        int n14;
        float f11;
        float f12;
        Object object;
        Object object2 = this.G;
        int n15 = 0;
        float f13 = 0.0f;
        Bitmap.Config config = null;
        int n16 = 1;
        float f14 = Float.MIN_VALUE;
        int n17 = 2;
        if (object2 != null) {
            object = new float[n17];
            f12 = object2.getWidth();
            f11 = this.y;
            object[0] = f12 /= f11;
            object2 = this.G;
            n14 = object2.getHeight();
            f12 = n14;
            n13 = this.y;
            f11 = n13;
            object[n16] = f12 /= f11;
            this.K = object;
        }
        Object object3 = new l();
        HashMap<Bitmap, Object> hashMap = new HashMap<Bitmap, Object>();
        object2 = cn.sharesdk.framework.utils.QRCodeUtil.e.b;
        hashMap.put((Bitmap)object2, "utf-8");
        object2 = cn.sharesdk.framework.utils.QRCodeUtil.e.f;
        object = this.z;
        hashMap.put((Bitmap)object2, object);
        object2 = cn.sharesdk.framework.utils.QRCodeUtil.e.a;
        object = (Object)cn.sharesdk.framework.utils.QRCodeUtil.f.d;
        hashMap.put((Bitmap)object2, object);
        String string2 = this.f;
        a a10 = cn.sharesdk.framework.utils.QRCodeUtil.a.l;
        int n18 = n12 = this.y;
        object2 = ((l)object3).encode(string2, a10, n12, n12, hashMap);
        int n19 = this.y;
        n19 *= n19;
        object = new int[n19];
        object3 = null;
        f11 = 0.0f;
        for (n13 = 0; n13 < (n11 = this.y); ++n13) {
            string2 = null;
            f10 = 0.0f;
            for (n11 = 0; n11 < (n10 = this.y); ++n11) {
                n10 = (int)(((c)object2).a(n11, n13) ? 1 : 0);
                if (n10 != 0) {
                    n10 = this.y * n13 + n11;
                    n18 = this.c(n11, n13);
                    object[n10] = n18;
                    continue;
                }
                n10 = this.y * n13 + n11;
                object[n10] = 0.0f;
            }
        }
        object2 = this.q;
        if (object2 != null) {
            object3 = new float[n17];
            f12 = object2.getWidth();
            n11 = this.A;
            f10 = n11;
            object3[0] = f12 /= f10;
            object2 = this.q;
            f12 = object2.getHeight();
            n15 = this.A;
            f10 = n15;
            object3[n16] = f12 /= f10;
            this.L = (float[])object3;
            n14 = this.y;
            n16 = (n14 - n15) / n17;
            n14 = (n14 + n15) / n17;
            for (n15 = n16; n15 < n14; ++n15) {
                for (n13 = n16; n13 < n14; ++n13) {
                    n11 = this.y * n15 + n13;
                    n10 = n13 - n16;
                    n18 = n15 - n16;
                    n10 = this.d(n10, n18);
                    object[n11] = n10;
                }
            }
        }
        n14 = this.y;
        config = Bitmap.Config.ARGB_8888;
        object2 = Bitmap.createBitmap((int[])object, (int)n14, (int)n14, (Bitmap.Config)config);
        config = this.B;
        f14 = config.x;
        f13 = config.y;
        canvas.translate(f14, f13);
        f13 = this.C;
        canvas.rotate(f13);
        n15 = this.y;
        f14 = -n15 / n17;
        f13 = -n15 / n17;
        canvas.translate(f14, f13);
        canvas.drawBitmap((Bitmap)object2, 0.0f, 0.0f, null);
    }

    private int c(int n10, int n11) {
        float[] fArray = this.K;
        if (fArray == null) {
            return this.F;
        }
        float f10 = n10;
        float f11 = fArray[0];
        n10 = (int)(f10 * f11);
        float f12 = n11;
        float f13 = fArray[1];
        n11 = (int)(f12 * f13);
        return this.G.getPixel(n10, n11);
    }

    private void c() {
        int n10;
        int n11 = this.g;
        if (n11 != 0 && (n11 = this.e) == (n10 = 1)) {
            String string2;
            this.f = string2 = this.d;
        }
    }

    private int d(int n10, int n11) {
        float f10 = n10;
        Object object = this.L;
        float f11 = object[0];
        n10 = (int)(f10 *= f11);
        float f12 = n11;
        int n12 = 1;
        f11 = Float.MIN_VALUE;
        float f13 = object[n12];
        n11 = (int)(f12 *= f13);
        object = this.q;
        int n13 = object.getWidth();
        if (n10 >= n13) {
            Bitmap bitmap = this.q;
            n10 = bitmap.getWidth() - n12;
        }
        if (n11 >= (n13 = (object = (Object)this.q).getHeight())) {
            Bitmap bitmap = this.q;
            n11 = bitmap.getHeight() - n12;
        }
        return this.q.getPixel(n10, n11);
    }

    private void d() {
        Object object;
        int n10 = this.o;
        int n11 = 5;
        int n12 = 4;
        int n13 = 3;
        int n14 = 1;
        int n15 = 6;
        if (n10 != 0 && (n10 = this.n) != n15) {
            if (n10 == n14) {
                object = MobSDK.getContext().getResources();
                int n16 = this.h;
                object = BitmapFactory.decodeResource((Resources)object, (int)n16);
                this.i = object;
            } else if (n10 == n13) {
                object = this.j;
                object = this.a((Drawable)object);
                this.i = object;
            } else if (n10 == n12) {
                String string2 = this.k;
                object = new FileInputStream(string2);
                object = BitmapFactory.decodeStream((InputStream)object);
                this.i = object;
            } else if (n10 == n11) {
                object = MobSDK.getContext();
                Object object2 = this.l;
                object = BitmapHelper.downloadBitmap((Context)object, (String)object2);
                object2 = new FileInputStream((String)object);
                object = BitmapFactory.decodeStream((InputStream)object2);
                this.i = object;
            }
            this.o = false;
        }
        if ((n10 = (int)(this.v ? 1 : 0)) != 0 && (n10 = this.u) != n15) {
            if (n10 == n14) {
                object = MobSDK.getContext().getResources();
                n11 = this.p;
                object = BitmapFactory.decodeResource((Resources)object, (int)n11);
                this.q = object;
            } else if (n10 == n13) {
                object = this.r;
                object = this.a((Drawable)object);
                this.q = object;
            } else if (n10 == n12) {
                String string3 = this.s;
                object = new FileInputStream(string3);
                object = BitmapFactory.decodeStream((InputStream)object);
                this.q = object;
            } else if (n10 == n11) {
                object = MobSDK.getContext();
                Object object3 = this.t;
                object = BitmapHelper.downloadBitmap((Context)object, (String)object3);
                object3 = new FileInputStream((String)object);
                object = BitmapFactory.decodeStream((InputStream)object3);
                this.q = object;
            }
            this.v = false;
        }
    }

    private void e() {
        float f10;
        Point point = this.c;
        int n10 = point.x;
        Point point2 = this.b;
        int n11 = point2.x;
        int n12 = point.y;
        int n13 = point2.y;
        n12 -= n13;
        n13 = (n10 -= n11) * n10;
        n11 = n12 * n12;
        this.y = n13 = (int)(Math.sqrt((n13 + n11) * 2) / 2.0);
        Point point3 = this.B;
        Point point4 = this.c;
        int n14 = point4.x;
        Point point5 = this.b;
        int n15 = point5.x;
        point3.x = n14 = (n14 + n15) / 2;
        int n16 = point4.y;
        n14 = point5.y;
        point3.y = n16 = (n16 + n14) / 2;
        this.A = n13 = (int)((double)n13 * 0.2);
        double d10 = n12;
        double d11 = n10;
        this.C = f10 = (float)(Math.toDegrees(Math.atan2(d10, d11)) - 45.0);
    }

    public Bitmap a() {
        return this.a;
    }

    public void a(int n10) {
        int n11;
        if (n10 > 0 && (n11 = this.H) == 0) {
            n11 = this.h;
            int n12 = 1;
            if (n11 == n10 && (n11 = this.n) == n12) {
                return;
            }
            this.h = n10;
            this.o = n12;
            this.n = n12;
            this.I = n12;
        }
    }

    public void a(int n10, int n11) {
        boolean bl2 = this.H;
        if (!bl2) {
            this.w = n10;
            this.x = n11;
            n10 = 1;
            this.I = n10;
        }
    }

    public void a(int n10, int n11, int n12, int n13) {
        boolean bl2 = this.H;
        if (!bl2) {
            Point point = this.b;
            point.x = n10;
            point.y = n11;
            Point point2 = this.c;
            point2.x = n12;
            point2.y = n13;
            this.e();
            n10 = 1;
            this.I = n10;
        }
    }

    public void a(Bitmap bitmap, boolean n10) {
        int n11;
        if (bitmap != null && (n11 = this.H) == 0) {
            n11 = 2;
            if (n10 != 0 || (n10 = this.n) >= n11) {
                boolean bl2;
                Bitmap bitmap2 = this.i;
                if (bitmap2 == bitmap && (n10 = this.n) == n11) {
                    return;
                }
                this.i = bitmap;
                this.n = n11;
                this.o = bl2 = true;
                this.I = bl2;
            }
        }
    }

    public void a(Drawable drawable2, boolean n10) {
        int n11;
        if (drawable2 != null && (n11 = this.H) == 0) {
            n11 = 3;
            if (n10 != 0 || (n10 = this.n) >= n11) {
                boolean bl2;
                Drawable drawable3 = this.j;
                if (drawable3 == drawable2 && (n10 = this.n) >= n11) {
                    return;
                }
                this.j = drawable2;
                this.n = n11;
                this.o = bl2 = true;
                this.I = bl2;
            }
        }
    }

    public void a(String string2) {
        String string3;
        int n10;
        int n11 = this.H;
        if (n11 == 0 && ((n11 = this.e) != (n10 = 1) || (string3 = this.d) == null || (n11 = (int)(string3.equals(string2) ? 1 : 0)) == 0)) {
            this.d = string2;
            this.e = n10;
            this.g = n10;
            this.I = n10;
        }
    }

    public void a(String string2, boolean n10) {
        int n11;
        if (string2 != null && (n11 = string2.length()) != 0 && (n11 = (int)(this.H ? 1 : 0)) == 0) {
            n11 = 4;
            if (n10 != 0 || (n10 = this.n) >= n11) {
                boolean bl2;
                String string3 = this.k;
                if (string3 != null && (n10 = (int)(string3.equals(string2) ? 1 : 0)) != 0 && (n10 = this.n) == n11) {
                    return;
                }
                this.k = string2;
                this.n = n11;
                this.o = bl2 = true;
                this.I = bl2;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Bitmap b() {
        synchronized (this) {
            Bitmap bitmap;
            int n10;
            int n11 = this.I;
            if (n11 == 0) return this.a;
            this.H = n11 = 1;
            this.c();
            String string2 = this.f;
            if (string2 == null) {
                String string3 = "content can not be null,please set url or uri before generate qrcode!";
                Error error = new Error(string3);
                throw error;
            }
            this.d();
            Bitmap bitmap2 = this.i;
            if (bitmap2 != null) {
                n11 = bitmap2.getWidth();
                if (n11 >= (n10 = this.D)) {
                    Bitmap bitmap3 = this.i;
                    n10 = bitmap3.getWidth();
                }
                this.w = n10;
                Bitmap bitmap4 = this.i;
                n11 = bitmap4.getHeight();
                n10 = this.E;
                if (n11 >= n10) {
                    Bitmap bitmap5 = this.i;
                    n10 = bitmap5.getHeight();
                }
                this.x = n10;
            }
            n11 = this.w;
            n10 = this.x;
            Bitmap bitmap6 = this.i;
            bitmap6 = bitmap6 == null ? Bitmap.Config.ARGB_8888 : bitmap6.getConfig();
            Bitmap bitmap7 = this.a = (bitmap = Bitmap.createBitmap((int)n11, (int)n10, (Bitmap.Config)bitmap6));
            Canvas canvas = new Canvas(bitmap7);
            this.a(canvas);
            this.b(canvas);
            n11 = 0;
            Object var2_12 = null;
            this.H = false;
            this.I = false;
            return this.a;
        }
    }

    public void b(int n10) {
        int n11;
        if (n10 > 0 && (n11 = this.H) == 0) {
            n11 = this.p;
            int n12 = 1;
            if (n11 == n10 && (n11 = this.u) == n12) {
                return;
            }
            this.p = n10;
            this.u = n12;
            this.v = n12;
            this.I = n12;
        }
    }

    public void b(Bitmap bitmap, boolean n10) {
        int n11;
        if (bitmap != null && (n11 = this.H) == 0) {
            n11 = 2;
            if (n10 != 0 || (n10 = this.u) >= n11) {
                boolean bl2;
                Bitmap bitmap2 = this.q;
                if (bitmap2 == bitmap && (n10 = this.u) == n11) {
                    return;
                }
                this.q = bitmap;
                this.u = n11;
                this.v = bl2 = true;
                this.I = bl2;
            }
        }
    }

    public void b(Drawable drawable2, boolean n10) {
        int n11;
        if (drawable2 != null && (n11 = this.H) == 0) {
            n11 = 3;
            if (n10 != 0 || (n10 = this.u) >= n11) {
                boolean bl2;
                Drawable drawable3 = this.r;
                if (drawable3 == drawable2 && (n10 = this.u) == n11) {
                    return;
                }
                this.r = drawable2;
                this.u = n11;
                this.v = bl2 = true;
                this.I = bl2;
            }
        }
    }

    public void b(String string2) {
        String string3;
        int n10;
        int n11 = this.H;
        if (n11 == 0 && ((n11 = this.e) != (n10 = 2) || (string3 = this.f) == null || (n11 = (int)(string3.equals(string2) ? 1 : 0)) == 0)) {
            boolean bl2;
            this.f = string2;
            this.e = n10;
            this.g = bl2 = true;
            this.I = bl2;
        }
    }

    public void b(String string2, boolean n10) {
        int n11;
        if (string2 != null && (n11 = string2.length()) != 0 && (n11 = (int)(this.H ? 1 : 0)) == 0) {
            n11 = 5;
            if (n10 != 0 || (n10 = this.n) >= n11) {
                boolean bl2;
                String string3 = this.l;
                if (string3 != null && (n10 = (int)(string3.equals(string2) ? 1 : 0)) != 0 && (n10 = this.n) == n11) {
                    return;
                }
                this.l = string2;
                this.n = n11;
                this.o = bl2 = true;
                this.I = bl2;
            }
        }
    }

    public void c(int n10) {
        int n11 = n10 >>> 24;
        if (n11 == 0) {
            n11 = -16777216;
            n10 |= n11;
        }
        if ((n11 = (int)(this.H ? 1 : 0)) == 0 && (n11 = this.F) != n10) {
            this.F = n10;
            n10 = 1;
            this.I = n10;
        }
    }

    public void c(String string2, boolean n10) {
        int n11;
        if (string2 != null && (n11 = string2.length()) != 0 && (n11 = (int)(this.H ? 1 : 0)) == 0) {
            n11 = 4;
            if (n10 != 0 || (n10 = this.u) >= n11) {
                boolean bl2;
                String string3 = this.s;
                if (string3 != null && (n10 = (int)(string3.equals(string2) ? 1 : 0)) != 0 && (n10 = this.u) == n11) {
                    return;
                }
                this.s = string2;
                this.u = n11;
                this.v = bl2 = true;
                this.I = bl2;
            }
        }
    }

    public void d(String string2, boolean n10) {
        int n11;
        if (string2 != null && (n11 = string2.length()) != 0 && (n11 = (int)(this.H ? 1 : 0)) == 0) {
            n11 = 5;
            if (n10 != 0 || (n10 = this.u) >= n11) {
                boolean bl2;
                String string3 = this.t;
                if (string3 != null && (n10 = (int)(string3.equals(string2) ? 1 : 0)) != 0 && (n10 = this.u) == n11) {
                    return;
                }
                this.t = string2;
                this.u = n11;
                this.v = bl2 = true;
                this.I = bl2;
            }
        }
    }
}

