/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.j1.a;

import android.view.View;
import com.zhiyun.cama.me.help.FeedbackDetailFragment;

public final class b
implements View.OnClickListener {
    public final /* synthetic */ FeedbackDetailFragment a;

    public /* synthetic */ b(FeedbackDetailFragment feedbackDetailFragment) {
        this.a = feedbackDetailFragment;
    }

    public final void onClick(View view) {
        this.a.l(view);
    }
}

