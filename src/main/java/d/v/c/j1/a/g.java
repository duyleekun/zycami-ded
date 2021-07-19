/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.j1.a;

import androidx.fragment.app.DialogFragment;
import com.zhiyun.cama.data.database.model.Feedback;
import com.zhiyun.cama.me.help.FeedbackDetailFragment$b;
import d.v.f.f.a;

public final class g
implements a {
    public final /* synthetic */ FeedbackDetailFragment$b a;
    public final /* synthetic */ Feedback b;

    public /* synthetic */ g(FeedbackDetailFragment$b feedbackDetailFragment$b, Feedback feedback) {
        this.a = feedbackDetailFragment$b;
        this.b = feedback;
    }

    public final void a(DialogFragment dialogFragment) {
        FeedbackDetailFragment$b feedbackDetailFragment$b = this.a;
        Feedback feedback = this.b;
        feedbackDetailFragment$b.g(feedback, dialogFragment);
    }
}

