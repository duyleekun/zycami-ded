/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.v.a;

import androidx.lifecycle.LiveData;
import com.zhiyun.cama.data.api.entity.music.AlbumListBean;
import d.v.c.v0.v.a.a;
import d.v.c.v0.v.c.s;
import d.v.e.l.c1;
import d.v.j.e.h.j;
import java.util.List;
import k.d;

public class a$a
extends j {
    public final /* synthetic */ boolean d;
    public final /* synthetic */ a e;

    public a$a(a a10, c1 c12, boolean bl2) {
        this.e = a10;
        this.d = bl2;
        super(c12);
    }

    public d e() {
        return d.v.c.v0.v.a.a.s(this.e).b();
    }

    public LiveData n() {
        return d.v.c.v0.v.a.a.r(this.e).m();
    }

    public void t(AlbumListBean object) {
        d.v.c.v0.v.a.a.r(this.e).f();
        s s10 = d.v.c.v0.v.a.a.r(this.e);
        object = d.v.c.v0.v.a.a.r(this.e).m0((AlbumListBean)object, false);
        s10.y((List)object);
    }

    public boolean u(List list) {
        return this.d;
    }
}

