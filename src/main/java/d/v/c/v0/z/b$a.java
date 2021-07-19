/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.z;

import androidx.lifecycle.LiveData;
import com.zhiyun.cama.data.api.entity.transition.TransitionListBean;
import d.v.c.v0.z.c.b;
import d.v.c.v0.z.d.a;
import d.v.e.l.c1;
import d.v.j.e.h.j;
import java.util.List;
import k.d;

public class b$a
extends j {
    public final /* synthetic */ boolean d;
    public final /* synthetic */ int e;
    public final /* synthetic */ int f;
    public final /* synthetic */ d.v.c.v0.z.b g;

    public b$a(d.v.c.v0.z.b b10, c1 c12, boolean bl2, int n10, int n11) {
        this.g = b10;
        this.d = bl2;
        this.e = n10;
        this.f = n11;
        super(c12);
    }

    public d e() {
        a a10 = d.v.c.v0.z.b.s(this.g);
        int n10 = this.e;
        int n11 = this.f;
        return a10.b(n10, n11);
    }

    public LiveData n() {
        return d.v.c.v0.z.b.r(this.g).c();
    }

    public void t(TransitionListBean object) {
        d.v.c.v0.z.b.r(this.g).a();
        b b10 = d.v.c.v0.z.b.r(this.g);
        object = d.v.c.v0.z.b.r(this.g).m((TransitionListBean)object);
        b10.i((List)object);
    }

    public boolean u(List list) {
        return this.d;
    }
}

