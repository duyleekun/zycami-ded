/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.c.j1.a;

import android.view.View;
import com.zhiyun.cama.data.database.model.Feedback;
import com.zhiyun.cama.me.help.FeedbackDetailFragment$b;
import d.v.g0.i$c;

public final class i
implements i$c {
    public final /* synthetic */ FeedbackDetailFragment$b a;
    public final /* synthetic */ Feedback b;
    public final /* synthetic */ View c;

    public /* synthetic */ i(FeedbackDetailFragment$b feedbackDetailFragment$b, Feedback feedback, View view) {
        this.a = feedbackDetailFragment$b;
        this.b = feedback;
        this.c = view;
    }

    public final void a(int n10) {
        FeedbackDetailFragment$b feedbackDetailFragment$b = this.a;
        Feedback feedback = this.b;
        View view = this.c;
        feedbackDetailFragment$b.j(feedback, view, n10);
    }
}

