/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.j1.a;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.me.help.FeedbackDetailFragment;

public final class k
implements Observer {
    public final /* synthetic */ FeedbackDetailFragment a;

    public /* synthetic */ k(FeedbackDetailFragment feedbackDetailFragment) {
        this.a = feedbackDetailFragment;
    }

    public final void onChanged(Object object) {
        FeedbackDetailFragment feedbackDetailFragment = this.a;
        object = (Boolean)object;
        feedbackDetailFragment.t((Boolean)object);
    }
}

