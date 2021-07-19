/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 */
package com.zhiyun.cama.me.help;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.me.help.FeedbackFragment$a;
import d.v.c.j1.a.o0;
import d.v.c.w0.we;
import d.v.f.h.a;
import d.v.i0.b;

public class FeedbackFragment
extends a {
    private we b;
    private o0 c;

    public static /* synthetic */ o0 j(FeedbackFragment feedbackFragment) {
        return feedbackFragment.c;
    }

    public int h() {
        return 2131558700;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (we)viewDataBinding;
        this.b = viewDataBinding;
        FeedbackFragment$a feedbackFragment$a = new FeedbackFragment$a(this);
        ((we)viewDataBinding).A(feedbackFragment$a);
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (o0)d.v.i0.b.c(this.requireActivity()).get(o0.class);
        this.c = object;
    }

    public void onViewCreated(View object, Bundle object2) {
        super.onViewCreated((View)object, (Bundle)object2);
        this.c.n();
        object = this.b;
        object2 = this.c;
        ((we)object).B((o0)object2);
    }
}

