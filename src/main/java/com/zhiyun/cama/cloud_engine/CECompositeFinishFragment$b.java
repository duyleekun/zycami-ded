/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 */
package com.zhiyun.cama.cloud_engine;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.zhiyun.cama.cloud_engine.CECompositeFinishFragment;
import com.zhiyun.cama.publish.PublishActivity;
import com.zhiyun.zyplayer.ExoVideoView;
import d.v.c.t0.a;
import d.v.c.t0.b;
import d.v.c.t0.c;
import d.v.c.v0.u.z;
import d.v.c.x1.l;
import d.v.g0.k$b;

public class CECompositeFinishFragment$b {
    private int a;
    public final /* synthetic */ CECompositeFinishFragment b;

    public CECompositeFinishFragment$b(CECompositeFinishFragment cECompositeFinishFragment) {
        this.b = cECompositeFinishFragment;
    }

    private /* synthetic */ void c(DialogFragment dialogFragment) {
        dialogFragment.dismiss();
        CECompositeFinishFragment.n(this.b);
    }

    private /* synthetic */ void e(DialogFragment dialogFragment) {
        dialogFragment.dismiss();
        CECompositeFinishFragment.l(this.b);
    }

    public void a() {
        Object object = this.b.getContext();
        k$b k$b = new k$b((Context)object);
        k$b = (k$b)k$b.m(2131951835);
        object = d.v.c.t0.a.a;
        k$b = (k$b)k$b.o(2131951833, (d.v.f.f.a)object);
        object = new c(this);
        k$b = (k$b)k$b.v(2131952621, (d.v.f.f.a)object);
        object = this.b.getChildFragmentManager();
        k$b.D((FragmentManager)object);
    }

    public void b() {
        Object object = z.m();
        boolean bl2 = ((z)object).q();
        Object object2 = this.b.getArguments();
        if (object2 != null) {
            String string2 = "ARGUMENTS_FILEURL";
            object2 = object2.getString(string2);
            if (bl2) {
                object = new Bundle();
                object.putString(string2, (String)object2);
                object2 = this.b;
                int n10 = 2131361800;
                l.e((Fragment)object2, n10, (Bundle)object);
            } else {
                object = this.b;
                PublishActivity.k((Fragment)object, (String)object2);
            }
        }
    }

    public /* synthetic */ void d(DialogFragment dialogFragment) {
        this.c(dialogFragment);
    }

    public /* synthetic */ void f(DialogFragment dialogFragment) {
        this.e(dialogFragment);
    }

    public void g() {
        Object object = this.b.getContext();
        k$b k$b = new k$b((Context)object);
        k$b = (k$b)k$b.m(2131952764);
        object = d.v.c.t0.a.a;
        k$b = (k$b)k$b.o(2131951833, (d.v.f.f.a)object);
        object = new b(this);
        k$b = (k$b)k$b.v(2131952621, (d.v.f.f.a)object);
        object = this.b.getChildFragmentManager();
        k$b.D((FragmentManager)object);
    }

    public void h() {
        int n10;
        CECompositeFinishFragment.k((CECompositeFinishFragment)this.b).i.E();
        CECompositeFinishFragment.k((CECompositeFinishFragment)this.b).d.setVisibility(0);
        this.a = n10 = CECompositeFinishFragment.k((CECompositeFinishFragment)this.b).i.getCurrentPosition();
    }

    public void i() {
        ExoVideoView exoVideoView = CECompositeFinishFragment.k((CECompositeFinishFragment)this.b).i;
        int n10 = this.a;
        exoVideoView.c(n10);
        CECompositeFinishFragment.k((CECompositeFinishFragment)this.b).i.start();
        CECompositeFinishFragment.k((CECompositeFinishFragment)this.b).d.setVisibility(8);
    }

    public void j() {
        CECompositeFinishFragment.l(this.b);
        CECompositeFinishFragment.m(this.b, 327);
    }
}

