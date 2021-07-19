/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.j1.a;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.me.help.FeedbackEditAddFragment;

public final class n
implements Observer {
    public final /* synthetic */ FeedbackEditAddFragment a;

    public /* synthetic */ n(FeedbackEditAddFragment feedbackEditAddFragment) {
        this.a = feedbackEditAddFragment;
    }

    public final void onChanged(Object object) {
        FeedbackEditAddFragment feedbackEditAddFragment = this.a;
        object = (Boolean)object;
        feedbackEditAddFragment.p((Boolean)object);
    }
}

