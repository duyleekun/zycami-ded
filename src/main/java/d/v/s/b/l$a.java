/*
 * Decompiled with CFR 0.151.
 */
package d.v.s.b;

import com.zhiyun.mediaprovider.data.MediaBean;
import d.v.s.b.i$a;
import d.v.s.b.l;
import e.a.g0;
import e.a.s0.b;

public class l$a
implements g0 {
    public final /* synthetic */ l a;

    public l$a(l l10) {
        this.a = l10;
    }

    public void a(MediaBean mediaBean) {
        i$a i$a = l.C(this.a);
        if (i$a != null) {
            i$a = l.C(this.a);
            i$a.a(mediaBean);
        }
    }

    public void onComplete() {
        i$a i$a = l.C(this.a);
        if (i$a != null) {
            i$a = l.C(this.a);
            i$a.b();
        }
        l.D(this.a);
    }

    public void onError(Throwable throwable) {
        this.a.s();
        i$a i$a = l.C(this.a);
        if (i$a != null) {
            i$a = l.C(this.a);
            Exception exception = new Exception(throwable);
            i$a.c(exception);
        }
        l.D(this.a);
    }

    public void onSubscribe(b b10) {
        l.B(this.a).b(b10);
    }
}

