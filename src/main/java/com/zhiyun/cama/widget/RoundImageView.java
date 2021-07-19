/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.Path$Direction
 *  android.graphics.Path$Op
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.RectF
 *  android.graphics.Xfermode
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 */
package com.zhiyun.cama.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.zhiyun.cama.R$styleable;
import d.v.e.l.h2;

public class RoundImageView
extends AppCompatImageView {
    private boolean a;
    private boolean b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private Xfermode m;
    private int n;
    private int o;
    private float p;
    private float[] q;
    private float[] r;
    private RectF s;
    private RectF t;
    private Paint u;
    private Path v;
    private Path w;

    public RoundImageView(Context context) {
        this(context, null);
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundImageView(Context object, AttributeSet attributeSet, int n10) {
        super((Context)object, attributeSet, n10);
        int n11;
        this.d = n10 = -1;
        this.f = n10;
        int[] nArray = R$styleable.RoundImageView;
        int n12 = 0;
        object = object.obtainStyledAttributes(attributeSet, nArray, 0, 0);
        while (true) {
            int n13;
            n11 = object.getIndexCount();
            n10 = 8;
            if (n12 >= n11) break;
            n11 = object.getIndex(n12);
            if (n11 == (n13 = 10)) {
                n10 = (int)(this.b ? 1 : 0);
                n11 = (int)(object.getBoolean(n11, n10 != 0) ? 1 : 0);
                this.b = n11;
            } else {
                n13 = 9;
                if (n11 == n13) {
                    n10 = (int)(this.a ? 1 : 0);
                    n11 = (int)(object.getBoolean(n11, n10 != 0) ? 1 : 0);
                    this.a = n11;
                } else {
                    n13 = 1;
                    if (n11 == n13) {
                        n10 = this.c;
                        this.c = n11 = object.getDimensionPixelSize(n11, n10);
                    } else if (n11 == 0) {
                        n10 = this.d;
                        this.d = n11 = object.getColor(n11, n10);
                    } else if (n11 == n10) {
                        n10 = this.e;
                        this.e = n11 = object.getDimensionPixelSize(n11, n10);
                    } else {
                        n10 = 7;
                        if (n11 == n10) {
                            n10 = this.f;
                            this.f = n11 = object.getColor(n11, n10);
                        } else {
                            n10 = 4;
                            if (n11 == n10) {
                                n10 = this.g;
                                this.g = n11 = object.getDimensionPixelSize(n11, n10);
                            } else {
                                n10 = 5;
                                if (n11 == n10) {
                                    n10 = this.h;
                                    this.h = n11 = object.getDimensionPixelSize(n11, n10);
                                } else {
                                    n10 = 6;
                                    if (n11 == n10) {
                                        n10 = this.i;
                                        this.i = n11 = object.getDimensionPixelSize(n11, n10);
                                    } else {
                                        n10 = 2;
                                        if (n11 == n10) {
                                            n10 = this.j;
                                            this.j = n11 = object.getDimensionPixelSize(n11, n10);
                                        } else {
                                            n10 = 3;
                                            if (n11 == n10) {
                                                n10 = this.k;
                                                this.k = n11 = object.getDimensionPixelSize(n11, n10);
                                            } else {
                                                n10 = 11;
                                                if (n11 == n10) {
                                                    n10 = this.l;
                                                    this.l = n11 = object.getColor(n11, n10);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ++n12;
        }
        object.recycle();
        object = new float[n10];
        this.q = (float[])object;
        object = new float[n10];
        this.r = (float[])object;
        super();
        this.t = object;
        super();
        this.s = object;
        super();
        this.u = object;
        super();
        this.v = object;
        int n14 = Build.VERSION.SDK_INT;
        n11 = 27;
        if (n14 <= n11) {
            attributeSet = PorterDuff.Mode.DST_IN;
            super((PorterDuff.Mode)attributeSet);
            this.m = object;
        } else {
            attributeSet = PorterDuff.Mode.DST_OUT;
            super((PorterDuff.Mode)attributeSet);
            this.m = object;
            super();
            this.w = object;
        }
        this.b();
        this.d();
    }

    private void b() {
        RoundImageView roundImageView = this;
        int n10 = this.a;
        if (n10 != 0) {
            return;
        }
        n10 = this.g;
        float f10 = 0.0f;
        int n11 = 0x40000000;
        float f11 = 2.0f;
        if (n10 > 0) {
            float[] fArray;
            int n12;
            for (int i10 = 0; i10 < (n12 = (fArray = roundImageView.q).length); ++i10) {
                float f12;
                n12 = roundImageView.g;
                fArray[i10] = f12 = (float)n12;
                fArray = roundImageView.r;
                float f13 = n12;
                int n13 = roundImageView.c;
                f12 = (float)n13 / f11;
                fArray[i10] = f13 -= f12;
            }
        } else {
            float[] fArray = this.q;
            int n14 = this.h;
            float f14 = n14;
            int n15 = 1;
            fArray[n15] = f14;
            fArray[0] = f14;
            int n16 = this.i;
            float f15 = n16;
            int n17 = 3;
            fArray[n17] = f15;
            int n18 = 2;
            fArray[n18] = f15;
            int n19 = this.k;
            float f16 = n19;
            int n20 = 5;
            fArray[n20] = f16;
            int n21 = 4;
            fArray[n21] = f16;
            int n22 = this.j;
            float f17 = n22;
            int n23 = 7;
            fArray[n23] = f17;
            int n24 = 6;
            fArray[n24] = f17;
            fArray = this.r;
            float f18 = n14;
            int n25 = this.c;
            float f19 = (float)n25 / f11;
            fArray[n15] = f18 -= f19;
            fArray[0] = f18;
            f10 = n16;
            f18 = (float)n25 / f11;
            fArray[n17] = f10 -= f18;
            fArray[n18] = f10;
            f10 = n19;
            f18 = (float)n25 / f11;
            fArray[n20] = f10 -= f18;
            fArray[n21] = f10;
            f10 = n22;
            f18 = (float)n25 / f11;
            fArray[n23] = f10 -= f18;
            n11 = 6;
            f11 = 8.4E-45f;
            fArray[n11] = f10;
        }
    }

    private void c(boolean bl2) {
        if (bl2) {
            bl2 = false;
            this.g = 0;
        }
        this.b();
        this.j();
        this.invalidate();
    }

    private void d() {
        boolean bl2 = this.a;
        if (!bl2) {
            bl2 = false;
            this.e = 0;
        }
    }

    private void f(Canvas canvas) {
        int n10 = this.a;
        if (n10 != 0) {
            float f10;
            float f11;
            int n11;
            n10 = this.c;
            float f12 = 2.0f;
            if (n10 > 0) {
                n11 = this.d;
                f11 = this.p;
                f10 = (float)n10 / f12;
                this.g(canvas, n10, n11, f11 -= f10);
            }
            if ((n10 = this.e) > 0) {
                n11 = this.f;
                f11 = this.p;
                int n12 = this.c;
                f10 = n12;
                f11 -= f10;
                f10 = (float)n10 / f12;
                this.g(canvas, n10, n11, f11 -= f10);
            }
        } else {
            int n13 = this.c;
            if (n13 > 0) {
                int n14 = this.d;
                RectF rectF = this.t;
                float[] fArray = this.q;
                this.h(canvas, n13, n14, rectF, fArray);
            }
        }
    }

    private void g(Canvas canvas, int n10, int n11, float f10) {
        this.i(n10, n11);
        Path path = this.v;
        float f11 = this.n;
        float f12 = 2.0f;
        float f13 = (float)this.o / f12;
        Path.Direction direction = Path.Direction.CCW;
        path.addCircle(f11 /= f12, f13, f10, direction);
        path = this.v;
        Paint paint = this.u;
        canvas.drawPath(path, paint);
    }

    private void h(Canvas canvas, int n10, int n11, RectF rectF, float[] fArray) {
        this.i(n10, n11);
        Path path = this.v;
        Path.Direction direction = Path.Direction.CCW;
        path.addRoundRect(rectF, fArray, direction);
        path = this.v;
        direction = this.u;
        canvas.drawPath(path, (Paint)direction);
    }

    private void i(int n10, int n11) {
        this.v.reset();
        Paint paint = this.u;
        float f10 = n10;
        paint.setStrokeWidth(f10);
        this.u.setColor(n11);
        Paint paint2 = this.u;
        Paint.Style style2 = Paint.Style.STROKE;
        paint2.setStyle(style2);
    }

    private void j() {
        boolean bl2 = this.a;
        if (!bl2) {
            RectF rectF = this.t;
            int n10 = this.c;
            float f10 = n10;
            float f11 = 2.0f;
            float f12 = (float)n10 / f11;
            int n11 = this.n;
            float f13 = n11;
            float f14 = (float)n10 / f11;
            f13 -= f14;
            int n12 = this.o;
            f14 = n12;
            float f15 = (float)n10 / f11;
            rectF.set(f10 /= f11, f12, f13, f14 -= f15);
        }
    }

    private void k() {
        int n10 = this.a;
        if (n10 != 0) {
            n10 = this.n;
            int n11 = this.o;
            n10 = Math.min(n10, n11);
            float f10 = n10;
            n11 = 0x40000000;
            float f11 = 2.0f;
            this.p = f10 /= f11;
            RectF rectF = this.s;
            int n12 = this.n;
            float f12 = (float)n12 / f11 - f10;
            int n13 = this.o;
            float f13 = (float)n13 / f11 - f10;
            float f14 = (float)n12 / f11 + f10;
            float f15 = (float)n13 / f11 + f10;
            rectF.set(f12, f13, f14, f15);
        } else {
            RectF rectF = this.s;
            int n14 = this.n;
            float f16 = n14;
            int n15 = this.o;
            float f17 = n15;
            boolean bl2 = false;
            float f18 = 0.0f;
            rectF.set(0.0f, 0.0f, f16, f17);
            n10 = (int)(this.b ? 1 : 0);
            if (n10 != 0) {
                this.s = rectF = this.t;
            }
        }
    }

    public void l(boolean bl2) {
        this.a = bl2;
        this.d();
        this.k();
        this.invalidate();
    }

    public void m(boolean bl2) {
        this.b = bl2;
        this.k();
        this.invalidate();
    }

    public void onDraw(Canvas canvas) {
        Object object;
        RectF rectF;
        float f10;
        float f11;
        int n10;
        int n11;
        RectF rectF2 = this.s;
        Paint paint = null;
        canvas.saveLayer(rectF2, null, 31);
        int n12 = this.b;
        int n13 = 0x40000000;
        float f12 = 2.0f;
        if (n12 == 0) {
            n12 = this.n;
            n11 = this.c;
            n10 = n11 * 2;
            n10 = n12 - n10;
            int n14 = this.e;
            int n15 = n14 * 2;
            f11 = n10 -= n15;
            n15 = 1065353216;
            float f13 = 1.0f;
            f11 *= f13;
            float f14 = n12;
            int n16 = this.o;
            n11 *= 2;
            n11 = n16 - n11;
            f10 = (float)(n11 -= (n14 *= 2)) * f13;
            float f15 = n16;
            f10 /= f15;
            float f16 = (float)n12 / f12;
            f15 = (float)n16 / f12;
            canvas.scale(f11 /= f14, f10, f16, f15);
        }
        super.onDraw(canvas);
        this.u.reset();
        rectF2 = this.v;
        rectF2.reset();
        n12 = (int)(this.a ? 1 : 0);
        if (n12 != 0) {
            rectF2 = this.v;
            n11 = this.n;
            f10 = (float)n11 / f12;
            n10 = this.o;
            f11 = (float)n10 / f12;
            f12 = this.p;
            Path.Direction direction = Path.Direction.CCW;
            rectF2.addCircle(f10, f11, f12, direction);
        } else {
            rectF2 = this.v;
            rectF = this.s;
            object = this.r;
            Path.Direction direction = Path.Direction.CCW;
            rectF2.addRoundRect(rectF, object, direction);
        }
        this.u.setAntiAlias(true);
        rectF2 = this.u;
        rectF = Paint.Style.FILL;
        rectF2.setStyle((Paint.Style)rectF);
        rectF2 = this.u;
        rectF = this.m;
        rectF2.setXfermode((Xfermode)rectF);
        n12 = Build.VERSION.SDK_INT;
        n13 = 27;
        f12 = 3.8E-44f;
        if (n12 <= n13) {
            rectF2 = this.v;
            rectF = this.u;
            canvas.drawPath((Path)rectF2, (Paint)rectF);
        } else {
            this.w.reset();
            rectF2 = this.w;
            rectF = this.s;
            object = Path.Direction.CCW;
            rectF2.addRect(rectF, (Path.Direction)object);
            rectF2 = this.w;
            rectF = this.v;
            object = Path.Op.DIFFERENCE;
            rectF2.op((Path)rectF, (Path.Op)object);
            rectF2 = this.w;
            rectF = this.u;
            canvas.drawPath((Path)rectF2, (Paint)rectF);
        }
        rectF2 = this.u;
        rectF2.setXfermode(null);
        n12 = this.l;
        if (n12 != 0) {
            this.u.setColor(n12);
            rectF2 = this.v;
            paint = this.u;
            canvas.drawPath((Path)rectF2, paint);
        }
        canvas.restore();
        this.f(canvas);
    }

    public void onSizeChanged(int n10, int n11, int n12, int n13) {
        super.onSizeChanged(n10, n11, n12, n13);
        this.n = n10;
        this.o = n11;
        this.j();
        this.k();
    }

    public void setBorderColor(int n10) {
        this.d = n10;
        this.invalidate();
    }

    public void setBorderWidth(int n10) {
        this.c = n10 = h2.b(n10);
        this.c(false);
    }

    public void setCornerBottomLeftRadius(int n10) {
        this.j = n10 = h2.b(n10);
        this.c(true);
    }

    public void setCornerBottomRightRadius(int n10) {
        this.k = n10 = h2.b(n10);
        this.c(true);
    }

    public void setCornerRadius(int n10) {
        this.g = n10 = h2.b(n10);
        this.c(false);
    }

    public void setCornerTopLeftRadius(int n10) {
        this.h = n10 = h2.b(n10);
        this.c(true);
    }

    public void setCornerTopRightRadius(int n10) {
        this.i = n10 = h2.b(n10);
        this.c(true);
    }

    public void setInnerBorderColor(int n10) {
        this.f = n10;
        this.invalidate();
    }

    public void setInnerBorderWidth(int n10) {
        this.e = n10 = h2.b(n10);
        this.d();
        this.invalidate();
    }

    public void setMaskColor(int n10) {
        this.l = n10;
        this.invalidate();
    }
}

