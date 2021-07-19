/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.j1.a;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.me.help.FeedbackEditAddFragment;

public final class q
implements Observer {
    public final /* synthetic */ FeedbackEditAddFragment a;

    public /* synthetic */ q(FeedbackEditAddFragment feedbackEditAddFragment) {
        this.a = feedbackEditAddFragment;
    }

    public final void onChanged(Object object) {
        FeedbackEditAddFragment feedbackEditAddFragment = this.a;
        object = (Boolean)object;
        feedbackEditAddFragment.t((Boolean)object);
    }
}

