/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7;

import com.zhiyun.zyplayer.ExoVideoView;
import d.v.c.s0.h7.i0;
import d.v.e.l.m2$a;
import d.v.e.l.m2$d;
import d.v.j0.d;

public class i0$a
implements m2$a {
    public final /* synthetic */ d a;
    public final /* synthetic */ int b;
    public final /* synthetic */ ExoVideoView c;
    public final /* synthetic */ i0 d;

    public i0$a(i0 i02, d d10, int n10, ExoVideoView exoVideoView) {
        this.d = i02;
        this.a = d10;
        this.b = n10;
        this.c = exoVideoView;
    }

    public void a(Long object) {
        int n10;
        int[] nArray;
        int n11;
        object = this.a;
        int n12 = object.getCurrentPosition();
        if (n12 >= (n11 = (nArray = i0.a(this.d))[n10 = 1] + -200) || n12 >= (n11 = this.b + -200)) {
            object = this.c;
            nArray = i0.a(this.d);
            n10 = 0;
            n11 = nArray[0];
            ((ExoVideoView)object).c(n11);
            object = i0.b(this.d);
            ((m2$d)object).a();
        }
    }

    public void onComplete() {
    }
}

