/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.SurfaceTexture
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.DisplayMetrics
 *  android.util.Size
 *  android.util.SparseArray
 *  android.view.Surface
 *  android.view.TextureView
 *  android.view.TextureView$SurfaceTextureListener
 *  android.view.View$MeasureSpec
 *  android.view.animation.AccelerateInterpolator
 *  com.zhiyun.renderengine.engine.zhiyun.opengl.ZhiYunRenderEngine
 */
package d.v.b.f0;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Size;
import android.util.SparseArray;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.zhiyun.renderengine.business.display.DisplayRender;
import com.zhiyun.renderengine.business.display.DisplayRender$EngineCombinationMode;
import com.zhiyun.renderengine.business.display.DisplayRender$s;
import com.zhiyun.renderengine.engine.IRenderEngine;
import com.zhiyun.renderengine.engine.RenderEngineType;
import com.zhiyun.renderengine.engine.zhiyun.opengl.ZhiYunRenderEngine;
import d.v.b.c0.e$a;
import d.v.b.f0.a;
import d.v.b.f0.i;
import d.v.b.f0.k$a;
import d.v.b.f0.k$b;
import d.v.b.f0.l.b;
import d.v.b.f0.l.c;
import d.v.b.f0.l.d;
import d.v.b.f0.l.e;
import d.v.b.f0.l.f;
import d.v.b.f0.l.g;

