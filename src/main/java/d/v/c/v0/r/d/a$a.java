/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.r.d;

import androidx.lifecycle.LiveData;
import com.zhiyun.cama.data.api.entity.filter.FilterTypeListBean;
import d.v.c.v0.r.b.g;
import d.v.c.v0.r.d.a;
import d.v.e.l.c1;
import d.v.j.e.h.j;
import java.util.List;
import k.d;

public class a$a
extends j {
    public final /* synthetic */ a d;

    public a$a(a a10, c1 c12) {
        this.d = a10;
        super(c12);
    }

    public d e() {
        return d.v.c.v0.r.d.a.s(this.d).d();
    }

    public LiveData n() {
        return d.v.c.v0.r.d.a.r(this.d).g();
    }

    public void t(FilterTypeListBean object) {
        d.v.c.v0.r.d.a.r(this.d).d();
        g g10 = d.v.c.v0.r.d.a.r(this.d);
        object = d.v.c.v0.r.d.a.r(this.d).G((FilterTypeListBean)object);
        g10.q((List)object);
    }

    public boolean u(List list) {
        return true;
    }
}

