/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.j1.a;

import com.zhiyun.cama.data.database.model.Feedback;
import com.zhiyun.cama.me.help.FeedbackDetailFragment$b;
import d.v.g0.i$c;

public final class d
implements i$c {
    public final /* synthetic */ FeedbackDetailFragment$b a;
    public final /* synthetic */ Feedback b;

    public /* synthetic */ d(FeedbackDetailFragment$b feedbackDetailFragment$b, Feedback feedback) {
        this.a = feedbackDetailFragment$b;
        this.b = feedback;
    }

    public final void a(int n10) {
        FeedbackDetailFragment$b feedbackDetailFragment$b = this.a;
        Feedback feedback = this.b;
        feedbackDetailFragment$b.m(feedback, n10);
    }
}

