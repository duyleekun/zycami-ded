/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 */
package com.zhiyun.cama.me.help;

import android.content.Context;
import android.view.View;
import com.zhiyun.cama.me.help.FeedbackEditAddFragment;
import d.v.c.j1.a.o0;
import d.v.c.x1.l;
import java.util.List;

public class FeedbackEditAddFragment$b {
    public final /* synthetic */ FeedbackEditAddFragment a;

    public FeedbackEditAddFragment$b(FeedbackEditAddFragment feedbackEditAddFragment) {
        this.a = feedbackEditAddFragment;
    }

    public void a(View object) {
        object = FeedbackEditAddFragment.l(this.a);
        Context context = this.a.requireContext();
        String string2 = FeedbackEditAddFragment.k((FeedbackEditAddFragment)this.a).a.getText().toString();
        List list = FeedbackEditAddFragment.k((FeedbackEditAddFragment)this.a).d.getImages();
        ((o0)object).f(context, string2, list);
    }

    public void b(View view) {
        l.g(view);
    }
}

