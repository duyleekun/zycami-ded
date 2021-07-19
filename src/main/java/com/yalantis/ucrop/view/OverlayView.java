/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.Path$Direction
 *  android.graphics.RectF
 *  android.graphics.Region$Op
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.View
 */
package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.yalantis.ucrop.R$color;
import com.yalantis.ucrop.R$dimen;
import com.yalantis.ucrop.R$styleable;
import d.t.a.f.d;
import d.t.a.i.g;

public class OverlayView
extends View {
    public static final int C = 0;
    public static final int D = 1;
    public static final int E = 2;
    public static final boolean F = true;
    public static final boolean G = true;
    public static final boolean H = false;
    public static final int I = 0;
    public static final int J = 2;
    public static final int K = 2;
    private d A;
    private boolean B;
    private final RectF a;
    private final RectF b;
    public int c;
    public int d;
    public float[] e;
    public float[] f;
    private int g;
    private int h;
    private float i;
    private float[] j;
    private boolean k;
    private boolean l;
    private boolean m;
    private int n;
    private Path o;
    private Paint p;
    private Paint q;
    private Paint r;
    private Paint s;
    private int t;
    private float u;
    private float v;
    private int w;
    private int x;
    private int y;
    private int z;

    public OverlayView(Context context) {
        this(context, null);
    }

    public OverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OverlayView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        int n11;
        float f10;
        super();
        this.a = context;
        super();
        this.b = context;
        this.j = null;
        super();
        this.o = context;
        int n12 = 1;
        super(n12);
        this.p = context;
        super(n12);
        this.q = context;
        super(n12);
        this.r = context;
        super(n12);
        this.s = context;
        this.t = 0;
        this.u = f10 = -1.0f;
        this.v = f10;
        this.w = -1;
        context = this.getResources();
        n12 = R$dimen.ucrop_default_crop_rect_corner_touch_threshold;
        this.x = n11 = context.getDimensionPixelSize(n12);
        context = this.getResources();
        n12 = R$dimen.ucrop_default_crop_rect_min_size;
        this.y = n11 = context.getDimensionPixelSize(n12);
        context = this.getResources();
        n12 = R$dimen.ucrop_default_crop_rect_corner_touch_area_line_length;
        this.z = n11 = context.getDimensionPixelSize(n12);
        this.d();
    }

    private int c(float f10, float f11) {
        RectF rectF;
        boolean bl2;
        int n10 = this.x;
        double d10 = n10;
        int n11 = -1;
        int n12 = 0;
        while (true) {
            int n13 = 8;
            float f12 = 1.1E-44f;
            if (n12 >= n13) break;
            float[] fArray = this.e;
            f12 = fArray[n12];
            f12 = f10 - f12;
            double d11 = f12;
            double d12 = 2.0;
            d11 = Math.pow(d11, d12);
            float[] fArray2 = this.e;
            int n14 = n12 + 1;
            float f13 = fArray2[n14];
            double d13 = f13 = f11 - f13;
            double d14 = (d11 = Math.sqrt(d11 + (d12 = Math.pow(d13, d12)))) - d10;
            Object object = d14 == 0.0 ? 0 : (d14 < 0.0 ? -1 : 1);
            if (object < 0) {
                n11 = n10 = n12 / 2;
                d10 = d11;
            }
            n12 += 2;
        }
        n10 = this.t;
        int n15 = 1;
        if (n10 == n15 && n11 < 0 && (bl2 = (rectF = this.a).contains(f10, f11))) {
            return 4;
        }
        return n11;
    }

    private void e(TypedArray typedArray) {
        int n10 = R$styleable.ucrop_UCropView_ucrop_frame_stroke_size;
        Resources resources = this.getResources();
        int n11 = R$dimen.ucrop_default_crop_frame_stoke_width;
        int n12 = resources.getDimensionPixelSize(n11);
        n10 = typedArray.getDimensionPixelSize(n10, n12);
        n12 = R$styleable.ucrop_UCropView_ucrop_frame_color;
        Resources resources2 = this.getResources();
        int n13 = R$color.ucrop_color_default_crop_frame;
        n11 = resources2.getColor(n13);
        int n14 = typedArray.getColor(n12, n11);
        resources = this.r;
        float f10 = n10;
        resources.setStrokeWidth(f10);
        this.r.setColor(n14);
        resources = this.r;
        resources2 = Paint.Style.STROKE;
        resources.setStyle((Paint.Style)resources2);
        resources = this.s;
        float f11 = n10 * 3;
        resources.setStrokeWidth(f11);
        this.s.setColor(n14);
        typedArray = this.s;
        Paint.Style style2 = Paint.Style.STROKE;
        typedArray.setStyle(style2);
    }

    private void f(TypedArray typedArray) {
        int n10;
        int n11 = R$styleable.ucrop_UCropView_ucrop_grid_stroke_size;
        Resources resources = this.getResources();
        int n12 = R$dimen.ucrop_default_crop_grid_stoke_width;
        int n13 = resources.getDimensionPixelSize(n12);
        n11 = typedArray.getDimensionPixelSize(n11, n13);
        n13 = R$styleable.ucrop_UCropView_ucrop_grid_color;
        Resources resources2 = this.getResources();
        int n14 = R$color.ucrop_color_default_crop_grid;
        n12 = resources2.getColor(n14);
        n13 = typedArray.getColor(n13, n12);
        resources2 = this.q;
        float f10 = n11;
        resources2.setStrokeWidth(f10);
        this.q.setColor(n13);
        n11 = R$styleable.ucrop_UCropView_ucrop_grid_row_count;
        n13 = 2;
        this.g = n11 = typedArray.getInt(n11, n13);
        n11 = R$styleable.ucrop_UCropView_ucrop_grid_column_count;
        this.h = n10 = typedArray.getInt(n11, n13);
    }

    private void j(float f10, float f11) {
        float f12;
        float f13;
        RectF rectF;
        float f14;
        int n10;
        RectF rectF2 = this.b;
        RectF rectF3 = this.a;
        rectF2.set(rectF3);
        int n11 = this.w;
        int n12 = 1;
        float f15 = Float.MIN_VALUE;
        if (n11 != 0) {
            if (n11 != n12) {
                n10 = 2;
                f14 = 2.8E-45f;
                if (n11 != n10) {
                    n10 = 3;
                    f14 = 4.2E-45f;
                    if (n11 != n10) {
                        n10 = 4;
                        f14 = 5.6E-45f;
                        if (n11 == n10) {
                            rectF2 = this.b;
                            f15 = this.u;
                            f10 -= f15;
                            f15 = this.v;
                            rectF2.offset(f10, f11 -= f15);
                            RectF rectF4 = this.b;
                            f10 = rectF4.left;
                            int n13 = this.getLeft();
                            f11 = n13;
                            Object object = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
                            if (object > 0) {
                                rectF4 = this.b;
                                f10 = rectF4.top;
                                n13 = this.getTop();
                                f11 = n13;
                                float f16 = f10 - f11;
                                object = f16 == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1);
                                if (object > 0) {
                                    rectF4 = this.b;
                                    f10 = rectF4.right;
                                    n13 = this.getRight();
                                    f11 = n13;
                                    float f17 = f10 - f11;
                                    object = f17 == 0.0f ? 0 : (f17 < 0.0f ? -1 : 1);
                                    if (object < 0) {
                                        rectF4 = this.b;
                                        f10 = rectF4.bottom;
                                        n13 = this.getBottom();
                                        f11 = n13;
                                        float f18 = f10 - f11;
                                        object = f18 == 0.0f ? 0 : (f18 < 0.0f ? -1 : 1);
                                        if (object < 0) {
                                            rectF4 = this.a;
                                            RectF rectF5 = this.b;
                                            rectF4.set(rectF5);
                                            this.k();
                                            this.postInvalidate();
                                        }
                                    }
                                }
                            }
                            return;
                        }
                    } else {
                        rectF2 = this.b;
                        rectF = this.a;
                        f13 = rectF.top;
                        f14 = rectF.right;
                        rectF2.set(f10, f13, f14, f11);
                    }
                } else {
                    rectF2 = this.b;
                    rectF = this.a;
                    f13 = rectF.left;
                    f14 = rectF.top;
                    rectF2.set(f13, f14, f10, f11);
                }
            } else {
                rectF2 = this.b;
                rectF = this.a;
                f13 = rectF.left;
                f14 = rectF.bottom;
                rectF2.set(f13, f11, f10, f14);
            }
        } else {
            rectF2 = this.b;
            rectF = this.a;
            f13 = rectF.right;
            f14 = rectF.bottom;
            rectF2.set(f10, f11, f13, f14);
        }
        RectF rectF6 = this.b;
        f10 = rectF6.height();
        f11 = this.y;
        float f19 = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
        boolean bl2 = false;
        f11 = 0.0f;
        RectF rectF7 = null;
        if (f19 >= 0) {
            f19 = n12;
            f10 = f15;
        } else {
            f19 = 0.0f;
            rectF6 = null;
            f10 = 0.0f;
        }
        rectF2 = this.b;
        float f20 = rectF2.width();
        n10 = this.y;
        f14 = n10;
        n11 = (int)(f20 == f14 ? 0 : (f20 > f14 ? 1 : -1));
        if (n11 < 0) {
            n12 = 0;
            rectF3 = null;
            f15 = 0.0f;
        }
        rectF7 = this.a;
        if (n12 != 0) {
            rectF2 = this.b;
            f20 = rectF2.left;
        } else {
            f20 = rectF7.left;
        }
        if (f19 != false) {
            rectF = this.b;
            f14 = rectF.top;
        } else {
            f14 = rectF7.top;
        }
        if (n12 != 0) {
            RectF rectF8 = this.b;
            f13 = rectF8.right;
        } else {
            f13 = rectF7.right;
        }
        if (f19 != false) {
            RectF rectF9 = this.b;
            f12 = rectF9.bottom;
        } else {
            f12 = rectF7.bottom;
        }
        rectF7.set(f20, f14, f13, f12);
        if (f19 != false || n12 != 0) {
            this.k();
            this.postInvalidate();
        }
    }

    private void k() {
        Object object = d.t.a.i.g.b(this.a);
        this.e = object;
        object = d.t.a.i.g.a(this.a);
        this.f = object;
        this.j = null;
        this.o.reset();
        object = this.o;
        float f10 = this.a.centerX();
        float f11 = this.a.centerY();
        float f12 = this.a.width();
        float f13 = this.a.height();
        f12 = Math.min(f12, f13) / 2.0f;
        Path.Direction direction = Path.Direction.CW;
        object.addCircle(f10, f11, f12, direction);
    }

    public void a(Canvas canvas) {
        float f10;
        int n10;
        float f11;
        Object object;
        int n11;
        Object object2;
        int n12 = this.l;
        if (n12 != 0) {
            object2 = this.j;
            if (object2 == null && (n12 = (int)((object2 = (Object)this.a).isEmpty() ? 1 : 0)) == 0) {
                float f12;
                float f13;
                float f14;
                RectF rectF;
                float f15;
                int n13;
                n12 = this.g * 4;
                n11 = this.h * 4;
                this.j = object2 = new float[n12 + n11];
                n12 = 0;
                object2 = null;
                n11 = 0;
                object = null;
                f11 = 0.0f;
                n10 = 0;
                f10 = 0.0f;
                while (true) {
                    n13 = this.g;
                    int n14 = 1065353216;
                    f15 = 1.0f;
                    if (n11 >= n13) break;
                    float[] fArray = this.j;
                    int n15 = n10 + 1;
                    rectF = this.a;
                    fArray[n10] = f14 = rectF.left;
                    n10 = n15 + 1;
                    f13 = rectF.height();
                    f14 = (float)n11 + f15;
                    n14 = this.g + 1;
                    f15 = n14;
                    f15 = f14 / f15;
                    f13 *= f15;
                    RectF rectF2 = this.a;
                    f12 = rectF2.top;
                    fArray[n15] = f13 += f12;
                    fArray = this.j;
                    n15 = n10 + 1;
                    fArray[n10] = f13 = rectF2.right;
                    n10 = n15 + 1;
                    f15 = rectF2.height();
                    int n16 = this.g + 1;
                    f13 = n16;
                    f15 *= (f14 /= f13);
                    rectF = this.a;
                    f13 = rectF.top;
                    fArray[n15] = f15 += f13;
                    ++n11;
                }
                while (n12 < (n11 = this.h)) {
                    object = this.j;
                    n13 = n10 + 1;
                    RectF rectF3 = this.a;
                    float f16 = rectF3.width();
                    f13 = (float)n12 + f15;
                    f14 = this.h + 1;
                    f14 = f13 / f14;
                    f16 *= f14;
                    RectF rectF4 = this.a;
                    f12 = rectF4.left;
                    object[n10] = (Paint)(f16 += f12);
                    object = this.j;
                    n10 = n13 + 1;
                    f16 = rectF4.top;
                    object[n13] = (Paint)f16;
                    n13 = n10 + 1;
                    f16 = rectF4.width();
                    int n17 = this.h + 1;
                    f14 = n17;
                    f16 *= (f13 /= f14);
                    rectF = this.a;
                    f14 = rectF.left;
                    object[n10] = (Paint)(f16 += f14);
                    object = this.j;
                    n10 = n13 + 1;
                    f16 = rectF.bottom;
                    object[n13] = (Paint)f16;
                    ++n12;
                }
            }
            if ((object2 = this.j) != null) {
                object = this.q;
                canvas.drawLines(object2, object);
            }
        }
        if ((n12 = this.k) != 0) {
            object2 = this.a;
            object = this.r;
            canvas.drawRect((RectF)object2, object);
        }
        if ((n12 = this.t) != 0) {
            canvas.save();
            object2 = this.b;
            object = this.a;
            object2.set((RectF)object);
            object2 = this.b;
            n11 = this.z;
            f10 = n11;
            f11 = -n11;
            object2.inset(f10, f11);
            object2 = this.b;
            object = Region.Op.DIFFERENCE;
            canvas.clipRect((RectF)object2, (Region.Op)object);
            object2 = this.b;
            object = this.a;
            object2.set((RectF)object);
            object2 = this.b;
            n11 = this.z;
            n10 = -n11;
            f10 = n10;
            f11 = n11;
            object2.inset(f10, f11);
            object2 = this.b;
            object = Region.Op.DIFFERENCE;
            canvas.clipRect((RectF)object2, (Region.Op)object);
            object2 = this.a;
            object = this.s;
            canvas.drawRect((RectF)object2, object);
            canvas.restore();
        }
    }

    public void b(Canvas canvas) {
        Region.Op op;
        Path path;
        canvas.save();
        int n10 = this.m;
        if (n10 != 0) {
            path = this.o;
            op = Region.Op.DIFFERENCE;
            canvas.clipPath(path, op);
        } else {
            path = this.a;
            op = Region.Op.DIFFERENCE;
            canvas.clipRect((RectF)path, op);
        }
        n10 = this.n;
        canvas.drawColor(n10);
        canvas.restore();
        n10 = (int)(this.m ? 1 : 0);
        if (n10 != 0) {
            path = this.a;
            float f10 = path.centerX();
            op = this.a;
            float f11 = op.centerY();
            RectF rectF = this.a;
            float f12 = rectF.width();
            float f13 = this.a.height();
            f12 = Math.min(f12, f13);
            f13 = 2.0f;
            Paint paint = this.p;
            canvas.drawCircle(f10, f11, f12 /= f13, paint);
        }
    }

    public void d() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 < n11) {
            n10 = 1;
            n11 = 0;
            this.setLayerType(n10, null);
        }
    }

    public boolean g() {
        int n10 = this.t;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public RectF getCropViewRect() {
        return this.a;
    }

    public int getFreestyleCropMode() {
        return this.t;
    }

    public d getOverlayViewChangeListener() {
        return this.A;
    }

    public void h(TypedArray typedArray) {
        boolean bl2;
        int n10 = R$styleable.ucrop_UCropView_ucrop_circle_dimmed_layer;
        n10 = (int)(typedArray.getBoolean(n10, false) ? 1 : 0);
        this.m = n10;
        n10 = R$styleable.ucrop_UCropView_ucrop_dimmed_color;
        Resources resources = this.getResources();
        int n11 = R$color.ucrop_color_default_dimmed;
        int bl3 = resources.getColor(n11);
        this.n = n10 = typedArray.getColor(n10, bl3);
        this.p.setColor(n10);
        Paint paint = this.p;
        resources = Paint.Style.STROKE;
        paint.setStyle((Paint.Style)resources);
        this.p.setStrokeWidth(1.0f);
        this.e(typedArray);
        n10 = R$styleable.ucrop_UCropView_ucrop_show_frame;
        boolean bl4 = true;
        n10 = (int)(typedArray.getBoolean(n10, bl4) ? 1 : 0);
        this.k = n10;
        this.f(typedArray);
        n10 = R$styleable.ucrop_UCropView_ucrop_show_grid;
        this.l = bl2 = typedArray.getBoolean(n10, bl4);
    }

    public void i() {
        Object object;
        int n10 = this.c;
        float f10 = n10;
        float f11 = this.i;
        int n11 = (int)(f10 /= f11);
        int n12 = this.d;
        if (n11 > n12) {
            n11 = (int)((float)n12 * f11);
            n10 = (n10 - n11) / 2;
            RectF rectF = this.a;
            n12 = this.getPaddingLeft() + n10;
            float f12 = n12;
            int n13 = this.getPaddingTop();
            float f13 = n13;
            float f14 = this.getPaddingLeft() + n11 + n10;
            n11 = this.getPaddingTop();
            int n14 = this.d;
            f10 = n11 += n14;
            rectF.set(f12, f13, f14, f10);
        } else {
            n12 = (n12 - n11) / 2;
            object = this.a;
            int n15 = this.getPaddingLeft();
            f11 = n15;
            int n16 = this.getPaddingTop() + n12;
            float f15 = n16;
            int n17 = this.getPaddingLeft();
            int n18 = this.c;
            float f16 = n17 += n18;
            n18 = this.getPaddingTop() + n11 + n12;
            f10 = n18;
            object.set(f11, f15, f16, f10);
        }
        object = this.A;
        if (object != null) {
            RectF rectF = this.a;
            object.a(rectF);
        }
        this.k();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.b(canvas);
        this.a(canvas);
    }

    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        int n14;
        int n15;
        int n16;
        int n17;
        super.onLayout(bl2, n17, n16, n15, n14);
        if (bl2) {
            int n18 = this.getPaddingLeft();
            n17 = this.getPaddingTop();
            n16 = this.getWidth();
            n15 = this.getPaddingRight();
            n16 -= n15;
            n15 = this.getHeight();
            n14 = this.getPaddingBottom();
            n15 -= n14;
            this.c = n16 -= n18;
            this.d = n15 -= n17;
            boolean bl3 = this.B;
            if (bl3) {
                boolean bl4 = false;
                this.B = false;
                float f10 = this.i;
                this.setTargetAspectRatio(f10);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent object) {
        RectF rectF = this.a;
        int n10 = rectF.isEmpty();
        int n11 = 0;
        float f10 = 0.0f;
        if (n10 == 0 && (n10 = this.t) != 0) {
            int n12;
            float f11 = object.getX();
            float f12 = object.getY();
            int n13 = object.getAction() & 0xFF;
            int n14 = -1;
            float f13 = -1.0f;
            int n15 = 1;
            float f14 = Float.MIN_VALUE;
            if (n13 == 0) {
                int n16;
                this.w = n16 = this.c(f11, f12);
                if (n16 != n14) {
                    n11 = n15;
                    f10 = f14;
                }
                if (n11 == 0) {
                    this.u = f13;
                    this.v = f13;
                } else {
                    float f15 = this.u;
                    n13 = 0;
                    float f16 = f15 - 0.0f;
                    n16 = (int)(f16 == 0.0f ? 0 : (f16 < 0.0f ? -1 : 1));
                    if (n16 < 0) {
                        this.u = f11;
                        this.v = f12;
                    }
                }
                return n11 != 0;
            }
            n13 = object.getAction() & 0xFF;
            if (n13 == (n12 = 2) && (n13 = object.getPointerCount()) == n15 && (n13 = this.w) != n14) {
                float f17 = this.getPaddingLeft();
                f17 = Math.max(f11, f17);
                n10 = this.getWidth();
                n11 = this.getPaddingRight();
                f11 = n10 - n11;
                f17 = Math.min(f17, f11);
                f11 = this.getPaddingTop();
                f11 = Math.max(f12, f11);
                n11 = this.getHeight();
                int n17 = this.getPaddingBottom();
                f10 = n11 - n17;
                f11 = Math.min(f11, f10);
                this.j(f17, f11);
                this.u = f17;
                this.v = f11;
                return n15 != 0;
            }
            int n18 = object.getAction() & 0xFF;
            if (n18 == n15) {
                this.u = f13;
                this.v = f13;
                this.w = n14;
                object = this.A;
                if (object != null) {
                    rectF = this.a;
                    object.a(rectF);
                }
            }
        }
        return false;
    }

    public void setCircleDimmedLayer(boolean bl2) {
        this.m = bl2;
    }

    public void setCropFrameColor(int n10) {
        this.r.setColor(n10);
    }

    public void setCropFrameStrokeWidth(int n10) {
        Paint paint = this.r;
        float f10 = n10;
        paint.setStrokeWidth(f10);
    }

    public void setCropGridColor(int n10) {
        this.q.setColor(n10);
    }

    public void setCropGridColumnCount(int n10) {
        this.h = n10;
        this.j = null;
    }

    public void setCropGridRowCount(int n10) {
        this.g = n10;
        this.j = null;
    }

    public void setCropGridStrokeWidth(int n10) {
        Paint paint = this.q;
        float f10 = n10;
        paint.setStrokeWidth(f10);
    }

    public void setDimmedColor(int n10) {
        this.n = n10;
    }

    public void setFreestyleCropEnabled(boolean bl2) {
        this.t = (int)(bl2 ? 1 : 0);
    }

    public void setFreestyleCropMode(int n10) {
        this.t = n10;
        this.postInvalidate();
    }

    public void setOverlayViewChangeListener(d d10) {
        this.A = d10;
    }

    public void setShowCropFrame(boolean bl2) {
        this.k = bl2;
    }

    public void setShowCropGrid(boolean bl2) {
        this.l = bl2;
    }

    public void setTargetAspectRatio(float f10) {
        this.i = f10;
        int n10 = this.c;
        if (n10 > 0) {
            this.i();
            this.postInvalidate();
        } else {
            n10 = 1;
            f10 = Float.MIN_VALUE;
            this.B = n10;
        }
    }
}

