/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnKeyListener
 *  android.content.Intent
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.view.KeyEvent
 *  android.view.View
 */
package d.v.c.m1.d;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.account.me.account.visitor.VisitorBindActivity;
import com.zhiyun.cama.prime.dialog.PrimeGetDialogViewModel;
import com.zhiyun.cama.prime.dialog.PrimeGetDialogViewModel$PRIME_STATUS;
import com.zhiyun.cama.prime.dialog.PrimeGetDialogViewModel$PrimeShowType;
import com.zhiyun.cama.prime.model.PrimeInfo;
import com.zhiyun.cama.prime.web.PrimeWebActivity;
import d.v.c.l0$b;
import d.v.c.m1.c;
import d.v.c.m1.d.h;
import d.v.c.m1.d.i;
import d.v.c.m1.d.j;
import d.v.c.m1.d.o;
import d.v.c.m1.d.o$a;
import d.v.c.m1.d.p$a;
import d.v.c.m1.e.y;
import d.v.c.w0.eg;
import d.v.e.f;
import d.v.e.l.h2;
import d.v.f.g.a;
import d.v.i0.b;

public class p
extends a {
    private static final String l = "prime_model";
    private static final String m = "prime_auto_receive";
    public static int n = 0;
    public static int o = 1;
    public static int p = 2;
    public static int q = 3;
    private boolean f;
    private c g;
    private PrimeGetDialogViewModel h;
    private y i;
    private eg j;
    private o k;

    private void A() {
        o o10 = this.k;
        if (o10 != null) {
            o10.dismiss();
        }
    }

    private void B() {
        d.v.a.f.c.b b10 = d.v.a.f.c.b.N();
        int n10 = (int)(b10.j() ? 1 : 0);
        if (n10 != 0) {
            n10 = 1;
            VisitorBindActivity.h(this, n10);
        } else {
            this.z();
        }
    }

    private void C() {
        Dialog dialog = this.getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
            dialog.setCancelable(false);
            h h10 = new h(this);
            dialog.setOnKeyListener((DialogInterface.OnKeyListener)h10);
        }
    }

    private void D() {
        MutableLiveData mutableLiveData = this.h.m();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        i i10 = new i(this);
        mutableLiveData.observe(lifecycleOwner, i10);
    }

    private /* synthetic */ boolean E(DialogInterface object, int n10, KeyEvent keyEvent) {
        int n11 = keyEvent.getKeyCode();
        if (n11 == (n10 = 4) && (object = this.getActivity()) != null) {
            this.dismiss();
            return true;
        }
        return false;
    }

    private /* synthetic */ void G(PrimeGetDialogViewModel$PRIME_STATUS object) {
        this.h.w((PrimeGetDialogViewModel$PRIME_STATUS)((Object)object));
        Object object2 = PrimeGetDialogViewModel$PRIME_STATUS.PRIME_STATUS_SUCCESS;
        if (object == object2) {
            object = this.g;
            object2 = d.v.a.f.c.b.N().P();
            ((c)object).w((String)object2);
        }
    }

    private /* synthetic */ void I(DialogFragment dialogFragment) {
        this.A();
    }

    public static p K() {
        d.v.a.f.c.b b10 = d.v.a.f.c.b.N();
        int n10 = b10.j();
        n10 = n10 != 0 ? o : n;
        return d.v.c.m1.d.p.L(n10, false);
    }

    public static p L(int n10, boolean bl2) {
        p p10 = new p();
        Bundle bundle = new Bundle();
        bundle.putInt(l, n10);
        bundle.putBoolean(m, bl2);
        p10.setArguments(bundle);
        return p10;
    }

    private void M() {
        float f10 = 284.0f;
        int n10 = h2.b(f10);
        Dialog dialog = this.getDialog();
        if (dialog != null && (dialog = this.getDialog().getWindow()) != null) {
            dialog = this.getDialog().getWindow();
            dialog.setLayout(n10, -2);
            n10 = 17;
            f10 = 2.4E-44f;
            dialog.setGravity(n10);
            ColorDrawable colorDrawable = new ColorDrawable(0);
            dialog.setBackgroundDrawable((Drawable)colorDrawable);
        }
    }

    private void N() {
        Object object = d.v.e.f.a().c();
        Object object2 = new o$a((Context)object);
        object2 = ((o$a)object2).r(2131952706).h(2131952661);
        object = new j(this);
        object2 = ((o$a)object2).o(2131951887, (d.v.f.f.a)object).m();
        object = this.getParentFragmentManager();
        this.k = object2 = ((o$a)object2).t((FragmentManager)object);
    }

    private void O() {
        Object object;
        Object object2 = this.h.l();
        if (object2 == (object = PrimeGetDialogViewModel$PrimeShowType.PRIME_SHOW_WEB_VIEW)) {
            object2 = this.i.c;
            object = l0$b.d;
            ((MutableLiveData)object2).postValue(object);
        } else {
            object2 = this.requireContext();
            PrimeWebActivity.d((Context)object2);
        }
    }

    public static /* synthetic */ c u(p p10) {
        return p10.g;
    }

    public static /* synthetic */ void v(p p10) {
        p10.N();
    }

    public static /* synthetic */ PrimeGetDialogViewModel w(p p10) {
        return p10.h;
    }

    public static /* synthetic */ void x(p p10) {
        p10.O();
    }

    public static /* synthetic */ void y(p p10) {
        p10.B();
    }

    private void z() {
        Object object;
        boolean bl2;
        Object object2 = this.g.g();
        if (object2 != null && (bl2 = ((c)(object = this.g)).p())) {
            object = d.v.a.f.c.b.N().i();
            PrimeGetDialogViewModel primeGetDialogViewModel = this.h;
            object = ((UserInfo)object).getToken();
            int n10 = ((PrimeInfo)object2).getId();
            object2 = String.valueOf(n10);
            primeGetDialogViewModel.p((String)object, (String)object2);
        } else {
            this.dismissAllowingStateLoss();
        }
    }

    public /* synthetic */ boolean F(DialogInterface dialogInterface, int n10, KeyEvent keyEvent) {
        return this.E(dialogInterface, n10, keyEvent);
    }

    public /* synthetic */ void H(PrimeGetDialogViewModel$PRIME_STATUS primeGetDialogViewModel$PRIME_STATUS) {
        this.G(primeGetDialogViewModel$PRIME_STATUS);
    }

    public /* synthetic */ void J(DialogFragment dialogFragment) {
        this.I(dialogFragment);
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        d.v.a.f.c.b b10;
        super.onActivityResult(n10, n11, intent);
        int n12 = 1;
        if (n10 == n12 && n11 == (n10 = 2) && (n10 = (int)((b10 = d.v.a.f.c.b.N()).s() ? 1 : 0)) != 0) {
            this.z();
        }
    }

    public void onAttach(Context object) {
        Class<y> clazz = y.class;
        super.onAttach((Context)object);
        object = b.c(this.requireActivity());
        Object object2 = (c)((ViewModelProvider)object).get(c.class);
        this.g = object2;
        object2 = b.a(this);
        Class<PrimeGetDialogViewModel> clazz2 = PrimeGetDialogViewModel.class;
        this.h = object2 = (PrimeGetDialogViewModel)((ViewModelProvider)object2).get(clazz2);
        object2 = this.getParentFragment();
        this.i = object2 != null ? (object = (y)b.a(this.getParentFragment()).get(clazz)) : (object = (y)((ViewModelProvider)object).get(clazz));
    }

    public void onResume() {
        super.onResume();
        this.M();
    }

    public void onViewCreated(View object, Bundle object2) {
        int n10;
        super.onViewCreated((View)object, (Bundle)object2);
        object = PrimeGetDialogViewModel$PrimeShowType.PRIME_SHOW_TYPE_OFFICIAL;
        object2 = this.getArguments();
        if (object2 != null) {
            boolean bl2;
            n10 = object2.getInt(l, 0);
            String string2 = m;
            this.f = bl2 = object2.getBoolean(string2, false);
            object = PrimeGetDialogViewModel$PrimeShowType.fromId(n10);
        }
        object2 = this.h;
        ((PrimeGetDialogViewModel)object2).u((PrimeGetDialogViewModel$PrimeShowType)((Object)object));
        n10 = (int)(this.f ? 1 : 0);
        if (n10 != 0) {
            this.B();
        }
        this.C();
        this.D();
    }

    public int s() {
        return 2131558745;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (eg)viewDataBinding;
        this.j = viewDataBinding;
        Object object = this.h;
        ((eg)viewDataBinding).B((PrimeGetDialogViewModel)object);
        viewDataBinding = this.j;
        object = new p$a(this);
        ((eg)viewDataBinding).A((p$a)object);
    }
}

