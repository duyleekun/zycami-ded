/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.s.a;

import androidx.lifecycle.LiveData;
import com.zhiyun.cama.data.api.entity.font.CaptionStyleListBean;
import d.v.c.v0.s.a.a;
import d.v.c.v0.s.c.e;
import d.v.e.l.c1;
import d.v.j.e.h.j;
import java.util.List;
import k.d;

public class a$a
extends j {
    public final /* synthetic */ boolean d;
    public final /* synthetic */ int e;
    public final /* synthetic */ int f;
    public final /* synthetic */ a g;

    public a$a(a a10, c1 c12, boolean bl2, int n10, int n11) {
        this.g = a10;
        this.d = bl2;
        this.e = n10;
        this.f = n11;
        super(c12);
    }

    public d e() {
        d.v.c.v0.s.d.a a10 = d.v.c.v0.s.a.a.s(this.g);
        int n10 = this.e;
        int n11 = this.f;
        return a10.b(n10, n11);
    }

    public LiveData n() {
        return d.v.c.v0.s.a.a.r(this.g).e();
    }

    public void t(CaptionStyleListBean object) {
        d.v.c.v0.s.a.a.r(this.g).c();
        e e10 = d.v.c.v0.s.a.a.r(this.g);
        object = d.v.c.v0.s.a.a.r(this.g).A((CaptionStyleListBean)object);
        e10.r((List)object);
    }

    public boolean u(List list) {
        return this.d;
    }
}

