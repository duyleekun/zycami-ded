/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.FrameLayout
 */
package d.v.c.n1;

import android.view.View;
import android.widget.FrameLayout;
import com.zhiyun.cama.publish.PublishFragment;

public final class u0
implements View.OnClickListener {
    public final /* synthetic */ PublishFragment a;
    public final /* synthetic */ int b;
    public final /* synthetic */ FrameLayout c;

    public /* synthetic */ u0(PublishFragment publishFragment, int n10, FrameLayout frameLayout) {
        this.a = publishFragment;
        this.b = n10;
        this.c = frameLayout;
    }

    public final void onClick(View view) {
        PublishFragment publishFragment = this.a;
        int n10 = this.b;
        FrameLayout frameLayout = this.c;
        publishFragment.c0(n10, frameLayout, view);
    }
}

