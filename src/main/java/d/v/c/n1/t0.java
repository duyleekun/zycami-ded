/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.FrameLayout
 */
package d.v.c.n1;

import android.widget.FrameLayout;
import com.zhiyun.cama.publish.PublishFragment;
import d.v.c.n1.i2$c;

public final class t0
implements i2$c {
    public final /* synthetic */ PublishFragment a;
    public final /* synthetic */ FrameLayout b;
    public final /* synthetic */ int c;

    public /* synthetic */ t0(PublishFragment publishFragment, FrameLayout frameLayout, int n10) {
        this.a = publishFragment;
        this.b = frameLayout;
        this.c = n10;
    }

    public final void a(String string2) {
        PublishFragment publishFragment = this.a;
        FrameLayout frameLayout = this.b;
        int n10 = this.c;
        publishFragment.z0(frameLayout, n10, string2);
    }
}

