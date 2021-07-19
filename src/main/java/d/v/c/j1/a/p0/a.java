/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.c.j1.a.p0;

import android.view.View;
import com.zhiyun.cama.data.database.model.Feedback;
import com.zhiyun.cama.me.help.list.FeedbackListFragment;
import d.v.f.f.b;

public final class a
implements b {
    public final /* synthetic */ FeedbackListFragment a;

    public /* synthetic */ a(FeedbackListFragment feedbackListFragment) {
        this.a = feedbackListFragment;
    }

    public final void a(View view, int n10, Object object) {
        FeedbackListFragment feedbackListFragment = this.a;
        object = (Feedback)object;
        feedbackListFragment.N(view, n10, (Feedback)object);
    }
}

