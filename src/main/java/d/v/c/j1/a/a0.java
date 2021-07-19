/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.j1.a;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.data.database.model.Feedback;
import com.zhiyun.cama.me.help.FeedbackEditFragment;

public final class a0
implements Observer {
    public final /* synthetic */ FeedbackEditFragment a;

    public /* synthetic */ a0(FeedbackEditFragment feedbackEditFragment) {
        this.a = feedbackEditFragment;
    }

    public final void onChanged(Object object) {
        FeedbackEditFragment feedbackEditFragment = this.a;
        object = (Feedback)object;
        feedbackEditFragment.r((Feedback)object);
    }
}

