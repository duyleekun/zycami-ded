/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.y.a;

import androidx.lifecycle.LiveData;
import com.zhiyun.cama.data.api.entity.sticker.StickerListBean;
import d.v.c.v0.y.a.b;
import d.v.c.v0.y.b.e;
import d.v.c.v0.y.c.a;
import d.v.e.l.c1;
import d.v.j.e.h.j;
import java.util.List;
import k.d;

public class b$b
extends j {
    public final /* synthetic */ boolean d;
    public final /* synthetic */ int e;
    public final /* synthetic */ int f;
    public final /* synthetic */ b g;

    public b$b(b b10, c1 c12, boolean bl2, int n10, int n11) {
        this.g = b10;
        this.d = bl2;
        this.e = n10;
        this.f = n11;
        super(c12);
    }

    public d e() {
        a a10 = b.s(this.g);
        int n10 = this.e;
        int n11 = this.f;
        return a10.b(n10, n11);
    }

    public LiveData n() {
        return b.r(this.g).f();
    }

    public void t(StickerListBean object) {
        b.r(this.g).a();
        e e10 = b.r(this.g);
        object = b.r(this.g).z((StickerListBean)object);
        e10.q((List)object);
    }

    public boolean u(List list) {
        return this.d;
    }
}

