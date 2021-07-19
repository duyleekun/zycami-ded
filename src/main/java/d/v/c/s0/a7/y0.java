/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowManager$LayoutParams
 *  android.widget.CheckBox
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.LinearLayout$LayoutParams
 */
package d.v.c.s0.a7;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.cama.camera.data.CameraSet$DelayInterval;
import com.zhiyun.cama.camera.data.CameraSet$DelayTime;
import com.zhiyun.cama.camera.widget.StringScrollView;
import com.zhiyun.cama.camera.widget.StringScrollView$c;
import com.zhiyun.image.Images;
import d.v.c.s0.a7.f;
import d.v.c.s0.a7.g;
import d.v.c.s0.a7.i;
import d.v.c.s0.a7.j;
import d.v.c.s0.a7.k;
import d.v.c.s0.a7.t0;
import d.v.c.s0.a7.y0$a;
import d.v.c.s0.s6;
import d.v.c.s0.u6;
import d.v.c.w0.qa;
import d.v.c.w0.r0;
import d.v.e.l.h2;
import d.v.e0.yd;
import d.v.i0.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class y0
extends t0 {
    private r0 f;
    private u6 g;
    private BleViewModel h;
    private List i;
    private List j;
    private s6 k;
    private int l;

    private void A() {
        CheckBox checkBox = this.f.a;
        g g10 = new g(this);
        checkBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)g10);
    }

    private void B() {
        MutableLiveData mutableLiveData = this.h.z;
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        Observer observer = new j(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.h.B;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new f(this);
        mutableLiveData.observe(lifecycleOwner, observer);
    }

    /*
     * WARNING - void declaration
     */
    private void C() {
        void var12_18;
        int n10;
        int n11;
        int n112;
        int n12;
        Object object = this.g.Z();
        Object object2 = CameraSet$DelayInterval.values();
        Object object3 = new ArrayList();
        boolean bl2 = false;
        float f10 = 0.0f;
        int n13 = 0;
        for (n12 = 0; n12 < (n112 = ((CameraSet$DelayInterval[])object2).length); ++n12) {
            Object object4 = object2[n12].getStr();
            object3.add(object4);
            object4 = object2[n12];
            if (object4 != object) continue;
            n13 = n12;
        }
        object = this.f.f;
        n12 = h2.b(110.0f);
        ((StringScrollView)object).setRecyclerViewWidth(n12);
        object = this.f.f;
        f10 = 36.0f;
        n12 = h2.b(f10);
        n112 = 1103101952;
        float f11 = 24.0f;
        int n14 = h2.b(f11);
        ((StringScrollView)object).o(n12, n14);
        this.f.f.setOrientation(0);
        this.f.f.setData((List)object3);
        this.f.f.setSelected(n13);
        object = this.f.f;
        object3 = new i(this, (CameraSet$DelayInterval[])object2);
        ((StringScrollView)object).setOnSelectListener((StringScrollView$c)object3);
        object = this.f.g;
        int n15 = h2.b(130.0f);
        ((StringScrollView)object).setRecyclerViewWidth(n15);
        object = this.f.g;
        float f12 = 50.0f;
        int n16 = h2.b(f12);
        int n17 = h2.b(f11);
        ((StringScrollView)object).o(n16, n17);
        this.f.g.setOrientation(0);
        this.i = object = Arrays.asList(CameraSet$DelayTime.values());
        this.j = object = new ArrayList();
        object = null;
        for (n11 = 0; n11 < (n10 = (object2 = this.i).size()); ++n11) {
            object2 = this.j;
            object3 = ((CameraSet$DelayTime)((Object)this.i.get(n11))).getStr();
            object2.add(object3);
        }
        object = this.f.a;
        object2 = this.h;
        int n18 = ((BleViewModel)object2).G();
        boolean bl3 = true;
        float f13 = Float.MIN_VALUE;
        if (n18 > 0) {
            boolean bl4 = bl3;
            f12 = f13;
        } else {
            boolean bl5 = false;
            object2 = null;
            f12 = 0.0f;
        }
        object.setChecked((boolean)var12_18);
        object = this.h;
        n11 = ((BleViewModel)object).G();
        if (n11 > 0) {
            bl2 = bl3;
        }
        this.Q(bl2);
    }

    private /* synthetic */ void D(View view) {
        this.h.c1();
    }

    private /* synthetic */ void F(CompoundButton compoundButton, boolean bl2) {
        this.y(bl2);
    }

    private /* synthetic */ void H(Boolean bl2) {
        int n10 = bl2.booleanValue();
        if (n10 != 0) {
            float f10 = 38.0f;
            n10 = h2.b(f10);
        } else {
            n10 = 0;
            float f11 = 0.0f;
            bl2 = null;
        }
        this.l = n10;
        this.P();
    }

    private /* synthetic */ void J(CameraSet$DelayInterval[] object, int n10) {
        u6 u62 = this.g;
        object = object[n10];
        u62.X1((CameraSet$DelayInterval)((Object)object));
    }

    public static /* synthetic */ void L(y0 y02, List list) {
        y02.z(list);
    }

    private /* synthetic */ void M(List object, int n10) {
        u6 u62 = this.g;
        object = (CameraSet$DelayTime)((Object)object.get(n10));
        u62.Y1((CameraSet$DelayTime)((Object)object));
    }

    public static y0 O() {
        y0 y02 = new y0();
        return y02;
    }

    private void P() {
        Dialog dialog = this.getDialog();
        if (dialog != null && (dialog = this.getDialog().getWindow()) != null) {
            int n10;
            dialog = this.getDialog().getWindow();
            View view = dialog.getDecorView();
            int n11 = 0;
            float f10 = 0.0f;
            ViewGroup.LayoutParams layoutParams = null;
            view.setPadding(0, 0, 0, 0);
            view = dialog.getAttributes();
            int n12 = this.k();
            int n13 = 1122238464;
            float f11 = 114.0f;
            float f12 = 56.0f;
            int n14 = 1134559232;
            float f13 = 320.0f;
            int n15 = 2;
            if (n12 != 0 && n12 != n15) {
                view.gravity = 48;
                float f14 = 58.0f;
                n10 = h2.b(f14);
                int n16 = this.l;
                view.y = n10 += n16;
                view.x = 0;
                view.width = n14 = h2.b(f13);
                CheckBox checkBox = this.f.a;
                n14 = (int)(checkBox.isChecked() ? 1 : 0);
                view.height = n14 != 0 ? (n13 = h2.b(f11)) : (n13 = h2.b(f12));
                n10 = 0;
                f14 = 0.0f;
            } else {
                view.gravity = 0x800003;
                view.y = 0;
                n10 = h2.b(130.0f);
                int n17 = this.l;
                view.x = n10 += n17;
                n10 = -90;
                float f15 = 0.0f / 0.0f;
                view.height = n14 = h2.b(f13);
                CheckBox checkBox = this.f.a;
                n14 = (int)(checkBox.isChecked() ? 1 : 0);
                view.width = n14 != 0 ? (n13 = h2.b(f11)) : (n13 = h2.b(f12));
            }
            n13 = 0;
            f11 = 0.0f;
            view.dimAmount = 0.0f;
            dialog.setAttributes((WindowManager.LayoutParams)view);
            ColorDrawable colorDrawable = new ColorDrawable(0);
            dialog.setBackgroundDrawable((Drawable)colorDrawable);
            dialog = this.getView();
            if (dialog != null) {
                f10 = n10;
                dialog.setRotation(f10);
                if (n12 != 0 && n12 != n15) {
                    int n18;
                    layoutParams = dialog.getLayoutParams();
                    layoutParams.width = n12 = view.width;
                    layoutParams = dialog.getLayoutParams();
                    layoutParams.height = n18 = view.height;
                    view = dialog.getLayoutParams();
                    dialog.setLayoutParams((ViewGroup.LayoutParams)view);
                    dialog.setTranslationX(0.0f);
                    dialog.setTranslationY(0.0f);
                } else {
                    layoutParams = dialog.getLayoutParams();
                    layoutParams.width = n12 = view.height;
                    layoutParams = dialog.getLayoutParams();
                    layoutParams.height = n12 = view.width;
                    layoutParams = dialog.getLayoutParams();
                    dialog.setLayoutParams(layoutParams);
                    n11 = view.width / n15;
                    int n19 = view.height / n15;
                    float f16 = n11 -= n19;
                    dialog.setTranslationX(f16);
                    n19 = -n11;
                    f16 = n19;
                    dialog.setTranslationY(f16);
                }
            }
        }
    }

    private void Q(boolean bl2) {
        Object object;
        Object object2 = this.i;
        ArrayList arrayList = new ArrayList(object2);
        List list = this.j;
        object2 = new Object(list);
        list = null;
        if (bl2) {
            arrayList.remove(0);
            object2.remove(0);
        }
        StringScrollView stringScrollView = this.f.g;
        stringScrollView.setData((List)object2);
        object2 = this.g.b0();
        int n10 = arrayList.indexOf(object2);
        if (bl2 && (object = CameraSet$DelayTime.t_infinite) == object2) {
            object = this.g;
            object2 = CameraSet$DelayTime.t_1m;
            ((u6)object).Y1((CameraSet$DelayTime)((Object)object2));
            object = this.f.g;
            ((StringScrollView)object).setSelected(0);
        } else {
            object = this.f.g;
            ((StringScrollView)object).setSelected(n10);
        }
        object = this.f.g;
        object2 = new Object(this, arrayList);
        ((StringScrollView)object).setOnSelectListener((StringScrollView$c)object2);
    }

    public static /* synthetic */ BleViewModel w(y0 y02) {
        return y02.h;
    }

    public static /* synthetic */ u6 x(y0 y02) {
        return y02.g;
    }

    private void y(boolean bl2) {
        MutableLiveData mutableLiveData = this.k.i;
        Object object = this.getResources();
        int n10 = bl2 ? 2131951789 : 2131951790;
        object = d.v.f.i.g.o(object, n10);
        mutableLiveData.setValue(object);
        mutableLiveData = this.k.j;
        boolean bl3 = bl2 ^ true;
        object = bl3;
        mutableLiveData.setValue(object);
        this.Q(bl2);
        if (!bl2) {
            BleViewModel bleViewModel = this.h;
            bleViewModel.i();
        }
        this.P();
    }

    private void z(List list) {
        int n10;
        int n11;
        y0 y02 = this;
        List list2 = list;
        List list3 = (List)this.h.x.getValue();
        if (list3 != null && list != null && (n11 = list3.size()) == (n10 = list.size())) {
            int n12;
            Object object;
            int n13;
            n11 = list3.size();
            Object object2 = this.f.k;
            int n14 = 8;
            int n15 = 5;
            float f10 = 7.0E-45f;
            if (n11 >= n15) {
                n13 = n14;
            } else {
                n13 = 0;
                object = null;
            }
            object2.setVisibility(n13);
            y02.f.e.removeAllViews();
            object2 = y02.f.e.getLayoutParams();
            n13 = 3;
            if (n11 < n13) {
                f10 = 85.0f;
                n15 = h2.b(f10);
                ((ViewGroup.LayoutParams)object2).width = n12 = -2;
            } else {
                if (n11 == n15) {
                    f10 = 316.0f;
                    ((ViewGroup.LayoutParams)object2).width = n15 = h2.b(f10);
                } else {
                    f10 = 264.0f;
                    ((ViewGroup.LayoutParams)object2).width = n15 = h2.b(f10);
                }
                n15 = 0;
                f10 = 0.0f;
            }
            Object object3 = y02.f.e;
            object3.setLayoutParams((ViewGroup.LayoutParams)object2);
            object2 = list3.iterator();
            while ((n12 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                int n16;
                object3 = (yd)object2.next();
                int n17 = list3.indexOf(object3);
                Object object4 = LayoutInflater.from((Context)this.getContext());
                int n18 = 2131558626;
                object4 = (qa)DataBindingUtil.inflate((LayoutInflater)object4, n18, null, false);
                FrameLayout frameLayout = (FrameLayout)((ViewDataBinding)object4).getRoot();
                int n19 = h2.b(48.0f);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(n15, n19);
                float f11 = 4.0f;
                layoutParams.rightMargin = n19 = h2.b(f11);
                if (n15 == 0) {
                    n19 = 1065353216;
                    layoutParams.weight = f11 = 1.0f;
                }
                n19 = 1;
                f11 = Float.MIN_VALUE;
                String string2 = n17 != 0 ? (n17 != n19 ? (n17 != (n16 = 2) ? (n17 != n13 ? (n17 != (n16 = 4) ? "" : "E") : "D") : "C") : "B") : "A";
                object = ((qa)object4).c;
                object.setText((CharSequence)string2);
                n13 = n11 + -1;
                if (n17 == n13) {
                    ((qa)object4).c.setVisibility(n14);
                    ((qa)object4).a.setVisibility(0);
                    object = new k(y02);
                    frameLayout.setOnClickListener((View.OnClickListener)object);
                }
                object = ((qa)object4).b;
                n12 = list3.indexOf(object3);
                object3 = list2.get(n12);
                float f12 = 6.0f;
                n17 = h2.b(f12);
                Images.G((ImageView)object, object3, n17);
                object = y02.f.e;
                object.addView((View)frameLayout, (ViewGroup.LayoutParams)layoutParams);
                n13 = 3;
            }
        }
    }

    public /* synthetic */ void E(View view) {
        this.D(view);
    }

    public /* synthetic */ void G(CompoundButton compoundButton, boolean bl2) {
        this.F(compoundButton, bl2);
    }

    public /* synthetic */ void I(Boolean bl2) {
        this.H(bl2);
    }

    public /* synthetic */ void K(CameraSet$DelayInterval[] cameraSet$DelayIntervalArray, int n10) {
        this.J(cameraSet$DelayIntervalArray, n10);
    }

    public /* synthetic */ void N(List list, int n10) {
        this.M(list, n10);
    }

    public void onAttach(Context object) {
        ViewModel viewModel;
        super.onAttach((Context)object);
        object = b.c(this.requireActivity());
        this.g = viewModel = (u6)((ViewModelProvider)object).get(u6.class);
        viewModel = (BleViewModel)((ViewModelProvider)object).get(BleViewModel.class);
        this.h = viewModel;
        this.k = object = (s6)((ViewModelProvider)object).get(s6.class);
    }

    public void onResume() {
        super.onResume();
        this.P();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.C();
        this.A();
        this.B();
    }

    public void p(int n10) {
        this.P();
    }

    public int s() {
        return 2131558462;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (r0)viewDataBinding;
        this.f = viewDataBinding;
        y0$a y0$a = new y0$a(this);
        ((r0)viewDataBinding).z(y0$a);
    }
}

