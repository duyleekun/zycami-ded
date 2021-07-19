/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.j1.a;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.data.database.model.Feedback;
import com.zhiyun.cama.me.help.FeedbackDetailFragment;

public final class l
implements Observer {
    public final /* synthetic */ FeedbackDetailFragment a;

    public /* synthetic */ l(FeedbackDetailFragment feedbackDetailFragment) {
        this.a = feedbackDetailFragment;
    }

    public final void onChanged(Object object) {
        FeedbackDetailFragment feedbackDetailFragment = this.a;
        object = (Feedback)object;
        feedbackDetailFragment.r((Feedback)object);
    }
}