public class k
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
    private DisplayRender i;
    private final Handler j;
    private final DisplayMetrics k;
    private int l;
    private int m;
    private ValueAnimator n;

    public k(Context context) {
        super(context);
        SparseArray sparseArray;
        this.c = sparseArray = new SparseArray();
        this.n(context, 0);
        sparseArray = Looper.getMainLooper();
        super((Looper)sparseArray);
        this.j = context;
        context = this.getResources().getDisplayMetrics();
        this.k = context;
        this.m();
    }

    public k(Context context, int n10) {
        super(context);
        SparseArray sparseArray;
        this.c = sparseArray = new SparseArray();
        this.n(context, n10);
        Looper looper = Looper.getMainLooper();
        super(looper);
        this.j = context;
        context = this.getResources().getDisplayMetrics();
        this.k = context;
        this.m();
    }

    public static /* synthetic */ DisplayRender c(k k10) {
        return k10.i;
    }

    public static /* synthetic */ SurfaceTexture d(k k10) {
        return k10.b;
    }

    public static /* synthetic */ SurfaceTexture e(k k10, SurfaceTexture surfaceTexture) {
        k10.b = surfaceTexture;
        return surfaceTexture;
    }

    public static /* synthetic */ Surface f(k k10, Surface surface) {
        k10.a = surface;
        return surface;
    }

    public static /* synthetic */ void g(k k10, int n10, int n11) {
        k10.w(n10, n11);
    }

    public static /* synthetic */ g h(k k10) {
        return k10.e;
    }

    public static /* synthetic */ void i(k k10) {
        k10.v();
    }

    private void j(int n10, d.v.b.c0.b b10) {
        this.c.append(n10, (Object)b10);
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
            object2 = new d.v.b.f0.g(this);
            valueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)object2);
            valueAnimator = this.n;
            long l10 = 250L;
            d10 = 1.235E-321;
            valueAnimator.setDuration(l10);
            valueAnimator = this.n;
            object2 = new AccelerateInterpolator();
            valueAnimator.setInterpolator((TimeInterpolator)object2);
            valueAnimator = this.n;
            valueAnimator.start();
        }
    }

    private Bitmap l(int n10, int n11) {
        DisplayMetrics displayMetrics = this.k;
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        return Bitmap.createBitmap((DisplayMetrics)displayMetrics, (int)n10, (int)n11, (Bitmap.Config)config);
    }

    private void m() {
        d.v.b.c0.b b10 = new g();
        this.e = b10;
        this.j(5, b10);
        b10 = new d();
        this.h = b10;
        this.j(9, b10);
        Object object = this.i;
        b10 = new c((DisplayRender)object);
        this.j(10, b10);
        b10 = new e();
        this.f = b10;
        this.j(7, b10);
        b10 = new f();
        this.d = b10;
        this.j(6, b10);
        b10 = new b();
        this.g = b10;
        this.j(8, b10);
        b10 = this.g;
        object = new d.v.b.f0.e(this);
        b10.h((e$a)object);
    }

    private void n(Context object, int n10) {
        DisplayRender displayRender;
        d.v.d.h.f.a("init texture zy");
        this.i = displayRender = new DisplayRender((Context)object);
        object = this.o(n10);
        displayRender.d0((IRenderEngine[])object);
        object = this.i;
        Object object2 = DisplayRender$EngineCombinationMode.SELECT_ENGINE_APPLY;
        ((DisplayRender)object).p0((DisplayRender$EngineCombinationMode)((Object)object2));
        object = this.i;
        object2 = RenderEngineType.FACE_UNITY_ENGINE;
        ((DisplayRender)object).y0((RenderEngineType)((Object)object2));
        object = new k$a(this);
        this.setSurfaceTextureListener((TextureView.SurfaceTextureListener)object);
        object = this.i;
        object2 = new k$b(this);
        ((DisplayRender)object).o0((DisplayRender$s)object2);
    }

    private IRenderEngine[] o(int n10) {
        String string2 = "init render";
        d.v.d.h.f.a(string2);
        if (n10 == 0) {
            return null;
        }
        string2 = null;
        int n11 = 1;
        if (n11 == n10) {
            IRenderEngine[] iRenderEngineArray = new IRenderEngine[n11];
            d.v.b0.e.c.a a10 = new d.v.b0.e.c.a();
            iRenderEngineArray[0] = a10;
            return iRenderEngineArray;
        }
        int n12 = 2;
        if (n12 == n10) {
            IRenderEngine[] iRenderEngineArray = new IRenderEngine[n11];
            ZhiYunRenderEngine zhiYunRenderEngine = new ZhiYunRenderEngine();
            iRenderEngineArray[0] = zhiYunRenderEngine;
            return iRenderEngineArray;
        }
        IRenderEngine[] iRenderEngineArray = new IRenderEngine[n12];
        d.v.b0.e.c.a a11 = new d.v.b0.e.c.a();
        iRenderEngineArray[0] = a11;
        string2 = new ZhiYunRenderEngine();
        iRenderEngineArray[n11] = string2;
        return iRenderEngineArray;
    }

    public static /* synthetic */ void p(k k10, ValueAnimator valueAnimator) {
        k10.u(valueAnimator);
    }

    private /* synthetic */ void q(Size size, int n10) {
        Object object = new StringBuilder();
        String string2 = "texture data change =";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(size);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.b;
        if (object == null) {
            return;
        }
        int n11 = size.getWidth();
        int n12 = size.getHeight();
        object.setDefaultBufferSize(n11, n12);
        size = this.j;
        object = new d.v.b.f0.f(this);
        size.post((Runnable)object);
    }

    private /* synthetic */ void s() {
        int n10 = this.d.p();
        int n11 = this.d.o();
        this.k(n10, n11);
    }

    private void u(ValueAnimator valueAnimator) {
        int n10;
        this.l = n10 = ((Integer)valueAnimator.getAnimatedValue()).intValue();
        valueAnimator = this.j;
        a a10 = new a(this);
        valueAnimator.postDelayed((Runnable)a10, (long)10);
    }

    private void v() {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = (object = this.c).size()); ++i10) {
            object = (d.v.b.c0.e)this.c.valueAt(i10);
            object.b();
        }
    }

    private void w(int n10, int n11) {
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
            Bitmap bitmap = this.l(n10, n11);
            return this.getBitmap(bitmap);
        }
        return null;
    }

    public DisplayRender getRender() {
        return this.i;
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

    public /* synthetic */ void r(Size size, int n10) {
        this.q(size, n10);
    }

    public /* synthetic */ void t() {
        this.s();
    }
}

