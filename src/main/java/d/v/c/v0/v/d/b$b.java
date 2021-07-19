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

public class b$b
extends j {
    public final /* synthetic */ long d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ Map f;
    public final /* synthetic */ b g;

    public b$b(b b10, c1 c12, long l10, boolean bl2, Map map) {
        this.g = b10;
        this.d = l10;
        this.e = bl2;
        this.f = map;
        super(c12);
    }

    public d e() {
        a a10 = b.s(this.g);
        Map map = this.f;
        return a10.d(map);
    }

    public LiveData n() {
        s s10 = b.r(this.g);
        long l10 = this.d;
        return s10.l(l10);
    }

    public void t(MusicListBean object) {
        long l10;
        s s10;
        long l11 = this.d;
        long l12 = 0L;
        long l13 = l11 - l12;
        Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object2 < 0) {
            b b10 = this.g;
            b10.g(l11);
        } else {
            s10 = b.r(this.g);
            l10 = this.d;
            s10.g(l10);
        }
        s10 = b.r(this.g);
        s s11 = b.r(this.g);
        l10 = this.d;
        long l14 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
        l14 = l14 < 0 ? (long)1 : (long)0;
        object = s11.o0((boolean)l14, (MusicListBean)object);
        s10.B((List)object);
    }

    public boolean u(List list) {
        return this.e;
    }
}

