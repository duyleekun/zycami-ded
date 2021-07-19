/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.os.Bundle
 *  android.view.View
 */
package d.v.c.y1.h;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.zyplayer.ExoVideoView;
import d.v.c.b1.t.g;
import d.v.c.q0.b;
import d.v.c.w0.n6;
import d.v.c.y1.h.d;
import d.v.c.y1.h.e;
import d.v.c.y1.h.f;
import d.v.c.y1.h.i$a;
import d.v.c.y1.h.j;
import d.v.e.l.l2;
import d.v.e.l.n2;
import d.v.j0.d$a;
import d.v.j0.d$d;

public class i
extends b {
    private static final String k = "video_uri";
    private n6 g;
    private j h;
    private ExoVideoView i;
    private String j;

    public static /* synthetic */ j A(i i10) {
        return i10.h;
    }

    public static /* synthetic */ void B(i i10) {
        i10.N();
    }

    public static i C(String string2) {
        i i10 = new i();
        Bundle bundle = new Bundle();
        bundle.putString(k, string2);
        i10.setArguments(bundle);
        return i10;
    }

    private void D() {
        MutableLiveData mutableLiveData = this.h.e();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        e e10 = new e(this);
        mutableLiveData.observe(lifecycleOwner, e10);
    }

    private void E() {
        Object object = this.getArguments();
        if (object == null) {
            return;
        }
        object = this.getArguments();
        Object object2 = k;
        object = object.getString((String)object2);
        this.j = object;
        if (object == null) {
            return;
        }
        this.i.setMediaControllerDefault(false);
        this.i.A();
        object = this.i;
        String string2 = this.j;
        String[] stringArray = new String[]{string2};
        ((ExoVideoView)object).setVideoPath(stringArray);
        object = this.i;
        object2 = new f(this);
        ((ExoVideoView)object).setOnPreparedListener((d$d)object2);
        object = this.i;
        object2 = new d(this);
        ((ExoVideoView)object).setOnCompletionListener((d$a)object2);
    }

    private /* synthetic */ void F(Boolean object) {
        boolean bl2;
        if (object == null) {
            return;
        }
        boolean bl3 = (Boolean)object;
        if (!bl3) {
            n2.e(d.v.f.i.g.s(this, 2131952046));
            return;
        }
        object = this.requireActivity().getSupportFragmentManager().getFragments().iterator();
        while (bl2 = object.hasNext()) {
            Fragment fragment = (Fragment)object.next();
            boolean bl4 = fragment instanceof DialogFragment;
            if (!bl4) continue;
            fragment = (DialogFragment)fragment;
            ((DialogFragment)fragment).dismissAllowingStateLoss();
        }
    }

    private /* synthetic */ void H(d.v.j0.d d10) {
        this.i.E();
        this.h.o(d10);
    }

    private /* synthetic */ void J(d.v.j0.d object) {
        this.M();
        this.i.c(0);
        this.h.n(100);
        object = l2.b((long)object.getDuration() * 1000L);
        j j10 = this.h;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)object);
        stringBuilder.append("/");
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        j10.m((String)object);
    }

    private void L() {
        Dialog dialog = this.getDialog();
        if (dialog != null && (dialog = this.getDialog().getWindow()) != null) {
            dialog = this.getDialog().getWindow();
            dialog.setBackgroundDrawableResource(2131099739);
            View view = dialog.getDecorView();
            view.setPadding(0, 0, 0, 0);
            int n10 = -1;
            dialog.setLayout(n10, n10);
        }
    }

    private void M() {
        this.i.E();
        this.g.k.setImageResource(2131231150);
    }

    private void N() {
        this.i.start();
        this.g.k.setImageResource(2131231620);
    }

    public static /* synthetic */ String w(i i10) {
        return i10.j;
    }

    public static /* synthetic */ ExoVideoView x(i i10) {
        return i10.i;
    }

    public static /* synthetic */ void y(i i10) {
        i10.M();
    }

    public static /* synthetic */ g z(i i10) {
        return i10.f;
    }

    public /* synthetic */ void G(Boolean bl2) {
        this.F(bl2);
    }

    public /* synthetic */ void I(d.v.j0.d d10) {
        this.H(d10);
    }

    public /* synthetic */ void K(d.v.j0.d d10) {
        this.J(d10);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.M();
        this.h.p();
        this.i.F(true);
    }

    public void onStart() {
        super.onStart();
        this.D();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.E();
    }

    public int s() {
        return 2131558568;
    }

    public void t(ViewDataBinding object) {
        super.t((ViewDataBinding)object);
        Object object2 = (j)d.v.i0.b.a(this).get(j.class);
        this.h = object2;
        object = (n6)object;
        this.g = object;
        object2 = new i$a(this);
        ((n6)object).A((i$a)object2);
        object = this.g;
        object2 = this.h;
        ((n6)object).B((j)object2);
        this.i = object = this.g.c;
        this.L();
    }
}

