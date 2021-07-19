/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.c.s0.h7.u0;

import android.view.View;
import com.zhiyun.cama.camera.story.track.TrackDescriptionBean;
import d.v.c.s0.h7.u0.j;
import d.v.c.w0.yh;
import d.v.f.f.b;

public final class d
implements b {
    public final /* synthetic */ j a;
    public final /* synthetic */ yh b;

    public /* synthetic */ d(j j10, yh yh2) {
        this.a = j10;
        this.b = yh2;
    }

    public final void a(View view, int n10, Object object) {
        j j10 = this.a;
        yh yh2 = this.b;
        object = (TrackDescriptionBean)object;
        j10.j(yh2, view, n10, (TrackDescriptionBean)object);
    }
}

