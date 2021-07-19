/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.util.Size
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.GestureDetector$SimpleOnGestureListener
 *  android.view.LayoutInflater
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 */
package d.v.c.s0.e7;

import android.content.Context;
import android.content.res.Resources;
import android.util.Size;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.camera.liveassistant.FloatWindowPermissionHelper;
import com.zhiyun.common.util.Windows;
import d.v.c.s0.e7.c;
import d.v.c.s0.e7.d;
import d.v.c.s0.e7.e;
import d.v.c.s0.e7.f;
import d.v.c.s0.e7.g;
import d.v.c.s0.e7.h;
import d.v.c.s0.e7.o;
import d.v.c.s0.e7.o$a;
import d.v.c.s0.e7.q$b;
import d.v.c.w0.id;
import d.v.e.b;
import d.v.e.l.h2;

public class q
extends o {
    private static final float A = 15.5f;
    private static final float B = 18.5f;
    private static final int C = 3000;
    private static final float D = 0.4f;
    private static final int t = 32;
    private static final int u = 64;
    private static final int v = 36;
    private static final int w = 5;
    private static final int x = 91;
    private static final int y = 77;
    private static final float z = 12.5f;
    private id j;
    private o k;
    private o l;
    private o m;
    private o n;
    public boolean o = true;
    private final Runnable p;
    private final Runnable q;
    private q$b r;
    public GestureDetector.SimpleOnGestureListener s;

    public q(Context context) {
        super(context);
        Object object = new f(this);
        this.p = object;
        super(this);
        this.q = object;
        super(this);
        this.s = object;
        this.q(context);
        this.p(context);
    }

    private /* synthetic */ void B(View view) {
        this.n.b();
    }

    private /* synthetic */ void D() {
        this.j.getRoot().setAlpha(0.4f);
    }

    private void F() {
        Runnable runnable;
        Object object = (ImageView)this.k.c.findViewById(2131362656);
        boolean bl2 = this.o;
        if (bl2) {
            runnable = null;
            this.o = false;
            int n10 = 2131231161;
            object.setImageResource(n10);
        } else {
            this.o = true;
            int n11 = 2131231160;
            object.setImageResource(n11);
        }
        object = this.c;
        runnable = this.q;
        object.removeCallbacks(runnable);
        object = this.c;
        runnable = this.q;
        long l10 = 3000L;
        object.postDelayed(runnable, l10);
        object = this.r;
        if (object != null) {
            boolean bl3 = this.o;
            object.a(bl3);
        }
    }

    private void H(boolean bl2) {
        int n10;
        int n11;
        float f10;
        int n12;
        float f11;
        int n13;
        ImageView imageView;
        if (bl2) {
            imageView = this.j.a;
            n13 = 2131231155;
            f11 = 1.8078383E38f;
            imageView.setBackgroundResource(n13);
        } else {
            imageView = this.j.a;
            n13 = 2131231156;
            f11 = 1.8078385E38f;
            imageView.setBackgroundResource(n13);
        }
        ViewGroup.LayoutParams layoutParams = this.j.a.getLayoutParams();
        imageView = new FrameLayout.LayoutParams(layoutParams);
        n13 = 1119223808;
        f11 = 91.0f;
        imageView.width = n12 = h2.b(f11);
        imageView.height = n12 = h2.b(77.0f);
        n12 = 0;
        imageView.leftMargin = 0;
        imageView.rightMargin = 0;
        ImageView imageView2 = this.j.a;
        imageView2.setLayoutParams((ViewGroup.LayoutParams)imageView);
        imageView = this.a;
        boolean bl3 = h2.c((Context)imageView);
        if (!bl3) {
            imageView = this.a.getResources();
            n12 = Windows.m((Resources)imageView);
        }
        this.j.b.setImageResource(2131231737);
        imageView2 = this.j.b.getLayoutParams();
        imageView = new FrameLayout.LayoutParams((ViewGroup.LayoutParams)imageView2);
        float f12 = 15.5f;
        if (bl2) {
            int n14;
            int n15;
            Size size = Windows.o(this.a);
            int n16 = size.getWidth();
            n13 = h2.b(f11);
            int n17 = n16 - n13;
            layoutParams = this.d;
            int n18 = n17 + n12;
            n12 = h2.b(f12);
            layoutParams.x = n15 = n18 + n12;
            f10 = 20.5f;
            imageView.leftMargin = n14 = h2.b(f10);
        } else {
            int n19;
            WindowManager.LayoutParams layoutParams2 = this.d;
            n13 = h2.b(f12);
            layoutParams2.x = n12 -= n13;
            f10 = 34.5f;
            imageView.leftMargin = n19 = h2.b(f10);
        }
        imageView.topMargin = n11 = h2.b(17.5f);
        f10 = 36.0f;
        imageView.width = n13 = h2.b(f10);
        imageView.height = n10 = h2.b(f10);
        this.j.b.setLayoutParams((ViewGroup.LayoutParams)imageView);
    }

    private void M() {
        this.c.setAlpha(1.0f);
        View view = this.c;
        Runnable runnable = this.p;
        view.removeCallbacks(runnable);
        view = this.c;
        runnable = this.p;
        view.postDelayed(runnable, 3000L);
    }

    public static /* synthetic */ o i(q q10) {
        return q10.m;
    }

    public static /* synthetic */ void j(q q10) {
        q10.n();
    }

    public static /* synthetic */ void k(q q10) {
        q10.M();
    }

    public static /* synthetic */ id l(q q10) {
        return q10.j;
    }

    private void n() {
        Object object = this.c;
        float f10 = 0.4f;
        object.setAlpha(f10);
        object = this.c;
        Runnable runnable = this.q;
        object.removeCallbacks(runnable);
        this.m.b();
        object = this.k;
        boolean bl2 = ((o)object).e();
        if (bl2) {
            object = this.k;
            ((o)object).b();
        }
        if (bl2 = ((o)(object = this.l)).e()) {
            object = this.l;
            ((o)object).b();
        }
        this.o();
    }

    private void o() {
        boolean bl2 = this.r();
        this.H(bl2);
        WindowManager windowManager = this.b;
        View view = this.c;
        WindowManager.LayoutParams layoutParams = this.d;
        windowManager.updateViewLayout(view, (ViewGroup.LayoutParams)layoutParams);
        windowManager = this.g;
        view = this.d;
        int n10 = view.x;
        int n11 = view.y;
        windowManager.set(n10, n11);
    }

    private void p(Context context) {
        Object object = this.s;
        Object object2 = new GestureDetector(context, (GestureDetector.OnGestureListener)object);
        context = this.c;
        object = new e(this, (GestureDetector)object2);
        context.setOnTouchListener((View.OnTouchListener)object);
        context = this.k.c;
        object2 = new h(this);
        context.setOnClickListener((View.OnClickListener)object2);
        context = this.l.c;
        object2 = new g(this);
        context.setOnClickListener((View.OnClickListener)object2);
        context = this.m.c;
        object2 = new d(this);
        context.setOnClickListener((View.OnClickListener)object2);
        context = this.n.c.findViewById(2131363519);
        object2 = new c(this);
        context.setOnClickListener((View.OnClickListener)object2);
    }

    private void q(Context object) {
        int n10;
        Object object2 = (id)DataBindingUtil.inflate(LayoutInflater.from((Context)object), 2131558669, null, false);
        this.j = object2;
        object2 = ((ViewDataBinding)object2).getRoot();
        this.d((View)object2);
        this.e = false;
        this.f = n10 = 0x800033;
        Object object3 = Windows.o(object);
        int n11 = object3.getWidth();
        int n12 = this.c.getWidth();
        n11 -= n12;
        int n13 = object3.getHeight() / 2;
        n12 = this.c.getWidth() / 2;
        this.g.set(n11, n13 -= n12);
        Object object4 = new o$a((Context)object);
        this.k = object4 = ((o$a)object4).d(2131558666).c(n10).e(n11, n13).a();
        object4 = new o$a((Context)object);
        object3 = ((o$a)object4).d(2131558664).c(n10).e(n11, n13).a();
        this.l = object3;
        object3 = new o$a((Context)object);
        this.m = object2 = ((o$a)object3).d(2131558665).c(n10).b(true).a();
        object2 = new o$a((Context)object);
        object = ((o$a)object2).d(2131558667).a();
        this.n = object;
    }

    private boolean r() {
        WindowManager.LayoutParams layoutParams = this.d;
        boolean bl2 = true;
        if (layoutParams == null) {
            return bl2;
        }
        int n10 = layoutParams.x;
        Size size = Windows.o(this.a);
        int n11 = size.getWidth() / 2;
        View view = this.c;
        int n12 = view.getWidth() / 2;
        if (n10 <= (n11 -= n12)) {
            bl2 = false;
        }
        return bl2;
    }

    public static /* synthetic */ void s(q q10) {
        q10.n();
    }

    private /* synthetic */ boolean t(GestureDetector gestureDetector, View view, MotionEvent motionEvent) {
        int n10;
        int n11 = motionEvent.getAction();
        if (n11 == (n10 = 1)) {
            this.o();
        }
        return gestureDetector.onTouchEvent(motionEvent);
    }

    private /* synthetic */ void v(View view) {
        this.F();
    }

    private /* synthetic */ void x(View view) {
        this.m();
    }

    private /* synthetic */ void z(View view) {
        this.n();
    }

    public /* synthetic */ void A(View view) {
        this.z(view);
    }

    public /* synthetic */ void C(View view) {
        this.B(view);
    }

    public /* synthetic */ void E() {
        this.D();
    }

    public void G() {
        WindowManager.LayoutParams layoutParams = this.d;
        if (layoutParams == null) {
            return;
        }
        layoutParams = this.a;
        int n10 = h2.c((Context)layoutParams);
        int n11 = 0;
        View view = null;
        if (n10 != 0) {
            layoutParams = this.a.getResources();
            n10 = Windows.m((Resources)layoutParams);
        } else {
            n10 = 0;
            layoutParams = null;
        }
        WindowManager.LayoutParams layoutParams2 = this.d;
        int n12 = layoutParams2.x;
        if (n12 > n10) {
            n11 = 1;
        }
        this.H(n11 != 0);
        layoutParams = this.d;
        n11 = Windows.o(this.a).getHeight() / 2;
        n12 = this.c.getWidth() / 2;
        layoutParams.y = n11 -= n12;
        layoutParams = this.b;
        view = this.c;
        layoutParams2 = this.d;
        layoutParams.updateViewLayout(view, (ViewGroup.LayoutParams)layoutParams2);
        layoutParams = this.g;
        view = this.d;
        n12 = view.x;
        n11 = view.y;
        layoutParams.set(n12, n11);
    }

    /*
     * WARNING - void declaration
     */
    public void I(boolean bl2) {
        void var1_4;
        this.o = bl2;
        View view = this.k.c;
        int n10 = 2131362656;
        view = (ImageView)view.findViewById(n10);
        if (bl2) {
            int n11 = 2131231160;
        } else {
            int n12 = 2131231161;
        }
        view.setImageResource((int)var1_4);
    }

    public void J(q$b q$b) {
        this.r = q$b;
    }

    public void K() {
        WindowManager.LayoutParams layoutParams;
        int n10;
        int n11;
        float f10;
        int n12 = this.r();
        ViewGroup.LayoutParams layoutParams2 = this.j.b.getLayoutParams();
        Object object = new FrameLayout.LayoutParams(layoutParams2);
        if (n12 == 0) {
            f10 = 15.5f;
            object.leftMargin = n11 = h2.b(f10);
        }
        n11 = 1117388800;
        f10 = 77.0f;
        object.width = n10 = h2.b(f10);
        object.height = n10 = h2.b(f10);
        ImageView imageView = this.j.b;
        imageView.setLayoutParams((ViewGroup.LayoutParams)object);
        this.j.b.setImageResource(2131231738);
        this.j.a.setBackgroundResource(2131099771);
        object = this.d;
        int n13 = object.y;
        n10 = h2.b(6.5f);
        n13 += n10;
        n10 = 1101004800;
        float f11 = 20.0f;
        float f12 = 32.0f;
        if (n12 != 0) {
            layoutParams = this.d;
            n12 = layoutParams.x;
            n11 = h2.b(f11);
            n12 -= n11;
            n11 = h2.b(f12);
            n12 -= n11;
            layoutParams2 = this.d;
            n11 = layoutParams2.x;
            f11 = 40.0f;
            n10 = h2.b(f11);
            n11 -= n10;
            n10 = h2.b(f12);
            n11 -= n10;
            n10 = h2.b(f12);
            n11 -= n10;
        } else {
            layoutParams = this.d;
            n12 = layoutParams.x;
            int n14 = h2.b(f10);
            n12 += n14;
            WindowManager.LayoutParams layoutParams3 = this.d;
            n14 = layoutParams3.x;
            n11 = h2.b(f10);
            n14 += n11;
            n11 = h2.b(f12);
            n14 += n11;
            n11 = h2.b(f11) + n14;
        }
        this.k.h(n12, n13);
        this.l.h(n11, n13);
        this.c.setAlpha(1.0f);
        layoutParams = this.c;
        object = this.p;
        layoutParams.removeCallbacks((Runnable)object);
        layoutParams = this.c;
        object = this.q;
        layoutParams.removeCallbacks((Runnable)object);
        layoutParams = this.c;
        object = this.q;
        layoutParams.postDelayed((Runnable)object, 3000L);
    }

    public void L(int n10, int n11) {
        this.g.set(n10, n11);
        this.m.g();
        this.g();
        this.K();
    }

    public void f() {
        View view = this.c;
        Runnable runnable = this.p;
        view.removeCallbacks(runnable);
        view = this.c;
        runnable = this.q;
        view.removeCallbacks(runnable);
        super.f();
        this.m.f();
        this.k.f();
        this.l.f();
        this.n.f();
    }

    public void g() {
        super.g();
        this.o();
        this.M();
    }

    public void m() {
        Object object = this.a;
        boolean bl2 = FloatWindowPermissionHelper.canBackgroundStartForXiaoMi((Context)object);
        if (!bl2) {
            this.n.g();
            return;
        }
        this.n();
        object = d.v.e.b.i();
        Context context = this.a;
        ((b)object).l(context);
    }

    public /* synthetic */ boolean u(GestureDetector gestureDetector, View view, MotionEvent motionEvent) {
        return this.t(gestureDetector, view, motionEvent);
    }

    public /* synthetic */ void w(View view) {
        this.v(view);
    }

    public /* synthetic */ void y(View view) {
        this.x(view);
    }
}

