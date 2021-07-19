/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.j1.a;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.me.help.FeedbackEditFragment;

public final class y
implements Observer {
    public final /* synthetic */ FeedbackEditFragment a;

    public /* synthetic */ y(FeedbackEditFragment feedbackEditFragment) {
        this.a = feedbackEditFragment;
    }

    public final void onChanged(Object object) {
        FeedbackEditFragment feedbackEditFragment = this.a;
        object = (String)object;
        feedbackEditFragment.v((String)object);
    }
}

