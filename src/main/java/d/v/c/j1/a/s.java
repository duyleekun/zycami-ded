/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.j1.a;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.me.help.FeedbackEditFragment;

public final class s
implements Observer {
    public final /* synthetic */ FeedbackEditFragment a;

    public /* synthetic */ s(FeedbackEditFragment feedbackEditFragment) {
        this.a = feedbackEditFragment;
    }

    public final void onChanged(Object object) {
        FeedbackEditFragment feedbackEditFragment = this.a;
        object = (Boolean)object;
        feedbackEditFragment.x((Boolean)object);
    }
}

