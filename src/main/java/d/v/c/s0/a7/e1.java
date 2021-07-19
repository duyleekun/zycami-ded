/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnScrollChangeListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.HorizontalScrollView
 *  android.widget.LinearLayout
 */
package d.v.c.s0.a7;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.core.util.Pair;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.zhiyun.cama.camera.StackLiveData;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.cama.camera.ble.BleViewModel$JoystickEvent;
import com.zhiyun.cama.camera.data.CameraSet$Mode;
import com.zhiyun.cama.camera.widget.WheelPicker;
import com.zhiyun.cama.camera.widget.WheelPicker$b;
import com.zhiyun.common.util.Windows;
import com.zhiyun.image.Images;
import com.zhiyun.protocol.constants.WorkingMode;
import com.zhiyun.zyplayer.ExoVideoView;
import d.q.a.d;
import d.v.c.s0.a7.e1$a;
import d.v.c.s0.a7.e1$b;
import d.v.c.s0.a7.e1$c;
import d.v.c.s0.a7.e1$d;
import d.v.c.s0.a7.n;
import d.v.c.s0.a7.o;
import d.v.c.s0.a7.p;
import d.v.c.s0.a7.q;
import d.v.c.s0.a7.r;
import d.v.c.s0.a7.s;
import d.v.c.s0.a7.s0;
import d.v.c.s0.a7.t;
import d.v.c.s0.a7.u;
import d.v.c.s0.a7.u0;
import d.v.c.s0.a7.v;
import d.v.c.s0.a7.w;
import d.v.c.s0.a7.x;
import d.v.c.s0.a7.y;
import d.v.c.s0.a7.z;
import d.v.c.s0.q6;
import d.v.c.s0.t6;
import d.v.c.s0.u6;
import d.v.c.w0.h1;
import d.v.e.i.f;
import d.v.e.i.f$a;
import d.v.e.l.a2;
import d.v.e.l.a2$a;
import d.v.e.l.h2;
import d.v.e.l.s1;
import d.v.f.i.g;
import d.v.i0.b;
import d.v.j0.d$d;
import e.a.h0;
import e.a.q0.c.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class e1
extends u0 {
    private h1 h;
    private u6 i;
    private BleViewModel j;
    private int k;
    private int l = 2;
    private boolean m = false;
    private Runnable n;
    private int o;

    public e1() {
        e1$a e1$a = new e1$a(this);
        this.n = e1$a;
    }

    public static /* synthetic */ int B(e1 e12) {
        return e12.k;
    }

    public static /* synthetic */ h1 C(e1 e12) {
        return e12.h;
    }

    public static /* synthetic */ View D(e1 e12, ViewGroup viewGroup, int n10) {
        return e12.J(viewGroup, n10);
    }

    public static /* synthetic */ void E(e1 e12, HorizontalScrollView horizontalScrollView, View view) {
        e12.v0(horizontalScrollView, view);
    }

    public static /* synthetic */ int F(e1 e12) {
        return e12.l;
    }

    public static /* synthetic */ int G(e1 e12, int n10) {
        e12.l = n10;
        return n10;
    }

    public static /* synthetic */ void H(e1 e12, float f10) {
        e12.u0(f10);
    }

    private void I() {
        this.m = true;
        HorizontalScrollView horizontalScrollView = this.h.f;
        w w10 = new w(this);
        horizontalScrollView.post((Runnable)w10);
    }

    private View J(ViewGroup viewGroup, int n10) {
        View view;
        block2: {
            int n11 = viewGroup.getChildCount();
            for (int i10 = 0; i10 < n11; ++i10) {
                view = viewGroup.getChildAt(i10);
                boolean bl2 = this.S(view, n10);
                if (!bl2) {
                    continue;
                }
                break block2;
            }
            view = null;
        }
        return view;
    }

    private void K() {
        int n10 = this.l;
        int n11 = 1;
        int n12 = 2;
        if (n10 == n12) {
            WheelPicker wheelPicker = this.h.j;
            this.M(wheelPicker, n11);
        } else {
            n12 = 3;
            if (n10 == n12) {
                WheelPicker wheelPicker = this.h.i;
                this.M(wheelPicker, n11);
            }
        }
    }

    private void L() {
        int n10 = this.l;
        int n11 = n10 + -1;
        int n12 = 1;
        if (n11 < n12) {
            return;
        }
        LinearLayout linearLayout = this.h.e;
        View view = linearLayout.getChildAt(n10 -= n12);
        linearLayout = this.h.f;
        this.v0((HorizontalScrollView)linearLayout, view);
    }

    private void M(WheelPicker wheelPicker, int n10) {
        int n11 = wheelPicker.getCurrentPosition();
        int n12 = wheelPicker.getDataListSize() + -1;
        if ((n11 += n10) >= 0 && n11 <= n12) {
            wheelPicker.setCurrentPosition(n11);
        }
    }

    private void N() {
        int n10 = this.l;
        int n11 = n10 + 1;
        int n12 = 3;
        if (n11 > n12) {
            return;
        }
        LinearLayout linearLayout = this.h.e;
        View view = linearLayout.getChildAt(++n10);
        linearLayout = this.h.f;
        this.v0((HorizontalScrollView)linearLayout, view);
    }

    private void O() {
        int n10 = this.l;
        int n11 = -1;
        int n12 = 2;
        if (n10 == n12) {
            WheelPicker wheelPicker = this.h.j;
            this.M(wheelPicker, n11);
        } else {
            n12 = 3;
            if (n10 == n12) {
                WheelPicker wheelPicker = this.h.i;
                this.M(wheelPicker, n11);
            }
        }
    }

    private void P() {
        Object object = t6.q(this.requireContext());
        Object object2 = p.a;
        object = ((e.a.q)object).D0((e.a.v0.o)object2);
        object2 = a.c();
        object = ((e.a.q)object).W0((h0)object2);
        object2 = d.a(d.q.a.f0.f.b.h(this));
        object = (d.q.a.x)((e.a.q)object).n((e.a.r)object2);
        object2 = new x(this);
        s0 s02 = s0.a;
        object.c((e.a.v0.g)object2, s02);
    }

    private void Q() {
        Object object = this.j.b;
        Object object2 = this.getViewLifecycleOwner();
        Observer observer = new v(this);
        object.observe((LifecycleOwner)object2, observer);
        object = this.j.p;
        object2 = this.getViewLifecycleOwner();
        observer = new n(this);
        object.observe((LifecycleOwner)object2, observer);
        object = this.j.k;
        object2 = this.getViewLifecycleOwner();
        f$a f$a = new t(this);
        observer = new f(f$a);
        ((StackLiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.j.m;
        object2 = this.getViewLifecycleOwner();
        f$a = q.a;
        observer = new f(f$a);
        ((StackLiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.h.f;
        object2 = new y(this);
        object.setOnScrollChangeListener((View.OnScrollChangeListener)object2);
        object = this.h.j;
        object2 = new s(this);
        object.postDelayed((Runnable)object2, 500L);
    }

    private void R() {
        Object object;
        Object object2;
        int n10;
        int n11;
        int n12;
        this.o = n12 = Windows.l(this.requireContext()).getHeight();
        Object object3 = this.h.e.getLayoutParams();
        ((ViewGroup.LayoutParams)object3).height = n11 = this.o;
        this.h.e.setLayoutParams((ViewGroup.LayoutParams)object3);
        object3 = this.h.c.getLayoutParams();
        ((ViewGroup.LayoutParams)object3).width = n11 = this.o;
        ((ViewGroup.LayoutParams)object3).height = n11;
        this.h.c.setLayoutParams((ViewGroup.LayoutParams)object3);
        this.P();
        object3 = new ArrayList();
        Iterator iterator2 = this.i.Y.iterator();
        while ((n10 = iterator2.hasNext()) != 0) {
            object2 = (CameraSet$Mode)((Object)iterator2.next());
            object = this.getResources();
            n10 = object2.getStringRes();
            object2 = g.o(object, n10);
            object3.add(object2);
        }
        this.h.j.setDataList((List)object3);
        object3 = this.h.j;
        iterator2 = this.i;
        object2 = ((u6)iterator2).Y;
        iterator2 = ((u6)((Object)iterator2)).I();
        n11 = object2.indexOf(iterator2);
        n10 = 0;
        object2 = null;
        ((WheelPicker)((Object)object3)).x(n11, false);
        object3 = new ArrayList();
        iterator2 = this.j.A().iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            object2 = (WorkingMode)((Object)iterator2.next());
            int n13 = q6.f((WorkingMode)((Object)object2));
            object = g.o(this.getResources(), n13);
            BleViewModel bleViewModel = this.j;
            object2 = bleViewModel.I((WorkingMode)((Object)object2), (String)object);
            object3.add(object2);
        }
        this.h.i.setDataList((List)object3);
    }

    private boolean S(View view, int n10) {
        boolean bl2 = false;
        if (view == null) {
            return false;
        }
        int n11 = view.getLeft();
        int n12 = view.getRight();
        if (n10 >= n11 && n10 <= n12) {
            bl2 = true;
        }
        return bl2;
    }

    private /* synthetic */ void T() {
        int n10;
        ViewGroup.LayoutParams layoutParams = this.h.g.getLayoutParams();
        Object object = this.h.h.getLayoutParams();
        int n11 = this.k();
        int n12 = 3;
        float f10 = 2.0f;
        float f11 = 1.0f;
        if (n11 != 0 && (n11 = this.k()) != (n10 = 2)) {
            n11 = this.h.f.getWidth();
            LinearLayout linearLayout = this.h.e;
            int n13 = 1;
            n10 = linearLayout.getChildAt(n13).getWidth();
            layoutParams.width = n11 = (int)((float)(n11 - n10) * f11 / f10);
            HorizontalScrollView horizontalScrollView = this.h.f;
            n11 = horizontalScrollView.getWidth();
            linearLayout = this.h.e;
            View view = linearLayout.getChildAt(n12);
            n12 = view.getWidth();
            float f12 = (float)(n11 - n12) * f11 / f10;
            object.width = n11 = (int)f12;
        } else {
            layoutParams.width = 0;
            HorizontalScrollView horizontalScrollView = this.h.f;
            n11 = horizontalScrollView.getWidth();
            LinearLayout linearLayout = this.h.e;
            View view = linearLayout.getChildAt(n12);
            n12 = view.getWidth();
            float f13 = (float)(n11 - n12) * f11 / f10;
            object.width = n11 = (int)f13;
        }
        this.h.g.setLayoutParams(layoutParams);
        this.h.h.setLayoutParams(object);
        layoutParams = this.h.h;
        object = new u(this);
        layoutParams.post((Runnable)object);
    }

    public static /* synthetic */ Pair V(String string2) {
        boolean bl2 = s1.b0(string2 = s1.H(string2));
        if (bl2) {
            return Pair.create(a2.d(string2), string2);
        }
        bl2 = s1.X(string2);
        if (bl2) {
            return Pair.create(string2, null);
        }
        return Pair.create(null, null);
    }

    private /* synthetic */ void W(Pair object) {
        Object object2 = ((Pair)object).first;
        boolean bl2 = object2 instanceof a2$a;
        if (bl2) {
            object = (String)((Pair)object).second;
            object2 = (a2$a)object2;
            this.t0((String)object, (a2$a)object2);
        } else {
            boolean bl3 = object2 instanceof String;
            if (bl3) {
                object2 = (String)object2;
                this.s0((String)object2);
            }
        }
    }

    private /* synthetic */ void Y() {
        WheelPicker wheelPicker = this.h.j;
        Object object = this.i;
        List list = object.Y;
        object = object.I();
        int n10 = list.indexOf(object);
        wheelPicker.y(n10, false, false);
        wheelPicker = this.h.j;
        object = new z(this);
        wheelPicker.setOnWheelChangeListener((WheelPicker$b)object);
        wheelPicker = this.h.i;
        object = new o(this);
        wheelPicker.setOnWheelChangeListener((WheelPicker$b)object);
    }

    private /* synthetic */ void a0(WorkingMode workingMode) {
        List list = this.j.A();
        Collections.sort(list);
        int n10 = Collections.binarySearch(list, workingMode);
        this.h.i.y(n10, false, false);
    }

    private /* synthetic */ void c0(BleViewModel$JoystickEvent bleViewModel$JoystickEvent) {
        int[] nArray = e1$c.a;
        int n10 = bleViewModel$JoystickEvent.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    n11 = 4;
                    if (n10 == n11) {
                        this.N();
                    }
                } else {
                    this.L();
                }
            } else {
                this.K();
            }
        } else {
            this.O();
        }
    }

    private /* synthetic */ void e0(Boolean bl2) {
        this.dismissAllowingStateLoss();
    }

    public static /* synthetic */ void g0(Boolean bl2) {
    }

    private /* synthetic */ void h0(View view, int n10, int n11, int n12, int n13) {
        this.k = n10;
        boolean bl2 = this.m;
        if (!bl2) {
            this.w0();
        }
    }

    private /* synthetic */ void j0() {
        this.m = false;
        LinearLayout linearLayout = this.h.e;
        int n10 = this.l;
        linearLayout = linearLayout.getChildAt(n10);
        HorizontalScrollView horizontalScrollView = this.h.f;
        this.v0(horizontalScrollView, (View)linearLayout);
    }

    private /* synthetic */ void l0(Object object, int n10) {
        object = this.i;
        CameraSet$Mode cameraSet$Mode = (CameraSet$Mode)((Object)((u6)object).Y.get(n10));
        ((u6)object).N1(cameraSet$Mode);
    }

    private /* synthetic */ void n0(Object object, int n10) {
        int n11;
        object = this.j.A();
        if (n10 >= 0 && n10 < (n11 = object.size())) {
            BleViewModel bleViewModel = this.j;
            object = (WorkingMode)((Object)object.get(n10));
            bleViewModel.t1((WorkingMode)((Object)object));
        }
    }

    private /* synthetic */ void p0(d.v.j0.d d10) {
        this.h.b.pause();
        this.h.b.setOnPreparedListener(null);
    }

    public static e1 r0() {
        e1 e12 = new e1();
        e12.setStyle(1, 2132017156);
        return e12;
    }

    private void s0(String string2) {
        this.h.d.setVisibility(0);
        Context context = this.requireContext();
        e1$b e1$b = new e1$b(this);
        Images.w(context, string2, e1$b);
    }

    private void t0(String object, a2$a object2) {
        int n10;
        float f10;
        int n11;
        int n12 = ((a2$a)object2).d;
        float f11 = 1.0f;
        if (n12 != 0 && n12 != (n11 = 180)) {
            n12 = ((a2$a)object2).b;
            f10 = (float)n12 * f11;
            n10 = ((a2$a)object2).a;
        } else {
            n12 = ((a2$a)object2).a;
            f10 = (float)n12 * f11;
            n10 = ((a2$a)object2).b;
        }
        float f12 = n10;
        this.u0(f10 /= f12);
        this.h.b.setVisibility(0);
        this.h.b.setLoopPlay(false);
        this.h.b.L(false);
        this.h.b.setMediaControllerDefault(false);
        this.h.b.A();
        object2 = this.h.b;
        String[] stringArray = new String[]{object};
        ((ExoVideoView)object2).setVideoPath(stringArray);
        object = this.h.b;
        object2 = new r(this);
        ((ExoVideoView)object).setOnPreparedListener((d$d)object2);
    }

    private void u0(float f10) {
        ViewGroup.LayoutParams layoutParams = this.h.a.getLayoutParams();
        int n10 = this.o;
        int n11 = h2.b(32.0f);
        n10 -= n11;
        float f11 = 1.0f;
        float f12 = f10 - f11;
        n11 = (int)(f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1));
        if (n11 > 0) {
            int n12;
            layoutParams.width = n10;
            float f13 = (float)n10 / f10;
            layoutParams.height = n12 = (int)f13;
        } else {
            int n13;
            f11 = (float)n10 * f10;
            layoutParams.width = n13 = (int)f11;
            layoutParams.height = n10;
        }
        this.h.a.setLayoutParams(layoutParams);
    }

    private void v0(HorizontalScrollView horizontalScrollView, View view) {
        int n10 = horizontalScrollView.getWidth();
        int n11 = view.getWidth();
        float f10 = (float)(n10 + n11) * 1.0f / 2.0f;
        int n12 = view.getRight();
        n10 = (int)f10;
        horizontalScrollView.smoothScrollTo(n12 -= n10, 0);
    }

    private void w0() {
        HorizontalScrollView horizontalScrollView = this.h.f;
        Runnable runnable = this.n;
        horizontalScrollView.removeCallbacks(runnable);
        horizontalScrollView = this.h.f;
        runnable = this.n;
        horizontalScrollView.postDelayed(runnable, (long)100);
    }

    public /* synthetic */ void U() {
        this.T();
    }

    public /* synthetic */ void X(Pair pair) {
        this.W(pair);
    }

    public /* synthetic */ void Z() {
        this.Y();
    }

    public /* synthetic */ void b0(WorkingMode workingMode) {
        this.a0(workingMode);
    }

    public /* synthetic */ void d0(BleViewModel$JoystickEvent bleViewModel$JoystickEvent) {
        this.c0(bleViewModel$JoystickEvent);
    }

    public /* synthetic */ void f0(Boolean bl2) {
        this.e0(bl2);
    }

    public /* synthetic */ void i0(View view, int n10, int n11, int n12, int n13) {
        this.h0(view, n10, n11, n12, n13);
    }

    public /* synthetic */ void k0() {
        this.j0();
    }

    public /* synthetic */ void m0(Object object, int n10) {
        this.l0(object, n10);
    }

    public /* synthetic */ void o0(Object object, int n10) {
        this.n0(object, n10);
    }

    public void onAttach(Context object) {
        u6 u62;
        super.onAttach((Context)object);
        object = b.c(this.requireActivity());
        this.i = u62 = (u6)((ViewModelProvider)object).get(u6.class);
        this.j = object = (BleViewModel)((ViewModelProvider)object).get(BleViewModel.class);
    }

    public void onDestroy() {
        this.h.b.F(true);
        super.onDestroy();
    }

    public void onPause() {
        this.j.o1(false);
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.I();
        this.j.o1(true);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.R();
        this.Q();
    }

    public void p(int n10) {
        super.p(n10);
        this.I();
    }

    public /* synthetic */ void q0(d.v.j0.d d10) {
        this.p0(d10);
    }

    public int s() {
        return 2131558470;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (h1)viewDataBinding;
        this.h = viewDataBinding;
        Object object = new e1$d(this);
        ((h1)viewDataBinding).A((e1$d)object);
        viewDataBinding = this.h;
        object = this.l;
        ((h1)viewDataBinding).B((Integer)object);
        int n10 = Windows.l(this.requireContext()).getWidth();
        this.z(n10);
        this.A(true);
    }
}

