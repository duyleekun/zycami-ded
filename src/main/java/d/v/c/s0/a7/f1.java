/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.view.View
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  android.widget.ImageView
 *  android.widget.RadioButton
 *  android.widget.RadioGroup
 *  android.widget.RadioGroup$OnCheckedChangeListener
 */
package d.v.c.s0.a7;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import com.zhiyun.cama.camera.ble.BleViewModel;
import d.v.c.s0.a7.a0;
import d.v.c.s0.a7.b0;
import d.v.c.s0.a7.c0;
import d.v.c.s0.a7.f1$a;
import d.v.c.s0.a7.o1.r0;
import d.v.c.s0.a7.o1.s0;
import d.v.c.s0.a7.o1.t0;
import d.v.c.s0.a7.u0;
import d.v.c.w0.l1;
import d.v.c.x1.l;
import d.v.e.l.h2;
import d.v.e.l.o1;
import d.v.f.i.g;
import d.v.i0.b;

public class f1
extends u0 {
    private l1 h;
    private BleViewModel i;
    private NavHostFragment j;
    private int k;
    private CompoundButton.OnCheckedChangeListener l;

    public f1() {
        a0 a02 = a0.a;
        this.l = a02;
    }

    public static /* synthetic */ l1 B(f1 f12) {
        return f12.h;
    }

    public static /* synthetic */ NavHostFragment C(f1 f12) {
        return f12.j;
    }

    private void D() {
        BleViewModel bleViewModel;
        this.i = bleViewModel = (BleViewModel)b.c(this.requireActivity()).get(BleViewModel.class);
        this.h.A(bleViewModel);
    }

    private void E() {
        RadioButton radioButton = this.h.f;
        Object object = this.l;
        radioButton.setOnCheckedChangeListener(object);
        radioButton = this.h.e;
        object = this.l;
        radioButton.setOnCheckedChangeListener(object);
        radioButton = this.h.d;
        object = this.l;
        radioButton.setOnCheckedChangeListener(object);
        radioButton = this.h.g;
        object = new b0(this);
        radioButton.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener)object);
    }

    private void F() {
        int n10;
        this.e();
        Object object = NavHostFragment.create(2131755012);
        this.j = object;
        object = this.getChildFragmentManager().beginTransaction();
        NavHostFragment navHostFragment = this.j;
        ((FragmentTransaction)object).add(2131362468, navHostFragment).commit();
        this.k = n10 = this.h.g.getCheckedRadioButtonId();
    }

    private /* synthetic */ void G(RadioGroup object, int n10) {
        int n11 = 2131363065;
        int n12 = 2131363061;
        if (n10 == n11) {
            n11 = this.k;
            object = n11 == n12 ? s0.c() : r0.b();
        } else if (n10 == n12) {
            n12 = this.k;
            object = n12 == n11 ? t0.c() : r0.a();
        } else {
            n11 = 2131363032;
            if (n10 == n11) {
                n11 = this.k;
                object = n11 == n12 ? s0.b() : t0.b();
            } else {
                n11 = 0;
                object = null;
            }
        }
        d.v.c.x1.l.f(this.j, (NavDirections)object);
        this.k = n10;
    }

    public static /* synthetic */ void I(CompoundButton compoundButton, boolean bl2) {
        if (bl2) {
            int n10 = 1098907648;
            float f10 = 16.0f;
            compoundButton.setTextSize(f10);
        } else {
            int n11 = 1096810496;
            float f11 = 14.0f;
            compoundButton.setTextSize(f11);
        }
    }

    private /* synthetic */ void J(NavController object, NavDestination navDestination, Bundle bundle) {
        int n10 = navDestination.getId();
        int n11 = -1;
        int n12 = 8;
        int n13 = 2131363191;
        if (n10 == n13) {
            n10 = 2131952756;
            this.h.h.setVisibility(0);
            navDestination = this.h.g;
            navDestination.setVisibility(n12);
        } else {
            n10 = navDestination.getId();
            if (n10 == (n13 = 2131363756)) {
                n10 = 2131953280;
                this.h.h.setVisibility(0);
                navDestination = this.h.g;
                navDestination.setVisibility(n12);
            } else {
                int n14;
                n10 = navDestination.getId();
                if (n10 == (n14 = 2131362518)) {
                    n10 = 2131953250;
                    this.h.h.setVisibility(0);
                    navDestination = this.h.g;
                    navDestination.setVisibility(n12);
                } else {
                    this.h.h.setVisibility(n12);
                    object = this.h.g;
                    object.setVisibility(0);
                    n10 = n11;
                }
            }
        }
        if (n10 != n11) {
            navDestination = this.h.h;
            bundle = this.getResources();
            object = g.o((Resources)bundle, n10);
            navDestination.setText((CharSequence)object);
        }
    }

    public static f1 L() {
        f1 f12 = new f1();
        return f12;
    }

    public /* synthetic */ void H(RadioGroup radioGroup, int n10) {
        this.G(radioGroup, n10);
    }

    public /* synthetic */ void K(NavController navController, NavDestination navDestination, Bundle bundle) {
        this.J(navController, navDestination, bundle);
    }

    public void e() {
        ImageView imageView = this.h.c;
        Drawable drawable2 = o1.o(this.getResources(), 2131231362);
        imageView.setImageDrawable(drawable2);
    }

    public void onResume() {
        super.onResume();
        NavController navController = this.j.getNavController();
        c0 c02 = new c0(this);
        navController.addOnDestinationChangedListener(c02);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.D();
        this.F();
        this.E();
    }

    public int s() {
        return 2131558472;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (l1)viewDataBinding;
        this.h = viewDataBinding;
        f1$a f1$a = new f1$a(this);
        ((l1)viewDataBinding).B(f1$a);
        int n10 = h2.b(262.0f);
        this.z(n10);
    }
}

