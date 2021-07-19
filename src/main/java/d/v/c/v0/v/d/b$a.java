/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.v.d;

import androidx.lifecycle.LiveData;
import com.zhiyun.cama.data.api.entity.music.MusicListBean;
import d.v.c.v0.v.c.s;
import d.v.c.v0.v.d.b;
import d.v.c.v0.v.e.a;
import d.v.e.l.c1;
import d.v.j.e.h.j;
import java.util.List;
import java.util.Map;
import k.d;

public class b$a
extends j {
    public final /* synthetic */ boolean d;
    public final /* synthetic */ Map e;
    public final /* synthetic */ b f;

    public b$a(b b10, c1 c12, boolean bl2, Map map) {
        this.f = b10;
        this.d = bl2;
        this.e = map;
        super(c12);
    }

    public d e() {
        a a10 = b.s(this.f);
        Map map = this.e;
        return a10.c(map);
    }

    public LiveData n() {
        return b.r(this.f).o();
    }

    public void t(MusicListBean object) {
        b.r(this.f).k();
        s s10 = b.r(this.f);
        object = b.r(this.f).p0((MusicListBean)object);
        s10.B((List)object);
    }

    public boolean u(List list) {
        return this.d;
    }
}

