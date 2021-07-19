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

public final class l1
implements View.OnClickListener {
    public final /* synthetic */ PublishFragment a;
    public final /* synthetic */ FrameLayout b;
    public final /* synthetic */ int c;

    public /* synthetic */ l1(PublishFragment publishFragment, FrameLayout frameLayout, int n10) {
        this.a = publishFragment;
        this.b = frameLayout;
        this.c = n10;
    }

    public final void onClick(View view) {
        PublishFragment publishFragment = this.a;
        FrameLayout frameLayout = this.b;
        int n10 = this.c;
        publishFragment.a0(frameLayout, n10, view);
    }
}

