/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Matrix
 *  android.graphics.SurfaceTexture
 *  android.os.AsyncTask
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.Surface
 *  android.view.TextureView
 *  android.view.TextureView$SurfaceTextureListener
 */
package com.tencent.liteav.renderer;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.module.a;
import com.tencent.liteav.basic.opengl.o;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.renderer.d;
import com.tencent.liteav.renderer.e$1;
import com.tencent.liteav.renderer.e$2;
import com.tencent.liteav.renderer.e$3;
import com.tencent.liteav.renderer.e$a;
import com.tencent.liteav.renderer.f;
import com.tencent.liteav.renderer.h;
import java.lang.ref.WeakReference;

public class e
extends a
implements TextureView.SurfaceTextureListener {
    private static final float[] a;
    private long A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private e$a F;
    private SurfaceTexture b;
    private int c = 800;
    public TextureView d;
    public d e;
    public int f = 0;
    public int g = 0;
    public int h = 0;
    public int i = 0;
    public int j = 0;
    public int k = 0;
    public volatile int l = -1;
    public int m = 0;
    public int n = 0;
    public f o;
    public WeakReference p;
    private com.tencent.liteav.basic.opengl.f q;
    private h r;
    private Surface s;
    private int t = 0;
    private int u;
    private int[] v;
    private int w;
    private long x;
    private long y;
    private long z;

    static {
        float[] fArray;
        float[] fArray2 = fArray = new float[16];
        float[] fArray3 = fArray;
        fArray2[0] = 1.0f;
        fArray3[1] = 0.0f;
        fArray2[2] = 0.0f;
        fArray3[3] = 0.0f;
        fArray2[4] = 0.0f;
        fArray3[5] = -1.0f;
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
        a = fArray;
    }

    public e() {
        long l10;
        Object object = new int[5];
        this.v = object;
        this.w = 500;
        this.x = l10 = 0L;
        this.y = l10;
        this.z = l10;
        this.A = l10;
        this.B = false;
        this.C = false;
        this.E = false;
        object = new e$a;
        this.F = object;
        this.D = false;
    }

    private long a(long l10) {
        long l11 = TXCTimeUtil.getTimeTick();
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            return 0L;
        }
        return l11 - l10;
    }

    private Bitmap a(Bitmap bitmap, int n10, int n11) {
        float f10 = n11;
        float f11 = n10;
        float f12 = f10 / f11;
        int n12 = bitmap.getHeight();
        float f13 = n12;
        int n13 = bitmap.getWidth();
        float f14 = n13;
        float f15 = f12 - (f13 /= f14);
        Object object = f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1);
        if (object > 0) {
            n11 = bitmap.getWidth();
            f10 = n11;
            f11 /= f10;
        } else {
            n10 = bitmap.getHeight();
            f11 = n10;
            f11 = f10 / f11;
        }
        Matrix matrix = new Matrix();
        matrix.preScale(f11, f11);
        int n14 = bitmap.getWidth();
        int n15 = bitmap.getHeight();
        Bitmap bitmap2 = Bitmap.createBitmap((Bitmap)bitmap, (int)0, (int)0, (int)n14, (int)n15, (Matrix)matrix, (boolean)false);
        bitmap.recycle();
        return bitmap2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private Bitmap a(Matrix matrix, Bitmap bitmap, int n10, int n11) {
        Bitmap bitmap2;
        int n12;
        int n13;
        int n14;
        e e10 = this;
        int n15 = n10;
        int n16 = n11;
        int n17 = this.t;
        int n18 = this.k;
        n17 = (n17 + n18) % 360;
        n17 = 360 - n17;
        int n19 = bitmap.getWidth();
        int n20 = bitmap.getHeight();
        float f10 = 0.0f;
        Matrix matrix2 = null;
        int n21 = 0;
        boolean bl2 = true;
        Bitmap bitmap3 = bitmap;
        bitmap3 = Bitmap.createBitmap((Bitmap)bitmap, (int)0, (int)0, (int)n19, (int)n20, (Matrix)matrix, (boolean)bl2);
        bitmap.recycle();
        if (n17 != 0) {
            matrix2 = new Matrix();
            float f11 = n17;
            matrix2.setRotate(f11);
            n14 = 0;
            n13 = 0;
            int n22 = bitmap3.getWidth();
            n12 = bitmap3.getHeight();
            bitmap2 = Bitmap.createBitmap((Bitmap)bitmap3, (int)0, (int)0, (int)n22, (int)n12, (Matrix)matrix2, (boolean)false);
            bitmap3.recycle();
        } else {
            bitmap2 = bitmap3;
        }
        n18 = e10.u;
        if (n18 == 0) {
            n20 = bitmap2.getWidth();
            int n23 = bitmap2.getHeight();
            n18 = 1;
            float f12 = Float.MIN_VALUE;
            f10 = 0.0f;
            matrix2 = null;
            n21 = n15 < n16 ? n18 : 0;
            if (n20 >= n23) {
                n18 = 0;
                bitmap3 = null;
                f12 = 0.0f;
            }
            if (n21 != n18) {
                n18 = 0x3F000000;
                f12 = 0.5f;
                if (n21 != 0) {
                    f10 = n23;
                    float f13 = n15;
                    f10 *= f13;
                    float f14 = n16;
                    f10 /= f14;
                    f14 = ((float)n20 - f10) * f12;
                    Matrix matrix3 = new Matrix();
                    matrix3.preScale(f13 /= f10, f13);
                    n21 = (int)f14;
                    n19 = 0;
                    n20 = (int)f10;
                    matrix2 = bitmap2;
                    Bitmap bitmap4 = Bitmap.createBitmap((Bitmap)bitmap2, (int)n21, (int)0, (int)n20, (int)n23, (Matrix)matrix3, (boolean)false);
                    bitmap2.recycle();
                    return bitmap4;
                }
                f10 = n20;
                float f15 = n15;
                f10 /= f15;
                f15 = n16;
                float f16 = ((float)n23 - (f10 *= f15)) * f12;
                Matrix matrix4 = new Matrix();
                matrix4.preScale(f15 /= f10, f15);
                n21 = 0;
                n19 = (int)f16;
                n23 = (int)f10;
                matrix2 = bitmap2;
                Bitmap bitmap5 = Bitmap.createBitmap((Bitmap)bitmap2, (int)0, (int)n19, (int)n20, (int)n23, null, (boolean)false);
                bl2 = false;
                Object var27_30 = null;
                n14 = bitmap5.getWidth();
                n13 = bitmap5.getHeight();
                n12 = 0;
                Bitmap bitmap6 = Bitmap.createBitmap((Bitmap)bitmap5, (int)0, (int)0, (int)n14, (int)n13, (Matrix)matrix4, (boolean)false);
                bitmap5.recycle();
                return bitmap6;
            }
            n18 = bitmap2.getWidth();
            if (n15 == n18) return bitmap2;
            n18 = bitmap2.getHeight();
            if (n16 == n18) return bitmap2;
            return e10.a(bitmap2, n15, n16);
        }
        n18 = bitmap2.getWidth();
        if (n15 == n18) return bitmap2;
        n18 = bitmap2.getHeight();
        if (n16 == n18) return bitmap2;
        return e10.a(bitmap2, n15, n16);
    }

    public static /* synthetic */ Bitmap a(e e10, Matrix matrix, Bitmap bitmap, int n10, int n11) {
        return e10.a(matrix, bitmap, n10, n11);
    }

    public static /* synthetic */ com.tencent.liteav.basic.opengl.f a(e e10) {
        return e10.q;
    }

    private int[] a(int n10, int n11, int n12, float[] object, boolean n13) {
        int n14;
        Object object2;
        int n15;
        Object object3 = this.r;
        if (object3 != null && (n15 = ((h)object3).a()) != n13) {
            this.r.c();
            n15 = 0;
            object3 = null;
            this.r = null;
        }
        if ((object3 = this.r) == null) {
            object2 = n13 != 0;
            this.r = object3 = new h((Boolean)object2);
            ((h)object3).b();
        }
        if (object != null) {
            object3 = this.r;
            ((h)object3).a((float[])object);
        } else {
            object = this.r;
            object3 = a;
            ((h)object).a((float[])object3);
        }
        int n16 = this.m;
        n15 = this.n;
        int n17 = this.u;
        if (n17 == 0) {
            object2 = this.r;
            n14 = com.tencent.liteav.renderer.h.a;
            ((h)object2).a(n14);
        } else {
            object2 = this.r;
            n14 = com.tencent.liteav.renderer.h.b;
            ((h)object2).a(n14);
        }
        n17 = this.t;
        n14 = this.k;
        int n18 = (n17 + n14) % 360;
        if (n13 != 0 && (n17 == (n13 = 90) || n17 == (n13 = 270))) {
            n17 = n17 + n14 + 180;
            n18 = n17 % 360;
        }
        this.r.b(n18);
        this.r.b(n11, n12);
        this.r.a(n16, n15);
        int[] nArray = new int[]{n10 = this.r.d(n10), n16, n15};
        return nArray;
    }

    private void b() {
        int n10;
        Long l10;
        Object object;
        Object object2;
        int n11;
        long l11;
        int n12;
        Object object3;
        Object object4;
        int n13 = this.D;
        String string2 = "TXCVideoRender";
        long l12 = 0L;
        if (n13 == 0) {
            object4 = new Bundle();
            object3 = this.getID();
            object4.putString("EVT_USERID", (String)object3);
            n12 = 2003;
            object4.putInt("EVT_ID", n12);
            l11 = TXCTimeUtil.getTimeTick();
            object4.putLong("EVT_TIME", l11);
            l11 = TXCTimeUtil.getUtcTimeTick();
            object4.putLong("EVT_UTC_TIME", l11);
            object4.putCharSequence("EVT_MSG", (CharSequence)"Render the first video frame(IDR)");
            n11 = this.h;
            object4.putInt("EVT_PARAM1", n11);
            n11 = this.i;
            object4.putInt("EVT_PARAM2", n11);
            com.tencent.liteav.basic.util.g.a(this.p, n12, (Bundle)object4);
            n11 = this.j;
            long l13 = TXCTimeUtil.getTimeTick();
            object2 = l13;
            this.setStatusValue(6001, n11, object2);
            n11 = this.j;
            object2 = this.h;
            this.setStatusValue(17021, n11, object2);
            n11 = this.j;
            object2 = this.i;
            this.setStatusValue(17022, n11, object2);
            object4 = new StringBuilder();
            ((StringBuilder)object4).append("[FirstFramePath][Video][Render] TXCVideoRender: render first video frame. instance:");
            n11 = this.hashCode();
            ((StringBuilder)object4).append(n11);
            ((StringBuilder)object4).append(" id:");
            object3 = this.getID();
            ((StringBuilder)object4).append((String)object3);
            ((StringBuilder)object4).append(" type:");
            n11 = this.j;
            ((StringBuilder)object4).append(n11);
            object4 = ((StringBuilder)object4).toString();
            TXCLog.i(string2, (String)object4);
            n13 = 1;
            this.D = n13;
            object3 = new Object[3];
            object2 = this.hashCode();
            object = 0;
            l10 = null;
            object3[0] = object2;
            object3[n13] = object2 = this.getID();
            n13 = this.j;
            object4 = n13;
            n12 = 2;
            object3[n12] = object4;
            object4 = String.format("Remote-VideoRender[%d]: Render first frame [tinyID:%s][streamType:%d]", object3);
            object3 = "streamType: 2-big, 3-small, 7-sub";
            Monitor.a(n12, (String)object4, (String)object3, 0);
            object4 = this.getID();
            n11 = 40022;
            n12 = this.j;
            TXCKeyPointReportProxy.a((String)object4, n11, l12, n12);
        }
        object4 = this.F;
        long l14 = ((e$a)object4).c;
        l11 = 1L;
        ((e$a)object4).c = l14 += l11;
        this.n();
        object4 = this.F;
        l14 = ((e$a)object4).d;
        long l15 = l14 == l12 ? 0 : (l14 < l12 ? -1 : 1);
        if (l15 != false) {
            long l16;
            Object object5;
            long l17;
            ((e$a)object4).j = l14 = this.a(l14);
            object4 = this.F;
            l14 = ((e$a)object4).k;
            long l18 = ((e$a)object4).j;
            ((e$a)object4).k = l14 += l18;
            l14 = 200L;
            long l19 = l18 - l14;
            n11 = (int)(l19 == 0L ? 0 : (l19 < 0L ? -1 : 1));
            if (n11 > 0) {
                ((e$a)object4).e = l14 = ((e$a)object4).e + l11;
                n13 = 6021;
                l15 = this.j;
                object3 = l14;
                this.setStatusValue(n13, (int)l15, object3);
            }
            object4 = this.F;
            l14 = ((e$a)object4).j;
            l15 = this.w;
            l18 = l15;
            n11 = (int)(l14 == l18 ? 0 : (l14 < l18 ? -1 : 1));
            object2 = " block time:";
            String string3 = "render frame count:";
            if (n11 > 0) {
                ((e$a)object4).f = l17 = ((e$a)object4).f + l11;
                n13 = 6003;
                n11 = this.j;
                object5 = l17;
                this.setStatusValue(n13, n11, object5);
                object4 = this.F;
                l17 = ((e$a)object4).j;
                l16 = ((e$a)object4).i;
                n11 = (int)(l17 == l16 ? 0 : (l17 < l16 ? -1 : 1));
                if (n11 > 0) {
                    ((e$a)object4).i = l17;
                    n13 = 6005;
                    n11 = this.j;
                    object5 = l17;
                    this.setStatusValue(n13, n11, object5);
                }
                object4 = new StringBuilder();
                ((StringBuilder)object4).append(string3);
                l17 = this.F.c;
                ((StringBuilder)object4).append(l17);
                ((StringBuilder)object4).append((String)object2);
                l17 = this.F.j;
                ((StringBuilder)object4).append(l17);
                object3 = "> 500";
                ((StringBuilder)object4).append((String)object3);
                object4 = ((StringBuilder)object4).toString();
                TXCLog.w(string2, (String)object4);
            }
            object4 = this.F;
            l17 = ((e$a)object4).j;
            l16 = this.c;
            long l20 = l17 - l16;
            n13 = (int)(l20 == 0L ? 0 : (l20 < 0L ? -1 : 1));
            if (n13 > 0) {
                this.x = l16 = this.x + l11;
                this.z = l16 = this.z + l17;
                object4 = new StringBuilder();
                ((StringBuilder)object4).append(string3);
                l17 = this.F.c;
                ((StringBuilder)object4).append(l17);
                ((StringBuilder)object4).append((String)object2);
                l17 = this.F.j;
                ((StringBuilder)object4).append(l17);
                ((StringBuilder)object4).append("> ");
                n11 = this.c;
                ((StringBuilder)object4).append(n11);
                object4 = ((StringBuilder)object4).toString();
                TXCLog.w(string2, (String)object4);
                object5 = this.p;
                String string4 = this.getID();
                int n14 = 2105;
                object4 = new StringBuilder();
                ((StringBuilder)object4).append("Current video playback stuck for ");
                long l21 = this.F.j;
                ((StringBuilder)object4).append(l21);
                object3 = "ms";
                ((StringBuilder)object4).append((String)object3);
                String string5 = ((StringBuilder)object4).toString();
                long l22 = this.F.j;
                com.tencent.liteav.basic.util.g.a((WeakReference)object5, string4, n14, string5, l22);
                object4 = this.F;
                l17 = ((e$a)object4).h;
                l16 = ((e$a)object4).j;
                ((e$a)object4).h = l17 += l16;
                n13 = 6006;
                n11 = this.j;
                object5 = l17;
                this.setStatusValue(n13, n11, object5);
            }
            object4 = this.F;
            l17 = ((e$a)object4).j;
            l16 = 1000L;
            long l23 = l17 - l16;
            n11 = (int)(l23 == 0L ? 0 : (l23 < 0L ? -1 : 1));
            if (n11 > 0) {
                ((e$a)object4).g = l17 = ((e$a)object4).g + l11;
                n13 = 6004;
                n11 = this.j;
                l10 = l17;
                this.setStatusValue(n13, n11, l10);
                object4 = new StringBuilder();
                ((StringBuilder)object4).append(string3);
                l11 = this.F.c;
                ((StringBuilder)object4).append(l11);
                ((StringBuilder)object4).append((String)object2);
                l14 = this.F.j;
                ((StringBuilder)object4).append(l14);
                object3 = "> 1000";
                ((StringBuilder)object4).append((String)object3);
                object4 = ((StringBuilder)object4).toString();
                TXCLog.w(string2, (String)object4);
            }
        }
        long l24 = TXCTimeUtil.getTimeTick();
        l14 = this.y;
        long l25 = l14 - l12;
        object = l25 == 0L ? 0 : (l25 < 0L ? -1 : 1);
        if (object == false) {
            this.y = l24;
        } else {
            l11 = 2000L;
            long l26 = (l14 = l24 - l14) - l11;
            n11 = (int)(l26 == 0L ? 0 : (l26 < 0L ? -1 : 1));
            if (n11 >= 0) {
                n12 = this.j;
                l10 = this.x;
                this.setStatusValue(17015, n12, l10);
                n12 = this.j;
                l11 = this.z;
                l10 = l11;
                this.setStatusValue(17016, n12, l10);
                l14 = this.A;
                n11 = (int)(l14 == l12 ? 0 : (l14 < l12 ? -1 : 1));
                if (n11 != 0) {
                    object3 = this.getID();
                    l11 = (int)this.z;
                    l15 = this.j;
                    TXCKeyPointReportProxy.a((String)object3, 40005, l11, (int)l15);
                    object3 = this.getID();
                    l11 = this.y;
                    object = (int)(l24 - l11);
                    l11 = object;
                    l15 = this.j;
                    TXCKeyPointReportProxy.a((String)object3, 40006, l11, (int)l15);
                    n11 = 6020;
                    n12 = this.j;
                    l11 = this.F.k;
                    l10 = l11;
                    this.setStatusValue(n11, n12, l10);
                }
                this.x = l12;
                this.y = l24;
                this.z = l12;
            }
        }
        object4 = this.F;
        ((e$a)object4).d = l14 = TXCTimeUtil.getTimeTick();
        l24 = this.A;
        n13 = l24 == l12 ? 0 : (l24 < l12 ? -1 : 1);
        if (n13 == 0) {
            object4 = this.F;
            this.A = l24 = ((e$a)object4).d;
        }
        object4 = this.F;
        ((e$a)object4).m = n10 = this.i;
        ((e$a)object4).l = n10 = this.h;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b(Surface object) {
        CharSequence charSequence = new StringBuilder();
        Object object2 = "surface-render: set surface ";
        ((StringBuilder)charSequence).append((String)object2);
        ((StringBuilder)charSequence).append(object);
        charSequence = ((StringBuilder)charSequence).toString();
        TXCLog.i("TXCVideoRender", (String)charSequence);
        Surface surface = this.s;
        if (surface == object) {
            TXCLog.i("TXCVideoRender", "surface-render: set the same surface, ignore ");
            return;
        }
        this.s = object;
        this.l = 1;
        surface = null;
        if (object != null) {
            charSequence = "TXCVideoRender";
            object2 = new StringBuilder();
            String string2 = "surface-render: set surface start render thread ";
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(object);
            object = ((StringBuilder)object2).toString();
            TXCLog.i((String)charSequence, (String)object);
            this.c(null);
            return;
        }
        synchronized (this) {
            object = this.q;
            if (object == null) return;
            object = "TXCVideoRender";
            charSequence = new StringBuilder();
            object2 = "surface-render: set surface stop render thread ";
            ((StringBuilder)charSequence).append((String)object2);
            object2 = this.q;
            ((StringBuilder)charSequence).append(object2);
            charSequence = ((StringBuilder)charSequence).toString();
            TXCLog.i((String)object, (String)charSequence);
            object = this.q;
            ((com.tencent.liteav.basic.opengl.f)object).a();
            this.q = null;
            return;
        }
    }

    private void b(TextureView object) {
        int n10;
        Object object2;
        int n11 = 0;
        Object object3 = null;
        if (object != null) {
            this.l = 0;
        }
        if ((object2 = this.d) == null && object != null || object2 != null && (n10 = object2.equals(object)) == 0) {
            n11 = 1;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("play:vrender: set video view @old=");
        Object object4 = this.d;
        ((StringBuilder)object2).append(object4);
        ((StringBuilder)object2).append(",new=");
        ((StringBuilder)object2).append(object);
        ((StringBuilder)object2).append("id ");
        object4 = this.getID();
        ((StringBuilder)object2).append((String)object4);
        ((StringBuilder)object2).append("_");
        int n12 = this.j;
        ((StringBuilder)object2).append(n12);
        object2 = ((StringBuilder)object2).toString();
        object4 = "TXCVideoRender";
        TXCLog.w((String)object4, (String)object2);
        if (n11 != 0) {
            object3 = this.d;
            if (object3 != null && (object2 = this.b) == null) {
                object3 = object3.getSurfaceTexture();
                this.b((SurfaceTexture)object3);
                object3 = this.d;
                n10 = 0;
                object2 = null;
                object3.setSurfaceTextureListener(null);
            }
            this.d = object;
            if (object != null) {
                int n13 = object.getWidth();
                if (n13 != 0) {
                    object = this.d;
                    this.f = n13 = object.getWidth();
                }
                if ((n13 = (object = this.d).getHeight()) != 0) {
                    object = this.d;
                    this.g = n13 = object.getHeight();
                }
                object3 = this.d;
                object = new d((TextureView)object3);
                this.e = object;
                n11 = this.h;
                n10 = this.i;
                ((d)object).b(n11, n10);
                object = this.e;
                n11 = this.f;
                n10 = this.g;
                ((d)object).a(n11, n10);
                object = this.e;
                n11 = this.u;
                ((d)object).a(n11);
                object = this.e;
                n11 = this.t;
                n10 = this.k;
                n11 = (n11 + n10) % 360;
                ((d)object).c(n11);
                this.d.setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
                object = this.b;
                if (object != null) {
                    n13 = Build.VERSION.SDK_INT;
                    n11 = 16;
                    if (n13 >= n11 && (object = this.d.getSurfaceTexture()) != (object3 = this.b)) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("play:vrender: setSurfaceTexture ");
                        object3 = this.d;
                        ((StringBuilder)object).append(object3);
                        ((StringBuilder)object).append(", surfaceTexture ");
                        object3 = this.b;
                        ((StringBuilder)object).append(object3);
                        object = ((StringBuilder)object).toString();
                        TXCLog.w((String)object4, (String)object);
                        object = this.d;
                        object3 = this.b;
                        try {
                            object.setSurfaceTexture((SurfaceTexture)object3);
                        }
                        catch (Exception exception) {
                            object3 = new StringBuilder();
                            object2 = "setSurfaceTexture error ";
                            ((StringBuilder)object3).append((String)object2);
                            ((StringBuilder)object3).append(exception);
                            String string2 = ((StringBuilder)object3).toString();
                            TXCLog.e((String)object4, string2);
                        }
                    } else {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("play:vrender: not setSurfaceTexture old surfaceTexture ");
                        object3 = this.d.getSurfaceTexture();
                        ((StringBuilder)object).append(object3);
                        ((StringBuilder)object).append(", new surfaceTexture ");
                        object3 = this.b;
                        ((StringBuilder)object).append(object3);
                        object = ((StringBuilder)object).toString();
                        TXCLog.w((String)object4, (String)object);
                    }
                } else {
                    object = this.d;
                    n13 = (int)(object.isAvailable() ? 1 : 0);
                    if (n13 != 0) {
                        object = this.d.getSurfaceTexture();
                        this.a((SurfaceTexture)object);
                    }
                }
            }
        }
    }

    public static /* synthetic */ int[] b(e e10) {
        return e10.v;
    }

    public SurfaceTexture a() {
        return null;
    }

    public void a(int n10) {
        this.j = n10;
    }

    public void a(int n10, int n11) {
        int n12;
        int n13 = this.h;
        if (!(n13 == n10 && (n12 = this.i) == n11 || n13 == n10 && (n13 = this.i) == n11)) {
            this.h = n10;
            this.i = n11;
            d d10 = this.e;
            if (d10 != null) {
                d10.b(n10, n11);
            }
        }
    }

    public void a(int n10, int n11, int n12, boolean bl2, int n13) {
        this.a(n11, n12);
    }

    public void a(SurfaceTexture surfaceTexture) {
        this.B = true;
    }

    public void a(Surface surface) {
        this.b(surface);
    }

    public void a(TextureView textureView) {
        this.b(textureView);
    }

    public void a(b b10) {
        WeakReference<b> weakReference;
        this.p = weakReference = new WeakReference<b>(b10);
    }

    public void a(o o10) {
        TextureView textureView = this.d;
        Runnable runnable = null;
        if (textureView != null) {
            Bitmap bitmap;
            Object object;
            try {
                bitmap = object = textureView.getBitmap();
            }
            catch (OutOfMemoryError outOfMemoryError) {
                bitmap = null;
            }
            if (bitmap != null) {
                e$1 e$1;
                Matrix matrix = textureView.getTransform(null);
                runnable = e$1;
                object = this;
                e$1 = new e$1(this, matrix, bitmap, textureView, o10);
                AsyncTask.execute((Runnable)e$1);
            }
        } else {
            com.tencent.liteav.basic.opengl.f f10 = this.q;
            if (f10 != null) {
                runnable = new e$2(this, o10);
                f10.a(runnable);
            } else if (o10 != null) {
                o10.a(null);
            }
        }
    }

    public void a(TXSVideoFrame tXSVideoFrame, int n10, int n11, int n12) {
        int n13 = this.k;
        if (n12 != n13) {
            this.k = n12;
            n13 = this.t;
            this.e(n13);
        }
        this.a(n10, n11);
        this.b();
    }

    public void a(f f10) {
        this.o = f10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(Object object, int n10, float[] fArray, boolean bl2) {
        e e10 = this;
        int n11 = this.l;
        int n12 = 1;
        if (n11 != n12) return;
        int n13 = this.h;
        int n14 = this.i;
        Object object2 = this;
        int n15 = n10;
        Object object3 = fArray;
        Object object4 = this.a(n10, n13, n14, fArray, bl2);
        int n16 = 0;
        object2 = null;
        int n17 = object4[0];
        int n18 = object4[n12];
        n15 = 2;
        int n19 = object4[n15];
        Object object5 = this.v;
        n13 = 3;
        System.arraycopy(object4, 0, object5, 0, n13);
        n11 = 4;
        if (bl2) {
            object2 = this.v;
            object2[n13] = n12;
            n15 = 180;
            object2[n11] = n15;
        } else {
            object5 = this.v;
            object5[n13] = 0;
            object5[n11] = 0;
        }
        synchronized (this) {
            object4 = e10.s;
            n16 = 0;
            object2 = null;
            if (object4 != null) {
                Object object6;
                object5 = e10.q;
                if (object5 != null && ((object5 = ((com.tencent.liteav.basic.opengl.f)object5).b()) != object4 || object5 != null && (n13 = (int)(object5.isValid() ? 1 : 0)) == 0)) {
                    object6 = "TXCVideoRender";
                    StringBuilder stringBuilder = new StringBuilder();
                    object3 = "surface-render: onDrawTextureToSurface surface change stop render thread ";
                    stringBuilder.append((String)object3);
                    object3 = e10.q;
                    stringBuilder.append(object3);
                    object3 = ", ";
                    stringBuilder.append((String)object3);
                    stringBuilder.append(object5);
                    object5 = ", ";
                    stringBuilder.append((String)object5);
                    stringBuilder.append(object4);
                    object5 = stringBuilder.toString();
                    TXCLog.i((String)object6, (String)object5);
                    object5 = e10.q;
                    ((com.tencent.liteav.basic.opengl.f)object5).a();
                    e10.q = null;
                }
                if ((object2 = e10.q) == null && (n16 = e10.l) == n12 && (n16 = (int)(object4.isValid() ? 1 : 0)) != 0) {
                    e10.q = object2 = new com.tencent.liteav.basic.opengl.f();
                    object2 = "TXCVideoRender";
                    object5 = new StringBuilder();
                    object6 = "surface-render: onDrawTextureToSurface start render thread ";
                    ((StringBuilder)object5).append((String)object6);
                    object6 = e10.q;
                    ((StringBuilder)object5).append(object6);
                    object6 = ",";
                    ((StringBuilder)object5).append((String)object6);
                    ((StringBuilder)object5).append(object4);
                    object5 = ((StringBuilder)object5).toString();
                    TXCLog.i((String)object2, (String)object5);
                    object2 = e10.q;
                    object5 = object;
                    ((com.tencent.liteav.basic.opengl.f)object2).a(object, (Surface)object4);
                }
                if ((object4 = (Object)e10.q) == null) return;
                n11 = e10.l;
                if (n11 != n12) return;
                if (bl2) {
                    com.tencent.liteav.basic.opengl.f f10 = e10.q;
                    boolean bl3 = true;
                    int n20 = 180;
                    int n21 = e10.m;
                    int n22 = e10.n;
                    f10.a(n17, bl3, n20, n21, n22, n18, n19, false, false);
                } else {
                    com.tencent.liteav.basic.opengl.f f11 = e10.q;
                    boolean bl4 = false;
                    boolean bl5 = false;
                    int n23 = e10.m;
                    int n24 = e10.n;
                    f11.a(n17, false, 0, n23, n24, n18, n19, false, false);
                }
            } else {
                object4 = e10.q;
                if (object4 == null) return;
                object4 = "TXCVideoRender";
                object5 = new StringBuilder();
                Object object7 = "surface-render: onDrawTextureToSurface stop render thread ";
                ((StringBuilder)object5).append((String)object7);
                object7 = e10.q;
                ((StringBuilder)object5).append(object7);
                object5 = ((StringBuilder)object5).toString();
                TXCLog.i((String)object4, (String)object5);
                object4 = e10.q;
                ((com.tencent.liteav.basic.opengl.f)object4).a();
                e10.q = null;
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(boolean bl2) {
        CharSequence charSequence;
        boolean bl3 = this.C;
        int n10 = 1;
        if (bl3) {
            Object object;
            charSequence = "Remote-VideoRender[%d]: Stop [tinyID:%s][streamType:%d][stopRendThread:%s]";
            int n11 = 4;
            Object object2 = new Object[n11];
            object2[0] = object = Integer.valueOf(this.hashCode());
            object2[n10] = object = this.getID();
            object = this.j;
            int n12 = 2;
            object2[n12] = object;
            int n13 = 3;
            String string2 = bl2 ? "true" : "false";
            object2[n13] = string2;
            charSequence = String.format((String)charSequence, object2);
            object2 = "streamType: 2-big, 3-small, 7-sub";
            Monitor.a(n12, (String)charSequence, (String)object2, 0);
        }
        this.C = false;
        this.D = false;
        this.E = false;
        if (!bl2) return;
        bl2 = this.l;
        if (bl2 != n10) return;
        bl2 = -1;
        this.l = (int)(bl2 ? 1 : 0);
        Object object = "TXCVideoRender";
        charSequence = "play:vrender: quit render thread when stop";
        TXCLog.w((String)object, (String)charSequence);
        this.d();
        synchronized (this) {
            object = this.q;
            if (object == null) return;
            object = "TXCVideoRender";
            charSequence = new StringBuilder();
            Object object3 = "surface-render:stop render thread ";
            ((StringBuilder)charSequence).append((String)object3);
            object3 = this.q;
            ((StringBuilder)charSequence).append(object3);
            charSequence = ((StringBuilder)charSequence).toString();
            TXCLog.i((String)object, (String)charSequence);
            object = this.q;
            ((com.tencent.liteav.basic.opengl.f)object).a();
            bl2 = false;
            object = null;
            this.q = null;
            return;
        }
    }

    public void b(int n10) {
        if (n10 > 0) {
            this.c = n10;
        }
    }

    public void b(SurfaceTexture surfaceTexture) {
        this.B = false;
    }

    public void c(int n10) {
        this.u = n10;
        d d10 = this.e;
        if (d10 != null) {
            d10.a(n10);
        }
    }

    public void c(int n10, int n11) {
        this.a(n10, n11);
    }

    public void c(Object object) {
    }

    public void d() {
    }

    public void d(int n10) {
        d d10 = this.e;
        if (d10 != null) {
            int n11 = 2;
            if (n10 == n11) {
                n10 = 0;
                d10.a(false);
            } else {
                n10 = 1;
                d10.a(n10 != 0);
            }
        }
    }

    public void d(int n10, int n11) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("surface-render: set setSurfaceSize ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append("*");
        ((StringBuilder)object).append(n11);
        object = ((StringBuilder)object).toString();
        Object object2 = "TXCVideoRender";
        TXCLog.i((String)object2, (String)object);
        int n12 = this.m;
        if (n10 != n12 || n11 != (n12 = this.n)) {
            int n13;
            object = this.q;
            if (object != null && (n12 = this.l) == (n13 = 1) && (object = (Object)this.v) != null) {
                object = this.q;
                object2 = new e$3(this, n10, n11);
                ((com.tencent.liteav.basic.opengl.f)object).a((Runnable)object2);
            } else {
                this.m = n10;
                this.n = n11;
            }
        }
    }

    public void e() {
        Object object;
        Object object2 = new Object[3];
        object2[0] = object = Integer.valueOf(this.hashCode());
        object = this.getID();
        int n10 = 1;
        object2[n10] = object;
        object = this.j;
        int n11 = 2;
        object2[n11] = object;
        object2 = String.format("Remote-VideoRender[%d]: Start [tinyID:%s] [streamType:%d]", object2);
        object = "streamType: 2-big, 3-small, 7-sub";
        Monitor.a(n11, (String)object2, (String)object, 0);
        this.C = n10;
        int n12 = Build.VERSION.SDK_INT;
        int n13 = 21;
        this.E = n12 >= n13 ? n10 : false;
        this.D = false;
        this.l();
    }

    public void e(int n10) {
        this.t = n10;
        d d10 = this.e;
        if (d10 != null) {
            int n11 = this.k;
            n10 = (n10 + n11) % 360;
            d10.c(n10);
        }
    }

    public int f() {
        TextureView textureView = this.d;
        if (textureView != null) {
            return textureView.getWidth();
        }
        textureView = this.s;
        if (textureView != null) {
            return this.m;
        }
        return 0;
    }

    public void f(int n10) {
        this.w = n10;
    }

    public int g() {
        TextureView textureView = this.d;
        if (textureView != null) {
            return textureView.getHeight();
        }
        textureView = this.s;
        if (textureView != null) {
            return this.n;
        }
        return 0;
    }

    public int h() {
        return this.h;
    }

    public int i() {
        return this.i;
    }

    public void j() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void k() {
        Object object;
        synchronized (this) {
            object = this.q;
            if (object != null) {
                object = "TXCVideoRender";
                CharSequence charSequence = new StringBuilder();
                Object object2 = "surface-render: onRenderThreadEGLDestroy stop render thread ";
                charSequence.append((String)object2);
                object2 = this.q;
                charSequence.append(object2);
                charSequence = charSequence.toString();
                TXCLog.i((String)object, (String)charSequence);
                object = this.q;
                ((com.tencent.liteav.basic.opengl.f)object).a();
                this.q = null;
            }
        }
        object = this.r;
        if (object != null) {
            ((h)object).c();
            this.r = null;
        }
    }

    public void l() {
        this.m();
        e$a e$a = this.F;
        long l10 = 0L;
        Long l11 = l10;
        e$a.b = l10;
        e$a.c = l10;
        e$a.e = l10;
        e$a.f = l10;
        e$a.g = l10;
        e$a.h = l10;
        e$a.i = l10;
        e$a.k = l10;
        this.A = l10;
        int n10 = this.j;
        this.setStatusValue(6001, n10, l11);
        n10 = this.j;
        this.setStatusValue(6003, n10, l11);
        n10 = this.j;
        this.setStatusValue(6005, n10, l11);
        n10 = this.j;
        this.setStatusValue(6006, n10, l11);
        n10 = this.j;
        this.setStatusValue(6004, n10, l11);
        n10 = this.j;
        this.setStatusValue(6020, n10, l11);
    }

    public void m() {
        long l10;
        e$a e$a = this.F;
        e$a.a = l10 = 0L;
        e$a.d = l10;
        e$a.j = l10;
        e$a.l = 0;
        e$a.m = 0;
        int n10 = this.j;
        Double d10 = 0.0;
        this.setStatusValue(6002, n10, d10);
    }

    public void n() {
        e$a e$a = this.F;
        long l10 = e$a.a;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            e$a.a = l10 = TXCTimeUtil.getTimeTick();
        } else {
            long l13 = TXCTimeUtil.getTimeTick();
            e$a e$a2 = this.F;
            l11 = e$a2.a;
            long l14 = (l13 -= l11) - (l11 = 950L);
            Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object2 >= 0) {
                l11 = e$a2.c;
                long l15 = e$a2.b;
                double d10 = (double)(l11 - l15) * 1000.0;
                double d11 = l13;
                d10 = d10 / d11;
                int n10 = 6002;
                int n11 = this.j;
                Double d12 = d10;
                this.setStatusValue(n10, n11, d12);
                String string2 = this.getID();
                n11 = 40001;
                int n12 = (int)d10;
                long l16 = n12;
                int n13 = this.j;
                TXCKeyPointReportProxy.a(string2, n11, l16, n13);
                e$a2 = this.F;
                e$a2.b = l11 = e$a2.c;
                e$a2.a = l11 = e$a2.a + l13;
            }
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int n10, int n11) {
        SurfaceTexture surfaceTexture2;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("play:vrender: texture available @");
        ((StringBuilder)object).append(surfaceTexture);
        ((StringBuilder)object).append("id ");
        String string2 = this.getID();
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append("_");
        int n12 = this.j;
        ((StringBuilder)object).append(n12);
        object = ((StringBuilder)object).toString();
        string2 = "TXCVideoRender";
        TXCLog.w(string2, (String)object);
        this.f = n10;
        this.g = n11;
        object = this.e;
        if (object != null) {
            ((d)object).a(n10, n11);
        }
        if ((surfaceTexture2 = this.b) != null) {
            int n13 = Build.VERSION.SDK_INT;
            n10 = 16;
            if (n13 >= n10 && (surfaceTexture = this.d.getSurfaceTexture()) != (surfaceTexture2 = this.b)) {
                surfaceTexture = this.d;
                surfaceTexture.setSurfaceTexture(surfaceTexture2);
            }
            n13 = 0;
            surfaceTexture = null;
            this.b = null;
        } else {
            this.a(surfaceTexture);
        }
        this.B = true;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        boolean bl2;
        block4: {
            Object object;
            String string2 = "TXCVideoRender";
            bl2 = false;
            try {
                long l10;
                this.B = false;
                object = new StringBuilder();
                String string3 = "play:vrender:  onSurfaceTextureDestroyed when need save texture : ";
                ((StringBuilder)object).append(string3);
                int n10 = this.E;
                ((StringBuilder)object).append(n10 != 0);
                string3 = "id ";
                ((StringBuilder)object).append(string3);
                string3 = this.getID();
                ((StringBuilder)object).append(string3);
                string3 = "_";
                ((StringBuilder)object).append(string3);
                n10 = this.j;
                ((StringBuilder)object).append(n10);
                object = ((StringBuilder)object).toString();
                TXCLog.w(string2, (String)object);
                boolean bl3 = this.E;
                if (bl3) {
                    this.b = surfaceTexture;
                    break block4;
                }
                object = this.F;
                ((e$a)object).a = l10 = 0L;
                this.b(surfaceTexture);
                object = this.b;
                if (surfaceTexture != object) break block4;
                surfaceTexture = null;
            }
            catch (Exception exception) {
                object = "onSurfaceTextureDestroyed failed.";
                TXCLog.e(string2, (String)object, exception);
                break block4;
            }
            {
                this.b = null;
            }
        }
        surfaceTexture = this.b;
        if (surfaceTexture != null) return bl2;
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture object, int n10, int n11) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("play:vrender: texture size change new:");
        charSequence.append(n10);
        String string2 = ",";
        charSequence.append(string2);
        charSequence.append(n11);
        String string3 = " old:";
        charSequence.append(string3);
        int n12 = this.f;
        charSequence.append(n12);
        charSequence.append(string2);
        int n13 = this.g;
        charSequence.append(n13);
        charSequence = charSequence.toString();
        string2 = "TXCVideoRender";
        TXCLog.w(string2, (String)charSequence);
        boolean bl2 = this.B;
        if (!bl2) {
            charSequence = "play:vrender: onSurfaceCreate on onSurfaceTextureSizeChanged when onSurfaceTextureAvailable is not trigger";
            TXCLog.w(string2, (String)charSequence);
            this.B = bl2 = true;
            this.a((SurfaceTexture)object);
        }
        this.f = n10;
        this.g = n11;
        object = this.e;
        if (object != null) {
            ((d)object).a(n10, n11);
        }
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}

