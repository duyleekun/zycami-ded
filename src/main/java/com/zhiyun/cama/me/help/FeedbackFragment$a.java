/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.zhiyun.cama.me.help;

import android.view.View;
import com.zhiyun.cama.me.help.FeedbackFragment;
import com.zhiyun.cama.me.help.data.FeedbackSet$Type;
import d.v.c.x1.l;

public class FeedbackFragment$a {
    public final /* synthetic */ FeedbackFragment a;

    public FeedbackFragment$a(FeedbackFragment feedbackFragment) {
        this.a = feedbackFragment;
    }

    public void a(View view) {
        l.g(view);
    }

    public void b(View view, FeedbackSet$Type feedbackSet$Type) {
        FeedbackFragment.j((FeedbackFragment)this.a).p.setValue((Object)feedbackSet$Type);
        l.a(view, 2131362443);
    }

    public void c(View view) {
        l.a(view, 2131362445);
    }
}

