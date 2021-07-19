/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.Paint
 *  android.graphics.Paint$Align
 *  android.graphics.Paint$Style
 *  android.graphics.Rect
 *  android.os.Handler
 *  android.text.Layout$Alignment
 *  android.text.StaticLayout
 *  android.text.TextPaint
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewConfiguration
 *  android.widget.Scroller
 */
package com.zhiyun.cama.camera.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import com.zhiyun.cama.R$styleable;
import com.zhiyun.cama.camera.widget.WheelPicker$a;
import com.zhiyun.cama.camera.widget.WheelPicker$b;
import d.v.c.s0.i7.l;
import java.text.Format;
import java.util.ArrayList;
import java.util.List;

public class WheelPicker
extends View {
    private int A;
    private Rect B;
    private Rect C;
    private int D;
    private int E;
    private int F;
    private Scroller G;
    private int H;
    private boolean I;
    private VelocityTracker J;
    private int K;
    private int L;
    private int M;
    private boolean N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private boolean S;
    private l T;
    private Handler U;
    private WheelPicker$b V;
    private boolean W;
    private List a;
    private Format b;
    private int c;
    private int d;
    private TextPaint e;
    private boolean f;
    private int g;
    private int h;
    private TextPaint i;
    private String j;
    private int k;
    private Runnable k0;
    private int l;
    private TextPaint m;
    private Paint n;
    private int o;
    private int p;
    private String q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private boolean w;
    private boolean x;
    private int y;
    private boolean z;

    public WheelPicker(Context context) {
        this(context, null);
    }

    public WheelPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WheelPicker(Context context, AttributeSet object, int n10) {
        super(context, object, n10);
        int n11;
        Handler handler;
        Object object2 = new ArrayList();
        this.a = object2;
        n10 = 1;
        this.N = n10;
        this.Q = 50;
        this.R = 12000;
        this.U = handler = new Handler();
        this.W = n10;
        this.k0 = object2 = new WheelPicker$a(this);
        this.o(context, (AttributeSet)object);
        this.p();
        n10 = this.c;
        int n12 = this.g;
        super(n10, n12);
        this.T = object;
        super();
        this.B = object;
        super();
        this.C = object;
        super(context);
        this.G = object;
        this.H = n11 = ViewConfiguration.get((Context)context).getScaledTouchSlop();
    }

    public static /* synthetic */ Scroller a(WheelPicker wheelPicker) {
        return wheelPicker.G;
    }

    public static /* synthetic */ int b(WheelPicker wheelPicker) {
        return wheelPicker.L;
    }

    public static /* synthetic */ int c(WheelPicker wheelPicker, int n10) {
        wheelPicker.L = n10;
        return n10;
    }

    public static /* synthetic */ Handler d(WheelPicker wheelPicker) {
        return wheelPicker.U;
    }

    public static /* synthetic */ int e(WheelPicker wheelPicker) {
        return wheelPicker.u;
    }

    public static /* synthetic */ int f(WheelPicker wheelPicker, int n10) {
        return wheelPicker.n(n10);
    }

    public static /* synthetic */ int g(WheelPicker wheelPicker) {
        return wheelPicker.v;
    }

    public static /* synthetic */ int h(WheelPicker wheelPicker, int n10) {
        wheelPicker.v = n10;
        return n10;
    }

    public static /* synthetic */ WheelPicker$b i(WheelPicker wheelPicker) {
        return wheelPicker.V;
    }

    public static /* synthetic */ List j(WheelPicker wheelPicker) {
        return wheelPicker.a;
    }

    private int k(int n10) {
        int n11;
        int n12;
        int n13 = Math.abs(n10);
        if (n13 > (n12 = (n11 = this.u) / 2)) {
            n13 = this.L;
            if (n13 < 0) {
                return -n11 - n10;
            }
            return n11 - n10;
        }
        return -n10;
    }

    private void l() {
        int n10 = this.N;
        if (n10 != 0) {
            n10 = -1 << -1;
        } else {
            n10 = -this.u;
            List list = this.a;
            int n11 = list.size() + -1;
            n10 *= n11;
        }
        this.P = n10;
        n10 = (int)(this.N ? 1 : 0);
        n10 = n10 != 0 ? -1 >>> 1 : 0;
        this.O = n10;
    }

    private void m() {
        int n10 = 0;
        float f10 = 0.0f;
        Object object = null;
        this.p = 0;
        this.o = 0;
        Object object2 = this.a;
        int n11 = object2.size();
        if (n11 == 0) {
            return;
        }
        object2 = this.n;
        int n12 = this.h;
        int n13 = this.d;
        float f11 = n12 > n13 ? (float)n12 : (float)n13;
        object2.setTextSize(f11);
        object2 = this.q;
        n11 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
        if (n11 == 0) {
            object = this.n;
            object2 = this.q;
            f10 = object.measureText((String)object2);
            this.o = n10 = (int)f10;
        } else {
            object2 = this.n;
            List list = this.a;
            object = list.get(0).toString();
            f10 = object2.measureText((String)object);
            this.o = n10 = (int)f10;
        }
        object = this.n.getFontMetrics();
        float f12 = object.bottom;
        f10 = object.top;
        this.p = n10 = (int)(f12 - f10);
    }

    private int n(int n10) {
        int n11;
        List list;
        if (n10 < 0) {
            list = this.a;
            n11 = list.size();
            List list2 = this.a;
            int n12 = list2.size();
            n10 = n10 % n12 + n11;
        }
        if (n10 >= (n11 = (list = this.a).size())) {
            list = this.a;
            n11 = list.size();
            n10 %= n11;
        }
        return n10;
    }

    private void o(Context context, AttributeSet object) {
        int n10;
        String string2;
        int n11;
        int n12;
        if (object == null) {
            return;
        }
        int[] nArray = R$styleable.WheelPicker;
        context = context.obtainStyledAttributes(object, nArray);
        this.d = n12 = context.getDimensionPixelSize(8, 80);
        int n13 = -16777216;
        this.c = n12 = context.getColor(7, n13);
        boolean bl2 = true;
        n12 = (int)(context.getBoolean(12, bl2) ? 1 : 0);
        this.f = n12;
        n12 = (int)(context.getBoolean(17, false) ? 1 : 0);
        this.N = n12;
        n12 = 2;
        this.r = n11 = context.getInteger((int)(bl2 ? 1 : 0), n12);
        this.q = string2 = context.getString(6);
        int n14 = Color.parseColor((String)"#33aaff");
        this.g = n11 = context.getColor(10, n14);
        this.h = n11 = context.getDimensionPixelSize(11, 100);
        this.v = n10 = context.getInteger(0, 0);
        n11 = 20;
        this.t = n10 = context.getDimensionPixelSize(9, n11);
        this.s = n10 = context.getDimensionPixelSize(5, n11);
        n10 = (int)(context.getBoolean(18, bl2) ? 1 : 0);
        this.w = n10;
        n10 = (int)(context.getBoolean(13, bl2) ? 1 : 0);
        this.x = n10;
        n11 = Color.parseColor((String)"#303d3d3d");
        this.y = n10 = context.getColor(16, n11);
        this.z = bl2 = context.getBoolean(14, bl2);
        this.A = n13 = context.getColor(15, n13);
        object = context.getString(n12);
        this.j = object;
        n13 = this.g;
        this.k = n12 = context.getColor(3, n13);
        n13 = this.d;
        this.l = n12 = context.getDimensionPixelSize(4, n13);
        context.recycle();
    }

    private void p() {
        Paint paint;
        int n10 = 69;
        this.n = paint = new Paint(n10);
        Paint.Style style2 = Paint.Style.FILL;
        paint.setStyle(style2);
        paint = this.n;
        style2 = Paint.Align.CENTER;
        paint.setTextAlign((Paint.Align)style2);
        paint = new TextPaint(n10);
        this.e = paint;
        style2 = Paint.Style.FILL;
        paint.setStyle(style2);
        paint = this.e;
        style2 = Paint.Align.CENTER;
        paint.setTextAlign((Paint.Align)style2);
        paint = this.e;
        int n11 = this.c;
        paint.setColor(n11);
        paint = this.e;
        float f10 = this.d;
        paint.setTextSize(f10);
        paint = new TextPaint(n10);
        this.i = paint;
        style2 = Paint.Style.FILL;
        paint.setStyle(style2);
        paint = this.i;
        style2 = Paint.Align.CENTER;
        paint.setTextAlign((Paint.Align)style2);
        paint = this.i;
        n11 = this.g;
        paint.setColor(n11);
        paint = this.i;
        f10 = this.h;
        paint.setTextSize(f10);
        paint = new TextPaint(n10);
        this.m = paint;
        Paint.Style style3 = Paint.Style.FILL;
        paint.setStyle(style3);
        paint = this.m;
        style3 = Paint.Align.LEFT;
        paint.setTextAlign((Paint.Align)style3);
        paint = this.m;
        n10 = this.k;
        paint.setColor(n10);
        paint = this.m;
        float f11 = this.l;
        paint.setTextSize(f11);
    }

    private int w(int n10, int n11, int n12) {
        int n13 = 0x40000000;
        if (n10 == n13) {
            return n11;
        }
        return Math.min(n11, n12);
    }

    public int getCurrentPosition() {
        return this.v;
    }

    public int getCurtainBorderColor() {
        return this.A;
    }

    public int getCurtainColor() {
        return this.y;
    }

    public Format getDataFormat() {
        return this.b;
    }

    public List getDataList() {
        return this.a;
    }

    public int getDataListSize() {
        List list = this.a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public int getHalfVisibleItemCount() {
        return this.r;
    }

    public Paint getIndicatorPaint() {
        return this.m;
    }

    public int getItemHeightSpace() {
        return this.s;
    }

    public String getItemMaximumWidthText() {
        return this.q;
    }

    public int getItemWidthSpace() {
        return this.t;
    }

    public int getMaximumVelocity() {
        return this.R;
    }

    public int getMinimumVelocity() {
        return this.Q;
    }

    public Paint getPaint() {
        return this.n;
    }

    public Paint getSelectedItemPaint() {
        return this.i;
    }

    public int getSelectedItemTextColor() {
        return this.g;
    }

    public int getSelectedItemTextSize() {
        return this.h;
    }

    public int getTextColor() {
        return this.c;
    }

    public Paint getTextPaint() {
        return this.e;
    }

    public int getTextSize() {
        return this.d;
    }

    public int getVisibleItemCount() {
        return this.r * 2 + 1;
    }

    public void onDraw(Canvas canvas) {
        Object object;
        int n10;
        int n11;
        super.onDraw(canvas);
        Object object2 = this.n;
        Paint.Align align = Paint.Align.CENTER;
        object2.setTextAlign(align);
        int n12 = this.x;
        if (n12 != 0) {
            object2 = this.n;
            align = Paint.Style.FILL;
            object2.setStyle((Paint.Style)align);
            object2 = this.n;
            n11 = this.y;
            object2.setColor(n11);
            object2 = this.C;
            align = this.n;
            canvas.drawRect((Rect)object2, (Paint)align);
        }
        if ((n12 = this.z) != 0) {
            object2 = this.n;
            align = Paint.Style.STROKE;
            object2.setStyle((Paint.Style)align);
            object2 = this.n;
            n11 = this.A;
            object2.setColor(n11);
            object2 = this.C;
            align = this.n;
            canvas.drawRect((Rect)object2, (Paint)align);
            object2 = this.B;
            align = this.n;
            canvas.drawRect((Rect)object2, (Paint)align);
        }
        n12 = -this.L;
        n11 = this.u;
        n12 /= n11;
        align = this.n;
        Paint.Style style2 = Paint.Style.FILL;
        align.setStyle(style2);
        n11 = this.r;
        n11 = n12 - n11;
        int n13 = 1;
        float f10 = Float.MIN_VALUE;
        n11 -= n13;
        while (n11 <= (n10 = this.r + n12 + n13)) {
            block17: {
                int n14;
                int n15;
                block19: {
                    block20: {
                        boolean bl2;
                        float f11;
                        Layout.Alignment alignment;
                        Rect rect;
                        int n16;
                        Object object3;
                        Object object4;
                        int n17;
                        block18: {
                            int n18;
                            float f12;
                            float f13;
                            block16: {
                                block15: {
                                    n10 = (int)(this.N ? 1 : 0);
                                    if (n10 == 0) break block15;
                                    n10 = this.n(n11);
                                    break block16;
                                }
                                if (n11 < 0 || n11 > (n10 = (object = this.a).size() - n13)) break block17;
                                n10 = n11;
                            }
                            List list = this.a;
                            object = list.get(n10);
                            n15 = this.E;
                            n14 = this.r + n11;
                            n17 = this.u;
                            n15 += (n14 *= n17);
                            n14 = this.L;
                            n15 += n14;
                            n14 = Math.abs(this.F - n15);
                            n17 = (int)(this.f ? 1 : 0);
                            int n19 = 0;
                            float f14 = 0.0f;
                            object4 = null;
                            if (n17 != 0) {
                                float f15;
                                n17 = this.u;
                                if (n14 < n17) {
                                    float f16 = n14;
                                    f13 = n17;
                                    f12 = 1.0f - (f16 /= f13);
                                    object3 = this.i;
                                    n16 = this.T.a(f12);
                                    object3.setColor(n16);
                                    object3 = this.e;
                                    l l10 = this.T;
                                    n18 = l10.a(f12);
                                    object3.setColor(n18);
                                } else {
                                    object3 = this.i;
                                    n18 = this.g;
                                    object3.setColor(n18);
                                    object3 = this.e;
                                    n18 = this.c;
                                    object3.setColor(n18);
                                }
                                n17 = this.F;
                                if (n15 > n17) {
                                    object3 = this.B;
                                    n17 = object3.height() - n15;
                                    f13 = n17;
                                    rect = this.B;
                                    n18 = rect.height();
                                    n16 = this.F;
                                    f12 = n18 -= n16;
                                    f13 /= f12;
                                } else {
                                    f12 = n15;
                                    f13 = n17;
                                    f13 = f12 / f13;
                                }
                                n18 = (int)((f15 = f13 - 0.0f) == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1));
                                if (n18 >= 0) {
                                    f14 = f13;
                                }
                                object3 = this.i;
                                f12 = 255.0f * f14;
                                n18 = (int)f12;
                                object3.setAlpha(n18);
                                object3 = this.e;
                                object3.setAlpha(n18);
                            }
                            if ((n17 = (int)(this.w ? 1 : 0)) != 0) {
                                n17 = this.h;
                                n18 = this.d;
                                f13 = n17 -= n18;
                                object3 = this.i;
                                f12 = (float)n18 + (f14 *= f13);
                                object3.setTextSize(f12);
                                object3 = this.e;
                                n18 = this.d;
                                f12 = (float)n18 + f14;
                                object3.setTextSize(f12);
                            } else {
                                object3 = this.i;
                                f14 = this.d;
                                object3.setTextSize(f14);
                                object3 = this.e;
                                n19 = this.d;
                                f14 = n19;
                                object3.setTextSize(f14);
                            }
                            object3 = this.b;
                            object = object3 == null ? object.toString() : ((Format)object3).format(object);
                            object4 = object;
                            canvas.save();
                            n10 = this.u / 2;
                            if (n14 >= n10) break block18;
                            rect = this.i;
                            n16 = this.getWidth();
                            alignment = Layout.Alignment.ALIGN_NORMAL;
                            f11 = 1.0f;
                            bl2 = true;
                            object3 = object;
                            object = new StaticLayout((CharSequence)object4, (TextPaint)rect, n16, alignment, f11, 0.0f, bl2);
                            n14 = object.getLineCount();
                            if (n14 <= n13) break block19;
                            n17 = object.getHeight() / n14 / 2;
                            break block20;
                        }
                        rect = this.e;
                        n16 = this.getWidth();
                        alignment = Layout.Alignment.ALIGN_NORMAL;
                        f11 = 1.0f;
                        bl2 = true;
                        object3 = object;
                        object = new StaticLayout((CharSequence)object4, (TextPaint)rect, n16, alignment, f11, 0.0f, bl2);
                        n14 = object.getLineCount();
                        if (n14 <= n13) break block19;
                        n17 = object.getHeight() / n14 / 2;
                    }
                    n15 -= (n17 *= (n14 += -1));
                }
                n14 = this.D;
                float f17 = n14;
                float f18 = n15;
                canvas.translate(f17, f18);
                object.draw(canvas);
                canvas.restore();
            }
            ++n11;
        }
        object2 = this.j;
        n12 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
        if (n12 == 0) {
            object2 = this.j;
            n11 = this.D;
            n13 = this.o / 2;
            float f19 = n11 += n13;
            n13 = this.F;
            f10 = n13;
            object = this.m;
            canvas.drawText((String)object2, f19, f10, (Paint)object);
        }
    }

    public void onMeasure(int n10, int n11) {
        int n12 = View.MeasureSpec.getSize((int)n10);
        n10 = View.MeasureSpec.getMode((int)n10);
        int n13 = View.MeasureSpec.getSize((int)n11);
        n11 = View.MeasureSpec.getMode((int)n11);
        int n14 = this.o;
        int n15 = this.t;
        n14 += n15;
        n15 = this.p;
        int n16 = this.s;
        n15 += n16;
        n16 = this.getVisibleItemCount();
        n15 *= n16;
        n16 = this.getPaddingLeft();
        int n17 = this.getPaddingRight();
        n14 += (n16 += n17);
        n16 = this.getPaddingTop();
        n17 = this.getPaddingBottom();
        n10 = this.w(n10, n12, n14);
        n11 = this.w(n11, n13, n15 += (n16 += n17));
        this.setMeasuredDimension(n10, n11);
    }

    public void onSizeChanged(int n10, int n11, int n12, int n13) {
        super.onSizeChanged(n10, n11, n12, n13);
        Rect rect = this.B;
        n11 = this.getPaddingLeft();
        n12 = this.getPaddingTop();
        n13 = this.getWidth();
        int n14 = this.getPaddingRight();
        n13 -= n14;
        n14 = this.getHeight();
        int n15 = this.getPaddingBottom();
        rect.set(n11, n12, n13, n14 -= n15);
        n10 = this.B.height();
        n11 = this.getVisibleItemCount();
        this.u = n10 /= n11;
        this.D = n10 = this.B.centerX();
        float f10 = this.u;
        float f11 = this.i.ascent();
        float f12 = this.i.descent();
        this.E = n10 = (int)((f10 - (f11 += f12)) / 2.0f);
        rect = this.C;
        n11 = this.getPaddingLeft();
        n12 = this.u;
        n13 = this.r;
        n12 *= n13;
        n13 = this.getWidth();
        n14 = this.getPaddingRight();
        n13 -= n14;
        n14 = this.u;
        n15 = this.r * n14;
        rect.set(n11, n12, n13, n14 += n15);
        this.l();
        n10 = this.E;
        n11 = this.u;
        n12 = this.r * n11;
        this.F = n10 += n12;
        n10 = -n11;
        n11 = this.v;
        this.L = n10 *= n11;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int n10;
        block19: {
            int n11;
            Object object;
            int n12;
            block17: {
                int n13;
                float f10;
                int n14;
                Scroller scroller;
                int n15;
                block18: {
                    int n16;
                    float f11;
                    float f12;
                    block20: {
                        n12 = this.W;
                        n15 = 0;
                        f12 = 0.0f;
                        scroller = null;
                        if (n12 == 0) {
                            return false;
                        }
                        object = this.J;
                        if (object == null) {
                            this.J = object = VelocityTracker.obtain();
                        }
                        object = this.J;
                        object.addMovement(motionEvent);
                        n12 = motionEvent.getAction();
                        n10 = 1;
                        if (n12 == 0) break block17;
                        if (n12 == n10) break block18;
                        int n17 = 2;
                        float f13 = 2.8E-45f;
                        if (n12 != n17) break block19;
                        n12 = this.I;
                        if (n12 == 0) break block20;
                        f11 = this.K;
                        f13 = motionEvent.getY();
                        float f14 = (f11 = Math.abs(f11 - f13)) - (f13 = (float)(n17 = this.H));
                        n12 = (int)(f14 == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1));
                        if (n12 < 0) break block19;
                    }
                    this.I = false;
                    f11 = motionEvent.getY();
                    f12 = this.M;
                    f11 -= f12;
                    n15 = this.L;
                    f12 = (float)n15 + f11;
                    this.L = n12 = (int)f12;
                    float f15 = motionEvent.getY();
                    this.M = n16 = (int)f15;
                    this.invalidate();
                    break block19;
                }
                n12 = (int)(this.S ? 1 : 0);
                if (n12 == 0 && (n12 = this.K) == (n14 = this.M)) {
                    this.performClick();
                    float f16 = motionEvent.getY();
                    Rect rect = this.C;
                    n14 = rect.bottom;
                    float f17 = n14;
                    n12 = (int)(f16 == f17 ? 0 : (f16 > f17 ? 1 : -1));
                    if (n12 > 0) {
                        f10 = motionEvent.getY();
                        object = this.C;
                        f16 = object.bottom;
                        n13 = (int)(f10 -= f16);
                        n12 = this.u;
                        n13 = n13 / n12 + n10;
                        rect = this.G;
                        int n18 = this.L;
                        n13 = -n13 * n12;
                        rect.startScroll(0, n18, 0, n13);
                    } else {
                        f16 = motionEvent.getY();
                        rect = this.C;
                        n14 = rect.top;
                        float f18 = n14;
                        float f19 = f16 - f18;
                        n12 = (int)(f19 == 0.0f ? 0 : (f19 < 0.0f ? -1 : 1));
                        if (n12 < 0) {
                            f16 = n14;
                            f10 = motionEvent.getY();
                            n13 = (int)(f16 -= f10);
                            n12 = this.u;
                            n13 = n13 / n12 + n10;
                            rect = this.G;
                            int n19 = this.L;
                            rect.startScroll(0, n19, 0, n13 *= n12);
                        }
                    }
                } else {
                    motionEvent = this.J;
                    float f20 = 1.401E-42f;
                    n14 = this.R;
                    float f21 = n14;
                    motionEvent.computeCurrentVelocity(1000, f21);
                    motionEvent = this.J;
                    f10 = motionEvent.getYVelocity();
                    int n20 = (int)f10;
                    n13 = Math.abs(n20);
                    n12 = this.Q;
                    if (n13 > n12) {
                        Scroller scroller2 = this.G;
                        boolean bl2 = false;
                        float f22 = 0.0f;
                        int n21 = this.L;
                        int n22 = this.P;
                        int n23 = this.O;
                        scroller2.fling(0, n21, 0, n20, 0, 0, n22, n23);
                        motionEvent = this.G;
                        n12 = motionEvent.getFinalY();
                        scroller = this.G;
                        n15 = scroller.getFinalY();
                        n14 = this.u;
                        n15 %= n14;
                        n15 = this.k(n15);
                        motionEvent.setFinalY(n12 += n15);
                    } else {
                        motionEvent = this.G;
                        n12 = this.L;
                        n14 = this.u;
                        n14 = n12 % n14;
                        n14 = this.k(n14);
                        motionEvent.startScroll(0, n12, 0, n14);
                    }
                }
                n13 = (int)(this.N ? 1 : 0);
                if (n13 == 0) {
                    motionEvent = this.G;
                    n13 = motionEvent.getFinalY();
                    if (n13 > (n12 = this.O)) {
                        motionEvent = this.G;
                        motionEvent.setFinalY(n12);
                    } else {
                        motionEvent = this.G;
                        n13 = motionEvent.getFinalY();
                        if (n13 < (n12 = this.P)) {
                            motionEvent = this.G;
                            motionEvent.setFinalY(n12);
                        }
                    }
                }
                motionEvent = this.U;
                object = this.k0;
                motionEvent.post((Runnable)object);
                this.J.recycle();
                n13 = 0;
                f10 = 0.0f;
                motionEvent = null;
                this.J = null;
                break block19;
            }
            object = this.G;
            n12 = (int)(object.isFinished() ? 1 : 0);
            if (n12 == 0) {
                object = this.G;
                object.abortAnimation();
                this.S = n10;
            } else {
                this.S = false;
            }
            object = this.J;
            object.clear();
            float f23 = motionEvent.getY();
            this.M = n11 = (int)f23;
            this.K = n11;
            this.I = n10;
        }
        return n10 != 0;
    }

    public boolean performClick() {
        return super.performClick();
    }

    public boolean q() {
        return this.N;
    }

    public boolean r() {
        return this.W;
    }

    public boolean s() {
        return this.x;
    }

    public void setCurrentPosition(int n10) {
        boolean bl2 = true;
        this.y(n10, bl2, bl2);
    }

    public void setCurtainBorderColor(int n10) {
        int n11 = this.A;
        if (n11 == n10) {
            return;
        }
        this.A = n10;
        this.postInvalidate();
    }

    public void setCurtainColor(int n10) {
        int n11 = this.y;
        if (n11 == n10) {
            return;
        }
        this.y = n10;
        this.postInvalidate();
    }

    public void setCyclic(boolean bl2) {
        boolean bl3 = this.N;
        if (bl3 == bl2) {
            return;
        }
        this.N = bl2;
        this.l();
        this.requestLayout();
    }

    public void setDataFormat(Format format) {
        this.b = format;
        this.postInvalidate();
    }

    public void setDataList(List list) {
        this.a = list;
        int n10 = list.size();
        if (n10 == 0) {
            return;
        }
        this.m();
        this.l();
        this.requestLayout();
        this.postInvalidate();
    }

    public void setHalfVisibleItemCount(int n10) {
        int n11 = this.r;
        if (n11 == n10) {
            return;
        }
        this.r = n10;
        this.requestLayout();
    }

    public void setIndicatorText(String string2) {
        this.j = string2;
        this.postInvalidate();
    }

    public void setIndicatorTextColor(int n10) {
        this.k = n10;
        this.m.setColor(n10);
        this.postInvalidate();
    }

    public void setIndicatorTextSize(int n10) {
        this.l = n10;
        TextPaint textPaint = this.m;
        float f10 = n10;
        textPaint.setTextSize(f10);
        this.postInvalidate();
    }

    public void setItemHeightSpace(int n10) {
        int n11 = this.s;
        if (n11 == n10) {
            return;
        }
        this.s = n10;
        this.requestLayout();
    }

    public void setItemMaximumWidthText(String string2) {
        this.q = string2;
        this.requestLayout();
        this.postInvalidate();
    }

    public void setItemWidthSpace(int n10) {
        int n11 = this.t;
        if (n11 == n10) {
            return;
        }
        this.t = n10;
        this.requestLayout();
    }

    public void setMaximumVelocity(int n10) {
        this.R = n10;
    }

    public void setMinimumVelocity(int n10) {
        this.Q = n10;
    }

    public void setOnWheelChangeListener(WheelPicker$b wheelPicker$b) {
        this.V = wheelPicker$b;
    }

    public void setScrollEnable(boolean bl2) {
        this.W = bl2;
    }

    public void setSelectedItemTextColor(int n10) {
        int n11 = this.g;
        if (n11 == n10) {
            return;
        }
        this.i.setColor(n10);
        this.g = n10;
        this.T.b(n10);
        this.postInvalidate();
    }

    public void setSelectedItemTextSize(int n10) {
        int n11 = this.h;
        if (n11 == n10) {
            return;
        }
        TextPaint textPaint = this.i;
        float f10 = n10;
        textPaint.setTextSize(f10);
        this.h = n10;
        this.m();
        this.postInvalidate();
    }

    public void setShowCurtain(boolean bl2) {
        boolean bl3 = this.x;
        if (bl3 == bl2) {
            return;
        }
        this.x = bl2;
        this.postInvalidate();
    }

    public void setShowCurtainBorder(boolean bl2) {
        boolean bl3 = this.z;
        if (bl3 == bl2) {
            return;
        }
        this.z = bl2;
        this.postInvalidate();
    }

    public void setTextColor(int n10) {
        int n11 = this.c;
        if (n11 == n10) {
            return;
        }
        this.e.setColor(n10);
        this.c = n10;
        this.T.c(n10);
        this.postInvalidate();
    }

    public void setTextGradual(boolean bl2) {
        boolean bl3 = this.f;
        if (bl3 == bl2) {
            return;
        }
        this.f = bl2;
        this.postInvalidate();
    }

    public void setTextSize(int n10) {
        int n11 = this.d;
        if (n11 == n10) {
            return;
        }
        this.d = n10;
        TextPaint textPaint = this.e;
        float f10 = n10;
        textPaint.setTextSize(f10);
        this.m();
        this.postInvalidate();
    }

    public void setZoomInSelectedItem(boolean bl2) {
        boolean bl3 = this.w;
        if (bl3 == bl2) {
            return;
        }
        this.w = bl2;
        this.postInvalidate();
    }

    public boolean t() {
        return this.z;
    }

    public boolean u() {
        return this.f;
    }

    public boolean v() {
        return this.w;
    }

    public void x(int n10, boolean bl2) {
        this.y(n10, bl2, true);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void y(int n10, boolean n11, boolean bl2) {
        synchronized (this) {
            block33: {
                int n12;
                List list;
                block32: {
                    block31: {
                        int n13;
                        List list2;
                        block30: {
                            list2 = this.a;
                            n13 = list2.size() + -1;
                            if (n10 <= n13) break block30;
                            list = this.a;
                            n10 = list.size() + -1;
                        }
                        n13 = 0;
                        list2 = null;
                        if (n10 < 0) {
                            n10 = 0;
                            list = null;
                        }
                        n12 = this.v;
                        if (n12 != n10) break block31;
                        return;
                    }
                    Scroller scroller = this.G;
                    n12 = (int)(scroller.isFinished() ? 1 : 0);
                    if (n12 != 0) break block32;
                    scroller = this.G;
                    scroller.abortAnimation();
                }
                if (n11 != 0) {
                    n11 = this.u;
                    if (n11 <= 0) break block33;
                    Scroller scroller = this.G;
                    n12 = this.L;
                    int n14 = (this.v - n10) * n11;
                    scroller.startScroll(0, n12, 0, n14);
                    n10 = -n10;
                    n11 = this.u;
                    Scroller scroller2 = this.G;
                    scroller2.setFinalY(n10 *= n11);
                    list = this.U;
                    Runnable runnable = this.k0;
                    list.post(runnable);
                    return;
                }
            }
            this.v = n10;
            n11 = -this.u * n10;
            this.L = n11;
            this.postInvalidate();
            if (!bl2) return;
            WheelPicker$b wheelPicker$b = this.V;
            if (wheelPicker$b == null) return;
            List list = this.a;
            Object e10 = list.get(n10);
            wheelPicker$b.a(e10, n10);
            return;
        }
    }
}

