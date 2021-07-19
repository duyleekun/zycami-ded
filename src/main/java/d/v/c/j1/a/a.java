/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.j1.a;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.me.help.FeedbackDetailAddFragment;
import java.util.List;

public final class a
implements Observer {
    public final /* synthetic */ FeedbackDetailAddFragment a;

    public /* synthetic */ a(FeedbackDetailAddFragment feedbackDetailAddFragment) {
        this.a = feedbackDetailAddFragment;
    }

    public final void onChanged(Object object) {
        FeedbackDetailAddFragment feedbackDetailAddFragment = this.a;
        object = (List)object;
        feedbackDetailAddFragment.k((List)object);
    }
}

