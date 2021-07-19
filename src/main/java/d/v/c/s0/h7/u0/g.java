/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.s0.h7.u0;

import android.view.View;
import com.zhiyun.cama.camera.story.track.TrackDescriptionBean;
import d.v.c.s0.h7.u0.k;

public final class g
implements View.OnClickListener {
    public final /* synthetic */ k a;
    public final /* synthetic */ int b;
    public final /* synthetic */ TrackDescriptionBean c;

    public /* synthetic */ g(k k10, int n10, TrackDescriptionBean trackDescriptionBean) {
        this.a = k10;
        this.b = n10;
        this.c = trackDescriptionBean;
    }

    public final void onClick(View view) {
        k k10 = this.a;
        int n10 = this.b;
        TrackDescriptionBean trackDescriptionBean = this.c;
        k10.h(n10, trackDescriptionBean, view);
    }
}

