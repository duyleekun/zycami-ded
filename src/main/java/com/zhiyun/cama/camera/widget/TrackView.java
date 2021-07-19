/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Paint$Cap
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.RectF
 *  android.text.TextPaint
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 */
package com.zhiyun.cama.camera.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.zhiyun.cama.camera.widget.TrackView$AreaSelectedState;
import com.zhiyun.cama.camera.widget.TrackView$Ratio;
import com.zhiyun.cama.camera.widget.TrackView$a;
import com.zhiyun.cama.camera.widget.TrackView$b;
import com.zhiyun.cama.camera.widget.TrackView$c;
import d.v.e.l.h2;

public class TrackView
extends View {
    private static final Boolean M = Boolean.FALSE;
    private static int N = 0;
    private static int O = 0;
    private static final float P = 100.0f;
    private boolean A;
    private boolean B;
    private TrackView$c C;
    private boolean D;
    private float E;
    private boolean F;
    private boolean G;
    private TrackView$AreaSelectedState H;
    private boolean I;
    private boolean J;
    private boolean K;
    private long L;
    private final float a;
    private int b;
    private int c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private Paint j;
    private Paint k;
    private Paint l;
    private TextPaint m;
    private float n;
    private float o;
    private float p;
    private float q;
    private RectF r;
    private RectF s;
    private RectF t;
    private Path u;
    private boolean v;
    private Bitmap w;
    private int x;
    public TrackView$AreaSelectedState y;
    private TrackView$b z;

    static {
        N = 0x63FFFFFF;
        O = 1677678680;
    }

    public TrackView(Context object) {
        super(object);
        boolean bl2;
        float f10;
        float f11;
        this.a = f11 = this.getContext().getResources().getDisplayMetrics().density;
        this.b = -1;
        this.c = -16711936;
        float f12 = 2.0f;
        this.d = f10 = f11 * f12;
        this.e = f10 *= f12;
        this.f = f10 = 3.0f * f11;
        this.g = f11 *= 6.0f;
        this.h = f11 *= f12;
        this.i = 80.0f;
        super();
        this.r = object;
        super();
        this.s = object;
        super();
        this.t = object;
        super();
        this.u = object;
        this.v = false;
        object = BitmapFactory.decodeResource((Resources)this.getResources(), (int)2131231689);
        this.w = object;
        object = TrackView$AreaSelectedState.STARTED;
        this.y = object;
        this.I = bl2 = true;
        this.J = bl2;
        this.j();
    }

    public TrackView(Context object, AttributeSet attributeSet) {
        super(object, attributeSet);
        boolean bl2;
        float f10;
        float f11;
        this.a = f11 = this.getContext().getResources().getDisplayMetrics().density;
        this.b = -1;
        this.c = -16711936;
        float f12 = 2.0f;
        this.d = f10 = f11 * f12;
        this.e = f10 *= f12;
        this.f = f10 = 3.0f * f11;
        this.g = f11 *= 6.0f;
        this.h = f11 *= f12;
        this.i = 80.0f;
        super();
        this.r = object;
        super();
        this.s = object;
        super();
        this.t = object;
        super();
        this.u = object;
        this.v = false;
        object = BitmapFactory.decodeResource((Resources)this.getResources(), (int)2131231689);
        this.w = object;
        object = TrackView$AreaSelectedState.STARTED;
        this.y = object;
        this.I = bl2 = true;
        this.J = bl2;
        this.j();
    }

    private void b(Canvas canvas) {
        RectF rectF = this.s;
        Paint paint = this.k;
        canvas.drawRect(rectF, paint);
    }

    private void c(Canvas canvas) {
        String string2 = this.s.toShortString();
        float f10 = this.m.measureText(string2);
        float f11 = this.s.centerX();
        f10 = this.s.centerY();
        TextPaint textPaint = this.m;
        canvas.drawText(string2, f11 -= (f10 /= 2.0f), f10, (Paint)textPaint);
    }

    private void d(Canvas canvas) {
        block4: {
            float f10;
            float f11;
            RectF rectF;
            block2: {
                block3: {
                    float f12;
                    rectF = this.t;
                    RectF rectF2 = this.getRectF();
                    rectF.set(rectF2);
                    rectF = this.t;
                    rectF2 = this.l;
                    canvas.drawRect(rectF, (Paint)rectF2);
                    rectF = this.u;
                    rectF2 = this.j;
                    canvas.drawPath((Path)rectF, (Paint)rectF2);
                    f11 = this.E;
                    f10 = 3.0f;
                    Object object = f11 == f10 ? 0 : (f11 > f10 ? 1 : -1);
                    if (object == false || (object = (f12 = f11 - (f10 = 1.0f)) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1)) == false) break block2;
                    float f13 = f11 - 0.0f;
                    object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
                    if (object == false) break block3;
                    object = 0x40000000;
                    f10 = 2.0f;
                    float f14 = f11 - f10;
                    Object object2 = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
                    if (object2 != false) break block4;
                }
                rectF = this.t;
                f10 = rectF.left;
                int n10 = this.x;
                float f15 = n10;
                f11 = rectF.top;
                float f16 = n10;
                canvas.translate(f10 -= f15, f11 -= f16);
                rectF = this.w;
                canvas.drawBitmap((Bitmap)rectF, 0.0f, 0.0f, null);
                break block4;
            }
            rectF = this.t;
            f10 = rectF.right;
            int n11 = this.x;
            float f17 = n11;
            f11 = rectF.top;
            float f18 = n11;
            canvas.translate(f10 -= f17, f11 -= f18);
            rectF = this.w;
            canvas.drawBitmap((Bitmap)rectF, 0.0f, 0.0f, null);
        }
    }

    private Path g(float f10) {
        TrackView$AreaSelectedState trackView$AreaSelectedState;
        float f11;
        float f12;
        float f13;
        Path path = new Path();
        RectF rectF = this.s;
        float f14 = rectF.left + f10;
        float f15 = rectF.top + f10;
        float f16 = Math.abs(rectF.right - f10);
        float f17 = this.s.bottom - f10;
        f10 = Math.abs(f17);
        Object object = this.s;
        float f18 = object.right;
        float f19 = f14 - f18;
        Object object2 = f19 == 0.0f ? 0 : (f19 > 0.0f ? 1 : -1);
        if (object2 > 0) {
            f14 = f18;
        }
        if ((f13 = (f12 = f15 - (f17 = object.bottom)) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1)) > 0) {
            f15 = f17;
        }
        if ((f11 = f16 == f14 ? 0 : (f16 < f14 ? -1 : 1)) < 0) {
            f16 = f14;
        }
        if ((f11 = f10 == f15 ? 0 : (f10 < f15 ? -1 : 1)) < 0) {
            f10 = f15;
        }
        if ((f11 = (float)this.l()) == false && (object = this.y) == (trackView$AreaSelectedState = TrackView$AreaSelectedState.COMPLETED)) {
            object = this.s;
            f18 = object.left;
            f17 = object.top;
            path.moveTo(f18, f17);
            f17 = this.s.top;
            path.lineTo(f14, f17);
            object = this.s;
            f18 = object.left;
            f17 = object.top;
            path.moveTo(f18, f17);
            object = this.s;
            f17 = object.left;
            path.lineTo(f17, f15);
        }
        if ((f11 = (float)this.l()) != false && (object = this.y) == (trackView$AreaSelectedState = TrackView$AreaSelectedState.COMPLETED)) {
            object = this.s;
            f18 = object.right;
            f17 = object.top;
            path.moveTo(f18, f17);
            f17 = this.s.top;
            path.lineTo(f16, f17);
            object = this.s;
            f18 = object.right;
            f17 = object.top;
            path.moveTo(f18, f17);
            object = this.s;
            f17 = object.right;
            path.lineTo(f17, f15);
        }
        RectF rectF2 = this.s;
        f17 = rectF2.left;
        f15 = rectF2.bottom;
        path.moveTo(f17, f15);
        f15 = this.s.bottom;
        path.lineTo(f14, f15);
        RectF rectF3 = this.s;
        f15 = rectF3.left;
        f14 = rectF3.bottom;
        path.moveTo(f15, f14);
        f14 = this.s.left;
        path.lineTo(f14, f10);
        rectF3 = this.s;
        f15 = rectF3.right;
        f14 = rectF3.bottom;
        path.moveTo(f15, f14);
        f14 = this.s.bottom;
        path.lineTo(f16, f14);
        rectF = this.s;
        f14 = rectF.right;
        f16 = rectF.bottom;
        path.moveTo(f14, f16);
        f16 = this.s.right;
        path.lineTo(f16, f10);
        path.close();
        return path;
    }

    private RectF getRectF() {
        float f10;
        float f11 = this.n;
        float f12 = this.o;
        float f13 = this.p;
        float f14 = this.q;
        Object object = f13 == f11 ? 0 : (f13 < f11 ? -1 : 1);
        if (object < 0) {
            f10 = f13;
            f13 = f11;
            f11 = f10;
        }
        if ((object = f14 == f12 ? 0 : (f14 < f12 ? -1 : 1)) < 0) {
            f10 = f14;
            f14 = f12;
            f12 = f10;
        }
        float f15 = this.e / 2.0f;
        float f16 = 0.0f + f15;
        float f17 = (float)this.getWidth() - f15;
        float f18 = (float)this.getHeight() - f15;
        f11 = Math.max(f11, f16);
        f12 = Math.max(f12, f16);
        f13 = Math.min(f13, f17);
        f14 = Math.min(f14, f18);
        RectF rectF = new RectF(f11, f12, f13, f14);
        return rectF;
    }

    /*
     * Unable to fully structure code
     */
    private int h(int var1_1, TrackView$Ratio var2_2) {
        var3_3 = View.MeasureSpec.getMode((int)var1_1);
        var1_1 = View.MeasureSpec.getSize((int)var1_1);
        var4_4 = 0x40000000;
        if (var3_3 != var4_4) {
            var5_5 = TrackView$Ratio.WIDTH;
            if (var2_2 == var5_5) {
                var6_6 = this.getPaddingStart() + var1_1;
                var4_4 = this.getPaddingEnd();
lbl9:
                // 2 sources

                while (true) {
                    var6_6 += var4_4;
                    break;
                }
            } else {
                var5_5 = TrackView$Ratio.HEIGHT;
                if (var2_2 == var5_5) {
                    var6_6 = this.getPaddingTop() + var1_1;
                    var4_4 = this.getPaddingBottom();
                    ** continue;
                }
                var6_6 = 0;
                var2_2 = null;
            }
            var4_4 = -1 << -1;
            var1_1 = var3_3 == var4_4 ? Math.min(var1_1, var6_6) : var6_6;
        }
        return var1_1;
    }

    private void j() {
        int n10;
        long l10;
        this.L = l10 = Thread.currentThread().getId();
        this.k();
        this.x = n10 = h2.b(12.0f);
    }

    private void k() {
        Paint paint;
        boolean bl2 = true;
        this.k = paint = new Paint((int)(bl2 ? 1 : 0));
        int n10 = this.b;
        paint.setColor(n10);
        paint = this.k;
        Paint.Style style2 = Paint.Style.STROKE;
        paint.setStyle(style2);
        paint = this.k;
        float f10 = this.d;
        paint.setStrokeWidth(f10);
        this.j = paint = new Paint((int)(bl2 ? 1 : 0));
        n10 = this.c;
        paint.setColor(n10);
        paint = this.j;
        style2 = Paint.Style.STROKE;
        paint.setStyle(style2);
        paint = this.j;
        f10 = this.f;
        paint.setStrokeWidth(f10);
        paint = this.j;
        style2 = Paint.Cap.ROUND;
        paint.setStrokeCap((Paint.Cap)style2);
        this.l = paint = new Paint((int)(bl2 ? 1 : 0));
        style2 = Paint.Style.STROKE;
        paint.setStyle(style2);
        paint = this.l;
        f10 = this.f;
        paint.setStrokeWidth(f10);
        paint = this.l;
        n10 = N;
        paint.setColor(n10);
        this.l.setAlpha(12);
        paint = new TextPaint();
        this.m = paint;
        f10 = this.a * 12.0f;
        paint.setTextSize(f10);
        this.m.setColor(-16776961);
        this.m.setAntiAlias(bl2);
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean l() {
        void var4_8;
        float f10 = this.E;
        float f11 = 0.0f;
        float f12 = f10 - 0.0f;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            int n10 = 0x40000000;
            f11 = 2.0f;
            float f13 = f10 - f11;
            Object object2 = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
            if (object2 != false) return (boolean)var4_8;
        }
        boolean bl2 = true;
        return (boolean)var4_8;
    }

    private boolean m(RectF rectF) {
        float f10 = Math.abs(rectF.width());
        float f11 = this.i;
        float f12 = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
        boolean bl2 = true;
        f11 = Float.MIN_VALUE;
        if (f12 >= 0) {
            f12 = (float)bl2;
            f10 = f11;
        } else {
            f12 = 0.0f;
            f10 = 0.0f;
        }
        float f13 = Math.abs(rectF.height());
        float f14 = this.i;
        float f15 = f13 == f14 ? 0 : (f13 > f14 ? 1 : -1);
        if (f15 >= 0) {
            f15 = (float)bl2;
            f13 = f11;
        } else {
            f15 = 0.0f;
            rectF = null;
            f13 = 0.0f;
        }
        if (f12 == false || f15 == false) {
            bl2 = false;
            f11 = 0.0f;
        }
        return bl2;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean n() {
        void var3_7;
        float f10 = this.p;
        float f11 = this.n;
        float f12 = (f10 = Math.abs(f10 - f11)) - (f11 = 100.0f);
        Object object = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
        if (object >= 0) {
            f10 = this.q;
            float f13 = this.o;
            float f14 = (f10 = Math.abs(f10 - f13)) - f11;
            Object object2 = f14 == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1);
            if (object2 >= 0) {
                return (boolean)var3_7;
            }
        }
        boolean bl2 = true;
        return (boolean)var3_7;
    }

    private void q() {
        Object object = this.z;
        if (object == null) {
            return;
        }
        object = TrackView$a.a;
        TrackView$AreaSelectedState trackView$AreaSelectedState = this.y;
        int n10 = trackView$AreaSelectedState.ordinal();
        Object object2 = object[n10];
        if (object2 != (n10 = 1)) {
            n10 = 3;
            if (object2 != n10) {
                n10 = 4;
                if (object2 == n10) {
                    object = this.z;
                    ((TrackView$b)object).b();
                }
            } else {
                object = this.z;
                trackView$AreaSelectedState = this.r;
                RectF rectF = this.s;
                ((TrackView$b)object).a((RectF)trackView$AreaSelectedState, rectF);
            }
        } else {
            object = this.z;
            ((TrackView$b)object).c();
        }
    }

    private void s() {
        RectF rectF = this.getRectF();
        this.setTrackRectF(rectF);
    }

    private void setTrackRectF(RectF rectF) {
        this.s.set(rectF);
        float f10 = this.h;
        rectF = this.g(f10);
        this.u = rectF;
        this.invalidate();
    }

    public void a() {
        long l10;
        Object object = TrackView$AreaSelectedState.INVALID;
        this.y = object;
        object = Thread.currentThread();
        long l11 = ((Thread)object).getId();
        long l12 = l11 - (l10 = this.L);
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false) {
            this.invalidate();
        } else {
            this.postInvalidate();
        }
    }

    public void e(boolean bl2) {
        this.J = bl2;
    }

    public void f(boolean bl2) {
        this.I = bl2;
    }

    public RectF getCenterArea() {
        RectF rectF = this.getTrackArea();
        float f10 = rectF.centerX();
        float f11 = rectF.centerY();
        float f12 = 20.0f;
        float f13 = f10 - f12;
        float f14 = f11 - f12;
        RectF rectF2 = new RectF(f13, f14, f10 += f12, f11 += f12);
        return rectF2;
    }

    public float getRotation() {
        return this.E;
    }

    public RectF getTrackArea() {
        return this.r;
    }

    public void i(boolean bl2) {
        this.D = bl2;
    }

    public boolean o(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
        return this.onTouchEvent(motionEvent2);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.z = null;
    }

    public void onDraw(Canvas canvas) {
        int[] nArray = TrackView$a.a;
        TrackView$AreaSelectedState trackView$AreaSelectedState = this.y;
        int n10 = trackView$AreaSelectedState.ordinal();
        int n11 = nArray[n10];
        if (n11 != (n10 = 1) && n11 != (n10 = 2)) {
            n10 = 3;
            if (n11 == n10) {
                this.d(canvas);
            }
        } else {
            this.b(canvas);
        }
    }

    public void onMeasure(int n10, int n11) {
        TrackView$Ratio trackView$Ratio = TrackView$Ratio.WIDTH;
        n10 = this.h(n10, trackView$Ratio);
        trackView$Ratio = TrackView$Ratio.HEIGHT;
        n11 = this.h(n11, trackView$Ratio);
        this.setMeasuredDimension(n10, n11);
    }

    public void onSizeChanged(int n10, int n11, int n12, int n13) {
        super.onSizeChanged(n10, n11, n12, n13);
        RectF rectF = this.r;
        float f10 = n10;
        float f11 = n11;
        rectF.set(0.0f, 0.0f, f10, f11);
    }

    public boolean onTouchEvent(MotionEvent object) {
        boolean bl2;
        float f10;
        int n10;
        float f11;
        int n11;
        int n12;
        block27: {
            TrackView$AreaSelectedState trackView$AreaSelectedState;
            float f12;
            float f13;
            int n13;
            RectF rectF;
            block24: {
                TrackView$AreaSelectedState trackView$AreaSelectedState2;
                float f14;
                block25: {
                    boolean bl3;
                    float f15;
                    block26: {
                        n12 = this.getVisibility();
                        n11 = 0;
                        f11 = 0.0f;
                        rectF = null;
                        if (n12 != 0) {
                            return false;
                        }
                        n12 = (int)(this.I ? 1 : 0);
                        if (n12 == 0) {
                            return false;
                        }
                        n12 = object.getAction();
                        n13 = 3;
                        f13 = 4.2E-45f;
                        n10 = 1;
                        f10 = Float.MIN_VALUE;
                        if (n12 != n10 && (n12 = object.getAction()) != n13) {
                            n12 = n10;
                            f12 = f10;
                        } else {
                            n12 = 0;
                            trackView$AreaSelectedState = null;
                            f12 = 0.0f;
                        }
                        this.F = n12;
                        n12 = object.getPointerCount();
                        if (n12 > n10) {
                            this.G = n10;
                            object = this.y;
                            trackView$AreaSelectedState = TrackView$AreaSelectedState.COMPLETED;
                            if (object != trackView$AreaSelectedState) {
                                this.a();
                            }
                            return false;
                        }
                        n12 = object.getAction();
                        if (n12 == 0) break block24;
                        if (n12 == n10) break block25;
                        int n14 = 2;
                        f14 = 2.8E-45f;
                        if (n12 == n14) break block26;
                        if (n12 == n13) break block25;
                        break block27;
                    }
                    n12 = this.G;
                    if (n12 != 0) {
                        return n10;
                    }
                    n12 = (int)(this.B ? 1 : 0);
                    if (n12 != 0) {
                        return n10;
                    }
                    n12 = (int)(this.J ? 1 : 0);
                    if (n12 == 0) {
                        return n10;
                    }
                    this.v = n10;
                    this.p = f12 = object.getX();
                    this.q = f15 = object.getY();
                    object = this.y;
                    trackView$AreaSelectedState = TrackView$AreaSelectedState.COMPLETED;
                    if (object == trackView$AreaSelectedState && (bl3 = this.n())) {
                        return n10;
                    }
                    object = TrackView$AreaSelectedState.SELECTING;
                    this.y = object;
                    this.s();
                    this.invalidate();
                    return n10;
                }
                if ((n12 = (int)(this.J ? 1 : 0)) == 0) {
                    return n10;
                }
                n12 = this.B;
                if (n12 != 0) {
                    this.B = false;
                    object = this.y;
                    trackView$AreaSelectedState = TrackView$AreaSelectedState.STARTED;
                    if (object == trackView$AreaSelectedState) {
                        this.a();
                    }
                    return n10;
                }
                n12 = (int)(this.G ? 1 : 0);
                if (n12 != 0) {
                    object = this.H;
                    trackView$AreaSelectedState = TrackView$AreaSelectedState.COMPLETED;
                    if (object != trackView$AreaSelectedState) {
                        this.a();
                    }
                    this.G = false;
                    return n10;
                }
                n12 = (int)(this.n() ? 1 : 0);
                if (n12 != 0 && (trackView$AreaSelectedState = this.y) == (trackView$AreaSelectedState2 = TrackView$AreaSelectedState.COMPLETED)) {
                    float f16;
                    object = this.t;
                    this.n = f12 = object.left;
                    this.o = f12 = object.top;
                    this.p = f12 = object.right;
                    this.q = f16 = object.bottom;
                    this.invalidate();
                    return n10;
                }
                this.p = f12 = object.getX();
                this.q = f12 = object.getY();
                trackView$AreaSelectedState2 = this.t;
                f14 = this.n;
                float f17 = this.o;
                float f18 = this.p;
                trackView$AreaSelectedState2.set(f14, f17, f18, f12);
                n12 = (int)(this.v ? 1 : 0);
                if (n12 != 0 && (n12 = (int)(this.m((RectF)(trackView$AreaSelectedState = this.t)) ? 1 : 0)) != 0) {
                    n12 = (int)(this.l() ? 1 : 0);
                    this.K = n12;
                    this.y = trackView$AreaSelectedState = TrackView$AreaSelectedState.COMPLETED;
                    this.q();
                    this.s();
                } else {
                    this.y = trackView$AreaSelectedState = TrackView$AreaSelectedState.INVALID;
                    this.a();
                    this.q();
                }
                break block27;
            }
            this.v = false;
            this.n = f12 = (float)((int)object.getX());
            n12 = (int)object.getY();
            this.o = f12 = (float)n12;
            this.H = trackView$AreaSelectedState = this.y;
            TrackView$AreaSelectedState trackView$AreaSelectedState3 = TrackView$AreaSelectedState.COMPLETED;
            if (trackView$AreaSelectedState == trackView$AreaSelectedState3) {
                n12 = (int)(this.l() ? 1 : 0);
                if (n12 != 0) {
                    trackView$AreaSelectedState = this.t;
                    f12 = ((RectF)trackView$AreaSelectedState).left;
                    n11 = this.x;
                } else {
                    trackView$AreaSelectedState = this.t;
                    f12 = ((RectF)trackView$AreaSelectedState).right;
                    n11 = this.x;
                }
                f11 = n11;
                f12 -= f11;
                rectF = this.t;
                f11 = rectF.top;
                n13 = this.x;
                f13 = n13;
                Bitmap bitmap = this.w;
                int n15 = bitmap.getWidth();
                float f19 = (float)n15 + f12;
                Bitmap bitmap2 = this.w;
                float f20 = (float)bitmap2.getHeight() + (f11 -= f13);
                trackView$AreaSelectedState3 = new RectF(f12, f11, f19, f20);
                trackView$AreaSelectedState = new Matrix();
                f11 = trackView$AreaSelectedState3.centerX();
                f19 = trackView$AreaSelectedState3.centerY();
                f20 = 1.3f;
                trackView$AreaSelectedState.setScale(f20, f20, f11, f19);
                trackView$AreaSelectedState.mapRect((RectF)trackView$AreaSelectedState3);
                f12 = object.getX();
                float f21 = object.getY();
                boolean bl4 = trackView$AreaSelectedState3.contains(f12, f21);
                if (bl4) {
                    this.B = n10;
                    object = TrackView$AreaSelectedState.STARTED;
                    this.y = object;
                    object = this.C;
                    if (object != null) {
                        object.a();
                    }
                }
                return n10;
            }
            this.y = trackView$AreaSelectedState = TrackView$AreaSelectedState.STARTED;
            this.q();
        }
        n12 = (int)(this.D ? 1 : 0);
        if (n12 != 0 || (bl2 = super.onTouchEvent(object))) {
            n11 = n10;
            f11 = f10;
        }
        return n11 != 0;
    }

    public void p() {
        TrackView$AreaSelectedState trackView$AreaSelectedState;
        this.s.setEmpty();
        this.y = trackView$AreaSelectedState = TrackView$AreaSelectedState.COMPLETED;
        this.s();
        this.invalidate();
    }

    public void r() {
        TrackView$AreaSelectedState trackView$AreaSelectedState;
        this.y = trackView$AreaSelectedState = TrackView$AreaSelectedState.COMPLETED;
        this.setSelectRectRed(true);
        this.invalidate();
    }

    public void setOnAreaSelectedListener(TrackView$b trackView$b) {
        this.z = trackView$b;
    }

    public void setOnCloseClickListener(TrackView$c trackView$c) {
        this.C = trackView$c;
    }

    public void setRotation(float f10) {
        this.E = f10;
    }

    public void setSelectRectRed(boolean bl2) {
        Paint paint = this.l;
        if (paint != null) {
            int n10 = bl2 ? O : N;
            paint.setColor(n10);
            paint = this.l;
            Paint.Style style2 = bl2 ? Paint.Style.FILL_AND_STROKE : Paint.Style.STROKE;
            paint.setStyle(style2);
        }
    }

    public void setTrackArea(RectF object) {
        this.s.set(object);
        object = TrackView$AreaSelectedState.COMPLETED;
        this.y = object;
        this.q();
    }

    public void t(RectF rectF) {
        float f10;
        if (rectF == null) {
            return;
        }
        boolean bl2 = this.F;
        if (bl2) {
            return;
        }
        this.n = f10 = rectF.left;
        this.o = f10 = rectF.top;
        this.p = f10 = rectF.right;
        this.q = f10 = rectF.bottom;
        this.s.set(rectF);
        float f11 = this.h;
        rectF = this.g(f11);
        this.u = rectF;
        rectF = this.s;
        this.setTrackRectF(rectF);
    }
}

