/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Matrix
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.os.AsyncTask
 *  android.util.AttributeSet
 */
package d.t.a.j;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.AttributeSet;
import com.yalantis.ucrop.R$styleable;
import d.t.a.f.c;
import d.t.a.g.d;
import d.t.a.i.g;
import d.t.a.j.a$a;
import d.t.a.j.a$b;
import d.t.a.j.b;
import java.util.Arrays;
import java.util.concurrent.Executor;

public class a
extends b {
    public static final int F = 0;
    public static final int G = 500;
    public static final float H = 10.0f;
    public static final float I;
    public static final float J;
    private float A;
    private float B;
    private int C;
    private int D;
    private long E;
    private final RectF t;
    private final Matrix u;
    private float v;
    private float w;
    private c x;
    private Runnable y;
    private Runnable z;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        super();
        this.t = context;
        super();
        this.u = context;
        this.w = 10.0f;
        this.z = null;
        this.C = 0;
        this.D = 0;
        this.E = 500L;
    }

    private void B(float f10, float f11) {
        float f12 = this.t.width();
        float f13 = this.t.height();
        float f14 = this.t.width() / f10;
        float f15 = this.t.height() / f11;
        f14 = Math.max(f14, f15);
        f12 -= (f10 *= f14);
        f10 = 2.0f;
        f12 /= f10;
        RectF rectF = this.t;
        float f16 = rectF.left;
        f13 = (f13 - (f11 *= f14)) / f10;
        f10 = rectF.top;
        this.d.reset();
        this.d.postScale(f14, f14);
        this.d.postTranslate(f12 += f16, f13 += f10);
        Matrix matrix = this.d;
        this.setImageMatrix(matrix);
    }

    public static /* synthetic */ RectF q(a a10) {
        return a10.t;
    }

    private float[] r() {
        int n10;
        int n11;
        this.u.reset();
        Object object = this.u;
        float f10 = -this.getCurrentAngle();
        object.setRotate(f10);
        object = this.a;
        int n12 = ((Matrix)object).length;
        object = Arrays.copyOf((float[])object, n12);
        Object object2 = d.t.a.i.g.b(this.t);
        this.u.mapPoints((float[])object);
        Matrix matrix = this.u;
        matrix.mapPoints(object2);
        object = d.t.a.i.g.d((float[])object);
        object2 = d.t.a.i.g.d(object2);
        float f11 = object.left;
        float f12 = object2.left;
        f11 -= f12;
        f12 = object.top;
        float f13 = object2.top;
        f12 -= f13;
        f13 = object.right;
        float f14 = object2.right;
        f13 -= f14;
        float f15 = object.bottom;
        f10 = object2.bottom;
        f15 -= f10;
        n12 = 4;
        f10 = 5.6E-45f;
        object2 = new float[n12];
        f14 = 0.0f;
        float f16 = f11 - 0.0f;
        float f17 = f16 == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1);
        if (f17 <= 0) {
            n11 = 0;
            matrix = null;
            f11 = 0.0f;
        }
        object2[0] = f11;
        n11 = 1;
        f11 = Float.MIN_VALUE;
        float f18 = f12 - 0.0f;
        f17 = f18 == 0.0f ? 0 : (f18 > 0.0f ? 1 : -1);
        if (f17 <= 0) {
            n10 = 0;
            f12 = 0.0f;
        }
        object2[n11] = f12;
        n11 = 2;
        f11 = 2.8E-45f;
        float f19 = f13 - 0.0f;
        n10 = f19 == 0.0f ? 0 : (f19 < 0.0f ? -1 : 1);
        if (n10 >= 0) {
            f13 = 0.0f;
        }
        object2[n11] = f13;
        n11 = 3;
        f11 = 4.2E-45f;
        float f20 = f15 - 0.0f;
        n10 = (int)(f20 == 0.0f ? 0 : (f20 < 0.0f ? -1 : 1));
        if (n10 >= 0) {
            object = null;
            f15 = 0.0f;
        }
        object2[n11] = f15;
        this.u.reset();
        object = this.u;
        f11 = this.getCurrentAngle();
        object.setRotate(f11);
        this.u.mapPoints(object2);
        return object2;
    }

    private void s() {
        Drawable drawable2 = this.getDrawable();
        if (drawable2 == null) {
            return;
        }
        float f10 = drawable2.getIntrinsicWidth();
        float f11 = drawable2.getIntrinsicHeight();
        this.t(f10, f11);
    }

    private void t(float f10, float f11) {
        float f12 = this.t.width() / f10;
        float f13 = this.t.width() / f11;
        f12 = Math.min(f12, f13);
        f13 = this.t.height() / f11;
        f11 = this.t.height() / f10;
        f10 = Math.min(f13, f11);
        this.B = f10 = Math.min(f12, f10);
        f11 = this.w;
        this.A = f10 *= f11;
    }

    public void A() {
        this.setImageToWrapCropBounds(true);
    }

    public void C(float f10, float f11, float f12, long l10) {
        float f13 = this.getMaxScale();
        float f14 = f10 - f13;
        Object object = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
        if (object > 0) {
            f10 = this.getMaxScale();
        }
        float f15 = this.getCurrentScale();
        float f16 = f10 - f15;
        a$b a$b = new a$b(this, l10, f15, f16, f11, f12);
        this.z = a$b;
        this.post(a$b);
    }

    public void D(float f10) {
        float f11 = this.t.centerX();
        float f12 = this.t.centerY();
        this.E(f10, f11, f12);
    }

    public void E(float f10, float f11, float f12) {
        float f13 = this.getMaxScale();
        float f14 = f10 - f13;
        Object object = f14 == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1);
        if (object <= 0) {
            f13 = this.getCurrentScale();
            this.l(f10 /= f13, f11, f12);
        }
    }

    public void F(float f10) {
        float f11 = this.t.centerX();
        float f12 = this.t.centerY();
        this.G(f10, f11, f12);
    }

    public void G(float f10, float f11, float f12) {
        float f13 = this.getMinScale();
        float f14 = f10 - f13;
        Object object = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
        if (object >= 0) {
            f13 = this.getCurrentScale();
            this.l(f10 /= f13, f11, f12);
        }
    }

    public c getCropBoundsChangeListener() {
        return this.x;
    }

    public float getMaxScale() {
        return this.A;
    }

    public float getMinScale() {
        return this.B;
    }

    public float getTargetAspectRatio() {
        return this.v;
    }

    public void j() {
        super.j();
        Object object = this.getDrawable();
        if (object == null) {
            return;
        }
        int n10 = object.getIntrinsicWidth();
        float f10 = n10;
        int n11 = object.getIntrinsicHeight();
        float f11 = n11;
        float f12 = this.v;
        float f13 = f12 - 0.0f;
        Object object2 = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object2 == false) {
            this.v = f12 = f10 / f11;
        }
        object2 = this.e;
        float f14 = object2;
        float f15 = this.v;
        int n12 = (int)(f14 /= f15);
        int n13 = this.f;
        if (n12 > n13) {
            n12 = (int)((float)n13 * f15);
            object2 = (object2 - n12) / 2;
            RectF rectF = this.t;
            float f16 = object2;
            f12 = n12 += object2;
            f14 = n13;
            rectF.set(f16, 0.0f, f12, f14);
        } else {
            n13 = (n13 - n12) / 2;
            RectF rectF = this.t;
            float f17 = n13;
            f12 = object2;
            f14 = n12 += n13;
            rectF.set(0.0f, f17, f12, f14);
        }
        this.t(f10, f11);
        this.B(f10, f11);
        object = this.x;
        if (object != null) {
            f10 = this.v;
            object.a(f10);
        }
        if ((object = this.g) != null) {
            f10 = this.getCurrentScale();
            object.a(f10);
            object = this.g;
            f10 = this.getCurrentAngle();
            object.d(f10);
        }
    }

    public void l(float f10, float f11, float f12) {
        float f13;
        float f14;
        float f15;
        int n10 = 1065353216;
        float f16 = 1.0f;
        float f17 = f10 - f16;
        Object object = f17 == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1);
        if (object > 0 && (object = (f15 = (f14 = this.getCurrentScale() * f10) - (f13 = this.getMaxScale())) == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1)) <= 0) {
            super.l(f10, f11, f12);
        } else {
            float f18;
            n10 = (int)(f10 == f16 ? 0 : (f10 < f16 ? -1 : 1));
            if (n10 < 0 && (n10 = (int)((f18 = (f16 = this.getCurrentScale() * f10) - (f14 = this.getMinScale())) == 0.0f ? 0 : (f18 > 0.0f ? 1 : -1))) >= 0) {
                super.l(f10, f11, f12);
            }
        }
    }

    public void setCropBoundsChangeListener(c c10) {
        this.x = c10;
    }

    public void setCropRect(RectF rectF) {
        float f10 = rectF.width();
        float f11 = rectF.height();
        this.v = f10 /= f11;
        RectF rectF2 = this.t;
        f11 = rectF.left;
        float f12 = this.getPaddingLeft();
        f11 -= f12;
        f12 = rectF.top;
        float f13 = this.getPaddingTop();
        f12 -= f13;
        f13 = rectF.right;
        float f14 = this.getPaddingRight();
        f13 -= f14;
        float f15 = rectF.bottom;
        f14 = this.getPaddingBottom();
        rectF2.set(f11, f12, f13, f15 -= f14);
        this.s();
        this.A();
    }

    public void setImageToWrapCropBounds(boolean bl2) {
        boolean bl3 = this.k;
        if (bl3 && !(bl3 = this.w())) {
            float f10;
            float f11;
            float f12;
            Object object = this.b;
            float f13 = 0.0f;
            float f14 = object[0];
            int n10 = 1;
            float f15 = Float.MIN_VALUE;
            float f16 = object[n10];
            float f17 = this.getCurrentScale();
            object = this.t;
            float f18 = object.centerX() - f14;
            Object object2 = this.t;
            float f19 = object2.centerY() - f16;
            RectF rectF = null;
            this.u.reset();
            this.u.setTranslate(f18, f19);
            Object object3 = this.a;
            int n11 = ((float[])object3).length;
            object3 = Arrays.copyOf(object3, n11);
            Matrix matrix = this.u;
            matrix.mapPoints(object3);
            boolean bl4 = this.x((float[])object3);
            if (bl4) {
                object = this.r();
                f13 = object[0];
                f19 = object[2];
                f13 = -(f13 + f19);
                f15 = object[n10];
                int n12 = 3;
                f19 = 4.2E-45f;
                f18 = object[n12];
                f15 += f18;
                f12 = f18 = -f15;
                f11 = f13;
                f10 = 0.0f;
            } else {
                object3 = this.t;
                rectF = new RectF((RectF)object3);
                this.u.reset();
                object3 = this.u;
                f11 = this.getCurrentAngle();
                object3.setRotate(f11);
                this.u.mapRect(rectF);
                object3 = d.t.a.i.g.c(this.a);
                f11 = rectF.width();
                f13 = object3[0];
                f11 /= f13;
                f13 = rectF.height();
                f15 = object3[n10];
                f13 /= f15;
                f13 = Math.max(f11, f13) * f17 - f17;
                f11 = f18;
                f10 = f13;
                f12 = f19;
            }
            if (bl2) {
                long l10 = this.E;
                object2 = this;
                a$a a$a = new a$a(this, l10, f14, f16, f11, f12, f17, f10, bl4);
                this.y = a$a;
                this.post(a$a);
            } else {
                this.m(f11, f12);
                if (!bl4) {
                    RectF rectF2 = this.t;
                    float f20 = rectF2.centerX();
                    object = this.t;
                    f18 = object.centerY();
                    this.E(f17 += f10, f20, f18);
                }
            }
        }
    }

    public void setImageToWrapCropBoundsAnimDuration(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            this.E = l10;
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Animation duration cannot be negative value.");
        throw illegalArgumentException;
    }

    public void setMaxResultImageSizeX(int n10) {
        this.C = n10;
    }

    public void setMaxResultImageSizeY(int n10) {
        this.D = n10;
    }

    public void setMaxScaleMultiplier(float f10) {
        this.w = f10;
    }

    public void setTargetAspectRatio(float f10) {
        float f11;
        Drawable drawable2 = this.getDrawable();
        if (drawable2 == null) {
            this.v = f10;
            return;
        }
        float f12 = f10 - 0.0f;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object == false) {
            int n10 = drawable2.getIntrinsicWidth();
            f10 = n10;
            int n11 = drawable2.getIntrinsicHeight();
            f11 = n11;
            this.v = f10 /= f11;
        } else {
            this.v = f10;
        }
        c c10 = this.x;
        if (c10 != null) {
            f11 = this.v;
            c10.a(f11);
        }
    }

    public void u() {
        Runnable runnable = this.y;
        this.removeCallbacks(runnable);
        runnable = this.z;
        this.removeCallbacks(runnable);
    }

    public void v(Bitmap.CompressFormat compressFormat, int n10, d.t.a.f.a a10) {
        d.t.a.h.a a11;
        this.u();
        this.setImageToWrapCropBounds(false);
        Object object = this.t;
        RectF rectF = d.t.a.i.g.d(this.a);
        float f10 = this.getCurrentScale();
        float f11 = this.getCurrentAngle();
        d d10 = new d((RectF)object, rectF, f10, f11);
        int n11 = this.C;
        int n12 = this.D;
        String string2 = this.getImageInputPath();
        String string3 = this.getImageOutputPath();
        d.t.a.g.c c10 = this.getExifInfo();
        d.t.a.g.b b10 = new d.t.a.g.b(n11, n12, compressFormat, n10, string2, string3, c10);
        rectF = this.getContext();
        Bitmap bitmap = this.getViewBitmap();
        object = a11;
        a11 = new d.t.a.h.a((Context)rectF, bitmap, d10, b10, a10);
        object = AsyncTask.THREAD_POOL_EXECUTOR;
        Object[] objectArray = new Void[]{};
        a11.executeOnExecutor((Executor)object, objectArray);
    }

    public boolean w() {
        float[] fArray = this.a;
        return this.x(fArray);
    }

    public boolean x(float[] object) {
        this.u.reset();
        Object object2 = this.u;
        float f10 = -this.getCurrentAngle();
        object2.setRotate(f10);
        int n10 = ((float[])object).length;
        object = Arrays.copyOf(object, n10);
        this.u.mapPoints(object);
        object2 = d.t.a.i.g.b(this.t);
        this.u.mapPoints((float[])object2);
        object = d.t.a.i.g.d(object);
        object2 = d.t.a.i.g.d((float[])object2);
        return object.contains((RectF)object2);
    }

    public void y(float f10) {
        float f11 = this.t.centerX();
        float f12 = this.t.centerY();
        this.k(f10, f11, f12);
    }

    public void z(TypedArray typedArray) {
        float f10;
        int n10 = R$styleable.ucrop_UCropView_ucrop_aspect_ratio_x;
        float f11 = Math.abs(typedArray.getFloat(n10, 0.0f));
        int n11 = R$styleable.ucrop_UCropView_ucrop_aspect_ratio_y;
        float f12 = Math.abs(typedArray.getFloat(n11, 0.0f));
        float f13 = f11 - 0.0f;
        n11 = (int)(f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1));
        this.v = n11 != 0 && (n11 = (int)((f10 = f12 - 0.0f) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1))) != 0 ? (f11 /= f12) : 0.0f;
    }
}

