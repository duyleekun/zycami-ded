/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.view.View
 */
package com.zhiyun.cama.main.me;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.data.database.model.PublishWorks;
import com.zhiyun.cama.main.me.MeFragment;
import com.zhiyun.cama.main.me.MeFragment$a;
import com.zhiyun.cama.publish.PublishActivity;
import com.zhiyun.cama.publish.PublishWorksService;
import d.v.a.f.c.b;
import d.v.c.m1.c;
import d.v.c.x1.l;

public class MeFragment$b {
    public final /* synthetic */ MeFragment a;

    private MeFragment$b(MeFragment meFragment) {
        this.a = meFragment;
    }

    public /* synthetic */ MeFragment$b(MeFragment meFragment, MeFragment$a meFragment$a) {
        this(meFragment);
    }

    public void a(View object) {
        object = MeFragment.n(this.a).j();
        Boolean bl2 = Boolean.FALSE;
        ((MutableLiveData)object).setValue(bl2);
    }

    public void b(View object) {
        object = this.a;
        boolean bl2 = MeFragment.j((MeFragment)object);
        if (!bl2 && (object = this.a.getActivity()) != null) {
            object = this.a.getActivity();
            ActivityCompat.finishAfterTransition((Activity)object);
        }
    }

    public void c(View view) {
        l.a(view, 2131362317);
    }

    public void d(View view) {
        l.a(view, 2131362892);
    }

    public void e(View view) {
        Object object = this.a;
        int n10 = MeFragment.j((MeFragment)object);
        if (n10 != 0) {
            object = b.N().i().getToken();
            c c10 = MeFragment.n(this.a);
            c10.w((String)object);
            n10 = 2131363005;
            l.a(view, n10);
        }
    }

    public void f(View object) {
        object = this.a.getActivity();
        if (object != null) {
            object = this.a.getActivity();
            PublishActivity.i((Activity)object);
        }
    }

    public void g(View view) {
        l.a(view, 2131363192);
    }

    public void h(View view) {
        MeFragment.k(this.a).k();
        MeFragment.k(this.a).j();
        MeFragment.l(this.a);
    }

    public void i(View view) {
        view = this.a.getContext();
        PublishWorks publishWorks = MeFragment.m(this.a);
        PublishWorksService.a((Context)view, publishWorks);
    }
}

