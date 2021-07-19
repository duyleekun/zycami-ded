/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Matrix
 *  android.graphics.Point
 *  android.graphics.SurfaceTexture
 *  android.opengl.Matrix
 *  android.util.AttributeSet
 *  android.util.Size
 *  android.view.Surface
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  d.v.d.h.b
 */
package com.zhiyun.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import android.util.AttributeSet;
import android.util.Size;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import com.zhiyun.android.CameraYun$2;
import com.zhiyun.android.CameraYun$a;
import com.zhiyun.android.R$styleable;
import com.zhiyun.renderengine.business.display.DisplayRender;
import com.zhiyun.renderengine.business.display.DisplayRender$u;
import d.v.b.a0;
import d.v.b.b0.k.a;
import d.v.b.b0.k.b;
import d.v.b.b0.k.c;
import d.v.b.b0.k.d;
import d.v.b.b0.k.f;
import d.v.b.b0.k.g;
import d.v.b.b0.k.h;
import d.v.b.b0.k.i;
import d.v.b.c0.e$a;
import d.v.b.d0.j;
import d.v.b.k;
import d.v.b.l;
import d.v.b.m;
import d.v.b.n;
import d.v.b.o;
import d.v.b.p;
import d.v.b.q;
import d.v.b.r;
import d.v.b.s;
import d.v.b.t;
import d.v.b.w;
import d.v.b.x;
import d.v.b.y;
import d.v.b0.f.c.b.e;
import d.v.d.i.a.c$a;
import d.v.d.i.f.u;
import d.v.d.i.f.v;
import d.v.d.i.f.z;
import d.v.d.i.g.k$a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CameraYun
implements x,
w,
y,
a0,
d.v.b.z {
    private Context a;
    private d.v.d.f b;
    private d.v.b.b0.j c;
    private d.v.b.e0.a d;
    private d.v.b.d0.i e;
    private d.v.b.f0.i f;
    private Size g;
    private d.v.d.i.f.l h;
    private ImageView i;
    private DisplayRender j;
    private float[] k;
    private final DisplayRender$u l;
    private long m;
    private long n;
    private boolean o;
    private final DefaultLifecycleObserver p;

    public CameraYun(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        Object object = new CameraYun$a(this);
        this.l = object;
        this.o = true;
        this.p = object = new CameraYun$2(this);
        d.v.d.h.f.a("init Camera Yun");
        this.a = context;
        this.I(context, viewGroup, attributeSet);
        this.G();
    }

    private int A() {
        Integer n10 = (Integer)this.getDeviceOrientation().get();
        int n11 = n10;
        Object object = this.d;
        int n12 = object.b();
        d.v.d.i.f.l l10 = this.getPreviewId();
        int n13 = l10.s();
        n13 = n13 != 0 ? -1 : 1;
        n11 = (n11 + (n12 *= n13) + 360) % 360;
        object = this.getPreviewId();
        n12 = (int)(((d.v.d.i.f.l)object).s() ? 1 : 0);
        if (n12 != 0) {
            n11 = (360 - n11) % 360;
        }
        return n11;
    }

    private d.v.d.i.f.q B() {
        return (d.v.d.i.f.q)this.b.i(275);
    }

    private d.v.d.i.f.s C() {
        return (d.v.d.i.f.s)this.b.i(289);
    }

    private v D() {
        return (v)this.b.i(288);
    }

    private d.v.d.i.f.o E() {
        return (d.v.d.i.f.o)this.b.i(276);
    }

    private d.v.b.f0.l.b F() {
        return (d.v.b.f0.l.b)this.f.a(8);
    }

    private void G() {
        d.v.d.h.f.a("init camera and start preview");
        Object object = this.a;
        Object object2 = new d.v.d.d((Context)object);
        this.b = object2;
        this.o();
        d.v.d.h.f.a("init Orientation");
        object = this.a;
        this.d = object2 = new d.v.b.e0.b((Context)object);
        this.q();
        d.v.d.h.f.a("init Beauty");
        object = this.j;
        this.c = object2 = new d.v.b.b0.i((DisplayRender)object);
        this.n();
    }

    private void H() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("initMaskAe ae isSupport=");
        boolean bl2 = this.getPreviewAe().i();
        ((StringBuilder)object).append(bl2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.getMaskValue();
        bl2 = this.getPreviewAe().i();
        Object object2 = this.getPreviewAe().e();
        Object object3 = this.getPreviewAe().f();
        ((d.v.b.c0.b)object).m(bl2, object2, object3);
        object = new StringBuilder();
        ((StringBuilder)object).append("reset Mask value=");
        String string2 = this.getMaskValue().toString();
        ((StringBuilder)object).append(string2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
    }

    private void I(Context context, ViewGroup viewGroup, AttributeSet object) {
        Context context2 = this.a;
        int[] nArray = R$styleable.CameraView;
        object = context2.obtainStyledAttributes((AttributeSet)object, nArray);
        int n10 = R$styleable.CameraView_beauty_mode;
        n10 = object.getInt(n10, 0);
        object.recycle();
        object = new StringBuilder();
        ((StringBuilder)object).append("init texture zy \uff0cbeautyMode=");
        ((StringBuilder)object).append(n10);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        this.f = object = new d.v.b.f0.k(context, n10);
        object = object.getView();
        viewGroup.addView((View)object);
        this.j = object = (DisplayRender)this.f.getRender();
        this.v();
        d.v.d.h.f.a("init blur view");
        object = new ImageView(context);
        this.i = object;
        context2 = ImageView.ScaleType.FIT_XY;
        object.setScaleType((ImageView.ScaleType)context2);
        this.i.setBackgroundColor(-16777216);
        object = this.i;
        viewGroup.addView((View)object);
        d.v.d.h.f.a("init mask view");
        this.e = object = new j(context);
        context = object.getView();
        viewGroup.addView((View)context);
        this.p();
    }

    private /* synthetic */ void J(Boolean bl2, int n10) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("beauty switch change=");
        ((StringBuilder)object).append(bl2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.getPreviewData();
        boolean bl3 = bl2;
        ((d.v.d.i.a.a)object).m(bl3);
    }

    private /* synthetic */ void L(Point point, int n10) {
        this.B().n(point);
    }

    private /* synthetic */ void N(Float f10, int n10) {
        d.v.d.i.a.a a10 = this.getPreviewStatus();
        n10 = (int)(((u)a10).o() ? 1 : 0);
        if (n10 != 0) {
            a10 = this.getPreviewWt();
            float f11 = f10.floatValue();
            ((z)a10).A(f11);
        }
    }

    private /* synthetic */ void P(Integer n10, int n11) {
        this.getPreviewAe().n(n10);
    }

    private /* synthetic */ void R(int n10) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("orientation change orientation=");
        ((StringBuilder)object).append(n10);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.getTextureOrientation();
        Integer n11 = n10;
        ((d.v.b.f0.l.d)object).q(n11);
        object = this.E();
        n11 = n10;
        ((d.v.d.i.a.a)object).set(n11);
        object = this.y();
        Integer n12 = n10;
        ((d.v.b.d0.k.g)object).o(n12);
    }

    private /* synthetic */ void T(Integer object, int n10) {
        Object object2 = this.getBeautySwitch();
        n10 = (int)(((h)object2).o() ? 1 : 0);
        if (n10 != 0) {
            this.y0();
            return;
        }
        int n11 = (Integer)object;
        if (n11 != (n10 = 1)) {
            n10 = 2;
            if (n11 != n10) {
                n10 = 3;
                if (n11 == n10) {
                    object = this.getPhotoControl();
                    n10 = 13;
                    object2 = n10;
                    ((d.v.d.i.e.a)object).n((Integer)object2);
                }
            } else {
                object = this.getPhotoControl();
                n10 = 12;
                object2 = n10;
                ((d.v.d.i.e.a)object).n((Integer)object2);
            }
        } else {
            object = this.getPhotoControl();
            n10 = 11;
            object2 = n10;
            ((d.v.d.i.e.a)object).n((Integer)object2);
        }
    }

    private /* synthetic */ void V(Integer n10, int n11) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("preview ae has change integer=");
        stringBuilder.append(n10);
        d.v.d.h.f.a(stringBuilder.toString());
        this.getMaskValue().o(n10);
    }

    private /* synthetic */ void X(d.v.d.i.a.b b10, int n10) {
        Object object = this.j;
        if (object != null && (object = this.g) != null) {
            object = this.getPreviewStatus();
            n10 = (int)(((u)object).o() ? 1 : 0);
            if (n10 == 0) {
                return;
            }
            object = b10.b();
            if (object == null) {
                return;
            }
            object = this.j;
            d.v.b0.c.b b11 = ((DisplayRender)object).L();
            byte[] byArray = b10.b();
            int n11 = this.g.getWidth();
            b10 = this.g;
            int n12 = b10.getHeight();
            float[] fArray = this.k;
            int n13 = this.x();
            b11.a(byArray, null, n11, n12, fArray, n13);
        }
    }

    private /* synthetic */ void Z(Size size, int n10) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("preview size change=");
        Object object2 = size.toString();
        ((StringBuilder)object).append((String)object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        this.getTextureRatio().n(true);
        object = this.getTextureRatio();
        double d10 = (double)size.getWidth() * 1.0;
        double d11 = size.getHeight();
        object2 = d10 / d11;
        ((d.v.b.f0.l.e)object).o((Double)object2);
        this.F().set(size);
        this.g = size;
    }

    private /* synthetic */ void b0(Float f10, int n10) {
        DisplayRender displayRender = this.j;
        if (displayRender != null) {
            float f11 = f10.floatValue();
            displayRender.h0(f11);
        }
    }

    private /* synthetic */ void d0(Integer object, int n10) {
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("record status change=");
        ((StringBuilder)object2).append(object);
        String string2 = ",status=";
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(n10);
        String string3 = ((StringBuilder)object2).toString();
        d.v.d.h.f.a(string3);
        int n11 = (Integer)object;
        n10 = 1;
        if (n11 != n10) {
            int n12 = 2;
            if (n11 != n12) {
                n10 = 4;
                if (n11 != n10) {
                    n10 = 5;
                    if (n11 == n10) {
                        d.v.d.h.f.a("stop  stop");
                        object = this.getRecordStatus();
                        n11 = (int)(((d.v.d.i.a.a)object).i() ? 1 : 0);
                        if (n11 != 0) {
                            object = d.v.b.c0.f.b();
                            ((d.v.b.c0.f)object).h(n12);
                        }
                    }
                } else {
                    d.v.d.h.f.a("PREPARE_STOP  stop filter record");
                    object = this.getTextureEncoder();
                    ((d.v.b.f0.l.c)object).p();
                }
            } else {
                d.v.d.h.f.a("start  start ");
                object = this.getRecordStatus();
                n11 = (int)(((d.v.d.i.a.a)object).i() ? 1 : 0);
                if (n11 != 0) {
                    object = d.v.b.c0.f.b();
                    ((d.v.b.c0.f)object).h(n10);
                }
            }
        } else {
            d.v.d.h.f.a("PREPARE_START  start filter record");
            object = this.getRecordSurface().get();
            if (object == null) {
                d.v.d.h.f.a("current is record surface==null ,return");
                return;
            }
            object = this.getTextureEncoder();
            string3 = (Surface)this.getRecordSurface().get();
            object2 = this.d;
            int n13 = object2.b();
            string2 = ((k$a)this.getRecordSize().get()).a;
            DisplayRender$u displayRender$u = this.l;
            ((d.v.b.f0.l.c)object).o((Surface)string3, n13, (Size)string2, displayRender$u);
        }
    }

    public static /* synthetic */ boolean e(CameraYun cameraYun, boolean bl2) {
        cameraYun.o = bl2;
        return bl2;
    }

    public static /* synthetic */ long f(CameraYun cameraYun, long l10) {
        cameraYun.n = l10;
        return l10;
    }

    private /* synthetic */ void f0(Integer n10, int n11) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select update integer=");
        stringBuilder.append(n10);
        d.v.d.h.f.a(stringBuilder.toString());
        this.z0(true);
    }

    public static /* synthetic */ boolean g(CameraYun cameraYun) {
        return cameraYun.w();
    }

    public static /* synthetic */ Context h(CameraYun cameraYun) {
        return cameraYun.a;
    }

    private /* synthetic */ void h0(Integer object, int n10) {
        int n11 = 2;
        n10 = (Integer)object;
        if (n11 == n10) {
            String string2 = "preview status  start";
            d.v.d.h.f.a(string2);
        }
        n10 = 3;
        float f10 = 4.2E-45f;
        int n12 = (Integer)object;
        if (n10 == n12) {
            d.v.d.h.f.a("preview status  ing");
            this.v0();
            object = this.j;
            if (object != null) {
                n10 = 1065353216;
                f10 = 1.0f;
                ((DisplayRender)object).h0(f10);
            }
            n12 = 0;
            object = null;
            this.z0(false);
            this.H();
        }
    }

    public static /* synthetic */ void i(CameraYun cameraYun, boolean bl2) {
        cameraYun.x0(bl2);
    }

    public static /* synthetic */ void j(CameraYun cameraYun) {
        cameraYun.l();
    }

    private /* synthetic */ void j0(Integer object, int n10) {
        Object object2 = new StringBuilder();
        String string2 = "photo status change integer=";
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(object);
        object2 = ((StringBuilder)object2).toString();
        d.v.d.h.f.a((String)object2);
        int n11 = (Integer)object;
        n10 = 2;
        if (n10 == n11) {
            d.v.d.h.f.a("photo status  start");
            object = this.getMaskAnimation();
            object2 = n10;
            ((d.v.b.d0.k.d)object).x((Integer)object2);
            object = d.v.b.c0.f.b();
            n10 = 0;
            object2 = null;
            ((d.v.b.c0.f)object).h(0);
        }
    }

    public static /* synthetic */ DefaultLifecycleObserver k(CameraYun cameraYun) {
        return cameraYun.p;
    }

    private void l() {
        this.b.d();
        this.d.close();
        this.e.release();
        this.c.release();
        d.v.b.c0.f.b().i();
        this.a = null;
    }

    private /* synthetic */ void l0(Size size, int n10) {
        this.z().set(size);
        this.getPreviewView().p(size);
        this.v0();
    }

    private Bitmap m(Bitmap bitmap, int n10) {
        if (bitmap == null) {
            return null;
        }
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        float f10 = n10;
        matrix.setRotate(f10);
        int n11 = bitmap.getWidth();
        int n12 = bitmap.getHeight();
        Bitmap bitmap2 = Bitmap.createBitmap((Bitmap)bitmap, (int)0, (int)0, (int)n11, (int)n12, (android.graphics.Matrix)matrix, (boolean)false);
        if (bitmap2 == bitmap) {
            return bitmap;
        }
        bitmap.recycle();
        return bitmap2;
    }

    private void n() {
        d.v.d.h.f.a(" create beauty listener");
        h h10 = this.getBeautySwitch();
        l l10 = new l(this);
        h10.h(l10);
    }

    private /* synthetic */ void n0(Integer object, int n10) {
        int n11;
        Object object2;
        int n12;
        n10 = (Integer)object;
        if (n10 == (n12 = 1)) {
            object2 = this.y();
            n12 = this.d.b();
            Integer n13 = n12;
            ((d.v.b.d0.k.g)object2).o(n13);
            object2 = this.D();
            n13 = this.f.getSurfaceTextureZy();
            ((v)object2).n((SurfaceTexture)n13);
            object2 = this.getPreviewList();
            n13 = this.f.getSurface();
            ((d.v.d.i.f.n)object2).n((Surface)n13);
            object2 = this.b;
            object2.c();
        }
        if ((n11 = ((Integer)object).intValue()) == (n10 = 3)) {
            object = this.D();
            object2 = this.f.getSurfaceTextureZy();
            ((v)object).n((SurfaceTexture)object2);
            object = this.getPreviewList();
            object2 = this.f.getSurface();
            ((d.v.d.i.f.n)object).n((Surface)object2);
        }
    }

    private void o() {
        d.v.d.h.f.a("create camera listener");
        this.u();
        this.s();
        this.r();
        this.t();
    }

    private void p() {
        d.v.d.h.f.a(" create mask listener");
        d.v.b.c0.b b10 = (d.v.b.d0.k.e)this.e.a(10);
        e$a e$a = new q(this);
        b10.h(e$a);
        b10 = (d.v.b.d0.k.j)this.e.a(9);
        e$a = new d.v.b.f(this);
        b10.h(e$a);
        b10 = this.getMaskValue();
        e$a = new k(this);
        b10.h(e$a);
    }

    private /* synthetic */ void p0() {
        this.i.setVisibility(8);
    }

    private void q() {
        this.x0(true);
        d.v.b.e0.a a10 = this.d;
        p p10 = new p(this);
        a10.e(p10);
        this.d.d();
    }

    private void r() {
        d.v.d.i.e.a a10 = this.getPhotoControl();
        d.v.b.h h10 = new d.v.b.h(this);
        a10.g(h10);
    }

    private /* synthetic */ void r0() {
        this.i.setVisibility(0);
    }

    private void s() {
        d.v.d.h.f.a("create preview size listener");
        d.v.d.i.a.a a10 = this.getPreviewSize();
        c$a c$a = new d.v.b.c(this);
        a10.g(c$a);
        a10 = this.getPreviewZoom();
        c$a = new d.v.b.i(this);
        a10.g(c$a);
        a10 = this.getPreviewAe();
        c$a = new o(this);
        a10.g(c$a);
        a10 = this.getPreviewData();
        c$a = new r(this);
        a10.g(c$a);
    }

    private void t() {
        d.v.d.i.g.l l10 = this.getRecordStatus();
        s s10 = new s(this);
        l10.g(s10);
    }

    private /* synthetic */ void t0(Bitmap bitmap) {
        this.i.setImageBitmap(bitmap);
        this.i.setVisibility(0);
    }

    private void u() {
        d.v.d.h.f.a("reset camera preview  photo status listener");
        d.v.d.i.a.a a10 = this.getCameraUpdate();
        c$a c$a = new m(this);
        a10.g(c$a);
        a10 = this.getPreviewStatus();
        c$a = new d.v.b.b(this);
        a10.g(c$a);
        a10 = this.getPhotoStatus();
        c$a = new d.v.b.e(this);
        a10.g(c$a);
    }

    private void v() {
        d.v.d.h.f.a("create texture listener");
        d.v.b.c0.b b10 = this.getTextureSize();
        e$a e$a = new d.v.b.j(this);
        b10.h(e$a);
        b10 = this.getTextureStatus();
        e$a = new t(this);
        b10.h(e$a);
    }

    private void v0() {
        Object object = this.g;
        if (object != null && (object = this.j) != null) {
            object = ((DisplayRender)object).L();
            int n10 = this.x();
            int n11 = (Integer)this.getDeviceOrientation().get();
            object.b(n10, n11);
            int n12 = this.getTextureSize().p();
            n10 = this.getTextureSize().o();
            n11 = this.g.getWidth();
            int n13 = this.g.getHeight();
            float[] fArray = d.v.b0.f.c.b.e.b(n12, n10, n11, n13);
            this.k = fArray;
            float f10 = 90.0f;
            float f11 = 1.0f;
            Matrix.rotateM((float[])fArray, (int)0, (float)f10, (float)0.0f, (float)0.0f, (float)f11);
            d.v.b0.c.b b10 = this.j.L();
            n11 = 0;
            n13 = 0;
            int n14 = this.g.getWidth();
            object = this.g;
            int n15 = object.getHeight();
            float[] fArray2 = this.k;
            int n16 = this.x();
            b10.a(null, null, n14, n15, fArray2, n16);
        }
    }

    private boolean w() {
        Object object = this.o;
        boolean bl2 = true;
        if (object == 0) {
            return bl2;
        }
        long l10 = System.nanoTime();
        long l11 = this.m;
        long l12 = (l10 -= l11) - (l11 = this.n);
        object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            this.m = l10 = System.nanoTime();
            return bl2;
        }
        return false;
    }

    private boolean w0() {
        d.v.d.i.a.a a10 = this.getPhotoMirror();
        boolean bl2 = ((d.v.d.i.e.c)a10).n();
        if (bl2 && (bl2 = ((d.v.d.i.f.l)(a10 = this.getPreviewId())).s())) {
            bl2 = true;
        } else {
            bl2 = false;
            a10 = null;
        }
        return bl2;
    }

    private int x() {
        boolean bl2;
        d.v.d.i.f.l l10 = this.h;
        if (l10 == null) {
            this.h = l10 = this.getPreviewId();
        }
        if (bl2 = (l10 = this.h).s()) {
            return 1;
        }
        return 0;
    }

    private void x0(boolean bl2) {
        d.v.b.e0.a a10 = this.d;
        if (a10 != null) {
            a10.c(bl2);
        }
    }

    private d.v.b.d0.k.g y() {
        return (d.v.b.d0.k.g)this.e.a(4);
    }

    private void y0() {
        Object iOException;
        int n10;
        d.v.d.h.f.a("take photo for beauty");
        Object object2 = this.getPreviewStatus();
        boolean n11 = ((u)object2).o();
        if (!n11) {
            return;
        }
        int n12 = this.getTextureSize().p();
        object2 = this.b(n12, n10 = ((d.v.b.f0.l.f)(iOException = this.getTextureSize())).o());
        if (object2 == null) {
            return;
        }
        iOException = new ByteArrayOutputStream();
        Object object = Bitmap.CompressFormat.JPEG;
        int n13 = 100;
        object2.compress(object, n13, (OutputStream)iOException);
        object2 = ((ByteArrayOutputStream)iOException).toByteArray();
        try {
            ((ByteArrayOutputStream)iOException).close();
        }
        catch (IOException iOException2) {
            iOException2.printStackTrace();
        }
        iOException = this.getPhotoStatus();
        object = 2;
        ((d.v.d.i.e.g)iOException).r((Integer)object);
        iOException = this.getPhotoData();
        boolean bl2 = this.w0();
        n13 = this.d.b();
        ((d.v.d.i.e.b)iOException).o((byte[])object2, bl2, n13);
    }

    private d.v.b.d0.k.k z() {
        return (d.v.b.d0.k.k)this.e.a(12);
    }

    private void z0(boolean bl2) {
        Object object = new StringBuilder();
        Object object2 = "update blur  show=";
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append(bl2);
        object = ((StringBuilder)object).toString();
        d.v.d.h.f.a((String)object);
        if (!bl2) {
            ImageView imageView = this.i;
            object = new d.v.b.d(this);
            object2 = this.getCameraApi();
            boolean bl3 = ((d.v.d.i.b.a)object2).p();
            long l10 = bl3 ? 200L : (long)100;
            imageView.postDelayed((Runnable)object, l10);
            return;
        }
        d.v.d.i.f.s s10 = this.C();
        boolean bl4 = s10.n();
        object = this.getTextureSize();
        int n10 = ((d.v.b.f0.l.f)object).p();
        if (!bl4) {
            n10 /= 5;
        }
        int n11 = ((d.v.b.f0.l.f)object).o();
        if (!bl4) {
            n11 /= 5;
        }
        d.v.b.f0.i i10 = this.f;
        object = i10.b(n10, n11);
        if (object == null) {
            s10 = this.i;
            object = new d.v.b.g(this);
            s10.post((Runnable)object);
            return;
        }
        if (!bl4) {
            int n12 = 1061997773;
            float f10 = 0.8f;
            n10 = 30;
            object = d.v.d.h.b.a((Bitmap)object, (float)f10, (int)n10);
        }
        s10 = this.i;
        object2 = new n(this, (Bitmap)object);
        s10.post((Runnable)object2);
    }

    public /* synthetic */ void K(Boolean bl2, int n10) {
        this.J(bl2, n10);
    }

    public /* synthetic */ void M(Point point, int n10) {
        this.L(point, n10);
    }

    public /* synthetic */ void O(Float f10, int n10) {
        this.N(f10, n10);
    }

    public /* synthetic */ void Q(Integer n10, int n11) {
        this.P(n10, n11);
    }

    public /* synthetic */ void S(int n10) {
        this.R(n10);
    }

    public /* synthetic */ void U(Integer n10, int n11) {
        this.T(n10, n11);
    }

    public /* synthetic */ void W(Integer n10, int n11) {
        this.V(n10, n11);
    }

    public /* synthetic */ void Y(d.v.d.i.a.b b10, int n10) {
        this.X(b10, n10);
    }

    public void a() {
        this.b.a();
    }

    public /* synthetic */ void a0(Size size, int n10) {
        this.Z(size, n10);
    }

    public Bitmap b(int n10, int n11) {
        Bitmap bitmap = this.f.b(n10, n11);
        n11 = this.A();
        return this.m(bitmap, n11);
    }

    public void c() {
        Object object = this.getTextureStatus();
        boolean bl2 = ((d.v.b.f0.l.g)object).o();
        if (bl2 && (object = this.getPreviewView().get()) != null) {
            object = this.b;
            object.c();
        }
    }

    public /* synthetic */ void c0(Float f10, int n10) {
        this.b0(f10, n10);
    }

    public void d(Lifecycle lifecycle) {
        DefaultLifecycleObserver defaultLifecycleObserver = this.p;
        lifecycle.addObserver(defaultLifecycleObserver);
    }

    public /* synthetic */ void e0(Integer n10, int n11) {
        this.d0(n10, n11);
    }

    public /* synthetic */ void g0(Integer n10, int n11) {
        this.f0(n10, n11);
    }

    public a getBeautyCheek() {
        return (a)this.c.a(2);
    }

    public b getBeautyEye() {
        return (b)this.c.a(5);
    }

    public c getBeautyFilter() {
        return (c)this.c.a(1);
    }

    public d getBeautyLight() {
        return (d)this.c.a(6);
    }

    public f getBeautyRosy() {
        return (f)this.c.a(7);
    }

    public g getBeautySkin() {
        return (g)this.c.a(3);
    }

    public h getBeautySwitch() {
        return (h)this.c.a(9);
    }

    public i getBeautyWhite() {
        return (i)this.c.a(4);
    }

    public d.v.d.i.b.a getCameraApi() {
        return (d.v.d.i.b.a)this.b.g(2);
    }

    public d.v.d.i.b.b getCameraMode() {
        return (d.v.d.i.b.b)this.b.g(1);
    }

    public d.v.d.i.b.d getCameraStatus() {
        return (d.v.d.i.b.d)this.b.g(3);
    }

    public d.v.d.i.b.e getCameraUpdate() {
        return (d.v.d.i.b.e)this.b.g(0);
    }

    public d.v.d.i.c.a getDeviceOrientation() {
        return (d.v.d.i.c.a)this.b.h(81);
    }

    public d.v.d.i.c.c getDeviceStatus() {
        return (d.v.d.i.c.c)this.b.h(80);
    }

    public d.v.d.i.d.c getLivePcm() {
        return (d.v.d.i.d.c)this.b.e(1025);
    }

    public d.v.d.i.d.d getLiveRecord() {
        return (d.v.d.i.d.d)this.b.e(1024);
    }

    public d.v.b.d0.k.d getMaskAnimation() {
        return (d.v.b.d0.k.d)this.e.a(3);
    }

    public d.v.b.d0.k.f getMaskColor() {
        return (d.v.b.d0.k.f)this.e.a(2);
    }

    public d.v.b.d0.k.h getMaskGrid() {
        return (d.v.b.d0.k.h)this.e.a(1);
    }

    public d.v.b.d0.k.i getMaskMotion() {
        return (d.v.b.d0.k.i)this.e.a(8);
    }

    public d.v.b.d0.k.j getMaskScale() {
        return (d.v.b.d0.k.j)this.e.a(9);
    }

    public d.v.b.d0.k.l getMaskValue() {
        return (d.v.b.d0.k.l)this.e.a(11);
    }

    public d.v.d.i.e.a getPhotoControl() {
        return (d.v.d.i.e.a)this.b.b(512);
    }

    public d.v.d.i.e.b getPhotoData() {
        return (d.v.d.i.e.b)this.b.b(514);
    }

    public d.v.d.i.e.c getPhotoMirror() {
        return (d.v.d.i.e.c)this.b.b(518);
    }

    public d.v.d.i.e.e getPhotoPath() {
        return (d.v.d.i.e.e)this.b.b(515);
    }

    public d.v.d.i.e.f getPhotoSize() {
        return (d.v.d.i.e.f)this.b.b(516);
    }

    public d.v.d.i.e.g getPhotoStatus() {
        return (d.v.d.i.e.g)this.b.b(513);
    }

    public d.v.d.i.e.h getPhotoTime() {
        return (d.v.d.i.e.h)this.b.b(517);
    }

    public d.v.d.i.f.e getPreviewAe() {
        return (d.v.d.i.f.e)this.b.i(260);
    }

    public d.v.d.i.f.f getPreviewAf() {
        return (d.v.d.i.f.f)this.b.i(258);
    }

    public d.v.d.i.f.g getPreviewData() {
        return (d.v.d.i.f.g)this.b.i(272);
    }

    public d.v.d.i.f.h getPreviewFace() {
        return (d.v.d.i.f.h)this.b.i(277);
    }

    public d.v.d.i.f.i getPreviewFlash() {
        return (d.v.d.i.f.i)this.b.i(279);
    }

    public d.v.d.i.f.j getPreviewFocus() {
        return (d.v.d.i.f.j)this.b.i(278);
    }

    public d.v.d.i.f.l getPreviewId() {
        return (d.v.d.i.f.l)this.b.i(256);
    }

    public d.v.d.i.f.m getPreviewIso() {
        return (d.v.d.i.f.m)this.b.i(262);
    }

    public d.v.d.i.f.n getPreviewList() {
        return (d.v.d.i.f.n)this.b.i(273);
    }

    public d.v.d.i.f.r getPreviewSec() {
        return (d.v.d.i.f.r)this.b.i(263);
    }

    public d.v.d.i.f.t getPreviewSize() {
        return (d.v.d.i.f.t)this.b.i(265);
    }

    public u getPreviewStatus() {
        return (u)this.b.i(257);
    }

    public d.v.d.i.f.w getPreviewView() {
        return (d.v.d.i.f.w)this.b.i(274);
    }

    public d.v.d.i.f.x getPreviewWb() {
        return (d.v.d.i.f.x)this.b.i(261);
    }

    public d.v.d.i.f.y getPreviewWbType() {
        return (d.v.d.i.f.y)this.b.i(264);
    }

    public z getPreviewWt() {
        return (z)this.b.i(259);
    }

    public d.v.d.i.f.a0 getPreviewZoom() {
        return (d.v.d.i.f.a0)this.b.i(290);
    }

    public d.v.d.i.g.c getRecordArm() {
        return (d.v.d.i.g.c)this.b.f(774);
    }

    public d.v.d.i.g.e getRecordCapture() {
        return (d.v.d.i.g.e)this.b.f(784);
    }

    public d.v.d.i.g.f getRecordControl() {
        return (d.v.d.i.g.f)this.b.f(776);
    }

    public d.v.d.i.g.g getRecordMic() {
        return (d.v.d.i.g.g)this.b.f(787);
    }

    public d.v.d.i.g.h getRecordMute() {
        return (d.v.d.i.g.h)this.b.f(785);
    }

    public d.v.d.i.g.j getRecordPath() {
        return (d.v.d.i.g.j)this.b.f(773);
    }

    public d.v.d.i.g.k getRecordSize() {
        return (d.v.d.i.g.k)this.b.f(771);
    }

    public d.v.d.i.g.l getRecordStatus() {
        return (d.v.d.i.g.l)this.b.f(770);
    }

    public d.v.d.i.g.m getRecordSurface() {
        return (d.v.d.i.g.m)this.b.f(769);
    }

    public d.v.d.i.g.n getRecordVolume() {
        return (d.v.d.i.g.n)this.b.f(777);
    }

    public d.v.b.f0.l.c getTextureEncoder() {
        return (d.v.b.f0.l.c)this.f.a(10);
    }

    public d.v.b.f0.l.d getTextureOrientation() {
        return (d.v.b.f0.l.d)this.f.a(9);
    }

    public d.v.b.f0.l.e getTextureRatio() {
        return (d.v.b.f0.l.e)this.f.a(7);
    }

    public d.v.b.f0.l.f getTextureSize() {
        return (d.v.b.f0.l.f)this.f.a(6);
    }

    public d.v.b.f0.l.g getTextureStatus() {
        return (d.v.b.f0.l.g)this.f.a(5);
    }

    public /* synthetic */ void i0(Integer n10, int n11) {
        this.h0(n10, n11);
    }

    public /* synthetic */ void k0(Integer n10, int n11) {
        this.j0(n10, n11);
    }

    public /* synthetic */ void m0(Size size, int n10) {
        this.l0(size, n10);
    }

    public /* synthetic */ void o0(Integer n10, int n11) {
        this.n0(n10, n11);
    }

    public /* synthetic */ void q0() {
        this.p0();
    }

    public /* synthetic */ void s0() {
        this.r0();
    }

    public /* synthetic */ void u0(Bitmap bitmap) {
        this.t0(bitmap);
    }
}

