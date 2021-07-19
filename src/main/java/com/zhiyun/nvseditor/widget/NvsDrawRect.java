/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.DashPathEffect
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.PathEffect
 *  android.graphics.PointF
 *  android.graphics.RectF
 *  android.graphics.Region
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.View
 */
package com.zhiyun.nvseditor.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.zhiyun.nvseditor.R$mipmap;
import com.zhiyun.nvseditor.widget.NvsDrawRect$a;
import com.zhiyun.nvseditor.widget.NvsDrawRect$b;
import d.v.e.l.h2;
import java.util.List;

public class NvsDrawRect
extends View {
    public static final int A = 0;
    public static final int B = 1;
    public static final double C = 10.0;
    public static final int D = 200;
    private static final int E = 5;
    private static final String z = NvsDrawRect.class.getSimpleName();
    private Paint a;
    private Paint b;
    private NvsDrawRect$b c;
    private NvsDrawRect$a d;
    private PointF e;
    private RectF f;
    private RectF g;
    private RectF h;
    private RectF i;
    private Path j;
    private List k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private int q;
    private int r;
    private long s;
    private double t;
    private boolean u;
    private boolean v;
    private Bitmap w;
    private Bitmap x;
    private Bitmap y;

    public NvsDrawRect(Context context) {
        this(context, null);
    }

    public NvsDrawRect(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NvsDrawRect(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        super();
        this.e = context;
        super();
        this.f = context;
        super();
        this.g = context;
        super();
        this.h = context;
        super();
        this.i = context;
        super();
        this.j = context;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.r = 0;
        this.s = 0L;
        this.t = 0.0;
        this.u = false;
        this.v = false;
        context = this.getResources();
        int n11 = R$mipmap.ic_zf_bjq_amplification;
        context = BitmapFactory.decodeResource((Resources)context, (int)n11);
        this.w = context;
        context = this.getResources();
        n11 = R$mipmap.ic_zf_bjq_close_red;
        context = BitmapFactory.decodeResource((Resources)context, (int)n11);
        this.x = context;
        context = this.getResources();
        n11 = R$mipmap.ic_zf_bjq_rotate;
        context = BitmapFactory.decodeResource((Resources)context, (int)n11);
        this.y = context;
        this.e();
    }

    private void a(Bitmap bitmap) {
        boolean bl2;
        if (bitmap != null && !(bl2 = bitmap.isRecycled())) {
            bitmap.recycle();
        }
    }

    private void e() {
        Paint paint;
        this.a = paint = new Paint();
        String string2 = "#FFFFFF";
        int bl2 = Color.parseColor((String)string2);
        paint.setColor(bl2);
        paint = this.a;
        boolean bl3 = true;
        paint.setAntiAlias(bl3);
        paint = this.a;
        float f10 = h2.b(1.0f);
        paint.setStrokeWidth(f10);
        paint = this.a;
        Paint.Style style2 = Paint.Style.STROKE;
        paint.setStyle(style2);
        paint = this.a;
        float[] fArray = new float[]{12.0f, 8.0f};
        style2 = new DashPathEffect(fArray, 0.0f);
        paint.setPathEffect((PathEffect)style2);
        this.b = paint = new Paint();
        int n10 = Color.parseColor((String)string2);
        paint.setColor(n10);
        this.b.setAntiAlias(bl3);
        paint = this.b;
        float f11 = h2.b(1.5f);
        paint.setStrokeWidth(f11);
        paint = this.b;
        string2 = Paint.Style.STROKE;
        paint.setStyle((Paint.Style)string2);
    }

    private Path f(List list) {
        int n10;
        int n11;
        if (list != null && (n11 = list.size()) == (n10 = 4)) {
            int n12;
            Path path = new Path();
            for (n10 = 0; n10 < (n12 = list.size()); ++n10) {
                float f10;
                float f11;
                PointF pointF = (PointF)list.get(n10);
                if (n10 == 0) {
                    f11 = pointF.x;
                    f10 = pointF.y;
                    path.moveTo(f11, f10);
                    continue;
                }
                f11 = pointF.x;
                f10 = pointF.y;
                path.lineTo(f11, f10);
            }
            path.close();
            return path;
        }
        return null;
    }

    private void setRectPath(List list) {
        int n10;
        int n11;
        if (list != null && (n11 = list.size()) == (n10 = 4)) {
            Path path = this.j;
            path.reset();
            list = this.f(list);
            this.j = list;
        }
    }

    public void b() {
        Bitmap bitmap = this.w;
        this.a(bitmap);
        this.w = null;
        Bitmap bitmap2 = this.x;
        this.a(bitmap2);
        this.x = null;
        bitmap2 = this.y;
        this.a(bitmap2);
        this.y = null;
    }

    public boolean c(List list, int n10, int n11) {
        int n12;
        int n13;
        if (list != null && (n13 = list.size()) == (n12 = 4)) {
            RectF rectF = new RectF();
            list = this.f(list);
            list.computeBounds(rectF, true);
            Region region = new Region();
            int n14 = (int)rectF.left;
            int n15 = (int)rectF.top;
            int n16 = (int)rectF.right;
            n13 = (int)rectF.bottom;
            Region region2 = new Region(n14, n15, n16, n13);
            region.setPath((Path)list, region2);
            return region.contains(n10, n11);
        }
        return false;
    }

    public boolean d(int n10, int n11) {
        List list = this.k;
        return this.c(list, n10, n11);
    }

    public void g(List list, int n10) {
        int n11;
        List list2 = this.k;
        if (list2 == list && (n11 = this.q) == n10) {
            return;
        }
        this.k = list;
        this.q = n10;
        this.invalidate();
    }

    public List getDrawRect() {
        return this.k;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        List list = this.k;
        if (list != null) {
            int n10 = list.size();
            int n11 = 4;
            float f10 = 5.6E-45f;
            if (n10 == n11) {
                list = this.k;
                this.setRectPath(list);
                list = this.j;
                Object object = this.a;
                canvas.drawPath((Path)list, (Paint)object);
                list = this.y;
                object = this.k;
                int n12 = 1;
                f10 = ((PointF)object.get((int)n12)).x;
                float f11 = this.y.getHeight() >> n12;
                f10 -= f11;
                f11 = ((PointF)this.k.get((int)n12)).y;
                float f12 = this.y.getWidth() >> n12;
                Paint paint = this.a;
                canvas.drawBitmap((Bitmap)list, f10, f11 -= f12, paint);
                list = this.g;
                f10 = ((PointF)this.k.get((int)n12)).x;
                f11 = this.y.getWidth() >> n12;
                f10 -= f11;
                f11 = ((PointF)this.k.get((int)n12)).y;
                f12 = this.y.getHeight() >> n12;
                f11 -= f12;
                f12 = ((PointF)this.k.get((int)n12)).x;
                float f13 = this.y.getWidth() >> n12;
                f12 += f13;
                f13 = ((PointF)this.k.get((int)n12)).y;
                float f14 = this.y.getHeight() >> n12;
                list.set(f10, f11, f12, f13 += f14);
                list = this.x;
                object = this.k;
                int n13 = 0;
                f11 = 0.0f;
                PointF pointF = null;
                f10 = ((PointF)object.get((int)0)).x;
                f12 = this.x.getWidth() >> n12;
                f10 -= f12;
                f12 = ((PointF)this.k.get((int)0)).y;
                f13 = this.x.getHeight() >> n12;
                Paint paint2 = this.a;
                canvas.drawBitmap((Bitmap)list, f10, f12 -= f13, paint2);
                list = this.i;
                f10 = ((PointF)this.k.get((int)0)).x;
                f12 = this.x.getWidth() >> n12;
                f10 -= f12;
                paint = (PointF)this.k.get(0);
                f12 = paint.y;
                f13 = this.x.getHeight() >> n12;
                f12 -= f13;
                f13 = ((PointF)this.k.get((int)0)).x;
                f14 = this.x.getWidth() >> n12;
                f13 += f14;
                f14 = ((PointF)this.k.get((int)0)).y;
                float f15 = this.x.getHeight() >> n12;
                list.set(f10, f12, f13, f14 += f15);
                list = this.w;
                object = this.k;
                int n14 = 2;
                f12 = 2.8E-45f;
                f10 = ((PointF)object.get((int)n14)).x;
                f13 = this.w.getHeight() >> n12;
                f10 -= f13;
                f13 = ((PointF)this.k.get((int)n14)).y;
                f14 = this.w.getWidth() >> n12;
                Paint paint3 = this.a;
                canvas.drawBitmap((Bitmap)list, f10, f13 -= f14, paint3);
                list = this.h;
                object = (PointF)this.k.get(n14);
                f10 = ((PointF)object).x;
                int n15 = this.w.getWidth() >> n12;
                f13 = n15;
                f10 -= f13;
                paint2 = (PointF)this.k.get(n14);
                f13 = paint2.y;
                int n16 = this.w.getHeight() >> n12;
                f14 = n16;
                f13 -= f14;
                paint3 = (PointF)this.k.get(n14);
                f14 = paint3.x;
                int n17 = this.w.getWidth() >> n12;
                f15 = n17;
                f14 += f15;
                PointF pointF2 = (PointF)this.k.get(n14);
                f15 = pointF2.y;
                Bitmap bitmap = this.w;
                int n18 = bitmap.getHeight() >> n12;
                float f16 = n18;
                list.set(f10, f13, f14, f15 += f16);
                n10 = (int)(this.v ? 1 : 0);
                if (n10 != 0) {
                    Paint paint4;
                    float f17;
                    float f18;
                    list = (PointF)this.k.get(0);
                    float f19 = ((PointF)list).x;
                    object = (PointF)this.k.get(n14);
                    f10 = ((PointF)object).x;
                    f19 += f10;
                    f10 = this.getWidth();
                    f19 = Math.abs(f19 - f10);
                    n11 = 0x40A00000;
                    f10 = 5.0f;
                    n10 = (int)(f19 == f10 ? 0 : (f19 < f10 ? -1 : 1));
                    n15 = 1096810496;
                    f13 = 14.0f;
                    if (n10 < 0) {
                        f15 = this.getWidth() >> n12;
                        n18 = 0;
                        bitmap = null;
                        f18 = this.getWidth() >> n12;
                        f17 = h2.b(f13);
                        paint4 = this.b;
                        paint3 = canvas;
                        canvas.drawLine(f15, 0.0f, f18, f17, paint4);
                        f15 = this.getWidth() >> n12;
                        f16 = this.getHeight();
                        f18 = this.getWidth() >> n12;
                        n10 = this.getHeight();
                        n16 = h2.b(f13);
                        f17 = n10 -= n16;
                        paint4 = this.b;
                        canvas.drawLine(f15, f16, f18, f17, paint4);
                    }
                    list = (PointF)this.k.get(0);
                    f19 = ((PointF)list).y;
                    pointF = (PointF)this.k.get(n14);
                    f11 = pointF.y;
                    f19 += f11;
                    n13 = this.getHeight();
                    f11 = n13;
                    float f20 = (f19 = Math.abs(f19 - f11)) - f10;
                    n10 = (int)(f20 == 0.0f ? 0 : (f20 < 0.0f ? -1 : 1));
                    if (n10 < 0) {
                        n17 = 0;
                        pointF2 = null;
                        f16 = this.getHeight() >> n12;
                        f18 = h2.b(f13);
                        f17 = this.getHeight() >> n12;
                        paint4 = this.b;
                        paint3 = canvas;
                        canvas.drawLine(0.0f, f16, f18, f17, paint4);
                        f15 = this.getWidth();
                        f16 = this.getHeight() >> n12;
                        n10 = this.getWidth();
                        n11 = h2.b(f13);
                        f18 = n10 - n11;
                        n10 = this.getHeight() >> n12;
                        f17 = n10;
                        paint4 = this.b;
                        canvas.drawLine(f15, f16, f18, f17, paint4);
                    }
                }
            }
        }
    }

    public boolean onTouchEvent(MotionEvent object) {
        float f10 = object.getX();
        float f11 = object.getY();
        Object object2 = this.k;
        int n10 = 1;
        if (object2 != null) {
            int n11 = object.getAction();
            int n12 = 4;
            float f12 = 5.6E-45f;
            if (n11 != 0) {
                boolean bl2 = false;
                float f13 = 0.0f;
                NvsDrawRect$b nvsDrawRect$b = null;
                if (n11 != n10) {
                    int n13 = 2;
                    float f14 = 2.8E-45f;
                    if (n11 == n13) {
                        float f15;
                        float f16;
                        float f17;
                        int n14;
                        n11 = (int)(this.l ? 1 : 0);
                        if ((n11 != 0 || (n11 = (int)(this.n ? 1 : 0)) != 0 || (n11 = (int)(this.m ? 1 : 0)) != 0) && (object2 = this.c) != null && (n14 = this.o) == 0) {
                            object2.j();
                        }
                        this.v = n10;
                        float f18 = this.e.x;
                        double d10 = f10 - f18;
                        double d11 = 2.0;
                        d10 = Math.pow(d10, d11);
                        object2 = this.e;
                        f18 = ((PointF)object2).y;
                        double d12 = Math.pow(f11 - f18, d11);
                        this.t = d10 = Math.sqrt(d10 + d12);
                        f18 = 100.0f;
                        float f19 = f10 - f18;
                        n11 = (int)(f19 == 0.0f ? 0 : (f19 < 0.0f ? -1 : 1));
                        if (n11 > 0 && (n11 = (int)((f17 = f10 - (f18 = (float)this.getWidth())) == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1))) < 0 && (n11 = (int)((f16 = f11 - (f18 = (float)this.getHeight())) == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1))) < 0 && (n11 = (int)((f15 = f11 - (f18 = 20.0f)) == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1))) > 0) {
                            PointF pointF;
                            float f20;
                            object2 = new PointF();
                            List list = this.k;
                            if (list != null && (n14 = list.size()) == n12) {
                                f12 = ((PointF)this.k.get((int)0)).x;
                                list = (PointF)this.k.get(n13);
                                f20 = ((PointF)list).x;
                                f12 += f20;
                                n14 = 0x40000000;
                                f20 = 2.0f;
                                ((PointF)object2).x = f12 /= f20;
                                pointF = (PointF)this.k.get(0);
                                f12 = pointF.y;
                                List list2 = this.k;
                                object = (PointF)list2.get(n13);
                                f14 = ((PointF)object).y;
                                ((PointF)object2).y = f12 = (f12 + f14) / f20;
                            }
                            if ((object = this.c) != null && ((n13 = (int)(this.l ? 1 : 0)) != 0 || (n13 = (int)(this.m ? 1 : 0)) != 0)) {
                                this.n = false;
                                f14 = this.e.x;
                                f12 = ((PointF)object2).x;
                                double d13 = Math.pow(f14 - f12, d11);
                                object = this.e;
                                f14 = ((PointF)object).y;
                                f20 = ((PointF)object2).y;
                                d10 = Math.pow(f14 - f20, d11);
                                d13 = Math.sqrt(d13 + d10);
                                f14 = ((PointF)object2).x;
                                d10 = Math.pow(f10 - f14, d11);
                                f14 = ((PointF)object2).y;
                                d12 = f11 - f14;
                                d11 = Math.pow(d12, d11);
                                f14 = (float)(Math.sqrt(d10 + d11) / d13);
                                f12 = ((PointF)object2).y;
                                d13 = f11 - f12;
                                f20 = ((PointF)object2).x;
                                d10 = f10 - f20;
                                d13 = Math.atan2(d13, d10);
                                list = this.e;
                                float f21 = ((PointF)list).y;
                                float f22 = ((PointF)object2).y;
                                double d14 = f21 -= f22;
                                f20 = ((PointF)list).x;
                                float f23 = ((PointF)object2).x;
                                double d15 = f20 -= f23;
                                d10 = Math.atan2(d14, d15);
                                f12 = (float)(d13 - d10);
                                f13 = 180.0f;
                                d13 = f12 * f13;
                                long l10 = 4614256656552045848L;
                                d10 = Math.PI;
                                f12 = (float)(d13 /= d10);
                                bl2 = this.l;
                                if (bl2) {
                                    nvsDrawRect$b = this.c;
                                    nvsDrawRect$b.h(f14, (PointF)object2);
                                }
                                if ((n13 = (int)(this.m ? 1 : 0)) != 0) {
                                    object = this.c;
                                    f18 = -f12;
                                    object.b(f18);
                                }
                            }
                            if ((object = this.c) != null && (n11 = (int)(this.n ? 1 : 0)) != 0) {
                                object2 = this.e;
                                pointF = new PointF(f10, f11);
                                object.c((PointF)object2, pointF);
                            }
                            object = this.e;
                            object.set(f10, f11);
                        } else {
                            this.u = n10;
                        }
                    }
                } else {
                    double d16;
                    Object object3;
                    NvsDrawRect$b nvsDrawRect$b2;
                    boolean bl3 = this.l;
                    if (!(bl3 || (bl3 = this.o) || (bl3 = this.m) || (nvsDrawRect$b2 = this.c) == null)) {
                        nvsDrawRect$b2.onTouchEvent((MotionEvent)object);
                    }
                    if ((object3 = this.l) == 0 && (object3 = this.o) != 0 && (object = this.c) != null) {
                        this.n = false;
                        object.k();
                    }
                    if (!((object3 = this.l) == 0 && (object3 = this.n) == 0 && (object3 = this.m) == 0 || (object = this.c) == null || (bl3 = this.o))) {
                        object.e();
                    }
                    long l11 = System.currentTimeMillis();
                    long l12 = this.s;
                    l11 -= l12;
                    double d17 = this.t;
                    double d18 = 10.0;
                    double d19 = d17 - d18;
                    object3 = d19 == 0.0 ? 0 : (d19 < 0.0 ? -1 : 1);
                    if (object3 < 0) {
                        l12 = 200L;
                        d17 = 9.9E-322;
                        object3 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
                        if (object3 <= 0) {
                            object3 = this.n;
                            if (!(object3 == 0 || (bl3 = this.l) || (bl3 = this.o) || (bl3 = this.p))) {
                                object = this.c;
                                if (object != null) {
                                    object.g();
                                }
                            } else {
                                bl3 = this.l;
                                if (!(bl3 || (bl3 = this.o) || (bl3 = this.m) || object3 != 0 || (object = this.c) == null)) {
                                    object.f();
                                }
                            }
                        }
                    }
                    this.o = false;
                    this.l = false;
                    this.n = false;
                    this.p = false;
                    this.m = false;
                    l11 = 0L;
                    this.t = d16 = 0.0;
                    this.v = false;
                    this.invalidate();
                }
            } else {
                boolean bl4;
                NvsDrawRect$b nvsDrawRect$b;
                long l13;
                this.s = l13 = System.currentTimeMillis();
                n11 = (int)(this.h.contains(f10, f11) ? 1 : 0);
                this.l = n11;
                n11 = (int)(this.i.contains(f10, f11) ? 1 : 0);
                this.o = n11;
                n11 = (int)(this.g.contains(f10, f11) ? 1 : 0);
                this.m = n11;
                object2 = this.k;
                if (object2 != null && (n11 = object2.size()) == n12) {
                    n11 = (int)f10;
                    n12 = (int)f11;
                    n11 = (int)(this.d(n11, n12) ? 1 : 0);
                    this.n = n11;
                }
                if ((object2 = this.c) != null) {
                    PointF pointF = new PointF(f10, f11);
                    object2.d(pointF);
                }
                object2 = this.e;
                object2.set(f10, f11);
                boolean bl5 = this.l;
                if ((bl5 || (bl5 = this.n) || (bl5 = this.m)) && (nvsDrawRect$b = this.c) != null && !(bl4 = this.o)) {
                    nvsDrawRect$b.i();
                }
                if (!((bl5 = this.l) || (bl5 = this.o) || (bl5 = this.m) || (nvsDrawRect$b = this.c) == null)) {
                    nvsDrawRect$b.onTouchEvent((MotionEvent)object);
                }
            }
        }
        return n10 != 0;
    }

    public void setAlignType(int n10) {
        int n11 = this.r;
        if (n11 != n10) {
            this.r = n10;
            this.invalidate();
        }
    }

    public void setOnDrawRectClickListener(NvsDrawRect$a nvsDrawRect$a) {
        this.d = nvsDrawRect$a;
    }

    public void setOnTouchListener(NvsDrawRect$b nvsDrawRect$b) {
        this.c = nvsDrawRect$b;
    }
}

