/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.y.d;

import androidx.lifecycle.LiveData;
import com.zhiyun.cama.data.api.entity.sticker.StickerTypeListBean;
import d.v.c.v0.y.b.e;
import d.v.c.v0.y.d.b;
import d.v.e.l.c1;
import d.v.j.e.h.j;
import java.util.List;
import k.d;

public class b$a
extends j {
    public final /* synthetic */ b d;

    public b$a(b b10, c1 c12) {
        this.d = b10;
        super(c12);
    }

    public d e() {
        return b.s(this.d).e();
    }

    public LiveData n() {
        return b.r(this.d).i();
    }

    public void t(StickerTypeListBean object) {
        b.r(this.d).b();
        e e10 = b.r(this.d);
        object = b.r(this.d).A((StickerTypeListBean)object);
        e10.s((List)object);
    }

    public boolean u(List list) {
        return true;
    }
}

