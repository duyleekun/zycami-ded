/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.graphics.Bitmap
 *  android.graphics.Matrix
 *  android.graphics.PointF
 *  android.graphics.Rect
 *  android.graphics.RectF
 */
package d.v.c.s0;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.core.util.Consumer;
import androidx.core.util.Pair;
import androidx.core.util.Supplier;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.zhishen.tracker.MovingTracker;
import com.zhishen.tracker.MovingTracker$TrackerType;
import d.v.c.s0.f6;
import d.v.c.s0.g6;
import d.v.c.s0.h6;
import d.v.c.s0.i6;
import d.v.c.s0.j6;
import d.v.c.s0.k6;
import d.v.c.s0.l6;
import d.v.c.s0.m6;
import d.v.c.s0.w6$a;
import d.v.c.s0.w6$b;
import d.v.d.i.f.h$a;
import d.v.e.h.d;
import d.v.e0.ce;
import d.v.e0.fe;
import e.a.h0;
import e.a.j;
import e.a.l;
import e.a.m;
import e.a.q0.c.a;
import e.a.s0.b;
import e.a.v0.g;
import e.a.v0.o;
import i.g.c;
import i.g.e;
import io.reactivex.BackpressureStrategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class w6
extends AndroidViewModel {
    public static final int o = 1;
    public static final int p = 2;
    public static final int q = 3;
    public static final int r = 1;
    public static final int s = 2;
    private static final float t = 0.1f;
    private static final float u = 10.0f;
    public final MutableLiveData a;
    public final MutableLiveData b;
    public final MutableLiveData c;
    private final RectF d;
    private final RectF e;
    private final RectF f;
    private final PointF g;
    private final List h;
    private boolean i;
    private MovingTracker j;
    private fe k;
    private b l;
    private boolean m;
    private long n;

    public w6(Application application) {
        super(application);
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        arrayList = new ArrayList();
        this.b = arrayList;
        arrayList = new ArrayList();
        this.c = arrayList;
        super();
        this.d = arrayList;
        super();
        this.e = arrayList;
        super();
        this.f = arrayList;
        super();
        this.g = arrayList;
        this.h = arrayList = new ArrayList();
        MovingTracker.initResource(application.getAssets());
    }

    public static /* synthetic */ RectF A(Pair pair) {
        pair = (RectF)pair.first;
        RectF rectF = new RectF((RectF)pair);
        return rectF;
    }

    private /* synthetic */ void F(e e10) {
        this.m = true;
    }

    private /* synthetic */ void H() {
        this.m = false;
        this.W();
        this.j.h();
    }

    private void J(RectF rectF) {
        float f10 = rectF.top;
        float f11 = this.d.height();
        float f12 = rectF.right;
        f11 -= f12;
        f12 = rectF.height() + f10;
        float f13 = rectF.width() + f11;
        rectF.set(f10, f11, f12, f13);
    }

    private void K(Pair pair, Supplier object, Supplier supplier) {
        pair = (PointF)pair.second;
        if (pair == null) {
            return;
        }
        boolean bl2 = (Boolean)(object = (Boolean)object.get());
        if (bl2) {
            pair.negate();
        }
        if (bl2 = ((Boolean)(object = (Boolean)supplier.get())).booleanValue()) {
            float f10 = ((PointF)pair).y;
            float f11 = -1.0f;
            ((PointF)pair).y = f10 *= f11;
        }
    }

    private static RectF L(RectF rectF, float f10) {
        float f11;
        RectF rectF2 = new RectF(rectF);
        rectF2.left = f11 = rectF2.left * f10;
        rectF2.top = f11 = rectF2.top * f10;
        rectF2.right = f11 = rectF2.right * f10;
        rectF2.bottom = f11 = rectF2.bottom * f10;
        return rectF2;
    }

    private void P(PointF pointF) {
        if (pointF != null) {
            PointF pointF2 = this.g;
            pointF2.set(pointF);
        }
    }

    private void R(Supplier supplier) {
        fe fe2;
        this.k = fe2 = new fe();
        w6$b w6$b = new w6$b(this, supplier);
        fe2.M(w6$b);
    }

    private j U(RectF object, Supplier object2, Supplier supplier, Supplier supplier2) {
        boolean bl2;
        Object object3 = this.j;
        if (object3 == null) {
            MovingTracker$TrackerType movingTracker$TrackerType = MovingTracker$TrackerType.kcf;
            object3 = new MovingTracker(movingTracker$TrackerType);
            this.j = object3;
        }
        if (bl2 = this.n()) {
            this.Y();
        }
        this.f.setEmpty();
        this.n = 0L;
        object3 = new j6(this, (RectF)object, (Supplier)object2);
        object = BackpressureStrategy.LATEST;
        object = e.a.j.D1((m)object3, (BackpressureStrategy)((Object)object));
        object2 = d.v.c.x1.j.c();
        object = ((j)object).n6((h0)object2);
        object2 = new i6(this);
        object = ((j)object).Y0((o)object2);
        object2 = new f6(this, supplier, supplier2);
        object = ((j)object).k2((g)object2);
        object2 = new k6(this);
        object = ((j)object).k2((g)object2);
        object2 = g6.a;
        object = ((j)object).R3((o)object2);
        object2 = new m6(this);
        object = ((j)object).m2((g)object2);
        object2 = new h6(this);
        return ((j)object).c2((e.a.v0.a)object2);
    }

    private void W() {
        fe fe2 = this.k;
        if (fe2 != null) {
            fe2.K();
            fe2 = null;
            this.k = null;
        }
    }

    private void a0(Supplier supplier) {
        boolean bl2 = ce.A1();
        if (bl2) {
            fe fe2 = this.k;
            if (fe2 == null) {
                this.R(supplier);
            }
        } else {
            this.W();
        }
    }

    public static /* synthetic */ RectF b(RectF rectF, float f10) {
        return w6.L(rectF, f10);
    }

    public static /* synthetic */ void c(w6 w62, Supplier supplier) {
        w62.a0(supplier);
    }

    public static /* synthetic */ PointF d(w6 w62) {
        return w62.g;
    }

    private boolean f(RectF rectF) {
        long l10 = System.currentTimeMillis();
        RectF rectF2 = this.f;
        boolean bl2 = rectF2.equals((Object)rectF);
        boolean bl3 = false;
        if (!bl2) {
            this.f.set(rectF);
            this.n = l10;
            return false;
        }
        l10 = System.currentTimeMillis();
        long l11 = this.n;
        long l12 = (l10 -= l11) - (l11 = 3000L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            bl3 = true;
        }
        return bl3;
    }

    private boolean g(RectF rectF, RectF rectF2, boolean n10) {
        float f10;
        float f11;
        int n11;
        float f12;
        float f13;
        float f14 = n10 != 0 ? rectF.height() : rectF.width();
        float f15 = n10 != 0 ? rectF.width() : rectF.height();
        float f16 = rectF2.width();
        float f17 = 6.0f;
        n10 = f16 == f17 ? 0 : (f16 < f17 ? -1 : 1);
        if (n10 >= 0 && (n10 = (int)((f13 = (f16 = rectF2.height()) - f17) == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1))) >= 0 && (n10 = (int)((f12 = (f16 = rectF2.width()) - f14) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1))) <= 0 && (n11 = (f11 = (f10 = rectF2.height()) - f15) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) <= 0) {
            n11 = 0;
            f15 = 0.0f;
            rectF = null;
        } else {
            n11 = 1;
            f15 = Float.MIN_VALUE;
        }
        return n11 != 0;
    }

    public static double i(PointF pointF, PointF pointF2) {
        float f10 = pointF.x;
        float f11 = pointF2.x;
        float f12 = f10 - f11;
        float f13 = pointF.y;
        float f14 = pointF2.y;
        f10 = f13 - f14;
        return Math.sqrt(Math.abs((f12 *= (f10 -= f11)) + (f10 *= (f13 -= f14))));
    }

    private RectF k(RectF rectF) {
        RectF rectF2;
        boolean bl2 = this.i;
        if (bl2) {
            rectF2 = this.d;
            float f10 = rectF2.height();
            float f11 = rectF.bottom;
            f10 -= f11;
            f11 = rectF.left;
            float f12 = rectF.height() + f10;
            float f13 = rectF.width() + f11;
            rectF.set(f10, f11, f12, f13);
        }
        rectF2 = new RectF(rectF);
        return d.v.e0.oe.m.b(rectF2, 0.1f);
    }

    private /* synthetic */ int p(Matrix matrix, PointF pointF, h$a h$a, h$a h$a2) {
        float f10;
        h$a = h$a.b();
        RectF rectF = new RectF((Rect)h$a);
        h$a2 = h$a2.b();
        h$a = new RectF((Rect)h$a2);
        int n10 = this.i;
        if (n10 == 0) {
            n10 = 1119092736;
            f10 = 90.0f;
            float f11 = rectF.centerX();
            float f12 = rectF.centerY();
            matrix.setRotate(f10, f11, f12);
        }
        matrix.mapRect(rectF);
        matrix.mapRect((RectF)h$a);
        f10 = rectF.centerX();
        float f13 = rectF.centerY();
        matrix = new PointF(f10, f13);
        double d10 = Math.abs(w6.i((PointF)matrix, pointF));
        f10 = h$a.centerX();
        float f14 = h$a.centerY();
        matrix = new PointF(f10, f14);
        double d11 = Math.abs(w6.i((PointF)matrix, pointF));
        double d12 = d10 == d11 ? 0 : (d10 > d11 ? 1 : -1);
        d12 = d12 > 0 ? 1.0 : (double)-1;
        return (int)d12;
    }

    private /* synthetic */ void s(RectF rectF, Supplier supplier, l l10) {
        boolean bl2;
        MovingTracker movingTracker = this.j;
        movingTracker.g(rectF);
        while (!(bl2 = l10.isCancelled())) {
            rectF = (Bitmap)supplier.get();
            if (rectF == null) continue;
            l10.onNext(rectF);
        }
        l10.onComplete();
    }

    private /* synthetic */ c u(Bitmap object) {
        this.j.e((Bitmap)object);
        object = this.j.a();
        PointF pointF = this.j.c();
        boolean bl2 = this.f((RectF)object);
        if (bl2) {
            object = new IllegalStateException("Tracking target lost.");
            return e.a.j.s2((Throwable)object);
        }
        return e.a.j.C3(Pair.create(object, pointF));
    }

    private /* synthetic */ void w(Supplier supplier, Supplier supplier2, Pair pair) {
        this.K(pair, supplier, supplier2);
    }

    private /* synthetic */ void y(Pair pair) {
        pair = (PointF)pair.second;
        this.P((PointF)pair);
    }

    public /* synthetic */ void G(e e10) {
        this.F(e10);
    }

    public /* synthetic */ void I() {
        this.H();
    }

    public void M(RectF rectF, RectF rectF2) {
        this.d.set(rectF);
        this.e.set(rectF2);
    }

    public void N(int n10) {
        int n11;
        n10 = n10 != 0 && n10 != (n11 = 2) ? 0 : 1;
        this.i = n10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public RectF Q(int n10, RectF object, RectF object2) {
        Object object3 = this.d;
        object3.set((RectF)object);
        this.N(n10);
        Object object4 = this.h;
        n10 = (int)(object4.isEmpty() ? 1 : 0);
        if (n10 != 0) {
            return null;
        }
        synchronized (this) {
            float f10;
            object4 = new Matrix();
            float f11 = object2.centerX();
            float f12 = object2.centerY();
            object = new PointF(f11, f12);
            object2 = this.h;
            object3 = new l6(this, (Matrix)object4, (PointF)object);
            object = Collections.min(object2, object3);
            object = (h$a)object;
            object = ((h$a)object).b();
            object2 = new RectF((Rect)object);
            int n11 = this.i;
            if (n11 == 0) {
                n11 = 1119092736;
                f10 = 90.0f;
                f11 = object2.centerX();
                float f13 = object2.centerY();
                object4.setRotate(f10, f11, f13);
                object4.mapRect(object2);
            }
            object4 = this.c;
            ((MutableLiveData)object4).setValue(object2);
            object4 = this.b;
            n11 = 1;
            f10 = Float.MIN_VALUE;
            object = n11;
            ((MutableLiveData)object4).setValue(object);
            object4 = new RectF(object2);
            return this.k((RectF)object4);
        }
    }

    public void S(RectF rectF, Supplier supplier, Supplier supplier2, Supplier supplier3, Supplier supplier4, Consumer consumer) {
        MutableLiveData mutableLiveData = this.a;
        Integer n10 = 1;
        mutableLiveData.setValue(n10);
        this.T(rectF, supplier, supplier2, supplier3, supplier4, consumer);
    }

    public void T(RectF object, Supplier object2, Supplier supplier, Supplier supplier2, Supplier supplier3, Consumer consumer) {
        object = this.U((RectF)object, (Supplier)object2, supplier2, supplier3);
        object2 = e.a.q0.c.a.c();
        object = ((j)object).s4((h0)object2);
        object2 = new w6$a(this, consumer, supplier);
        this.l = object = (b)((Object)((j)object).j((i.g.d)object2));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void V() {
        Object object = this.b;
        int n10 = 2;
        Integer n11 = n10;
        ((MutableLiveData)object).setValue(n11);
        synchronized (this) {
            object = this.h;
            object.clear();
            return;
        }
    }

    public void X() {
        MutableLiveData mutableLiveData = this.a;
        Integer n10 = 2;
        mutableLiveData.postValue(n10);
    }

    public void Y() {
        b b10 = this.l;
        if (b10 != null) {
            b10.dispose();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public RectF Z(int n10, RectF rectF, RectF rectF2, boolean bl2) {
        RectF rectF3;
        this.M(rectF, rectF2);
        this.N(n10);
        if (bl2) {
            synchronized (this) {
                boolean bl3;
                rectF3 = new RectF();
                rectF = new RectF();
                rectF2 = new Matrix();
                Object object = this.h;
                object = object.iterator();
                while (bl3 = object.hasNext()) {
                    Object object2 = object.next();
                    object2 = (h$a)object2;
                    object2 = ((h$a)object2).b();
                    rectF3.set((Rect)object2);
                    rectF.set(rectF3);
                    float f10 = rectF.centerX();
                    float f11 = rectF.centerY();
                    float f12 = 1.15f;
                    rectF2.setScale(f12, f12, f10, f11);
                    rectF2.mapRect(rectF);
                    object2 = this.e;
                    bl3 = rectF.contains((RectF)object2);
                    if (!bl3) continue;
                    rectF2.reset();
                    bl2 = this.i;
                    if (!bl2) {
                        bl2 = 1119092736;
                        float f13 = 90.0f;
                        f10 = rectF.centerX();
                        float f14 = rectF.centerY();
                        rectF2.setRotate(f13, f10, f14);
                    }
                    rectF2.mapRect(rectF3);
                    rectF = this.e;
                    rectF.set(rectF3);
                    break;
                }
            }
        }
        rectF3 = this.e;
        return this.k(rectF3);
    }

    public boolean b0(RectF rectF) {
        float f10 = 10.0f;
        d.v.e0.oe.m.b(rectF, f10);
        RectF rectF2 = this.d;
        boolean bl2 = this.i;
        boolean bl3 = this.g(rectF2, rectF, bl2);
        if (!bl3) {
            bl3 = this.i;
            if (bl3) {
                this.J(rectF);
            }
            this.c.setValue(rectF);
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void e(List list) {
        if (list == null) {
            return;
        }
        synchronized (this) {
            List list2 = this.h;
            list2.clear();
            list2 = this.h;
            list2.addAll(list);
            return;
        }
    }

    public MutableLiveData j() {
        return this.c;
    }

    public float l() {
        return 0.1f;
    }

    public boolean m() {
        int n10;
        Integer n11 = (Integer)this.b.getValue();
        int n12 = d.v.e.h.d.c(n11);
        if (n12 != (n10 = 1)) {
            n10 = 0;
        }
        return n10 != 0;
    }

    public boolean n() {
        int n10;
        int n11;
        Integer n12 = (Integer)this.a.getValue();
        if (n12 != null && (n11 = n12.intValue()) != (n10 = 2)) {
            n11 = 1;
        } else {
            n11 = 0;
            n12 = null;
        }
        return n11 != 0;
    }

    public boolean o() {
        return this.m;
    }

    public /* synthetic */ int r(Matrix matrix, PointF pointF, h$a h$a, h$a h$a2) {
        return this.p(matrix, pointF, h$a, h$a2);
    }

    public /* synthetic */ void t(RectF rectF, Supplier supplier, l l10) {
        this.s(rectF, supplier, l10);
    }

    public /* synthetic */ c v(Bitmap bitmap) {
        return this.u(bitmap);
    }

    public /* synthetic */ void x(Supplier supplier, Supplier supplier2, Pair pair) {
        this.w(supplier, supplier2, pair);
    }

    public /* synthetic */ void z(Pair pair) {
        this.y(pair);
    }
}

