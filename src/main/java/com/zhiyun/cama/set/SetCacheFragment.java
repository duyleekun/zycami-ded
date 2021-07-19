/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.view.View
 */
package com.zhiyun.cama.set;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.core.util.Pair;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import com.zhiyun.cama.set.SetCacheFragment$a;
import d.v.c.q1.g0;
import d.v.c.q1.k;
import d.v.c.w0.mg;
import d.v.e.l.n2;
import d.v.f.f.a;
import d.v.f.i.g;
import d.v.g0.k$a;
import d.v.g0.k$b;
import d.v.i0.b;

public class SetCacheFragment
extends d.v.f.h.a {
    private mg b;
    private g0 c;

    public static /* synthetic */ g0 j(SetCacheFragment setCacheFragment) {
        return setCacheFragment.c;
    }

    public static /* synthetic */ void k(SetCacheFragment setCacheFragment, LiveData liveData, a a10) {
        setCacheFragment.m(liveData, a10);
    }

    public static /* synthetic */ void l(DialogFragment dialogFragment) {
    }

    private void m(LiveData object, a object2) {
        long l10;
        long l11;
        long l12;
        long l13;
        Object object3 = ((LiveData)object).getValue();
        if (object3 != null && (l13 = (l12 = (l11 = ((Long)(object = (Long)((Pair)object.getValue()).first)).longValue()) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
            object3 = this.getContext();
            object = new k$b((Context)object3);
            int n10 = 2131952865;
            object = (k$b)((k$a)object).A(n10);
            object3 = k.a;
            object = (k$b)((k$b)((k$a)object).p((a)object3)).w((a)object2);
            object2 = this.getChildFragmentManager();
            ((k$a)object).D((FragmentManager)object2);
        } else {
            object = this.getResources();
            int n11 = 2131952880;
            object = g.o((Resources)object, n11);
            n2.e((String)object);
        }
    }

    public int h() {
        return 2131558754;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (mg)viewDataBinding;
        this.b = viewDataBinding;
        SetCacheFragment$a setCacheFragment$a = new SetCacheFragment$a(this);
        ((mg)viewDataBinding).A(setCacheFragment$a);
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (g0)d.v.i0.b.c(this.requireActivity()).get(g0.class);
        this.c = object;
    }

    public void onViewCreated(View object, Bundle object2) {
        super.onViewCreated((View)object, (Bundle)object2);
        object = this.b;
        object2 = this.c;
        ((mg)object).B((g0)object2);
        this.c.H();
    }
}

