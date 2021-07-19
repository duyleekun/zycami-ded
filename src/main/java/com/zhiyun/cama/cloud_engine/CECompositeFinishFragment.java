/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ObjectAnimator
 *  android.animation.ValueAnimator
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.net.Uri
 *  android.os.Bundle
 *  android.view.View
 *  android.widget.ImageView
 */
package com.zhiyun.cama.cloud_engine;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.activity.OnBackPressedDispatcher;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;
import com.zhiyun.cama.cloud_engine.CECompositeFinishFragment$a;
import com.zhiyun.cama.cloud_engine.CECompositeFinishFragment$b;
import com.zhiyun.cama.publish.PublishActivity;
import com.zhiyun.zyplayer.ExoVideoView;
import d.v.c.s0.t6;
import d.v.c.t0.a;
import d.v.c.t0.d;
import d.v.c.t0.e;
import d.v.c.t0.f;
import d.v.c.t0.i0;
import d.v.c.t0.l0;
import d.v.c.t0.u;
import d.v.c.w0.l2;
import d.v.d.i.g.c;
import d.v.e.l.n2;
import d.v.f.i.g;
import d.v.g0.k$b;
import d.v.i0.b;

public class CECompositeFinishFragment
extends d.v.f.h.a {
    private static final int i = 848;
    private static final int j = 327;
    private l2 b;
    private u c;
    private CECompositeFinishFragment$b d;
    private int e = 848;
    private ValueAnimator f;
    private long g;
    private String h;

    private void A() {
        long l10;
        long l11 = d.v.d.i.g.c.p();
        long l12 = l11 - (l10 = (long)50);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object < 0) {
            Object object2 = this.getContext();
            k$b k$b = new k$b((Context)object2);
            k$b = (k$b)k$b.m(2131952617);
            d.v.f.f.a a10 = a.a;
            k$b = (k$b)k$b.o(2131951833, a10);
            a10 = new e(this);
            k$b = (k$b)k$b.v(2131952921, a10);
            object2 = this.getChildFragmentManager();
            k$b.D((FragmentManager)object2);
            return;
        }
        this.y();
        Object object3 = this.getArguments();
        if (object3 != null) {
            object3 = object3.getString("ARGUMENTS_FILEURL");
            u u10 = this.c;
            u10.b((String)object3);
        }
    }

    public static /* synthetic */ CECompositeFinishFragment$b j(CECompositeFinishFragment cECompositeFinishFragment) {
        return cECompositeFinishFragment.d;
    }

    public static /* synthetic */ l2 k(CECompositeFinishFragment cECompositeFinishFragment) {
        return cECompositeFinishFragment.b;
    }

    public static /* synthetic */ void l(CECompositeFinishFragment cECompositeFinishFragment) {
        cECompositeFinishFragment.A();
    }

    public static /* synthetic */ int m(CECompositeFinishFragment cECompositeFinishFragment, int n10) {
        cECompositeFinishFragment.e = n10;
        return n10;
    }

    public static /* synthetic */ void n(CECompositeFinishFragment cECompositeFinishFragment) {
        cECompositeFinishFragment.v();
    }

    private void o(l0 object) {
        int n10;
        Object object2 = this.getContext();
        if (object2 == null) {
            return;
        }
        if (object == null) {
            return;
        }
        this.p();
        boolean n11 = ((l0)object).c();
        if (n11) {
            object = this.getResources();
            n10 = 2131952800;
            n2.e(d.v.f.i.g.o((Resources)object, n10));
            object = this.getContext();
            object2 = this.c.c();
            t6.b((Context)object, (String)object2);
        } else {
            object = this.getResources();
            n10 = 2131952844;
            object = d.v.f.i.g.o((Resources)object, n10);
            n2.e((String)object);
        }
        int n12 = this.e;
        n10 = 327;
        if (n12 == n10) {
            object = this.c.c();
            PublishActivity.k(this, (String)object);
        } else {
            this.v();
        }
        this.e = 690;
    }

    private void p() {
        int n10;
        NavController navController = NavHostFragment.findNavController(this);
        NavDestination navDestination = navController.getCurrentDestination();
        if (navDestination == null) {
            return;
        }
        int n11 = navDestination.getId();
        if (n11 == (n10 = 2131361801)) {
            navController.popBackStack();
        }
    }

    private void q() {
        CECompositeFinishFragment$a cECompositeFinishFragment$a = new CECompositeFinishFragment$a(this, true);
        OnBackPressedDispatcher onBackPressedDispatcher = this.requireActivity().getOnBackPressedDispatcher();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        onBackPressedDispatcher.addCallback(lifecycleOwner, cECompositeFinishFragment$a);
    }

    public static /* synthetic */ void r(CECompositeFinishFragment cECompositeFinishFragment, boolean bl2) {
        cECompositeFinishFragment.x(bl2);
    }

    public static /* synthetic */ void s(CECompositeFinishFragment cECompositeFinishFragment, l0 l02) {
        cECompositeFinishFragment.o(l02);
    }

    private /* synthetic */ void t(DialogFragment dialogFragment) {
        dialogFragment.dismiss();
        dialogFragment = new Intent("android.settings.INTERNAL_STORAGE_SETTINGS");
        this.startActivity((Intent)dialogFragment);
    }

    private void v() {
        NavHostFragment.findNavController(this).popBackStack(2131363293, false);
    }

    private void w() {
        ValueAnimator valueAnimator = this.f;
        if (valueAnimator != null) {
            valueAnimator.pause();
        }
    }

    private void x(boolean bl2) {
        if (bl2) {
            ImageView imageView = this.b.b;
            int n10 = 8;
            imageView.setVisibility(n10);
            this.z();
        } else {
            this.w();
        }
    }

    private void y() {
        NavHostFragment.findNavController(this).navigate(2131361859);
    }

    private void z() {
        boolean bl2;
        this.w();
        ValueAnimator valueAnimator = this.f;
        if (valueAnimator == null) {
            valueAnimator = this.b.e;
            int[] nArray = new int[]{0, 100};
            String string2 = "progress";
            this.f = valueAnimator = ObjectAnimator.ofInt((Object)valueAnimator, (String)string2, (int[])nArray);
            nArray = null;
            valueAnimator.setInterpolator(null);
            valueAnimator = this.f;
            long l10 = this.g;
            valueAnimator.setDuration(l10);
            this.f.setRepeatMode(1);
            valueAnimator = this.f;
            int n10 = -1;
            valueAnimator.setRepeatCount(n10);
        }
        if (bl2 = (valueAnimator = this.f).isPaused()) {
            valueAnimator = this.f;
            valueAnimator.resume();
        } else {
            valueAnimator = this.f;
            valueAnimator.start();
        }
    }

    public int h() {
        return 2131558485;
    }

    public void i(ViewDataBinding object) {
        super.i((ViewDataBinding)object);
        object = (l2)object;
        this.b = object;
        this.d = object = new CECompositeFinishFragment$b(this);
        this.b.A((CECompositeFinishFragment$b)object);
    }

    public void onDestroy() {
        this.b.i.F(true);
        this.f.cancel();
        i0.e().g();
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        this.w();
        this.d.h();
    }

    public void onStart() {
        super.onStart();
        int n10 = this.e;
        int n11 = 690;
        if (n10 == n11) {
            this.v();
        }
    }

    public void onViewCreated(View object, Bundle object2) {
        super.onViewCreated((View)object, (Bundle)object2);
        object = (u)d.v.i0.b.a(this).get(u.class);
        this.c = object;
        object = ((u)object).b;
        object2 = this.getViewLifecycleOwner();
        Uri[] uriArray = new f(this);
        ((LiveData)object).observe((LifecycleOwner)object2, (Observer)uriArray);
        object = this.getArguments();
        if (object != null) {
            object2 = this.b;
            uriArray = object.getString("ARGUMENTS_COVERIMAGEURL");
            ((l2)object2).B((String)uriArray);
            object2 = object.getString("ARGUMENTS_DURATION");
            if (object2 != null) {
                long l10;
                this.g = l10 = Long.parseLong((String)object2);
            }
            this.h = object = object.getString("ARGUMENTS_FILEURL");
            object = this.b.i;
            object2 = null;
            ((ExoVideoView)object).L(false);
            this.b.i.setMediaControllerDefault(false);
            object = this.b.i;
            int n10 = 1;
            ((ExoVideoView)object).setLoopPlay(n10 != 0);
            object = this.b.i;
            d d10 = new d(this);
            ((ExoVideoView)object).setOnPlayWhenReadyListener(d10);
            object = this.b.i;
            uriArray = new Uri[n10];
            d10 = Uri.parse((String)this.h);
            uriArray[0] = d10;
            ((ExoVideoView)object).setVideoURI(uriArray);
        }
        this.q();
    }

    public /* synthetic */ void u(DialogFragment dialogFragment) {
        this.t(dialogFragment);
    }
}

