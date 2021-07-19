/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Matrix
 *  android.graphics.Matrix$ScaleToFit
 *  android.graphics.RectF
 *  android.graphics.SurfaceTexture
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.DisplayMetrics
 *  android.util.Size
 *  android.util.SparseArray
 *  android.view.Surface
 *  android.view.TextureView
 *  android.view.View$MeasureSpec
 *  android.view.WindowManager
 *  android.view.animation.AccelerateInterpolator
 */
package d.v.b.f0;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Size;
import android.util.SparseArray;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import com.zhiyun.renderengine.business.display.DisplayRender;
import d.v.b.f0.c;
import d.v.b.f0.h;
import d.v.b.f0.i;
import d.v.b.f0.j$a;
import d.v.b.f0.l.b;
import d.v.b.f0.l.d;
import d.v.b.f0.l.e;
import d.v.b.f0.l.f;
import d.v.b.f0.l.g;

public class j
extends TextureView
implements i {
    private Surface a;
    private SurfaceTexture b;
    private final SparseArray c;
    private f d;
    private g e;
    private e f;
    private b g;
    private d h;
    private final Handler i;
    private DisplayRender j;
    private final DisplayMetrics k;
    private int l;
    private int m;
    private ValueAnimator n;

    public j(Context context) {
        super(context);
        Object object;
        this.c = object = new SparseArray();
        this.o();
        Looper looper = Looper.getMainLooper();
        super(looper);
        this.i = object;
        object = this.getResources().getDisplayMetrics();
        this.k = object;
        super(context);
        this.j = object;
        this.n();
    }

    public j(Context context, int n10) {
        super(context);
        Object object;
        this.c = object = new SparseArray();
        this.o();
        Looper looper = Looper.getMainLooper();
        super(looper);
        this.i = object;
        object = this.getResources().getDisplayMetrics();
        this.k = object;
        super(context);
        this.j = object;
        this.n();
    }

    public static /* synthetic */ SurfaceTexture c(j j10) {
        return j10.b;
    }

    public static /* synthetic */ SurfaceTexture d(j j10, SurfaceTexture surfaceTexture) {
        j10.b = surfaceTexture;
        return surfaceTexture;
    }

    public static /* synthetic */ Surface e(j j10, Surface surface) {
        j10.a = surface;
        return surface;
    }

    public static /* synthetic */ void f(j j10, int n10, int n11) {
        j10.v(n10, n11);
    }

    public static /* synthetic */ g g(j j10) {
        return j10.e;
    }

    private int getDisplayRotation() {
        int n10 = ((Activity)this.getContext()).getWindowManager().getDefaultDisplay().getRotation();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("configureTransform rotation1=");
        stringBuilder.append(n10);
        d.v.d.h.f.a(stringBuilder.toString());
        return n10;
    }

    public static /* synthetic */ void h(j j10) {
        j10.l();
    }

    private void i(int n10, d.v.b.c0.b b10) {
        this.c.append(n10, (Object)b10);
    }

    private int j() {
        Configuration configuration = this.getResources().getConfiguration();
        int n10 = configuration.orientation;
        CharSequence charSequence = new StringBuilder();
        String string2 = "configureTransform orientation1=";
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(n10);
        charSequence = ((StringBuilder)charSequence).toString();
        d.v.d.h.f.a((String)charSequence);
        int n11 = 2;
        if (n10 == n11) {
            configuration = this.getContext();
            charSequence = "window";
            configuration = ((WindowManager)configuration.getSystemService((String)charSequence)).getDefaultDisplay();
            n10 = configuration.getRotation();
        } else {
            n10 = 0;
            configuration = null;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("configureTransform degrees=");
        ((StringBuilder)charSequence).append(n10);
        d.v.d.h.f.a(((StringBuilder)charSequence).toString());
        return n10;
    }

    private void k(int n10, int n11) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("changeAnimator srcWidth=");
        ((StringBuilder)object).append(n10);
        String string2 = ",srcHeight=";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(n11);
        object = ((StringBuilder)object).toString();
        d.v.d.h.f.a((String)object);
        if (n10 != 0 && n11 != 0) {
            ValueAnimator valueAnimator;
            int n12;
            object = this.f;
            boolean n122 = ((d.v.b.c0.b)object).k();
            if (!n122) {
                d.v.d.h.f.a("doesn't have aspect ratio");
                this.l = n10;
                this.m = n11;
                return;
            }
            double d10 = (Double)this.f.get();
            double d11 = (double)n11 * d10;
            this.l = n12 = (int)d11;
            this.m = n11;
            Object object2 = new StringBuilder();
            ((StringBuilder)object2).append("changeAnimator mTargetWidth=");
            int n13 = this.l;
            ((StringBuilder)object2).append(n13);
            object = ",mTargetHeight=";
            ((StringBuilder)object2).append((String)object);
            int n14 = this.m;
            ((StringBuilder)object2).append(n14);
            object2 = ((StringBuilder)object2).toString();
            d.v.d.h.f.a((String)object2);
            n11 = this.l;
            if (n11 == n10) {
                d.v.d.h.f.a("changeAnimator same size ,return");
                this.l();
                return;
            }
            object2 = this.n;
            if (object2 != null) {
                object2.cancel();
            }
            n11 = 2;
            object2 = new int[n11];
            object = null;
            object2[0] = n10;
            n10 = 1;
            int n15 = this.l;
            object2[n10] = n15;
            this.n = valueAnimator = ValueAnimator.ofInt((int[])object2);
            object2 = new c(this);
            valueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)object2);
            valueAnimator = this.n;
            long l10 = 300L;
            d10 = 1.48E-321;
            valueAnimator.setDuration(l10);
            valueAnimator = this.n;
            object2 = new AccelerateInterpolator();
            valueAnimator.setInterpolator((TimeInterpolator)object2);
            valueAnimator = this.n;
            valueAnimator.start();
        }
    }

    private void l() {
        Object object;
        Matrix matrix;
        block3: {
            int n10;
            float f10;
            Object object2;
            float f11;
            b b10;
            float f12;
            float f13;
            int n11;
            int n12;
            block2: {
                n12 = this.j();
                matrix = new Matrix();
                n11 = this.d.p();
                f13 = n11;
                f12 = this.d.o();
                object = new RectF(0.0f, 0.0f, f13, f12);
                b b11 = this.g;
                int n13 = b11.o();
                f12 = n13;
                b10 = this.g;
                f11 = b10.p();
                object2 = new RectF(0.0f, 0.0f, f12, f11);
                f12 = object.centerX();
                f10 = object.centerY();
                n10 = 1;
                f11 = Float.MIN_VALUE;
                if (n10 == n12) break block2;
                n10 = 3;
                f11 = 4.2E-45f;
                if (n10 != n12) break block3;
            }
            f11 = object2.centerX();
            f11 = f12 - f11;
            float f14 = object2.centerY();
            f14 = f10 - f14;
            object2.offset(f11, f14);
            b10 = Matrix.ScaleToFit.FILL;
            matrix.setRectToRect((RectF)object, (RectF)object2, (Matrix.ScaleToFit)b10);
            object = this.d;
            int n14 = ((f)object).p();
            float f15 = n14;
            f13 = this.g.p();
            f15 /= f13;
            object2 = this.d;
            n11 = ((f)object2).o();
            f13 = n11;
            b10 = this.g;
            n10 = b10.o();
            f11 = n10;
            f15 = Math.max(f15, f13 /= f11);
            matrix.postScale(f15, f15, f12, f10);
            n12 = (n12 + -2) * 90;
            float f16 = n12;
            matrix.postRotate(f16, f12, f10);
        }
        Handler handler = this.i;
        object = new d.v.b.f0.d(this, matrix);
        handler.postDelayed((Runnable)object, (long)10);
    }

    private Bitmap m(int n10, int n11) {
        DisplayMetrics displayMetrics = this.k;
        int n12 = Math.min(n10, n11);
        n10 = Math.max(n10, n11);
        Bitmap.Config config = Bitmap.Config.RGB_565;
        return Bitmap.createBitmap((DisplayMetrics)displayMetrics, (int)n12, (int)n10, (Bitmap.Config)config);
    }

    private void n() {
        d.v.b.c0.b b10 = new g();
        this.e = b10;
        this.i(5, b10);
        b10 = new d();
        this.h = b10;
        this.i(9, b10);
        b10 = new e();
        this.f = b10;
        this.i(7, b10);
        b10 = new f();
        this.d = b10;
        this.i(6, b10);
        b10 = new b();
        this.g = b10;
        this.i(8, b10);
        b10 = this.g;
        d.v.b.f0.b b11 = new d.v.b.f0.b(this);
        b10.h(b11);
    }

    private void o() {
        d.v.d.h.f.a("init texture sys");
        j$a j$a = new j$a(this);
        this.setSurfaceTextureListener(j$a);
    }

    public static /* synthetic */ void p(j j10, ValueAnimator valueAnimator) {
        j10.u(valueAnimator);
    }

    private /* synthetic */ void q(Matrix matrix) {
        this.setTransform(matrix);
    }

    private /* synthetic */ void s(Size size, int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("texture data change =");
        stringBuilder.append(size);
        stringBuilder.append(",mSurfaceTexture=");
        SurfaceTexture surfaceTexture = this.b;
        stringBuilder.append(surfaceTexture);
        d.v.d.h.f.a(stringBuilder.toString());
        stringBuilder = this.b;
        if (stringBuilder == null) {
            return;
        }
        int n11 = size.getWidth();
        int n12 = size.getHeight();
        stringBuilder.setDefaultBufferSize(n11, n12);
        n12 = this.d.p();
        n10 = this.d.o();
        this.k(n12, n10);
    }

    private void u(ValueAnimator valueAnimator) {
        int n10;
        this.l = n10 = ((Integer)valueAnimator.getAnimatedValue()).intValue();
        valueAnimator = this.i;
        h h10 = new h(this);
        valueAnimator.postDelayed((Runnable)h10, (long)10);
    }

    private void v(int n10, int n11) {
        f f10 = this.d;
        Size size = new Size(n10, n11);
        f10.set(size);
    }

    public d.v.b.c0.e a(int n10) {
        return (d.v.b.c0.e)this.c.get(n10);
    }

    public Bitmap b(int n10, int n11) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("get Snapshot width=");
        charSequence.append(n10);
        String string2 = ",height=";
        charSequence.append(string2);
        charSequence.append(n11);
        charSequence = charSequence.toString();
        d.v.d.h.f.a((String)charSequence);
        if (n10 > 0 && n11 > 0) {
            Bitmap bitmap = this.m(n10, n11);
            return this.getBitmap(bitmap);
        }
        return null;
    }

    public DisplayRender getRender() {
        return null;
    }

    public Surface getSurface() {
        return this.a;
    }

    public SurfaceTexture getSurfaceTextureZy() {
        return this.b;
    }

    public TextureView getView() {
        return this;
    }

    public void onMeasure(int n10, int n11) {
        int n12;
        int n13 = this.l;
        if (n13 > 0 && (n12 = this.m) > 0) {
            n10 = 0x40000000;
            n11 = View.MeasureSpec.makeMeasureSpec((int)n13, (int)n10);
            n10 = View.MeasureSpec.makeMeasureSpec((int)this.m, (int)n10);
            super.onMeasure(n11, n10);
            return;
        }
        super.onMeasure(n10, n11);
    }

    public /* synthetic */ void r(Matrix matrix) {
        this.q(matrix);
    }

    public /* synthetic */ void t(Size size, int n10) {
        this.s(size, n10);
    }
}

