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

public class b$a
extends j {
    public final /* synthetic */ int d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ int f;
    public final /* synthetic */ int g;
    public final /* synthetic */ b h;

    public b$a(b b10, c1 c12, int n10, boolean bl2, int n11, int n12) {
        this.h = b10;
        this.d = n10;
        this.e = bl2;
        this.f = n11;
        this.g = n12;
        super(c12);
    }

    public d e() {
        a a10 = b.s(this.h);
        int n10 = this.f;
        int n11 = this.g;
        int n12 = this.d;
        return a10.c(n10, n11, n12);
    }

    public LiveData n() {
        e e10 = b.r(this.h);
        int n10 = this.d;
        return e10.g(n10);
    }

    public void t(StickerListBean object) {
        e e10 = b.r(this.h);
        int n10 = this.d;
        e10.e(n10);
        e10 = b.r(this.h);
        object = b.r(this.h).z((StickerListBean)object);
        e10.q((List)object);
    }

    public boolean u(List list) {
        return this.e;
    }
}

