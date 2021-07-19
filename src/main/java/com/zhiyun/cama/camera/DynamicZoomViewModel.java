/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.graphics.RectF
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.view.animation.LinearInterpolator
 */
package com.zhiyun.cama.camera;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.RectF;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.animation.LinearInterpolator;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.zhiyun.cama.camera.DynamicZoomViewModel$TargetModel;
import com.zhiyun.cama.camera.DynamicZoomViewModel$a;
import com.zhiyun.cama.camera.DynamicZoomViewModel$b;
import com.zhiyun.cama.camera.DynamicZoomViewModel$c;
import com.zhiyun.cama.camera.DynamicZoomViewModel$d;
import com.zhiyun.cama.camera.DynamicZoomViewModel$e;
import com.zhiyun.cama.camera.DynamicZoomViewModel$f;
import com.zhiyun.cama.camera.DynamicZoomViewModel$g;
import com.zhiyun.cama.camera.DynamicZoomViewModel$h;
import d.v.c.s0.d6;
import d.v.c.v0.n.d;
import d.v.c.x1.k;
import m.a.a;

public class DynamicZoomViewModel
extends ViewModel {
    private int A;
    public MutableLiveData B;
    private int C;
    private int D;
    private HandlerThread E;
    private Handler F;
    private DynamicZoomViewModel$f G;
    private volatile boolean H;
    private Runnable I;
    private Runnable J;
    private volatile boolean K;
    private Runnable L;
    private volatile boolean M;
    private Runnable N;
    private k O;
    private k P;
    private k Q;
    private k R;
    private boolean S;
    private final String a;
    private d b;
    public final MutableLiveData c;
    private final MutableLiveData d;
    private final MutableLiveData e;
    public final MutableLiveData f;
    public final MutableLiveData g;
    public final MutableLiveData h;
    private float i;
    private RectF j;
    private RectF k;
    private int l;
    private float m;
    private float n;
    private float o;
    private float p;
    private int q;
    private int r;
    private float s;
    private float t;
    private DynamicZoomViewModel$h u;
    private RectF v;
    private final MutableLiveData w;
    public boolean x;
    private DynamicZoomViewModel$e y;
    private long z;

    public DynamicZoomViewModel() {
        boolean bl2;
        float f10;
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        this.a = "ZL";
        this.c = mutableLiveData2 = new MutableLiveData();
        this.d = mutableLiveData2 = new MutableLiveData();
        this.e = mutableLiveData2 = new MutableLiveData();
        this.f = mutableLiveData2 = new MutableLiveData();
        Object object = new MutableLiveData();
        this.g = object;
        this.h = mutableLiveData = new MutableLiveData();
        this.i = 0.0f;
        this.l = 0;
        this.m = f10 = 50.0f;
        this.n = f10 *= 10.0f;
        this.o = f10 = 1.0f;
        this.s = f10;
        this.t = 4.0f;
        Object object2 = new DynamicZoomViewModel$h();
        this.u = object2;
        this.w = object2 = new MutableLiveData();
        this.x = false;
        this.y = object2 = new DynamicZoomViewModel$e(null);
        this.A = 30;
        this.B = object2 = new MutableLiveData();
        this.C = 0;
        this.D = 0;
        this.H = false;
        this.I = object2 = new DynamicZoomViewModel$a(this);
        this.J = object2 = new DynamicZoomViewModel$b(this);
        this.K = false;
        this.L = object2 = new DynamicZoomViewModel$c(this);
        this.M = false;
        Object object3 = new DynamicZoomViewModel$d(this);
        this.N = object3;
        this.S = true;
        this.b = object3 = d.v.c.v0.n.d.s();
        this.x = bl2 = ((d)object3).M();
        object3 = Boolean.FALSE;
        ((MutableLiveData)object).setValue(object3);
        mutableLiveData.setValue(object3);
        object = Boolean.TRUE;
        mutableLiveData2.setValue(object);
        this.v();
        super("DynamicZoomViewModel HandThread.");
        this.E = mutableLiveData2;
        mutableLiveData2.start();
        object = this.E.getLooper();
        super((Looper)object);
        this.F = mutableLiveData2;
    }

    private void F() {
        k k10 = this.O;
        if (k10 != null) {
            k10.f();
        }
        if ((k10 = this.Q) != null) {
            k10.f();
        }
        if ((k10 = this.P) != null) {
            k10.f();
        }
        if ((k10 = this.R) != null) {
            k10.f();
        }
    }

    private boolean T(RectF rectF) {
        Object object;
        float f10;
        RectF rectF2;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        if (rectF != null) {
            f15 = rectF.left;
            f14 = 10.0f;
            f13 = rectF.top * f14;
            f12 = rectF.right * f14;
            f11 = rectF.bottom * f14;
            rectF2 = new RectF(f15 *= f14, f13, f12, f11);
        } else {
            f10 = 0.0f;
            rectF2 = null;
        }
        rectF = this.v;
        boolean bl2 = false;
        f15 = 0.0f;
        if (rectF != null && (object = rectF.isEmpty()) == 0 && rectF2 != null && (object = rectF2.isEmpty()) == 0) {
            float f16;
            rectF = this.v;
            object = rectF.contains(rectF2);
            if (object != 0) {
                return false;
            }
            RectF rectF3 = this.v;
            rectF = new RectF(rectF3);
            rectF.union(rectF2);
            f14 = rectF.width();
            f11 = rectF.height();
            RectF rectF4 = this.v;
            f13 = rectF4.width();
            f12 = rectF2.width();
            f13 += f12;
            RectF rectF5 = this.v;
            f12 = rectF5.height();
            float f17 = rectF2.height();
            float f18 = f14 == f13 ? 0 : (f14 < f13 ? -1 : 1);
            boolean bl3 = true;
            float f19 = Float.MIN_VALUE;
            if (f18 < 0 && (f18 = (f16 = f11 - (f12 += f17)) == 0.0f ? 0 : (f16 < 0.0f ? -1 : 1)) < 0) {
                f13 -= f14;
                f13 *= (f12 -= f11);
                f11 = rectF2.width();
                f10 = rectF2.height();
                f11 *= f10;
                f10 = 3.0f;
                float f20 = f13 - (f11 /= f10);
                object = f20 == 0.0f ? 0 : (f20 > 0.0f ? 1 : -1);
                if (object <= 0) {
                    bl2 = bl3;
                    f15 = f19;
                }
                return bl2;
            }
            return bl3;
        }
        return false;
    }

    public static /* synthetic */ boolean b(DynamicZoomViewModel dynamicZoomViewModel, boolean bl2) {
        dynamicZoomViewModel.H = bl2;
        return bl2;
    }

    public static /* synthetic */ DynamicZoomViewModel$f c(DynamicZoomViewModel dynamicZoomViewModel) {
        return dynamicZoomViewModel.G;
    }

    public static /* synthetic */ MutableLiveData d(DynamicZoomViewModel dynamicZoomViewModel) {
        return dynamicZoomViewModel.d;
    }

    public static /* synthetic */ boolean e(DynamicZoomViewModel dynamicZoomViewModel, boolean bl2) {
        dynamicZoomViewModel.K = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean f(DynamicZoomViewModel dynamicZoomViewModel, boolean bl2) {
        dynamicZoomViewModel.M = bl2;
        return bl2;
    }

    private boolean i(RectF rectF, DynamicZoomViewModel$e dynamicZoomViewModel$e) {
        if (rectF != null) {
            float f10 = rectF.width();
            float f11 = rectF.height();
            float f12 = (f10 *= f11) - (f11 = this.n);
            Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
            if (object >= 0) {
                dynamicZoomViewModel$e.a = "reached the threshold of the lost rect.";
                return true;
            }
        }
        return false;
    }

    private float k(float f10) {
        float f11 = 1.0f;
        Object object = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
        float f12 = 3.0f;
        if (object >= 0 && (object = f10 == f12 ? 0 : (f10 < f12 ? -1 : 1)) <= 0) {
            return f10;
        }
        object = f10 == f12 ? 0 : (f10 > f12 ? 1 : -1);
        if (object > 0) {
            return f12;
        }
        Object object2 = f10 == f11 ? 0 : (f10 < f11 ? -1 : 1);
        if (object2 < 0) {
            // empty if block
        }
        return f11;
    }

    private RectF m(RectF rectF) {
        boolean bl2;
        if (rectF != null && !(bl2 = rectF.isEmpty())) {
            k k10 = this.O;
            float f10 = rectF.left;
            k10.e(f10);
            k10 = this.Q;
            f10 = rectF.top;
            k10.e(f10);
            k10 = this.P;
            f10 = rectF.right;
            k10.e(f10);
            k10 = this.R;
            float f11 = rectF.bottom;
            k10.e(f11);
            float f12 = this.O.b();
            f10 = this.Q.b();
            float f13 = this.P.b();
            float f14 = this.R.b();
            rectF = new RectF(f12, f10, f13, f14);
            return rectF;
        }
        return null;
    }

    private void v() {
        k k10;
        int n10 = 25;
        this.O = k10 = new k(n10);
        this.Q = k10 = new k(n10);
        this.P = k10 = new k(n10);
        this.R = k10 = new k(n10);
    }

    public static /* synthetic */ void y(DynamicZoomViewModel$g dynamicZoomViewModel$g, DynamicZoomViewModel$TargetModel dynamicZoomViewModel$TargetModel, ValueAnimator object) {
        if (dynamicZoomViewModel$g != null) {
            object = (Float)object.getAnimatedValue();
            float f10 = ((Float)object).floatValue();
            dynamicZoomViewModel$g.a(dynamicZoomViewModel$TargetModel, f10);
        }
    }

    public void A() {
        float f10;
        this.o = f10 = 1.0f;
        this.p = f10;
    }

    public void G(int n10, int n11) {
        this.q = n10;
        this.r = n11;
    }

    public void H(boolean bl2) {
        synchronized (this) {
            MutableLiveData mutableLiveData = this.w;
            Boolean bl3 = bl2;
            mutableLiveData.postValue(bl3);
            return;
        }
    }

    public void I(boolean bl2) {
        MutableLiveData mutableLiveData = this.B;
        Boolean bl3 = bl2;
        mutableLiveData.postValue(bl3);
    }

    public void J(float f10) {
        this.p = f10 = this.j(f10);
    }

    public void K() {
        DynamicZoomViewModel$TargetModel dynamicZoomViewModel$TargetModel;
        DynamicZoomViewModel$TargetModel dynamicZoomViewModel$TargetModel2 = d.v.c.v0.n.d.s().p();
        if (dynamicZoomViewModel$TargetModel2 == (dynamicZoomViewModel$TargetModel = DynamicZoomViewModel$TargetModel.NEAR)) {
            this.Q();
        } else {
            this.P();
        }
    }

    public void L(DynamicZoomViewModel$f dynamicZoomViewModel$f) {
        this.G = dynamicZoomViewModel$f;
    }

    public void M(RectF rectF) {
        boolean bl2;
        if (rectF != null && !(bl2 = rectF.isEmpty())) {
            this.v = rectF;
        }
    }

    public void N(boolean bl2) {
        this.S = bl2;
    }

    public void P() {
        Object object = this.d;
        DynamicZoomViewModel$TargetModel dynamicZoomViewModel$TargetModel = DynamicZoomViewModel$TargetModel.FAR;
        ((MutableLiveData)object).postValue((Object)dynamicZoomViewModel$TargetModel);
        object = this.b;
        if (object != null) {
            ((d)object).h0(dynamicZoomViewModel$TargetModel);
        }
    }

    public void Q() {
        Object object = this.d;
        DynamicZoomViewModel$TargetModel dynamicZoomViewModel$TargetModel = DynamicZoomViewModel$TargetModel.NEAR;
        ((MutableLiveData)object).postValue((Object)dynamicZoomViewModel$TargetModel);
        object = this.b;
        if (object != null) {
            ((d)object).h0(dynamicZoomViewModel$TargetModel);
        }
    }

    public void R(float f10, float f11) {
        int n10 = 1065353216;
        float f12 = 1.0f;
        float f13 = f10 - f12;
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object <= 0) {
            f10 = f12;
        }
        this.s = f10;
        f10 = 4.0f;
        n10 = (int)(f11 == f10 ? 0 : (f11 < f10 ? -1 : 1));
        if (n10 >= 0) {
            f11 = f10;
        }
        this.t = f11;
    }

    public boolean S() {
        return this.S;
    }

    public float U(DynamicZoomViewModel$TargetModel dynamicZoomViewModel$TargetModel, boolean bl2, float f10) {
        float f11;
        float f12;
        float f13;
        DynamicZoomViewModel$TargetModel dynamicZoomViewModel$TargetModel2 = DynamicZoomViewModel$TargetModel.FAR;
        if (dynamicZoomViewModel$TargetModel == dynamicZoomViewModel$TargetModel2 && (f13 = (f12 = f10 - (f11 = 1.0f)) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1)) != false) {
            f13 = 1068205343;
            f11 = 1.34f;
            f10 *= f11;
        }
        return f10;
    }

    public void V(float f10, float f11, DynamicZoomViewModel$TargetModel dynamicZoomViewModel$TargetModel, DynamicZoomViewModel$g dynamicZoomViewModel$g) {
        float[] fArray = new float[]{f10, f11};
        ValueAnimator valueAnimator = ValueAnimator.ofFloat((float[])fArray);
        long l10 = this.A;
        valueAnimator.setDuration(l10);
        valueAnimator.setRepeatCount(0);
        Object object = new LinearInterpolator();
        valueAnimator.setInterpolator((TimeInterpolator)object);
        object = new d6(dynamicZoomViewModel$g, dynamicZoomViewModel$TargetModel);
        valueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)object);
        valueAnimator.start();
    }

    public DynamicZoomViewModel$h W(RectF object) {
        float f10;
        Object object2 = this.u;
        ((DynamicZoomViewModel$h)object2).b();
        long l10 = this.z;
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 == false) {
            this.z = l10 = System.currentTimeMillis();
        }
        l10 = System.currentTimeMillis();
        l11 = this.z;
        int n10 = this.A;
        long l13 = n10;
        long l14 = (l11 = l10 - l11) - l13;
        Object object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object3 < 0) {
            return this.u;
        }
        this.z = l10;
        object2 = this.u;
        ((DynamicZoomViewModel$h)object2).d = f10 = ((DynamicZoomViewModel$h)object2).e;
        if (object != null) {
            object2 = this.y;
            l12 = (long)this.i((RectF)object, (DynamicZoomViewModel$e)object2);
            Object object4 = 0;
            f10 = 0.0f;
            Runnable runnable = null;
            if (l12 != false) {
                object = this.G;
                if (object != null) {
                    object2 = this.y.a;
                    object.a((String)object2);
                }
                object = this.u;
                ((DynamicZoomViewModel$h)object).c = false;
                return object;
            }
            object2 = this.m((RectF)object);
            if (object2 != null) {
                object = object2;
            }
            float f11 = object.width();
            float f12 = object.height();
            f11 *= f12;
            object3 = 1065353216;
            f12 = 1.0f;
            float f13 = this.i;
            f13 = (f11 *= f12) - f13;
            float f14 = Math.abs(f13);
            float f15 = this.i;
            f14 /= f15;
            Object object5 = this.d.getValue();
            Object object6 = DynamicZoomViewModel$TargetModel.FAR;
            long l15 = 5000L;
            float f16 = 10.0f;
            int n11 = 1;
            float f17 = 0.0f;
            if (object5 == object6) {
                object5 = this.u;
                ((DynamicZoomViewModel$h)object5).a = object6;
                float f18 = f13 - 0.0f;
                Object object7 = f18 == 0.0f ? 0 : (f18 < 0.0f ? -1 : 1);
                if (object7 < 0) {
                    f15 = this.p;
                    float f19 = 2.5f * f14 + f12;
                    f15 *= f19;
                    f19 = this.o;
                    float f20 = f19 - (f15 = this.k(f15));
                    Object object8 = f20 == 0.0f ? 0 : (f20 < 0.0f ? -1 : 1);
                    if (object8 < 0) {
                        this.o = f15;
                    }
                } else {
                    float f21;
                    object5 = this.k;
                    if (object5 != null) {
                        f15 = object5.width();
                        object6 = this.k;
                        f21 = object6.height();
                        f15 *= f21;
                    } else {
                        object7 = false;
                        object5 = null;
                        f15 = 0.0f;
                    }
                    object7 = f11 == f15 ? 0 : (f11 > f15 ? 1 : -1);
                    if (object7 > 0) {
                        object7 = this.C + n11;
                        this.C = (int)object7;
                    } else {
                        this.C = 0;
                    }
                    object7 = this.C;
                    int n12 = 2;
                    f21 = 2.8E-45f;
                    if (object7 >= n12) {
                        f15 = this.p * f14;
                        f21 = this.o;
                        this.o = f15 = this.k(f21 -= (f15 /= f16));
                    }
                    object7 = this.C;
                    n12 = 5;
                    f21 = 7.0E-45f;
                    if (object7 >= n12) {
                        this.C = 0;
                        object5 = this.F;
                        if (object5 != null && (object7 = (Object)this.H) == false) {
                            object5 = this.F;
                            object6 = this.I;
                            object5.post((Runnable)object6);
                            object5 = this.F;
                            object6 = this.J;
                            object5.postDelayed((Runnable)object6, l15);
                        }
                    }
                }
            }
            if ((object5 = this.d.getValue()) == (object6 = DynamicZoomViewModel$TargetModel.NEAR)) {
                object5 = this.u;
                ((DynamicZoomViewModel$h)object5).a = object6;
                float f22 = f13 - 0.0f;
                Object object9 = f22 == 0.0f ? 0 : (f22 > 0.0f ? 1 : -1);
                if (object9 > 0) {
                    f11 = this.p;
                    f11 *= (f12 -= (f14 /= 5.0f));
                    float f23 = (f11 = this.j(f11)) - (f10 = this.o);
                    object4 = f23 == 0.0f ? 0 : (f23 < 0.0f ? -1 : 1);
                    if (object4 < 0) {
                        this.o = f11;
                    }
                } else {
                    RectF rectF = this.k;
                    if (rectF != null) {
                        f12 = rectF.width();
                        RectF rectF2 = this.k;
                        f13 = rectF2.height();
                        f17 = f12 * f13;
                    }
                    if ((l12 = (long)(f11 == f17 ? 0 : (f11 < f17 ? -1 : 1))) < 0) {
                        l12 = this.D + n11;
                        this.D = (int)l12;
                    } else {
                        this.D = 0;
                    }
                    f11 = this.p * f14 / f16;
                    f12 = this.o + f11;
                    this.o = f11 = this.j(f12);
                    l12 = this.D;
                    object3 = 3;
                    f12 = 4.2E-45f;
                    if (l12 >= object3) {
                        this.D = 0;
                        object2 = this.F;
                        if (object2 != null && (l12 = (long)this.H) == false) {
                            object2 = this.F;
                            runnable = this.I;
                            object2.post(runnable);
                            object2 = this.F;
                            runnable = this.J;
                            object2.postDelayed(runnable, l15);
                        }
                    }
                }
            }
            this.k = object;
            object = this.u;
            ((DynamicZoomViewModel$h)object).e = f11 = this.o;
            ((DynamicZoomViewModel$h)object).c = n11;
            return object;
        }
        return object2;
    }

    public boolean g(RectF rectF) {
        boolean bl2 = this.T(rectF);
        if (bl2) {
            boolean bl3 = this.K;
            if (!bl3) {
                this.K = bl3 = true;
                Handler handler = this.F;
                Runnable runnable = this.L;
                long l10 = 5000L;
                handler.postDelayed(runnable, l10);
            }
        } else {
            Handler handler = this.F;
            Runnable runnable = this.L;
            handler.removeCallbacks(runnable);
            boolean bl4 = false;
            handler = null;
            this.K = false;
        }
        return bl2;
    }

    public float j(float f10) {
        float f11;
        float f12;
        float f13 = this.s;
        float f14 = f10 - f13;
        Object object = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
        if (object >= 0 && (object = (f12 = f10 - (f11 = this.t)) == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1)) <= 0) {
            return f10;
        }
        f11 = this.t;
        float f15 = f10 - f11;
        Object object2 = f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1);
        if (object2 > 0) {
            return f11;
        }
        Object object3 = f10 == f13 ? 0 : (f10 < f13 ? -1 : 1);
        if (object3 < 0) {
            return f13;
        }
        return 1.0f;
    }

    public void l() {
        DynamicZoomViewModel$f dynamicZoomViewModel$f = this.G;
        if (dynamicZoomViewModel$f != null && (dynamicZoomViewModel$f = this.F) != null) {
            Runnable runnable = this.J;
            dynamicZoomViewModel$f.post(runnable);
        }
    }

    public void n() {
        d d10 = this.b;
        if (d10 != null) {
            d10.i0(false);
        }
        this.x = false;
    }

    public MutableLiveData o() {
        return this.d;
    }

    public void onCleared() {
        super.onCleared();
        Handler handler = this.F;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if ((handler = this.E) != null) {
            handler.quit();
        }
    }

    public void onPause() {
        Boolean bl2;
        Object object = this.F;
        if (object != null) {
            bl2 = null;
            object.removeCallbacksAndMessages(null);
        }
        object = this.h;
        bl2 = Boolean.FALSE;
        ((MutableLiveData)object).postValue(bl2);
        this.g.postValue(bl2);
        this.f.postValue(bl2);
    }

    public DynamicZoomViewModel$TargetModel p() {
        Object object = this.d.getValue();
        object = object == null ? DynamicZoomViewModel$TargetModel.FAR : (DynamicZoomViewModel$TargetModel)((Object)this.d.getValue());
        return object;
    }

    public RectF r() {
        return this.v;
    }

    public MutableLiveData s() {
        return this.w;
    }

    public MutableLiveData t() {
        return this.e;
    }

    public boolean u() {
        synchronized (this) {
            Object object = this.w;
            object = ((LiveData)object).getValue();
            object = (Boolean)object;
            boolean bl2 = (Boolean)object;
            return bl2;
        }
    }

    public void w(RectF object, float f10) {
        boolean bl2;
        if (object != null && !(bl2 = object.isEmpty())) {
            float f11;
            float f12 = object.width();
            float f13 = object.height();
            f12 *= f13;
            f13 = 1.0f;
            this.i = f12 *= f13;
            this.j = object;
            this.k = object;
            this.m = f11 = f12 / 20.0f;
            f11 = 100.0f;
            this.n = f12 *= f11;
            f12 = this.o;
            float f14 = f12 - f13;
            Object object2 = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
            if (object2 == false) {
                f12 = f10;
            }
            this.o = f12;
            this.J(f10);
            Object[] objectArray = this.u;
            objectArray.d = f12 = this.o;
            objectArray.e = f12;
            this.H(true);
            this.F();
            f10 = 0.0f;
            this.C = 0;
            this.M = false;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ZL initRecognitionArea: area");
            f13 = this.i;
            stringBuilder.append(f13);
            String string2 = "    ";
            stringBuilder.append(string2);
            object = object.toString();
            stringBuilder.append((String)object);
            stringBuilder.append("ZOOM_MAP_UNIT:");
            float f15 = this.m;
            stringBuilder.append(f15);
            stringBuilder.append("   CHANGE_RECT_THRESHOLD:");
            f15 = this.n;
            stringBuilder.append(f15);
            object = stringBuilder.toString();
            objectArray = new Object[]{};
            m.a.a.i((String)object, objectArray);
        }
    }

    public boolean x() {
        d d10 = this.b;
        if (d10 != null) {
            boolean bl2;
            this.x = bl2 = d10.M();
        }
        return this.x;
    }

    public void z() {
        Handler handler;
        boolean bl2 = this.M;
        if (!bl2 && (handler = this.F) != null) {
            this.M = bl2 = true;
            this.F.removeCallbacksAndMessages(null);
            handler = this.F;
            Runnable runnable = this.N;
            long l10 = 1500L;
            handler.postDelayed(runnable, l10);
        }
    }
}

