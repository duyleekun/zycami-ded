/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.c.y1.h;

import android.view.View;
import com.zhiyun.zyplayer.ExoVideoView;
import d.v.c.b1.t.g;
import d.v.c.y1.h.i;
import d.v.c.y1.h.j;

public final class i$a {
    public final /* synthetic */ i a;

    public i$a(i i10) {
        this.a = i10;
    }

    public void a(View view) {
        i.A(this.a).b();
    }

    public void b(View object) {
        Object object2 = i.w(this.a);
        if (object2 == null) {
            return;
        }
        object2 = i.x(this.a);
        boolean bl2 = ((ExoVideoView)object2).isPlaying();
        if (bl2) {
            object2 = this.a;
            i.y((i)object2);
        }
        object2 = i.A(this.a);
        g g10 = i.z(this.a);
        String string2 = i.w(this.a);
        object = d.v.f.i.g.q(object, 2131952013);
        ((j)object2).c(g10, string2, (String)object);
    }

    public void c(View view) {
        this.a.dismissAllowingStateLoss();
    }

    public void d() {
        Object object = i.x(this.a);
        boolean bl2 = ((ExoVideoView)object).isPlaying();
        if (bl2) {
            object = this.a;
            i.y((i)object);
        } else {
            object = this.a;
            i.B((i)object);
        }
    }
}

